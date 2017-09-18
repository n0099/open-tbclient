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
    private View anc;
    private com.baidu.tbadk.mvc.g.a bSG;
    private NoNetworkView bem;
    private AtMessageActivity dNg;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> dNn;
    private BdListView dNo;
    private NavigationBar dNp;
    protected com.baidu.tbadk.core.view.l mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dNg = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Zx() {
        this.rootView = this.dNg.getActivity().getLayoutInflater().inflate(d.j.at_me_activity, (ViewGroup) null);
        this.dNg.setContentView(this.rootView);
        this.dNo = (BdListView) this.rootView.findViewById(d.h.atme_lv);
        this.dNp = (NavigationBar) this.rootView.findViewById(d.h.view_navigation_bar);
        this.dNp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dNp.setTitleText(d.l.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dNg.getPageContext());
        this.mPullView.setTag(this.dNg.getUniqueId());
        this.mPullView.a(this.dNg);
        this.bSG = new com.baidu.tbadk.mvc.g.a(this.dNg);
        this.bSG.lb();
        this.anc = new TextView(this.dNg.getPageContext().getPageActivity());
        this.anc.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.f(this.dNg.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.anc, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        this.dNo.setPullRefresh(this.mPullView);
        this.dNo.addHeaderView(this.anc, 0);
        this.dNo.setNextPage(this.bSG);
        this.dNo.setDividerHeight(0);
        this.bem = (NoNetworkView) this.rootView.findViewById(d.h.no_networkview);
        this.bem.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bem.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                d.this.hh(z);
            }
        });
        this.dNo.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.dNg.NM();
            }
        });
        this.dNn = new com.baidu.tbadk.mvc.f.d<>(this.dNg.getPageContext(), a.class, d.j.mention_atme_item, this.dNg.FL());
        this.dNn.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dNg.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dl(d.l.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dNo.setAdapter((ListAdapter) this.dNn);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dNn != null) {
                this.dNn.D(fVar.aCc());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dNn != null) {
            this.dNn.b(tbPageContext, i);
        }
        if (this.bSG != null) {
            this.bSG.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
        this.dNp.onChangeSkinType(tbPageContext, i);
    }

    public void aBU() {
        if (this.dNo != null) {
            this.dNo.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hh(boolean z) {
        BdListViewHelper.a(this.anc, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        if (z && this.dNo != null && this.dNo.getWrappedAdapter() != null && this.dNo.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dNo.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bSG != null) {
                if (aVar.FF()) {
                    this.bSG.lK();
                    if (aVar.FD()) {
                        this.bSG.fc(d.l.loading);
                    } else if (aVar.FE()) {
                        this.bSG.fc(d.l.loading);
                    } else {
                        this.bSG.fd(d.l.no_more_msg);
                    }
                } else {
                    this.bSG.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aBV();
            } else {
                aBU();
            }
        }
    }

    public void aBV() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dNo != null) {
            this.dNo.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dNg);
        }
    }
}
