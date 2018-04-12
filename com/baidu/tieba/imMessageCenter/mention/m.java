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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView bnQ;
    private BdSwipeRefreshLayout bnR;
    private final e.b bnX;
    private final ReplyMessageFragment enK;
    private PbListView enP;
    private com.baidu.tieba.imMessageCenter.mention.base.e enQ;
    private com.baidu.tieba.imMessageCenter.mention.base.f enR;
    private com.baidu.tieba.imMessageCenter.mention.base.f enS;
    private boolean enT;
    private boolean enU;
    private ai enV;
    private AttentionHostData enW;
    private int enX;
    private int enY;
    private int enZ;
    private BdListView.b eoa;
    private View.OnClickListener eob;
    private ReplyMeModel eoc;
    private com.baidu.tbadk.editortools.pb.g eod;
    private com.baidu.tieba.imMessageCenter.mention.base.a eoe;
    private String eog;
    private long eoh;
    private long eoi;
    private DataModel<MessageCenterActivity> eoj;
    private final ReplyMeModel.a eok;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.f mPullView;
    private com.baidu.tbadk.j.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.enX = 0;
        this.enY = 0;
        this.enZ = d.C0126d.cp_bg_line_e;
        this.eoa = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view2) {
                if (view2 != m.this.enR.getView()) {
                    if (view2 == m.this.enS.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().zN();
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().dT(0);
                        m.this.enY = 0;
                        m.this.ok(m.this.enY);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().zM();
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgAtme(0);
                m.this.enX = 0;
                m.this.oj(m.this.enX);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.eob = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.enP != null && m.this.enK != null) {
                    m.this.enP.dx(0);
                    m.this.enP.setOnClickListener(null);
                    m.this.enP.wR();
                    m.this.enK.aIN();
                }
            }
        };
        this.bnX = new e.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (com.baidu.adp.lib.util.j.gP()) {
                    if (m.this.enK != null) {
                        m.this.enK.aIM();
                    }
                } else if (m.this.bnR != null) {
                    m.this.bnR.setRefreshing(false);
                }
            }
        };
        this.eoc = null;
        this.eok = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.eog = str;
                m.this.eoh = j2;
                m.this.eoi = j3;
                if (m.this.eod != null && m.this.eoe != null) {
                    if (!m.this.eoe.aIQ() || m.this.eoe.getReplyer() == null) {
                        m.this.eod.gu(null);
                    } else {
                        m.this.eod.gu(m.this.eoe.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.eod != null) {
                    m.this.eod.EA();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.enK = replyMessageFragment;
        this.enV = new ai(replyMessageFragment.getPageContext());
        this.enV.a(new ai.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.ai.a
            public void c(boolean z, int i) {
                if (z && m.this.eod != null) {
                    m.this.eod.Ew();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.w(this.bnQ.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        m.this.hN(true);
                        m.this.enK.aIM();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.Fu();
                this.mRefreshView.fa(getPageContext().getResources().getDimensionPixelSize(d.e.ds_102));
                this.mRefreshView.Fs().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.setSubText(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.enU) {
                this.bnQ.addHeaderView(this.mRefreshView.Fs(), 0);
            }
            this.enU = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        hN(false);
        if (z) {
            this.enP.dx(0);
            this.enP.wS();
            this.enP.setOnClickListener(this.eob);
        } else {
            this.enP.dx(0);
            this.enP.wS();
            this.enP.setText(this.mContext.getResources().getString(d.k.list_no_more));
            this.enP.setOnClickListener(null);
        }
        if (v.w(arrayList)) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.k.mention_replyme_nodata), null);
                this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
            }
            if (this.mNoDataView.getParent() == null && !this.enT && this.bnQ != null) {
                this.enT = true;
                this.bnQ.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.bnQ.setNextPage(null);
            this.enZ = d.C0126d.cp_bg_line_d;
        } else {
            if (this.bnQ != null) {
                this.bnQ.removeHeaderView(this.mNoDataView);
                this.enT = false;
                if (this.mRefreshView != null) {
                    this.bnQ.removeHeaderView(this.mRefreshView.Fs());
                    this.enU = false;
                }
            }
            if (this.enQ != null) {
                this.enQ.setData(arrayList);
                this.enQ.notifyDataSetChanged();
            }
            this.bnQ.setNextPage(this.enP);
            this.enZ = d.C0126d.cp_bg_line_e;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.enQ != null) {
            this.enQ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.f(this.enK.getPageContext());
            this.mPullView.a(this.bnX);
        }
        this.mPullView.setTag(this.enK.getUniqueId());
        if (this.enP == null) {
            this.enP = new PbListView(this.enK.getContext());
            this.enP.getView();
        }
        this.enP.dv(d.C0126d.cp_bg_line_e);
        this.enP.setHeight(com.baidu.adp.lib.util.l.e(this.enK.getContext(), d.e.tbds182));
        this.enP.wO();
        this.enP.setTextSize(d.e.tbfontsize33);
        this.enP.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
        this.enP.du(d.C0126d.cp_cont_e);
        this.enP.setOnClickListener(this.eob);
        this.bnR = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.bnR.setProgressView(this.mPullView);
        this.bnQ = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.enQ = new com.baidu.tieba.imMessageCenter.mention.base.e(this.enK.getPageContext(), this.bnQ);
        this.enQ.d(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view2 != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.hO(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view2.getId() == d.g.message_bottom_reply_container) {
                        m.this.eoe = aVar;
                        if (aVar.aIQ()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aIR(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.enW == null) {
                            m.this.enW = new AttentionHostData();
                        }
                        if (m.this.eoe != null) {
                            m.this.enW.parserWithMetaData(m.this.eoe.getThreadAuthor());
                        }
                        m.this.eoc.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aIS() != null) {
                            al r = new al(aVar.aIS()).r("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eoJ) {
                                r.r("obj_type", 1);
                            } else {
                                r.r("obj_type", 2);
                            }
                            TiebaStatic.log(r);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.bnQ.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bnQ.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bnQ.setFadingEdgeLength(0);
        this.bnQ.setOverScrollMode(2);
        this.bnQ.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bnQ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
            }
        });
        this.bnQ.setNextPage(this.enP);
        this.bnQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.enP != null) {
                    m.this.enP.dx(0);
                    m.this.enP.setOnClickListener(null);
                    m.this.enP.showLoading();
                    m.this.enK.aIN();
                }
            }
        });
        this.bnQ.setOnScrollListener(this.mScrollListener);
        aIK();
        this.eoc = new ReplyMeModel(this.enK.getPageContext());
        this.eoc.a(this.eok);
        this.eoj = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.enK.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean DZ() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData gi(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.eog);
                writeData.setThreadId(m.this.eoe.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.eoe.aIQ()) {
                    writeData.setFloor(m.this.eoh > 0 ? String.valueOf(m.this.eoh) : m.this.eoe.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.eoe.getPost_id());
                }
                if (m.this.eoi > 0) {
                    writeData.setRepostId(String.valueOf(m.this.eoi));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Ea() {
                return null;
            }
        };
        this.eod = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aO(this.enK.getPageContext().getContext());
        this.eod.setContext(this.enK.getPageContext());
        this.eod.b(this.eoj);
        this.eod.d(this.enK.getPageContext());
        this.eod.DF().bx(true);
        this.eod.DF().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eod.DF() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eod.DF(), layoutParams);
            this.eod.DF().hide();
        }
        this.eod.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Ed() {
                if (m.this.enK.getBaseFragmentActivity() != null) {
                    m.this.enK.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.eod.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (m.this.enK.getBaseFragmentActivity() != null) {
                    m.this.enK.getBaseFragmentActivity().hideProgressBar();
                    m.this.eod.DF().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.enV.a(m.this.enW);
                        m.this.enV.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && tVar == null && !AntiHelper.tu(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.enK.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aIK() {
        this.enR = new com.baidu.tieba.imMessageCenter.mention.base.f(this.enK.getPageContext());
        this.enS = new com.baidu.tieba.imMessageCenter.mention.base.f(this.enK.getPageContext());
        this.enR.au(this.enK.getString(d.k.at_me), d.f.icon_im_at);
        oj(this.enX);
        this.enS.au(this.enK.getString(d.k.agree_me), d.f.icon_im_laud);
        ok(this.enY);
        this.enS.ol(8);
        this.bnQ.addHeaderView(this.enR.getView());
        this.bnQ.addHeaderView(this.enS.getView());
        this.bnQ.setOnHeaderClickListener(this.eoa);
    }

    public void onChangeSkinType(int i) {
        if (this.eod != null && this.eod.DF() != null) {
            this.eod.DF().onChangeSkinType(i);
        }
        if (this.enP != null) {
            this.enP.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.enP.dw(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
        }
        if (this.enR != null) {
            this.enR.aIT();
        }
        if (this.enS != null) {
            this.enS.aIT();
        }
        notifyDataSetChanged();
        ak.j(this.bnQ, this.enZ);
        ak.j(this.bnR, d.C0126d.cp_bg_line_c);
    }

    public boolean onBackPressed() {
        if (this.eod == null || this.eod.DF() == null || this.eod.DF().getVisibility() != 0) {
            return false;
        }
        this.eod.EA();
        return true;
    }

    public void hN(boolean z) {
        if (this.bnR != null) {
            this.bnR.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.enX = newsNotifyMessage.getMsgAtme();
            this.enY = newsNotifyMessage.getMsgAgree();
            oj(this.enX);
            ok(this.enY);
        }
    }

    public void aIL() {
        oj(this.enX);
        ok(this.enY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(int i) {
        if (this.enR != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Aj()) {
                z = true;
            }
            this.enR.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i) {
        if (this.enS != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Au()) {
                z = true;
            }
            this.enS.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eod != null) {
            this.eod.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eod.DF().Ca();
        this.eod.EA();
        this.eod.DF().DP();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eod.b(writeData);
                this.eod.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eI = this.eod.DF().eI(6);
                if (eI != null && eI.aCM != null) {
                    eI.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eod.Ew();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eod != null) {
            this.eod.onDestory();
        }
        if (this.enV != null) {
            this.enV.onDestroy();
        }
        if (this.eoc != null) {
            this.eoc.a((ReplyMeModel.a) null);
            this.eoc.onDestroy();
        }
        if (this.enV != null) {
            this.enV.a((ai.a) null);
        }
    }

    public void d(n nVar) {
        if (this.enQ != null) {
            this.enQ.d(nVar);
        }
    }
}
