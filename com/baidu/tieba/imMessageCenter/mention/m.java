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
    private BdTypeRecyclerView bRk;
    private BdSwipeRefreshLayout bRl;
    private final j.b bRq;
    private final ReplyMessageFragment feS;
    private PbListView feX;
    private com.baidu.tieba.imMessageCenter.mention.base.e feY;
    private com.baidu.tieba.imMessageCenter.mention.base.f feZ;
    private com.baidu.tieba.imMessageCenter.mention.base.f ffa;
    private boolean ffb;
    private boolean ffc;
    private aj ffd;
    private AttentionHostData ffe;
    private int fff;
    private int ffg;
    private int ffh;
    private BdListView.b ffi;
    private View.OnClickListener ffj;
    private ReplyMeModel ffk;
    private com.baidu.tbadk.editortools.pb.g ffl;
    private com.baidu.tieba.imMessageCenter.mention.base.a ffm;
    private String ffn;
    private long ffo;
    private long ffp;
    private DataModel<MessageCenterActivity> ffq;
    private final ReplyMeModel.a ffr;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.k.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.fff = 0;
        this.ffg = 0;
        this.ffh = e.d.cp_bg_line_e;
        this.ffi = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.feZ.getView()) {
                    if (view == m.this.ffa.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().If();
                        com.baidu.tbadk.coreExtra.messageCenter.a.HP().eV(0);
                        m.this.ffg = 0;
                        m.this.qF(m.this.ffg);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.HP().Ie();
                com.baidu.tbadk.coreExtra.messageCenter.a.HP().setMsgAtme(0);
                m.this.fff = 0;
                m.this.qE(m.this.fff);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        };
        this.ffj = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.feX != null && m.this.feS != null) {
                    m.this.feX.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.feX.setOnClickListener(null);
                    m.this.feX.Fc();
                    m.this.feS.aDi();
                }
            }
        };
        this.bRq = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (m.this.feS != null) {
                        m.this.feS.aDj();
                    }
                } else if (m.this.bRl != null) {
                    m.this.bRl.setRefreshing(false);
                }
            }
        };
        this.ffk = null;
        this.ffr = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.ffn = str;
                m.this.ffo = j2;
                m.this.ffp = j3;
                if (m.this.ffl != null && m.this.ffm != null) {
                    if (!m.this.ffm.aWd() || m.this.ffm.getReplyer() == null) {
                        m.this.ffl.hU(null);
                    } else {
                        m.this.ffl.hU(m.this.ffm.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.ffl != null) {
                    m.this.ffl.MT();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.feS = replyMessageFragment;
        this.ffd = new aj(replyMessageFragment.getPageContext());
        this.ffd.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z && m.this.ffl != null) {
                    m.this.ffl.MP();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.I(this.bRk.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.jj(true);
                        m.this.feS.aDj();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.NL();
                this.mRefreshView.gc(getPageContext().getResources().getDimensionPixelSize(e.C0210e.ds_102));
                this.mRefreshView.NJ().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.in(getPageContext().getResources().getString(e.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.in(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.ffc) {
                this.bRk.addHeaderView(this.mRefreshView.NJ(), 0);
            }
            this.ffc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.bRk != null) {
            jj(false);
            if (z) {
                this.feX.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.feX.Fd();
                this.feX.setOnClickListener(this.ffj);
            } else {
                this.feX.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.feX.Fd();
                this.feX.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.feX.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.ffb) {
                    this.ffb = true;
                    this.bRk.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bRk.setNextPage(null);
                this.ffh = e.d.cp_bg_line_d;
            } else {
                this.bRk.removeHeaderView(this.mNoDataView);
                this.ffb = false;
                if (this.mRefreshView != null) {
                    this.bRk.removeHeaderView(this.mRefreshView.NJ());
                    this.ffc = false;
                }
                if (this.feY != null) {
                    this.feY.setData(arrayList);
                    this.feY.notifyDataSetChanged();
                }
                this.bRk.setNextPage(this.feX);
                this.ffh = e.d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.feY != null) {
            this.feY.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.feS.getPageContext());
            this.mPullView.a(this.bRq);
        }
        this.mPullView.setTag(this.feS.getUniqueId());
        if (this.feX == null) {
            this.feX = new PbListView(this.feS.getContext());
            this.feX.getView();
        }
        this.feX.ex(e.d.cp_bg_line_e);
        this.feX.setHeight(com.baidu.adp.lib.util.l.h(this.feS.getContext(), e.C0210e.tbds182));
        this.feX.EZ();
        this.feX.setTextSize(e.C0210e.tbfontsize33);
        this.feX.setTextColor(al.getColor(e.d.cp_cont_d));
        this.feX.ew(e.d.cp_cont_e);
        this.feX.setOnClickListener(this.ffj);
        this.bRl = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.reply_me_pull_refresh_layout);
        this.bRl.setProgressView(this.mPullView);
        this.bRk = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.replyme_lv);
        this.feY = new com.baidu.tieba.imMessageCenter.mention.base.e(this.feS.getPageContext(), this.bRk);
        this.feY.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long d;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.jk(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == e.g.message_bottom_reply_container) {
                        m.this.ffm = aVar;
                        if (aVar.aWd()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.aWe(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.ffe == null) {
                            m.this.ffe = new AttentionHostData();
                        }
                        if (m.this.ffm != null) {
                            m.this.ffe.parserWithMetaData(m.this.ffm.getThreadAuthor());
                        }
                        m.this.ffk.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aWf() != null) {
                            am x = new am(aVar.aWf()).x("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.ffR) {
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
        ((DefaultItemAnimator) this.bRk.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRk.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bRk.setFadingEdgeLength(0);
        this.bRk.setOverScrollMode(2);
        this.bRk.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bRk.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bRk.setNextPage(this.feX);
        this.bRk.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.feX != null) {
                    m.this.feX.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.feX.setOnClickListener(null);
                    m.this.feX.showLoading();
                    m.this.feS.aDi();
                }
            }
        });
        this.bRk.setOnScrollListener(this.mScrollListener);
        aVZ();
        this.ffk = new ReplyMeModel(this.feS.getPageContext());
        this.ffk.a(this.ffr);
        this.ffq = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.feS.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Mr() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData hK(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.ffn);
                writeData.setThreadId(m.this.ffm.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.ffm.aWd()) {
                    writeData.setFloor(m.this.ffo > 0 ? String.valueOf(m.this.ffo) : m.this.ffm.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.ffm.getPost_id());
                }
                if (m.this.ffp > 0) {
                    writeData.setRepostId(String.valueOf(m.this.ffp));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Ms() {
                return null;
            }
        };
        this.ffl = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.feS.getPageContext().getContext());
        this.ffl.setContext(this.feS.getPageContext());
        this.ffl.b(this.ffq);
        this.ffl.d(this.feS.getPageContext());
        this.ffl.LX().cq(true);
        this.ffl.LX().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ffl.LX() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.ffl.LX(), layoutParams);
            this.ffl.LX().hide();
        }
        this.ffl.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Mv() {
                if (m.this.feS.getBaseFragmentActivity() != null) {
                    m.this.feS.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.ffl.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                if (m.this.feS.getBaseFragmentActivity() != null) {
                    m.this.feS.getBaseFragmentActivity().hideProgressBar();
                    m.this.ffl.LX().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.ffd.a(m.this.ffe);
                        m.this.ffd.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && wVar == null && !AntiHelper.ai(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.feS.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aVZ() {
        this.feZ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.feS.getPageContext());
        this.ffa = new com.baidu.tieba.imMessageCenter.mention.base.f(this.feS.getPageContext());
        this.feZ.aC(this.feS.getString(e.j.at_me), e.f.icon_im_at);
        qE(this.fff);
        this.ffa.aC(this.feS.getString(e.j.agree_me), e.f.icon_im_laud);
        qF(this.ffg);
        this.ffa.qG(8);
        this.bRk.addHeaderView(this.feZ.getView());
        this.bRk.addHeaderView(this.ffa.getView());
        this.bRk.setOnHeaderClickListener(this.ffi);
    }

    public void onChangeSkinType(int i) {
        if (this.ffl != null && this.ffl.LX() != null) {
            this.ffl.LX().onChangeSkinType(i);
        }
        if (this.feX != null) {
            this.feX.setTextColor(al.getColor(e.d.cp_cont_d));
            this.feX.ey(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.feZ != null) {
            this.feZ.aWg();
        }
        if (this.ffa != null) {
            this.ffa.aWg();
        }
        notifyDataSetChanged();
        al.j(this.bRk, this.ffh);
        al.j(this.bRl, e.d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.ffl == null || this.ffl.LX() == null || this.ffl.LX().getVisibility() != 0) {
            return false;
        }
        this.ffl.MT();
        return true;
    }

    public void jj(boolean z) {
        if (this.bRl != null) {
            if (z && this.bRk != null && this.bRk.getFirstVisiblePosition() != 0) {
                this.bRk.setSelection(0);
            }
            this.bRl.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.fff = newsNotifyMessage.getMsgAtme();
            this.ffg = newsNotifyMessage.getMsgAgree();
            qE(this.fff);
            qF(this.ffg);
        }
    }

    public void aWa() {
        qE(this.fff);
        qF(this.ffg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qE(int i) {
        if (this.feZ != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IB()) {
                z = true;
            }
            this.feZ.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qF(int i) {
        if (this.ffa != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Iw().IN()) {
                z = true;
            }
            this.ffa.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.ffl != null) {
            if (i == 12005) {
                this.ffl.MW();
            }
            this.ffl.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.ffl.LX().Kw();
        this.ffl.MT();
        this.ffl.LX().Mh();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ffl.b(writeData);
                this.ffl.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k fK = this.ffl.LX().fK(6);
                if (fK != null && fK.aYi != null) {
                    fK.aYi.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ffl.MP();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.ffl != null) {
            this.ffl.onDestory();
        }
        if (this.ffd != null) {
            this.ffd.onDestroy();
        }
        if (this.ffk != null) {
            this.ffk.a((ReplyMeModel.a) null);
            this.ffk.onDestroy();
        }
        if (this.ffd != null) {
            this.ffd.a((aj.a) null);
        }
    }

    public void d(n nVar) {
        if (this.feY != null) {
            this.feY.d(nVar);
        }
    }
}
