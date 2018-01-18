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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
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
    private NoNetworkView bYQ;
    private com.baidu.tbadk.mvc.g.a dbT;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> eNJ;
    private NavigationBar eNL;
    private BdListView eOG;
    private ReplyMeModel eOH;
    private com.baidu.tbadk.editortools.pb.h eOI;
    private FeedData eOJ;
    private String eOK;
    private long eOL;
    private long eOM;
    private DataModel<g> eON;
    private final ReplyMeModel.a eOO;
    private final ReplyMessageActivity eOx;
    private final AbsListView.OnScrollListener enT;
    private String mForumId;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.eOG = null;
        this.eOH = null;
        this.eOO = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.eOK = str;
                n.this.eOL = j2;
                n.this.eOM = j3;
                if (n.this.eOI != null) {
                    if (!n.this.eOJ.getIsFloor() || n.this.eOJ.getReplyer() == null) {
                        n.this.eOI.gl(null);
                    } else {
                        n.this.eOI.gl(n.this.eOJ.getReplyer().getName_show());
                    }
                }
            }
        };
        this.enT = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.eOI != null) {
                    n.this.eOI.Lp();
                }
            }
        };
        this.eOx = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eNJ != null) {
                this.eNJ.L(fVar.aLW());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v40, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View XH() {
        this.mRootView = (RelativeLayout) this.eOx.getActivity().getLayoutInflater().inflate(d.h.reply_me_activity, (ViewGroup) null);
        this.eOx.setContentView(this.mRootView);
        this.eOG = (BdListView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eNL = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.eNL.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eNL.setCenterTextTitle(getPageContext().getString(d.j.reply_me));
        this.eNL.showBottomLine();
        this.eNJ = new com.baidu.tbadk.mvc.f.d<>(this.eOx.getPageContext(), k.class, d.h.mention_replyme_item, this.eOx.Nd());
        this.eNJ.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eOx.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gn(d.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eOG.setAdapter((ListAdapter) this.eNJ);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eOx.getPageContext());
        this.mPullView.a(this.eOx);
        this.dbT = new com.baidu.tbadk.mvc.g.a(this.eOx);
        this.dbT.su();
        this.IZ = new TextView(this.eOx.getPageContext().getPageActivity());
        this.IZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.eOx.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oI());
        this.eOG.setNextPage(this.dbT);
        this.eOG.setPullRefresh(this.mPullView);
        this.eOG.addHeaderView(this.IZ, 0);
        this.bYQ = (NoNetworkView) this.mRootView.findViewById(d.g.no_networkview);
        this.bYQ.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bYQ.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bp(boolean z) {
                n.this.hS(z);
            }
        });
        this.eOH = new ReplyMeModel(this.eOx);
        this.eOH.a(this.eOO);
        this.eOG.setOnScrollListener(this.enT);
        this.eOG.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.eOx.WR();
            }
        });
        this.eON = new DataModel<g>(com.baidu.adp.base.i.ak(this.eOx.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean KN() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData ga(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.eOK);
                writeData.setThreadId(n.this.eOJ.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.eOJ.getIsFloor()) {
                    writeData.setFloor(n.this.eOL > 0 ? String.valueOf(n.this.eOL) : n.this.eOJ.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.eOJ.getPost_id());
                }
                if (n.this.eOM > 0) {
                    writeData.setRepostId(String.valueOf(n.this.eOM));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String KO() {
                return null;
            }
        };
        this.eOI = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bh(this.eOx.getPageContext().getPageActivity());
        this.eOI.a(this.eOx.getPageContext());
        this.eOI.b(this.eON);
        this.eOI.e(this.eOx.getPageContext());
        this.eOI.Ku().ca(true);
        this.eOI.Ku().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eOI.Ku() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eOI.Ku(), layoutParams);
            this.eOI.Ku().hide();
        }
        this.eOI.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void KR() {
                n.this.eOx.showProgressBar();
            }
        });
        this.eOI.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                n.this.eOx.hideProgressBar();
                n.this.eOI.Ku().hide();
                if (postWriteCallBackData != null && tVar == null && !AntiHelper.vQ(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.eOx.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eNJ != null) {
            this.eNJ.notifyDataSetChanged();
            this.eNJ.b(tbPageContext, i);
        }
        if (this.eOI != null && this.eOI.Ku() != null) {
            this.eOI.Ku().onChangeSkinType(i);
        }
        this.eNL.onChangeSkinType(tbPageContext, i);
        if (this.dbT != null) {
            this.dbT.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
    }

    public boolean onBackPressed() {
        if (this.eOI == null || this.eOI.Ku() == null || this.eOI.Ku().getVisibility() != 0) {
            return false;
        }
        this.eOI.Lp();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Mv() == 9486) {
            FeedData feedData = (FeedData) bVar.Mw();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.eOG) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.eOG && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.eOG.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.eOJ = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.eOH.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aLO() {
        if (this.eOG != null) {
            this.eOG.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.dbT != null) {
                if (aVar.MX()) {
                    this.dbT.th();
                    if (aVar.MV()) {
                        this.dbT.ig(d.j.loading);
                    } else if (aVar.MW()) {
                        this.dbT.ig(d.j.loading);
                    } else {
                        this.dbT.ih(d.j.no_more_msg);
                    }
                } else {
                    this.dbT.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aLP();
            } else {
                aLO();
            }
        }
    }

    public void aLP() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.eOG != null) {
            this.eOG.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eOx);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eOI != null) {
            this.eOI.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eOI.Ku().IE();
        this.eOI.Lp();
        this.eOI.Ku().KE();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eOI.b(writeData);
                this.eOI.setVoiceModel(pbEditorData.getVoiceModel());
                r hJ = this.eOI.Ku().hJ(6);
                if (hJ != null && hJ.bqa != null) {
                    hJ.bqa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eOI.Ll();
                }
            }
        }
    }

    public void hS(boolean z) {
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.eOG != null && this.eOG.getWrappedAdapter() != null && this.eOG.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.nr().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.eOG.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eOI != null) {
            this.eOI.onDestory();
        }
    }
}
