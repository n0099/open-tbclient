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
    BaseFragmentActivity bDk;
    private View dJf;
    public BdListView eev;
    private e fKH;
    private com.baidu.tbadk.core.dialog.a fKI = null;
    a.b fKJ = null;
    private boolean fKK = false;
    private a fLj;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.bDk = null;
        this.eev = null;
        this.dJf = null;
        this.mNoDataView = null;
        this.fKH = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bDk = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(e.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bDk.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bDk.getPageContext().getPageActivity(), e.C0210e.ds222)), NoDataViewFactory.d.H(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.fKH = new e(threadFragment.getPageContext());
        this.fKH.notifyDataSetChanged();
        this.mPullView = new k(threadFragment.getPageContext());
        this.eev = (BdListView) view.findViewById(e.g.list);
        this.eev.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.dJf = new TextView(this.bDk.getActivity());
        this.dJf.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.bDk.getActivity(), e.C0210e.ds88)));
        this.eev.addHeaderView(this.dJf, 0);
        this.eev.setAdapter((ListAdapter) this.fKH);
        this.eev.setOnSrollToBottomListener(threadFragment);
        this.eev.setOnItemClickListener(threadFragment);
        this.fKH.C(threadFragment);
        this.fKH.D(threadFragment);
        this.fKH.E(threadFragment);
    }

    public void c(a.b bVar) {
        this.fKJ = bVar;
    }

    public void kb(boolean z) {
        this.fKH.dt(z);
        this.fKH.notifyDataSetChanged();
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
            this.eev.startPullRefresh();
            return;
        }
        this.fKH.setRefreshing(true);
        this.fKH.notifyDataSetChanged();
    }

    public void aHb() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fKH.setRefreshing(true);
        if (str != null) {
            this.bDk.showToast(str);
        }
        if (aVar != null) {
            if (aVar.beU() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.beU() < 20) {
                this.fKH.setHasMore(false);
                this.fKH.ka(true);
            } else {
                this.fKH.setHasMore(true);
                this.fKH.ka(true);
            }
            this.fKH.setData(aVar.beT());
            a(aVar, z);
        }
        this.fKH.setRefreshing(false);
        this.fKH.notifyDataSetChanged();
        if (isPullRefreshing()) {
            cH(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.eev.removeHeaderView(this.mNoDataView);
            this.fKH.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bDk.getPageContext());
        this.eev.removeHeaderView(this.mNoDataView);
        this.eev.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void beR() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bDk.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bDk.closeLoadingDialog();
        if (str != null) {
            this.bDk.showToast(str);
        }
        if (z2) {
            beK();
        }
        this.fKH.notifyDataSetChanged();
    }

    public void axy() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fLl;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fLl = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fLl != null) {
                this.fLl.e(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bDk.showToast(this.bDk.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.beT() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.fKH.setData(aVar.beT());
            if (aVar.beT().size() == 0) {
                if (this.fLj == null) {
                    this.fLj = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fLj);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(this.fLj, 600L);
            }
        } else {
            this.bDk.showToast(str);
        }
        this.fKH.ka(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bDk.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fKH.setData(arrayList);
    }

    private void beK() {
        if (this.fKI == null) {
            this.fKI = new com.baidu.tbadk.core.dialog.a(this.bDk.getPageContext().getPageActivity());
            this.fKI.eJ(this.bDk.getPageContext().getString(e.j.sync_mark_fail));
            this.fKI.eK(this.bDk.getPageContext().getString(e.j.neterror));
            if (this.fKJ != null) {
                this.fKI.a(this.bDk.getPageContext().getString(e.j.retry_rightnow), this.fKJ);
            }
            this.fKI.b(this.bDk.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fKI.b(this.bDk.getPageContext());
            this.fKI.bh(true);
        }
        this.fKI.BS();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mParent, e.d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        beL();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bDk.getPageContext(), i);
            al.j(this.mNoDataView, e.d.common_color_10076);
        }
    }

    public void beL() {
        this.fKH.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fKI != null) {
            this.fKI.dismiss();
            this.fKI = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fLj != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fLj);
        }
    }

    public void completePullRefresh() {
        if (this.eev != null) {
            this.eev.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fKK;
    }

    public void cH(boolean z) {
        this.fKK = z;
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.dJf, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
