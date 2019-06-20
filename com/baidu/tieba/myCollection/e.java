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
    BaseFragmentActivity cWF;
    public BdListView fIW;
    private View fmo;
    private d hsv;
    private a hsy;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private i mPullView;
    private com.baidu.tbadk.core.dialog.a hsw = null;
    a.b hsx = null;
    private boolean hsz = false;

    public e(ThreadFragment threadFragment, View view) {
        this.cWF = null;
        this.fIW = null;
        this.fmo = null;
        this.mNoDataView = null;
        this.hsv = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.cWF = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.mParent = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.cWF.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.cWF.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ad(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.hsv = new d(threadFragment.getPageContext());
        this.hsv.notifyDataSetChanged();
        this.mPullView = new i(threadFragment.getPageContext());
        this.fIW = (BdListView) view.findViewById(R.id.list);
        this.fIW.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.fmo = new TextView(this.cWF.getActivity());
        this.fmo.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(this.cWF.getActivity(), R.dimen.ds88)));
        this.fIW.addHeaderView(this.fmo, 0);
        this.fIW.setAdapter((ListAdapter) this.hsv);
        this.fIW.setOnSrollToBottomListener(threadFragment);
        this.fIW.setOnItemClickListener(threadFragment);
        this.hsv.F(threadFragment);
        this.hsv.G(threadFragment);
        this.hsv.H(threadFragment);
    }

    public void d(a.b bVar) {
        this.hsx = bVar;
    }

    public void ns(boolean z) {
        this.hsv.gg(z);
        this.hsv.notifyDataSetChanged();
    }

    public int nt(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int nu(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int nv(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.fIW.startPullRefresh();
            return;
        }
        this.hsv.setRefreshing(true);
        this.hsv.notifyDataSetChanged();
    }

    public void boN() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.hsv.setRefreshing(true);
        if (str != null) {
            this.cWF.showToast(str);
        }
        if (aVar != null) {
            if (aVar.bNf() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.bNf() < 20) {
                this.hsv.setHasMore(false);
                this.hsv.nr(true);
            } else {
                this.hsv.setHasMore(true);
                this.hsv.nr(true);
            }
            this.hsv.setData(aVar.bNe());
            a(aVar, z);
        }
        this.hsv.setRefreshing(false);
        this.hsv.notifyDataSetChanged();
        if (isPullRefreshing()) {
            ft(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.fIW.removeHeaderView(this.mNoDataView);
            this.hsv.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.cWF.getPageContext());
        this.fIW.removeHeaderView(this.mNoDataView);
        this.fIW.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void bNa() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.cWF.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.cWF.closeLoadingDialog();
        if (str != null) {
            this.cWF.showToast(str);
        }
        if (z2) {
            bNb();
        }
        this.hsv.notifyDataSetChanged();
    }

    public void bfv() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes6.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a hsB;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.hsB = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hsB != null) {
                this.hsB.g(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.cWF.showToast(this.cWF.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.bNe() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.hsv.setData(aVar.bNe());
            if (aVar.bNe().size() == 0) {
                if (this.hsy == null) {
                    this.hsy = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hsy);
                }
                com.baidu.adp.lib.g.e.iB().postDelayed(this.hsy, 600L);
            }
        } else {
            this.cWF.showToast(str);
        }
        this.hsv.nr(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.cWF.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ar(ArrayList<MarkData> arrayList) {
        this.hsv.setData(arrayList);
    }

    private void bNb() {
        if (this.hsw == null) {
            this.hsw = new com.baidu.tbadk.core.dialog.a(this.cWF.getPageContext().getPageActivity());
            this.hsw.mC(this.cWF.getPageContext().getString(R.string.sync_mark_fail));
            this.hsw.mD(this.cWF.getPageContext().getString(R.string.neterror));
            if (this.hsx != null) {
                this.hsw.a(this.cWF.getPageContext().getString(R.string.retry_rightnow), this.hsx);
            }
            this.hsw.b(this.cWF.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hsw.b(this.cWF.getPageContext());
            this.hsw.dN(true);
        }
        this.hsw.afG();
    }

    public void onChangeSkinType(int i) {
        al.l(this.mParent, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        bNc();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.cWF.getPageContext(), i);
            al.l(this.mNoDataView, R.color.common_color_10076);
        }
    }

    public void bNc() {
        this.hsv.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.hsw != null) {
            this.hsw.dismiss();
            this.hsw = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.hsy != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.hsy);
        }
    }

    public void completePullRefresh() {
        if (this.fIW != null) {
            this.fIW.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.hsz;
    }

    public void ft(boolean z) {
        this.hsz = z;
    }

    public void jw(boolean z) {
        BdListViewHelper.a(this.fmo, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
