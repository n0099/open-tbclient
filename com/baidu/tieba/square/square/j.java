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
    private NoNetworkView fCm;
    private TbPageContext<Object> hHG;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;
    private BdListView mbv;
    private g mbw;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.hHG = null;
        this.mbv = null;
        this.mPullView = null;
        this.mbw = null;
        this.hHG = tbPageContext;
        this.mRoot = view;
        this.mbv = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.mbv.setOnKeyListener(onKeyListener);
        if (this.hHG.getOrignalPage() instanceof f) {
            this.mbv.setOnItemClickListener((f) this.hHG.getOrignalPage());
        }
        this.mbw = new g(tbPageContext);
        this.mbv.setAdapter((ListAdapter) this.mbw);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.mbv.setPullRefresh(this.mPullView);
        this.fCm = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.mbw.a(hVar);
                    this.mbw.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.mbv.completePullRefreshPostDelayed(0L);
    }

    public void C(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.hHG.showToast(str, true);
        }
    }

    public void dvz() {
        this.fCm.setVisibility(0);
    }

    public void dvA() {
        this.fCm.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fCm.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fCm.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.hHG.getLayoutMode().setNightMode(i == 1);
        this.hHG.getLayoutMode().onModeChanged(this.mRoot);
        this.mbw.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fCm.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mbv.removeHeaderView(this.mNoDataView);
        }
    }

    public void Bd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hHG.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.oK(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.oK(i));
        this.mNoDataView.onChangeSkinType(this.hHG, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.mbv.removeHeaderView(this.mNoDataView);
        this.mbv.addHeaderView(this.mNoDataView);
    }
}
