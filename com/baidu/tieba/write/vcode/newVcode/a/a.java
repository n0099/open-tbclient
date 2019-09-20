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
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes3.dex */
public class a implements b {
    private PostWriteCallBackData hSa;
    private final NewWriteModel jQe;
    private final NewVcodeView jTU;
    private NewWriteModel.d jTV;
    private boolean jQf = false;
    private final NewWriteModel.d cuV = new NewWriteModel.d() { // from class: com.baidu.tieba.write.vcode.newVcode.a.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
            String str;
            String str2;
            String str3 = null;
            if (a.this.jTU != null) {
                a.this.jTU.showPostThreadLoadingView(false);
                if (z) {
                    a.this.hSa = postWriteCallBackData;
                    a.this.jQf = true;
                    if (yVar == null || yVar.amT() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str2 = yVar.amT().endPoint;
                        str = yVar.amT().successImg;
                        str3 = yVar.amT().slideEndPoint;
                    }
                    a.this.jTU.runJsMethod("success", str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + str3);
                } else if (postWriteCallBackData == null || postWriteCallBackData.getErrorCode() != 227001) {
                    if (a.this.jTV != null) {
                        a.this.jTV.callback(false, postWriteCallBackData, yVar, writeData, antiData);
                    }
                } else {
                    a.this.jTU.getContext().setVisible(false);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(a.this.jTU.getContext().getActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                }
            }
        }
    };

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.jTU = newVcodeView;
        this.jQe = newWriteModel;
        this.jQe.b(this.cuV);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.jQe.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.jQe.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.jTU.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            Hp(com.baidu.tbadk.v.a.rE(str));
            return true;
        } else if (str.contains("objc:finish")) {
            this.jQf = true;
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.jTU.showToast(true, this.jTU.getContext().getResources().getString(R.string.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.jTU.showToast(true, this.jTU.getContext().getResources().getString(R.string.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.jTU.getContext().getResources().getString(R.string.send_success);
                if (this.hSa != null) {
                    str2 = this.hSa.getPreMsg();
                    str3 = this.hSa.getColorMsg();
                    string = this.hSa.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.c.f(this.jTU.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.hSa);
            intent.putExtras(bundle);
            BaseActivity context = this.jTU.getContext();
            this.jTU.getContext();
            context.setResult(-1, intent);
            this.jTU.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.jTU.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPageFinished(WebView webView, String str) {
        if (this.jTU != null) {
            this.jTU.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void start(boolean z) {
        this.jTU.setRatio(0.9433962f);
        this.jTU.showWebView(false);
        this.jTU.getWebView().loadUrl(TbConfig.SERVER_ADDRESS_WEB_VIEW + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void d(NewWriteModel.d dVar) {
        this.jTV = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.b
    public void onPostThreadCancle() {
        this.jTU.showPostThreadLoadingView(false);
        this.jQe.cancelLoadData();
    }

    private void Hp(String str) {
        this.jQf = false;
        if (!l.kt()) {
            this.jTU.getContext().showToast(R.string.neterror);
            this.jTU.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.jTU.showPostThreadLoadingView(true);
            this.jQe.getWriteData().setVcode(str);
            this.jQe.getWriteData().setVcodeType("5");
            this.jQe.startPostWrite();
        } else {
            this.jTU.getContext().showToast(R.string.neterror);
            this.jTU.getContext().finish();
        }
    }
}
