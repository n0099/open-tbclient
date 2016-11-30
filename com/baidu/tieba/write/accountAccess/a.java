package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* loaded from: classes.dex */
public class a {
    private final b.d awS = new b(this);
    private final c gju;
    private final com.baidu.tieba.tbadkCore.writeModel.b gjy;

    public a(c cVar, com.baidu.tieba.tbadkCore.writeModel.b bVar) {
        this.gju = cVar;
        this.gjy = bVar;
        bVar.b(this.awS);
    }

    public boolean sN(String str) {
        if (this.gju == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gju.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gju.v(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gju.but() != this.gju.ad()) {
                this.gju.setRatio(this.gju.but());
                this.gju.buu();
            }
            this.gju.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bus();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback")) {
            this.gju.getContext().finish();
            bf.vP().c(this.gju.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void buq() {
        if (this.gju != null) {
            this.gju.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gju != null) {
            this.gju.mh(true);
            this.gju.showWebView(false);
            this.gju.getWebView().loadUrl(str);
        }
    }

    public void bur() {
        if (this.gju != null) {
            this.gju.showPostThreadLoadingView(false);
        }
    }

    private void bus() {
        if (this.gju != null && this.gjy != null) {
            if (!k.gD()) {
                this.gju.getContext().showToast(r.j.neterror);
                this.gju.getContext().finish();
                return;
            }
            this.gju.showPostThreadLoadingView(true);
            this.gjy.bno();
        }
    }
}
