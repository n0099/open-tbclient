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
/* loaded from: classes7.dex */
public class e {
    BaseFragmentActivity gfX;
    private View iXF;
    public BdListView jCE;
    public NavigationBarShadowView kIN;
    private d loY;
    private RelativeLayout loZ;
    private a lpc;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a lpa = null;
    a.b lpb = null;
    private boolean lpd = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.kIN != null && i == 1) {
                e.this.kIN.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.kIN != null && childAt != null && childAt.getTop() == 0) {
                    e.this.kIN.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.gfX = null;
        this.jCE = null;
        this.iXF = null;
        this.mNoDataView = null;
        this.loY = null;
        this.loZ = null;
        this.mProgressBar = null;
        this.gfX = threadFragment.getBaseFragmentActivity();
        this.kIN = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.loZ = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.gfX.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.gfX.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aY(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.loY = new d(threadFragment.getPageContext());
        this.loY.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.jCE = (BdListView) view.findViewById(R.id.list);
        this.jCE.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.iXF = new TextView(this.gfX.getActivity());
        this.iXF.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gfX.getActivity(), R.dimen.ds88)));
        this.jCE.addHeaderView(this.iXF, 0);
        this.jCE.setAdapter((ListAdapter) this.loY);
        this.jCE.setOnSrollToBottomListener(threadFragment);
        this.jCE.setOnItemClickListener(threadFragment);
        this.jCE.setOnScrollListener(this.mOnScrollListener);
        this.loY.O(threadFragment);
        this.loY.P(threadFragment);
        this.loY.Q(threadFragment);
    }

    public void b(a.b bVar) {
        this.lpb = bVar;
    }

    public void tU(boolean z) {
        this.loY.lY(z);
        this.loY.notifyDataSetChanged();
    }

    public int tV(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int tW(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int tX(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.jCE.startPullRefresh();
            return;
        }
        this.loY.setRefreshing(true);
        this.loY.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.loY.setRefreshing(true);
        if (str != null) {
            this.gfX.showToast(str);
        }
        if (aVar != null) {
            if (aVar.dfH() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.dfH() < 20) {
                this.loY.setHasMore(false);
                this.loY.tT(true);
            } else {
                this.loY.setHasMore(true);
                this.loY.tT(true);
            }
            this.loY.setData(aVar.dfG());
            a(aVar, z);
        }
        this.loY.setRefreshing(false);
        this.loY.notifyDataSetChanged();
        if (isPullRefreshing()) {
            le(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.jCE.removeHeaderView(this.mNoDataView);
            this.loY.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.gfX.getPageContext());
        this.jCE.removeHeaderView(this.mNoDataView);
        this.jCE.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void dfC() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.gfX.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.gfX.closeLoadingDialog();
        if (str != null) {
            this.gfX.showToast(str);
        }
        if (z2) {
            dfD();
        }
        this.loY.notifyDataSetChanged();
    }

    public void cxm() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes7.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a lpf;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.lpf = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.lpf != null) {
                this.lpf.q(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.gfX.showToast(this.gfX.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.dfG() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.loY.setData(aVar.dfG());
            if (aVar.dfG().size() == 0) {
                if (this.lpc == null) {
                    this.lpc = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lpc);
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(this.lpc, 600L);
            }
        } else {
            this.gfX.showToast(str);
        }
        this.loY.tT(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.gfX.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aT(ArrayList<MarkData> arrayList) {
        this.loY.setData(arrayList);
    }

    private void dfD() {
        if (this.lpa == null) {
            this.lpa = new com.baidu.tbadk.core.dialog.a(this.gfX.getPageContext().getPageActivity());
            this.lpa.Ac(this.gfX.getPageContext().getString(R.string.sync_mark_fail));
            this.lpa.Ad(this.gfX.getPageContext().getString(R.string.neterror));
            if (this.lpb != null) {
                this.lpa.a(this.gfX.getPageContext().getString(R.string.retry_rightnow), this.lpb);
            }
            this.lpa.b(this.gfX.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lpa.b(this.gfX.getPageContext());
            this.lpa.jE(true);
        }
        this.lpa.bqe();
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.loZ, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        dfE();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gfX.getPageContext(), i);
            ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
    }

    public void dfE() {
        this.loY.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.lpa != null) {
            this.lpa.dismiss();
            this.lpa = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.lpc != null) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(this.lpc);
        }
        if (this.loY != null) {
            this.loY.onDestroy();
        }
    }

    public void completePullRefresh() {
        if (this.jCE != null) {
            this.jCE.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.lpd;
    }

    public void le(boolean z) {
        this.lpd = z;
    }

    public void qe(boolean z) {
        BdListViewHelper.a(this.iXF, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
