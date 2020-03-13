package com.baidu.tieba.square.square;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView fVd;
    private TbPageContext<Object> gdy;
    private BdListView kdA;
    private g kdB;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.h mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.gdy = null;
        this.kdA = null;
        this.mPullView = null;
        this.kdB = null;
        this.gdy = tbPageContext;
        this.mRoot = view;
        this.kdA = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.kdA.setOnKeyListener(onKeyListener);
        if (this.gdy.getOrignalPage() instanceof f) {
            this.kdA.setOnItemClickListener((f) this.gdy.getOrignalPage());
        }
        this.kdB = new g(tbPageContext);
        this.kdA.setAdapter((ListAdapter) this.kdB);
        this.mPullView = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.kdA.setPullRefresh(this.mPullView);
        this.fVd = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.kdB.a(hVar);
                    this.kdB.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.kdA.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.gdy.showToast(str, true);
        }
    }

    public void cJW() {
        this.fVd.setVisibility(0);
    }

    public void cJX() {
        this.fVd.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fVd.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fVd.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.gdy.getLayoutMode().setNightMode(i == 1);
        this.gdy.getLayoutMode().onModeChanged(this.mRoot);
        this.kdB.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fVd.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.kdA.removeHeaderView(this.mNoDataView);
        }
    }

    public void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gdy.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.lh(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(i));
        this.mNoDataView.onChangeSkinType(this.gdy, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.kdA.removeHeaderView(this.mNoDataView);
        this.kdA.addHeaderView(this.mNoDataView);
    }
}
