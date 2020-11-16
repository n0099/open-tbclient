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
/* loaded from: classes23.dex */
public class e {
    BaseFragmentActivity fTc;
    private View iFg;
    private RelativeLayout jVZ;
    public BdListView jhk;
    public NavigationBarShadowView kuN;
    private d laO;
    private a laR;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a laP = null;
    a.b laQ = null;
    private boolean laS = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.kuN != null && i == 1) {
                e.this.kuN.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.kuN != null && childAt != null && childAt.getTop() == 0) {
                    e.this.kuN.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.fTc = null;
        this.jhk = null;
        this.iFg = null;
        this.mNoDataView = null;
        this.laO = null;
        this.jVZ = null;
        this.mProgressBar = null;
        this.fTc = threadFragment.getBaseFragmentActivity();
        this.kuN = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.jVZ = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fTc.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.fTc.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aY(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.laO = new d(threadFragment.getPageContext());
        this.laO.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.jhk = (BdListView) view.findViewById(R.id.list);
        this.jhk.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.iFg = new TextView(this.fTc.getActivity());
        this.iFg.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fTc.getActivity(), R.dimen.ds88)));
        this.jhk.addHeaderView(this.iFg, 0);
        this.jhk.setAdapter((ListAdapter) this.laO);
        this.jhk.setOnSrollToBottomListener(threadFragment);
        this.jhk.setOnItemClickListener(threadFragment);
        this.jhk.setOnScrollListener(this.mOnScrollListener);
        this.laO.M(threadFragment);
        this.laO.N(threadFragment);
        this.laO.O(threadFragment);
    }

    public void d(a.b bVar) {
        this.laQ = bVar;
    }

    public void tv(boolean z) {
        this.laO.lk(z);
        this.laO.notifyDataSetChanged();
    }

    public int tw(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int tx(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int ty(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.jhk.startPullRefresh();
            return;
        }
        this.laO.setRefreshing(true);
        this.laO.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.laO.setRefreshing(true);
        if (str != null) {
            this.fTc.showToast(str);
        }
        if (aVar != null) {
            if (aVar.dex() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.dex() < 20) {
                this.laO.setHasMore(false);
                this.laO.tu(true);
            } else {
                this.laO.setHasMore(true);
                this.laO.tu(true);
            }
            this.laO.setData(aVar.dew());
            a(aVar, z);
        }
        this.laO.setRefreshing(false);
        this.laO.notifyDataSetChanged();
        if (isPullRefreshing()) {
            kt(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.jhk.removeHeaderView(this.mNoDataView);
            this.laO.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.fTc.getPageContext());
        this.jhk.removeHeaderView(this.mNoDataView);
        this.jhk.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void des() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.fTc.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.fTc.closeLoadingDialog();
        if (str != null) {
            this.fTc.showToast(str);
        }
        if (z2) {
            det();
        }
        this.laO.notifyDataSetChanged();
    }

    public void ctU() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes23.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a laU;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.laU = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.laU != null) {
                this.laU.p(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fTc.showToast(this.fTc.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.dew() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.laO.setData(aVar.dew());
            if (aVar.dew().size() == 0) {
                if (this.laR == null) {
                    this.laR = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.laR);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.laR, 600L);
            }
        } else {
            this.fTc.showToast(str);
        }
        this.laO.tu(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.fTc.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aW(ArrayList<MarkData> arrayList) {
        this.laO.setData(arrayList);
    }

    private void det() {
        if (this.laP == null) {
            this.laP = new com.baidu.tbadk.core.dialog.a(this.fTc.getPageContext().getPageActivity());
            this.laP.AI(this.fTc.getPageContext().getString(R.string.sync_mark_fail));
            this.laP.AJ(this.fTc.getPageContext().getString(R.string.neterror));
            if (this.laQ != null) {
                this.laP.a(this.fTc.getPageContext().getString(R.string.retry_rightnow), this.laQ);
            }
            this.laP.b(this.fTc.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.laP.b(this.fTc.getPageContext());
            this.laP.iX(true);
        }
        this.laP.bog();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jVZ, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        deu();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fTc.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
    }

    public void deu() {
        this.laO.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.laP != null) {
            this.laP.dismiss();
            this.laP = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.laR != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.laR);
        }
    }

    public void completePullRefresh() {
        if (this.jhk != null) {
            this.jhk.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.laS;
    }

    public void kt(boolean z) {
        this.laS = z;
    }

    public void po(boolean z) {
        BdListViewHelper.a(this.iFg, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
