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
    BaseFragmentActivity eay;
    public BdListView gID;
    private View glE;
    public NavigationBarShadowView hOA;
    private RelativeLayout hrZ;
    private d isS;
    private a isV;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;
    private com.baidu.tbadk.core.dialog.a isT = null;
    a.b isU = null;
    private boolean isW = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.hOA != null && i == 1) {
                e.this.hOA.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.hOA != null && childAt != null && childAt.getTop() == 0) {
                    e.this.hOA.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.eay = null;
        this.gID = null;
        this.glE = null;
        this.mNoDataView = null;
        this.isS = null;
        this.hrZ = null;
        this.mProgressBar = null;
        this.eay = threadFragment.getBaseFragmentActivity();
        this.hOA = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.hrZ = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.eay.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.eay.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aF(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.isS = new d(threadFragment.getPageContext());
        this.isS.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.gID = (BdListView) view.findViewById(R.id.list);
        this.gID.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.glE = new TextView(this.eay.getActivity());
        this.glE.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.eay.getActivity(), R.dimen.ds88)));
        this.gID.addHeaderView(this.glE, 0);
        this.gID.setAdapter((ListAdapter) this.isS);
        this.gID.setOnSrollToBottomListener(threadFragment);
        this.gID.setOnItemClickListener(threadFragment);
        this.gID.setOnScrollListener(this.mOnScrollListener);
        this.isS.J(threadFragment);
        this.isS.K(threadFragment);
        this.isS.L(threadFragment);
    }

    public void d(a.b bVar) {
        this.isU = bVar;
    }

    public void oZ(boolean z) {
        this.isS.hC(z);
        this.isS.notifyDataSetChanged();
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
            this.gID.startPullRefresh();
            return;
        }
        this.isS.setRefreshing(true);
        this.isS.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.isS.setRefreshing(true);
        if (str != null) {
            this.eay.showToast(str);
        }
        if (aVar != null) {
            if (aVar.chN() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.chN() < 20) {
                this.isS.setHasMore(false);
                this.isS.oY(true);
            } else {
                this.isS.setHasMore(true);
                this.isS.oY(true);
            }
            this.isS.setData(aVar.chM());
            a(aVar, z);
        }
        this.isS.setRefreshing(false);
        this.isS.notifyDataSetChanged();
        if (isPullRefreshing()) {
            gO(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.gID.removeHeaderView(this.mNoDataView);
            this.isS.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.eay.getPageContext());
        this.gID.removeHeaderView(this.mNoDataView);
        this.gID.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void chI() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.eay.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.eay.closeLoadingDialog();
        if (str != null) {
            this.eay.showToast(str);
        }
        if (z2) {
            chJ();
        }
        this.isS.notifyDataSetChanged();
    }

    public void bAh() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a isY;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.isY = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.isY != null) {
                this.isY.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.eay.showToast(this.eay.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.chM() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.isS.setData(aVar.chM());
            if (aVar.chM().size() == 0) {
                if (this.isV == null) {
                    this.isV = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.isV);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.isV, 600L);
            }
        } else {
            this.eay.showToast(str);
        }
        this.isS.oY(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eay.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aG(ArrayList<MarkData> arrayList) {
        this.isS.setData(arrayList);
    }

    private void chJ() {
        if (this.isT == null) {
            this.isT = new com.baidu.tbadk.core.dialog.a(this.eay.getPageContext().getPageActivity());
            this.isT.sR(this.eay.getPageContext().getString(R.string.sync_mark_fail));
            this.isT.sS(this.eay.getPageContext().getString(R.string.neterror));
            if (this.isU != null) {
                this.isT.a(this.eay.getPageContext().getString(R.string.retry_rightnow), this.isU);
            }
            this.isT.b(this.eay.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.isT.b(this.eay.getPageContext());
            this.isT.fH(true);
        }
        this.isT.aEC();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hrZ, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        chK();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eay.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void chK() {
        this.isS.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.isT != null) {
            this.isT.dismiss();
            this.isT = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.isV != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.isV);
        }
    }

    public void completePullRefresh() {
        if (this.gID != null) {
            this.gID.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.isW;
    }

    public void gO(boolean z) {
        this.isW = z;
    }

    public void kY(boolean z) {
        BdListViewHelper.a(this.glE, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
