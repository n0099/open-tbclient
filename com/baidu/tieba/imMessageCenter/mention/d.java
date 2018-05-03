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
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.base.c<AtMessageActivity> {
    private NoNetworkView bla;
    private com.baidu.tbadk.mvc.g.a cwG;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, a> emB;
    private BdListView emC;
    private NavigationBar emD;
    private AtMessageActivity emu;
    private View mHeaderView;
    protected com.baidu.tbadk.core.view.f mPullView;
    private View rootView;

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.emu = atMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View Rn() {
        this.rootView = this.emu.getActivity().getLayoutInflater().inflate(d.i.at_me_activity, (ViewGroup) null);
        this.emu.setContentView(this.rootView);
        this.emC = (BdListView) this.rootView.findViewById(d.g.atme_lv);
        this.emD = (NavigationBar) this.rootView.findViewById(d.g.view_navigation_bar);
        this.emD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.emD.setCenterTextTitle(getPageContext().getString(d.k.at_me));
        this.emD.showBottomLine();
        this.mPullView = new com.baidu.tbadk.core.view.f(this.emu.getPageContext());
        this.mPullView.setTag(this.emu.getUniqueId());
        this.mPullView.a(this.emu);
        this.cwG = new com.baidu.tbadk.mvc.g.a(this.emu);
        this.cwG.kA();
        this.mHeaderView = new TextView(this.emu.getPageContext().getPageActivity());
        this.mHeaderView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.e(this.emu.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
        this.emC.setPullRefresh(this.mPullView);
        this.emC.addHeaderView(this.mHeaderView, 0);
        this.emC.setNextPage(this.cwG);
        this.emC.setDividerHeight(0);
        this.bla = (NoNetworkView) this.rootView.findViewById(d.g.no_networkview);
        this.bla.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bla.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.d.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                d.this.hH(z);
            }
        });
        this.emC.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.d.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                d.this.emu.arh();
            }
        });
        this.emB = new com.baidu.tbadk.mvc.f.d<>(this.emu.getPageContext(), a.class, d.i.mention_atme_item, this.emu.Gn());
        this.emB.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.emu.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.m16do(d.k.mention_atme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.emC.setAdapter((ListAdapter) this.emB);
        return this.rootView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.emB != null) {
                this.emB.F(fVar.aIH());
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.emB != null) {
            this.emB.b(tbPageContext, i);
        }
        if (this.cwG != null) {
            this.cwG.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        this.emD.onChangeSkinType(tbPageContext, i);
    }

    public void aIo() {
        if (this.emC != null) {
            this.emC.completePullRefreshPostDelayed(2000L);
        }
    }

    public void hH(boolean z) {
        BdListViewHelper.a(this.mHeaderView, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.gP());
        if (z && this.emC != null && this.emC.getWrappedAdapter() != null && this.emC.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fw().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.emC.startPullRefresh();
                }
            });
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cwG != null) {
                if (aVar.Gh()) {
                    this.cwG.lN();
                    if (aVar.Gf()) {
                        this.cwG.fc(d.k.loading);
                    } else if (aVar.Gg()) {
                        this.cwG.fc(d.k.loading);
                    } else {
                        this.cwG.fd(d.k.no_more_msg);
                    }
                } else {
                    this.cwG.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aIp();
            } else {
                aIo();
            }
        }
    }

    public void aIp() {
        if (this.mPullView != null) {
            this.mPullView.a((e.b) null);
        }
        if (this.emC != null) {
            this.emC.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.emu);
        }
    }
}
