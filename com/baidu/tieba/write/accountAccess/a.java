package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
public class a {
    private final b.d awp = new b(this);
    private final c fxP;
    private final com.baidu.tieba.tbadkCore.writeModel.b fxT;

    public a(c cVar, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.fxP = cVar;
        this.fxT = bVar;
        bVar.b(this.awp);
    }

    public boolean qY(String str) {
        if (this.fxP == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.fxP.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.fxP.t(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.fxP.blk() != this.fxP.ad()) {
                this.fxP.setRatio(this.fxP.blk());
                this.fxP.bll();
            }
            this.fxP.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            blj();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback")) {
            this.fxP.getContext().finish();
            bc.vz().c(this.fxP.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void blh() {
        if (this.fxP != null) {
            this.fxP.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.fxP != null) {
            this.fxP.lv(true);
            this.fxP.showWebView(false);
            this.fxP.getWebView().loadUrl(str);
        }
    }

    public void bli() {
        if (this.fxP != null) {
            this.fxP.showPostThreadLoadingView(false);
        }
    }

    private void blj() {
        if (this.fxP != null && this.fxT != null) {
            if (!k.gD()) {
                this.fxP.getContext().showToast(r.j.neterror);
                this.fxP.getContext().finish();
                return;
            }
            this.fxP.showPostThreadLoadingView(true);
            this.fxT.bhi();
        }
    }
}
