package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private View amR;
    private NoNetworkView blt;
    private com.baidu.tbadk.mvc.g.a ciu;
    private AtMessageActivity dYQ;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dYX;
    private BdListView dYY;
    private NavigationBar dYZ;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dYQ = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Qv() {
        this.rootView = this.dYQ.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.dYQ.setContentView(this.rootView);
        this.dYY = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.dYZ = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.dYZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dYZ.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.dYZ.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dYQ.getPageContext());
        this.mPullView.setTag(this.dYQ.getUniqueId());
        this.mPullView.a(this.dYQ);
        this.ciu = new com.baidu.tbadk.mvc.g.a(this.dYQ);
        this.ciu.kX();
        this.amR = new TextView(this.dYQ.getPageContext().getPageActivity());
        this.amR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dYQ.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dYY.setPullRefresh(this.mPullView);
        this.dYY.addHeaderView(this.amR, 0);
        this.dYY.setNextPage(this.ciu);
        this.dYY.setDividerHeight(0);
        this.blt = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.blt.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.blt.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                d.this.hp(z);
            }
        });
        this.dYY.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dYQ.PF();
            }
        });
        this.dYX = new com.baidu.tbadk.mvc.f.d<>(this.dYQ.getPageContext(), a.class, d.h.mention_atme_item, this.dYQ.FP());
        this.dYX.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dYQ.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dYY.setAdapter((ListAdapter) this.dYX);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dYX != null) {
                this.dYX.E(fVar.aEH());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dYX != null) {
            this.dYX.b(tbPageContext, i);
        }
        if (this.ciu != null) {
            this.ciu.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        this.dYZ.onChangeSkinType(tbPageContext, i);
    }

    public void aEz() {
        if (this.dYY != null) {
            this.dYY.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hp(boolean z) {
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dYY != null && this.dYY.getWrappedAdapter() != null && this.dYY.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dYY.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.ciu != null) {
                if (aVar.FJ()) {
                    this.ciu.lE();
                    if (aVar.FH()) {
                        this.ciu.fl(d.j.loading);
                    } else if (aVar.FI()) {
                        this.ciu.fl(d.j.loading);
                    } else {
                        this.ciu.fm(d.j.no_more_msg);
                    }
                } else {
                    this.ciu.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aEA();
            } else {
                aEz();
            }
        }
    }

    public void aEA() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dYY != null) {
            this.dYY.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dYQ);
        }
    }
}
