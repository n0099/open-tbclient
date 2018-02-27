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
    private View IS;
    private NoNetworkView caX;
    private com.baidu.tbadk.mvc.g.a deQ;
    private AtMessageActivity eRU;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eSb;
    private BdListView eSc;
    private NavigationBar eSd;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eRU = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View YN() {
        this.rootView = this.eRU.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.eRU.setContentView(this.rootView);
        this.eSc = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eSd = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eSd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSd.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.eSd.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eRU.getPageContext());
        this.mPullView.setTag(this.eRU.getUniqueId());
        this.mPullView.a(this.eRU);
        this.deQ = new com.baidu.tbadk.mvc.g.a(this.eRU);
        this.deQ.st();
        this.IS = new TextView(this.eRU.getPageContext().getPageActivity());
        this.IS.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(this.eRU.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IS, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        this.eSc.setPullRefresh(this.mPullView);
        this.eSc.addHeaderView(this.IS, 0);
        this.eSc.setNextPage(this.deQ);
        this.eSc.setDividerHeight(0);
        this.caX = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.caX.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.caX.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                d.this.m16if(z);
            }
        });
        this.eSc.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eRU.awP();
            }
        });
        this.eSb = new com.baidu.tbadk.mvc.f.d<>(this.eRU.getPageContext(), a.class, d.h.mention_atme_item, this.eRU.NK());
        this.eSb.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eRU.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eSc.setAdapter((ListAdapter) this.eSb);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eSb != null) {
                this.eSb.N(fVar.aNE());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eSb != null) {
            this.eSb.b(tbPageContext, i);
        }
        if (this.deQ != null) {
            this.deQ.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        this.eSd.onChangeSkinType(tbPageContext, i);
    }

    public void aNt() {
        if (this.eSc != null) {
            this.eSc.completePullRefreshPostDelayed(2000L);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m16if(boolean z) {
        BdListViewHelper.a(this.IS, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        if (z && this.eSc != null && this.eSc.getWrappedAdapter() != null && this.eSc.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eSc.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.deQ != null) {
                if (aVar.NE()) {
                    this.deQ.th();
                    if (aVar.NC()) {
                        this.deQ.id(d.j.loading);
                    } else if (aVar.ND()) {
                        this.deQ.id(d.j.loading);
                    } else {
                        this.deQ.ie(d.j.no_more_msg);
                    }
                } else {
                    this.deQ.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aNu();
            } else {
                aNt();
            }
        }
    }

    public void aNu() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.eSc != null) {
            this.eSc.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eRU);
        }
    }
}
