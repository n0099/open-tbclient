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
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView Qq;
    private BdSwipeRefreshLayout dcE;
    private final h.c dhu;
    private com.baidu.tieba.frs.profession.permission.c fcw;
    private final ReplyMessageFragment gyA;
    private PbListView gyF;
    private com.baidu.tieba.imMessageCenter.mention.base.e gyG;
    private com.baidu.tieba.imMessageCenter.mention.base.f gyH;
    private com.baidu.tieba.imMessageCenter.mention.base.f gyI;
    private boolean gyJ;
    private boolean gyK;
    private aj gyL;
    private AttentionHostData gyM;
    private int gyN;
    private int gyO;
    private int gyP;
    private BdListView.b gyQ;
    private View.OnClickListener gyR;
    private ReplyMeModel gyS;
    private com.baidu.tbadk.editortools.pb.g gyT;
    private com.baidu.tieba.imMessageCenter.mention.base.a gyU;
    private String gyV;
    private long gyW;
    private long gyX;
    private DataModel<MessageCenterActivity> gyY;
    private final ReplyMeModel.a gyZ;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gyN = 0;
        this.gyO = 0;
        this.gyP = d.C0236d.cp_bg_line_e;
        this.gyQ = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gyH.getView()) {
                    if (view == m.this.gyI.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahQ();
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iC(0);
                        m.this.gyO = 0;
                        m.this.uB(m.this.gyO);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahP();
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgAtme(0);
                m.this.gyN = 0;
                m.this.uA(m.this.gyN);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gyR = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gyF != null && m.this.gyA != null) {
                    m.this.gyF.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gyF.setOnClickListener(null);
                    m.this.gyF.aeC();
                    m.this.gyA.bfe();
                }
            }
        };
        this.dhu = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    if (m.this.gyA != null) {
                        m.this.gyA.bff();
                    }
                } else if (m.this.dcE != null) {
                    m.this.dcE.setRefreshing(false);
                }
            }
        };
        this.gyS = null;
        this.gyZ = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gyV = str;
                m.this.gyW = j2;
                m.this.gyX = j3;
                m.this.x(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gyT != null) {
                    m.this.gyT.amQ();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gyA = replyMessageFragment;
        this.gyL = new aj(replyMessageFragment.getPageContext());
        this.gyL.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gyT != null) {
                    m.this.gyT.amM();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.T(this.Qq.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.lM(true);
                        m.this.gyA.bff();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.anC();
                this.mRefreshView.anD().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.po(getPageContext().getResources().getString(d.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.po(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.gyK) {
                this.Qq.addHeaderView(this.mRefreshView.anD(), 0);
            }
            this.gyK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Qq != null) {
            lM(false);
            if (z) {
                this.gyF.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gyF.aeD();
                this.gyF.setOnClickListener(this.gyR);
            } else {
                this.gyF.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gyF.aeD();
                this.gyF.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.gyF.setOnClickListener(null);
            }
            if (v.T(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.hU(d.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.l(this.mNoDataView, d.C0236d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gyJ) {
                    this.gyJ = true;
                    this.Qq.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Qq.setNextPage(null);
                this.gyP = d.C0236d.cp_bg_line_d;
            } else {
                this.Qq.removeHeaderView(this.mNoDataView);
                this.gyJ = false;
                if (this.mRefreshView != null) {
                    this.Qq.removeHeaderView(this.mRefreshView.anD());
                    this.gyK = false;
                }
                if (this.gyG != null) {
                    this.gyG.setData(arrayList);
                    this.gyG.notifyDataSetChanged();
                }
                this.Qq.setNextPage(this.gyF);
                this.gyP = d.C0236d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gyG != null) {
            this.gyG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gyA.getPageContext());
            this.mPullView.setListPullRefreshListener(this.dhu);
        }
        this.mPullView.setTag(this.gyA.getUniqueId());
        if (this.gyF == null) {
            this.gyF = new PbListView(this.gyA.getContext());
            this.gyF.getView();
        }
        this.gyF.ib(d.C0236d.cp_bg_line_e);
        this.gyF.setHeight(com.baidu.adp.lib.util.l.h(this.gyA.getContext(), d.e.tbds182));
        this.gyF.aez();
        this.gyF.setTextSize(d.e.tbfontsize33);
        this.gyF.setTextColor(al.getColor(d.C0236d.cp_cont_d));
        this.gyF.ia(d.C0236d.cp_cont_e);
        this.gyF.setOnClickListener(this.gyR);
        this.dcE = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.dcE.setProgressView(this.mPullView);
        this.Qq = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.gyG = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gyA.getPageContext(), this.Qq);
        this.gyG.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long d;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.lN(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == d.g.message_bottom_reply_container) {
                        m.this.gyU = aVar;
                        if (aVar.bxT()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.bxU(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gyM == null) {
                            m.this.gyM = new AttentionHostData();
                        }
                        if (m.this.gyU != null) {
                            m.this.gyM.parserWithMetaData(m.this.gyU.getThreadAuthor());
                        }
                        m.this.gyS.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bxV() != null) {
                            am T = new am(aVar.bxV()).T("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gzy) {
                                T.T("obj_type", 1);
                            } else {
                                T.T("obj_type", 2);
                            }
                            TiebaStatic.log(T);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Qq.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Qq.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Qq.setFadingEdgeLength(0);
        this.Qq.setOverScrollMode(2);
        this.Qq.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Qq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Qq.setNextPage(this.gyF);
        this.Qq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gyF != null) {
                    m.this.gyF.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gyF.setOnClickListener(null);
                    m.this.gyF.showLoading();
                    m.this.gyA.bfe();
                }
            }
        });
        this.Qq.setOnScrollListener(this.mScrollListener);
        bxQ();
        this.gyS = new ReplyMeModel(this.gyA.getPageContext());
        this.gyS.a(this.gyZ);
        this.gyY = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.gyA.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean amo() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData oN(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.gyV);
                writeData.setThreadId(m.this.gyU.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gyU.bxT()) {
                    writeData.setFloor(m.this.gyW > 0 ? String.valueOf(m.this.gyW) : m.this.gyU.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gyU.getPost_id());
                }
                if (m.this.gyX > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gyX));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String amp() {
                return null;
            }
        };
        this.gyT = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().dd(this.gyA.getPageContext().getContext());
        this.gyT.a(this.gyA.getPageContext());
        this.gyT.b(this.gyY);
        this.gyT.e(this.gyA.getPageContext());
        this.gyT.alT().eH(true);
        this.gyT.alT().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gyT.alT() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gyT.alT(), layoutParams);
            this.gyT.alT().hide();
        }
        this.gyT.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void ams() {
                if (m.this.gyA.getBaseFragmentActivity() != null) {
                    m.this.gyA.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gyT.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.gyA.getBaseFragmentActivity() != null) {
                    m.this.gyA.getBaseFragmentActivity().hideProgressBar();
                    m.this.gyT.alT().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gyL.a(m.this.gyM);
                        m.this.gyL.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gyA.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bxQ() {
        this.gyH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gyA.getPageContext());
        this.gyI = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gyA.getPageContext());
        this.gyH.aY(this.gyA.getString(d.j.at_me), d.f.icon_im_at);
        uA(this.gyN);
        this.gyI.aY(this.gyA.getString(d.j.agree_me), d.f.icon_im_laud);
        uB(this.gyO);
        this.gyI.uC(8);
        this.Qq.addHeaderView(this.gyH.getView());
        this.Qq.addHeaderView(this.gyI.getView());
        this.Qq.setOnHeaderClickListener(this.gyQ);
    }

    public void onChangeSkinType(int i) {
        if (this.gyT != null && this.gyT.alT() != null) {
            this.gyT.alT().onChangeSkinType(i);
        }
        if (this.gyF != null) {
            this.gyF.setTextColor(al.getColor(d.C0236d.cp_cont_d));
            this.gyF.ic(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, d.C0236d.cp_bg_line_d);
        }
        if (this.gyH != null) {
            this.gyH.bxW();
        }
        if (this.gyI != null) {
            this.gyI.bxW();
        }
        notifyDataSetChanged();
        al.l(this.Qq, this.gyP);
        al.l(this.dcE, d.C0236d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gyT == null || this.gyT.alT() == null || this.gyT.alT().getVisibility() != 0) {
            return false;
        }
        this.gyT.amQ();
        return true;
    }

    public void lM(boolean z) {
        if (this.dcE != null) {
            if (z && this.Qq != null && this.Qq.getFirstVisiblePosition() != 0) {
                this.Qq.setSelection(0);
            }
            this.dcE.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gyN = newsNotifyMessage.getMsgAtme();
            this.gyO = newsNotifyMessage.getMsgAgree();
            uA(this.gyN);
            uB(this.gyO);
        }
    }

    public void bxR() {
        uA(this.gyN);
        uB(this.gyO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uA(int i) {
        if (this.gyH != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aih().aim()) {
                z = true;
            }
            this.gyH.E(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB(int i) {
        if (this.gyI != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiy()) {
                z = true;
            }
            this.gyI.E(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gyT != null) {
            if (i == 12005) {
                this.gyT.amT();
            }
            this.gyT.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gyT.alT().akq();
        this.gyT.amQ();
        this.gyT.alT().ame();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gyT.b(writeData);
                this.gyT.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k jw = this.gyT.alT().jw(6);
                if (jw != null && jw.ciu != null) {
                    jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gyT.amM();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (this.fcw == null) {
            this.fcw = new com.baidu.tieba.frs.profession.permission.c(this.gyA.getPageContext());
            this.fcw.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jl(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jm(boolean z) {
                    if (z && m.this.gyT != null && m.this.gyU != null) {
                        if (!m.this.gyU.bxT() || m.this.gyU.getReplyer() == null) {
                            m.this.gyT.oX(null);
                        } else {
                            m.this.gyT.oX(m.this.gyU.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fcw.q(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gyT != null) {
            this.gyT.onDestory();
        }
        if (this.gyL != null) {
            this.gyL.onDestroy();
        }
        if (this.gyS != null) {
            this.gyS.a((ReplyMeModel.a) null);
            this.gyS.onDestroy();
        }
        if (this.gyL != null) {
            this.gyL.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gyG != null) {
            this.gyG.d(sVar);
        }
    }
}
