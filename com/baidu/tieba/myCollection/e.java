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
/* loaded from: classes11.dex */
public class e {
    BaseFragmentActivity eAT;
    private View gVL;
    public BdListView huX;
    public NavigationBarShadowView iAj;
    private RelativeLayout idE;
    private d jeN;
    private a jeQ;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;
    private com.baidu.tbadk.core.dialog.a jeO = null;
    a.b jeP = null;
    private boolean jeR = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.iAj != null && i == 1) {
                e.this.iAj.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.iAj != null && childAt != null && childAt.getTop() == 0) {
                    e.this.iAj.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.eAT = null;
        this.huX = null;
        this.gVL = null;
        this.mNoDataView = null;
        this.jeN = null;
        this.idE = null;
        this.mProgressBar = null;
        this.eAT = threadFragment.getBaseFragmentActivity();
        this.iAj = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.idE = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.eAT.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.eAT.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aJ(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.jeN = new d(threadFragment.getPageContext());
        this.jeN.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.huX = (BdListView) view.findViewById(R.id.list);
        this.huX.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.gVL = new TextView(this.eAT.getActivity());
        this.gVL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.eAT.getActivity(), R.dimen.ds88)));
        this.huX.addHeaderView(this.gVL, 0);
        this.huX.setAdapter((ListAdapter) this.jeN);
        this.huX.setOnSrollToBottomListener(threadFragment);
        this.huX.setOnItemClickListener(threadFragment);
        this.huX.setOnScrollListener(this.mOnScrollListener);
        this.jeN.K(threadFragment);
        this.jeN.L(threadFragment);
        this.jeN.M(threadFragment);
    }

    public void d(a.b bVar) {
        this.jeP = bVar;
    }

    public void qj(boolean z) {
        this.jeN.iB(z);
        this.jeN.notifyDataSetChanged();
    }

    public int qk(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int ql(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int qm(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.huX.startPullRefresh();
            return;
        }
        this.jeN.setRefreshing(true);
        this.jeN.notifyDataSetChanged();
    }

    public void ash() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.jeN.setRefreshing(true);
        if (str != null) {
            this.eAT.showToast(str);
        }
        if (aVar != null) {
            if (aVar.csM() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.csM() < 20) {
                this.jeN.setHasMore(false);
                this.jeN.qi(true);
            } else {
                this.jeN.setHasMore(true);
                this.jeN.qi(true);
            }
            this.jeN.setData(aVar.csL());
            a(aVar, z);
        }
        this.jeN.setRefreshing(false);
        this.jeN.notifyDataSetChanged();
        if (isPullRefreshing()) {
            hN(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.huX.removeHeaderView(this.mNoDataView);
            this.jeN.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.eAT.getPageContext());
        this.huX.removeHeaderView(this.mNoDataView);
        this.huX.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void csH() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.eAT.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.eAT.closeLoadingDialog();
        if (str != null) {
            this.eAT.showToast(str);
        }
        if (z2) {
            csI();
        }
        this.jeN.notifyDataSetChanged();
    }

    public void bKN() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a jeT;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.jeT = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jeT != null) {
                this.jeT.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.eAT.showToast(this.eAT.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.csL() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.jeN.setData(aVar.csL());
            if (aVar.csL().size() == 0) {
                if (this.jeQ == null) {
                    this.jeQ = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jeQ);
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(this.jeQ, 600L);
            }
        } else {
            this.eAT.showToast(str);
        }
        this.jeN.qi(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eAT.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aI(ArrayList<MarkData> arrayList) {
        this.jeN.setData(arrayList);
    }

    private void csI() {
        if (this.jeO == null) {
            this.jeO = new com.baidu.tbadk.core.dialog.a(this.eAT.getPageContext().getPageActivity());
            this.jeO.uh(this.eAT.getPageContext().getString(R.string.sync_mark_fail));
            this.jeO.ui(this.eAT.getPageContext().getString(R.string.neterror));
            if (this.jeP != null) {
                this.jeO.a(this.eAT.getPageContext().getString(R.string.retry_rightnow), this.jeP);
            }
            this.jeO.b(this.eAT.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jeO.b(this.eAT.getPageContext());
            this.jeO.gF(true);
        }
        this.jeO.aMS();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.idE, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        csJ();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eAT.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void csJ() {
        this.jeN.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.jeO != null) {
            this.jeO.dismiss();
            this.jeO = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.jeQ != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jeQ);
        }
    }

    public void completePullRefresh() {
        if (this.huX != null) {
            this.huX.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.jeR;
    }

    public void hN(boolean z) {
        this.jeR = z;
    }

    public void mi(boolean z) {
        BdListViewHelper.a(this.gVL, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
