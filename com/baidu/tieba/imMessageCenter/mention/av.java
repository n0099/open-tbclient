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
    private NoNetworkView aZX;
    private View akY;
    private com.baidu.tbadk.mvc.g.a bHZ;
    private final AbsListView.OnScrollListener bUW;
    private final ReplyMessageActivity dmR;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, am> dmd;
    private NavigationBar dmf;
    private BdListView dna;
    private ReplyMeModel dnb;
    private com.baidu.tbadk.editortools.pb.n dnc;
    private FeedData dnd;
    private long dne;
    private long dnf;
    private DataModel<ad> dng;
    private final ReplyMeModel.a dnh;
    private String mForumId;
    private com.baidu.tbadk.core.view.ah mPullView;
    private RelativeLayout mRootView;

    public av(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dna = null;
        this.dnb = null;
        this.dnh = new aw(this);
        this.bUW = new ax(this);
        this.dmR = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof ac) {
            ac acVar = (ac) aVar;
            if (this.dmd != null) {
                this.dmd.x(acVar.auf());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View VN() {
        this.mRootView = (RelativeLayout) this.dmR.getActivity().getLayoutInflater().inflate(w.j.reply_me_activity, (ViewGroup) null);
        this.dmR.setContentView(this.mRootView);
        this.dna = (BdListView) this.mRootView.findViewById(w.h.replyme_lv);
        this.dmf = (NavigationBar) this.mRootView.findViewById(w.h.view_navigation_bar);
        this.dmf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dmf.setTitleText(w.l.reply_me);
        this.dmd = new com.baidu.tbadk.mvc.f.d<>(this.dmR.getPageContext(), am.class, w.j.mention_replyme_item, this.dmR.ES());
        this.dmd.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dmR.getResources().getDimension(w.f.ds80)), NoDataViewFactory.d.de(w.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dna.setAdapter((ListAdapter) this.dmd);
        this.mPullView = new com.baidu.tbadk.core.view.ah(this.dmR.getPageContext());
        this.mPullView.a(this.dmR);
        this.bHZ = new com.baidu.tbadk.mvc.g.a(this.dmR);
        this.bHZ.le();
        this.akY = new TextView(this.dmR.getPageContext().getPageActivity());
        this.akY.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dmR.getPageContext().getPageActivity(), w.f.ds98)));
        BdListViewHelper.a(this.akY, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hk());
        this.dna.setNextPage(this.bHZ);
        this.dna.setPullRefresh(this.mPullView);
        this.dna.addHeaderView(this.akY, 0);
        this.aZX = (NoNetworkView) this.mRootView.findViewById(w.h.no_networkview);
        this.aZX.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.aZX.a(new ay(this));
        this.dnb = new ReplyMeModel(this.dmR);
        this.dnb.a(this.dnh);
        this.dna.setOnScrollListener(this.bUW);
        this.dna.setExOnSrollToBottomListener(new az(this));
        this.dng = new ba(this, com.baidu.adp.base.k.Z(this.dmR.getPageContext().getPageActivity()));
        this.dnc = (com.baidu.tbadk.editortools.pb.n) new com.baidu.tbadk.editortools.pb.r().aQ(this.dmR.getPageContext().getPageActivity());
        this.dnc.a(this.dmR.getPageContext());
        this.dnc.b(this.dng);
        this.dnc.f(this.dmR.getPageContext());
        this.dnc.Cm().bA(true);
        this.dnc.Cm().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.dnc.Cm() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dnc.Cm(), layoutParams);
            this.dnc.Cm().hide();
        }
        this.dnc.a(new bb(this));
        this.dnc.b(new bc(this));
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dmd != null) {
            this.dmd.notifyDataSetChanged();
            this.dmd.b(tbPageContext, i);
        }
        if (this.dnc != null && this.dnc.Cm() != null) {
            this.dnc.Cm().onChangeSkinType(i);
        }
        this.dmf.onChangeSkinType(tbPageContext, i);
        if (this.bHZ != null) {
            this.bHZ.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dj(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dnc == null || this.dnc.Cm() == null || this.dnc.Cm().getVisibility() != 0) {
            return false;
        }
        this.dnc.Dk();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Ej() == 9486) {
            FeedData feedData = (FeedData) bVar.Ek();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dna) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dna && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dna.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dnd = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dnb.a(c, 2, feedData.getFname());
            }
        }
    }

    public void atW() {
        if (this.dna != null) {
            this.dna.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bHZ != null) {
                if (aVar.EM()) {
                    this.bHZ.lO();
                    if (aVar.EK()) {
                        this.bHZ.eV(w.l.loading);
                    } else if (aVar.EL()) {
                        this.bHZ.eV(w.l.loading);
                    } else {
                        this.bHZ.eW(w.l.no_more_msg);
                    }
                } else {
                    this.bHZ.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                atX();
            } else {
                atW();
            }
        }
    }

    public void atX() {
        if (this.mPullView != null) {
            this.mPullView.a((ae.b) null);
        }
        if (this.dna != null) {
            this.dna.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dmR);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dnc != null) {
            this.dnc.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gp(boolean z) {
        BdListViewHelper.a(this.akY, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dna != null && this.dna.getWrappedAdapter() != null && this.dna.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.h.fS().post(new bd(this));
        }
    }

    @Override // com.baidu.adp.base.e
    public void destroy() {
        if (this.dnc != null) {
            this.dnc.onDestory();
        }
    }
}
