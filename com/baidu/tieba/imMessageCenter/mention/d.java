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
    private NoNetworkView ePl;
    private com.baidu.tbadk.mvc.g.a gua;
    private AtMessageActivity izH;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> izO;
    private BdListView izP;
    private NavigationBar izQ;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.h mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.izH = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View boo() {
        this.rootView = this.izH.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.izH.setContentView(this.rootView);
        this.izP = (BdListView) this.rootView.findViewById(R.id.atme_lv);
        this.izQ = (NavigationBar) this.rootView.findViewById(R.id.view_navigation_bar);
        this.izQ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.izQ.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.izQ.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.h(this.izH.getPageContext());
        this.mPullView.setTag(this.izH.getUniqueId());
        this.mPullView.setListPullRefreshListener(this.izH);
        this.gua = new com.baidu.tbadk.mvc.g.a(this.izH);
        this.gua.createView();
        this.mHeaderView = new TextView(this.izH.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.getDimens(this.izH.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        this.izP.setPullRefresh(this.mPullView);
        this.izP.addHeaderView(this.mHeaderView, 0);
        this.izP.setNextPage(this.gua);
        this.izP.setDividerHeight(0);
        this.ePl = (NoNetworkView) this.rootView.findViewById(R.id.no_networkview);
        this.ePl.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.ePl.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void onNetworkChange(boolean z) {
                d.this.pm(z);
            }
        });
        this.izP.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void v(BdListView bdListView) {
                d.this.izH.bRk();
            }
        });
        this.izO = new com.baidu.tbadk.mvc.f.d<>(this.izH.getPageContext(), a.class, R.layout.mention_atme_item, this.izH.aZe());
        this.izO.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, com.baidu.tbadk.core.util.i.dD(this.izH)), NoDataViewFactory.d.cK(null, this.izH.getResources().getString(R.string.mention_atme_nodata)), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.izP.setAdapter((ListAdapter) this.izO);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.izO != null) {
                this.izO.aU(fVar.ckE());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.izO != null) {
            this.izO.b(tbPageContext, i);
        }
        if (this.gua != null) {
            this.gua.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        this.izQ.onChangeSkinType(tbPageContext, i);
    }

    public void ckl() {
        if (this.izP != null) {
            this.izP.completePullRefreshPostDelayed(0L);
        }
    }

    public void pm(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.isNetWorkAvailable());
        if (z && this.izP != null && this.izP.getWrappedAdapter() != null && this.izP.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.f.e.lb().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.izP.startPullRefresh();
                }
            });
        }
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.gua != null) {
                if (aVar.aYZ()) {
                    this.gua.display();
                    if (aVar.aYX()) {
                        this.gua.mV(R.string.loading);
                    } else if (aVar.aYY()) {
                        this.gua.mV(R.string.loading);
                    } else {
                        this.gua.mW(R.string.no_more_msg);
                    }
                } else {
                    this.gua.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                ckm();
            } else {
                ckl();
            }
        }
    }

    public void ckm() {
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(null);
        }
        if (this.izP != null) {
            this.izP.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.setListPullRefreshListener(this.izH);
        }
    }
}
