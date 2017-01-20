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
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes.dex */
public class a implements c {
    private final NewWriteModel.d avt = new b(this);
    private final NewWriteModel fGy;
    private final NewVcodeView fIG;
    private PostWriteCallBackData fIH;
    private NewWriteModel.d fII;

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.fIG = newVcodeView;
        this.fGy = newWriteModel;
        this.fGy.b(this.avt);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean onUrlLoad(WebView webView, String str) {
        if (this.fGy.getWriteData() == null) {
            return false;
        }
        WriteData writeData = this.fGy.getWriteData();
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.fIG.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            rB(com.baidu.tbadk.j.a.gx(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.fIG.showToast(true, this.fIG.getContext().getResources().getString(r.l.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.fIG.showToast(true, this.fIG.getContext().getResources().getString(r.l.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.fIG.getContext().getResources().getString(r.l.send_success);
                if (this.fIH != null) {
                    str2 = this.fIH.getPreMsg();
                    str3 = this.fIH.getColorMsg();
                    string = this.fIH.getErrorString();
                }
                com.baidu.tieba.tbadkCore.writeModel.e.c(this.fIG.getContext().getActivity(), string, str2, str3);
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fIH);
            intent.putExtras(bundle);
            BaseActivity context = this.fIG.getContext();
            this.fIG.getContext();
            context.setResult(-1, intent);
            this.fIG.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fIG.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fIG != null) {
            this.fIG.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void start(boolean z) {
        this.fIG.setRatio(0.9433962f);
        this.fIG.showWebView(false);
        this.fIG.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(NewWriteModel.d dVar) {
        this.fII = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPostThreadCancle() {
        this.fIG.showPostThreadLoadingView(false);
        this.fGy.cancelLoadData();
    }

    private void rB(String str) {
        if (!k.gB()) {
            this.fIG.getContext().showToast(r.l.neterror);
            this.fIG.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fIG.showPostThreadLoadingView(true);
            this.fGy.getWriteData().setVcode(str);
            this.fGy.getWriteData().setVcodeType("5");
            this.fGy.startPostWrite();
        } else {
            this.fIG.getContext().showToast(r.l.neterror);
            this.fIG.getContext().finish();
        }
    }
}
