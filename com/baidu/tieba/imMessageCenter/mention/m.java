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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ab;
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
    private BdTypeRecyclerView Vw;
    private BdSwipeRefreshLayout feu;
    private final f.c fiZ;
    private com.baidu.tieba.frs.profession.permission.c hra;
    private NavigationBarShadowView iPD;
    private com.baidu.tieba.imMessageCenter.mention.base.f iQA;
    private boolean iQB;
    private aj iQC;
    private AttentionHostData iQD;
    private int iQE;
    private int iQF;
    private int iQG;
    private boolean iQH;
    private BdListView.b iQI;
    private View.OnClickListener iQJ;
    private RecyclerView.OnScrollListener iQK;
    private g.a iQL;
    private ReplyMeModel iQM;
    private com.baidu.tbadk.editortools.pb.h iQN;
    private com.baidu.tieba.imMessageCenter.mention.base.a iQO;
    private String iQP;
    private long iQQ;
    private long iQR;
    private DataModel<MessageCenterActivity> iQS;
    private NewWriteModel.d iQT;
    private final ReplyMeModel.a iQU;
    private final ReplyMessageFragment iQr;
    private PbListView iQw;
    private com.baidu.tieba.imMessageCenter.mention.base.e iQx;
    private com.baidu.tieba.imMessageCenter.mention.base.g iQy;
    private com.baidu.tieba.imMessageCenter.mention.base.f iQz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.iQE = 0;
        this.iQF = 0;
        this.iQG = R.color.cp_bg_line_c;
        this.iQH = false;
        this.iQI = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.iQz.getView()) {
                    if (view == m.this.iQA.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZm().aZC();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZm().mG(0);
                        m.this.iQF = 0;
                        m.this.yu(m.this.iQF);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aZm().aZB();
                com.baidu.tbadk.coreExtra.messageCenter.b.aZm().setMsgAtme(0);
                m.this.iQE = 0;
                m.this.yt(m.this.iQE);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.iQJ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.iQw != null && m.this.iQr != null) {
                    m.this.iQw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.iQw.setOnClickListener(null);
                    m.this.iQw.startLoadData();
                    m.this.iQr.bJR();
                }
            }
        };
        this.fiZ = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.iQr != null) {
                        m.this.iQr.bXK();
                    }
                } else if (m.this.feu != null) {
                    m.this.feu.setRefreshing(false);
                }
            }
        };
        this.iQK = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.iPD.show();
                            return;
                        } else {
                            m.this.iPD.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.iPD.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.iQL = new g.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.tieba.imMessageCenter.mention.base.g.a
            public void onClose() {
                if (m.this.iQy != null) {
                    m.this.Vw.removeHeaderView(m.this.iQy.getView());
                    m.this.iQH = false;
                }
            }
        };
        this.iQM = null;
        this.iQU = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.iQP = str;
                m.this.iQQ = j2;
                m.this.iQR = j3;
                m.this.H(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.iQN != null) {
                    m.this.iQN.bdW();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.iQr = replyMessageFragment;
        this.iQC = new aj(replyMessageFragment.getPageContext());
        this.iQC.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tbadk.core.util.aj.a
            public void q(boolean z, int i) {
                if (z && m.this.iQN != null) {
                    m.this.iQN.bdS();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<o> arrayList) {
        if (this.Vw != null) {
            pO(false);
            if (z) {
                this.iQw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.iQw.endLoadData();
                this.iQw.setOnClickListener(this.iQJ);
            } else {
                this.iQw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.iQw.endLoadData();
                this.iQw.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.iQw.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dj(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.iQB) {
                    this.iQB = true;
                    this.Vw.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Vw.setNextPage(null);
                if (arrayList != null) {
                    this.iQx.setData(arrayList);
                }
                this.iQG = R.color.cp_bg_line_e;
            } else {
                this.Vw.removeHeaderView(this.mNoDataView);
                this.iQB = false;
                if (this.iQx != null) {
                    this.iQx.setData(arrayList);
                    this.iQx.notifyDataSetChanged();
                }
                this.Vw.setNextPage(this.iQw);
                this.iQG = R.color.cp_bg_line_c;
            }
            cro();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.iQx != null) {
            this.iQx.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bM(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.iPD = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.iQr.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fiZ);
        }
        this.mPullView.setTag(this.iQr.getUniqueId());
        if (this.iQw == null) {
            this.iQw = new PbListView(this.iQr.getContext());
            this.iQw.getView();
        }
        this.iQw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.iQw.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iQr.getContext(), R.dimen.tbds182));
        this.iQw.setLineGone();
        this.iQw.setTextSize(R.dimen.tbfontsize33);
        this.iQw.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iQw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iQw.setOnClickListener(this.iQJ);
        this.feu = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.feu.setProgressView(this.mPullView);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.iQx = new com.baidu.tieba.imMessageCenter.mention.base.e(this.iQr.getPageContext(), this.Vw);
        this.iQx.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.pQ(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.iQO = aVar;
                        if (aVar.crs()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.crt(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.iQD == null) {
                            m.this.iQD = new AttentionHostData();
                        }
                        if (m.this.iQO != null) {
                            m.this.iQD.parserWithMetaData(m.this.iQO.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.iQO != null) {
                            baijiahaoData = m.this.iQO.getBaijiahaoData();
                        }
                        m.this.iQM.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cru() != null) {
                            an ag = new an(aVar.cru()).ag("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.iRt) {
                                ag.ag("obj_type", 1);
                            } else {
                                ag.ag("obj_type", 2);
                            }
                            TiebaStatic.log(ag);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Vw.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Vw.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Vw.setFadingEdgeLength(0);
        this.Vw.setOverScrollMode(2);
        this.Vw.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Vw.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Vw.setNextPage(this.iQw);
        this.Vw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.iQw != null) {
                    m.this.iQw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.iQw.setOnClickListener(null);
                    m.this.iQw.showLoading();
                    m.this.iQr.bJR();
                }
            }
        });
        this.Vw.setOnScrollListener(this.mScrollListener);
        this.Vw.addOnScrollListener(this.iQK);
        crn();
        this.iQM = new ReplyMeModel(this.iQr.getPageContext());
        this.iQM.a(this.iQU);
        crq();
        pP(false);
        return this.mRootView;
    }

    private void crn() {
        cro();
        this.iQz = new com.baidu.tieba.imMessageCenter.mention.base.f(this.iQr.getPageContext());
        this.iQA = new com.baidu.tieba.imMessageCenter.mention.base.f(this.iQr.getPageContext());
        this.iQz.bl(this.iQr.getString(R.string.at_me), R.drawable.icon_im_at);
        yt(this.iQE);
        this.iQA.bl(this.iQr.getString(R.string.agree_me), R.drawable.icon_im_laud);
        yu(this.iQF);
        this.Vw.addHeaderView(this.iQz.getView());
        this.Vw.addHeaderView(this.iQA.getView());
        this.Vw.setOnHeaderClickListener(this.iQI);
    }

    private void cro() {
        if (this.Vw != null) {
            if (NotificationManagerCompat.from(this.iQr.getFragmentActivity()).areNotificationsEnabled()) {
                if (this.iQy != null) {
                    this.Vw.removeHeaderView(this.iQy.getView());
                    this.iQH = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_im_open_notification_close_time", 0L);
            if (this.iQH) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.iQy == null) {
                    this.iQy = new com.baidu.tieba.imMessageCenter.mention.base.g(this.iQr.getPageContext());
                    this.iQy.a(this.iQL);
                }
                this.Vw.addHeaderView(this.iQy.getView(), 0);
                this.iQH = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iQN != null && this.iQN.bcX() != null) {
            this.iQN.bcX().onChangeSkinType(i);
        }
        if (this.iQw != null) {
            this.iQw.setTextColor(am.getColor(R.color.cp_cont_d));
            this.iQw.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.iQz != null) {
            this.iQz.crv();
        }
        if (this.iQA != null) {
            this.iQA.crv();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.Vw, this.iQG);
        am.setBackgroundColor(this.feu, R.color.cp_bg_line_e);
        if (this.iQy != null) {
            this.iQy.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.iQN == null || this.iQN.bcX() == null || this.iQN.bcX().getVisibility() != 0) {
            return false;
        }
        this.iQN.bdW();
        return true;
    }

    public void pO(boolean z) {
        if (this.feu != null) {
            if (z && this.Vw != null && this.Vw.getFirstVisiblePosition() != 0) {
                this.Vw.setSelection(0);
            }
            this.feu.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.iQE = newsNotifyMessage.getMsgAtme();
            this.iQF = newsNotifyMessage.getMsgAgree();
            yt(this.iQE);
            yu(this.iQF);
        }
    }

    public void crp() {
        yt(this.iQE);
        yu(this.iQF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt(int i) {
        if (this.iQz != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aZT().aZY()) {
                z = true;
            }
            this.iQz.U(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu(int i) {
        if (this.iQA != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aZT().bak()) {
                z = true;
            }
            this.iQA.U(i, z);
        }
    }

    private void crq() {
        this.iQS = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.G(this.iQr.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bdr() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData yf(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.iQP);
                writeData.setThreadId(m.this.iQO.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.iQO.crs()) {
                    writeData.setFloor(m.this.iQQ > 0 ? String.valueOf(m.this.iQQ) : m.this.iQO.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.iQO.getPost_id());
                }
                if (m.this.iQR > 0) {
                    writeData.setRepostId(String.valueOf(m.this.iQR));
                }
                if (m.this.iQO != null) {
                    writeData.setBaijiahaoData(m.this.iQO.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bds() {
                return null;
            }
        };
        this.iQT = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
                if (m.this.iQr.getBaseFragmentActivity() != null) {
                    m.this.iQr.getBaseFragmentActivity().hideProgressBar();
                    m.this.iQN.bcX().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.iQC.a(m.this.iQD);
                        m.this.iQC.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && abVar == null && !AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.iQr.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(boolean z) {
        if (this.iQN != null && this.iQN.bcX() != null && this.iQN.bcX().getParent() != null) {
            ((ViewGroup) this.iQN.bcX().getParent()).removeView(this.iQN.bcX());
        }
        this.iQN = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dN(this.iQr.getPageContext().getPageActivity());
        this.iQN.a(this.iQr.getPageContext());
        this.iQN.b(this.iQS);
        this.iQN.h(this.iQr.getPageContext());
        this.iQN.bcX().hW(true);
        this.iQN.bcX().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iQN.bcX() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.iQN.bcX(), layoutParams);
            this.iQN.bcX().hide();
        }
        this.iQN.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bdv() {
                if (m.this.iQr.getBaseFragmentActivity() != null) {
                    m.this.iQr.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.iQN.b(this.iQT);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.iQN != null) {
            if (i == 12005) {
                this.iQN.bdZ();
            }
            this.iQN.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.iQN.bcX().bbA();
        this.iQN.bdW();
        this.iQN.bcX().bdh();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.iQN.b(writeData);
                this.iQN.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l nh = this.iQN.bcX().nh(6);
                if (nh != null && nh.ekV != null) {
                    nh.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.iQN.bdS();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, long j) {
        if (this.iQO != null && this.iQO.getBaijiahaoData() != null && this.iQO.isBjh()) {
            if (this.iQN == null || !this.iQN.isBJH) {
                pP(true);
            }
            if (this.iQN != null && this.iQO != null) {
                if (this.iQO.crs() && this.iQO.getReplyer() != null) {
                    this.iQN.yp(this.iQO.getReplyer().getName_show());
                    return;
                } else {
                    this.iQN.yp(null);
                    return;
                }
            }
            return;
        }
        if (this.hra == null) {
            this.hra = new com.baidu.tieba.frs.profession.permission.c(this.iQr.getPageContext());
            this.hra.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void na(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void x(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nb(boolean z) {
                    if (z) {
                        if (m.this.iQN == null || m.this.iQN.isBJH) {
                            m.this.pP(false);
                        }
                        if (m.this.iQN != null && m.this.iQO != null) {
                            if (!m.this.iQO.crs() || m.this.iQO.getReplyer() == null) {
                                m.this.iQN.yp(null);
                            } else {
                                m.this.iQN.yp(m.this.iQO.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.hra.D(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.iQN != null) {
            this.iQN.onDestory();
        }
        if (this.iQC != null) {
            this.iQC.onDestroy();
        }
        if (this.iQM != null) {
            this.iQM.a((ReplyMeModel.a) null);
            this.iQM.onDestroy();
        }
        if (this.iQC != null) {
            this.iQC.a((aj.a) null);
        }
    }

    public void e(x xVar) {
        if (this.iQx != null) {
            this.iQx.e(xVar);
        }
    }

    public void onPrimary() {
        cro();
    }
}
