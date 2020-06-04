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
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    BaseFragmentActivity ePD;
    public BdListView hKx;
    private View hkI;
    public NavigationBarShadowView iPD;
    private RelativeLayout ita;
    private d juW;
    private a juZ;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a juX = null;
    a.b juY = null;
    private boolean jva = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.iPD != null && i == 1) {
                e.this.iPD.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.iPD != null && childAt != null && childAt.getTop() == 0) {
                    e.this.iPD.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.ePD = null;
        this.hKx = null;
        this.hkI = null;
        this.mNoDataView = null;
        this.juW = null;
        this.ita = null;
        this.mProgressBar = null;
        this.ePD = threadFragment.getBaseFragmentActivity();
        this.iPD = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.ita = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.ePD.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.ePD.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aM(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.juW = new d(threadFragment.getPageContext());
        this.juW.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.hKx = (BdListView) view.findViewById(R.id.list);
        this.hKx.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.hkI = new TextView(this.ePD.getActivity());
        this.hkI.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ePD.getActivity(), R.dimen.ds88)));
        this.hKx.addHeaderView(this.hkI, 0);
        this.hKx.setAdapter((ListAdapter) this.juW);
        this.hKx.setOnSrollToBottomListener(threadFragment);
        this.hKx.setOnItemClickListener(threadFragment);
        this.hKx.setOnScrollListener(this.mOnScrollListener);
        this.juW.K(threadFragment);
        this.juW.L(threadFragment);
        this.juW.M(threadFragment);
    }

    public void d(a.b bVar) {
        this.juY = bVar;
    }

    public void qG(boolean z) {
        this.juW.iY(z);
        this.juW.notifyDataSetChanged();
    }

    public int qH(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int qI(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int qJ(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.hKx.startPullRefresh();
            return;
        }
        this.juW.setRefreshing(true);
        this.juW.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.juW.setRefreshing(true);
        if (str != null) {
            this.ePD.showToast(str);
        }
        if (aVar != null) {
            if (aVar.czG() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.czG() < 20) {
                this.juW.setHasMore(false);
                this.juW.qF(true);
            } else {
                this.juW.setHasMore(true);
                this.juW.qF(true);
            }
            this.juW.setData(aVar.czF());
            a(aVar, z);
        }
        this.juW.setRefreshing(false);
        this.juW.notifyDataSetChanged();
        if (isPullRefreshing()) {
            ij(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.hKx.removeHeaderView(this.mNoDataView);
            this.juW.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.ePD.getPageContext());
        this.hKx.removeHeaderView(this.mNoDataView);
        this.hKx.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void czB() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.ePD.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.ePD.closeLoadingDialog();
        if (str != null) {
            this.ePD.showToast(str);
        }
        if (z2) {
            czC();
        }
        this.juW.notifyDataSetChanged();
    }

    public void bRl() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a jvc;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.jvc = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jvc != null) {
                this.jvc.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.ePD.showToast(this.ePD.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.czF() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.juW.setData(aVar.czF());
            if (aVar.czF().size() == 0) {
                if (this.juZ == null) {
                    this.juZ = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(this.juZ);
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(this.juZ, 600L);
            }
        } else {
            this.ePD.showToast(str);
        }
        this.juW.qF(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.ePD.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aI(ArrayList<MarkData> arrayList) {
        this.juW.setData(arrayList);
    }

    private void czC() {
        if (this.juX == null) {
            this.juX = new com.baidu.tbadk.core.dialog.a(this.ePD.getPageContext().getPageActivity());
            this.juX.vN(this.ePD.getPageContext().getString(R.string.sync_mark_fail));
            this.juX.vO(this.ePD.getPageContext().getString(R.string.neterror));
            if (this.juY != null) {
                this.juX.a(this.ePD.getPageContext().getString(R.string.retry_rightnow), this.juY);
            }
            this.juX.b(this.ePD.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.juX.b(this.ePD.getPageContext());
            this.juX.gX(true);
        }
        this.juX.aST();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.ita, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        czD();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ePD.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void czD() {
        this.juW.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.juX != null) {
            this.juX.dismiss();
            this.juX = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.juZ != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.juZ);
        }
    }

    public void completePullRefresh() {
        if (this.hKx != null) {
            this.hKx.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.jva;
    }

    public void ij(boolean z) {
        this.jva = z;
    }

    public void mD(boolean z) {
        BdListViewHelper.a(this.hkI, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
