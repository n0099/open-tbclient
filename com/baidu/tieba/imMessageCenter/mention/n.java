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
import com.baidu.tbadk.core.view.k;
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
    private View ane;
    private com.baidu.tbadk.mvc.g.a bRP;
    private NoNetworkView bep;
    private final AbsListView.OnScrollListener cqd;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dMt;
    private NavigationBar dMv;
    private final ReplyMessageActivity dNi;
    private BdListView dNr;
    private ReplyMeModel dNs;
    private com.baidu.tbadk.editortools.pb.e dNt;
    private FeedData dNu;
    private String dNv;
    private long dNw;
    private long dNx;
    private DataModel<g> dNy;
    private final ReplyMeModel.a dNz;
    private String mForumId;
    private com.baidu.tbadk.core.view.l mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dNr = null;
        this.dNs = null;
        this.dNz = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dNv = str;
                n.this.dNw = j2;
                n.this.dNx = j3;
                if (n.this.dNt != null) {
                    if (!n.this.dNu.getIsFloor() || n.this.dNu.getReplyer() == null) {
                        n.this.dNt.gb(null);
                    } else {
                        n.this.dNt.gb(n.this.dNu.getReplyer().getName_show());
                    }
                }
            }
        };
        this.cqd = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dNt != null) {
                    n.this.dNt.DT();
                }
            }
        };
        this.dNi = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dMt != null) {
                this.dMt.D(fVar.aBR());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Zm() {
        this.mRootView = (RelativeLayout) this.dNi.getActivity().getLayoutInflater().inflate(d.j.reply_me_activity, (ViewGroup) null);
        this.dNi.setContentView(this.mRootView);
        this.dNr = (BdListView) this.mRootView.findViewById(d.h.replyme_lv);
        this.dMv = (NavigationBar) this.mRootView.findViewById(d.h.view_navigation_bar);
        this.dMv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dMv.setTitleText(d.l.reply_me);
        this.dMt = new com.baidu.tbadk.mvc.f.d<>(this.dNi.getPageContext(), k.class, d.j.mention_replyme_item, this.dNi.FL());
        this.dMt.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dNi.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dl(d.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dNr.setAdapter((ListAdapter) this.dMt);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dNi.getPageContext());
        this.mPullView.a(this.dNi);
        this.bRP = new com.baidu.tbadk.mvc.g.a(this.dNi);
        this.bRP.lb();
        this.ane = new TextView(this.dNi.getPageContext().getPageActivity());
        this.ane.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dNi.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.ane, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        this.dNr.setNextPage(this.bRP);
        this.dNr.setPullRefresh(this.mPullView);
        this.dNr.addHeaderView(this.ane, 0);
        this.bep = (NoNetworkView) this.mRootView.findViewById(d.h.no_networkview);
        this.bep.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bep.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                n.this.hg(z);
            }
        });
        this.dNs = new ReplyMeModel(this.dNi);
        this.dNs.a(this.dNz);
        this.dNr.setOnScrollListener(this.cqd);
        this.dNr.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dNi.NL();
            }
        });
        this.dNy = new DataModel<g>(com.baidu.adp.base.i.X(this.dNi.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Dp() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fQ(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.dNv);
                writeData.setThreadId(n.this.dNu.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dNu.getIsFloor()) {
                    writeData.setFloor(n.this.dNw > 0 ? String.valueOf(n.this.dNw) : n.this.dNu.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dNu.getPost_id());
                }
                if (n.this.dNx > 0) {
                    writeData.setRepostId(String.valueOf(n.this.dNx));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Dq() {
                return null;
            }
        };
        this.dNt = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aW(this.dNi.getPageContext().getPageActivity());
        this.dNt.a(this.dNi.getPageContext());
        this.dNt.b(this.dNy);
        this.dNt.g(this.dNi.getPageContext());
        this.dNt.CV().bD(true);
        this.dNt.CV().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dNt.CV() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dNt.CV(), layoutParams);
            this.dNt.CV().hide();
        }
        this.dNt.a(new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.b
            public void Ds() {
                n.this.dNi.showProgressBar();
            }
        });
        this.dNt.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                n.this.dNi.hideProgressBar();
                n.this.dNt.CV().hide();
                if (postWriteCallBackData != null && qVar == null && !AntiHelper.tz(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dNi.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dMt != null) {
            this.dMt.notifyDataSetChanged();
            this.dMt.b(tbPageContext, i);
        }
        if (this.dNt != null && this.dNt.CV() != null) {
            this.dNt.CV().onChangeSkinType(i);
        }
        this.dMv.onChangeSkinType(tbPageContext, i);
        if (this.bRP != null) {
            this.bRP.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dNt == null || this.dNt.CV() == null || this.dNt.CV().getVisibility() != 0) {
            return false;
        }
        this.dNt.DT();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Fd() == 9486) {
            FeedData feedData = (FeedData) bVar.Fe();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dNr) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dNr && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dNr.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dNu = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dNs.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aBJ() {
        if (this.dNr != null) {
            this.dNr.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bRP != null) {
                if (aVar.FF()) {
                    this.bRP.lK();
                    if (aVar.FD()) {
                        this.bRP.fc(d.l.loading);
                    } else if (aVar.FE()) {
                        this.bRP.fc(d.l.loading);
                    } else {
                        this.bRP.fd(d.l.no_more_msg);
                    }
                } else {
                    this.bRP.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aBK();
            } else {
                aBJ();
            }
        }
    }

    public void aBK() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dNr != null) {
            this.dNr.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dNi);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dNt != null) {
            this.dNt.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void hg(boolean z) {
        BdListViewHelper.a(this.ane, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dNr != null && this.dNr.getWrappedAdapter() != null && this.dNr.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dNr.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dNt != null) {
            this.dNt.onDestory();
        }
    }
}
