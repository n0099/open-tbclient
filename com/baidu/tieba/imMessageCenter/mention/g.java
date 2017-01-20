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
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.base.e<AtMessageActivity> {
    private NoNetworkView Gt;
    private View afF;
    private com.baidu.tbadk.mvc.g.a bsP;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> cgR;
    private AtMessageActivity djn;
    private BdListView dju;
    private NavigationBar djv;
    protected com.baidu.tbadk.core.view.ad mPullView;
    private View rootView;

    public g(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.djn = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View lW() {
        this.rootView = this.djn.getActivity().getLayoutInflater().inflate(r.j.at_me_activity, (ViewGroup) null);
        this.djn.setContentView(this.rootView);
        this.dju = (BdListView) this.rootView.findViewById(r.h.atme_lv);
        this.djv = (NavigationBar) this.rootView.findViewById(r.h.view_navigation_bar);
        this.djv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.djv.setTitleText(r.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.ad(this.djn.getPageContext());
        this.mPullView.setTag(this.djn.getUniqueId());
        this.mPullView.a(this.djn);
        this.bsP = new com.baidu.tbadk.mvc.g.a(this.djn);
        this.bsP.kg();
        this.afF = new TextView(this.djn.getPageContext().getPageActivity());
        this.afF.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.djn.getPageContext().getPageActivity(), r.f.ds98)));
        BdListViewHelper.a(this.afF, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gk());
        this.dju.setPullRefresh(this.mPullView);
        this.dju.addHeaderView(this.afF, 0);
        this.dju.setNextPage(this.bsP);
        this.dju.setDividerHeight(0);
        this.Gt = (NoNetworkView) this.rootView.findViewById(r.h.no_networkview);
        this.Gt.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Gt.a(new h(this));
        this.dju.setExOnSrollToBottomListener(new i(this));
        this.cgR = new com.baidu.tbadk.mvc.f.d<>(this.djn.getPageContext(), a.class, r.j.mention_atme_item, this.djn.lA());
        this.cgR.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.djn.getResources().getDimension(r.f.ds80)), NoDataViewFactory.d.di(r.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dju.setAdapter((ListAdapter) this.cgR);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.cgR != null) {
                this.cgR.y(acVar.avZ());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cgR != null) {
            this.cgR.a(tbPageContext, i);
        }
        if (this.bsP != null) {
            this.bsP.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
        this.djv.onChangeSkinType(tbPageContext, i);
    }

    public void avQ() {
        if (this.dju != null) {
            this.dju.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gA(boolean z) {
        BdListViewHelper.a(this.afF, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gk());
        if (z && this.dju != null && this.dju.getWrappedAdapter() != null && this.dju.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.eE().post(new j(this));
        }
    }

    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bsP != null) {
                if (aVar.ER()) {
                    this.bsP.lr();
                    if (aVar.EP()) {
                        this.bsP.fa(r.l.loading);
                    } else if (aVar.EQ()) {
                        this.bsP.fa(r.l.loading);
                    } else {
                        this.bsP.fb(r.l.no_more_msg);
                    }
                } else {
                    this.bsP.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                avR();
            } else {
                avQ();
            }
        }
    }

    public void avR() {
        if (this.mPullView != null) {
            this.mPullView.a((aa.b) null);
        }
        if (this.dju != null) {
            this.dju.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.djn);
        }
    }
}
