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
/* loaded from: classes9.dex */
public class e {
    BaseFragmentActivity dWt;
    public BdListView gGC;
    private View gjB;
    public NavigationBarShadowView hMA;
    private RelativeLayout hpY;
    private d iqV;
    private a iqY;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;
    private com.baidu.tbadk.core.dialog.a iqW = null;
    a.b iqX = null;
    private boolean iqZ = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.hMA != null && i == 1) {
                e.this.hMA.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.hMA != null && childAt != null && childAt.getTop() == 0) {
                    e.this.hMA.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.dWt = null;
        this.gGC = null;
        this.gjB = null;
        this.mNoDataView = null;
        this.iqV = null;
        this.hpY = null;
        this.mProgressBar = null;
        this.dWt = threadFragment.getBaseFragmentActivity();
        this.hMA = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.hpY = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.dWt.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.dWt.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aF(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.iqV = new d(threadFragment.getPageContext());
        this.iqV.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.gGC = (BdListView) view.findViewById(R.id.list);
        this.gGC.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.gjB = new TextView(this.dWt.getActivity());
        this.gjB.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.dWt.getActivity(), R.dimen.ds88)));
        this.gGC.addHeaderView(this.gjB, 0);
        this.gGC.setAdapter((ListAdapter) this.iqV);
        this.gGC.setOnSrollToBottomListener(threadFragment);
        this.gGC.setOnItemClickListener(threadFragment);
        this.gGC.setOnScrollListener(this.mOnScrollListener);
        this.iqV.I(threadFragment);
        this.iqV.J(threadFragment);
        this.iqV.K(threadFragment);
    }

    public void d(a.b bVar) {
        this.iqX = bVar;
    }

    public void oW(boolean z) {
        this.iqV.hv(z);
        this.iqV.notifyDataSetChanged();
    }

    public int oX(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int oY(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int oZ(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.gGC.startPullRefresh();
            return;
        }
        this.iqV.setRefreshing(true);
        this.iqV.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.iqV.setRefreshing(true);
        if (str != null) {
            this.dWt.showToast(str);
        }
        if (aVar != null) {
            if (aVar.cgg() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.cgg() < 20) {
                this.iqV.setHasMore(false);
                this.iqV.oV(true);
            } else {
                this.iqV.setHasMore(true);
                this.iqV.oV(true);
            }
            this.iqV.setData(aVar.cgf());
            a(aVar, z);
        }
        this.iqV.setRefreshing(false);
        this.iqV.notifyDataSetChanged();
        if (isPullRefreshing()) {
            gH(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.gGC.removeHeaderView(this.mNoDataView);
            this.iqV.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.dWt.getPageContext());
        this.gGC.removeHeaderView(this.mNoDataView);
        this.gGC.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void cgb() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.dWt.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.dWt.closeLoadingDialog();
        if (str != null) {
            this.dWt.showToast(str);
        }
        if (z2) {
            cgc();
        }
        this.iqV.notifyDataSetChanged();
    }

    public void byD() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes9.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a irb;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.irb = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.irb != null) {
                this.irb.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.dWt.showToast(this.dWt.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.cgf() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.iqV.setData(aVar.cgf());
            if (aVar.cgf().size() == 0) {
                if (this.iqY == null) {
                    this.iqY = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iqY);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.iqY, 600L);
            }
        } else {
            this.dWt.showToast(str);
        }
        this.iqV.oV(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.dWt.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aG(ArrayList<MarkData> arrayList) {
        this.iqV.setData(arrayList);
    }

    private void cgc() {
        if (this.iqW == null) {
            this.iqW = new com.baidu.tbadk.core.dialog.a(this.dWt.getPageContext().getPageActivity());
            this.iqW.sB(this.dWt.getPageContext().getString(R.string.sync_mark_fail));
            this.iqW.sC(this.dWt.getPageContext().getString(R.string.neterror));
            if (this.iqX != null) {
                this.iqW.a(this.dWt.getPageContext().getString(R.string.retry_rightnow), this.iqX);
            }
            this.iqW.b(this.dWt.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iqW.b(this.dWt.getPageContext());
            this.iqW.fA(true);
        }
        this.iqW.aCp();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hpY, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        cgd();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.dWt.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void cgd() {
        this.iqV.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.iqW != null) {
            this.iqW.dismiss();
            this.iqW = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.iqY != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iqY);
        }
    }

    public void completePullRefresh() {
        if (this.gGC != null) {
            this.gGC.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.iqZ;
    }

    public void gH(boolean z) {
        this.iqZ = z;
    }

    public void kU(boolean z) {
        BdListViewHelper.a(this.gjB, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
