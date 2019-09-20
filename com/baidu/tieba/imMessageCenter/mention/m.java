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
import com.baidu.tbadk.coreExtra.data.y;
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
    private BdTypeRecyclerView Oo;
    private BdSwipeRefreshLayout dra;
    private final h.c dvZ;
    private com.baidu.tieba.frs.profession.permission.c fzF;
    private PbListView gYE;
    private com.baidu.tieba.imMessageCenter.mention.base.e gYF;
    private com.baidu.tieba.imMessageCenter.mention.base.f gYG;
    private com.baidu.tieba.imMessageCenter.mention.base.f gYH;
    private boolean gYI;
    private boolean gYJ;
    private aj gYK;
    private AttentionHostData gYL;
    private int gYM;
    private int gYN;
    private int gYO;
    private BdListView.b gYP;
    private View.OnClickListener gYQ;
    private ReplyMeModel gYR;
    private com.baidu.tbadk.editortools.pb.g gYS;
    private com.baidu.tieba.imMessageCenter.mention.base.a gYT;
    private String gYU;
    private long gYV;
    private long gYW;
    private DataModel<MessageCenterActivity> gYX;
    private final ReplyMeModel.a gYY;
    private final ReplyMessageFragment gYz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gYM = 0;
        this.gYN = 0;
        this.gYO = R.color.cp_bg_line_c;
        this.gYP = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gYG.getView()) {
                    if (view == m.this.gYH.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.anR().aoh();
                        com.baidu.tbadk.coreExtra.messageCenter.b.anR().jz(0);
                        m.this.gYN = 0;
                        m.this.wm(m.this.gYN);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.anR().aog();
                com.baidu.tbadk.coreExtra.messageCenter.b.anR().setMsgAtme(0);
                m.this.gYM = 0;
                m.this.wl(m.this.gYM);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gYQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gYE != null && m.this.gYz != null) {
                    m.this.gYE.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gYE.setOnClickListener(null);
                    m.this.gYE.akR();
                    m.this.gYz.aYU();
                }
            }
        };
        this.dvZ = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void eu(boolean z) {
                if (com.baidu.adp.lib.util.j.kc()) {
                    if (m.this.gYz != null) {
                        m.this.gYz.bpv();
                    }
                } else if (m.this.dra != null) {
                    m.this.dra.setRefreshing(false);
                }
            }
        };
        this.gYR = null;
        this.gYY = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gYU = str;
                m.this.gYV = j2;
                m.this.gYW = j3;
                m.this.B(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gYS != null) {
                    m.this.gYS.atj();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gYz = replyMessageFragment;
        this.gYK = new aj(replyMessageFragment.getPageContext());
        this.gYK.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gYS != null) {
                    m.this.gYS.atf();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.aa(this.Oo.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.mT(true);
                        m.this.gYz.bpv();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.atW();
                this.mRefreshView.atX().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.qY(getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.qY(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.gYJ) {
                this.Oo.addHeaderView(this.mRefreshView.atX(), 0);
            }
            this.gYJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Oo != null) {
            mT(false);
            if (z) {
                this.gYE.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gYE.akS();
                this.gYE.setOnClickListener(this.gYQ);
            } else {
                this.gYE.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gYE.akS();
                this.gYE.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.gYE.setOnClickListener(null);
            }
            if (v.aa(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.iQ(R.string.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.l(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gYI) {
                    this.gYI = true;
                    this.Oo.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Oo.setNextPage(null);
                this.gYO = R.color.cp_bg_line_e;
            } else {
                this.Oo.removeHeaderView(this.mNoDataView);
                this.gYI = false;
                if (this.mRefreshView != null) {
                    this.Oo.removeHeaderView(this.mRefreshView.atX());
                    this.gYJ = false;
                }
                if (this.gYF != null) {
                    this.gYF.setData(arrayList);
                    this.gYF.notifyDataSetChanged();
                }
                this.Oo.setNextPage(this.gYE);
                this.gYO = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gYF != null) {
            this.gYF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bx(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gYz.getPageContext());
            this.mPullView.setListPullRefreshListener(this.dvZ);
        }
        this.mPullView.setTag(this.gYz.getUniqueId());
        if (this.gYE == null) {
            this.gYE = new PbListView(this.gYz.getContext());
            this.gYE.getView();
        }
        this.gYE.iX(R.color.cp_bg_line_e);
        this.gYE.setHeight(com.baidu.adp.lib.util.l.g(this.gYz.getContext(), R.dimen.tbds182));
        this.gYE.akO();
        this.gYE.setTextSize(R.dimen.tbfontsize33);
        this.gYE.setTextColor(am.getColor(R.color.cp_cont_d));
        this.gYE.iW(R.color.cp_cont_e);
        this.gYE.setOnClickListener(this.gYQ);
        this.dra = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.dra.setProgressView(this.mPullView);
        this.Oo = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.gYF = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gYz.getPageContext(), this.Oo);
        this.gYF.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long e;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.mU(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.gYT = aVar;
                        if (aVar.bJk()) {
                            e = com.baidu.adp.lib.g.b.e(aVar.bJl(), 0L);
                        } else {
                            e = com.baidu.adp.lib.g.b.e(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gYL == null) {
                            m.this.gYL = new AttentionHostData();
                        }
                        if (m.this.gYT != null) {
                            m.this.gYL.parserWithMetaData(m.this.gYT.getThreadAuthor());
                        }
                        m.this.gYR.a(e, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bJm() != null) {
                            an P = new an(aVar.bJm()).P("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gZy) {
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
        ((DefaultItemAnimator) this.Oo.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Oo.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Oo.setFadingEdgeLength(0);
        this.Oo.setOverScrollMode(2);
        this.Oo.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Oo.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Oo.setNextPage(this.gYE);
        this.Oo.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gYE != null) {
                    m.this.gYE.iZ(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gYE.setOnClickListener(null);
                    m.this.gYE.showLoading();
                    m.this.gYz.aYU();
                }
            }
        });
        this.Oo.setOnScrollListener(this.mScrollListener);
        bJh();
        this.gYR = new ReplyMeModel(this.gYz.getPageContext());
        this.gYR.a(this.gYY);
        this.gYX = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.gYz.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean asH() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData qx(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.gYU);
                writeData.setThreadId(m.this.gYT.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gYT.bJk()) {
                    writeData.setFloor(m.this.gYV > 0 ? String.valueOf(m.this.gYV) : m.this.gYT.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gYT.getPost_id());
                }
                if (m.this.gYW > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gYW));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String asI() {
                return null;
            }
        };
        this.gYS = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().cK(this.gYz.getPageContext().getContext());
        this.gYS.a(this.gYz.getPageContext());
        this.gYS.b(this.gYX);
        this.gYS.e(this.gYz.getPageContext());
        this.gYS.asm().fk(true);
        this.gYS.asm().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gYS.asm() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gYS.asm(), layoutParams);
            this.gYS.asm().hide();
        }
        this.gYS.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void asL() {
                if (m.this.gYz.getBaseFragmentActivity() != null) {
                    m.this.gYz.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gYS.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (m.this.gYz.getBaseFragmentActivity() != null) {
                    m.this.gYz.getBaseFragmentActivity().hideProgressBar();
                    m.this.gYS.asm().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gYK.a(m.this.gYL);
                        m.this.gYK.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && yVar == null && !AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gYz.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bJh() {
        this.gYG = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gYz.getPageContext());
        this.gYH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gYz.getPageContext());
        this.gYG.aX(this.gYz.getString(R.string.at_me), R.drawable.icon_im_at);
        wl(this.gYM);
        this.gYH.aX(this.gYz.getString(R.string.agree_me), R.drawable.icon_im_laud);
        wm(this.gYN);
        this.Oo.addHeaderView(this.gYG.getView());
        this.Oo.addHeaderView(this.gYH.getView());
        this.Oo.setOnHeaderClickListener(this.gYP);
    }

    public void onChangeSkinType(int i) {
        if (this.gYS != null && this.gYS.asm() != null) {
            this.gYS.asm().onChangeSkinType(i);
        }
        if (this.gYE != null) {
            this.gYE.setTextColor(am.getColor(R.color.cp_cont_d));
            this.gYE.iY(i);
        }
        if (this.mPullView != null) {
            this.mPullView.iY(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.l(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.gYG != null) {
            this.gYG.bql();
        }
        if (this.gYH != null) {
            this.gYH.bql();
        }
        notifyDataSetChanged();
        am.l(this.Oo, this.gYO);
        am.l(this.dra, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gYS == null || this.gYS.asm() == null || this.gYS.asm().getVisibility() != 0) {
            return false;
        }
        this.gYS.atj();
        return true;
    }

    public void mT(boolean z) {
        if (this.dra != null) {
            if (z && this.Oo != null && this.Oo.getFirstVisiblePosition() != 0) {
                this.Oo.setSelection(0);
            }
            this.dra.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gYM = newsNotifyMessage.getMsgAtme();
            this.gYN = newsNotifyMessage.getMsgAgree();
            wl(this.gYM);
            wm(this.gYN);
        }
    }

    public void bJi() {
        wl(this.gYM);
        wm(this.gYN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wl(int i) {
        if (this.gYG != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoD()) {
                z = true;
            }
            this.gYG.M(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wm(int i) {
        if (this.gYH != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aoy().aoP()) {
                z = true;
            }
            this.gYH.M(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gYS != null) {
            if (i == 12005) {
                this.gYS.atm();
            }
            this.gYS.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gYS.asm().aqI();
        this.gYS.atj();
        this.gYS.asm().asx();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gYS.b(writeData);
                this.gYS.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k kt = this.gYS.asm().kt(6);
                if (kt != null && kt.csV != null) {
                    kt.csV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gYS.atf();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, long j) {
        if (this.fzF == null) {
            this.fzF = new com.baidu.tieba.frs.profession.permission.c(this.gYz.getPageContext());
            this.fzF.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ki(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void kj(boolean z) {
                    if (z && m.this.gYS != null && m.this.gYT != null) {
                        if (!m.this.gYT.bJk() || m.this.gYT.getReplyer() == null) {
                            m.this.gYS.qH(null);
                        } else {
                            m.this.gYS.qH(m.this.gYT.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fzF.v(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gYS != null) {
            this.gYS.onDestory();
        }
        if (this.gYK != null) {
            this.gYK.onDestroy();
        }
        if (this.gYR != null) {
            this.gYR.a((ReplyMeModel.a) null);
            this.gYR.onDestroy();
        }
        if (this.gYK != null) {
            this.gYK.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gYF != null) {
            this.gYF.d(sVar);
        }
    }
}
