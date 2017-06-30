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
    private View alM;
    private com.baidu.tbadk.mvc.g.a bIS;
    private NoNetworkView bbO;
    private AtMessageActivity dtS;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dtZ;
    private BdListView dua;
    private NavigationBar dub;
    protected com.baidu.tbadk.core.view.ah mPullView;
    private View rootView;

    public g(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dtS = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Xe() {
        this.rootView = this.dtS.getActivity().getLayoutInflater().inflate(w.j.at_me_activity, (ViewGroup) null);
        this.dtS.setContentView(this.rootView);
        this.dua = (BdListView) this.rootView.findViewById(w.h.atme_lv);
        this.dub = (NavigationBar) this.rootView.findViewById(w.h.view_navigation_bar);
        this.dub.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dub.setTitleText(w.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.dtS.getPageContext());
        this.mPullView.setTag(this.dtS.getUniqueId());
        this.mPullView.a(this.dtS);
        this.bIS = new com.baidu.tbadk.mvc.g.a(this.dtS);
        this.bIS.lc();
        this.alM = new TextView(this.dtS.getPageContext().getPageActivity());
        this.alM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dtS.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.alM, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        this.dua.setPullRefresh(this.mPullView);
        this.dua.addHeaderView(this.alM, 0);
        this.dua.setNextPage(this.bIS);
        this.dua.setDividerHeight(0);
        this.bbO = (NoNetworkView) this.rootView.findViewById(w.h.no_networkview);
        this.bbO.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.bbO.a(new h(this));
        this.dua.setExOnSrollToBottomListener(new i(this));
        this.dtZ = new com.baidu.tbadk.mvc.f.d<>(this.dtS.getPageContext(), a.class, w.j.mention_atme_item, this.dtS.Fp());
        this.dtZ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dtS.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dg(w.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dua.setAdapter((ListAdapter) this.dtZ);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dtZ != null) {
                this.dtZ.z(acVar.axM());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dtZ != null) {
            this.dtZ.b(tbPageContext, i);
        }
        if (this.bIS != null) {
            this.bIS.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
        this.dub.onChangeSkinType(tbPageContext, i);
    }

    public void axE() {
        if (this.dua != null) {
            this.dua.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gH(boolean z) {
        BdListViewHelper.a(this.alM, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        if (z && this.dua != null && this.dua.getWrappedAdapter() != null && this.dua.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fR().post(new j(this));
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bIS != null) {
                if (aVar.Fj()) {
                    this.bIS.lM();
                    if (aVar.Fh()) {
                        this.bIS.eX(w.l.loading);
                    } else if (aVar.Fi()) {
                        this.bIS.eX(w.l.loading);
                    } else {
                        this.bIS.eY(w.l.no_more_msg);
                    }
                } else {
                    this.bIS.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                axF();
            } else {
                axE();
            }
        }
    }

    public void axF() {
        if (this.mPullView != null) {
            this.mPullView.a((ae.b) null);
        }
        if (this.dua != null) {
            this.dua.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dtS);
        }
    }
}
