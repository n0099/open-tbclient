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
    BaseFragmentActivity bDl;
    private View dJg;
    public BdListView eew;
    private e fKI;
    private com.baidu.tbadk.core.dialog.a fKJ = null;
    a.b fKK = null;
    private boolean fKL = false;
    private a fLk;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.bDl = null;
        this.eew = null;
        this.dJg = null;
        this.mNoDataView = null;
        this.fKI = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bDl = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(e.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bDl.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bDl.getPageContext().getPageActivity(), e.C0210e.ds222)), NoDataViewFactory.d.H(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.fKI = new e(threadFragment.getPageContext());
        this.fKI.notifyDataSetChanged();
        this.mPullView = new k(threadFragment.getPageContext());
        this.eew = (BdListView) view.findViewById(e.g.list);
        this.eew.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.dJg = new TextView(this.bDl.getActivity());
        this.dJg.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.bDl.getActivity(), e.C0210e.ds88)));
        this.eew.addHeaderView(this.dJg, 0);
        this.eew.setAdapter((ListAdapter) this.fKI);
        this.eew.setOnSrollToBottomListener(threadFragment);
        this.eew.setOnItemClickListener(threadFragment);
        this.fKI.C(threadFragment);
        this.fKI.D(threadFragment);
        this.fKI.E(threadFragment);
    }

    public void c(a.b bVar) {
        this.fKK = bVar;
    }

    public void kb(boolean z) {
        this.fKI.dt(z);
        this.fKI.notifyDataSetChanged();
    }

    public int kc(boolean z) {
        return z ? e.g.share_lv_markitem_delete : e.g.home_lv_markitem_delete;
    }

    public int kd(boolean z) {
        return z ? e.g.share_lv_markitem_userinfo : e.g.home_lv_markitem_userinfo;
    }

    public int ke(boolean z) {
        return z ? e.g.share_mark_item_state : e.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.eew.startPullRefresh();
            return;
        }
        this.fKI.setRefreshing(true);
        this.fKI.notifyDataSetChanged();
    }

    public void aHb() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fKI.setRefreshing(true);
        if (str != null) {
            this.bDl.showToast(str);
        }
        if (aVar != null) {
            if (aVar.beU() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.beU() < 20) {
                this.fKI.setHasMore(false);
                this.fKI.ka(true);
            } else {
                this.fKI.setHasMore(true);
                this.fKI.ka(true);
            }
            this.fKI.setData(aVar.beT());
            a(aVar, z);
        }
        this.fKI.setRefreshing(false);
        this.fKI.notifyDataSetChanged();
        if (isPullRefreshing()) {
            cH(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.eew.removeHeaderView(this.mNoDataView);
            this.fKI.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bDl.getPageContext());
        this.eew.removeHeaderView(this.mNoDataView);
        this.eew.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void beR() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bDl.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bDl.closeLoadingDialog();
        if (str != null) {
            this.bDl.showToast(str);
        }
        if (z2) {
            beK();
        }
        this.fKI.notifyDataSetChanged();
    }

    public void axy() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fLm;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fLm = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fLm != null) {
                this.fLm.e(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bDl.showToast(this.bDl.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.beT() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.fKI.setData(aVar.beT());
            if (aVar.beT().size() == 0) {
                if (this.fLk == null) {
                    this.fLk = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fLk);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(this.fLk, 600L);
            }
        } else {
            this.bDl.showToast(str);
        }
        this.fKI.ka(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bDl.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fKI.setData(arrayList);
    }

    private void beK() {
        if (this.fKJ == null) {
            this.fKJ = new com.baidu.tbadk.core.dialog.a(this.bDl.getPageContext().getPageActivity());
            this.fKJ.eJ(this.bDl.getPageContext().getString(e.j.sync_mark_fail));
            this.fKJ.eK(this.bDl.getPageContext().getString(e.j.neterror));
            if (this.fKK != null) {
                this.fKJ.a(this.bDl.getPageContext().getString(e.j.retry_rightnow), this.fKK);
            }
            this.fKJ.b(this.bDl.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fKJ.b(this.bDl.getPageContext());
            this.fKJ.bh(true);
        }
        this.fKJ.BS();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mParent, e.d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        beL();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bDl.getPageContext(), i);
            al.j(this.mNoDataView, e.d.common_color_10076);
        }
    }

    public void beL() {
        this.fKI.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fKJ != null) {
            this.fKJ.dismiss();
            this.fKJ = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fLk != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fLk);
        }
    }

    public void completePullRefresh() {
        if (this.eew != null) {
            this.eew.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fKL;
    }

    public void cH(boolean z) {
        this.fKL = z;
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.dJg, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
