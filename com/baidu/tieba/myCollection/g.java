package com.baidu.tieba.myCollection;

import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    BaseFragmentActivity bCu;
    private View dFI;
    public BdListView eaY;
    private e fGV;
    private com.baidu.tbadk.core.dialog.a fGW = null;
    a.b fGX = null;
    private boolean fGY = false;
    private a fHx;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.bCu = null;
        this.eaY = null;
        this.dFI = null;
        this.mNoDataView = null;
        this.fGV = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bCu = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(e.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bCu.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bCu.getPageContext().getPageActivity(), e.C0210e.ds222)), NoDataViewFactory.d.H(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.fGV = new e(threadFragment.getPageContext());
        this.fGV.notifyDataSetChanged();
        this.mPullView = new k(threadFragment.getPageContext());
        this.eaY = (BdListView) view.findViewById(e.g.list);
        this.eaY.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.dFI = new TextView(this.bCu.getActivity());
        this.dFI.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.bCu.getActivity(), e.C0210e.ds88)));
        this.eaY.addHeaderView(this.dFI, 0);
        this.eaY.setAdapter((ListAdapter) this.fGV);
        this.eaY.setOnSrollToBottomListener(threadFragment);
        this.eaY.setOnItemClickListener(threadFragment);
        this.fGV.C(threadFragment);
        this.fGV.D(threadFragment);
        this.fGV.E(threadFragment);
    }

    public void c(a.b bVar) {
        this.fGX = bVar;
    }

    public void jY(boolean z) {
        this.fGV.dq(z);
        this.fGV.notifyDataSetChanged();
    }

    public int jZ(boolean z) {
        return z ? e.g.share_lv_markitem_delete : e.g.home_lv_markitem_delete;
    }

    public int ka(boolean z) {
        return z ? e.g.share_lv_markitem_userinfo : e.g.home_lv_markitem_userinfo;
    }

    public int kb(boolean z) {
        return z ? e.g.share_mark_item_state : e.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.eaY.startPullRefresh();
            return;
        }
        this.fGV.setRefreshing(true);
        this.fGV.notifyDataSetChanged();
    }

    public void aFP() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fGV.setRefreshing(true);
        if (str != null) {
            this.bCu.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bdJ() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bdJ() < 20) {
                this.fGV.setHasMore(false);
                this.fGV.jX(true);
            } else {
                this.fGV.setHasMore(true);
                this.fGV.jX(true);
            }
            this.fGV.setData(aVar.bdI());
            a(aVar, z);
        }
        this.fGV.setRefreshing(false);
        this.fGV.notifyDataSetChanged();
        if (isPullRefreshing()) {
            cE(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.eaY.removeHeaderView(this.mNoDataView);
            this.fGV.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bCu.getPageContext());
        this.eaY.removeHeaderView(this.mNoDataView);
        this.eaY.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bdG() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bCu.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bCu.closeLoadingDialog();
        if (str != null) {
            this.bCu.showToast(str);
        }
        if (z2) {
            bdx();
        }
        this.fGV.notifyDataSetChanged();
    }

    public void awm() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fHz;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fHz = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fHz != null) {
                this.fHz.e(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bCu.showToast(this.bCu.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.bdI() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.fGV.setData(aVar.bdI());
            if (aVar.bdI().size() == 0) {
                if (this.fHx == null) {
                    this.fHx = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fHx);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(this.fHx, 600L);
            }
        } else {
            this.bCu.showToast(str);
        }
        this.fGV.jX(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bCu.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fGV.setData(arrayList);
    }

    private void bdx() {
        if (this.fGW == null) {
            this.fGW = new com.baidu.tbadk.core.dialog.a(this.bCu.getPageContext().getPageActivity());
            this.fGW.eA(this.bCu.getPageContext().getString(e.j.sync_mark_fail));
            this.fGW.eB(this.bCu.getPageContext().getString(e.j.neterror));
            if (this.fGX != null) {
                this.fGW.a(this.bCu.getPageContext().getString(e.j.retry_rightnow), this.fGX);
            }
            this.fGW.b(this.bCu.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fGW.b(this.bCu.getPageContext());
            this.fGW.bg(true);
        }
        this.fGW.BF();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mParent, e.d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        bdy();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bCu.getPageContext(), i);
            al.j(this.mNoDataView, e.d.common_color_10076);
        }
    }

    public void bdy() {
        this.fGV.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fGW != null) {
            this.fGW.dismiss();
            this.fGW = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fHx != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fHx);
        }
    }

    public void completePullRefresh() {
        if (this.eaY != null) {
            this.eaY.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fGY;
    }

    public void cE(boolean z) {
        this.fGY = z;
    }

    public void gm(boolean z) {
        BdListViewHelper.a(this.dFI, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
