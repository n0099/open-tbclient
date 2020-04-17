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
    private BdTypeRecyclerView Vf;
    private BdSwipeRefreshLayout eRw;
    private final g.c eVZ;
    private com.baidu.tieba.frs.profession.permission.c hbV;
    private final ReplyMessageFragment iAR;
    private PbListView iAW;
    private com.baidu.tieba.imMessageCenter.mention.base.e iAX;
    private com.baidu.tieba.imMessageCenter.mention.base.f iAY;
    private com.baidu.tieba.imMessageCenter.mention.base.f iAZ;
    private NavigationBarShadowView iAd;
    private boolean iBa;
    private aj iBb;
    private AttentionHostData iBc;
    private int iBd;
    private int iBe;
    private int iBf;
    private BdListView.b iBg;
    private View.OnClickListener iBh;
    private RecyclerView.OnScrollListener iBi;
    private ReplyMeModel iBj;
    private com.baidu.tbadk.editortools.pb.h iBk;
    private com.baidu.tieba.imMessageCenter.mention.base.a iBl;
    private String iBm;
    private long iBn;
    private long iBo;
    private DataModel<MessageCenterActivity> iBp;
    private NewWriteModel.d iBq;
    private final ReplyMeModel.a iBr;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.h mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.iBd = 0;
        this.iBe = 0;
        this.iBf = R.color.cp_bg_line_c;
        this.iBg = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.iAY.getView()) {
                    if (view == m.this.iAZ.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTg().aTw();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aTg().mb(0);
                        m.this.iBe = 0;
                        m.this.xM(m.this.iBe);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aTg().aTv();
                com.baidu.tbadk.coreExtra.messageCenter.b.aTg().setMsgAtme(0);
                m.this.iBd = 0;
                m.this.xL(m.this.iBd);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.iBh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.iAW != null && m.this.iAR != null) {
                    m.this.iAW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.iAW.setOnClickListener(null);
                    m.this.iAW.startLoadData();
                    m.this.iAR.bDz();
                }
            }
        };
        this.eVZ = new g.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.g.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.iAR != null) {
                        m.this.iAR.bRn();
                    }
                } else if (m.this.eRw != null) {
                    m.this.eRw.setRefreshing(false);
                }
            }
        };
        this.iBi = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.iAd.show();
                            return;
                        } else {
                            m.this.iAd.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.iAd.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.iBj = null;
        this.iBr = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.iBm = str;
                m.this.iBn = j2;
                m.this.iBo = j3;
                m.this.I(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.iBk != null) {
                    m.this.iBk.aXO();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.iAR = replyMessageFragment;
        this.iBb = new aj(replyMessageFragment.getPageContext());
        this.iBb.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.aj.a
            public void m(boolean z, int i) {
                if (z && m.this.iBk != null) {
                    m.this.iBk.aXK();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Vf != null) {
            ps(false);
            if (z) {
                this.iAW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.iAW.endLoadData();
                this.iAW.setOnClickListener(this.iBh);
            } else {
                this.iAW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.iAW.endLoadData();
                this.iAW.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.iAW.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.cK(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.iBa) {
                    this.iBa = true;
                    this.Vf.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Vf.setNextPage(null);
                if (arrayList != null) {
                    this.iAX.setData(arrayList);
                }
                this.iBf = R.color.cp_bg_line_e;
            } else {
                this.Vf.removeHeaderView(this.mNoDataView);
                this.iBa = false;
                if (this.iAX != null) {
                    this.iAX.setData(arrayList);
                    this.iAX.notifyDataSetChanged();
                }
                this.Vf.setNextPage(this.iAW);
                this.iBf = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.iAX != null) {
            this.iAX.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bC(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.iAd = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.h(this.iAR.getPageContext());
            this.mPullView.setListPullRefreshListener(this.eVZ);
        }
        this.mPullView.setTag(this.iAR.getUniqueId());
        if (this.iAW == null) {
            this.iAW = new PbListView(this.iAR.getContext());
            this.iAW.getView();
        }
        this.iAW.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.iAW.setHeight(com.baidu.adp.lib.util.l.getDimens(this.iAR.getContext(), R.dimen.tbds182));
        this.iAW.setLineGone();
        this.iAW.setTextSize(R.dimen.tbfontsize33);
        this.iAW.setTextColor(am.getColor(R.color.cp_cont_d));
        this.iAW.setNoMoreTextColorId(R.color.cp_cont_e);
        this.iAW.setOnClickListener(this.iBh);
        this.eRw = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.eRw.setProgressView(this.mPullView);
        this.Vf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.iAX = new com.baidu.tieba.imMessageCenter.mention.base.e(this.iAR.getPageContext(), this.Vf);
        this.iAX.setOnCardSubClickListener(new z() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.iBl = aVar;
                        if (aVar.ckL()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.ckM(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.iBc == null) {
                            m.this.iBc = new AttentionHostData();
                        }
                        if (m.this.iBl != null) {
                            m.this.iBc.parserWithMetaData(m.this.iBl.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.iBl != null) {
                            baijiahaoData = m.this.iBl.getBaijiahaoData();
                        }
                        m.this.iBj.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.ckN() != null) {
                            an af = new an(aVar.ckN()).af("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.iBQ) {
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
        ((DefaultItemAnimator) this.Vf.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Vf.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Vf.setFadingEdgeLength(0);
        this.Vf.setOverScrollMode(2);
        this.Vf.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Vf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Vf.setNextPage(this.iAW);
        this.Vf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.iAW != null) {
                    m.this.iAW.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.iAW.setOnClickListener(null);
                    m.this.iAW.showLoading();
                    m.this.iAR.bDz();
                }
            }
        });
        this.Vf.setOnScrollListener(this.mScrollListener);
        this.Vf.addOnScrollListener(this.iBi);
        ckH();
        this.iBj = new ReplyMeModel(this.iAR.getPageContext());
        this.iBj.a(this.iBr);
        ckJ();
        pt(false);
        return this.mRootView;
    }

    private void ckH() {
        this.iAY = new com.baidu.tieba.imMessageCenter.mention.base.f(this.iAR.getPageContext());
        this.iAZ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.iAR.getPageContext());
        this.iAY.bk(this.iAR.getString(R.string.at_me), R.drawable.icon_im_at);
        xL(this.iBd);
        this.iAZ.bk(this.iAR.getString(R.string.agree_me), R.drawable.icon_im_laud);
        xM(this.iBe);
        this.Vf.addHeaderView(this.iAY.getView());
        this.Vf.addHeaderView(this.iAZ.getView());
        this.Vf.setOnHeaderClickListener(this.iBg);
    }

    public void onChangeSkinType(int i) {
        if (this.iBk != null && this.iBk.aWP() != null) {
            this.iBk.aWP().onChangeSkinType(i);
        }
        if (this.iAW != null) {
            this.iAW.setTextColor(am.getColor(R.color.cp_cont_d));
            this.iAW.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.iAY != null) {
            this.iAY.ckO();
        }
        if (this.iAZ != null) {
            this.iAZ.ckO();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.Vf, this.iBf);
        am.setBackgroundColor(this.eRw, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.iBk == null || this.iBk.aWP() == null || this.iBk.aWP().getVisibility() != 0) {
            return false;
        }
        this.iBk.aXO();
        return true;
    }

    public void ps(boolean z) {
        if (this.eRw != null) {
            if (z && this.Vf != null && this.Vf.getFirstVisiblePosition() != 0) {
                this.Vf.setSelection(0);
            }
            this.eRw.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.iBd = newsNotifyMessage.getMsgAtme();
            this.iBe = newsNotifyMessage.getMsgAgree();
            xL(this.iBd);
            xM(this.iBe);
        }
    }

    public void ckI() {
        xL(this.iBd);
        xM(this.iBe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL(int i) {
        if (this.iAY != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aTS()) {
                z = true;
            }
            this.iAY.R(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM(int i) {
        if (this.iAZ != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aTN().aUe()) {
                z = true;
            }
            this.iAZ.R(i, z);
        }
    }

    private void ckJ() {
        this.iBp = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.T(this.iAR.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aXj() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData ww(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.iBm);
                writeData.setThreadId(m.this.iBl.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.iBl.ckL()) {
                    writeData.setFloor(m.this.iBn > 0 ? String.valueOf(m.this.iBn) : m.this.iBl.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.iBl.getPost_id());
                }
                if (m.this.iBo > 0) {
                    writeData.setRepostId(String.valueOf(m.this.iBo));
                }
                if (m.this.iBl != null) {
                    writeData.setBaijiahaoData(m.this.iBl.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aXk() {
                return null;
            }
        };
        this.iBq = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
                if (m.this.iAR.getBaseFragmentActivity() != null) {
                    m.this.iAR.getBaseFragmentActivity().hideProgressBar();
                    m.this.iBk.aWP().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.iBb.a(m.this.iBc);
                        m.this.iBb.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && aaVar == null && !AntiHelper.bq(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.iAR.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(boolean z) {
        if (this.iBk != null && this.iBk.aWP() != null && this.iBk.aWP().getParent() != null) {
            ((ViewGroup) this.iBk.aWP().getParent()).removeView(this.iBk.aWP());
        }
        this.iBk = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dI(this.iAR.getPageContext().getPageActivity());
        this.iBk.a(this.iAR.getPageContext());
        this.iBk.b(this.iBp);
        this.iBk.j(this.iAR.getPageContext());
        this.iBk.aWP().hA(true);
        this.iBk.aWP().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iBk.aWP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.iBk.aWP(), layoutParams);
            this.iBk.aWP().hide();
        }
        this.iBk.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void aXn() {
                if (m.this.iAR.getBaseFragmentActivity() != null) {
                    m.this.iAR.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.iBk.b(this.iBq);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.iBk != null) {
            if (i == 12005) {
                this.iBk.aXR();
            }
            this.iBk.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.iBk.aWP().aVs();
        this.iBk.aXO();
        this.iBk.aWP().aWZ();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.iBk.b(writeData);
                this.iBk.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l mD = this.iBk.aWP().mD(6);
                if (mD != null && mD.dWH != null) {
                    mD.dWH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.iBk.aXK();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, long j) {
        if (this.iBl != null && this.iBl.getBaijiahaoData() != null && this.iBl.isBjh()) {
            if (this.iBk == null || !this.iBk.isBJH) {
                pt(true);
            }
            if (this.iBk != null && this.iBl != null) {
                if (this.iBl.ckL() && this.iBl.getReplyer() != null) {
                    this.iBk.wG(this.iBl.getReplyer().getName_show());
                    return;
                } else {
                    this.iBk.wG(null);
                    return;
                }
            }
            return;
        }
        if (this.hbV == null) {
            this.hbV = new com.baidu.tieba.frs.profession.permission.c(this.iAR.getPageContext());
            this.hbV.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void mF(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void u(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void mG(boolean z) {
                    if (z) {
                        if (m.this.iBk == null || m.this.iBk.isBJH) {
                            m.this.pt(false);
                        }
                        if (m.this.iBk != null && m.this.iBl != null) {
                            if (!m.this.iBl.ckL() || m.this.iBl.getReplyer() == null) {
                                m.this.iBk.wG(null);
                            } else {
                                m.this.iBk.wG(m.this.iBl.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.hbV.E(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.iBk != null) {
            this.iBk.onDestory();
        }
        if (this.iBb != null) {
            this.iBb.onDestroy();
        }
        if (this.iBj != null) {
            this.iBj.a((ReplyMeModel.a) null);
            this.iBj.onDestroy();
        }
        if (this.iBb != null) {
            this.iBb.a((aj.a) null);
        }
    }

    public void e(com.baidu.adp.widget.ListView.v vVar) {
        if (this.iAX != null) {
            this.iAX.e(vVar);
        }
    }
}
