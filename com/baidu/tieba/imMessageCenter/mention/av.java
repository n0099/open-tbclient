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
import com.baidu.tbadk.core.view.ae;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class av extends com.baidu.adp.base.e<ReplyMessageActivity> {
    private NoNetworkView aSi;
    private View ali;
    private com.baidu.tbadk.mvc.g.a bCj;
    private final AbsListView.OnScrollListener bPi;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, am> dgH;
    private NavigationBar dgJ;
    private BdListView dhE;
    private ReplyMeModel dhF;
    private com.baidu.tbadk.editortools.pb.n dhG;
    private FeedData dhH;
    private long dhI;
    private long dhJ;
    private DataModel<ad> dhK;
    private final ReplyMeModel.a dhL;
    private final ReplyMessageActivity dhv;
    private String mForumId;
    private com.baidu.tbadk.core.view.ah mPullView;
    private RelativeLayout mRootView;

    public av(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dhE = null;
        this.dhF = null;
        this.dhL = new aw(this);
        this.bPi = new ax(this);
        this.dhv = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dgH != null) {
                this.dgH.x(acVar.atk());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View UK() {
        this.mRootView = (RelativeLayout) this.dhv.getActivity().getLayoutInflater().inflate(w.j.reply_me_activity, (ViewGroup) null);
        this.dhv.setContentView(this.mRootView);
        this.dhE = (BdListView) this.mRootView.findViewById(w.h.replyme_lv);
        this.dgJ = (NavigationBar) this.mRootView.findViewById(w.h.view_navigation_bar);
        this.dgJ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dgJ.setTitleText(w.l.reply_me);
        this.dgH = new com.baidu.tbadk.mvc.f.d<>(this.dhv.getPageContext(), am.class, w.j.mention_replyme_item, this.dhv.EY());
        this.dgH.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dhv.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dd(w.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dhE.setAdapter((ListAdapter) this.dgH);
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.dhv.getPageContext());
        this.mPullView.a(this.dhv);
        this.bCj = new com.baidu.tbadk.mvc.g.a(this.dhv);
        this.bCj.le();
        this.ali = new TextView(this.dhv.getPageContext().getPageActivity());
        this.ali.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dhv.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.ali, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        this.dhE.setNextPage(this.bCj);
        this.dhE.setPullRefresh(this.mPullView);
        this.dhE.addHeaderView(this.ali, 0);
        this.aSi = (NoNetworkView) this.mRootView.findViewById(w.h.no_networkview);
        this.aSi.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aSi.a(new ay(this));
        this.dhF = new ReplyMeModel(this.dhv);
        this.dhF.a(this.dhL);
        this.dhE.setOnScrollListener(this.bPi);
        this.dhE.setExOnSrollToBottomListener(new az(this));
        this.dhK = new ba(this, com.baidu.adp.base.k.Z(this.dhv.getPageContext().getPageActivity()));
        this.dhG = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aQ(this.dhv.getPageContext().getPageActivity());
        this.dhG.a(this.dhv.getPageContext());
        this.dhG.b(this.dhK);
        this.dhG.f(this.dhv.getPageContext());
        this.dhG.Cs().bD(true);
        this.dhG.Cs().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.dhG.Cs() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dhG.Cs(), layoutParams);
            this.dhG.Cs().hide();
        }
        this.dhG.a(new bb(this));
        this.dhG.b(new bc(this));
        return this.mRootView;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dgH != null) {
            this.dgH.notifyDataSetChanged();
            this.dgH.b(tbPageContext, i);
        }
        if (this.dhG != null && this.dhG.Cs() != null) {
            this.dhG.Cs().onChangeSkinType(i);
        }
        this.dgJ.onChangeSkinType(tbPageContext, i);
        if (this.bCj != null) {
            this.bCj.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.di(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dhG == null || this.dhG.Cs() == null || this.dhG.Cs().getVisibility() != 0) {
            return false;
        }
        this.dhG.Dq();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Ep() == 9486) {
            FeedData feedData = (FeedData) bVar.Eq();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dhE) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dhE && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dhE.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dhH = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dhF.a(c, 2, feedData.getFname());
            }
        }
    }

    public void atb() {
        if (this.dhE != null) {
            this.dhE.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bCj != null) {
                if (aVar.ES()) {
                    this.bCj.lW();
                    if (aVar.EQ()) {
                        this.bCj.eU(w.l.loading);
                    } else if (aVar.ER()) {
                        this.bCj.eU(w.l.loading);
                    } else {
                        this.bCj.eV(w.l.no_more_msg);
                    }
                } else {
                    this.bCj.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                atc();
            } else {
                atb();
            }
        }
    }

    public void atc() {
        if (this.mPullView != null) {
            this.mPullView.a((ae.b) null);
        }
        if (this.dhE != null) {
            this.dhE.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dhv);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dhG != null) {
            this.dhG.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gc(boolean z) {
        BdListViewHelper.a(this.ali, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dhE != null && this.dhE.getWrappedAdapter() != null && this.dhE.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fS().post(new bd(this));
        }
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.dhG != null) {
            this.dhG.onDestory();
        }
    }
}
