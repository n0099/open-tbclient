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
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView bla;
    private com.baidu.tbadk.mvc.g.a cwJ;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> emE;
    private BdListView emF;
    private NavigationBar emG;
    private AtMessageActivity emx;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.f mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.emx = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Rn() {
        this.rootView = this.emx.getActivity().getLayoutInflater().inflate(d.i.at_me_activity, (ViewGroup) null);
        this.emx.setContentView(this.rootView);
        this.emF = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.emG = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.emG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.emG.setCenterTextTitle(getPageContext().getString(d.k.at_me));
        this.emG.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.f(this.emx.getPageContext());
        this.mPullView.setTag(this.emx.getUniqueId());
        this.mPullView.a(this.emx);
        this.cwJ = new com.baidu.tbadk.mvc.g.a(this.emx);
        this.cwJ.kA();
        this.mHeaderView = new TextView(this.emx.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.emx.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
        this.emF.setPullRefresh(this.mPullView);
        this.emF.addHeaderView(this.mHeaderView, 0);
        this.emF.setNextPage(this.cwJ);
        this.emF.setDividerHeight(0);
        this.bla = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.bla.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bla.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                d.this.hH(z);
            }
        });
        this.emF.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.emx.arh();
            }
        });
        this.emE = new com.baidu.tbadk.mvc.f.d<>(this.emx.getPageContext(), a.class, d.i.mention_atme_item, this.emx.Gn());
        this.emE.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.emx.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.k.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.emF.setAdapter((ListAdapter) this.emE);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.emE != null) {
                this.emE.F(fVar.aIH());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.emE != null) {
            this.emE.b(tbPageContext, i);
        }
        if (this.cwJ != null) {
            this.cwJ.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        this.emG.onChangeSkinType(tbPageContext, i);
    }

    public void aIo() {
        if (this.emF != null) {
            this.emF.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hH(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
        if (z && this.emF != null && this.emF.getWrappedAdapter() != null && this.emF.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.emF.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cwJ != null) {
                if (aVar.Gh()) {
                    this.cwJ.lN();
                    if (aVar.Gf()) {
                        this.cwJ.fd(d.k.loading);
                    } else if (aVar.Gg()) {
                        this.cwJ.fd(d.k.loading);
                    } else {
                        this.cwJ.fe(d.k.no_more_msg);
                    }
                } else {
                    this.cwJ.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aIp();
            } else {
                aIo();
            }
        }
    }

    public void aIp() {
        if (this.mPullView != null) {
            this.mPullView.a((e.b) null);
        }
        if (this.emF != null) {
            this.emF.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.emx);
        }
    }
}
