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
    private NoNetworkView aRv;
    private View akX;
    private final AbsListView.OnScrollListener bNN;
    private com.baidu.tbadk.mvc.g.a bzY;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, al> dlN;
    private NavigationBar dlP;
    private final ReplyMessageActivity dmA;
    private BdListView dmJ;
    private ReplyMeModel dmK;
    private com.baidu.tbadk.editortools.pb.n dmL;
    private FeedData dmM;
    private long dmN;
    private long dmO;
    private DataModel<ad> dmP;
    private final ReplyMeModel.a dmQ;
    private String mForumId;
    private com.baidu.tbadk.core.view.ae mPullView;
    private RelativeLayout mRootView;

    public au(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dmJ = null;
        this.dmK = null;
        this.dmQ = new av(this);
        this.bNN = new aw(this);
        this.dmA = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dlN != null) {
                this.dlN.w(acVar.avv());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View TS() {
        this.mRootView = (RelativeLayout) this.dmA.getActivity().getLayoutInflater().inflate(w.j.reply_me_activity, (ViewGroup) null);
        this.dmA.setContentView(this.mRootView);
        this.dmJ = (BdListView) this.mRootView.findViewById(w.h.replyme_lv);
        this.dlP = (NavigationBar) this.mRootView.findViewById(w.h.view_navigation_bar);
        this.dlP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dlP.setTitleText(w.l.reply_me);
        this.dlN = new com.baidu.tbadk.mvc.f.d<>(this.dmA.getPageContext(), al.class, w.j.mention_replyme_item, this.dmA.Fw());
        this.dlN.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dmA.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.de(w.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dmJ.setAdapter((ListAdapter) this.dlN);
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.dmA.getPageContext());
        this.mPullView.a(this.dmA);
        this.bzY = new com.baidu.tbadk.mvc.g.a(this.dmA);
        this.bzY.la();
        this.akX = new TextView(this.dmA.getPageContext().getPageActivity());
        this.akX.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dmA.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.akX, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.he());
        this.dmJ.setNextPage(this.bzY);
        this.dmJ.setPullRefresh(this.mPullView);
        this.dmJ.addHeaderView(this.akX, 0);
        this.aRv = (NoNetworkView) this.mRootView.findViewById(w.h.no_networkview);
        this.aRv.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aRv.a(new ax(this));
        this.dmK = new ReplyMeModel(this.dmA);
        this.dmK.a(this.dmQ);
        this.dmJ.setOnScrollListener(this.bNN);
        this.dmJ.setExOnSrollToBottomListener(new ay(this));
        this.dmP = new az(this, com.baidu.adp.base.k.aa(this.dmA.getPageContext().getPageActivity()));
        this.dmL = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aL(this.dmA.getPageContext().getPageActivity());
        this.dmL.a(this.dmA.getPageContext());
        this.dmL.b(this.dmP);
        this.dmL.f(this.dmA.getPageContext());
        this.dmL.CP().bB(true);
        this.dmL.CP().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.dmL.CP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dmL.CP(), layoutParams);
            this.dmL.CP().hide();
        }
        this.dmL.a(new ba(this));
        this.dmL.b(new bb(this));
        return this.mRootView;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dlN != null) {
            this.dlN.notifyDataSetChanged();
            this.dlN.b(tbPageContext, i);
        }
        if (this.dmL != null && this.dmL.CP() != null) {
            this.dmL.CP().onChangeSkinType(i);
        }
        this.dlP.onChangeSkinType(tbPageContext, i);
        if (this.bzY != null) {
            this.bzY.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dh(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dmL == null || this.dmL.CP() == null || this.dmL.CP().getVisibility() != 0) {
            return false;
        }
        this.dmL.DO();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EN() == 9486) {
            FeedData feedData = (FeedData) bVar.EO();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dmJ) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dmJ && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dmJ.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dmM = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dmK.b(c, 2, feedData.getFname());
            }
        }
    }

    public void avm() {
        if (this.dmJ != null) {
            this.dmJ.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bzY != null) {
                if (aVar.Fq()) {
                    this.bzY.ml();
                    if (aVar.Fo()) {
                        this.bzY.eV(w.l.loading);
                    } else if (aVar.Fp()) {
                        this.bzY.eV(w.l.loading);
                    } else {
                        this.bzY.eW(w.l.no_more_msg);
                    }
                } else {
                    this.bzY.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                avn();
            } else {
                avm();
            }
        }
    }

    public void avn() {
        if (this.mPullView != null) {
            this.mPullView.a((ab.b) null);
        }
        if (this.dmJ != null) {
            this.dmJ.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dmA);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dmL != null) {
            this.dmL.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gr(boolean z) {
        BdListViewHelper.a(this.akX, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dmJ != null && this.dmJ.getWrappedAdapter() != null && this.dmJ.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fM().post(new bc(this));
        }
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.dmL != null) {
            this.dmL.onDestory();
        }
    }
}
