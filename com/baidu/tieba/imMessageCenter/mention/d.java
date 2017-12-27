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
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private View IZ;
    private NoNetworkView bYJ;
    private com.baidu.tbadk.mvc.g.a cXp;
    private AtMessageActivity eMc;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eMj;
    private BdListView eMk;
    private NavigationBar eMl;
    protected com.baidu.tbadk.core.view.j mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eMc = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View XT() {
        this.rootView = this.eMc.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.eMc.setContentView(this.rootView);
        this.eMk = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eMl = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eMl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eMl.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.eMl.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.j(this.eMc.getPageContext());
        this.mPullView.setTag(this.eMc.getUniqueId());
        this.mPullView.a(this.eMc);
        this.cXp = new com.baidu.tbadk.mvc.g.a(this.eMc);
        this.cXp.su();
        this.IZ = new TextView(this.eMc.getPageContext().getPageActivity());
        this.IZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.eMc.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        this.eMk.setPullRefresh(this.mPullView);
        this.eMk.addHeaderView(this.IZ, 0);
        this.eMk.setNextPage(this.cXp);
        this.eMk.setDividerHeight(0);
        this.bYJ = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.bYJ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bYJ.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bp(boolean z) {
                d.this.hP(z);
            }
        });
        this.eMk.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eMc.Xd();
            }
        });
        this.eMj = new com.baidu.tbadk.mvc.f.d<>(this.eMc.getPageContext(), a.class, d.h.mention_atme_item, this.eMc.Np());
        this.eMj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eMc.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eMk.setAdapter((ListAdapter) this.eMj);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eMj != null) {
                this.eMj.N(fVar.aLR());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eMj != null) {
            this.eMj.b(tbPageContext, i);
        }
        if (this.cXp != null) {
            this.cXp.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gy(i);
        }
        this.eMl.onChangeSkinType(tbPageContext, i);
    }

    public void aLJ() {
        if (this.eMk != null) {
            this.eMk.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hP(boolean z) {
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        if (z && this.eMk != null && this.eMk.getWrappedAdapter() != null && this.eMk.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eMk.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cXp != null) {
                if (aVar.Nj()) {
                    this.cXp.th();
                    if (aVar.Nh()) {
                        this.cXp.ik(d.j.loading);
                    } else if (aVar.Ni()) {
                        this.cXp.ik(d.j.loading);
                    } else {
                        this.cXp.il(d.j.no_more_msg);
                    }
                } else {
                    this.cXp.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aLK();
            } else {
                aLJ();
            }
        }
    }

    public void aLK() {
        if (this.mPullView != null) {
            this.mPullView.a((i.b) null);
        }
        if (this.eMk != null) {
            this.eMk.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eMc);
        }
    }
}
