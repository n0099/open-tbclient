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
/* loaded from: classes7.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView ehd;
    private com.baidu.tbadk.mvc.g.a fMa;
    private AtMessageActivity hMe;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> hMl;
    private BdListView hMm;
    private NavigationBar hMn;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.hMe = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bcD() {
        this.rootView = this.hMe.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.hMe.setContentView(this.rootView);
        this.hMm = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.hMn = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.hMn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hMn.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.hMn.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.hMe.getPageContext());
        this.mPullView.setTag(this.hMe.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.hMe);
        this.fMa = new com.baidu.tbadk.mvc.g.a(this.hMe);
        this.fMa.createView();
        this.mHeaderView = new TextView(this.hMe.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.hMe.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.hMm.setPullRefresh(this.mPullView);
        this.hMm.addHeaderView(this.mHeaderView, 0);
        this.hMm.setNextPage(this.fMa);
        this.hMm.setDividerHeight(0);
        this.ehd = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.ehd.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.ehd.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.oa(z);
            }
        });
        this.hMm.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.hMe.bES();
            }
        });
        this.hMl = new com.baidu.tbadk.mvc.f.d<>(this.hMe.getPageContext(), a.class, R.layout.mention_atme_item, this.hMe.aOy());
        this.hMl.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dM(this.hMe)), NoDataViewFactory.d.cr(null, this.hMe.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.hMm.setAdapter((ListAdapter) this.hMl);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.hMl != null) {
                this.hMl.aK(fVar.bYh());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.hMl != null) {
            this.hMl.b(tbPageContext, i);
        }
        if (this.fMa != null) {
            this.fMa.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.hMn.onChangeSkinType(tbPageContext, i);
    }

    public void bXO() {
        if (this.hMm != null) {
            this.hMm.completePullRefreshPostDelayed(0L);
        }
    }

    public void oa(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.hMm != null && this.hMm.getWrappedAdapter() != null && this.hMm.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.gx().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hMm.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.fMa != null) {
                if (aVar.aOt()) {
                    this.fMa.display();
                    if (aVar.aOr()) {
                        this.fMa.mr(R.string.loading);
                    } else if (aVar.aOs()) {
                        this.fMa.mr(R.string.loading);
                    } else {
                        this.fMa.ms(R.string.no_more_msg);
                    }
                } else {
                    this.fMa.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bXP();
            } else {
                bXO();
            }
        }
    }

    public void bXP() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.hMm != null) {
            this.hMm.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.hMe);
        }
    }
}
