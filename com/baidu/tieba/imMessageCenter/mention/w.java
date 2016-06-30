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
    protected BdListView aWk;
    private com.baidu.tbadk.mvc.h.a aWm;
    protected View acA;
    protected View axa;
    protected View buC;
    protected bf ddD;
    private boolean ddR;
    private boolean ddS;
    protected int ddT;
    protected com.baidu.tbadk.core.view.w mPullView;
    private int mSkinType;

    public w(bf bfVar) {
        super(com.baidu.adp.base.l.s(bfVar.getPageContext().getPageActivity()));
        this.ddR = true;
        this.ddS = false;
        this.ddD = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.aWm != null) {
                if (aVar.DS()) {
                    this.aWm.kF();
                    if (aVar.DQ()) {
                        this.aWm.eJ(u.j.loading);
                    } else if (aVar.DR()) {
                        this.aWm.eJ(u.j.loading);
                    } else {
                        this.aWm.eK(u.j.no_more_msg);
                    }
                } else {
                    this.aWm.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                ats();
            } else {
                att();
            }
        }
    }

    public void ats() {
        if (this.mPullView != null) {
            this.mPullView.a((t.c) null);
        }
        if (this.aWk != null) {
            this.aWk.jB();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void att() {
        if (this.aWk != null) {
            this.aWk.k(2000L);
        }
    }

    @Override // com.baidu.tbadk.core.view.t.c
    public void b(View view, boolean z) {
        if (this instanceof k) {
            this.ddD.atP().cl(z);
        } else if (this instanceof j) {
            this.ddD.atO().cl(z);
        } else {
            this.ddD.atN().cl(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        att();
        if (this.aWm != null) {
            this.aWm.eK(u.j.no_more_msg);
        }
    }

    protected View lk() {
        this.axa = this.ddD.getActivity().getLayoutInflater().inflate(u.h.mvc_template_list, (ViewGroup) null);
        this.aWk = (BdListView) this.ddD.getActivity().findViewById(u.g.view_list);
        return this.axa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kZ() {
        this.mPullView = new com.baidu.tbadk.core.view.w(this.ddD.getPageContext());
        this.mPullView.setTag(this.ddD.getUniqueId());
        this.mPullView.a(this);
        this.aWm = new com.baidu.tbadk.mvc.h.a(this.ddD.getBaseFragmentActivity());
        this.aWm.jq();
        if (this.aWk != null) {
            this.aWk.setDividerHeight(0);
            this.aWk.setExOnSrollToBottomListener(new x(this));
            this.aWk.setPullRefresh(this.mPullView);
            this.buC = new View(this.ddD.getActivity());
            this.buC.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.c(this.ddD.getActivity(), u.e.ds140)));
            this.aWk.setNextPage(this.aWm);
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.aWk.addFooterView(this.buC, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atu() {
        if (this.aWk != null) {
            this.acA = BdListViewHelper.a(this.ddD.getActivity(), this.aWk, BdListViewHelper.HeadType.HASTAB);
            if (this.ddT > 0) {
                lB(this.ddT);
            }
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.aWk != null) {
            if (i == 2) {
                this.aWk.removeFooterView(this.buC);
            } else if (this.aWk.getFooterViewsCount() < 2) {
                this.aWk.addFooterView(this.buC);
            }
        }
        this.mSkinType = i;
        com.baidu.tbadk.j.a.a(tbPageContext, getView());
        if (this.aWm != null) {
            this.aWm.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.cT(i);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Bundle bundle) {
    }

    public void onPrimary() {
        if (this.ddR || this.ddS) {
            this.ddR = false;
            this.ddS = false;
            if (this instanceof k) {
                this.ddD.atP().cl(false);
            } else if (this instanceof j) {
                this.ddD.atO().lb();
            } else {
                this.ddD.atN().lb();
            }
        }
    }

    public void bK(boolean z) {
        if (z && this.aWk != null && this.aWk.getWrappedAdapter() != null && this.aWk.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.dM().post(new y(this));
        }
    }

    public void DV() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void DW() {
    }

    public void fV(boolean z) {
        this.ddS = z;
    }

    public void fW(boolean z) {
        this.ddR = z;
    }

    public View getView() {
        return this.axa;
    }

    public void lB(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.ddT = i;
        if (this.acA != null && (layoutParams = this.acA.getLayoutParams()) != null && layoutParams.height != i) {
            layoutParams.height = i;
            this.acA.setLayoutParams(layoutParams);
        }
    }
}
