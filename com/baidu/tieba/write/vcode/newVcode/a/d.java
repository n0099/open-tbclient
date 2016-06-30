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
    private String cly;
    private String clz;
    private final NewVcodeView fFH;
    private final com.baidu.tieba.tbadkCore.writeModel.a fFI;
    private boolean fFM = false;
    private String fFN = null;
    private Runnable fFO = new e(this);
    private final a.d asA = new f(this);

    public d(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.a aVar) {
        this.fFH = newVcodeView;
        this.fFI = aVar;
        this.fFI.b(this.asA);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.cly = com.baidu.tbadk.k.a.gz(str);
            if (this.cly != null && this.fFI.bdu() != null) {
                this.fFH.runJsMethod(this.cly, "'" + this.fFI.bdu().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.fFH.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return jS(com.baidu.tbadk.k.a.gz(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.fFH != null) {
            this.fFH.showWebViewDelay(500);
            if (this.fFM) {
                h.dM().postDelayed(this.fFO, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void q(boolean z, String str) {
        this.fFM = z;
        this.fFN = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lh(boolean z) {
        this.fFH.setRatio(1.2631578f);
        this.fFH.showWebView(false);
        String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
        if (z) {
            str = String.valueOf(str) + "?feedback=1";
        }
        this.fFH.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
        h.dM().removeCallbacks(this.fFO);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(a.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void bkV() {
        this.fFH.showPostThreadLoadingView(false);
        this.fFI.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afu() {
        this.fFH.runJsMethod(this.clz, "'" + this.fFI.bdu().getVcodeUrl() + "'");
    }

    private boolean jS(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.clz = split[0];
        qQ(split[1]);
        return true;
    }

    private void qQ(String str) {
        if (!k.fI()) {
            this.fFH.getContext().showToast(u.j.neterror);
            this.fFH.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.fFH.showPostThreadLoadingView(true);
            this.fFI.bdu().setVcode(str);
            this.fFI.bdu().setVcodeType("4");
            this.fFI.bdv();
        } else {
            this.fFH.getContext().showToast(u.j.neterror);
            this.fFH.getContext().finish();
        }
    }
}
