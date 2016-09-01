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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes.dex */
public class a implements c {
    private final b.d aww = new b(this);
    private final com.baidu.tieba.tbadkCore.writeModel.b fZK;
    private final NewVcodeView gbO;
    private PostWriteCallBackData gbP;
    private b.d gbQ;

    public a(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.gbO = newVcodeView;
        this.fZK = bVar;
        this.fZK.b(this.aww);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (this.fZK.beT() == null) {
            return false;
        }
        WriteData beT = this.fZK.beT();
        if (str.contains("objc:loadReady")) {
            if (beT.getVcodeExtra() == null) {
                return false;
            }
            this.gbO.runJsMethod("handleFreshCaptcha", "'" + beT.getVcodeUrl() + "','" + beT.getVcodeExtra().slideImg + "','" + beT.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            sk(com.baidu.tbadk.k.a.gB(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (beT != null && beT.getVideoReviewType() == 1) {
                this.gbO.showToast(true, this.gbO.getContext().getResources().getString(t.j.video_send_success_under_review));
            } else if (beT != null && beT.getVideoReviewType() == 2) {
                this.gbO.showToast(true, this.gbO.getContext().getResources().getString(t.j.video_send_success));
            } else {
                this.gbO.showToast(true, this.gbO.getContext().getResources().getString(t.j.send_success));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.gbP);
            intent.putExtras(bundle);
            BaseActivity context = this.gbO.getContext();
            this.gbO.getContext();
            context.setResult(-1, intent);
            this.gbO.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gbO.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.gbO != null) {
            this.gbO.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void o(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lL(boolean z) {
        this.gbO.setRatio(0.9433962f);
        this.gbO.showWebView(false);
        this.gbO.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(b.d dVar) {
        this.gbQ = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void brq() {
        this.gbO.showPostThreadLoadingView(false);
        this.fZK.cancelLoadData();
    }

    private void sk(String str) {
        if (!k.gD()) {
            this.gbO.getContext().showToast(t.j.neterror);
            this.gbO.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gbO.showPostThreadLoadingView(true);
            this.fZK.beT().setVcode(str);
            this.fZK.beT().setVcodeType("5");
            this.fZK.bkn();
        } else {
            this.gbO.getContext().showToast(t.j.neterror);
            this.gbO.getContext().finish();
        }
    }
}
