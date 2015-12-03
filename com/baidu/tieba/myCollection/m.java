package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.n;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class m {
    private TextView aGj;
    private LinearLayout aUy;
    private BdListView biH;
    EditMarkActivity cue;
    private p cuf;
    private com.baidu.tbadk.core.dialog.a cug = null;
    a.b cuh = null;
    private boolean cui = false;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.n mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.s mPullView;

    public m(EditMarkActivity editMarkActivity) {
        this.cue = null;
        this.biH = null;
        this.mNoDataView = null;
        this.cuf = null;
        this.aGj = null;
        this.aUy = null;
        this.mProgressBar = null;
        this.cue = editMarkActivity;
        editMarkActivity.setContentView(n.g.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(n.f.progress);
        this.aUy = (LinearLayout) editMarkActivity.findViewById(n.f.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cue.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.d.ds160)), NoDataViewFactory.d.D(n.i.mark_nodata, n.i.mark_nodata_2), null);
        this.aUy.addView(this.mNoDataView, 1);
        this.cuf = new p(editMarkActivity.getPageContext());
        this.cuf.eE(false);
        this.cuf.aic();
        this.mPullView = new com.baidu.tbadk.core.view.s(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.biH = (BdListView) editMarkActivity.findViewById(n.f.list);
        this.biH.setAdapter((ListAdapter) this.cuf);
        this.biH.setPullRefresh(this.mPullView);
        this.biH.setOnSrollToBottomListener(editMarkActivity);
        this.biH.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(n.i.my_mark));
        this.aGj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(n.i.edit));
        this.aGj.setOnClickListener(editMarkActivity);
        this.aGj.setVisibility(4);
        this.cuf.x(editMarkActivity);
    }

    public TextView ahX() {
        return this.aGj;
    }

    public void b(a.b bVar) {
        this.cuh = bVar;
    }

    public void changeEditState() {
        if (!this.cuf.GV()) {
            this.cuf.setEditState(true);
            this.aGj.setText(n.i.done);
            as.g(this.aGj, TbadkCoreApplication.m411getInst().getSkinType());
            this.cuf.notifyDataSetChanged();
            return;
        }
        this.cuf.setEditState(false);
        this.aGj.setText(n.i.edit);
        as.i(this.aGj, TbadkCoreApplication.m411getInst().getSkinType());
        this.cuf.notifyDataSetChanged();
    }

    public boolean Kz() {
        return this.cuf.GV();
    }

    public int ahY() {
        return n.f.home_lv_markitem_delete;
    }

    public void jC(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.cuf.eC(true);
        this.cuf.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void OM() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.cuf.eC(true);
        if (str != null) {
            this.cue.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aih() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.aih() < 20) {
                this.cuf.setHasMore(false);
                this.cuf.eD(!aVar.isFirst());
            } else {
                this.cuf.setHasMore(true);
                this.cuf.eD(true);
            }
            this.cuf.eE(true);
            this.cuf.setData(aVar.aig());
            if (aVar.getCount() > 0) {
                this.aGj.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.biH.setVisibility(0);
                this.cuf.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.aGj.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.biH.setVisibility(8);
            }
        }
        this.cuf.eC(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bu(false);
        }
    }

    public void startSync() {
        this.cue.showLoadingDialog(this.cue.getPageContext().getString(n.i.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.cue.closeLoadingDialog();
        if (z) {
            this.cuf.aic();
        }
        if (str != null) {
            this.cue.showToast(str);
        }
        if (z2) {
            ahZ();
        }
        this.cuf.notifyDataSetChanged();
    }

    public void KX() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cue.showToast(this.cue.getPageContext().getString(n.i.del_mark_success));
            if (aVar == null || aVar.aig() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aig().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.cuf.setData(aVar.aig());
                this.cuf.eE(true);
            }
        } else {
            this.cue.showToast(str);
        }
        this.cuf.eD(false);
        this.mProgressBar.setVisibility(8);
    }

    public void S(ArrayList<MarkData> arrayList) {
        this.cuf.setData(arrayList);
    }

    private void ahZ() {
        if (this.cug == null) {
            this.cug = new com.baidu.tbadk.core.dialog.a(this.cue.getPageContext().getPageActivity());
            this.cug.cB(this.cue.getPageContext().getString(n.i.sync_mark_fail));
            this.cug.cC(this.cue.getPageContext().getString(n.i.neterror));
            if (this.cuh != null) {
                this.cug.a(this.cue.getPageContext().getString(n.i.retry_rightnow), this.cuh);
            }
            this.cug.b(this.cue.getPageContext().getString(n.i.confirm), new n(this));
            this.cug.b(this.cue.getPageContext());
            this.cug.am(true);
        }
        this.cug.tv();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cue.getPageContext(), i);
        this.cue.getLayoutMode().k(this.aUy);
        if (this.mPullView != null) {
            this.mPullView.cV(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cue.getPageContext(), i);
        }
    }

    public void aia() {
        this.cuf.aic();
        this.cuf.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.cug != null) {
            this.cug.dismiss();
            this.cug = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.cuf.aib();
    }

    public void completePullRefresh() {
        if (this.biH != null) {
            this.biH.completePullRefresh();
        }
    }

    public boolean isPullRefreshing() {
        return this.cui;
    }

    public void bu(boolean z) {
        this.cui = z;
    }
}
