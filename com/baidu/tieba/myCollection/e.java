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
    BaseFragmentActivity cWE;
    public BdListView fIU;
    private View fmo;
    private d hsu;
    private a hsx;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hsv = null;
    a.b hsw = null;
    private boolean hsy = false;

    public e(ThreadFragment threadFragment, View view) {
        this.cWE = null;
        this.fIU = null;
        this.fmo = null;
        this.mNoDataView = null;
        this.hsu = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.cWE = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.mParent = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cWE.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cWE.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ad(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.hsu = new d(threadFragment.getPageContext());
        this.hsu.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fIU = (BdListView) view.findViewById(R.id.list);
        this.fIU.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.fmo = new TextView(this.cWE.getActivity());
        this.fmo.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.cWE.getActivity(), R.dimen.ds88)));
        this.fIU.addHeaderView(this.fmo, 0);
        this.fIU.setAdapter((ListAdapter) this.hsu);
        this.fIU.setOnSrollToBottomListener(threadFragment);
        this.fIU.setOnItemClickListener(threadFragment);
        this.hsu.F(threadFragment);
        this.hsu.G(threadFragment);
        this.hsu.H(threadFragment);
    }

    public void d(a.b bVar) {
        this.hsw = bVar;
    }

    public void nr(boolean z) {
        this.hsu.gg(z);
        this.hsu.notifyDataSetChanged();
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
            this.fIU.startPullRefresh();
            return;
        }
        this.hsu.setRefreshing(true);
        this.hsu.notifyDataSetChanged();
    }

    public void boL() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hsu.setRefreshing(true);
        if (str != null) {
            this.cWE.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bNe() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bNe() < 20) {
                this.hsu.setHasMore(false);
                this.hsu.nq(true);
            } else {
                this.hsu.setHasMore(true);
                this.hsu.nq(true);
            }
            this.hsu.setData(aVar.bNd());
            a(aVar, z);
        }
        this.hsu.setRefreshing(false);
        this.hsu.notifyDataSetChanged();
        if (isPullRefreshing()) {
            ft(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fIU.removeHeaderView(this.mNoDataView);
            this.hsu.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.cWE.getPageContext());
        this.fIU.removeHeaderView(this.mNoDataView);
        this.fIU.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bMZ() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.cWE.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.cWE.closeLoadingDialog();
        if (str != null) {
            this.cWE.showToast(str);
        }
        if (z2) {
            bNa();
        }
        this.hsu.notifyDataSetChanged();
    }

    public void bfv() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hsA;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hsA = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hsA != null) {
                this.hsA.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cWE.showToast(this.cWE.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.bNd() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hsu.setData(aVar.bNd());
            if (aVar.bNd().size() == 0) {
                if (this.hsx == null) {
                    this.hsx = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hsx);
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(this.hsx, 600L);
            }
        } else {
            this.cWE.showToast(str);
        }
        this.hsu.nq(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cWE.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ar(ArrayList<MarkData> arrayList) {
        this.hsu.setData(arrayList);
    }

    private void bNa() {
        if (this.hsv == null) {
            this.hsv = new com.baidu.tbadk.core.dialog.a(this.cWE.getPageContext().getPageActivity());
            this.hsv.mD(this.cWE.getPageContext().getString(R.string.sync_mark_fail));
            this.hsv.mE(this.cWE.getPageContext().getString(R.string.neterror));
            if (this.hsw != null) {
                this.hsv.a(this.cWE.getPageContext().getString(R.string.retry_rightnow), this.hsw);
            }
            this.hsv.b(this.cWE.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hsv.b(this.cWE.getPageContext());
            this.hsv.dN(true);
        }
        this.hsv.afG();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mParent, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        bNb();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cWE.getPageContext(), i);
            al.l(this.mNoDataView, R.color.common_color_10076);
        }
    }

    public void bNb() {
        this.hsu.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hsv != null) {
            this.hsv.dismiss();
            this.hsv = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hsx != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hsx);
        }
    }

    public void completePullRefresh() {
        if (this.fIU != null) {
            this.fIU.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hsy;
    }

    public void ft(boolean z) {
        this.hsy = z;
    }

    public void jw(boolean z) {
        BdListViewHelper.a(this.fmo, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
