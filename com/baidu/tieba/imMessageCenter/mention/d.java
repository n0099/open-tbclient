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
    private View amv;
    private com.baidu.tbadk.mvc.g.a bZW;
    private NoNetworkView bgM;
    private AtMessageActivity dRc;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dRj;
    private BdListView dRk;
    private NavigationBar dRl;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dRc = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Pl() {
        this.rootView = this.dRc.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.dRc.setContentView(this.rootView);
        this.dRk = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.dRl = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.dRl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dRl.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.dRl.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dRc.getPageContext());
        this.mPullView.setTag(this.dRc.getUniqueId());
        this.mPullView.a(this.dRc);
        this.bZW = new com.baidu.tbadk.mvc.g.a(this.dRc);
        this.bZW.kX();
        this.amv = new TextView(this.dRc.getPageContext().getPageActivity());
        this.amv.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dRc.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amv, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dRk.setPullRefresh(this.mPullView);
        this.dRk.addHeaderView(this.amv, 0);
        this.dRk.setNextPage(this.bZW);
        this.dRk.setDividerHeight(0);
        this.bgM = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.bgM.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bgM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                d.this.gV(z);
            }
        });
        this.dRk.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dRc.Os();
            }
        });
        this.dRj = new com.baidu.tbadk.mvc.f.d<>(this.dRc.getPageContext(), a.class, d.h.mention_atme_item, this.dRc.FI());
        this.dRj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dRc.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dRk.setAdapter((ListAdapter) this.dRj);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dRj != null) {
                this.dRj.D(fVar.aDh());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dRj != null) {
            this.dRj.b(tbPageContext, i);
        }
        if (this.bZW != null) {
            this.bZW.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        this.dRl.onChangeSkinType(tbPageContext, i);
    }

    public void aCZ() {
        if (this.dRk != null) {
            this.dRk.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gV(boolean z) {
        BdListViewHelper.a(this.amv, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dRk != null && this.dRk.getWrappedAdapter() != null && this.dRk.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dRk.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bZW != null) {
                if (aVar.FC()) {
                    this.bZW.lG();
                    if (aVar.FA()) {
                        this.bZW.fm(d.j.loading);
                    } else if (aVar.FB()) {
                        this.bZW.fm(d.j.loading);
                    } else {
                        this.bZW.fn(d.j.no_more_msg);
                    }
                } else {
                    this.bZW.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aDa();
            } else {
                aCZ();
            }
        }
    }

    public void aDa() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dRk != null) {
            this.dRk.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dRc);
        }
    }
}
