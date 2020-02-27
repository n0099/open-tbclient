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
import com.baidu.tbadk.coreExtra.data.aa;
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
/* loaded from: classes9.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView BK;
    private BdSwipeRefreshLayout ens;
    private final g.c erT;
    private com.baidu.tieba.frs.profession.permission.c grK;
    private NavigationBarShadowView hOy;
    private int hPA;
    private BdListView.b hPB;
    private View.OnClickListener hPC;
    private RecyclerView.OnScrollListener hPD;
    private ReplyMeModel hPE;
    private com.baidu.tbadk.editortools.pb.h hPF;
    private com.baidu.tieba.imMessageCenter.mention.base.a hPG;
    private String hPH;
    private long hPI;
    private long hPJ;
    private DataModel<MessageCenterActivity> hPK;
    private NewWriteModel.d hPL;
    private final ReplyMeModel.a hPM;
    private final ReplyMessageFragment hPm;
    private PbListView hPr;
    private com.baidu.tieba.imMessageCenter.mention.base.e hPs;
    private com.baidu.tieba.imMessageCenter.mention.base.f hPt;
    private com.baidu.tieba.imMessageCenter.mention.base.f hPu;
    private boolean hPv;
    private aj hPw;
    private AttentionHostData hPx;
    private int hPy;
    private int hPz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.hPy = 0;
        this.hPz = 0;
        this.hPA = R.color.cp_bg_line_c;
        this.hPB = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.hPt.getView()) {
                    if (view == m.this.hPu.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKS();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKC().lN(0);
                        m.this.hPz = 0;
                        m.this.xe(m.this.hPz);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aKC().aKR();
                com.baidu.tbadk.coreExtra.messageCenter.b.aKC().setMsgAtme(0);
                m.this.hPy = 0;
                m.this.xd(m.this.hPy);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.hPC = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hPr != null && m.this.hPm != null) {
                    m.this.hPr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hPr.setOnClickListener(null);
                    m.this.hPr.startLoadData();
                    m.this.hPm.btG();
                }
            }
        };
        this.erT = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.hPm != null) {
                        m.this.hPm.bGx();
                    }
                } else if (m.this.ens != null) {
                    m.this.ens.setRefreshing(false);
                }
            }
        };
        this.hPD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.hOy.show();
                            return;
                        } else {
                            m.this.hOy.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.hOy.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.hPE = null;
        this.hPM = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.hPH = str;
                m.this.hPI = j2;
                m.this.hPJ = j3;
                m.this.I(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.hPF != null) {
                    m.this.hPF.aPq();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.hPm = replyMessageFragment;
        this.hPw = new aj(replyMessageFragment.getPageContext());
        this.hPw.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z && m.this.hPF != null) {
                    m.this.hPF.aPm();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.BK != null) {
            oi(false);
            if (z) {
                this.hPr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hPr.endLoadData();
                this.hPr.setOnClickListener(this.hPC);
            } else {
                this.hPr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hPr.endLoadData();
                this.hPr.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.hPr.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.cA(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hPv) {
                    this.hPv = true;
                    this.BK.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.BK.setNextPage(null);
                if (arrayList != null) {
                    this.hPs.setData(arrayList);
                }
                this.hPA = R.color.cp_bg_line_e;
            } else {
                this.BK.removeHeaderView(this.mNoDataView);
                this.hPv = false;
                if (this.hPs != null) {
                    this.hPs.setData(arrayList);
                    this.hPs.notifyDataSetChanged();
                }
                this.BK.setNextPage(this.hPr);
                this.hPA = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.hPs != null) {
            this.hPs.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bz(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.hOy = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.hPm.getPageContext());
            this.mPullView.setListPullRefreshListener(this.erT);
        }
        this.mPullView.setTag(this.hPm.getUniqueId());
        if (this.hPr == null) {
            this.hPr = new PbListView(this.hPm.getContext());
            this.hPr.getView();
        }
        this.hPr.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.hPr.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hPm.getContext(), R.dimen.tbds182));
        this.hPr.setLineGone();
        this.hPr.setTextSize(R.dimen.tbfontsize33);
        this.hPr.setTextColor(am.getColor(R.color.cp_cont_d));
        this.hPr.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hPr.setOnClickListener(this.hPC);
        this.ens = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.ens.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.hPs = new com.baidu.tieba.imMessageCenter.mention.base.e(this.hPm.getPageContext(), this.BK);
        this.hPs.setOnCardSubClickListener(new z() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.ok(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.hPG = aVar;
                        if (aVar.bZP()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.bZQ(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.hPx == null) {
                            m.this.hPx = new AttentionHostData();
                        }
                        if (m.this.hPG != null) {
                            m.this.hPx.parserWithMetaData(m.this.hPG.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.hPG != null) {
                            baijiahaoData = m.this.hPG.getBaijiahaoData();
                        }
                        m.this.hPE.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.bZR() != null) {
                            an X = new an(aVar.bZR()).X("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.hQl) {
                                X.X("obj_type", 1);
                            } else {
                                X.X("obj_type", 2);
                            }
                            TiebaStatic.log(X);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.BK.getItemAnimator()).setSupportsChangeAnimations(false);
        this.BK.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.BK.setFadingEdgeLength(0);
        this.BK.setOverScrollMode(2);
        this.BK.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.BK.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.BK.setNextPage(this.hPr);
        this.BK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.hPr != null) {
                    m.this.hPr.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hPr.setOnClickListener(null);
                    m.this.hPr.showLoading();
                    m.this.hPm.btG();
                }
            }
        });
        this.BK.setOnScrollListener(this.mScrollListener);
        this.BK.addOnScrollListener(this.hPD);
        bZL();
        this.hPE = new ReplyMeModel(this.hPm.getPageContext());
        this.hPE.a(this.hPM);
        bZN();
        oj(false);
        return this.mRootView;
    }

    private void bZL() {
        this.hPt = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hPm.getPageContext());
        this.hPu = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hPm.getPageContext());
        this.hPt.ba(this.hPm.getString(R.string.at_me), R.drawable.icon_im_at);
        xd(this.hPy);
        this.hPu.ba(this.hPm.getString(R.string.agree_me), R.drawable.icon_im_laud);
        xe(this.hPz);
        this.BK.addHeaderView(this.hPt.getView());
        this.BK.addHeaderView(this.hPu.getView());
        this.BK.setOnHeaderClickListener(this.hPB);
    }

    public void onChangeSkinType(int i) {
        if (this.hPF != null && this.hPF.aOr() != null) {
            this.hPF.aOr().onChangeSkinType(i);
        }
        if (this.hPr != null) {
            this.hPr.setTextColor(am.getColor(R.color.cp_cont_d));
            this.hPr.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.hPt != null) {
            this.hPt.bHq();
        }
        if (this.hPu != null) {
            this.hPu.bHq();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.BK, this.hPA);
        am.setBackgroundColor(this.ens, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.hPF == null || this.hPF.aOr() == null || this.hPF.aOr().getVisibility() != 0) {
            return false;
        }
        this.hPF.aPq();
        return true;
    }

    public void oi(boolean z) {
        if (this.ens != null) {
            if (z && this.BK != null && this.BK.getFirstVisiblePosition() != 0) {
                this.BK.setSelection(0);
            }
            this.ens.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.hPy = newsNotifyMessage.getMsgAtme();
            this.hPz = newsNotifyMessage.getMsgAgree();
            xd(this.hPy);
            xe(this.hPz);
        }
    }

    public void bZM() {
        xd(this.hPy);
        xe(this.hPz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(int i) {
        if (this.hPt != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLo()) {
                z = true;
            }
            this.hPt.L(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe(int i) {
        if (this.hPu != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aLj().aLA()) {
                z = true;
            }
            this.hPu.L(i, z);
        }
    }

    private void bZN() {
        this.hPK = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.hPm.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aOL() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData vi(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.hPH);
                writeData.setThreadId(m.this.hPG.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.hPG.bZP()) {
                    writeData.setFloor(m.this.hPI > 0 ? String.valueOf(m.this.hPI) : m.this.hPG.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.hPG.getPost_id());
                }
                if (m.this.hPJ > 0) {
                    writeData.setRepostId(String.valueOf(m.this.hPJ));
                }
                if (m.this.hPG != null) {
                    writeData.setBaijiahaoData(m.this.hPG.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aOM() {
                return null;
            }
        };
        this.hPL = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (m.this.hPm.getBaseFragmentActivity() != null) {
                    m.this.hPm.getBaseFragmentActivity().hideProgressBar();
                    m.this.hPF.aOr().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.hPw.a(m.this.hPx);
                        m.this.hPw.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && aaVar == null && !AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.hPm.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        if (this.hPF != null && this.hPF.aOr() != null && this.hPF.aOr().getParent() != null) {
            ((ViewGroup) this.hPF.aOr().getParent()).removeView(this.hPF.aOr());
        }
        this.hPF = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dV(this.hPm.getPageContext().getPageActivity());
        this.hPF.a(this.hPm.getPageContext());
        this.hPF.b(this.hPK);
        this.hPF.g(this.hPm.getPageContext());
        this.hPF.aOr().gB(true);
        this.hPF.aOr().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hPF.aOr() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.hPF.aOr(), layoutParams);
            this.hPF.aOr().hide();
        }
        this.hPF.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void aOP() {
                if (m.this.hPm.getBaseFragmentActivity() != null) {
                    m.this.hPm.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.hPF.b(this.hPL);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.hPF != null) {
            if (i == 12005) {
                this.hPF.aPt();
            }
            this.hPF.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.hPF.aOr().aMO();
        this.hPF.aPq();
        this.hPF.aOr().aOB();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hPF.b(writeData);
                this.hPF.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mp = this.hPF.aOr().mp(6);
                if (mp != null && mp.dwz != null) {
                    mp.dwz.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hPF.aPm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, long j) {
        if (this.hPG != null && this.hPG.getBaijiahaoData() != null && this.hPG.isBjh()) {
            if (this.hPF == null || !this.hPF.isBJH) {
                oj(true);
            }
            if (this.hPF != null && this.hPG != null) {
                if (this.hPG.bZP() && this.hPG.getReplyer() != null) {
                    this.hPF.vr(this.hPG.getReplyer().getName_show());
                    return;
                } else {
                    this.hPF.vr(null);
                    return;
                }
            }
            return;
        }
        if (this.grK == null) {
            this.grK = new com.baidu.tieba.frs.profession.permission.c(this.hPm.getPageContext());
            this.grK.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lw(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void t(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lx(boolean z) {
                    if (z) {
                        if (m.this.hPF == null || m.this.hPF.isBJH) {
                            m.this.oj(false);
                        }
                        if (m.this.hPF != null && m.this.hPG != null) {
                            if (!m.this.hPG.bZP() || m.this.hPG.getReplyer() == null) {
                                m.this.hPF.vr(null);
                            } else {
                                m.this.hPF.vr(m.this.hPG.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.grK.C(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.hPF != null) {
            this.hPF.onDestory();
        }
        if (this.hPw != null) {
            this.hPw.onDestroy();
        }
        if (this.hPE != null) {
            this.hPE.a((ReplyMeModel.a) null);
            this.hPE.onDestroy();
        }
        if (this.hPw != null) {
            this.hPw.a((aj.a) null);
        }
    }

    public void e(s sVar) {
        if (this.hPs != null) {
            this.hPs.e(sVar);
        }
    }
}
