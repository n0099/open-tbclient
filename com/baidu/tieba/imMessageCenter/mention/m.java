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
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.w;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView bNt;
    private BdSwipeRefreshLayout bNu;
    private final j.b bNz;
    private long eYA;
    private DataModel<MessageCenterActivity> eYB;
    private final ReplyMeModel.a eYC;
    private final ReplyMessageFragment eYd;
    private PbListView eYi;
    private com.baidu.tieba.imMessageCenter.mention.base.e eYj;
    private com.baidu.tieba.imMessageCenter.mention.base.f eYk;
    private com.baidu.tieba.imMessageCenter.mention.base.f eYl;
    private boolean eYm;
    private boolean eYn;
    private aj eYo;
    private AttentionHostData eYp;
    private int eYq;
    private int eYr;
    private int eYs;
    private BdListView.b eYt;
    private View.OnClickListener eYu;
    private ReplyMeModel eYv;
    private com.baidu.tbadk.editortools.pb.g eYw;
    private com.baidu.tieba.imMessageCenter.mention.base.a eYx;
    private String eYy;
    private long eYz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.k.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eYq = 0;
        this.eYr = 0;
        this.eYs = e.d.cp_bg_line_e;
        this.eYt = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.eYk.getView()) {
                    if (view == m.this.eYl.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.GL().Hb();
                        com.baidu.tbadk.coreExtra.messageCenter.a.GL().eH(0);
                        m.this.eYr = 0;
                        m.this.ql(m.this.eYr);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.GL().Ha();
                com.baidu.tbadk.coreExtra.messageCenter.a.GL().setMsgAtme(0);
                m.this.eYq = 0;
                m.this.qk(m.this.eYq);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        };
        this.eYu = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eYi != null && m.this.eYd != null) {
                    m.this.eYi.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eYi.setOnClickListener(null);
                    m.this.eYi.DY();
                    m.this.eYd.aBy();
                }
            }
        };
        this.bNz = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.j.b
            public void bG(boolean z) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (m.this.eYd != null) {
                        m.this.eYd.aBz();
                    }
                } else if (m.this.bNu != null) {
                    m.this.bNu.setRefreshing(false);
                }
            }
        };
        this.eYv = null;
        this.eYC = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.eYy = str;
                m.this.eYz = j2;
                m.this.eYA = j3;
                if (m.this.eYw != null && m.this.eYx != null) {
                    if (!m.this.eYx.aUl() || m.this.eYx.getReplyer() == null) {
                        m.this.eYw.hD(null);
                    } else {
                        m.this.eYw.hD(m.this.eYx.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.eYw != null) {
                    m.this.eYw.LP();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eYd = replyMessageFragment;
        this.eYo = new aj(replyMessageFragment.getPageContext());
        this.eYo.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z && m.this.eYw != null) {
                    m.this.eYw.LL();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.I(this.bNt.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.jg(true);
                        m.this.eYd.aBz();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.MH();
                this.mRefreshView.fO(getPageContext().getResources().getDimensionPixelSize(e.C0200e.ds_102));
                this.mRefreshView.MF().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.hV(getPageContext().getResources().getString(e.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.hV(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.eYn) {
                this.bNt.addHeaderView(this.mRefreshView.MF(), 0);
            }
            this.eYn = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.bNt != null) {
            jg(false);
            if (z) {
                this.eYi.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.eYi.DZ();
                this.eYi.setOnClickListener(this.eYu);
            } else {
                this.eYi.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.eYi.DZ();
                this.eYi.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.eYi.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0200e.ds80)), NoDataViewFactory.d.ec(e.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eYm) {
                    this.eYm = true;
                    this.bNt.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bNt.setNextPage(null);
                this.eYs = e.d.cp_bg_line_d;
            } else {
                this.bNt.removeHeaderView(this.mNoDataView);
                this.eYm = false;
                if (this.mRefreshView != null) {
                    this.bNt.removeHeaderView(this.mRefreshView.MF());
                    this.eYn = false;
                }
                if (this.eYj != null) {
                    this.eYj.setData(arrayList);
                    this.eYj.notifyDataSetChanged();
                }
                this.bNt.setNextPage(this.eYi);
                this.eYs = e.d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eYj != null) {
            this.eYj.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.eYd.getPageContext());
            this.mPullView.a(this.bNz);
        }
        this.mPullView.setTag(this.eYd.getUniqueId());
        if (this.eYi == null) {
            this.eYi = new PbListView(this.eYd.getContext());
            this.eYi.getView();
        }
        this.eYi.ej(e.d.cp_bg_line_e);
        this.eYi.setHeight(com.baidu.adp.lib.util.l.h(this.eYd.getContext(), e.C0200e.tbds182));
        this.eYi.DV();
        this.eYi.setTextSize(e.C0200e.tbfontsize33);
        this.eYi.setTextColor(al.getColor(e.d.cp_cont_d));
        this.eYi.ei(e.d.cp_cont_e);
        this.eYi.setOnClickListener(this.eYu);
        this.bNu = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.reply_me_pull_refresh_layout);
        this.bNu.setProgressView(this.mPullView);
        this.bNt = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.replyme_lv);
        this.eYj = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eYd.getPageContext(), this.bNt);
        this.eYj.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long d;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.jh(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == e.g.message_bottom_reply_container) {
                        m.this.eYx = aVar;
                        if (aVar.aUl()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.aUm(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.eYp == null) {
                            m.this.eYp = new AttentionHostData();
                        }
                        if (m.this.eYx != null) {
                            m.this.eYp.parserWithMetaData(m.this.eYx.getThreadAuthor());
                        }
                        m.this.eYv.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aUn() != null) {
                            am x = new am(aVar.aUn()).x("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eZc) {
                                x.x("obj_type", 1);
                            } else {
                                x.x("obj_type", 2);
                            }
                            TiebaStatic.log(x);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.bNt.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bNt.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bNt.setFadingEdgeLength(0);
        this.bNt.setOverScrollMode(2);
        this.bNt.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bNt.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bNt.setNextPage(this.eYi);
        this.bNt.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.eYi != null) {
                    m.this.eYi.el(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eYi.setOnClickListener(null);
                    m.this.eYi.showLoading();
                    m.this.eYd.aBy();
                }
            }
        });
        this.bNt.setOnScrollListener(this.mScrollListener);
        aUh();
        this.eYv = new ReplyMeModel(this.eYd.getPageContext());
        this.eYv.a(this.eYC);
        this.eYB = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.eYd.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Ln() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData hs(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.eYy);
                writeData.setThreadId(m.this.eYx.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.eYx.aUl()) {
                    writeData.setFloor(m.this.eYz > 0 ? String.valueOf(m.this.eYz) : m.this.eYx.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.eYx.getPost_id());
                }
                if (m.this.eYA > 0) {
                    writeData.setRepostId(String.valueOf(m.this.eYA));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Lo() {
                return null;
            }
        };
        this.eYw = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bJ(this.eYd.getPageContext().getContext());
        this.eYw.setContext(this.eYd.getPageContext());
        this.eYw.b(this.eYB);
        this.eYw.d(this.eYd.getPageContext());
        this.eYw.KT().cp(true);
        this.eYw.KT().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eYw.KT() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eYw.KT(), layoutParams);
            this.eYw.KT().hide();
        }
        this.eYw.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Lr() {
                if (m.this.eYd.getBaseFragmentActivity() != null) {
                    m.this.eYd.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.eYw.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                if (m.this.eYd.getBaseFragmentActivity() != null) {
                    m.this.eYd.getBaseFragmentActivity().hideProgressBar();
                    m.this.eYw.KT().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.eYo.a(m.this.eYp);
                        m.this.eYo.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && wVar == null && !AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.eYd.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aUh() {
        this.eYk = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eYd.getPageContext());
        this.eYl = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eYd.getPageContext());
        this.eYk.aB(this.eYd.getString(e.j.at_me), e.f.icon_im_at);
        qk(this.eYq);
        this.eYl.aB(this.eYd.getString(e.j.agree_me), e.f.icon_im_laud);
        ql(this.eYr);
        this.eYl.qm(8);
        this.bNt.addHeaderView(this.eYk.getView());
        this.bNt.addHeaderView(this.eYl.getView());
        this.bNt.setOnHeaderClickListener(this.eYt);
    }

    public void onChangeSkinType(int i) {
        if (this.eYw != null && this.eYw.KT() != null) {
            this.eYw.KT().onChangeSkinType(i);
        }
        if (this.eYi != null) {
            this.eYi.setTextColor(al.getColor(e.d.cp_cont_d));
            this.eYi.ek(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ek(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.eYk != null) {
            this.eYk.aUo();
        }
        if (this.eYl != null) {
            this.eYl.aUo();
        }
        notifyDataSetChanged();
        al.j(this.bNt, this.eYs);
        al.j(this.bNu, e.d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.eYw == null || this.eYw.KT() == null || this.eYw.KT().getVisibility() != 0) {
            return false;
        }
        this.eYw.LP();
        return true;
    }

    public void jg(boolean z) {
        if (this.bNu != null) {
            if (z && this.bNt != null && this.bNt.getFirstVisiblePosition() != 0) {
                this.bNt.setSelection(0);
            }
            this.bNu.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.eYq = newsNotifyMessage.getMsgAtme();
            this.eYr = newsNotifyMessage.getMsgAgree();
            qk(this.eYq);
            ql(this.eYr);
        }
    }

    public void aUi() {
        qk(this.eYq);
        ql(this.eYr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qk(int i) {
        if (this.eYk != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hs().Hx()) {
                z = true;
            }
            this.eYk.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ql(int i) {
        if (this.eYl != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hs().HJ()) {
                z = true;
            }
            this.eYl.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eYw != null) {
            if (i == 12005) {
                this.eYw.LS();
            }
            this.eYw.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eYw.KT().Js();
        this.eYw.LP();
        this.eYw.KT().Ld();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eYw.b(writeData);
                this.eYw.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k fw = this.eYw.KT().fw(6);
                if (fw != null && fw.aUL != null) {
                    fw.aUL.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eYw.LL();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eYw != null) {
            this.eYw.onDestory();
        }
        if (this.eYo != null) {
            this.eYo.onDestroy();
        }
        if (this.eYv != null) {
            this.eYv.a((ReplyMeModel.a) null);
            this.eYv.onDestroy();
        }
        if (this.eYo != null) {
            this.eYo.a((aj.a) null);
        }
    }

    public void d(n nVar) {
        if (this.eYj != null) {
            this.eYj.d(nVar);
        }
    }
}
