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
    BaseFragmentActivity djs;
    public BdListView fPR;
    private View fsM;
    private RelativeLayout gze;
    private d hAe;
    private a hAh;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hAf = null;
    a.b hAg = null;
    private boolean hAi = false;

    public e(ThreadFragment threadFragment, View view) {
        this.djs = null;
        this.fPR = null;
        this.fsM = null;
        this.mNoDataView = null;
        this.hAe = null;
        this.gze = null;
        this.mProgressBar = null;
        this.djs = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.gze = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.djs.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.djs.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ak(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.hAe = new d(threadFragment.getPageContext());
        this.hAe.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fPR = (BdListView) view.findViewById(R.id.list);
        this.fPR.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.fsM = new TextView(this.djs.getActivity());
        this.fsM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.djs.getActivity(), R.dimen.ds88)));
        this.fPR.addHeaderView(this.fsM, 0);
        this.fPR.setAdapter((ListAdapter) this.hAe);
        this.fPR.setOnSrollToBottomListener(threadFragment);
        this.fPR.setOnItemClickListener(threadFragment);
        this.hAe.I(threadFragment);
        this.hAe.J(threadFragment);
        this.hAe.K(threadFragment);
    }

    public void d(a.b bVar) {
        this.hAg = bVar;
    }

    public void nv(boolean z) {
        this.hAe.gc(z);
        this.hAe.notifyDataSetChanged();
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
            this.fPR.startPullRefresh();
            return;
        }
        this.hAe.setRefreshing(true);
        this.hAe.notifyDataSetChanged();
    }

    public void boQ() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hAe.setRefreshing(true);
        if (str != null) {
            this.djs.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bNO() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bNO() < 20) {
                this.hAe.setHasMore(false);
                this.hAe.nu(true);
            } else {
                this.hAe.setHasMore(true);
                this.hAe.nu(true);
            }
            this.hAe.setData(aVar.bNN());
            a(aVar, z);
        }
        this.hAe.setRefreshing(false);
        this.hAe.notifyDataSetChanged();
        if (isPullRefreshing()) {
            fr(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fPR.removeHeaderView(this.mNoDataView);
            this.hAe.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.djs.getPageContext());
        this.fPR.removeHeaderView(this.mNoDataView);
        this.fPR.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bNJ() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.djs.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.djs.closeLoadingDialog();
        if (str != null) {
            this.djs.showToast(str);
        }
        if (z2) {
            bNK();
        }
        this.hAe.notifyDataSetChanged();
    }

    public void bgi() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hAk;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hAk = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hAk != null) {
                this.hAk.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.djs.showToast(this.djs.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.bNN() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hAe.setData(aVar.bNN());
            if (aVar.bNN().size() == 0) {
                if (this.hAh == null) {
                    this.hAh = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hAh);
                }
                com.baidu.adp.lib.g.e.fZ().postDelayed(this.hAh, 600L);
            }
        } else {
            this.djs.showToast(str);
        }
        this.hAe.nu(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.djs.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void av(ArrayList<MarkData> arrayList) {
        this.hAe.setData(arrayList);
    }

    private void bNK() {
        if (this.hAf == null) {
            this.hAf = new com.baidu.tbadk.core.dialog.a(this.djs.getPageContext().getPageActivity());
            this.hAf.nm(this.djs.getPageContext().getString(R.string.sync_mark_fail));
            this.hAf.nn(this.djs.getPageContext().getString(R.string.neterror));
            if (this.hAg != null) {
                this.hAf.a(this.djs.getPageContext().getString(R.string.retry_rightnow), this.hAg);
            }
            this.hAf.b(this.djs.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hAf.b(this.djs.getPageContext());
            this.hAf.eh(true);
        }
        this.hAf.akO();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.gze, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        bNL();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.djs.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.common_color_10076);
        }
    }

    public void bNL() {
        this.hAe.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hAf != null) {
            this.hAf.dismiss();
            this.hAf = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hAh != null) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.hAh);
        }
    }

    public void completePullRefresh() {
        if (this.fPR != null) {
            this.fPR.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hAi;
    }

    public void fr(boolean z) {
        this.hAi = z;
    }

    public void jx(boolean z) {
        BdListViewHelper.a(this.fsM, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
