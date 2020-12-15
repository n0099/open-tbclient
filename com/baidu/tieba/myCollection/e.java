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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class e {
    BaseFragmentActivity gbo;
    private View iQa;
    public BdListView juP;
    public NavigationBarShadowView kIj;
    private RelativeLayout kjG;
    private d lop;
    private a los;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a loq = null;
    a.b lor = null;
    private boolean lot = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.kIj != null && i == 1) {
                e.this.kIj.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.kIj != null && childAt != null && childAt.getTop() == 0) {
                    e.this.kIj.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.gbo = null;
        this.juP = null;
        this.iQa = null;
        this.mNoDataView = null;
        this.lop = null;
        this.kjG = null;
        this.mProgressBar = null;
        this.gbo = threadFragment.getBaseFragmentActivity();
        this.kIj = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.kjG = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.gbo.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.gbo.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ba(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.lop = new d(threadFragment.getPageContext());
        this.lop.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.juP = (BdListView) view.findViewById(R.id.list);
        this.juP.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.iQa = new TextView(this.gbo.getActivity());
        this.iQa.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gbo.getActivity(), R.dimen.ds88)));
        this.juP.addHeaderView(this.iQa, 0);
        this.juP.setAdapter((ListAdapter) this.lop);
        this.juP.setOnSrollToBottomListener(threadFragment);
        this.juP.setOnItemClickListener(threadFragment);
        this.juP.setOnScrollListener(this.mOnScrollListener);
        this.lop.M(threadFragment);
        this.lop.N(threadFragment);
        this.lop.O(threadFragment);
    }

    public void d(a.b bVar) {
        this.lor = bVar;
    }

    public void tX(boolean z) {
        this.lop.lF(z);
        this.lop.notifyDataSetChanged();
    }

    public int tY(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int tZ(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int ua(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.juP.startPullRefresh();
            return;
        }
        this.lop.setRefreshing(true);
        this.lop.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.lop.setRefreshing(true);
        if (str != null) {
            this.gbo.showToast(str);
        }
        if (aVar != null) {
            if (aVar.djK() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.djK() < 20) {
                this.lop.setHasMore(false);
                this.lop.tW(true);
            } else {
                this.lop.setHasMore(true);
                this.lop.tW(true);
            }
            this.lop.setData(aVar.djJ());
            a(aVar, z);
        }
        this.lop.setRefreshing(false);
        this.lop.notifyDataSetChanged();
        if (isPullRefreshing()) {
            kM(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.juP.removeHeaderView(this.mNoDataView);
            this.lop.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.gbo.getPageContext());
        this.juP.removeHeaderView(this.mNoDataView);
        this.juP.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void djF() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.gbo.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.gbo.closeLoadingDialog();
        if (str != null) {
            this.gbo.showToast(str);
        }
        if (z2) {
            djG();
        }
        this.lop.notifyDataSetChanged();
    }

    public void cyk() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes24.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a lov;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.lov = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.lov != null) {
                this.lov.p(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.gbo.showToast(this.gbo.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.djJ() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.lop.setData(aVar.djJ());
            if (aVar.djJ().size() == 0) {
                if (this.los == null) {
                    this.los = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.los);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.los, 600L);
            }
        } else {
            this.gbo.showToast(str);
        }
        this.lop.tW(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.gbo.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aY(ArrayList<MarkData> arrayList) {
        this.lop.setData(arrayList);
    }

    private void djG() {
        if (this.loq == null) {
            this.loq = new com.baidu.tbadk.core.dialog.a(this.gbo.getPageContext().getPageActivity());
            this.loq.Bp(this.gbo.getPageContext().getString(R.string.sync_mark_fail));
            this.loq.Bq(this.gbo.getPageContext().getString(R.string.neterror));
            if (this.lor != null) {
                this.loq.a(this.gbo.getPageContext().getString(R.string.retry_rightnow), this.lor);
            }
            this.loq.b(this.gbo.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.loq.b(this.gbo.getPageContext());
            this.loq.jm(true);
        }
        this.loq.brv();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.kjG, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        djH();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gbo.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
    }

    public void djH() {
        this.lop.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.loq != null) {
            this.loq.dismiss();
            this.loq = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.los != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.los);
        }
    }

    public void completePullRefresh() {
        if (this.juP != null) {
            this.juP.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.lot;
    }

    public void kM(boolean z) {
        this.lot = z;
    }

    public void pL(boolean z) {
        BdListViewHelper.a(this.iQa, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
