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
public abstract class w extends com.baidu.adp.base.f<bf> implements t.c, com.baidu.tbadk.mvc.f.a.a {
    protected BdListView aSP;
    private com.baidu.tbadk.mvc.h.a aSR;
    protected View aYK;
    protected View acg;
    protected View awk;
    protected bf cyh;
    private boolean cyu;
    private boolean cyv;
    protected int cyw;
    protected com.baidu.tbadk.core.view.w mPullView;
    private int mSkinType;

    public w(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.cyu = true;
        this.cyv = false;
        this.cyh = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.aSR != null) {
                if (aVar.DJ()) {
                    this.aSR.kC();
                    if (aVar.DH()) {
                        this.aSR.eE(t.j.loading);
                    } else if (aVar.DI()) {
                        this.aSR.eE(t.j.loading);
                    } else {
                        this.aSR.eF(t.j.no_more_msg);
                    }
                } else {
                    this.aSR.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                alf();
            } else {
                alg();
            }
        }
    }

    public void alf() {
        if (this.mPullView != null) {
            this.mPullView.a((t.c) null);
        }
        if (this.aSP != null) {
            this.aSP.jy();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void alg() {
        if (this.aSP != null) {
            this.aSP.k(2000L);
        }
    }

    @Override // com.baidu.tbadk.core.view.t.c
    public void b(View view, boolean z) {
        if (this instanceof k) {
            this.cyh.alC().ck(z);
        } else if (this instanceof j) {
            this.cyh.alB().ck(z);
        } else {
            this.cyh.alA().ck(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        alg();
        if (this.aSR != null) {
            this.aSR.eF(t.j.no_more_msg);
        }
    }

    protected View lg() {
        this.awk = this.cyh.getActivity().getLayoutInflater().inflate(t.h.mvc_template_list, (ViewGroup) null);
        this.aSP = (BdListView) this.cyh.getActivity().findViewById(t.g.view_list);
        return this.awk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kW() {
        this.mPullView = new com.baidu.tbadk.core.view.w(this.cyh.getPageContext());
        this.mPullView.setTag(this.cyh.getUniqueId());
        this.mPullView.a(this);
        this.aSR = new com.baidu.tbadk.mvc.h.a(this.cyh.getBaseFragmentActivity());
        this.aSR.jn();
        if (this.aSP != null) {
            this.aSP.setDividerHeight(0);
            this.aSP.setExOnSrollToBottomListener(new x(this));
            this.aSP.setPullRefresh(this.mPullView);
            this.aYK = new View(this.cyh.getActivity());
            this.aYK.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.cyh.getActivity(), t.e.ds140)));
            this.aSP.setNextPage(this.aSR);
            if (TbadkCoreApplication.m11getInst().getSkinType() != 2) {
                this.aSP.addFooterView(this.aYK, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void alh() {
        if (this.aSP != null) {
            this.acg = BdListViewHelper.a(this.cyh.getActivity(), this.aSP, BdListViewHelper.HeadType.HASTAB);
            if (this.cyw > 0) {
                jZ(this.cyw);
            }
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.aSP != null) {
            if (i == 2) {
                this.aSP.removeFooterView(this.aYK);
            } else if (this.aSP.getFooterViewsCount() < 2) {
                this.aSP.addFooterView(this.aYK);
            }
        }
        this.mSkinType = i;
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (this.aSR != null) {
            this.aSR.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cR(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Bundle bundle) {
    }

    public void onPrimary() {
        if (this.cyu || this.cyv) {
            this.cyu = false;
            this.cyv = false;
            if (this instanceof k) {
                this.cyh.alC().ck(false);
            } else if (this instanceof j) {
                this.cyh.alB().kX();
            } else {
                this.cyh.alA().kX();
            }
        }
    }

    public void bL(boolean z) {
        if (z && this.aSP != null && this.aSP.getWrappedAdapter() != null && this.aSP.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.dL().post(new y(this));
        }
    }

    public void DM() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void DN() {
    }

    public void fh(boolean z) {
        this.cyv = z;
    }

    public void fi(boolean z) {
        this.cyu = z;
    }

    public View getView() {
        return this.awk;
    }

    public void jZ(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.cyw = i;
        if (this.acg != null && (layoutParams = this.acg.getLayoutParams()) != null && layoutParams.height != i) {
            layoutParams.height = i;
            this.acg.setLayoutParams(layoutParams);
        }
    }
}
