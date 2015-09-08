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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.z;
import com.baidu.tieba.i;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class j {
    private TextView aFc;
    private LinearLayout aQg;
    EditMarkActivity bXG;
    private m bXH;
    private com.baidu.tbadk.core.dialog.a bXI = null;
    a.b bXJ = null;
    private boolean bXK = false;
    private BdListView bbt;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.u mNoDataView;
    private ProgressBar mProgressBar;
    private z mPullView;

    public j(EditMarkActivity editMarkActivity) {
        this.bXG = null;
        this.bbt = null;
        this.mNoDataView = null;
        this.bXH = null;
        this.aFc = null;
        this.aQg = null;
        this.mProgressBar = null;
        this.bXG = editMarkActivity;
        editMarkActivity.setContentView(i.g.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(i.f.progress);
        this.aQg = (LinearLayout) editMarkActivity.findViewById(i.f.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bXG.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(i.d.ds160)), NoDataViewFactory.d.C(i.h.mark_nodata, i.h.mark_nodata_2), null);
        this.aQg.addView(this.mNoDataView, 1);
        this.bXH = new m(editMarkActivity.getPageContext());
        this.bXH.dZ(false);
        this.bXH.acf();
        this.mPullView = new z(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.bbt = (BdListView) editMarkActivity.findViewById(i.f.list);
        this.bbt.setAdapter((ListAdapter) this.bXH);
        this.bbt.setPullRefresh(this.mPullView);
        this.bbt.setOnSrollToBottomListener(editMarkActivity);
        this.bbt.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(i.h.my_mark));
        this.aFc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(i.h.edit));
        this.aFc.setOnClickListener(editMarkActivity);
        this.aFc.setVisibility(4);
        this.bXH.w(editMarkActivity);
    }

    public TextView aca() {
        return this.aFc;
    }

    public void b(a.b bVar) {
        this.bXJ = bVar;
    }

    public void changeEditState() {
        if (!this.bXH.Gb()) {
            this.bXH.setEditState(true);
            this.aFc.setText(i.h.done);
            al.g(this.aFc, TbadkCoreApplication.m411getInst().getSkinType());
            this.bXH.notifyDataSetChanged();
            return;
        }
        this.bXH.setEditState(false);
        this.aFc.setText(i.h.edit);
        al.i(this.aFc, TbadkCoreApplication.m411getInst().getSkinType());
        this.bXH.notifyDataSetChanged();
    }

    public boolean IW() {
        return this.bXH.Gb();
    }

    public int acb() {
        return i.f.home_lv_markitem_delete;
    }

    public void iq(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.bXH.dX(true);
        this.bXH.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void MX() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.bXH.dX(true);
        if (str != null) {
            this.bXG.showToast(str);
        }
        if (aVar != null) {
            if (aVar.ack() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.ack() < 20) {
                this.bXH.setHasMore(false);
                this.bXH.dY(!aVar.isFirst());
            } else {
                this.bXH.setHasMore(true);
                this.bXH.dY(true);
            }
            this.bXH.dZ(true);
            this.bXH.setData(aVar.acj());
            if (aVar.getCount() > 0) {
                this.aFc.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.bbt.setVisibility(0);
                this.bXH.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.aFc.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.bbt.setVisibility(8);
            }
        }
        this.bXH.dX(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bl(false);
        }
    }

    public void startSync() {
        this.bXG.showLoadingDialog(this.bXG.getPageContext().getString(i.h.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.bXG.closeLoadingDialog();
        if (z) {
            this.bXH.acf();
        }
        if (str != null) {
            this.bXG.showToast(str);
        }
        if (z2) {
            acc();
        }
        this.bXH.notifyDataSetChanged();
    }

    public void Jv() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bXG.showToast(this.bXG.getPageContext().getString(i.h.del_mark_success));
            if (aVar == null || aVar.acj() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.acj().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.bXH.setData(aVar.acj());
                this.bXH.dZ(true);
            }
        } else {
            this.bXG.showToast(str);
        }
        this.bXH.dY(false);
        this.mProgressBar.setVisibility(8);
    }

    public void M(ArrayList<MarkData> arrayList) {
        this.bXH.setData(arrayList);
    }

    private void acc() {
        if (this.bXI == null) {
            this.bXI = new com.baidu.tbadk.core.dialog.a(this.bXG.getPageContext().getPageActivity());
            this.bXI.cs(this.bXG.getPageContext().getString(i.h.sync_mark_fail));
            this.bXI.ct(this.bXG.getPageContext().getString(i.h.neterror));
            if (this.bXJ != null) {
                this.bXI.a(this.bXG.getPageContext().getString(i.h.retry_rightnow), this.bXJ);
            }
            this.bXI.b(this.bXG.getPageContext().getString(i.h.confirm), new k(this));
            this.bXI.b(this.bXG.getPageContext());
            this.bXI.ak(true);
        }
        this.bXI.sU();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bXG.getPageContext(), i);
        this.bXG.getLayoutMode().k(this.aQg);
        if (this.mPullView != null) {
            this.mPullView.cM(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bXG.getPageContext(), i);
        }
    }

    public void acd() {
        this.bXH.acf();
        this.bXH.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.bXI != null) {
            this.bXI.dismiss();
            this.bXI = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.bXH.ace();
    }

    public void completePullRefresh() {
        if (this.bbt != null) {
            this.bbt.completePullRefresh();
        }
    }

    public boolean isPullRefreshing() {
        return this.bXK;
    }

    public void bl(boolean z) {
        this.bXK = z;
    }
}
