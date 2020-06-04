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
/* loaded from: classes9.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView fci;
    private com.baidu.tbadk.mvc.g.a gJc;
    private AtMessageActivity iPh;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> iPo;
    private BdListView iPp;
    private NavigationBar iPq;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.g mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.iPh = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View btW() {
        this.rootView = this.iPh.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.iPh.setContentView(this.rootView);
        this.iPp = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.iPq = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.iPq.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iPq.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.iPq.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.g(this.iPh.getPageContext());
        this.mPullView.setTag(this.iPh.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.iPh);
        this.gJc = new com.baidu.tbadk.mvc.g.a(this.iPh);
        this.gJc.createView();
        this.mHeaderView = new TextView(this.iPh.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.iPh.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.iPp.setPullRefresh(this.mPullView);
        this.iPp.addHeaderView(this.mHeaderView, 0);
        this.iPp.setNextPage(this.gJc);
        this.iPp.setDividerHeight(0);
        this.fci = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.fci.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.fci.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.pI(z);
            }
        });
        this.iPp.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.iPh.bXH();
            }
        });
        this.iPo = new com.baidu.tbadk.mvc.f.d<>(this.iPh.getPageContext(), a.class, R.layout.mention_atme_item, this.iPh.bfn());
        this.iPo.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dJ(this.iPh)), NoDataViewFactory.d.dj(null, this.iPh.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.iPp.setAdapter((ListAdapter) this.iPo);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.iPo != null) {
                this.iPo.aP(fVar.crk());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.iPo != null) {
            this.iPo.b(tbPageContext, i);
        }
        if (this.gJc != null) {
            this.gJc.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.iPq.onChangeSkinType(tbPageContext, i);
    }

    public void cqR() {
        if (this.iPp != null) {
            this.iPp.completePullRefreshPostDelayed(0L);
        }
    }

    public void pI(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.iPp != null && this.iPp.getWrappedAdapter() != null && this.iPp.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.ld().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iPp.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.gJc != null) {
                if (aVar.bfi()) {
                    this.gJc.display();
                    if (aVar.bfg()) {
                        this.gJc.nz(R.string.loading);
                    } else if (aVar.bfh()) {
                        this.gJc.nz(R.string.loading);
                    } else {
                        this.gJc.nA(R.string.no_more_msg);
                    }
                } else {
                    this.gJc.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                cqS();
            } else {
                cqR();
            }
        }
    }

    public void cqS() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.iPp != null) {
            this.iPp.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.iPh);
        }
    }
}
