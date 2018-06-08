package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class c {
    private TextView bkm;
    private LinearLayout cYt;
    private BdListView dzA;
    EditMarkActivity ffB;
    private e ffC;
    private com.baidu.tbadk.core.dialog.a ffD = null;
    a.b ffE = null;
    private boolean ffF = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.ffB = null;
        this.dzA = null;
        this.mNoDataView = null;
        this.ffC = null;
        this.bkm = null;
        this.cYt = null;
        this.mProgressBar = null;
        this.ffB = editMarkActivity;
        editMarkActivity.setContentView(d.i.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(d.g.progress);
        this.cYt = (LinearLayout) editMarkActivity.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.ffB.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds160)), NoDataViewFactory.d.D(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.cYt.addView(this.mNoDataView, 1);
        this.ffC = new e(editMarkActivity.getPageContext());
        this.ffC.notifyDataSetChanged();
        this.mPullView = new com.baidu.tbadk.core.view.g(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dzA = (BdListView) editMarkActivity.findViewById(d.g.list);
        this.dzA.setAdapter((ListAdapter) this.ffC);
        this.dzA.setPullRefresh(this.mPullView);
        this.dzA.setOnSrollToBottomListener(editMarkActivity);
        this.dzA.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(d.k.my_mark));
        this.bkm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(d.k.edit));
        this.bkm.setOnClickListener(editMarkActivity);
        this.bkm.setVisibility(4);
        this.ffC.z(editMarkActivity);
    }

    public TextView aXG() {
        return this.bkm;
    }

    public void c(a.b bVar) {
        this.ffE = bVar;
    }

    public void aXH() {
        if (!this.ffC.Qm()) {
            this.ffC.ct(true);
            this.bkm.setText(d.k.done);
            al.d(this.bkm, TbadkCoreApplication.getInst().getSkinType());
            this.ffC.notifyDataSetChanged();
            return;
        }
        this.ffC.ct(false);
        this.bkm.setText(d.k.edit);
        al.f(this.bkm, TbadkCoreApplication.getInst().getSkinType());
        this.ffC.notifyDataSetChanged();
    }

    public boolean aoY() {
        return this.ffC.Qm();
    }

    public int aXI() {
        return d.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.ffC.setRefreshing(true);
        this.ffC.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void axY() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.ffC.setRefreshing(true);
        if (str != null) {
            this.ffB.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aXV() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aXV() < 20) {
                this.ffC.setHasMore(false);
                this.ffC.iZ(aVar.isFirst() ? false : true);
            } else {
                this.ffC.setHasMore(true);
                this.ffC.iZ(true);
            }
            this.ffC.setData(aVar.aXU());
            if (aVar.getCount() > 0) {
                this.bkm.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dzA.setVisibility(0);
                this.ffC.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bkm.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dzA.setVisibility(8);
            }
        }
        this.ffC.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bP(false);
        }
    }

    public void startSync() {
        this.ffB.showLoadingDialog(this.ffB.getPageContext().getString(d.k.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.ffB.closeLoadingDialog();
        if (str != null) {
            this.ffB.showToast(str);
        }
        if (z2) {
            aXJ();
        }
        this.ffC.notifyDataSetChanged();
    }

    public void apX() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.ffB.showToast(this.ffB.getPageContext().getString(d.k.delete_success));
            if (aVar == null || aVar.aXU() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aXU().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.ffC.setData(aVar.aXU());
            }
        } else {
            this.ffB.showToast(str);
        }
        this.ffC.iZ(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.ffC.setData(arrayList);
    }

    private void aXJ() {
        if (this.ffD == null) {
            this.ffD = new com.baidu.tbadk.core.dialog.a(this.ffB.getPageContext().getPageActivity());
            this.ffD.dA(this.ffB.getPageContext().getString(d.k.sync_mark_fail));
            this.ffD.dB(this.ffB.getPageContext().getString(d.k.neterror));
            if (this.ffE != null) {
                this.ffD.a(this.ffB.getPageContext().getString(d.k.retry_rightnow), this.ffE);
            }
            this.ffD.b(this.ffB.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ffD.b(this.ffB.getPageContext());
            this.ffD.av(true);
        }
        this.ffD.xa();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.ffB.getPageContext(), i);
        this.ffB.getLayoutMode().onModeChanged(this.cYt);
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ffB.getPageContext(), i);
        }
    }

    public void aXK() {
        this.ffC.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.ffD != null) {
            this.ffD.dismiss();
            this.ffD = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dzA != null) {
            this.dzA.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.ffF;
    }

    public void bP(boolean z) {
        this.ffF = z;
    }
}
