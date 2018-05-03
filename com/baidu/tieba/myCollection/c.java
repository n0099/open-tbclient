package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes3.dex */
public class c {
    private TextView bca;
    private LinearLayout cOh;
    private BdListView dpg;
    EditMarkActivity eTc;
    private e eTd;
    private com.baidu.tbadk.core.dialog.a eTe = null;
    a.b eTf = null;
    private boolean eTg = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.eTc = null;
        this.dpg = null;
        this.mNoDataView = null;
        this.eTd = null;
        this.bca = null;
        this.cOh = null;
        this.mProgressBar = null;
        this.eTc = editMarkActivity;
        editMarkActivity.setContentView(d.i.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(d.g.progress);
        this.cOh = (LinearLayout) editMarkActivity.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.eTc.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds160)), NoDataViewFactory.d.C(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.cOh.addView(this.mNoDataView, 1);
        this.eTd = new e(editMarkActivity.getPageContext());
        this.eTd.notifyDataSetChanged();
        this.mPullView = new com.baidu.tbadk.core.view.f(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dpg = (BdListView) editMarkActivity.findViewById(d.g.list);
        this.dpg.setAdapter((ListAdapter) this.eTd);
        this.dpg.setPullRefresh(this.mPullView);
        this.dpg.setOnSrollToBottomListener(editMarkActivity);
        this.dpg.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(d.k.my_mark));
        this.bca = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(d.k.edit));
        this.bca.setOnClickListener(editMarkActivity);
        this.bca.setVisibility(4);
        this.eTd.z(editMarkActivity);
    }

    public TextView aSK() {
        return this.bca;
    }

    public void c(a.b bVar) {
        this.eTf = bVar;
    }

    public void aSL() {
        if (!this.eTd.MP()) {
            this.eTd.co(true);
            this.bca.setText(d.k.done);
            ak.d(this.bca, TbadkCoreApplication.getInst().getSkinType());
            this.eTd.notifyDataSetChanged();
            return;
        }
        this.eTd.co(false);
        this.bca.setText(d.k.edit);
        ak.f(this.bca, TbadkCoreApplication.getInst().getSkinType());
        this.eTd.notifyDataSetChanged();
    }

    public boolean akS() {
        return this.eTd.MP();
    }

    public int aSM() {
        return d.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.eTd.setRefreshing(true);
        this.eTd.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void atM() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.eTd.setRefreshing(true);
        if (str != null) {
            this.eTc.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aSZ() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aSZ() < 20) {
                this.eTd.setHasMore(false);
                this.eTd.iS(aVar.isFirst() ? false : true);
            } else {
                this.eTd.setHasMore(true);
                this.eTd.iS(true);
            }
            this.eTd.setData(aVar.aSY());
            if (aVar.getCount() > 0) {
                this.bca.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dpg.setVisibility(0);
                this.eTd.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bca.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dpg.setVisibility(8);
            }
        }
        this.eTd.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bL(false);
        }
    }

    public void startSync() {
        this.eTc.showLoadingDialog(this.eTc.getPageContext().getString(d.k.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.eTc.closeLoadingDialog();
        if (str != null) {
            this.eTc.showToast(str);
        }
        if (z2) {
            aSN();
        }
        this.eTd.notifyDataSetChanged();
    }

    public void alR() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.eTc.showToast(this.eTc.getPageContext().getString(d.k.delete_success));
            if (aVar == null || aVar.aSY() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aSY().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.eTd.setData(aVar.aSY());
            }
        } else {
            this.eTc.showToast(str);
        }
        this.eTd.iS(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.eTd.setData(arrayList);
    }

    private void aSN() {
        if (this.eTe == null) {
            this.eTe = new com.baidu.tbadk.core.dialog.a(this.eTc.getPageContext().getPageActivity());
            this.eTe.db(this.eTc.getPageContext().getString(d.k.sync_mark_fail));
            this.eTe.dc(this.eTc.getPageContext().getString(d.k.neterror));
            if (this.eTf != null) {
                this.eTe.a(this.eTc.getPageContext().getString(d.k.retry_rightnow), this.eTf);
            }
            this.eTe.b(this.eTc.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eTe.b(this.eTc.getPageContext());
            this.eTe.as(true);
        }
        this.eTe.tD();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eTc.getPageContext(), i);
        this.eTc.getLayoutMode().u(this.cOh);
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eTc.getPageContext(), i);
        }
    }

    public void aSO() {
        this.eTd.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.eTe != null) {
            this.eTe.dismiss();
            this.eTe = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dpg != null) {
            this.dpg.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.eTg;
    }

    public void bL(boolean z) {
        this.eTg = z;
    }
}
