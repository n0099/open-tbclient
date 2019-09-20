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
    BaseFragmentActivity cZT;
    public BdListView fQy;
    private View ftz;
    private d hBv;
    private a hBy;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hBw = null;
    a.b hBx = null;
    private boolean hBz = false;

    public e(ThreadFragment threadFragment, View view) {
        this.cZT = null;
        this.fQy = null;
        this.ftz = null;
        this.mNoDataView = null;
        this.hBv = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.cZT = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.mParent = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cZT.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cZT.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ag(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.hBv = new d(threadFragment.getPageContext());
        this.hBv.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fQy = (BdListView) view.findViewById(R.id.list);
        this.fQy.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.ftz = new TextView(this.cZT.getActivity());
        this.ftz.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.cZT.getActivity(), R.dimen.ds88)));
        this.fQy.addHeaderView(this.ftz, 0);
        this.fQy.setAdapter((ListAdapter) this.hBv);
        this.fQy.setOnSrollToBottomListener(threadFragment);
        this.fQy.setOnItemClickListener(threadFragment);
        this.hBv.H(threadFragment);
        this.hBv.I(threadFragment);
        this.hBv.J(threadFragment);
    }

    public void d(a.b bVar) {
        this.hBx = bVar;
    }

    public void nK(boolean z) {
        this.hBv.gn(z);
        this.hBv.notifyDataSetChanged();
    }

    public int nL(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int nM(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int nN(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.fQy.startPullRefresh();
            return;
        }
        this.hBv.setRefreshing(true);
        this.hBv.notifyDataSetChanged();
    }

    public void brM() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hBv.setRefreshing(true);
        if (str != null) {
            this.cZT.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bQP() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bQP() < 20) {
                this.hBv.setHasMore(false);
                this.hBv.nJ(true);
            } else {
                this.hBv.setHasMore(true);
                this.hBv.nJ(true);
            }
            this.hBv.setData(aVar.bQO());
            a(aVar, z);
        }
        this.hBv.setRefreshing(false);
        this.hBv.notifyDataSetChanged();
        if (isPullRefreshing()) {
            fA(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fQy.removeHeaderView(this.mNoDataView);
            this.hBv.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.cZT.getPageContext());
        this.fQy.removeHeaderView(this.mNoDataView);
        this.fQy.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bQK() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.cZT.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.cZT.closeLoadingDialog();
        if (str != null) {
            this.cZT.showToast(str);
        }
        if (z2) {
            bQL();
        }
        this.hBv.notifyDataSetChanged();
    }

    public void biq() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hBB;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hBB = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hBB != null) {
                this.hBB.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cZT.showToast(this.cZT.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.bQO() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hBv.setData(aVar.bQO());
            if (aVar.bQO().size() == 0) {
                if (this.hBy == null) {
                    this.hBy = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hBy);
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(this.hBy, 600L);
            }
        } else {
            this.cZT.showToast(str);
        }
        this.hBv.nJ(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cZT.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.e(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ar(ArrayList<MarkData> arrayList) {
        this.hBv.setData(arrayList);
    }

    private void bQL() {
        if (this.hBw == null) {
            this.hBw = new com.baidu.tbadk.core.dialog.a(this.cZT.getPageContext().getPageActivity());
            this.hBw.mP(this.cZT.getPageContext().getString(R.string.sync_mark_fail));
            this.hBw.mQ(this.cZT.getPageContext().getString(R.string.neterror));
            if (this.hBx != null) {
                this.hBw.a(this.cZT.getPageContext().getString(R.string.retry_rightnow), this.hBx);
            }
            this.hBw.b(this.cZT.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hBw.b(this.cZT.getPageContext());
            this.hBw.dR(true);
        }
        this.hBw.agO();
    }

    public void onChangeSkinType(int i) {
        am.l(this.mParent, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        bQM();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cZT.getPageContext(), i);
            am.l(this.mNoDataView, R.color.common_color_10076);
        }
    }

    public void bQM() {
        this.hBv.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hBw != null) {
            this.hBw.dismiss();
            this.hBw = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hBy != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hBy);
        }
    }

    public void completePullRefresh() {
        if (this.fQy != null) {
            this.fQy.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hBz;
    }

    public void fA(boolean z) {
        this.hBz = z;
    }

    public void jJ(boolean z) {
        BdListViewHelper.a(this.ftz, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
