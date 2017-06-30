package com.baidu.tieba.write.vcode.newVcode.a;

import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.w;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes.dex */
public class d implements c {
    private final NewWriteModel gec;
    private final NewVcodeView ghY;
    private String jsMethodForChangeVCode;
    private String jsMethodForInit;
    private boolean mNeedShowErrorToastOnStart = false;
    private String mErrorToastOnStart = null;
    private Runnable mShowErrorTaostRunnable = new e(this);
    private final NewWriteModel.d aBU = new f(this);

    public d(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.ghY = newVcodeView;
        this.gec = newWriteModel;
        this.gec.b(this.aBU);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean onUrlLoad(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jsMethodForInit = com.baidu.tbadk.o.a.gM(str);
            if (this.jsMethodForInit != null && this.gec.getWriteData() != null) {
                this.ghY.runJsMethod(this.jsMethodForInit, "'" + this.gec.getWriteData().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.ghY.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return dealJsSubmit(com.baidu.tbadk.o.a.gM(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.ghY != null) {
            this.ghY.showWebViewDelay(500);
            if (this.mNeedShowErrorToastOnStart) {
                h.fR().postDelayed(this.mShowErrorTaostRunnable, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void showErrorOnStart(boolean z, String str) {
        this.mNeedShowErrorToastOnStart = z;
        this.mErrorToastOnStart = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void start(boolean z) {
        this.ghY.setRatio(1.2631578f);
        this.ghY.showWebView(false);
        String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
        if (z) {
            str = String.valueOf(str) + "?feedback=1";
        }
        this.ghY.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
        h.fR().removeCallbacks(this.mShowErrorTaostRunnable);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void d(NewWriteModel.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPostThreadCancle() {
        this.ghY.showPostThreadLoadingView(false);
        this.gec.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVCode() {
        this.ghY.runJsMethod(this.jsMethodForChangeVCode, "'" + this.gec.getWriteData().getVcodeUrl() + "'");
    }

    private boolean dealJsSubmit(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || split.length != 2) {
            return false;
        }
        this.jsMethodForChangeVCode = split[0];
        sm(split[1]);
        return true;
    }

    private void sm(String str) {
        if (!k.hA()) {
            this.ghY.getContext().showToast(w.l.neterror);
            this.ghY.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.ghY.showPostThreadLoadingView(true);
            this.gec.getWriteData().setVcode(str);
            this.gec.getWriteData().setVcodeType("4");
            this.gec.startPostWrite();
        } else {
            this.ghY.getContext().showToast(w.l.neterror);
            this.ghY.getContext().finish();
        }
    }
}
