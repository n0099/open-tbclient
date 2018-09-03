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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.f;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView byo;
    private BdSwipeRefreshLayout byp;
    private final g.b byv;
    private final ReplyMessageFragment eHM;
    private PbListView eHR;
    private com.baidu.tieba.imMessageCenter.mention.base.e eHS;
    private com.baidu.tieba.imMessageCenter.mention.base.f eHT;
    private com.baidu.tieba.imMessageCenter.mention.base.f eHU;
    private boolean eHV;
    private boolean eHW;
    private ak eHX;
    private AttentionHostData eHY;
    private int eHZ;
    private int eIa;
    private int eIb;
    private BdListView.b eIc;
    private View.OnClickListener eId;
    private ReplyMeModel eIe;
    private com.baidu.tbadk.editortools.pb.g eIf;
    private com.baidu.tieba.imMessageCenter.mention.base.a eIg;
    private String eIh;
    private long eIi;
    private long eIj;
    private DataModel<MessageCenterActivity> eIk;
    private final ReplyMeModel.a eIl;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private com.baidu.tbadk.k.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eHZ = 0;
        this.eIa = 0;
        this.eIb = f.d.cp_bg_line_e;
        this.eIc = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.eHT.getView()) {
                    if (view == m.this.eHU.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DB();
                        com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dY(0);
                        m.this.eIa = 0;
                        m.this.oQ(m.this.eIa);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().DA();
                com.baidu.tbadk.coreExtra.messageCenter.a.Dl().setMsgAtme(0);
                m.this.eHZ = 0;
                m.this.oP(m.this.eHZ);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.eId = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eHR != null && m.this.eHM != null) {
                    m.this.eHR.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eHR.setOnClickListener(null);
                    m.this.eHR.Av();
                    m.this.eHM.aPk();
                }
            }
        };
        this.byv = new g.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.g.b
            public void aT(boolean z) {
                if (com.baidu.adp.lib.util.j.jE()) {
                    if (m.this.eHM != null) {
                        m.this.eHM.aPj();
                    }
                } else if (m.this.byp != null) {
                    m.this.byp.setRefreshing(false);
                }
            }
        };
        this.eIe = null;
        this.eIl = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.eIh = str;
                m.this.eIi = j2;
                m.this.eIj = j3;
                if (m.this.eIf != null && m.this.eIg != null) {
                    if (!m.this.eIg.aPn() || m.this.eIg.getReplyer() == null) {
                        m.this.eIf.gS(null);
                    } else {
                        m.this.eIf.gS(m.this.eIg.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.eIf != null) {
                    m.this.eIf.Ip();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eHM = replyMessageFragment;
        this.eHX = new ak(replyMessageFragment.getPageContext());
        this.eHX.a(new ak.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.ak.a
            public void c(boolean z, int i) {
                if (z && m.this.eIf != null) {
                    m.this.eIf.Il();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (w.z(this.byo.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.ih(true);
                        m.this.eHM.aPj();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.Jk();
                this.mRefreshView.ff(getPageContext().getResources().getDimensionPixelSize(f.e.ds_102));
                this.mRefreshView.Ji().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.hk(getPageContext().getResources().getString(f.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.hk(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.eHW) {
                this.byo.addHeaderView(this.mRefreshView.Ji(), 0);
            }
            this.eHW = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.byo != null) {
            ih(false);
            if (z) {
                this.eHR.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.eHR.Aw();
                this.eHR.setOnClickListener(this.eId);
            } else {
                this.eHR.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.eHR.Aw();
                this.eHR.setText(this.mContext.getResources().getString(f.j.list_no_more));
                this.eHR.setOnClickListener(null);
            }
            if (w.z(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(f.e.ds80)), NoDataViewFactory.d.dt(f.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.j(this.mNoDataView, f.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.eHV) {
                    this.eHV = true;
                    this.byo.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.byo.setNextPage(null);
                this.eIb = f.d.cp_bg_line_d;
            } else {
                this.byo.removeHeaderView(this.mNoDataView);
                this.eHV = false;
                if (this.mRefreshView != null) {
                    this.byo.removeHeaderView(this.mRefreshView.Ji());
                    this.eHW = false;
                }
                if (this.eHS != null) {
                    this.eHS.setData(arrayList);
                    this.eHS.notifyDataSetChanged();
                }
                this.byo.setNextPage(this.eHR);
                this.eIb = f.d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eHS != null) {
            this.eHS.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.eHM.getPageContext());
            this.mPullView.a(this.byv);
        }
        this.mPullView.setTag(this.eHM.getUniqueId());
        if (this.eHR == null) {
            this.eHR = new PbListView(this.eHM.getContext());
            this.eHR.getView();
        }
        this.eHR.dA(f.d.cp_bg_line_e);
        this.eHR.setHeight(com.baidu.adp.lib.util.l.f(this.eHM.getContext(), f.e.tbds182));
        this.eHR.As();
        this.eHR.setTextSize(f.e.tbfontsize33);
        this.eHR.setTextColor(am.getColor(f.d.cp_cont_d));
        this.eHR.dz(f.d.cp_cont_e);
        this.eHR.setOnClickListener(this.eId);
        this.byp = (BdSwipeRefreshLayout) this.mRootView.findViewById(f.g.reply_me_pull_refresh_layout);
        this.byp.setProgressView(this.mPullView);
        this.byo = (BdTypeRecyclerView) this.mRootView.findViewById(f.g.replyme_lv);
        this.eHS = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eHM.getPageContext(), this.byo);
        this.eHS.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.ii(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == f.g.message_bottom_reply_container) {
                        m.this.eIg = aVar;
                        if (aVar.aPn()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aPo(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.eHY == null) {
                            m.this.eHY = new AttentionHostData();
                        }
                        if (m.this.eIg != null) {
                            m.this.eHY.parserWithMetaData(m.this.eIg.getThreadAuthor());
                        }
                        m.this.eIe.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aPp() != null) {
                            an r = new an(aVar.aPp()).r("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eIL) {
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
        ((DefaultItemAnimator) this.byo.getItemAnimator()).setSupportsChangeAnimations(false);
        this.byo.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.byo.setFadingEdgeLength(0);
        this.byo.setOverScrollMode(2);
        this.byo.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.byo.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.byo.setNextPage(this.eHR);
        this.byo.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.eHR != null) {
                    m.this.eHR.dC(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eHR.setOnClickListener(null);
                    m.this.eHR.showLoading();
                    m.this.eHM.aPk();
                }
            }
        });
        this.byo.setOnScrollListener(this.mScrollListener);
        aPh();
        this.eIe = new ReplyMeModel(this.eHM.getPageContext());
        this.eIe.a(this.eIl);
        this.eIk = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ad(this.eHM.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
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
                writeData.setForumName(m.this.eIh);
                writeData.setThreadId(m.this.eIg.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.eIg.aPn()) {
                    writeData.setFloor(m.this.eIi > 0 ? String.valueOf(m.this.eIi) : m.this.eIg.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.eIg.getPost_id());
                }
                if (m.this.eIj > 0) {
                    writeData.setRepostId(String.valueOf(m.this.eIj));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String HO() {
                return null;
            }
        };
        this.eIf = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aY(this.eHM.getPageContext().getContext());
        this.eIf.setContext(this.eHM.getPageContext());
        this.eIf.b(this.eIk);
        this.eIf.d(this.eHM.getPageContext());
        this.eIf.Ht().bD(true);
        this.eIf.Ht().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eIf.Ht() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eIf.Ht(), layoutParams);
            this.eIf.Ht().hide();
        }
        this.eIf.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void HR() {
                if (m.this.eHM.getBaseFragmentActivity() != null) {
                    m.this.eHM.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.eIf.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, u uVar, WriteData writeData, AntiData antiData) {
                if (m.this.eHM.getBaseFragmentActivity() != null) {
                    m.this.eHM.getBaseFragmentActivity().hideProgressBar();
                    m.this.eIf.Ht().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.eHX.a(m.this.eHY);
                        m.this.eHX.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && uVar == null && !AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.eHM.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aPh() {
        this.eHT = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eHM.getPageContext());
        this.eHU = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eHM.getPageContext());
        this.eHT.as(this.eHM.getString(f.j.at_me), f.C0146f.icon_im_at);
        oP(this.eHZ);
        this.eHU.as(this.eHM.getString(f.j.agree_me), f.C0146f.icon_im_laud);
        oQ(this.eIa);
        this.eHU.oR(8);
        this.byo.addHeaderView(this.eHT.getView());
        this.byo.addHeaderView(this.eHU.getView());
        this.byo.setOnHeaderClickListener(this.eIc);
    }

    public void onChangeSkinType(int i) {
        if (this.eIf != null && this.eIf.Ht() != null) {
            this.eIf.Ht().onChangeSkinType(i);
        }
        if (this.eHR != null) {
            this.eHR.setTextColor(am.getColor(f.d.cp_cont_d));
            this.eHR.dB(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dB(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.j(this.mNoDataView, f.d.cp_bg_line_d);
        }
        if (this.eHT != null) {
            this.eHT.aPq();
        }
        if (this.eHU != null) {
            this.eHU.aPq();
        }
        notifyDataSetChanged();
        am.j(this.byo, this.eIb);
        am.j(this.byp, f.d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.eIf == null || this.eIf.Ht() == null || this.eIf.Ht().getVisibility() != 0) {
            return false;
        }
        this.eIf.Ip();
        return true;
    }

    public void ih(boolean z) {
        if (this.byp != null) {
            if (z && this.byo != null && this.byo.getFirstVisiblePosition() != 0) {
                this.byo.setSelection(0);
            }
            this.byp.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.eHZ = newsNotifyMessage.getMsgAtme();
            this.eIa = newsNotifyMessage.getMsgAgree();
            oP(this.eHZ);
            oQ(this.eIa);
        }
    }

    public void aPi() {
        oP(this.eHZ);
        oQ(this.eIa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oP(int i) {
        if (this.eHT != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.DS().DX()) {
                z = true;
            }
            this.eHT.x(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oQ(int i) {
        if (this.eHU != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.DS().Ei()) {
                z = true;
            }
            this.eHU.x(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eIf != null) {
            if (i == 12005) {
                this.eIf.Is();
            }
            this.eIf.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eIf.Ht().FP();
        this.eIf.Ip();
        this.eIf.Ht().HD();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eIf.b(writeData);
                this.eIf.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eN = this.eIf.Ht().eN(6);
                if (eN != null && eN.aMc != null) {
                    eN.aMc.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eIf.Il();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eIf != null) {
            this.eIf.onDestory();
        }
        if (this.eHX != null) {
            this.eHX.onDestroy();
        }
        if (this.eIe != null) {
            this.eIe.a((ReplyMeModel.a) null);
            this.eIe.onDestroy();
        }
        if (this.eHX != null) {
            this.eHX.a((ak.a) null);
        }
    }

    public void d(n nVar) {
        if (this.eHS != null) {
            this.eHS.d(nVar);
        }
    }
}
