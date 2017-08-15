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
    private View anK;
    private com.baidu.tbadk.mvc.g.a bOV;
    private NoNetworkView ber;
    private final AbsListView.OnScrollListener ckJ;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dFP;
    private NavigationBar dFR;
    private final ReplyMessageActivity dGC;
    private BdListView dGL;
    private ReplyMeModel dGM;
    private com.baidu.tbadk.editortools.pb.e dGN;
    private FeedData dGO;
    private String dGP;
    private long dGQ;
    private long dGR;
    private DataModel<g> dGS;
    private final ReplyMeModel.a dGT;
    private String mForumId;
    private com.baidu.tbadk.core.view.l mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dGL = null;
        this.dGM = null;
        this.dGT = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dGP = str;
                n.this.dGQ = j2;
                n.this.dGR = j3;
                if (n.this.dGN != null) {
                    if (!n.this.dGO.getIsFloor() || n.this.dGO.getReplyer() == null) {
                        n.this.dGN.gd(null);
                    } else {
                        n.this.dGN.gd(n.this.dGO.getReplyer().getName_show());
                    }
                }
            }
        };
        this.ckJ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dGN != null) {
                    n.this.dGN.DY();
                }
            }
        };
        this.dGC = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dFP != null) {
                this.dFP.D(fVar.aAh());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Ym() {
        this.mRootView = (RelativeLayout) this.dGC.getActivity().getLayoutInflater().inflate(d.j.reply_me_activity, (ViewGroup) null);
        this.dGC.setContentView(this.mRootView);
        this.dGL = (BdListView) this.mRootView.findViewById(d.h.replyme_lv);
        this.dFR = (NavigationBar) this.mRootView.findViewById(d.h.view_navigation_bar);
        this.dFR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFR.setTitleText(d.l.reply_me);
        this.dFP = new com.baidu.tbadk.mvc.f.d<>(this.dGC.getPageContext(), k.class, d.j.mention_replyme_item, this.dGC.FN());
        this.dFP.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dGC.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dk(d.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dGL.setAdapter((ListAdapter) this.dFP);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dGC.getPageContext());
        this.mPullView.a(this.dGC);
        this.bOV = new com.baidu.tbadk.mvc.g.a(this.dGC);
        this.bOV.lk();
        this.anK = new TextView(this.dGC.getPageContext().getPageActivity());
        this.anK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dGC.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.anK, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hr());
        this.dGL.setNextPage(this.bOV);
        this.dGL.setPullRefresh(this.mPullView);
        this.dGL.addHeaderView(this.anK, 0);
        this.ber = (NoNetworkView) this.mRootView.findViewById(d.h.no_networkview);
        this.ber.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.ber.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                n.this.gY(z);
            }
        });
        this.dGM = new ReplyMeModel(this.dGC);
        this.dGM.a(this.dGT);
        this.dGL.setOnScrollListener(this.ckJ);
        this.dGL.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dGC.Nv();
            }
        });
        this.dGS = new DataModel<g>(com.baidu.adp.base.i.aa(this.dGC.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
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
                writeData.setForumName(n.this.dGP);
                writeData.setThreadId(n.this.dGO.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dGO.getIsFloor()) {
                    writeData.setFloor(n.this.dGQ > 0 ? String.valueOf(n.this.dGQ) : n.this.dGO.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dGO.getPost_id());
                }
                if (n.this.dGR > 0) {
                    writeData.setRepostId(String.valueOf(n.this.dGR));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Dv() {
                return null;
            }
        };
        this.dGN = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aR(this.dGC.getPageContext().getPageActivity());
        this.dGN.a(this.dGC.getPageContext());
        this.dGN.b(this.dGS);
        this.dGN.g(this.dGC.getPageContext());
        this.dGN.Da().bE(true);
        this.dGN.Da().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dGN.Da() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dGN.Da(), layoutParams);
            this.dGN.Da().hide();
        }
        this.dGN.a(new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.b
            public void Dx() {
                n.this.dGC.showProgressBar();
            }
        });
        this.dGN.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                n.this.dGC.hideProgressBar();
                n.this.dGN.Da().hide();
                if (postWriteCallBackData != null && qVar == null && !AntiHelper.tx(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dGC.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dFP != null) {
            this.dFP.notifyDataSetChanged();
            this.dFP.b(tbPageContext, i);
        }
        if (this.dGN != null && this.dGN.Da() != null) {
            this.dGN.Da().onChangeSkinType(i);
        }
        this.dFR.onChangeSkinType(tbPageContext, i);
        if (this.bOV != null) {
            this.bOV.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dp(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dGN == null || this.dGN.Da() == null || this.dGN.Da().getVisibility() != 0) {
            return false;
        }
        this.dGN.DY();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long d;
        if (bVar != null && bVar.Ff() == 9486) {
            FeedData feedData = (FeedData) bVar.Fg();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dGL) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dGL && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dGL.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dGO = feedData;
                if (feedData.getIsFloor()) {
                    d = com.baidu.adp.lib.g.b.d(feedData.getQuote_pid(), 0L);
                } else {
                    d = com.baidu.adp.lib.g.b.d(feedData.getPost_id(), 0L);
                }
                this.dGM.a(d, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void azZ() {
        if (this.dGL != null) {
            this.dGL.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bOV != null) {
                if (aVar.FH()) {
                    this.bOV.lT();
                    if (aVar.FF()) {
                        this.bOV.fc(d.l.loading);
                    } else if (aVar.FG()) {
                        this.bOV.fc(d.l.loading);
                    } else {
                        this.bOV.fd(d.l.no_more_msg);
                    }
                } else {
                    this.bOV.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aAa();
            } else {
                azZ();
            }
        }
    }

    public void aAa() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dGL != null) {
            this.dGL.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dGC);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dGN != null) {
            this.dGN.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gY(boolean z) {
        BdListViewHelper.a(this.anK, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dGL != null && this.dGL.getWrappedAdapter() != null && this.dGL.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ga().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dGL.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dGN != null) {
            this.dGN.onDestory();
        }
    }
}
