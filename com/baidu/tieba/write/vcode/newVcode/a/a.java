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
    private final NewWriteModel.d aAO = new b(this);
    private final NewWriteModel fKS;
    private final NewVcodeView fNa;
    private PostWriteCallBackData fNb;
    private NewWriteModel.d fNc;

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.fNa = newVcodeView;
        this.fKS = newWriteModel;
        this.fKS.b(this.aAO);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean onUrlLoad(WebView webView, String str) {
        if (this.fKS.getWriteData() == null) {
            return false;
        }
        WriteData writeData = this.fKS.getWriteData();
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.fNa.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            qJ(com.baidu.tbadk.j.a.gm(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.fNa.showToast(true, this.fNa.getContext().getResources().getString(w.l.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.fNa.showToast(true, this.fNa.getContext().getResources().getString(w.l.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.fNa.getContext().getResources().getString(w.l.send_success);
                if (this.fNb != null) {
                    str2 = this.fNb.getPreMsg();
                    str3 = this.fNb.getColorMsg();
                    string = this.fNb.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.e.b(this.fNa.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fNb);
            intent.putExtras(bundle);
            BaseActivity context = this.fNa.getContext();
            this.fNa.getContext();
            context.setResult(-1, intent);
            this.fNa.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fNa.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fNa != null) {
            this.fNa.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void start(boolean z) {
        this.fNa.setRatio(0.9433962f);
        this.fNa.showWebView(false);
        this.fNa.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(NewWriteModel.d dVar) {
        this.fNc = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPostThreadCancle() {
        this.fNa.showPostThreadLoadingView(false);
        this.fKS.cancelLoadData();
    }

    private void qJ(String str) {
        if (!k.hv()) {
            this.fNa.getContext().showToast(w.l.neterror);
            this.fNa.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fNa.showPostThreadLoadingView(true);
            this.fKS.getWriteData().setVcode(str);
            this.fKS.getWriteData().setVcodeType("5");
            this.fKS.startPostWrite();
        } else {
            this.fNa.getContext().showToast(w.l.neterror);
            this.fNa.getContext().finish();
        }
    }
}
