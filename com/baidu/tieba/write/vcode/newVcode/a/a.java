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
    private final NewWriteModel.d aBe = new b(this);
    private final NewWriteModel fMB;
    private final NewVcodeView fOJ;
    private PostWriteCallBackData fOK;
    private NewWriteModel.d fOL;

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.fOJ = newVcodeView;
        this.fMB = newWriteModel;
        this.fMB.b(this.aBe);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean onUrlLoad(WebView webView, String str) {
        if (this.fMB.getWriteData() == null || StringUtils.isNull(str)) {
            return false;
        }
        WriteData writeData = this.fMB.getWriteData();
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.fOJ.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            rd(com.baidu.tbadk.o.a.gs(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.fOJ.showToast(true, this.fOJ.getContext().getResources().getString(w.l.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.fOJ.showToast(true, this.fOJ.getContext().getResources().getString(w.l.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.fOJ.getContext().getResources().getString(w.l.send_success);
                if (this.fOK != null) {
                    str2 = this.fOK.getPreMsg();
                    str3 = this.fOK.getColorMsg();
                    string = this.fOK.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.e.c(this.fOJ.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fOK);
            intent.putExtras(bundle);
            BaseActivity context = this.fOJ.getContext();
            this.fOJ.getContext();
            context.setResult(-1, intent);
            this.fOJ.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fOJ.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fOJ != null) {
            this.fOJ.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void start(boolean z) {
        this.fOJ.setRatio(0.9433962f);
        this.fOJ.showWebView(false);
        this.fOJ.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(NewWriteModel.d dVar) {
        this.fOL = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPostThreadCancle() {
        this.fOJ.showPostThreadLoadingView(false);
        this.fMB.cancelLoadData();
    }

    private void rd(String str) {
        if (!k.hA()) {
            this.fOJ.getContext().showToast(w.l.neterror);
            this.fOJ.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fOJ.showPostThreadLoadingView(true);
            this.fMB.getWriteData().setVcode(str);
            this.fMB.getWriteData().setVcodeType("5");
            this.fMB.startPostWrite();
        } else {
            this.fOJ.getContext().showToast(w.l.neterror);
            this.fOJ.getContext().finish();
        }
    }
}
