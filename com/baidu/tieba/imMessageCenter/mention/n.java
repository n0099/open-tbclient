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
    private View ama;
    private com.baidu.tbadk.mvc.g.a bSf;
    private NoNetworkView bfM;
    private final AbsListView.OnScrollListener crg;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dJr;
    private NavigationBar dJt;
    private final ReplyMessageActivity dKg;
    private BdListView dKp;
    private ReplyMeModel dKq;
    private com.baidu.tbadk.editortools.pb.e dKr;
    private FeedData dKs;
    private String dKt;
    private long dKu;
    private long dKv;
    private DataModel<g> dKw;
    private final ReplyMeModel.a dKx;
    private String mForumId;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dKp = null;
        this.dKq = null;
        this.dKx = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dKt = str;
                n.this.dKu = j2;
                n.this.dKv = j3;
                if (n.this.dKr != null) {
                    if (!n.this.dKs.getIsFloor() || n.this.dKs.getReplyer() == null) {
                        n.this.dKr.fT(null);
                    } else {
                        n.this.dKr.fT(n.this.dKs.getReplyer().getName_show());
                    }
                }
            }
        };
        this.crg = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dKr != null) {
                    n.this.dKr.Dr();
                }
            }
        };
        this.dKg = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dJr != null) {
                this.dJr.C(fVar.aAI());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Ze() {
        this.mRootView = (RelativeLayout) this.dKg.getActivity().getLayoutInflater().inflate(d.j.reply_me_activity, (ViewGroup) null);
        this.dKg.setContentView(this.mRootView);
        this.dKp = (BdListView) this.mRootView.findViewById(d.h.replyme_lv);
        this.dJt = (NavigationBar) this.mRootView.findViewById(d.h.view_navigation_bar);
        this.dJt.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dJt.setTitleText(d.l.reply_me);
        this.dJr = new com.baidu.tbadk.mvc.f.d<>(this.dKg.getPageContext(), k.class, d.j.mention_replyme_item, this.dKg.Fk());
        this.dJr.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dKg.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dp(d.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dKp.setAdapter((ListAdapter) this.dJr);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dKg.getPageContext());
        this.mPullView.a(this.dKg);
        this.bSf = new com.baidu.tbadk.mvc.g.a(this.dKg);
        this.bSf.ld();
        this.ama = new TextView(this.dKg.getPageContext().getPageActivity());
        this.ama.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dKg.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.ama, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dKp.setNextPage(this.bSf);
        this.dKp.setPullRefresh(this.mPullView);
        this.dKp.addHeaderView(this.ama, 0);
        this.bfM = (NoNetworkView) this.mRootView.findViewById(d.h.no_networkview);
        this.bfM.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bfM.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aL(boolean z) {
                n.this.gT(z);
            }
        });
        this.dKq = new ReplyMeModel(this.dKg);
        this.dKq.a(this.dKx);
        this.dKp.setOnScrollListener(this.crg);
        this.dKp.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dKg.Ob();
            }
        });
        this.dKw = new DataModel<g>(com.baidu.adp.base.i.Y(this.dKg.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean CN() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fI(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.dKt);
                writeData.setThreadId(n.this.dKs.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dKs.getIsFloor()) {
                    writeData.setFloor(n.this.dKu > 0 ? String.valueOf(n.this.dKu) : n.this.dKs.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dKs.getPost_id());
                }
                if (n.this.dKv > 0) {
                    writeData.setRepostId(String.valueOf(n.this.dKv));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String CO() {
                return null;
            }
        };
        this.dKr = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aW(this.dKg.getPageContext().getPageActivity());
        this.dKr.a(this.dKg.getPageContext());
        this.dKr.b(this.dKw);
        this.dKr.e(this.dKg.getPageContext());
        this.dKr.Ct().bB(true);
        this.dKr.Ct().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dKr.Ct() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dKr.Ct(), layoutParams);
            this.dKr.Ct().hide();
        }
        this.dKr.a(new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.b
            public void CQ() {
                n.this.dKg.showProgressBar();
            }
        });
        this.dKr.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                n.this.dKg.hideProgressBar();
                n.this.dKr.Ct().hide();
                if (postWriteCallBackData != null && qVar == null && !AntiHelper.tF(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dKg.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dJr != null) {
            this.dJr.notifyDataSetChanged();
            this.dJr.b(tbPageContext, i);
        }
        if (this.dKr != null && this.dKr.Ct() != null) {
            this.dKr.Ct().onChangeSkinType(i);
        }
        this.dJt.onChangeSkinType(tbPageContext, i);
        if (this.bSf != null) {
            this.bSf.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dKr == null || this.dKr.Ct() == null || this.dKr.Ct().getVisibility() != 0) {
            return false;
        }
        this.dKr.Dr();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EC() == 9486) {
            FeedData feedData = (FeedData) bVar.ED();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dKp) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dKp && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dKp.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dKs = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dKq.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aAA() {
        if (this.dKp != null) {
            this.dKp.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bSf != null) {
                if (aVar.Fe()) {
                    this.bSf.lM();
                    if (aVar.Fc()) {
                        this.bSf.fm(d.l.loading);
                    } else if (aVar.Fd()) {
                        this.bSf.fm(d.l.loading);
                    } else {
                        this.bSf.fn(d.l.no_more_msg);
                    }
                } else {
                    this.bSf.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aAB();
            } else {
                aAA();
            }
        }
    }

    public void aAB() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dKp != null) {
            this.dKp.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dKg);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dKr != null) {
            this.dKr.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gT(boolean z) {
        BdListViewHelper.a(this.ama, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dKp != null && this.dKp.getWrappedAdapter() != null && this.dKp.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dKp.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dKr != null) {
            this.dKr.onDestory();
        }
    }
}
