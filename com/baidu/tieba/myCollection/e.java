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
    BaseFragmentActivity fpJ;
    private View hPS;
    public BdListView irR;
    public NavigationBarShadowView jEc;
    private RelativeLayout jfk;
    private d kkj;
    private a kkm;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a kkk = null;
    a.b kkl = null;
    private boolean kkn = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.jEc != null && i == 1) {
                e.this.jEc.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.jEc != null && childAt != null && childAt.getTop() == 0) {
                    e.this.jEc.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.fpJ = null;
        this.irR = null;
        this.hPS = null;
        this.mNoDataView = null;
        this.kkj = null;
        this.jfk = null;
        this.mProgressBar = null;
        this.fpJ = threadFragment.getBaseFragmentActivity();
        this.jEc = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.jfk = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fpJ.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.fpJ.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aY(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.kkj = new d(threadFragment.getPageContext());
        this.kkj.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.irR = (BdListView) view.findViewById(R.id.list);
        this.irR.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.hPS = new TextView(this.fpJ.getActivity());
        this.hPS.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fpJ.getActivity(), R.dimen.ds88)));
        this.irR.addHeaderView(this.hPS, 0);
        this.irR.setAdapter((ListAdapter) this.kkj);
        this.irR.setOnSrollToBottomListener(threadFragment);
        this.irR.setOnItemClickListener(threadFragment);
        this.irR.setOnScrollListener(this.mOnScrollListener);
        this.kkj.M(threadFragment);
        this.kkj.N(threadFragment);
        this.kkj.O(threadFragment);
    }

    public void d(a.b bVar) {
        this.kkl = bVar;
    }

    public void sb(boolean z) {
        this.kkj.km(z);
        this.kkj.notifyDataSetChanged();
    }

    public int sc(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int sd(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int se(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.irR.startPullRefresh();
            return;
        }
        this.kkj.setRefreshing(true);
        this.kkj.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.kkj.setRefreshing(true);
        if (str != null) {
            this.fpJ.showToast(str);
        }
        if (aVar != null) {
            if (aVar.cSb() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.cSb() < 20) {
                this.kkj.setHasMore(false);
                this.kkj.sa(true);
            } else {
                this.kkj.setHasMore(true);
                this.kkj.sa(true);
            }
            this.kkj.setData(aVar.cSa());
            a(aVar, z);
        }
        this.kkj.setRefreshing(false);
        this.kkj.notifyDataSetChanged();
        if (isPullRefreshing()) {
            jv(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.irR.removeHeaderView(this.mNoDataView);
            this.kkj.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.fpJ.getPageContext());
        this.irR.removeHeaderView(this.mNoDataView);
        this.irR.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void cRW() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.fpJ.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.fpJ.closeLoadingDialog();
        if (str != null) {
            this.fpJ.showToast(str);
        }
        if (z2) {
            cRX();
        }
        this.kkj.notifyDataSetChanged();
    }

    public void chX() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes18.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a kkp;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.kkp = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.kkp != null) {
                this.kkp.n(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fpJ.showToast(this.fpJ.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.cSa() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.kkj.setData(aVar.cSa());
            if (aVar.cSa().size() == 0) {
                if (this.kkm == null) {
                    this.kkm = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kkm);
                }
                com.baidu.adp.lib.f.e.mS().postDelayed(this.kkm, 600L);
            }
        } else {
            this.fpJ.showToast(str);
        }
        this.kkj.sa(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.fpJ.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aQ(ArrayList<MarkData> arrayList) {
        this.kkj.setData(arrayList);
    }

    private void cRX() {
        if (this.kkk == null) {
            this.kkk = new com.baidu.tbadk.core.dialog.a(this.fpJ.getPageContext().getPageActivity());
            this.kkk.zy(this.fpJ.getPageContext().getString(R.string.sync_mark_fail));
            this.kkk.zz(this.fpJ.getPageContext().getString(R.string.neterror));
            if (this.kkl != null) {
                this.kkk.a(this.fpJ.getPageContext().getString(R.string.retry_rightnow), this.kkl);
            }
            this.kkk.b(this.fpJ.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kkk.b(this.fpJ.getPageContext());
            this.kkk.ig(true);
        }
        this.kkk.bhg();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jfk, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        cRY();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fpJ.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void cRY() {
        this.kkj.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.kkk != null) {
            this.kkk.dismiss();
            this.kkk = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.kkm != null) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(this.kkm);
        }
    }

    public void completePullRefresh() {
        if (this.irR != null) {
            this.irR.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.kkn;
    }

    public void jv(boolean z) {
        this.kkn = z;
    }

    public void nX(boolean z) {
        BdListViewHelper.a(this.hPS, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
