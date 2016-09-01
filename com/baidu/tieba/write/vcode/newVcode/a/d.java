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
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.writeModel.b;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeView;
/* loaded from: classes.dex */
public class d implements c {
    private String cyW;
    private String cyX;
    private final com.baidu.tieba.tbadkCore.writeModel.b fZK;
    private final NewVcodeView gbO;
    private boolean gbS = false;
    private String gbT = null;
    private Runnable gbU = new e(this);
    private final b.d aww = new f(this);

    public d(NewVcodeView newVcodeView, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.gbO = newVcodeView;
        this.fZK = bVar;
        this.fZK.b(this.aww);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public boolean b(WebView webView, String str) {
        if (str.contains("objc:jsChangeVcode")) {
            this.cyW = com.baidu.tbadk.k.a.gB(str);
            if (this.cyW != null && this.fZK.beT() != null) {
                this.gbO.runJsMethod(this.cyW, "'" + this.fZK.beT().getVcodeUrl() + "'");
                return true;
            }
            return false;
        } else if (str.equals("objc:jumpToFeedback()")) {
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.gbO.getContext().getActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, null, 13003, true, false, null, false, false, null, null, null, 0);
            writeActivityConfig.setIsVcodeFeedBack();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            return true;
        } else if (str.contains("objc:jsSubmit")) {
            return kG(com.baidu.tbadk.k.a.gB(str));
        } else {
            return false;
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onPageFinished(WebView webView, String str) {
        if (this.gbO != null) {
            this.gbO.showWebViewDelay(500);
            if (this.gbS) {
                h.eG().postDelayed(this.gbU, 500L);
            }
        }
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void o(boolean z, String str) {
        this.gbS = z;
        this.gbT = str;
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void lL(boolean z) {
        this.gbO.setRatio(1.2631578f);
        this.gbO.showWebView(false);
        String str = String.valueOf(TbConfig.SERVER_ADDRESS_WEB_VIEW) + "mo/q/captcha";
        if (z) {
            str = String.valueOf(str) + "?feedback=1";
        }
        this.gbO.getWebView().loadUrl(str);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void onDestroy() {
        h.eG().removeCallbacks(this.gbU);
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void c(b.d dVar) {
    }

    @Override // com.baidu.tieba.write.vcode.newVcode.a.c
    public void brq() {
        this.gbO.showPostThreadLoadingView(false);
        this.fZK.cancelLoadData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akI() {
        this.gbO.runJsMethod(this.cyX, "'" + this.fZK.beT().getVcodeUrl() + "'");
    }

    private boolean kG(String str) {
        String[] split;
        if (StringUtils.isNull(str) || (split = str.split(",")) == null || split.length != 2) {
            return false;
        }
        this.cyX = split[0];
        sk(split[1]);
        return true;
    }

    private void sk(String str) {
        if (!k.gD()) {
            this.gbO.getContext().showToast(t.j.neterror);
            this.gbO.getContext().finish();
        } else if (!StringUtils.isNull(str)) {
            this.gbO.showPostThreadLoadingView(true);
            this.fZK.beT().setVcode(str);
            this.fZK.beT().setVcodeType("4");
            this.fZK.bkn();
        } else {
            this.gbO.getContext().showToast(t.j.neterror);
            this.gbO.getContext().finish();
        }
    }
}
