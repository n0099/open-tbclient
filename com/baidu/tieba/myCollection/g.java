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
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    BaseFragmentActivity bui;
    public BdListView dLs;
    private View dpP;
    private a frF;
    private e frc;
    private com.baidu.tbadk.core.dialog.a frd = null;
    a.b fre = null;
    private boolean frf = false;
    private NoDataView mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public g(ThreadFragment threadFragment, View view) {
        this.bui = null;
        this.dLs = null;
        this.dpP = null;
        this.mNoDataView = null;
        this.frc = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bui = threadFragment.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(e.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(e.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bui.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.bui.getPageContext().getPageActivity(), e.C0141e.ds222)), NoDataViewFactory.d.G(e.j.mark_nodata, e.j.mark_nodata_2), null);
        this.frc = new e(threadFragment.getPageContext());
        this.frc.notifyDataSetChanged();
        this.mPullView = new k(threadFragment.getPageContext());
        this.dLs = (BdListView) view.findViewById(e.g.list);
        this.dLs.setPullRefresh(this.mPullView);
        this.mPullView.a(threadFragment);
        this.dpP = new TextView(this.bui.getActivity());
        this.dpP.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.h(this.bui.getActivity(), e.C0141e.ds88)));
        this.dLs.addHeaderView(this.dpP, 0);
        this.dLs.setAdapter((ListAdapter) this.frc);
        this.dLs.setOnSrollToBottomListener(threadFragment);
        this.dLs.setOnItemClickListener(threadFragment);
        this.frc.A(threadFragment);
        this.frc.B(threadFragment);
        this.frc.C(threadFragment);
    }

    public void c(a.b bVar) {
        this.fre = bVar;
    }

    public void jt(boolean z) {
        this.frc.cP(z);
        this.frc.notifyDataSetChanged();
    }

    public int ju(boolean z) {
        return z ? e.g.share_lv_markitem_delete : e.g.home_lv_markitem_delete;
    }

    public int jv(boolean z) {
        return z ? e.g.share_lv_markitem_userinfo : e.g.home_lv_markitem_userinfo;
    }

    public int jw(boolean z) {
        return z ? e.g.share_mark_item_state : e.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.dLs.startPullRefresh();
            return;
        }
        this.frc.setRefreshing(true);
        this.frc.notifyDataSetChanged();
    }

    public void aBo() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.frc.setRefreshing(true);
        if (str != null) {
            this.bui.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aZh() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aZh() < 20) {
                this.frc.setHasMore(false);
                this.frc.js(true);
            } else {
                this.frc.setHasMore(true);
                this.frc.js(true);
            }
            this.frc.setData(aVar.aZg());
            a(aVar, z);
        }
        this.frc.setRefreshing(false);
        this.frc.notifyDataSetChanged();
        if (isPullRefreshing()) {
            cd(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.dLs.removeHeaderView(this.mNoDataView);
            this.frc.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bui.getPageContext());
        this.dLs.removeHeaderView(this.mNoDataView);
        this.dLs.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aZe() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bui.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bui.closeLoadingDialog();
        if (str != null) {
            this.bui.showToast(str);
        }
        if (z2) {
            aYV();
        }
        this.frc.notifyDataSetChanged();
    }

    public void arG() {
        this.mProgressBar.setVisibility(0);
    }

    /* loaded from: classes3.dex */
    private static class a implements Runnable {
        com.baidu.tieba.myCollection.baseEditMark.a frH;

        public a(com.baidu.tieba.myCollection.baseEditMark.a aVar) {
            this.frH = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.frH != null) {
                this.frH.e(true);
            }
        }
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bui.showToast(this.bui.getPageContext().getString(e.j.delete_success));
            if (aVar == null || aVar.aZg() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            }
            this.frc.setData(aVar.aZg());
            if (aVar.aZg().size() == 0) {
                if (this.frF == null) {
                    this.frF = new a(aVar);
                } else {
                    com.baidu.adp.lib.g.e.jt().removeCallbacks(this.frF);
                }
                com.baidu.adp.lib.g.e.jt().postDelayed(this.frF, 600L);
            }
        } else {
            this.bui.showToast(str);
        }
        this.frc.js(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bui.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.d(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ak(ArrayList<MarkData> arrayList) {
        this.frc.setData(arrayList);
    }

    private void aYV() {
        if (this.frd == null) {
            this.frd = new com.baidu.tbadk.core.dialog.a(this.bui.getPageContext().getPageActivity());
            this.frd.dS(this.bui.getPageContext().getString(e.j.sync_mark_fail));
            this.frd.dT(this.bui.getPageContext().getString(e.j.neterror));
            if (this.fre != null) {
                this.frd.a(this.bui.getPageContext().getString(e.j.retry_rightnow), this.fre);
            }
            this.frd.b(this.bui.getPageContext().getString(e.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.g.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.frd.b(this.bui.getPageContext());
            this.frd.aF(true);
        }
        this.frd.yl();
    }

    public void onChangeSkinType(int i) {
        al.j(this.mParent, e.d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        aYW();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bui.getPageContext(), i);
            al.j(this.mNoDataView, e.d.common_color_10076);
        }
    }

    public void aYW() {
        this.frc.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.frd != null) {
            this.frd.dismiss();
            this.frd = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
        if (this.frF != null) {
            com.baidu.adp.lib.g.e.jt().removeCallbacks(this.frF);
        }
    }

    public void completePullRefresh() {
        if (this.dLs != null) {
            this.dLs.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.frf;
    }

    public void cd(boolean z) {
        this.frf = z;
    }

    public void fJ(boolean z) {
        BdListViewHelper.a(this.dpP, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
