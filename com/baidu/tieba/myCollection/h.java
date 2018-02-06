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
    BaseFragmentActivity bUg;
    private View dCx;
    private BdListView eyi;
    private e fyr;
    private com.baidu.tbadk.core.dialog.a fys = null;
    a.b fyt = null;
    private boolean fyu = false;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public h(g gVar, View view) {
        this.bUg = null;
        this.eyi = null;
        this.dCx = null;
        this.mNoDataView = null;
        this.fyr = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bUg = gVar.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bUg.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.bUg.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.aC(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.fyr = new e(gVar.getPageContext());
        this.fyr.notifyDataSetChanged();
        this.mPullView = new k(gVar.getPageContext());
        this.eyi = (BdListView) view.findViewById(d.g.list);
        this.eyi.setPullRefresh(this.mPullView);
        this.mPullView.a(gVar);
        this.dCx = new TextView(this.bUg.getActivity());
        this.dCx.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.t(this.bUg.getActivity(), d.e.ds88)));
        this.eyi.addHeaderView(this.dCx, 0);
        this.eyi.setAdapter((ListAdapter) this.fyr);
        this.eyi.setOnSrollToBottomListener(gVar);
        this.eyi.setOnItemClickListener(gVar);
        this.fyr.y(gVar);
        this.fyr.z(gVar);
        this.fyr.A(gVar);
    }

    public void c(a.b bVar) {
        this.fyt = bVar;
    }

    public void js(boolean z) {
        this.fyr.cX(z);
        this.fyr.notifyDataSetChanged();
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
            this.eyi.startPullRefresh();
            return;
        }
        this.fyr.setRefreshing(true);
        this.fyr.notifyDataSetChanged();
    }

    public void aIH() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fyr.setRefreshing(true);
        if (str != null) {
            this.bUg.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aYe() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aYe() < 20) {
                this.fyr.setHasMore(false);
                this.fyr.jr(true);
            } else {
                this.fyr.setHasMore(true);
                this.fyr.jr(true);
            }
            this.fyr.setData(aVar.aYd());
            a(aVar, z);
        }
        this.fyr.setRefreshing(false);
        this.fyr.notifyDataSetChanged();
        if (isPullRefreshing()) {
            ct(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.eyi.removeHeaderView(this.mNoDataView);
            this.fyr.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bUg.getPageContext());
        this.eyi.removeHeaderView(this.mNoDataView);
        this.eyi.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aYb() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bUg.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bUg.closeLoadingDialog();
        if (str != null) {
            this.bUg.showToast(str);
        }
        if (z2) {
            aXS();
        }
        this.fyr.notifyDataSetChanged();
    }

    public void arB() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bUg.showToast(this.bUg.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.aYd() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aYd().size() == 0) {
                aVar.d(true);
            } else {
                this.fyr.setData(aVar.aYd());
            }
        } else {
            this.bUg.showToast(str);
        }
        this.fyr.jr(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bUg.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ah(ArrayList<MarkData> arrayList) {
        this.fyr.setData(arrayList);
    }

    private void aXS() {
        if (this.fys == null) {
            this.fys = new com.baidu.tbadk.core.dialog.a(this.bUg.getPageContext().getPageActivity());
            this.fys.dj(this.bUg.getPageContext().getString(d.j.sync_mark_fail));
            this.fys.dk(this.bUg.getPageContext().getString(d.j.neterror));
            if (this.fyt != null) {
                this.fys.a(this.bUg.getPageContext().getString(d.j.retry_rightnow), this.fyt);
            }
            this.fys.b(this.bUg.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.h.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fys.b(this.bUg.getPageContext());
            this.fys.ba(true);
        }
        this.fys.AU();
    }

    public void onChangeSkinType(int i) {
        aj.t(this.mParent, d.C0140d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        aXT();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bUg.getPageContext(), i);
            aj.t(this.mNoDataView, d.C0140d.common_color_10076);
        }
    }

    public void aXT() {
        this.fyr.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fys != null) {
            this.fys.dismiss();
            this.fys = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.eyi != null) {
            this.eyi.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fyu;
    }

    public void ct(boolean z) {
        this.fyu = z;
    }

    public void fG(boolean z) {
        BdListViewHelper.a(this.dCx, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
