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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    BaseFragmentActivity bml;
    private View dfr;
    public BdListView dzA;
    private e ffC;
    private com.baidu.tbadk.core.dialog.a ffD = null;
    a.b ffE = null;
    private boolean ffF = false;
    private a fge;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private com.baidu.tbadk.core.view.g mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.bml = null;
        this.dzA = null;
        this.dfr = null;
        this.mNoDataView = null;
        this.ffC = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bml = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bml.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.bml.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.D(d.k.mark_nodata, d.k.mark_nodata_2), null);
        this.ffC = new e(threadFragment.getPageContext());
        this.ffC.notifyDataSetChanged();
        this.mPullView = new com.baidu.tbadk.core.view.g(threadFragment.getPageContext());
        this.dzA = (BdListView) view.findViewById(d.g.list);
        this.dzA.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.dfr = new TextView(this.bml.getActivity());
        this.dfr.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.e(this.bml.getActivity(), d.e.ds88)));
        this.dzA.addHeaderView(this.dfr, 0);
        this.dzA.setAdapter((ListAdapter) this.ffC);
        this.dzA.setOnSrollToBottomListener(threadFragment);
        this.dzA.setOnItemClickListener(threadFragment);
        this.ffC.z(threadFragment);
        this.ffC.A(threadFragment);
        this.ffC.B(threadFragment);
    }

    public void c(a.b bVar) {
        this.ffE = bVar;
    }

    public void ja(boolean z) {
        this.ffC.ct(z);
        this.ffC.notifyDataSetChanged();
    }

    public int jb(boolean z) {
        return z ? d.g.share_lv_markitem_delete : d.g.home_lv_markitem_delete;
    }

    public int jc(boolean z) {
        return z ? d.g.share_lv_markitem_userinfo : d.g.home_lv_markitem_userinfo;
    }

    public int jd(boolean z) {
        return z ? d.g.share_mark_item_state : d.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.dzA.startPullRefresh();
            return;
        }
        this.ffC.setRefreshing(true);
        this.ffC.notifyDataSetChanged();
    }

    public void axY() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.ffC.setRefreshing(true);
        if (str != null) {
            this.bml.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aXV() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aXV() < 20) {
                this.ffC.setHasMore(false);
                this.ffC.iZ(true);
            } else {
                this.ffC.setHasMore(true);
                this.ffC.iZ(true);
            }
            this.ffC.setData(aVar.aXU());
            a(aVar, z);
        }
        this.ffC.setRefreshing(false);
        this.ffC.notifyDataSetChanged();
        if (isPullRefreshing()) {
            bP(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dzA.removeHeaderView(this.mNoDataView);
            this.ffC.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bml.getPageContext());
        this.dzA.removeHeaderView(this.mNoDataView);
        this.dzA.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aXS() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bml.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bml.closeLoadingDialog();
        if (str != null) {
            this.bml.showToast(str);
        }
        if (z2) {
            aXJ();
        }
        this.ffC.notifyDataSetChanged();
    }

    public void apX() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a fgg;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.fgg = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.fgg != null) {
                this.fgg.d(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bml.showToast(this.bml.getPageContext().getString(d.k.delete_success));
            if (aVar == null || aVar.aXU() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.ffC.setData(aVar.aXU());
            if (aVar.aXU().size() == 0) {
                if (this.fge == null) {
                    this.fge = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.im().removeCallbacks(this.fge);
                }
                com.baidu.adp.lib.g.e.im().postDelayed(this.fge, 600L);
            }
        } else {
            this.bml.showToast(str);
        }
        this.ffC.iZ(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bml.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ai(ArrayList<MarkData> arrayList) {
        this.ffC.setData(arrayList);
    }

    private void aXJ() {
        if (this.ffD == null) {
            this.ffD = new com.baidu.tbadk.core.dialog.a(this.bml.getPageContext().getPageActivity());
            this.ffD.dA(this.bml.getPageContext().getString(d.k.sync_mark_fail));
            this.ffD.dB(this.bml.getPageContext().getString(d.k.neterror));
            if (this.ffE != null) {
                this.ffD.a(this.bml.getPageContext().getString(d.k.retry_rightnow), this.ffE);
            }
            this.ffD.b(this.bml.getPageContext().getString(d.k.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ffD.b(this.bml.getPageContext());
            this.ffD.av(true);
        }
        this.ffD.xa();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mParent, d.C0141d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        aXK();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bml.getPageContext(), i);
            al.j(this.mNoDataView, d.C0141d.common_color_10076);
        }
    }

    public void aXK() {
        this.ffC.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.ffD != null) {
            this.ffD.dismiss();
            this.ffD = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.fge != null) {
            com.baidu.adp.lib.g.e.im().removeCallbacks(this.fge);
        }
    }

    public void completePullRefresh() {
        if (this.dzA != null) {
            this.dzA.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.ffF;
    }

    public void bP(boolean z) {
        this.ffF = z;
    }

    public void fq(boolean z) {
        BdListViewHelper.a(this.dfr, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
