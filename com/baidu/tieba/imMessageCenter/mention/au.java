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
    private NoNetworkView aRN;
    private View aln;
    private com.baidu.tbadk.mvc.g.a bCi;
    private final AbsListView.OnScrollListener bPT;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, al> dmD;
    private NavigationBar dmF;
    private ReplyMeModel dnA;
    private com.baidu.tbadk.editortools.pb.n dnB;
    private FeedData dnC;
    private long dnD;
    private long dnE;
    private DataModel<ad> dnF;
    private final ReplyMeModel.a dnG;
    private final ReplyMessageActivity dnq;
    private BdListView dnz;
    private String mForumId;
    private com.baidu.tbadk.core.view.ae mPullView;
    private RelativeLayout mRootView;

    public au(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dnz = null;
        this.dnA = null;
        this.dnG = new av(this);
        this.bPT = new aw(this);
        this.dnq = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dmD != null) {
                this.dmD.w(acVar.awp());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Vr() {
        this.mRootView = (RelativeLayout) this.dnq.getActivity().getLayoutInflater().inflate(w.j.reply_me_activity, (ViewGroup) null);
        this.dnq.setContentView(this.mRootView);
        this.dnz = (BdListView) this.mRootView.findViewById(w.h.replyme_lv);
        this.dmF = (NavigationBar) this.mRootView.findViewById(w.h.view_navigation_bar);
        this.dmF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dmF.setTitleText(w.l.reply_me);
        this.dmD = new com.baidu.tbadk.mvc.f.d<>(this.dnq.getPageContext(), al.class, w.j.mention_replyme_item, this.dnq.FU());
        this.dmD.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dnq.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dh(w.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dnz.setAdapter((ListAdapter) this.dmD);
        this.mPullView = new com.baidu.tbadk.core.view.ae(this.dnq.getPageContext());
        this.mPullView.a(this.dnq);
        this.bCi = new com.baidu.tbadk.mvc.g.a(this.dnq);
        this.bCi.lf();
        this.aln = new TextView(this.dnq.getPageContext().getPageActivity());
        this.aln.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dnq.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.aln, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        this.dnz.setNextPage(this.bCi);
        this.dnz.setPullRefresh(this.mPullView);
        this.dnz.addHeaderView(this.aln, 0);
        this.aRN = (NoNetworkView) this.mRootView.findViewById(w.h.no_networkview);
        this.aRN.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aRN.a(new ax(this));
        this.dnA = new ReplyMeModel(this.dnq);
        this.dnA.a(this.dnG);
        this.dnz.setOnScrollListener(this.bPT);
        this.dnz.setExOnSrollToBottomListener(new ay(this));
        this.dnF = new az(this, com.baidu.adp.base.k.Z(this.dnq.getPageContext().getPageActivity()));
        this.dnB = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aN(this.dnq.getPageContext().getPageActivity());
        this.dnB.a(this.dnq.getPageContext());
        this.dnB.b(this.dnF);
        this.dnB.f(this.dnq.getPageContext());
        this.dnB.Dn().bD(true);
        this.dnB.Dn().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.dnB.Dn() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dnB.Dn(), layoutParams);
            this.dnB.Dn().hide();
        }
        this.dnB.a(new ba(this));
        this.dnB.b(new bb(this));
        return this.mRootView;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.dmD != null) {
            this.dmD.notifyDataSetChanged();
            this.dmD.b(tbPageContext, i);
        }
        if (this.dnB != null && this.dnB.Dn() != null) {
            this.dnB.Dn().onChangeSkinType(i);
        }
        this.dmF.onChangeSkinType(tbPageContext, i);
        if (this.bCi != null) {
            this.bCi.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dnB == null || this.dnB.Dn() == null || this.dnB.Dn().getVisibility() != 0) {
            return false;
        }
        this.dnB.Em();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Fl() == 9486) {
            FeedData feedData = (FeedData) bVar.Fm();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dnz) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dnz && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dnz.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dnC = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dnA.b(c, 2, feedData.getFname());
            }
        }
    }

    public void awg() {
        if (this.dnz != null) {
            this.dnz.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bCi != null) {
                if (aVar.FO()) {
                    this.bCi.mp();
                    if (aVar.FM()) {
                        this.bCi.eY(w.l.loading);
                    } else if (aVar.FN()) {
                        this.bCi.eY(w.l.loading);
                    } else {
                        this.bCi.eZ(w.l.no_more_msg);
                    }
                } else {
                    this.bCi.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                awh();
            } else {
                awg();
            }
        }
    }

    public void awh() {
        if (this.mPullView != null) {
            this.mPullView.a((ab.b) null);
        }
        if (this.dnz != null) {
            this.dnz.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dnq);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dnB != null) {
            this.dnB.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gB(boolean z) {
        BdListViewHelper.a(this.aln, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dnz != null && this.dnz.getWrappedAdapter() != null && this.dnz.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fS().post(new bc(this));
        }
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.dnB != null) {
            this.dnB.onDestory();
        }
    }
}
