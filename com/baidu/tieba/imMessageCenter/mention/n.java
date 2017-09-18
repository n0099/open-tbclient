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
    private View anc;
    private com.baidu.tbadk.mvc.g.a bSG;
    private NoNetworkView bem;
    private final AbsListView.OnScrollListener cqV;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dNn;
    private NavigationBar dNp;
    private final ReplyMessageActivity dOc;
    private BdListView dOl;
    private ReplyMeModel dOm;
    private com.baidu.tbadk.editortools.pb.e dOn;
    private FeedData dOo;
    private String dOp;
    private long dOq;
    private long dOr;
    private DataModel<g> dOs;
    private final ReplyMeModel.a dOt;
    private String mForumId;
    private com.baidu.tbadk.core.view.l mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dOl = null;
        this.dOm = null;
        this.dOt = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dOp = str;
                n.this.dOq = j2;
                n.this.dOr = j3;
                if (n.this.dOn != null) {
                    if (!n.this.dOo.getIsFloor() || n.this.dOo.getReplyer() == null) {
                        n.this.dOn.gb(null);
                    } else {
                        n.this.dOn.gb(n.this.dOo.getReplyer().getName_show());
                    }
                }
            }
        };
        this.cqV = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dOn != null) {
                    n.this.dOn.DT();
                }
            }
        };
        this.dOc = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dNn != null) {
                this.dNn.D(fVar.aCc());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Zx() {
        this.mRootView = (RelativeLayout) this.dOc.getActivity().getLayoutInflater().inflate(d.j.reply_me_activity, (ViewGroup) null);
        this.dOc.setContentView(this.mRootView);
        this.dOl = (BdListView) this.mRootView.findViewById(d.h.replyme_lv);
        this.dNp = (NavigationBar) this.mRootView.findViewById(d.h.view_navigation_bar);
        this.dNp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dNp.setTitleText(d.l.reply_me);
        this.dNn = new com.baidu.tbadk.mvc.f.d<>(this.dOc.getPageContext(), k.class, d.j.mention_replyme_item, this.dOc.FL());
        this.dNn.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dOc.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dl(d.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dOl.setAdapter((ListAdapter) this.dNn);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dOc.getPageContext());
        this.mPullView.a(this.dOc);
        this.bSG = new com.baidu.tbadk.mvc.g.a(this.dOc);
        this.bSG.lb();
        this.anc = new TextView(this.dOc.getPageContext().getPageActivity());
        this.anc.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.f(this.dOc.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.anc, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hi());
        this.dOl.setNextPage(this.bSG);
        this.dOl.setPullRefresh(this.mPullView);
        this.dOl.addHeaderView(this.anc, 0);
        this.bem = (NoNetworkView) this.mRootView.findViewById(d.h.no_networkview);
        this.bem.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bem.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                n.this.hh(z);
            }
        });
        this.dOm = new ReplyMeModel(this.dOc);
        this.dOm.a(this.dOt);
        this.dOl.setOnScrollListener(this.cqV);
        this.dOl.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dOc.NM();
            }
        });
        this.dOs = new DataModel<g>(com.baidu.adp.base.i.Y(this.dOc.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
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
                writeData.setForumName(n.this.dOp);
                writeData.setThreadId(n.this.dOo.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dOo.getIsFloor()) {
                    writeData.setFloor(n.this.dOq > 0 ? String.valueOf(n.this.dOq) : n.this.dOo.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dOo.getPost_id());
                }
                if (n.this.dOr > 0) {
                    writeData.setRepostId(String.valueOf(n.this.dOr));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Dq() {
                return null;
            }
        };
        this.dOn = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aX(this.dOc.getPageContext().getPageActivity());
        this.dOn.a(this.dOc.getPageContext());
        this.dOn.b(this.dOs);
        this.dOn.g(this.dOc.getPageContext());
        this.dOn.CV().bD(true);
        this.dOn.CV().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dOn.CV() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dOn.CV(), layoutParams);
            this.dOn.CV().hide();
        }
        this.dOn.a(new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.b
            public void Ds() {
                n.this.dOc.showProgressBar();
            }
        });
        this.dOn.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                n.this.dOc.hideProgressBar();
                n.this.dOn.CV().hide();
                if (postWriteCallBackData != null && qVar == null && !AntiHelper.tB(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dOc.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dNn != null) {
            this.dNn.notifyDataSetChanged();
            this.dNn.b(tbPageContext, i);
        }
        if (this.dOn != null && this.dOn.CV() != null) {
            this.dOn.CV().onChangeSkinType(i);
        }
        this.dNp.onChangeSkinType(tbPageContext, i);
        if (this.bSG != null) {
            this.bSG.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dq(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dOn == null || this.dOn.CV() == null || this.dOn.CV().getVisibility() != 0) {
            return false;
        }
        this.dOn.DT();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Fd() == 9486) {
            FeedData feedData = (FeedData) bVar.Fe();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dOl) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dOl && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dOl.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dOo = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dOm.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aBU() {
        if (this.dOl != null) {
            this.dOl.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bSG != null) {
                if (aVar.FF()) {
                    this.bSG.lK();
                    if (aVar.FD()) {
                        this.bSG.fc(d.l.loading);
                    } else if (aVar.FE()) {
                        this.bSG.fc(d.l.loading);
                    } else {
                        this.bSG.fd(d.l.no_more_msg);
                    }
                } else {
                    this.bSG.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aBV();
            } else {
                aBU();
            }
        }
    }

    public void aBV() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dOl != null) {
            this.dOl.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dOc);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dOn != null) {
            this.dOn.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void hh(boolean z) {
        BdListViewHelper.a(this.anc, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dOl != null && this.dOl.getWrappedAdapter() != null && this.dOl.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fQ().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dOl.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dOn != null) {
            this.dOn.onDestory();
        }
    }
}
