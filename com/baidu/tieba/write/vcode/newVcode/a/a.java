package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public class a implements b {
    private PostWriteCallBackData jvx;
    private final NewVcodeView lBD;
    private NewWriteModel.d lBE;
    private final NewWriteModel lxI;
    private boolean lxJ = false;
    private final NewWriteModel.d dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.lBD != null) {
                a.this.lBD.showPostThreadLoadingView(false);
                if (z) {
                    a.this.jvx = postWriteCallBackData;
                    a.this.lxJ = true;
                    if (aaVar == null || aaVar.aSi() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = aaVar.aSi().endPoint;
                        str = aaVar.aSi().successImg;
                        str3 = aaVar.aSi().slideEndPoint;
                    }
                    a.this.lBD.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.lBE != null) {
                        a.this.lBE.callback(false, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else {
                    a.this.lBD.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.lBD.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.lBD = newVcodeView;
        this.lxI = newWriteModel;
        this.lxI.b(this.dYH);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cSN;
        if (this.lxI.cSN() == null || StringUtils.isNull(str) || (cSN = this.lxI.cSN()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cSN.getVcodeExtra() == null) {
                return false;
            }
            this.lBD.runJsMethod("handleFreshCaptcha", "'" + cSN.getVcodeUrl() + "','" + cSN.getVcodeExtra().slideImg + "','" + cSN.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            MB(com.baidu.tbadk.s.a.xn(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.lxJ = true;
            if (cSN != null && cSN.getVideoReviewType() == 1) {
                this.lBD.showToast(true, this.lBD.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cSN != null && cSN.getVideoReviewType() == 2) {
                this.lBD.showToast(true, this.lBD.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.lBD.getContext().getResources().getString(R.string.send_success);
                if (this.jvx != null) {
                    str2 = this.jvx.getPreMsg();
                    str3 = this.jvx.getColorMsg();
                    string = this.jvx.getErrorString();
                }
                if (cSN.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.lBD.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.jvx);
            intent.putExtras(bundle);
            BaseActivity context = this.lBD.getContext();
            this.lBD.getContext();
            context.setResult(-1, intent);
            this.lBD.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.lBD.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.lBD != null) {
            this.lBD.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void B(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.lBD.setRatio(0.9433962f);
        this.lBD.showWebView(false);
        this.lBD.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.lBE = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dfl() {
        this.lBD.showPostThreadLoadingView(false);
        this.lxI.cancelLoadData();
    }

    private void MB(String str) {
        this.lxJ = false;
        if (!l.isNetOk()) {
            this.lBD.getContext().showToast(R.string.neterror);
            this.lBD.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.lBD.showPostThreadLoadingView(true);
            this.lxI.cSN().setVcode(str);
            this.lxI.cSN().setVcodeType("5");
            this.lxI.cXB();
        } else {
            this.lBD.getContext().showToast(R.string.neterror);
            this.lBD.getContext().finish();
        }
    }
}
