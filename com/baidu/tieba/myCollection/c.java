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
    private TextView bAB;
    private LinearLayout dxC;
    private BdListView edP;
    EditMarkActivity fJM;
    private e fJN;
    private com.baidu.tbadk.core.dialog.a fJO = null;
    a.b fJP = null;
    private boolean fJQ = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fJM = null;
        this.edP = null;
        this.mNoDataView = null;
        this.fJN = null;
        this.bAB = null;
        this.dxC = null;
        this.mProgressBar = null;
        this.fJM = editMarkActivity;
        editMarkActivity.setContentView(e.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(e.g.progress);
        this.dxC = (LinearLayout) editMarkActivity.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fJM.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0210e.ds160)), NoDataViewFactory.d.H(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.dxC.addView(this.mNoDataView, 1);
        this.fJN = new e(editMarkActivity.getPageContext());
        this.fJN.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.edP = (BdListView) editMarkActivity.findViewById(e.g.list);
        this.edP.setAdapter((ListAdapter) this.fJN);
        this.edP.setPullRefresh(this.mPullView);
        this.edP.setOnSrollToBottomListener(editMarkActivity);
        this.edP.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(e.j.my_mark));
        this.bAB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(e.j.edit));
        this.bAB.setOnClickListener(editMarkActivity);
        this.bAB.setVisibility(4);
        this.fJN.C(editMarkActivity);
    }

    public TextView beh() {
        return this.bAB;
    }

    public void c(a.b bVar) {
        this.fJP = bVar;
    }

    public void bei() {
        if (!this.fJN.VW()) {
            this.fJN.dq(true);
            this.bAB.setText(e.j.done);
            al.d(this.bAB, TbadkCoreApplication.getInst().getSkinType());
            this.fJN.notifyDataSetChanged();
            return;
        }
        this.fJN.dq(false);
        this.bAB.setText(e.j.edit);
        al.f(this.bAB, TbadkCoreApplication.getInst().getSkinType());
        this.fJN.notifyDataSetChanged();
    }

    public boolean awf() {
        return this.fJN.VW();
    }

    public int bej() {
        return e.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fJN.setRefreshing(true);
        this.fJN.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aGE() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fJN.setRefreshing(true);
        if (str != null) {
            this.fJM.showToast(str);
        }
        if (aVar != null) {
            if (aVar.beu() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.beu() < 20) {
                this.fJN.setHasMore(false);
                this.fJN.ka(aVar.isFirst() ? false : true);
            } else {
                this.fJN.setHasMore(true);
                this.fJN.ka(true);
            }
            this.fJN.setData(aVar.bet());
            if (aVar.getCount() > 0) {
                this.bAB.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.edP.setVisibility(0);
                this.fJN.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bAB.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.edP.setVisibility(8);
            }
        }
        this.fJN.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            cE(false);
        }
    }

    public void startSync() {
        this.fJM.showLoadingDialog(this.fJM.getPageContext().getString(e.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fJM.closeLoadingDialog();
        if (str != null) {
            this.fJM.showToast(str);
        }
        if (z2) {
            bek();
        }
        this.fJN.notifyDataSetChanged();
    }

    public void axb() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fJM.showToast(this.fJM.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.bet() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.bet().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fJN.setData(aVar.bet());
            }
        } else {
            this.fJM.showToast(str);
        }
        this.fJN.ka(false);
        this.mProgressBar.setVisibility(8);
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fJN.setData(arrayList);
    }

    private void bek() {
        if (this.fJO == null) {
            this.fJO = new com.baidu.tbadk.core.dialog.a(this.fJM.getPageContext().getPageActivity());
            this.fJO.eA(this.fJM.getPageContext().getString(e.j.sync_mark_fail));
            this.fJO.eB(this.fJM.getPageContext().getString(e.j.neterror));
            if (this.fJP != null) {
                this.fJO.a(this.fJM.getPageContext().getString(e.j.retry_rightnow), this.fJP);
            }
            this.fJO.b(this.fJM.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fJO.b(this.fJM.getPageContext());
            this.fJO.bg(true);
        }
        this.fJO.BF();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fJM.getPageContext(), i);
        this.fJM.getLayoutMode().onModeChanged(this.dxC);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fJM.getPageContext(), i);
        }
    }

    public void bel() {
        this.fJN.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fJO != null) {
            this.fJO.dismiss();
            this.fJO = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.edP != null) {
            this.edP.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fJQ;
    }

    public void cE(boolean z) {
        this.fJQ = z;
    }
}
