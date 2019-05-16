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
    private NoNetworkView dlW;
    private com.baidu.tbadk.mvc.g.a eFH;
    private AtMessageActivity gOq;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gOx;
    private BdListView gOy;
    private NavigationBar gOz;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gOq = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aJF() {
        this.rootView = this.gOq.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.gOq.setContentView(this.rootView);
        this.gOy = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.gOz = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.gOz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gOz.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.gOz.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gOq.getPageContext());
        this.mPullView.setTag(this.gOq.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gOq);
        this.eFH = new com.baidu.tbadk.mvc.g.a(this.gOq);
        this.eFH.nG();
        this.mHeaderView = new TextView(this.gOq.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.gOq.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
        this.gOy.setPullRefresh(this.mPullView);
        this.gOy.addHeaderView(this.mHeaderView, 0);
        this.gOy.setNextPage(this.eFH);
        this.gOy.setDividerHeight(0);
        this.dlW = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.dlW.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dlW.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void el(boolean z) {
                d.this.mv(z);
            }
        });
        this.gOy.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gOq.bmp();
            }
        });
        this.gOx = new com.baidu.tbadk.mvc.f.d<>(this.gOq.getPageContext(), a.class, R.layout.mention_atme_item, this.gOq.atK());
        this.gOx.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cu(this.gOq)), NoDataViewFactory.d.iH(R.string.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gOy.setAdapter((ListAdapter) this.gOx);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gOx != null) {
                this.gOx.al(fVar.bFr());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gOx != null) {
            this.gOx.b(tbPageContext, i);
        }
        if (this.eFH != null) {
            this.eFH.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        this.gOz.onChangeSkinType(tbPageContext, i);
    }

    public void bEY() {
        if (this.gOy != null) {
            this.gOy.completePullRefreshPostDelayed(0L);
        }
    }

    public void mv(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jS());
        if (z && this.gOy != null && this.gOy.getWrappedAdapter() != null && this.gOy.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iB().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gOy.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.eFH != null) {
                if (aVar.atE()) {
                    this.eFH.pO();
                    if (aVar.atC()) {
                        this.eFH.kH(R.string.loading);
                    } else if (aVar.atD()) {
                        this.eFH.kH(R.string.loading);
                    } else {
                        this.eFH.kI(R.string.no_more_msg);
                    }
                } else {
                    this.eFH.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bEZ();
            } else {
                bEY();
            }
        }
    }

    public void bEZ() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gOy != null) {
            this.gOy.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gOq);
        }
    }
}
