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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private View ama;
    private com.baidu.tbadk.mvc.g.a bSf;
    private NoNetworkView bfM;
    private AtMessageActivity dJk;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dJr;
    private BdListView dJs;
    private NavigationBar dJt;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dJk = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Ze() {
        this.rootView = this.dJk.getActivity().getLayoutInflater().inflate(d.j.at_me_activity, (ViewGroup) null);
        this.dJk.setContentView(this.rootView);
        this.dJs = (BdListView) this.rootView.findViewById(d.h.atme_lv);
        this.dJt = (NavigationBar) this.rootView.findViewById(d.h.view_navigation_bar);
        this.dJt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dJt.setTitleText(d.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dJk.getPageContext());
        this.mPullView.setTag(this.dJk.getUniqueId());
        this.mPullView.a(this.dJk);
        this.bSf = new com.baidu.tbadk.mvc.g.a(this.dJk);
        this.bSf.ld();
        this.ama = new TextView(this.dJk.getPageContext().getPageActivity());
        this.ama.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dJk.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.ama, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dJs.setPullRefresh(this.mPullView);
        this.dJs.addHeaderView(this.ama, 0);
        this.dJs.setNextPage(this.bSf);
        this.dJs.setDividerHeight(0);
        this.bfM = (NoNetworkView) this.rootView.findViewById(d.h.no_networkview);
        this.bfM.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bfM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aL(boolean z) {
                d.this.gT(z);
            }
        });
        this.dJs.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dJk.Ob();
            }
        });
        this.dJr = new com.baidu.tbadk.mvc.f.d<>(this.dJk.getPageContext(), a.class, d.j.mention_atme_item, this.dJk.Fk());
        this.dJr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dJk.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dp(d.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dJs.setAdapter((ListAdapter) this.dJr);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dJr != null) {
                this.dJr.C(fVar.aAI());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dJr != null) {
            this.dJr.b(tbPageContext, i);
        }
        if (this.bSf != null) {
            this.bSf.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        this.dJt.onChangeSkinType(tbPageContext, i);
    }

    public void aAA() {
        if (this.dJs != null) {
            this.dJs.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gT(boolean z) {
        BdListViewHelper.a(this.ama, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dJs != null && this.dJs.getWrappedAdapter() != null && this.dJs.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dJs.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bSf != null) {
                if (aVar.Fe()) {
                    this.bSf.lM();
                    if (aVar.Fc()) {
                        this.bSf.fm(d.l.loading);
                    } else if (aVar.Fd()) {
                        this.bSf.fm(d.l.loading);
                    } else {
                        this.bSf.fn(d.l.no_more_msg);
                    }
                } else {
                    this.bSf.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aAB();
            } else {
                aAA();
            }
        }
    }

    public void aAB() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dJs != null) {
            this.dJs.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dJk);
        }
    }
}
