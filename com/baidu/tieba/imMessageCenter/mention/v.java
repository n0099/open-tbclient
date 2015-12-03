package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public abstract class v extends com.baidu.adp.base.f<bc> implements q.b, com.baidu.tbadk.mvc.f.a.a {
    protected BdListView aNj;
    private com.baidu.tbadk.mvc.h.a aNl;
    protected bc ceg;
    private boolean ces;
    private boolean cet;
    protected com.baidu.tbadk.core.view.s mPullView;
    protected View rootView;

    public v(bc bcVar) {
        super(com.baidu.adp.base.l.C(bcVar.getPageContext().getPageActivity()));
        this.ces = true;
        this.cet = false;
        this.ceg = bcVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.DU()) {
                this.aNl.oD();
                if (aVar.DS()) {
                    this.aNl.eF(n.i.loading);
                } else if (aVar.DT()) {
                    this.aNl.eF(n.i.loading);
                } else {
                    this.aNl.eG(n.i.no_more_msg);
                }
            } else {
                this.aNl.hide();
            }
            if (aVar.isPullRefreshing()) {
                adk();
            } else {
                adl();
            }
        }
    }

    public void adk() {
        if (this.mPullView != null) {
            this.mPullView.a((q.b) null);
        }
        if (this.aNj != null) {
            this.aNj.nD();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void adl() {
        if (this.aNj != null) {
            this.aNj.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.view.q.b
    public void a(View view, boolean z) {
        if (this instanceof k) {
            this.ceg.adH().bO(z);
        } else if (this instanceof j) {
            this.ceg.adG().bO(z);
        } else {
            this.ceg.adF().bO(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        adl();
        if (this.aNl != null) {
            this.aNl.eG(n.i.no_more_msg);
        }
    }

    protected View pg() {
        this.rootView = this.ceg.getActivity().getLayoutInflater().inflate(n.g.mvc_template_list, (ViewGroup) null);
        this.aNj = (BdListView) this.ceg.getActivity().findViewById(n.f.view_list);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void oX() {
        this.mPullView = new com.baidu.tbadk.core.view.s(this.ceg.getPageContext());
        this.mPullView.a(this);
        this.aNl = new com.baidu.tbadk.mvc.h.a(this.ceg.getBaseFragmentActivity());
        this.aNl.nv();
        if (this.aNj != null) {
            this.aNj.setDividerHeight(0);
            this.aNj.setExOnSrollToBottomListener(new w(this));
            this.aNj.setPullRefresh(this.mPullView);
            this.aNj.setNextPage(this.aNl);
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (this.aNl != null) {
            this.aNl.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cV(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
    }

    public void onPrimary() {
        if (this.ces || this.cet) {
            this.ces = false;
            this.cet = false;
            if (this instanceof k) {
                this.ceg.adH().bO(false);
            } else if (this instanceof j) {
                this.ceg.adG().oY();
            } else {
                this.ceg.adF().oY();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void by(boolean z) {
        if (z && this.aNj != null && this.aNj.getWrappedAdapter() != null && this.aNj.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.hj().post(new x(this));
        }
    }

    public void DX() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void DY() {
    }

    public void ec(boolean z) {
        this.cet = z;
    }

    public void ed(boolean z) {
        this.ces = z;
    }

    public View getView() {
        return this.rootView;
    }
}
