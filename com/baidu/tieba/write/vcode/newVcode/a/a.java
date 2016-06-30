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
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes.dex */
public class a implements c {
    private final a.d asA = new b(this);
    private final NewVcodeView fFH;
    private final com.baidu.tieba.tbadkCore.writeModel.a fFI;
    private PostWriteCallBackData fFJ;
    private a.d fFK;

    public a(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.a aVar) {
        this.fFH = newVcodeView;
        this.fFI = aVar;
        this.fFI.b(this.asA);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (this.fFI.bdu() == null) {
            return false;
        }
        WriteData bdu = this.fFI.bdu();
        if (str.contains("objc:loadReady")) {
            if (bdu.getVcodeExtra() == null) {
                return false;
            }
            this.fFH.runJsMethod("handleFreshCaptcha", "'" + bdu.getVcodeUrl() + "','" + bdu.getVcodeExtra().slideImg + "','" + bdu.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            qQ(com.baidu.tbadk.k.a.gz(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (bdu != null && bdu.getVideoReviewType() == 1) {
                this.fFH.showToast(true, this.fFH.getContext().getResources().getString(u.j.video_send_success_under_review));
            } else if (bdu != null && bdu.getVideoReviewType() == 2) {
                this.fFH.showToast(true, this.fFH.getContext().getResources().getString(u.j.video_send_success));
            } else {
                this.fFH.showToast(true, this.fFH.getContext().getResources().getString(u.j.send_success));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fFJ);
            intent.putExtras(bundle);
            BaseActivity context = this.fFH.getContext();
            this.fFH.getContext();
            context.setResult(-1, intent);
            this.fFH.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fFH.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fFH != null) {
            this.fFH.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void q(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lh(boolean z) {
        this.fFH.setRatio(0.9433962f);
        this.fFH.showWebView(false);
        this.fFH.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(a.d dVar) {
        this.fFK = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void bkV() {
        this.fFH.showPostThreadLoadingView(false);
        this.fFI.cancelLoadData();
    }

    private void qQ(String str) {
        if (!k.fI()) {
            this.fFH.getContext().showToast(u.j.neterror);
            this.fFH.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fFH.showPostThreadLoadingView(true);
            this.fFI.bdu().setVcode(str);
            this.fFI.bdu().setVcodeType("5");
            this.fFI.bdv();
        } else {
            this.fFH.getContext().showToast(u.j.neterror);
            this.fFH.getContext().finish();
        }
    }
}
