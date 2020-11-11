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
    BaseFragmentActivity fTv;
    private View iEs;
    private RelativeLayout jVp;
    public BdListView jgz;
    public NavigationBarShadowView kud;
    private d lav;
    private a lay;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a law = null;
    a.b lax = null;
    private boolean laz = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.kud != null && i == 1) {
                e.this.kud.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.kud != null && childAt != null && childAt.getTop() == 0) {
                    e.this.kud.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.fTv = null;
        this.jgz = null;
        this.iEs = null;
        this.mNoDataView = null;
        this.lav = null;
        this.jVp = null;
        this.mProgressBar = null;
        this.fTv = threadFragment.getBaseFragmentActivity();
        this.kud = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.jVp = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fTv.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.fTv.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aY(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.lav = new d(threadFragment.getPageContext());
        this.lav.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.jgz = (BdListView) view.findViewById(R.id.list);
        this.jgz.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.iEs = new TextView(this.fTv.getActivity());
        this.iEs.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fTv.getActivity(), R.dimen.ds88)));
        this.jgz.addHeaderView(this.iEs, 0);
        this.jgz.setAdapter((ListAdapter) this.lav);
        this.jgz.setOnSrollToBottomListener(threadFragment);
        this.jgz.setOnItemClickListener(threadFragment);
        this.jgz.setOnScrollListener(this.mOnScrollListener);
        this.lav.N(threadFragment);
        this.lav.O(threadFragment);
        this.lav.P(threadFragment);
    }

    public void d(a.b bVar) {
        this.lax = bVar;
    }

    public void ts(boolean z) {
        this.lav.lj(z);
        this.lav.notifyDataSetChanged();
    }

    public int tt(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int tu(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int tv(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.jgz.startPullRefresh();
            return;
        }
        this.lav.setRefreshing(true);
        this.lav.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.lav.setRefreshing(true);
        if (str != null) {
            this.fTv.showToast(str);
        }
        if (aVar != null) {
            if (aVar.dfa() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.dfa() < 20) {
                this.lav.setHasMore(false);
                this.lav.tr(true);
            } else {
                this.lav.setHasMore(true);
                this.lav.tr(true);
            }
            this.lav.setData(aVar.deZ());
            a(aVar, z);
        }
        this.lav.setRefreshing(false);
        this.lav.notifyDataSetChanged();
        if (isPullRefreshing()) {
            ks(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.jgz.removeHeaderView(this.mNoDataView);
            this.lav.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.fTv.getPageContext());
        this.jgz.removeHeaderView(this.mNoDataView);
        this.jgz.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void deV() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.fTv.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.fTv.closeLoadingDialog();
        if (str != null) {
            this.fTv.showToast(str);
        }
        if (z2) {
            deW();
        }
        this.lav.notifyDataSetChanged();
    }

    public void cur() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes24.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a laB;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.laB = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.laB != null) {
                this.laB.p(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fTv.showToast(this.fTv.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.deZ() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.lav.setData(aVar.deZ());
            if (aVar.deZ().size() == 0) {
                if (this.lay == null) {
                    this.lay = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lay);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.lay, 600L);
            }
        } else {
            this.fTv.showToast(str);
        }
        this.lav.tr(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.fTv.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aV(ArrayList<MarkData> arrayList) {
        this.lav.setData(arrayList);
    }

    private void deW() {
        if (this.law == null) {
            this.law = new com.baidu.tbadk.core.dialog.a(this.fTv.getPageContext().getPageActivity());
            this.law.Bn(this.fTv.getPageContext().getString(R.string.sync_mark_fail));
            this.law.Bo(this.fTv.getPageContext().getString(R.string.neterror));
            if (this.lax != null) {
                this.law.a(this.fTv.getPageContext().getString(R.string.retry_rightnow), this.lax);
            }
            this.law.b(this.fTv.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.law.b(this.fTv.getPageContext());
            this.law.iW(true);
        }
        this.law.bpc();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jVp, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        deX();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fTv.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void deX() {
        this.lav.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.law != null) {
            this.law.dismiss();
            this.law = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.lay != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.lay);
        }
    }

    public void completePullRefresh() {
        if (this.jgz != null) {
            this.jgz.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.laz;
    }

    public void ks(boolean z) {
        this.laz = z;
    }

    public void pl(boolean z) {
        BdListViewHelper.a(this.iEs, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
