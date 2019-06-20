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
    private BdTypeRecyclerView NY;
    private BdSwipeRefreshLayout dni;
    private final h.c drY;
    private com.baidu.tieba.frs.profession.permission.c fsx;
    private final ReplyMessageFragment gPD;
    private PbListView gPI;
    private com.baidu.tieba.imMessageCenter.mention.base.e gPJ;
    private com.baidu.tieba.imMessageCenter.mention.base.f gPK;
    private com.baidu.tieba.imMessageCenter.mention.base.f gPL;
    private boolean gPM;
    private boolean gPN;
    private aj gPO;
    private AttentionHostData gPP;
    private int gPQ;
    private int gPR;
    private int gPS;
    private BdListView.b gPT;
    private View.OnClickListener gPU;
    private ReplyMeModel gPV;
    private com.baidu.tbadk.editortools.pb.g gPW;
    private com.baidu.tieba.imMessageCenter.mention.base.a gPX;
    private String gPY;
    private long gPZ;
    private long gQa;
    private DataModel<MessageCenterActivity> gQb;
    private final ReplyMeModel.a gQc;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gPQ = 0;
        this.gPR = 0;
        this.gPS = R.color.cp_bg_line_e;
        this.gPT = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gPK.getView()) {
                    if (view == m.this.gPL.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().amO();
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().jp(0);
                        m.this.gPR = 0;
                        m.this.vE(m.this.gPR);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().amN();
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgAtme(0);
                m.this.gPQ = 0;
                m.this.vD(m.this.gPQ);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gPU = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gPI != null && m.this.gPD != null) {
                    m.this.gPI.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gPI.setOnClickListener(null);
                    m.this.gPI.ajy();
                    m.this.gPD.aWs();
                }
            }
        };
        this.drY = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (com.baidu.adp.lib.util.j.jS()) {
                    if (m.this.gPD != null) {
                        m.this.gPD.bmw();
                    }
                } else if (m.this.dni != null) {
                    m.this.dni.setRefreshing(false);
                }
            }
        };
        this.gPV = null;
        this.gQc = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gPY = str;
                m.this.gPZ = j2;
                m.this.gQa = j3;
                m.this.z(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gPW != null) {
                    m.this.gPW.arP();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gPD = replyMessageFragment;
        this.gPO = new aj(replyMessageFragment.getPageContext());
        this.gPO.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gPW != null) {
                    m.this.gPW.arL();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.aa(this.NY.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.mC(true);
                        m.this.gPD.bmw();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.asB();
                this.mRefreshView.asC().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.qw(getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.qw(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.gPN) {
                this.NY.addHeaderView(this.mRefreshView.asC(), 0);
            }
            this.gPN = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.NY != null) {
            mC(false);
            if (z) {
                this.gPI.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gPI.ajz();
                this.gPI.setOnClickListener(this.gPU);
            } else {
                this.gPI.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gPI.ajz();
                this.gPI.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.gPI.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.iH(R.string.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gPM) {
                    this.gPM = true;
                    this.NY.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.NY.setNextPage(null);
                this.gPS = R.color.cp_bg_line_d;
            } else {
                this.NY.removeHeaderView(this.mNoDataView);
                this.gPM = false;
                if (this.mRefreshView != null) {
                    this.NY.removeHeaderView(this.mRefreshView.asC());
                    this.gPN = false;
                }
                if (this.gPJ != null) {
                    this.gPJ.setData(arrayList);
                    this.gPJ.notifyDataSetChanged();
                }
                this.NY.setNextPage(this.gPI);
                this.gPS = R.color.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gPJ != null) {
            this.gPJ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gPD.getPageContext());
            this.mPullView.setListPullRefreshListener(this.drY);
        }
        this.mPullView.setTag(this.gPD.getUniqueId());
        if (this.gPI == null) {
            this.gPI = new PbListView(this.gPD.getContext());
            this.gPI.getView();
        }
        this.gPI.iO(R.color.cp_bg_line_e);
        this.gPI.setHeight(com.baidu.adp.lib.util.l.g(this.gPD.getContext(), R.dimen.tbds182));
        this.gPI.ajv();
        this.gPI.setTextSize(R.dimen.tbfontsize33);
        this.gPI.setTextColor(al.getColor(R.color.cp_cont_d));
        this.gPI.iN(R.color.cp_cont_e);
        this.gPI.setOnClickListener(this.gPU);
        this.dni = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.dni.setProgressView(this.mPullView);
        this.NY = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.gPJ = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gPD.getPageContext(), this.NY);
        this.gPJ.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.mD(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.gPX = aVar;
                        if (aVar.bFB()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.bFC(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gPP == null) {
                            m.this.gPP = new AttentionHostData();
                        }
                        if (m.this.gPX != null) {
                            m.this.gPP.parserWithMetaData(m.this.gPX.getThreadAuthor());
                        }
                        m.this.gPV.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bFD() != null) {
                            am P = new am(aVar.bFD()).P("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gQC) {
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
        ((DefaultItemAnimator) this.NY.getItemAnimator()).setSupportsChangeAnimations(false);
        this.NY.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.NY.setFadingEdgeLength(0);
        this.NY.setOverScrollMode(2);
        this.NY.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.NY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.NY.setNextPage(this.gPI);
        this.NY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gPI != null) {
                    m.this.gPI.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gPI.setOnClickListener(null);
                    m.this.gPI.showLoading();
                    m.this.gPD.aWs();
                }
            }
        });
        this.NY.setOnScrollListener(this.mScrollListener);
        bFy();
        this.gPV = new ReplyMeModel(this.gPD.getPageContext());
        this.gPV.a(this.gQc);
        this.gQb = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.gPD.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
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
            public WriteData pV(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.gPY);
                writeData.setThreadId(m.this.gPX.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gPX.bFB()) {
                    writeData.setFloor(m.this.gPZ > 0 ? String.valueOf(m.this.gPZ) : m.this.gPX.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gPX.getPost_id());
                }
                if (m.this.gQa > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gQa));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aro() {
                return null;
            }
        };
        this.gPW = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().cJ(this.gPD.getPageContext().getContext());
        this.gPW.a(this.gPD.getPageContext());
        this.gPW.b(this.gQb);
        this.gPW.e(this.gPD.getPageContext());
        this.gPW.aqS().fd(true);
        this.gPW.aqS().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gPW.aqS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gPW.aqS(), layoutParams);
            this.gPW.aqS().hide();
        }
        this.gPW.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void arr() {
                if (m.this.gPD.getBaseFragmentActivity() != null) {
                    m.this.gPD.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gPW.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.gPD.getBaseFragmentActivity() != null) {
                    m.this.gPD.getBaseFragmentActivity().hideProgressBar();
                    m.this.gPW.aqS().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gPO.a(m.this.gPP);
                        m.this.gPO.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gPD.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bFy() {
        this.gPK = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gPD.getPageContext());
        this.gPL = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gPD.getPageContext());
        this.gPK.aU(this.gPD.getString(R.string.at_me), R.drawable.icon_im_at);
        vD(this.gPQ);
        this.gPL.aU(this.gPD.getString(R.string.agree_me), R.drawable.icon_im_laud);
        vE(this.gPR);
        this.gPL.vF(8);
        this.NY.addHeaderView(this.gPK.getView());
        this.NY.addHeaderView(this.gPL.getView());
        this.NY.setOnHeaderClickListener(this.gPT);
    }

    public void onChangeSkinType(int i) {
        if (this.gPW != null && this.gPW.aqS() != null) {
            this.gPW.aqS().onChangeSkinType(i);
        }
        if (this.gPI != null) {
            this.gPI.setTextColor(al.getColor(R.color.cp_cont_d));
            this.gPI.iP(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.gPK != null) {
            this.gPK.bFE();
        }
        if (this.gPL != null) {
            this.gPL.bFE();
        }
        notifyDataSetChanged();
        al.l(this.NY, this.gPS);
        al.l(this.dni, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gPW == null || this.gPW.aqS() == null || this.gPW.aqS().getVisibility() != 0) {
            return false;
        }
        this.gPW.arP();
        return true;
    }

    public void mC(boolean z) {
        if (this.dni != null) {
            if (z && this.NY != null && this.NY.getFirstVisiblePosition() != 0) {
                this.NY.setSelection(0);
            }
            this.dni.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gPQ = newsNotifyMessage.getMsgAtme();
            this.gPR = newsNotifyMessage.getMsgAgree();
            vD(this.gPQ);
            vE(this.gPR);
        }
    }

    public void bFz() {
        vD(this.gPQ);
        vE(this.gPR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vD(int i) {
        if (this.gPK != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.anf().ank()) {
                z = true;
            }
            this.gPK.J(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vE(int i) {
        if (this.gPL != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.anf().anw()) {
                z = true;
            }
            this.gPL.J(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gPW != null) {
            if (i == 12005) {
                this.gPW.arS();
            }
            this.gPW.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gPW.aqS().app();
        this.gPW.arP();
        this.gPW.aqS().ard();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gPW.b(writeData);
                this.gPW.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kj = this.gPW.aqS().kj(6);
                if (kj != null && kj.cqF != null) {
                    kj.cqF.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gPW.arL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.fsx == null) {
            this.fsx = new com.baidu.tieba.frs.profession.permission.c(this.gPD.getPageContext());
            this.fsx.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jV(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jW(boolean z) {
                    if (z && m.this.gPW != null && m.this.gPX != null) {
                        if (!m.this.gPX.bFB() || m.this.gPX.getReplyer() == null) {
                            m.this.gPW.qf(null);
                        } else {
                            m.this.gPW.qf(m.this.gPX.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fsx.t(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gPW != null) {
            this.gPW.onDestory();
        }
        if (this.gPO != null) {
            this.gPO.onDestroy();
        }
        if (this.gPV != null) {
            this.gPV.a((ReplyMeModel.a) null);
            this.gPV.onDestroy();
        }
        if (this.gPO != null) {
            this.gPO.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gPJ != null) {
            this.gPJ.d(sVar);
        }
    }
}
