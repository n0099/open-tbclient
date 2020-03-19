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
    BaseFragmentActivity ebb;
    public BdListView gJU;
    private View gmz;
    public NavigationBarShadowView hQm;
    private RelativeLayout htL;
    private d iuE;
    private a iuH;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;
    private com.baidu.tbadk.core.dialog.a iuF = null;
    a.b iuG = null;
    private boolean iuI = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.hQm != null && i == 1) {
                e.this.hQm.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.hQm != null && childAt != null && childAt.getTop() == 0) {
                    e.this.hQm.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.ebb = null;
        this.gJU = null;
        this.gmz = null;
        this.mNoDataView = null;
        this.iuE = null;
        this.htL = null;
        this.mProgressBar = null;
        this.ebb = threadFragment.getBaseFragmentActivity();
        this.hQm = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.htL = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.ebb.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.ebb.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aF(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.iuE = new d(threadFragment.getPageContext());
        this.iuE.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.gJU = (BdListView) view.findViewById(R.id.list);
        this.gJU.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.gmz = new TextView(this.ebb.getActivity());
        this.gmz.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.ebb.getActivity(), R.dimen.ds88)));
        this.gJU.addHeaderView(this.gmz, 0);
        this.gJU.setAdapter((ListAdapter) this.iuE);
        this.gJU.setOnSrollToBottomListener(threadFragment);
        this.gJU.setOnItemClickListener(threadFragment);
        this.gJU.setOnScrollListener(this.mOnScrollListener);
        this.iuE.J(threadFragment);
        this.iuE.K(threadFragment);
        this.iuE.L(threadFragment);
    }

    public void d(a.b bVar) {
        this.iuG = bVar;
    }

    public void pf(boolean z) {
        this.iuE.hD(z);
        this.iuE.notifyDataSetChanged();
    }

    public int pg(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int ph(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int pi(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.gJU.startPullRefresh();
            return;
        }
        this.iuE.setRefreshing(true);
        this.iuE.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.iuE.setRefreshing(true);
        if (str != null) {
            this.ebb.showToast(str);
        }
        if (aVar != null) {
            if (aVar.cii() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.cii() < 20) {
                this.iuE.setHasMore(false);
                this.iuE.pe(true);
            } else {
                this.iuE.setHasMore(true);
                this.iuE.pe(true);
            }
            this.iuE.setData(aVar.cih());
            a(aVar, z);
        }
        this.iuE.setRefreshing(false);
        this.iuE.notifyDataSetChanged();
        if (isPullRefreshing()) {
            gP(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.gJU.removeHeaderView(this.mNoDataView);
            this.iuE.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.ebb.getPageContext());
        this.gJU.removeHeaderView(this.mNoDataView);
        this.gJU.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void cid() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.ebb.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.ebb.closeLoadingDialog();
        if (str != null) {
            this.ebb.showToast(str);
        }
        if (z2) {
            cie();
        }
        this.iuE.notifyDataSetChanged();
    }

    public void bAo() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a iuK;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.iuK = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.iuK != null) {
                this.iuK.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.ebb.showToast(this.ebb.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.cih() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.iuE.setData(aVar.cih());
            if (aVar.cih().size() == 0) {
                if (this.iuH == null) {
                    this.iuH = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iuH);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.iuH, 600L);
            }
        } else {
            this.ebb.showToast(str);
        }
        this.iuE.pe(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.ebb.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aG(ArrayList<MarkData> arrayList) {
        this.iuE.setData(arrayList);
    }

    private void cie() {
        if (this.iuF == null) {
            this.iuF = new com.baidu.tbadk.core.dialog.a(this.ebb.getPageContext().getPageActivity());
            this.iuF.sR(this.ebb.getPageContext().getString(R.string.sync_mark_fail));
            this.iuF.sS(this.ebb.getPageContext().getString(R.string.neterror));
            if (this.iuG != null) {
                this.iuF.a(this.ebb.getPageContext().getString(R.string.retry_rightnow), this.iuG);
            }
            this.iuF.b(this.ebb.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iuF.b(this.ebb.getPageContext());
            this.iuF.fI(true);
        }
        this.iuF.aEG();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.htL, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        cif();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ebb.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void cif() {
        this.iuE.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.iuF != null) {
            this.iuF.dismiss();
            this.iuF = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.iuH != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.iuH);
        }
    }

    public void completePullRefresh() {
        if (this.gJU != null) {
            this.gJU.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.iuI;
    }

    public void gP(boolean z) {
        this.iuI = z;
    }

    public void ld(boolean z) {
        BdListViewHelper.a(this.gmz, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
