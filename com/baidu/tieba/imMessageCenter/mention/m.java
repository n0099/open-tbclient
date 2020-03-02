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
    private BdSwipeRefreshLayout ent;
    private final g.c erU;
    private com.baidu.tieba.frs.profession.permission.c grM;
    private NavigationBarShadowView hOA;
    private int hPA;
    private int hPB;
    private int hPC;
    private BdListView.b hPD;
    private View.OnClickListener hPE;
    private RecyclerView.OnScrollListener hPF;
    private ReplyMeModel hPG;
    private com.baidu.tbadk.editortools.pb.h hPH;
    private com.baidu.tieba.imMessageCenter.mention.base.a hPI;
    private String hPJ;
    private long hPK;
    private long hPL;
    private DataModel<MessageCenterActivity> hPM;
    private NewWriteModel.d hPN;
    private final ReplyMeModel.a hPO;
    private final ReplyMessageFragment hPo;
    private PbListView hPt;
    private com.baidu.tieba.imMessageCenter.mention.base.e hPu;
    private com.baidu.tieba.imMessageCenter.mention.base.f hPv;
    private com.baidu.tieba.imMessageCenter.mention.base.f hPw;
    private boolean hPx;
    private aj hPy;
    private AttentionHostData hPz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.hPA = 0;
        this.hPB = 0;
        this.hPC = R.color.cp_bg_line_c;
        this.hPD = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.hPv.getView()) {
                    if (view == m.this.hPw.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aKU();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKE().lN(0);
                        m.this.hPB = 0;
                        m.this.xe(m.this.hPB);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().aKT();
                com.baidu.tbadk.coreExtra.messageCenter.b.aKE().setMsgAtme(0);
                m.this.hPA = 0;
                m.this.xd(m.this.hPA);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.hPE = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hPt != null && m.this.hPo != null) {
                    m.this.hPt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hPt.setOnClickListener(null);
                    m.this.hPt.startLoadData();
                    m.this.hPo.btI();
                }
            }
        };
        this.erU = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.hPo != null) {
                        m.this.hPo.bGz();
                    }
                } else if (m.this.ent != null) {
                    m.this.ent.setRefreshing(false);
                }
            }
        };
        this.hPF = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.hOA.show();
                            return;
                        } else {
                            m.this.hOA.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.hOA.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.hPG = null;
        this.hPO = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.hPJ = str;
                m.this.hPK = j2;
                m.this.hPL = j3;
                m.this.I(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.hPH != null) {
                    m.this.hPH.aPs();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.hPo = replyMessageFragment;
        this.hPy = new aj(replyMessageFragment.getPageContext());
        this.hPy.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z && m.this.hPH != null) {
                    m.this.hPH.aPo();
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
                this.hPt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hPt.endLoadData();
                this.hPt.setOnClickListener(this.hPE);
            } else {
                this.hPt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hPt.endLoadData();
                this.hPt.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.hPt.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.cA(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hPx) {
                    this.hPx = true;
                    this.BK.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.BK.setNextPage(null);
                if (arrayList != null) {
                    this.hPu.setData(arrayList);
                }
                this.hPC = R.color.cp_bg_line_e;
            } else {
                this.BK.removeHeaderView(this.mNoDataView);
                this.hPx = false;
                if (this.hPu != null) {
                    this.hPu.setData(arrayList);
                    this.hPu.notifyDataSetChanged();
                }
                this.BK.setNextPage(this.hPt);
                this.hPC = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.hPu != null) {
            this.hPu.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bz(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.hOA = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.hPo.getPageContext());
            this.mPullView.setListPullRefreshListener(this.erU);
        }
        this.mPullView.setTag(this.hPo.getUniqueId());
        if (this.hPt == null) {
            this.hPt = new PbListView(this.hPo.getContext());
            this.hPt.getView();
        }
        this.hPt.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.hPt.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hPo.getContext(), R.dimen.tbds182));
        this.hPt.setLineGone();
        this.hPt.setTextSize(R.dimen.tbfontsize33);
        this.hPt.setTextColor(am.getColor(R.color.cp_cont_d));
        this.hPt.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hPt.setOnClickListener(this.hPE);
        this.ent = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.ent.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.hPu = new com.baidu.tieba.imMessageCenter.mention.base.e(this.hPo.getPageContext(), this.BK);
        this.hPu.setOnCardSubClickListener(new z() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.hPI = aVar;
                        if (aVar.bZR()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.bZS(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.hPz == null) {
                            m.this.hPz = new AttentionHostData();
                        }
                        if (m.this.hPI != null) {
                            m.this.hPz.parserWithMetaData(m.this.hPI.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.hPI != null) {
                            baijiahaoData = m.this.hPI.getBaijiahaoData();
                        }
                        m.this.hPG.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.bZT() != null) {
                            an X = new an(aVar.bZT()).X("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.hQn) {
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
        this.BK.setNextPage(this.hPt);
        this.BK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.hPt != null) {
                    m.this.hPt.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hPt.setOnClickListener(null);
                    m.this.hPt.showLoading();
                    m.this.hPo.btI();
                }
            }
        });
        this.BK.setOnScrollListener(this.mScrollListener);
        this.BK.addOnScrollListener(this.hPF);
        bZN();
        this.hPG = new ReplyMeModel(this.hPo.getPageContext());
        this.hPG.a(this.hPO);
        bZP();
        oj(false);
        return this.mRootView;
    }

    private void bZN() {
        this.hPv = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hPo.getPageContext());
        this.hPw = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hPo.getPageContext());
        this.hPv.ba(this.hPo.getString(R.string.at_me), R.drawable.icon_im_at);
        xd(this.hPA);
        this.hPw.ba(this.hPo.getString(R.string.agree_me), R.drawable.icon_im_laud);
        xe(this.hPB);
        this.BK.addHeaderView(this.hPv.getView());
        this.BK.addHeaderView(this.hPw.getView());
        this.BK.setOnHeaderClickListener(this.hPD);
    }

    public void onChangeSkinType(int i) {
        if (this.hPH != null && this.hPH.aOt() != null) {
            this.hPH.aOt().onChangeSkinType(i);
        }
        if (this.hPt != null) {
            this.hPt.setTextColor(am.getColor(R.color.cp_cont_d));
            this.hPt.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.hPv != null) {
            this.hPv.bHs();
        }
        if (this.hPw != null) {
            this.hPw.bHs();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.BK, this.hPC);
        am.setBackgroundColor(this.ent, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.hPH == null || this.hPH.aOt() == null || this.hPH.aOt().getVisibility() != 0) {
            return false;
        }
        this.hPH.aPs();
        return true;
    }

    public void oi(boolean z) {
        if (this.ent != null) {
            if (z && this.BK != null && this.BK.getFirstVisiblePosition() != 0) {
                this.BK.setSelection(0);
            }
            this.ent.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.hPA = newsNotifyMessage.getMsgAtme();
            this.hPB = newsNotifyMessage.getMsgAgree();
            xd(this.hPA);
            xe(this.hPB);
        }
    }

    public void bZO() {
        xd(this.hPA);
        xe(this.hPB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(int i) {
        if (this.hPv != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLq()) {
                z = true;
            }
            this.hPv.L(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe(int i) {
        if (this.hPw != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aLl().aLC()) {
                z = true;
            }
            this.hPw.L(i, z);
        }
    }

    private void bZP() {
        this.hPM = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.hPo.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aON() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData vi(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.hPJ);
                writeData.setThreadId(m.this.hPI.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.hPI.bZR()) {
                    writeData.setFloor(m.this.hPK > 0 ? String.valueOf(m.this.hPK) : m.this.hPI.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.hPI.getPost_id());
                }
                if (m.this.hPL > 0) {
                    writeData.setRepostId(String.valueOf(m.this.hPL));
                }
                if (m.this.hPI != null) {
                    writeData.setBaijiahaoData(m.this.hPI.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aOO() {
                return null;
            }
        };
        this.hPN = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (m.this.hPo.getBaseFragmentActivity() != null) {
                    m.this.hPo.getBaseFragmentActivity().hideProgressBar();
                    m.this.hPH.aOt().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.hPy.a(m.this.hPz);
                        m.this.hPy.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && aaVar == null && !AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.hPo.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        if (this.hPH != null && this.hPH.aOt() != null && this.hPH.aOt().getParent() != null) {
            ((ViewGroup) this.hPH.aOt().getParent()).removeView(this.hPH.aOt());
        }
        this.hPH = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dV(this.hPo.getPageContext().getPageActivity());
        this.hPH.a(this.hPo.getPageContext());
        this.hPH.b(this.hPM);
        this.hPH.g(this.hPo.getPageContext());
        this.hPH.aOt().gB(true);
        this.hPH.aOt().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hPH.aOt() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.hPH.aOt(), layoutParams);
            this.hPH.aOt().hide();
        }
        this.hPH.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void aOR() {
                if (m.this.hPo.getBaseFragmentActivity() != null) {
                    m.this.hPo.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.hPH.b(this.hPN);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.hPH != null) {
            if (i == 12005) {
                this.hPH.aPv();
            }
            this.hPH.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.hPH.aOt().aMQ();
        this.hPH.aPs();
        this.hPH.aOt().aOD();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hPH.b(writeData);
                this.hPH.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mp = this.hPH.aOt().mp(6);
                if (mp != null && mp.dwA != null) {
                    mp.dwA.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hPH.aPo();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, long j) {
        if (this.hPI != null && this.hPI.getBaijiahaoData() != null && this.hPI.isBjh()) {
            if (this.hPH == null || !this.hPH.isBJH) {
                oj(true);
            }
            if (this.hPH != null && this.hPI != null) {
                if (this.hPI.bZR() && this.hPI.getReplyer() != null) {
                    this.hPH.vr(this.hPI.getReplyer().getName_show());
                    return;
                } else {
                    this.hPH.vr(null);
                    return;
                }
            }
            return;
        }
        if (this.grM == null) {
            this.grM = new com.baidu.tieba.frs.profession.permission.c(this.hPo.getPageContext());
            this.grM.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lw(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void t(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lx(boolean z) {
                    if (z) {
                        if (m.this.hPH == null || m.this.hPH.isBJH) {
                            m.this.oj(false);
                        }
                        if (m.this.hPH != null && m.this.hPI != null) {
                            if (!m.this.hPI.bZR() || m.this.hPI.getReplyer() == null) {
                                m.this.hPH.vr(null);
                            } else {
                                m.this.hPH.vr(m.this.hPI.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.grM.C(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.hPH != null) {
            this.hPH.onDestory();
        }
        if (this.hPy != null) {
            this.hPy.onDestroy();
        }
        if (this.hPG != null) {
            this.hPG.a((ReplyMeModel.a) null);
            this.hPG.onDestroy();
        }
        if (this.hPy != null) {
            this.hPy.a((aj.a) null);
        }
    }

    public void e(s sVar) {
        if (this.hPu != null) {
            this.hPu.e(sVar);
        }
    }
}
