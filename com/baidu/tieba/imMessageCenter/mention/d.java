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
    private NoNetworkView dvR;
    private com.baidu.tbadk.mvc.g.a eUj;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gUG;
    private BdListView gUH;
    private NavigationBar gUI;
    private AtMessageActivity gUz;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gUz = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aKW() {
        this.rootView = this.gUz.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.gUz.setContentView(this.rootView);
        this.gUH = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.gUI = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.gUI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gUI.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.gUI.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gUz.getPageContext());
        this.mPullView.setTag(this.gUz.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gUz);
        this.eUj = new com.baidu.tbadk.mvc.g.a(this.gUz);
        this.eUj.createView();
        this.mHeaderView = new TextView(this.gUz.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.gUz.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.gUH.setPullRefresh(this.mPullView);
        this.gUH.addHeaderView(this.mHeaderView, 0);
        this.gUH.setNextPage(this.eUj);
        this.gUH.setDividerHeight(0);
        this.dvR = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.dvR.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dvR.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.mB(z);
            }
        });
        this.gUH.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.gUz.bmu();
            }
        });
        this.gUG = new com.baidu.tbadk.mvc.f.d<>(this.gUz.getPageContext(), a.class, R.layout.mention_atme_item, this.gUz.awv());
        this.gUG.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cr(this.gUz)), NoDataViewFactory.d.iK(R.string.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gUH.setAdapter((ListAdapter) this.gUG);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gUG != null) {
                this.gUG.aF(fVar.bFM());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gUG != null) {
            this.gUG.b(tbPageContext, i);
        }
        if (this.eUj != null) {
            this.eUj.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.gUI.onChangeSkinType(tbPageContext, i);
    }

    public void bFt() {
        if (this.gUH != null) {
            this.gUH.completePullRefreshPostDelayed(0L);
        }
    }

    public void mB(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.gUH != null && this.gUH.getWrappedAdapter() != null && this.gUH.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fZ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gUH.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.eUj != null) {
                if (aVar.awq()) {
                    this.eUj.le();
                    if (aVar.awo()) {
                        this.eUj.kd(R.string.loading);
                    } else if (aVar.awp()) {
                        this.eUj.kd(R.string.loading);
                    } else {
                        this.eUj.ke(R.string.no_more_msg);
                    }
                } else {
                    this.eUj.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bFu();
            } else {
                bFt();
            }
        }
    }

    public void bFu() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gUH != null) {
            this.gUH.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gUz);
        }
    }
}
