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
    private LinearLayout Hk;
    com.baidu.tbadk.core.view.y Yc;
    private NoNetworkView aty;
    private BdListView bNm;
    private com.baidu.tieba.view.w bNn;
    private ap bNo;
    private BaseFragmentActivity mActivity;
    private View mRoot;

    public aq(BaseFragmentActivity baseFragmentActivity, BaseFragment baseFragment, View.OnKeyListener onKeyListener) {
        super(baseFragmentActivity);
        this.mActivity = null;
        this.bNm = null;
        this.Hk = null;
        this.Yc = null;
        this.bNo = null;
        this.mActivity = baseFragmentActivity;
        this.mRoot = baseFragment.getView();
        this.Hk = (LinearLayout) this.mRoot.findViewById(com.baidu.tieba.v.container);
        this.bNn = new com.baidu.tieba.view.w(this.mActivity);
        this.bNm = (BdListView) this.mRoot.findViewById(com.baidu.tieba.v.square_list);
        this.bNm.setOnKeyListener(onKeyListener);
        this.bNm.setOnItemClickListener(baseFragment);
        this.bNm.setOnScrollListener(baseFragment);
        this.bNo = new ap(baseFragmentActivity);
        this.bNm.setAdapter((ListAdapter) this.bNo);
        this.Yc = new com.baidu.tbadk.core.view.y(baseFragmentActivity);
        this.bNm.setPullRefresh(this.Yc);
        this.bNm.addHeaderView(this.bNn);
        this.aty = (NoNetworkView) this.mRoot.findViewById(com.baidu.tieba.v.view_no_network);
        com.baidu.tieba.view.i iVar = new com.baidu.tieba.view.i(this.mContext);
        iVar.setHeightDip(30);
        this.bNm.addFooterView(iVar);
    }

    public void c(ah ahVar) {
        if (ahVar != null) {
            try {
                this.bNo.b(ahVar);
                this.bNo.notifyDataSetChanged();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void Dd() {
        if (this.bNm != null) {
            int headerViewsCount = this.bNm.getHeaderViewsCount() + 1;
            int firstVisiblePosition = this.bNm.getFirstVisiblePosition();
            int lastVisiblePosition = this.bNm.getLastVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition -= headerViewsCount;
                lastVisiblePosition -= headerViewsCount;
            }
            this.bNo.g(this.bNm, firstVisiblePosition, lastVisiblePosition);
        }
    }

    public void IN() {
        this.bNm.hN();
    }

    public void d(boolean z, String str) {
        IN();
        if (!z && str != null) {
            this.mActivity.showToast(str);
        }
    }

    public com.baidu.tieba.view.w adB() {
        return this.bNn;
    }

    public void hO() {
        this.bNm.hO();
    }

    public void IS() {
        this.aty.setVisibility(0);
    }

    public void adC() {
        this.aty.setVisibility(8);
    }

    public void c(com.baidu.tbadk.core.view.u uVar) {
        this.aty.a(uVar);
    }

    public void d(com.baidu.tbadk.core.view.u uVar) {
        this.aty.b(uVar);
    }

    public void onStop() {
        this.bNo.adn();
    }

    public void onResume() {
        NetworkInfo activeNetworkInfo;
        this.bNo.onResume();
        if (this.aty != null && this.aty.getVisibility() == 0 && (activeNetworkInfo = ((ConnectivityManager) this.mActivity.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
            this.aty.Z(false);
        }
    }

    public void onPause() {
        this.bNo.onPause();
    }

    public void onDestroy() {
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.Hk);
        this.bNo.onChangeSkinType(i);
        this.Yc.bM(i);
        this.aty.onChangeSkinType(i);
        this.bNn.onChangeSkinType(i);
    }

    public void a(com.baidu.adp.widget.ListView.f fVar) {
        this.Yc.a(fVar);
    }
}
