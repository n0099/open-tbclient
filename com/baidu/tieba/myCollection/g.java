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
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    BaseFragmentActivity bnK;
    public BdListView dCN;
    private View dhi;
    private e fjA;
    private com.baidu.tbadk.core.dialog.a fjB = null;
    a.b fjC = null;
    private boolean fjD = false;
    private a fkc;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private h mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.bnK = null;
        this.dCN = null;
        this.dhi = null;
        this.mNoDataView = null;
        this.fjA = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bnK = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bnK.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.bnK.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.D(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.fjA = new e(threadFragment.getPageContext());
        this.fjA.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.dCN = (BdListView) view.findViewById(d.g.list);
        this.dCN.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.dhi = new TextView(this.bnK.getActivity());
        this.dhi.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.bnK.getActivity(), d.e.ds88)));
        this.dCN.addHeaderView(this.dhi, 0);
        this.dCN.setAdapter((ListAdapter) this.fjA);
        this.dCN.setOnSrollToBottomListener(threadFragment);
        this.dCN.setOnItemClickListener(threadFragment);
        this.fjA.C(threadFragment);
        this.fjA.D(threadFragment);
        this.fjA.E(threadFragment);
    }

    public void c(a.b bVar) {
        this.fjC = bVar;
    }

    public void jj(boolean z) {
        this.fjA.cx(z);
        this.fjA.notifyDataSetChanged();
    }

    public int jk(boolean z) {
        return z ? d.g.share_lv_markitem_delete : d.g.home_lv_markitem_delete;
    }

    public int jl(boolean z) {
        return z ? d.g.share_lv_markitem_userinfo : d.g.home_lv_markitem_userinfo;
    }

    public int jm(boolean z) {
        return z ? d.g.share_mark_item_state : d.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.dCN.startPullRefresh();
            return;
        }
        this.fjA.setRefreshing(true);
        this.fjA.notifyDataSetChanged();
    }

    public void ayD() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fjA.setRefreshing(true);
        if (str != null) {
            this.bnK.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aYC() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aYC() < 20) {
                this.fjA.setHasMore(false);
                this.fjA.ji(true);
            } else {
                this.fjA.setHasMore(true);
                this.fjA.ji(true);
            }
            this.fjA.setData(aVar.aYB());
            a(aVar, z);
        }
        this.fjA.setRefreshing(false);
        this.fjA.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bS(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dCN.removeHeaderView(this.mNoDataView);
            this.fjA.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bnK.getPageContext());
        this.dCN.removeHeaderView(this.mNoDataView);
        this.dCN.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aYz() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bnK.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bnK.closeLoadingDialog();
        if (str != null) {
            this.bnK.showToast(str);
        }
        if (z2) {
            aYq();
        }
        this.fjA.notifyDataSetChanged();
    }

    public void aps() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fke;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fke = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fke != null) {
                this.fke.d(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bnK.showToast(this.bnK.getPageContext().getString(d.k.delete_success));
            if (aVar == null || aVar.aYB() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.fjA.setData(aVar.aYB());
            if (aVar.aYB().size() == 0) {
                if (this.fkc == null) {
                    this.fkc = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.im().removeCallbacks(this.fkc);
                }
                com.baidu.adp.lib.g.e.im().postDelayed(this.fkc, 600L);
            }
        } else {
            this.bnK.showToast(str);
        }
        this.fjA.ji(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bnK.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void am(ArrayList<MarkData> arrayList) {
        this.fjA.setData(arrayList);
    }

    private void aYq() {
        if (this.fjB == null) {
            this.fjB = new com.baidu.tbadk.core.dialog.a(this.bnK.getPageContext().getPageActivity());
            this.fjB.dD(this.bnK.getPageContext().getString(d.k.sync_mark_fail));
            this.fjB.dE(this.bnK.getPageContext().getString(d.k.neterror));
            if (this.fjC != null) {
                this.fjB.a(this.bnK.getPageContext().getString(d.k.retry_rightnow), this.fjC);
            }
            this.fjB.b(this.bnK.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fjB.b(this.bnK.getPageContext());
            this.fjB.ax(true);
        }
        this.fjB.xn();
    }

    public void onChangeSkinType(int i) {
        am.j(this.mParent, d.C0142d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        aYr();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bnK.getPageContext(), i);
            am.j(this.mNoDataView, d.C0142d.common_color_10076);
        }
    }

    public void aYr() {
        this.fjA.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fjB != null) {
            this.fjB.dismiss();
            this.fjB = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fkc != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fkc);
        }
    }

    public void completePullRefresh() {
        if (this.dCN != null) {
            this.dCN.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fjD;
    }

    public void bS(boolean z) {
        this.fjD = z;
    }

    public void fr(boolean z) {
        BdListViewHelper.a(this.dhi, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
