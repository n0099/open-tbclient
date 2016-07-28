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
    private final a.d atp = new b(this);
    private final com.baidu.tieba.tbadkCore.writeModel.a fPF;
    private final NewVcodeView fRJ;
    private PostWriteCallBackData fRK;
    private a.d fRL;

    public a(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.a aVar) {
        this.fRJ = newVcodeView;
        this.fPF = aVar;
        this.fPF.b(this.atp);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (this.fPF.bbo() == null) {
            return false;
        }
        WriteData bbo = this.fPF.bbo();
        if (str.contains("objc:loadReady")) {
            if (bbo.getVcodeExtra() == null) {
                return false;
            }
            this.fRJ.runJsMethod("handleFreshCaptcha", "'" + bbo.getVcodeUrl() + "','" + bbo.getVcodeExtra().slideImg + "','" + bbo.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            rA(com.baidu.tbadk.k.a.gy(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (bbo != null && bbo.getVideoReviewType() == 1) {
                this.fRJ.showToast(true, this.fRJ.getContext().getResources().getString(u.j.video_send_success_under_review));
            } else if (bbo != null && bbo.getVideoReviewType() == 2) {
                this.fRJ.showToast(true, this.fRJ.getContext().getResources().getString(u.j.video_send_success));
            } else {
                this.fRJ.showToast(true, this.fRJ.getContext().getResources().getString(u.j.send_success));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.fRK);
            intent.putExtras(bundle);
            BaseActivity context = this.fRJ.getContext();
            this.fRJ.getContext();
            context.setResult(-1, intent);
            this.fRJ.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fRJ.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fRJ != null) {
            this.fRJ.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void p(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lv(boolean z) {
        this.fRJ.setRatio(0.9433962f);
        this.fRJ.showWebView(false);
        this.fRJ.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(a.d dVar) {
        this.fRL = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void bmZ() {
        this.fRJ.showPostThreadLoadingView(false);
        this.fPF.cancelLoadData();
    }

    private void rA(String str) {
        if (!k.fH()) {
            this.fRJ.getContext().showToast(u.j.neterror);
            this.fRJ.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fRJ.showPostThreadLoadingView(true);
            this.fPF.bbo().setVcode(str);
            this.fPF.bbo().setVcodeType("5");
            this.fPF.bgM();
        } else {
            this.fRJ.getContext().showToast(u.j.neterror);
            this.fRJ.getContext().finish();
        }
    }
}
