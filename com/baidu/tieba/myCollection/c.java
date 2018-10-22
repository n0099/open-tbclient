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
    private BdListView dTp;
    private LinearLayout dnj;
    EditMarkActivity fyH;
    private e fyI;
    private com.baidu.tbadk.core.dialog.a fyJ = null;
    a.b fyK = null;
    private boolean fyL = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fyH = null;
        this.dTp = null;
        this.mNoDataView = null;
        this.fyI = null;
        this.bwq = null;
        this.dnj = null;
        this.mProgressBar = null;
        this.fyH = editMarkActivity;
        editMarkActivity.setContentView(e.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(e.g.progress);
        this.dnj = (LinearLayout) editMarkActivity.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fyH.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0175e.ds160)), NoDataViewFactory.d.G(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.dnj.addView(this.mNoDataView, 1);
        this.fyI = new e(editMarkActivity.getPageContext());
        this.fyI.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dTp = (BdListView) editMarkActivity.findViewById(e.g.list);
        this.dTp.setAdapter((ListAdapter) this.fyI);
        this.dTp.setPullRefresh(this.mPullView);
        this.dTp.setOnSrollToBottomListener(editMarkActivity);
        this.dTp.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(e.j.my_mark));
        this.bwq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(e.j.edit));
        this.bwq.setOnClickListener(editMarkActivity);
        this.bwq.setVisibility(4);
        this.fyI.A(editMarkActivity);
    }

    public TextView bce() {
        return this.bwq;
    }

    public void c(a.b bVar) {
        this.fyK = bVar;
    }

    public void bcf() {
        if (!this.fyI.UF()) {
            this.fyI.cY(true);
            this.bwq.setText(e.j.done);
            al.d(this.bwq, TbadkCoreApplication.getInst().getSkinType());
            this.fyI.notifyDataSetChanged();
            return;
        }
        this.fyI.cY(false);
        this.bwq.setText(e.j.edit);
        al.f(this.bwq, TbadkCoreApplication.getInst().getSkinType());
        this.fyI.notifyDataSetChanged();
    }

    public boolean auf() {
        return this.fyI.UF();
    }

    public int bcg() {
        return e.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fyI.setRefreshing(true);
        this.fyI.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aEH() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fyI.setRefreshing(true);
        if (str != null) {
            this.fyH.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bct() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bct() < 20) {
                this.fyI.setHasMore(false);
                this.fyI.jK(aVar.isFirst() ? false : true);
            } else {
                this.fyI.setHasMore(true);
                this.fyI.jK(true);
            }
            this.fyI.setData(aVar.bcs());
            if (aVar.getCount() > 0) {
                this.bwq.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dTp.setVisibility(0);
                this.fyI.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bwq.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dTp.setVisibility(8);
            }
        }
        this.fyI.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            cm(false);
        }
    }

    public void startSync() {
        this.fyH.showLoadingDialog(this.fyH.getPageContext().getString(e.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fyH.closeLoadingDialog();
        if (str != null) {
            this.fyH.showToast(str);
        }
        if (z2) {
            bch();
        }
        this.fyI.notifyDataSetChanged();
    }

    public void avd() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fyH.showToast(this.fyH.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.bcs() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.bcs().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fyI.setData(aVar.bcs());
            }
        } else {
            this.fyH.showToast(str);
        }
        this.fyI.jK(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fyI.setData(arrayList);
    }

    private void bch() {
        if (this.fyJ == null) {
            this.fyJ = new com.baidu.tbadk.core.dialog.a(this.fyH.getPageContext().getPageActivity());
            this.fyJ.ei(this.fyH.getPageContext().getString(e.j.sync_mark_fail));
            this.fyJ.ej(this.fyH.getPageContext().getString(e.j.neterror));
            if (this.fyK != null) {
                this.fyJ.a(this.fyH.getPageContext().getString(e.j.retry_rightnow), this.fyK);
            }
            this.fyJ.b(this.fyH.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fyJ.b(this.fyH.getPageContext());
            this.fyJ.aP(true);
        }
        this.fyJ.Au();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fyH.getPageContext(), i);
        this.fyH.getLayoutMode().onModeChanged(this.dnj);
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fyH.getPageContext(), i);
        }
    }

    public void bci() {
        this.fyI.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fyJ != null) {
            this.fyJ.dismiss();
            this.fyJ = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dTp != null) {
            this.dTp.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fyL;
    }

    public void cm(boolean z) {
        this.fyL = z;
    }
}
