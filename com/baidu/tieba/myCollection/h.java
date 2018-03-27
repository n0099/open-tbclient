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
    BaseFragmentActivity bTX;
    private View dCo;
    private BdListView eyn;
    private e fyv;
    private com.baidu.tbadk.core.dialog.a fyw = null;
    a.b fyx = null;
    private boolean fyy = false;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private RelativeLayout mParent;
    private ProgressBar mProgressBar;
    private k mPullView;

    public h(g gVar, View view) {
        this.bTX = null;
        this.eyn = null;
        this.dCo = null;
        this.mNoDataView = null;
        this.fyv = null;
        this.mParent = null;
        this.mProgressBar = null;
        this.bTX = gVar.getBaseFragmentActivity();
        this.mProgressBar = (ProgressBar) view.findViewById(d.g.progress);
        this.mParent = (RelativeLayout) view.findViewById(d.g.parent);
        this.mNoDataView = NoDataViewFactory.a(this.bTX.getPageContext().getPageActivity(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.bTX.getPageContext().getPageActivity(), d.e.ds222)), NoDataViewFactory.d.aC(d.j.mark_nodata, d.j.mark_nodata_2), null);
        this.fyv = new e(gVar.getPageContext());
        this.fyv.notifyDataSetChanged();
        this.mPullView = new k(gVar.getPageContext());
        this.eyn = (BdListView) view.findViewById(d.g.list);
        this.eyn.setPullRefresh(this.mPullView);
        this.mPullView.a(gVar);
        this.dCo = new TextView(this.bTX.getActivity());
        this.dCo.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.t(this.bTX.getActivity(), d.e.ds88)));
        this.eyn.addHeaderView(this.dCo, 0);
        this.eyn.setAdapter((ListAdapter) this.fyv);
        this.eyn.setOnSrollToBottomListener(gVar);
        this.eyn.setOnItemClickListener(gVar);
        this.fyv.y(gVar);
        this.fyv.z(gVar);
        this.fyv.A(gVar);
    }

    public void c(a.b bVar) {
        this.fyx = bVar;
    }

    public void jx(boolean z) {
        this.fyv.cX(z);
        this.fyv.notifyDataSetChanged();
    }

    public int jy(boolean z) {
        return z ? d.g.share_lv_markitem_delete : d.g.home_lv_markitem_delete;
    }

    public int jz(boolean z) {
        return z ? d.g.share_lv_markitem_userinfo : d.g.home_lv_markitem_userinfo;
    }

    public int jA(boolean z) {
        return z ? d.g.share_mark_item_state : d.g.markitem_state;
    }

    public void startRefresh(int i) {
        if (i == 0) {
            this.eyn.startPullRefresh();
            return;
        }
        this.fyv.setRefreshing(true);
        this.fyv.notifyDataSetChanged();
    }

    public void aIH() {
        this.mProgressBar.setVisibility(8);
    }

    public void a(String str, com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        this.fyv.setRefreshing(true);
        if (str != null) {
            this.bTX.showToast(str);
        }
        if (aVar != null) {
            if (aVar.aYe() != 0 || z || aVar.getCount() <= 0) {
            }
            if (aVar.aYe() < 20) {
                this.fyv.setHasMore(false);
                this.fyv.jw(true);
            } else {
                this.fyv.setHasMore(true);
                this.fyv.jw(true);
            }
            this.fyv.setData(aVar.aYd());
            a(aVar, z);
        }
        this.fyv.setRefreshing(false);
        this.fyv.notifyDataSetChanged();
        if (isPullRefreshing()) {
            ct(false);
        }
    }

    public void a(com.baidu.tieba.myCollection.baseEditMark.a aVar, boolean z) {
        if (aVar == null) {
            showNoDataView();
        } else if (aVar.getCount() > 0) {
            this.mNoDataView.setVisibility(8);
            this.eyn.removeHeaderView(this.mNoDataView);
            this.fyv.notifyDataSetChanged();
        } else if (aVar.getCount() == 0 && !z) {
            showNoDataView();
        }
    }

    public void showNoDataView() {
        this.mNoDataView.e(this.bTX.getPageContext());
        this.eyn.removeHeaderView(this.mNoDataView);
        this.eyn.addHeaderView(this.mNoDataView);
        this.mNoDataView.setVisibility(0);
    }

    public void aYb() {
        if (this.mNoDataView.isShown()) {
            this.mNoDataView.e(this.bTX.getPageContext());
        }
    }

    public void a(boolean z, String str, boolean z2) {
        this.bTX.closeLoadingDialog();
        if (str != null) {
            this.bTX.showToast(str);
        }
        if (z2) {
            aXS();
        }
        this.fyv.notifyDataSetChanged();
    }

    public void arB() {
        this.mProgressBar.setVisibility(0);
    }

    public void a(boolean z, String str, com.baidu.tieba.myCollection.baseEditMark.a aVar) {
        if (z) {
            this.bTX.showToast(this.bTX.getPageContext().getString(d.j.delete_success));
            if (aVar == null || aVar.aYd() == null) {
                this.mProgressBar.setVisibility(8);
                return;
            } else if (aVar.aYd().size() == 0) {
                aVar.d(true);
            } else {
                this.fyv.setData(aVar.aYd());
            }
        } else {
            this.bTX.showToast(str);
        }
        this.fyv.jw(false);
        this.mProgressBar.setVisibility(8);
    }

    public void e(MarkData markData) {
        if (markData != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.bTX.getPageContext().getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(markData.getUesrId(), 0L), false, markData.isGod())));
        }
    }

    public void ah(ArrayList<MarkData> arrayList) {
        this.fyv.setData(arrayList);
    }

    private void aXS() {
        if (this.fyw == null) {
            this.fyw = new com.baidu.tbadk.core.dialog.a(this.bTX.getPageContext().getPageActivity());
            this.fyw.dj(this.bTX.getPageContext().getString(d.j.sync_mark_fail));
            this.fyw.dk(this.bTX.getPageContext().getString(d.j.neterror));
            if (this.fyx != null) {
                this.fyw.a(this.bTX.getPageContext().getString(d.j.retry_rightnow), this.fyx);
            }
            this.fyw.b(this.bTX.getPageContext().getString(d.j.confirm), new a.b() { // from class: com.baidu.tieba.myCollection.h.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fyw.b(this.bTX.getPageContext());
            this.fyw.ba(true);
        }
        this.fyw.AV();
    }

    public void onChangeSkinType(int i) {
        aj.t(this.mParent, d.C0141d.cp_bg_line_d);
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        aXT();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.bTX.getPageContext(), i);
            aj.t(this.mNoDataView, d.C0141d.common_color_10076);
        }
    }

    public void aXT() {
        this.fyv.notifyDataSetChanged();
    }

    public void onDestroy() {
        if (this.fyw != null) {
            this.fyw.dismiss();
            this.fyw = null;
        }
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    public void completePullRefresh() {
        if (this.eyn != null) {
            this.eyn.completePullRefreshPostDelayed(2000L);
        }
    }

    public boolean isPullRefreshing() {
        return this.fyy;
    }

    public void ct(boolean z) {
        this.fyy = z;
    }

    public void fG(boolean z) {
        BdListViewHelper.a(this.dCo, BdListViewHelper.HeadType.DEFAULT, z);
    }
}
