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
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes.dex */
public class d implements c {
    private String cnN;
    private String cnO;
    private final com.baidu.tieba.tbadkCore.writeModel.a fPF;
    private final NewVcodeView fRJ;
    private boolean fRN = false;
    private String fRO = null;
    private Runnable fRP = new e(this);
    private final a.d atp = new f(this);

    public d(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.a aVar) {
        this.fRJ = newVcodeView;
        this.fPF = aVar;
        this.fPF.b(this.atp);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.cnN = com.baidu.tbadk.k.a.gy(str);
            if (this.cnN != null && this.fPF.bbo() != null) {
                this.fRJ.runJsMethod(this.cnN, "'" + this.fPF.bbo().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fRJ.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return jY(com.baidu.tbadk.k.a.gy(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fRJ != null) {
            this.fRJ.showWebViewDelay(500);
            if (this.fRN) {
                h.dL().postDelayed(this.fRP, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void p(boolean z, String str) {
        this.fRN = z;
        this.fRO = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lv(boolean z) {
        this.fRJ.setRatio(1.2631578f);
        this.fRJ.showWebView(false);
        String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
        if (z) {
            str = String.valueOf(str) + "?feedback=1";
        }
        this.fRJ.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
        h.dL().removeCallbacks(this.fRP);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(a.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void bmZ() {
        this.fRJ.showPostThreadLoadingView(false);
        this.fPF.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afX() {
        this.fRJ.runJsMethod(this.cnO, "'" + this.fPF.bbo().getVcodeUrl() + "'");
    }

    private boolean jY(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.cnO = split[0];
        rA(split[1]);
        return true;
    }

    private void rA(String str) {
        if (!k.fH()) {
            this.fRJ.getContext().showToast(u.j.neterror);
            this.fRJ.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fRJ.showPostThreadLoadingView(true);
            this.fPF.bbo().setVcode(str);
            this.fPF.bbo().setVcodeType("4");
            this.fPF.bgM();
        } else {
            this.fRJ.getContext().showToast(u.j.neterror);
            this.fRJ.getContext().finish();
        }
    }
}
