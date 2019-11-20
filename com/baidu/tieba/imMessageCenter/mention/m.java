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
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.y;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.base.c {
    private final h.c dBK;
    private BdSwipeRefreshLayout dxt;
    private com.baidu.tieba.frs.profession.permission.c fyd;
    private final ReplyMessageFragment gVJ;
    private PbListView gVO;
    private com.baidu.tieba.imMessageCenter.mention.base.e gVP;
    private com.baidu.tieba.imMessageCenter.mention.base.f gVQ;
    private com.baidu.tieba.imMessageCenter.mention.base.f gVR;
    private boolean gVS;
    private boolean gVT;
    private aj gVU;
    private AttentionHostData gVV;
    private int gVW;
    private int gVX;
    private int gVY;
    private BdListView.b gVZ;
    private View.OnClickListener gWa;
    private ReplyMeModel gWb;
    private com.baidu.tbadk.editortools.pb.g gWc;
    private com.baidu.tieba.imMessageCenter.mention.base.a gWd;
    private String gWe;
    private long gWf;
    private long gWg;
    private DataModel<MessageCenterActivity> gWh;
    private final ReplyMeModel.a gWi;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private BdTypeRecyclerView yJ;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gVW = 0;
        this.gVX = 0;
        this.gVY = R.color.cp_bg_line_c;
        this.gVZ = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gVQ.getView()) {
                    if (view == m.this.gVR.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqH();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aqr().jj(0);
                        m.this.gVX = 0;
                        m.this.uR(m.this.gVX);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().aqG();
                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().setMsgAtme(0);
                m.this.gVW = 0;
                m.this.uQ(m.this.gVW);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gWa = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gVO != null && m.this.gVJ != null) {
                    m.this.gVO.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gVO.setOnClickListener(null);
                    m.this.gVO.startLoadData();
                    m.this.gVJ.aYW();
                }
            }
        };
        this.dBK = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.gVJ != null) {
                        m.this.gVJ.bmy();
                    }
                } else if (m.this.dxt != null) {
                    m.this.dxt.setRefreshing(false);
                }
            }
        };
        this.gWb = null;
        this.gWi = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gWe = str;
                m.this.gWf = j2;
                m.this.gWg = j3;
                m.this.F(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gWc != null) {
                    m.this.gWc.auT();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gVJ = replyMessageFragment;
        this.gVU = new aj(replyMessageFragment.getPageContext());
        this.gVU.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void f(boolean z, int i) {
                if (z && m.this.gWc != null) {
                    m.this.gWc.auP();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.isEmpty(this.yJ.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.mH(true);
                        m.this.gVJ.bmy();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.showRefreshButton();
                this.mRefreshView.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.setSubText(getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.setSubText(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.gVT) {
                this.yJ.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            }
            this.gVT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.yJ != null) {
            mH(false);
            if (z) {
                this.gVO.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gVO.endLoadData();
                this.gVO.setOnClickListener(this.gWa);
            } else {
                this.gVO.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gVO.endLoadData();
                this.gVO.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.gVO.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.iK(R.string.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gVS) {
                    this.gVS = true;
                    this.yJ.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.yJ.setNextPage(null);
                this.gVY = R.color.cp_bg_line_e;
            } else {
                this.yJ.removeHeaderView(this.mNoDataView);
                this.gVS = false;
                if (this.mRefreshView != null) {
                    this.yJ.removeHeaderView(this.mRefreshView.getAttachedView());
                    this.gVT = false;
                }
                if (this.gVP != null) {
                    this.gVP.setData(arrayList);
                    this.gVP.notifyDataSetChanged();
                }
                this.yJ.setNextPage(this.gVO);
                this.gVY = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gVP != null) {
            this.gVP.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bz(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gVJ.getPageContext());
            this.mPullView.setListPullRefreshListener(this.dBK);
        }
        this.mPullView.setTag(this.gVJ.getUniqueId());
        if (this.gVO == null) {
            this.gVO = new PbListView(this.gVJ.getContext());
            this.gVO.getView();
        }
        this.gVO.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gVO.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gVJ.getContext(), R.dimen.tbds182));
        this.gVO.setLineGone();
        this.gVO.setTextSize(R.dimen.tbfontsize33);
        this.gVO.setTextColor(am.getColor(R.color.cp_cont_d));
        this.gVO.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gVO.setOnClickListener(this.gWa);
        this.dxt = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.dxt.setProgressView(this.mPullView);
        this.yJ = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.gVP = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gVJ.getPageContext(), this.yJ);
        this.gVP.a(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.mI(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.gWd = aVar;
                        if (aVar.bFS()) {
                            j = com.baidu.adp.lib.g.b.toLong(aVar.bFT(), 0L);
                        } else {
                            j = com.baidu.adp.lib.g.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gVV == null) {
                            m.this.gVV = new AttentionHostData();
                        }
                        if (m.this.gWd != null) {
                            m.this.gVV.parserWithMetaData(m.this.gWd.getThreadAuthor());
                        }
                        m.this.gWb.a(j, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bFU() != null) {
                            an O = new an(aVar.bFU()).O("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gWI) {
                                O.O("obj_type", 1);
                            } else {
                                O.O("obj_type", 2);
                            }
                            TiebaStatic.log(O);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.yJ.getItemAnimator()).setSupportsChangeAnimations(false);
        this.yJ.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.yJ.setFadingEdgeLength(0);
        this.yJ.setOverScrollMode(2);
        this.yJ.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.yJ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.yJ.setNextPage(this.gVO);
        this.yJ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gVO != null) {
                    m.this.gVO.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gVO.setOnClickListener(null);
                    m.this.gVO.showLoading();
                    m.this.gVJ.aYW();
                }
            }
        });
        this.yJ.setOnScrollListener(this.mScrollListener);
        bFP();
        this.gWb = new ReplyMeModel(this.gVJ.getPageContext());
        this.gWb.a(this.gWi);
        this.gWh = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.gVJ.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aur() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData pG(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.gWe);
                writeData.setThreadId(m.this.gWd.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gWd.bFS()) {
                    writeData.setFloor(m.this.gWf > 0 ? String.valueOf(m.this.gWf) : m.this.gWd.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gWd.getPost_id());
                }
                if (m.this.gWg > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gWg));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aus() {
                return null;
            }
        };
        this.gWc = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().cw(this.gVJ.getPageContext().getContext());
        this.gWc.a(this.gVJ.getPageContext());
        this.gWc.b(this.gWh);
        this.gWc.e(this.gVJ.getPageContext());
        this.gWc.atX().fe(true);
        this.gWc.atX().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gWc.atX() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gWc.atX(), layoutParams);
            this.gWc.atX().hide();
        }
        this.gWc.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void auv() {
                if (m.this.gVJ.getBaseFragmentActivity() != null) {
                    m.this.gVJ.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gWc.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (m.this.gVJ.getBaseFragmentActivity() != null) {
                    m.this.gVJ.getBaseFragmentActivity().hideProgressBar();
                    m.this.gWc.atX().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gVU.a(m.this.gVV);
                        m.this.gVU.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && yVar == null && !AntiHelper.aG(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gVJ.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bFP() {
        this.gVQ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gVJ.getPageContext());
        this.gVR = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gVJ.getPageContext());
        this.gVQ.aS(this.gVJ.getString(R.string.at_me), R.drawable.icon_im_at);
        uQ(this.gVW);
        this.gVR.aS(this.gVJ.getString(R.string.agree_me), R.drawable.icon_im_laud);
        uR(this.gVX);
        this.yJ.addHeaderView(this.gVQ.getView());
        this.yJ.addHeaderView(this.gVR.getView());
        this.yJ.setOnHeaderClickListener(this.gVZ);
    }

    public void onChangeSkinType(int i) {
        if (this.gWc != null && this.gWc.atX() != null) {
            this.gWc.atX().onChangeSkinType(i);
        }
        if (this.gVO != null) {
            this.gVO.setTextColor(am.getColor(R.color.cp_cont_d));
            this.gVO.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.gVQ != null) {
            this.gVQ.bno();
        }
        if (this.gVR != null) {
            this.gVR.bno();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.yJ, this.gVY);
        am.setBackgroundColor(this.dxt, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gWc == null || this.gWc.atX() == null || this.gWc.atX().getVisibility() != 0) {
            return false;
        }
        this.gWc.auT();
        return true;
    }

    public void mH(boolean z) {
        if (this.dxt != null) {
            if (z && this.yJ != null && this.yJ.getFirstVisiblePosition() != 0) {
                this.yJ.setSelection(0);
            }
            this.dxt.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gVW = newsNotifyMessage.getMsgAtme();
            this.gVX = newsNotifyMessage.getMsgAgree();
            uQ(this.gVW);
            uR(this.gVX);
        }
    }

    public void bFQ() {
        uQ(this.gVW);
        uR(this.gVX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(int i) {
        if (this.gVQ != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aqY().ard()) {
                z = true;
            }
            this.gVQ.K(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uR(int i) {
        if (this.gVR != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aqY().arp()) {
                z = true;
            }
            this.gVR.K(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gWc != null) {
            if (i == 12005) {
                this.gWc.auW();
            }
            this.gWc.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gWc.atX().asA();
        this.gWc.auT();
        this.gWc.atX().auh();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gWc.b(writeData);
                this.gWc.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k jK = this.gWc.atX().jK(6);
                if (jK != null && jK.cEn != null) {
                    jK.cEn.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gWc.auP();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, long j) {
        if (this.fyd == null) {
            this.fyd = new com.baidu.tieba.frs.profession.permission.c(this.gVJ.getPageContext());
            this.fyd.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jW(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void o(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jX(boolean z) {
                    if (z && m.this.gWc != null && m.this.gWd != null) {
                        if (!m.this.gWd.bFS() || m.this.gWd.getReplyer() == null) {
                            m.this.gWc.pQ(null);
                        } else {
                            m.this.gWc.pQ(m.this.gWd.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fyd.z(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gWc != null) {
            this.gWc.onDestory();
        }
        if (this.gVU != null) {
            this.gVU.onDestroy();
        }
        if (this.gWb != null) {
            this.gWb.a((ReplyMeModel.a) null);
            this.gWb.onDestroy();
        }
        if (this.gVU != null) {
            this.gVU.a((aj.a) null);
        }
    }

    public void e(s sVar) {
        if (this.gVP != null) {
            this.gVP.e(sVar);
        }
    }
}
