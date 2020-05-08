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
    private PostWriteCallBackData jvB;
    private final NewVcodeView lBH;
    private NewWriteModel.d lBI;
    private final NewWriteModel lxM;
    private boolean lxN = false;
    private final NewWriteModel.d dYM = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.lBH != null) {
                a.this.lBH.showPostThreadLoadingView(false);
                if (z) {
                    a.this.jvB = postWriteCallBackData;
                    a.this.lxN = true;
                    if (aaVar == null || aaVar.aSf() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = aaVar.aSf().endPoint;
                        str = aaVar.aSf().successImg;
                        str3 = aaVar.aSf().slideEndPoint;
                    }
                    a.this.lBH.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.lBI != null) {
                        a.this.lBI.callback(false, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else {
                    a.this.lBH.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.lBH.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.lBH = newVcodeView;
        this.lxM = newWriteModel;
        this.lxM.b(this.dYM);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cSK;
        if (this.lxM.cSK() == null || StringUtils.isNull(str) || (cSK = this.lxM.cSK()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cSK.getVcodeExtra() == null) {
                return false;
            }
            this.lBH.runJsMethod("handleFreshCaptcha", "'" + cSK.getVcodeUrl() + "','" + cSK.getVcodeExtra().slideImg + "','" + cSK.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            ME(com.baidu.tbadk.s.a.xq(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.lxN = true;
            if (cSK != null && cSK.getVideoReviewType() == 1) {
                this.lBH.showToast(true, this.lBH.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cSK != null && cSK.getVideoReviewType() == 2) {
                this.lBH.showToast(true, this.lBH.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.lBH.getContext().getResources().getString(R.string.send_success);
                if (this.jvB != null) {
                    str2 = this.jvB.getPreMsg();
                    str3 = this.jvB.getColorMsg();
                    string = this.jvB.getErrorString();
                }
                if (cSK.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.lBH.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.jvB);
            intent.putExtras(bundle);
            BaseActivity context = this.lBH.getContext();
            this.lBH.getContext();
            context.setResult(-1, intent);
            this.lBH.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.lBH.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.lBH != null) {
            this.lBH.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void B(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.lBH.setRatio(0.9433962f);
        this.lBH.showWebView(false);
        this.lBH.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.lBI = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dfi() {
        this.lBH.showPostThreadLoadingView(false);
        this.lxM.cancelLoadData();
    }

    private void ME(String str) {
        this.lxN = false;
        if (!l.isNetOk()) {
            this.lBH.getContext().showToast(R.string.neterror);
            this.lBH.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.lBH.showPostThreadLoadingView(true);
            this.lxM.cSK().setVcode(str);
            this.lxM.cSK().setVcodeType("5");
            this.lxM.cXy();
        } else {
            this.lBH.getContext().showToast(R.string.neterror);
            this.lBH.getContext().finish();
        }
    }
}
