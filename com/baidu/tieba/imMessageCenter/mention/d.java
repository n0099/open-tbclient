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
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private View amq;
    private com.baidu.tbadk.mvc.g.a bNc;
    private NoNetworkView bdg;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dCB;
    private BdListView dCC;
    private NavigationBar dCD;
    private AtMessageActivity dCu;
    protected com.baidu.tbadk.core.view.l mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dCu = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View XM() {
        this.rootView = this.dCu.getActivity().getLayoutInflater().inflate(d.j.at_me_activity, (ViewGroup) null);
        this.dCu.setContentView(this.rootView);
        this.dCC = (BdListView) this.rootView.findViewById(d.h.atme_lv);
        this.dCD = (NavigationBar) this.rootView.findViewById(d.h.view_navigation_bar);
        this.dCD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dCD.setTitleText(d.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dCu.getPageContext());
        this.mPullView.setTag(this.dCu.getUniqueId());
        this.mPullView.a(this.dCu);
        this.bNc = new com.baidu.tbadk.mvc.g.a(this.dCu);
        this.bNc.la();
        this.amq = new TextView(this.dCu.getPageContext().getPageActivity());
        this.amq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dCu.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.amq, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hh());
        this.dCC.setPullRefresh(this.mPullView);
        this.dCC.addHeaderView(this.amq, 0);
        this.dCC.setNextPage(this.bNc);
        this.dCC.setDividerHeight(0);
        this.bdg = (NoNetworkView) this.rootView.findViewById(d.h.no_networkview);
        this.bdg.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bdg.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                d.this.gV(z);
            }
        });
        this.dCC.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dCu.Nq();
            }
        });
        this.dCB = new com.baidu.tbadk.mvc.f.d<>(this.dCu.getPageContext(), a.class, d.j.mention_atme_item, this.dCu.FF());
        this.dCB.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dCu.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.di(d.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dCC.setAdapter((ListAdapter) this.dCB);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dCB != null) {
                this.dCB.D(fVar.azp());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dCB != null) {
            this.dCB.b(tbPageContext, i);
        }
        if (this.bNc != null) {
            this.bNc.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dn(i);
        }
        this.dCD.onChangeSkinType(tbPageContext, i);
    }

    public void azh() {
        if (this.dCC != null) {
            this.dCC.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gV(boolean z) {
        BdListViewHelper.a(this.amq, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hh());
        if (z && this.dCC != null && this.dCC.getWrappedAdapter() != null && this.dCC.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dCC.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bNc != null) {
                if (aVar.Fz()) {
                    this.bNc.lJ();
                    if (aVar.Fx()) {
                        this.bNc.fa(d.l.loading);
                    } else if (aVar.Fy()) {
                        this.bNc.fa(d.l.loading);
                    } else {
                        this.bNc.fb(d.l.no_more_msg);
                    }
                } else {
                    this.bNc.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                azi();
            } else {
                azh();
            }
        }
    }

    public void azi() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dCC != null) {
            this.dCC.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dCu);
        }
    }
}
