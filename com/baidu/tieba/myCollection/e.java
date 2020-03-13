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
    BaseFragmentActivity eaL;
    public BdListView gIP;
    private View glR;
    public NavigationBarShadowView hOM;
    private RelativeLayout hsl;
    private d ite;
    private a ith;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private h mPullView;
    private com.baidu.tbadk.core.dialog.a itf = null;
    a.b itg = null;
    private boolean iti = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.e.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (e.this.hOM != null && i == 1) {
                e.this.hOM.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (e.this.hOM != null && childAt != null && childAt.getTop() == 0) {
                    e.this.hOM.hide();
                }
            }
        }
    };

    public e(ThreadFragment threadFragment, View view) {
        this.eaL = null;
        this.gIP = null;
        this.glR = null;
        this.mNoDataView = null;
        this.ite = null;
        this.hsl = null;
        this.mProgressBar = null;
        this.eaL = threadFragment.getBaseFragmentActivity();
        this.hOM = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.hsl = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.eaL.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.eaL.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aF(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.ite = new d(threadFragment.getPageContext());
        this.ite.notifyDataSetChanged();
        this.mPullView = new h(threadFragment.getPageContext());
        this.gIP = (BdListView) view.findViewById(R.id.list);
        this.gIP.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.glR = new TextView(this.eaL.getActivity());
        this.glR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.eaL.getActivity(), R.dimen.ds88)));
        this.gIP.addHeaderView(this.glR, 0);
        this.gIP.setAdapter((ListAdapter) this.ite);
        this.gIP.setOnSrollToBottomListener(threadFragment);
        this.gIP.setOnItemClickListener(threadFragment);
        this.gIP.setOnScrollListener(this.mOnScrollListener);
        this.ite.J(threadFragment);
        this.ite.K(threadFragment);
        this.ite.L(threadFragment);
    }

    public void d(a.b bVar) {
        this.itg = bVar;
    }

    public void oZ(boolean z) {
        this.ite.hC(z);
        this.ite.notifyDataSetChanged();
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
            this.gIP.startPullRefresh();
            return;
        }
        this.ite.setRefreshing(true);
        this.ite.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.ite.setRefreshing(true);
        if (str != null) {
            this.eaL.showToast(str);
        }
        if (aVar != null) {
            if (aVar.chO() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.chO() < 20) {
                this.ite.setHasMore(false);
                this.ite.oY(true);
            } else {
                this.ite.setHasMore(true);
                this.ite.oY(true);
            }
            this.ite.setData(aVar.chN());
            a(aVar, z);
        }
        this.ite.setRefreshing(false);
        this.ite.notifyDataSetChanged();
        if (isPullRefreshing()) {
            gO(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.gIP.removeHeaderView(this.mNoDataView);
            this.ite.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.eaL.getPageContext());
        this.gIP.removeHeaderView(this.mNoDataView);
        this.gIP.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void chJ() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.eaL.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.eaL.closeLoadingDialog();
        if (str != null) {
            this.eaL.showToast(str);
        }
        if (z2) {
            chK();
        }
        this.ite.notifyDataSetChanged();
    }

    public void bAi() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes11.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a itk;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.itk = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.itk != null) {
                this.itk.j(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.eaL.showToast(this.eaL.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.chN() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.ite.setData(aVar.chN());
            if (aVar.chN().size() == 0) {
                if (this.ith == null) {
                    this.ith = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ith);
                }
                com.baidu.adp.lib.f.e.gx().postDelayed(this.ith, 600L);
            }
        } else {
            this.eaL.showToast(str);
        }
        this.ite.oY(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.eaL.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aG(ArrayList<MarkData> arrayList) {
        this.ite.setData(arrayList);
    }

    private void chK() {
        if (this.itf == null) {
            this.itf = new com.baidu.tbadk.core.dialog.a(this.eaL.getPageContext().getPageActivity());
            this.itf.sR(this.eaL.getPageContext().getString(R.string.sync_mark_fail));
            this.itf.sS(this.eaL.getPageContext().getString(R.string.neterror));
            if (this.itg != null) {
                this.itf.a(this.eaL.getPageContext().getString(R.string.retry_rightnow), this.itg);
            }
            this.itf.b(this.eaL.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.itf.b(this.eaL.getPageContext());
            this.itf.fH(true);
        }
        this.itf.aEC();
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.hsl, R.color.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        chL();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.eaL.getPageContext(), i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
    }

    public void chL() {
        this.ite.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.itf != null) {
            this.itf.dismiss();
            this.itf = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.ith != null) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.ith);
        }
    }

    public void completePullRefresh() {
        if (this.gIP != null) {
            this.gIP.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.iti;
    }

    public void gO(boolean z) {
        this.iti = z;
    }

    public void kY(boolean z) {
        BdListViewHelper.a(this.glR, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
