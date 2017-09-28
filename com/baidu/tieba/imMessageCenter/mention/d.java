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
    private View amm;
    private com.baidu.tbadk.mvc.g.a bSr;
    private NoNetworkView bga;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dJF;
    private BdListView dJG;
    private NavigationBar dJH;
    private AtMessageActivity dJy;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dJy = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Zi() {
        this.rootView = this.dJy.getActivity().getLayoutInflater().inflate(d.j.at_me_activity, (ViewGroup) null);
        this.dJy.setContentView(this.rootView);
        this.dJG = (BdListView) this.rootView.findViewById(d.h.atme_lv);
        this.dJH = (NavigationBar) this.rootView.findViewById(d.h.view_navigation_bar);
        this.dJH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dJH.setTitleText(d.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dJy.getPageContext());
        this.mPullView.setTag(this.dJy.getUniqueId());
        this.mPullView.a(this.dJy);
        this.bSr = new com.baidu.tbadk.mvc.g.a(this.dJy);
        this.bSr.ld();
        this.amm = new TextView(this.dJy.getPageContext().getPageActivity());
        this.amm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dJy.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.amm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dJG.setPullRefresh(this.mPullView);
        this.dJG.addHeaderView(this.amm, 0);
        this.dJG.setNextPage(this.bSr);
        this.dJG.setDividerHeight(0);
        this.bga = (NoNetworkView) this.rootView.findViewById(d.h.no_networkview);
        this.bga.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bga.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                d.this.gU(z);
            }
        });
        this.dJG.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dJy.Oh();
            }
        });
        this.dJF = new com.baidu.tbadk.mvc.f.d<>(this.dJy.getPageContext(), a.class, d.j.mention_atme_item, this.dJy.Fq());
        this.dJF.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dJy.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dq(d.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dJG.setAdapter((ListAdapter) this.dJF);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dJF != null) {
                this.dJF.C(fVar.aAN());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dJF != null) {
            this.dJF.b(tbPageContext, i);
        }
        if (this.bSr != null) {
            this.bSr.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        this.dJH.onChangeSkinType(tbPageContext, i);
    }

    public void aAF() {
        if (this.dJG != null) {
            this.dJG.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gU(boolean z) {
        BdListViewHelper.a(this.amm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        if (z && this.dJG != null && this.dJG.getWrappedAdapter() != null && this.dJG.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dJG.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bSr != null) {
                if (aVar.Fk()) {
                    this.bSr.lM();
                    if (aVar.Fi()) {
                        this.bSr.fn(d.l.loading);
                    } else if (aVar.Fj()) {
                        this.bSr.fn(d.l.loading);
                    } else {
                        this.bSr.fo(d.l.no_more_msg);
                    }
                } else {
                    this.bSr.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aAG();
            } else {
                aAF();
            }
        }
    }

    public void aAG() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dJG != null) {
            this.dJG.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dJy);
        }
    }
}
