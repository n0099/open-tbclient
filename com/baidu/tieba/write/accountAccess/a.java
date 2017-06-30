package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a {
    private final NewWriteModel.d aBU = new b(this);
    private final c gdZ;
    private final NewWriteModel gec;

    public a(c cVar, NewWriteModel newWriteModel) {
        this.gdZ = cVar;
        this.gec = newWriteModel;
        newWriteModel.b(this.aBU);
    }

    public boolean sb(String str) {
        if (this.gdZ == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.gdZ.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.gdZ.t(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.gdZ.brG() != this.gdZ.bm()) {
                this.gdZ.setRatio(this.gdZ.brG());
                this.gdZ.brH();
            }
            this.gdZ.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            brF();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback") || str.equals("https://tieba.baidu.com/account/access/feedback")) {
            this.gdZ.getContext().finish();
            be.vP().c(this.gdZ.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void brE() {
        if (this.gdZ != null) {
            this.gdZ.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.gdZ != null) {
            this.gdZ.showWebLoadingView(true);
            this.gdZ.showWebView(false);
            this.gdZ.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.gdZ != null) {
            this.gdZ.showPostThreadLoadingView(false);
        }
    }

    private void brF() {
        if (this.gdZ != null && this.gec != null) {
            if (!k.hA()) {
                this.gdZ.getContext().showToast(w.l.neterror);
                this.gdZ.getContext().finish();
                return;
            }
            this.gdZ.showPostThreadLoadingView(true);
            this.gec.startPostWrite();
        }
    }
}
