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
    private TextView bmr;
    private LinearLayout cZl;
    private BdListView dFz;
    EditMarkActivity fjL;
    private e fjM;
    private com.baidu.tbadk.core.dialog.a fjN = null;
    a.b fjO = null;
    private boolean fjP = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fjL = null;
        this.dFz = null;
        this.mNoDataView = null;
        this.fjM = null;
        this.bmr = null;
        this.cZl = null;
        this.mProgressBar = null;
        this.fjL = editMarkActivity;
        editMarkActivity.setContentView(d.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(d.g.progress);
        this.cZl = (LinearLayout) editMarkActivity.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fjL.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds160)), NoDataViewFactory.d.E(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.cZl.addView(this.mNoDataView, 1);
        this.fjM = new e(editMarkActivity.getPageContext());
        this.fjM.notifyDataSetChanged();
        this.mPullView = new h(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dFz = (BdListView) editMarkActivity.findViewById(d.g.list);
        this.dFz.setAdapter((ListAdapter) this.fjM);
        this.dFz.setPullRefresh(this.mPullView);
        this.dFz.setOnSrollToBottomListener(editMarkActivity);
        this.dFz.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(d.j.my_mark));
        this.bmr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(d.j.edit));
        this.bmr.setOnClickListener(editMarkActivity);
        this.bmr.setVisibility(4);
        this.fjM.A(editMarkActivity);
    }

    public TextView aWJ() {
        return this.bmr;
    }

    public void c(a.b bVar) {
        this.fjO = bVar;
    }

    public void aWK() {
        if (!this.fjM.QQ()) {
            this.fjM.cx(true);
            this.bmr.setText(d.j.done);
            am.d(this.bmr, TbadkCoreApplication.getInst().getSkinType());
            this.fjM.notifyDataSetChanged();
            return;
        }
        this.fjM.cx(false);
        this.bmr.setText(d.j.edit);
        am.f(this.bmr, TbadkCoreApplication.getInst().getSkinType());
        this.fjM.notifyDataSetChanged();
    }

    public boolean aoT() {
        return this.fjM.QQ();
    }

    public int aWL() {
        return d.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fjM.setRefreshing(true);
        this.fjM.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void azi() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fjM.setRefreshing(true);
        if (str != null) {
            this.fjL.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aWY() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aWY() < 20) {
                this.fjM.setHasMore(false);
                this.fjM.iU(aVar.isFirst() ? false : true);
            } else {
                this.fjM.setHasMore(true);
                this.fjM.iU(true);
            }
            this.fjM.setData(aVar.aWX());
            if (aVar.getCount() > 0) {
                this.bmr.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dFz.setVisibility(0);
                this.fjM.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bmr.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dFz.setVisibility(8);
            }
        }
        this.fjM.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bQ(false);
        }
    }

    public void startSync() {
        this.fjL.showLoadingDialog(this.fjL.getPageContext().getString(d.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fjL.closeLoadingDialog();
        if (str != null) {
            this.fjL.showToast(str);
        }
        if (z2) {
            aWM();
        }
        this.fjM.notifyDataSetChanged();
    }

    public void apS() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fjL.showToast(this.fjL.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.aWX() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aWX().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fjM.setData(aVar.aWX());
            }
        } else {
            this.fjL.showToast(str);
        }
        this.fjM.iU(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fjM.setData(arrayList);
    }

    private void aWM() {
        if (this.fjN == null) {
            this.fjN = new com.baidu.tbadk.core.dialog.a(this.fjL.getPageContext().getPageActivity());
            this.fjN.dA(this.fjL.getPageContext().getString(d.j.sync_mark_fail));
            this.fjN.dB(this.fjL.getPageContext().getString(d.j.neterror));
            if (this.fjO != null) {
                this.fjN.a(this.fjL.getPageContext().getString(d.j.retry_rightnow), this.fjO);
            }
            this.fjN.b(this.fjL.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fjN.b(this.fjL.getPageContext());
            this.fjN.av(true);
        }
        this.fjN.xf();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fjL.getPageContext(), i);
        this.fjL.getLayoutMode().onModeChanged(this.cZl);
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fjL.getPageContext(), i);
        }
    }

    public void aWN() {
        this.fjM.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fjN != null) {
            this.fjN.dismiss();
            this.fjN = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dFz != null) {
            this.dFz.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fjP;
    }

    public void bQ(boolean z) {
        this.fjP = z;
    }
}
