package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.imMessageCenter.mention.base.g;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView Wa;
    private BdSwipeRefreshLayout fpF;
    private final f.c fum;
    private com.baidu.tieba.frs.profession.permission.c hDN;
    private NavigationBarShadowView jgG;
    private final ReplyMessageFragment jhA;
    private PbListView jhF;
    private com.baidu.tieba.imMessageCenter.mention.base.e jhG;
    private com.baidu.tieba.imMessageCenter.mention.base.g jhH;
    private com.baidu.tieba.imMessageCenter.mention.base.f jhI;
    private com.baidu.tieba.imMessageCenter.mention.base.f jhJ;
    private boolean jhK;
    private ak jhL;
    private AttentionHostData jhM;
    private int jhN;
    private int jhO;
    private int jhP;
    private boolean jhQ;
    private BdListView.b jhR;
    private View.OnClickListener jhS;
    private RecyclerView.OnScrollListener jhT;
    private g.a jhU;
    private ReplyMeModel jhV;
    private com.baidu.tbadk.editortools.pb.h jhW;
    private com.baidu.tieba.imMessageCenter.mention.base.a jhX;
    private String jhY;
    private long jhZ;
    private long jia;
    private DataModel<MessageCenterActivity> jib;
    private NewWriteModel.d jic;
    private final ReplyMeModel.a jie;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jhN = 0;
        this.jhO = 0;
        this.jhP = R.color.cp_bg_line_c;
        this.jhQ = false;
        this.jhR = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                ao aoVar = new ao("c13720");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                if (view != m.this.jhI.getView()) {
                    if (view == m.this.jhJ.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbE();
                        com.baidu.tbadk.coreExtra.messageCenter.b.bbo().na(0);
                        m.this.jhO = 0;
                        m.this.zf(m.this.jhO);
                        TiebaStatic.log("c12926");
                        aoVar.ag("obj_type", 2);
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                    com.baidu.tbadk.coreExtra.messageCenter.b.bbo().bbD();
                    com.baidu.tbadk.coreExtra.messageCenter.b.bbo().setMsgAtme(0);
                    m.this.jhN = 0;
                    m.this.ze(m.this.jhN);
                    TiebaStatic.log("c12925");
                    TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
                    aoVar.ag("obj_type", 1);
                }
                TiebaStatic.log(aoVar);
            }
        };
        this.jhS = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.jhF != null && m.this.jhA != null) {
                    m.this.jhF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jhF.setOnClickListener(null);
                    m.this.jhF.startLoadData();
                    m.this.jhA.bMX();
                }
            }
        };
        this.fum = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.jhA != null) {
                        m.this.jhA.caY();
                    }
                } else if (m.this.fpF != null) {
                    m.this.fpF.setRefreshing(false);
                }
            }
        };
        this.jhT = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.jgG.show();
                            return;
                        } else {
                            m.this.jgG.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.jgG.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.jhU = new g.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.tieba.imMessageCenter.mention.base.g.a
            public void onClose() {
                if (m.this.jhH != null) {
                    m.this.Wa.removeHeaderView(m.this.jhH.getView());
                    m.this.jhQ = false;
                }
            }
        };
        this.jhV = null;
        this.jie = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.jhY = str;
                m.this.jhZ = j2;
                m.this.jia = j3;
                m.this.H(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.jhW != null) {
                    m.this.jhW.bgb();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.jhA = replyMessageFragment;
        this.jhL = new ak(replyMessageFragment.getPageContext());
        this.jhL.a(new ak.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tbadk.core.util.ak.a
            public void q(boolean z, int i) {
                if (z && m.this.jhW != null) {
                    m.this.jhW.bfX();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<q> arrayList) {
        if (this.Wa != null) {
            pY(false);
            if (z) {
                this.jhF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jhF.endLoadData();
                this.jhF.setOnClickListener(this.jhS);
            } else {
                this.jhF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jhF.endLoadData();
                this.jhF.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.jhF.setOnClickListener(null);
            }
            if (w.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dm(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    an.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jhK) {
                    this.jhK = true;
                    this.Wa.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Wa.setNextPage(null);
                if (arrayList != null) {
                    this.jhG.setData(arrayList);
                }
                this.jhP = R.color.cp_bg_line_e;
            } else {
                this.Wa.removeHeaderView(this.mNoDataView);
                this.jhK = false;
                if (this.jhG != null) {
                    this.jhG.setData(arrayList);
                    this.jhG.notifyDataSetChanged();
                }
                this.Wa.setNextPage(this.jhF);
                this.jhP = R.color.cp_bg_line_c;
            }
            cvg();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.jhG != null) {
            this.jhG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bV(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.jgG = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jhA.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fum);
        }
        this.mPullView.setTag(this.jhA.getUniqueId());
        if (this.jhF == null) {
            this.jhF = new PbListView(this.jhA.getContext());
            this.jhF.getView();
        }
        this.jhF.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.jhF.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jhA.getContext(), R.dimen.tbds182));
        this.jhF.setLineGone();
        this.jhF.setTextSize(R.dimen.tbfontsize33);
        this.jhF.setTextColor(an.getColor(R.color.cp_cont_d));
        this.jhF.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jhF.setOnClickListener(this.jhS);
        this.fpF = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.fpF.setProgressView(this.mPullView);
        this.Wa = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.jhG = new com.baidu.tieba.imMessageCenter.mention.base.e(this.jhA.getPageContext(), this.Wa);
        this.jhG.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.qa(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.jhX = aVar;
                        if (aVar.cvk()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cvl(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.jhM == null) {
                            m.this.jhM = new AttentionHostData();
                        }
                        if (m.this.jhX != null) {
                            m.this.jhM.parserWithMetaData(m.this.jhX.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.jhX != null) {
                            baijiahaoData = m.this.jhX.getBaijiahaoData();
                        }
                        m.this.jhV.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cvm() != null) {
                            ao ag = new ao(aVar.cvm()).ag("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jiF) {
                                ag.ag("obj_type", 1);
                            } else {
                                ag.ag("obj_type", 2);
                            }
                            TiebaStatic.log(ag);
                        }
                        ao aoVar = new ao("c13784");
                        aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(aoVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Wa.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Wa.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Wa.setFadingEdgeLength(0);
        this.Wa.setOverScrollMode(2);
        this.Wa.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Wa.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Wa.setNextPage(this.jhF);
        this.Wa.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.jhF != null) {
                    m.this.jhF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jhF.setOnClickListener(null);
                    m.this.jhF.showLoading();
                    m.this.jhA.bMX();
                }
            }
        });
        this.Wa.setOnScrollListener(this.mScrollListener);
        this.Wa.addOnScrollListener(this.jhT);
        cvf();
        this.jhV = new ReplyMeModel(this.jhA.getPageContext());
        this.jhV.a(this.jie);
        cvi();
        pZ(false);
        return this.mRootView;
    }

    private void cvf() {
        cvg();
        this.jhI = new com.baidu.tieba.imMessageCenter.mention.base.f(this.jhA.getPageContext());
        this.jhJ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.jhA.getPageContext());
        this.jhI.bk(this.jhA.getString(R.string.at_me), R.drawable.icon_im_at);
        ze(this.jhN);
        this.jhJ.bk(this.jhA.getString(R.string.agree_me), R.drawable.icon_im_laud);
        zf(this.jhO);
        this.Wa.addHeaderView(this.jhI.getView());
        this.Wa.addHeaderView(this.jhJ.getView());
        this.Wa.setOnHeaderClickListener(this.jhR);
    }

    private void cvg() {
        if (this.Wa != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.jhA.getFragmentActivity()).areNotificationsEnabled();
            ao aoVar = new ao("c13616");
            aoVar.ag("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aoVar);
            if (areNotificationsEnabled) {
                if (this.jhH != null) {
                    this.Wa.removeHeaderView(this.jhH.getView());
                    this.jhQ = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aVP().getLong("key_im_open_notification_close_time", 0L);
            if (this.jhQ) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jhH == null) {
                    this.jhH = new com.baidu.tieba.imMessageCenter.mention.base.g(this.jhA.getPageContext());
                    this.jhH.a(this.jhU);
                }
                this.Wa.addHeaderView(this.jhH.getView(), 0);
                this.jhQ = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jhW != null && this.jhW.bfa() != null) {
            this.jhW.bfa().onChangeSkinType(i);
        }
        if (this.jhF != null) {
            this.jhF.setTextColor(an.getColor(R.color.cp_cont_d));
            this.jhF.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            an.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.jhI != null) {
            this.jhI.aYi();
        }
        if (this.jhJ != null) {
            this.jhJ.aYi();
        }
        notifyDataSetChanged();
        an.setBackgroundColor(this.Wa, this.jhP);
        an.setBackgroundColor(this.fpF, R.color.cp_bg_line_e);
        if (this.jhH != null) {
            this.jhH.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.jhW == null || this.jhW.bfa() == null || this.jhW.bfa().getVisibility() != 0) {
            return false;
        }
        this.jhW.bgb();
        return true;
    }

    public void pY(boolean z) {
        if (this.fpF != null) {
            if (z && this.Wa != null && this.Wa.getFirstVisiblePosition() != 0) {
                this.Wa.setSelection(0);
            }
            this.fpF.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.jhN = newsNotifyMessage.getMsgAtme();
            this.jhO = newsNotifyMessage.getMsgAgree();
            ze(this.jhN);
            zf(this.jhO);
        }
    }

    public void cvh() {
        ze(this.jhN);
        zf(this.jhO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ze(int i) {
        if (this.jhI != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bca()) {
                z = true;
            }
            this.jhI.X(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zf(int i) {
        if (this.jhJ != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.bbV().bcm()) {
                z = true;
            }
            this.jhJ.X(i, z);
        }
    }

    private void cvi() {
        this.jib = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.G(this.jhA.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bfv() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData yy(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.jhY);
                writeData.setThreadId(m.this.jhX.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.jhX.cvk()) {
                    writeData.setFloor(m.this.jhZ > 0 ? String.valueOf(m.this.jhZ) : m.this.jhX.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.jhX.getPost_id());
                }
                if (m.this.jia > 0) {
                    writeData.setRepostId(String.valueOf(m.this.jia));
                }
                if (m.this.jhX != null) {
                    writeData.setBaijiahaoData(m.this.jhX.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bfw() {
                return null;
            }
        };
        this.jic = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                if (m.this.jhA.getBaseFragmentActivity() != null) {
                    m.this.jhA.getBaseFragmentActivity().hideProgressBar();
                    m.this.jhW.bfa().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.jhL.a(m.this.jhM);
                        m.this.jhL.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && adVar == null && !AntiHelper.bA(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.jhA.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pZ(boolean z) {
        if (this.jhW != null && this.jhW.bfa() != null && this.jhW.bfa().getParent() != null) {
            ((ViewGroup) this.jhW.bfa().getParent()).removeView(this.jhW.bfa());
        }
        this.jhW = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dO(this.jhA.getPageContext().getPageActivity());
        this.jhW.a(this.jhA.getPageContext());
        this.jhW.b(this.jib);
        this.jhW.k(this.jhA.getPageContext());
        this.jhW.bfa().m32if(true);
        this.jhW.bfa().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jhW.bfa() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.jhW.bfa(), layoutParams);
            this.jhW.bfa().hide();
        }
        this.jhW.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bfz() {
                if (m.this.jhA.getBaseFragmentActivity() != null) {
                    m.this.jhA.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.jhW.b(this.jic);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.jhW != null) {
            if (i == 12005) {
                this.jhW.bge();
            }
            this.jhW.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.jhW.bfa().bdC();
        this.jhW.bgb();
        this.jhW.bfa().bfk();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jhW.b(writeData);
                this.jhW.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l nB = this.jhW.bfa().nB(6);
                if (nB != null && nB.etH != null) {
                    nB.etH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jhW.bfX();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, long j) {
        if (this.jhX != null && this.jhX.getBaijiahaoData() != null && this.jhX.isBjh()) {
            if (this.jhW == null || !this.jhW.isBJH) {
                pZ(true);
            }
            if (this.jhW != null && this.jhX != null) {
                if (this.jhX.cvk() && this.jhX.getReplyer() != null) {
                    this.jhW.yI(this.jhX.getReplyer().getName_show());
                    return;
                } else {
                    this.jhW.yI(null);
                    return;
                }
            }
            return;
        }
        if (this.hDN == null) {
            this.hDN = new com.baidu.tieba.frs.profession.permission.c(this.jhA.getPageContext());
            this.hDN.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nl(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void z(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nm(boolean z) {
                    if (z) {
                        if (m.this.jhW == null || m.this.jhW.isBJH) {
                            m.this.pZ(false);
                        }
                        if (m.this.jhW != null && m.this.jhX != null) {
                            if (!m.this.jhX.cvk() || m.this.jhX.getReplyer() == null) {
                                m.this.jhW.yI(null);
                            } else {
                                m.this.jhW.yI(m.this.jhX.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.hDN.D(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.jhW != null) {
            this.jhW.onDestory();
        }
        if (this.jhL != null) {
            this.jhL.onDestroy();
        }
        if (this.jhV != null) {
            this.jhV.a((ReplyMeModel.a) null);
            this.jhV.onDestroy();
        }
        if (this.jhL != null) {
            this.jhL.a((ak.a) null);
        }
    }

    public void e(z zVar) {
        if (this.jhG != null) {
            this.jhG.e(zVar);
        }
    }

    public void b(com.baidu.adp.widget.ListView.aa aaVar) {
        if (this.jhG != null) {
            this.jhG.a(aaVar);
        }
    }

    public void onPrimary() {
        cvg();
    }

    public void zg(int i) {
        if (this.jhG != null) {
            this.jhG.zg(i);
        }
    }
}
