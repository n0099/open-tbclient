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
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private View anJ;
    private com.baidu.tbadk.mvc.g.a bOm;
    private NoNetworkView beq;
    private AtMessageActivity dDL;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dDS;
    private BdListView dDT;
    private NavigationBar dDU;
    protected com.baidu.tbadk.core.view.l mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dDL = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View XR() {
        this.rootView = this.dDL.getActivity().getLayoutInflater().inflate(d.j.at_me_activity, (ViewGroup) null);
        this.dDL.setContentView(this.rootView);
        this.dDT = (BdListView) this.rootView.findViewById(d.h.atme_lv);
        this.dDU = (NavigationBar) this.rootView.findViewById(d.h.view_navigation_bar);
        this.dDU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dDU.setTitleText(d.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dDL.getPageContext());
        this.mPullView.setTag(this.dDL.getUniqueId());
        this.mPullView.a(this.dDL);
        this.bOm = new com.baidu.tbadk.mvc.g.a(this.dDL);
        this.bOm.lk();
        this.anJ = new TextView(this.dDL.getPageContext().getPageActivity());
        this.anJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dDL.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.anJ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        this.dDT.setPullRefresh(this.mPullView);
        this.dDT.addHeaderView(this.anJ, 0);
        this.dDT.setNextPage(this.bOm);
        this.dDT.setDividerHeight(0);
        this.beq = (NoNetworkView) this.rootView.findViewById(d.h.no_networkview);
        this.beq.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.beq.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                d.this.gV(z);
            }
        });
        this.dDT.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dDL.Nv();
            }
        });
        this.dDS = new com.baidu.tbadk.mvc.f.d<>(this.dDL.getPageContext(), a.class, d.j.mention_atme_item, this.dDL.FN());
        this.dDS.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dDL.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dk(d.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dDT.setAdapter((ListAdapter) this.dDS);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dDS != null) {
                this.dDS.D(fVar.azA());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dDS != null) {
            this.dDS.b(tbPageContext, i);
        }
        if (this.bOm != null) {
            this.bOm.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
        this.dDU.onChangeSkinType(tbPageContext, i);
    }

    public void azs() {
        if (this.dDT != null) {
            this.dDT.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gV(boolean z) {
        BdListViewHelper.a(this.anJ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        if (z && this.dDT != null && this.dDT.getWrappedAdapter() != null && this.dDT.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dDT.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bOm != null) {
                if (aVar.FH()) {
                    this.bOm.lT();
                    if (aVar.FF()) {
                        this.bOm.fc(d.l.loading);
                    } else if (aVar.FG()) {
                        this.bOm.fc(d.l.loading);
                    } else {
                        this.bOm.fd(d.l.no_more_msg);
                    }
                } else {
                    this.bOm.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                azt();
            } else {
                azs();
            }
        }
    }

    public void azt() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dDT != null) {
            this.dDT.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dDL);
        }
    }
}
