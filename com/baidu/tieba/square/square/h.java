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
    private NoNetworkView fbw;
    private TbPageContext<Object> fkq;
    private BdListView jfk;
    private e jfl;
    private NoDataView mNoDataView;
    i mPullView;
    private View mRoot;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.fkq = null;
        this.jfk = null;
        this.mPullView = null;
        this.jfl = null;
        this.fkq = tbPageContext;
        this.mRoot = view;
        this.jfk = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.jfk.setOnKeyListener(onKeyListener);
        if (this.fkq.getOrignalPage() instanceof SquareActivity) {
            this.jfk.setOnItemClickListener((SquareActivity) this.fkq.getOrignalPage());
        }
        this.jfl = new e(tbPageContext);
        this.jfk.setAdapter((ListAdapter) this.jfl);
        this.mPullView = new i(tbPageContext);
        this.jfk.setPullRefresh(this.mPullView);
        this.fbw = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(f fVar) {
        if (fVar != null) {
            try {
                if (!fVar.isEmpty()) {
                    this.jfl.a(fVar);
                    this.jfl.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.jfk.completePullRefreshPostDelayed(0L);
    }

    public void y(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.fkq.showToast(str, true);
        }
    }

    public void cnf() {
        this.fbw.setVisibility(0);
    }

    public void cng() {
        this.fbw.setVisibility(8);
    }

    public void d(NoNetworkView.a aVar) {
        this.fbw.a(aVar);
    }

    public void e(NoNetworkView.a aVar) {
        this.fbw.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.fkq.getLayoutMode().setNightMode(i == 1);
        this.fkq.getLayoutMode().onModeChanged(this.mRoot);
        this.jfl.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fbw.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(h.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.jfk.removeHeaderView(this.mNoDataView);
        }
    }

    public void uc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fkq.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.iL(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iL(i));
        this.mNoDataView.onChangeSkinType(this.fkq, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.jfk.removeHeaderView(this.mNoDataView);
        this.jfk.addHeaderView(this.mNoDataView);
    }
}
