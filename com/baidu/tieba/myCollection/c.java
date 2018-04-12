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
    private LinearLayout cOk;
    private BdListView dpj;
    EditMarkActivity eTf;
    private e eTg;
    private com.baidu.tbadk.core.dialog.a eTh = null;
    a.b eTi = null;
    private boolean eTj = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.eTf = null;
        this.dpj = null;
        this.mNoDataView = null;
        this.eTg = null;
        this.bca = null;
        this.cOk = null;
        this.mProgressBar = null;
        this.eTf = editMarkActivity;
        editMarkActivity.setContentView(d.i.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(d.g.progress);
        this.cOk = (LinearLayout) editMarkActivity.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.eTf.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds160)), NoDataViewFactory.d.C(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.cOk.addView(this.mNoDataView, 1);
        this.eTg = new e(editMarkActivity.getPageContext());
        this.eTg.notifyDataSetChanged();
        this.mPullView = new com.baidu.tbadk.core.view.f(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dpj = (BdListView) editMarkActivity.findViewById(d.g.list);
        this.dpj.setAdapter((ListAdapter) this.eTg);
        this.dpj.setPullRefresh(this.mPullView);
        this.dpj.setOnSrollToBottomListener(editMarkActivity);
        this.dpj.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(d.k.my_mark));
        this.bca = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(d.k.edit));
        this.bca.setOnClickListener(editMarkActivity);
        this.bca.setVisibility(4);
        this.eTg.z(editMarkActivity);
    }

    public TextView aSK() {
        return this.bca;
    }

    public void c(a.b bVar) {
        this.eTi = bVar;
    }

    public void aSL() {
        if (!this.eTg.MP()) {
            this.eTg.co(true);
            this.bca.setText(d.k.done);
            ak.d(this.bca, TbadkCoreApplication.getInst().getSkinType());
            this.eTg.notifyDataSetChanged();
            return;
        }
        this.eTg.co(false);
        this.bca.setText(d.k.edit);
        ak.f(this.bca, TbadkCoreApplication.getInst().getSkinType());
        this.eTg.notifyDataSetChanged();
    }

    public boolean akS() {
        return this.eTg.MP();
    }

    public int aSM() {
        return d.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.eTg.setRefreshing(true);
        this.eTg.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void atM() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.eTg.setRefreshing(true);
        if (str != null) {
            this.eTf.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aSZ() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aSZ() < 20) {
                this.eTg.setHasMore(false);
                this.eTg.iS(aVar.isFirst() ? false : true);
            } else {
                this.eTg.setHasMore(true);
                this.eTg.iS(true);
            }
            this.eTg.setData(aVar.aSY());
            if (aVar.getCount() > 0) {
                this.bca.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dpj.setVisibility(0);
                this.eTg.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bca.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dpj.setVisibility(8);
            }
        }
        this.eTg.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bL(false);
        }
    }

    public void startSync() {
        this.eTf.showLoadingDialog(this.eTf.getPageContext().getString(d.k.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.eTf.closeLoadingDialog();
        if (str != null) {
            this.eTf.showToast(str);
        }
        if (z2) {
            aSN();
        }
        this.eTg.notifyDataSetChanged();
    }

    public void alR() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.eTf.showToast(this.eTf.getPageContext().getString(d.k.delete_success));
            if (aVar == null || aVar.aSY() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aSY().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.eTg.setData(aVar.aSY());
            }
        } else {
            this.eTf.showToast(str);
        }
        this.eTg.iS(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.eTg.setData(arrayList);
    }

    private void aSN() {
        if (this.eTh == null) {
            this.eTh = new com.baidu.tbadk.core.dialog.a(this.eTf.getPageContext().getPageActivity());
            this.eTh.db(this.eTf.getPageContext().getString(d.k.sync_mark_fail));
            this.eTh.dc(this.eTf.getPageContext().getString(d.k.neterror));
            if (this.eTi != null) {
                this.eTh.a(this.eTf.getPageContext().getString(d.k.retry_rightnow), this.eTi);
            }
            this.eTh.b(this.eTf.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eTh.b(this.eTf.getPageContext());
            this.eTh.as(true);
        }
        this.eTh.tD();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eTf.getPageContext(), i);
        this.eTf.getLayoutMode().u(this.cOk);
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eTf.getPageContext(), i);
        }
    }

    public void aSO() {
        this.eTg.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.eTh != null) {
            this.eTh.dismiss();
            this.eTh = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dpj != null) {
            this.dpj.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.eTj;
    }

    public void bL(boolean z) {
        this.eTj = z;
    }
}
