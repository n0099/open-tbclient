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
    private View anK;
    private com.baidu.tbadk.mvc.g.a bOW;
    private NoNetworkView bes;
    private AtMessageActivity dFI;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dFP;
    private BdListView dFQ;
    private NavigationBar dFR;
    protected com.baidu.tbadk.core.view.l mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dFI = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Yj() {
        this.rootView = this.dFI.getActivity().getLayoutInflater().inflate(d.j.at_me_activity, (ViewGroup) null);
        this.dFI.setContentView(this.rootView);
        this.dFQ = (BdListView) this.rootView.findViewById(d.h.atme_lv);
        this.dFR = (NavigationBar) this.rootView.findViewById(d.h.view_navigation_bar);
        this.dFR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFR.setTitleText(d.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dFI.getPageContext());
        this.mPullView.setTag(this.dFI.getUniqueId());
        this.mPullView.a(this.dFI);
        this.bOW = new com.baidu.tbadk.mvc.g.a(this.dFI);
        this.bOW.lj();
        this.anK = new TextView(this.dFI.getPageContext().getPageActivity());
        this.anK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dFI.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.anK, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        this.dFQ.setPullRefresh(this.mPullView);
        this.dFQ.addHeaderView(this.anK, 0);
        this.dFQ.setNextPage(this.bOW);
        this.dFQ.setDividerHeight(0);
        this.bes = (NoNetworkView) this.rootView.findViewById(d.h.no_networkview);
        this.bes.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bes.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                d.this.gY(z);
            }
        });
        this.dFQ.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dFI.Nv();
            }
        });
        this.dFP = new com.baidu.tbadk.mvc.f.d<>(this.dFI.getPageContext(), a.class, d.j.mention_atme_item, this.dFI.FN());
        this.dFP.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dFI.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dk(d.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dFQ.setAdapter((ListAdapter) this.dFP);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dFP != null) {
                this.dFP.D(fVar.aAc());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dFP != null) {
            this.dFP.b(tbPageContext, i);
        }
        if (this.bOW != null) {
            this.bOW.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
        this.dFR.onChangeSkinType(tbPageContext, i);
    }

    public void azU() {
        if (this.dFQ != null) {
            this.dFQ.completePullRefreshPostDelayed(2000L);
        }
    }

    public void gY(boolean z) {
        BdListViewHelper.a(this.anK, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        if (z && this.dFQ != null && this.dFQ.getWrappedAdapter() != null && this.dFQ.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dFQ.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bOW != null) {
                if (aVar.FH()) {
                    this.bOW.lS();
                    if (aVar.FF()) {
                        this.bOW.fc(d.l.loading);
                    } else if (aVar.FG()) {
                        this.bOW.fc(d.l.loading);
                    } else {
                        this.bOW.fd(d.l.no_more_msg);
                    }
                } else {
                    this.bOW.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                azV();
            } else {
                azU();
            }
        }
    }

    public void azV() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dFQ != null) {
            this.dFQ.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dFI);
        }
    }
}
