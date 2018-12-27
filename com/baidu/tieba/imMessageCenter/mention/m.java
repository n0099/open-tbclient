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
    private BdTypeRecyclerView bRn;
    private BdSwipeRefreshLayout bRo;
    private final j.b bRt;
    private final ReplyMessageFragment fhJ;
    private PbListView fhO;
    private com.baidu.tieba.imMessageCenter.mention.base.e fhP;
    private com.baidu.tieba.imMessageCenter.mention.base.f fhQ;
    private com.baidu.tieba.imMessageCenter.mention.base.f fhR;
    private boolean fhS;
    private boolean fhT;
    private aj fhU;
    private AttentionHostData fhV;
    private int fhW;
    private int fhX;
    private int fhY;
    private BdListView.b fhZ;
    private View.OnClickListener fia;
    private ReplyMeModel fib;
    private com.baidu.tbadk.editortools.pb.g fic;
    private com.baidu.tieba.imMessageCenter.mention.base.a fie;
    private String fif;
    private long fig;
    private long fih;
    private DataModel<MessageCenterActivity> fii;
    private final ReplyMeModel.a fij;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.k.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.fhW = 0;
        this.fhX = 0;
        this.fhY = e.d.cp_bg_line_e;
        this.fhZ = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.fhQ.getView()) {
                    if (view == m.this.fhR.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.HQ().Ig();
                        com.baidu.tbadk.coreExtra.messageCenter.a.HQ().eW(0);
                        m.this.fhX = 0;
                        m.this.qS(m.this.fhX);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.HQ().If();
                com.baidu.tbadk.coreExtra.messageCenter.a.HQ().setMsgAtme(0);
                m.this.fhW = 0;
                m.this.qR(m.this.fhW);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        };
        this.fia = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.fhO != null && m.this.fhJ != null) {
                    m.this.fhO.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.fhO.setOnClickListener(null);
                    m.this.fhO.Fc();
                    m.this.fhJ.aDX();
                }
            }
        };
        this.bRt = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.j.b
            public void bH(boolean z) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (m.this.fhJ != null) {
                        m.this.fhJ.aDY();
                    }
                } else if (m.this.bRo != null) {
                    m.this.bRo.setRefreshing(false);
                }
            }
        };
        this.fib = null;
        this.fij = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.fif = str;
                m.this.fig = j2;
                m.this.fih = j3;
                if (m.this.fic != null && m.this.fie != null) {
                    if (!m.this.fie.aWQ() || m.this.fie.getReplyer() == null) {
                        m.this.fic.hV(null);
                    } else {
                        m.this.fic.hV(m.this.fie.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.fic != null) {
                    m.this.fic.MU();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.fhJ = replyMessageFragment;
        this.fhU = new aj(replyMessageFragment.getPageContext());
        this.fhU.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z && m.this.fic != null) {
                    m.this.fic.MQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.I(this.bRn.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.jm(true);
                        m.this.fhJ.aDY();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.NM();
                this.mRefreshView.gd(getPageContext().getResources().getDimensionPixelSize(e.C0210e.ds_102));
                this.mRefreshView.NK().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.io(getPageContext().getResources().getString(e.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.io(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.fhT) {
                this.bRn.addHeaderView(this.mRefreshView.NK(), 0);
            }
            this.fhT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.bRn != null) {
            jm(false);
            if (z) {
                this.fhO.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fhO.Fd();
                this.fhO.setOnClickListener(this.fia);
            } else {
                this.fhO.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fhO.Fd();
                this.fhO.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.fhO.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.fhS) {
                    this.fhS = true;
                    this.bRn.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bRn.setNextPage(null);
                this.fhY = e.d.cp_bg_line_d;
            } else {
                this.bRn.removeHeaderView(this.mNoDataView);
                this.fhS = false;
                if (this.mRefreshView != null) {
                    this.bRn.removeHeaderView(this.mRefreshView.NK());
                    this.fhT = false;
                }
                if (this.fhP != null) {
                    this.fhP.setData(arrayList);
                    this.fhP.notifyDataSetChanged();
                }
                this.bRn.setNextPage(this.fhO);
                this.fhY = e.d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.fhP != null) {
            this.fhP.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.fhJ.getPageContext());
            this.mPullView.a(this.bRt);
        }
        this.mPullView.setTag(this.fhJ.getUniqueId());
        if (this.fhO == null) {
            this.fhO = new PbListView(this.fhJ.getContext());
            this.fhO.getView();
        }
        this.fhO.ex(e.d.cp_bg_line_e);
        this.fhO.setHeight(com.baidu.adp.lib.util.l.h(this.fhJ.getContext(), e.C0210e.tbds182));
        this.fhO.EZ();
        this.fhO.setTextSize(e.C0210e.tbfontsize33);
        this.fhO.setTextColor(al.getColor(e.d.cp_cont_d));
        this.fhO.ew(e.d.cp_cont_e);
        this.fhO.setOnClickListener(this.fia);
        this.bRo = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.reply_me_pull_refresh_layout);
        this.bRo.setProgressView(this.mPullView);
        this.bRn = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.replyme_lv);
        this.fhP = new com.baidu.tieba.imMessageCenter.mention.base.e(this.fhJ.getPageContext(), this.bRn);
        this.fhP.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long d;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.jn(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == e.g.message_bottom_reply_container) {
                        m.this.fie = aVar;
                        if (aVar.aWQ()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.aWR(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.fhV == null) {
                            m.this.fhV = new AttentionHostData();
                        }
                        if (m.this.fie != null) {
                            m.this.fhV.parserWithMetaData(m.this.fie.getThreadAuthor());
                        }
                        m.this.fib.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aWS() != null) {
                            am x = new am(aVar.aWS()).x("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.fiK) {
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
        ((DefaultItemAnimator) this.bRn.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRn.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bRn.setFadingEdgeLength(0);
        this.bRn.setOverScrollMode(2);
        this.bRn.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bRn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bRn.setNextPage(this.fhO);
        this.bRn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.fhO != null) {
                    m.this.fhO.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.fhO.setOnClickListener(null);
                    m.this.fhO.showLoading();
                    m.this.fhJ.aDX();
                }
            }
        });
        this.bRn.setOnScrollListener(this.mScrollListener);
        aWM();
        this.fib = new ReplyMeModel(this.fhJ.getPageContext());
        this.fib.a(this.fij);
        this.fii = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.fhJ.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Ms() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData hL(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.fif);
                writeData.setThreadId(m.this.fie.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.fie.aWQ()) {
                    writeData.setFloor(m.this.fig > 0 ? String.valueOf(m.this.fig) : m.this.fie.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.fie.getPost_id());
                }
                if (m.this.fih > 0) {
                    writeData.setRepostId(String.valueOf(m.this.fih));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Mt() {
                return null;
            }
        };
        this.fic = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.fhJ.getPageContext().getContext());
        this.fic.setContext(this.fhJ.getPageContext());
        this.fic.b(this.fii);
        this.fic.d(this.fhJ.getPageContext());
        this.fic.LY().cq(true);
        this.fic.LY().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fic.LY() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.fic.LY(), layoutParams);
            this.fic.LY().hide();
        }
        this.fic.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Mw() {
                if (m.this.fhJ.getBaseFragmentActivity() != null) {
                    m.this.fhJ.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.fic.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, w wVar, WriteData writeData, AntiData antiData) {
                if (m.this.fhJ.getBaseFragmentActivity() != null) {
                    m.this.fhJ.getBaseFragmentActivity().hideProgressBar();
                    m.this.fic.LY().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.fhU.a(m.this.fhV);
                        m.this.fhU.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && wVar == null && !AntiHelper.aj(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.fhJ.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aWM() {
        this.fhQ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.fhJ.getPageContext());
        this.fhR = new com.baidu.tieba.imMessageCenter.mention.base.f(this.fhJ.getPageContext());
        this.fhQ.aD(this.fhJ.getString(e.j.at_me), e.f.icon_im_at);
        qR(this.fhW);
        this.fhR.aD(this.fhJ.getString(e.j.agree_me), e.f.icon_im_laud);
        qS(this.fhX);
        this.fhR.qT(8);
        this.bRn.addHeaderView(this.fhQ.getView());
        this.bRn.addHeaderView(this.fhR.getView());
        this.bRn.setOnHeaderClickListener(this.fhZ);
    }

    public void onChangeSkinType(int i) {
        if (this.fic != null && this.fic.LY() != null) {
            this.fic.LY().onChangeSkinType(i);
        }
        if (this.fhO != null) {
            this.fhO.setTextColor(al.getColor(e.d.cp_cont_d));
            this.fhO.ey(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.fhQ != null) {
            this.fhQ.aWT();
        }
        if (this.fhR != null) {
            this.fhR.aWT();
        }
        notifyDataSetChanged();
        al.j(this.bRn, this.fhY);
        al.j(this.bRo, e.d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.fic == null || this.fic.LY() == null || this.fic.LY().getVisibility() != 0) {
            return false;
        }
        this.fic.MU();
        return true;
    }

    public void jm(boolean z) {
        if (this.bRo != null) {
            if (z && this.bRn != null && this.bRn.getFirstVisiblePosition() != 0) {
                this.bRn.setSelection(0);
            }
            this.bRo.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.fhW = newsNotifyMessage.getMsgAtme();
            this.fhX = newsNotifyMessage.getMsgAgree();
            qR(this.fhW);
            qS(this.fhX);
        }
    }

    public void aWN() {
        qR(this.fhW);
        qS(this.fhX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qR(int i) {
        if (this.fhQ != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IC()) {
                z = true;
            }
            this.fhQ.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qS(int i) {
        if (this.fhR != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ix().IO()) {
                z = true;
            }
            this.fhR.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.fic != null) {
            if (i == 12005) {
                this.fic.MX();
            }
            this.fic.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.fic.LY().Kx();
        this.fic.MU();
        this.fic.LY().Mi();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.fic.b(writeData);
                this.fic.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k fL = this.fic.LY().fL(6);
                if (fL != null && fL.aYl != null) {
                    fL.aYl.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.fic.MQ();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.fic != null) {
            this.fic.onDestory();
        }
        if (this.fhU != null) {
            this.fhU.onDestroy();
        }
        if (this.fib != null) {
            this.fib.a((ReplyMeModel.a) null);
            this.fib.onDestroy();
        }
        if (this.fhU != null) {
            this.fhU.a((aj.a) null);
        }
    }

    public void d(n nVar) {
        if (this.fhP != null) {
            this.fhP.d(nVar);
        }
    }
}
