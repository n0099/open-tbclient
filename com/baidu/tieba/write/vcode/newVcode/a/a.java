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
    private final NewWriteModel.d aBU = new b(this);
    private final NewWriteModel gec;
    private final NewVcodeView ghY;
    private PostWriteCallBackData ghZ;
    private NewWriteModel.d gia;

    public a(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.ghY = newVcodeView;
        this.gec = newWriteModel;
        this.gec.b(this.aBU);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean onUrlLoad(WebView webView, String str) {
        WriteData writeData;
        if (this.gec.getWriteData() == null || StringUtils.isNull(str) || (writeData = this.gec.getWriteData()) == null) {
            return false;
        }
        if (str.contains("objc:loadReady")) {
            if (writeData.getVcodeExtra() == null) {
                return false;
            }
            this.ghY.runJsMethod("handleFreshCaptcha", "'" + writeData.getVcodeUrl() + "','" + writeData.getVcodeExtra().slideImg + "','" + writeData.getVcodeExtra().textImg + "'");
            return true;
        } else if (str.contains("objc:jsChangePosition")) {
            sm(com.baidu.tbadk.o.a.gM(str));
            return true;
        } else if (str.contains("objc:finish")) {
            if (writeData != null && writeData.getVideoReviewType() == 1) {
                this.ghY.showToast(true, this.ghY.getContext().getResources().getString(w.l.video_send_success_under_review));
            } else if (writeData != null && writeData.getVideoReviewType() == 2) {
                this.ghY.showToast(true, this.ghY.getContext().getResources().getString(w.l.video_send_success));
            } else {
                String str2 = null;
                String str3 = null;
                String string = this.ghY.getContext().getResources().getString(w.l.send_success);
                if (this.ghZ != null) {
                    str2 = this.ghZ.getPreMsg();
                    str3 = this.ghZ.getColorMsg();
                    string = this.ghZ.getErrorString();
                }
                if (writeData.getType() != 7) {
                    com.baidu.tieba.tbadkCore.writeModel.e.c(this.ghY.getContext().getActivity(), string, str2, str3);
                }
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WriteActivityConfig.POST_WRITE_CALLBACK_DATA, this.ghZ);
            intent.putExtras(bundle);
            BaseActivity context = this.ghY.getContext();
            this.ghY.getContext();
            context.setResult(-1, intent);
            this.ghY.getContext().finish();
            return true;
        } else if (str.contains("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.ghY.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.ghY != null) {
            this.ghY.showWebViewDelay(1000);
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void showErrorOnStart(boolean z, String str) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void start(boolean z) {
        this.ghY.setRatio(0.9433962f);
        this.ghY.showWebView(false);
        this.ghY.getWebView().loadUrl(String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "n/captcha-drag");
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void d(NewWriteModel.d dVar) {
        this.gia = dVar;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPostThreadCancle() {
        this.ghY.showPostThreadLoadingView(false);
        this.gec.cancelLoadData();
    }

    private void sm(String str) {
        if (!k.hA()) {
            this.ghY.getContext().showToast(w.l.neterror);
            this.ghY.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.ghY.showPostThreadLoadingView(true);
            this.gec.getWriteData().setVcode(str);
            this.gec.getWriteData().setVcodeType("5");
            this.gec.startPostWrite();
        } else {
            this.ghY.getContext().showToast(w.l.neterror);
            this.ghY.getContext().finish();
        }
    }
}
