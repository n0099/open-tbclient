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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h {
    BaseFragmentActivity bTU;
    private View dCl;
    private BdListView exW;
    private e fyf;
    private com.baidu.tbadk.core.dialog.a fyg = null;
    a.b fyh = null;
    private boolean fyi = false;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public h(g gVar, View view) {
        this.bTU = null;
        this.exW = null;
        this.dCl = null;
        this.mNoDataView = null;
        this.fyf = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bTU = gVar.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bTU.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.bTU.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.aC(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.fyf = new e(gVar.getPageContext());
        this.fyf.notifyDataSetChanged();
        this.mPullView = new k(gVar.getPageContext());
        this.exW = (BdListView) view.findViewById(d.g.list);
        this.exW.setPullRefresh(this.mPullView);
        this.mPullView.a(gVar);
        this.dCl = new TextView(this.bTU.getActivity());
        this.dCl.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.t(this.bTU.getActivity(), d.e.ds88)));
        this.exW.addHeaderView(this.dCl, 0);
        this.exW.setAdapter((ListAdapter) this.fyf);
        this.exW.setOnSrollToBottomListener(gVar);
        this.exW.setOnItemClickListener(gVar);
        this.fyf.y(gVar);
        this.fyf.z(gVar);
        this.fyf.A(gVar);
    }

    public void c(a.b bVar) {
        this.fyh = bVar;
    }

    public void js(boolean z) {
        this.fyf.cX(z);
        this.fyf.notifyDataSetChanged();
    }

    public int jt(boolean z) {
        return z ? d.g.share_lv_markitem_delete : d.g.home_lv_markitem_delete;
    }

    public int ju(boolean z) {
        return z ? d.g.share_lv_markitem_userinfo : d.g.home_lv_markitem_userinfo;
    }

    public int jv(boolean z) {
        return z ? d.g.share_mark_item_state : d.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.exW.startPullRefresh();
            return;
        }
        this.fyf.setRefreshing(true);
        this.fyf.notifyDataSetChanged();
    }

    public void aIG() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fyf.setRefreshing(true);
        if (str != null) {
            this.bTU.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aYd() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aYd() < 20) {
                this.fyf.setHasMore(false);
                this.fyf.jr(true);
            } else {
                this.fyf.setHasMore(true);
                this.fyf.jr(true);
            }
            this.fyf.setData(aVar.aYc());
            a(aVar, z);
        }
        this.fyf.setRefreshing(false);
        this.fyf.notifyDataSetChanged();
        if (isPullRefreshing()) {
            ct(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.exW.removeHeaderView(this.mNoDataView);
            this.fyf.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bTU.getPageContext());
        this.exW.removeHeaderView(this.mNoDataView);
        this.exW.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aYa() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bTU.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bTU.closeLoadingDialog();
        if (str != null) {
            this.bTU.showToast(str);
        }
        if (z2) {
            aXR();
        }
        this.fyf.notifyDataSetChanged();
    }

    public void arA() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bTU.showToast(this.bTU.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.aYc() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aYc().size() == 0) {
                aVar.d(true);
            } else {
                this.fyf.setData(aVar.aYc());
            }
        } else {
            this.bTU.showToast(str);
        }
        this.fyf.jr(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bTU.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ah(ArrayList<MarkData> arrayList) {
        this.fyf.setData(arrayList);
    }

    private void aXR() {
        if (this.fyg == null) {
            this.fyg = new com.baidu.tbadk.core.dialog.a(this.bTU.getPageContext().getPageActivity());
            this.fyg.dj(this.bTU.getPageContext().getString(d.j.sync_mark_fail));
            this.fyg.dk(this.bTU.getPageContext().getString(d.j.neterror));
            if (this.fyh != null) {
                this.fyg.a(this.bTU.getPageContext().getString(d.j.retry_rightnow), this.fyh);
            }
            this.fyg.b(this.bTU.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.h.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fyg.b(this.bTU.getPageContext());
            this.fyg.ba(true);
        }
        this.fyg.AU();
    }

    public void onChangeSkinType(int i) {
        aj.t(this.mParent, d.C0141d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        aXS();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bTU.getPageContext(), i);
            aj.t(this.mNoDataView, d.C0141d.common_color_10076);
        }
    }

    public void aXS() {
        this.fyf.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fyg != null) {
            this.fyg.dismiss();
            this.fyg = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.exW != null) {
            this.exW.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fyi;
    }

    public void ct(boolean z) {
        this.fyi = z;
    }

    public void fG(boolean z) {
        BdListViewHelper.a(this.dCl, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
