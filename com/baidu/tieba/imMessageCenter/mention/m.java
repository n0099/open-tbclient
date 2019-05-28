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
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView NZ;
    private BdSwipeRefreshLayout dni;
    private final h.c drY;
    private com.baidu.tieba.frs.profession.permission.c fsx;
    private final ReplyMessageFragment gPB;
    private PbListView gPG;
    private com.baidu.tieba.imMessageCenter.mention.base.e gPH;
    private com.baidu.tieba.imMessageCenter.mention.base.f gPI;
    private com.baidu.tieba.imMessageCenter.mention.base.f gPJ;
    private boolean gPK;
    private boolean gPL;
    private aj gPM;
    private AttentionHostData gPN;
    private int gPO;
    private int gPP;
    private int gPQ;
    private BdListView.b gPR;
    private View.OnClickListener gPS;
    private ReplyMeModel gPT;
    private com.baidu.tbadk.editortools.pb.g gPU;
    private com.baidu.tieba.imMessageCenter.mention.base.a gPV;
    private String gPW;
    private long gPX;
    private long gPY;
    private DataModel<MessageCenterActivity> gPZ;
    private final ReplyMeModel.a gQa;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gPO = 0;
        this.gPP = 0;
        this.gPQ = R.color.cp_bg_line_e;
        this.gPR = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gPI.getView()) {
                    if (view == m.this.gPJ.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().amO();
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().jp(0);
                        m.this.gPP = 0;
                        m.this.vE(m.this.gPP);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().amN();
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgAtme(0);
                m.this.gPO = 0;
                m.this.vD(m.this.gPO);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gPS = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gPG != null && m.this.gPB != null) {
                    m.this.gPG.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gPG.setOnClickListener(null);
                    m.this.gPG.ajy();
                    m.this.gPB.aWs();
                }
            }
        };
        this.drY = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (com.baidu.adp.lib.util.j.jS()) {
                    if (m.this.gPB != null) {
                        m.this.gPB.bmw();
                    }
                } else if (m.this.dni != null) {
                    m.this.dni.setRefreshing(false);
                }
            }
        };
        this.gPT = null;
        this.gQa = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gPW = str;
                m.this.gPX = j2;
                m.this.gPY = j3;
                m.this.z(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gPU != null) {
                    m.this.gPU.arP();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gPB = replyMessageFragment;
        this.gPM = new aj(replyMessageFragment.getPageContext());
        this.gPM.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gPU != null) {
                    m.this.gPU.arL();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.aa(this.NZ.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.mB(true);
                        m.this.gPB.bmw();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.asB();
                this.mRefreshView.asC().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.qx(getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.qx(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.gPL) {
                this.NZ.addHeaderView(this.mRefreshView.asC(), 0);
            }
            this.gPL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.NZ != null) {
            mB(false);
            if (z) {
                this.gPG.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gPG.ajz();
                this.gPG.setOnClickListener(this.gPS);
            } else {
                this.gPG.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gPG.ajz();
                this.gPG.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.gPG.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.iH(R.string.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gPK) {
                    this.gPK = true;
                    this.NZ.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.NZ.setNextPage(null);
                this.gPQ = R.color.cp_bg_line_d;
            } else {
                this.NZ.removeHeaderView(this.mNoDataView);
                this.gPK = false;
                if (this.mRefreshView != null) {
                    this.NZ.removeHeaderView(this.mRefreshView.asC());
                    this.gPL = false;
                }
                if (this.gPH != null) {
                    this.gPH.setData(arrayList);
                    this.gPH.notifyDataSetChanged();
                }
                this.NZ.setNextPage(this.gPG);
                this.gPQ = R.color.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gPH != null) {
            this.gPH.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gPB.getPageContext());
            this.mPullView.setListPullRefreshListener(this.drY);
        }
        this.mPullView.setTag(this.gPB.getUniqueId());
        if (this.gPG == null) {
            this.gPG = new PbListView(this.gPB.getContext());
            this.gPG.getView();
        }
        this.gPG.iO(R.color.cp_bg_line_e);
        this.gPG.setHeight(com.baidu.adp.lib.util.l.g(this.gPB.getContext(), R.dimen.tbds182));
        this.gPG.ajv();
        this.gPG.setTextSize(R.dimen.tbfontsize33);
        this.gPG.setTextColor(al.getColor(R.color.cp_cont_d));
        this.gPG.iN(R.color.cp_cont_e);
        this.gPG.setOnClickListener(this.gPS);
        this.dni = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.dni.setProgressView(this.mPullView);
        this.NZ = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.gPH = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gPB.getPageContext(), this.NZ);
        this.gPH.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.mC(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.gPV = aVar;
                        if (aVar.bFA()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.bFB(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gPN == null) {
                            m.this.gPN = new AttentionHostData();
                        }
                        if (m.this.gPV != null) {
                            m.this.gPN.parserWithMetaData(m.this.gPV.getThreadAuthor());
                        }
                        m.this.gPT.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bFC() != null) {
                            am P = new am(aVar.bFC()).P("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gQA) {
                                P.P("obj_type", 1);
                            } else {
                                P.P("obj_type", 2);
                            }
                            TiebaStatic.log(P);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.NZ.getItemAnimator()).setSupportsChangeAnimations(false);
        this.NZ.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.NZ.setFadingEdgeLength(0);
        this.NZ.setOverScrollMode(2);
        this.NZ.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.NZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.NZ.setNextPage(this.gPG);
        this.NZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gPG != null) {
                    m.this.gPG.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gPG.setOnClickListener(null);
                    m.this.gPG.showLoading();
                    m.this.gPB.aWs();
                }
            }
        });
        this.NZ.setOnScrollListener(this.mScrollListener);
        bFx();
        this.gPT = new ReplyMeModel(this.gPB.getPageContext());
        this.gPT.a(this.gQa);
        this.gPZ = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.gPB.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean arn() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData pW(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.gPW);
                writeData.setThreadId(m.this.gPV.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gPV.bFA()) {
                    writeData.setFloor(m.this.gPX > 0 ? String.valueOf(m.this.gPX) : m.this.gPV.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gPV.getPost_id());
                }
                if (m.this.gPY > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gPY));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aro() {
                return null;
            }
        };
        this.gPU = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().cJ(this.gPB.getPageContext().getContext());
        this.gPU.a(this.gPB.getPageContext());
        this.gPU.b(this.gPZ);
        this.gPU.e(this.gPB.getPageContext());
        this.gPU.aqS().fd(true);
        this.gPU.aqS().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gPU.aqS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gPU.aqS(), layoutParams);
            this.gPU.aqS().hide();
        }
        this.gPU.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void arr() {
                if (m.this.gPB.getBaseFragmentActivity() != null) {
                    m.this.gPB.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gPU.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.gPB.getBaseFragmentActivity() != null) {
                    m.this.gPB.getBaseFragmentActivity().hideProgressBar();
                    m.this.gPU.aqS().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gPM.a(m.this.gPN);
                        m.this.gPM.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gPB.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bFx() {
        this.gPI = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gPB.getPageContext());
        this.gPJ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gPB.getPageContext());
        this.gPI.aU(this.gPB.getString(R.string.at_me), R.drawable.icon_im_at);
        vD(this.gPO);
        this.gPJ.aU(this.gPB.getString(R.string.agree_me), R.drawable.icon_im_laud);
        vE(this.gPP);
        this.gPJ.vF(8);
        this.NZ.addHeaderView(this.gPI.getView());
        this.NZ.addHeaderView(this.gPJ.getView());
        this.NZ.setOnHeaderClickListener(this.gPR);
    }

    public void onChangeSkinType(int i) {
        if (this.gPU != null && this.gPU.aqS() != null) {
            this.gPU.aqS().onChangeSkinType(i);
        }
        if (this.gPG != null) {
            this.gPG.setTextColor(al.getColor(R.color.cp_cont_d));
            this.gPG.iP(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.gPI != null) {
            this.gPI.bFD();
        }
        if (this.gPJ != null) {
            this.gPJ.bFD();
        }
        notifyDataSetChanged();
        al.l(this.NZ, this.gPQ);
        al.l(this.dni, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gPU == null || this.gPU.aqS() == null || this.gPU.aqS().getVisibility() != 0) {
            return false;
        }
        this.gPU.arP();
        return true;
    }

    public void mB(boolean z) {
        if (this.dni != null) {
            if (z && this.NZ != null && this.NZ.getFirstVisiblePosition() != 0) {
                this.NZ.setSelection(0);
            }
            this.dni.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gPO = newsNotifyMessage.getMsgAtme();
            this.gPP = newsNotifyMessage.getMsgAgree();
            vD(this.gPO);
            vE(this.gPP);
        }
    }

    public void bFy() {
        vD(this.gPO);
        vE(this.gPP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vD(int i) {
        if (this.gPI != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.anf().ank()) {
                z = true;
            }
            this.gPI.J(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vE(int i) {
        if (this.gPJ != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.anf().anw()) {
                z = true;
            }
            this.gPJ.J(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gPU != null) {
            if (i == 12005) {
                this.gPU.arS();
            }
            this.gPU.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gPU.aqS().app();
        this.gPU.arP();
        this.gPU.aqS().ard();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gPU.b(writeData);
                this.gPU.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kj = this.gPU.aqS().kj(6);
                if (kj != null && kj.cqE != null) {
                    kj.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gPU.arL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.fsx == null) {
            this.fsx = new com.baidu.tieba.frs.profession.permission.c(this.gPB.getPageContext());
            this.fsx.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jV(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jW(boolean z) {
                    if (z && m.this.gPU != null && m.this.gPV != null) {
                        if (!m.this.gPV.bFA() || m.this.gPV.getReplyer() == null) {
                            m.this.gPU.qg(null);
                        } else {
                            m.this.gPU.qg(m.this.gPV.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fsx.t(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gPU != null) {
            this.gPU.onDestory();
        }
        if (this.gPM != null) {
            this.gPM.onDestroy();
        }
        if (this.gPT != null) {
            this.gPT.a((ReplyMeModel.a) null);
            this.gPT.onDestroy();
        }
        if (this.gPM != null) {
            this.gPM.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gPH != null) {
            this.gPH.d(sVar);
        }
    }
}
