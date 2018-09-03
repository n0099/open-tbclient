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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    BaseFragmentActivity bos;
    public BdListView dFw;
    private View djW;
    private e fjG;
    private com.baidu.tbadk.core.dialog.a fjH = null;
    a.b fjI = null;
    private boolean fjJ = false;
    private a fki;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private h mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.bos = null;
        this.dFw = null;
        this.djW = null;
        this.mNoDataView = null;
        this.fjG = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bos = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(f.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(f.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bos.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.bos.getPageContext().getPageActivity(), f.e.ds222)), NoDataViewFactory.d.E(f.j.mark_nodata, f.j.mark_nodata_2), null);
        this.fjG = new e(threadFragment.getPageContext());
        this.fjG.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.dFw = (BdListView) view.findViewById(f.g.list);
        this.dFw.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.djW = new TextView(this.bos.getActivity());
        this.djW.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.f(this.bos.getActivity(), f.e.ds88)));
        this.dFw.addHeaderView(this.djW, 0);
        this.dFw.setAdapter((ListAdapter) this.fjG);
        this.dFw.setOnSrollToBottomListener(threadFragment);
        this.dFw.setOnItemClickListener(threadFragment);
        this.fjG.A(threadFragment);
        this.fjG.B(threadFragment);
        this.fjG.C(threadFragment);
    }

    public void c(a.b bVar) {
        this.fjI = bVar;
    }

    public void iV(boolean z) {
        this.fjG.cy(z);
        this.fjG.notifyDataSetChanged();
    }

    public int iW(boolean z) {
        return z ? f.g.share_lv_markitem_delete : f.g.home_lv_markitem_delete;
    }

    public int iX(boolean z) {
        return z ? f.g.share_lv_markitem_userinfo : f.g.home_lv_markitem_userinfo;
    }

    public int iY(boolean z) {
        return z ? f.g.share_mark_item_state : f.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.dFw.startPullRefresh();
            return;
        }
        this.fjG.setRefreshing(true);
        this.fjG.notifyDataSetChanged();
    }

    public void azg() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fjG.setRefreshing(true);
        if (str != null) {
            this.bos.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aWU() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aWU() < 20) {
                this.fjG.setHasMore(false);
                this.fjG.iU(true);
            } else {
                this.fjG.setHasMore(true);
                this.fjG.iU(true);
            }
            this.fjG.setData(aVar.aWT());
            a(aVar, z);
        }
        this.fjG.setRefreshing(false);
        this.fjG.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bR(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dFw.removeHeaderView(this.mNoDataView);
            this.fjG.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bos.getPageContext());
        this.dFw.removeHeaderView(this.mNoDataView);
        this.dFw.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aWR() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bos.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bos.closeLoadingDialog();
        if (str != null) {
            this.bos.showToast(str);
        }
        if (z2) {
            aWI();
        }
        this.fjG.notifyDataSetChanged();
    }

    public void apS() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fkk;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fkk = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fkk != null) {
                this.fkk.e(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bos.showToast(this.bos.getPageContext().getString(f.j.delete_success));
            if (aVar == null || aVar.aWT() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.fjG.setData(aVar.aWT());
            if (aVar.aWT().size() == 0) {
                if (this.fki == null) {
                    this.fki = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.in().removeCallbacks(this.fki);
                }
                com.baidu.adp.lib.g.e.in().postDelayed(this.fki, 600L);
            }
        } else {
            this.bos.showToast(str);
        }
        this.fjG.iU(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bos.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fjG.setData(arrayList);
    }

    private void aWI() {
        if (this.fjH == null) {
            this.fjH = new com.baidu.tbadk.core.dialog.a(this.bos.getPageContext().getPageActivity());
            this.fjH.dA(this.bos.getPageContext().getString(f.j.sync_mark_fail));
            this.fjH.dB(this.bos.getPageContext().getString(f.j.neterror));
            if (this.fjI != null) {
                this.fjH.a(this.bos.getPageContext().getString(f.j.retry_rightnow), this.fjI);
            }
            this.fjH.b(this.bos.getPageContext().getString(f.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fjH.b(this.bos.getPageContext());
            this.fjH.aw(true);
        }
        this.fjH.xe();
    }

    public void onChangeSkinType(int i) {
        am.j(this.mParent, f.d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        aWJ();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bos.getPageContext(), i);
            am.j(this.mNoDataView, f.d.common_color_10076);
        }
    }

    public void aWJ() {
        this.fjG.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fjH != null) {
            this.fjH.dismiss();
            this.fjH = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fki != null) {
            com.baidu.adp.lib.g.e.in().removeCallbacks(this.fki);
        }
    }

    public void completePullRefresh() {
        if (this.dFw != null) {
            this.dFw.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fjJ;
    }

    public void bR(boolean z) {
        this.fjJ = z;
    }

    public void fs(boolean z) {
        BdListViewHelper.a(this.djW, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
