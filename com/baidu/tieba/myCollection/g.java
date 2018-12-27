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
    BaseFragmentActivity bCx;
    private View dIw;
    public BdListView edP;
    private e fJN;
    private com.baidu.tbadk.core.dialog.a fJO = null;
    a.b fJP = null;
    private boolean fJQ = false;
    private a fKp;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.bCx = null;
        this.edP = null;
        this.dIw = null;
        this.mNoDataView = null;
        this.fJN = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bCx = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(e.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bCx.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bCx.getPageContext().getPageActivity(), e.C0210e.ds222)), NoDataViewFactory.d.H(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.fJN = new e(threadFragment.getPageContext());
        this.fJN.notifyDataSetChanged();
        this.mPullView = new k(threadFragment.getPageContext());
        this.edP = (BdListView) view.findViewById(e.g.list);
        this.edP.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.dIw = new TextView(this.bCx.getActivity());
        this.dIw.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.bCx.getActivity(), e.C0210e.ds88)));
        this.edP.addHeaderView(this.dIw, 0);
        this.edP.setAdapter((ListAdapter) this.fJN);
        this.edP.setOnSrollToBottomListener(threadFragment);
        this.edP.setOnItemClickListener(threadFragment);
        this.fJN.C(threadFragment);
        this.fJN.D(threadFragment);
        this.fJN.E(threadFragment);
    }

    public void c(a.b bVar) {
        this.fJP = bVar;
    }

    public void kb(boolean z) {
        this.fJN.dq(z);
        this.fJN.notifyDataSetChanged();
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
            this.edP.startPullRefresh();
            return;
        }
        this.fJN.setRefreshing(true);
        this.fJN.notifyDataSetChanged();
    }

    public void aGE() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fJN.setRefreshing(true);
        if (str != null) {
            this.bCx.showToast(str);
        }
        if (aVar != null) {
            if (aVar.beu() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.beu() < 20) {
                this.fJN.setHasMore(false);
                this.fJN.ka(true);
            } else {
                this.fJN.setHasMore(true);
                this.fJN.ka(true);
            }
            this.fJN.setData(aVar.bet());
            a(aVar, z);
        }
        this.fJN.setRefreshing(false);
        this.fJN.notifyDataSetChanged();
        if (isPullRefreshing()) {
            cE(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.edP.removeHeaderView(this.mNoDataView);
            this.fJN.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bCx.getPageContext());
        this.edP.removeHeaderView(this.mNoDataView);
        this.edP.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void ber() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bCx.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bCx.closeLoadingDialog();
        if (str != null) {
            this.bCx.showToast(str);
        }
        if (z2) {
            bek();
        }
        this.fJN.notifyDataSetChanged();
    }

    public void axb() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fKr;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fKr = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fKr != null) {
                this.fKr.e(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bCx.showToast(this.bCx.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.bet() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.fJN.setData(aVar.bet());
            if (aVar.bet().size() == 0) {
                if (this.fKp == null) {
                    this.fKp = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fKp);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(this.fKp, 600L);
            }
        } else {
            this.bCx.showToast(str);
        }
        this.fJN.ka(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bCx.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aj(ArrayList<MarkData> arrayList) {
        this.fJN.setData(arrayList);
    }

    private void bek() {
        if (this.fJO == null) {
            this.fJO = new com.baidu.tbadk.core.dialog.a(this.bCx.getPageContext().getPageActivity());
            this.fJO.eA(this.bCx.getPageContext().getString(e.j.sync_mark_fail));
            this.fJO.eB(this.bCx.getPageContext().getString(e.j.neterror));
            if (this.fJP != null) {
                this.fJO.a(this.bCx.getPageContext().getString(e.j.retry_rightnow), this.fJP);
            }
            this.fJO.b(this.bCx.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fJO.b(this.bCx.getPageContext());
            this.fJO.bg(true);
        }
        this.fJO.BF();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mParent, e.d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        bel();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bCx.getPageContext(), i);
            al.j(this.mNoDataView, e.d.common_color_10076);
        }
    }

    public void bel() {
        this.fJN.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fJO != null) {
            this.fJO.dismiss();
            this.fJO = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fKp != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.fKp);
        }
    }

    public void completePullRefresh() {
        if (this.edP != null) {
            this.edP.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fJQ;
    }

    public void cE(boolean z) {
        this.fJQ = z;
    }

    public void go(boolean z) {
        BdListViewHelper.a(this.dIw, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
