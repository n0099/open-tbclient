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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class n extends com.baidu.adp.base.c<ReplyMessageActivity> {
    private View amR;
    private NoNetworkView blt;
    private final AbsListView.OnScrollListener cHZ;
    private com.baidu.tbadk.mvc.g.a ciu;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> dYX;
    private NavigationBar dYZ;
    private final ReplyMessageActivity dZM;
    private BdListView dZV;
    private ReplyMeModel dZW;
    private com.baidu.tbadk.editortools.pb.h dZX;
    private FeedData dZY;
    private String dZZ;
    private long eaa;
    private long eab;
    private DataModel<g> eac;
    private final ReplyMeModel.a ead;
    private String mForumId;
    private com.baidu.tbadk.core.view.h mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.dZV = null;
        this.dZW = null;
        this.ead = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.dZZ = str;
                n.this.eaa = j2;
                n.this.eab = j3;
                if (n.this.dZX != null) {
                    if (!n.this.dZY.getIsFloor() || n.this.dZY.getReplyer() == null) {
                        n.this.dZX.ge(null);
                    } else {
                        n.this.dZX.ge(n.this.dZY.getReplyer().getName_show());
                    }
                }
            }
        };
        this.cHZ = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.dZX != null) {
                    n.this.dZX.DZ();
                }
            }
        };
        this.dZM = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.dYX != null) {
                this.dYX.E(fVar.aEH());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v40, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Qv() {
        this.mRootView = (RelativeLayout) this.dZM.getActivity().getLayoutInflater().inflate(d.h.reply_me_activity, (ViewGroup) null);
        this.dZM.setContentView(this.mRootView);
        this.dZV = (BdListView) this.mRootView.findViewById(d.g.replyme_lv);
        this.dYZ = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.dYZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dYZ.setCenterTextTitle(getPageContext().getString(d.j.reply_me));
        this.dYZ.showBottomLine();
        this.dYX = new com.baidu.tbadk.mvc.f.d<>(this.dZM.getPageContext(), k.class, d.h.mention_replyme_item, this.dZM.FP());
        this.dYX.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.dZM.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.dZV.setAdapter((ListAdapter) this.dYX);
        this.mPullView = new com.baidu.tbadk.core.view.h(this.dZM.getPageContext());
        this.mPullView.a(this.dZM);
        this.ciu = new com.baidu.tbadk.mvc.g.a(this.dZM);
        this.ciu.kX();
        this.amR = new TextView(this.dZM.getPageContext().getPageActivity());
        this.amR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.dZM.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.dZV.setNextPage(this.ciu);
        this.dZV.setPullRefresh(this.mPullView);
        this.dZV.addHeaderView(this.amR, 0);
        this.blt = (NoNetworkView) this.mRootView.findViewById(d.g.no_networkview);
        this.blt.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.blt.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                n.this.hp(z);
            }
        });
        this.dZW = new ReplyMeModel(this.dZM);
        this.dZW.a(this.ead);
        this.dZV.setOnScrollListener(this.cHZ);
        this.dZV.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.dZM.PF();
            }
        });
        this.eac = new DataModel<g>(com.baidu.adp.base.i.Y(this.dZM.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Dw() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fT(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.dZZ);
                writeData.setThreadId(n.this.dZY.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.dZY.getIsFloor()) {
                    writeData.setFloor(n.this.eaa > 0 ? String.valueOf(n.this.eaa) : n.this.dZY.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.dZY.getPost_id());
                }
                if (n.this.eab > 0) {
                    writeData.setRepostId(String.valueOf(n.this.eab));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Dx() {
                return null;
            }
        };
        this.dZX = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().aY(this.dZM.getPageContext().getPageActivity());
        this.dZX.a(this.dZM.getPageContext());
        this.dZX.b(this.eac);
        this.dZX.e(this.dZM.getPageContext());
        this.dZX.Dd().bx(true);
        this.dZX.Dd().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.dZX.Dd() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.dZX.Dd(), layoutParams);
            this.dZX.Dd().hide();
        }
        this.dZX.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void DA() {
                n.this.dZM.showProgressBar();
            }
        });
        this.dZX.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, r rVar, WriteData writeData, AntiData antiData) {
                n.this.dZM.hideProgressBar();
                n.this.dZX.Dd().hide();
                if (postWriteCallBackData != null && rVar == null && !AntiHelper.uq(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.dZM.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.dYX != null) {
            this.dYX.notifyDataSetChanged();
            this.dYX.b(tbPageContext, i);
        }
        if (this.dZX != null && this.dZX.Dd() != null) {
            this.dZX.Dd().onChangeSkinType(i);
        }
        this.dYZ.onChangeSkinType(tbPageContext, i);
        if (this.ciu != null) {
            this.ciu.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public boolean onBackPressed() {
        if (this.dZX == null || this.dZX.Dd() == null || this.dZX.Dd().getVisibility() != 0) {
            return false;
        }
        this.dZX.DZ();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Fh() == 9486) {
            FeedData feedData = (FeedData) bVar.Fi();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.dZV) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.dZV && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.dZV.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.dZY = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.dZW.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aEz() {
        if (this.dZV != null) {
            this.dZV.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.ciu != null) {
                if (aVar.FJ()) {
                    this.ciu.lE();
                    if (aVar.FH()) {
                        this.ciu.fl(d.j.loading);
                    } else if (aVar.FI()) {
                        this.ciu.fl(d.j.loading);
                    } else {
                        this.ciu.fm(d.j.no_more_msg);
                    }
                } else {
                    this.ciu.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aEA();
            } else {
                aEz();
            }
        }
    }

    public void aEA() {
        if (this.mPullView != null) {
            this.mPullView.a((g.b) null);
        }
        if (this.dZV != null) {
            this.dZV.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.dZM);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.dZX != null) {
            this.dZX.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.dZX.Dd().Bm();
        this.dZX.DZ();
        this.dZX.Dd().Dn();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.dZX.b(writeData);
                this.dZX.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.r eP = this.dZX.Dd().eP(6);
                if (eP != null && eP.aBO != null) {
                    eP.aBO.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.dZX.DV();
                }
            }
        }
    }

    public void hp(boolean z) {
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.dZV != null && this.dZV.getWrappedAdapter() != null && this.dZV.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.dZV.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.dZX != null) {
            this.dZX.onDestory();
        }
    }
}
