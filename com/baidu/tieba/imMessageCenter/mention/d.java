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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private View IZ;
    private NoNetworkView bYY;
    private com.baidu.tbadk.mvc.g.a dco;
    private AtMessageActivity eNX;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eOe;
    private BdListView eOf;
    private NavigationBar eOg;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eNX = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View XJ() {
        this.rootView = this.eNX.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.eNX.setContentView(this.rootView);
        this.eOf = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eOg = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eOg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eOg.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.eOg.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eNX.getPageContext());
        this.mPullView.setTag(this.eNX.getUniqueId());
        this.mPullView.a(this.eNX);
        this.dco = new com.baidu.tbadk.mvc.g.a(this.eNX);
        this.dco.sv();
        this.IZ = new TextView(this.eNX.getPageContext().getPageActivity());
        this.IZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.eNX.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        this.eOf.setPullRefresh(this.mPullView);
        this.eOf.addHeaderView(this.IZ, 0);
        this.eOf.setNextPage(this.dco);
        this.eOf.setDividerHeight(0);
        this.bYY = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.bYY.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bYY.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bq(boolean z) {
                d.this.hU(z);
            }
        });
        this.eOf.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eNX.WT();
            }
        });
        this.eOe = new com.baidu.tbadk.mvc.f.d<>(this.eNX.getPageContext(), a.class, d.h.mention_atme_item, this.eNX.Nf());
        this.eOe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eNX.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gn(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eOf.setAdapter((ListAdapter) this.eOe);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eOe != null) {
                this.eOe.L(fVar.aMb());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eOe != null) {
            this.eOe.b(tbPageContext, i);
        }
        if (this.dco != null) {
            this.dco.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
        this.eOg.onChangeSkinType(tbPageContext, i);
    }

    public void aLT() {
        if (this.eOf != null) {
            this.eOf.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hU(boolean z) {
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        if (z && this.eOf != null && this.eOf.getWrappedAdapter() != null && this.eOf.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eOf.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.dco != null) {
                if (aVar.MZ()) {
                    this.dco.ti();
                    if (aVar.MX()) {
                        this.dco.ig(d.j.loading);
                    } else if (aVar.MY()) {
                        this.dco.ig(d.j.loading);
                    } else {
                        this.dco.ih(d.j.no_more_msg);
                    }
                } else {
                    this.dco.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aLU();
            } else {
                aLT();
            }
        }
    }

    public void aLU() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.eOf != null) {
            this.eOf.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eNX);
        }
    }
}
