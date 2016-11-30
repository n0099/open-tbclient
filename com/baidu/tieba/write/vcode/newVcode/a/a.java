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
    private final b.d awS = new b(this);
    private final com.baidu.tieba.tbadkCore.writeModel.b gjy;
    private final NewVcodeView glB;
    private PostWriteCallBackData glC;
    private b.d glD;

    public a(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.glB = newVcodeView;
        this.gjy = bVar;
        this.gjy.b(this.awS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (this.gjy.bia() == null) {
            return false;
        }
        WriteData bia = this.gjy.bia();
        if (str.contains("objc:loadReady")) {
            if (bia.getVcodeExtra() == null) {
                return false;
            }
            this.glB.runJsMethod("handleFreshCaptcha", "'" + bia.getVcodeUrl() + "','" + bia.getVcodeExtra().slideImg + "','" + bia.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            sV(com.baidu.tbadk.j.a.gF(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (bia != null && bia.getVideoReviewType() == 1) {
                this.glB.showToast(true, this.glB.getContext().getResources().getString(r.j.video_send_success_under_review));
            } else if (bia != null && bia.getVideoReviewType() == 2) {
                this.glB.showToast(true, this.glB.getContext().getResources().getString(r.j.video_send_success));
            } else {
                this.glB.showToast(true, this.glB.getContext().getResources().getString(r.j.send_success));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.glC);
            intent.putExtras(bundle);
            BaseActivity context = this.glB.getContext();
            this.glB.getContext();
            context.setResult(-1, intent);
            this.glB.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.glB.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.glB != null) {
            this.glB.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void p(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void mm(boolean z) {
        this.glB.setRatio(0.9433962f);
        this.glB.showWebView(false);
        this.glB.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(b.d dVar) {
        this.glD = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void bur() {
        this.glB.showPostThreadLoadingView(false);
        this.gjy.cancelLoadData();
    }

    private void sV(String str) {
        if (!k.gD()) {
            this.glB.getContext().showToast(r.j.neterror);
            this.glB.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.glB.showPostThreadLoadingView(true);
            this.gjy.bia().setVcode(str);
            this.gjy.bia().setVcodeType("5");
            this.gjy.bno();
        } else {
            this.glB.getContext().showToast(r.j.neterror);
            this.glB.getContext().finish();
        }
    }
}
