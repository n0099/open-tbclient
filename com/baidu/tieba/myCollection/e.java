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
    BaseFragmentActivity eAO;
    private View gVF;
    public BdListView huR;
    public NavigationBarShadowView iAd;
    private RelativeLayout idy;
    private d jeJ;
    private a jeM;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;
    private com.baidu.tbadk.core.dialog.a jeK = null;
    a.b jeL = null;
    private boolean jeN = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.iAd != null && i == 1) {
                e.this.iAd.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.iAd != null && childAt != null && childAt.getTop() == 0) {
                    e.this.iAd.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.eAO = null;
        this.huR = null;
        this.gVF = null;
        this.mNoDataView = null;
        this.jeJ = null;
        this.idy = null;
        this.mProgressBar = null;
        this.eAO = threadFragment.getBaseFragmentActivity();
        this.iAd = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.idy = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.eAO.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.eAO.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aJ(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.jeJ = new d(threadFragment.getPageContext());
        this.jeJ.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.huR = (BdListView) view.findViewById(R.id.list);
        this.huR.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.gVF = new TextView(this.eAO.getActivity());
        this.gVF.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.eAO.getActivity(), R.dimen.ds88)));
        this.huR.addHeaderView(this.gVF, 0);
        this.huR.setAdapter((ListAdapter) this.jeJ);
        this.huR.setOnSrollToBottomListener(threadFragment);
        this.huR.setOnItemClickListener(threadFragment);
        this.huR.setOnScrollListener(this.mOnScrollListener);
        this.jeJ.K(threadFragment);
        this.jeJ.L(threadFragment);
        this.jeJ.M(threadFragment);
    }

    public void d(a.b bVar) {
        this.jeL = bVar;
    }

    public void qj(boolean z) {
        this.jeJ.iB(z);
        this.jeJ.notifyDataSetChanged();
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
            this.huR.startPullRefresh();
            return;
        }
        this.jeJ.setRefreshing(true);
        this.jeJ.notifyDataSetChanged();
    }

    public void asi() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.jeJ.setRefreshing(true);
        if (str != null) {
            this.eAO.showToast(str);
        }
        if (aVar != null) {
            if (aVar.csP() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.csP() < 20) {
                this.jeJ.setHasMore(false);
                this.jeJ.qi(true);
            } else {
                this.jeJ.setHasMore(true);
                this.jeJ.qi(true);
            }
            this.jeJ.setData(aVar.csO());
            a(aVar, z);
        }
        this.jeJ.setRefreshing(false);
        this.jeJ.notifyDataSetChanged();
        if (isPullRefreshing()) {
            hN(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.huR.removeHeaderView(this.mNoDataView);
            this.jeJ.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.eAO.getPageContext());
        this.huR.removeHeaderView(this.mNoDataView);
        this.huR.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void csK() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.eAO.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.eAO.closeLoadingDialog();
        if (str != null) {
            this.eAO.showToast(str);
        }
        if (z2) {
            csL();
        }
        this.jeJ.notifyDataSetChanged();
    }

    public void bKP() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a jeP;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.jeP = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jeP != null) {
                this.jeP.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.eAO.showToast(this.eAO.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.csO() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.jeJ.setData(aVar.csO());
            if (aVar.csO().size() == 0) {
                if (this.jeM == null) {
                    this.jeM = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jeM);
                }
                com.baidu.adp.lib.f.e.lb().postDelayed(this.jeM, 600L);
            }
        } else {
            this.eAO.showToast(str);
        }
        this.jeJ.qi(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eAO.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aI(ArrayList<MarkData> arrayList) {
        this.jeJ.setData(arrayList);
    }

    private void csL() {
        if (this.jeK == null) {
            this.jeK = new com.baidu.tbadk.core.dialog.a(this.eAO.getPageContext().getPageActivity());
            this.jeK.ue(this.eAO.getPageContext().getString(R.string.sync_mark_fail));
            this.jeK.uf(this.eAO.getPageContext().getString(R.string.neterror));
            if (this.jeL != null) {
                this.jeK.a(this.eAO.getPageContext().getString(R.string.retry_rightnow), this.jeL);
            }
            this.jeK.b(this.eAO.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jeK.b(this.eAO.getPageContext());
            this.jeK.gF(true);
        }
        this.jeK.aMU();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.idy, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        csM();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eAO.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void csM() {
        this.jeJ.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.jeK != null) {
            this.jeK.dismiss();
            this.jeK = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.jeM != null) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jeM);
        }
    }

    public void completePullRefresh() {
        if (this.huR != null) {
            this.huR.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.jeN;
    }

    public void hN(boolean z) {
        this.jeN = z;
    }

    public void mi(boolean z) {
        BdListViewHelper.a(this.gVF, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
