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
/* loaded from: classes7.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView fPl;
    private TbPageContext<Object> fXZ;
    private BdListView jYF;
    private g jYG;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.h mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.fXZ = null;
        this.jYF = null;
        this.mPullView = null;
        this.jYG = null;
        this.fXZ = tbPageContext;
        this.mRoot = view;
        this.jYF = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.jYF.setOnKeyListener(onKeyListener);
        if (this.fXZ.getOrignalPage() instanceof f) {
            this.jYF.setOnItemClickListener((f) this.fXZ.getOrignalPage());
        }
        this.jYG = new g(tbPageContext);
        this.jYF.setAdapter((ListAdapter) this.jYG);
        this.mPullView = new com.baidu.tbadk.core.view.h(tbPageContext);
        this.jYF.setPullRefresh(this.mPullView);
        this.fPl = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.jYG.a(hVar);
                    this.jYG.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.jYF.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.fXZ.showToast(str, true);
        }
    }

    public void cHj() {
        this.fPl.setVisibility(0);
    }

    public void cHk() {
        this.fPl.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fPl.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fPl.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.fXZ.getLayoutMode().setNightMode(i == 1);
        this.fXZ.getLayoutMode().onModeChanged(this.mRoot);
        this.jYG.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fPl.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(g.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.jYF.removeHeaderView(this.mNoDataView);
        }
    }

    public void wd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fXZ.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.kQ(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.kQ(i));
        this.mNoDataView.onChangeSkinType(this.fXZ, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.jYF.removeHeaderView(this.mNoDataView);
        this.jYF.addHeaderView(this.mNoDataView);
    }
}
