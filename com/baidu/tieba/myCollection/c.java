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
import com.baidu.tbadk.core.view.k;
import com.baidu.tieba.e;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class c {
    private TextView bsj;
    private BdListView dLs;
    private LinearLayout dfe;
    EditMarkActivity frb;
    private e frc;
    private com.baidu.tbadk.core.dialog.a frd = null;
    a.b fre = null;
    private boolean frf = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private k mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.frb = null;
        this.dLs = null;
        this.mNoDataView = null;
        this.frc = null;
        this.bsj = null;
        this.dfe = null;
        this.mProgressBar = null;
        this.frb = editMarkActivity;
        editMarkActivity.setContentView(e.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(e.g.progress);
        this.dfe = (LinearLayout) editMarkActivity.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.frb.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(e.C0141e.ds160)), NoDataViewFactory.d.G(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.dfe.addView(this.mNoDataView, 1);
        this.frc = new e(editMarkActivity.getPageContext());
        this.frc.notifyDataSetChanged();
        this.mPullView = new k(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dLs = (BdListView) editMarkActivity.findViewById(e.g.list);
        this.dLs.setAdapter((ListAdapter) this.frc);
        this.dLs.setPullRefresh(this.mPullView);
        this.dLs.setOnSrollToBottomListener(editMarkActivity);
        this.dLs.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(e.j.my_mark));
        this.bsj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(e.j.edit));
        this.bsj.setOnClickListener(editMarkActivity);
        this.bsj.setVisibility(4);
        this.frc.A(editMarkActivity);
    }

    public TextView aYS() {
        return this.bsj;
    }

    public void c(a.b bVar) {
        this.fre = bVar;
    }

    public void aYT() {
        if (!this.frc.SJ()) {
            this.frc.cP(true);
            this.bsj.setText(e.j.done);
            al.d(this.bsj, TbadkCoreApplication.getInst().getSkinType());
            this.frc.notifyDataSetChanged();
            return;
        }
        this.frc.cP(false);
        this.bsj.setText(e.j.edit);
        al.f(this.bsj, TbadkCoreApplication.getInst().getSkinType());
        this.frc.notifyDataSetChanged();
    }

    public boolean aqI() {
        return this.frc.SJ();
    }

    public int aYU() {
        return e.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.frc.setRefreshing(true);
        this.frc.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void aBo() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.frc.setRefreshing(true);
        if (str != null) {
            this.frb.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aZh() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aZh() < 20) {
                this.frc.setHasMore(false);
                this.frc.js(aVar.isFirst() ? false : true);
            } else {
                this.frc.setHasMore(true);
                this.frc.js(true);
            }
            this.frc.setData(aVar.aZg());
            if (aVar.getCount() > 0) {
                this.bsj.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dLs.setVisibility(0);
                this.frc.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bsj.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dLs.setVisibility(8);
            }
        }
        this.frc.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            cd(false);
        }
    }

    public void startSync() {
        this.frb.showLoadingDialog(this.frb.getPageContext().getString(e.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.frb.closeLoadingDialog();
        if (str != null) {
            this.frb.showToast(str);
        }
        if (z2) {
            aYV();
        }
        this.frc.notifyDataSetChanged();
    }

    public void arG() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.frb.showToast(this.frb.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.aZg() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aZg().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.frc.setData(aVar.aZg());
            }
        } else {
            this.frb.showToast(str);
        }
        this.frc.js(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.frc.setData(arrayList);
    }

    private void aYV() {
        if (this.frd == null) {
            this.frd = new com.baidu.tbadk.core.dialog.a(this.frb.getPageContext().getPageActivity());
            this.frd.dS(this.frb.getPageContext().getString(e.j.sync_mark_fail));
            this.frd.dT(this.frb.getPageContext().getString(e.j.neterror));
            if (this.fre != null) {
                this.frd.a(this.frb.getPageContext().getString(e.j.retry_rightnow), this.fre);
            }
            this.frd.b(this.frb.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.frd.b(this.frb.getPageContext());
            this.frd.aF(true);
        }
        this.frd.yl();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.frb.getPageContext(), i);
        this.frb.getLayoutMode().onModeChanged(this.dfe);
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.frb.getPageContext(), i);
        }
    }

    public void aYW() {
        this.frc.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.frd != null) {
            this.frd.dismiss();
            this.frd = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dLs != null) {
            this.dLs.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.frf;
    }

    public void cd(boolean z) {
        this.frf = z;
    }
}
