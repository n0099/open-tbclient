package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView bMI;
    private BdSwipeRefreshLayout bMJ;
    private final j.b bMO;
    private final ReplyMessageFragment eWL;
    private PbListView eWQ;
    private com.baidu.tieba.imMessageCenter.mention.base.e eWR;
    private com.baidu.tieba.imMessageCenter.mention.base.f eWS;
    private com.baidu.tieba.imMessageCenter.mention.base.f eWT;
    private boolean eWU;
    private boolean eWV;
    private aj eWW;
    private AttentionHostData eWX;
    private int eWY;
    private int eWZ;
    private int eXa;
    private BdListView.b eXb;
    private View.OnClickListener eXc;
    private ReplyMeModel eXd;
    private com.baidu.tbadk.editortools.pb.g eXe;
    private com.baidu.tieba.imMessageCenter.mention.base.a eXf;
    private String eXg;
    private long eXh;
    private long eXi;
    private DataModel<MessageCenterActivity> eXj;
    private final ReplyMeModel.a eXk;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.k.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eWY = 0;
        this.eWZ = 0;
        this.eXa = e.d.cp_bg_line_e;
        this.eXb = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.eWS.getView()) {
                    if (view == m.this.eWT.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GP();
                        com.baidu.tbadk.coreExtra.messageCenter.a.Gz().et(0);
                        m.this.eWZ = 0;
                        m.this.pS(m.this.eWZ);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().GO();
                com.baidu.tbadk.coreExtra.messageCenter.a.Gz().setMsgAtme(0);
                m.this.eWY = 0;
                m.this.pR(m.this.eWY);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        };
        this.eXc = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eWQ != null && m.this.eWL != null) {
                    m.this.eWQ.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eWQ.setOnClickListener(null);
                    m.this.eWQ.DO();
                    m.this.eWL.aCb();
                }
            }
        };
        this.bMO = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.j.b
            public void bp(boolean z) {
                if (com.baidu.adp.lib.util.j.kX()) {
                    if (m.this.eWL != null) {
                        m.this.eWL.aCc();
                    }
                } else if (m.this.bMJ != null) {
                    m.this.bMJ.setRefreshing(false);
                }
            }
        };
        this.eXd = null;
        this.eXk = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.eXg = str;
                m.this.eXh = j2;
                m.this.eXi = j3;
                if (m.this.eXe != null && m.this.eXf != null) {
                    if (!m.this.eXf.aUO() || m.this.eXf.getReplyer() == null) {
                        m.this.eXe.hC(null);
                    } else {
                        m.this.eXe.hC(m.this.eXf.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.eXe != null) {
                    m.this.eXe.LD();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eWL = replyMessageFragment;
        this.eWW = new aj(replyMessageFragment.getPageContext());
        this.eWW.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z && m.this.eXe != null) {
                    m.this.eXe.Lz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.J(this.bMI.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.iX(true);
                        m.this.eWL.aCc();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.My();
                this.mRefreshView.fA(getPageContext().getResources().getDimensionPixelSize(e.C0175e.ds_102));
                this.mRefreshView.Mw().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.hU(getPageContext().getResources().getString(e.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.hU(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.eWV) {
                this.bMI.addHeaderView(this.mRefreshView.Mw(), 0);
            }
            this.eWV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.bMI != null) {
            iX(false);
            if (z) {
                this.eWQ.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.eWQ.DP();
                this.eWQ.setOnClickListener(this.eXc);
            } else {
                this.eWQ.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.eWQ.DP();
                this.eWQ.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.eWQ.setOnClickListener(null);
            }
            if (v.J(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0175e.ds80)), NoDataViewFactory.d.dO(e.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eWU) {
                    this.eWU = true;
                    this.bMI.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bMI.setNextPage(null);
                this.eXa = e.d.cp_bg_line_d;
            } else {
                this.bMI.removeHeaderView(this.mNoDataView);
                this.eWU = false;
                if (this.mRefreshView != null) {
                    this.bMI.removeHeaderView(this.mRefreshView.Mw());
                    this.eWV = false;
                }
                if (this.eWR != null) {
                    this.eWR.setData(arrayList);
                    this.eWR.notifyDataSetChanged();
                }
                this.bMI.setNextPage(this.eWQ);
                this.eXa = e.d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eWR != null) {
            this.eWR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.eWL.getPageContext());
            this.mPullView.a(this.bMO);
        }
        this.mPullView.setTag(this.eWL.getUniqueId());
        if (this.eWQ == null) {
            this.eWQ = new PbListView(this.eWL.getContext());
            this.eWQ.getView();
        }
        this.eWQ.dV(e.d.cp_bg_line_e);
        this.eWQ.setHeight(com.baidu.adp.lib.util.l.h(this.eWL.getContext(), e.C0175e.tbds182));
        this.eWQ.DL();
        this.eWQ.setTextSize(e.C0175e.tbfontsize33);
        this.eWQ.setTextColor(al.getColor(e.d.cp_cont_d));
        this.eWQ.dU(e.d.cp_cont_e);
        this.eWQ.setOnClickListener(this.eXc);
        this.bMJ = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.reply_me_pull_refresh_layout);
        this.bMJ.setProgressView(this.mPullView);
        this.bMI = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.replyme_lv);
        this.eWR = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eWL.getPageContext(), this.bMI);
        this.eWR.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long d;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.iY(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == e.g.message_bottom_reply_container) {
                        m.this.eXf = aVar;
                        if (aVar.aUO()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.aUP(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.eWX == null) {
                            m.this.eWX = new AttentionHostData();
                        }
                        if (m.this.eXf != null) {
                            m.this.eWX.parserWithMetaData(m.this.eXf.getThreadAuthor());
                        }
                        m.this.eXd.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aUQ() != null) {
                            am x = new am(aVar.aUQ()).x("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eXK) {
                                x.x("obj_type", 1);
                            } else {
                                x.x("obj_type", 2);
                            }
                            TiebaStatic.log(x);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.bMI.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bMI.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bMI.setFadingEdgeLength(0);
        this.bMI.setOverScrollMode(2);
        this.bMI.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bMI.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bMI.setNextPage(this.eWQ);
        this.bMI.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.eWQ != null) {
                    m.this.eWQ.dX(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eWQ.setOnClickListener(null);
                    m.this.eWQ.showLoading();
                    m.this.eWL.aCb();
                }
            }
        });
        this.bMI.setOnScrollListener(this.mScrollListener);
        aUK();
        this.eXd = new ReplyMeModel(this.eWL.getPageContext());
        this.eXd.a(this.eXk);
        this.eXj = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.eWL.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Lb() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData hr(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.eXg);
                writeData.setThreadId(m.this.eXf.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.eXf.aUO()) {
                    writeData.setFloor(m.this.eXh > 0 ? String.valueOf(m.this.eXh) : m.this.eXf.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.eXf.getPost_id());
                }
                if (m.this.eXi > 0) {
                    writeData.setRepostId(String.valueOf(m.this.eXi));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Lc() {
                return null;
            }
        };
        this.eXe = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.eWL.getPageContext().getContext());
        this.eXe.setContext(this.eWL.getPageContext());
        this.eXe.b(this.eXj);
        this.eXe.d(this.eWL.getPageContext());
        this.eXe.KH().bY(true);
        this.eXe.KH().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eXe.KH() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eXe.KH(), layoutParams);
            this.eXe.KH().hide();
        }
        this.eXe.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Lf() {
                if (m.this.eWL.getBaseFragmentActivity() != null) {
                    m.this.eWL.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.eXe.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.v vVar, WriteData writeData, AntiData antiData) {
                if (m.this.eWL.getBaseFragmentActivity() != null) {
                    m.this.eWL.getBaseFragmentActivity().hideProgressBar();
                    m.this.eXe.KH().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.eWW.a(m.this.eWX);
                        m.this.eWW.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && vVar == null && !AntiHelper.am(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.eWL.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aUK() {
        this.eWS = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eWL.getPageContext());
        this.eWT = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eWL.getPageContext());
        this.eWS.aB(this.eWL.getString(e.j.at_me), e.f.icon_im_at);
        pR(this.eWY);
        this.eWT.aB(this.eWL.getString(e.j.agree_me), e.f.icon_im_laud);
        pS(this.eWZ);
        this.eWT.pT(8);
        this.bMI.addHeaderView(this.eWS.getView());
        this.bMI.addHeaderView(this.eWT.getView());
        this.bMI.setOnHeaderClickListener(this.eXb);
    }

    public void onChangeSkinType(int i) {
        if (this.eXe != null && this.eXe.KH() != null) {
            this.eXe.KH().onChangeSkinType(i);
        }
        if (this.eWQ != null) {
            this.eWQ.setTextColor(al.getColor(e.d.cp_cont_d));
            this.eWQ.dW(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dW(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.eWS != null) {
            this.eWS.aUR();
        }
        if (this.eWT != null) {
            this.eWT.aUR();
        }
        notifyDataSetChanged();
        al.j(this.bMI, this.eXa);
        al.j(this.bMJ, e.d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.eXe == null || this.eXe.KH() == null || this.eXe.KH().getVisibility() != 0) {
            return false;
        }
        this.eXe.LD();
        return true;
    }

    public void iX(boolean z) {
        if (this.bMJ != null) {
            if (z && this.bMI != null && this.bMI.getFirstVisiblePosition() != 0) {
                this.bMI.setSelection(0);
            }
            this.bMJ.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.eWY = newsNotifyMessage.getMsgAtme();
            this.eWZ = newsNotifyMessage.getMsgAgree();
            pR(this.eWY);
            pS(this.eWZ);
        }
    }

    public void aUL() {
        pR(this.eWY);
        pS(this.eWZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(int i) {
        if (this.eWS != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hl()) {
                z = true;
            }
            this.eWS.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS(int i) {
        if (this.eWT != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hg().Hx()) {
                z = true;
            }
            this.eWT.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eXe != null) {
            if (i == 12005) {
                this.eXe.LG();
            }
            this.eXe.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eXe.KH().Jg();
        this.eXe.LD();
        this.eXe.KH().KR();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eXe.b(writeData);
                this.eXe.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k fi = this.eXe.KH().fi(6);
                if (fi != null && fi.aTV != null) {
                    fi.aTV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eXe.Lz();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eXe != null) {
            this.eXe.onDestory();
        }
        if (this.eWW != null) {
            this.eWW.onDestroy();
        }
        if (this.eXd != null) {
            this.eXd.a((ReplyMeModel.a) null);
            this.eXd.onDestroy();
        }
        if (this.eWW != null) {
            this.eWW.a((aj.a) null);
        }
    }

    public void d(n nVar) {
        if (this.eWR != null) {
            this.eWR.d(nVar);
        }
    }
}
