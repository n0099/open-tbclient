package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.t;
import java.util.ArrayList;
@Deprecated
/* loaded from: classes.dex */
public class m {
    private TextView aIL;
    private LinearLayout baO;
    private BdListView bpm;
    EditMarkActivity cEM;
    private p cEN;
    private com.baidu.tbadk.core.dialog.a cEO = null;
    a.b cEP = null;
    private boolean cEQ = false;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.o mNoDataView;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.t mPullView;

    public m(EditMarkActivity editMarkActivity) {
        this.cEM = null;
        this.bpm = null;
        this.mNoDataView = null;
        this.cEN = null;
        this.aIL = null;
        this.baO = null;
        this.mProgressBar = null;
        this.cEM = editMarkActivity;
        editMarkActivity.setContentView(t.h.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(t.g.progress);
        this.baO = (LinearLayout) editMarkActivity.findViewById(t.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cEM.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.e.ds160)), NoDataViewFactory.d.y(t.j.mark_nodata, t.j.mark_nodata_2), null);
        this.baO.addView(this.mNoDataView, 1);
        this.cEN = new p(editMarkActivity.getPageContext());
        this.cEN.eQ(false);
        this.cEN.ann();
        this.mPullView = new com.baidu.tbadk.core.view.t(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.bpm = (BdListView) editMarkActivity.findViewById(t.g.list);
        this.bpm.setAdapter((ListAdapter) this.cEN);
        this.bpm.setPullRefresh(this.mPullView);
        this.bpm.setOnSrollToBottomListener(editMarkActivity);
        this.bpm.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(t.j.my_mark));
        this.aIL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(t.j.edit));
        this.aIL.setOnClickListener(editMarkActivity);
        this.aIL.setVisibility(4);
        this.cEN.D(editMarkActivity);
    }

    public TextView anh() {
        return this.aIL;
    }

    public void d(a.b bVar) {
        this.cEP = bVar;
    }

    public void ani() {
        if (!this.cEN.Il()) {
            this.cEN.setEditState(true);
            this.aIL.setText(t.j.done);
            ar.g(this.aIL, TbadkCoreApplication.m411getInst().getSkinType());
            this.cEN.notifyDataSetChanged();
            return;
        }
        this.cEN.setEditState(false);
        this.aIL.setText(t.j.edit);
        ar.i(this.aIL, TbadkCoreApplication.m411getInst().getSkinType());
        this.cEN.notifyDataSetChanged();
    }

    public boolean MJ() {
        return this.cEN.Il();
    }

    public int anj() {
        return t.g.home_lv_markitem_delete;
    }

    public void kA(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.cEN.eO(true);
        this.cEN.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void Rh() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.cEN.eO(true);
        if (str != null) {
            this.cEM.showToast(str);
        }
        if (aVar != null) {
            if (aVar.ans() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.ans() < 20) {
                this.cEN.setHasMore(false);
                this.cEN.eP(!aVar.isFirst());
            } else {
                this.cEN.setHasMore(true);
                this.cEN.eP(true);
            }
            this.cEN.eQ(true);
            this.cEN.setData(aVar.anr());
            if (aVar.getCount() > 0) {
                this.aIL.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.bpm.setVisibility(0);
                this.cEN.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.aIL.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.bpm.setVisibility(8);
            }
        }
        this.cEN.eO(false);
        this.mProgressBar.setVisibility(8);
        if (z && !isPullRefreshing()) {
            showLoading();
        }
        if (isPullRefreshing()) {
            bw(false);
        }
    }

    public void startSync() {
        this.cEM.showLoadingDialog(this.cEM.getPageContext().getString(t.j.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.cEM.closeLoadingDialog();
        if (z) {
            this.cEN.ann();
        }
        if (str != null) {
            this.cEM.showToast(str);
        }
        if (z2) {
            ank();
        }
        this.cEN.notifyDataSetChanged();
    }

    public void Nj() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cEM.showToast(this.cEM.getPageContext().getString(t.j.del_mark_success));
            if (aVar == null || aVar.anr() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.anr().size() == 0) {
                aVar.a((Boolean) true, false);
            } else {
                this.cEN.setData(aVar.anr());
                this.cEN.eQ(true);
            }
        } else {
            this.cEM.showToast(str);
        }
        this.cEN.eP(false);
        this.mProgressBar.setVisibility(8);
    }

    public void S(ArrayList<MarkData> arrayList) {
        this.cEN.setData(arrayList);
    }

    private void ank() {
        if (this.cEO == null) {
            this.cEO = new com.baidu.tbadk.core.dialog.a(this.cEM.getPageContext().getPageActivity());
            this.cEO.cD(this.cEM.getPageContext().getString(t.j.sync_mark_fail));
            this.cEO.cE(this.cEM.getPageContext().getString(t.j.neterror));
            if (this.cEP != null) {
                this.cEO.a(this.cEM.getPageContext().getString(t.j.retry_rightnow), this.cEP);
            }
            this.cEO.b(this.cEM.getPageContext().getString(t.j.confirm), new n(this));
            this.cEO.b(this.cEM.getPageContext());
            this.cEO.ak(true);
        }
        this.cEO.uj();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.cEM.getPageContext(), i);
        this.cEM.getLayoutMode().x(this.baO);
        if (this.mPullView != null) {
            this.mPullView.dg(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cEM.getPageContext(), i);
        }
    }

    public void anl() {
        this.cEN.ann();
        this.cEN.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.cEO != null) {
            this.cEO.dismiss();
            this.cEO = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.cEN.anm();
    }

    public void nr() {
        if (this.bpm != null) {
            this.bpm.nr();
        }
    }

    public boolean isPullRefreshing() {
        return this.cEQ;
    }

    public void bw(boolean z) {
        this.cEQ = z;
    }
}
