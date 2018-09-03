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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView bvB;
    private com.baidu.tbadk.mvc.g.a cGO;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eGF;
    private BdListView eGG;
    private NavigationBar eGH;
    private AtMessageActivity eGy;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eGy = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Vq() {
        this.rootView = this.eGy.getActivity().getLayoutInflater().inflate(f.h.at_me_activity, (ViewGroup) null);
        this.eGy.setContentView(this.rootView);
        this.eGG = (BdListView) this.rootView.findViewById(f.g.atme_lv);
        this.eGH = (NavigationBar) this.rootView.findViewById(f.g.view_navigation_bar);
        this.eGH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eGH.setCenterTextTitle(getPageContext().getString(f.j.at_me));
        this.eGH.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.eGy.getPageContext());
        this.mPullView.setTag(this.eGy.getUniqueId());
        this.mPullView.a(this.eGy);
        this.cGO = new com.baidu.tbadk.mvc.g.a(this.eGy);
        this.cGO.np();
        this.mHeaderView = new TextView(this.eGy.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eGy.getPageContext().getPageActivity(), f.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jE());
        this.eGG.setPullRefresh(this.mPullView);
        this.eGG.addHeaderView(this.mHeaderView, 0);
        this.eGG.setNextPage(this.cGO);
        this.eGG.setDividerHeight(0);
        this.bvB = (NoNetworkView) this.rootView.findViewById(f.g.no_networkview);
        this.bvB.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bvB.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aR(boolean z) {
                d.this.ib(z);
            }
        });
        this.eGG.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eGy.aws();
            }
        });
        this.eGF = new com.baidu.tbadk.mvc.f.d<>(this.eGy.getPageContext(), a.class, f.h.mention_atme_item, this.eGy.Kk());
        this.eGF.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eGy.getResources().getDimension(f.e.ds80)), NoDataViewFactory.d.dt(f.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eGG.setAdapter((ListAdapter) this.eGF);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eGF != null) {
                this.eGF.I(fVar.aPe());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eGF != null) {
            this.eGF.b(tbPageContext, i);
        }
        if (this.cGO != null) {
            this.cGO.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        this.eGH.onChangeSkinType(tbPageContext, i);
    }

    public void aOK() {
        if (this.eGG != null) {
            this.eGG.completePullRefreshPostDelayed(2000L);
        }
    }

    public void ib(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jE());
        if (z && this.eGG != null && this.eGG.getWrappedAdapter() != null && this.eGG.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eGG.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cGO != null) {
                if (aVar.Ke()) {
                    this.cGO.oC();
                    if (aVar.Kc()) {
                        this.cGO.fi(f.j.loading);
                    } else if (aVar.Kd()) {
                        this.cGO.fi(f.j.loading);
                    } else {
                        this.cGO.fj(f.j.no_more_msg);
                    }
                } else {
                    this.cGO.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aOL();
            } else {
                aOK();
            }
        }
    }

    public void aOL() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.eGG != null) {
            this.eGG.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eGy);
        }
    }
}
