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
    BaseFragmentActivity byX;
    public BdListView dUv;
    private View dzj;
    private a fAH;
    private e fAf;
    private com.baidu.tbadk.core.dialog.a fAg = null;
    a.b fAh = null;
    private boolean fAi = false;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.byX = null;
        this.dUv = null;
        this.dzj = null;
        this.mNoDataView = null;
        this.fAf = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.byX = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(e.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.byX.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.byX.getPageContext().getPageActivity(), e.C0200e.ds222)), NoDataViewFactory.d.G(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.fAf = new e(threadFragment.getPageContext());
        this.fAf.notifyDataSetChanged();
        this.mPullView = new k(threadFragment.getPageContext());
        this.dUv = (BdListView) view.findViewById(e.g.list);
        this.dUv.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.dzj = new TextView(this.byX.getActivity());
        this.dzj.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.byX.getActivity(), e.C0200e.ds88)));
        this.dUv.addHeaderView(this.dzj, 0);
        this.dUv.setAdapter((ListAdapter) this.fAf);
        this.dUv.setOnSrollToBottomListener(threadFragment);
        this.dUv.setOnItemClickListener(threadFragment);
        this.fAf.C(threadFragment);
        this.fAf.D(threadFragment);
        this.fAf.E(threadFragment);
    }

    public void c(a.b bVar) {
        this.fAh = bVar;
    }

    public void jV(boolean z) {
        this.fAf.dp(z);
        this.fAf.notifyDataSetChanged();
    }

    public int jW(boolean z) {
        return z ? e.g.share_lv_markitem_delete : e.g.home_lv_markitem_delete;
    }

    public int jX(boolean z) {
        return z ? e.g.share_lv_markitem_userinfo : e.g.home_lv_markitem_userinfo;
    }

    public int jY(boolean z) {
        return z ? e.g.share_mark_item_state : e.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.dUv.startPullRefresh();
            return;
        }
        this.fAf.setRefreshing(true);
        this.fAf.notifyDataSetChanged();
    }

    public void aEd() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fAf.setRefreshing(true);
        if (str != null) {
            this.byX.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bbS() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bbS() < 20) {
                this.fAf.setHasMore(false);
                this.fAf.jU(true);
            } else {
                this.fAf.setHasMore(true);
                this.fAf.jU(true);
            }
            this.fAf.setData(aVar.bbR());
            a(aVar, z);
        }
        this.fAf.setRefreshing(false);
        this.fAf.notifyDataSetChanged();
        if (isPullRefreshing()) {
            cD(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dUv.removeHeaderView(this.mNoDataView);
            this.fAf.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.byX.getPageContext());
        this.dUv.removeHeaderView(this.mNoDataView);
        this.dUv.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bbP() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.byX.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.byX.closeLoadingDialog();
        if (str != null) {
            this.byX.showToast(str);
        }
        if (z2) {
            bbG();
        }
        this.fAf.notifyDataSetChanged();
    }

    public void auB() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fAJ;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fAJ = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fAJ != null) {
                this.fAJ.e(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.byX.showToast(this.byX.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.bbR() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.fAf.setData(aVar.bbR());
            if (aVar.bbR().size() == 0) {
                if (this.fAH == null) {
                    this.fAH = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fAH);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(this.fAH, 600L);
            }
        } else {
            this.byX.showToast(str);
        }
        this.fAf.jU(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.byX.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fAf.setData(arrayList);
    }

    private void bbG() {
        if (this.fAg == null) {
            this.fAg = new com.baidu.tbadk.core.dialog.a(this.byX.getPageContext().getPageActivity());
            this.fAg.ei(this.byX.getPageContext().getString(e.j.sync_mark_fail));
            this.fAg.ej(this.byX.getPageContext().getString(e.j.neterror));
            if (this.fAh != null) {
                this.fAg.a(this.byX.getPageContext().getString(e.j.retry_rightnow), this.fAh);
            }
            this.fAg.b(this.byX.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fAg.b(this.byX.getPageContext());
            this.fAg.bf(true);
        }
        this.fAg.AB();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mParent, e.d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        bbH();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.byX.getPageContext(), i);
            al.j(this.mNoDataView, e.d.common_color_10076);
        }
    }

    public void bbH() {
        this.fAf.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fAg != null) {
            this.fAg.dismiss();
            this.fAg = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fAH != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fAH);
        }
    }

    public void completePullRefresh() {
        if (this.dUv != null) {
            this.dUv.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fAi;
    }

    public void cD(boolean z) {
        this.fAi = z;
    }

    public void gl(boolean z) {
        BdListViewHelper.a(this.dzj, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
