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
    private final NewWriteModel fTr;
    private final NewVcodeView fWZ;
    private String jsMethodForChangeVCode;
    private String jsMethodForInit;
    private boolean mNeedShowErrorToastOnStart = false;
    private String mErrorToastOnStart = null;
    private Runnable mShowErrorTaostRunnable = new e(this);
    private final NewWriteModel.d aAR = new f(this);

    public d(NewVcodeView newVcodeView, NewWriteModel newWriteModel) {
        this.fWZ = newVcodeView;
        this.fTr = newWriteModel;
        this.fTr.b(this.aAR);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean onUrlLoad(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.jsMethodForInit = com.baidu.tbadk.o.a.gp(str);
            if (this.jsMethodForInit != null && this.fTr.getWriteData() != null) {
                this.fWZ.runJsMethod(this.jsMethodForInit, "'" + this.fTr.getWriteData().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fWZ.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return dealJsSubmit(com.baidu.tbadk.o.a.gp(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fWZ != null) {
            this.fWZ.showWebViewDelay(500);
            if (this.mNeedShowErrorToastOnStart) {
                h.fS().postDelayed(this.mShowErrorTaostRunnable, 500L);
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
        this.fWZ.setRatio(1.2631578f);
        this.fWZ.showWebView(false);
        String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
        if (z) {
            str = String.valueOf(str) + "?feedback=1";
        }
        this.fWZ.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
        h.fS().removeCallbacks(this.mShowErrorTaostRunnable);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void d(NewWriteModel.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPostThreadCancle() {
        this.fWZ.showPostThreadLoadingView(false);
        this.fTr.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshVCode() {
        this.fWZ.runJsMethod(this.jsMethodForChangeVCode, "'" + this.fTr.getWriteData().getVcodeUrl() + "'");
    }

    private boolean dealJsSubmit(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.jsMethodForChangeVCode = split[0];
        rn(split[1]);
        return true;
    }

    private void rn(String str) {
        if (!k.hB()) {
            this.fWZ.getContext().showToast(w.l.neterror);
            this.fWZ.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fWZ.showPostThreadLoadingView(true);
            this.fTr.getWriteData().setVcode(str);
            this.fTr.getWriteData().setVcodeType("4");
            this.fTr.startPostWrite();
        } else {
            this.fWZ.getContext().showToast(w.l.neterror);
            this.fWZ.getContext().finish();
        }
    }
}
