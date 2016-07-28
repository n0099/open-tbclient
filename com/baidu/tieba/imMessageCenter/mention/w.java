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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public abstract class w extends com.baidu.adp.base.f<bf> implements t.c, com.baidu.tbadk.mvc.f.a.a {
    protected BdListView aXi;
    private com.baidu.tbadk.mvc.h.a aXk;
    protected View adl;
    protected View axO;
    protected View bwQ;
    private boolean dgN;
    private boolean dgO;
    protected int dgP;
    protected bf dgz;
    protected com.baidu.tbadk.core.view.w mPullView;
    private int mSkinType;

    public w(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.dgN = true;
        this.dgO = false;
        this.dgz = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.aXk != null) {
                if (aVar.DR()) {
                    this.aXk.kB();
                    if (aVar.DP()) {
                        this.aXk.eJ(u.j.loading);
                    } else if (aVar.DQ()) {
                        this.aXk.eJ(u.j.loading);
                    } else {
                        this.aXk.eK(u.j.no_more_msg);
                    }
                } else {
                    this.aXk.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aue();
            } else {
                auf();
            }
        }
    }

    public void aue() {
        if (this.mPullView != null) {
            this.mPullView.a((t.c) null);
        }
        if (this.aXi != null) {
            this.aXi.jA();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void auf() {
        if (this.aXi != null) {
            this.aXi.l(2000L);
        }
    }

    @Override // com.baidu.tbadk.core.view.t.c
    public void b(View view, boolean z) {
        if (this instanceof k) {
            this.dgz.auB().co(z);
        } else if (this instanceof j) {
            this.dgz.auA().co(z);
        } else {
            this.dgz.auz().co(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        auf();
        if (this.aXk != null) {
            this.aXk.eK(u.j.no_more_msg);
        }
    }

    protected View lg() {
        this.axO = this.dgz.getActivity().getLayoutInflater().inflate(u.h.mvc_template_list, (ViewGroup) null);
        this.aXi = (BdListView) this.dgz.getActivity().findViewById(u.g.view_list);
        return this.axO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kV() {
        this.mPullView = new com.baidu.tbadk.core.view.w(this.dgz.getPageContext());
        this.mPullView.setTag(this.dgz.getUniqueId());
        this.mPullView.a(this);
        this.aXk = new com.baidu.tbadk.mvc.h.a(this.dgz.getBaseFragmentActivity());
        this.aXk.jp();
        if (this.aXi != null) {
            this.aXi.setDividerHeight(0);
            this.aXi.setExOnSrollToBottomListener(new x(this));
            this.aXi.setPullRefresh(this.mPullView);
            this.bwQ = new View(this.dgz.getActivity());
            this.bwQ.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.dgz.getActivity(), u.e.ds140)));
            this.aXi.setNextPage(this.aXk);
            if (TbadkCoreApplication.m10getInst().getSkinType() != 2) {
                this.aXi.addFooterView(this.bwQ, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aug() {
        if (this.aXi != null) {
            this.adl = BdListViewHelper.a(this.dgz.getActivity(), this.aXi, BdListViewHelper.HeadType.HASTAB);
            if (this.dgP > 0) {
                lH(this.dgP);
            }
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.aXi != null) {
            if (i == 2) {
                this.aXi.removeFooterView(this.bwQ);
            } else if (this.aXi.getFooterViewsCount() < 2) {
                this.aXi.addFooterView(this.bwQ);
            }
        }
        this.mSkinType = i;
        com.baidu.tbadk.j.a.a(tbPageContext, getView());
        if (this.aXk != null) {
            this.aXk.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cT(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Bundle bundle) {
    }

    public void onPrimary() {
        if (this.dgN || this.dgO) {
            this.dgN = false;
            this.dgO = false;
            if (this instanceof k) {
                this.dgz.auB().co(false);
            } else if (this instanceof j) {
                this.dgz.auA().kX();
            } else {
                this.dgz.auz().kX();
            }
        }
    }

    public void bN(boolean z) {
        if (z && this.aXi != null && this.aXi.getWrappedAdapter() != null && this.aXi.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.dL().post(new y(this));
        }
    }

    public void DU() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void DV() {
    }

    public void fY(boolean z) {
        this.dgO = z;
    }

    public void fZ(boolean z) {
        this.dgN = z;
    }

    public View getView() {
        return this.axO;
    }

    public void lH(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.dgP = i;
        if (this.adl != null && (layoutParams = this.adl.getLayoutParams()) != null && layoutParams.height != i) {
            layoutParams.height = i;
            this.adl.setLayoutParams(layoutParams);
        }
    }
}
