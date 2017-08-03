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
    private View amq;
    private com.baidu.tbadk.mvc.g.a bNc;
    private NoNetworkView bdg;
    private final AbsListView.OnScrollListener ciQ;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dCB;
    private NavigationBar dCD;
    private FeedData dDA;
    private String dDB;
    private long dDC;
    private long dDD;
    private DataModel<g> dDE;
    private final ReplyMeModel.a dDF;
    private final ReplyMessageActivity dDo;
    private BdListView dDx;
    private ReplyMeModel dDy;
    private com.baidu.tbadk.editortools.pb.e dDz;
    private String mForumId;
    private com.baidu.tbadk.core.view.l mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dDx = null;
        this.dDy = null;
        this.dDF = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dDB = str;
                n.this.dDC = j2;
                n.this.dDD = j3;
                if (n.this.dDz != null) {
                    if (!n.this.dDA.getIsFloor() || n.this.dDA.getReplyer() == null) {
                        n.this.dDz.fX(null);
                    } else {
                        n.this.dDz.fX(n.this.dDA.getReplyer().getName_show());
                    }
                }
            }
        };
        this.ciQ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dDz != null) {
                    n.this.dDz.DQ();
                }
            }
        };
        this.dDo = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dCB != null) {
                this.dCB.D(fVar.azp());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v39, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v42, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View XM() {
        this.mRootView = (RelativeLayout) this.dDo.getActivity().getLayoutInflater().inflate(d.j.reply_me_activity, (ViewGroup) null);
        this.dDo.setContentView(this.mRootView);
        this.dDx = (BdListView) this.mRootView.findViewById(d.h.replyme_lv);
        this.dCD = (NavigationBar) this.mRootView.findViewById(d.h.view_navigation_bar);
        this.dCD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dCD.setTitleText(d.l.reply_me);
        this.dCB = new com.baidu.tbadk.mvc.f.d<>(this.dDo.getPageContext(), k.class, d.j.mention_replyme_item, this.dDo.FF());
        this.dCB.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dDo.getResources().getDimension(d.f.ds80)), NoDataViewFactory.d.di(d.l.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dDx.setAdapter((ListAdapter) this.dCB);
        this.mPullView = new com.baidu.tbadk.core.view.l(this.dDo.getPageContext());
        this.mPullView.a(this.dDo);
        this.bNc = new com.baidu.tbadk.mvc.g.a(this.dDo);
        this.bNc.la();
        this.amq = new TextView(this.dDo.getPageContext().getPageActivity());
        this.amq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.dDo.getPageContext().getPageActivity(), d.f.ds98)));
        BdListViewHelper.a(this.amq, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.i.hh());
        this.dDx.setNextPage(this.bNc);
        this.dDx.setPullRefresh(this.mPullView);
        this.dDx.addHeaderView(this.amq, 0);
        this.bdg = (NoNetworkView) this.mRootView.findViewById(d.h.no_networkview);
        this.bdg.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bdg.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aM(boolean z) {
                n.this.gV(z);
            }
        });
        this.dDy = new ReplyMeModel(this.dDo);
        this.dDy.a(this.dDF);
        this.dDx.setOnScrollListener(this.ciQ);
        this.dDx.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dDo.Nq();
            }
        });
        this.dDE = new DataModel<g>(com.baidu.adp.base.i.Z(this.dDo.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Dm() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fM(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.dDB);
                writeData.setThreadId(n.this.dDA.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dDA.getIsFloor()) {
                    writeData.setFloor(n.this.dDC > 0 ? String.valueOf(n.this.dDC) : n.this.dDA.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dDA.getPost_id());
                }
                if (n.this.dDD > 0) {
                    writeData.setRepostId(String.valueOf(n.this.dDD));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Dn() {
                return null;
            }
        };
        this.dDz = (com.baidu.tbadk.editortools.pb.e) new com.baidu.tbadk.editortools.pb.f().aQ(this.dDo.getPageContext().getPageActivity());
        this.dDz.a(this.dDo.getPageContext());
        this.dDz.b(this.dDE);
        this.dDz.g(this.dDo.getPageContext());
        this.dDz.CS().bE(true);
        this.dDz.CS().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dDz.CS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dDz.CS(), layoutParams);
            this.dDz.CS().hide();
        }
        this.dDz.a(new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.b
            public void Dp() {
                n.this.dDo.showProgressBar();
            }
        });
        this.dDz.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, q qVar, WriteData writeData, AntiData antiData) {
                n.this.dDo.hideProgressBar();
                n.this.dDz.CS().hide();
                if (postWriteCallBackData != null && qVar == null && !AntiHelper.tn(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dDo.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dCB != null) {
            this.dCB.notifyDataSetChanged();
            this.dCB.b(tbPageContext, i);
        }
        if (this.dDz != null && this.dDz.CS() != null) {
            this.dDz.CS().onChangeSkinType(i);
        }
        this.dCD.onChangeSkinType(tbPageContext, i);
        if (this.bNc != null) {
            this.bNc.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dn(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dDz == null || this.dDz.CS() == null || this.dDz.CS().getVisibility() != 0) {
            return false;
        }
        this.dDz.DQ();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.EX() == 9486) {
            FeedData feedData = (FeedData) bVar.EY();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dDx) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dDx && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dDx.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dDA = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dDy.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void azh() {
        if (this.dDx != null) {
            this.dDx.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.bNc != null) {
                if (aVar.Fz()) {
                    this.bNc.lJ();
                    if (aVar.Fx()) {
                        this.bNc.fa(d.l.loading);
                    } else if (aVar.Fy()) {
                        this.bNc.fa(d.l.loading);
                    } else {
                        this.bNc.fb(d.l.no_more_msg);
                    }
                } else {
                    this.bNc.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                azi();
            } else {
                azh();
            }
        }
    }

    public void azi() {
        if (this.mPullView != null) {
            this.mPullView.a((k.b) null);
        }
        if (this.dDx != null) {
            this.dDx.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dDo);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dDz != null) {
            this.dDz.onActivityResult(i, i2, intent);
            return false;
        }
        return false;
    }

    public void gV(boolean z) {
        BdListViewHelper.a(this.amq, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dDx != null && this.dDx.getWrappedAdapter() != null && this.dDx.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dDx.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dDz != null) {
            this.dDz.onDestory();
        }
    }
}
