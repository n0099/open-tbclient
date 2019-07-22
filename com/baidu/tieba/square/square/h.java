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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.view.i;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class h extends com.baidu.adp.base.c<Object> {
    private NoNetworkView eWV;
    private TbPageContext<Object> ffp;
    private BdListView jbU;
    private e jbV;
    private NoDataView mNoDataView;
    i mPullView;
    private View mRoot;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.ffp = null;
        this.jbU = null;
        this.mPullView = null;
        this.jbV = null;
        this.ffp = tbPageContext;
        this.mRoot = view;
        this.jbU = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.jbU.setOnKeyListener(onKeyListener);
        if (this.ffp.getOrignalPage() instanceof SquareActivity) {
            this.jbU.setOnItemClickListener((SquareActivity) this.ffp.getOrignalPage());
        }
        this.jbV = new e(tbPageContext);
        this.jbU.setAdapter((ListAdapter) this.jbV);
        this.mPullView = new i(tbPageContext);
        this.jbU.setPullRefresh(this.mPullView);
        this.eWV = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.jbV.a(fVar);
                    this.jbV.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void oT() {
        this.jbU.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        oT();
        if (!z && str != null) {
            this.ffp.showToast(str, true);
        }
    }

    public void coj() {
        this.eWV.setVisibility(0);
    }

    public void cok() {
        this.eWV.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.eWV.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.eWV.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.ffp.getLayoutMode().setNightMode(i == 1);
        this.ffp.getLayoutMode().onModeChanged(this.mRoot);
        this.jbV.onChangeSkinType(i);
        this.mPullView.iV(i);
        this.eWV.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.jbU.removeHeaderView(this.mNoDataView);
        }
    }

    public void oW(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ffp.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.iN(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(i));
        this.mNoDataView.onChangeSkinType(this.ffp, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.jbU.removeHeaderView(this.mNoDataView);
        this.jbU.addHeaderView(this.mNoDataView);
    }
}
