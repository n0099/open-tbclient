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
/* loaded from: classes.dex */
public class d implements c {
    private final NewWriteModel fMB;
    private final NewVcodeView fOJ;
    private String jsMethodForChangeVCode;
    private String jsMethodForInit;
    private boolean mNeedShowErrorToastOnStart = false;
    private String mErrorToastOnStart = null;
    private Runnable mShowErrorTaostRunnable = new e(this);
    private final NewWriteModel.d aBe = new f(this);

    public d(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.fOJ = newVcodeView;
        this.fMB = newWriteModel;
        this.fMB.b(this.aBe);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean onUrlLoad(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jsMethodForInit = com.baidu.tbadk.o.a.gs(str);
            if (this.jsMethodForInit != null && this.fMB.getWriteData() != null) {
                this.fOJ.runJsMethod(this.jsMethodForInit, "'" + this.fMB.getWriteData().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fOJ.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return dealJsSubmit(com.baidu.tbadk.o.a.gs(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fOJ != null) {
            this.fOJ.showWebViewDelay(500);
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
        this.fOJ.setRatio(1.2631578f);
        this.fOJ.showWebView(false);
        String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
        if (z) {
            str = String.valueOf(str) + "?feedback=1";
        }
        this.fOJ.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
        h.fR().removeCallbacks(this.mShowErrorTaostRunnable);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(NewWriteModel.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPostThreadCancle() {
        this.fOJ.showPostThreadLoadingView(false);
        this.fMB.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVCode() {
        this.fOJ.runJsMethod(this.jsMethodForChangeVCode, "'" + this.fMB.getWriteData().getVcodeUrl() + "'");
    }

    private boolean dealJsSubmit(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.jsMethodForChangeVCode = split[0];
        rd(split[1]);
        return true;
    }

    private void rd(String str) {
        if (!k.hA()) {
            this.fOJ.getContext().showToast(w.l.neterror);
            this.fOJ.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fOJ.showPostThreadLoadingView(true);
            this.fMB.getWriteData().setVcode(str);
            this.fMB.getWriteData().setVcodeType("4");
            this.fMB.startPostWrite();
        } else {
            this.fOJ.getContext().showToast(w.l.neterror);
            this.fOJ.getContext().finish();
        }
    }
}
