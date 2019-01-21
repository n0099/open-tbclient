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
    private TextView bBp;
    private LinearLayout dym;
    private BdListView eew;
    EditMarkActivity fKH;
    private e fKI;
    private com.baidu.tbadk.core.dialog.a fKJ = null;
    a.b fKK = null;
    private boolean fKL = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fKH = null;
        this.eew = null;
        this.mNoDataView = null;
        this.fKI = null;
        this.bBp = null;
        this.dym = null;
        this.mProgressBar = null;
        this.fKH = editMarkActivity;
        editMarkActivity.setContentView(e.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(e.g.progress);
        this.dym = (LinearLayout) editMarkActivity.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fKH.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds160)), NoDataViewFactory.d.H(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.dym.addView(this.mNoDataView, 1);
        this.fKI = new e(editMarkActivity.getPageContext());
        this.fKI.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.eew = (BdListView) editMarkActivity.findViewById(e.g.list);
        this.eew.setAdapter((ListAdapter) this.fKI);
        this.eew.setPullRefresh(this.mPullView);
        this.eew.setOnSrollToBottomListener(editMarkActivity);
        this.eew.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(e.j.my_mark));
        this.bBp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(e.j.edit));
        this.bBp.setOnClickListener(editMarkActivity);
        this.bBp.setVisibility(4);
        this.fKI.C(editMarkActivity);
    }

    public TextView beH() {
        return this.bBp;
    }

    public void c(a.b bVar) {
        this.fKK = bVar;
    }

    public void beI() {
        if (!this.fKI.Ws()) {
            this.fKI.dt(true);
            this.bBp.setText(e.j.done);
            al.d(this.bBp, TbadkCoreApplication.getInst().getSkinType());
            this.fKI.notifyDataSetChanged();
            return;
        }
        this.fKI.dt(false);
        this.bBp.setText(e.j.edit);
        al.f(this.bBp, TbadkCoreApplication.getInst().getSkinType());
        this.fKI.notifyDataSetChanged();
    }

    public boolean awC() {
        return this.fKI.Ws();
    }

    public int beJ() {
        return e.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fKI.setRefreshing(true);
        this.fKI.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aHb() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fKI.setRefreshing(true);
        if (str != null) {
            this.fKH.showToast(str);
        }
        if (aVar != null) {
            if (aVar.beU() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.beU() < 20) {
                this.fKI.setHasMore(false);
                this.fKI.ka(aVar.isFirst() ? false : true);
            } else {
                this.fKI.setHasMore(true);
                this.fKI.ka(true);
            }
            this.fKI.setData(aVar.beT());
            if (aVar.getCount() > 0) {
                this.bBp.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.eew.setVisibility(0);
                this.fKI.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bBp.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.eew.setVisibility(8);
            }
        }
        this.fKI.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            cH(false);
        }
    }

    public void startSync() {
        this.fKH.showLoadingDialog(this.fKH.getPageContext().getString(e.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fKH.closeLoadingDialog();
        if (str != null) {
            this.fKH.showToast(str);
        }
        if (z2) {
            beK();
        }
        this.fKI.notifyDataSetChanged();
    }

    public void axy() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fKH.showToast(this.fKH.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.beT() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.beT().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fKI.setData(aVar.beT());
            }
        } else {
            this.fKH.showToast(str);
        }
        this.fKI.ka(false);
        this.mProgressBar.setVisibility(8);
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fKI.setData(arrayList);
    }

    private void beK() {
        if (this.fKJ == null) {
            this.fKJ = new com.baidu.tbadk.core.dialog.a(this.fKH.getPageContext().getPageActivity());
            this.fKJ.eJ(this.fKH.getPageContext().getString(e.j.sync_mark_fail));
            this.fKJ.eK(this.fKH.getPageContext().getString(e.j.neterror));
            if (this.fKK != null) {
                this.fKJ.a(this.fKH.getPageContext().getString(e.j.retry_rightnow), this.fKK);
            }
            this.fKJ.b(this.fKH.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fKJ.b(this.fKH.getPageContext());
            this.fKJ.bh(true);
        }
        this.fKJ.BS();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fKH.getPageContext(), i);
        this.fKH.getLayoutMode().onModeChanged(this.dym);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fKH.getPageContext(), i);
        }
    }

    public void beL() {
        this.fKI.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fKJ != null) {
            this.fKJ.dismiss();
            this.fKJ = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.eew != null) {
            this.eew.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fKL;
    }

    public void cH(boolean z) {
        this.fKL = z;
    }
}
