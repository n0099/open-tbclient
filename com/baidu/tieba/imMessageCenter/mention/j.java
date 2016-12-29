package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.f<AtMessageActivity> {
    private NoNetworkView Hj;
    private View aAK;
    private View agt;
    private com.baidu.tbadk.mvc.g.a bfM;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, b> cav;
    private AtMessageActivity dcb;
    private BdListView dci;
    private NavigationBar dcj;
    protected com.baidu.tbadk.core.view.ac mPullView;

    public j(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.dcb = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View me() {
        this.aAK = this.dcb.getActivity().getLayoutInflater().inflate(r.h.at_me_activity, (ViewGroup) null);
        this.dcb.setContentView(this.aAK);
        this.dci = (BdListView) this.aAK.findViewById(r.g.atme_lv);
        this.dcj = (NavigationBar) this.aAK.findViewById(r.g.view_navigation_bar);
        this.dcj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dcj.setTitleText(r.j.at_me);
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.dcb.getPageContext());
        this.mPullView.setTag(this.dcb.getUniqueId());
        this.mPullView.a(this.dcb);
        this.bfM = new com.baidu.tbadk.mvc.g.a(this.dcb);
        this.bfM.kk();
        this.agt = new TextView(this.dcb.getPageContext().getPageActivity());
        this.agt.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.dcb.getPageContext().getPageActivity(), r.e.ds98)));
        BdListViewHelper.a(this.agt, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gm());
        this.dci.setPullRefresh(this.mPullView);
        this.dci.f(this.agt, 0);
        this.dci.setNextPage(this.bfM);
        this.dci.setDividerHeight(0);
        this.Hj = (NoNetworkView) this.aAK.findViewById(r.g.no_networkview);
        this.Hj.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Hj.a(new k(this));
        this.dci.setExOnSrollToBottomListener(new l(this));
        this.cav = new com.baidu.tbadk.mvc.f.d<>(this.dcb.getPageContext(), b.class, r.h.mention_atme_item, this.dcb.lI());
        this.cav.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dcb.getResources().getDimension(r.e.ds80)), NoDataViewFactory.d.dh(r.j.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dci.setAdapter((ListAdapter) this.cav);
        return this.aAK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof af) {
            af afVar = (af) aVar;
            if (this.cav != null) {
                this.cav.A(afVar.auS());
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cav != null) {
            this.cav.a(tbPageContext, i);
        }
        if (this.bfM != null) {
            this.bfM.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
        this.dcj.onChangeSkinType(tbPageContext, i);
    }

    public void auK() {
        if (this.dci != null) {
            this.dci.l(2000L);
        }
    }

    public void gx(boolean z) {
        BdListViewHelper.a(this.agt, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gm());
        if (z && this.dci != null && this.dci.getWrappedAdapter() != null && this.dci.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.eG().post(new m(this));
        }
    }

    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bfM != null) {
                if (aVar.EX()) {
                    this.bfM.lz();
                    if (aVar.EV()) {
                        this.bfM.eZ(r.j.loading);
                    } else if (aVar.EW()) {
                        this.bfM.eZ(r.j.loading);
                    } else {
                        this.bfM.fa(r.j.no_more_msg);
                    }
                } else {
                    this.bfM.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                auL();
            } else {
                auK();
            }
        }
    }

    public void auL() {
        if (this.mPullView != null) {
            this.mPullView.a((z.b) null);
        }
        if (this.dci != null) {
            this.dci.kv();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dcb);
        }
    }
}
