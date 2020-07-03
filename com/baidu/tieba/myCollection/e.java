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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class e {
    BaseFragmentActivity eZO;
    public BdListView hXJ;
    private View hwP;
    private RelativeLayout iKg;
    private d jMn;
    private a jMq;
    public NavigationBarShadowView jgG;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a jMo = null;
    a.b jMp = null;
    private boolean jMr = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.jgG != null && i == 1) {
                e.this.jgG.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.jgG != null && childAt != null && childAt.getTop() == 0) {
                    e.this.jgG.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.eZO = null;
        this.hXJ = null;
        this.hwP = null;
        this.mNoDataView = null;
        this.jMn = null;
        this.iKg = null;
        this.mProgressBar = null;
        this.eZO = threadFragment.getBaseFragmentActivity();
        this.jgG = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.iKg = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.eZO.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.eZO.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aP(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.jMn = new d(threadFragment.getPageContext());
        this.jMn.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.hXJ = (BdListView) view.findViewById(R.id.list);
        this.hXJ.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.hwP = new TextView(this.eZO.getActivity());
        this.hwP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.eZO.getActivity(), R.dimen.ds88)));
        this.hXJ.addHeaderView(this.hwP, 0);
        this.hXJ.setAdapter((ListAdapter) this.jMn);
        this.hXJ.setOnSrollToBottomListener(threadFragment);
        this.hXJ.setOnItemClickListener(threadFragment);
        this.hXJ.setOnScrollListener(this.mOnScrollListener);
        this.jMn.L(threadFragment);
        this.jMn.M(threadFragment);
        this.jMn.N(threadFragment);
    }

    public void d(a.b bVar) {
        this.jMp = bVar;
    }

    public void qQ(boolean z) {
        this.jMn.jk(z);
        this.jMn.notifyDataSetChanged();
    }

    public int qR(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int qS(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int qT(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.hXJ.startPullRefresh();
            return;
        }
        this.jMn.setRefreshing(true);
        this.jMn.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.jMn.setRefreshing(true);
        if (str != null) {
            this.eZO.showToast(str);
        }
        if (aVar != null) {
            if (aVar.cDD() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.cDD() < 20) {
                this.jMn.setHasMore(false);
                this.jMn.qP(true);
            } else {
                this.jMn.setHasMore(true);
                this.jMn.qP(true);
            }
            this.jMn.setData(aVar.cDC());
            a(aVar, z);
        }
        this.jMn.setRefreshing(false);
        this.jMn.notifyDataSetChanged();
        if (isPullRefreshing()) {
            is(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.hXJ.removeHeaderView(this.mNoDataView);
            this.jMn.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.eZO.getPageContext());
        this.hXJ.removeHeaderView(this.mNoDataView);
        this.hXJ.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void cDy() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.eZO.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.eZO.closeLoadingDialog();
        if (str != null) {
            this.eZO.showToast(str);
        }
        if (z2) {
            cDz();
        }
        this.jMn.notifyDataSetChanged();
    }

    public void bUh() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a jMt;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.jMt = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.jMt != null) {
                this.jMt.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.eZO.showToast(this.eZO.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.cDC() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.jMn.setData(aVar.cDC());
            if (aVar.cDC().size() == 0) {
                if (this.jMq == null) {
                    this.jMq = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jMq);
                }
                com.baidu.adp.lib.f.e.lt().postDelayed(this.jMq, 600L);
            }
        } else {
            this.eZO.showToast(str);
        }
        this.jMn.qP(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eZO.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aJ(ArrayList<MarkData> arrayList) {
        this.jMn.setData(arrayList);
    }

    private void cDz() {
        if (this.jMo == null) {
            this.jMo = new com.baidu.tbadk.core.dialog.a(this.eZO.getPageContext().getPageActivity());
            this.jMo.wd(this.eZO.getPageContext().getString(R.string.sync_mark_fail));
            this.jMo.we(this.eZO.getPageContext().getString(R.string.neterror));
            if (this.jMp != null) {
                this.jMo.a(this.eZO.getPageContext().getString(R.string.retry_rightnow), this.jMp);
            }
            this.jMo.b(this.eZO.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jMo.b(this.eZO.getPageContext());
            this.jMo.hg(true);
        }
        this.jMo.aUN();
    }

    public void onChangeSkinType(int i) {
        an.setBackgroundColor(this.iKg, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        cDA();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eZO.getPageContext(), i);
            an.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void cDA() {
        this.jMn.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.jMo != null) {
            this.jMo.dismiss();
            this.jMo = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.jMq != null) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.jMq);
        }
    }

    public void completePullRefresh() {
        if (this.hXJ != null) {
            this.hXJ.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.jMr;
    }

    public void is(boolean z) {
        this.jMr = z;
    }

    public void mO(boolean z) {
        BdListViewHelper.a(this.hwP, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
