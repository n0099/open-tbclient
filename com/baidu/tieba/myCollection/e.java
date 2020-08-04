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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class e {
    BaseFragmentActivity feq;
    private View hCD;
    private RelativeLayout iQn;
    public BdListView idN;
    private d jUN;
    private a jUQ;
    public NavigationBarShadowView jpe;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a jUO = null;
    a.b jUP = null;
    private boolean jUR = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.jpe != null && i == 1) {
                e.this.jpe.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.jpe != null && childAt != null && childAt.getTop() == 0) {
                    e.this.jpe.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.feq = null;
        this.idN = null;
        this.hCD = null;
        this.mNoDataView = null;
        this.jUN = null;
        this.iQn = null;
        this.mProgressBar = null;
        this.feq = threadFragment.getBaseFragmentActivity();
        this.jpe = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.iQn = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.feq.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.feq.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aQ(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.jUN = new d(threadFragment.getPageContext());
        this.jUN.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.idN = (BdListView) view.findViewById(R.id.list);
        this.idN.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.hCD = new TextView(this.feq.getActivity());
        this.hCD.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.feq.getActivity(), R.dimen.ds88)));
        this.idN.addHeaderView(this.hCD, 0);
        this.idN.setAdapter((ListAdapter) this.jUN);
        this.idN.setOnSrollToBottomListener(threadFragment);
        this.idN.setOnItemClickListener(threadFragment);
        this.idN.setOnScrollListener(this.mOnScrollListener);
        this.jUN.L(threadFragment);
        this.jUN.M(threadFragment);
        this.jUN.N(threadFragment);
    }

    public void d(a.b bVar) {
        this.jUP = bVar;
    }

    public void rv(boolean z) {
        this.jUN.jO(z);
        this.jUN.notifyDataSetChanged();
    }

    public int rw(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int rx(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int ry(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.idN.startPullRefresh();
            return;
        }
        this.jUN.setRefreshing(true);
        this.jUN.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.jUN.setRefreshing(true);
        if (str != null) {
            this.feq.showToast(str);
        }
        if (aVar != null) {
            if (aVar.cHm() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.cHm() < 20) {
                this.jUN.setHasMore(false);
                this.jUN.ru(true);
            } else {
                this.jUN.setHasMore(true);
                this.jUN.ru(true);
            }
            this.jUN.setData(aVar.cHl());
            a(aVar, z);
        }
        this.jUN.setRefreshing(false);
        this.jUN.notifyDataSetChanged();
        if (isPullRefreshing()) {
            iX(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.idN.removeHeaderView(this.mNoDataView);
            this.jUN.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.feq.getPageContext());
        this.idN.removeHeaderView(this.mNoDataView);
        this.idN.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void cHh() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.feq.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.feq.closeLoadingDialog();
        if (str != null) {
            this.feq.showToast(str);
        }
        if (z2) {
            cHi();
        }
        this.jUN.notifyDataSetChanged();
    }

    public void bXB() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes18.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a jUT;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.jUT = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jUT != null) {
                this.jUT.l(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.feq.showToast(this.feq.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.cHl() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.jUN.setData(aVar.cHl());
            if (aVar.cHl().size() == 0) {
                if (this.jUQ == null) {
                    this.jUQ = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jUQ);
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(this.jUQ, 600L);
            }
        } else {
            this.feq.showToast(str);
        }
        this.jUN.ru(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.feq.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aK(ArrayList<MarkData> arrayList) {
        this.jUN.setData(arrayList);
    }

    private void cHi() {
        if (this.jUO == null) {
            this.jUO = new com.baidu.tbadk.core.dialog.a(this.feq.getPageContext().getPageActivity());
            this.jUO.xk(this.feq.getPageContext().getString(R.string.sync_mark_fail));
            this.jUO.xl(this.feq.getPageContext().getString(R.string.neterror));
            if (this.jUP != null) {
                this.jUO.a(this.feq.getPageContext().getString(R.string.retry_rightnow), this.jUP);
            }
            this.jUO.b(this.feq.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jUO.b(this.feq.getPageContext());
            this.jUO.hK(true);
        }
        this.jUO.aYL();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.iQn, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        cHj();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.feq.getPageContext(), i);
            ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void cHj() {
        this.jUN.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.jUO != null) {
            this.jUO.dismiss();
            this.jUO = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.jUQ != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jUQ);
        }
    }

    public void completePullRefresh() {
        if (this.idN != null) {
            this.idN.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.jUR;
    }

    public void iX(boolean z) {
        this.jUR = z;
    }

    public void nt(boolean z) {
        BdListViewHelper.a(this.hCD, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
