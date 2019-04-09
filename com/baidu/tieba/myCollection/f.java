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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class f {
    BaseFragmentActivity cOs;
    private View eWj;
    public BdListView fsx;
    private d hba;
    private a hbd;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hbb = null;
    a.b hbc = null;
    private boolean hbe = false;

    public f(ThreadFragment threadFragment, View view) {
        this.cOs = null;
        this.fsx = null;
        this.eWj = null;
        this.mNoDataView = null;
        this.hba = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.cOs = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cOs.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.cOs.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.ad(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.hba = new d(threadFragment.getPageContext());
        this.hba.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fsx = (BdListView) view.findViewById(d.g.list);
        this.fsx.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.eWj = new TextView(this.cOs.getActivity());
        this.eWj.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.cOs.getActivity(), d.e.ds88)));
        this.fsx.addHeaderView(this.eWj, 0);
        this.fsx.setAdapter((ListAdapter) this.hba);
        this.fsx.setOnSrollToBottomListener(threadFragment);
        this.fsx.setOnItemClickListener(threadFragment);
        this.hba.D(threadFragment);
        this.hba.E(threadFragment);
        this.hba.F(threadFragment);
    }

    public void d(a.b bVar) {
        this.hbc = bVar;
    }

    public void mC(boolean z) {
        this.hba.fJ(z);
        this.hba.notifyDataSetChanged();
    }

    public int mD(boolean z) {
        return z ? d.g.share_lv_markitem_delete : d.g.home_lv_markitem_delete;
    }

    public int mE(boolean z) {
        return z ? d.g.share_lv_markitem_userinfo : d.g.home_lv_markitem_userinfo;
    }

    public int mF(boolean z) {
        return z ? d.g.share_mark_item_state : d.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.fsx.startPullRefresh();
            return;
        }
        this.hba.setRefreshing(true);
        this.hba.notifyDataSetChanged();
    }

    public void bhp() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hba.setRefreshing(true);
        if (str != null) {
            this.cOs.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bFr() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bFr() < 20) {
                this.hba.setHasMore(false);
                this.hba.mB(true);
            } else {
                this.hba.setHasMore(true);
                this.hba.mB(true);
            }
            this.hba.setData(aVar.bFq());
            a(aVar, z);
        }
        this.hba.setRefreshing(false);
        this.hba.notifyDataSetChanged();
        if (isPullRefreshing()) {
            eX(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fsx.removeHeaderView(this.mNoDataView);
            this.hba.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.cOs.getPageContext());
        this.fsx.removeHeaderView(this.mNoDataView);
        this.fsx.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bFm() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.cOs.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.cOs.closeLoadingDialog();
        if (str != null) {
            this.cOs.showToast(str);
        }
        if (z2) {
            bFn();
        }
        this.hba.notifyDataSetChanged();
    }

    public void aXY() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hbg;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hbg = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hbg != null) {
                this.hbg.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cOs.showToast(this.cOs.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.bFq() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hba.setData(aVar.bFq());
            if (aVar.bFq().size() == 0) {
                if (this.hbd == null) {
                    this.hbd = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hbd);
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(this.hbd, 600L);
            }
        } else {
            this.cOs.showToast(str);
        }
        this.hba.mB(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cOs.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void an(ArrayList<MarkData> arrayList) {
        this.hba.setData(arrayList);
    }

    private void bFn() {
        if (this.hbb == null) {
            this.hbb = new com.baidu.tbadk.core.dialog.a(this.cOs.getPageContext().getPageActivity());
            this.hbb.ly(this.cOs.getPageContext().getString(d.j.sync_mark_fail));
            this.hbb.lz(this.cOs.getPageContext().getString(d.j.neterror));
            if (this.hbc != null) {
                this.hbb.a(this.cOs.getPageContext().getString(d.j.retry_rightnow), this.hbc);
            }
            this.hbb.b(this.cOs.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hbb.b(this.cOs.getPageContext());
            this.hbb.dr(true);
        }
        this.hbb.aaW();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mParent, d.C0277d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        bFo();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cOs.getPageContext(), i);
            al.l(this.mNoDataView, d.C0277d.common_color_10076);
        }
    }

    public void bFo() {
        this.hba.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hbb != null) {
            this.hbb.dismiss();
            this.hbb = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hbd != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hbd);
        }
    }

    public void completePullRefresh() {
        if (this.fsx != null) {
            this.fsx.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hbe;
    }

    public void eX(boolean z) {
        this.hbe = z;
    }

    public void iO(boolean z) {
        BdListViewHelper.a(this.eWj, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
