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
/* loaded from: classes7.dex */
public class f {
    BaseFragmentActivity gke;
    public BdListView jKf;
    private View jfj;
    public NavigationBarShadowView kTg;
    private e lzt;
    private RelativeLayout lzu;
    private a lzx;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a lzv = null;
    a.b lzw = null;
    private boolean lzy = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.f.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.kTg != null && i == 1) {
                f.this.kTg.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (f.this.kTg != null && childAt != null && childAt.getTop() == 0) {
                    f.this.kTg.hide();
                }
            }
        }
    };

    public f(ThreadFragment threadFragment, View view) {
        this.gke = null;
        this.jKf = null;
        this.jfj = null;
        this.mNoDataView = null;
        this.lzt = null;
        this.lzu = null;
        this.mProgressBar = null;
        this.gke = threadFragment.getBaseFragmentActivity();
        this.kTg = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.lzu = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.gke.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.gke.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aV(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.lzt = new e(threadFragment.getPageContext());
        this.lzt.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.jKf = (BdListView) view.findViewById(R.id.list);
        this.jKf.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.jfj = new TextView(this.gke.getActivity());
        this.jfj.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gke.getActivity(), R.dimen.ds88)));
        this.jKf.addHeaderView(this.jfj, 0);
        this.jKf.setAdapter((ListAdapter) this.lzt);
        this.jKf.setOnSrollToBottomListener(threadFragment);
        this.jKf.setOnItemClickListener(threadFragment);
        this.jKf.setOnScrollListener(this.mOnScrollListener);
        this.lzt.P(threadFragment);
        this.lzt.Q(threadFragment);
        this.lzt.R(threadFragment);
    }

    public void b(a.b bVar) {
        this.lzw = bVar;
    }

    public void uh(boolean z) {
        this.lzt.mc(z);
        this.lzt.notifyDataSetChanged();
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
            this.jKf.startPullRefresh();
            return;
        }
        this.lzt.setRefreshing(true);
        this.lzt.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.lzt.setRefreshing(true);
        if (str != null) {
            this.gke.showToast(str);
        }
        if (aVar != null) {
            if (aVar.dhY() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.dhY() < 20) {
                this.lzt.setHasMore(false);
                this.lzt.ug(true);
            } else {
                this.lzt.setHasMore(true);
                this.lzt.ug(true);
            }
            this.lzt.setData(aVar.dhX());
            a(aVar, z);
        }
        this.lzt.setRefreshing(false);
        this.lzt.notifyDataSetChanged();
        if (isPullRefreshing()) {
            lh(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.jKf.removeHeaderView(this.mNoDataView);
            this.lzt.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.gke.getPageContext());
        this.jKf.removeHeaderView(this.mNoDataView);
        this.jKf.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void dhT() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.gke.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.gke.closeLoadingDialog();
        if (str != null) {
            this.gke.showToast(str);
        }
        if (z2) {
            dhU();
        }
        this.lzt.notifyDataSetChanged();
    }

    public void cyK() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes7.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a lzA;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.lzA = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.lzA != null) {
                this.lzA.p(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.gke.showToast(this.gke.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.dhX() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.lzt.setData(aVar.dhX());
            if (aVar.dhX().size() == 0) {
                if (this.lzx == null) {
                    this.lzx = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lzx);
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(this.lzx, 600L);
            }
        } else {
            this.gke.showToast(str);
        }
        this.lzt.ug(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.gke.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aS(ArrayList<MarkData> arrayList) {
        this.lzt.setData(arrayList);
    }

    private void dhU() {
        if (this.lzv == null) {
            this.lzv = new com.baidu.tbadk.core.dialog.a(this.gke.getPageContext().getPageActivity());
            this.lzv.AA(this.gke.getPageContext().getString(R.string.sync_mark_fail));
            this.lzv.AB(this.gke.getPageContext().getString(R.string.neterror));
            if (this.lzw != null) {
                this.lzv.a(this.gke.getPageContext().getString(R.string.retry_rightnow), this.lzw);
            }
            this.lzv.b(this.gke.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lzv.b(this.gke.getPageContext());
            this.lzv.jG(true);
        }
        this.lzv.bqz();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.lzu, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        dhV();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gke.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
    }

    public void dhV() {
        this.lzt.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.lzv != null) {
            this.lzv.dismiss();
            this.lzv = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.lzx != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lzx);
        }
        if (this.lzt != null) {
            this.lzt.onDestroy();
        }
    }

    public void completePullRefresh() {
        if (this.jKf != null) {
            this.jKf.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.lzy;
    }

    public void lh(boolean z) {
        this.lzy = z;
    }

    public void qo(boolean z) {
        BdListViewHelper.a(this.jfj, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
