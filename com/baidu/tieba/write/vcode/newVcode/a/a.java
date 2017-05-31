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
    private final NewWriteModel.d aAR = new b(this);
    private final NewWriteModel fTr;
    private final NewVcodeView fWZ;
    private PostWriteCallBackData fXa;
    private NewWriteModel.d fXb;

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.fWZ = newVcodeView;
        this.fTr = newWriteModel;
        this.fTr.b(this.aAR);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.fTr.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.fTr.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.fWZ.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            rn(com.baidu.tbadk.o.a.gp(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.fWZ.showToast(true, this.fWZ.getContext().getResources().getString(w.l.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.fWZ.showToast(true, this.fWZ.getContext().getResources().getString(w.l.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.fWZ.getContext().getResources().getString(w.l.send_success);
                if (this.fXa != null) {
                    str2 = this.fXa.getPreMsg();
                    str3 = this.fXa.getColorMsg();
                    string = this.fXa.getErrorString();
                }
                if (writeData.getType() != 7 && (writeData.getType() != 0 || writeData.isUserFeedback())) {
                    com.baidu.tieba.tbadkCore.writeModel.e.c(this.fWZ.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fXa);
            intent.putExtras(bundle);
            BaseActivity context = this.fWZ.getContext();
            this.fWZ.getContext();
            context.setResult(-1, intent);
            this.fWZ.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fWZ.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fWZ != null) {
            this.fWZ.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void start(boolean z) {
        this.fWZ.setRatio(0.9433962f);
        this.fWZ.showWebView(false);
        this.fWZ.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void d(NewWriteModel.d dVar) {
        this.fXb = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPostThreadCancle() {
        this.fWZ.showPostThreadLoadingView(false);
        this.fTr.cancelLoadData();
    }

    private void rn(String str) {
        if (!k.hB()) {
            this.fWZ.getContext().showToast(w.l.neterror);
            this.fWZ.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fWZ.showPostThreadLoadingView(true);
            this.fTr.getWriteData().setVcode(str);
            this.fTr.getWriteData().setVcodeType("5");
            this.fTr.startPostWrite();
        } else {
            this.fWZ.getContext().showToast(w.l.neterror);
            this.fWZ.getContext().finish();
        }
    }
}
