package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public abstract class w extends com.baidu.adp.base.f<bd> implements r.b, com.baidu.tbadk.mvc.f.a.a {
    protected BdListView aRc;
    private com.baidu.tbadk.mvc.h.a aRe;
    protected bd cih;
    private boolean ciu;
    private boolean civ;
    protected com.baidu.tbadk.core.view.t mPullView;
    protected View rootView;

    public w(bd bdVar) {
        super(com.baidu.adp.base.l.C(bdVar.getPageContext().getPageActivity()));
        this.ciu = true;
        this.civ = false;
        this.cih = bdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (aVar.DJ()) {
                this.aRe.ob();
                if (aVar.DH()) {
                    this.aRe.ez(n.j.loading);
                } else if (aVar.DI()) {
                    this.aRe.ez(n.j.loading);
                } else {
                    this.aRe.eA(n.j.no_more_msg);
                }
            } else {
                this.aRe.hide();
            }
            if (aVar.isPullRefreshing()) {
                aet();
            } else {
                aeu();
            }
        }
    }

    public void aet() {
        if (this.mPullView != null) {
            this.mPullView.a((r.b) null);
        }
        if (this.aRc != null) {
            this.aRc.nb();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void aeu() {
        if (this.aRc != null) {
            this.aRc.completePullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.view.r.b
    public void a(View view, boolean z) {
        if (this instanceof k) {
            this.cih.aeP().bP(z);
        } else if (this instanceof j) {
            this.cih.aeO().bP(z);
        } else {
            this.cih.aeN().bP(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        aeu();
        if (this.aRe != null) {
            this.aRe.eA(n.j.no_more_msg);
        }
    }

    protected View oE() {
        this.rootView = this.cih.getActivity().getLayoutInflater().inflate(n.h.mvc_template_list, (ViewGroup) null);
        this.aRc = (BdListView) this.cih.getActivity().findViewById(n.g.view_list);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ov() {
        this.mPullView = new com.baidu.tbadk.core.view.t(this.cih.getPageContext());
        this.mPullView.setTag(this.cih.getUniqueId());
        this.mPullView.a(this);
        this.aRe = new com.baidu.tbadk.mvc.h.a(this.cih.getBaseFragmentActivity());
        this.aRe.mT();
        if (this.aRc != null) {
            this.aRc.setDividerHeight(0);
            this.aRc.setExOnSrollToBottomListener(new x(this));
            this.aRc.setPullRefresh(this.mPullView);
            this.aRc.setNextPage(this.aRe);
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (this.aRe != null) {
            this.aRe.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cP(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Bundle bundle) {
    }

    public void onPrimary() {
        if (this.ciu || this.civ) {
            this.ciu = false;
            this.civ = false;
            if (this instanceof k) {
                this.cih.aeP().bP(false);
            } else if (this instanceof j) {
                this.cih.aeO().ow();
            } else {
                this.cih.aeN().ow();
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void by(boolean z) {
        if (z && this.aRc != null && this.aRc.getWrappedAdapter() != null && this.aRc.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.hj().post(new y(this));
        }
    }

    public void DM() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void DN() {
    }

    public void ec(boolean z) {
        this.civ = z;
    }

    public void ed(boolean z) {
        this.ciu = z;
    }

    public View getView() {
        return this.rootView;
    }
}
