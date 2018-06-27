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
    private NoNetworkView buT;
    private com.baidu.tbadk.mvc.g.a cEl;
    private AtMessageActivity eCJ;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eCQ;
    private BdListView eCR;
    private NavigationBar eCS;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eCJ = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Vd() {
        this.rootView = this.eCJ.getActivity().getLayoutInflater().inflate(d.i.at_me_activity, (ViewGroup) null);
        this.eCJ.setContentView(this.rootView);
        this.eCR = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eCS = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eCS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eCS.setCenterTextTitle(getPageContext().getString(d.k.at_me));
        this.eCS.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.eCJ.getPageContext());
        this.mPullView.setTag(this.eCJ.getUniqueId());
        this.mPullView.a(this.eCJ);
        this.cEl = new com.baidu.tbadk.mvc.g.a(this.eCJ);
        this.cEl.nn();
        this.mHeaderView = new TextView(this.eCJ.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.eCJ.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jD());
        this.eCR.setPullRefresh(this.mPullView);
        this.eCR.addHeaderView(this.mHeaderView, 0);
        this.eCR.setNextPage(this.cEl);
        this.eCR.setDividerHeight(0);
        this.buT = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.buT.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.buT.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aS(boolean z) {
                d.this.hY(z);
            }
        });
        this.eCR.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eCJ.avO();
            }
        });
        this.eCQ = new com.baidu.tbadk.mvc.f.d<>(this.eCJ.getPageContext(), a.class, d.i.mention_atme_item, this.eCJ.Kl());
        this.eCQ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eCJ.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.ds(d.k.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eCR.setAdapter((ListAdapter) this.eCQ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eCQ != null) {
                this.eCQ.J(fVar.aOh());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eCQ != null) {
            this.eCQ.b(tbPageContext, i);
        }
        if (this.cEl != null) {
            this.cEl.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        this.eCS.onChangeSkinType(tbPageContext, i);
    }

    public void aNN() {
        if (this.eCR != null) {
            this.eCR.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hY(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jD());
        if (z && this.eCR != null && this.eCR.getWrappedAdapter() != null && this.eCR.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eCR.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cEl != null) {
                if (aVar.Kf()) {
                    this.cEl.oD();
                    if (aVar.Kd()) {
                        this.cEl.fi(d.k.loading);
                    } else if (aVar.Ke()) {
                        this.cEl.fi(d.k.loading);
                    } else {
                        this.cEl.fj(d.k.no_more_msg);
                    }
                } else {
                    this.cEl.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aNO();
            } else {
                aNN();
            }
        }
    }

    public void aNO() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.eCR != null) {
            this.eCR.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eCJ);
        }
    }
}
