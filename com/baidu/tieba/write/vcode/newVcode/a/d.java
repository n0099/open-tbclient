package com.baidu.tieba.write.vcode.newVcode.a;

import android.webkit.WebView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.h.h;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes.dex */
public class d implements c {
    private String cka;
    private String ckb;
    private final NewVcodeView fAe;
    private final com.baidu.tieba.tbadkCore.writeModel.b fxT;
    private boolean fAi = false;
    private String fAj = null;
    private Runnable fAk = new e(this);
    private final b.d awp = new f(this);

    public d(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.fAe = newVcodeView;
        this.fxT = bVar;
        this.fxT.b(this.awp);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.cka = com.baidu.tbadk.j.a.gA(str);
            if (this.cka != null && this.fxT.bbN() != null) {
                this.fAe.runJsMethod(this.cka, "'" + this.fxT.bbN().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fAe.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return jC(com.baidu.tbadk.j.a.gA(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fAe != null) {
            this.fAe.showWebViewDelay(500);
            if (this.fAi) {
                h.eG().postDelayed(this.fAk, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void p(boolean z, String str) {
        this.fAi = z;
        this.fAj = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lB(boolean z) {
        this.fAe.setRatio(1.2631578f);
        this.fAe.showWebView(false);
        String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
        if (z) {
            str = String.valueOf(str) + "?feedback=1";
        }
        this.fAe.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
        h.eG().removeCallbacks(this.fAk);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(b.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void bli() {
        this.fAe.showPostThreadLoadingView(false);
        this.fxT.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahr() {
        this.fAe.runJsMethod(this.ckb, "'" + this.fxT.bbN().getVcodeUrl() + "'");
    }

    private boolean jC(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.ckb = split[0];
        ri(split[1]);
        return true;
    }

    private void ri(String str) {
        if (!k.gD()) {
            this.fAe.getContext().showToast(r.j.neterror);
            this.fAe.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fAe.showPostThreadLoadingView(true);
            this.fxT.bbN().setVcode(str);
            this.fxT.bbN().setVcodeType("4");
            this.fxT.bhi();
        } else {
            this.fAe.getContext().showToast(r.j.neterror);
            this.fAe.getContext().finish();
        }
    }
}
