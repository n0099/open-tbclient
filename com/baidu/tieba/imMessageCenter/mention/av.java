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
    private View alM;
    private com.baidu.tbadk.mvc.g.a bIS;
    private NoNetworkView bbO;
    private final AbsListView.OnScrollListener cdf;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, am> dtZ;
    private final ReplyMessageActivity duN;
    private BdListView duW;
    private ReplyMeModel duX;
    private com.baidu.tbadk.editortools.pb.n duY;
    private FeedData duZ;
    private NavigationBar dub;
    private long dva;
    private long dvb;
    private DataModel<ad> dvc;
    private final ReplyMeModel.a dvd;
    private String mForumId;
    private com.baidu.tbadk.core.view.ah mPullView;
    private RelativeLayout mRootView;

    public av(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.duW = null;
        this.duX = null;
        this.dvd = new aw(this);
        this.cdf = new ax(this);
        this.duN = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dtZ != null) {
                this.dtZ.z(acVar.axM());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Xe() {
        this.mRootView = (RelativeLayout) this.duN.getActivity().getLayoutInflater().inflate(w.j.reply_me_activity, (ViewGroup) null);
        this.duN.setContentView(this.mRootView);
        this.duW = (BdListView) this.mRootView.findViewById(w.h.replyme_lv);
        this.dub = (NavigationBar) this.mRootView.findViewById(w.h.view_navigation_bar);
        this.dub.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dub.setTitleText(w.l.reply_me);
        this.dtZ = new com.baidu.tbadk.mvc.f.d<>(this.duN.getPageContext(), am.class, w.j.mention_replyme_item, this.duN.Fp());
        this.dtZ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.duN.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.dg(w.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.duW.setAdapter((ListAdapter) this.dtZ);
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.duN.getPageContext());
        this.mPullView.a(this.duN);
        this.bIS = new com.baidu.tbadk.mvc.g.a(this.duN);
        this.bIS.lc();
        this.alM = new TextView(this.duN.getPageContext().getPageActivity());
        this.alM.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.duN.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.alM, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hj());
        this.duW.setNextPage(this.bIS);
        this.duW.setPullRefresh(this.mPullView);
        this.duW.addHeaderView(this.alM, 0);
        this.bbO = (NoNetworkView) this.mRootView.findViewById(w.h.no_networkview);
        this.bbO.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.bbO.a(new ay(this));
        this.duX = new ReplyMeModel(this.duN);
        this.duX.a(this.dvd);
        this.duW.setOnScrollListener(this.cdf);
        this.duW.setExOnSrollToBottomListener(new az(this));
        this.dvc = new ba(this, com.baidu.adp.base.k.Z(this.duN.getPageContext().getPageActivity()));
        this.duY = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aQ(this.duN.getPageContext().getPageActivity());
        this.duY.a(this.duN.getPageContext());
        this.duY.b(this.dvc);
        this.duY.f(this.duN.getPageContext());
        this.duY.CG().bB(true);
        this.duY.CG().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.duY.CG() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.duY.CG(), layoutParams);
            this.duY.CG().hide();
        }
        this.duY.a(new bb(this));
        this.duY.b(new bc(this));
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dtZ != null) {
            this.dtZ.notifyDataSetChanged();
            this.dtZ.b(tbPageContext, i);
        }
        if (this.duY != null && this.duY.CG() != null) {
            this.duY.CG().onChangeSkinType(i);
        }
        this.dub.onChangeSkinType(tbPageContext, i);
        if (this.bIS != null) {
            this.bIS.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dl(i);
        }
    }

    public boolean onBackPressed() {
        if (this.duY == null || this.duY.CG() == null || this.duY.CG().getVisibility() != 0) {
            return false;
        }
        this.duY.DE();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EG() == 9486) {
            FeedData feedData = (FeedData) bVar.EH();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.duW) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.duW && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.duW.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.duZ = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.duX.a(c, 2, feedData.getFname());
            }
        }
    }

    public void axE() {
        if (this.duW != null) {
            this.duW.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bIS != null) {
                if (aVar.Fj()) {
                    this.bIS.lM();
                    if (aVar.Fh()) {
                        this.bIS.eX(w.l.loading);
                    } else if (aVar.Fi()) {
                        this.bIS.eX(w.l.loading);
                    } else {
                        this.bIS.eY(w.l.no_more_msg);
                    }
                } else {
                    this.bIS.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                axF();
            } else {
                axE();
            }
        }
    }

    public void axF() {
        if (this.mPullView != null) {
            this.mPullView.a((ae.b) null);
        }
        if (this.duW != null) {
            this.duW.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.duN);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.duY != null) {
            this.duY.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gH(boolean z) {
        BdListViewHelper.a(this.alM, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.duW != null && this.duW.getWrappedAdapter() != null && this.duW.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fR().post(new bd(this));
        }
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.duY != null) {
            this.duY.onDestory();
        }
    }
}
