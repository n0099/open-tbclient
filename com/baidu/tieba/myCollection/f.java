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
/* loaded from: classes8.dex */
public class f {
    BaseFragmentActivity giB;
    public BdListView jIw;
    private View jdA;
    public NavigationBarShadowView kRe;
    private e lxq;
    private RelativeLayout lxr;
    private a lxu;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a lxs = null;
    a.b lxt = null;
    private boolean lxv = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.f.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.kRe != null && i == 1) {
                f.this.kRe.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (f.this.kRe != null && childAt != null && childAt.getTop() == 0) {
                    f.this.kRe.hide();
                }
            }
        }
    };

    public f(ThreadFragment threadFragment, View view) {
        this.giB = null;
        this.jIw = null;
        this.jdA = null;
        this.mNoDataView = null;
        this.lxq = null;
        this.lxr = null;
        this.mProgressBar = null;
        this.giB = threadFragment.getBaseFragmentActivity();
        this.kRe = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.lxr = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.giB.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.giB.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aV(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.lxq = new e(threadFragment.getPageContext());
        this.lxq.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.jIw = (BdListView) view.findViewById(R.id.list);
        this.jIw.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.jdA = new TextView(this.giB.getActivity());
        this.jdA.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.giB.getActivity(), R.dimen.ds88)));
        this.jIw.addHeaderView(this.jdA, 0);
        this.jIw.setAdapter((ListAdapter) this.lxq);
        this.jIw.setOnSrollToBottomListener(threadFragment);
        this.jIw.setOnItemClickListener(threadFragment);
        this.jIw.setOnScrollListener(this.mOnScrollListener);
        this.lxq.O(threadFragment);
        this.lxq.P(threadFragment);
        this.lxq.Q(threadFragment);
    }

    public void b(a.b bVar) {
        this.lxt = bVar;
    }

    public void uh(boolean z) {
        this.lxq.mc(z);
        this.lxq.notifyDataSetChanged();
    }

    public int ui(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int uj(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int uk(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.jIw.startPullRefresh();
            return;
        }
        this.lxq.setRefreshing(true);
        this.lxq.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.lxq.setRefreshing(true);
        if (str != null) {
            this.giB.showToast(str);
        }
        if (aVar != null) {
            if (aVar.dhP() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.dhP() < 20) {
                this.lxq.setHasMore(false);
                this.lxq.ug(true);
            } else {
                this.lxq.setHasMore(true);
                this.lxq.ug(true);
            }
            this.lxq.setData(aVar.dhO());
            a(aVar, z);
        }
        this.lxq.setRefreshing(false);
        this.lxq.notifyDataSetChanged();
        if (isPullRefreshing()) {
            lh(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.jIw.removeHeaderView(this.mNoDataView);
            this.lxq.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.giB.getPageContext());
        this.jIw.removeHeaderView(this.mNoDataView);
        this.jIw.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void dhK() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.giB.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.giB.closeLoadingDialog();
        if (str != null) {
            this.giB.showToast(str);
        }
        if (z2) {
            dhL();
        }
        this.lxq.notifyDataSetChanged();
    }

    public void cyE() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes8.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a lxx;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.lxx = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.lxx != null) {
                this.lxx.p(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.giB.showToast(this.giB.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.dhO() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.lxq.setData(aVar.dhO());
            if (aVar.dhO().size() == 0) {
                if (this.lxu == null) {
                    this.lxu = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lxu);
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(this.lxu, 600L);
            }
        } else {
            this.giB.showToast(str);
        }
        this.lxq.ug(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.giB.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aS(ArrayList<MarkData> arrayList) {
        this.lxq.setData(arrayList);
    }

    private void dhL() {
        if (this.lxs == null) {
            this.lxs = new com.baidu.tbadk.core.dialog.a(this.giB.getPageContext().getPageActivity());
            this.lxs.At(this.giB.getPageContext().getString(R.string.sync_mark_fail));
            this.lxs.Au(this.giB.getPageContext().getString(R.string.neterror));
            if (this.lxt != null) {
                this.lxs.a(this.giB.getPageContext().getString(R.string.retry_rightnow), this.lxt);
            }
            this.lxs.b(this.giB.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lxs.b(this.giB.getPageContext());
            this.lxs.jG(true);
        }
        this.lxs.bqx();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.lxr, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        dhM();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.giB.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
    }

    public void dhM() {
        this.lxq.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.lxs != null) {
            this.lxs.dismiss();
            this.lxs = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.lxu != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lxu);
        }
        if (this.lxq != null) {
            this.lxq.onDestroy();
        }
    }

    public void completePullRefresh() {
        if (this.jIw != null) {
            this.jIw.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.lxv;
    }

    public void lh(boolean z) {
        this.lxv = z;
    }

    public void qo(boolean z) {
        BdListViewHelper.a(this.jdA, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
