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
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class e {
    BaseFragmentActivity cYb;
    public BdListView fNU;
    private View frm;
    private d hyH;
    private a hyK;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hyI = null;
    a.b hyJ = null;
    private boolean hyL = false;

    public e(ThreadFragment threadFragment, View view) {
        this.cYb = null;
        this.fNU = null;
        this.frm = null;
        this.mNoDataView = null;
        this.hyH = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.cYb = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.mParent = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cYb.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cYb.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ag(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.hyH = new d(threadFragment.getPageContext());
        this.hyH.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fNU = (BdListView) view.findViewById(R.id.list);
        this.fNU.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.frm = new TextView(this.cYb.getActivity());
        this.frm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.cYb.getActivity(), R.dimen.ds88)));
        this.fNU.addHeaderView(this.frm, 0);
        this.fNU.setAdapter((ListAdapter) this.hyH);
        this.fNU.setOnSrollToBottomListener(threadFragment);
        this.fNU.setOnItemClickListener(threadFragment);
        this.hyH.H(threadFragment);
        this.hyH.I(threadFragment);
        this.hyH.J(threadFragment);
    }

    public void d(a.b bVar) {
        this.hyJ = bVar;
    }

    public void nG(boolean z) {
        this.hyH.gk(z);
        this.hyH.notifyDataSetChanged();
    }

    public int nH(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int nI(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int nJ(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.fNU.startPullRefresh();
            return;
        }
        this.hyH.setRefreshing(true);
        this.hyH.notifyDataSetChanged();
    }

    public void bqO() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hyH.setRefreshing(true);
        if (str != null) {
            this.cYb.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bPN() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bPN() < 20) {
                this.hyH.setHasMore(false);
                this.hyH.nF(true);
            } else {
                this.hyH.setHasMore(true);
                this.hyH.nF(true);
            }
            this.hyH.setData(aVar.bPM());
            a(aVar, z);
        }
        this.hyH.setRefreshing(false);
        this.hyH.notifyDataSetChanged();
        if (isPullRefreshing()) {
            fx(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fNU.removeHeaderView(this.mNoDataView);
            this.hyH.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.cYb.getPageContext());
        this.fNU.removeHeaderView(this.mNoDataView);
        this.fNU.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bPI() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.cYb.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.cYb.closeLoadingDialog();
        if (str != null) {
            this.cYb.showToast(str);
        }
        if (z2) {
            bPJ();
        }
        this.hyH.notifyDataSetChanged();
    }

    public void bhy() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hyN;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hyN = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hyN != null) {
                this.hyN.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cYb.showToast(this.cYb.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.bPM() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hyH.setData(aVar.bPM());
            if (aVar.bPM().size() == 0) {
                if (this.hyK == null) {
                    this.hyK = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hyK);
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(this.hyK, 600L);
            }
        } else {
            this.cYb.showToast(str);
        }
        this.hyH.nF(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cYb.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ar(ArrayList<MarkData> arrayList) {
        this.hyH.setData(arrayList);
    }

    private void bPJ() {
        if (this.hyI == null) {
            this.hyI = new com.baidu.tbadk.core.dialog.a(this.cYb.getPageContext().getPageActivity());
            this.hyI.mN(this.cYb.getPageContext().getString(R.string.sync_mark_fail));
            this.hyI.mO(this.cYb.getPageContext().getString(R.string.neterror));
            if (this.hyJ != null) {
                this.hyI.a(this.cYb.getPageContext().getString(R.string.retry_rightnow), this.hyJ);
            }
            this.hyI.b(this.cYb.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hyI.b(this.cYb.getPageContext());
            this.hyI.dR(true);
        }
        this.hyI.agI();
    }

    public void onChangeSkinType(int i) {
        am.l(this.mParent, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        bPK();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cYb.getPageContext(), i);
            am.l(this.mNoDataView, R.color.common_color_10076);
        }
    }

    public void bPK() {
        this.hyH.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hyI != null) {
            this.hyI.dismiss();
            this.hyI = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hyK != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hyK);
        }
    }

    public void completePullRefresh() {
        if (this.fNU != null) {
            this.fNU.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hyL;
    }

    public void fx(boolean z) {
        this.hyL = z;
    }

    public void jG(boolean z) {
        BdListViewHelper.a(this.frm, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
