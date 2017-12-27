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
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.i;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.s;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.r;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class n extends com.baidu.adp.base.c<ReplyMessageActivity> {
    private View IZ;
    private NoNetworkView bYJ;
    private com.baidu.tbadk.mvc.g.a cXp;
    private final ReplyMessageActivity eMY;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> eMj;
    private NavigationBar eMl;
    private BdListView eNh;
    private ReplyMeModel eNi;
    private com.baidu.tbadk.editortools.pb.h eNj;
    private FeedData eNk;
    private String eNl;
    private long eNm;
    private long eNn;
    private DataModel<g> eNo;
    private final ReplyMeModel.a eNp;
    private final AbsListView.OnScrollListener emv;
    private String mForumId;
    private com.baidu.tbadk.core.view.j mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.eNh = null;
        this.eNi = null;
        this.eNp = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.eNl = str;
                n.this.eNm = j2;
                n.this.eNn = j3;
                if (n.this.eNj != null) {
                    if (!n.this.eNk.getIsFloor() || n.this.eNk.getReplyer() == null) {
                        n.this.eNj.gk(null);
                    } else {
                        n.this.eNj.gk(n.this.eNk.getReplyer().getName_show());
                    }
                }
            }
        };
        this.emv = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.eNj != null) {
                    n.this.eNj.LB();
                }
            }
        };
        this.eMY = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eMj != null) {
                this.eMj.N(fVar.aLR());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v40, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View XT() {
        this.mRootView = (RelativeLayout) this.eMY.getActivity().getLayoutInflater().inflate(d.h.reply_me_activity, (ViewGroup) null);
        this.eMY.setContentView(this.mRootView);
        this.eNh = (BdListView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eMl = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.eMl.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eMl.setCenterTextTitle(getPageContext().getString(d.j.reply_me));
        this.eMl.showBottomLine();
        this.eMj = new com.baidu.tbadk.mvc.f.d<>(this.eMY.getPageContext(), k.class, d.h.mention_replyme_item, this.eMY.Np());
        this.eMj.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eMY.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eNh.setAdapter((ListAdapter) this.eMj);
        this.mPullView = new com.baidu.tbadk.core.view.j(this.eMY.getPageContext());
        this.mPullView.a(this.eMY);
        this.cXp = new com.baidu.tbadk.mvc.g.a(this.eMY);
        this.cXp.su();
        this.IZ = new TextView(this.eMY.getPageContext().getPageActivity());
        this.IZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.eMY.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        this.eNh.setNextPage(this.cXp);
        this.eNh.setPullRefresh(this.mPullView);
        this.eNh.addHeaderView(this.IZ, 0);
        this.bYJ = (NoNetworkView) this.mRootView.findViewById(d.g.no_networkview);
        this.bYJ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bYJ.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bp(boolean z) {
                n.this.hP(z);
            }
        });
        this.eNi = new ReplyMeModel(this.eMY);
        this.eNi.a(this.eNp);
        this.eNh.setOnScrollListener(this.emv);
        this.eNh.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.eMY.Xd();
            }
        });
        this.eNo = new DataModel<g>(com.baidu.adp.base.i.ak(this.eMY.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean KY() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fZ(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.eNl);
                writeData.setThreadId(n.this.eNk.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.eNk.getIsFloor()) {
                    writeData.setFloor(n.this.eNm > 0 ? String.valueOf(n.this.eNm) : n.this.eNk.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.eNk.getPost_id());
                }
                if (n.this.eNn > 0) {
                    writeData.setRepostId(String.valueOf(n.this.eNn));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String KZ() {
                return null;
            }
        };
        this.eNj = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bh(this.eMY.getPageContext().getPageActivity());
        this.eNj.a(this.eMY.getPageContext());
        this.eNj.b(this.eNo);
        this.eNj.e(this.eMY.getPageContext());
        this.eNj.KF().cc(true);
        this.eNj.KF().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eNj.KF() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eNj.KF(), layoutParams);
            this.eNj.KF().hide();
        }
        this.eNj.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Lc() {
                n.this.eMY.showProgressBar();
            }
        });
        this.eNj.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
                n.this.eMY.hideProgressBar();
                n.this.eNj.KF().hide();
                if (postWriteCallBackData != null && sVar == null && !AntiHelper.xo(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.eMY.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eMj != null) {
            this.eMj.notifyDataSetChanged();
            this.eMj.b(tbPageContext, i);
        }
        if (this.eNj != null && this.eNj.KF() != null) {
            this.eNj.KF().onChangeSkinType(i);
        }
        this.eMl.onChangeSkinType(tbPageContext, i);
        if (this.cXp != null) {
            this.cXp.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gy(i);
        }
    }

    public boolean onBackPressed() {
        if (this.eNj == null || this.eNj.KF() == null || this.eNj.KF().getVisibility() != 0) {
            return false;
        }
        this.eNj.LB();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.MH() == 9486) {
            FeedData feedData = (FeedData) bVar.MI();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.eNh) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.eNh && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.eNh.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.eNk = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.eNi.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aLJ() {
        if (this.eNh != null) {
            this.eNh.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.cXp != null) {
                if (aVar.Nj()) {
                    this.cXp.th();
                    if (aVar.Nh()) {
                        this.cXp.ik(d.j.loading);
                    } else if (aVar.Ni()) {
                        this.cXp.ik(d.j.loading);
                    } else {
                        this.cXp.il(d.j.no_more_msg);
                    }
                } else {
                    this.cXp.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aLK();
            } else {
                aLJ();
            }
        }
    }

    public void aLK() {
        if (this.mPullView != null) {
            this.mPullView.a((i.b) null);
        }
        if (this.eNh != null) {
            this.eNh.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eMY);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eNj != null) {
            this.eNj.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eNj.KF().IP();
        this.eNj.LB();
        this.eNj.KF().KP();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eNj.b(writeData);
                this.eNj.setVoiceModel(pbEditorData.getVoiceModel());
                r hN = this.eNj.KF().hN(6);
                if (hN != null && hN.bpR != null) {
                    hN.bpR.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eNj.Lx();
                }
            }
        }
    }

    public void hP(boolean z) {
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.eNh != null && this.eNh.getWrappedAdapter() != null && this.eNh.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.eNh.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eNj != null) {
            this.eNj.onDestory();
        }
    }
}
