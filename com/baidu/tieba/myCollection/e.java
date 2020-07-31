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
    private RelativeLayout iQl;
    public BdListView idL;
    private d jUL;
    private a jUO;
    public NavigationBarShadowView jpc;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a jUM = null;
    a.b jUN = null;
    private boolean jUP = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.jpc != null && i == 1) {
                e.this.jpc.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.jpc != null && childAt != null && childAt.getTop() == 0) {
                    e.this.jpc.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.feq = null;
        this.idL = null;
        this.hCD = null;
        this.mNoDataView = null;
        this.jUL = null;
        this.iQl = null;
        this.mProgressBar = null;
        this.feq = threadFragment.getBaseFragmentActivity();
        this.jpc = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.iQl = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.feq.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.feq.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aQ(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.jUL = new d(threadFragment.getPageContext());
        this.jUL.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.idL = (BdListView) view.findViewById(R.id.list);
        this.idL.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.hCD = new TextView(this.feq.getActivity());
        this.hCD.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.feq.getActivity(), R.dimen.ds88)));
        this.idL.addHeaderView(this.hCD, 0);
        this.idL.setAdapter((ListAdapter) this.jUL);
        this.idL.setOnSrollToBottomListener(threadFragment);
        this.idL.setOnItemClickListener(threadFragment);
        this.idL.setOnScrollListener(this.mOnScrollListener);
        this.jUL.L(threadFragment);
        this.jUL.M(threadFragment);
        this.jUL.N(threadFragment);
    }

    public void d(a.b bVar) {
        this.jUN = bVar;
    }

    public void rv(boolean z) {
        this.jUL.jO(z);
        this.jUL.notifyDataSetChanged();
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
            this.idL.startPullRefresh();
            return;
        }
        this.jUL.setRefreshing(true);
        this.jUL.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.jUL.setRefreshing(true);
        if (str != null) {
            this.feq.showToast(str);
        }
        if (aVar != null) {
            if (aVar.cHm() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.cHm() < 20) {
                this.jUL.setHasMore(false);
                this.jUL.ru(true);
            } else {
                this.jUL.setHasMore(true);
                this.jUL.ru(true);
            }
            this.jUL.setData(aVar.cHl());
            a(aVar, z);
        }
        this.jUL.setRefreshing(false);
        this.jUL.notifyDataSetChanged();
        if (isPullRefreshing()) {
            iX(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.idL.removeHeaderView(this.mNoDataView);
            this.jUL.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.feq.getPageContext());
        this.idL.removeHeaderView(this.mNoDataView);
        this.idL.addHeaderView(this.mNoDataView);
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
        this.jUL.notifyDataSetChanged();
    }

    public void bXB() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes18.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a jUR;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.jUR = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jUR != null) {
                this.jUR.l(true);
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
            this.jUL.setData(aVar.cHl());
            if (aVar.cHl().size() == 0) {
                if (this.jUO == null) {
                    this.jUO = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jUO);
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(this.jUO, 600L);
            }
        } else {
            this.feq.showToast(str);
        }
        this.jUL.ru(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.feq.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aK(ArrayList<MarkData> arrayList) {
        this.jUL.setData(arrayList);
    }

    private void cHi() {
        if (this.jUM == null) {
            this.jUM = new com.baidu.tbadk.core.dialog.a(this.feq.getPageContext().getPageActivity());
            this.jUM.xk(this.feq.getPageContext().getString(R.string.sync_mark_fail));
            this.jUM.xl(this.feq.getPageContext().getString(R.string.neterror));
            if (this.jUN != null) {
                this.jUM.a(this.feq.getPageContext().getString(R.string.retry_rightnow), this.jUN);
            }
            this.jUM.b(this.feq.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jUM.b(this.feq.getPageContext());
            this.jUM.hK(true);
        }
        this.jUM.aYL();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.iQl, R.color.cp_bg_line_d);
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
        this.jUL.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.jUM != null) {
            this.jUM.dismiss();
            this.jUM = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.jUO != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jUO);
        }
    }

    public void completePullRefresh() {
        if (this.idL != null) {
            this.idL.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.jUP;
    }

    public void iX(boolean z) {
        this.jUP = z;
    }

    public void nt(boolean z) {
        BdListViewHelper.a(this.hCD, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
