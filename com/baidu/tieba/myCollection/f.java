package com.baidu.tieba.myCollection;

import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.ag;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f {
    private BdListView aZi;
    private TextView auq;
    private LinearLayout axj;
    EditMarkActivity bDO;
    private h bDP;
    private com.baidu.tbadk.core.dialog.a bDQ = null;
    com.baidu.tbadk.core.dialog.d bDR = null;
    private boolean bDS = false;
    private NavigationBar mNavigationBar;
    private s mNoDataView;
    private ProgressBar mProgressBar;
    private ag mPullView;

    public f(EditMarkActivity editMarkActivity) {
        this.bDO = null;
        this.aZi = null;
        this.mNoDataView = null;
        this.bDP = null;
        this.auq = null;
        this.axj = null;
        this.mProgressBar = null;
        this.bDO = editMarkActivity;
        editMarkActivity.setContentView(w.edit_mark_activity);
        this.mProgressBar = (ProgressBar) editMarkActivity.findViewById(v.progress);
        this.axj = (LinearLayout) editMarkActivity.findViewById(v.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bDO.getPageContext().getPageActivity(), null, com.baidu.tbadk.core.view.v.a(NoDataViewFactory.ImgType.NODATA, (int) TbadkCoreApplication.m411getInst().getResources().getDimension(t.ds160)), com.baidu.tbadk.core.view.w.r(y.mark_nodata, y.mark_nodata_2), null);
        this.axj.addView(this.mNoDataView, 1);
        this.bDP = new h(editMarkActivity);
        this.bDP.dz(false);
        this.bDP.XU();
        this.mPullView = new ag(editMarkActivity.getPageContext());
        this.mPullView.a(editMarkActivity);
        this.aZi = (BdListView) editMarkActivity.findViewById(v.list);
        this.aZi.setAdapter((ListAdapter) this.bDP);
        this.aZi.setPullRefresh(this.mPullView);
        this.aZi.setOnSrollToBottomListener(editMarkActivity);
        this.aZi.setOnItemClickListener(editMarkActivity);
        this.mNavigationBar = (NavigationBar) editMarkActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(editMarkActivity.getResources().getString(y.my_mark));
        this.auq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, editMarkActivity.getResources().getString(y.edit));
        this.auq.setOnClickListener(editMarkActivity);
        this.auq.setVisibility(4);
        this.bDP.r(editMarkActivity);
    }

    public TextView XP() {
        return this.auq;
    }

    public void a(com.baidu.tbadk.core.dialog.d dVar) {
        this.bDR = dVar;
    }

    public void XQ() {
        if (!this.bDP.Ei()) {
            this.bDP.setEditState(true);
            this.auq.setText(y.done);
            ba.g(this.auq, TbadkCoreApplication.m411getInst().getSkinType());
            this.bDP.notifyDataSetChanged();
            return;
        }
        this.bDP.setEditState(false);
        this.auq.setText(y.edit);
        ba.i(this.auq, TbadkCoreApplication.m411getInst().getSkinType());
        this.bDP.notifyDataSetChanged();
    }

    public boolean Ho() {
        return this.bDP.Ei();
    }

    public int XR() {
        return v.home_lv_markitem_delete;
    }

    public void gW(int i) {
        if (i == 0) {
            this.mProgressBar.setVisibility(0);
        }
        this.bDP.setRefreshing(true);
        this.bDP.notifyDataSetChanged();
    }

    public void showLoading() {
        this.mProgressBar.setVisibility(0);
    }

    public void Qj() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.bDP.setRefreshing(true);
        if (str != null) {
            this.bDO.showToast(str);
        }
        if (aVar != null) {
            if (aVar.XY() == 0 && !z) {
                aVar.getCount();
            }
            if (aVar.XY() < 20) {
                this.bDP.setHasMore(false);
                this.bDP.dy(!aVar.isFirst());
            } else {
                this.bDP.setHasMore(true);
                this.bDP.dy(true);
            }
            this.bDP.dz(true);
            this.bDP.p(aVar.XX());
            if (aVar.getCount() > 0) {
                this.auq.setVisibility(0);
                this.mNoDataView.setVisibility(8);
                this.aZi.setVisibility(0);
                this.bDP.notifyDataSetChanged();
            } else if (aVar.getCount() == 0 && !z) {
                this.auq.setVisibility(4);
                this.mNoDataView.setVisibility(0);
                this.aZi.setVisibility(8);
            }
        }
        this.bDP.setRefreshing(false);
        this.mProgressBar.setVisibility(8);
        if (z && !Bf()) {
            showLoading();
        }
        if (Bf()) {
            aV(false);
        }
    }

    public void startSync() {
        this.bDO.showLoadingDialog(this.bDO.getPageContext().getString(y.syncing));
    }

    public void a(boolean z, String str, boolean z2) {
        this.bDO.closeLoadingDialog();
        if (z) {
            this.bDP.XU();
        }
        if (str != null) {
            this.bDO.showToast(str);
        }
        if (z2) {
            XS();
        }
        this.bDP.notifyDataSetChanged();
    }

    public void HM() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bDO.showToast(this.bDO.getPageContext().getString(y.del_mark_success));
            if (aVar == null || aVar.XX() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.XX().size() == 0) {
                aVar.e(true);
            } else {
                this.bDP.p(aVar.XX());
                this.bDP.dz(true);
            }
        } else {
            this.bDO.showToast(str);
        }
        this.bDP.dy(false);
        this.mProgressBar.setVisibility(8);
    }

    public void H(ArrayList<MarkData> arrayList) {
        this.bDP.p(arrayList);
    }

    private void XS() {
        if (this.bDQ == null) {
            this.bDQ = new com.baidu.tbadk.core.dialog.a(this.bDO.getPageContext().getPageActivity());
            this.bDQ.bZ(this.bDO.getPageContext().getString(y.sync_mark_fail));
            this.bDQ.ca(this.bDO.getPageContext().getString(y.neterror));
            if (this.bDR != null) {
                this.bDQ.a(this.bDO.getPageContext().getString(y.retry_rightnow), this.bDR);
            }
            this.bDQ.b(this.bDO.getPageContext().getString(y.confirm), new g(this));
            this.bDQ.b(this.bDO.getPageContext());
            this.bDQ.ad(true);
        }
        this.bDQ.re();
    }

    public void onChangeSkinType(int i) {
        this.mNavigationBar.onChangeSkinType(this.bDO.getPageContext(), i);
        this.bDO.getLayoutMode().h(this.axj);
        if (this.mPullView != null) {
            this.mPullView.ct(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bDO.getPageContext(), i);
        }
    }

    public void XT() {
        this.bDP.XU();
        this.bDP.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.bDQ != null) {
            this.bDQ.dismiss();
            this.bDQ = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        this.bDP.WK();
    }

    public void mW() {
        if (this.aZi != null) {
            this.aZi.mW();
        }
    }

    public boolean Bf() {
        return this.bDS;
    }

    public void aV(boolean z) {
        this.bDS = z;
    }
}
