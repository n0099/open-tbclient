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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    BaseFragmentActivity diB;
    public BdListView fPa;
    private View frV;
    private RelativeLayout gyn;
    private d hzn;
    private a hzq;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hzo = null;
    a.b hzp = null;
    private boolean hzr = false;

    public e(ThreadFragment threadFragment, View view) {
        this.diB = null;
        this.fPa = null;
        this.frV = null;
        this.mNoDataView = null;
        this.hzn = null;
        this.gyn = null;
        this.mProgressBar = null;
        this.diB = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.gyn = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.diB.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.diB.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ai(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.hzn = new d(threadFragment.getPageContext());
        this.hzn.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fPa = (BdListView) view.findViewById(R.id.list);
        this.fPa.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.frV = new TextView(this.diB.getActivity());
        this.frV.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.diB.getActivity(), R.dimen.ds88)));
        this.fPa.addHeaderView(this.frV, 0);
        this.fPa.setAdapter((ListAdapter) this.hzn);
        this.fPa.setOnSrollToBottomListener(threadFragment);
        this.fPa.setOnItemClickListener(threadFragment);
        this.hzn.I(threadFragment);
        this.hzn.J(threadFragment);
        this.hzn.K(threadFragment);
    }

    public void d(a.b bVar) {
        this.hzp = bVar;
    }

    public void nv(boolean z) {
        this.hzn.gc(z);
        this.hzn.notifyDataSetChanged();
    }

    public int nw(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int nx(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int ny(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.fPa.startPullRefresh();
            return;
        }
        this.hzn.setRefreshing(true);
        this.hzn.notifyDataSetChanged();
    }

    public void boO() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hzn.setRefreshing(true);
        if (str != null) {
            this.diB.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bNM() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bNM() < 20) {
                this.hzn.setHasMore(false);
                this.hzn.nu(true);
            } else {
                this.hzn.setHasMore(true);
                this.hzn.nu(true);
            }
            this.hzn.setData(aVar.bNL());
            a(aVar, z);
        }
        this.hzn.setRefreshing(false);
        this.hzn.notifyDataSetChanged();
        if (isPullRefreshing()) {
            fr(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fPa.removeHeaderView(this.mNoDataView);
            this.hzn.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.diB.getPageContext());
        this.fPa.removeHeaderView(this.mNoDataView);
        this.fPa.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bNH() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.diB.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.diB.closeLoadingDialog();
        if (str != null) {
            this.diB.showToast(str);
        }
        if (z2) {
            bNI();
        }
        this.hzn.notifyDataSetChanged();
    }

    public void bgg() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hzt;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hzt = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hzt != null) {
                this.hzt.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.diB.showToast(this.diB.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.bNL() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hzn.setData(aVar.bNL());
            if (aVar.bNL().size() == 0) {
                if (this.hzq == null) {
                    this.hzq = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hzq);
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.hzq, 600L);
            }
        } else {
            this.diB.showToast(str);
        }
        this.hzn.nu(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.diB.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void av(ArrayList<MarkData> arrayList) {
        this.hzn.setData(arrayList);
    }

    private void bNI() {
        if (this.hzo == null) {
            this.hzo = new com.baidu.tbadk.core.dialog.a(this.diB.getPageContext().getPageActivity());
            this.hzo.nm(this.diB.getPageContext().getString(R.string.sync_mark_fail));
            this.hzo.nn(this.diB.getPageContext().getString(R.string.neterror));
            if (this.hzp != null) {
                this.hzo.a(this.diB.getPageContext().getString(R.string.retry_rightnow), this.hzp);
            }
            this.hzo.b(this.diB.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hzo.b(this.diB.getPageContext());
            this.hzo.eh(true);
        }
        this.hzo.akM();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.gyn, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        bNJ();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.diB.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.common_color_10076);
        }
    }

    public void bNJ() {
        this.hzn.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hzo != null) {
            this.hzo.dismiss();
            this.hzo = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hzq != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hzq);
        }
    }

    public void completePullRefresh() {
        if (this.fPa != null) {
            this.fPa.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hzr;
    }

    public void fr(boolean z) {
        this.hzr = z;
    }

    public void jx(boolean z) {
        BdListViewHelper.a(this.frV, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
