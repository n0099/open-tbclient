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
/* loaded from: classes23.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView gbO;
    private TbPageContext<Object> iqk;
    private NoDataView mNoDataView;
    private BdListView mNv;
    private g mNw;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.iqk = null;
        this.mNv = null;
        this.mPullView = null;
        this.mNw = null;
        this.iqk = tbPageContext;
        this.mRoot = view;
        this.mNv = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.mNv.setOnKeyListener(onKeyListener);
        if (this.iqk.getOrignalPage() instanceof f) {
            this.mNv.setOnItemClickListener((f) this.iqk.getOrignalPage());
        }
        this.mNw = new g(tbPageContext);
        this.mNv.setAdapter((ListAdapter) this.mNw);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.mNv.setPullRefresh(this.mPullView);
        this.gbO = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.mNw.a(hVar);
                    this.mNw.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.mNv.completePullRefreshPostDelayed(0L);
    }

    public void E(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.iqk.showToast(str, true);
        }
    }

    public void dGq() {
        this.gbO.setVisibility(0);
    }

    public void dGr() {
        this.gbO.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.gbO.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.gbO.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.iqk.getLayoutMode().setNightMode(i == 1);
        this.iqk.getLayoutMode().onModeChanged(this.mRoot);
        this.mNw.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.gbO.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mNv.removeHeaderView(this.mNoDataView);
        }
    }

    public void CD(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iqk.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.pG(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pG(i));
        this.mNoDataView.onChangeSkinType(this.iqk, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.mNv.removeHeaderView(this.mNoDataView);
        this.mNv.addHeaderView(this.mNoDataView);
    }
}
