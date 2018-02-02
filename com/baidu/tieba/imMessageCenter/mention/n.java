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
    private NoNetworkView bYY;
    private com.baidu.tbadk.mvc.g.a dco;
    private final ReplyMessageActivity eOS;
    private com.baidu.tbadk.mvc.f.d<FeedData, com.baidu.tbadk.mvc.d.b, k> eOe;
    private NavigationBar eOg;
    private BdListView ePb;
    private ReplyMeModel ePc;
    private com.baidu.tbadk.editortools.pb.h ePd;
    private FeedData ePe;
    private String ePf;
    private long ePg;
    private long ePh;
    private DataModel<g> ePi;
    private final ReplyMeModel.a ePj;
    private final AbsListView.OnScrollListener eop;
    private String mForumId;
    private com.baidu.tbadk.core.view.k mPullView;
    private RelativeLayout mRootView;

    public n(ReplyMessageActivity replyMessageActivity) {
        super(replyMessageActivity.getPageContext());
        this.ePb = null;
        this.ePc = null;
        this.ePj = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.6
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                n.this.mForumId = String.valueOf(j);
                n.this.ePf = str;
                n.this.ePg = j2;
                n.this.ePh = j3;
                if (n.this.ePd != null) {
                    if (!n.this.ePe.getIsFloor() || n.this.ePe.getReplyer() == null) {
                        n.this.ePd.gu(null);
                    } else {
                        n.this.ePd.gu(n.this.ePe.getReplyer().getName_show());
                    }
                }
            }
        };
        this.eop = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.n.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i != 0 && n.this.ePd != null) {
                    n.this.ePd.Lr();
                }
            }
        };
        this.eOS = replyMessageActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        if (aVar instanceof f) {
            f fVar = (f) aVar;
            if (this.eOe != null) {
                this.eOe.L(fVar.aMb());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v40, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v43, resolved type: com.baidu.tieba.imMessageCenter.mention.ReplyMessageActivity */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public View XJ() {
        this.mRootView = (RelativeLayout) this.eOS.getActivity().getLayoutInflater().inflate(d.h.reply_me_activity, (ViewGroup) null);
        this.eOS.setContentView(this.mRootView);
        this.ePb = (BdListView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eOg = (NavigationBar) this.mRootView.findViewById(d.g.view_navigation_bar);
        this.eOg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eOg.setCenterTextTitle(getPageContext().getString(d.j.reply_me));
        this.eOg.showBottomLine();
        this.eOe = new com.baidu.tbadk.mvc.f.d<>(this.eOS.getPageContext(), k.class, d.h.mention_replyme_item, this.eOS.Nf());
        this.eOe.a(NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.eOS.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gn(d.j.mention_replyme_nodata), (NoDataViewFactory.b) null, (FrameLayout.LayoutParams) null);
        this.ePb.setAdapter((ListAdapter) this.eOe);
        this.mPullView = new com.baidu.tbadk.core.view.k(this.eOS.getPageContext());
        this.mPullView.a(this.eOS);
        this.dco = new com.baidu.tbadk.mvc.g.a(this.eOS);
        this.dco.sv();
        this.IZ = new TextView(this.eOS.getPageContext().getPageActivity());
        this.IZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.l.s(this.eOS.getPageContext().getPageActivity(), d.e.ds88)));
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, com.baidu.adp.lib.util.j.oJ());
        this.ePb.setNextPage(this.dco);
        this.ePb.setPullRefresh(this.mPullView);
        this.ePb.addHeaderView(this.IZ, 0);
        this.bYY = (NoNetworkView) this.mRootView.findViewById(d.g.no_networkview);
        this.bYY.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.bYY.a(new NoNetworkView.a() { // from class: com.baidu.tieba.imMessageCenter.mention.n.1
            @Override // com.baidu.tbadk.core.view.NoNetworkView.a
            public void bq(boolean z) {
                n.this.hV(z);
            }
        });
        this.ePc = new ReplyMeModel(this.eOS);
        this.ePc.a(this.ePj);
        this.ePb.setOnScrollListener(this.eop);
        this.ePb.setExOnSrollToBottomListener(new BdListView.f() { // from class: com.baidu.tieba.imMessageCenter.mention.n.2
            @Override // com.baidu.adp.widget.ListView.BdListView.f
            public void a(BdListView bdListView) {
                n.this.eOS.WT();
            }
        });
        this.ePi = new DataModel<g>(com.baidu.adp.base.i.ak(this.eOS.getPageContext().getPageActivity())) { // from class: com.baidu.tieba.imMessageCenter.mention.n.3
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean KP() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData gi(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(n.this.mForumId);
                writeData.setForumName(n.this.ePf);
                writeData.setThreadId(n.this.ePe.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (n.this.ePe.getIsFloor()) {
                    writeData.setFloor(n.this.ePg > 0 ? String.valueOf(n.this.ePg) : n.this.ePe.getQuote_pid());
                } else {
                    writeData.setFloor(n.this.ePe.getPost_id());
                }
                if (n.this.ePh > 0) {
                    writeData.setRepostId(String.valueOf(n.this.ePh));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String KQ() {
                return null;
            }
        };
        this.ePd = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().be(this.eOS.getPageContext().getPageActivity());
        this.ePd.a(this.eOS.getPageContext());
        this.ePd.b(this.ePi);
        this.ePd.e(this.eOS.getPageContext());
        this.ePd.Kw().cb(true);
        this.ePd.Kw().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ePd.Kw() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.ePd.Kw(), layoutParams);
            this.ePd.Kw().hide();
        }
        this.ePd.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.n.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void KT() {
                n.this.eOS.showProgressBar();
            }
        });
        this.ePd.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.n.5
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                n.this.eOS.hideProgressBar();
                n.this.ePd.Kw().hide();
                if (postWriteCallBackData != null && tVar == null && !AntiHelper.vQ(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    n.this.eOS.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.eOe != null) {
            this.eOe.notifyDataSetChanged();
            this.eOe.b(tbPageContext, i);
        }
        if (this.ePd != null && this.ePd.Kw() != null) {
            this.ePd.Kw().onChangeSkinType(i);
        }
        this.eOg.onChangeSkinType(tbPageContext, i);
        if (this.dco != null) {
            this.dco.b(tbPageContext, i);
        }
        if (this.mPullView != null) {
            this.mPullView.gv(i);
        }
    }

    public boolean onBackPressed() {
        if (this.ePd == null || this.ePd.Kw() == null || this.ePd.Kw().getVisibility() != 0) {
            return false;
        }
        this.ePd.Lr();
        return true;
    }

    public void d(com.baidu.tbadk.mvc.c.b bVar) {
        long c;
        if (bVar != null && bVar.Mx() == 9486) {
            FeedData feedData = (FeedData) bVar.My();
            ViewParent viewParent = (ViewParent) bVar.getView();
            while (viewParent != null && (viewParent instanceof View) && viewParent != this.ePb) {
                viewParent = viewParent.getParent();
            }
            if (viewParent == this.ePb && viewParent != null) {
                Rect rect = new Rect();
                bVar.getView().getDrawingRect(rect);
                this.ePb.offsetDescendantRectToMyCoords(bVar.getView(), rect);
                this.ePe = feedData;
                if (feedData.getIsFloor()) {
                    c = com.baidu.adp.lib.g.b.c(feedData.getQuote_pid(), 0L);
                } else {
                    c = com.baidu.adp.lib.g.b.c(feedData.getPost_id(), 0L);
                }
                this.ePc.a(c, 2, feedData.getFname(), feedData.getThread_id());
            }
        }
    }

    public void aLT() {
        if (this.ePb != null) {
            this.ePb.completePullRefreshPostDelayed(2000L);
        }
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        if (bVar instanceof com.baidu.tbadk.mvc.d.a) {
            com.baidu.tbadk.mvc.d.a aVar = (com.baidu.tbadk.mvc.d.a) bVar;
            if (this.dco != null) {
                if (aVar.MZ()) {
                    this.dco.ti();
                    if (aVar.MX()) {
                        this.dco.ig(d.j.loading);
                    } else if (aVar.MY()) {
                        this.dco.ig(d.j.loading);
                    } else {
                        this.dco.ih(d.j.no_more_msg);
                    }
                } else {
                    this.dco.hide();
                }
            }
            if (aVar.isPullRefreshing()) {
                aLU();
            } else {
                aLT();
            }
        }
    }

    public void aLU() {
        if (this.mPullView != null) {
            this.mPullView.a((j.b) null);
        }
        if (this.ePb != null) {
            this.ePb.startPullRefresh();
        }
        if (this.mPullView != null) {
            this.mPullView.a(this.eOS);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.ePd != null) {
            this.ePd.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.ePd.Kw().IG();
        this.ePd.Lr();
        this.ePd.Kw().KG();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ePd.b(writeData);
                this.ePd.setVoiceModel(pbEditorData.getVoiceModel());
                r hJ = this.ePd.Kw().hJ(6);
                if (hJ != null && hJ.bqj != null) {
                    hJ.bqj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ePd.Ln();
                }
            }
        }
    }

    public void hV(boolean z) {
        BdListViewHelper.a(this.IZ, BdListViewHelper.HeadType.DEFAULT, z);
        if (z && this.ePb != null && this.ePb.getWrappedAdapter() != null && this.ePb.getWrappedAdapter().getCount() <= 0) {
            com.baidu.adp.lib.g.e.ns().post(new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.n.8
                @Override // java.lang.Runnable
                public void run() {
                    n.this.ePb.startPullRefresh();
                }
            });
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.ePd != null) {
            this.ePd.onDestory();
        }
    }
}
