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
    private NoNetworkView bvz;
    private com.baidu.tbadk.mvc.g.a cGR;
    private AtMessageActivity eGD;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> eGK;
    private BdListView eGL;
    private NavigationBar eGM;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eGD = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Vm() {
        this.rootView = this.eGD.getActivity().getLayoutInflater().inflate(d.h.at_me_activity, (ViewGroup) null);
        this.eGD.setContentView(this.rootView);
        this.eGL = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.eGM = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.eGM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eGM.setCenterTextTitle(getPageContext().getString(d.j.at_me));
        this.eGM.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.eGD.getPageContext());
        this.mPullView.setTag(this.eGD.getUniqueId());
        this.mPullView.a(this.eGD);
        this.cGR = new com.baidu.tbadk.mvc.g.a(this.eGD);
        this.cGR.np();
        this.mHeaderView = new TextView(this.eGD.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eGD.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jE());
        this.eGL.setPullRefresh(this.mPullView);
        this.eGL.addHeaderView(this.mHeaderView, 0);
        this.eGL.setNextPage(this.cGR);
        this.eGL.setDividerHeight(0);
        this.bvz = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.bvz.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bvz.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aQ(boolean z) {
                d.this.ib(z);
            }
        });
        this.eGL.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eGD.awt();
            }
        });
        this.eGK = new com.baidu.tbadk.mvc.f.d<>(this.eGD.getPageContext(), a.class, d.h.mention_atme_item, this.eGD.Kg());
        this.eGK.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eGD.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.du(d.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eGL.setAdapter((ListAdapter) this.eGK);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eGK != null) {
                this.eGK.I(fVar.aPh());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eGK != null) {
            this.eGK.b(tbPageContext, i);
        }
        if (this.cGR != null) {
            this.cGR.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        this.eGM.onChangeSkinType(tbPageContext, i);
    }

    public void aON() {
        if (this.eGL != null) {
            this.eGL.completePullRefreshPostDelayed(2000L);
        }
    }

    public void ib(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jE());
        if (z && this.eGL != null && this.eGL.getWrappedAdapter() != null && this.eGL.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.in().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.eGL.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cGR != null) {
                if (aVar.Ka()) {
                    this.cGR.oF();
                    if (aVar.JY()) {
                        this.cGR.fj(d.j.loading);
                    } else if (aVar.JZ()) {
                        this.cGR.fj(d.j.loading);
                    } else {
                        this.cGR.fk(d.j.no_more_msg);
                    }
                } else {
                    this.cGR.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aOO();
            } else {
                aON();
            }
        }
    }

    public void aOO() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.eGL != null) {
            this.eGL.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eGD);
        }
    }
}
