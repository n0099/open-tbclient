package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData hPi;
    private final NewWriteModel jMC;
    private final NewVcodeView jQr;
    private NewWriteModel.d jQs;
    private boolean jMD = false;
    private final NewWriteModel.d ctR = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jQr != null) {
                a.this.jQr.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hPi = postWriteCallBackData;
                    a.this.jMD = true;
                    if (xVar == null || xVar.amF() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = xVar.amF().endPoint;
                        str = xVar.amF().successImg;
                        str3 = xVar.amF().slideEndPoint;
                    }
                    a.this.jQr.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jQs != null) {
                        a.this.jQs.callback(false, postWriteCallBackData, xVar, writeData, antiData);
                    }
                } else {
                    a.this.jQr.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.jQr.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jQr = newVcodeView;
        this.jMC = newWriteModel;
        this.jMC.b(this.ctR);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.jMC.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.jMC.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.jQr.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            GO(com.baidu.tbadk.v.a.rt(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jMD = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.jQr.showToast(true, this.jQr.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.jQr.showToast(true, this.jQr.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jQr.getContext().getResources().getString(R.string.send_success);
                if (this.hPi != null) {
                    str2 = this.hPi.getPreMsg();
                    str3 = this.hPi.getColorMsg();
                    string = this.hPi.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.jQr.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hPi);
            intent.putExtras(bundle);
            BaseActivity context = this.jQr.getContext();
            this.jQr.getContext();
            context.setResult(-1, intent);
            this.jQr.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jQr.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jQr != null) {
            this.jQr.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jQr.setRatio(0.9433962f);
        this.jQr.showWebView(false);
        this.jQr.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jQs = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.jQr.showPostThreadLoadingView(false);
        this.jMC.cancelLoadData();
    }

    private void GO(String str) {
        this.jMD = false;
        if (!l.kt()) {
            this.jQr.getContext().showToast(R.string.neterror);
            this.jQr.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jQr.showPostThreadLoadingView(true);
            this.jMC.getWriteData().setVcode(str);
            this.jMC.getWriteData().setVcodeType("5");
            this.jMC.startPostWrite();
        } else {
            this.jQr.getContext().showToast(R.string.neterror);
            this.jQr.getContext().finish();
        }
    }
}
