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
    BaseFragmentActivity cOr;
    private View eWi;
    public BdListView fsx;
    private d haZ;
    private a hbc;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hba = null;
    a.b hbb = null;
    private boolean hbd = false;

    public f(ThreadFragment threadFragment, View view) {
        this.cOr = null;
        this.fsx = null;
        this.eWi = null;
        this.mNoDataView = null;
        this.haZ = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.cOr = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cOr.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.cOr.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.ad(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.haZ = new d(threadFragment.getPageContext());
        this.haZ.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fsx = (BdListView) view.findViewById(d.g.list);
        this.fsx.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.eWi = new TextView(this.cOr.getActivity());
        this.eWi.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.cOr.getActivity(), d.e.ds88)));
        this.fsx.addHeaderView(this.eWi, 0);
        this.fsx.setAdapter((ListAdapter) this.haZ);
        this.fsx.setOnSrollToBottomListener(threadFragment);
        this.fsx.setOnItemClickListener(threadFragment);
        this.haZ.D(threadFragment);
        this.haZ.E(threadFragment);
        this.haZ.F(threadFragment);
    }

    public void d(a.b bVar) {
        this.hbb = bVar;
    }

    public void mC(boolean z) {
        this.haZ.fJ(z);
        this.haZ.notifyDataSetChanged();
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
        this.haZ.setRefreshing(true);
        this.haZ.notifyDataSetChanged();
    }

    public void bhp() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.haZ.setRefreshing(true);
        if (str != null) {
            this.cOr.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bFr() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bFr() < 20) {
                this.haZ.setHasMore(false);
                this.haZ.mB(true);
            } else {
                this.haZ.setHasMore(true);
                this.haZ.mB(true);
            }
            this.haZ.setData(aVar.bFq());
            a(aVar, z);
        }
        this.haZ.setRefreshing(false);
        this.haZ.notifyDataSetChanged();
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
            this.haZ.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.cOr.getPageContext());
        this.fsx.removeHeaderView(this.mNoDataView);
        this.fsx.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bFm() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.cOr.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.cOr.closeLoadingDialog();
        if (str != null) {
            this.cOr.showToast(str);
        }
        if (z2) {
            bFn();
        }
        this.haZ.notifyDataSetChanged();
    }

    public void aXY() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hbf;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hbf = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hbf != null) {
                this.hbf.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cOr.showToast(this.cOr.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.bFq() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.haZ.setData(aVar.bFq());
            if (aVar.bFq().size() == 0) {
                if (this.hbc == null) {
                    this.hbc = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hbc);
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(this.hbc, 600L);
            }
        } else {
            this.cOr.showToast(str);
        }
        this.haZ.mB(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cOr.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void an(ArrayList<MarkData> arrayList) {
        this.haZ.setData(arrayList);
    }

    private void bFn() {
        if (this.hba == null) {
            this.hba = new com.baidu.tbadk.core.dialog.a(this.cOr.getPageContext().getPageActivity());
            this.hba.ly(this.cOr.getPageContext().getString(d.j.sync_mark_fail));
            this.hba.lz(this.cOr.getPageContext().getString(d.j.neterror));
            if (this.hbb != null) {
                this.hba.a(this.cOr.getPageContext().getString(d.j.retry_rightnow), this.hbb);
            }
            this.hba.b(this.cOr.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hba.b(this.cOr.getPageContext());
            this.hba.dr(true);
        }
        this.hba.aaW();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mParent, d.C0277d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        bFo();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cOr.getPageContext(), i);
            al.l(this.mNoDataView, d.C0277d.common_color_10076);
        }
    }

    public void bFo() {
        this.haZ.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hba != null) {
            this.hba.dismiss();
            this.hba = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hbc != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hbc);
        }
    }

    public void completePullRefresh() {
        if (this.fsx != null) {
            this.fsx.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hbd;
    }

    public void eX(boolean z) {
        this.hbd = z;
    }

    public void iO(boolean z) {
        BdListViewHelper.a(this.eWi, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
