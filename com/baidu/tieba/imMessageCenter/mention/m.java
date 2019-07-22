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
    private BdSwipeRefreshLayout dpi;
    private final h.c duh;
    private com.baidu.tieba.frs.profession.permission.c fxt;
    private final ReplyMessageFragment gVN;
    private PbListView gVS;
    private com.baidu.tieba.imMessageCenter.mention.base.e gVT;
    private com.baidu.tieba.imMessageCenter.mention.base.f gVU;
    private com.baidu.tieba.imMessageCenter.mention.base.f gVV;
    private boolean gVW;
    private boolean gVX;
    private aj gVY;
    private AttentionHostData gVZ;
    private int gWa;
    private int gWb;
    private int gWc;
    private BdListView.b gWd;
    private View.OnClickListener gWe;
    private ReplyMeModel gWf;
    private com.baidu.tbadk.editortools.pb.g gWg;
    private com.baidu.tieba.imMessageCenter.mention.base.a gWh;
    private String gWi;
    private long gWj;
    private long gWk;
    private DataModel<MessageCenterActivity> gWl;
    private final ReplyMeModel.a gWm;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gWa = 0;
        this.gWb = 0;
        this.gWc = R.color.cp_bg_line_e;
        this.gWd = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gVU.getView()) {
                    if (view == m.this.gVV.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.anD().anT();
                        com.baidu.tbadk.coreExtra.messageCenter.b.anD().jv(0);
                        m.this.gWb = 0;
                        m.this.wg(m.this.gWb);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.anD().anS();
                com.baidu.tbadk.coreExtra.messageCenter.b.anD().setMsgAtme(0);
                m.this.gWa = 0;
                m.this.wf(m.this.gWa);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gWe = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gVS != null && m.this.gVN != null) {
                    m.this.gVS.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gVS.setOnClickListener(null);
                    m.this.gVS.akD();
                    m.this.gVN.aYo();
                }
            }
        };
        this.duh = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void er(boolean z) {
                if (com.baidu.adp.lib.util.j.kc()) {
                    if (m.this.gVN != null) {
                        m.this.gVN.box();
                    }
                } else if (m.this.dpi != null) {
                    m.this.dpi.setRefreshing(false);
                }
            }
        };
        this.gWf = null;
        this.gWm = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gWi = str;
                m.this.gWj = j2;
                m.this.gWk = j3;
                m.this.z(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gWg != null) {
                    m.this.gWg.asV();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gVN = replyMessageFragment;
        this.gVY = new aj(replyMessageFragment.getPageContext());
        this.gVY.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gWg != null) {
                    m.this.gWg.asR();
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
                        m.this.gVN.box();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.atI();
                this.mRefreshView.atJ().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.qN(getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.qN(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.gVX) {
                this.Op.addHeaderView(this.mRefreshView.atJ(), 0);
            }
            this.gVX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Op != null) {
            mQ(false);
            if (z) {
                this.gVS.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gVS.akE();
                this.gVS.setOnClickListener(this.gWe);
            } else {
                this.gVS.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gVS.akE();
                this.gVS.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.gVS.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.iN(R.string.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gVW) {
                    this.gVW = true;
                    this.Op.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Op.setNextPage(null);
                this.gWc = R.color.cp_bg_line_d;
            } else {
                this.Op.removeHeaderView(this.mNoDataView);
                this.gVW = false;
                if (this.mRefreshView != null) {
                    this.Op.removeHeaderView(this.mRefreshView.atJ());
                    this.gVX = false;
                }
                if (this.gVT != null) {
                    this.gVT.setData(arrayList);
                    this.gVT.notifyDataSetChanged();
                }
                this.Op.setNextPage(this.gVS);
                this.gWc = R.color.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gVT != null) {
            this.gVT.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bx(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gVN.getPageContext());
            this.mPullView.setListPullRefreshListener(this.duh);
        }
        this.mPullView.setTag(this.gVN.getUniqueId());
        if (this.gVS == null) {
            this.gVS = new PbListView(this.gVN.getContext());
            this.gVS.getView();
        }
        this.gVS.iU(R.color.cp_bg_line_e);
        this.gVS.setHeight(com.baidu.adp.lib.util.l.g(this.gVN.getContext(), R.dimen.tbds182));
        this.gVS.akA();
        this.gVS.setTextSize(R.dimen.tbfontsize33);
        this.gVS.setTextColor(am.getColor(R.color.cp_cont_d));
        this.gVS.iT(R.color.cp_cont_e);
        this.gVS.setOnClickListener(this.gWe);
        this.dpi = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.dpi.setProgressView(this.mPullView);
        this.Op = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.gVT = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gVN.getPageContext(), this.Op);
        this.gVT.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.gWh = aVar;
                        if (aVar.bIi()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.bIj(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gVZ == null) {
                            m.this.gVZ = new AttentionHostData();
                        }
                        if (m.this.gWh != null) {
                            m.this.gVZ.parserWithMetaData(m.this.gWh.getThreadAuthor());
                        }
                        m.this.gWf.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bIk() != null) {
                            an P = new an(aVar.bIk()).P("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gWM) {
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
        this.Op.setNextPage(this.gVS);
        this.Op.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gVS != null) {
                    m.this.gVS.iW(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gVS.setOnClickListener(null);
                    m.this.gVS.showLoading();
                    m.this.gVN.aYo();
                }
            }
        });
        this.Op.setOnScrollListener(this.mScrollListener);
        bIf();
        this.gWf = new ReplyMeModel(this.gVN.getPageContext());
        this.gWf.a(this.gWm);
        this.gWl = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.gVN.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean ast() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData qm(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.gWi);
                writeData.setThreadId(m.this.gWh.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gWh.bIi()) {
                    writeData.setFloor(m.this.gWj > 0 ? String.valueOf(m.this.gWj) : m.this.gWh.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gWh.getPost_id());
                }
                if (m.this.gWk > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gWk));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String asu() {
                return null;
            }
        };
        this.gWg = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().cK(this.gVN.getPageContext().getContext());
        this.gWg.a(this.gVN.getPageContext());
        this.gWg.b(this.gWl);
        this.gWg.e(this.gVN.getPageContext());
        this.gWg.arY().fh(true);
        this.gWg.arY().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gWg.arY() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gWg.arY(), layoutParams);
            this.gWg.arY().hide();
        }
        this.gWg.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void asx() {
                if (m.this.gVN.getBaseFragmentActivity() != null) {
                    m.this.gVN.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gWg.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.gVN.getBaseFragmentActivity() != null) {
                    m.this.gVN.getBaseFragmentActivity().hideProgressBar();
                    m.this.gWg.arY().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gVY.a(m.this.gVZ);
                        m.this.gVY.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gVN.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bIf() {
        this.gVU = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gVN.getPageContext());
        this.gVV = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gVN.getPageContext());
        this.gVU.aV(this.gVN.getString(R.string.at_me), R.drawable.icon_im_at);
        wf(this.gWa);
        this.gVV.aV(this.gVN.getString(R.string.agree_me), R.drawable.icon_im_laud);
        wg(this.gWb);
        this.gVV.wh(8);
        this.Op.addHeaderView(this.gVU.getView());
        this.Op.addHeaderView(this.gVV.getView());
        this.Op.setOnHeaderClickListener(this.gWd);
    }

    public void onChangeSkinType(int i) {
        if (this.gWg != null && this.gWg.arY() != null) {
            this.gWg.arY().onChangeSkinType(i);
        }
        if (this.gVS != null) {
            this.gVS.setTextColor(am.getColor(R.color.cp_cont_d));
            this.gVS.iV(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iV(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.gVU != null) {
            this.gVU.bIl();
        }
        if (this.gVV != null) {
            this.gVV.bIl();
        }
        notifyDataSetChanged();
        am.l(this.Op, this.gWc);
        am.l(this.dpi, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gWg == null || this.gWg.arY() == null || this.gWg.arY().getVisibility() != 0) {
            return false;
        }
        this.gWg.asV();
        return true;
    }

    public void mQ(boolean z) {
        if (this.dpi != null) {
            if (z && this.Op != null && this.Op.getFirstVisiblePosition() != 0) {
                this.Op.setSelection(0);
            }
            this.dpi.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gWa = newsNotifyMessage.getMsgAtme();
            this.gWb = newsNotifyMessage.getMsgAgree();
            wf(this.gWa);
            wg(this.gWb);
        }
    }

    public void bIg() {
        wf(this.gWa);
        wg(this.gWb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wf(int i) {
        if (this.gVU != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aok().aop()) {
                z = true;
            }
            this.gVU.L(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(int i) {
        if (this.gVV != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aok().aoB()) {
                z = true;
            }
            this.gVV.L(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gWg != null) {
            if (i == 12005) {
                this.gWg.asY();
            }
            this.gWg.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gWg.arY().aqu();
        this.gWg.asV();
        this.gWg.arY().asj();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gWg.b(writeData);
                this.gWg.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kp = this.gWg.arY().kp(6);
                if (kp != null && kp.crT != null) {
                    kp.crT.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gWg.asR();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, long j) {
        if (this.fxt == null) {
            this.fxt = new com.baidu.tieba.frs.profession.permission.c(this.gVN.getPageContext());
            this.fxt.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kf(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kg(boolean z) {
                    if (z && m.this.gWg != null && m.this.gWh != null) {
                        if (!m.this.gWh.bIi() || m.this.gWh.getReplyer() == null) {
                            m.this.gWg.qw(null);
                        } else {
                            m.this.gWg.qw(m.this.gWh.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fxt.t(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gWg != null) {
            this.gWg.onDestory();
        }
        if (this.gVY != null) {
            this.gVY.onDestroy();
        }
        if (this.gWf != null) {
            this.gWf.a((ReplyMeModel.a) null);
            this.gWf.onDestroy();
        }
        if (this.gVY != null) {
            this.gVY.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gVT != null) {
            this.gVT.d(sVar);
        }
    }
}
