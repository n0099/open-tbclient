package com.baidu.tieba.imMessageCenter.mention;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public abstract class w extends com.baidu.adp.base.f<bf> implements y.b, com.baidu.tbadk.mvc.f.a.a {
    protected View aAy;
    protected View agA;
    protected View bIg;
    protected BdListView bdv;
    private com.baidu.tbadk.mvc.h.a bdx;
    protected bf dtC;
    private boolean dtQ;
    private boolean dtR;
    protected int dtS;
    protected com.baidu.tbadk.core.view.ab mPullView;
    private int mSkinType;

    public w(bf bfVar) {
        super(com.baidu.adp.base.l.C(bfVar.getPageContext().getPageActivity()));
        this.dtQ = true;
        this.dtR = false;
        this.dtC = bfVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bdx != null) {
                if (aVar.Fk()) {
                    this.bdx.lw();
                    if (aVar.Fi()) {
                        this.bdx.eW(r.j.loading);
                    } else if (aVar.Fj()) {
                        this.bdx.eW(r.j.loading);
                    } else {
                        this.bdx.eX(r.j.no_more_msg);
                    }
                } else {
                    this.bdx.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                azq();
            } else {
                azr();
            }
        }
    }

    public void azq() {
        if (this.mPullView != null) {
            this.mPullView.a((y.b) null);
        }
        if (this.bdv != null) {
            this.bdv.kv();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this);
        }
    }

    public void azr() {
        if (this.bdv != null) {
            this.bdv.l(2000L);
        }
    }

    @Override // com.baidu.tbadk.core.view.y.b
    public void aI(boolean z) {
        if (this instanceof k) {
            this.dtC.azM().cv(z);
        } else if (this instanceof j) {
            this.dtC.azL().cv(z);
        } else {
            this.dtC.azK().cv(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        azr();
        if (this.bdx != null) {
            this.bdx.eX(r.j.no_more_msg);
        }
    }

    protected View mb() {
        this.aAy = this.dtC.getActivity().getLayoutInflater().inflate(r.h.mvc_template_list, (ViewGroup) null);
        this.bdv = (BdListView) this.dtC.getActivity().findViewById(r.g.view_list);
        return this.aAy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lQ() {
        this.mPullView = new com.baidu.tbadk.core.view.ab(this.dtC.getPageContext());
        this.mPullView.setTag(this.dtC.getUniqueId());
        this.mPullView.a(this);
        this.bdx = new com.baidu.tbadk.mvc.h.a(this.dtC.getBaseFragmentActivity());
        this.bdx.kk();
        if (this.bdv != null) {
            this.bdv.setDividerHeight(0);
            this.bdv.setExOnSrollToBottomListener(new x(this));
            this.bdv.setPullRefresh(this.mPullView);
            this.bIg = new View(this.dtC.getActivity());
            this.bIg.setLayoutParams(new AbsListView.LayoutParams(-1, com.baidu.adp.lib.util.k.e(this.dtC.getActivity(), r.e.ds140)));
            this.bdv.setNextPage(this.bdx);
            if (TbadkCoreApplication.m9getInst().getSkinType() != 2) {
                this.bdv.addFooterView(this.bIg, null, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azs() {
        if (this.bdv != null) {
            this.agA = BdListViewHelper.a(this.dtC.getActivity(), this.bdv, BdListViewHelper.HeadType.HASTAB);
            if (this.dtS > 0) {
                ms(this.dtS);
            }
        }
    }

    public boolean a(TbPageContext<?> tbPageContext, int i) {
        if (this.bdv != null) {
            if (i == 2) {
                this.bdv.removeFooterView(this.bIg);
            } else if (this.bdv.getFooterViewsCount() < 2) {
                this.bdv.addFooterView(this.bIg);
            }
        }
        this.mSkinType = i;
        com.baidu.tbadk.i.a.a(tbPageContext, getView());
        if (this.bdx != null) {
            this.bdx.a(tbPageContext, i);
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
        if (this.dtQ || this.dtR) {
            this.dtQ = false;
            this.dtR = false;
            if (this instanceof k) {
                this.dtC.azM().cv(false);
            } else if (this instanceof j) {
                this.dtC.azL().lS();
            } else {
                this.dtC.azK().lS();
            }
        }
    }

    public void bO(boolean z) {
        if (z && this.bdv != null && this.bdv.getWrappedAdapter() != null && this.bdv.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.eG().post(new y(this));
        }
    }

    public void Fn() {
    }

    @Override // com.baidu.tbadk.mvc.f.a.a
    public void Fo() {
    }

    public void gx(boolean z) {
        this.dtR = z;
    }

    public void gy(boolean z) {
        this.dtQ = z;
    }

    public View getView() {
        return this.aAy;
    }

    public void ms(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.dtS = i;
        if (this.agA != null && (layoutParams = this.agA.getLayoutParams()) != null && layoutParams.height != i) {
            layoutParams.height = i;
            this.agA.setLayoutParams(layoutParams);
        }
    }
}
