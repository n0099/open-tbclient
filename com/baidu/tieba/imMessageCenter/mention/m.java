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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
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
    private BdTypeRecyclerView Op;
    private BdSwipeRefreshLayout dpp;
    private final h.c duo;
    private com.baidu.tieba.frs.profession.permission.c fxS;
    private final ReplyMessageFragment gWF;
    private PbListView gWK;
    private com.baidu.tieba.imMessageCenter.mention.base.e gWL;
    private com.baidu.tieba.imMessageCenter.mention.base.f gWM;
    private com.baidu.tieba.imMessageCenter.mention.base.f gWN;
    private boolean gWO;
    private boolean gWP;
    private aj gWQ;
    private AttentionHostData gWR;
    private int gWS;
    private int gWT;
    private int gWU;
    private BdListView.b gWV;
    private View.OnClickListener gWW;
    private ReplyMeModel gWX;
    private com.baidu.tbadk.editortools.pb.g gWY;
    private com.baidu.tieba.imMessageCenter.mention.base.a gWZ;
    private String gXa;
    private long gXb;
    private long gXc;
    private DataModel<MessageCenterActivity> gXd;
    private final ReplyMeModel.a gXe;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gWS = 0;
        this.gWT = 0;
        this.gWU = R.color.cp_bg_line_e;
        this.gWV = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gWM.getView()) {
                    if (view == m.this.gWN.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.anF().anV();
                        com.baidu.tbadk.coreExtra.messageCenter.b.anF().jw(0);
                        m.this.gWT = 0;
                        m.this.wi(m.this.gWT);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.anF().anU();
                com.baidu.tbadk.coreExtra.messageCenter.b.anF().setMsgAtme(0);
                m.this.gWS = 0;
                m.this.wh(m.this.gWS);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gWW = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gWK != null && m.this.gWF != null) {
                    m.this.gWK.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gWK.setOnClickListener(null);
                    m.this.gWK.akF();
                    m.this.gWF.aYq();
                }
            }
        };
        this.duo = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (com.baidu.adp.lib.util.j.kc()) {
                    if (m.this.gWF != null) {
                        m.this.gWF.boK();
                    }
                } else if (m.this.dpp != null) {
                    m.this.dpp.setRefreshing(false);
                }
            }
        };
        this.gWX = null;
        this.gXe = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gXa = str;
                m.this.gXb = j2;
                m.this.gXc = j3;
                m.this.z(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gWY != null) {
                    m.this.gWY.asX();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gWF = replyMessageFragment;
        this.gWQ = new aj(replyMessageFragment.getPageContext());
        this.gWQ.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gWY != null) {
                    m.this.gWY.asT();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.aa(this.Op.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.mQ(true);
                        m.this.gWF.boK();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.atK();
                this.mRefreshView.atL().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.qN(getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.qN(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.gWP) {
                this.Op.addHeaderView(this.mRefreshView.atL(), 0);
            }
            this.gWP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Op != null) {
            mQ(false);
            if (z) {
                this.gWK.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gWK.akG();
                this.gWK.setOnClickListener(this.gWW);
            } else {
                this.gWK.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gWK.akG();
                this.gWK.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.gWK.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.iN(R.string.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gWO) {
                    this.gWO = true;
                    this.Op.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Op.setNextPage(null);
                this.gWU = R.color.cp_bg_line_d;
            } else {
                this.Op.removeHeaderView(this.mNoDataView);
                this.gWO = false;
                if (this.mRefreshView != null) {
                    this.Op.removeHeaderView(this.mRefreshView.atL());
                    this.gWP = false;
                }
                if (this.gWL != null) {
                    this.gWL.setData(arrayList);
                    this.gWL.notifyDataSetChanged();
                }
                this.Op.setNextPage(this.gWK);
                this.gWU = R.color.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gWL != null) {
            this.gWL.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bx(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gWF.getPageContext());
            this.mPullView.setListPullRefreshListener(this.duo);
        }
        this.mPullView.setTag(this.gWF.getUniqueId());
        if (this.gWK == null) {
            this.gWK = new PbListView(this.gWF.getContext());
            this.gWK.getView();
        }
        this.gWK.iU(R.color.cp_bg_line_e);
        this.gWK.setHeight(com.baidu.adp.lib.util.l.g(this.gWF.getContext(), R.dimen.tbds182));
        this.gWK.akC();
        this.gWK.setTextSize(R.dimen.tbfontsize33);
        this.gWK.setTextColor(am.getColor(R.color.cp_cont_d));
        this.gWK.iT(R.color.cp_cont_e);
        this.gWK.setOnClickListener(this.gWW);
        this.dpp = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.dpp.setProgressView(this.mPullView);
        this.Op = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.gWL = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gWF.getPageContext(), this.Op);
        this.gWL.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.mR(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.gWZ = aVar;
                        if (aVar.bIw()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.bIx(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gWR == null) {
                            m.this.gWR = new AttentionHostData();
                        }
                        if (m.this.gWZ != null) {
                            m.this.gWR.parserWithMetaData(m.this.gWZ.getThreadAuthor());
                        }
                        m.this.gWX.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bIy() != null) {
                            an P = new an(aVar.bIy()).P("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gXE) {
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
        ((DefaultItemAnimator) this.Op.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Op.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Op.setFadingEdgeLength(0);
        this.Op.setOverScrollMode(2);
        this.Op.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Op.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Op.setNextPage(this.gWK);
        this.Op.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gWK != null) {
                    m.this.gWK.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gWK.setOnClickListener(null);
                    m.this.gWK.showLoading();
                    m.this.gWF.aYq();
                }
            }
        });
        this.Op.setOnScrollListener(this.mScrollListener);
        bIt();
        this.gWX = new ReplyMeModel(this.gWF.getPageContext());
        this.gWX.a(this.gXe);
        this.gXd = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.gWF.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean asv() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData qm(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.gXa);
                writeData.setThreadId(m.this.gWZ.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gWZ.bIw()) {
                    writeData.setFloor(m.this.gXb > 0 ? String.valueOf(m.this.gXb) : m.this.gWZ.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gWZ.getPost_id());
                }
                if (m.this.gXc > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gXc));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String asw() {
                return null;
            }
        };
        this.gWY = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().cK(this.gWF.getPageContext().getContext());
        this.gWY.a(this.gWF.getPageContext());
        this.gWY.b(this.gXd);
        this.gWY.e(this.gWF.getPageContext());
        this.gWY.asa().fh(true);
        this.gWY.asa().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gWY.asa() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gWY.asa(), layoutParams);
            this.gWY.asa().hide();
        }
        this.gWY.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void asz() {
                if (m.this.gWF.getBaseFragmentActivity() != null) {
                    m.this.gWF.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gWY.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.gWF.getBaseFragmentActivity() != null) {
                    m.this.gWF.getBaseFragmentActivity().hideProgressBar();
                    m.this.gWY.asa().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gWQ.a(m.this.gWR);
                        m.this.gWQ.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gWF.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bIt() {
        this.gWM = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gWF.getPageContext());
        this.gWN = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gWF.getPageContext());
        this.gWM.aV(this.gWF.getString(R.string.at_me), R.drawable.icon_im_at);
        wh(this.gWS);
        this.gWN.aV(this.gWF.getString(R.string.agree_me), R.drawable.icon_im_laud);
        wi(this.gWT);
        this.gWN.wj(8);
        this.Op.addHeaderView(this.gWM.getView());
        this.Op.addHeaderView(this.gWN.getView());
        this.Op.setOnHeaderClickListener(this.gWV);
    }

    public void onChangeSkinType(int i) {
        if (this.gWY != null && this.gWY.asa() != null) {
            this.gWY.asa().onChangeSkinType(i);
        }
        if (this.gWK != null) {
            this.gWK.setTextColor(am.getColor(R.color.cp_cont_d));
            this.gWK.iV(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.gWM != null) {
            this.gWM.bIz();
        }
        if (this.gWN != null) {
            this.gWN.bIz();
        }
        notifyDataSetChanged();
        am.l(this.Op, this.gWU);
        am.l(this.dpp, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gWY == null || this.gWY.asa() == null || this.gWY.asa().getVisibility() != 0) {
            return false;
        }
        this.gWY.asX();
        return true;
    }

    public void mQ(boolean z) {
        if (this.dpp != null) {
            if (z && this.Op != null && this.Op.getFirstVisiblePosition() != 0) {
                this.Op.setSelection(0);
            }
            this.dpp.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gWS = newsNotifyMessage.getMsgAtme();
            this.gWT = newsNotifyMessage.getMsgAgree();
            wh(this.gWS);
            wi(this.gWT);
        }
    }

    public void bIu() {
        wh(this.gWS);
        wi(this.gWT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(int i) {
        if (this.gWM != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aom().aor()) {
                z = true;
            }
            this.gWM.L(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(int i) {
        if (this.gWN != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aom().aoD()) {
                z = true;
            }
            this.gWN.L(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gWY != null) {
            if (i == 12005) {
                this.gWY.ata();
            }
            this.gWY.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gWY.asa().aqw();
        this.gWY.asX();
        this.gWY.asa().asl();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gWY.b(writeData);
                this.gWY.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kq = this.gWY.asa().kq(6);
                if (kq != null && kq.csa != null) {
                    kq.csa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gWY.asT();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.fxS == null) {
            this.fxS = new com.baidu.tieba.frs.profession.permission.c(this.gWF.getPageContext());
            this.fxS.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kf(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kg(boolean z) {
                    if (z && m.this.gWY != null && m.this.gWZ != null) {
                        if (!m.this.gWZ.bIw() || m.this.gWZ.getReplyer() == null) {
                            m.this.gWY.qw(null);
                        } else {
                            m.this.gWY.qw(m.this.gWZ.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fxS.t(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gWY != null) {
            this.gWY.onDestory();
        }
        if (this.gWQ != null) {
            this.gWQ.onDestroy();
        }
        if (this.gWX != null) {
            this.gWX.a((ReplyMeModel.a) null);
            this.gWX.onDestroy();
        }
        if (this.gWQ != null) {
            this.gWQ.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gWL != null) {
            this.gWL.d(sVar);
        }
    }
}
