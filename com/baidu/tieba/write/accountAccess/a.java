package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
public class a {
    private final b.d avZ = new b(this);
    private final c gbP;
    private final com.baidu.tieba.tbadkCore.writeModel.b gbT;

    public a(c cVar, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.gbP = cVar;
        this.gbT = bVar;
        bVar.b(this.avZ);
    }

    public boolean sr(String str) {
        if (this.gbP == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gbP.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gbP.w(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gbP.brY() != this.gbP.ad()) {
                this.gbP.setRatio(this.gbP.brY());
                this.gbP.brZ();
            }
            this.gbP.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            brX();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback")) {
            this.gbP.getContext().finish();
            bh.vL().c(this.gbP.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void brV() {
        if (this.gbP != null) {
            this.gbP.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gbP != null) {
            this.gbP.lI(true);
            this.gbP.showWebView(false);
            this.gbP.getWebView().loadUrl(str);
        }
    }

    public void brW() {
        if (this.gbP != null) {
            this.gbP.showPostThreadLoadingView(false);
        }
    }

    private void brX() {
        if (this.gbP != null && this.gbT != null) {
            if (!k.gD()) {
                this.gbP.getContext().showToast(r.j.neterror);
                this.gbP.getContext().finish();
                return;
            }
            this.gbP.showPostThreadLoadingView(true);
            this.gbT.bkY();
        }
    }
}
