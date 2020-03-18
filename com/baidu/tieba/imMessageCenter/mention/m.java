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
    private BdSwipeRefreshLayout enY;
    private final g.c esD;
    private com.baidu.tieba.frs.profession.permission.c gsJ;
    private NavigationBarShadowView hQm;
    private final ReplyMeModel.a hRA;
    private final ReplyMessageFragment hRa;
    private PbListView hRf;
    private com.baidu.tieba.imMessageCenter.mention.base.e hRg;
    private com.baidu.tieba.imMessageCenter.mention.base.f hRh;
    private com.baidu.tieba.imMessageCenter.mention.base.f hRi;
    private boolean hRj;
    private aj hRk;
    private AttentionHostData hRl;
    private int hRm;
    private int hRn;
    private int hRo;
    private BdListView.b hRp;
    private View.OnClickListener hRq;
    private RecyclerView.OnScrollListener hRr;
    private ReplyMeModel hRs;
    private com.baidu.tbadk.editortools.pb.h hRt;
    private com.baidu.tieba.imMessageCenter.mention.base.a hRu;
    private String hRv;
    private long hRw;
    private long hRx;
    private DataModel<MessageCenterActivity> hRy;
    private NewWriteModel.d hRz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.hRm = 0;
        this.hRn = 0;
        this.hRo = R.color.cp_bg_line_c;
        this.hRp = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.hRh.getView()) {
                    if (view == m.this.hRi.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aKZ();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().lP(0);
                        m.this.hRn = 0;
                        m.this.xm(m.this.hRn);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().aKY();
                com.baidu.tbadk.coreExtra.messageCenter.b.aKJ().setMsgAtme(0);
                m.this.hRm = 0;
                m.this.xl(m.this.hRm);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.hRq = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.hRf != null && m.this.hRa != null) {
                    m.this.hRf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hRf.setOnClickListener(null);
                    m.this.hRf.startLoadData();
                    m.this.hRa.btO();
                }
            }
        };
        this.esD = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.hRa != null) {
                        m.this.hRa.bGM();
                    }
                } else if (m.this.enY != null) {
                    m.this.enY.setRefreshing(false);
                }
            }
        };
        this.hRr = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.hQm.show();
                            return;
                        } else {
                            m.this.hQm.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.hQm.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.hRs = null;
        this.hRA = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.hRv = str;
                m.this.hRw = j2;
                m.this.hRx = j3;
                m.this.I(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.hRt != null) {
                    m.this.hRt.aPx();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.hRa = replyMessageFragment;
        this.hRk = new aj(replyMessageFragment.getPageContext());
        this.hRk.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.aj.a
            public void l(boolean z, int i) {
                if (z && m.this.hRt != null) {
                    m.this.hRt.aPt();
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
            oo(false);
            if (z) {
                this.hRf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hRf.endLoadData();
                this.hRf.setOnClickListener(this.hRq);
            } else {
                this.hRf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.hRf.endLoadData();
                this.hRf.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.hRf.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.cz(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.hRj) {
                    this.hRj = true;
                    this.BK.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.BK.setNextPage(null);
                if (arrayList != null) {
                    this.hRg.setData(arrayList);
                }
                this.hRo = R.color.cp_bg_line_e;
            } else {
                this.BK.removeHeaderView(this.mNoDataView);
                this.hRj = false;
                if (this.hRg != null) {
                    this.hRg.setData(arrayList);
                    this.hRg.notifyDataSetChanged();
                }
                this.BK.setNextPage(this.hRf);
                this.hRo = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.hRg != null) {
            this.hRg.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bA(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.hQm = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.hRa.getPageContext());
            this.mPullView.setListPullRefreshListener(this.esD);
        }
        this.mPullView.setTag(this.hRa.getUniqueId());
        if (this.hRf == null) {
            this.hRf = new PbListView(this.hRa.getContext());
            this.hRf.getView();
        }
        this.hRf.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.hRf.setHeight(com.baidu.adp.lib.util.l.getDimens(this.hRa.getContext(), R.dimen.tbds182));
        this.hRf.setLineGone();
        this.hRf.setTextSize(R.dimen.tbfontsize33);
        this.hRf.setTextColor(am.getColor(R.color.cp_cont_d));
        this.hRf.setNoMoreTextColorId(R.color.cp_cont_e);
        this.hRf.setOnClickListener(this.hRq);
        this.enY = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.enY.setProgressView(this.mPullView);
        this.BK = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.hRg = new com.baidu.tieba.imMessageCenter.mention.base.e(this.hRa.getPageContext(), this.BK);
        this.hRg.setOnCardSubClickListener(new z() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.oq(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.hRu = aVar;
                        if (aVar.cak()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cal(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.hRl == null) {
                            m.this.hRl = new AttentionHostData();
                        }
                        if (m.this.hRu != null) {
                            m.this.hRl.parserWithMetaData(m.this.hRu.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.hRu != null) {
                            baijiahaoData = m.this.hRu.getBaijiahaoData();
                        }
                        m.this.hRs.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cam() != null) {
                            an X = new an(aVar.cam()).X("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.hRZ) {
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
        this.BK.setNextPage(this.hRf);
        this.BK.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.hRf != null) {
                    m.this.hRf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.hRf.setOnClickListener(null);
                    m.this.hRf.showLoading();
                    m.this.hRa.btO();
                }
            }
        });
        this.BK.setOnScrollListener(this.mScrollListener);
        this.BK.addOnScrollListener(this.hRr);
        cag();
        this.hRs = new ReplyMeModel(this.hRa.getPageContext());
        this.hRs.a(this.hRA);
        cai();
        op(false);
        return this.mRootView;
    }

    private void cag() {
        this.hRh = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hRa.getPageContext());
        this.hRi = new com.baidu.tieba.imMessageCenter.mention.base.f(this.hRa.getPageContext());
        this.hRh.ba(this.hRa.getString(R.string.at_me), R.drawable.icon_im_at);
        xl(this.hRm);
        this.hRi.ba(this.hRa.getString(R.string.agree_me), R.drawable.icon_im_laud);
        xm(this.hRn);
        this.BK.addHeaderView(this.hRh.getView());
        this.BK.addHeaderView(this.hRi.getView());
        this.BK.setOnHeaderClickListener(this.hRp);
    }

    public void onChangeSkinType(int i) {
        if (this.hRt != null && this.hRt.aOy() != null) {
            this.hRt.aOy().onChangeSkinType(i);
        }
        if (this.hRf != null) {
            this.hRf.setTextColor(am.getColor(R.color.cp_cont_d));
            this.hRf.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.hRh != null) {
            this.hRh.can();
        }
        if (this.hRi != null) {
            this.hRi.can();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.BK, this.hRo);
        am.setBackgroundColor(this.enY, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.hRt == null || this.hRt.aOy() == null || this.hRt.aOy().getVisibility() != 0) {
            return false;
        }
        this.hRt.aPx();
        return true;
    }

    public void oo(boolean z) {
        if (this.enY != null) {
            if (z && this.BK != null && this.BK.getFirstVisiblePosition() != 0) {
                this.BK.setSelection(0);
            }
            this.enY.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.hRm = newsNotifyMessage.getMsgAtme();
            this.hRn = newsNotifyMessage.getMsgAgree();
            xl(this.hRm);
            xm(this.hRn);
        }
    }

    public void cah() {
        xl(this.hRm);
        xm(this.hRn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl(int i) {
        if (this.hRh != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLv()) {
                z = true;
            }
            this.hRh.L(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm(int i) {
        if (this.hRi != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aLq().aLH()) {
                z = true;
            }
            this.hRi.L(i, z);
        }
    }

    private void cai() {
        this.hRy = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.hRa.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aOS() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData vi(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.hRv);
                writeData.setThreadId(m.this.hRu.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.hRu.cak()) {
                    writeData.setFloor(m.this.hRw > 0 ? String.valueOf(m.this.hRw) : m.this.hRu.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.hRu.getPost_id());
                }
                if (m.this.hRx > 0) {
                    writeData.setRepostId(String.valueOf(m.this.hRx));
                }
                if (m.this.hRu != null) {
                    writeData.setBaijiahaoData(m.this.hRu.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aOT() {
                return null;
            }
        };
        this.hRz = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (m.this.hRa.getBaseFragmentActivity() != null) {
                    m.this.hRa.getBaseFragmentActivity().hideProgressBar();
                    m.this.hRt.aOy().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.hRk.a(m.this.hRl);
                        m.this.hRk.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && aaVar == null && !AntiHelper.bb(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.hRa.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(boolean z) {
        if (this.hRt != null && this.hRt.aOy() != null && this.hRt.aOy().getParent() != null) {
            ((ViewGroup) this.hRt.aOy().getParent()).removeView(this.hRt.aOy());
        }
        this.hRt = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dU(this.hRa.getPageContext().getPageActivity());
        this.hRt.a(this.hRa.getPageContext());
        this.hRt.b(this.hRy);
        this.hRt.g(this.hRa.getPageContext());
        this.hRt.aOy().gC(true);
        this.hRt.aOy().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.hRt.aOy() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.hRt.aOy(), layoutParams);
            this.hRt.aOy().hide();
        }
        this.hRt.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void aOW() {
                if (m.this.hRa.getBaseFragmentActivity() != null) {
                    m.this.hRa.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.hRt.b(this.hRz);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.hRt != null) {
            if (i == 12005) {
                this.hRt.aPA();
            }
            this.hRt.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.hRt.aOy().aMV();
        this.hRt.aPx();
        this.hRt.aOy().aOI();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.hRt.b(writeData);
                this.hRt.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mr = this.hRt.aOy().mr(6);
                if (mr != null && mr.dxa != null) {
                    mr.dxa.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.hRt.aPt();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, long j) {
        if (this.hRu != null && this.hRu.getBaijiahaoData() != null && this.hRu.isBjh()) {
            if (this.hRt == null || !this.hRt.isBJH) {
                op(true);
            }
            if (this.hRt != null && this.hRu != null) {
                if (this.hRu.cak() && this.hRu.getReplyer() != null) {
                    this.hRt.vr(this.hRu.getReplyer().getName_show());
                    return;
                } else {
                    this.hRt.vr(null);
                    return;
                }
            }
            return;
        }
        if (this.gsJ == null) {
            this.gsJ = new com.baidu.tieba.frs.profession.permission.c(this.hRa.getPageContext());
            this.gsJ.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lC(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void t(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void lD(boolean z) {
                    if (z) {
                        if (m.this.hRt == null || m.this.hRt.isBJH) {
                            m.this.op(false);
                        }
                        if (m.this.hRt != null && m.this.hRu != null) {
                            if (!m.this.hRu.cak() || m.this.hRu.getReplyer() == null) {
                                m.this.hRt.vr(null);
                            } else {
                                m.this.hRt.vr(m.this.hRu.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.gsJ.C(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.hRt != null) {
            this.hRt.onDestory();
        }
        if (this.hRk != null) {
            this.hRk.onDestroy();
        }
        if (this.hRs != null) {
            this.hRs.a((ReplyMeModel.a) null);
            this.hRs.onDestroy();
        }
        if (this.hRk != null) {
            this.hRk.a((aj.a) null);
        }
    }

    public void e(s sVar) {
        if (this.hRg != null) {
            this.hRg.e(sVar);
        }
    }
}
