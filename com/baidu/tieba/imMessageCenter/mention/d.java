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
    private View ane;
    private com.baidu.tbadk.mvc.g.a bRP;
    private NoNetworkView bep;
    private AtMessageActivity dMm;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dMt;
    private BdListView dMu;
    private NavigationBar dMv;
    protected com.baidu.tbadk.core.view.l mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dMm = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Zm() {
        this.rootView = this.dMm.getActivity().getLayoutInflater().inflate(d.j.at_me_activity, (ViewGroup) null);
        this.dMm.setContentView(this.rootView);
        this.dMu = (BdListView) this.rootView.findViewById(d.h.atme_lv);
        this.dMv = (NavigationBar) this.rootView.findViewById(d.h.view_navigation_bar);
        this.dMv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dMv.setTitleText(d.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dMm.getPageContext());
        this.mPullView.setTag(this.dMm.getUniqueId());
        this.mPullView.a(this.dMm);
        this.bRP = new com.baidu.tbadk.mvc.g.a(this.dMm);
        this.bRP.lb();
        this.ane = new TextView(this.dMm.getPageContext().getPageActivity());
        this.ane.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dMm.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.ane, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        this.dMu.setPullRefresh(this.mPullView);
        this.dMu.addHeaderView(this.ane, 0);
        this.dMu.setNextPage(this.bRP);
        this.dMu.setDividerHeight(0);
        this.bep = (NoNetworkView) this.rootView.findViewById(d.h.no_networkview);
        this.bep.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bep.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                d.this.hg(z);
            }
        });
        this.dMu.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dMm.NL();
            }
        });
        this.dMt = new com.baidu.tbadk.mvc.f.d<>(this.dMm.getPageContext(), a.class, d.j.mention_atme_item, this.dMm.FL());
        this.dMt.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dMm.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dl(d.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dMu.setAdapter((ListAdapter) this.dMt);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dMt != null) {
                this.dMt.D(fVar.aBR());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dMt != null) {
            this.dMt.b(tbPageContext, i);
        }
        if (this.bRP != null) {
            this.bRP.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
        this.dMv.onChangeSkinType(tbPageContext, i);
    }

    public void aBJ() {
        if (this.dMu != null) {
            this.dMu.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hg(boolean z) {
        BdListViewHelper.a(this.ane, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        if (z && this.dMu != null && this.dMu.getWrappedAdapter() != null && this.dMu.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dMu.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bRP != null) {
                if (aVar.FF()) {
                    this.bRP.lK();
                    if (aVar.FD()) {
                        this.bRP.fc(d.l.loading);
                    } else if (aVar.FE()) {
                        this.bRP.fc(d.l.loading);
                    } else {
                        this.bRP.fd(d.l.no_more_msg);
                    }
                } else {
                    this.bRP.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aBK();
            } else {
                aBJ();
            }
        }
    }

    public void aBK() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dMu != null) {
            this.dMu.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dMm);
        }
    }
}
