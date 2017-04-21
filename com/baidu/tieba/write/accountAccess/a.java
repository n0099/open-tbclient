package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private final NewWriteModel.d aBg = new b(this);
    private final c fOU;
    private final NewWriteModel fOX;

    public a(c cVar, NewWriteModel newWriteModel) {
        this.fOU = cVar;
        this.fOX = newWriteModel;
        newWriteModel.b(this.aBg);
    }

    public boolean qV(String str) {
        if (this.fOU == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.fOU.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.fOU.t(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.fOU.bog() != this.fOU.bm()) {
                this.fOU.setRatio(this.fOU.bog());
                this.fOU.boh();
            }
            this.fOU.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bof();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.fOU.getContext().finish();
            bb.wn().c(this.fOU.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void boe() {
        if (this.fOU != null) {
            this.fOU.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.fOU != null) {
            this.fOU.showWebLoadingView(true);
            this.fOU.showWebView(false);
            this.fOU.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.fOU != null) {
            this.fOU.showPostThreadLoadingView(false);
        }
    }

    private void bof() {
        if (this.fOU != null && this.fOX != null) {
            if (!k.hB()) {
                this.fOU.getContext().showToast(w.l.neterror);
                this.fOU.getContext().finish();
                return;
            }
            this.fOU.showPostThreadLoadingView(true);
            this.fOX.startPostWrite();
        }
    }
}
