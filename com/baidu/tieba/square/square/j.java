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
    private NoNetworkView fRL;
    private TbPageContext<Object> idM;
    private BdListView mAL;
    private g mAM;
    private NoDataView mNoDataView;
    com.baidu.tbadk.core.view.g mPullView;
    private View mRoot;

    public j(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.mPullView.setTag(bdUniqueId);
    }

    public j(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.idM = null;
        this.mAL = null;
        this.mPullView = null;
        this.mAM = null;
        this.idM = tbPageContext;
        this.mRoot = view;
        this.mAL = (BdListView) this.mRoot.findViewById(R.id.square_list);
        this.mAL.setOnKeyListener(onKeyListener);
        if (this.idM.getOrignalPage() instanceof f) {
            this.mAL.setOnItemClickListener((f) this.idM.getOrignalPage());
        }
        this.mAM = new g(tbPageContext);
        this.mAL.setAdapter((ListAdapter) this.mAM);
        this.mPullView = new com.baidu.tbadk.core.view.g(tbPageContext);
        this.mAL.setPullRefresh(this.mPullView);
        this.fRL = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
    }

    public View getRootView() {
        return this.mRoot;
    }

    public void c(h hVar) {
        if (hVar != null) {
            try {
                if (!hVar.isEmpty()) {
                    this.mAM.a(hVar);
                    this.mAM.notifyDataSetChanged();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void completeRefresh() {
        this.mAL.completePullRefreshPostDelayed(0L);
    }

    public void C(boolean z, String str) {
        completeRefresh();
        if (!z && str != null) {
            this.idM.showToast(str, true);
        }
    }

    public void dDi() {
        this.fRL.setVisibility(0);
    }

    public void dDj() {
        this.fRL.setVisibility(8);
    }

    public void c(NoNetworkView.a aVar) {
        this.fRL.a(aVar);
    }

    public void d(NoNetworkView.a aVar) {
        this.fRL.b(aVar);
    }

    public void onChangeSkinType(int i) {
        this.idM.getLayoutMode().setNightMode(i == 1);
        this.idM.getLayoutMode().onModeChanged(this.mRoot);
        this.mAM.onChangeSkinType(i);
        this.mPullView.changeSkin(i);
        this.fRL.onChangeSkinType(this.mContext, i);
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.mPullView.setListPullRefreshListener(cVar);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mAL.removeHeaderView(this.mNoDataView);
        }
    }

    public void Ck(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.idM.getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.d.pv(i), null);
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.pv(i));
        this.mNoDataView.onChangeSkinType(this.idM, TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
        this.mAL.removeHeaderView(this.mNoDataView);
        this.mAL.addHeaderView(this.mNoDataView);
    }
}
