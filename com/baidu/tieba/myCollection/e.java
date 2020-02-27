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
    BaseFragmentActivity eax;
    public BdListView gIB;
    private View glC;
    public NavigationBarShadowView hOy;
    private RelativeLayout hrX;
    private d isQ;
    private a isT;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;
    private com.baidu.tbadk.core.dialog.a isR = null;
    a.b isS = null;
    private boolean isU = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.hOy != null && i == 1) {
                e.this.hOy.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.hOy != null && childAt != null && childAt.getTop() == 0) {
                    e.this.hOy.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.eax = null;
        this.gIB = null;
        this.glC = null;
        this.mNoDataView = null;
        this.isQ = null;
        this.hrX = null;
        this.mProgressBar = null;
        this.eax = threadFragment.getBaseFragmentActivity();
        this.hOy = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.hrX = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.eax.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.eax.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aF(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.isQ = new d(threadFragment.getPageContext());
        this.isQ.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.gIB = (BdListView) view.findViewById(R.id.list);
        this.gIB.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.glC = new TextView(this.eax.getActivity());
        this.glC.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.eax.getActivity(), R.dimen.ds88)));
        this.gIB.addHeaderView(this.glC, 0);
        this.gIB.setAdapter((ListAdapter) this.isQ);
        this.gIB.setOnSrollToBottomListener(threadFragment);
        this.gIB.setOnItemClickListener(threadFragment);
        this.gIB.setOnScrollListener(this.mOnScrollListener);
        this.isQ.J(threadFragment);
        this.isQ.K(threadFragment);
        this.isQ.L(threadFragment);
    }

    public void d(a.b bVar) {
        this.isS = bVar;
    }

    public void oZ(boolean z) {
        this.isQ.hC(z);
        this.isQ.notifyDataSetChanged();
    }

    public int pa(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int pb(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int pc(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.gIB.startPullRefresh();
            return;
        }
        this.isQ.setRefreshing(true);
        this.isQ.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.isQ.setRefreshing(true);
        if (str != null) {
            this.eax.showToast(str);
        }
        if (aVar != null) {
            if (aVar.chL() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.chL() < 20) {
                this.isQ.setHasMore(false);
                this.isQ.oY(true);
            } else {
                this.isQ.setHasMore(true);
                this.isQ.oY(true);
            }
            this.isQ.setData(aVar.chK());
            a(aVar, z);
        }
        this.isQ.setRefreshing(false);
        this.isQ.notifyDataSetChanged();
        if (isPullRefreshing()) {
            gO(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.gIB.removeHeaderView(this.mNoDataView);
            this.isQ.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.eax.getPageContext());
        this.gIB.removeHeaderView(this.mNoDataView);
        this.gIB.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void chG() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.eax.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.eax.closeLoadingDialog();
        if (str != null) {
            this.eax.showToast(str);
        }
        if (z2) {
            chH();
        }
        this.isQ.notifyDataSetChanged();
    }

    public void bAf() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a isW;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.isW = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.isW != null) {
                this.isW.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.eax.showToast(this.eax.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.chK() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.isQ.setData(aVar.chK());
            if (aVar.chK().size() == 0) {
                if (this.isT == null) {
                    this.isT = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.isT);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.isT, 600L);
            }
        } else {
            this.eax.showToast(str);
        }
        this.isQ.oY(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eax.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aG(ArrayList<MarkData> arrayList) {
        this.isQ.setData(arrayList);
    }

    private void chH() {
        if (this.isR == null) {
            this.isR = new com.baidu.tbadk.core.dialog.a(this.eax.getPageContext().getPageActivity());
            this.isR.sR(this.eax.getPageContext().getString(R.string.sync_mark_fail));
            this.isR.sS(this.eax.getPageContext().getString(R.string.neterror));
            if (this.isS != null) {
                this.isR.a(this.eax.getPageContext().getString(R.string.retry_rightnow), this.isS);
            }
            this.isR.b(this.eax.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.isR.b(this.eax.getPageContext());
            this.isR.fH(true);
        }
        this.isR.aEA();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hrX, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        chI();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eax.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void chI() {
        this.isQ.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.isR != null) {
            this.isR.dismiss();
            this.isR = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.isT != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.isT);
        }
    }

    public void completePullRefresh() {
        if (this.gIB != null) {
            this.gIB.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.isU;
    }

    public void gO(boolean z) {
        this.isU = z;
    }

    public void kY(boolean z) {
        BdListViewHelper.a(this.glC, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
