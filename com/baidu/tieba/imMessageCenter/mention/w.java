package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class w extends com.baidu.adp.base.f<bd> implements r.b, com.baidu.tbadk.mvc.f.a.a {
    protected BdListView aTj;
    private com.baidu.tbadk.mvc.h.a aTl;
    protected View azA;
    protected bd cmH;
    private boolean cmU;
    private boolean cmV;
    protected com.baidu.tbadk.core.view.t mPullView;

    public w(bd bdVar) {
        super(com.baidu.adp.base.l.C(bdVar.getPageContext().getPageActivity()));
        this.cmU = true;
        this.cmV = false;
        this.cmH = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.Fd()) {
                this.aTl.ow();
                if (aVar.Fb()) {
                    this.aTl.eT(t.j.loading);
                } else if (aVar.Fc()) {
                    this.aTl.eT(t.j.loading);
                } else {
                    this.aTl.eU(t.j.no_more_msg);
                }
            } else {
                this.aTl.hide();
            }
            if (aVar.isPullRefreshing()) {
                ahD();
            } else {
                ahE();
            }
        }
    }

    public void ahD() {
        if (this.mPullView != null) {
            this.mPullView.a((r.b) null);
        }
        if (this.aTj != null) {
            this.aTj.ns();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void ahE() {
        if (this.aTj != null) {
            this.aTj.nr();
        }
    }

    @Override // com.baidu.tbadk.core.view.r.b
    public void b(View view, boolean z) {
        if (this instanceof k) {
            this.cmH.ahY().bU(z);
        } else if (this instanceof j) {
            this.cmH.ahX().bU(z);
        } else {
            this.cmH.ahW().bU(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        ahE();
        if (this.aTl != null) {
            this.aTl.eU(t.j.no_more_msg);
        }
    }

    protected View pa() {
        this.azA = this.cmH.getActivity().getLayoutInflater().inflate(t.h.mvc_template_list, (ViewGroup) null);
        this.aTj = (BdListView) this.cmH.getActivity().findViewById(t.g.view_list);
        return this.azA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oQ() {
        this.mPullView = new com.baidu.tbadk.core.view.t(this.cmH.getPageContext());
        this.mPullView.setTag(this.cmH.getUniqueId());
        this.mPullView.a(this);
        this.aTl = new com.baidu.tbadk.mvc.h.a(this.cmH.getBaseFragmentActivity());
        this.aTl.ni();
        if (this.aTj != null) {
            this.aTj.setDividerHeight(0);
            this.aTj.setExOnSrollToBottomListener(new x(this));
            this.aTj.setPullRefresh(this.mPullView);
            this.aTj.setNextPage(this.aTl);
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (this.aTl != null) {
            this.aTl.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dg(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Bundle bundle) {
    }

    public void onPrimary() {
        if (this.cmU || this.cmV) {
            this.cmU = false;
            this.cmV = false;
            if (this instanceof k) {
                this.cmH.ahY().bU(false);
            } else if (this instanceof j) {
                this.cmH.ahX().oR();
            } else {
                this.cmH.ahW().oR();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void bA(boolean z) {
        if (z && this.aTj != null && this.aTj.getWrappedAdapter() != null && this.aTj.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.hr().post(new y(this));
        }
    }

    public void Fg() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void Fh() {
    }

    public void ej(boolean z) {
        this.cmV = z;
    }

    public void ek(boolean z) {
        this.cmU = z;
    }

    public View getView() {
        return this.azA;
    }
}
