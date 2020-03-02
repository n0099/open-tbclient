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
/* loaded from: classes13.dex */
public class a implements b {
    private PostWriteCallBackData iJB;
    private final NewWriteModel kMw;
    private final NewVcodeView kPT;
    private NewWriteModel.d kPU;
    private boolean kMx = false;
    private final NewWriteModel.d dyA = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.kPT != null) {
                a.this.kPT.showPostThreadLoadingView(false);
                if (z) {
                    a.this.iJB = postWriteCallBackData;
                    a.this.kMx = true;
                    if (aaVar == null || aaVar.aJG() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = aaVar.aJG().endPoint;
                        str = aaVar.aJG().successImg;
                        str3 = aaVar.aJG().slideEndPoint;
                    }
                    a.this.kPT.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.kPU != null) {
                        a.this.kPU.callback(false, postWriteCallBackData, aaVar, writeData, antiData);
                    }
                } else {
                    a.this.kPT.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.kPT.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.kPT = newVcodeView;
        this.kMw = newWriteModel;
        this.kMw.b(this.dyA);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean c(WebView webView, String str) {
        WriteData cHU;
        if (this.kMw.cHU() == null || StringUtils.isNull(str) || (cHU = this.kMw.cHU()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cHU.getVcodeExtra() == null) {
                return false;
            }
            this.kPT.runJsMethod("handleFreshCaptcha", "'" + cHU.getVcodeUrl() + "','" + cHU.getVcodeExtra().slideImg + "','" + cHU.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            KU(com.baidu.tbadk.s.a.vZ(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.kMx = true;
            if (cHU != null && cHU.getVideoReviewType() == 1) {
                this.kPT.showToast(true, this.kPT.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cHU != null && cHU.getVideoReviewType() == 2) {
                this.kPT.showToast(true, this.kPT.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.kPT.getContext().getResources().getString(R.string.send_success);
                if (this.iJB != null) {
                    str2 = this.iJB.getPreMsg();
                    str3 = this.iJB.getColorMsg();
                    string = this.iJB.getErrorString();
                }
                if (cHU.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.kPT.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.iJB);
            intent.putExtras(bundle);
            BaseActivity context = this.kPT.getContext();
            this.kPT.getContext();
            context.setResult(-1, intent);
            this.kPT.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.kPT.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.kPT != null) {
            this.kPT.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void A(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.kPT.setRatio(0.9433962f);
        this.kPT.showWebView(false);
        this.kPT.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.kPU = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void cUu() {
        this.kPT.showPostThreadLoadingView(false);
        this.kMw.cancelLoadData();
    }

    private void KU(String str) {
        this.kMx = false;
        if (!l.isNetOk()) {
            this.kPT.getContext().showToast(R.string.neterror);
            this.kPT.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.kPT.showPostThreadLoadingView(true);
            this.kMw.cHU().setVcode(str);
            this.kMw.cHU().setVcodeType("5");
            this.kMw.cMj();
        } else {
            this.kPT.getContext().showToast(R.string.neterror);
            this.kPT.getContext().finish();
        }
    }
}
