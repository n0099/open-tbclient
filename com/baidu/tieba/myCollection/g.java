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
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    BaseFragmentActivity bea;
    private View cUX;
    private BdListView dpg;
    private e eTd;
    private com.baidu.tbadk.core.dialog.a eTe = null;
    a.b eTf = null;
    private boolean eTg = false;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;

    public g(ThreadFragment threadFragment, View view2) {
        this.bea = null;
        this.dpg = null;
        this.cUX = null;
        this.mNoDataView = null;
        this.eTd = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bea = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view2.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view2.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bea.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.bea.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.C(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.eTd = new e(threadFragment.getPageContext());
        this.eTd.notifyDataSetChanged();
        this.mPullView = new com.baidu.tbadk.core.view.f(threadFragment.getPageContext());
        this.dpg = (BdListView) view2.findViewById(d.g.list);
        this.dpg.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.cUX = new TextView(this.bea.getActivity());
        this.cUX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.bea.getActivity(), d.e.ds88)));
        this.dpg.addHeaderView(this.cUX, 0);
        this.dpg.setAdapter((ListAdapter) this.eTd);
        this.dpg.setOnSrollToBottomListener(threadFragment);
        this.dpg.setOnItemClickListener(threadFragment);
        this.eTd.z(threadFragment);
        this.eTd.A(threadFragment);
        this.eTd.B(threadFragment);
    }

    public void c(a.b bVar) {
        this.eTf = bVar;
    }

    public void iT(boolean z) {
        this.eTd.co(z);
        this.eTd.notifyDataSetChanged();
    }

    public int iU(boolean z) {
        return z ? d.g.share_lv_markitem_delete : d.g.home_lv_markitem_delete;
    }

    public int iV(boolean z) {
        return z ? d.g.share_lv_markitem_userinfo : d.g.home_lv_markitem_userinfo;
    }

    public int iW(boolean z) {
        return z ? d.g.share_mark_item_state : d.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.dpg.startPullRefresh();
            return;
        }
        this.eTd.setRefreshing(true);
        this.eTd.notifyDataSetChanged();
    }

    public void atM() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.eTd.setRefreshing(true);
        if (str != null) {
            this.bea.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aSZ() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aSZ() < 20) {
                this.eTd.setHasMore(false);
                this.eTd.iS(true);
            } else {
                this.eTd.setHasMore(true);
                this.eTd.iS(true);
            }
            this.eTd.setData(aVar.aSY());
            a(aVar, z);
        }
        this.eTd.setRefreshing(false);
        this.eTd.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bL(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dpg.removeHeaderView(this.mNoDataView);
            this.eTd.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bea.getPageContext());
        this.dpg.removeHeaderView(this.mNoDataView);
        this.dpg.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aSW() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bea.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bea.closeLoadingDialog();
        if (str != null) {
            this.bea.showToast(str);
        }
        if (z2) {
            aSN();
        }
        this.eTd.notifyDataSetChanged();
    }

    public void alR() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bea.showToast(this.bea.getPageContext().getString(d.k.delete_success));
            if (aVar == null || aVar.aSY() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aSY().size() == 0) {
                aVar.d(true);
            } else {
                this.eTd.setData(aVar.aSY());
            }
        } else {
            this.bea.showToast(str);
        }
        this.eTd.iS(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bea.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.eTd.setData(arrayList);
    }

    private void aSN() {
        if (this.eTe == null) {
            this.eTe = new com.baidu.tbadk.core.dialog.a(this.bea.getPageContext().getPageActivity());
            this.eTe.db(this.bea.getPageContext().getString(d.k.sync_mark_fail));
            this.eTe.dc(this.bea.getPageContext().getString(d.k.neterror));
            if (this.eTf != null) {
                this.eTe.a(this.bea.getPageContext().getString(d.k.retry_rightnow), this.eTf);
            }
            this.eTe.b(this.bea.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eTe.b(this.bea.getPageContext());
            this.eTe.as(true);
        }
        this.eTe.tD();
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mParent, d.C0126d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        aSO();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bea.getPageContext(), i);
            ak.j(this.mNoDataView, d.C0126d.common_color_10076);
        }
    }

    public void aSO() {
        this.eTd.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.eTe != null) {
            this.eTe.dismiss();
            this.eTe = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dpg != null) {
            this.dpg.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.eTg;
    }

    public void bL(boolean z) {
        this.eTg = z;
    }

    public void fl(boolean z) {
        BdListViewHelper.a(this.cUX, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
