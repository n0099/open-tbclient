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
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView blp;
    private com.baidu.tbadk.mvc.g.a cxP;
    private AtMessageActivity enC;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> enJ;
    private BdListView enK;
    private NavigationBar enL;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.f mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.enC = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Rk() {
        this.rootView = this.enC.getActivity().getLayoutInflater().inflate(d.i.at_me_activity, (ViewGroup) null);
        this.enC.setContentView(this.rootView);
        this.enK = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.enL = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.enL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.enL.setCenterTextTitle(getPageContext().getString(d.k.at_me));
        this.enL.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.f(this.enC.getPageContext());
        this.mPullView.setTag(this.enC.getUniqueId());
        this.mPullView.a(this.enC);
        this.cxP = new com.baidu.tbadk.mvc.g.a(this.enC);
        this.cxP.kz();
        this.mHeaderView = new TextView(this.enC.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.enC.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
        this.enK.setPullRefresh(this.mPullView);
        this.enK.addHeaderView(this.mHeaderView, 0);
        this.enK.setNextPage(this.cxP);
        this.enK.setDividerHeight(0);
        this.blp = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.blp.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.blp.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                d.this.hI(z);
            }
        });
        this.enK.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.enC.arg();
            }
        });
        this.enJ = new com.baidu.tbadk.mvc.f.d<>(this.enC.getPageContext(), a.class, d.i.mention_atme_item, this.enC.Gl());
        this.enJ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.enC.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.k.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.enK.setAdapter((ListAdapter) this.enJ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.enJ != null) {
                this.enJ.F(fVar.aIG());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.enJ != null) {
            this.enJ.b(tbPageContext, i);
        }
        if (this.cxP != null) {
            this.cxP.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        this.enL.onChangeSkinType(tbPageContext, i);
    }

    public void aIm() {
        if (this.enK != null) {
            this.enK.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hI(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
        if (z && this.enK != null && this.enK.getWrappedAdapter() != null && this.enK.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.enK.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cxP != null) {
                if (aVar.Gf()) {
                    this.cxP.lM();
                    if (aVar.Gd()) {
                        this.cxP.fd(d.k.loading);
                    } else if (aVar.Ge()) {
                        this.cxP.fd(d.k.loading);
                    } else {
                        this.cxP.fe(d.k.no_more_msg);
                    }
                } else {
                    this.cxP.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aIn();
            } else {
                aIm();
            }
        }
    }

    public void aIn() {
        if (this.mPullView != null) {
            this.mPullView.a((e.b) null);
        }
        if (this.enK != null) {
            this.enK.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.enC);
        }
    }
}
