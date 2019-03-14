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
    BaseFragmentActivity cOp;
    private View eWw;
    public BdListView fsL;
    private d hbm;
    private a hbp;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hbn = null;
    a.b hbo = null;
    private boolean hbq = false;

    public f(ThreadFragment threadFragment, View view) {
        this.cOp = null;
        this.fsL = null;
        this.eWw = null;
        this.mNoDataView = null;
        this.hbm = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.cOp = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cOp.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.cOp.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.ad(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.hbm = new d(threadFragment.getPageContext());
        this.hbm.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fsL = (BdListView) view.findViewById(d.g.list);
        this.fsL.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.eWw = new TextView(this.cOp.getActivity());
        this.eWw.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.cOp.getActivity(), d.e.ds88)));
        this.fsL.addHeaderView(this.eWw, 0);
        this.fsL.setAdapter((ListAdapter) this.hbm);
        this.fsL.setOnSrollToBottomListener(threadFragment);
        this.fsL.setOnItemClickListener(threadFragment);
        this.hbm.D(threadFragment);
        this.hbm.E(threadFragment);
        this.hbm.F(threadFragment);
    }

    public void d(a.b bVar) {
        this.hbo = bVar;
    }

    public void mC(boolean z) {
        this.hbm.fJ(z);
        this.hbm.notifyDataSetChanged();
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
            this.fsL.startPullRefresh();
            return;
        }
        this.hbm.setRefreshing(true);
        this.hbm.notifyDataSetChanged();
    }

    public void bhr() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hbm.setRefreshing(true);
        if (str != null) {
            this.cOp.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bFu() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bFu() < 20) {
                this.hbm.setHasMore(false);
                this.hbm.mB(true);
            } else {
                this.hbm.setHasMore(true);
                this.hbm.mB(true);
            }
            this.hbm.setData(aVar.bFt());
            a(aVar, z);
        }
        this.hbm.setRefreshing(false);
        this.hbm.notifyDataSetChanged();
        if (isPullRefreshing()) {
            eX(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fsL.removeHeaderView(this.mNoDataView);
            this.hbm.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.cOp.getPageContext());
        this.fsL.removeHeaderView(this.mNoDataView);
        this.fsL.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bFp() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.cOp.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.cOp.closeLoadingDialog();
        if (str != null) {
            this.cOp.showToast(str);
        }
        if (z2) {
            bFq();
        }
        this.hbm.notifyDataSetChanged();
    }

    public void aYb() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hbs;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hbs = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hbs != null) {
                this.hbs.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cOp.showToast(this.cOp.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.bFt() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hbm.setData(aVar.bFt());
            if (aVar.bFt().size() == 0) {
                if (this.hbp == null) {
                    this.hbp = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hbp);
                }
                com.baidu.adp.lib.g.e.jH().postDelayed(this.hbp, 600L);
            }
        } else {
            this.cOp.showToast(str);
        }
        this.hbm.mB(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cOp.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void an(ArrayList<MarkData> arrayList) {
        this.hbm.setData(arrayList);
    }

    private void bFq() {
        if (this.hbn == null) {
            this.hbn = new com.baidu.tbadk.core.dialog.a(this.cOp.getPageContext().getPageActivity());
            this.hbn.lx(this.cOp.getPageContext().getString(d.j.sync_mark_fail));
            this.hbn.ly(this.cOp.getPageContext().getString(d.j.neterror));
            if (this.hbo != null) {
                this.hbn.a(this.cOp.getPageContext().getString(d.j.retry_rightnow), this.hbo);
            }
            this.hbn.b(this.cOp.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.f.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hbn.b(this.cOp.getPageContext());
            this.hbn.dr(true);
        }
        this.hbn.aaZ();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mParent, d.C0277d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        bFr();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cOp.getPageContext(), i);
            al.l(this.mNoDataView, d.C0277d.common_color_10076);
        }
    }

    public void bFr() {
        this.hbm.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hbn != null) {
            this.hbn.dismiss();
            this.hbn = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hbp != null) {
            com.baidu.adp.lib.g.e.jH().removeCallbacks(this.hbp);
        }
    }

    public void completePullRefresh() {
        if (this.fsL != null) {
            this.fsL.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hbq;
    }

    public void eX(boolean z) {
        this.hbq = z;
    }

    public void iO(boolean z) {
        BdListViewHelper.a(this.eWw, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
