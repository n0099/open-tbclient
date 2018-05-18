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
    private TextView bcb;
    private LinearLayout cPo;
    private BdListView dqo;
    EditMarkActivity eUj;
    private e eUk;
    private com.baidu.tbadk.core.dialog.a eUl = null;
    a.b eUm = null;
    private boolean eUn = false;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;

    public c(EditMarkActivity editMarkActivity) {
        this.eUj = null;
        this.dqo = null;
        this.mNoDataView = null;
        this.eUk = null;
        this.bcb = null;
        this.cPo = null;
        this.mProgressBar = null;
        this.eUj = editMarkActivity;
        editMarkActivity.setContentView(d.i.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(d.g.progress);
        this.cPo = (LinearLayout) editMarkActivity.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.eUj.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.getInst().getResources().getDimension(d.e.ds160)), NoDataViewFactory.d.C(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.cPo.addView(this.mNoDataView, 1);
        this.eUk = new e(editMarkActivity.getPageContext());
        this.eUk.notifyDataSetChanged();
        this.mPullView = new com.baidu.tbadk.core.view.f(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.dqo = (BdListView) editMarkActivity.findViewById(d.g.list);
        this.dqo.setAdapter((ListAdapter) this.eUk);
        this.dqo.setPullRefresh(this.mPullView);
        this.dqo.setOnSrollToBottomListener(editMarkActivity);
        this.dqo.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(d.k.my_mark));
        this.bcb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(d.k.edit));
        this.bcb.setOnClickListener(editMarkActivity);
        this.bcb.setVisibility(4);
        this.eUk.z(editMarkActivity);
    }

    public TextView aSK() {
        return this.bcb;
    }

    public void c(a.b bVar) {
        this.eUm = bVar;
    }

    public void aSL() {
        if (!this.eUk.MN()) {
            this.eUk.co(true);
            this.bcb.setText(d.k.done);
            ak.d(this.bcb, TbadkCoreApplication.getInst().getSkinType());
            this.eUk.notifyDataSetChanged();
            return;
        }
        this.eUk.co(false);
        this.bcb.setText(d.k.edit);
        ak.f(this.bcb, TbadkCoreApplication.getInst().getSkinType());
        this.eUk.notifyDataSetChanged();
    }

    public boolean akS() {
        return this.eUk.MN();
    }

    public int aSM() {
        return d.g.home_lv_markitem_delete;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.eUk.setRefreshing(true);
        this.eUk.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void atL() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.eUk.setRefreshing(true);
        if (str != null) {
            this.eUj.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aSZ() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aSZ() < 20) {
                this.eUk.setHasMore(false);
                this.eUk.iT(aVar.isFirst() ? false : true);
            } else {
                this.eUk.setHasMore(true);
                this.eUk.iT(true);
            }
            this.eUk.setData(aVar.aSY());
            if (aVar.getCount() > 0) {
                this.bcb.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.dqo.setVisibility(0);
                this.eUk.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.bcb.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.dqo.setVisibility(8);
            }
        }
        this.eUk.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bL(false);
        }
    }

    public void startSync() {
        this.eUj.showLoadingDialog(this.eUj.getPageContext().getString(d.k.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.eUj.closeLoadingDialog();
        if (str != null) {
            this.eUj.showToast(str);
        }
        if (z2) {
            aSN();
        }
        this.eUk.notifyDataSetChanged();
    }

    public void alR() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.eUj.showToast(this.eUj.getPageContext().getString(d.k.delete_success));
            if (aVar == null || aVar.aSY() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aSY().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.eUk.setData(aVar.aSY());
            }
        } else {
            this.eUj.showToast(str);
        }
        this.eUk.iT(false);
        this.mProgressBar.setVisibility(8);
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.eUk.setData(arrayList);
    }

    private void aSN() {
        if (this.eUl == null) {
            this.eUl = new com.baidu.tbadk.core.dialog.a(this.eUj.getPageContext().getPageActivity());
            this.eUl.db(this.eUj.getPageContext().getString(d.k.sync_mark_fail));
            this.eUl.dc(this.eUj.getPageContext().getString(d.k.neterror));
            if (this.eUm != null) {
                this.eUl.a(this.eUj.getPageContext().getString(d.k.retry_rightnow), this.eUm);
            }
            this.eUl.b(this.eUj.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.c.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eUl.b(this.eUj.getPageContext());
            this.eUl.as(true);
        }
        this.eUl.tC();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.eUj.getPageContext(), i);
        this.eUj.getLayoutMode().u(this.cPo);
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eUj.getPageContext(), i);
        }
    }

    public void aSO() {
        this.eUk.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.eUl != null) {
            this.eUl.dismiss();
            this.eUl = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dqo != null) {
            this.dqo.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.eUn;
    }

    public void bL(boolean z) {
        this.eUn = z;
    }
}
