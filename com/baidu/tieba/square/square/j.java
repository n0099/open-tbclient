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
    private NoNetworkView fUQ;
    private TbPageContext<Object> gdl;
    private BdListView kdo;
    private g kdp;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.h mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.gdl = null;
        this.kdo = null;
        this.mPullView = null;
        this.kdp = null;
        this.gdl = tbPageContext;
        this.mRoot = view;
        this.kdo = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.kdo.setOnKeyListener(onKeyListener);
        if (this.gdl.getOrignalPage() instanceof f) {
            this.kdo.setOnItemClickListener((f) this.gdl.getOrignalPage());
        }
        this.kdp = new g(tbPageContext);
        this.kdo.setAdapter((ListAdapter) this.kdp);
        this.mPullView = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.kdo.setPullRefresh(this.mPullView);
        this.fUQ = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.kdp.a(hVar);
                    this.kdp.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.kdo.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.gdl.showToast(str, true);
        }
    }

    public void cJV() {
        this.fUQ.setVisibility(0);
    }

    public void cJW() {
        this.fUQ.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fUQ.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fUQ.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.gdl.getLayoutMode().setNightMode(i == 1);
        this.gdl.getLayoutMode().onModeChanged(this.mRoot);
        this.kdp.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fUQ.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.kdo.removeHeaderView(this.mNoDataView);
        }
    }

    public void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gdl.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.lh(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lh(i));
        this.mNoDataView.onChangeSkinType(this.gdl, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.kdo.removeHeaderView(this.mNoDataView);
        this.kdo.addHeaderView(this.mNoDataView);
    }
}
