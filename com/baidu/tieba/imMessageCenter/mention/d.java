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
    private View IY;
    private NoNetworkView cbj;
    private com.baidu.tbadk.mvc.g.a dfc;
    private AtMessageActivity eSg;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eSn;
    private BdListView eSo;
    private NavigationBar eSp;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eSg = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View YO() {
        this.rootView = this.eSg.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.eSg.setContentView(this.rootView);
        this.eSo = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eSp = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eSp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSp.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.eSp.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eSg.getPageContext());
        this.mPullView.setTag(this.eSg.getUniqueId());
        this.mPullView.a(this.eSg);
        this.dfc = new com.baidu.tbadk.mvc.g.a(this.eSg);
        this.dfc.st();
        this.IY = new TextView(this.eSg.getPageContext().getPageActivity());
        this.IY.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(this.eSg.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        this.eSo.setPullRefresh(this.mPullView);
        this.eSo.addHeaderView(this.IY, 0);
        this.eSo.setNextPage(this.dfc);
        this.eSo.setDividerHeight(0);
        this.cbj = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.cbj.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cbj.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                d.this.m16if(z);
            }
        });
        this.eSo.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eSg.awQ();
            }
        });
        this.eSn = new com.baidu.tbadk.mvc.f.d<>(this.eSg.getPageContext(), a.class, d.h.mention_atme_item, this.eSg.NL());
        this.eSn.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eSg.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eSo.setAdapter((ListAdapter) this.eSn);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eSn != null) {
                this.eSn.N(fVar.aNF());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eSn != null) {
            this.eSn.b(tbPageContext, i);
        }
        if (this.dfc != null) {
            this.dfc.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        this.eSp.onChangeSkinType(tbPageContext, i);
    }

    public void aNu() {
        if (this.eSo != null) {
            this.eSo.completePullRefreshPostDelayed(2000L);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m16if(boolean z) {
        BdListViewHelper.a(this.IY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        if (z && this.eSo != null && this.eSo.getWrappedAdapter() != null && this.eSo.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eSo.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.dfc != null) {
                if (aVar.NF()) {
                    this.dfc.th();
                    if (aVar.ND()) {
                        this.dfc.id(d.j.loading);
                    } else if (aVar.NE()) {
                        this.dfc.id(d.j.loading);
                    } else {
                        this.dfc.ie(d.j.no_more_msg);
                    }
                } else {
                    this.dfc.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aNv();
            } else {
                aNu();
            }
        }
    }

    public void aNv() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.eSo != null) {
            this.eSo.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eSg);
        }
    }
}
