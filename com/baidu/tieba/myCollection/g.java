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
    BaseFragmentActivity beb;
    private View cWe;
    private BdListView dqo;
    private e eUk;
    private com.baidu.tbadk.core.dialog.a eUl = null;
    a.b eUm = null;
    private boolean eUn = false;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.f mPullView;

    public g(ThreadFragment threadFragment, View view2) {
        this.beb = null;
        this.dqo = null;
        this.cWe = null;
        this.mNoDataView = null;
        this.eUk = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.beb = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view2.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view2.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.beb.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.beb.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.C(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.eUk = new e(threadFragment.getPageContext());
        this.eUk.notifyDataSetChanged();
        this.mPullView = new com.baidu.tbadk.core.view.f(threadFragment.getPageContext());
        this.dqo = (BdListView) view2.findViewById(d.g.list);
        this.dqo.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.cWe = new TextView(this.beb.getActivity());
        this.cWe.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.beb.getActivity(), d.e.ds88)));
        this.dqo.addHeaderView(this.cWe, 0);
        this.dqo.setAdapter((ListAdapter) this.eUk);
        this.dqo.setOnSrollToBottomListener(threadFragment);
        this.dqo.setOnItemClickListener(threadFragment);
        this.eUk.z(threadFragment);
        this.eUk.A(threadFragment);
        this.eUk.B(threadFragment);
    }

    public void c(a.b bVar) {
        this.eUm = bVar;
    }

    public void iU(boolean z) {
        this.eUk.co(z);
        this.eUk.notifyDataSetChanged();
    }

    public int iV(boolean z) {
        return z ? d.g.share_lv_markitem_delete : d.g.home_lv_markitem_delete;
    }

    public int iW(boolean z) {
        return z ? d.g.share_lv_markitem_userinfo : d.g.home_lv_markitem_userinfo;
    }

    public int iX(boolean z) {
        return z ? d.g.share_mark_item_state : d.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.dqo.startPullRefresh();
            return;
        }
        this.eUk.setRefreshing(true);
        this.eUk.notifyDataSetChanged();
    }

    public void atL() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.eUk.setRefreshing(true);
        if (str != null) {
            this.beb.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aSZ() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aSZ() < 20) {
                this.eUk.setHasMore(false);
                this.eUk.iT(true);
            } else {
                this.eUk.setHasMore(true);
                this.eUk.iT(true);
            }
            this.eUk.setData(aVar.aSY());
            a(aVar, z);
        }
        this.eUk.setRefreshing(false);
        this.eUk.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bL(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dqo.removeHeaderView(this.mNoDataView);
            this.eUk.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.beb.getPageContext());
        this.dqo.removeHeaderView(this.mNoDataView);
        this.dqo.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aSW() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.beb.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.beb.closeLoadingDialog();
        if (str != null) {
            this.beb.showToast(str);
        }
        if (z2) {
            aSN();
        }
        this.eUk.notifyDataSetChanged();
    }

    public void alR() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.beb.showToast(this.beb.getPageContext().getString(d.k.delete_success));
            if (aVar == null || aVar.aSY() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aSY().size() == 0) {
                aVar.d(true);
            } else {
                this.eUk.setData(aVar.aSY());
            }
        } else {
            this.beb.showToast(str);
        }
        this.eUk.iT(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.beb.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.eUk.setData(arrayList);
    }

    private void aSN() {
        if (this.eUl == null) {
            this.eUl = new com.baidu.tbadk.core.dialog.a(this.beb.getPageContext().getPageActivity());
            this.eUl.db(this.beb.getPageContext().getString(d.k.sync_mark_fail));
            this.eUl.dc(this.beb.getPageContext().getString(d.k.neterror));
            if (this.eUm != null) {
                this.eUl.a(this.beb.getPageContext().getString(d.k.retry_rightnow), this.eUm);
            }
            this.eUl.b(this.beb.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.eUl.b(this.beb.getPageContext());
            this.eUl.as(true);
        }
        this.eUl.tC();
    }

    public void onChangeSkinType(int i) {
        ak.j(this.mParent, d.C0126d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        aSO();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.beb.getPageContext(), i);
            ak.j(this.mNoDataView, d.C0126d.common_color_10076);
        }
    }

    public void aSO() {
        this.eUk.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.eUl != null) {
            this.eUl.dismiss();
            this.eUl = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.dqo != null) {
            this.dqo.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.eUn;
    }

    public void bL(boolean z) {
        this.eUn = z;
    }

    public void fm(boolean z) {
        BdListViewHelper.a(this.cWe, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
