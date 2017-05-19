package com.baidu.tieba.write.vcode.newVcode.a;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.w;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes.dex */
public class a implements c {
    private final NewWriteModel.d aBf = new b(this);
    private final NewWriteModel fLK;
    private final NewVcodeView fPd;
    private PostWriteCallBackData fPe;
    private NewWriteModel.d fPf;

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.fPd = newVcodeView;
        this.fLK = newWriteModel;
        this.fLK.b(this.aBf);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean onUrlLoad(WebView webView, String str) {
        if (this.fLK.getWriteData() == null || StringUtils.isNull(str)) {
            return false;
        }
        WriteData writeData = this.fLK.getWriteData();
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.fPd.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            qZ(com.baidu.tbadk.o.a.gq(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.fPd.showToast(true, this.fPd.getContext().getResources().getString(w.l.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.fPd.showToast(true, this.fPd.getContext().getResources().getString(w.l.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.fPd.getContext().getResources().getString(w.l.send_success);
                if (this.fPe != null) {
                    str2 = this.fPe.getPreMsg();
                    str3 = this.fPe.getColorMsg();
                    string = this.fPe.getErrorString();
                }
                if (writeData.getType() != 7 && (writeData.getType() != 0 || writeData.isUserFeedback())) {
                    com.baidu.tieba.tbadkCore.writeModel.e.c(this.fPd.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fPe);
            intent.putExtras(bundle);
            BaseActivity context = this.fPd.getContext();
            this.fPd.getContext();
            context.setResult(-1, intent);
            this.fPd.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fPd.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fPd != null) {
            this.fPd.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void start(boolean z) {
        this.fPd.setRatio(0.9433962f);
        this.fPd.showWebView(false);
        this.fPd.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(NewWriteModel.d dVar) {
        this.fPf = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPostThreadCancle() {
        this.fPd.showPostThreadLoadingView(false);
        this.fLK.cancelLoadData();
    }

    private void qZ(String str) {
        if (!k.hB()) {
            this.fPd.getContext().showToast(w.l.neterror);
            this.fPd.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fPd.showPostThreadLoadingView(true);
            this.fLK.getWriteData().setVcode(str);
            this.fLK.getWriteData().setVcodeType("5");
            this.fLK.startPostWrite();
        } else {
            this.fPd.getContext().showToast(w.l.neterror);
            this.fPd.getContext().finish();
        }
    }
}
