package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.tbadkCore.writeModel.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a {
    private final a.d atp = new b(this);
    private final c fPB;
    private final com.baidu.tieba.tbadkCore.writeModel.a fPF;

    public a(c cVar, com.baidu.tieba.tbadkCore.writeModel.a aVar) {
        this.fPB = cVar;
        this.fPF = aVar;
        aVar.b(this.atp);
    }

    public boolean rs(String str) {
        if (this.fPB == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.fPB.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.fPB.u(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.fPB.bnc() != this.fPB.bnb()) {
                this.fPB.setRatio(this.fPB.bnc());
                this.fPB.bnd();
            }
            this.fPB.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bna();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback")) {
            this.fPB.getContext().finish();
            bi.us().c(this.fPB.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bmY() {
        if (this.fPB != null) {
            this.fPB.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.fPB != null) {
            this.fPB.lq(true);
            this.fPB.showWebView(false);
            this.fPB.getWebView().loadUrl(str);
        }
    }

    public void bmZ() {
        if (this.fPB != null) {
            this.fPB.showPostThreadLoadingView(false);
        }
    }

    private void bna() {
        if (this.fPB != null && this.fPF != null) {
            if (!k.fH()) {
                this.fPB.getContext().showToast(u.j.neterror);
                this.fPB.getContext().finish();
                return;
            }
            this.fPB.showPostThreadLoadingView(true);
            this.fPF.bgM();
        }
    }
}
