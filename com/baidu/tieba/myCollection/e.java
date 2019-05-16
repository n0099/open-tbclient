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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class e {
    BaseFragmentActivity cWD;
    public BdListView fIT;
    private View fmn;
    private d hsr;
    private a hsu;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hss = null;
    a.b hst = null;
    private boolean hsv = false;

    public e(ThreadFragment threadFragment, View view) {
        this.cWD = null;
        this.fIT = null;
        this.fmn = null;
        this.mNoDataView = null;
        this.hsr = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.cWD = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.mParent = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cWD.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cWD.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ad(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.hsr = new d(threadFragment.getPageContext());
        this.hsr.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fIT = (BdListView) view.findViewById(R.id.list);
        this.fIT.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.fmn = new TextView(this.cWD.getActivity());
        this.fmn.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.cWD.getActivity(), R.dimen.ds88)));
        this.fIT.addHeaderView(this.fmn, 0);
        this.fIT.setAdapter((ListAdapter) this.hsr);
        this.fIT.setOnSrollToBottomListener(threadFragment);
        this.fIT.setOnItemClickListener(threadFragment);
        this.hsr.F(threadFragment);
        this.hsr.G(threadFragment);
        this.hsr.H(threadFragment);
    }

    public void d(a.b bVar) {
        this.hst = bVar;
    }

    public void nr(boolean z) {
        this.hsr.gg(z);
        this.hsr.notifyDataSetChanged();
    }

    public int ns(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int nt(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int nu(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.fIT.startPullRefresh();
            return;
        }
        this.hsr.setRefreshing(true);
        this.hsr.notifyDataSetChanged();
    }

    public void boI() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hsr.setRefreshing(true);
        if (str != null) {
            this.cWD.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bNb() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bNb() < 20) {
                this.hsr.setHasMore(false);
                this.hsr.nq(true);
            } else {
                this.hsr.setHasMore(true);
                this.hsr.nq(true);
            }
            this.hsr.setData(aVar.bNa());
            a(aVar, z);
        }
        this.hsr.setRefreshing(false);
        this.hsr.notifyDataSetChanged();
        if (isPullRefreshing()) {
            ft(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fIT.removeHeaderView(this.mNoDataView);
            this.hsr.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.cWD.getPageContext());
        this.fIT.removeHeaderView(this.mNoDataView);
        this.fIT.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bMW() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.cWD.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.cWD.closeLoadingDialog();
        if (str != null) {
            this.cWD.showToast(str);
        }
        if (z2) {
            bMX();
        }
        this.hsr.notifyDataSetChanged();
    }

    public void bfs() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hsx;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hsx = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hsx != null) {
                this.hsx.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cWD.showToast(this.cWD.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.bNa() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hsr.setData(aVar.bNa());
            if (aVar.bNa().size() == 0) {
                if (this.hsu == null) {
                    this.hsu = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hsu);
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(this.hsu, 600L);
            }
        } else {
            this.cWD.showToast(str);
        }
        this.hsr.nq(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cWD.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ar(ArrayList<MarkData> arrayList) {
        this.hsr.setData(arrayList);
    }

    private void bMX() {
        if (this.hss == null) {
            this.hss = new com.baidu.tbadk.core.dialog.a(this.cWD.getPageContext().getPageActivity());
            this.hss.mD(this.cWD.getPageContext().getString(R.string.sync_mark_fail));
            this.hss.mE(this.cWD.getPageContext().getString(R.string.neterror));
            if (this.hst != null) {
                this.hss.a(this.cWD.getPageContext().getString(R.string.retry_rightnow), this.hst);
            }
            this.hss.b(this.cWD.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hss.b(this.cWD.getPageContext());
            this.hss.dN(true);
        }
        this.hss.afG();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mParent, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        bMY();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cWD.getPageContext(), i);
            al.l(this.mNoDataView, R.color.common_color_10076);
        }
    }

    public void bMY() {
        this.hsr.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hss != null) {
            this.hss.dismiss();
            this.hss = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hsu != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hsu);
        }
    }

    public void completePullRefresh() {
        if (this.fIT != null) {
            this.fIT.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hsv;
    }

    public void ft(boolean z) {
        this.hsv = z;
    }

    public void jw(boolean z) {
        BdListViewHelper.a(this.fmn, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
