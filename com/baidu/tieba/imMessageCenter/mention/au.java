package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.ab;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e<ReplyMessageActivity> {
    private NoNetworkView aRL;
    private View alm;
    private final AbsListView.OnScrollListener bNC;
    private com.baidu.tbadk.mvc.g.a bzR;
    private final ReplyMessageActivity dkZ;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, al> dkm;
    private NavigationBar dko;
    private BdListView dli;
    private ReplyMeModel dlj;
    private com.baidu.tbadk.editortools.pb.n dlk;
    private FeedData dll;
    private long dlm;
    private long dln;
    private DataModel<ad> dlo;
    private final ReplyMeModel.a dlp;
    private String mForumId;
    private com.baidu.tbadk.core.view.ae mPullView;
    private RelativeLayout mRootView;

    public au(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dli = null;
        this.dlj = null;
        this.dlp = new av(this);
        this.bNC = new aw(this);
        this.dkZ = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dkm != null) {
                this.dkm.w(acVar.avo());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Uq() {
        this.mRootView = (RelativeLayout) this.dkZ.getActivity().getLayoutInflater().inflate(w.j.reply_me_activity, (ViewGroup) null);
        this.dkZ.setContentView(this.mRootView);
        this.dli = (BdListView) this.mRootView.findViewById(w.h.replyme_lv);
        this.dko = (NavigationBar) this.mRootView.findViewById(w.h.view_navigation_bar);
        this.dko.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dko.setTitleText(w.l.reply_me);
        this.dkm = new com.baidu.tbadk.mvc.f.d<>(this.dkZ.getPageContext(), al.class, w.j.mention_replyme_item, this.dkZ.FU());
        this.dkm.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dkZ.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dh(w.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dli.setAdapter((ListAdapter) this.dkm);
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.dkZ.getPageContext());
        this.mPullView.a(this.dkZ);
        this.bzR = new com.baidu.tbadk.mvc.g.a(this.dkZ);
        this.bzR.le();
        this.alm = new TextView(this.dkZ.getPageContext().getPageActivity());
        this.alm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dkZ.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.alm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        this.dli.setNextPage(this.bzR);
        this.dli.setPullRefresh(this.mPullView);
        this.dli.addHeaderView(this.alm, 0);
        this.aRL = (NoNetworkView) this.mRootView.findViewById(w.h.no_networkview);
        this.aRL.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aRL.a(new ax(this));
        this.dlj = new ReplyMeModel(this.dkZ);
        this.dlj.a(this.dlp);
        this.dli.setOnScrollListener(this.bNC);
        this.dli.setExOnSrollToBottomListener(new ay(this));
        this.dlo = new az(this, com.baidu.adp.base.k.Z(this.dkZ.getPageContext().getPageActivity()));
        this.dlk = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aN(this.dkZ.getPageContext().getPageActivity());
        this.dlk.a(this.dkZ.getPageContext());
        this.dlk.b(this.dlo);
        this.dlk.f(this.dkZ.getPageContext());
        this.dlk.Dn().bD(true);
        this.dlk.Dn().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.dlk.Dn() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dlk.Dn(), layoutParams);
            this.dlk.Dn().hide();
        }
        this.dlk.a(new ba(this));
        this.dlk.b(new bb(this));
        return this.mRootView;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dkm != null) {
            this.dkm.notifyDataSetChanged();
            this.dkm.b(tbPageContext, i);
        }
        if (this.dlk != null && this.dlk.Dn() != null) {
            this.dlk.Dn().onChangeSkinType(i);
        }
        this.dko.onChangeSkinType(tbPageContext, i);
        if (this.bzR != null) {
            this.bzR.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dlk == null || this.dlk.Dn() == null || this.dlk.Dn().getVisibility() != 0) {
            return false;
        }
        this.dlk.Em();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Fl() == 9486) {
            FeedData feedData = (FeedData) bVar.Fm();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dli) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dli && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dli.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dll = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dlj.b(c, 2, feedData.getFname());
            }
        }
    }

    public void avf() {
        if (this.dli != null) {
            this.dli.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bzR != null) {
                if (aVar.FO()) {
                    this.bzR.mp();
                    if (aVar.FM()) {
                        this.bzR.eY(w.l.loading);
                    } else if (aVar.FN()) {
                        this.bzR.eY(w.l.loading);
                    } else {
                        this.bzR.eZ(w.l.no_more_msg);
                    }
                } else {
                    this.bzR.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                avg();
            } else {
                avf();
            }
        }
    }

    public void avg() {
        if (this.mPullView != null) {
            this.mPullView.a((ab.b) null);
        }
        if (this.dli != null) {
            this.dli.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dkZ);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dlk != null) {
            this.dlk.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.alm, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dli != null && this.dli.getWrappedAdapter() != null && this.dli.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fR().post(new bc(this));
        }
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.dlk != null) {
            this.dlk.onDestory();
        }
    }
}
