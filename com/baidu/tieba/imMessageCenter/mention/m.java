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
    private BdSwipeRefreshLayout enH;
    private final g.c esh;
    private com.baidu.tieba.frs.profession.permission.c grZ;
    private NavigationBarShadowView hOM;
    private final ReplyMessageFragment hPA;
    private PbListView hPF;
    private com.baidu.tieba.imMessageCenter.mention.base.e hPG;
    private com.baidu.tieba.imMessageCenter.mention.base.f hPH;
    private com.baidu.tieba.imMessageCenter.mention.base.f hPI;
    private boolean hPJ;
    private aj hPK;
    private AttentionHostData hPL;
    private int hPM;
    private int hPN;
    private int hPO;
    private BdListView.b hPP;
    private View.OnClickListener hPQ;
    private RecyclerView.OnScrollListener hPR;
    private ReplyMeModel hPS;
    private com.baidu.tbadk.editortools.pb.h hPT;
    private com.baidu.tieba.imMessageCenter.mention.base.a hPU;
    private String hPV;
    private long hPW;
    private long hPX;
    private DataModel<MessageCenterActivity> hPY;
    private NewWriteModel.d hPZ;
    private final ReplyMeModel.a hQa;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.hPM = 0;
        this.hPN = 0;
        this.hPO = R.color.cp_bg_line_c;
        this.hPP = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.hPH.getView()) {
                    if (view == m.this.hPI.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aKV();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKF().lN(0);
                        m.this.hPN = 0;
                        m.this.xe(m.this.hPN);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aKF().aKU();
                com.baidu.tbadk.coreExtra.messageCenter.b.aKF().setMsgAtme(0);
                m.this.hPM = 0;
                m.this.xd(m.this.hPM);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.hPQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hPF != null && m.this.hPA != null) {
                    m.this.hPF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hPF.setOnClickListener(null);
                    m.this.hPF.startLoadData();
                    m.this.hPA.btJ();
                }
            }
        };
        this.esh = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.hPA != null) {
                        m.this.hPA.bGA();
                    }
                } else if (m.this.enH != null) {
                    m.this.enH.setRefreshing(false);
                }
            }
        };
        this.hPR = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.hOM.show();
                            return;
                        } else {
                            m.this.hOM.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.hOM.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.hPS = null;
        this.hQa = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.hPV = str;
                m.this.hPW = j2;
                m.this.hPX = j3;
                m.this.I(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.hPT != null) {
                    m.this.hPT.aPt();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.hPA = replyMessageFragment;
        this.hPK = new aj(replyMessageFragment.getPageContext());
        this.hPK.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z && m.this.hPT != null) {
                    m.this.hPT.aPp();
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
                this.hPF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hPF.endLoadData();
                this.hPF.setOnClickListener(this.hPQ);
            } else {
                this.hPF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hPF.endLoadData();
                this.hPF.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.hPF.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.cA(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hPJ) {
                    this.hPJ = true;
                    this.BK.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.BK.setNextPage(null);
                if (arrayList != null) {
                    this.hPG.setData(arrayList);
                }
                this.hPO = R.color.cp_bg_line_e;
            } else {
                this.BK.removeHeaderView(this.mNoDataView);
                this.hPJ = false;
                if (this.hPG != null) {
                    this.hPG.setData(arrayList);
                    this.hPG.notifyDataSetChanged();
                }
                this.BK.setNextPage(this.hPF);
                this.hPO = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.hPG != null) {
            this.hPG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bz(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.hOM = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.hPA.getPageContext());
            this.mPullView.setListPullRefreshListener(this.esh);
        }
        this.mPullView.setTag(this.hPA.getUniqueId());
        if (this.hPF == null) {
            this.hPF = new PbListView(this.hPA.getContext());
            this.hPF.getView();
        }
        this.hPF.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.hPF.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hPA.getContext(), R.dimen.tbds182));
        this.hPF.setLineGone();
        this.hPF.setTextSize(R.dimen.tbfontsize33);
        this.hPF.setTextColor(am.getColor(R.color.cp_cont_d));
        this.hPF.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hPF.setOnClickListener(this.hPQ);
        this.enH = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.enH.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.hPG = new com.baidu.tieba.imMessageCenter.mention.base.e(this.hPA.getPageContext(), this.BK);
        this.hPG.setOnCardSubClickListener(new z() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.hPU = aVar;
                        if (aVar.bZS()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.bZT(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.hPL == null) {
                            m.this.hPL = new AttentionHostData();
                        }
                        if (m.this.hPU != null) {
                            m.this.hPL.parserWithMetaData(m.this.hPU.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.hPU != null) {
                            baijiahaoData = m.this.hPU.getBaijiahaoData();
                        }
                        m.this.hPS.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.bZU() != null) {
                            an X = new an(aVar.bZU()).X("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.hQz) {
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
        this.BK.setNextPage(this.hPF);
        this.BK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.hPF != null) {
                    m.this.hPF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hPF.setOnClickListener(null);
                    m.this.hPF.showLoading();
                    m.this.hPA.btJ();
                }
            }
        });
        this.BK.setOnScrollListener(this.mScrollListener);
        this.BK.addOnScrollListener(this.hPR);
        bZO();
        this.hPS = new ReplyMeModel(this.hPA.getPageContext());
        this.hPS.a(this.hQa);
        bZQ();
        oj(false);
        return this.mRootView;
    }

    private void bZO() {
        this.hPH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hPA.getPageContext());
        this.hPI = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hPA.getPageContext());
        this.hPH.ba(this.hPA.getString(R.string.at_me), R.drawable.icon_im_at);
        xd(this.hPM);
        this.hPI.ba(this.hPA.getString(R.string.agree_me), R.drawable.icon_im_laud);
        xe(this.hPN);
        this.BK.addHeaderView(this.hPH.getView());
        this.BK.addHeaderView(this.hPI.getView());
        this.BK.setOnHeaderClickListener(this.hPP);
    }

    public void onChangeSkinType(int i) {
        if (this.hPT != null && this.hPT.aOu() != null) {
            this.hPT.aOu().onChangeSkinType(i);
        }
        if (this.hPF != null) {
            this.hPF.setTextColor(am.getColor(R.color.cp_cont_d));
            this.hPF.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.hPH != null) {
            this.hPH.bHt();
        }
        if (this.hPI != null) {
            this.hPI.bHt();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.BK, this.hPO);
        am.setBackgroundColor(this.enH, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.hPT == null || this.hPT.aOu() == null || this.hPT.aOu().getVisibility() != 0) {
            return false;
        }
        this.hPT.aPt();
        return true;
    }

    public void oi(boolean z) {
        if (this.enH != null) {
            if (z && this.BK != null && this.BK.getFirstVisiblePosition() != 0) {
                this.BK.setSelection(0);
            }
            this.enH.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.hPM = newsNotifyMessage.getMsgAtme();
            this.hPN = newsNotifyMessage.getMsgAgree();
            xd(this.hPM);
            xe(this.hPN);
        }
    }

    public void bZP() {
        xd(this.hPM);
        xe(this.hPN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(int i) {
        if (this.hPH != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLr()) {
                z = true;
            }
            this.hPH.L(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe(int i) {
        if (this.hPI != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aLm().aLD()) {
                z = true;
            }
            this.hPI.L(i, z);
        }
    }

    private void bZQ() {
        this.hPY = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.hPA.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aOO() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData vj(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.hPV);
                writeData.setThreadId(m.this.hPU.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.hPU.bZS()) {
                    writeData.setFloor(m.this.hPW > 0 ? String.valueOf(m.this.hPW) : m.this.hPU.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.hPU.getPost_id());
                }
                if (m.this.hPX > 0) {
                    writeData.setRepostId(String.valueOf(m.this.hPX));
                }
                if (m.this.hPU != null) {
                    writeData.setBaijiahaoData(m.this.hPU.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aOP() {
                return null;
            }
        };
        this.hPZ = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (m.this.hPA.getBaseFragmentActivity() != null) {
                    m.this.hPA.getBaseFragmentActivity().hideProgressBar();
                    m.this.hPT.aOu().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.hPK.a(m.this.hPL);
                        m.this.hPK.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && aaVar == null && !AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.hPA.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        if (this.hPT != null && this.hPT.aOu() != null && this.hPT.aOu().getParent() != null) {
            ((ViewGroup) this.hPT.aOu().getParent()).removeView(this.hPT.aOu());
        }
        this.hPT = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dV(this.hPA.getPageContext().getPageActivity());
        this.hPT.a(this.hPA.getPageContext());
        this.hPT.b(this.hPY);
        this.hPT.g(this.hPA.getPageContext());
        this.hPT.aOu().gB(true);
        this.hPT.aOu().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hPT.aOu() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.hPT.aOu(), layoutParams);
            this.hPT.aOu().hide();
        }
        this.hPT.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void aOS() {
                if (m.this.hPA.getBaseFragmentActivity() != null) {
                    m.this.hPA.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.hPT.b(this.hPZ);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.hPT != null) {
            if (i == 12005) {
                this.hPT.aPw();
            }
            this.hPT.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.hPT.aOu().aMR();
        this.hPT.aPt();
        this.hPT.aOu().aOE();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hPT.b(writeData);
                this.hPT.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mp = this.hPT.aOu().mp(6);
                if (mp != null && mp.dwN != null) {
                    mp.dwN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hPT.aPp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, long j) {
        if (this.hPU != null && this.hPU.getBaijiahaoData() != null && this.hPU.isBjh()) {
            if (this.hPT == null || !this.hPT.isBJH) {
                oj(true);
            }
            if (this.hPT != null && this.hPU != null) {
                if (this.hPU.bZS() && this.hPU.getReplyer() != null) {
                    this.hPT.vs(this.hPU.getReplyer().getName_show());
                    return;
                } else {
                    this.hPT.vs(null);
                    return;
                }
            }
            return;
        }
        if (this.grZ == null) {
            this.grZ = new com.baidu.tieba.frs.profession.permission.c(this.hPA.getPageContext());
            this.grZ.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lw(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void t(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lx(boolean z) {
                    if (z) {
                        if (m.this.hPT == null || m.this.hPT.isBJH) {
                            m.this.oj(false);
                        }
                        if (m.this.hPT != null && m.this.hPU != null) {
                            if (!m.this.hPU.bZS() || m.this.hPU.getReplyer() == null) {
                                m.this.hPT.vs(null);
                            } else {
                                m.this.hPT.vs(m.this.hPU.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.grZ.C(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.hPT != null) {
            this.hPT.onDestory();
        }
        if (this.hPK != null) {
            this.hPK.onDestroy();
        }
        if (this.hPS != null) {
            this.hPS.a((ReplyMeModel.a) null);
            this.hPS.onDestroy();
        }
        if (this.hPK != null) {
            this.hPK.a((aj.a) null);
        }
    }

    public void e(s sVar) {
        if (this.hPG != null) {
            this.hPG.e(sVar);
        }
    }
}
