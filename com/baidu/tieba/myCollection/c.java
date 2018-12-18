package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class c {
    private TextView bAy;
    private LinearLayout duP;
    private BdListView eaY;
    EditMarkActivity fGU;
    private e fGV;
    private com.baidu.tbadk.core.dialog.a fGW = null;
    a.b fGX = null;
    private boolean fGY = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fGU = null;
        this.eaY = null;
        this.mNoDataView = null;
        this.fGV = null;
        this.bAy = null;
        this.duP = null;
        this.mProgressBar = null;
        this.fGU = editMarkActivity;
        editMarkActivity.setContentView(e.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(e.g.progress);
        this.duP = (LinearLayout) editMarkActivity.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fGU.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds160)), NoDataViewFactory.d.H(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.duP.addView(this.mNoDataView, 1);
        this.fGV = new e(editMarkActivity.getPageContext());
        this.fGV.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.eaY = (BdListView) editMarkActivity.findViewById(e.g.list);
        this.eaY.setAdapter((ListAdapter) this.fGV);
        this.eaY.setPullRefresh(this.mPullView);
        this.eaY.setOnSrollToBottomListener(editMarkActivity);
        this.eaY.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(e.j.my_mark));
        this.bAy = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(e.j.edit));
        this.bAy.setOnClickListener(editMarkActivity);
        this.bAy.setVisibility(4);
        this.fGV.C(editMarkActivity);
    }

    public TextView bdt() {
        return this.bAy;
    }

    public void c(a.b bVar) {
        this.fGX = bVar;
    }

    public void bdu() {
        if (!this.fGV.VU()) {
            this.fGV.dq(true);
            this.bAy.setText(e.j.done);
            al.d(this.bAy, TbadkCoreApplication.getInst().getSkinType());
            this.fGV.notifyDataSetChanged();
            return;
        }
        this.fGV.dq(false);
        this.bAy.setText(e.j.edit);
        al.f(this.bAy, TbadkCoreApplication.getInst().getSkinType());
        this.fGV.notifyDataSetChanged();
    }

    public boolean avq() {
        return this.fGV.VU();
    }

    public int bdv() {
        return e.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fGV.setRefreshing(true);
        this.fGV.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aFP() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fGV.setRefreshing(true);
        if (str != null) {
            this.fGU.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bdI() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bdI() < 20) {
                this.fGV.setHasMore(false);
                this.fGV.jX(aVar.isFirst() ? false : true);
            } else {
                this.fGV.setHasMore(true);
                this.fGV.jX(true);
            }
            this.fGV.setData(aVar.bdH());
            if (aVar.getCount() > 0) {
                this.bAy.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.eaY.setVisibility(0);
                this.fGV.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bAy.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.eaY.setVisibility(8);
            }
        }
        this.fGV.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            cE(false);
        }
    }

    public void startSync() {
        this.fGU.showLoadingDialog(this.fGU.getPageContext().getString(e.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fGU.closeLoadingDialog();
        if (str != null) {
            this.fGU.showToast(str);
        }
        if (z2) {
            bdw();
        }
        this.fGV.notifyDataSetChanged();
    }

    public void awm() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fGU.showToast(this.fGU.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.bdH() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.bdH().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fGV.setData(aVar.bdH());
            }
        } else {
            this.fGU.showToast(str);
        }
        this.fGV.jX(false);
        this.mProgressBar.setVisibility(8);
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fGV.setData(arrayList);
    }

    private void bdw() {
        if (this.fGW == null) {
            this.fGW = new com.baidu.tbadk.core.dialog.a(this.fGU.getPageContext().getPageActivity());
            this.fGW.eA(this.fGU.getPageContext().getString(e.j.sync_mark_fail));
            this.fGW.eB(this.fGU.getPageContext().getString(e.j.neterror));
            if (this.fGX != null) {
                this.fGW.a(this.fGU.getPageContext().getString(e.j.retry_rightnow), this.fGX);
            }
            this.fGW.b(this.fGU.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fGW.b(this.fGU.getPageContext());
            this.fGW.bg(true);
        }
        this.fGW.BF();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fGU.getPageContext(), i);
        this.fGU.getLayoutMode().onModeChanged(this.duP);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fGU.getPageContext(), i);
        }
    }

    public void bdx() {
        this.fGV.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fGW != null) {
            this.fGW.dismiss();
            this.fGW = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.eaY != null) {
            this.eaY.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fGY;
    }

    public void cE(boolean z) {
        this.fGY = z;
    }
}
