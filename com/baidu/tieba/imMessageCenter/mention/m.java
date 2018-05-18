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
    private BdTypeRecyclerView bof;
    private BdSwipeRefreshLayout bog;
    private final e.b bom;
    private final ReplyMessageFragment eoQ;
    private PbListView eoV;
    private com.baidu.tieba.imMessageCenter.mention.base.e eoW;
    private com.baidu.tieba.imMessageCenter.mention.base.f eoX;
    private com.baidu.tieba.imMessageCenter.mention.base.f eoY;
    private boolean eoZ;
    private boolean epa;
    private ai epb;
    private AttentionHostData epc;
    private int epd;
    private int epe;
    private int epf;
    private BdListView.b epg;
    private View.OnClickListener eph;
    private ReplyMeModel epi;
    private com.baidu.tbadk.editortools.pb.g epj;
    private com.baidu.tieba.imMessageCenter.mention.base.a epk;
    private String epl;
    private long epm;
    private long epn;
    private DataModel<MessageCenterActivity> epo;
    private final ReplyMeModel.a epp;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.f mPullView;
    private com.baidu.tbadk.j.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.epd = 0;
        this.epe = 0;
        this.epf = d.C0126d.cp_bg_line_e;
        this.epg = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view2) {
                if (view2 != m.this.eoX.getView()) {
                    if (view2 == m.this.eoY.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.zw().zM();
                        com.baidu.tbadk.coreExtra.messageCenter.a.zw().dT(0);
                        m.this.epe = 0;
                        m.this.oi(m.this.epe);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.zw().zL();
                com.baidu.tbadk.coreExtra.messageCenter.a.zw().setMsgAtme(0);
                m.this.epd = 0;
                m.this.oh(m.this.epd);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.eph = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (m.this.eoV != null && m.this.eoQ != null) {
                    m.this.eoV.dx(0);
                    m.this.eoV.setOnClickListener(null);
                    m.this.eoV.wQ();
                    m.this.eoQ.aIM();
                }
            }
        };
        this.bom = new e.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.e.b
            public void aO(boolean z) {
                if (com.baidu.adp.lib.util.j.gP()) {
                    if (m.this.eoQ != null) {
                        m.this.eoQ.aIL();
                    }
                } else if (m.this.bog != null) {
                    m.this.bog.setRefreshing(false);
                }
            }
        };
        this.epi = null;
        this.epp = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.epl = str;
                m.this.epm = j2;
                m.this.epn = j3;
                if (m.this.epj != null && m.this.epk != null) {
                    if (!m.this.epk.aIP() || m.this.epk.getReplyer() == null) {
                        m.this.epj.gu(null);
                    } else {
                        m.this.epj.gu(m.this.epk.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.epj != null) {
                    m.this.epj.Ey();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eoQ = replyMessageFragment;
        this.epb = new ai(replyMessageFragment.getPageContext());
        this.epb.a(new ai.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.ai.a
            public void c(boolean z, int i) {
                if (z && m.this.epj != null) {
                    m.this.epj.Eu();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.w(this.bof.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        m.this.hO(true);
                        m.this.eoQ.aIL();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.Fs();
                this.mRefreshView.fa(getPageContext().getResources().getDimensionPixelSize(d.e.ds_102));
                this.mRefreshView.Fq().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.setSubText(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.epa) {
                this.bof.addHeaderView(this.mRefreshView.Fq(), 0);
            }
            this.epa = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        hO(false);
        if (z) {
            this.eoV.dx(0);
            this.eoV.wR();
            this.eoV.setOnClickListener(this.eph);
        } else {
            this.eoV.dx(0);
            this.eoV.wR();
            this.eoV.setText(this.mContext.getResources().getString(d.k.list_no_more));
            this.eoV.setOnClickListener(null);
        }
        if (v.w(arrayList)) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dp(d.k.mention_replyme_nodata), null);
                this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
            }
            if (this.mNoDataView.getParent() == null && !this.eoZ && this.bof != null) {
                this.eoZ = true;
                this.bof.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.bof.setNextPage(null);
            this.epf = d.C0126d.cp_bg_line_d;
        } else {
            if (this.bof != null) {
                this.bof.removeHeaderView(this.mNoDataView);
                this.eoZ = false;
                if (this.mRefreshView != null) {
                    this.bof.removeHeaderView(this.mRefreshView.Fq());
                    this.epa = false;
                }
            }
            if (this.eoW != null) {
                this.eoW.setData(arrayList);
                this.eoW.notifyDataSetChanged();
            }
            this.bof.setNextPage(this.eoV);
            this.epf = d.C0126d.cp_bg_line_e;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eoW != null) {
            this.eoW.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.f(this.eoQ.getPageContext());
            this.mPullView.a(this.bom);
        }
        this.mPullView.setTag(this.eoQ.getUniqueId());
        if (this.eoV == null) {
            this.eoV = new PbListView(this.eoQ.getContext());
            this.eoV.getView();
        }
        this.eoV.dv(d.C0126d.cp_bg_line_e);
        this.eoV.setHeight(com.baidu.adp.lib.util.l.e(this.eoQ.getContext(), d.e.tbds182));
        this.eoV.wN();
        this.eoV.setTextSize(d.e.tbfontsize33);
        this.eoV.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
        this.eoV.du(d.C0126d.cp_cont_e);
        this.eoV.setOnClickListener(this.eph);
        this.bog = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.bog.setProgressView(this.mPullView);
        this.bof = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eoW = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eoQ.getPageContext(), this.bof);
        this.eoW.d(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ab
            public void a(View view2, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view2 != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.hP(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view2.getId() == d.g.message_bottom_reply_container) {
                        m.this.epk = aVar;
                        if (aVar.aIP()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aIQ(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.epc == null) {
                            m.this.epc = new AttentionHostData();
                        }
                        if (m.this.epk != null) {
                            m.this.epc.parserWithMetaData(m.this.epk.getThreadAuthor());
                        }
                        m.this.epi.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aIR() != null) {
                            al r = new al(aVar.aIR()).r("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.epP) {
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
        ((DefaultItemAnimator) this.bof.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bof.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bof.setFadingEdgeLength(0);
        this.bof.setOverScrollMode(2);
        this.bof.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bof.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view2 = viewHolder.itemView;
            }
        });
        this.bof.setNextPage(this.eoV);
        this.bof.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.eoV != null) {
                    m.this.eoV.dx(0);
                    m.this.eoV.setOnClickListener(null);
                    m.this.eoV.showLoading();
                    m.this.eoQ.aIM();
                }
            }
        });
        this.bof.setOnScrollListener(this.mScrollListener);
        aIJ();
        this.epi = new ReplyMeModel(this.eoQ.getPageContext());
        this.epi.a(this.epp);
        this.epo = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.eoQ.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean DX() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData gi(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.epl);
                writeData.setThreadId(m.this.epk.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.epk.aIP()) {
                    writeData.setFloor(m.this.epm > 0 ? String.valueOf(m.this.epm) : m.this.epk.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.epk.getPost_id());
                }
                if (m.this.epn > 0) {
                    writeData.setRepostId(String.valueOf(m.this.epn));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String DY() {
                return null;
            }
        };
        this.epj = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aO(this.eoQ.getPageContext().getContext());
        this.epj.setContext(this.eoQ.getPageContext());
        this.epj.b(this.epo);
        this.epj.d(this.eoQ.getPageContext());
        this.epj.DD().bx(true);
        this.epj.DD().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.epj.DD() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.epj.DD(), layoutParams);
            this.epj.DD().hide();
        }
        this.epj.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Eb() {
                if (m.this.eoQ.getBaseFragmentActivity() != null) {
                    m.this.eoQ.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.epj.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (m.this.eoQ.getBaseFragmentActivity() != null) {
                    m.this.eoQ.getBaseFragmentActivity().hideProgressBar();
                    m.this.epj.DD().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.epb.a(m.this.epc);
                        m.this.epb.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && tVar == null && !AntiHelper.ts(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.eoQ.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aIJ() {
        this.eoX = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eoQ.getPageContext());
        this.eoY = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eoQ.getPageContext());
        this.eoX.au(this.eoQ.getString(d.k.at_me), d.f.icon_im_at);
        oh(this.epd);
        this.eoY.au(this.eoQ.getString(d.k.agree_me), d.f.icon_im_laud);
        oi(this.epe);
        this.eoY.oj(8);
        this.bof.addHeaderView(this.eoX.getView());
        this.bof.addHeaderView(this.eoY.getView());
        this.bof.setOnHeaderClickListener(this.epg);
    }

    public void onChangeSkinType(int i) {
        if (this.epj != null && this.epj.DD() != null) {
            this.epj.DD().onChangeSkinType(i);
        }
        if (this.eoV != null) {
            this.eoV.setTextColor(ak.getColor(d.C0126d.cp_cont_d));
            this.eoV.dw(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dw(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ak.j(this.mNoDataView, d.C0126d.cp_bg_line_d);
        }
        if (this.eoX != null) {
            this.eoX.aIS();
        }
        if (this.eoY != null) {
            this.eoY.aIS();
        }
        notifyDataSetChanged();
        ak.j(this.bof, this.epf);
        ak.j(this.bog, d.C0126d.cp_bg_line_c);
    }

    public boolean onBackPressed() {
        if (this.epj == null || this.epj.DD() == null || this.epj.DD().getVisibility() != 0) {
            return false;
        }
        this.epj.Ey();
        return true;
    }

    public void hO(boolean z) {
        if (this.bog != null) {
            this.bog.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.epd = newsNotifyMessage.getMsgAtme();
            this.epe = newsNotifyMessage.getMsgAgree();
            oh(this.epd);
            oi(this.epe);
        }
    }

    public void aIK() {
        oh(this.epd);
        oi(this.epe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh(int i) {
        if (this.eoX != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ad().Ai()) {
                z = true;
            }
            this.eoX.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(int i) {
        if (this.eoY != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ad().At()) {
                z = true;
            }
            this.eoY.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.epj != null) {
            this.epj.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.epj.DD().BY();
        this.epj.Ey();
        this.epj.DD().DN();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.epj.b(writeData);
                this.epj.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eI = this.epj.DD().eI(6);
                if (eI != null && eI.aCN != null) {
                    eI.aCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.epj.Eu();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.epj != null) {
            this.epj.onDestory();
        }
        if (this.epb != null) {
            this.epb.onDestroy();
        }
        if (this.epi != null) {
            this.epi.a((ReplyMeModel.a) null);
            this.epi.onDestroy();
        }
        if (this.epb != null) {
            this.epb.a((ai.a) null);
        }
    }

    public void d(n nVar) {
        if (this.eoW != null) {
            this.eoW.d(nVar);
        }
    }
}
