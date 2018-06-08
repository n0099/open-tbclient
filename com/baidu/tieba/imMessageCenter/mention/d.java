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
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView btu;
    private com.baidu.tbadk.mvc.g.a cGs;
    private AtMessageActivity eyU;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> ezb;
    private BdListView ezc;
    private NavigationBar ezd;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.eyU = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View UI() {
        this.rootView = this.eyU.getActivity().getLayoutInflater().inflate(d.i.at_me_activity, (ViewGroup) null);
        this.eyU.setContentView(this.rootView);
        this.ezc = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.ezd = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.ezd.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ezd.setCenterTextTitle(getPageContext().getString(d.k.at_me));
        this.ezd.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.eyU.getPageContext());
        this.mPullView.setTag(this.eyU.getUniqueId());
        this.mPullView.a(this.eyU);
        this.cGs = new com.baidu.tbadk.mvc.g.a(this.eyU);
        this.cGs.nn();
        this.mHeaderView = new TextView(this.eyU.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.eyU.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jD());
        this.ezc.setPullRefresh(this.mPullView);
        this.ezc.addHeaderView(this.mHeaderView, 0);
        this.ezc.setNextPage(this.cGs);
        this.ezc.setDividerHeight(0);
        this.btu = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.btu.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.btu.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aQ(boolean z) {
                d.this.hO(z);
            }
        });
        this.ezc.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.eyU.avl();
            }
        });
        this.ezb = new com.baidu.tbadk.mvc.f.d<>(this.eyU.getPageContext(), a.class, d.i.mention_atme_item, this.eyU.JT());
        this.ezb.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eyU.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dr(d.k.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.ezc.setAdapter((ListAdapter) this.ezb);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.ezb != null) {
                this.ezb.I(fVar.aNB());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.ezb != null) {
            this.ezb.b(tbPageContext, i);
        }
        if (this.cGs != null) {
            this.cGs.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        this.ezd.onChangeSkinType(tbPageContext, i);
    }

    public void aNh() {
        if (this.ezc != null) {
            this.ezc.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hO(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.jD());
        if (z && this.ezc != null && this.ezc.getWrappedAdapter() != null && this.ezc.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.im().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ezc.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cGs != null) {
                if (aVar.JN()) {
                    this.cGs.oD();
                    if (aVar.JL()) {
                        this.cGs.fh(d.k.loading);
                    } else if (aVar.JM()) {
                        this.cGs.fh(d.k.loading);
                    } else {
                        this.cGs.fi(d.k.no_more_msg);
                    }
                } else {
                    this.cGs.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aNi();
            } else {
                aNh();
            }
        }
    }

    public void aNi() {
        if (this.mPullView != null) {
            this.mPullView.a((f.b) null);
        }
        if (this.ezc != null) {
            this.ezc.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eyU);
        }
    }
}
