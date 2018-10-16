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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    BaseFragmentActivity bym;
    public BdListView dTo;
    private View dxR;
    private e fyH;
    private com.baidu.tbadk.core.dialog.a fyI = null;
    a.b fyJ = null;
    private boolean fyK = false;
    private a fzj;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.bym = null;
        this.dTo = null;
        this.dxR = null;
        this.mNoDataView = null;
        this.fyH = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bym = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(e.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bym.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bym.getPageContext().getPageActivity(), e.C0175e.ds222)), NoDataViewFactory.d.G(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.fyH = new e(threadFragment.getPageContext());
        this.fyH.notifyDataSetChanged();
        this.mPullView = new k(threadFragment.getPageContext());
        this.dTo = (BdListView) view.findViewById(e.g.list);
        this.dTo.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.dxR = new TextView(this.bym.getActivity());
        this.dxR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.bym.getActivity(), e.C0175e.ds88)));
        this.dTo.addHeaderView(this.dxR, 0);
        this.dTo.setAdapter((ListAdapter) this.fyH);
        this.dTo.setOnSrollToBottomListener(threadFragment);
        this.dTo.setOnItemClickListener(threadFragment);
        this.fyH.A(threadFragment);
        this.fyH.B(threadFragment);
        this.fyH.C(threadFragment);
    }

    public void c(a.b bVar) {
        this.fyJ = bVar;
    }

    public void jL(boolean z) {
        this.fyH.cY(z);
        this.fyH.notifyDataSetChanged();
    }

    public int jM(boolean z) {
        return z ? e.g.share_lv_markitem_delete : e.g.home_lv_markitem_delete;
    }

    public int jN(boolean z) {
        return z ? e.g.share_lv_markitem_userinfo : e.g.home_lv_markitem_userinfo;
    }

    public int jO(boolean z) {
        return z ? e.g.share_mark_item_state : e.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.dTo.startPullRefresh();
            return;
        }
        this.fyH.setRefreshing(true);
        this.fyH.notifyDataSetChanged();
    }

    public void aEH() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fyH.setRefreshing(true);
        if (str != null) {
            this.bym.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bct() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bct() < 20) {
                this.fyH.setHasMore(false);
                this.fyH.jK(true);
            } else {
                this.fyH.setHasMore(true);
                this.fyH.jK(true);
            }
            this.fyH.setData(aVar.bcs());
            a(aVar, z);
        }
        this.fyH.setRefreshing(false);
        this.fyH.notifyDataSetChanged();
        if (isPullRefreshing()) {
            cm(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dTo.removeHeaderView(this.mNoDataView);
            this.fyH.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bym.getPageContext());
        this.dTo.removeHeaderView(this.mNoDataView);
        this.dTo.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bcq() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bym.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bym.closeLoadingDialog();
        if (str != null) {
            this.bym.showToast(str);
        }
        if (z2) {
            bch();
        }
        this.fyH.notifyDataSetChanged();
    }

    public void avc() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fzl;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fzl = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fzl != null) {
                this.fzl.e(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bym.showToast(this.bym.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.bcs() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.fyH.setData(aVar.bcs());
            if (aVar.bcs().size() == 0) {
                if (this.fzj == null) {
                    this.fzj = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fzj);
                }
                com.baidu.adp.lib.g.e.jI().postDelayed(this.fzj, 600L);
            }
        } else {
            this.bym.showToast(str);
        }
        this.fyH.jK(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bym.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.fyH.setData(arrayList);
    }

    private void bch() {
        if (this.fyI == null) {
            this.fyI = new com.baidu.tbadk.core.dialog.a(this.bym.getPageContext().getPageActivity());
            this.fyI.ei(this.bym.getPageContext().getString(e.j.sync_mark_fail));
            this.fyI.ej(this.bym.getPageContext().getString(e.j.neterror));
            if (this.fyJ != null) {
                this.fyI.a(this.bym.getPageContext().getString(e.j.retry_rightnow), this.fyJ);
            }
            this.fyI.b(this.bym.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fyI.b(this.bym.getPageContext());
            this.fyI.aP(true);
        }
        this.fyI.Au();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mParent, e.d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        bci();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bym.getPageContext(), i);
            al.j(this.mNoDataView, e.d.common_color_10076);
        }
    }

    public void bci() {
        this.fyH.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fyI != null) {
            this.fyI.dismiss();
            this.fyI = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fzj != null) {
            com.baidu.adp.lib.g.e.jI().removeCallbacks(this.fzj);
        }
    }

    public void completePullRefresh() {
        if (this.dTo != null) {
            this.dTo.completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
        }
    }

    public boolean isPullRefreshing() {
        return this.fyK;
    }

    public void cm(boolean z) {
        this.fyK = z;
    }

    public void gb(boolean z) {
        BdListViewHelper.a(this.dxR, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
