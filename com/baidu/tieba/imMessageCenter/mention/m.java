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
    private BdTypeRecyclerView Vi;
    private BdSwipeRefreshLayout eRB;
    private final g.c eWe;
    private com.baidu.tieba.frs.profession.permission.c hcb;
    private final ReplyMessageFragment iAX;
    private NavigationBarShadowView iAj;
    private PbListView iBc;
    private com.baidu.tieba.imMessageCenter.mention.base.e iBd;
    private com.baidu.tieba.imMessageCenter.mention.base.f iBe;
    private com.baidu.tieba.imMessageCenter.mention.base.f iBf;
    private boolean iBg;
    private aj iBh;
    private AttentionHostData iBi;
    private int iBj;
    private int iBk;
    private int iBl;
    private BdListView.b iBm;
    private View.OnClickListener iBn;
    private RecyclerView.OnScrollListener iBo;
    private ReplyMeModel iBp;
    private com.baidu.tbadk.editortools.pb.h iBq;
    private com.baidu.tieba.imMessageCenter.mention.base.a iBr;
    private String iBs;
    private long iBt;
    private long iBu;
    private DataModel<MessageCenterActivity> iBv;
    private NewWriteModel.d iBw;
    private final ReplyMeModel.a iBx;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.iBj = 0;
        this.iBk = 0;
        this.iBl = R.color.cp_bg_line_c;
        this.iBm = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.iBe.getView()) {
                    if (view == m.this.iBf.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTu();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTe().mb(0);
                        m.this.iBk = 0;
                        m.this.xM(m.this.iBk);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().aTt();
                com.baidu.tbadk.coreExtra.messageCenter.b.aTe().setMsgAtme(0);
                m.this.iBj = 0;
                m.this.xL(m.this.iBj);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.iBn = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.iBc != null && m.this.iAX != null) {
                    m.this.iBc.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.iBc.setOnClickListener(null);
                    m.this.iBc.startLoadData();
                    m.this.iAX.bDx();
                }
            }
        };
        this.eWe = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.iAX != null) {
                        m.this.iAX.bRl();
                    }
                } else if (m.this.eRB != null) {
                    m.this.eRB.setRefreshing(false);
                }
            }
        };
        this.iBo = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.iAj.show();
                            return;
                        } else {
                            m.this.iAj.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.iAj.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.iBp = null;
        this.iBx = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.iBs = str;
                m.this.iBt = j2;
                m.this.iBu = j3;
                m.this.I(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.iBq != null) {
                    m.this.iBq.aXM();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.iAX = replyMessageFragment;
        this.iBh = new aj(replyMessageFragment.getPageContext());
        this.iBh.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.aj.a
            public void m(boolean z, int i) {
                if (z && m.this.iBq != null) {
                    m.this.iBq.aXI();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Vi != null) {
            ps(false);
            if (z) {
                this.iBc.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.iBc.endLoadData();
                this.iBc.setOnClickListener(this.iBn);
            } else {
                this.iBc.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.iBc.endLoadData();
                this.iBc.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.iBc.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.cK(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.iBg) {
                    this.iBg = true;
                    this.Vi.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Vi.setNextPage(null);
                if (arrayList != null) {
                    this.iBd.setData(arrayList);
                }
                this.iBl = R.color.cp_bg_line_e;
            } else {
                this.Vi.removeHeaderView(this.mNoDataView);
                this.iBg = false;
                if (this.iBd != null) {
                    this.iBd.setData(arrayList);
                    this.iBd.notifyDataSetChanged();
                }
                this.Vi.setNextPage(this.iBc);
                this.iBl = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.iBd != null) {
            this.iBd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bC(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.iAj = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.iAX.getPageContext());
            this.mPullView.setListPullRefreshListener(this.eWe);
        }
        this.mPullView.setTag(this.iAX.getUniqueId());
        if (this.iBc == null) {
            this.iBc = new PbListView(this.iAX.getContext());
            this.iBc.getView();
        }
        this.iBc.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.iBc.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iAX.getContext(), R.dimen.tbds182));
        this.iBc.setLineGone();
        this.iBc.setTextSize(R.dimen.tbfontsize33);
        this.iBc.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iBc.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iBc.setOnClickListener(this.iBn);
        this.eRB = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.eRB.setProgressView(this.mPullView);
        this.Vi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.iBd = new com.baidu.tieba.imMessageCenter.mention.base.e(this.iAX.getPageContext(), this.Vi);
        this.iBd.setOnCardSubClickListener(new z() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.pu(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.iBr = aVar;
                        if (aVar.ckJ()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.ckK(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.iBi == null) {
                            m.this.iBi = new AttentionHostData();
                        }
                        if (m.this.iBr != null) {
                            m.this.iBi.parserWithMetaData(m.this.iBr.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.iBr != null) {
                            baijiahaoData = m.this.iBr.getBaijiahaoData();
                        }
                        m.this.iBp.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.ckL() != null) {
                            an af = new an(aVar.ckL()).af("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.iBW) {
                                af.af("obj_type", 1);
                            } else {
                                af.af("obj_type", 2);
                            }
                            TiebaStatic.log(af);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Vi.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Vi.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Vi.setFadingEdgeLength(0);
        this.Vi.setOverScrollMode(2);
        this.Vi.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Vi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Vi.setNextPage(this.iBc);
        this.Vi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.iBc != null) {
                    m.this.iBc.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.iBc.setOnClickListener(null);
                    m.this.iBc.showLoading();
                    m.this.iAX.bDx();
                }
            }
        });
        this.Vi.setOnScrollListener(this.mScrollListener);
        this.Vi.addOnScrollListener(this.iBo);
        ckF();
        this.iBp = new ReplyMeModel(this.iAX.getPageContext());
        this.iBp.a(this.iBx);
        ckH();
        pt(false);
        return this.mRootView;
    }

    private void ckF() {
        this.iBe = new com.baidu.tieba.imMessageCenter.mention.base.f(this.iAX.getPageContext());
        this.iBf = new com.baidu.tieba.imMessageCenter.mention.base.f(this.iAX.getPageContext());
        this.iBe.bk(this.iAX.getString(R.string.at_me), R.drawable.icon_im_at);
        xL(this.iBj);
        this.iBf.bk(this.iAX.getString(R.string.agree_me), R.drawable.icon_im_laud);
        xM(this.iBk);
        this.Vi.addHeaderView(this.iBe.getView());
        this.Vi.addHeaderView(this.iBf.getView());
        this.Vi.setOnHeaderClickListener(this.iBm);
    }

    public void onChangeSkinType(int i) {
        if (this.iBq != null && this.iBq.aWN() != null) {
            this.iBq.aWN().onChangeSkinType(i);
        }
        if (this.iBc != null) {
            this.iBc.setTextColor(am.getColor(R.color.cp_cont_d));
            this.iBc.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.iBe != null) {
            this.iBe.ckM();
        }
        if (this.iBf != null) {
            this.iBf.ckM();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.Vi, this.iBl);
        am.setBackgroundColor(this.eRB, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.iBq == null || this.iBq.aWN() == null || this.iBq.aWN().getVisibility() != 0) {
            return false;
        }
        this.iBq.aXM();
        return true;
    }

    public void ps(boolean z) {
        if (this.eRB != null) {
            if (z && this.Vi != null && this.Vi.getFirstVisiblePosition() != 0) {
                this.Vi.setSelection(0);
            }
            this.eRB.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.iBj = newsNotifyMessage.getMsgAtme();
            this.iBk = newsNotifyMessage.getMsgAgree();
            xL(this.iBj);
            xM(this.iBk);
        }
    }

    public void ckG() {
        xL(this.iBj);
        xM(this.iBk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL(int i) {
        if (this.iBe != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aTQ()) {
                z = true;
            }
            this.iBe.R(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM(int i) {
        if (this.iBf != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aTL().aUc()) {
                z = true;
            }
            this.iBf.R(i, z);
        }
    }

    private void ckH() {
        this.iBv = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.G(this.iAX.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aXh() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData wz(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.iBs);
                writeData.setThreadId(m.this.iBr.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.iBr.ckJ()) {
                    writeData.setFloor(m.this.iBt > 0 ? String.valueOf(m.this.iBt) : m.this.iBr.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.iBr.getPost_id());
                }
                if (m.this.iBu > 0) {
                    writeData.setRepostId(String.valueOf(m.this.iBu));
                }
                if (m.this.iBr != null) {
                    writeData.setBaijiahaoData(m.this.iBr.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aXi() {
                return null;
            }
        };
        this.iBw = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (m.this.iAX.getBaseFragmentActivity() != null) {
                    m.this.iAX.getBaseFragmentActivity().hideProgressBar();
                    m.this.iBq.aWN().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.iBh.a(m.this.iBi);
                        m.this.iBh.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && aaVar == null && !AntiHelper.bq(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.iAX.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
        if (this.iBq != null && this.iBq.aWN() != null && this.iBq.aWN().getParent() != null) {
            ((ViewGroup) this.iBq.aWN().getParent()).removeView(this.iBq.aWN());
        }
        this.iBq = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dw(this.iAX.getPageContext().getPageActivity());
        this.iBq.a(this.iAX.getPageContext());
        this.iBq.b(this.iBv);
        this.iBq.j(this.iAX.getPageContext());
        this.iBq.aWN().hA(true);
        this.iBq.aWN().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iBq.aWN() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.iBq.aWN(), layoutParams);
            this.iBq.aWN().hide();
        }
        this.iBq.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void aXl() {
                if (m.this.iAX.getBaseFragmentActivity() != null) {
                    m.this.iAX.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.iBq.b(this.iBw);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.iBq != null) {
            if (i == 12005) {
                this.iBq.aXP();
            }
            this.iBq.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.iBq.aWN().aVq();
        this.iBq.aXM();
        this.iBq.aWN().aWX();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.iBq.b(writeData);
                this.iBq.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mD = this.iBq.aWN().mD(6);
                if (mD != null && mD.dWM != null) {
                    mD.dWM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.iBq.aXI();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, long j) {
        if (this.iBr != null && this.iBr.getBaijiahaoData() != null && this.iBr.isBjh()) {
            if (this.iBq == null || !this.iBq.isBJH) {
                pt(true);
            }
            if (this.iBq != null && this.iBr != null) {
                if (this.iBr.ckJ() && this.iBr.getReplyer() != null) {
                    this.iBq.wJ(this.iBr.getReplyer().getName_show());
                    return;
                } else {
                    this.iBq.wJ(null);
                    return;
                }
            }
            return;
        }
        if (this.hcb == null) {
            this.hcb = new com.baidu.tieba.frs.profession.permission.c(this.iAX.getPageContext());
            this.hcb.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void mF(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void u(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void mG(boolean z) {
                    if (z) {
                        if (m.this.iBq == null || m.this.iBq.isBJH) {
                            m.this.pt(false);
                        }
                        if (m.this.iBq != null && m.this.iBr != null) {
                            if (!m.this.iBr.ckJ() || m.this.iBr.getReplyer() == null) {
                                m.this.iBq.wJ(null);
                            } else {
                                m.this.iBq.wJ(m.this.iBr.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.hcb.E(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.iBq != null) {
            this.iBq.onDestory();
        }
        if (this.iBh != null) {
            this.iBh.onDestroy();
        }
        if (this.iBp != null) {
            this.iBp.a((ReplyMeModel.a) null);
            this.iBp.onDestroy();
        }
        if (this.iBh != null) {
            this.iBh.a((aj.a) null);
        }
    }

    public void e(com.baidu.adp.widget.ListView.v vVar) {
        if (this.iBd != null) {
            this.iBd.e(vVar);
        }
    }
}
