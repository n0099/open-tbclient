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
    private NoNetworkView fCq;
    private TbPageContext<Object> hHM;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView mbK;
    private g mbL;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.hHM = null;
        this.mbK = null;
        this.mPullView = null;
        this.mbL = null;
        this.hHM = tbPageContext;
        this.mRoot = view;
        this.mbK = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.mbK.setOnKeyListener(onKeyListener);
        if (this.hHM.getOrignalPage() instanceof f) {
            this.mbK.setOnItemClickListener((f) this.hHM.getOrignalPage());
        }
        this.mbL = new g(tbPageContext);
        this.mbK.setAdapter((ListAdapter) this.mbL);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.mbK.setPullRefresh(this.mPullView);
        this.fCq = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.mbL.a(hVar);
                    this.mbL.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.mbK.completePullRefreshPostDelayed(0L);
    }

    public void C(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.hHM.showToast(str, true);
        }
    }

    public void dvE() {
        this.fCq.setVisibility(0);
    }

    public void dvF() {
        this.fCq.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fCq.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fCq.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.hHM.getLayoutMode().setNightMode(i == 1);
        this.hHM.getLayoutMode().onModeChanged(this.mRoot);
        this.mbL.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fCq.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mbK.removeHeaderView(this.mNoDataView);
        }
    }

    public void Bd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hHM.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.oK(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oK(i));
        this.mNoDataView.onChangeSkinType(this.hHM, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.mbK.removeHeaderView(this.mNoDataView);
        this.mbK.addHeaderView(this.mNoDataView);
    }
}
