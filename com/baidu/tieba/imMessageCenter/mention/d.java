package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView bOx;
    private com.baidu.tbadk.mvc.g.a dcN;
    private AtMessageActivity fdE;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> fdL;
    private BdListView fdM;
    private NavigationBar fdN;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.k mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.fdE = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View acb() {
        this.rootView = this.fdE.getActivity().getLayoutInflater().inflate(e.h.at_me_activity, (ViewGroup) null);
        this.fdE.setContentView(this.rootView);
        this.fdM = (BdListView) this.rootView.findViewById(e.g.atme_lv);
        this.fdN = (NavigationBar) this.rootView.findViewById(e.g.view_navigation_bar);
        this.fdN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.fdN.setCenterTextTitle(getPageContext().getString(e.j.at_me));
        this.fdN.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.k(this.fdE.getPageContext());
        this.mPullView.setTag(this.fdE.getUniqueId());
        this.mPullView.a(this.fdE);
        this.dcN = new com.baidu.tbadk.mvc.g.a(this.fdE);
        this.dcN.oD();
        this.mHeaderView = new TextView(this.fdE.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.h(this.fdE.getPageContext().getPageActivity(), e.C0210e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        this.fdM.setPullRefresh(this.mPullView);
        this.fdM.addHeaderView(this.mHeaderView, 0);
        this.fdM.setNextPage(this.dcN);
        this.fdM.setDividerHeight(0);
        this.bOx = (NoNetworkView) this.rootView.findViewById(e.g.no_networkview);
        this.bOx.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bOx.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bF(boolean z) {
                d.this.jd(z);
            }
        });
        this.fdM.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.fdE.aDe();
            }
        });
        this.fdL = new com.baidu.tbadk.mvc.f.d<>(this.fdE.getPageContext(), a.class, e.h.mention_atme_item, this.fdE.OL());
        this.fdL.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.fdE.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.fdM.setAdapter((ListAdapter) this.fdL);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.fdL != null) {
                this.fdL.R(fVar.aVV());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.fdL != null) {
            this.fdL.b(tbPageContext, i);
        }
        if (this.dcN != null) {
            this.dcN.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        this.fdN.onChangeSkinType(tbPageContext, i);
    }

    public void aVB() {
        if (this.fdM != null) {
            this.fdM.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public void jd(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kV());
        if (z && this.fdM != null && this.fdM.getWrappedAdapter() != null && this.fdM.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.jG().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.fdM.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.dcN != null) {
                if (aVar.OF()) {
                    this.dcN.pN();
                    if (aVar.OD()) {
                        this.dcN.gf(e.j.loading);
                    } else if (aVar.OE()) {
                        this.dcN.gf(e.j.loading);
                    } else {
                        this.dcN.gg(e.j.no_more_msg);
                    }
                } else {
                    this.dcN.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aVC();
            } else {
                aVB();
            }
        }
    }

    public void aVC() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.fdM != null) {
            this.fdM.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.fdE);
        }
    }
}
