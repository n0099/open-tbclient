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
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView fFC;
    private TbPageContext<Object> hON;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView mlk;
    private g mll;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.hON = null;
        this.mlk = null;
        this.mPullView = null;
        this.mll = null;
        this.hON = tbPageContext;
        this.mRoot = view;
        this.mlk = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.mlk.setOnKeyListener(onKeyListener);
        if (this.hON.getOrignalPage() instanceof f) {
            this.mlk.setOnItemClickListener((f) this.hON.getOrignalPage());
        }
        this.mll = new g(tbPageContext);
        this.mlk.setAdapter((ListAdapter) this.mll);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.mlk.setPullRefresh(this.mPullView);
        this.fFC = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.mll.a(hVar);
                    this.mll.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.mlk.completePullRefreshPostDelayed(0L);
    }

    public void C(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.hON.showToast(str, true);
        }
    }

    public void dzx() {
        this.fFC.setVisibility(0);
    }

    public void dzy() {
        this.fFC.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fFC.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fFC.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.hON.getLayoutMode().setNightMode(i == 1);
        this.hON.getLayoutMode().onModeChanged(this.mRoot);
        this.mll.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fFC.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mlk.removeHeaderView(this.mNoDataView);
        }
    }

    public void BE(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hON.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.oW(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oW(i));
        this.mNoDataView.onChangeSkinType(this.hON, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.mlk.removeHeaderView(this.mNoDataView);
        this.mlk.addHeaderView(this.mNoDataView);
    }
}
