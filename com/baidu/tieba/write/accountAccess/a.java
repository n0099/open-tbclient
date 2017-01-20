package com.baidu.tieba.write.accountAccess;

import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
/* loaded from: classes.dex */
public class a {
    private final NewWriteModel.d avt = new b(this);
    private final c fGv;
    private final NewWriteModel fGy;

    public a(c cVar, NewWriteModel newWriteModel) {
        this.fGv = cVar;
        this.fGy = newWriteModel;
        newWriteModel.b(this.avt);
    }

    public boolean rs(String str) {
        if (this.fGv == null || str == null) {
            return false;
        }
        if (str.equals("http://tieba.baidu.com/account/access/cancel")) {
            this.fGv.getContext().finish();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/input_focus")) {
            this.fGv.s(0, UtilHelper.getImmersiveStickyBarHeight(), 0, 0);
            if (this.fGv.bmI() != this.fGv.ad()) {
                this.fGv.setRatio(this.fGv.bmI());
                this.fGv.bmJ();
            }
            this.fGv.getWebView().setVisibility(0);
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/valid_success")) {
            bmH();
            return true;
        } else if (str.equals("http://tieba.baidu.com/account/access/feedback")) {
            this.fGv.getContext().finish();
            ba.vt().c(this.fGv.getContext().getPageContext(), new String[]{"feedback:"});
            return true;
        } else {
            return true;
        }
    }

    public void bmG() {
        if (this.fGv != null) {
            this.fGv.showWebViewDelay(500);
        }
    }

    public void start(String str) {
        if (this.fGv != null) {
            this.fGv.showWebLoadingView(true);
            this.fGv.showWebView(false);
            this.fGv.getWebView().loadUrl(str);
        }
    }

    public void onPostThreadCancle() {
        if (this.fGv != null) {
            this.fGv.showPostThreadLoadingView(false);
        }
    }

    private void bmH() {
        if (this.fGv != null && this.fGy != null) {
            if (!k.gB()) {
                this.fGv.getContext().showToast(r.l.neterror);
                this.fGv.getContext().finish();
                return;
            }
            this.fGv.showPostThreadLoadingView(true);
            this.fGy.startPostWrite();
        }
    }
}
