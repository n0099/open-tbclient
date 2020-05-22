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
    private BdSwipeRefreshLayout fej;
    private final f.c fiO;
    private com.baidu.tieba.frs.profession.permission.c hqP;
    private NavigationBarShadowView iOQ;
    private final ReplyMessageFragment iPE;
    private PbListView iPJ;
    private com.baidu.tieba.imMessageCenter.mention.base.e iPK;
    private com.baidu.tieba.imMessageCenter.mention.base.g iPL;
    private com.baidu.tieba.imMessageCenter.mention.base.f iPM;
    private com.baidu.tieba.imMessageCenter.mention.base.f iPN;
    private boolean iPO;
    private aj iPP;
    private AttentionHostData iPQ;
    private int iPR;
    private int iPS;
    private int iPT;
    private boolean iPU;
    private BdListView.b iPV;
    private View.OnClickListener iPW;
    private RecyclerView.OnScrollListener iPX;
    private g.a iPY;
    private ReplyMeModel iPZ;
    private com.baidu.tbadk.editortools.pb.h iQa;
    private com.baidu.tieba.imMessageCenter.mention.base.a iQb;
    private String iQc;
    private long iQd;
    private long iQe;
    private DataModel<MessageCenterActivity> iQf;
    private NewWriteModel.d iQg;
    private final ReplyMeModel.a iQh;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.iPR = 0;
        this.iPS = 0;
        this.iPT = R.color.cp_bg_line_c;
        this.iPU = false;
        this.iPV = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.iPM.getView()) {
                    if (view == m.this.iPN.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZB();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aZl().mE(0);
                        m.this.iPS = 0;
                        m.this.ys(m.this.iPS);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().aZA();
                com.baidu.tbadk.coreExtra.messageCenter.b.aZl().setMsgAtme(0);
                m.this.iPR = 0;
                m.this.yr(m.this.iPR);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.iPW = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.iPJ != null && m.this.iPE != null) {
                    m.this.iPJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.iPJ.setOnClickListener(null);
                    m.this.iPJ.startLoadData();
                    m.this.iPE.bJP();
                }
            }
        };
        this.fiO = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.iPE != null) {
                        m.this.iPE.bXI();
                    }
                } else if (m.this.fej != null) {
                    m.this.fej.setRefreshing(false);
                }
            }
        };
        this.iPX = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.iOQ.show();
                            return;
                        } else {
                            m.this.iOQ.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.iOQ.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.iPY = new g.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.tieba.imMessageCenter.mention.base.g.a
            public void onClose() {
                if (m.this.iPL != null) {
                    m.this.Vw.removeHeaderView(m.this.iPL.getView());
                    m.this.iPU = false;
                }
            }
        };
        this.iPZ = null;
        this.iQh = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.iQc = str;
                m.this.iQd = j2;
                m.this.iQe = j3;
                m.this.H(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.iQa != null) {
                    m.this.iQa.bdV();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.iPE = replyMessageFragment;
        this.iPP = new aj(replyMessageFragment.getPageContext());
        this.iPP.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tbadk.core.util.aj.a
            public void q(boolean z, int i) {
                if (z && m.this.iQa != null) {
                    m.this.iQa.bdR();
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
                this.iPJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.iPJ.endLoadData();
                this.iPJ.setOnClickListener(this.iPW);
            } else {
                this.iPJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.iPJ.endLoadData();
                this.iPJ.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.iPJ.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dj(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.iPO) {
                    this.iPO = true;
                    this.Vw.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Vw.setNextPage(null);
                if (arrayList != null) {
                    this.iPK.setData(arrayList);
                }
                this.iPT = R.color.cp_bg_line_e;
            } else {
                this.Vw.removeHeaderView(this.mNoDataView);
                this.iPO = false;
                if (this.iPK != null) {
                    this.iPK.setData(arrayList);
                    this.iPK.notifyDataSetChanged();
                }
                this.Vw.setNextPage(this.iPJ);
                this.iPT = R.color.cp_bg_line_c;
            }
            crf();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.iPK != null) {
            this.iPK.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bM(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.iOQ = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.iPE.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fiO);
        }
        this.mPullView.setTag(this.iPE.getUniqueId());
        if (this.iPJ == null) {
            this.iPJ = new PbListView(this.iPE.getContext());
            this.iPJ.getView();
        }
        this.iPJ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.iPJ.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iPE.getContext(), R.dimen.tbds182));
        this.iPJ.setLineGone();
        this.iPJ.setTextSize(R.dimen.tbfontsize33);
        this.iPJ.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iPJ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iPJ.setOnClickListener(this.iPW);
        this.fej = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.fej.setProgressView(this.mPullView);
        this.Vw = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.iPK = new com.baidu.tieba.imMessageCenter.mention.base.e(this.iPE.getPageContext(), this.Vw);
        this.iPK.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
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
                        m.this.iQb = aVar;
                        if (aVar.crj()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.crk(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.iPQ == null) {
                            m.this.iPQ = new AttentionHostData();
                        }
                        if (m.this.iQb != null) {
                            m.this.iPQ.parserWithMetaData(m.this.iQb.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.iQb != null) {
                            baijiahaoData = m.this.iQb.getBaijiahaoData();
                        }
                        m.this.iPZ.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.crl() != null) {
                            an ag = new an(aVar.crl()).ag("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.iQG) {
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
        this.Vw.setNextPage(this.iPJ);
        this.Vw.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.iPJ != null) {
                    m.this.iPJ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.iPJ.setOnClickListener(null);
                    m.this.iPJ.showLoading();
                    m.this.iPE.bJP();
                }
            }
        });
        this.Vw.setOnScrollListener(this.mScrollListener);
        this.Vw.addOnScrollListener(this.iPX);
        cre();
        this.iPZ = new ReplyMeModel(this.iPE.getPageContext());
        this.iPZ.a(this.iQh);
        crh();
        pP(false);
        return this.mRootView;
    }

    private void cre() {
        crf();
        this.iPM = new com.baidu.tieba.imMessageCenter.mention.base.f(this.iPE.getPageContext());
        this.iPN = new com.baidu.tieba.imMessageCenter.mention.base.f(this.iPE.getPageContext());
        this.iPM.bl(this.iPE.getString(R.string.at_me), R.drawable.icon_im_at);
        yr(this.iPR);
        this.iPN.bl(this.iPE.getString(R.string.agree_me), R.drawable.icon_im_laud);
        ys(this.iPS);
        this.Vw.addHeaderView(this.iPM.getView());
        this.Vw.addHeaderView(this.iPN.getView());
        this.Vw.setOnHeaderClickListener(this.iPV);
    }

    private void crf() {
        if (this.Vw != null) {
            if (NotificationManagerCompat.from(this.iPE.getFragmentActivity()).areNotificationsEnabled()) {
                if (this.iPL != null) {
                    this.Vw.removeHeaderView(this.iPL.getView());
                    this.iPU = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aTX().getLong("key_im_open_notification_close_time", 0L);
            if (this.iPU) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.iPL == null) {
                    this.iPL = new com.baidu.tieba.imMessageCenter.mention.base.g(this.iPE.getPageContext());
                    this.iPL.a(this.iPY);
                }
                this.Vw.addHeaderView(this.iPL.getView(), 0);
                this.iPU = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iQa != null && this.iQa.bcW() != null) {
            this.iQa.bcW().onChangeSkinType(i);
        }
        if (this.iPJ != null) {
            this.iPJ.setTextColor(am.getColor(R.color.cp_cont_d));
            this.iPJ.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.iPM != null) {
            this.iPM.crm();
        }
        if (this.iPN != null) {
            this.iPN.crm();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.Vw, this.iPT);
        am.setBackgroundColor(this.fej, R.color.cp_bg_line_e);
        if (this.iPL != null) {
            this.iPL.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.iQa == null || this.iQa.bcW() == null || this.iQa.bcW().getVisibility() != 0) {
            return false;
        }
        this.iQa.bdV();
        return true;
    }

    public void pO(boolean z) {
        if (this.fej != null) {
            if (z && this.Vw != null && this.Vw.getFirstVisiblePosition() != 0) {
                this.Vw.setSelection(0);
            }
            this.fej.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.iPR = newsNotifyMessage.getMsgAtme();
            this.iPS = newsNotifyMessage.getMsgAgree();
            yr(this.iPR);
            ys(this.iPS);
        }
    }

    public void crg() {
        yr(this.iPR);
        ys(this.iPS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yr(int i) {
        if (this.iPM != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aZS().aZX()) {
                z = true;
            }
            this.iPM.U(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys(int i) {
        if (this.iPN != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aZS().baj()) {
                z = true;
            }
            this.iPN.U(i, z);
        }
    }

    private void crh() {
        this.iQf = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.G(this.iPE.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bdq() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData yf(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.iQc);
                writeData.setThreadId(m.this.iQb.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.iQb.crj()) {
                    writeData.setFloor(m.this.iQd > 0 ? String.valueOf(m.this.iQd) : m.this.iQb.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.iQb.getPost_id());
                }
                if (m.this.iQe > 0) {
                    writeData.setRepostId(String.valueOf(m.this.iQe));
                }
                if (m.this.iQb != null) {
                    writeData.setBaijiahaoData(m.this.iQb.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bdr() {
                return null;
            }
        };
        this.iQg = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.aa aaVar, WriteData writeData, AntiData antiData) {
                if (m.this.iPE.getBaseFragmentActivity() != null) {
                    m.this.iPE.getBaseFragmentActivity().hideProgressBar();
                    m.this.iQa.bcW().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.iPP.a(m.this.iPQ);
                        m.this.iPP.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && aaVar == null && !AntiHelper.bv(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.iPE.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(boolean z) {
        if (this.iQa != null && this.iQa.bcW() != null && this.iQa.bcW().getParent() != null) {
            ((ViewGroup) this.iQa.bcW().getParent()).removeView(this.iQa.bcW());
        }
        this.iQa = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dN(this.iPE.getPageContext().getPageActivity());
        this.iQa.a(this.iPE.getPageContext());
        this.iQa.b(this.iQf);
        this.iQa.h(this.iPE.getPageContext());
        this.iQa.bcW().hW(true);
        this.iQa.bcW().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iQa.bcW() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.iQa.bcW(), layoutParams);
            this.iQa.bcW().hide();
        }
        this.iQa.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bdu() {
                if (m.this.iPE.getBaseFragmentActivity() != null) {
                    m.this.iPE.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.iQa.b(this.iQg);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.iQa != null) {
            if (i == 12005) {
                this.iQa.bdY();
            }
            this.iQa.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.iQa.bcW().bbz();
        this.iQa.bdV();
        this.iQa.bcW().bdg();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.iQa.b(writeData);
                this.iQa.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l nf = this.iQa.bcW().nf(6);
                if (nf != null && nf.ekV != null) {
                    nf.ekV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.iQa.bdR();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, long j) {
        if (this.iQb != null && this.iQb.getBaijiahaoData() != null && this.iQb.isBjh()) {
            if (this.iQa == null || !this.iQa.isBJH) {
                pP(true);
            }
            if (this.iQa != null && this.iQb != null) {
                if (this.iQb.crj() && this.iQb.getReplyer() != null) {
                    this.iQa.yp(this.iQb.getReplyer().getName_show());
                    return;
                } else {
                    this.iQa.yp(null);
                    return;
                }
            }
            return;
        }
        if (this.hqP == null) {
            this.hqP = new com.baidu.tieba.frs.profession.permission.c(this.iPE.getPageContext());
            this.hqP.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void na(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void x(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nb(boolean z) {
                    if (z) {
                        if (m.this.iQa == null || m.this.iQa.isBJH) {
                            m.this.pP(false);
                        }
                        if (m.this.iQa != null && m.this.iQb != null) {
                            if (!m.this.iQb.crj() || m.this.iQb.getReplyer() == null) {
                                m.this.iQa.yp(null);
                            } else {
                                m.this.iQa.yp(m.this.iQb.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.hqP.D(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.iQa != null) {
            this.iQa.onDestory();
        }
        if (this.iPP != null) {
            this.iPP.onDestroy();
        }
        if (this.iPZ != null) {
            this.iPZ.a((ReplyMeModel.a) null);
            this.iPZ.onDestroy();
        }
        if (this.iPP != null) {
            this.iPP.a((aj.a) null);
        }
    }

    public void e(x xVar) {
        if (this.iPK != null) {
            this.iPK.e(xVar);
        }
    }

    public void onPrimary() {
        crf();
    }
}
