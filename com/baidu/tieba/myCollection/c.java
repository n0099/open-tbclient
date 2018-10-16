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
    private TextView bwq;
    private BdListView dTo;
    private LinearLayout dnj;
    EditMarkActivity fyG;
    private e fyH;
    private com.baidu.tbadk.core.dialog.a fyI = null;
    a.b fyJ = null;
    private boolean fyK = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fyG = null;
        this.dTo = null;
        this.mNoDataView = null;
        this.fyH = null;
        this.bwq = null;
        this.dnj = null;
        this.mProgressBar = null;
        this.fyG = editMarkActivity;
        editMarkActivity.setContentView(e.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(e.g.progress);
        this.dnj = (LinearLayout) editMarkActivity.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fyG.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0175e.ds160)), NoDataViewFactory.d.G(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.dnj.addView(this.mNoDataView, 1);
        this.fyH = new e(editMarkActivity.getPageContext());
        this.fyH.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dTo = (BdListView) editMarkActivity.findViewById(e.g.list);
        this.dTo.setAdapter((ListAdapter) this.fyH);
        this.dTo.setPullRefresh(this.mPullView);
        this.dTo.setOnSrollToBottomListener(editMarkActivity);
        this.dTo.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(e.j.my_mark));
        this.bwq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(e.j.edit));
        this.bwq.setOnClickListener(editMarkActivity);
        this.bwq.setVisibility(4);
        this.fyH.A(editMarkActivity);
    }

    public TextView bce() {
        return this.bwq;
    }

    public void c(a.b bVar) {
        this.fyJ = bVar;
    }

    public void bcf() {
        if (!this.fyH.UF()) {
            this.fyH.cY(true);
            this.bwq.setText(e.j.done);
            al.d(this.bwq, TbadkCoreApplication.getInst().getSkinType());
            this.fyH.notifyDataSetChanged();
            return;
        }
        this.fyH.cY(false);
        this.bwq.setText(e.j.edit);
        al.f(this.bwq, TbadkCoreApplication.getInst().getSkinType());
        this.fyH.notifyDataSetChanged();
    }

    public boolean aue() {
        return this.fyH.UF();
    }

    public int bcg() {
        return e.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fyH.setRefreshing(true);
        this.fyH.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aEH() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fyH.setRefreshing(true);
        if (str != null) {
            this.fyG.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bct() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bct() < 20) {
                this.fyH.setHasMore(false);
                this.fyH.jK(aVar.isFirst() ? false : true);
            } else {
                this.fyH.setHasMore(true);
                this.fyH.jK(true);
            }
            this.fyH.setData(aVar.bcs());
            if (aVar.getCount() > 0) {
                this.bwq.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dTo.setVisibility(0);
                this.fyH.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bwq.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dTo.setVisibility(8);
            }
        }
        this.fyH.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            cm(false);
        }
    }

    public void startSync() {
        this.fyG.showLoadingDialog(this.fyG.getPageContext().getString(e.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fyG.closeLoadingDialog();
        if (str != null) {
            this.fyG.showToast(str);
        }
        if (z2) {
            bch();
        }
        this.fyH.notifyDataSetChanged();
    }

    public void avc() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fyG.showToast(this.fyG.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.bcs() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.bcs().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fyH.setData(aVar.bcs());
            }
        } else {
            this.fyG.showToast(str);
        }
        this.fyH.jK(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fyH.setData(arrayList);
    }

    private void bch() {
        if (this.fyI == null) {
            this.fyI = new com.baidu.tbadk.core.dialog.a(this.fyG.getPageContext().getPageActivity());
            this.fyI.ei(this.fyG.getPageContext().getString(e.j.sync_mark_fail));
            this.fyI.ej(this.fyG.getPageContext().getString(e.j.neterror));
            if (this.fyJ != null) {
                this.fyI.a(this.fyG.getPageContext().getString(e.j.retry_rightnow), this.fyJ);
            }
            this.fyI.b(this.fyG.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fyI.b(this.fyG.getPageContext());
            this.fyI.aP(true);
        }
        this.fyI.Au();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fyG.getPageContext(), i);
        this.fyG.getLayoutMode().onModeChanged(this.dnj);
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fyG.getPageContext(), i);
        }
    }

    public void bci() {
        this.fyH.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fyI != null) {
            this.fyI.dismiss();
            this.fyI = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dTo != null) {
            this.dTo.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fyK;
    }

    public void cm(boolean z) {
        this.fyK = z;
    }
}
