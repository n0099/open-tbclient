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
    private final ReplyMessageFragment enH;
    private PbListView enM;
    private com.baidu.tieba.imMessageCenter.mention.base.e enN;
    private com.baidu.tieba.imMessageCenter.mention.base.f enO;
    private com.baidu.tieba.imMessageCenter.mention.base.f enP;
    private boolean enQ;
    private boolean enR;
    private ai enS;
    private AttentionHostData enT;
    private int enU;
    private int enV;
    private int enW;
    private BdListView.b enX;
    private View.OnClickListener enY;
    private ReplyMeModel enZ;
    private com.baidu.tbadk.editortools.pb.g eoa;
    private com.baidu.tieba.imMessageCenter.mention.base.a eob;
    private String eoc;
    private long eod;
    private long eoe;
    private DataModel<MessageCenterActivity> eog;
    private final ReplyMeModel.a eoh;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.f mPullView;
    private com.baidu.tbadk.j.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.enU = 0;
        this.enV = 0;
        this.enW = d.C0126d.cp_bg_line_e;
        this.enX = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view2) {
                if (view2 != m.this.enO.getView()) {
                    if (view2 == m.this.enP.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().zN();
                        com.baidu.tbadk.coreExtra.messageCenter.a.zx().dS(0);
                        m.this.enV = 0;
                        m.this.oj(m.this.enV);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().zM();
                com.baidu.tbadk.coreExtra.messageCenter.a.zx().setMsgAtme(0);
                m.this.enU = 0;
                m.this.oi(m.this.enU);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.enY = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.enM != null && m.this.enH != null) {
                    m.this.enM.dw(0);
                    m.this.enM.setOnClickListener(null);
                    m.this.enM.wR();
                    m.this.enH.aIN();
                }
            }
        };
        this.bnX = new e.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (com.baidu.adp.lib.util.j.gP()) {
                    if (m.this.enH != null) {
                        m.this.enH.aIM();
                    }
                } else if (m.this.bnR != null) {
                    m.this.bnR.setRefreshing(false);
                }
            }
        };
        this.enZ = null;
        this.eoh = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.eoc = str;
                m.this.eod = j2;
                m.this.eoe = j3;
                if (m.this.eoa != null && m.this.eob != null) {
                    if (!m.this.eob.aIQ() || m.this.eob.getReplyer() == null) {
                        m.this.eoa.gu(null);
                    } else {
                        m.this.eoa.gu(m.this.eob.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.eoa != null) {
                    m.this.eoa.EA();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.enH = replyMessageFragment;
        this.enS = new ai(replyMessageFragment.getPageContext());
        this.enS.a(new ai.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.ai.a
            public void c(boolean z, int i) {
                if (z && m.this.eoa != null) {
                    m.this.eoa.Ew();
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
                        m.this.enH.aIM();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.Fu();
                this.mRefreshView.eZ(getPageContext().getResources().getDimensionPixelSize(d.e.ds_102));
                this.mRefreshView.Fs().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.setSubText(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.enR) {
                this.bnQ.addHeaderView(this.mRefreshView.Fs(), 0);
            }
            this.enR = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        hN(false);
        if (z) {
            this.enM.dw(0);
            this.enM.wS();
            this.enM.setOnClickListener(this.enY);
        } else {
            this.enM.dw(0);
            this.enM.wS();
            this.enM.setText(this.mContext.getResources().getString(d.k.list_no_more));
            this.enM.setOnClickListener(null);
        }
        if (v.w(arrayList)) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.m16do(d.k.mention_replyme_nodata), null);
                this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
            }
            if (this.mNoDataView.getParent() == null && !this.enQ && this.bnQ != null) {
                this.enQ = true;
                this.bnQ.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.bnQ.setNextPage(null);
            this.enW = d.C0126d.cp_bg_line_d;
        } else {
            if (this.bnQ != null) {
                this.bnQ.removeHeaderView(this.mNoDataView);
                this.enQ = false;
                if (this.mRefreshView != null) {
                    this.bnQ.removeHeaderView(this.mRefreshView.Fs());
                    this.enR = false;
                }
            }
            if (this.enN != null) {
                this.enN.setData(arrayList);
                this.enN.notifyDataSetChanged();
            }
            this.bnQ.setNextPage(this.enM);
            this.enW = d.C0126d.cp_bg_line_e;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.enN != null) {
            this.enN.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.f(this.enH.getPageContext());
            this.mPullView.a(this.bnX);
        }
        this.mPullView.setTag(this.enH.getUniqueId());
        if (this.enM == null) {
            this.enM = new PbListView(this.enH.getContext());
            this.enM.getView();
        }
        this.enM.du(d.C0126d.cp_bg_line_e);
        this.enM.setHeight(com.baidu.adp.lib.util.l.e(this.enH.getContext(), d.e.tbds182));
        this.enM.wO();
        this.enM.setTextSize(d.e.tbfontsize33);
        this.enM.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
        this.enM.dt(d.C0126d.cp_cont_e);
        this.enM.setOnClickListener(this.enY);
        this.bnR = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.bnR.setProgressView(this.mPullView);
        this.bnQ = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.enN = new com.baidu.tieba.imMessageCenter.mention.base.e(this.enH.getPageContext(), this.bnQ);
        this.enN.d(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
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
                        m.this.eob = aVar;
                        if (aVar.aIQ()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aIR(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.enT == null) {
                            m.this.enT = new AttentionHostData();
                        }
                        if (m.this.eob != null) {
                            m.this.enT.parserWithMetaData(m.this.eob.getThreadAuthor());
                        }
                        m.this.enZ.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aIS() != null) {
                            al r = new al(aVar.aIS()).r("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eoG) {
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
        this.bnQ.setNextPage(this.enM);
        this.bnQ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.enM != null) {
                    m.this.enM.dw(0);
                    m.this.enM.setOnClickListener(null);
                    m.this.enM.showLoading();
                    m.this.enH.aIN();
                }
            }
        });
        this.bnQ.setOnScrollListener(this.mScrollListener);
        aIK();
        this.enZ = new ReplyMeModel(this.enH.getPageContext());
        this.enZ.a(this.eoh);
        this.eog = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.enH.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
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
                writeData.setForumName(m.this.eoc);
                writeData.setThreadId(m.this.eob.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.eob.aIQ()) {
                    writeData.setFloor(m.this.eod > 0 ? String.valueOf(m.this.eod) : m.this.eob.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.eob.getPost_id());
                }
                if (m.this.eoe > 0) {
                    writeData.setRepostId(String.valueOf(m.this.eoe));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Ea() {
                return null;
            }
        };
        this.eoa = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aO(this.enH.getPageContext().getContext());
        this.eoa.setContext(this.enH.getPageContext());
        this.eoa.b(this.eog);
        this.eoa.d(this.enH.getPageContext());
        this.eoa.DF().bx(true);
        this.eoa.DF().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eoa.DF() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eoa.DF(), layoutParams);
            this.eoa.DF().hide();
        }
        this.eoa.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Ed() {
                if (m.this.enH.getBaseFragmentActivity() != null) {
                    m.this.enH.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.eoa.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (m.this.enH.getBaseFragmentActivity() != null) {
                    m.this.enH.getBaseFragmentActivity().hideProgressBar();
                    m.this.eoa.DF().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.enS.a(m.this.enT);
                        m.this.enS.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && tVar == null && !AntiHelper.tt(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.enH.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aIK() {
        this.enO = new com.baidu.tieba.imMessageCenter.mention.base.f(this.enH.getPageContext());
        this.enP = new com.baidu.tieba.imMessageCenter.mention.base.f(this.enH.getPageContext());
        this.enO.au(this.enH.getString(d.k.at_me), d.f.icon_im_at);
        oi(this.enU);
        this.enP.au(this.enH.getString(d.k.agree_me), d.f.icon_im_laud);
        oj(this.enV);
        this.enP.ok(8);
        this.bnQ.addHeaderView(this.enO.getView());
        this.bnQ.addHeaderView(this.enP.getView());
        this.bnQ.setOnHeaderClickListener(this.enX);
    }

    public void onChangeSkinType(int i) {
        if (this.eoa != null && this.eoa.DF() != null) {
            this.eoa.DF().onChangeSkinType(i);
        }
        if (this.enM != null) {
            this.enM.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.enM.dv(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dv(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
        }
        if (this.enO != null) {
            this.enO.aIT();
        }
        if (this.enP != null) {
            this.enP.aIT();
        }
        notifyDataSetChanged();
        ak.j(this.bnQ, this.enW);
        ak.j(this.bnR, d.C0126d.cp_bg_line_c);
    }

    public boolean onBackPressed() {
        if (this.eoa == null || this.eoa.DF() == null || this.eoa.DF().getVisibility() != 0) {
            return false;
        }
        this.eoa.EA();
        return true;
    }

    public void hN(boolean z) {
        if (this.bnR != null) {
            this.bnR.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.enU = newsNotifyMessage.getMsgAtme();
            this.enV = newsNotifyMessage.getMsgAgree();
            oi(this.enU);
            oj(this.enV);
        }
    }

    public void aIL() {
        oi(this.enU);
        oj(this.enV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(int i) {
        if (this.enO != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Aj()) {
                z = true;
            }
            this.enO.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(int i) {
        if (this.enP != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ae().Au()) {
                z = true;
            }
            this.enP.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eoa != null) {
            this.eoa.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eoa.DF().Ca();
        this.eoa.EA();
        this.eoa.DF().DP();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eoa.b(writeData);
                this.eoa.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eH = this.eoa.DF().eH(6);
                if (eH != null && eH.aCM != null) {
                    eH.aCM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eoa.Ew();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eoa != null) {
            this.eoa.onDestory();
        }
        if (this.enS != null) {
            this.enS.onDestroy();
        }
        if (this.enZ != null) {
            this.enZ.a((ReplyMeModel.a) null);
            this.enZ.onDestroy();
        }
        if (this.enS != null) {
            this.enS.a((ai.a) null);
        }
    }

    public void d(n nVar) {
        if (this.enN != null) {
            this.enN.d(nVar);
        }
    }
}
