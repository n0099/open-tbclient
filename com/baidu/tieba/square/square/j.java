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
    private NoNetworkView flI;
    private TbPageContext<Object> hoE;
    private BdListView lCv;
    private g lCw;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.hoE = null;
        this.lCv = null;
        this.mPullView = null;
        this.lCw = null;
        this.hoE = tbPageContext;
        this.mRoot = view;
        this.lCv = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.lCv.setOnKeyListener(onKeyListener);
        if (this.hoE.getOrignalPage() instanceof f) {
            this.lCv.setOnItemClickListener((f) this.hoE.getOrignalPage());
        }
        this.lCw = new g(tbPageContext);
        this.lCv.setAdapter((ListAdapter) this.lCw);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.lCv.setPullRefresh(this.mPullView);
        this.flI = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.lCw.a(hVar);
                    this.lCw.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.lCv.completePullRefreshPostDelayed(0L);
    }

    public void B(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.hoE.showToast(str, true);
        }
    }

    public void dgS() {
        this.flI.setVisibility(0);
    }

    public void dgT() {
        this.flI.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.flI.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.flI.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.hoE.getLayoutMode().setNightMode(i == 1);
        this.hoE.getLayoutMode().onModeChanged(this.mRoot);
        this.lCw.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.flI.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.lCv.removeHeaderView(this.mNoDataView);
        }
    }

    public void ym(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.hoE.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.mm(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.mm(i));
        this.mNoDataView.onChangeSkinType(this.hoE, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.lCv.removeHeaderView(this.mNoDataView);
        this.lCv.addHeaderView(this.mNoDataView);
    }
}
