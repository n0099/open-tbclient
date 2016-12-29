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
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes.dex */
public class a implements c {
    private final b.d awp = new b(this);
    private final NewVcodeView fAe;
    private PostWriteCallBackData fAf;
    private b.d fAg;
    private final com.baidu.tieba.tbadkCore.writeModel.b fxT;

    public a(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.fAe = newVcodeView;
        this.fxT = bVar;
        this.fxT.b(this.awp);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (this.fxT.bbN() == null) {
            return false;
        }
        WriteData bbN = this.fxT.bbN();
        if (str.contains("objc:loadReady")) {
            if (bbN.getVcodeExtra() == null) {
                return false;
            }
            this.fAe.runJsMethod("handleFreshCaptcha", "'" + bbN.getVcodeUrl() + "','" + bbN.getVcodeExtra().slideImg + "','" + bbN.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            ri(com.baidu.tbadk.j.a.gA(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (bbN != null && bbN.getVideoReviewType() == 1) {
                this.fAe.showToast(true, this.fAe.getContext().getResources().getString(r.j.video_send_success_under_review));
            } else if (bbN != null && bbN.getVideoReviewType() == 2) {
                this.fAe.showToast(true, this.fAe.getContext().getResources().getString(r.j.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.fAe.getContext().getResources().getString(r.j.send_success);
                if (this.fAf != null) {
                    str2 = this.fAf.getPreMsg();
                    str3 = this.fAf.getColorMsg();
                    string = this.fAf.getErrorString();
                }
                com.baidu.tieba.tbadkCore.writeModel.f.c(this.fAe.getContext().getActivity(), string, str2, str3);
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fAf);
            intent.putExtras(bundle);
            BaseActivity context = this.fAe.getContext();
            this.fAe.getContext();
            context.setResult(-1, intent);
            this.fAe.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fAe.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fAe != null) {
            this.fAe.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void p(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lB(boolean z) {
        this.fAe.setRatio(0.9433962f);
        this.fAe.showWebView(false);
        this.fAe.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(b.d dVar) {
        this.fAg = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void bli() {
        this.fAe.showPostThreadLoadingView(false);
        this.fxT.cancelLoadData();
    }

    private void ri(String str) {
        if (!k.gD()) {
            this.fAe.getContext().showToast(r.j.neterror);
            this.fAe.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fAe.showPostThreadLoadingView(true);
            this.fxT.bbN().setVcode(str);
            this.fxT.bbN().setVcodeType("5");
            this.fxT.bhi();
        } else {
            this.fAe.getContext().showToast(r.j.neterror);
            this.fAe.getContext().finish();
        }
    }
}
