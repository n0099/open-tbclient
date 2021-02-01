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
/* loaded from: classes8.dex */
public class f {
    BaseFragmentActivity gin;
    public BdListView jIi;
    private View jdm;
    public NavigationBarShadowView kQQ;
    private e lxc;
    private RelativeLayout lxd;
    private a lxg;
    private NoDataView mNoDataView;
    private ProgressBar mProgressBar;
    private g mPullView;
    private com.baidu.tbadk.core.dialog.a lxe = null;
    a.b lxf = null;
    private boolean lxh = false;
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.myCollection.f.1
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (f.this.kQQ != null && i == 1) {
                f.this.kQQ.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i == 0) {
                View childAt = absListView.getChildAt(0);
                if (f.this.kQQ != null && childAt != null && childAt.getTop() == 0) {
                    f.this.kQQ.hide();
                }
            }
        }
    };

    public f(ThreadFragment threadFragment, View view) {
        this.gin = null;
        this.jIi = null;
        this.jdm = null;
        this.mNoDataView = null;
        this.lxc = null;
        this.lxd = null;
        this.mProgressBar = null;
        this.gin = threadFragment.getBaseFragmentActivity();
        this.kQQ = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_collect);
        this.mProgressBar = (ProgressBar) view.findViewById(R.id.progress);
        this.lxd = (RelativeLayout) view.findViewById(R.id.parent);
        this.mNoDataView = NoDataViewFactory.a(this.gin.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.COLLECTION, l.getDimens(this.gin.getPageContext().getPageActivity(), R.dimen.ds222)), NoDataViewFactory.d.aV(R.string.mark_nodata, R.string.mark_nodata_2), null);
        this.lxc = new e(threadFragment.getPageContext());
        this.lxc.notifyDataSetChanged();
        this.mPullView = new g(threadFragment.getPageContext());
        this.jIi = (BdListView) view.findViewById(R.id.list);
        this.jIi.setPullRefresh(this.mPullView);
        this.mPullView.setListPullRefreshListener(threadFragment);
        this.jdm = new TextView(this.gin.getActivity());
        this.jdm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.getDimens(this.gin.getActivity(), R.dimen.ds88)));
        this.jIi.addHeaderView(this.jdm, 0);
        this.jIi.setAdapter((ListAdapter) this.lxc);
        this.jIi.setOnSrollToBottomListener(threadFragment);
        this.jIi.setOnItemClickListener(threadFragment);
        this.jIi.setOnScrollListener(this.mOnScrollListener);
        this.lxc.O(threadFragment);
        this.lxc.P(threadFragment);
        this.lxc.Q(threadFragment);
    }

    public void b(a.b bVar) {
        this.lxf = bVar;
    }

    public void uh(boolean z) {
        this.lxc.mc(z);
        this.lxc.notifyDataSetChanged();
    }

    public int ui(boolean z) {
        return z ? R.id.share_lv_markitem_delete : R.id.home_lv_markitem_delete;
    }

    public int uj(boolean z) {
        return z ? R.id.share_lv_markitem_userinfo : R.id.home_lv_markitem_userinfo;
    }

    public int uk(boolean z) {
        return z ? R.id.share_mark_item_state : R.id.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.jIi.startPullRefresh();
            return;
        }
        this.lxc.setRefreshing(true);
        this.lxc.notifyDataSetChanged();
    }

    public void hideLoading() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.lxc.setRefreshing(true);
        if (str != null) {
            this.gin.showToast(str);
        }
        if (aVar != null) {
            if (aVar.dhI() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.dhI() < 20) {
                this.lxc.setHasMore(false);
                this.lxc.ug(true);
            } else {
                this.lxc.setHasMore(true);
                this.lxc.ug(true);
            }
            this.lxc.setData(aVar.dhH());
            a(aVar, z);
        }
        this.lxc.setRefreshing(false);
        this.lxc.notifyDataSetChanged();
        if (isPullRefreshing()) {
            lh(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.jIi.removeHeaderView(this.mNoDataView);
            this.lxc.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.gin.getPageContext());
        this.jIi.removeHeaderView(this.mNoDataView);
        this.jIi.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void dhD() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.gin.getPageContext());
        }
    }

    public void b(boolean z, String str, boolean z2) {
        this.gin.closeLoadingDialog();
        if (str != null) {
            this.gin.showToast(str);
        }
        if (z2) {
            dhE();
        }
        this.lxc.notifyDataSetChanged();
    }

    public void cyx() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes8.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a lxj;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.lxj = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.lxj != null) {
                this.lxj.p(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.gin.showToast(this.gin.getPageContext().getString(R.string.delete_success));
            if (aVar == null || aVar.dhH() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.lxc.setData(aVar.dhH());
            if (aVar.dhH().size() == 0) {
                if (this.lxg == null) {
                    this.lxg = new a(aVar);
                } else {
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lxg);
                }
                com.baidu.adp.lib.f.e.mA().postDelayed(this.lxg, 600L);
            }
        } else {
            this.gin.showToast(str);
        }
        this.lxc.ug(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.gin.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void aS(ArrayList<MarkData> arrayList) {
        this.lxc.setData(arrayList);
    }

    private void dhE() {
        if (this.lxe == null) {
            this.lxe = new com.baidu.tbadk.core.dialog.a(this.gin.getPageContext().getPageActivity());
            this.lxe.At(this.gin.getPageContext().getString(R.string.sync_mark_fail));
            this.lxe.Au(this.gin.getPageContext().getString(R.string.neterror));
            if (this.lxf != null) {
                this.lxe.a(this.gin.getPageContext().getString(R.string.retry_rightnow), this.lxf);
            }
            this.lxe.b(this.gin.getPageContext().getString(R.string.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.f.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lxe.b(this.gin.getPageContext());
            this.lxe.jG(true);
        }
        this.lxe.bqx();
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this.lxd, R.color.CAM_X0201);
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        dhF();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gin.getPageContext(), i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
    }

    public void dhF() {
        this.lxc.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.lxe != null) {
            this.lxe.dismiss();
            this.lxe = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.lxg != null) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.lxg);
        }
        if (this.lxc != null) {
            this.lxc.onDestroy();
        }
    }

    public void completePullRefresh() {
        if (this.jIi != null) {
            this.jIi.completePullRefreshPostDelayed(0L);
        }
    }

    public boolean isPullRefreshing() {
        return this.lxh;
    }

    public void lh(boolean z) {
        this.lxh = z;
    }

    public void qo(boolean z) {
        BdListViewHelper.a(this.jdm, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
