package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private final NewWriteModel.d aBf = new b(this);
    private final c fLH;
    private final NewWriteModel fLK;

    public a(c cVar, NewWriteModel newWriteModel) {
        this.fLH = cVar;
        this.fLK = newWriteModel;
        newWriteModel.b(this.aBf);
    }

    public boolean qP(String str) {
        if (this.fLH == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.fLH.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.fLH.s(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.fLH.blM() != this.fLH.bm()) {
                this.fLH.setRatio(this.fLH.blM());
                this.fLH.blN();
            }
            this.fLH.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            blL();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.fLH.getContext().finish();
            bb.vB().c(this.fLH.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void blK() {
        if (this.fLH != null) {
            this.fLH.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.fLH != null) {
            this.fLH.showWebLoadingView(true);
            this.fLH.showWebView(false);
            this.fLH.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.fLH != null) {
            this.fLH.showPostThreadLoadingView(false);
        }
    }

    private void blL() {
        if (this.fLH != null && this.fLK != null) {
            if (!k.hB()) {
                this.fLH.getContext().showToast(w.l.neterror);
                this.fLH.getContext().finish();
                return;
            }
            this.fLH.showPostThreadLoadingView(true);
            this.fLK.startPostWrite();
        }
    }
}
