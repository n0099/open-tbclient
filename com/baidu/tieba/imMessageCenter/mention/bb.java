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
import com.baidu.tbadk.core.view.z;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.imMessageCenter.mention.au;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.base.f<ReplyMessageActivity> {
    private NoNetworkView Hj;
    private com.baidu.tbadk.editortools.e.a<ag> aSN;
    private View agt;
    private int aoG;
    private com.baidu.tbadk.mvc.g.a bfM;
    private final AbsListView.OnScrollListener bze;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, ap> cav;
    private final ReplyMessageActivity dcV;
    private NavigationBar dcj;
    private BdListView dde;
    private au ddf;
    private com.baidu.tbadk.editortools.e.p ddg;
    private FeedData ddh;
    private long ddi;
    private long ddj;
    private final au.a ddk;
    private com.baidu.tieba.tbadkCore.y ddl;
    private int mBottom;
    private String mForumId;
    private com.baidu.tbadk.core.view.ac mPullView;
    private RelativeLayout mRootView;

    public bb(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dde = null;
        this.ddf = null;
        this.ddk = new bc(this);
        this.ddl = null;
        this.bze = new bd(this);
        this.dcV = replyMessageActivity;
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View me() {
        this.mRootView = (RelativeLayout) this.dcV.getActivity().getLayoutInflater().inflate(r.h.reply_me_activity, (ViewGroup) null);
        this.dcV.setContentView(this.mRootView);
        this.dde = (BdListView) this.mRootView.findViewById(r.g.replyme_lv);
        this.dcj = (NavigationBar) this.mRootView.findViewById(r.g.view_navigation_bar);
        this.dcj.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dcj.setTitleText(r.j.reply_me);
        this.cav = new com.baidu.tbadk.mvc.f.d<>(this.dcV.getPageContext(), ap.class, r.h.mention_replyme_item, this.dcV.lI());
        this.cav.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dcV.getResources().getDimension(r.e.ds80)), NoDataViewFactory.d.dh(r.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dde.setAdapter((ListAdapter) this.cav);
        this.mPullView = new com.baidu.tbadk.core.view.ac(this.dcV.getPageContext());
        this.mPullView.a(this.dcV);
        this.bfM = new com.baidu.tbadk.mvc.g.a(this.dcV);
        this.bfM.kk();
        this.agt = new TextView(this.dcV.getPageContext().getPageActivity());
        this.agt.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.dcV.getPageContext().getPageActivity(), r.e.ds98)));
        BdListViewHelper.a(this.agt, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.gm());
        this.dde.setNextPage(this.bfM);
        this.dde.setPullRefresh(this.mPullView);
        this.dde.f(this.agt, 0);
        this.Hj = (NoNetworkView) this.mRootView.findViewById(r.g.no_networkview);
        this.Hj.onChangeSkinType(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.Hj.a(new be(this));
        this.ddf = new au(this.dcV);
        this.ddf.a(this.ddk);
        this.dde.setOnScrollListener(this.bze);
        this.dde.setExOnSrollToBottomListener(new bf(this));
        this.aSN = new bg(this, com.baidu.adp.base.l.C(this.dcV.getPageContext().getPageActivity()));
        this.ddg = (com.baidu.tbadk.editortools.e.p) new com.baidu.tbadk.editortools.e.t().al(this.dcV.getPageContext().getPageActivity());
        this.ddg.a(this.dcV.getPageContext());
        this.ddg.b(this.aSN);
        this.ddg.f(this.dcV.getPageContext());
        this.ddg.CB().bC(true);
        this.ddg.CB().onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.ddg.CB() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.ddg.CB(), layoutParams);
            this.ddg.CB().hide();
        }
        this.ddg.a(new bh(this));
        this.ddg.b(new bi(this));
        return this.mRootView;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.cav != null) {
            this.cav.notifyDataSetChanged();
            this.cav.a(tbPageContext, i);
        }
        if (this.ddg != null && this.ddg.CB() != null) {
            this.ddg.CB().onChangeSkinType(i);
        }
        this.dcj.onChangeSkinType(tbPageContext, i);
        if (this.bfM != null) {
            this.bfM.a(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dk(i);
        }
    }

    public boolean onBackPressed() {
        if (this.ddg == null || this.ddg.CB() == null || this.ddg.CB().getVisibility() != 0) {
            return false;
        }
        this.ddg.DA();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Ey() == 9486) {
            FeedData feedData = (FeedData) bVar.Ez();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dde) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dde && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dde.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.mBottom = rect.bottom;
                this.aoG = bVar.EA();
                this.ddh = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.h.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.h.b.c(feedData.getPost_id(), 0L);
                }
                this.ddf.b(c, 2, feedData.getFname());
            }
        }
    }

    public void auK() {
        if (this.dde != null) {
            this.dde.l(2000L);
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
        if (this.dde != null) {
            this.dde.kv();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dcV);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.ddg != null) {
            this.ddg.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gx(boolean z) {
        BdListViewHelper.a(this.agt, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dde != null && this.dde.getWrappedAdapter() != null && this.dde.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.h.h.eG().post(new bj(this));
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.ddg != null) {
            this.ddg.onDestory();
        }
    }
}
