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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private View amO;
    private NoNetworkView blu;
    private com.baidu.tbadk.mvc.g.a ciI;
    private AtMessageActivity dZV;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eac;
    private BdListView ead;
    private NavigationBar eae;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dZV = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Qv() {
        this.rootView = this.dZV.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.dZV.setContentView(this.rootView);
        this.ead = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eae = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eae.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eae.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.eae.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.dZV.getPageContext());
        this.mPullView.setTag(this.dZV.getUniqueId());
        this.mPullView.a(this.dZV);
        this.ciI = new com.baidu.tbadk.mvc.g.a(this.dZV);
        this.ciI.kX();
        this.amO = new TextView(this.dZV.getPageContext().getPageActivity());
        this.amO.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dZV.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amO, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.ead.setPullRefresh(this.mPullView);
        this.ead.addHeaderView(this.amO, 0);
        this.ead.setNextPage(this.ciI);
        this.ead.setDividerHeight(0);
        this.blu = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.blu.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.blu.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                d.this.hq(z);
            }
        });
        this.ead.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dZV.PF();
            }
        });
        this.eac = new com.baidu.tbadk.mvc.f.d<>(this.dZV.getPageContext(), a.class, d.h.mention_atme_item, this.dZV.FQ());
        this.eac.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dZV.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.ead.setAdapter((ListAdapter) this.eac);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eac != null) {
                this.eac.E(fVar.aEP());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eac != null) {
            this.eac.b(tbPageContext, i);
        }
        if (this.ciI != null) {
            this.ciI.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        this.eae.onChangeSkinType(tbPageContext, i);
    }

    public void aEH() {
        if (this.ead != null) {
            this.ead.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hq(boolean z) {
        BdListViewHelper.a(this.amO, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.ead != null && this.ead.getWrappedAdapter() != null && this.ead.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ead.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.ciI != null) {
                if (aVar.FK()) {
                    this.ciI.lE();
                    if (aVar.FI()) {
                        this.ciI.fl(d.j.loading);
                    } else if (aVar.FJ()) {
                        this.ciI.fl(d.j.loading);
                    } else {
                        this.ciI.fm(d.j.no_more_msg);
                    }
                } else {
                    this.ciI.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aEI();
            } else {
                aEH();
            }
        }
    }

    public void aEI() {
        if (this.mPullView != null) {
            this.mPullView.a((h.b) null);
        }
        if (this.ead != null) {
            this.ead.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dZV);
        }
    }
}
