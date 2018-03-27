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
    private View IS;
    private NoNetworkView cba;
    private com.baidu.tbadk.mvc.g.a deT;
    private AtMessageActivity eSj;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eSq;
    private BdListView eSr;
    private NavigationBar eSs;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eSj = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View YO() {
        this.rootView = this.eSj.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.eSj.setContentView(this.rootView);
        this.eSr = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eSs = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eSs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSs.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.eSs.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eSj.getPageContext());
        this.mPullView.setTag(this.eSj.getUniqueId());
        this.mPullView.a(this.eSj);
        this.deT = new com.baidu.tbadk.mvc.g.a(this.eSj);
        this.deT.st();
        this.IS = new TextView(this.eSj.getPageContext().getPageActivity());
        this.IS.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.t(this.eSj.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IS, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        this.eSr.setPullRefresh(this.mPullView);
        this.eSr.addHeaderView(this.IS, 0);
        this.eSr.setNextPage(this.deT);
        this.eSr.setDividerHeight(0);
        this.cba = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.cba.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.cba.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bu(boolean z) {
                d.this.ik(z);
            }
        });
        this.eSr.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eSj.awR();
            }
        });
        this.eSq = new com.baidu.tbadk.mvc.f.d<>(this.eSj.getPageContext(), a.class, d.h.mention_atme_item, this.eSj.NL());
        this.eSq.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eSj.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eSr.setAdapter((ListAdapter) this.eSq);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eSq != null) {
                this.eSq.N(fVar.aNF());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eSq != null) {
            this.eSq.b(tbPageContext, i);
        }
        if (this.deT != null) {
            this.deT.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        this.eSs.onChangeSkinType(tbPageContext, i);
    }

    public void aNu() {
        if (this.eSr != null) {
            this.eSr.completePullRefreshPostDelayed(2000L);
        }
    }

    public void ik(boolean z) {
        BdListViewHelper.a(this.IS, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        if (z && this.eSr != null && this.eSr.getWrappedAdapter() != null && this.eSr.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eSr.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.deT != null) {
                if (aVar.NF()) {
                    this.deT.th();
                    if (aVar.ND()) {
                        this.deT.id(d.j.loading);
                    } else if (aVar.NE()) {
                        this.deT.id(d.j.loading);
                    } else {
                        this.deT.ie(d.j.no_more_msg);
                    }
                } else {
                    this.deT.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aNv();
            } else {
                aNu();
            }
        }
    }

    public void aNv() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.eSr != null) {
            this.eSr.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eSj);
        }
    }
}
