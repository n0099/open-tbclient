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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    BaseFragmentActivity ePs;
    public BdListView hJK;
    private View hkx;
    public NavigationBarShadowView iOQ;
    private RelativeLayout isn;
    private d jtQ;
    private a jtT;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a jtR = null;
    a.b jtS = null;
    private boolean jtU = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.iOQ != null && i == 1) {
                e.this.iOQ.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.iOQ != null && childAt != null && childAt.getTop() == 0) {
                    e.this.iOQ.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.ePs = null;
        this.hJK = null;
        this.hkx = null;
        this.mNoDataView = null;
        this.jtQ = null;
        this.isn = null;
        this.mProgressBar = null;
        this.ePs = threadFragment.getBaseFragmentActivity();
        this.iOQ = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.isn = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.ePs.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.ePs.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aM(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.jtQ = new d(threadFragment.getPageContext());
        this.jtQ.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.hJK = (BdListView) view.findViewById(R.id.list);
        this.hJK.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.hkx = new TextView(this.ePs.getActivity());
        this.hkx.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ePs.getActivity(), R.dimen.ds88)));
        this.hJK.addHeaderView(this.hkx, 0);
        this.hJK.setAdapter((ListAdapter) this.jtQ);
        this.hJK.setOnSrollToBottomListener(threadFragment);
        this.hJK.setOnItemClickListener(threadFragment);
        this.hJK.setOnScrollListener(this.mOnScrollListener);
        this.jtQ.K(threadFragment);
        this.jtQ.L(threadFragment);
        this.jtQ.M(threadFragment);
    }

    public void d(a.b bVar) {
        this.jtS = bVar;
    }

    public void qG(boolean z) {
        this.jtQ.iY(z);
        this.jtQ.notifyDataSetChanged();
    }

    public int qH(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int qI(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int qJ(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.hJK.startPullRefresh();
            return;
        }
        this.jtQ.setRefreshing(true);
        this.jtQ.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.jtQ.setRefreshing(true);
        if (str != null) {
            this.ePs.showToast(str);
        }
        if (aVar != null) {
            if (aVar.czp() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.czp() < 20) {
                this.jtQ.setHasMore(false);
                this.jtQ.qF(true);
            } else {
                this.jtQ.setHasMore(true);
                this.jtQ.qF(true);
            }
            this.jtQ.setData(aVar.czo());
            a(aVar, z);
        }
        this.jtQ.setRefreshing(false);
        this.jtQ.notifyDataSetChanged();
        if (isPullRefreshing()) {
            ij(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.hJK.removeHeaderView(this.mNoDataView);
            this.jtQ.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.ePs.getPageContext());
        this.hJK.removeHeaderView(this.mNoDataView);
        this.hJK.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void czk() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.ePs.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.ePs.closeLoadingDialog();
        if (str != null) {
            this.ePs.showToast(str);
        }
        if (z2) {
            czl();
        }
        this.jtQ.notifyDataSetChanged();
    }

    public void bRj() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a jtW;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.jtW = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jtW != null) {
                this.jtW.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.ePs.showToast(this.ePs.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.czo() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.jtQ.setData(aVar.czo());
            if (aVar.czo().size() == 0) {
                if (this.jtT == null) {
                    this.jtT = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jtT);
                }
                com.baidu.adp.lib.f.e.ld().postDelayed(this.jtT, 600L);
            }
        } else {
            this.ePs.showToast(str);
        }
        this.jtQ.qF(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.ePs.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aI(ArrayList<MarkData> arrayList) {
        this.jtQ.setData(arrayList);
    }

    private void czl() {
        if (this.jtR == null) {
            this.jtR = new com.baidu.tbadk.core.dialog.a(this.ePs.getPageContext().getPageActivity());
            this.jtR.vN(this.ePs.getPageContext().getString(R.string.sync_mark_fail));
            this.jtR.vO(this.ePs.getPageContext().getString(R.string.neterror));
            if (this.jtS != null) {
                this.jtR.a(this.ePs.getPageContext().getString(R.string.retry_rightnow), this.jtS);
            }
            this.jtR.b(this.ePs.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jtR.b(this.ePs.getPageContext());
            this.jtR.gX(true);
        }
        this.jtR.aST();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.isn, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        czm();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ePs.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void czm() {
        this.jtQ.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.jtR != null) {
            this.jtR.dismiss();
            this.jtR = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.jtT != null) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.jtT);
        }
    }

    public void completePullRefresh() {
        if (this.hJK != null) {
            this.hJK.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.jtU;
    }

    public void ij(boolean z) {
        this.jtU = z;
    }

    public void mD(boolean z) {
        BdListViewHelper.a(this.hkx, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
