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
    private View amm;
    private com.baidu.tbadk.mvc.g.a bSr;
    private NoNetworkView bga;
    private final AbsListView.OnScrollListener crs;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dJF;
    private NavigationBar dJH;
    private BdListView dKD;
    private ReplyMeModel dKE;
    private com.baidu.tbadk.editortools.pb.e dKF;
    private FeedData dKG;
    private String dKH;
    private long dKI;
    private long dKJ;
    private DataModel<g> dKK;
    private final ReplyMeModel.a dKL;
    private final ReplyMessageActivity dKu;
    private String mForumId;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dKD = null;
        this.dKE = null;
        this.dKL = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dKH = str;
                n.this.dKI = j2;
                n.this.dKJ = j3;
                if (n.this.dKF != null) {
                    if (!n.this.dKG.getIsFloor() || n.this.dKG.getReplyer() == null) {
                        n.this.dKF.fU(null);
                    } else {
                        n.this.dKF.fU(n.this.dKG.getReplyer().getName_show());
                    }
                }
            }
        };
        this.crs = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dKF != null) {
                    n.this.dKF.Dx();
                }
            }
        };
        this.dKu = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dJF != null) {
                this.dJF.C(fVar.aAN());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Zi() {
        this.mRootView = (RelativeLayout) this.dKu.getActivity().getLayoutInflater().inflate(d.j.reply_me_activity, (ViewGroup) null);
        this.dKu.setContentView(this.mRootView);
        this.dKD = (BdListView) this.mRootView.findViewById(d.h.replyme_lv);
        this.dJH = (NavigationBar) this.mRootView.findViewById(d.h.view_navigation_bar);
        this.dJH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dJH.setTitleText(d.l.reply_me);
        this.dJF = new com.baidu.tbadk.mvc.f.d<>(this.dKu.getPageContext(), k.class, d.j.mention_replyme_item, this.dKu.Fq());
        this.dJF.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dKu.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.dq(d.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dKD.setAdapter((ListAdapter) this.dJF);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dKu.getPageContext());
        this.mPullView.a(this.dKu);
        this.bSr = new com.baidu.tbadk.mvc.g.a(this.dKu);
        this.bSr.ld();
        this.amm = new TextView(this.dKu.getPageContext().getPageActivity());
        this.amm.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dKu.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.amm, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dKD.setNextPage(this.bSr);
        this.dKD.setPullRefresh(this.mPullView);
        this.dKD.addHeaderView(this.amm, 0);
        this.bga = (NoNetworkView) this.mRootView.findViewById(d.h.no_networkview);
        this.bga.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bga.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                n.this.gU(z);
            }
        });
        this.dKE = new ReplyMeModel(this.dKu);
        this.dKE.a(this.dKL);
        this.dKD.setOnScrollListener(this.crs);
        this.dKD.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dKu.Oh();
            }
        });
        this.dKK = new DataModel<g>(com.baidu.adp.base.i.Y(this.dKu.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean CT() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fJ(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.dKH);
                writeData.setThreadId(n.this.dKG.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dKG.getIsFloor()) {
                    writeData.setFloor(n.this.dKI > 0 ? String.valueOf(n.this.dKI) : n.this.dKG.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dKG.getPost_id());
                }
                if (n.this.dKJ > 0) {
                    writeData.setRepostId(String.valueOf(n.this.dKJ));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String CU() {
                return null;
            }
        };
        this.dKF = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aX(this.dKu.getPageContext().getPageActivity());
        this.dKF.a(this.dKu.getPageContext());
        this.dKF.b(this.dKK);
        this.dKF.e(this.dKu.getPageContext());
        this.dKF.Cz().bC(true);
        this.dKF.Cz().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dKF.Cz() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dKF.Cz(), layoutParams);
            this.dKF.Cz().hide();
        }
        this.dKF.a(new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.b
            public void CW() {
                n.this.dKu.showProgressBar();
            }
        });
        this.dKF.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                n.this.dKu.hideProgressBar();
                n.this.dKF.Cz().hide();
                if (postWriteCallBackData != null && qVar == null && !AntiHelper.tG(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dKu.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dJF != null) {
            this.dJF.notifyDataSetChanged();
            this.dJF.b(tbPageContext, i);
        }
        if (this.dKF != null && this.dKF.Cz() != null) {
            this.dKF.Cz().onChangeSkinType(i);
        }
        this.dJH.onChangeSkinType(tbPageContext, i);
        if (this.bSr != null) {
            this.bSr.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dKF == null || this.dKF.Cz() == null || this.dKF.Cz().getVisibility() != 0) {
            return false;
        }
        this.dKF.Dx();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EI() == 9486) {
            FeedData feedData = (FeedData) bVar.EJ();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dKD) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dKD && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dKD.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dKG = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dKE.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aAF() {
        if (this.dKD != null) {
            this.dKD.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bSr != null) {
                if (aVar.Fk()) {
                    this.bSr.lM();
                    if (aVar.Fi()) {
                        this.bSr.fn(d.l.loading);
                    } else if (aVar.Fj()) {
                        this.bSr.fn(d.l.loading);
                    } else {
                        this.bSr.fo(d.l.no_more_msg);
                    }
                } else {
                    this.bSr.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aAG();
            } else {
                aAF();
            }
        }
    }

    public void aAG() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dKD != null) {
            this.dKD.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dKu);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dKF != null) {
            this.dKF.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gU(boolean z) {
        BdListViewHelper.a(this.amm, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dKD != null && this.dKD.getWrappedAdapter() != null && this.dKD.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dKD.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dKF != null) {
            this.dKF.onDestory();
        }
    }
}
