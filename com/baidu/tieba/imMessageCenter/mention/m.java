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
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tbadk.coreExtra.data.y;
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
/* loaded from: classes6.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView Bn;
    private BdSwipeRefreshLayout eiv;
    private final g.c emI;
    private com.baidu.tieba.frs.profession.permission.c gmA;
    private NavigationBarShadowView hIX;
    private final ReplyMessageFragment hJL;
    private PbListView hJQ;
    private com.baidu.tieba.imMessageCenter.mention.base.e hJR;
    private com.baidu.tieba.imMessageCenter.mention.base.f hJS;
    private com.baidu.tieba.imMessageCenter.mention.base.f hJT;
    private boolean hJU;
    private aj hJV;
    private AttentionHostData hJW;
    private int hJX;
    private int hJY;
    private int hJZ;
    private BdListView.b hKa;
    private View.OnClickListener hKb;
    private RecyclerView.OnScrollListener hKc;
    private ReplyMeModel hKd;
    private com.baidu.tbadk.editortools.pb.h hKe;
    private com.baidu.tieba.imMessageCenter.mention.base.a hKf;
    private String hKg;
    private long hKh;
    private long hKi;
    private DataModel<MessageCenterActivity> hKj;
    private NewWriteModel.d hKk;
    private final ReplyMeModel.a hKl;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.hJX = 0;
        this.hJY = 0;
        this.hJZ = R.color.cp_bg_line_c;
        this.hKa = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.hJS.getView()) {
                    if (view == m.this.hJT.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aIf();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aHP().lw(0);
                        m.this.hJY = 0;
                        m.this.wT(m.this.hJY);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().aIe();
                com.baidu.tbadk.coreExtra.messageCenter.b.aHP().setMsgAtme(0);
                m.this.hJX = 0;
                m.this.wS(m.this.hJX);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.hKb = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hJQ != null && m.this.hJL != null) {
                    m.this.hJQ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hJQ.setOnClickListener(null);
                    m.this.hJQ.startLoadData();
                    m.this.hJL.bra();
                }
            }
        };
        this.emI = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.hJL != null) {
                        m.this.hJL.bDT();
                    }
                } else if (m.this.eiv != null) {
                    m.this.eiv.setRefreshing(false);
                }
            }
        };
        this.hKc = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.hIX.show();
                            return;
                        } else {
                            m.this.hIX.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.hIX.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.hKd = null;
        this.hKl = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.hKg = str;
                m.this.hKh = j2;
                m.this.hKi = j3;
                m.this.H(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.hKe != null) {
                    m.this.hKe.aMB();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 7));
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.hJL = replyMessageFragment;
        this.hJV = new aj(replyMessageFragment.getPageContext());
        this.hJV.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.aj.a
            public void j(boolean z, int i) {
                if (z && m.this.hKe != null) {
                    m.this.hKe.aMx();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Bn != null) {
            nU(false);
            if (z) {
                this.hJQ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hJQ.endLoadData();
                this.hJQ.setOnClickListener(this.hKb);
            } else {
                this.hJQ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hJQ.endLoadData();
                this.hJQ.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.hJQ.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.cr(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hJU) {
                    this.hJU = true;
                    this.Bn.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Bn.setNextPage(null);
                if (arrayList != null) {
                    this.hJR.setData(arrayList);
                }
                this.hJZ = R.color.cp_bg_line_e;
            } else {
                this.Bn.removeHeaderView(this.mNoDataView);
                this.hJU = false;
                if (this.hJR != null) {
                    this.hJR.setData(arrayList);
                    this.hJR.notifyDataSetChanged();
                }
                this.Bn.setNextPage(this.hJQ);
                this.hJZ = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.hJR != null) {
            this.hJR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bv(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.hIX = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.hJL.getPageContext());
            this.mPullView.setListPullRefreshListener(this.emI);
        }
        this.mPullView.setTag(this.hJL.getUniqueId());
        if (this.hJQ == null) {
            this.hJQ = new PbListView(this.hJL.getContext());
            this.hJQ.getView();
        }
        this.hJQ.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.hJQ.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hJL.getContext(), R.dimen.tbds182));
        this.hJQ.setLineGone();
        this.hJQ.setTextSize(R.dimen.tbfontsize33);
        this.hJQ.setTextColor(am.getColor(R.color.cp_cont_d));
        this.hJQ.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hJQ.setOnClickListener(this.hKb);
        this.eiv = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.eiv.setProgressView(this.mPullView);
        this.Bn = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.hJR = new com.baidu.tieba.imMessageCenter.mention.base.e(this.hJL.getPageContext(), this.Bn);
        this.hJR.setOnCardSubClickListener(new z() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.nW(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.hKf = aVar;
                        if (aVar.bXf()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.bXg(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.hJW == null) {
                            m.this.hJW = new AttentionHostData();
                        }
                        if (m.this.hKf != null) {
                            m.this.hJW.parserWithMetaData(m.this.hKf.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.hKf != null) {
                            baijiahaoData = m.this.hKf.getBaijiahaoData();
                        }
                        m.this.hKd.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.bXh() != null) {
                            an Z = new an(aVar.bXh()).Z("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.hKK) {
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
        ((DefaultItemAnimator) this.Bn.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Bn.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Bn.setFadingEdgeLength(0);
        this.Bn.setOverScrollMode(2);
        this.Bn.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Bn.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Bn.setNextPage(this.hJQ);
        this.Bn.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.hJQ != null) {
                    m.this.hJQ.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hJQ.setOnClickListener(null);
                    m.this.hJQ.showLoading();
                    m.this.hJL.bra();
                }
            }
        });
        this.Bn.setOnScrollListener(this.mScrollListener);
        this.Bn.addOnScrollListener(this.hKc);
        bXb();
        this.hKd = new ReplyMeModel(this.hJL.getPageContext());
        this.hKd.a(this.hKl);
        bXd();
        nV(false);
        return this.mRootView;
    }

    private void bXb() {
        this.hJS = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hJL.getPageContext());
        this.hJT = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hJL.getPageContext());
        this.hJS.bb(this.hJL.getString(R.string.at_me), R.drawable.icon_im_at);
        wS(this.hJX);
        this.hJT.bb(this.hJL.getString(R.string.agree_me), R.drawable.icon_im_laud);
        wT(this.hJY);
        this.Bn.addHeaderView(this.hJS.getView());
        this.Bn.addHeaderView(this.hJT.getView());
        this.Bn.setOnHeaderClickListener(this.hKa);
    }

    public void onChangeSkinType(int i) {
        if (this.hKe != null && this.hKe.aLC() != null) {
            this.hKe.aLC().onChangeSkinType(i);
        }
        if (this.hJQ != null) {
            this.hJQ.setTextColor(am.getColor(R.color.cp_cont_d));
            this.hJQ.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.hJS != null) {
            this.hJS.bEM();
        }
        if (this.hJT != null) {
            this.hJT.bEM();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.Bn, this.hJZ);
        am.setBackgroundColor(this.eiv, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.hKe == null || this.hKe.aLC() == null || this.hKe.aLC().getVisibility() != 0) {
            return false;
        }
        this.hKe.aMB();
        return true;
    }

    public void nU(boolean z) {
        if (this.eiv != null) {
            if (z && this.Bn != null && this.Bn.getFirstVisiblePosition() != 0) {
                this.Bn.setSelection(0);
            }
            this.eiv.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.hJX = newsNotifyMessage.getMsgAtme();
            this.hJY = newsNotifyMessage.getMsgAgree();
            wS(this.hJX);
            wT(this.hJY);
        }
    }

    public void bXc() {
        wS(this.hJX);
        wT(this.hJY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wS(int i) {
        if (this.hJS != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIB()) {
                z = true;
            }
            this.hJS.M(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wT(int i) {
        if (this.hJT != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aIw().aIN()) {
                z = true;
            }
            this.hJT.M(i, z);
        }
    }

    private void bXd() {
        this.hKj = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.hJL.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aLW() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData uM(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.hKg);
                writeData.setThreadId(m.this.hKf.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.hKf.bXf()) {
                    writeData.setFloor(m.this.hKh > 0 ? String.valueOf(m.this.hKh) : m.this.hKf.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.hKf.getPost_id());
                }
                if (m.this.hKi > 0) {
                    writeData.setRepostId(String.valueOf(m.this.hKi));
                }
                if (m.this.hKf != null) {
                    writeData.setBaijiahaoData(m.this.hKf.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aLX() {
                return null;
            }
        };
        this.hKk = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (m.this.hJL.getBaseFragmentActivity() != null) {
                    m.this.hJL.getBaseFragmentActivity().hideProgressBar();
                    m.this.hKe.aLC().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.hJV.a(m.this.hJW);
                        m.this.hJV.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && yVar == null && !AntiHelper.aW(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.hJL.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nV(boolean z) {
        if (this.hKe != null && this.hKe.aLC() != null && this.hKe.aLC().getParent() != null) {
            ((ViewGroup) this.hKe.aLC().getParent()).removeView(this.hKe.aLC());
        }
        this.hKe = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dR(this.hJL.getPageContext().getPageActivity());
        this.hKe.a(this.hJL.getPageContext());
        this.hKe.b(this.hKj);
        this.hKe.g(this.hJL.getPageContext());
        this.hKe.aLC().gp(true);
        this.hKe.aLC().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hKe.aLC() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.hKe.aLC(), layoutParams);
            this.hKe.aLC().hide();
        }
        this.hKe.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void aMa() {
                if (m.this.hJL.getBaseFragmentActivity() != null) {
                    m.this.hJL.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.hKe.b(this.hKk);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.hKe != null) {
            if (i == 12005) {
                this.hKe.aME();
            }
            this.hKe.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.hKe.aLC().aJZ();
        this.hKe.aMB();
        this.hKe.aLC().aLM();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hKe.b(writeData);
                this.hKe.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l lX = this.hKe.aLC().lX(6);
                if (lX != null && lX.dsh != null) {
                    lX.dsh.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hKe.aMx();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, long j) {
        if (this.hKf != null && this.hKf.getBaijiahaoData() != null && this.hKf.isBjh()) {
            if (this.hKe == null || !this.hKe.isBJH) {
                nV(true);
            }
            if (this.hKe != null && this.hKf != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 8));
                if (this.hKf.bXf() && this.hKf.getReplyer() != null) {
                    this.hKe.uV(this.hKf.getReplyer().getName_show());
                    return;
                } else {
                    this.hKe.uV(null);
                    return;
                }
            }
            return;
        }
        if (this.gmA == null) {
            this.gmA = new com.baidu.tieba.frs.profession.permission.c(this.hJL.getPageContext());
            this.gmA.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void li(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void r(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lj(boolean z) {
                    if (z) {
                        if (m.this.hKe == null || m.this.hKe.isBJH) {
                            m.this.nV(false);
                        }
                        if (m.this.hKe != null && m.this.hKf != null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921382, 8));
                            if (!m.this.hKf.bXf() || m.this.hKf.getReplyer() == null) {
                                m.this.hKe.uV(null);
                            } else {
                                m.this.hKe.uV(m.this.hKf.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.gmA.B(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.hKe != null) {
            this.hKe.onDestory();
        }
        if (this.hJV != null) {
            this.hJV.onDestroy();
        }
        if (this.hKd != null) {
            this.hKd.a((ReplyMeModel.a) null);
            this.hKd.onDestroy();
        }
        if (this.hJV != null) {
            this.hJV.a((aj.a) null);
        }
    }

    public void e(s sVar) {
        if (this.hJR != null) {
            this.hJR.e(sVar);
        }
    }
}
