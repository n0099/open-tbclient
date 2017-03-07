package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private final NewWriteModel.d aAO = new b(this);
    private final c fKP;
    private final NewWriteModel fKS;

    public a(c cVar, NewWriteModel newWriteModel) {
        this.fKP = cVar;
        this.fKS = newWriteModel;
        newWriteModel.b(this.aAO);
    }

    public boolean qA(String str) {
        if (this.fKP == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.fKP.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.fKP.t(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.fKP.bmv() != this.fKP.bn()) {
                this.fKP.setRatio(this.fKP.bmv());
                this.fKP.bmw();
            }
            this.fKP.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bmu();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.fKP.getContext().finish();
            bb.vQ().c(this.fKP.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bmt() {
        if (this.fKP != null) {
            this.fKP.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.fKP != null) {
            this.fKP.showWebLoadingView(true);
            this.fKP.showWebView(false);
            this.fKP.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.fKP != null) {
            this.fKP.showPostThreadLoadingView(false);
        }
    }

    private void bmu() {
        if (this.fKP != null && this.fKS != null) {
            if (!k.hv()) {
                this.fKP.getContext().showToast(w.l.neterror);
                this.fKP.getContext().finish();
                return;
            }
            this.fKP.showPostThreadLoadingView(true);
            this.fKS.startPostWrite();
        }
    }
}
