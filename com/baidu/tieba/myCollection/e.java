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
/* loaded from: classes8.dex */
public class e {
    BaseFragmentActivity gkF;
    public BdListView jHk;
    private View jcm;
    public NavigationBarShadowView kNs;
    private d ltE;
    private RelativeLayout ltF;
    private a ltI;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a ltG = null;
    a.b ltH = null;
    private boolean ltJ = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.kNs != null && i == 1) {
                e.this.kNs.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.kNs != null && childAt != null && childAt.getTop() == 0) {
                    e.this.kNs.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.gkF = null;
        this.jHk = null;
        this.jcm = null;
        this.mNoDataView = null;
        this.ltE = null;
        this.ltF = null;
        this.mProgressBar = null;
        this.gkF = threadFragment.getBaseFragmentActivity();
        this.kNs = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.ltF = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.gkF.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.gkF.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aY(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.ltE = new d(threadFragment.getPageContext());
        this.ltE.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.jHk = (BdListView) view.findViewById(R.id.list);
        this.jHk.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.jcm = new TextView(this.gkF.getActivity());
        this.jcm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gkF.getActivity(), R.dimen.ds88)));
        this.jHk.addHeaderView(this.jcm, 0);
        this.jHk.setAdapter((ListAdapter) this.ltE);
        this.jHk.setOnSrollToBottomListener(threadFragment);
        this.jHk.setOnItemClickListener(threadFragment);
        this.jHk.setOnScrollListener(this.mOnScrollListener);
        this.ltE.O(threadFragment);
        this.ltE.P(threadFragment);
        this.ltE.Q(threadFragment);
    }

    public void b(a.b bVar) {
        this.ltH = bVar;
    }

    public void tY(boolean z) {
        this.ltE.mc(z);
        this.ltE.notifyDataSetChanged();
    }

    public int tZ(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int ua(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int ub(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.jHk.startPullRefresh();
            return;
        }
        this.ltE.setRefreshing(true);
        this.ltE.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.ltE.setRefreshing(true);
        if (str != null) {
            this.gkF.showToast(str);
        }
        if (aVar != null) {
            if (aVar.djy() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.djy() < 20) {
                this.ltE.setHasMore(false);
                this.ltE.tX(true);
            } else {
                this.ltE.setHasMore(true);
                this.ltE.tX(true);
            }
            this.ltE.setData(aVar.djx());
            a(aVar, z);
        }
        this.ltE.setRefreshing(false);
        this.ltE.notifyDataSetChanged();
        if (isPullRefreshing()) {
            li(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.jHk.removeHeaderView(this.mNoDataView);
            this.ltE.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.gkF.getPageContext());
        this.jHk.removeHeaderView(this.mNoDataView);
        this.jHk.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void djt() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.gkF.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.gkF.closeLoadingDialog();
        if (str != null) {
            this.gkF.showToast(str);
        }
        if (z2) {
            dju();
        }
        this.ltE.notifyDataSetChanged();
    }

    public void cBd() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes8.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a ltL;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.ltL = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ltL != null) {
                this.ltL.q(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.gkF.showToast(this.gkF.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.djx() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.ltE.setData(aVar.djx());
            if (aVar.djx().size() == 0) {
                if (this.ltI == null) {
                    this.ltI = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(this.ltI);
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(this.ltI, 600L);
            }
        } else {
            this.gkF.showToast(str);
        }
        this.ltE.tX(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.gkF.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aY(ArrayList<MarkData> arrayList) {
        this.ltE.setData(arrayList);
    }

    private void dju() {
        if (this.ltG == null) {
            this.ltG = new com.baidu.tbadk.core.dialog.a(this.gkF.getPageContext().getPageActivity());
            this.ltG.Bo(this.gkF.getPageContext().getString(R.string.sync_mark_fail));
            this.ltG.Bp(this.gkF.getPageContext().getString(R.string.neterror));
            if (this.ltH != null) {
                this.ltG.a(this.gkF.getPageContext().getString(R.string.retry_rightnow), this.ltH);
            }
            this.ltG.b(this.gkF.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ltG.b(this.gkF.getPageContext());
            this.ltG.jI(true);
        }
        this.ltG.btX();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.ltF, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        djv();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gkF.getPageContext(), i);
            ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
    }

    public void djv() {
        this.ltE.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.ltG != null) {
            this.ltG.dismiss();
            this.ltG = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.ltI != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.ltI);
        }
    }

    public void completePullRefresh() {
        if (this.jHk != null) {
            this.jHk.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.ltJ;
    }

    public void li(boolean z) {
        this.ltJ = z;
    }

    public void qi(boolean z) {
        BdListViewHelper.a(this.jcm, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
