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
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData kOk;
    private final NewWriteModel mXd;
    private final NewVcodeView nbe;
    private NewWriteModel.d nbf;
    private boolean mXe = false;
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.nbe != null) {
                a.this.nbe.showPostThreadLoadingView(false);
                if (z) {
                    a.this.kOk = postWriteCallBackData;
                    a.this.mXe = true;
                    if (ahVar == null || ahVar.bnT() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = ahVar.bnT().endPoint;
                        str = ahVar.bnT().successImg;
                        str3 = ahVar.bnT().slideEndPoint;
                    }
                    a.this.nbe.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.nbf != null) {
                        a.this.nbf.callback(false, postWriteCallBackData, ahVar, writeData, antiData);
                    }
                } else {
                    a.this.nbe.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AccountAccessActivityConfig(a.this.nbe.getContext().getActivity(), RequestResponseCode.REQUEST_VCODE, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.nbe = newVcodeView;
        this.mXd = newWriteModel;
        this.mXd.b(this.ePy);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean b(WebView webView, String str) {
        WriteData cOG;
        if (this.mXd.cOG() == null || StringUtils.isNull(str) || (cOG = this.mXd.cOG()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (cOG.getVcodeExtra() == null) {
                return false;
            }
            this.nbe.runJsMethod("handleFreshCaptcha", "'" + cOG.getVcodeUrl() + "','" + cOG.getVcodeExtra().slideImg + "','" + cOG.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Tj(com.baidu.tbadk.t.a.Dk(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.mXe = true;
            if (cOG != null && cOG.getVideoReviewType() == 1) {
                this.nbe.showToast(true, this.nbe.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (cOG != null && cOG.getVideoReviewType() == 2) {
                this.nbe.showToast(true, this.nbe.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.nbe.getContext().getResources().getString(R.string.send_success);
                if (this.kOk != null) {
                    str2 = this.kOk.getPreMsg();
                    str3 = this.kOk.getColorMsg();
                    string = this.kOk.getErrorString();
                }
                if (cOG.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.g(this.nbe.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.kOk);
            intent.putExtras(bundle);
            BaseActivity context = this.nbe.getContext();
            this.nbe.getContext();
            context.setResult(-1, intent);
            this.nbe.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.nbe.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.nbe != null) {
            this.nbe.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void E(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.nbe.setRatio(0.9433962f);
        this.nbe.showWebView(false);
        this.nbe.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + Config.DRAG_VCODE_WEBVIEW_ADDRESS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.nbf = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void dJR() {
        this.nbe.showPostThreadLoadingView(false);
        this.mXd.cancelLoadData();
    }

    private void Tj(String str) {
        this.mXe = false;
        if (!l.isNetOk()) {
            this.nbe.getContext().showToast(R.string.neterror);
            this.nbe.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.nbe.showPostThreadLoadingView(true);
            this.mXd.cOG().setVcode(str);
            this.mXd.cOG().setVcodeType("5");
            this.mXd.dBQ();
        } else {
            this.nbe.getContext().showToast(R.string.neterror);
            this.nbe.getContext().finish();
        }
    }
}
