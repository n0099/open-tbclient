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
/* loaded from: classes10.dex */
public class j extends com.baidu.adp.base.c<Object> {
    private NoNetworkView fay;
    private TbPageContext<Object> hct;
    private g liA;
    private BdListView liz;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.hct = null;
        this.liz = null;
        this.mPullView = null;
        this.liA = null;
        this.hct = tbPageContext;
        this.mRoot = view;
        this.liz = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.liz.setOnKeyListener(onKeyListener);
        if (this.hct.getOrignalPage() instanceof f) {
            this.liz.setOnItemClickListener((f) this.hct.getOrignalPage());
        }
        this.liA = new g(tbPageContext);
        this.liz.setAdapter((ListAdapter) this.liA);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.liz.setPullRefresh(this.mPullView);
        this.fay = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.liA.a(hVar);
                    this.liA.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.liz.completePullRefreshPostDelayed(0L);
    }

    public void z(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.hct.showToast(str, true);
        }
    }

    public void dcD() {
        this.fay.setVisibility(0);
    }

    public void dcE() {
        this.fay.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fay.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fay.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.hct.getLayoutMode().setNightMode(i == 1);
        this.hct.getLayoutMode().onModeChanged(this.mRoot);
        this.liA.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fay.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.liz.removeHeaderView(this.mNoDataView);
        }
    }

    public void xC(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hct.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.lV(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.lV(i));
        this.mNoDataView.onChangeSkinType(this.hct, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.liz.removeHeaderView(this.mNoDataView);
        this.liz.addHeaderView(this.mNoDataView);
    }
}
