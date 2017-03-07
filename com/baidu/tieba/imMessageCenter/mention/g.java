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
    private NoNetworkView aRv;
    private View akX;
    private com.baidu.tbadk.mvc.g.a bzY;
    private AtMessageActivity dlG;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dlN;
    private BdListView dlO;
    private NavigationBar dlP;
    protected com.baidu.tbadk.core.view.ae mPullView;
    private View rootView;

    public g(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dlG = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View TS() {
        this.rootView = this.dlG.getActivity().getLayoutInflater().inflate(w.j.at_me_activity, (ViewGroup) null);
        this.dlG.setContentView(this.rootView);
        this.dlO = (BdListView) this.rootView.findViewById(w.h.atme_lv);
        this.dlP = (NavigationBar) this.rootView.findViewById(w.h.view_navigation_bar);
        this.dlP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dlP.setTitleText(w.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.dlG.getPageContext());
        this.mPullView.setTag(this.dlG.getUniqueId());
        this.mPullView.a(this.dlG);
        this.bzY = new com.baidu.tbadk.mvc.g.a(this.dlG);
        this.bzY.la();
        this.akX = new TextView(this.dlG.getPageContext().getPageActivity());
        this.akX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dlG.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.akX, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.he());
        this.dlO.setPullRefresh(this.mPullView);
        this.dlO.addHeaderView(this.akX, 0);
        this.dlO.setNextPage(this.bzY);
        this.dlO.setDividerHeight(0);
        this.aRv = (NoNetworkView) this.rootView.findViewById(w.h.no_networkview);
        this.aRv.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aRv.a(new h(this));
        this.dlO.setExOnSrollToBottomListener(new i(this));
        this.dlN = new com.baidu.tbadk.mvc.f.d<>(this.dlG.getPageContext(), a.class, w.j.mention_atme_item, this.dlG.Fw());
        this.dlN.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dlG.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.de(w.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dlO.setAdapter((ListAdapter) this.dlN);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dlN != null) {
                this.dlN.w(acVar.avv());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dlN != null) {
            this.dlN.b(tbPageContext, i);
        }
        if (this.bzY != null) {
            this.bzY.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
        this.dlP.onChangeSkinType(tbPageContext, i);
    }

    public void avm() {
        if (this.dlO != null) {
            this.dlO.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.akX, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.he());
        if (z && this.dlO != null && this.dlO.getWrappedAdapter() != null && this.dlO.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fM().post(new j(this));
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bzY != null) {
                if (aVar.Fq()) {
                    this.bzY.ml();
                    if (aVar.Fo()) {
                        this.bzY.eV(w.l.loading);
                    } else if (aVar.Fp()) {
                        this.bzY.eV(w.l.loading);
                    } else {
                        this.bzY.eW(w.l.no_more_msg);
                    }
                } else {
                    this.bzY.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                avn();
            } else {
                avm();
            }
        }
    }

    public void avn() {
        if (this.mPullView != null) {
            this.mPullView.a((ab.b) null);
        }
        if (this.dlO != null) {
            this.dlO.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dlG);
        }
    }
}
