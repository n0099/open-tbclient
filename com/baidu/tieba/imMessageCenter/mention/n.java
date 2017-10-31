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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class n extends com.baidu.adp.base.c<ReplyMessageActivity> {
    private View amw;
    private com.baidu.tbadk.mvc.g.a bZJ;
    private NoNetworkView bgD;
    private final AbsListView.OnScrollListener cyB;
    private final ReplyMessageActivity dRS;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dRe;
    private NavigationBar dRg;
    private BdListView dSb;
    private ReplyMeModel dSc;
    private com.baidu.tbadk.editortools.pb.f dSd;
    private FeedData dSe;
    private String dSf;
    private long dSg;
    private long dSh;
    private DataModel<g> dSi;
    private final ReplyMeModel.a dSj;
    private String mForumId;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dSb = null;
        this.dSc = null;
        this.dSj = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dSf = str;
                n.this.dSg = j2;
                n.this.dSh = j3;
                if (n.this.dSd != null) {
                    if (!n.this.dSe.getIsFloor() || n.this.dSe.getReplyer() == null) {
                        n.this.dSd.ga(null);
                    } else {
                        n.this.dSd.ga(n.this.dSe.getReplyer().getName_show());
                    }
                }
            }
        };
        this.cyB = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dSd != null) {
                    n.this.dSd.DG();
                }
            }
        };
        this.dRS = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dRe != null) {
                this.dRe.D(fVar.aDd());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v40, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Pa() {
        this.mRootView = (RelativeLayout) this.dRS.getActivity().getLayoutInflater().inflate(d.h.reply_me_activity, (ViewGroup) null);
        this.dRS.setContentView(this.mRootView);
        this.dSb = (BdListView) this.mRootView.findViewById(d.g.replyme_lv);
        this.dRg = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.dRg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dRg.setCenterTextTitle(getPageContext().getString(d.j.reply_me));
        this.dRg.showBottomLine();
        this.dRe = new com.baidu.tbadk.mvc.f.d<>(this.dRS.getPageContext(), k.class, d.h.mention_replyme_item, this.dRS.Fw());
        this.dRe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dRS.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dSb.setAdapter((ListAdapter) this.dRe);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dRS.getPageContext());
        this.mPullView.a(this.dRS);
        this.bZJ = new com.baidu.tbadk.mvc.g.a(this.dRS);
        this.bZJ.kX();
        this.amw = new TextView(this.dRS.getPageContext().getPageActivity());
        this.amw.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dRS.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amw, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dSb.setNextPage(this.bZJ);
        this.dSb.setPullRefresh(this.mPullView);
        this.dSb.addHeaderView(this.amw, 0);
        this.bgD = (NoNetworkView) this.mRootView.findViewById(d.g.no_networkview);
        this.bgD.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bgD.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                n.this.gP(z);
            }
        });
        this.dSc = new ReplyMeModel(this.dRS);
        this.dSc.a(this.dSj);
        this.dSb.setOnScrollListener(this.cyB);
        this.dSb.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dRS.Oh();
            }
        });
        this.dSi = new DataModel<g>(com.baidu.adp.base.i.Y(this.dRS.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Db() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fP(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.dSf);
                writeData.setThreadId(n.this.dSe.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dSe.getIsFloor()) {
                    writeData.setFloor(n.this.dSg > 0 ? String.valueOf(n.this.dSg) : n.this.dSe.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dSe.getPost_id());
                }
                if (n.this.dSh > 0) {
                    writeData.setRepostId(String.valueOf(n.this.dSh));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Dc() {
                return null;
            }
        };
        this.dSd = (com.baidu.tbadk.editortools.pb.f) new com.baidu.tbadk.editortools.pb.g().aW(this.dRS.getPageContext().getPageActivity());
        this.dSd.a(this.dRS.getPageContext());
        this.dSd.b(this.dSi);
        this.dSd.e(this.dRS.getPageContext());
        this.dSd.CI().bw(true);
        this.dSd.CI().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dSd.CI() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dSd.CI(), layoutParams);
            this.dSd.CI().hide();
        }
        this.dSd.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Df() {
                n.this.dRS.showProgressBar();
            }
        });
        this.dSd.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                n.this.dRS.hideProgressBar();
                n.this.dSd.CI().hide();
                if (postWriteCallBackData != null && qVar == null && !AntiHelper.tW(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dRS.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dRe != null) {
            this.dRe.notifyDataSetChanged();
            this.dRe.b(tbPageContext, i);
        }
        if (this.dSd != null && this.dSd.CI() != null) {
            this.dSd.CI().onChangeSkinType(i);
        }
        this.dRg.onChangeSkinType(tbPageContext, i);
        if (this.bZJ != null) {
            this.bZJ.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dSd == null || this.dSd.CI() == null || this.dSd.CI().getVisibility() != 0) {
            return false;
        }
        this.dSd.DG();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EO() == 9486) {
            FeedData feedData = (FeedData) bVar.EP();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dSb) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dSb && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dSb.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dSe = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dSc.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aCV() {
        if (this.dSb != null) {
            this.dSb.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bZJ != null) {
                if (aVar.Fq()) {
                    this.bZJ.lG();
                    if (aVar.Fo()) {
                        this.bZJ.fn(d.j.loading);
                    } else if (aVar.Fp()) {
                        this.bZJ.fn(d.j.loading);
                    } else {
                        this.bZJ.fo(d.j.no_more_msg);
                    }
                } else {
                    this.bZJ.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aCW();
            } else {
                aCV();
            }
        }
    }

    public void aCW() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dSb != null) {
            this.dSb.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dRS);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dSd != null) {
            this.dSd.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gP(boolean z) {
        BdListViewHelper.a(this.amw, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dSb != null && this.dSb.getWrappedAdapter() != null && this.dSb.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dSb.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dSd != null) {
            this.dSd.onDestory();
        }
    }
}
