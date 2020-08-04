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
/* loaded from: classes17.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView fqQ;
    private TbPageContext<Object> huq;
    private BdListView lJM;
    private g lJN;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.huq = null;
        this.lJM = null;
        this.mPullView = null;
        this.lJN = null;
        this.huq = tbPageContext;
        this.mRoot = view;
        this.lJM = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.lJM.setOnKeyListener(onKeyListener);
        if (this.huq.getOrignalPage() instanceof f) {
            this.lJM.setOnItemClickListener((f) this.huq.getOrignalPage());
        }
        this.lJN = new g(tbPageContext);
        this.lJM.setAdapter((ListAdapter) this.lJN);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.lJM.setPullRefresh(this.mPullView);
        this.fqQ = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.lJN.a(hVar);
                    this.lJN.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.lJM.completePullRefreshPostDelayed(0L);
    }

    public void B(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.huq.showToast(str, true);
        }
    }

    public void dkc() {
        this.fqQ.setVisibility(0);
    }

    public void dkd() {
        this.fqQ.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fqQ.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fqQ.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.huq.getLayoutMode().setNightMode(i == 1);
        this.huq.getLayoutMode().onModeChanged(this.mRoot);
        this.lJN.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fqQ.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.lJM.removeHeaderView(this.mNoDataView);
        }
    }

    public void yK(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.huq.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.mF(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.mF(i));
        this.mNoDataView.onChangeSkinType(this.huq, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.lJM.removeHeaderView(this.mNoDataView);
        this.lJM.addHeaderView(this.mNoDataView);
    }
}
