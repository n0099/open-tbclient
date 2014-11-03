package com.baidu.tieba.square;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
public class aq extends com.baidu.adp.base.f {
    private LinearLayout Hl;
    com.baidu.tbadk.core.view.y Yg;
    private NoNetworkView atH;
    private BdListView bNB;
    private com.baidu.tieba.view.w bNC;
    private ap bND;
    private BaseFragmentActivity mActivity;
    private View mRoot;

    public aq(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity);
        this.mActivity = null;
        this.bNB = null;
        this.Hl = null;
        this.Yg = null;
        this.bND = null;
        this.mActivity = baseFragmentActivity;
        this.mRoot = baseFragment.getView();
        this.Hl = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.container);
        this.bNC = new com.baidu.tieba.view.w(this.mActivity);
        this.bNB = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.square_list);
        this.bNB.setOnKeyListener(onKeyListener);
        this.bNB.setOnItemClickListener(baseFragment);
        this.bNB.setOnScrollListener(baseFragment);
        this.bND = new ap(baseFragmentActivity);
        this.bNB.setAdapter((ListAdapter) this.bND);
        this.Yg = new com.baidu.tbadk.core.view.y(baseFragmentActivity);
        this.bNB.setPullRefresh(this.Yg);
        this.bNB.addHeaderView(this.bNC);
        this.atH = (NoNetworkView) this.mRoot.findViewById(com.baidu.tieba.v.view_no_network);
        com.baidu.tieba.view.i iVar = new com.baidu.tieba.view.i(this.mContext);
        iVar.setHeightDip(30);
        this.bNB.addFooterView(iVar);
    }

    public void c(ah ahVar) {
        if (ahVar != null) {
            try {
                this.bND.b(ahVar);
                this.bND.notifyDataSetChanged();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void Df() {
        if (this.bNB != null) {
            int headerViewsCount = this.bNB.getHeaderViewsCount() + 1;
            int firstVisiblePosition = this.bNB.getFirstVisiblePosition();
            int lastVisiblePosition = this.bNB.getLastVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition -= headerViewsCount;
                lastVisiblePosition -= headerViewsCount;
            }
            this.bND.g(this.bNB, firstVisiblePosition, lastVisiblePosition);
        }
    }

    public void IR() {
        this.bNB.hN();
    }

    public void d(boolean z, String str) {
        IR();
        if (!z && str != null) {
            this.mActivity.showToast(str);
        }
    }

    public com.baidu.tieba.view.w adE() {
        return this.bNC;
    }

    public void hO() {
        this.bNB.hO();
    }

    public void IW() {
        this.atH.setVisibility(0);
    }

    public void adF() {
        this.atH.setVisibility(8);
    }

    public void c(com.baidu.tbadk.core.view.u uVar) {
        this.atH.a(uVar);
    }

    public void d(com.baidu.tbadk.core.view.u uVar) {
        this.atH.b(uVar);
    }

    public void onStop() {
        this.bND.adq();
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.bND.onResume();
        if (this.atH != null && this.atH.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.atH.Z(false);
        }
    }

    public void onPause() {
        this.bND.onPause();
    }

    public void onDestroy() {
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.Hl);
        this.bND.onChangeSkinType(i);
        this.Yg.bM(i);
        this.atH.onChangeSkinType(i);
        this.bNC.onChangeSkinType(i);
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yg.a(fVar);
    }
}
