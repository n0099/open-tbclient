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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView bym;
    private BdSwipeRefreshLayout byn;
    private final g.b byt;
    private final ReplyMessageFragment eHR;
    private PbListView eHW;
    private com.baidu.tieba.imMessageCenter.mention.base.e eHX;
    private com.baidu.tieba.imMessageCenter.mention.base.f eHY;
    private com.baidu.tieba.imMessageCenter.mention.base.f eHZ;
    private boolean eIa;
    private boolean eIb;
    private ak eIc;
    private AttentionHostData eId;
    private int eIe;
    private int eIf;
    private int eIg;
    private BdListView.b eIh;
    private View.OnClickListener eIi;
    private ReplyMeModel eIj;
    private com.baidu.tbadk.editortools.pb.g eIk;
    private com.baidu.tieba.imMessageCenter.mention.base.a eIl;
    private String eIm;
    private long eIn;
    private long eIo;
    private DataModel<MessageCenterActivity> eIp;
    private final ReplyMeModel.a eIq;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private com.baidu.tbadk.k.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eIe = 0;
        this.eIf = 0;
        this.eIg = d.C0140d.cp_bg_line_e;
        this.eIh = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.eHY.getView()) {
                    if (view == m.this.eHZ.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DB();
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dZ(0);
                        m.this.eIf = 0;
                        m.this.oQ(m.this.eIf);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DA();
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgAtme(0);
                m.this.eIe = 0;
                m.this.oP(m.this.eIe);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.eIi = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eHW != null && m.this.eHR != null) {
                    m.this.eHW.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eHW.setOnClickListener(null);
                    m.this.eHW.Ax();
                    m.this.eHR.aPn();
                }
            }
        };
        this.byt = new g.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.g.b
            public void aS(boolean z) {
                if (com.baidu.adp.lib.util.j.jE()) {
                    if (m.this.eHR != null) {
                        m.this.eHR.aPm();
                    }
                } else if (m.this.byn != null) {
                    m.this.byn.setRefreshing(false);
                }
            }
        };
        this.eIj = null;
        this.eIq = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.eIm = str;
                m.this.eIn = j2;
                m.this.eIo = j3;
                if (m.this.eIk != null && m.this.eIl != null) {
                    if (!m.this.eIl.aPq() || m.this.eIl.getReplyer() == null) {
                        m.this.eIk.gS(null);
                    } else {
                        m.this.eIk.gS(m.this.eIl.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.eIk != null) {
                    m.this.eIk.Ip();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eHR = replyMessageFragment;
        this.eIc = new ak(replyMessageFragment.getPageContext());
        this.eIc.a(new ak.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.ak.a
            public void c(boolean z, int i) {
                if (z && m.this.eIk != null) {
                    m.this.eIk.Il();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (w.z(this.bym.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.ih(true);
                        m.this.eHR.aPm();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.Jk();
                this.mRefreshView.fg(getPageContext().getResources().getDimensionPixelSize(d.e.ds_102));
                this.mRefreshView.Ji().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.hk(getPageContext().getResources().getString(d.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.hk(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.eIb) {
                this.bym.addHeaderView(this.mRefreshView.Ji(), 0);
            }
            this.eIb = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.bym != null) {
            ih(false);
            if (z) {
                this.eHW.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.eHW.Ay();
                this.eHW.setOnClickListener(this.eIi);
            } else {
                this.eHW.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.eHW.Ay();
                this.eHW.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.eHW.setOnClickListener(null);
            }
            if (w.z(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.du(d.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.j(this.mNoDataView, d.C0140d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eIa) {
                    this.eIa = true;
                    this.bym.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bym.setNextPage(null);
                this.eIg = d.C0140d.cp_bg_line_d;
            } else {
                this.bym.removeHeaderView(this.mNoDataView);
                this.eIa = false;
                if (this.mRefreshView != null) {
                    this.bym.removeHeaderView(this.mRefreshView.Ji());
                    this.eIb = false;
                }
                if (this.eHX != null) {
                    this.eHX.setData(arrayList);
                    this.eHX.notifyDataSetChanged();
                }
                this.bym.setNextPage(this.eHW);
                this.eIg = d.C0140d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eHX != null) {
            this.eHX.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.eHR.getPageContext());
            this.mPullView.a(this.byt);
        }
        this.mPullView.setTag(this.eHR.getUniqueId());
        if (this.eHW == null) {
            this.eHW = new PbListView(this.eHR.getContext());
            this.eHW.getView();
        }
        this.eHW.dB(d.C0140d.cp_bg_line_e);
        this.eHW.setHeight(com.baidu.adp.lib.util.l.f(this.eHR.getContext(), d.e.tbds182));
        this.eHW.Au();
        this.eHW.setTextSize(d.e.tbfontsize33);
        this.eHW.setTextColor(am.getColor(d.C0140d.cp_cont_d));
        this.eHW.dA(d.C0140d.cp_cont_e);
        this.eHW.setOnClickListener(this.eIi);
        this.byn = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.byn.setProgressView(this.mPullView);
        this.bym = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eHX = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eHR.getPageContext(), this.bym);
        this.eHX.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.ii(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == d.g.message_bottom_reply_container) {
                        m.this.eIl = aVar;
                        if (aVar.aPq()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aPr(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.eId == null) {
                            m.this.eId = new AttentionHostData();
                        }
                        if (m.this.eIl != null) {
                            m.this.eId.parserWithMetaData(m.this.eIl.getThreadAuthor());
                        }
                        m.this.eIj.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aPs() != null) {
                            an r = new an(aVar.aPs()).r("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eIQ) {
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
        ((DefaultItemAnimator) this.bym.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bym.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bym.setFadingEdgeLength(0);
        this.bym.setOverScrollMode(2);
        this.bym.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bym.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bym.setNextPage(this.eHW);
        this.bym.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.eHW != null) {
                    m.this.eHW.dD(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eHW.setOnClickListener(null);
                    m.this.eHW.showLoading();
                    m.this.eHR.aPn();
                }
            }
        });
        this.bym.setOnScrollListener(this.mScrollListener);
        aPk();
        this.eIj = new ReplyMeModel(this.eHR.getPageContext());
        this.eIj.a(this.eIq);
        this.eIp = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ad(this.eHR.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean HN() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData gH(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.eIm);
                writeData.setThreadId(m.this.eIl.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.eIl.aPq()) {
                    writeData.setFloor(m.this.eIn > 0 ? String.valueOf(m.this.eIn) : m.this.eIl.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.eIl.getPost_id());
                }
                if (m.this.eIo > 0) {
                    writeData.setRepostId(String.valueOf(m.this.eIo));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String HO() {
                return null;
            }
        };
        this.eIk = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aZ(this.eHR.getPageContext().getContext());
        this.eIk.setContext(this.eHR.getPageContext());
        this.eIk.b(this.eIp);
        this.eIk.d(this.eHR.getPageContext());
        this.eIk.Ht().bC(true);
        this.eIk.Ht().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eIk.Ht() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eIk.Ht(), layoutParams);
            this.eIk.Ht().hide();
        }
        this.eIk.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void HR() {
                if (m.this.eHR.getBaseFragmentActivity() != null) {
                    m.this.eHR.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.eIk.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (m.this.eHR.getBaseFragmentActivity() != null) {
                    m.this.eHR.getBaseFragmentActivity().hideProgressBar();
                    m.this.eIk.Ht().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.eIc.a(m.this.eId);
                        m.this.eIc.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && tVar == null && !AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.eHR.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aPk() {
        this.eHY = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eHR.getPageContext());
        this.eHZ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eHR.getPageContext());
        this.eHY.as(this.eHR.getString(d.j.at_me), d.f.icon_im_at);
        oP(this.eIe);
        this.eHZ.as(this.eHR.getString(d.j.agree_me), d.f.icon_im_laud);
        oQ(this.eIf);
        this.eHZ.oR(8);
        this.bym.addHeaderView(this.eHY.getView());
        this.bym.addHeaderView(this.eHZ.getView());
        this.bym.setOnHeaderClickListener(this.eIh);
    }

    public void onChangeSkinType(int i) {
        if (this.eIk != null && this.eIk.Ht() != null) {
            this.eIk.Ht().onChangeSkinType(i);
        }
        if (this.eHW != null) {
            this.eHW.setTextColor(am.getColor(d.C0140d.cp_cont_d));
            this.eHW.dC(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dC(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.j(this.mNoDataView, d.C0140d.cp_bg_line_d);
        }
        if (this.eHY != null) {
            this.eHY.aPt();
        }
        if (this.eHZ != null) {
            this.eHZ.aPt();
        }
        notifyDataSetChanged();
        am.j(this.bym, this.eIg);
        am.j(this.byn, d.C0140d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.eIk == null || this.eIk.Ht() == null || this.eIk.Ht().getVisibility() != 0) {
            return false;
        }
        this.eIk.Ip();
        return true;
    }

    public void ih(boolean z) {
        if (this.byn != null) {
            if (z && this.bym != null && this.bym.getFirstVisiblePosition() != 0) {
                this.bym.setSelection(0);
            }
            this.byn.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.eIe = newsNotifyMessage.getMsgAtme();
            this.eIf = newsNotifyMessage.getMsgAgree();
            oP(this.eIe);
            oQ(this.eIf);
        }
    }

    public void aPl() {
        oP(this.eIe);
        oQ(this.eIf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oP(int i) {
        if (this.eHY != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.DS().DX()) {
                z = true;
            }
            this.eHY.x(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ(int i) {
        if (this.eHZ != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ei()) {
                z = true;
            }
            this.eHZ.x(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eIk != null) {
            if (i == 12005) {
                this.eIk.Is();
            }
            this.eIk.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eIk.Ht().FP();
        this.eIk.Ip();
        this.eIk.Ht().HD();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eIk.b(writeData);
                this.eIk.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eO = this.eIk.Ht().eO(6);
                if (eO != null && eO.aMf != null) {
                    eO.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eIk.Il();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eIk != null) {
            this.eIk.onDestory();
        }
        if (this.eIc != null) {
            this.eIc.onDestroy();
        }
        if (this.eIj != null) {
            this.eIj.a((ReplyMeModel.a) null);
            this.eIj.onDestroy();
        }
        if (this.eIc != null) {
            this.eIc.a((ak.a) null);
        }
    }

    public void d(n nVar) {
        if (this.eHX != null) {
            this.eHX.d(nVar);
        }
    }
}
