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
    private TextView aHJ;
    private LinearLayout aYz;
    private BdListView bmy;
    EditMarkActivity cyf;
    private p cyg;
    private com.baidu.tbadk.core.dialog.a cyh = null;
    a.b cyi = null;
    private boolean cyj = false;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.t mPullView;

    public m(EditMarkActivity editMarkActivity) {
        this.cyf = null;
        this.bmy = null;
        this.mNoDataView = null;
        this.cyg = null;
        this.aHJ = null;
        this.aYz = null;
        this.mProgressBar = null;
        this.cyf = editMarkActivity;
        editMarkActivity.setContentView(n.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(n.g.progress);
        this.aYz = (LinearLayout) editMarkActivity.findViewById(n.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cyf.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(n.e.ds160)), NoDataViewFactory.d.C(n.j.mark_nodata, n.j.mark_nodata_2), null);
        this.aYz.addView(this.mNoDataView, 1);
        this.cyg = new p(editMarkActivity.getPageContext());
        this.cyg.eD(false);
        this.cyg.ajp();
        this.mPullView = new com.baidu.tbadk.core.view.t(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.bmy = (BdListView) editMarkActivity.findViewById(n.g.list);
        this.bmy.setAdapter((ListAdapter) this.cyg);
        this.bmy.setPullRefresh(this.mPullView);
        this.bmy.setOnSrollToBottomListener(editMarkActivity);
        this.bmy.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(n.j.my_mark));
        this.aHJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(n.j.edit));
        this.aHJ.setOnClickListener(editMarkActivity);
        this.aHJ.setVisibility(4);
        this.cyg.x(editMarkActivity);
    }

    public TextView ajk() {
        return this.aHJ;
    }

    public void b(a.b bVar) {
        this.cyi = bVar;
    }

    public void changeEditState() {
        if (!this.cyg.GK()) {
            this.cyg.setEditState(true);
            this.aHJ.setText(n.j.done);
            as.g(this.aHJ, TbadkCoreApplication.m411getInst().getSkinType());
            this.cyg.notifyDataSetChanged();
            return;
        }
        this.cyg.setEditState(false);
        this.aHJ.setText(n.j.edit);
        as.i(this.aHJ, TbadkCoreApplication.m411getInst().getSkinType());
        this.cyg.notifyDataSetChanged();
    }

    public boolean KS() {
        return this.cyg.GK();
    }

    public int ajl() {
        return n.g.home_lv_markitem_delete;
    }

    public void ka(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.cyg.eB(true);
        this.cyg.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void Pe() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.cyg.eB(true);
        if (str != null) {
            this.cyf.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aju() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.aju() < 20) {
                this.cyg.setHasMore(false);
                this.cyg.eC(!aVar.isFirst());
            } else {
                this.cyg.setHasMore(true);
                this.cyg.eC(true);
            }
            this.cyg.eD(true);
            this.cyg.setData(aVar.ajt());
            if (aVar.getCount() > 0) {
                this.aHJ.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.bmy.setVisibility(0);
                this.cyg.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.aHJ.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.bmy.setVisibility(8);
            }
        }
        this.cyg.eB(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bu(false);
        }
    }

    public void startSync() {
        this.cyf.showLoadingDialog(this.cyf.getPageContext().getString(n.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.cyf.closeLoadingDialog();
        if (z) {
            this.cyg.ajp();
        }
        if (str != null) {
            this.cyf.showToast(str);
        }
        if (z2) {
            ajm();
        }
        this.cyg.notifyDataSetChanged();
    }

    public void Lq() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cyf.showToast(this.cyf.getPageContext().getString(n.j.del_mark_success));
            if (aVar == null || aVar.ajt() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.ajt().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.cyg.setData(aVar.ajt());
                this.cyg.eD(true);
            }
        } else {
            this.cyf.showToast(str);
        }
        this.cyg.eC(false);
        this.mProgressBar.setVisibility(8);
    }

    public void R(ArrayList<MarkData> arrayList) {
        this.cyg.setData(arrayList);
    }

    private void ajm() {
        if (this.cyh == null) {
            this.cyh = new com.baidu.tbadk.core.dialog.a(this.cyf.getPageContext().getPageActivity());
            this.cyh.cE(this.cyf.getPageContext().getString(n.j.sync_mark_fail));
            this.cyh.cF(this.cyf.getPageContext().getString(n.j.neterror));
            if (this.cyi != null) {
                this.cyh.a(this.cyf.getPageContext().getString(n.j.retry_rightnow), this.cyi);
            }
            this.cyh.b(this.cyf.getPageContext().getString(n.j.confirm), new n(this));
            this.cyh.b(this.cyf.getPageContext());
            this.cyh.aj(true);
        }
        this.cyh.tf();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cyf.getPageContext(), i);
        this.cyf.getLayoutMode().k(this.aYz);
        if (this.mPullView != null) {
            this.mPullView.cP(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cyf.getPageContext(), i);
        }
    }

    public void ajn() {
        this.cyg.ajp();
        this.cyg.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.cyh != null) {
            this.cyh.dismiss();
            this.cyh = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.cyg.ajo();
    }

    public void completePullRefresh() {
        if (this.bmy != null) {
            this.bmy.completePullRefresh();
        }
    }

    public boolean isPullRefreshing() {
        return this.cyj;
    }

    public void bu(boolean z) {
        this.cyj = z;
    }
}
