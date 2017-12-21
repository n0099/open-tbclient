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
    private View amR;
    private NoNetworkView bly;
    private final AbsListView.OnScrollListener cIm;
    private com.baidu.tbadk.mvc.g.a ciM;
    private final ReplyMessageActivity eaV;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> eag;
    private NavigationBar eai;
    private BdListView ebe;
    private ReplyMeModel ebf;
    private com.baidu.tbadk.editortools.pb.h ebg;
    private FeedData ebh;
    private String ebi;
    private long ebj;
    private long ebk;
    private DataModel<g> ebl;
    private final ReplyMeModel.a ebm;
    private String mForumId;
    private com.baidu.tbadk.core.view.i mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.ebe = null;
        this.ebf = null;
        this.ebm = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.ebi = str;
                n.this.ebj = j2;
                n.this.ebk = j3;
                if (n.this.ebg != null) {
                    if (!n.this.ebh.getIsFloor() || n.this.ebh.getReplyer() == null) {
                        n.this.ebg.gd(null);
                    } else {
                        n.this.ebg.gd(n.this.ebh.getReplyer().getName_show());
                    }
                }
            }
        };
        this.cIm = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.ebg != null) {
                    n.this.ebg.Ea();
                }
            }
        };
        this.eaV = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eag != null) {
                this.eag.E(fVar.aEQ());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v40, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View Qv() {
        this.mRootView = (RelativeLayout) this.eaV.getActivity().getLayoutInflater().inflate(d.h.reply_me_activity, (ViewGroup) null);
        this.eaV.setContentView(this.mRootView);
        this.ebe = (BdListView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eai = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.eai.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eai.setCenterTextTitle(getPageContext().getString(d.j.reply_me));
        this.eai.showBottomLine();
        this.eag = new com.baidu.tbadk.mvc.f.d<>(this.eaV.getPageContext(), k.class, d.h.mention_replyme_item, this.eaV.FQ());
        this.eag.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eaV.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dq(d.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.ebe.setAdapter((ListAdapter) this.eag);
        this.mPullView = new com.baidu.tbadk.core.view.i(this.eaV.getPageContext());
        this.mPullView.a(this.eaV);
        this.ciM = new com.baidu.tbadk.mvc.g.a(this.eaV);
        this.ciM.kX();
        this.amR = new TextView(this.eaV.getPageContext().getPageActivity());
        this.amR.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.f(this.eaV.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.hh());
        this.ebe.setNextPage(this.ciM);
        this.ebe.setPullRefresh(this.mPullView);
        this.ebe.addHeaderView(this.amR, 0);
        this.bly = (NoNetworkView) this.mRootView.findViewById(d.g.no_networkview);
        this.bly.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bly.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void aJ(boolean z) {
                n.this.hq(z);
            }
        });
        this.ebf = new ReplyMeModel(this.eaV);
        this.ebf.a(this.ebm);
        this.ebe.setOnScrollListener(this.cIm);
        this.ebe.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.eaV.PF();
            }
        });
        this.ebl = new DataModel<g>(com.baidu.adp.base.i.Y(this.eaV.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
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
                writeData.setForumName(n.this.ebi);
                writeData.setThreadId(n.this.ebh.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.ebh.getIsFloor()) {
                    writeData.setFloor(n.this.ebj > 0 ? String.valueOf(n.this.ebj) : n.this.ebh.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.ebh.getPost_id());
                }
                if (n.this.ebk > 0) {
                    writeData.setRepostId(String.valueOf(n.this.ebk));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Dy() {
                return null;
            }
        };
        this.ebg = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().aV(this.eaV.getPageContext().getPageActivity());
        this.ebg.a(this.eaV.getPageContext());
        this.ebg.b(this.ebl);
        this.ebg.e(this.eaV.getPageContext());
        this.ebg.De().by(true);
        this.ebg.De().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ebg.De() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.ebg.De(), layoutParams);
            this.ebg.De().hide();
        }
        this.ebg.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void DB() {
                n.this.eaV.showProgressBar();
            }
        });
        this.ebg.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, s sVar, WriteData writeData, AntiData antiData) {
                n.this.eaV.hideProgressBar();
                n.this.ebg.De().hide();
                if (postWriteCallBackData != null && sVar == null && !AntiHelper.uB(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.eaV.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eag != null) {
            this.eag.notifyDataSetChanged();
            this.eag.b(tbPageContext, i);
        }
        if (this.ebg != null && this.ebg.De() != null) {
            this.ebg.De().onChangeSkinType(i);
        }
        this.eai.onChangeSkinType(tbPageContext, i);
        if (this.ciM != null) {
            this.ciM.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
    }

    public boolean onBackPressed() {
        if (this.ebg == null || this.ebg.De() == null || this.ebg.De().getVisibility() != 0) {
            return false;
        }
        this.ebg.Ea();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Fi() == 9486) {
            FeedData feedData = (FeedData) bVar.Fj();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.ebe) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.ebe && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.ebe.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.ebh = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.ebf.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aEI() {
        if (this.ebe != null) {
            this.ebe.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.ciM != null) {
                if (aVar.FK()) {
                    this.ciM.lE();
                    if (aVar.FI()) {
                        this.ciM.fl(d.j.loading);
                    } else if (aVar.FJ()) {
                        this.ciM.fl(d.j.loading);
                    } else {
                        this.ciM.fm(d.j.no_more_msg);
                    }
                } else {
                    this.ciM.hide();
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
        if (this.ebe != null) {
            this.ebe.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eaV);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.ebg != null) {
            this.ebg.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.ebg.De().Bn();
        this.ebg.Ea();
        this.ebg.De().Do();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ebg.b(writeData);
                this.ebg.setVoiceModel(pbEditorData.getVoiceModel());
                r eP = this.ebg.De().eP(6);
                if (eP != null && eP.aBW != null) {
                    eP.aBW.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ebg.DW();
                }
            }
        }
    }

    public void hq(boolean z) {
        BdListViewHelper.a(this.amR, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.ebe != null && this.ebe.getWrappedAdapter() != null && this.ebe.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.fP().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.ebe.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.ebg != null) {
            this.ebg.onDestory();
        }
    }
}
