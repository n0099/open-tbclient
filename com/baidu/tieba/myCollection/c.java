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
    private TextView bxb;
    private BdListView dUv;
    private LinearLayout dop;
    EditMarkActivity fAe;
    private e fAf;
    private com.baidu.tbadk.core.dialog.a fAg = null;
    a.b fAh = null;
    private boolean fAi = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.fAe = null;
        this.dUv = null;
        this.mNoDataView = null;
        this.fAf = null;
        this.bxb = null;
        this.dop = null;
        this.mProgressBar = null;
        this.fAe = editMarkActivity;
        editMarkActivity.setContentView(e.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(e.g.progress);
        this.dop = (LinearLayout) editMarkActivity.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fAe.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0200e.ds160)), NoDataViewFactory.d.G(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.dop.addView(this.mNoDataView, 1);
        this.fAf = new e(editMarkActivity.getPageContext());
        this.fAf.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dUv = (BdListView) editMarkActivity.findViewById(e.g.list);
        this.dUv.setAdapter((ListAdapter) this.fAf);
        this.dUv.setPullRefresh(this.mPullView);
        this.dUv.setOnSrollToBottomListener(editMarkActivity);
        this.dUv.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(e.j.my_mark));
        this.bxb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(e.j.edit));
        this.bxb.setOnClickListener(editMarkActivity);
        this.bxb.setVisibility(4);
        this.fAf.C(editMarkActivity);
    }

    public TextView bbD() {
        return this.bxb;
    }

    public void c(a.b bVar) {
        this.fAh = bVar;
    }

    public void bbE() {
        if (!this.fAf.UO()) {
            this.fAf.dp(true);
            this.bxb.setText(e.j.done);
            al.d(this.bxb, TbadkCoreApplication.getInst().getSkinType());
            this.fAf.notifyDataSetChanged();
            return;
        }
        this.fAf.dp(false);
        this.bxb.setText(e.j.edit);
        al.f(this.bxb, TbadkCoreApplication.getInst().getSkinType());
        this.fAf.notifyDataSetChanged();
    }

    public boolean atE() {
        return this.fAf.UO();
    }

    public int bbF() {
        return e.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.fAf.setRefreshing(true);
        this.fAf.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aEd() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fAf.setRefreshing(true);
        if (str != null) {
            this.fAe.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bbS() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bbS() < 20) {
                this.fAf.setHasMore(false);
                this.fAf.jU(aVar.isFirst() ? false : true);
            } else {
                this.fAf.setHasMore(true);
                this.fAf.jU(true);
            }
            this.fAf.setData(aVar.bbR());
            if (aVar.getCount() > 0) {
                this.bxb.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dUv.setVisibility(0);
                this.fAf.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bxb.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dUv.setVisibility(8);
            }
        }
        this.fAf.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            cD(false);
        }
    }

    public void startSync() {
        this.fAe.showLoadingDialog(this.fAe.getPageContext().getString(e.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.fAe.closeLoadingDialog();
        if (str != null) {
            this.fAe.showToast(str);
        }
        if (z2) {
            bbG();
        }
        this.fAf.notifyDataSetChanged();
    }

    public void auB() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fAe.showToast(this.fAe.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.bbR() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.bbR().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.fAf.setData(aVar.bbR());
            }
        } else {
            this.fAe.showToast(str);
        }
        this.fAf.jU(false);
        this.mProgressBar.setVisibility(8);
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fAf.setData(arrayList);
    }

    private void bbG() {
        if (this.fAg == null) {
            this.fAg = new com.baidu.tbadk.core.dialog.a(this.fAe.getPageContext().getPageActivity());
            this.fAg.ei(this.fAe.getPageContext().getString(e.j.sync_mark_fail));
            this.fAg.ej(this.fAe.getPageContext().getString(e.j.neterror));
            if (this.fAh != null) {
                this.fAg.a(this.fAe.getPageContext().getString(e.j.retry_rightnow), this.fAh);
            }
            this.fAg.b(this.fAe.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fAg.b(this.fAe.getPageContext());
            this.fAg.bf(true);
        }
        this.fAg.AB();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.fAe.getPageContext(), i);
        this.fAe.getLayoutMode().onModeChanged(this.dop);
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fAe.getPageContext(), i);
        }
    }

    public void bbH() {
        this.fAf.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fAg != null) {
            this.fAg.dismiss();
            this.fAg = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dUv != null) {
            this.dUv.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fAi;
    }

    public void cD(boolean z) {
        this.fAi = z;
    }
}
