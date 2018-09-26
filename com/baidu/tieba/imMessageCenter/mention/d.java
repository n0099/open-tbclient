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
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView bBq;
    private com.baidu.tbadk.mvc.g.a cMF;
    private AtMessageActivity eNO;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eNV;
    private BdListView eNW;
    private NavigationBar eNX;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eNO = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Xd() {
        this.rootView = this.eNO.getActivity().getLayoutInflater().inflate(e.h.at_me_activity, (ViewGroup) null);
        this.eNO.setContentView(this.rootView);
        this.eNW = (BdListView) this.rootView.findViewById(e.g.atme_lv);
        this.eNX = (NavigationBar) this.rootView.findViewById(e.g.view_navigation_bar);
        this.eNX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eNX.setCenterTextTitle(getPageContext().getString(e.j.at_me));
        this.eNX.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eNO.getPageContext());
        this.mPullView.setTag(this.eNO.getUniqueId());
        this.mPullView.a(this.eNO);
        this.cMF = new com.baidu.tbadk.mvc.g.a(this.eNO);
        this.cMF.ov();
        this.mHeaderView = new TextView(this.eNO.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.eNO.getPageContext().getPageActivity(), e.C0141e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kK());
        this.eNW.setPullRefresh(this.mPullView);
        this.eNW.addHeaderView(this.mHeaderView, 0);
        this.eNW.setNextPage(this.cMF);
        this.eNW.setDividerHeight(0);
        this.bBq = (NoNetworkView) this.rootView.findViewById(e.g.no_networkview);
        this.bBq.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bBq.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bd(boolean z) {
                d.this.iz(z);
            }
        });
        this.eNW.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eNO.ayD();
            }
        });
        this.eNV = new com.baidu.tbadk.mvc.f.d<>(this.eNO.getPageContext(), a.class, e.h.mention_atme_item, this.eNO.LA());
        this.eNV.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eNO.getResources().getDimension(e.C0141e.ds80)), NoDataViewFactory.d.dE(e.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eNW.setAdapter((ListAdapter) this.eNV);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eNV != null) {
                this.eNV.J(fVar.aRt());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eNV != null) {
            this.eNV.b(tbPageContext, i);
        }
        if (this.cMF != null) {
            this.cMF.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        this.eNX.onChangeSkinType(tbPageContext, i);
    }

    public void aQZ() {
        if (this.eNW != null) {
            this.eNW.completePullRefreshPostDelayed(2000L);
        }
    }

    public void iz(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kK());
        if (z && this.eNW != null && this.eNW.getWrappedAdapter() != null && this.eNW.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jt().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eNW.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cMF != null) {
                if (aVar.Lu()) {
                    this.cMF.pI();
                    if (aVar.Ls()) {
                        this.cMF.fu(e.j.loading);
                    } else if (aVar.Lt()) {
                        this.cMF.fu(e.j.loading);
                    } else {
                        this.cMF.fv(e.j.no_more_msg);
                    }
                } else {
                    this.cMF.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aRa();
            } else {
                aQZ();
            }
        }
    }

    public void aRa() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.eNW != null) {
            this.eNW.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eNO);
        }
    }
}
