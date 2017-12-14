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
import com.baidu.tbadk.core.view.h;
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
    private View amO;
    private NoNetworkView blu;
    private final AbsListView.OnScrollListener cIi;
    private com.baidu.tbadk.mvc.g.a ciI;
    private final ReplyMessageActivity eaR;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> eac;
    private NavigationBar eae;
    private BdListView eba;
    private ReplyMeModel ebb;
    private com.baidu.tbadk.editortools.pb.h ebc;
    private FeedData ebd;
    private String ebe;
    private long ebf;
    private long ebg;
    private DataModel<g> ebh;
    private final ReplyMeModel.a ebi;
    private String mForumId;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.eba = null;
        this.ebb = null;
        this.ebi = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.ebe = str;
                n.this.ebf = j2;
                n.this.ebg = j3;
                if (n.this.ebc != null) {
                    if (!n.this.ebd.getIsFloor() || n.this.ebd.getReplyer() == null) {
                        n.this.ebc.gd(null);
                    } else {
                        n.this.ebc.gd(n.this.ebd.getReplyer().getName_show());
                    }
                }
            }
        };
        this.cIi = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.ebc != null) {
                    n.this.ebc.Ea();
                }
            }
        };
        this.eaR = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eac != null) {
                this.eac.E(fVar.aEQ());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v40, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Qv() {
        this.mRootView = (RelativeLayout) this.eaR.getActivity().getLayoutInflater().inflate(d.h.reply_me_activity, (ViewGroup) null);
        this.eaR.setContentView(this.mRootView);
        this.eba = (BdListView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eae = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.eae.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eae.setCenterTextTitle(getPageContext().getString(d.j.reply_me));
        this.eae.showBottomLine();
        this.eac = new com.baidu.tbadk.mvc.f.d<>(this.eaR.getPageContext(), k.class, d.h.mention_replyme_item, this.eaR.FQ());
        this.eac.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eaR.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.eba.setAdapter((ListAdapter) this.eac);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eaR.getPageContext());
        this.mPullView.a(this.eaR);
        this.ciI = new com.baidu.tbadk.mvc.g.a(this.eaR);
        this.ciI.kX();
        this.amO = new TextView(this.eaR.getPageContext().getPageActivity());
        this.amO.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eaR.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amO, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.eba.setNextPage(this.ciI);
        this.eba.setPullRefresh(this.mPullView);
        this.eba.addHeaderView(this.amO, 0);
        this.blu = (NoNetworkView) this.mRootView.findViewById(d.g.no_networkview);
        this.blu.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.blu.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                n.this.hq(z);
            }
        });
        this.ebb = new ReplyMeModel(this.eaR);
        this.ebb.a(this.ebi);
        this.eba.setOnScrollListener(this.cIi);
        this.eba.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.eaR.PF();
            }
        });
        this.ebh = new DataModel<g>(com.baidu.adp.base.i.Y(this.eaR.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Dx() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData fS(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.ebe);
                writeData.setThreadId(n.this.ebd.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.ebd.getIsFloor()) {
                    writeData.setFloor(n.this.ebf > 0 ? String.valueOf(n.this.ebf) : n.this.ebd.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.ebd.getPost_id());
                }
                if (n.this.ebg > 0) {
                    writeData.setRepostId(String.valueOf(n.this.ebg));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Dy() {
                return null;
            }
        };
        this.ebc = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().aV(this.eaR.getPageContext().getPageActivity());
        this.ebc.a(this.eaR.getPageContext());
        this.ebc.b(this.ebh);
        this.ebc.e(this.eaR.getPageContext());
        this.ebc.De().by(true);
        this.ebc.De().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ebc.De() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.ebc.De(), layoutParams);
            this.ebc.De().hide();
        }
        this.ebc.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void DB() {
                n.this.eaR.showProgressBar();
            }
        });
        this.ebc.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
                n.this.eaR.hideProgressBar();
                n.this.ebc.De().hide();
                if (postWriteCallBackData != null && sVar == null && !AntiHelper.uB(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.eaR.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eac != null) {
            this.eac.notifyDataSetChanged();
            this.eac.b(tbPageContext, i);
        }
        if (this.ebc != null && this.ebc.De() != null) {
            this.ebc.De().onChangeSkinType(i);
        }
        this.eae.onChangeSkinType(tbPageContext, i);
        if (this.ciI != null) {
            this.ciI.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public boolean onBackPressed() {
        if (this.ebc == null || this.ebc.De() == null || this.ebc.De().getVisibility() != 0) {
            return false;
        }
        this.ebc.Ea();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Fi() == 9486) {
            FeedData feedData = (FeedData) bVar.Fj();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.eba) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.eba && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.eba.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.ebd = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.ebb.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aEI() {
        if (this.eba != null) {
            this.eba.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.ciI != null) {
                if (aVar.FK()) {
                    this.ciI.lE();
                    if (aVar.FI()) {
                        this.ciI.fl(d.j.loading);
                    } else if (aVar.FJ()) {
                        this.ciI.fl(d.j.loading);
                    } else {
                        this.ciI.fm(d.j.no_more_msg);
                    }
                } else {
                    this.ciI.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aEJ();
            } else {
                aEI();
            }
        }
    }

    public void aEJ() {
        if (this.mPullView != null) {
            this.mPullView.a((h.b) null);
        }
        if (this.eba != null) {
            this.eba.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eaR);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.ebc != null) {
            this.ebc.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.ebc.De().Bn();
        this.ebc.Ea();
        this.ebc.De().Do();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ebc.b(writeData);
                this.ebc.setVoiceModel(pbEditorData.getVoiceModel());
                r eP = this.ebc.De().eP(6);
                if (eP != null && eP.aBT != null) {
                    eP.aBT.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ebc.DW();
                }
            }
        }
    }

    public void hq(boolean z) {
        BdListViewHelper.a(this.amO, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.eba != null && this.eba.getWrappedAdapter() != null && this.eba.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.eba.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.ebc != null) {
            this.ebc.onDestory();
        }
    }
}
