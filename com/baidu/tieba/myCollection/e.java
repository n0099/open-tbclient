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
/* loaded from: classes23.dex */
public class e {
    BaseFragmentActivity fsZ;
    private View hWY;
    public BdListView izn;
    public NavigationBarShadowView jMK;
    private RelativeLayout jnW;
    private d ksP;
    private a ksS;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a ksQ = null;
    a.b ksR = null;
    private boolean ksT = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.jMK != null && i == 1) {
                e.this.jMK.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.jMK != null && childAt != null && childAt.getTop() == 0) {
                    e.this.jMK.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.fsZ = null;
        this.izn = null;
        this.hWY = null;
        this.mNoDataView = null;
        this.ksP = null;
        this.jnW = null;
        this.mProgressBar = null;
        this.fsZ = threadFragment.getBaseFragmentActivity();
        this.jMK = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.jnW = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.fsZ.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.fsZ.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aY(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.ksP = new d(threadFragment.getPageContext());
        this.ksP.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.izn = (BdListView) view.findViewById(R.id.list);
        this.izn.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.hWY = new TextView(this.fsZ.getActivity());
        this.hWY.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.fsZ.getActivity(), R.dimen.ds88)));
        this.izn.addHeaderView(this.hWY, 0);
        this.izn.setAdapter((ListAdapter) this.ksP);
        this.izn.setOnSrollToBottomListener(threadFragment);
        this.izn.setOnItemClickListener(threadFragment);
        this.izn.setOnScrollListener(this.mOnScrollListener);
        this.ksP.M(threadFragment);
        this.ksP.N(threadFragment);
        this.ksP.O(threadFragment);
    }

    public void d(a.b bVar) {
        this.ksR = bVar;
    }

    public void sl(boolean z) {
        this.ksP.kp(z);
        this.ksP.notifyDataSetChanged();
    }

    public int sm(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int sn(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int so(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.izn.startPullRefresh();
            return;
        }
        this.ksP.setRefreshing(true);
        this.ksP.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.ksP.setRefreshing(true);
        if (str != null) {
            this.fsZ.showToast(str);
        }
        if (aVar != null) {
            if (aVar.cVH() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.cVH() < 20) {
                this.ksP.setHasMore(false);
                this.ksP.sk(true);
            } else {
                this.ksP.setHasMore(true);
                this.ksP.sk(true);
            }
            this.ksP.setData(aVar.cVG());
            a(aVar, z);
        }
        this.ksP.setRefreshing(false);
        this.ksP.notifyDataSetChanged();
        if (isPullRefreshing()) {
            jy(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.izn.removeHeaderView(this.mNoDataView);
            this.ksP.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.fsZ.getPageContext());
        this.izn.removeHeaderView(this.mNoDataView);
        this.izn.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void cVC() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.fsZ.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.fsZ.closeLoadingDialog();
        if (str != null) {
            this.fsZ.showToast(str);
        }
        if (z2) {
            cVD();
        }
        this.ksP.notifyDataSetChanged();
    }

    public void cll() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes23.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a ksV;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.ksV = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ksV != null) {
                this.ksV.o(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.fsZ.showToast(this.fsZ.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.cVG() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.ksP.setData(aVar.cVG());
            if (aVar.cVG().size() == 0) {
                if (this.ksS == null) {
                    this.ksS = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ksS);
                }
                com.baidu.adp.lib.f.e.mX().postDelayed(this.ksS, 600L);
            }
        } else {
            this.fsZ.showToast(str);
        }
        this.ksP.sk(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.fsZ.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aS(ArrayList<MarkData> arrayList) {
        this.ksP.setData(arrayList);
    }

    private void cVD() {
        if (this.ksQ == null) {
            this.ksQ = new com.baidu.tbadk.core.dialog.a(this.fsZ.getPageContext().getPageActivity());
            this.ksQ.zU(this.fsZ.getPageContext().getString(R.string.sync_mark_fail));
            this.ksQ.zV(this.fsZ.getPageContext().getString(R.string.neterror));
            if (this.ksR != null) {
                this.ksQ.a(this.fsZ.getPageContext().getString(R.string.retry_rightnow), this.ksR);
            }
            this.ksQ.b(this.fsZ.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ksQ.b(this.fsZ.getPageContext());
            this.ksQ.ie(true);
        }
        this.ksQ.bia();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.jnW, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        cVE();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fsZ.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void cVE() {
        this.ksP.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.ksQ != null) {
            this.ksQ.dismiss();
            this.ksQ = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.ksS != null) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(this.ksS);
        }
    }

    public void completePullRefresh() {
        if (this.izn != null) {
            this.izn.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.ksT;
    }

    public void jy(boolean z) {
        this.ksT = z;
    }

    public void of(boolean z) {
        BdListViewHelper.a(this.hWY, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
