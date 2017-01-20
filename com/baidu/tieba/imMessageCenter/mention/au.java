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
import com.baidu.tbadk.core.view.aa;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class au extends com.baidu.adp.base.e<ReplyMessageActivity> {
    private NoNetworkView Gt;
    private View afF;
    private int anM;
    private final AbsListView.OnScrollListener bGE;
    private com.baidu.tbadk.mvc.g.a bsP;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, al> cgR;
    private NavigationBar djv;
    private final ReplyMessageActivity dkg;
    private BdListView dkp;
    private ReplyMeModel dkq;
    private com.baidu.tbadk.editortools.pb.n dkr;
    private FeedData dks;
    private long dkt;
    private long dku;
    private DataModel<ad> dkv;
    private final ReplyMeModel.a dkw;
    private com.baidu.tieba.tbadkCore.w dkx;
    private int mBottom;
    private String mForumId;
    private com.baidu.tbadk.core.view.ad mPullView;
    private RelativeLayout mRootView;

    public au(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dkp = null;
        this.dkq = null;
        this.dkw = new av(this);
        this.dkx = null;
        this.bGE = new aw(this);
        this.dkg = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.cgR != null) {
                this.cgR.y(acVar.avZ());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View lW() {
        this.mRootView = (RelativeLayout) this.dkg.getActivity().getLayoutInflater().inflate(r.j.reply_me_activity, (ViewGroup) null);
        this.dkg.setContentView(this.mRootView);
        this.dkp = (BdListView) this.mRootView.findViewById(r.h.replyme_lv);
        this.djv = (NavigationBar) this.mRootView.findViewById(r.h.view_navigation_bar);
        this.djv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.djv.setTitleText(r.l.reply_me);
        this.cgR = new com.baidu.tbadk.mvc.f.d<>(this.dkg.getPageContext(), al.class, r.j.mention_replyme_item, this.dkg.lA());
        this.cgR.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dkg.getResources().getDimension(r.f.ds80)), NoDataViewFactory.d.di(r.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dkp.setAdapter((ListAdapter) this.cgR);
        this.mPullView = new com.baidu.tbadk.core.view.ad(this.dkg.getPageContext());
        this.mPullView.a(this.dkg);
        this.bsP = new com.baidu.tbadk.mvc.g.a(this.dkg);
        this.bsP.kg();
        this.afF = new TextView(this.dkg.getPageContext().getPageActivity());
        this.afF.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.dkg.getPageContext().getPageActivity(), r.f.ds98)));
        BdListViewHelper.a(this.afF, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gk());
        this.dkp.setNextPage(this.bsP);
        this.dkp.setPullRefresh(this.mPullView);
        this.dkp.addHeaderView(this.afF, 0);
        this.Gt = (NoNetworkView) this.mRootView.findViewById(r.h.no_networkview);
        this.Gt.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Gt.a(new ax(this));
        this.dkq = new ReplyMeModel(this.dkg);
        this.dkq.a(this.dkw);
        this.dkp.setOnScrollListener(this.bGE);
        this.dkp.setExOnSrollToBottomListener(new ay(this));
        this.dkv = new az(this, com.baidu.adp.base.k.C(this.dkg.getPageContext().getPageActivity()));
        this.dkr = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().an(this.dkg.getPageContext().getPageActivity());
        this.dkr.a(this.dkg.getPageContext());
        this.dkr.b(this.dkv);
        this.dkr.f(this.dkg.getPageContext());
        this.dkr.Cw().bC(true);
        this.dkr.Cw().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.dkr.Cw() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dkr.Cw(), layoutParams);
            this.dkr.Cw().hide();
        }
        this.dkr.a(new ba(this));
        this.dkr.b(new bb(this));
        return this.mRootView;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cgR != null) {
            this.cgR.notifyDataSetChanged();
            this.cgR.a(tbPageContext, i);
        }
        if (this.dkr != null && this.dkr.Cw() != null) {
            this.dkr.Cw().onChangeSkinType(i);
        }
        this.djv.onChangeSkinType(tbPageContext, i);
        if (this.bsP != null) {
            this.bsP.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dkr == null || this.dkr.Cw() == null || this.dkr.Cw().getVisibility() != 0) {
            return false;
        }
        this.dkr.Dv();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Es() == 9486) {
            FeedData feedData = (FeedData) bVar.Et();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dkp) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dkp && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dkp.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.anM = bVar.Eu();
                this.dks = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dkq.b(c, 2, feedData.getFname());
            }
        }
    }

    public void avQ() {
        if (this.dkp != null) {
            this.dkp.completePullRefreshPostDelayed(2000L);
        }
    }

    public void d(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bsP != null) {
                if (aVar.ER()) {
                    this.bsP.lr();
                    if (aVar.EP()) {
                        this.bsP.fa(r.l.loading);
                    } else if (aVar.EQ()) {
                        this.bsP.fa(r.l.loading);
                    } else {
                        this.bsP.fb(r.l.no_more_msg);
                    }
                } else {
                    this.bsP.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                avR();
            } else {
                avQ();
            }
        }
    }

    public void avR() {
        if (this.mPullView != null) {
            this.mPullView.a((aa.b) null);
        }
        if (this.dkp != null) {
            this.dkp.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dkg);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dkr != null) {
            this.dkr.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gA(boolean z) {
        BdListViewHelper.a(this.afF, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dkp != null && this.dkp.getWrappedAdapter() != null && this.dkp.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.eE().post(new bc(this));
        }
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.dkr != null) {
            this.dkr.onDestory();
        }
    }
}
