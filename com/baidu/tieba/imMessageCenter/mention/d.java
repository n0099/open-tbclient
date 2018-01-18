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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private View IZ;
    private NoNetworkView bYQ;
    private com.baidu.tbadk.mvc.g.a dbT;
    private AtMessageActivity eNC;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eNJ;
    private BdListView eNK;
    private NavigationBar eNL;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eNC = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View XH() {
        this.rootView = this.eNC.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.eNC.setContentView(this.rootView);
        this.eNK = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eNL = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eNL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eNL.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.eNL.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eNC.getPageContext());
        this.mPullView.setTag(this.eNC.getUniqueId());
        this.mPullView.a(this.eNC);
        this.dbT = new com.baidu.tbadk.mvc.g.a(this.eNC);
        this.dbT.su();
        this.IZ = new TextView(this.eNC.getPageContext().getPageActivity());
        this.IZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.eNC.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        this.eNK.setPullRefresh(this.mPullView);
        this.eNK.addHeaderView(this.IZ, 0);
        this.eNK.setNextPage(this.dbT);
        this.eNK.setDividerHeight(0);
        this.bYQ = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.bYQ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bYQ.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bp(boolean z) {
                d.this.hS(z);
            }
        });
        this.eNK.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eNC.WR();
            }
        });
        this.eNJ = new com.baidu.tbadk.mvc.f.d<>(this.eNC.getPageContext(), a.class, d.h.mention_atme_item, this.eNC.Nd());
        this.eNJ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eNC.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gn(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eNK.setAdapter((ListAdapter) this.eNJ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eNJ != null) {
                this.eNJ.L(fVar.aLW());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eNJ != null) {
            this.eNJ.b(tbPageContext, i);
        }
        if (this.dbT != null) {
            this.dbT.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
        this.eNL.onChangeSkinType(tbPageContext, i);
    }

    public void aLO() {
        if (this.eNK != null) {
            this.eNK.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hS(boolean z) {
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        if (z && this.eNK != null && this.eNK.getWrappedAdapter() != null && this.eNK.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eNK.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.dbT != null) {
                if (aVar.MX()) {
                    this.dbT.th();
                    if (aVar.MV()) {
                        this.dbT.ig(d.j.loading);
                    } else if (aVar.MW()) {
                        this.dbT.ig(d.j.loading);
                    } else {
                        this.dbT.ih(d.j.no_more_msg);
                    }
                } else {
                    this.dbT.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aLP();
            } else {
                aLO();
            }
        }
    }

    public void aLP() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.eNK != null) {
            this.eNK.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eNC);
        }
    }
}
