package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.t;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public abstract class w extends com.baidu.adp.base.f<bf> implements t.b, com.baidu.tbadk.mvc.f.a.a {
    protected View aAV;
    protected View aga;
    protected View bIe;
    protected BdListView bdb;
    private com.baidu.tbadk.mvc.h.a bdd;
    protected bf dsf;
    private boolean dst;
    private boolean dsu;
    protected int dsv;
    protected com.baidu.tbadk.core.view.w mPullView;
    private int mSkinType;

    public w(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.dst = true;
        this.dsu = false;
        this.dsf = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bdd != null) {
                if (aVar.Fl()) {
                    this.bdd.lw();
                    if (aVar.Fj()) {
                        this.bdd.eX(t.j.loading);
                    } else if (aVar.Fk()) {
                        this.bdd.eX(t.j.loading);
                    } else {
                        this.bdd.eY(t.j.no_more_msg);
                    }
                } else {
                    this.bdd.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                ayS();
            } else {
                ayT();
            }
        }
    }

    public void ayS() {
        if (this.mPullView != null) {
            this.mPullView.a((t.b) null);
        }
        if (this.bdb != null) {
            this.bdb.kv();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void ayT() {
        if (this.bdb != null) {
            this.bdb.l(2000L);
        }
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aI(boolean z) {
        if (this instanceof k) {
            this.dsf.azo().cu(z);
        } else if (this instanceof j) {
            this.dsf.azn().cu(z);
        } else {
            this.dsf.azm().cu(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        ayT();
        if (this.bdd != null) {
            this.bdd.eY(t.j.no_more_msg);
        }
    }

    protected View mb() {
        this.aAV = this.dsf.getActivity().getLayoutInflater().inflate(t.h.mvc_template_list, (ViewGroup) null);
        this.bdb = (BdListView) this.dsf.getActivity().findViewById(t.g.view_list);
        return this.aAV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lQ() {
        this.mPullView = new com.baidu.tbadk.core.view.w(this.dsf.getPageContext());
        this.mPullView.setTag(this.dsf.getUniqueId());
        this.mPullView.a(this);
        this.bdd = new com.baidu.tbadk.mvc.h.a(this.dsf.getBaseFragmentActivity());
        this.bdd.kk();
        if (this.bdb != null) {
            this.bdb.setDividerHeight(0);
            this.bdb.setExOnSrollToBottomListener(new x(this));
            this.bdb.setPullRefresh(this.mPullView);
            this.bIe = new View(this.dsf.getActivity());
            this.bIe.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.dsf.getActivity(), t.e.ds140)));
            this.bdb.setNextPage(this.bdd);
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bdb.addFooterView(this.bIe, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayU() {
        if (this.bdb != null) {
            this.aga = BdListViewHelper.a(this.dsf.getActivity(), this.bdb, BdListViewHelper.HeadType.HASTAB);
            if (this.dsv > 0) {
                mk(this.dsv);
            }
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bdb != null) {
            if (i == 2) {
                this.bdb.removeFooterView(this.bIe);
            } else if (this.bdb.getFooterViewsCount() < 2) {
                this.bdb.addFooterView(this.bIe);
            }
        }
        this.mSkinType = i;
        com.baidu.tbadk.j.a.a(tbPageContext, getView());
        if (this.bdd != null) {
            this.bdd.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Bundle bundle) {
    }

    public void onPrimary() {
        if (this.dst || this.dsu) {
            this.dst = false;
            this.dsu = false;
            if (this instanceof k) {
                this.dsf.azo().cu(false);
            } else if (this instanceof j) {
                this.dsf.azn().lS();
            } else {
                this.dsf.azm().lS();
            }
        }
    }

    public void bP(boolean z) {
        if (z && this.bdb != null && this.bdb.getWrappedAdapter() != null && this.bdb.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.eG().post(new y(this));
        }
    }

    public void Fo() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void Fp() {
    }

    public void gu(boolean z) {
        this.dsu = z;
    }

    public void gv(boolean z) {
        this.dst = z;
    }

    public View getView() {
        return this.aAV;
    }

    public void mk(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.dsv = i;
        if (this.aga != null && (layoutParams = this.aga.getLayoutParams()) != null && layoutParams.height != i) {
            layoutParams.height = i;
            this.aga.setLayoutParams(layoutParams);
        }
    }
}
