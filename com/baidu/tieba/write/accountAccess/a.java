package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
public class a {
    private final b.d aww = new b(this);
    private final c fZG;
    private final com.baidu.tieba.tbadkCore.writeModel.b fZK;

    public a(c cVar, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.fZG = cVar;
        this.fZK = bVar;
        bVar.b(this.aww);
    }

    public boolean sc(String str) {
        if (this.fZG == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.fZG.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.fZG.v(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.fZG.brs() != this.fZG.ad()) {
                this.fZG.setRatio(this.fZG.brs());
                this.fZG.brt();
            }
            this.fZG.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            brr();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback")) {
            this.fZG.getContext().finish();
            bi.vx().c(this.fZG.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void brp() {
        if (this.fZG != null) {
            this.fZG.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.fZG != null) {
            this.fZG.lG(true);
            this.fZG.showWebView(false);
            this.fZG.getWebView().loadUrl(str);
        }
    }

    public void brq() {
        if (this.fZG != null) {
            this.fZG.showPostThreadLoadingView(false);
        }
    }

    private void brr() {
        if (this.fZG != null && this.fZK != null) {
            if (!k.gD()) {
                this.fZG.getContext().showToast(t.j.neterror);
                this.fZG.getContext().finish();
                return;
            }
            this.fZG.showPostThreadLoadingView(true);
            this.fZK.bkn();
        }
    }
}
