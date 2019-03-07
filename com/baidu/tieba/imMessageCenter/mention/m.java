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
    private PbListView gyE;
    private com.baidu.tieba.imMessageCenter.mention.base.e gyF;
    private com.baidu.tieba.imMessageCenter.mention.base.f gyG;
    private com.baidu.tieba.imMessageCenter.mention.base.f gyH;
    private boolean gyI;
    private boolean gyJ;
    private aj gyK;
    private AttentionHostData gyL;
    private int gyM;
    private int gyN;
    private int gyO;
    private BdListView.b gyP;
    private View.OnClickListener gyQ;
    private ReplyMeModel gyR;
    private com.baidu.tbadk.editortools.pb.g gyS;
    private com.baidu.tieba.imMessageCenter.mention.base.a gyT;
    private String gyU;
    private long gyV;
    private long gyW;
    private DataModel<MessageCenterActivity> gyX;
    private final ReplyMeModel.a gyY;
    private final ReplyMessageFragment gyz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gyM = 0;
        this.gyN = 0;
        this.gyO = d.C0236d.cp_bg_line_e;
        this.gyP = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gyG.getView()) {
                    if (view == m.this.gyH.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahQ();
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iC(0);
                        m.this.gyN = 0;
                        m.this.uB(m.this.gyN);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().ahP();
                com.baidu.tbadk.coreExtra.messageCenter.b.ahA().setMsgAtme(0);
                m.this.gyM = 0;
                m.this.uA(m.this.gyM);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gyQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gyE != null && m.this.gyz != null) {
                    m.this.gyE.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gyE.setOnClickListener(null);
                    m.this.gyE.aeC();
                    m.this.gyz.bfd();
                }
            }
        };
        this.dhu = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    if (m.this.gyz != null) {
                        m.this.gyz.bfe();
                    }
                } else if (m.this.dcE != null) {
                    m.this.dcE.setRefreshing(false);
                }
            }
        };
        this.gyR = null;
        this.gyY = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gyU = str;
                m.this.gyV = j2;
                m.this.gyW = j3;
                m.this.x(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gyS != null) {
                    m.this.gyS.amQ();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gyz = replyMessageFragment;
        this.gyK = new aj(replyMessageFragment.getPageContext());
        this.gyK.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gyS != null) {
                    m.this.gyS.amM();
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
                        m.this.gyz.bfe();
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
            if (!this.gyJ) {
                this.Qq.addHeaderView(this.mRefreshView.anD(), 0);
            }
            this.gyJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Qq != null) {
            lM(false);
            if (z) {
                this.gyE.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gyE.aeD();
                this.gyE.setOnClickListener(this.gyQ);
            } else {
                this.gyE.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gyE.aeD();
                this.gyE.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.gyE.setOnClickListener(null);
            }
            if (v.T(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.hU(d.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.l(this.mNoDataView, d.C0236d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gyI) {
                    this.gyI = true;
                    this.Qq.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Qq.setNextPage(null);
                this.gyO = d.C0236d.cp_bg_line_d;
            } else {
                this.Qq.removeHeaderView(this.mNoDataView);
                this.gyI = false;
                if (this.mRefreshView != null) {
                    this.Qq.removeHeaderView(this.mRefreshView.anD());
                    this.gyJ = false;
                }
                if (this.gyF != null) {
                    this.gyF.setData(arrayList);
                    this.gyF.notifyDataSetChanged();
                }
                this.Qq.setNextPage(this.gyE);
                this.gyO = d.C0236d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gyF != null) {
            this.gyF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gyz.getPageContext());
            this.mPullView.setListPullRefreshListener(this.dhu);
        }
        this.mPullView.setTag(this.gyz.getUniqueId());
        if (this.gyE == null) {
            this.gyE = new PbListView(this.gyz.getContext());
            this.gyE.getView();
        }
        this.gyE.ib(d.C0236d.cp_bg_line_e);
        this.gyE.setHeight(com.baidu.adp.lib.util.l.h(this.gyz.getContext(), d.e.tbds182));
        this.gyE.aez();
        this.gyE.setTextSize(d.e.tbfontsize33);
        this.gyE.setTextColor(al.getColor(d.C0236d.cp_cont_d));
        this.gyE.ia(d.C0236d.cp_cont_e);
        this.gyE.setOnClickListener(this.gyQ);
        this.dcE = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.dcE.setProgressView(this.mPullView);
        this.Qq = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.gyF = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gyz.getPageContext(), this.Qq);
        this.gyF.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.gyT = aVar;
                        if (aVar.bxS()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.bxT(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gyL == null) {
                            m.this.gyL = new AttentionHostData();
                        }
                        if (m.this.gyT != null) {
                            m.this.gyL.parserWithMetaData(m.this.gyT.getThreadAuthor());
                        }
                        m.this.gyR.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bxU() != null) {
                            am T = new am(aVar.bxU()).T("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gzx) {
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
        this.Qq.setNextPage(this.gyE);
        this.Qq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gyE != null) {
                    m.this.gyE.id(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gyE.setOnClickListener(null);
                    m.this.gyE.showLoading();
                    m.this.gyz.bfd();
                }
            }
        });
        this.Qq.setOnScrollListener(this.mScrollListener);
        bxP();
        this.gyR = new ReplyMeModel(this.gyz.getPageContext());
        this.gyR.a(this.gyY);
        this.gyX = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.gyz.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
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
                writeData.setForumName(m.this.gyU);
                writeData.setThreadId(m.this.gyT.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gyT.bxS()) {
                    writeData.setFloor(m.this.gyV > 0 ? String.valueOf(m.this.gyV) : m.this.gyT.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gyT.getPost_id());
                }
                if (m.this.gyW > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gyW));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String amp() {
                return null;
            }
        };
        this.gyS = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().dd(this.gyz.getPageContext().getContext());
        this.gyS.a(this.gyz.getPageContext());
        this.gyS.b(this.gyX);
        this.gyS.e(this.gyz.getPageContext());
        this.gyS.alT().eH(true);
        this.gyS.alT().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gyS.alT() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gyS.alT(), layoutParams);
            this.gyS.alT().hide();
        }
        this.gyS.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void ams() {
                if (m.this.gyz.getBaseFragmentActivity() != null) {
                    m.this.gyz.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gyS.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.gyz.getBaseFragmentActivity() != null) {
                    m.this.gyz.getBaseFragmentActivity().hideProgressBar();
                    m.this.gyS.alT().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gyK.a(m.this.gyL);
                        m.this.gyK.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.aB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gyz.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bxP() {
        this.gyG = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gyz.getPageContext());
        this.gyH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gyz.getPageContext());
        this.gyG.aY(this.gyz.getString(d.j.at_me), d.f.icon_im_at);
        uA(this.gyM);
        this.gyH.aY(this.gyz.getString(d.j.agree_me), d.f.icon_im_laud);
        uB(this.gyN);
        this.gyH.uC(8);
        this.Qq.addHeaderView(this.gyG.getView());
        this.Qq.addHeaderView(this.gyH.getView());
        this.Qq.setOnHeaderClickListener(this.gyP);
    }

    public void onChangeSkinType(int i) {
        if (this.gyS != null && this.gyS.alT() != null) {
            this.gyS.alT().onChangeSkinType(i);
        }
        if (this.gyE != null) {
            this.gyE.setTextColor(al.getColor(d.C0236d.cp_cont_d));
            this.gyE.ic(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ic(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, d.C0236d.cp_bg_line_d);
        }
        if (this.gyG != null) {
            this.gyG.bxV();
        }
        if (this.gyH != null) {
            this.gyH.bxV();
        }
        notifyDataSetChanged();
        al.l(this.Qq, this.gyO);
        al.l(this.dcE, d.C0236d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gyS == null || this.gyS.alT() == null || this.gyS.alT().getVisibility() != 0) {
            return false;
        }
        this.gyS.amQ();
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
            this.gyM = newsNotifyMessage.getMsgAtme();
            this.gyN = newsNotifyMessage.getMsgAgree();
            uA(this.gyM);
            uB(this.gyN);
        }
    }

    public void bxQ() {
        uA(this.gyM);
        uB(this.gyN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uA(int i) {
        if (this.gyG != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aih().aim()) {
                z = true;
            }
            this.gyG.E(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uB(int i) {
        if (this.gyH != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aih().aiy()) {
                z = true;
            }
            this.gyH.E(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gyS != null) {
            if (i == 12005) {
                this.gyS.amT();
            }
            this.gyS.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gyS.alT().akq();
        this.gyS.amQ();
        this.gyS.alT().ame();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gyS.b(writeData);
                this.gyS.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k jw = this.gyS.alT().jw(6);
                if (jw != null && jw.ciu != null) {
                    jw.ciu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gyS.amM();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (this.fcw == null) {
            this.fcw = new com.baidu.tieba.frs.profession.permission.c(this.gyz.getPageContext());
            this.fcw.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jl(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jm(boolean z) {
                    if (z && m.this.gyS != null && m.this.gyT != null) {
                        if (!m.this.gyT.bxS() || m.this.gyT.getReplyer() == null) {
                            m.this.gyS.oX(null);
                        } else {
                            m.this.gyS.oX(m.this.gyT.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fcw.q(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gyS != null) {
            this.gyS.onDestory();
        }
        if (this.gyK != null) {
            this.gyK.onDestroy();
        }
        if (this.gyR != null) {
            this.gyR.a((ReplyMeModel.a) null);
            this.gyR.onDestroy();
        }
        if (this.gyK != null) {
            this.gyK.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gyF != null) {
            this.gyF.d(sVar);
        }
    }
}
