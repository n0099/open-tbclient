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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView dpy;
    private com.baidu.tbadk.mvc.g.a eMu;
    private AtMessageActivity gXp;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gXw;
    private BdListView gXx;
    private NavigationBar gXy;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gXp = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aLT() {
        this.rootView = this.gXp.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.gXp.setContentView(this.rootView);
        this.gXx = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.gXy = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.gXy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gXy.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.gXy.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gXp.getPageContext());
        this.mPullView.setTag(this.gXp.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gXp);
        this.eMu = new com.baidu.tbadk.mvc.g.a(this.gXp);
        this.eMu.nZ();
        this.mHeaderView = new TextView(this.gXp.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.gXp.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
        this.gXx.setPullRefresh(this.mPullView);
        this.gXx.addHeaderView(this.mHeaderView, 0);
        this.gXx.setNextPage(this.eMu);
        this.gXx.setDividerHeight(0);
        this.dpy = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.dpy.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dpy.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void es(boolean z) {
                d.this.mN(z);
            }
        });
        this.gXx.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gXp.bpr();
            }
        });
        this.gXw = new com.baidu.tbadk.mvc.f.d<>(this.gXp.getPageContext(), a.class, R.layout.mention_atme_item, this.gXp.avg());
        this.gXw.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cv(this.gXp)), NoDataViewFactory.d.iQ(R.string.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gXx.setAdapter((ListAdapter) this.gXw);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gXw != null) {
                this.gXw.al(fVar.bJe());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gXw != null) {
            this.gXw.b(tbPageContext, i);
        }
        if (this.eMu != null) {
            this.eMu.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        this.gXy.onChangeSkinType(tbPageContext, i);
    }

    public void bIL() {
        if (this.gXx != null) {
            this.gXx.completePullRefreshPostDelayed(0L);
        }
    }

    public void mN(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
        if (z && this.gXx != null && this.gXx.getWrappedAdapter() != null && this.gXx.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gXx.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.eMu != null) {
                if (aVar.ava()) {
                    this.eMu.ql();
                    if (aVar.auY()) {
                        this.eMu.kR(R.string.loading);
                    } else if (aVar.auZ()) {
                        this.eMu.kR(R.string.loading);
                    } else {
                        this.eMu.kS(R.string.no_more_msg);
                    }
                } else {
                    this.eMu.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bIM();
            } else {
                bIL();
            }
        }
    }

    public void bIM() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gXx != null) {
            this.gXx.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gXp);
        }
    }
}
