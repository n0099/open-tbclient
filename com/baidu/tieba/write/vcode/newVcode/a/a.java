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
    private final b.d avZ = new b(this);
    private final com.baidu.tieba.tbadkCore.writeModel.b gbT;
    private final NewVcodeView gdX;
    private PostWriteCallBackData gdY;
    private b.d gdZ;

    public a(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.gdX = newVcodeView;
        this.gbT = bVar;
        this.gbT.b(this.avZ);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (this.gbT.bfE() == null) {
            return false;
        }
        WriteData bfE = this.gbT.bfE();
        if (str.contains("objc:loadReady")) {
            if (bfE.getVcodeExtra() == null) {
                return false;
            }
            this.gdX.runJsMethod("handleFreshCaptcha", "'" + bfE.getVcodeUrl() + "','" + bfE.getVcodeExtra().slideImg + "','" + bfE.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            sz(com.baidu.tbadk.j.a.gF(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (bfE != null && bfE.getVideoReviewType() == 1) {
                this.gdX.showToast(true, this.gdX.getContext().getResources().getString(r.j.video_send_success_under_review));
            } else if (bfE != null && bfE.getVideoReviewType() == 2) {
                this.gdX.showToast(true, this.gdX.getContext().getResources().getString(r.j.video_send_success));
            } else {
                this.gdX.showToast(true, this.gdX.getContext().getResources().getString(r.j.send_success));
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("post_write_callback_data", this.gdY);
            intent.putExtras(bundle);
            BaseActivity context = this.gdX.getContext();
            this.gdX.getContext();
            context.setResult(-1, intent);
            this.gdX.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gdX.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.gdX != null) {
            this.gdX.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void o(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lN(boolean z) {
        this.gdX.setRatio(0.9433962f);
        this.gdX.showWebView(false);
        this.gdX.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(b.d dVar) {
        this.gdZ = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void brW() {
        this.gdX.showPostThreadLoadingView(false);
        this.gbT.cancelLoadData();
    }

    private void sz(String str) {
        if (!k.gD()) {
            this.gdX.getContext().showToast(r.j.neterror);
            this.gdX.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gdX.showPostThreadLoadingView(true);
            this.gbT.bfE().setVcode(str);
            this.gbT.bfE().setVcodeType("5");
            this.gbT.bkY();
        } else {
            this.gdX.getContext().showToast(r.j.neterror);
            this.gdX.getContext().finish();
        }
    }
}
