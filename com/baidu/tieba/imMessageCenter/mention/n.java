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
    private View anJ;
    private com.baidu.tbadk.mvc.g.a bOm;
    private NoNetworkView beq;
    private final AbsListView.OnScrollListener cjW;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dDS;
    private NavigationBar dDU;
    private final ReplyMessageActivity dEF;
    private BdListView dEO;
    private ReplyMeModel dEP;
    private com.baidu.tbadk.editortools.pb.e dEQ;
    private FeedData dER;
    private String dES;
    private long dET;
    private long dEU;
    private DataModel<g> dEV;
    private final ReplyMeModel.a dEW;
    private String mForumId;
    private com.baidu.tbadk.core.view.l mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dEO = null;
        this.dEP = null;
        this.dEW = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dES = str;
                n.this.dET = j2;
                n.this.dEU = j3;
                if (n.this.dEQ != null) {
                    if (!n.this.dER.getIsFloor() || n.this.dER.getReplyer() == null) {
                        n.this.dEQ.gd(null);
                    } else {
                        n.this.dEQ.gd(n.this.dER.getReplyer().getName_show());
                    }
                }
            }
        };
        this.cjW = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dEQ != null) {
                    n.this.dEQ.DY();
                }
            }
        };
        this.dEF = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dDS != null) {
                this.dDS.D(fVar.azA());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View XR() {
        this.mRootView = (RelativeLayout) this.dEF.getActivity().getLayoutInflater().inflate(d.j.reply_me_activity, (ViewGroup) null);
        this.dEF.setContentView(this.mRootView);
        this.dEO = (BdListView) this.mRootView.findViewById(d.h.replyme_lv);
        this.dDU = (NavigationBar) this.mRootView.findViewById(d.h.view_navigation_bar);
        this.dDU.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dDU.setTitleText(d.l.reply_me);
        this.dDS = new com.baidu.tbadk.mvc.f.d<>(this.dEF.getPageContext(), k.class, d.j.mention_replyme_item, this.dEF.FN());
        this.dDS.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dEF.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dk(d.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dEO.setAdapter((ListAdapter) this.dDS);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dEF.getPageContext());
        this.mPullView.a(this.dEF);
        this.bOm = new com.baidu.tbadk.mvc.g.a(this.dEF);
        this.bOm.lk();
        this.anJ = new TextView(this.dEF.getPageContext().getPageActivity());
        this.anJ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dEF.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.anJ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        this.dEO.setNextPage(this.bOm);
        this.dEO.setPullRefresh(this.mPullView);
        this.dEO.addHeaderView(this.anJ, 0);
        this.beq = (NoNetworkView) this.mRootView.findViewById(d.h.no_networkview);
        this.beq.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.beq.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                n.this.gV(z);
            }
        });
        this.dEP = new ReplyMeModel(this.dEF);
        this.dEP.a(this.dEW);
        this.dEO.setOnScrollListener(this.cjW);
        this.dEO.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dEF.Nv();
            }
        });
        this.dEV = new DataModel<g>(com.baidu.adp.base.i.aa(this.dEF.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Du() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fS(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.dES);
                writeData.setThreadId(n.this.dER.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dER.getIsFloor()) {
                    writeData.setFloor(n.this.dET > 0 ? String.valueOf(n.this.dET) : n.this.dER.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dER.getPost_id());
                }
                if (n.this.dEU > 0) {
                    writeData.setRepostId(String.valueOf(n.this.dEU));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Dv() {
                return null;
            }
        };
        this.dEQ = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aR(this.dEF.getPageContext().getPageActivity());
        this.dEQ.a(this.dEF.getPageContext());
        this.dEQ.b(this.dEV);
        this.dEQ.g(this.dEF.getPageContext());
        this.dEQ.Da().bE(true);
        this.dEQ.Da().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dEQ.Da() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dEQ.Da(), layoutParams);
            this.dEQ.Da().hide();
        }
        this.dEQ.a(new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.b
            public void Dx() {
                n.this.dEF.showProgressBar();
            }
        });
        this.dEQ.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                n.this.dEF.hideProgressBar();
                n.this.dEQ.Da().hide();
                if (postWriteCallBackData != null && qVar == null && !AntiHelper.tn(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dEF.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dDS != null) {
            this.dDS.notifyDataSetChanged();
            this.dDS.b(tbPageContext, i);
        }
        if (this.dEQ != null && this.dEQ.Da() != null) {
            this.dEQ.Da().onChangeSkinType(i);
        }
        this.dDU.onChangeSkinType(tbPageContext, i);
        if (this.bOm != null) {
            this.bOm.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dEQ == null || this.dEQ.Da() == null || this.dEQ.Da().getVisibility() != 0) {
            return false;
        }
        this.dEQ.DY();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long d;
        if (bVar != null && bVar.Ff() == 9486) {
            FeedData feedData = (FeedData) bVar.Fg();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dEO) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dEO && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dEO.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dER = feedData;
                if (feedData.getIsFloor()) {
                    d = com.baidu.adp.lib.g.b.d(feedData.getQuote_pid(), 0L);
                } else {
                    d = com.baidu.adp.lib.g.b.d(feedData.getPost_id(), 0L);
                }
                this.dEP.a(d, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void azs() {
        if (this.dEO != null) {
            this.dEO.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bOm != null) {
                if (aVar.FH()) {
                    this.bOm.lT();
                    if (aVar.FF()) {
                        this.bOm.fc(d.l.loading);
                    } else if (aVar.FG()) {
                        this.bOm.fc(d.l.loading);
                    } else {
                        this.bOm.fd(d.l.no_more_msg);
                    }
                } else {
                    this.bOm.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                azt();
            } else {
                azs();
            }
        }
    }

    public void azt() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dEO != null) {
            this.dEO.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dEF);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dEQ != null) {
            this.dEQ.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gV(boolean z) {
        BdListViewHelper.a(this.anJ, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dEO != null && this.dEO.getWrappedAdapter() != null && this.dEO.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dEO.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dEQ != null) {
            this.dEQ.onDestory();
        }
    }
}
