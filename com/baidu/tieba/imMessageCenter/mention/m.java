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
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView Bs;
    private BdSwipeRefreshLayout ejj;
    private final g.c enH;
    private com.baidu.tieba.frs.profession.permission.c gpJ;
    private NavigationBarShadowView hMA;
    private int hNA;
    private int hNB;
    private int hNC;
    private BdListView.b hND;
    private View.OnClickListener hNE;
    private RecyclerView.OnScrollListener hNF;
    private ReplyMeModel hNG;
    private com.baidu.tbadk.editortools.pb.h hNH;
    private com.baidu.tieba.imMessageCenter.mention.base.a hNI;
    private String hNJ;
    private long hNK;
    private long hNL;
    private DataModel<MessageCenterActivity> hNM;
    private NewWriteModel.d hNN;
    private final ReplyMeModel.a hNO;
    private final ReplyMessageFragment hNo;
    private PbListView hNt;
    private com.baidu.tieba.imMessageCenter.mention.base.e hNu;
    private com.baidu.tieba.imMessageCenter.mention.base.f hNv;
    private com.baidu.tieba.imMessageCenter.mention.base.f hNw;
    private boolean hNx;
    private aj hNy;
    private AttentionHostData hNz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.hNA = 0;
        this.hNB = 0;
        this.hNC = R.color.cp_bg_line_c;
        this.hND = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.hNv.getView()) {
                    if (view == m.this.hNw.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIz();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aIj().lw(0);
                        m.this.hNB = 0;
                        m.this.wY(m.this.hNB);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aIj().aIy();
                com.baidu.tbadk.coreExtra.messageCenter.b.aIj().setMsgAtme(0);
                m.this.hNA = 0;
                m.this.wX(m.this.hNA);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.hNE = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hNt != null && m.this.hNo != null) {
                    m.this.hNt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hNt.setOnClickListener(null);
                    m.this.hNt.startLoadData();
                    m.this.hNo.bsc();
                }
            }
        };
        this.enH = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.hNo != null) {
                        m.this.hNo.bEV();
                    }
                } else if (m.this.ejj != null) {
                    m.this.ejj.setRefreshing(false);
                }
            }
        };
        this.hNF = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.hMA.show();
                            return;
                        } else {
                            m.this.hMA.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.hMA.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.hNG = null;
        this.hNO = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.hNJ = str;
                m.this.hNK = j2;
                m.this.hNL = j3;
                m.this.I(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.hNH != null) {
                    m.this.hNH.aMU();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.hNo = replyMessageFragment;
        this.hNy = new aj(replyMessageFragment.getPageContext());
        this.hNy.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.aj.a
            public void k(boolean z, int i) {
                if (z && m.this.hNH != null) {
                    m.this.hNH.aMQ();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Bs != null) {
            og(false);
            if (z) {
                this.hNt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hNt.endLoadData();
                this.hNt.setOnClickListener(this.hNE);
            } else {
                this.hNt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hNt.endLoadData();
                this.hNt.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.hNt.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.cr(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hNx) {
                    this.hNx = true;
                    this.Bs.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Bs.setNextPage(null);
                if (arrayList != null) {
                    this.hNu.setData(arrayList);
                }
                this.hNC = R.color.cp_bg_line_e;
            } else {
                this.Bs.removeHeaderView(this.mNoDataView);
                this.hNx = false;
                if (this.hNu != null) {
                    this.hNu.setData(arrayList);
                    this.hNu.notifyDataSetChanged();
                }
                this.Bs.setNextPage(this.hNt);
                this.hNC = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.hNu != null) {
            this.hNu.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bz(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.hMA = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.hNo.getPageContext());
            this.mPullView.setListPullRefreshListener(this.enH);
        }
        this.mPullView.setTag(this.hNo.getUniqueId());
        if (this.hNt == null) {
            this.hNt = new PbListView(this.hNo.getContext());
            this.hNt.getView();
        }
        this.hNt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.hNt.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hNo.getContext(), R.dimen.tbds182));
        this.hNt.setLineGone();
        this.hNt.setTextSize(R.dimen.tbfontsize33);
        this.hNt.setTextColor(am.getColor(R.color.cp_cont_d));
        this.hNt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hNt.setOnClickListener(this.hNE);
        this.ejj = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.ejj.setProgressView(this.mPullView);
        this.Bs = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.hNu = new com.baidu.tieba.imMessageCenter.mention.base.e(this.hNo.getPageContext(), this.Bs);
        this.hNu.setOnCardSubClickListener(new z() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.oi(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.hNI = aVar;
                        if (aVar.bYo()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.bYp(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.hNz == null) {
                            m.this.hNz = new AttentionHostData();
                        }
                        if (m.this.hNI != null) {
                            m.this.hNz.parserWithMetaData(m.this.hNI.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.hNI != null) {
                            baijiahaoData = m.this.hNI.getBaijiahaoData();
                        }
                        m.this.hNG.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.bYq() != null) {
                            an Z = new an(aVar.bYq()).Z("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.hOn) {
                                Z.Z("obj_type", 1);
                            } else {
                                Z.Z("obj_type", 2);
                            }
                            TiebaStatic.log(Z);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Bs.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Bs.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Bs.setFadingEdgeLength(0);
        this.Bs.setOverScrollMode(2);
        this.Bs.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Bs.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Bs.setNextPage(this.hNt);
        this.Bs.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.hNt != null) {
                    m.this.hNt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hNt.setOnClickListener(null);
                    m.this.hNt.showLoading();
                    m.this.hNo.bsc();
                }
            }
        });
        this.Bs.setOnScrollListener(this.mScrollListener);
        this.Bs.addOnScrollListener(this.hNF);
        bYk();
        this.hNG = new ReplyMeModel(this.hNo.getPageContext());
        this.hNG.a(this.hNO);
        bYm();
        oh(false);
        return this.mRootView;
    }

    private void bYk() {
        this.hNv = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hNo.getPageContext());
        this.hNw = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hNo.getPageContext());
        this.hNv.bc(this.hNo.getString(R.string.at_me), R.drawable.icon_im_at);
        wX(this.hNA);
        this.hNw.bc(this.hNo.getString(R.string.agree_me), R.drawable.icon_im_laud);
        wY(this.hNB);
        this.Bs.addHeaderView(this.hNv.getView());
        this.Bs.addHeaderView(this.hNw.getView());
        this.Bs.setOnHeaderClickListener(this.hND);
    }

    public void onChangeSkinType(int i) {
        if (this.hNH != null && this.hNH.aLV() != null) {
            this.hNH.aLV().onChangeSkinType(i);
        }
        if (this.hNt != null) {
            this.hNt.setTextColor(am.getColor(R.color.cp_cont_d));
            this.hNt.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.hNv != null) {
            this.hNv.bFO();
        }
        if (this.hNw != null) {
            this.hNw.bFO();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.Bs, this.hNC);
        am.setBackgroundColor(this.ejj, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.hNH == null || this.hNH.aLV() == null || this.hNH.aLV().getVisibility() != 0) {
            return false;
        }
        this.hNH.aMU();
        return true;
    }

    public void og(boolean z) {
        if (this.ejj != null) {
            if (z && this.Bs != null && this.Bs.getFirstVisiblePosition() != 0) {
                this.Bs.setSelection(0);
            }
            this.ejj.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.hNA = newsNotifyMessage.getMsgAtme();
            this.hNB = newsNotifyMessage.getMsgAgree();
            wX(this.hNA);
            wY(this.hNB);
        }
    }

    public void bYl() {
        wX(this.hNA);
        wY(this.hNB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wX(int i) {
        if (this.hNv != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aIV()) {
                z = true;
            }
            this.hNv.M(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wY(int i) {
        if (this.hNw != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aIQ().aJh()) {
                z = true;
            }
            this.hNw.M(i, z);
        }
    }

    private void bYm() {
        this.hNM = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.hNo.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aMp() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData uR(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.hNJ);
                writeData.setThreadId(m.this.hNI.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.hNI.bYo()) {
                    writeData.setFloor(m.this.hNK > 0 ? String.valueOf(m.this.hNK) : m.this.hNI.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.hNI.getPost_id());
                }
                if (m.this.hNL > 0) {
                    writeData.setRepostId(String.valueOf(m.this.hNL));
                }
                if (m.this.hNI != null) {
                    writeData.setBaijiahaoData(m.this.hNI.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aMq() {
                return null;
            }
        };
        this.hNN = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.z zVar, WriteData writeData, AntiData antiData) {
                if (m.this.hNo.getBaseFragmentActivity() != null) {
                    m.this.hNo.getBaseFragmentActivity().hideProgressBar();
                    m.this.hNH.aLV().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.hNy.a(m.this.hNz);
                        m.this.hNy.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && zVar == null && !AntiHelper.bc(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.hNo.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oh(boolean z) {
        if (this.hNH != null && this.hNH.aLV() != null && this.hNH.aLV().getParent() != null) {
            ((ViewGroup) this.hNH.aLV().getParent()).removeView(this.hNH.aLV());
        }
        this.hNH = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dR(this.hNo.getPageContext().getPageActivity());
        this.hNH.a(this.hNo.getPageContext());
        this.hNH.b(this.hNM);
        this.hNH.g(this.hNo.getPageContext());
        this.hNH.aLV().gu(true);
        this.hNH.aLV().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hNH.aLV() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.hNH.aLV(), layoutParams);
            this.hNH.aLV().hide();
        }
        this.hNH.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void aMt() {
                if (m.this.hNo.getBaseFragmentActivity() != null) {
                    m.this.hNo.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.hNH.b(this.hNN);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.hNH != null) {
            if (i == 12005) {
                this.hNH.aMX();
            }
            this.hNH.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.hNH.aLV().aKs();
        this.hNH.aMU();
        this.hNH.aLV().aMf();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hNH.b(writeData);
                this.hNH.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l lX = this.hNH.aLV().lX(6);
                if (lX != null && lX.dss != null) {
                    lX.dss.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hNH.aMQ();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, long j) {
        if (this.hNI != null && this.hNI.getBaijiahaoData() != null && this.hNI.isBjh()) {
            if (this.hNH == null || !this.hNH.isBJH) {
                oh(true);
            }
            if (this.hNH != null && this.hNI != null) {
                if (this.hNI.bYo() && this.hNI.getReplyer() != null) {
                    this.hNH.va(this.hNI.getReplyer().getName_show());
                    return;
                } else {
                    this.hNH.va(null);
                    return;
                }
            }
            return;
        }
        if (this.gpJ == null) {
            this.gpJ = new com.baidu.tieba.frs.profession.permission.c(this.hNo.getPageContext());
            this.gpJ.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lt(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void s(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lu(boolean z) {
                    if (z) {
                        if (m.this.hNH == null || m.this.hNH.isBJH) {
                            m.this.oh(false);
                        }
                        if (m.this.hNH != null && m.this.hNI != null) {
                            if (!m.this.hNI.bYo() || m.this.hNI.getReplyer() == null) {
                                m.this.hNH.va(null);
                            } else {
                                m.this.hNH.va(m.this.hNI.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.gpJ.C(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.hNH != null) {
            this.hNH.onDestory();
        }
        if (this.hNy != null) {
            this.hNy.onDestroy();
        }
        if (this.hNG != null) {
            this.hNG.a((ReplyMeModel.a) null);
            this.hNG.onDestroy();
        }
        if (this.hNy != null) {
            this.hNy.a((aj.a) null);
        }
    }

    public void e(s sVar) {
        if (this.hNu != null) {
            this.hNu.e(sVar);
        }
    }
}
