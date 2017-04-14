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
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<AtMessageActivity> {
    private NoNetworkView aRL;
    private View alm;
    private com.baidu.tbadk.mvc.g.a bzR;
    private AtMessageActivity dkf;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dkm;
    private BdListView dkn;
    private NavigationBar dko;
    protected com.baidu.tbadk.core.view.ae mPullView;
    private View rootView;

    public g(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dkf = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Uq() {
        this.rootView = this.dkf.getActivity().getLayoutInflater().inflate(w.j.at_me_activity, (ViewGroup) null);
        this.dkf.setContentView(this.rootView);
        this.dkn = (BdListView) this.rootView.findViewById(w.h.atme_lv);
        this.dko = (NavigationBar) this.rootView.findViewById(w.h.view_navigation_bar);
        this.dko.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dko.setTitleText(w.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.dkf.getPageContext());
        this.mPullView.setTag(this.dkf.getUniqueId());
        this.mPullView.a(this.dkf);
        this.bzR = new com.baidu.tbadk.mvc.g.a(this.dkf);
        this.bzR.le();
        this.alm = new TextView(this.dkf.getPageContext().getPageActivity());
        this.alm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dkf.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.alm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        this.dkn.setPullRefresh(this.mPullView);
        this.dkn.addHeaderView(this.alm, 0);
        this.dkn.setNextPage(this.bzR);
        this.dkn.setDividerHeight(0);
        this.aRL = (NoNetworkView) this.rootView.findViewById(w.h.no_networkview);
        this.aRL.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aRL.a(new h(this));
        this.dkn.setExOnSrollToBottomListener(new i(this));
        this.dkm = new com.baidu.tbadk.mvc.f.d<>(this.dkf.getPageContext(), a.class, w.j.mention_atme_item, this.dkf.FU());
        this.dkm.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dkf.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dh(w.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dkn.setAdapter((ListAdapter) this.dkm);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dkm != null) {
                this.dkm.w(acVar.avo());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dkm != null) {
            this.dkm.b(tbPageContext, i);
        }
        if (this.bzR != null) {
            this.bzR.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        this.dko.onChangeSkinType(tbPageContext, i);
    }

    public void avf() {
        if (this.dkn != null) {
            this.dkn.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.alm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        if (z && this.dkn != null && this.dkn.getWrappedAdapter() != null && this.dkn.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fR().post(new j(this));
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bzR != null) {
                if (aVar.FO()) {
                    this.bzR.mp();
                    if (aVar.FM()) {
                        this.bzR.eY(w.l.loading);
                    } else if (aVar.FN()) {
                        this.bzR.eY(w.l.loading);
                    } else {
                        this.bzR.eZ(w.l.no_more_msg);
                    }
                } else {
                    this.bzR.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                avg();
            } else {
                avf();
            }
        }
    }

    public void avg() {
        if (this.mPullView != null) {
            this.mPullView.a((ab.b) null);
        }
        if (this.dkn != null) {
            this.dkn.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dkf);
        }
    }
}
