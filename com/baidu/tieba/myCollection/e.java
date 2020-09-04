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
/* loaded from: classes18.dex */
public class e {
    BaseFragmentActivity fpN;
    private View hPY;
    public BdListView irX;
    public NavigationBarShadowView jEi;
    private RelativeLayout jfq;
    private d kkq;
    private a kkt;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a kkr = null;
    a.b kks = null;
    private boolean kku = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.jEi != null && i == 1) {
                e.this.jEi.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.jEi != null && childAt != null && childAt.getTop() == 0) {
                    e.this.jEi.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.fpN = null;
        this.irX = null;
        this.hPY = null;
        this.mNoDataView = null;
        this.kkq = null;
        this.jfq = null;
        this.mProgressBar = null;
        this.fpN = threadFragment.getBaseFragmentActivity();
        this.jEi = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.jfq = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fpN.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.fpN.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aY(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.kkq = new d(threadFragment.getPageContext());
        this.kkq.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.irX = (BdListView) view.findViewById(R.id.list);
        this.irX.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.hPY = new TextView(this.fpN.getActivity());
        this.hPY.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fpN.getActivity(), R.dimen.ds88)));
        this.irX.addHeaderView(this.hPY, 0);
        this.irX.setAdapter((ListAdapter) this.kkq);
        this.irX.setOnSrollToBottomListener(threadFragment);
        this.irX.setOnItemClickListener(threadFragment);
        this.irX.setOnScrollListener(this.mOnScrollListener);
        this.kkq.M(threadFragment);
        this.kkq.N(threadFragment);
        this.kkq.O(threadFragment);
    }

    public void d(a.b bVar) {
        this.kks = bVar;
    }

    public void sd(boolean z) {
        this.kkq.ko(z);
        this.kkq.notifyDataSetChanged();
    }

    public int se(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int sf(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int sg(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.irX.startPullRefresh();
            return;
        }
        this.kkq.setRefreshing(true);
        this.kkq.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.kkq.setRefreshing(true);
        if (str != null) {
            this.fpN.showToast(str);
        }
        if (aVar != null) {
            if (aVar.cSc() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.cSc() < 20) {
                this.kkq.setHasMore(false);
                this.kkq.sc(true);
            } else {
                this.kkq.setHasMore(true);
                this.kkq.sc(true);
            }
            this.kkq.setData(aVar.cSb());
            a(aVar, z);
        }
        this.kkq.setRefreshing(false);
        this.kkq.notifyDataSetChanged();
        if (isPullRefreshing()) {
            jx(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.irX.removeHeaderView(this.mNoDataView);
            this.kkq.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.fpN.getPageContext());
        this.irX.removeHeaderView(this.mNoDataView);
        this.irX.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void cRX() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.fpN.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.fpN.closeLoadingDialog();
        if (str != null) {
            this.fpN.showToast(str);
        }
        if (z2) {
            cRY();
        }
        this.kkq.notifyDataSetChanged();
    }

    public void chY() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes18.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a kkw;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.kkw = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.kkw != null) {
                this.kkw.n(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fpN.showToast(this.fpN.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.cSb() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.kkq.setData(aVar.cSb());
            if (aVar.cSb().size() == 0) {
                if (this.kkt == null) {
                    this.kkt = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kkt);
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(this.kkt, 600L);
            }
        } else {
            this.fpN.showToast(str);
        }
        this.kkq.sc(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.fpN.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aQ(ArrayList<MarkData> arrayList) {
        this.kkq.setData(arrayList);
    }

    private void cRY() {
        if (this.kkr == null) {
            this.kkr = new com.baidu.tbadk.core.dialog.a(this.fpN.getPageContext().getPageActivity());
            this.kkr.zz(this.fpN.getPageContext().getString(R.string.sync_mark_fail));
            this.kkr.zA(this.fpN.getPageContext().getString(R.string.neterror));
            if (this.kks != null) {
                this.kkr.a(this.fpN.getPageContext().getString(R.string.retry_rightnow), this.kks);
            }
            this.kkr.b(this.fpN.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kkr.b(this.fpN.getPageContext());
            this.kkr.ih(true);
        }
        this.kkr.bhg();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jfq, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        cRZ();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fpN.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void cRZ() {
        this.kkq.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.kkr != null) {
            this.kkr.dismiss();
            this.kkr = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.kkt != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kkt);
        }
    }

    public void completePullRefresh() {
        if (this.irX != null) {
            this.irX.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.kku;
    }

    public void jx(boolean z) {
        this.kku = z;
    }

    public void nZ(boolean z) {
        BdListViewHelper.a(this.hPY, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
