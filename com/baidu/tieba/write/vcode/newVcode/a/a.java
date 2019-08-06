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
    private PostWriteCallBackData hQd;
    private final NewWriteModel jNJ;
    private final NewVcodeView jRx;
    private NewWriteModel.d jRy;
    private boolean jNK = false;
    private final NewWriteModel.d ctY = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jRx != null) {
                a.this.jRx.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hQd = postWriteCallBackData;
                    a.this.jNK = true;
                    if (xVar == null || xVar.amH() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = xVar.amH().endPoint;
                        str = xVar.amH().successImg;
                        str3 = xVar.amH().slideEndPoint;
                    }
                    a.this.jRx.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jRy != null) {
                        a.this.jRy.callback(false, postWriteCallBackData, xVar, writeData, antiData);
                    }
                } else {
                    a.this.jRx.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.jRx.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jRx = newVcodeView;
        this.jNJ = newWriteModel;
        this.jNJ.b(this.ctY);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.jNJ.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.jNJ.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.jRx.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            GP(com.baidu.tbadk.v.a.rt(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jNK = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.jRx.showToast(true, this.jRx.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.jRx.showToast(true, this.jRx.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jRx.getContext().getResources().getString(R.string.send_success);
                if (this.hQd != null) {
                    str2 = this.hQd.getPreMsg();
                    str3 = this.hQd.getColorMsg();
                    string = this.hQd.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.jRx.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hQd);
            intent.putExtras(bundle);
            BaseActivity context = this.jRx.getContext();
            this.jRx.getContext();
            context.setResult(-1, intent);
            this.jRx.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jRx.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jRx != null) {
            this.jRx.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jRx.setRatio(0.9433962f);
        this.jRx.showWebView(false);
        this.jRx.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jRy = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.jRx.showPostThreadLoadingView(false);
        this.jNJ.cancelLoadData();
    }

    private void GP(String str) {
        this.jNK = false;
        if (!l.kt()) {
            this.jRx.getContext().showToast(R.string.neterror);
            this.jRx.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jRx.showPostThreadLoadingView(true);
            this.jNJ.getWriteData().setVcode(str);
            this.jNJ.getWriteData().setVcodeType("5");
            this.jNJ.startPostWrite();
        } else {
            this.jRx.getContext().showToast(R.string.neterror);
            this.jRx.getContext().finish();
        }
    }
}
