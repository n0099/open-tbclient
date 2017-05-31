package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private final NewWriteModel.d aAR = new b(this);
    private final c fTo;
    private final NewWriteModel fTr;

    public a(c cVar, NewWriteModel newWriteModel) {
        this.fTo = cVar;
        this.fTr = newWriteModel;
        newWriteModel.b(this.aAR);
    }

    public boolean rc(String str) {
        if (this.fTo == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.fTo.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.fTo.r(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.fTo.bnj() != this.fTo.bm()) {
                this.fTo.setRatio(this.fTo.bnj());
                this.fTo.bnk();
            }
            this.fTo.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bni();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.fTo.getContext().finish();
            bb.vy().c(this.fTo.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bnh() {
        if (this.fTo != null) {
            this.fTo.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.fTo != null) {
            this.fTo.showWebLoadingView(true);
            this.fTo.showWebView(false);
            this.fTo.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.fTo != null) {
            this.fTo.showPostThreadLoadingView(false);
        }
    }

    private void bni() {
        if (this.fTo != null && this.fTr != null) {
            if (!k.hB()) {
                this.fTo.getContext().showToast(w.l.neterror);
                this.fTo.getContext().finish();
                return;
            }
            this.fTo.showPostThreadLoadingView(true);
            this.fTr.startPostWrite();
        }
    }
}
