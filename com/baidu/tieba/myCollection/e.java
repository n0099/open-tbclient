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
    BaseFragmentActivity fNF;
    private View iyv;
    private RelativeLayout jPs;
    public BdListView jaC;
    private a kUB;
    private d kUy;
    public NavigationBarShadowView koh;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a kUz = null;
    a.b kUA = null;
    private boolean kUC = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.koh != null && i == 1) {
                e.this.koh.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.koh != null && childAt != null && childAt.getTop() == 0) {
                    e.this.koh.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.fNF = null;
        this.jaC = null;
        this.iyv = null;
        this.mNoDataView = null;
        this.kUy = null;
        this.jPs = null;
        this.mProgressBar = null;
        this.fNF = threadFragment.getBaseFragmentActivity();
        this.koh = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.jPs = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fNF.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.fNF.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aY(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.kUy = new d(threadFragment.getPageContext());
        this.kUy.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.jaC = (BdListView) view.findViewById(R.id.list);
        this.jaC.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.iyv = new TextView(this.fNF.getActivity());
        this.iyv.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fNF.getActivity(), R.dimen.ds88)));
        this.jaC.addHeaderView(this.iyv, 0);
        this.jaC.setAdapter((ListAdapter) this.kUy);
        this.jaC.setOnSrollToBottomListener(threadFragment);
        this.jaC.setOnItemClickListener(threadFragment);
        this.jaC.setOnScrollListener(this.mOnScrollListener);
        this.kUy.M(threadFragment);
        this.kUy.N(threadFragment);
        this.kUy.O(threadFragment);
    }

    public void d(a.b bVar) {
        this.kUA = bVar;
    }

    public void tj(boolean z) {
        this.kUy.la(z);
        this.kUy.notifyDataSetChanged();
    }

    public int tk(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int tl(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int tm(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.jaC.startPullRefresh();
            return;
        }
        this.kUy.setRefreshing(true);
        this.kUy.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.kUy.setRefreshing(true);
        if (str != null) {
            this.fNF.showToast(str);
        }
        if (aVar != null) {
            if (aVar.dcy() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.dcy() < 20) {
                this.kUy.setHasMore(false);
                this.kUy.ti(true);
            } else {
                this.kUy.setHasMore(true);
                this.kUy.ti(true);
            }
            this.kUy.setData(aVar.dcx());
            a(aVar, z);
        }
        this.kUy.setRefreshing(false);
        this.kUy.notifyDataSetChanged();
        if (isPullRefreshing()) {
            kj(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.jaC.removeHeaderView(this.mNoDataView);
            this.kUy.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.fNF.getPageContext());
        this.jaC.removeHeaderView(this.mNoDataView);
        this.jaC.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void dct() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.fNF.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.fNF.closeLoadingDialog();
        if (str != null) {
            this.fNF.showToast(str);
        }
        if (z2) {
            dcu();
        }
        this.kUy.notifyDataSetChanged();
    }

    public void crQ() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes24.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a kUE;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.kUE = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.kUE != null) {
                this.kUE.p(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fNF.showToast(this.fNF.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.dcx() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.kUy.setData(aVar.dcx());
            if (aVar.dcx().size() == 0) {
                if (this.kUB == null) {
                    this.kUB = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUB);
                }
                com.baidu.adp.lib.f.e.mY().postDelayed(this.kUB, 600L);
            }
        } else {
            this.fNF.showToast(str);
        }
        this.kUy.ti(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.fNF.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aV(ArrayList<MarkData> arrayList) {
        this.kUy.setData(arrayList);
    }

    private void dcu() {
        if (this.kUz == null) {
            this.kUz = new com.baidu.tbadk.core.dialog.a(this.fNF.getPageContext().getPageActivity());
            this.kUz.AZ(this.fNF.getPageContext().getString(R.string.sync_mark_fail));
            this.kUz.Ba(this.fNF.getPageContext().getString(R.string.neterror));
            if (this.kUA != null) {
                this.kUz.a(this.fNF.getPageContext().getString(R.string.retry_rightnow), this.kUA);
            }
            this.kUz.b(this.fNF.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kUz.b(this.fNF.getPageContext());
            this.kUz.iN(true);
        }
        this.kUz.bmC();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jPs, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        dcv();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fNF.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void dcv() {
        this.kUy.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.kUz != null) {
            this.kUz.dismiss();
            this.kUz = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.kUB != null) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(this.kUB);
        }
    }

    public void completePullRefresh() {
        if (this.jaC != null) {
            this.jaC.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.kUC;
    }

    public void kj(boolean z) {
        this.kUC = z;
    }

    public void pc(boolean z) {
        BdListViewHelper.a(this.iyv, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
