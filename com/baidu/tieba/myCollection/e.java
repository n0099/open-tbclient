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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class e {
    BaseFragmentActivity dWk;
    public BdListView gDn;
    private View ggr;
    public NavigationBarShadowView hIX;
    private RelativeLayout hmv;
    private d inq;
    private a inu;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;
    private com.baidu.tbadk.core.dialog.a inr = null;

    /* renamed from: int  reason: not valid java name */
    a.b f7int = null;
    private boolean inv = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.hIX != null && i == 1) {
                e.this.hIX.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.hIX != null && childAt != null && childAt.getTop() == 0) {
                    e.this.hIX.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.dWk = null;
        this.gDn = null;
        this.ggr = null;
        this.mNoDataView = null;
        this.inq = null;
        this.hmv = null;
        this.mProgressBar = null;
        this.dWk = threadFragment.getBaseFragmentActivity();
        this.hIX = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.hmv = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.dWk.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.dWk.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aB(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.inq = new d(threadFragment.getPageContext());
        this.inq.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.gDn = (BdListView) view.findViewById(R.id.list);
        this.gDn.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.ggr = new TextView(this.dWk.getActivity());
        this.ggr.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.dWk.getActivity(), R.dimen.ds88)));
        this.gDn.addHeaderView(this.ggr, 0);
        this.gDn.setAdapter((ListAdapter) this.inq);
        this.gDn.setOnSrollToBottomListener(threadFragment);
        this.gDn.setOnItemClickListener(threadFragment);
        this.gDn.setOnScrollListener(this.mOnScrollListener);
        this.inq.J(threadFragment);
        this.inq.K(threadFragment);
        this.inq.L(threadFragment);
    }

    public void d(a.b bVar) {
        this.f7int = bVar;
    }

    public void oK(boolean z) {
        this.inq.hq(z);
        this.inq.notifyDataSetChanged();
    }

    public int oL(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int oM(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int oN(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.gDn.startPullRefresh();
            return;
        }
        this.inq.setRefreshing(true);
        this.inq.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.inq.setRefreshing(true);
        if (str != null) {
            this.dWk.showToast(str);
        }
        if (aVar != null) {
            if (aVar.ceY() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.ceY() < 20) {
                this.inq.setHasMore(false);
                this.inq.oJ(true);
            } else {
                this.inq.setHasMore(true);
                this.inq.oJ(true);
            }
            this.inq.setData(aVar.ceX());
            a(aVar, z);
        }
        this.inq.setRefreshing(false);
        this.inq.notifyDataSetChanged();
        if (isPullRefreshing()) {
            gC(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.gDn.removeHeaderView(this.mNoDataView);
            this.inq.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.dWk.getPageContext());
        this.gDn.removeHeaderView(this.mNoDataView);
        this.gDn.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void ceT() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.dWk.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.dWk.closeLoadingDialog();
        if (str != null) {
            this.dWk.showToast(str);
        }
        if (z2) {
            ceU();
        }
        this.inq.notifyDataSetChanged();
    }

    public void bxB() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes8.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a inx;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.inx = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.inx != null) {
                this.inx.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.dWk.showToast(this.dWk.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.ceX() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.inq.setData(aVar.ceX());
            if (aVar.ceX().size() == 0) {
                if (this.inu == null) {
                    this.inu = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.gy().removeCallbacks(this.inu);
                }
                com.baidu.adp.lib.f.e.gy().postDelayed(this.inu, 600L);
            }
        } else {
            this.dWk.showToast(str);
        }
        this.inq.oJ(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.dWk.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aG(ArrayList<MarkData> arrayList) {
        this.inq.setData(arrayList);
    }

    private void ceU() {
        if (this.inr == null) {
            this.inr = new com.baidu.tbadk.core.dialog.a(this.dWk.getPageContext().getPageActivity());
            this.inr.sy(this.dWk.getPageContext().getString(R.string.sync_mark_fail));
            this.inr.sz(this.dWk.getPageContext().getString(R.string.neterror));
            if (this.f7int != null) {
                this.inr.a(this.dWk.getPageContext().getString(R.string.retry_rightnow), this.f7int);
            }
            this.inr.b(this.dWk.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.inr.b(this.dWk.getPageContext());
            this.inr.fv(true);
        }
        this.inr.aBW();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hmv, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        ceV();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dWk.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void ceV() {
        this.inq.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.inr != null) {
            this.inr.dismiss();
            this.inr = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.inu != null) {
            com.baidu.adp.lib.f.e.gy().removeCallbacks(this.inu);
        }
    }

    public void completePullRefresh() {
        if (this.gDn != null) {
            this.gDn.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.inv;
    }

    public void gC(boolean z) {
        this.inv = z;
    }

    public void kJ(boolean z) {
        BdListViewHelper.a(this.ggr, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
