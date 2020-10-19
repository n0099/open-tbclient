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
/* loaded from: classes24.dex */
public class e {
    BaseFragmentActivity fFk;
    public BdListView iOg;
    private View ilX;
    private RelativeLayout jCT;
    private d kIb;
    private a kIe;
    public NavigationBarShadowView kbI;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a kIc = null;
    a.b kId = null;
    private boolean kIf = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.kbI != null && i == 1) {
                e.this.kbI.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.kbI != null && childAt != null && childAt.getTop() == 0) {
                    e.this.kbI.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.fFk = null;
        this.iOg = null;
        this.ilX = null;
        this.mNoDataView = null;
        this.kIb = null;
        this.jCT = null;
        this.mProgressBar = null;
        this.fFk = threadFragment.getBaseFragmentActivity();
        this.kbI = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.jCT = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fFk.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.fFk.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aX(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.kIb = new d(threadFragment.getPageContext());
        this.kIb.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.iOg = (BdListView) view.findViewById(R.id.list);
        this.iOg.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.ilX = new TextView(this.fFk.getActivity());
        this.ilX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fFk.getActivity(), R.dimen.ds88)));
        this.iOg.addHeaderView(this.ilX, 0);
        this.iOg.setAdapter((ListAdapter) this.kIb);
        this.iOg.setOnSrollToBottomListener(threadFragment);
        this.iOg.setOnItemClickListener(threadFragment);
        this.iOg.setOnScrollListener(this.mOnScrollListener);
        this.kIb.M(threadFragment);
        this.kIb.N(threadFragment);
        this.kIb.O(threadFragment);
    }

    public void d(a.b bVar) {
        this.kId = bVar;
    }

    public void sS(boolean z) {
        this.kIb.kN(z);
        this.kIb.notifyDataSetChanged();
    }

    public int sT(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int sU(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int sV(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.iOg.startPullRefresh();
            return;
        }
        this.kIb.setRefreshing(true);
        this.kIb.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.kIb.setRefreshing(true);
        if (str != null) {
            this.fFk.showToast(str);
        }
        if (aVar != null) {
            if (aVar.cZq() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.cZq() < 20) {
                this.kIb.setHasMore(false);
                this.kIb.sR(true);
            } else {
                this.kIb.setHasMore(true);
                this.kIb.sR(true);
            }
            this.kIb.setData(aVar.cZp());
            a(aVar, z);
        }
        this.kIb.setRefreshing(false);
        this.kIb.notifyDataSetChanged();
        if (isPullRefreshing()) {
            jW(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.iOg.removeHeaderView(this.mNoDataView);
            this.kIb.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.fFk.getPageContext());
        this.iOg.removeHeaderView(this.mNoDataView);
        this.iOg.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void cZl() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.fFk.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.fFk.closeLoadingDialog();
        if (str != null) {
            this.fFk.showToast(str);
        }
        if (z2) {
            cZm();
        }
        this.kIb.notifyDataSetChanged();
    }

    public void coJ() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes24.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a kIh;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.kIh = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.kIh != null) {
                this.kIh.p(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fFk.showToast(this.fFk.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.cZp() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.kIb.setData(aVar.cZp());
            if (aVar.cZp().size() == 0) {
                if (this.kIe == null) {
                    this.kIe = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kIe);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.kIe, 600L);
            }
        } else {
            this.fFk.showToast(str);
        }
        this.kIb.sR(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.fFk.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aS(ArrayList<MarkData> arrayList) {
        this.kIb.setData(arrayList);
    }

    private void cZm() {
        if (this.kIc == null) {
            this.kIc = new com.baidu.tbadk.core.dialog.a(this.fFk.getPageContext().getPageActivity());
            this.kIc.AG(this.fFk.getPageContext().getString(R.string.sync_mark_fail));
            this.kIc.AH(this.fFk.getPageContext().getString(R.string.neterror));
            if (this.kId != null) {
                this.kIc.a(this.fFk.getPageContext().getString(R.string.retry_rightnow), this.kId);
            }
            this.kIc.b(this.fFk.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kIc.b(this.fFk.getPageContext());
            this.kIc.iA(true);
        }
        this.kIc.bkJ();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jCT, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        cZn();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fFk.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void cZn() {
        this.kIb.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.kIc != null) {
            this.kIc.dismiss();
            this.kIc = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.kIe != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kIe);
        }
    }

    public void completePullRefresh() {
        if (this.iOg != null) {
            this.iOg.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.kIf;
    }

    public void jW(boolean z) {
        this.kIf = z;
    }

    public void oK(boolean z) {
        BdListViewHelper.a(this.ilX, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
