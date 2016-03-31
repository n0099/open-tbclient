package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class w extends com.baidu.adp.base.f<be> implements s.b, com.baidu.tbadk.mvc.f.a.a {
    protected View aAh;
    protected BdListView aWV;
    private com.baidu.tbadk.mvc.h.a aWX;
    protected be cxj;
    private boolean cxw;
    private boolean cxx;
    protected com.baidu.tbadk.core.view.u mPullView;

    public w(be beVar) {
        super(com.baidu.adp.base.l.s(beVar.getPageContext().getPageActivity()));
        this.cxw = true;
        this.cxx = false;
        this.cxj = beVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.FQ()) {
                this.aWX.op();
                if (aVar.FO()) {
                    this.aWX.eZ(t.j.loading);
                } else if (aVar.FP()) {
                    this.aWX.eZ(t.j.loading);
                } else {
                    this.aWX.fa(t.j.no_more_msg);
                }
            } else {
                this.aWX.hide();
            }
            if (aVar.isPullRefreshing()) {
                akX();
            } else {
                akY();
            }
        }
    }

    public void akX() {
        if (this.mPullView != null) {
            this.mPullView.a((s.b) null);
        }
        if (this.aWV != null) {
            this.aWV.nk();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void akY() {
        if (this.aWV != null) {
            this.aWV.nj();
        }
    }

    @Override // com.baidu.tbadk.core.view.s.b
    public void b(View view, boolean z) {
        if (this instanceof k) {
            this.cxj.als().ce(z);
        } else if (this instanceof j) {
            this.cxj.alr().ce(z);
        } else {
            this.cxj.alq().ce(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        akY();
        if (this.aWX != null) {
            this.aWX.fa(t.j.no_more_msg);
        }
    }

    protected View oT() {
        this.aAh = this.cxj.getActivity().getLayoutInflater().inflate(t.h.mvc_template_list, (ViewGroup) null);
        this.aWV = (BdListView) this.cxj.getActivity().findViewById(t.g.view_list);
        return this.aAh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oJ() {
        this.mPullView = new com.baidu.tbadk.core.view.u(this.cxj.getPageContext());
        this.mPullView.setTag(this.cxj.getUniqueId());
        this.mPullView.a(this);
        this.aWX = new com.baidu.tbadk.mvc.h.a(this.cxj.getBaseFragmentActivity());
        this.aWX.mZ();
        if (this.aWV != null) {
            this.aWV.setDividerHeight(0);
            this.aWV.setExOnSrollToBottomListener(new x(this));
            this.aWV.setPullRefresh(this.mPullView);
            this.aWV.setNextPage(this.aWX);
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (this.aWX != null) {
            this.aWX.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dj(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Bundle bundle) {
    }

    public void onPrimary() {
        if (this.cxw || this.cxx) {
            this.cxw = false;
            this.cxx = false;
            if (this instanceof k) {
                this.cxj.als().ce(false);
            } else if (this instanceof j) {
                this.cxj.alr().oK();
            } else {
                this.cxj.alq().oK();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void bF(boolean z) {
        if (z && this.aWV != null && this.aWV.getWrappedAdapter() != null && this.aWV.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.hx().post(new y(this));
        }
    }

    public void FT() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void FU() {
    }

    public void eF(boolean z) {
        this.cxx = z;
    }

    public void eG(boolean z) {
        this.cxw = z;
    }

    public View getView() {
        return this.aAh;
    }
}
