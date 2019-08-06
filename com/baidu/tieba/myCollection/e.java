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
    BaseFragmentActivity cYi;
    public BdListView fOI;
    private View frM;
    private a hzC;
    private d hzz;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hzA = null;
    a.b hzB = null;
    private boolean hzD = false;

    public e(ThreadFragment threadFragment, View view) {
        this.cYi = null;
        this.fOI = null;
        this.frM = null;
        this.mNoDataView = null;
        this.hzz = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.cYi = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.mParent = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cYi.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cYi.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ag(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.hzz = new d(threadFragment.getPageContext());
        this.hzz.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fOI = (BdListView) view.findViewById(R.id.list);
        this.fOI.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.frM = new TextView(this.cYi.getActivity());
        this.frM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.cYi.getActivity(), R.dimen.ds88)));
        this.fOI.addHeaderView(this.frM, 0);
        this.fOI.setAdapter((ListAdapter) this.hzz);
        this.fOI.setOnSrollToBottomListener(threadFragment);
        this.fOI.setOnItemClickListener(threadFragment);
        this.hzz.H(threadFragment);
        this.hzz.I(threadFragment);
        this.hzz.J(threadFragment);
    }

    public void d(a.b bVar) {
        this.hzB = bVar;
    }

    public void nG(boolean z) {
        this.hzz.gk(z);
        this.hzz.notifyDataSetChanged();
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
            this.fOI.startPullRefresh();
            return;
        }
        this.hzz.setRefreshing(true);
        this.hzz.notifyDataSetChanged();
    }

    public void brb() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hzz.setRefreshing(true);
        if (str != null) {
            this.cYi.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bQb() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bQb() < 20) {
                this.hzz.setHasMore(false);
                this.hzz.nF(true);
            } else {
                this.hzz.setHasMore(true);
                this.hzz.nF(true);
            }
            this.hzz.setData(aVar.bQa());
            a(aVar, z);
        }
        this.hzz.setRefreshing(false);
        this.hzz.notifyDataSetChanged();
        if (isPullRefreshing()) {
            fx(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fOI.removeHeaderView(this.mNoDataView);
            this.hzz.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.cYi.getPageContext());
        this.fOI.removeHeaderView(this.mNoDataView);
        this.fOI.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bPW() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.cYi.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.cYi.closeLoadingDialog();
        if (str != null) {
            this.cYi.showToast(str);
        }
        if (z2) {
            bPX();
        }
        this.hzz.notifyDataSetChanged();
    }

    public void bhF() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hzF;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hzF = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hzF != null) {
                this.hzF.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cYi.showToast(this.cYi.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.bQa() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hzz.setData(aVar.bQa());
            if (aVar.bQa().size() == 0) {
                if (this.hzC == null) {
                    this.hzC = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hzC);
                }
                com.baidu.adp.lib.g.e.iK().postDelayed(this.hzC, 600L);
            }
        } else {
            this.cYi.showToast(str);
        }
        this.hzz.nF(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cYi.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ar(ArrayList<MarkData> arrayList) {
        this.hzz.setData(arrayList);
    }

    private void bPX() {
        if (this.hzA == null) {
            this.hzA = new com.baidu.tbadk.core.dialog.a(this.cYi.getPageContext().getPageActivity());
            this.hzA.mN(this.cYi.getPageContext().getString(R.string.sync_mark_fail));
            this.hzA.mO(this.cYi.getPageContext().getString(R.string.neterror));
            if (this.hzB != null) {
                this.hzA.a(this.cYi.getPageContext().getString(R.string.retry_rightnow), this.hzB);
            }
            this.hzA.b(this.cYi.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hzA.b(this.cYi.getPageContext());
            this.hzA.dR(true);
        }
        this.hzA.agK();
    }

    public void onChangeSkinType(int i) {
        am.l(this.mParent, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        bPY();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cYi.getPageContext(), i);
            am.l(this.mNoDataView, R.color.common_color_10076);
        }
    }

    public void bPY() {
        this.hzz.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hzA != null) {
            this.hzA.dismiss();
            this.hzA = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hzC != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.hzC);
        }
    }

    public void completePullRefresh() {
        if (this.fOI != null) {
            this.fOI.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hzD;
    }

    public void fx(boolean z) {
        this.hzD = z;
    }

    public void jG(boolean z) {
        BdListViewHelper.a(this.frM, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
