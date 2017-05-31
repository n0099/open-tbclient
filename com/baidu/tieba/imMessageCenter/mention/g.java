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
    private NoNetworkView aZX;
    private View akY;
    private com.baidu.tbadk.mvc.g.a bHZ;
    private AtMessageActivity dlW;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dmd;
    private BdListView dme;
    private NavigationBar dmf;
    protected com.baidu.tbadk.core.view.ah mPullView;
    private View rootView;

    public g(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dlW = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View VN() {
        this.rootView = this.dlW.getActivity().getLayoutInflater().inflate(w.j.at_me_activity, (ViewGroup) null);
        this.dlW.setContentView(this.rootView);
        this.dme = (BdListView) this.rootView.findViewById(w.h.atme_lv);
        this.dmf = (NavigationBar) this.rootView.findViewById(w.h.view_navigation_bar);
        this.dmf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dmf.setTitleText(w.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.dlW.getPageContext());
        this.mPullView.setTag(this.dlW.getUniqueId());
        this.mPullView.a(this.dlW);
        this.bHZ = new com.baidu.tbadk.mvc.g.a(this.dlW);
        this.bHZ.le();
        this.akY = new TextView(this.dlW.getPageContext().getPageActivity());
        this.akY.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dlW.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.akY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        this.dme.setPullRefresh(this.mPullView);
        this.dme.addHeaderView(this.akY, 0);
        this.dme.setNextPage(this.bHZ);
        this.dme.setDividerHeight(0);
        this.aZX = (NoNetworkView) this.rootView.findViewById(w.h.no_networkview);
        this.aZX.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aZX.a(new h(this));
        this.dme.setExOnSrollToBottomListener(new i(this));
        this.dmd = new com.baidu.tbadk.mvc.f.d<>(this.dlW.getPageContext(), a.class, w.j.mention_atme_item, this.dlW.ES());
        this.dmd.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dlW.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.de(w.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dme.setAdapter((ListAdapter) this.dmd);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dmd != null) {
                this.dmd.x(acVar.auf());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dmd != null) {
            this.dmd.b(tbPageContext, i);
        }
        if (this.bHZ != null) {
            this.bHZ.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
        this.dmf.onChangeSkinType(tbPageContext, i);
    }

    public void atW() {
        if (this.dme != null) {
            this.dme.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gp(boolean z) {
        BdListViewHelper.a(this.akY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        if (z && this.dme != null && this.dme.getWrappedAdapter() != null && this.dme.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fS().post(new j(this));
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bHZ != null) {
                if (aVar.EM()) {
                    this.bHZ.lO();
                    if (aVar.EK()) {
                        this.bHZ.eV(w.l.loading);
                    } else if (aVar.EL()) {
                        this.bHZ.eV(w.l.loading);
                    } else {
                        this.bHZ.eW(w.l.no_more_msg);
                    }
                } else {
                    this.bHZ.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                atX();
            } else {
                atW();
            }
        }
    }

    public void atX() {
        if (this.mPullView != null) {
            this.mPullView.a((ae.b) null);
        }
        if (this.dme != null) {
            this.dme.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dlW);
        }
    }
}
