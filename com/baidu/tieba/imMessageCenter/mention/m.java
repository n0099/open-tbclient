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
    private BdSwipeRefreshLayout dnh;
    private final h.c drX;
    private com.baidu.tieba.frs.profession.permission.c fsw;
    private PbListView gPE;
    private com.baidu.tieba.imMessageCenter.mention.base.e gPF;
    private com.baidu.tieba.imMessageCenter.mention.base.f gPG;
    private com.baidu.tieba.imMessageCenter.mention.base.f gPH;
    private boolean gPI;
    private boolean gPJ;
    private aj gPK;
    private AttentionHostData gPL;
    private int gPM;
    private int gPN;
    private int gPO;
    private BdListView.b gPP;
    private View.OnClickListener gPQ;
    private ReplyMeModel gPR;
    private com.baidu.tbadk.editortools.pb.g gPS;
    private com.baidu.tieba.imMessageCenter.mention.base.a gPT;
    private String gPU;
    private long gPV;
    private long gPW;
    private DataModel<MessageCenterActivity> gPX;
    private final ReplyMeModel.a gPY;
    private final ReplyMessageFragment gPz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gPM = 0;
        this.gPN = 0;
        this.gPO = R.color.cp_bg_line_e;
        this.gPP = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gPG.getView()) {
                    if (view == m.this.gPH.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().amO();
                        com.baidu.tbadk.coreExtra.messageCenter.b.amy().jp(0);
                        m.this.gPN = 0;
                        m.this.vE(m.this.gPN);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().amN();
                com.baidu.tbadk.coreExtra.messageCenter.b.amy().setMsgAtme(0);
                m.this.gPM = 0;
                m.this.vD(m.this.gPM);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gPQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gPE != null && m.this.gPz != null) {
                    m.this.gPE.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gPE.setOnClickListener(null);
                    m.this.gPE.ajy();
                    m.this.gPz.aWp();
                }
            }
        };
        this.drX = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void en(boolean z) {
                if (com.baidu.adp.lib.util.j.jS()) {
                    if (m.this.gPz != null) {
                        m.this.gPz.bmt();
                    }
                } else if (m.this.dnh != null) {
                    m.this.dnh.setRefreshing(false);
                }
            }
        };
        this.gPR = null;
        this.gPY = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gPU = str;
                m.this.gPV = j2;
                m.this.gPW = j3;
                m.this.z(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gPS != null) {
                    m.this.gPS.arP();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gPz = replyMessageFragment;
        this.gPK = new aj(replyMessageFragment.getPageContext());
        this.gPK.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gPS != null) {
                    m.this.gPS.arL();
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
                        m.this.gPz.bmt();
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
            if (!this.gPJ) {
                this.NZ.addHeaderView(this.mRefreshView.asC(), 0);
            }
            this.gPJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.NZ != null) {
            mB(false);
            if (z) {
                this.gPE.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gPE.ajz();
                this.gPE.setOnClickListener(this.gPQ);
            } else {
                this.gPE.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gPE.ajz();
                this.gPE.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.gPE.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.iH(R.string.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gPI) {
                    this.gPI = true;
                    this.NZ.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.NZ.setNextPage(null);
                this.gPO = R.color.cp_bg_line_d;
            } else {
                this.NZ.removeHeaderView(this.mNoDataView);
                this.gPI = false;
                if (this.mRefreshView != null) {
                    this.NZ.removeHeaderView(this.mRefreshView.asC());
                    this.gPJ = false;
                }
                if (this.gPF != null) {
                    this.gPF.setData(arrayList);
                    this.gPF.notifyDataSetChanged();
                }
                this.NZ.setNextPage(this.gPE);
                this.gPO = R.color.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gPF != null) {
            this.gPF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gPz.getPageContext());
            this.mPullView.setListPullRefreshListener(this.drX);
        }
        this.mPullView.setTag(this.gPz.getUniqueId());
        if (this.gPE == null) {
            this.gPE = new PbListView(this.gPz.getContext());
            this.gPE.getView();
        }
        this.gPE.iO(R.color.cp_bg_line_e);
        this.gPE.setHeight(com.baidu.adp.lib.util.l.g(this.gPz.getContext(), R.dimen.tbds182));
        this.gPE.ajv();
        this.gPE.setTextSize(R.dimen.tbfontsize33);
        this.gPE.setTextColor(al.getColor(R.color.cp_cont_d));
        this.gPE.iN(R.color.cp_cont_e);
        this.gPE.setOnClickListener(this.gPQ);
        this.dnh = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.dnh.setProgressView(this.mPullView);
        this.NZ = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.gPF = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gPz.getPageContext(), this.NZ);
        this.gPF.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.gPT = aVar;
                        if (aVar.bFx()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.bFy(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gPL == null) {
                            m.this.gPL = new AttentionHostData();
                        }
                        if (m.this.gPT != null) {
                            m.this.gPL.parserWithMetaData(m.this.gPT.getThreadAuthor());
                        }
                        m.this.gPR.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bFz() != null) {
                            am P = new am(aVar.bFz()).P("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gQx) {
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
        this.NZ.setNextPage(this.gPE);
        this.NZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gPE != null) {
                    m.this.gPE.iQ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gPE.setOnClickListener(null);
                    m.this.gPE.showLoading();
                    m.this.gPz.aWp();
                }
            }
        });
        this.NZ.setOnScrollListener(this.mScrollListener);
        bFu();
        this.gPR = new ReplyMeModel(this.gPz.getPageContext());
        this.gPR.a(this.gPY);
        this.gPX = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.gPz.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
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
                writeData.setForumName(m.this.gPU);
                writeData.setThreadId(m.this.gPT.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gPT.bFx()) {
                    writeData.setFloor(m.this.gPV > 0 ? String.valueOf(m.this.gPV) : m.this.gPT.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gPT.getPost_id());
                }
                if (m.this.gPW > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gPW));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aro() {
                return null;
            }
        };
        this.gPS = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().cJ(this.gPz.getPageContext().getContext());
        this.gPS.a(this.gPz.getPageContext());
        this.gPS.b(this.gPX);
        this.gPS.e(this.gPz.getPageContext());
        this.gPS.aqS().fd(true);
        this.gPS.aqS().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gPS.aqS() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gPS.aqS(), layoutParams);
            this.gPS.aqS().hide();
        }
        this.gPS.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void arr() {
                if (m.this.gPz.getBaseFragmentActivity() != null) {
                    m.this.gPz.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gPS.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.gPz.getBaseFragmentActivity() != null) {
                    m.this.gPz.getBaseFragmentActivity().hideProgressBar();
                    m.this.gPS.aqS().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gPK.a(m.this.gPL);
                        m.this.gPK.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gPz.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bFu() {
        this.gPG = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gPz.getPageContext());
        this.gPH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gPz.getPageContext());
        this.gPG.aU(this.gPz.getString(R.string.at_me), R.drawable.icon_im_at);
        vD(this.gPM);
        this.gPH.aU(this.gPz.getString(R.string.agree_me), R.drawable.icon_im_laud);
        vE(this.gPN);
        this.gPH.vF(8);
        this.NZ.addHeaderView(this.gPG.getView());
        this.NZ.addHeaderView(this.gPH.getView());
        this.NZ.setOnHeaderClickListener(this.gPP);
    }

    public void onChangeSkinType(int i) {
        if (this.gPS != null && this.gPS.aqS() != null) {
            this.gPS.aqS().onChangeSkinType(i);
        }
        if (this.gPE != null) {
            this.gPE.setTextColor(al.getColor(R.color.cp_cont_d));
            this.gPE.iP(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iP(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.gPG != null) {
            this.gPG.bFA();
        }
        if (this.gPH != null) {
            this.gPH.bFA();
        }
        notifyDataSetChanged();
        al.l(this.NZ, this.gPO);
        al.l(this.dnh, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gPS == null || this.gPS.aqS() == null || this.gPS.aqS().getVisibility() != 0) {
            return false;
        }
        this.gPS.arP();
        return true;
    }

    public void mB(boolean z) {
        if (this.dnh != null) {
            if (z && this.NZ != null && this.NZ.getFirstVisiblePosition() != 0) {
                this.NZ.setSelection(0);
            }
            this.dnh.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gPM = newsNotifyMessage.getMsgAtme();
            this.gPN = newsNotifyMessage.getMsgAgree();
            vD(this.gPM);
            vE(this.gPN);
        }
    }

    public void bFv() {
        vD(this.gPM);
        vE(this.gPN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vD(int i) {
        if (this.gPG != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.anf().ank()) {
                z = true;
            }
            this.gPG.J(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vE(int i) {
        if (this.gPH != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.anf().anw()) {
                z = true;
            }
            this.gPH.J(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gPS != null) {
            if (i == 12005) {
                this.gPS.arS();
            }
            this.gPS.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gPS.aqS().app();
        this.gPS.arP();
        this.gPS.aqS().ard();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gPS.b(writeData);
                this.gPS.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kj = this.gPS.aqS().kj(6);
                if (kj != null && kj.cqE != null) {
                    kj.cqE.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gPS.arL();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.fsw == null) {
            this.fsw = new com.baidu.tieba.frs.profession.permission.c(this.gPz.getPageContext());
            this.fsw.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jV(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jW(boolean z) {
                    if (z && m.this.gPS != null && m.this.gPT != null) {
                        if (!m.this.gPT.bFx() || m.this.gPT.getReplyer() == null) {
                            m.this.gPS.qg(null);
                        } else {
                            m.this.gPS.qg(m.this.gPT.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fsw.t(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gPS != null) {
            this.gPS.onDestory();
        }
        if (this.gPK != null) {
            this.gPK.onDestroy();
        }
        if (this.gPR != null) {
            this.gPR.a((ReplyMeModel.a) null);
            this.gPR.onDestroy();
        }
        if (this.gPK != null) {
            this.gPK.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gPF != null) {
            this.gPF.d(sVar);
        }
    }
}
