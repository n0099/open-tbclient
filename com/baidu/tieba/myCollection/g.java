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
    private View cVa;
    private BdListView dpj;
    private e eTg;
    private com.baidu.tbadk.core.dialog.a eTh = null;
    a.b eTi = null;
    private boolean eTj = false;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;

    public g(ThreadFragment threadFragment, View view2) {
        this.bea = null;
        this.dpj = null;
        this.cVa = null;
        this.mNoDataView = null;
        this.eTg = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bea = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view2.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view2.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bea.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.bea.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.C(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.eTg = new e(threadFragment.getPageContext());
        this.eTg.notifyDataSetChanged();
        this.mPullView = new com.baidu.tbadk.core.view.f(threadFragment.getPageContext());
        this.dpj = (BdListView) view2.findViewById(d.g.list);
        this.dpj.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.cVa = new TextView(this.bea.getActivity());
        this.cVa.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.bea.getActivity(), d.e.ds88)));
        this.dpj.addHeaderView(this.cVa, 0);
        this.dpj.setAdapter((ListAdapter) this.eTg);
        this.dpj.setOnSrollToBottomListener(threadFragment);
        this.dpj.setOnItemClickListener(threadFragment);
        this.eTg.z(threadFragment);
        this.eTg.A(threadFragment);
        this.eTg.B(threadFragment);
    }

    public void c(a.b bVar) {
        this.eTi = bVar;
    }

    public void iT(boolean z) {
        this.eTg.co(z);
        this.eTg.notifyDataSetChanged();
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
            this.dpj.startPullRefresh();
            return;
        }
        this.eTg.setRefreshing(true);
        this.eTg.notifyDataSetChanged();
    }

    public void atM() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.eTg.setRefreshing(true);
        if (str != null) {
            this.bea.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aSZ() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aSZ() < 20) {
                this.eTg.setHasMore(false);
                this.eTg.iS(true);
            } else {
                this.eTg.setHasMore(true);
                this.eTg.iS(true);
            }
            this.eTg.setData(aVar.aSY());
            a(aVar, z);
        }
        this.eTg.setRefreshing(false);
        this.eTg.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bL(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dpj.removeHeaderView(this.mNoDataView);
            this.eTg.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bea.getPageContext());
        this.dpj.removeHeaderView(this.mNoDataView);
        this.dpj.addHeaderView(this.mNoDataView);
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
        this.eTg.notifyDataSetChanged();
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
                this.eTg.setData(aVar.aSY());
            }
        } else {
            this.bea.showToast(str);
        }
        this.eTg.iS(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bea.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.eTg.setData(arrayList);
    }

    private void aSN() {
        if (this.eTh == null) {
            this.eTh = new com.baidu.tbadk.core.dialog.a(this.bea.getPageContext().getPageActivity());
            this.eTh.db(this.bea.getPageContext().getString(d.k.sync_mark_fail));
            this.eTh.dc(this.bea.getPageContext().getString(d.k.neterror));
            if (this.eTi != null) {
                this.eTh.a(this.bea.getPageContext().getString(d.k.retry_rightnow), this.eTi);
            }
            this.eTh.b(this.bea.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eTh.b(this.bea.getPageContext());
            this.eTh.as(true);
        }
        this.eTh.tD();
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mParent, d.C0126d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        aSO();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bea.getPageContext(), i);
            ak.j(this.mNoDataView, d.C0126d.common_color_10076);
        }
    }

    public void aSO() {
        this.eTg.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.eTh != null) {
            this.eTh.dismiss();
            this.eTh = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dpj != null) {
            this.dpj.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.eTj;
    }

    public void bL(boolean z) {
        this.eTj = z;
    }

    public void fl(boolean z) {
        BdListViewHelper.a(this.cVa, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
