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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView dnF;
    private com.baidu.tbadk.mvc.g.a eKE;
    private AtMessageActivity gUD;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> gUK;
    private BdListView gUL;
    private NavigationBar gUM;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.i mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.gUD = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View aLn() {
        this.rootView = this.gUD.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.gUD.setContentView(this.rootView);
        this.gUL = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.gUM = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.gUM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gUM.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.gUM.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.i(this.gUD.getPageContext());
        this.mPullView.setTag(this.gUD.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.gUD);
        this.eKE = new com.baidu.tbadk.mvc.g.a(this.gUD);
        this.eKE.nZ();
        this.mHeaderView = new TextView(this.gUD.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.g(this.gUD.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
        this.gUL.setPullRefresh(this.mPullView);
        this.gUL.addHeaderView(this.mHeaderView, 0);
        this.gUL.setNextPage(this.eKE);
        this.gUL.setDividerHeight(0);
        this.dnF = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.dnF.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.dnF.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void ep(boolean z) {
                d.this.mK(z);
            }
        });
        this.gUL.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.gUD.bot();
            }
        });
        this.gUK = new com.baidu.tbadk.mvc.f.d<>(this.gUD.getPageContext(), a.class, R.layout.mention_atme_item, this.gUD.auS());
        this.gUK.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, com.baidu.tbadk.core.util.i.cv(this.gUD)), NoDataViewFactory.d.iN(R.string.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.gUL.setAdapter((ListAdapter) this.gUK);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.gUK != null) {
                this.gUK.al(fVar.bIc());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.gUK != null) {
            this.gUK.b(tbPageContext, i);
        }
        if (this.eKE != null) {
            this.eKE.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        this.gUM.onChangeSkinType(tbPageContext, i);
    }

    public void bHJ() {
        if (this.gUL != null) {
            this.gUL.completePullRefreshPostDelayed(0L);
        }
    }

    public void mK(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.kc());
        if (z && this.gUL != null && this.gUL.getWrappedAdapter() != null && this.gUL.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.iK().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gUL.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.eKE != null) {
                if (aVar.auM()) {
                    this.eKE.qk();
                    if (aVar.auK()) {
                        this.eKE.kN(R.string.loading);
                    } else if (aVar.auL()) {
                        this.eKE.kN(R.string.loading);
                    } else {
                        this.eKE.kO(R.string.no_more_msg);
                    }
                } else {
                    this.eKE.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                bHK();
            } else {
                bHJ();
            }
        }
    }

    public void bHK() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.gUL != null) {
            this.gUL.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.gUD);
        }
    }
}
