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
    private TextView bBo;
    private LinearLayout dyl;
    private BdListView eev;
    EditMarkActivity fKG;
    private e fKH;
    private com.baidu.tbadk.core.dialog.a fKI = null;
    a.b fKJ = null;
    private boolean fKK = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fKG = null;
        this.eev = null;
        this.mNoDataView = null;
        this.fKH = null;
        this.bBo = null;
        this.dyl = null;
        this.mProgressBar = null;
        this.fKG = editMarkActivity;
        editMarkActivity.setContentView(e.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(e.g.progress);
        this.dyl = (LinearLayout) editMarkActivity.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fKG.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds160)), NoDataViewFactory.d.H(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.dyl.addView(this.mNoDataView, 1);
        this.fKH = new e(editMarkActivity.getPageContext());
        this.fKH.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.eev = (BdListView) editMarkActivity.findViewById(e.g.list);
        this.eev.setAdapter((ListAdapter) this.fKH);
        this.eev.setPullRefresh(this.mPullView);
        this.eev.setOnSrollToBottomListener(editMarkActivity);
        this.eev.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(e.j.my_mark));
        this.bBo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(e.j.edit));
        this.bBo.setOnClickListener(editMarkActivity);
        this.bBo.setVisibility(4);
        this.fKH.C(editMarkActivity);
    }

    public TextView beH() {
        return this.bBo;
    }

    public void c(a.b bVar) {
        this.fKJ = bVar;
    }

    public void beI() {
        if (!this.fKH.Ws()) {
            this.fKH.dt(true);
            this.bBo.setText(e.j.done);
            al.d(this.bBo, TbadkCoreApplication.getInst().getSkinType());
            this.fKH.notifyDataSetChanged();
            return;
        }
        this.fKH.dt(false);
        this.bBo.setText(e.j.edit);
        al.f(this.bBo, TbadkCoreApplication.getInst().getSkinType());
        this.fKH.notifyDataSetChanged();
    }

    public boolean awC() {
        return this.fKH.Ws();
    }

    public int beJ() {
        return e.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fKH.setRefreshing(true);
        this.fKH.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aHb() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fKH.setRefreshing(true);
        if (str != null) {
            this.fKG.showToast(str);
        }
        if (aVar != null) {
            if (aVar.beU() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.beU() < 20) {
                this.fKH.setHasMore(false);
                this.fKH.ka(aVar.isFirst() ? false : true);
            } else {
                this.fKH.setHasMore(true);
                this.fKH.ka(true);
            }
            this.fKH.setData(aVar.beT());
            if (aVar.getCount() > 0) {
                this.bBo.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.eev.setVisibility(0);
                this.fKH.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bBo.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.eev.setVisibility(8);
            }
        }
        this.fKH.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            cH(false);
        }
    }

    public void startSync() {
        this.fKG.showLoadingDialog(this.fKG.getPageContext().getString(e.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fKG.closeLoadingDialog();
        if (str != null) {
            this.fKG.showToast(str);
        }
        if (z2) {
            beK();
        }
        this.fKH.notifyDataSetChanged();
    }

    public void axy() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fKG.showToast(this.fKG.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.beT() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.beT().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fKH.setData(aVar.beT());
            }
        } else {
            this.fKG.showToast(str);
        }
        this.fKH.ka(false);
        this.mProgressBar.setVisibility(8);
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fKH.setData(arrayList);
    }

    private void beK() {
        if (this.fKI == null) {
            this.fKI = new com.baidu.tbadk.core.dialog.a(this.fKG.getPageContext().getPageActivity());
            this.fKI.eJ(this.fKG.getPageContext().getString(e.j.sync_mark_fail));
            this.fKI.eK(this.fKG.getPageContext().getString(e.j.neterror));
            if (this.fKJ != null) {
                this.fKI.a(this.fKG.getPageContext().getString(e.j.retry_rightnow), this.fKJ);
            }
            this.fKI.b(this.fKG.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fKI.b(this.fKG.getPageContext());
            this.fKI.bh(true);
        }
        this.fKI.BS();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fKG.getPageContext(), i);
        this.fKG.getLayoutMode().onModeChanged(this.dyl);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fKG.getPageContext(), i);
        }
    }

    public void beL() {
        this.fKH.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fKI != null) {
            this.fKI.dismiss();
            this.fKI = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.eev != null) {
            this.eev.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fKK;
    }

    public void cH(boolean z) {
        this.fKK = z;
    }
}
