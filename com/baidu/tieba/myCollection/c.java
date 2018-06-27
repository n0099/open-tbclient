package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tieba.d;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class c {
    private TextView blL;
    private LinearLayout cWw;
    private BdListView dCN;
    private e fjA;
    private com.baidu.tbadk.core.dialog.a fjB = null;
    a.b fjC = null;
    private boolean fjD = false;
    EditMarkActivity fjz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fjz = null;
        this.dCN = null;
        this.mNoDataView = null;
        this.fjA = null;
        this.blL = null;
        this.cWw = null;
        this.mProgressBar = null;
        this.fjz = editMarkActivity;
        editMarkActivity.setContentView(d.i.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(d.g.progress);
        this.cWw = (LinearLayout) editMarkActivity.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fjz.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds160)), NoDataViewFactory.d.D(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.cWw.addView(this.mNoDataView, 1);
        this.fjA = new e(editMarkActivity.getPageContext());
        this.fjA.notifyDataSetChanged();
        this.mPullView = new h(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dCN = (BdListView) editMarkActivity.findViewById(d.g.list);
        this.dCN.setAdapter((ListAdapter) this.fjA);
        this.dCN.setPullRefresh(this.mPullView);
        this.dCN.setOnSrollToBottomListener(editMarkActivity);
        this.dCN.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(d.k.my_mark));
        this.blL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(d.k.edit));
        this.blL.setOnClickListener(editMarkActivity);
        this.blL.setVisibility(4);
        this.fjA.C(editMarkActivity);
    }

    public TextView aYn() {
        return this.blL;
    }

    public void c(a.b bVar) {
        this.fjC = bVar;
    }

    public void aYo() {
        if (!this.fjA.QJ()) {
            this.fjA.cx(true);
            this.blL.setText(d.k.done);
            am.d(this.blL, TbadkCoreApplication.getInst().getSkinType());
            this.fjA.notifyDataSetChanged();
            return;
        }
        this.fjA.cx(false);
        this.blL.setText(d.k.edit);
        am.f(this.blL, TbadkCoreApplication.getInst().getSkinType());
        this.fjA.notifyDataSetChanged();
    }

    public boolean aot() {
        return this.fjA.QJ();
    }

    public int aYp() {
        return d.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fjA.setRefreshing(true);
        this.fjA.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void ayD() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fjA.setRefreshing(true);
        if (str != null) {
            this.fjz.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aYC() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aYC() < 20) {
                this.fjA.setHasMore(false);
                this.fjA.ji(aVar.isFirst() ? false : true);
            } else {
                this.fjA.setHasMore(true);
                this.fjA.ji(true);
            }
            this.fjA.setData(aVar.aYB());
            if (aVar.getCount() > 0) {
                this.blL.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dCN.setVisibility(0);
                this.fjA.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.blL.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dCN.setVisibility(8);
            }
        }
        this.fjA.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bS(false);
        }
    }

    public void startSync() {
        this.fjz.showLoadingDialog(this.fjz.getPageContext().getString(d.k.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fjz.closeLoadingDialog();
        if (str != null) {
            this.fjz.showToast(str);
        }
        if (z2) {
            aYq();
        }
        this.fjA.notifyDataSetChanged();
    }

    public void aps() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fjz.showToast(this.fjz.getPageContext().getString(d.k.delete_success));
            if (aVar == null || aVar.aYB() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aYB().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fjA.setData(aVar.aYB());
            }
        } else {
            this.fjz.showToast(str);
        }
        this.fjA.ji(false);
        this.mProgressBar.setVisibility(8);
    }

    public void am(ArrayList<MarkData> arrayList) {
        this.fjA.setData(arrayList);
    }

    private void aYq() {
        if (this.fjB == null) {
            this.fjB = new com.baidu.tbadk.core.dialog.a(this.fjz.getPageContext().getPageActivity());
            this.fjB.dD(this.fjz.getPageContext().getString(d.k.sync_mark_fail));
            this.fjB.dE(this.fjz.getPageContext().getString(d.k.neterror));
            if (this.fjC != null) {
                this.fjB.a(this.fjz.getPageContext().getString(d.k.retry_rightnow), this.fjC);
            }
            this.fjB.b(this.fjz.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fjB.b(this.fjz.getPageContext());
            this.fjB.ax(true);
        }
        this.fjB.xn();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fjz.getPageContext(), i);
        this.fjz.getLayoutMode().onModeChanged(this.cWw);
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fjz.getPageContext(), i);
        }
    }

    public void aYr() {
        this.fjA.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fjB != null) {
            this.fjB.dismiss();
            this.fjB = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dCN != null) {
            this.dCN.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fjD;
    }

    public void bS(boolean z) {
        this.fjD = z;
    }
}
