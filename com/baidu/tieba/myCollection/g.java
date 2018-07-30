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
    BaseFragmentActivity boq;
    public BdListView dFz;
    private View djY;
    private e fjM;
    private com.baidu.tbadk.core.dialog.a fjN = null;
    a.b fjO = null;
    private boolean fjP = false;
    private a fko;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private h mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.boq = null;
        this.dFz = null;
        this.djY = null;
        this.mNoDataView = null;
        this.fjM = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.boq = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.boq.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.boq.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.E(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.fjM = new e(threadFragment.getPageContext());
        this.fjM.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.dFz = (BdListView) view.findViewById(d.g.list);
        this.dFz.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.djY = new TextView(this.boq.getActivity());
        this.djY.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.boq.getActivity(), d.e.ds88)));
        this.dFz.addHeaderView(this.djY, 0);
        this.dFz.setAdapter((ListAdapter) this.fjM);
        this.dFz.setOnSrollToBottomListener(threadFragment);
        this.dFz.setOnItemClickListener(threadFragment);
        this.fjM.A(threadFragment);
        this.fjM.B(threadFragment);
        this.fjM.C(threadFragment);
    }

    public void c(a.b bVar) {
        this.fjO = bVar;
    }

    public void iV(boolean z) {
        this.fjM.cx(z);
        this.fjM.notifyDataSetChanged();
    }

    public int iW(boolean z) {
        return z ? d.g.share_lv_markitem_delete : d.g.home_lv_markitem_delete;
    }

    public int iX(boolean z) {
        return z ? d.g.share_lv_markitem_userinfo : d.g.home_lv_markitem_userinfo;
    }

    public int iY(boolean z) {
        return z ? d.g.share_mark_item_state : d.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.dFz.startPullRefresh();
            return;
        }
        this.fjM.setRefreshing(true);
        this.fjM.notifyDataSetChanged();
    }

    public void azi() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fjM.setRefreshing(true);
        if (str != null) {
            this.boq.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aWY() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aWY() < 20) {
                this.fjM.setHasMore(false);
                this.fjM.iU(true);
            } else {
                this.fjM.setHasMore(true);
                this.fjM.iU(true);
            }
            this.fjM.setData(aVar.aWX());
            a(aVar, z);
        }
        this.fjM.setRefreshing(false);
        this.fjM.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bQ(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dFz.removeHeaderView(this.mNoDataView);
            this.fjM.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.boq.getPageContext());
        this.dFz.removeHeaderView(this.mNoDataView);
        this.dFz.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aWV() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.boq.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.boq.closeLoadingDialog();
        if (str != null) {
            this.boq.showToast(str);
        }
        if (z2) {
            aWM();
        }
        this.fjM.notifyDataSetChanged();
    }

    public void apS() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fkq;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fkq = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fkq != null) {
                this.fkq.e(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.boq.showToast(this.boq.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.aWX() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.fjM.setData(aVar.aWX());
            if (aVar.aWX().size() == 0) {
                if (this.fko == null) {
                    this.fko = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.in().removeCallbacks(this.fko);
                }
                com.baidu.adp.lib.g.e.in().postDelayed(this.fko, 600L);
            }
        } else {
            this.boq.showToast(str);
        }
        this.fjM.iU(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.boq.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fjM.setData(arrayList);
    }

    private void aWM() {
        if (this.fjN == null) {
            this.fjN = new com.baidu.tbadk.core.dialog.a(this.boq.getPageContext().getPageActivity());
            this.fjN.dA(this.boq.getPageContext().getString(d.j.sync_mark_fail));
            this.fjN.dB(this.boq.getPageContext().getString(d.j.neterror));
            if (this.fjO != null) {
                this.fjN.a(this.boq.getPageContext().getString(d.j.retry_rightnow), this.fjO);
            }
            this.fjN.b(this.boq.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fjN.b(this.boq.getPageContext());
            this.fjN.av(true);
        }
        this.fjN.xf();
    }

    public void onChangeSkinType(int i) {
        am.j(this.mParent, d.C0140d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        aWN();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.boq.getPageContext(), i);
            am.j(this.mNoDataView, d.C0140d.common_color_10076);
        }
    }

    public void aWN() {
        this.fjM.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fjN != null) {
            this.fjN.dismiss();
            this.fjN = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fko != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fko);
        }
    }

    public void completePullRefresh() {
        if (this.dFz != null) {
            this.dFz.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fjP;
    }

    public void bQ(boolean z) {
        this.fjP = z;
    }

    public void fs(boolean z) {
        BdListViewHelper.a(this.djY, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
