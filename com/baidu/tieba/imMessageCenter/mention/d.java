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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private View amR;
    private NoNetworkView bly;
    private com.baidu.tbadk.mvc.g.a ciM;
    private AtMessageActivity dZZ;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eag;
    private BdListView eah;
    private NavigationBar eai;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dZZ = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Qv() {
        this.rootView = this.dZZ.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.dZZ.setContentView(this.rootView);
        this.eah = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eai = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eai.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eai.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.eai.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.dZZ.getPageContext());
        this.mPullView.setTag(this.dZZ.getUniqueId());
        this.mPullView.a(this.dZZ);
        this.ciM = new com.baidu.tbadk.mvc.g.a(this.dZZ);
        this.ciM.kX();
        this.amR = new TextView(this.dZZ.getPageContext().getPageActivity());
        this.amR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dZZ.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.eah.setPullRefresh(this.mPullView);
        this.eah.addHeaderView(this.amR, 0);
        this.eah.setNextPage(this.ciM);
        this.eah.setDividerHeight(0);
        this.bly = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.bly.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bly.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                d.this.hq(z);
            }
        });
        this.eah.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dZZ.PF();
            }
        });
        this.eag = new com.baidu.tbadk.mvc.f.d<>(this.dZZ.getPageContext(), a.class, d.h.mention_atme_item, this.dZZ.FQ());
        this.eag.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dZZ.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eah.setAdapter((ListAdapter) this.eag);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eag != null) {
                this.eag.E(fVar.aEQ());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eag != null) {
            this.eag.b(tbPageContext, i);
        }
        if (this.ciM != null) {
            this.ciM.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        this.eai.onChangeSkinType(tbPageContext, i);
    }

    public void aEI() {
        if (this.eah != null) {
            this.eah.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hq(boolean z) {
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.eah != null && this.eah.getWrappedAdapter() != null && this.eah.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eah.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.ciM != null) {
                if (aVar.FK()) {
                    this.ciM.lE();
                    if (aVar.FI()) {
                        this.ciM.fl(d.j.loading);
                    } else if (aVar.FJ()) {
                        this.ciM.fl(d.j.loading);
                    } else {
                        this.ciM.fm(d.j.no_more_msg);
                    }
                } else {
                    this.ciM.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aEJ();
            } else {
                aEI();
            }
        }
    }

    public void aEJ() {
        if (this.mPullView != null) {
            this.mPullView.a((h.b) null);
        }
        if (this.eah != null) {
            this.eah.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dZZ);
        }
    }
}
