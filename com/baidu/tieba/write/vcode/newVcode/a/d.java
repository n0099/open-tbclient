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
    private String cEK;
    private String cEL;
    private final com.baidu.tieba.tbadkCore.writeModel.b gjy;
    private final NewVcodeView glB;
    private boolean glF = false;
    private String glG = null;
    private Runnable glH = new e(this);
    private final b.d awS = new f(this);

    public d(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.glB = newVcodeView;
        this.gjy = bVar;
        this.gjy.b(this.awS);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.cEK = com.baidu.tbadk.j.a.gF(str);
            if (this.cEK != null && this.gjy.bia() != null) {
                this.glB.runJsMethod(this.cEK, "'" + this.gjy.bia().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.glB.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return kY(com.baidu.tbadk.j.a.gF(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.glB != null) {
            this.glB.showWebViewDelay(500);
            if (this.glF) {
                h.eG().postDelayed(this.glH, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void p(boolean z, String str) {
        this.glF = z;
        this.glG = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void mm(boolean z) {
        this.glB.setRatio(1.2631578f);
        this.glB.showWebView(false);
        String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
        if (z) {
            str = String.valueOf(str) + "?feedback=1";
        }
        this.glB.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
        h.eG().removeCallbacks(this.glH);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(b.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void bur() {
        this.glB.showPostThreadLoadingView(false);
        this.gjy.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amR() {
        this.glB.runJsMethod(this.cEL, "'" + this.gjy.bia().getVcodeUrl() + "'");
    }

    private boolean kY(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.cEL = split[0];
        sV(split[1]);
        return true;
    }

    private void sV(String str) {
        if (!k.gD()) {
            this.glB.getContext().showToast(r.j.neterror);
            this.glB.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.glB.showPostThreadLoadingView(true);
            this.gjy.bia().setVcode(str);
            this.gjy.bia().setVcodeType("4");
            this.gjy.bno();
        } else {
            this.glB.getContext().showToast(r.j.neterror);
            this.glB.getContext().finish();
        }
    }
}
