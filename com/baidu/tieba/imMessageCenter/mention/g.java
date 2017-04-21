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
    private NoNetworkView aRN;
    private View aln;
    private com.baidu.tbadk.mvc.g.a bCi;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dmD;
    private BdListView dmE;
    private NavigationBar dmF;
    private AtMessageActivity dmw;
    protected com.baidu.tbadk.core.view.ae mPullView;
    private View rootView;

    public g(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dmw = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Vr() {
        this.rootView = this.dmw.getActivity().getLayoutInflater().inflate(w.j.at_me_activity, (ViewGroup) null);
        this.dmw.setContentView(this.rootView);
        this.dmE = (BdListView) this.rootView.findViewById(w.h.atme_lv);
        this.dmF = (NavigationBar) this.rootView.findViewById(w.h.view_navigation_bar);
        this.dmF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dmF.setTitleText(w.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.dmw.getPageContext());
        this.mPullView.setTag(this.dmw.getUniqueId());
        this.mPullView.a(this.dmw);
        this.bCi = new com.baidu.tbadk.mvc.g.a(this.dmw);
        this.bCi.lf();
        this.aln = new TextView(this.dmw.getPageContext().getPageActivity());
        this.aln.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dmw.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.aln, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        this.dmE.setPullRefresh(this.mPullView);
        this.dmE.addHeaderView(this.aln, 0);
        this.dmE.setNextPage(this.bCi);
        this.dmE.setDividerHeight(0);
        this.aRN = (NoNetworkView) this.rootView.findViewById(w.h.no_networkview);
        this.aRN.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aRN.a(new h(this));
        this.dmE.setExOnSrollToBottomListener(new i(this));
        this.dmD = new com.baidu.tbadk.mvc.f.d<>(this.dmw.getPageContext(), a.class, w.j.mention_atme_item, this.dmw.FU());
        this.dmD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dmw.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dh(w.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dmE.setAdapter((ListAdapter) this.dmD);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dmD != null) {
                this.dmD.w(acVar.awp());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dmD != null) {
            this.dmD.b(tbPageContext, i);
        }
        if (this.bCi != null) {
            this.bCi.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        this.dmF.onChangeSkinType(tbPageContext, i);
    }

    public void awg() {
        if (this.dmE != null) {
            this.dmE.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gB(boolean z) {
        BdListViewHelper.a(this.aln, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        if (z && this.dmE != null && this.dmE.getWrappedAdapter() != null && this.dmE.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fS().post(new j(this));
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bCi != null) {
                if (aVar.FO()) {
                    this.bCi.mp();
                    if (aVar.FM()) {
                        this.bCi.eY(w.l.loading);
                    } else if (aVar.FN()) {
                        this.bCi.eY(w.l.loading);
                    } else {
                        this.bCi.eZ(w.l.no_more_msg);
                    }
                } else {
                    this.bCi.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                awh();
            } else {
                awg();
            }
        }
    }

    public void awh() {
        if (this.mPullView != null) {
            this.mPullView.a((ab.b) null);
        }
        if (this.dmE != null) {
            this.dmE.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dmw);
        }
    }
}
