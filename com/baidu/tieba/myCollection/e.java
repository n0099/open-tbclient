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
    BaseFragmentActivity gbm;
    private View iPY;
    public BdListView juN;
    public NavigationBarShadowView kIh;
    private RelativeLayout kjE;
    private d lom;
    private a loq;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a loo = null;
    a.b lop = null;
    private boolean lor = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.kIh != null && i == 1) {
                e.this.kIh.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.kIh != null && childAt != null && childAt.getTop() == 0) {
                    e.this.kIh.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.gbm = null;
        this.juN = null;
        this.iPY = null;
        this.mNoDataView = null;
        this.lom = null;
        this.kjE = null;
        this.mProgressBar = null;
        this.gbm = threadFragment.getBaseFragmentActivity();
        this.kIh = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.kjE = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.gbm.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.gbm.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.ba(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.lom = new d(threadFragment.getPageContext());
        this.lom.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.juN = (BdListView) view.findViewById(R.id.list);
        this.juN.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.iPY = new TextView(this.gbm.getActivity());
        this.iPY.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gbm.getActivity(), R.dimen.ds88)));
        this.juN.addHeaderView(this.iPY, 0);
        this.juN.setAdapter((ListAdapter) this.lom);
        this.juN.setOnSrollToBottomListener(threadFragment);
        this.juN.setOnItemClickListener(threadFragment);
        this.juN.setOnScrollListener(this.mOnScrollListener);
        this.lom.M(threadFragment);
        this.lom.N(threadFragment);
        this.lom.O(threadFragment);
    }

    public void d(a.b bVar) {
        this.lop = bVar;
    }

    public void tX(boolean z) {
        this.lom.lF(z);
        this.lom.notifyDataSetChanged();
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
            this.juN.startPullRefresh();
            return;
        }
        this.lom.setRefreshing(true);
        this.lom.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.lom.setRefreshing(true);
        if (str != null) {
            this.gbm.showToast(str);
        }
        if (aVar != null) {
            if (aVar.djJ() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.djJ() < 20) {
                this.lom.setHasMore(false);
                this.lom.tW(true);
            } else {
                this.lom.setHasMore(true);
                this.lom.tW(true);
            }
            this.lom.setData(aVar.djI());
            a(aVar, z);
        }
        this.lom.setRefreshing(false);
        this.lom.notifyDataSetChanged();
        if (isPullRefreshing()) {
            kM(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.juN.removeHeaderView(this.mNoDataView);
            this.lom.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.gbm.getPageContext());
        this.juN.removeHeaderView(this.mNoDataView);
        this.juN.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void djE() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.gbm.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.gbm.closeLoadingDialog();
        if (str != null) {
            this.gbm.showToast(str);
        }
        if (z2) {
            djF();
        }
        this.lom.notifyDataSetChanged();
    }

    public void cyj() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes24.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a lot;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.lot = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.lot != null) {
                this.lot.p(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.gbm.showToast(this.gbm.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.djI() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.lom.setData(aVar.djI());
            if (aVar.djI().size() == 0) {
                if (this.loq == null) {
                    this.loq = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.loq);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.loq, 600L);
            }
        } else {
            this.gbm.showToast(str);
        }
        this.lom.tW(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.gbm.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aY(ArrayList<MarkData> arrayList) {
        this.lom.setData(arrayList);
    }

    private void djF() {
        if (this.loo == null) {
            this.loo = new com.baidu.tbadk.core.dialog.a(this.gbm.getPageContext().getPageActivity());
            this.loo.Bp(this.gbm.getPageContext().getString(R.string.sync_mark_fail));
            this.loo.Bq(this.gbm.getPageContext().getString(R.string.neterror));
            if (this.lop != null) {
                this.loo.a(this.gbm.getPageContext().getString(R.string.retry_rightnow), this.lop);
            }
            this.loo.b(this.gbm.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.loo.b(this.gbm.getPageContext());
            this.loo.jm(true);
        }
        this.loo.brv();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.kjE, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        djG();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gbm.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
    }

    public void djG() {
        this.lom.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.loo != null) {
            this.loo.dismiss();
            this.loo = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.loq != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.loq);
        }
    }

    public void completePullRefresh() {
        if (this.juN != null) {
            this.juN.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.lor;
    }

    public void kM(boolean z) {
        this.lor = z;
    }

    public void pL(boolean z) {
        BdListViewHelper.a(this.iPY, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
