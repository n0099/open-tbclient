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
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class g extends com.baidu.adp.base.e<AtMessageActivity> {
    private NoNetworkView aSi;
    private View ali;
    private com.baidu.tbadk.mvc.g.a bCj;
    private AtMessageActivity dgA;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dgH;
    private BdListView dgI;
    private NavigationBar dgJ;
    protected com.baidu.tbadk.core.view.ah mPullView;
    private View rootView;

    public g(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dgA = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View UK() {
        this.rootView = this.dgA.getActivity().getLayoutInflater().inflate(w.j.at_me_activity, (ViewGroup) null);
        this.dgA.setContentView(this.rootView);
        this.dgI = (BdListView) this.rootView.findViewById(w.h.atme_lv);
        this.dgJ = (NavigationBar) this.rootView.findViewById(w.h.view_navigation_bar);
        this.dgJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dgJ.setTitleText(w.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.dgA.getPageContext());
        this.mPullView.setTag(this.dgA.getUniqueId());
        this.mPullView.a(this.dgA);
        this.bCj = new com.baidu.tbadk.mvc.g.a(this.dgA);
        this.bCj.le();
        this.ali = new TextView(this.dgA.getPageContext().getPageActivity());
        this.ali.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dgA.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.ali, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        this.dgI.setPullRefresh(this.mPullView);
        this.dgI.addHeaderView(this.ali, 0);
        this.dgI.setNextPage(this.bCj);
        this.dgI.setDividerHeight(0);
        this.aSi = (NoNetworkView) this.rootView.findViewById(w.h.no_networkview);
        this.aSi.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aSi.a(new h(this));
        this.dgI.setExOnSrollToBottomListener(new i(this));
        this.dgH = new com.baidu.tbadk.mvc.f.d<>(this.dgA.getPageContext(), a.class, w.j.mention_atme_item, this.dgA.EY());
        this.dgH.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dgA.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dd(w.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dgI.setAdapter((ListAdapter) this.dgH);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dgH != null) {
                this.dgH.x(acVar.atk());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dgH != null) {
            this.dgH.b(tbPageContext, i);
        }
        if (this.bCj != null) {
            this.bCj.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
        }
        this.dgJ.onChangeSkinType(tbPageContext, i);
    }

    public void atb() {
        if (this.dgI != null) {
            this.dgI.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gc(boolean z) {
        BdListViewHelper.a(this.ali, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        if (z && this.dgI != null && this.dgI.getWrappedAdapter() != null && this.dgI.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fS().post(new j(this));
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bCj != null) {
                if (aVar.ES()) {
                    this.bCj.lW();
                    if (aVar.EQ()) {
                        this.bCj.eU(w.l.loading);
                    } else if (aVar.ER()) {
                        this.bCj.eU(w.l.loading);
                    } else {
                        this.bCj.eV(w.l.no_more_msg);
                    }
                } else {
                    this.bCj.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                atc();
            } else {
                atb();
            }
        }
    }

    public void atc() {
        if (this.mPullView != null) {
            this.mPullView.a((ae.b) null);
        }
        if (this.dgI != null) {
            this.dgI.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dgA);
        }
    }
}
