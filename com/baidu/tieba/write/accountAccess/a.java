package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private final NewWriteModel.d aBe = new b(this);
    private final NewWriteModel fMB;
    private final c fMy;

    public a(c cVar, NewWriteModel newWriteModel) {
        this.fMy = cVar;
        this.fMB = newWriteModel;
        newWriteModel.b(this.aBe);
    }

    public boolean qU(String str) {
        if (this.fMy == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.fMy.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.fMy.t(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.fMy.bnf() != this.fMy.bm()) {
                this.fMy.setRatio(this.fMy.bnf());
                this.fMy.bng();
            }
            this.fMy.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bne();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.fMy.getContext().finish();
            bb.wn().c(this.fMy.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bnd() {
        if (this.fMy != null) {
            this.fMy.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.fMy != null) {
            this.fMy.showWebLoadingView(true);
            this.fMy.showWebView(false);
            this.fMy.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.fMy != null) {
            this.fMy.showPostThreadLoadingView(false);
        }
    }

    private void bne() {
        if (this.fMy != null && this.fMB != null) {
            if (!k.hA()) {
                this.fMy.getContext().showToast(w.l.neterror);
                this.fMy.getContext().finish();
                return;
            }
            this.fMy.showPostThreadLoadingView(true);
            this.fMB.startPostWrite();
        }
    }
}
