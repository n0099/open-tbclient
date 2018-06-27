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
    private BdTypeRecyclerView bxH;
    private BdSwipeRefreshLayout bxI;
    private final g.b bxO;
    private final ReplyMessageFragment eDX;
    private PbListView eEc;
    private com.baidu.tieba.imMessageCenter.mention.base.e eEd;
    private com.baidu.tieba.imMessageCenter.mention.base.f eEe;
    private com.baidu.tieba.imMessageCenter.mention.base.f eEf;
    private boolean eEg;
    private boolean eEh;
    private ak eEi;
    private AttentionHostData eEj;
    private int eEk;
    private int eEl;
    private int eEm;
    private BdListView.b eEn;
    private View.OnClickListener eEo;
    private ReplyMeModel eEp;
    private com.baidu.tbadk.editortools.pb.g eEq;
    private com.baidu.tieba.imMessageCenter.mention.base.a eEr;
    private String eEs;
    private long eEt;
    private long eEu;
    private DataModel<MessageCenterActivity> eEv;
    private final ReplyMeModel.a eEw;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private com.baidu.tbadk.j.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eEk = 0;
        this.eEl = 0;
        this.eEm = d.C0142d.cp_bg_line_e;
        this.eEn = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.eEe.getView()) {
                    if (view == m.this.eEf.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DF();
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dp().dW(0);
                        m.this.eEl = 0;
                        m.this.oB(m.this.eEl);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().DE();
                com.baidu.tbadk.coreExtra.messageCenter.a.Dp().setMsgAtme(0);
                m.this.eEk = 0;
                m.this.oA(m.this.eEk);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.eEo = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eEc != null && m.this.eDX != null) {
                    m.this.eEc.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eEc.setOnClickListener(null);
                    m.this.eEc.AH();
                    m.this.eDX.aOn();
                }
            }
        };
        this.bxO = new g.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.g.b
            public void aU(boolean z) {
                if (com.baidu.adp.lib.util.j.jD()) {
                    if (m.this.eDX != null) {
                        m.this.eDX.aOm();
                    }
                } else if (m.this.bxI != null) {
                    m.this.bxI.setRefreshing(false);
                }
            }
        };
        this.eEp = null;
        this.eEw = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.eEs = str;
                m.this.eEt = j2;
                m.this.eEu = j3;
                if (m.this.eEq != null && m.this.eEr != null) {
                    if (!m.this.eEr.aOq() || m.this.eEr.getReplyer() == null) {
                        m.this.eEq.gW(null);
                    } else {
                        m.this.eEq.gW(m.this.eEr.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.eEq != null) {
                    m.this.eEq.Iu();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eDX = replyMessageFragment;
        this.eEi = new ak(replyMessageFragment.getPageContext());
        this.eEi.a(new ak.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.ak.a
            public void c(boolean z, int i) {
                if (z && m.this.eEq != null) {
                    m.this.eEq.Iq();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (w.A(this.bxH.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.ie(true);
                        m.this.eDX.aOm();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.Jp();
                this.mRefreshView.ff(getPageContext().getResources().getDimensionPixelSize(d.e.ds_102));
                this.mRefreshView.Jn().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.setSubText(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.eEh) {
                this.bxH.addHeaderView(this.mRefreshView.Jn(), 0);
            }
            this.eEh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        ie(false);
        if (z) {
            this.eEc.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.eEc.AI();
            this.eEc.setOnClickListener(this.eEo);
        } else {
            this.eEc.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.eEc.AI();
            this.eEc.setText(this.mContext.getResources().getString(d.k.list_no_more));
            this.eEc.setOnClickListener(null);
        }
        if (w.A(arrayList)) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.ds(d.k.mention_replyme_nodata), null);
                this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                am.j(this.mNoDataView, d.C0142d.cp_bg_line_d);
            }
            if (this.mNoDataView.getParent() == null && !this.eEg && this.bxH != null) {
                this.eEg = true;
                this.bxH.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.bxH.setNextPage(null);
            this.eEm = d.C0142d.cp_bg_line_d;
        } else {
            if (this.bxH != null) {
                this.bxH.removeHeaderView(this.mNoDataView);
                this.eEg = false;
                if (this.mRefreshView != null) {
                    this.bxH.removeHeaderView(this.mRefreshView.Jn());
                    this.eEh = false;
                }
            }
            if (this.eEd != null) {
                this.eEd.setData(arrayList);
                this.eEd.notifyDataSetChanged();
            }
            this.bxH.setNextPage(this.eEc);
            this.eEm = d.C0142d.cp_bg_line_e;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eEd != null) {
            this.eEd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.eDX.getPageContext());
            this.mPullView.a(this.bxO);
        }
        this.mPullView.setTag(this.eDX.getUniqueId());
        if (this.eEc == null) {
            this.eEc = new PbListView(this.eDX.getContext());
            this.eEc.getView();
        }
        this.eEc.dy(d.C0142d.cp_bg_line_e);
        this.eEc.setHeight(com.baidu.adp.lib.util.l.e(this.eDX.getContext(), d.e.tbds182));
        this.eEc.AE();
        this.eEc.setTextSize(d.e.tbfontsize33);
        this.eEc.setTextColor(am.getColor(d.C0142d.cp_cont_d));
        this.eEc.dx(d.C0142d.cp_cont_e);
        this.eEc.setOnClickListener(this.eEo);
        this.bxI = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.bxI.setProgressView(this.mPullView);
        this.bxH = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eEd = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eDX.getPageContext(), this.bxH);
        this.eEd.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.m16if(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == d.g.message_bottom_reply_container) {
                        m.this.eEr = aVar;
                        if (aVar.aOq()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aOr(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.eEj == null) {
                            m.this.eEj = new AttentionHostData();
                        }
                        if (m.this.eEr != null) {
                            m.this.eEj.parserWithMetaData(m.this.eEr.getThreadAuthor());
                        }
                        m.this.eEp.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aOs() != null) {
                            an r = new an(aVar.aOs()).r("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eEW) {
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
        ((DefaultItemAnimator) this.bxH.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bxH.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bxH.setFadingEdgeLength(0);
        this.bxH.setOverScrollMode(2);
        this.bxH.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bxH.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bxH.setNextPage(this.eEc);
        this.bxH.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.eEc != null) {
                    m.this.eEc.dA(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eEc.setOnClickListener(null);
                    m.this.eEc.showLoading();
                    m.this.eDX.aOn();
                }
            }
        });
        this.bxH.setOnScrollListener(this.mScrollListener);
        aOk();
        this.eEp = new ReplyMeModel(this.eDX.getPageContext());
        this.eEp.a(this.eEw);
        this.eEv = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ad(this.eDX.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean HS() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData gL(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.eEs);
                writeData.setThreadId(m.this.eEr.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.eEr.aOq()) {
                    writeData.setFloor(m.this.eEt > 0 ? String.valueOf(m.this.eEt) : m.this.eEr.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.eEr.getPost_id());
                }
                if (m.this.eEu > 0) {
                    writeData.setRepostId(String.valueOf(m.this.eEu));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String HT() {
                return null;
            }
        };
        this.eEq = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aY(this.eDX.getPageContext().getContext());
        this.eEq.setContext(this.eDX.getPageContext());
        this.eEq.b(this.eEv);
        this.eEq.d(this.eDX.getPageContext());
        this.eEq.Hy().bE(true);
        this.eEq.Hy().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eEq.Hy() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eEq.Hy(), layoutParams);
            this.eEq.Hy().hide();
        }
        this.eEq.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void HW() {
                if (m.this.eDX.getBaseFragmentActivity() != null) {
                    m.this.eDX.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.eEq.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (m.this.eDX.getBaseFragmentActivity() != null) {
                    m.this.eDX.getBaseFragmentActivity().hideProgressBar();
                    m.this.eEq.Hy().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.eEi.a(m.this.eEj);
                        m.this.eEi.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && tVar == null && !AntiHelper.tQ(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.eDX.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aOk() {
        this.eEe = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eDX.getPageContext());
        this.eEf = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eDX.getPageContext());
        this.eEe.aw(this.eDX.getString(d.k.at_me), d.f.icon_im_at);
        oA(this.eEk);
        this.eEf.aw(this.eDX.getString(d.k.agree_me), d.f.icon_im_laud);
        oB(this.eEl);
        this.eEf.oC(8);
        this.bxH.addHeaderView(this.eEe.getView());
        this.bxH.addHeaderView(this.eEf.getView());
        this.bxH.setOnHeaderClickListener(this.eEn);
    }

    public void onChangeSkinType(int i) {
        if (this.eEq != null && this.eEq.Hy() != null) {
            this.eEq.Hy().onChangeSkinType(i);
        }
        if (this.eEc != null) {
            this.eEc.setTextColor(am.getColor(d.C0142d.cp_cont_d));
            this.eEc.dz(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dz(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.j(this.mNoDataView, d.C0142d.cp_bg_line_d);
        }
        if (this.eEe != null) {
            this.eEe.aOt();
        }
        if (this.eEf != null) {
            this.eEf.aOt();
        }
        notifyDataSetChanged();
        am.j(this.bxH, this.eEm);
        am.j(this.bxI, d.C0142d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.eEq == null || this.eEq.Hy() == null || this.eEq.Hy().getVisibility() != 0) {
            return false;
        }
        this.eEq.Iu();
        return true;
    }

    public void ie(boolean z) {
        if (this.bxI != null) {
            if (z && this.bxH != null && this.bxH.getFirstVisiblePosition() != 0) {
                this.bxH.setSelection(0);
            }
            this.bxI.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.eEk = newsNotifyMessage.getMsgAtme();
            this.eEl = newsNotifyMessage.getMsgAgree();
            oA(this.eEk);
            oB(this.eEl);
        }
    }

    public void aOl() {
        oA(this.eEk);
        oB(this.eEl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oA(int i) {
        if (this.eEe != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.DW().Eb()) {
                z = true;
            }
            this.eEe.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oB(int i) {
        if (this.eEf != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.DW().Em()) {
                z = true;
            }
            this.eEf.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eEq != null) {
            if (i == 12005) {
                this.eEq.Ix();
            }
            this.eEq.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eEq.Hy().FT();
        this.eEq.Iu();
        this.eEq.Hy().HI();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eEq.b(writeData);
                this.eEq.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eN = this.eEq.Hy().eN(6);
                if (eN != null && eN.aMf != null) {
                    eN.aMf.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eEq.Iq();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eEq != null) {
            this.eEq.onDestory();
        }
        if (this.eEi != null) {
            this.eEi.onDestroy();
        }
        if (this.eEp != null) {
            this.eEp.a((ReplyMeModel.a) null);
            this.eEp.onDestroy();
        }
        if (this.eEi != null) {
            this.eEi.a((ak.a) null);
        }
    }

    public void d(n nVar) {
        if (this.eEd != null) {
            this.eEd.d(nVar);
        }
    }
}
