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
    private View amw;
    private com.baidu.tbadk.mvc.g.a bZJ;
    private NoNetworkView bgD;
    private AtMessageActivity dQX;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dRe;
    private BdListView dRf;
    private NavigationBar dRg;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dQX = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Pa() {
        this.rootView = this.dQX.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.dQX.setContentView(this.rootView);
        this.dRf = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.dRg = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.dRg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dRg.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.dRg.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dQX.getPageContext());
        this.mPullView.setTag(this.dQX.getUniqueId());
        this.mPullView.a(this.dQX);
        this.bZJ = new com.baidu.tbadk.mvc.g.a(this.dQX);
        this.bZJ.kX();
        this.amw = new TextView(this.dQX.getPageContext().getPageActivity());
        this.amw.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dQX.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amw, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dRf.setPullRefresh(this.mPullView);
        this.dRf.addHeaderView(this.amw, 0);
        this.dRf.setNextPage(this.bZJ);
        this.dRf.setDividerHeight(0);
        this.bgD = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.bgD.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bgD.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                d.this.gP(z);
            }
        });
        this.dRf.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dQX.Oh();
            }
        });
        this.dRe = new com.baidu.tbadk.mvc.f.d<>(this.dQX.getPageContext(), a.class, d.h.mention_atme_item, this.dQX.Fw());
        this.dRe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dQX.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dRf.setAdapter((ListAdapter) this.dRe);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dRe != null) {
                this.dRe.D(fVar.aDd());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dRe != null) {
            this.dRe.b(tbPageContext, i);
        }
        if (this.bZJ != null) {
            this.bZJ.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        this.dRg.onChangeSkinType(tbPageContext, i);
    }

    public void aCV() {
        if (this.dRf != null) {
            this.dRf.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gP(boolean z) {
        BdListViewHelper.a(this.amw, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dRf != null && this.dRf.getWrappedAdapter() != null && this.dRf.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dRf.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bZJ != null) {
                if (aVar.Fq()) {
                    this.bZJ.lG();
                    if (aVar.Fo()) {
                        this.bZJ.fn(d.j.loading);
                    } else if (aVar.Fp()) {
                        this.bZJ.fn(d.j.loading);
                    } else {
                        this.bZJ.fo(d.j.no_more_msg);
                    }
                } else {
                    this.bZJ.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aCW();
            } else {
                aCV();
            }
        }
    }

    public void aCW() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dRf != null) {
            this.dRf.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dQX);
        }
    }
}
