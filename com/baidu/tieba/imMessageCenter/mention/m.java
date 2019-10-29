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
    private final h.c dCB;
    private BdSwipeRefreshLayout dyk;
    private com.baidu.tieba.frs.profession.permission.c fyU;
    private final ReplyMessageFragment gWA;
    private PbListView gWF;
    private com.baidu.tieba.imMessageCenter.mention.base.e gWG;
    private com.baidu.tieba.imMessageCenter.mention.base.f gWH;
    private com.baidu.tieba.imMessageCenter.mention.base.f gWI;
    private boolean gWJ;
    private boolean gWK;
    private aj gWL;
    private AttentionHostData gWM;
    private int gWN;
    private int gWO;
    private int gWP;
    private BdListView.b gWQ;
    private View.OnClickListener gWR;
    private ReplyMeModel gWS;
    private com.baidu.tbadk.editortools.pb.g gWT;
    private com.baidu.tieba.imMessageCenter.mention.base.a gWU;
    private String gWV;
    private long gWW;
    private long gWX;
    private DataModel<MessageCenterActivity> gWY;
    private final ReplyMeModel.a gWZ;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;
    private BdTypeRecyclerView zj;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gWN = 0;
        this.gWO = 0;
        this.gWP = R.color.cp_bg_line_c;
        this.gWQ = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gWH.getView()) {
                    if (view == m.this.gWI.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqJ();
                        com.baidu.tbadk.coreExtra.messageCenter.b.aqt().jk(0);
                        m.this.gWO = 0;
                        m.this.uS(m.this.gWO);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.aqt().aqI();
                com.baidu.tbadk.coreExtra.messageCenter.b.aqt().setMsgAtme(0);
                m.this.gWN = 0;
                m.this.uR(m.this.gWN);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gWR = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gWF != null && m.this.gWA != null) {
                    m.this.gWF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gWF.setOnClickListener(null);
                    m.this.gWF.startLoadData();
                    m.this.gWA.aYY();
                }
            }
        };
        this.dCB = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.gWA != null) {
                        m.this.gWA.bmA();
                    }
                } else if (m.this.dyk != null) {
                    m.this.dyk.setRefreshing(false);
                }
            }
        };
        this.gWS = null;
        this.gWZ = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gWV = str;
                m.this.gWW = j2;
                m.this.gWX = j3;
                m.this.F(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gWT != null) {
                    m.this.gWT.auV();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gWA = replyMessageFragment;
        this.gWL = new aj(replyMessageFragment.getPageContext());
        this.gWL.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void f(boolean z, int i) {
                if (z && m.this.gWT != null) {
                    m.this.gWT.auR();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.isEmpty(this.zj.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.mH(true);
                        m.this.gWA.bmA();
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
            if (!this.gWK) {
                this.zj.addHeaderView(this.mRefreshView.getAttachedView(), 0);
            }
            this.gWK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.zj != null) {
            mH(false);
            if (z) {
                this.gWF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gWF.endLoadData();
                this.gWF.setOnClickListener(this.gWR);
            } else {
                this.gWF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gWF.endLoadData();
                this.gWF.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.gWF.setOnClickListener(null);
            }
            if (v.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.iL(R.string.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gWJ) {
                    this.gWJ = true;
                    this.zj.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.zj.setNextPage(null);
                this.gWP = R.color.cp_bg_line_e;
            } else {
                this.zj.removeHeaderView(this.mNoDataView);
                this.gWJ = false;
                if (this.mRefreshView != null) {
                    this.zj.removeHeaderView(this.mRefreshView.getAttachedView());
                    this.gWK = false;
                }
                if (this.gWG != null) {
                    this.gWG.setData(arrayList);
                    this.gWG.notifyDataSetChanged();
                }
                this.zj.setNextPage(this.gWF);
                this.gWP = R.color.cp_bg_line_c;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gWG != null) {
            this.gWG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bz(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gWA.getPageContext());
            this.mPullView.setListPullRefreshListener(this.dCB);
        }
        this.mPullView.setTag(this.gWA.getUniqueId());
        if (this.gWF == null) {
            this.gWF = new PbListView(this.gWA.getContext());
            this.gWF.getView();
        }
        this.gWF.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.gWF.setHeight(com.baidu.adp.lib.util.l.getDimens(this.gWA.getContext(), R.dimen.tbds182));
        this.gWF.setLineGone();
        this.gWF.setTextSize(R.dimen.tbfontsize33);
        this.gWF.setTextColor(am.getColor(R.color.cp_cont_d));
        this.gWF.setNoMoreTextColorId(R.color.cp_cont_e);
        this.gWF.setOnClickListener(this.gWR);
        this.dyk = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.dyk.setProgressView(this.mPullView);
        this.zj = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.gWG = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gWA.getPageContext(), this.zj);
        this.gWG.a(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.gWU = aVar;
                        if (aVar.bFU()) {
                            j = com.baidu.adp.lib.g.b.toLong(aVar.bFV(), 0L);
                        } else {
                            j = com.baidu.adp.lib.g.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gWM == null) {
                            m.this.gWM = new AttentionHostData();
                        }
                        if (m.this.gWU != null) {
                            m.this.gWM.parserWithMetaData(m.this.gWU.getThreadAuthor());
                        }
                        m.this.gWS.a(j, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bFW() != null) {
                            an O = new an(aVar.bFW()).O("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gXz) {
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
        ((DefaultItemAnimator) this.zj.getItemAnimator()).setSupportsChangeAnimations(false);
        this.zj.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.zj.setFadingEdgeLength(0);
        this.zj.setOverScrollMode(2);
        this.zj.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.zj.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.zj.setNextPage(this.gWF);
        this.zj.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gWF != null) {
                    m.this.gWF.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gWF.setOnClickListener(null);
                    m.this.gWF.showLoading();
                    m.this.gWA.aYY();
                }
            }
        });
        this.zj.setOnScrollListener(this.mScrollListener);
        bFR();
        this.gWS = new ReplyMeModel(this.gWA.getPageContext());
        this.gWS.a(this.gWZ);
        this.gWY = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ab(this.gWA.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean aut() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData pG(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.gWV);
                writeData.setThreadId(m.this.gWU.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gWU.bFU()) {
                    writeData.setFloor(m.this.gWW > 0 ? String.valueOf(m.this.gWW) : m.this.gWU.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gWU.getPost_id());
                }
                if (m.this.gWX > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gWX));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String auu() {
                return null;
            }
        };
        this.gWT = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().cw(this.gWA.getPageContext().getContext());
        this.gWT.a(this.gWA.getPageContext());
        this.gWT.b(this.gWY);
        this.gWT.e(this.gWA.getPageContext());
        this.gWT.atZ().fe(true);
        this.gWT.atZ().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gWT.atZ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gWT.atZ(), layoutParams);
            this.gWT.atZ().hide();
        }
        this.gWT.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void aux() {
                if (m.this.gWA.getBaseFragmentActivity() != null) {
                    m.this.gWA.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gWT.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y yVar, WriteData writeData, AntiData antiData) {
                if (m.this.gWA.getBaseFragmentActivity() != null) {
                    m.this.gWA.getBaseFragmentActivity().hideProgressBar();
                    m.this.gWT.atZ().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gWL.a(m.this.gWM);
                        m.this.gWL.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && yVar == null && !AntiHelper.aH(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gWA.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bFR() {
        this.gWH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gWA.getPageContext());
        this.gWI = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gWA.getPageContext());
        this.gWH.aS(this.gWA.getString(R.string.at_me), R.drawable.icon_im_at);
        uR(this.gWN);
        this.gWI.aS(this.gWA.getString(R.string.agree_me), R.drawable.icon_im_laud);
        uS(this.gWO);
        this.zj.addHeaderView(this.gWH.getView());
        this.zj.addHeaderView(this.gWI.getView());
        this.zj.setOnHeaderClickListener(this.gWQ);
    }

    public void onChangeSkinType(int i) {
        if (this.gWT != null && this.gWT.atZ() != null) {
            this.gWT.atZ().onChangeSkinType(i);
        }
        if (this.gWF != null) {
            this.gWF.setTextColor(am.getColor(R.color.cp_cont_d));
            this.gWF.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        if (this.gWH != null) {
            this.gWH.bnq();
        }
        if (this.gWI != null) {
            this.gWI.bnq();
        }
        notifyDataSetChanged();
        am.setBackgroundColor(this.zj, this.gWP);
        am.setBackgroundColor(this.dyk, R.color.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gWT == null || this.gWT.atZ() == null || this.gWT.atZ().getVisibility() != 0) {
            return false;
        }
        this.gWT.auV();
        return true;
    }

    public void mH(boolean z) {
        if (this.dyk != null) {
            if (z && this.zj != null && this.zj.getFirstVisiblePosition() != 0) {
                this.zj.setSelection(0);
            }
            this.dyk.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gWN = newsNotifyMessage.getMsgAtme();
            this.gWO = newsNotifyMessage.getMsgAgree();
            uR(this.gWN);
            uS(this.gWO);
        }
    }

    public void bFS() {
        uR(this.gWN);
        uS(this.gWO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uR(int i) {
        if (this.gWH != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.ara().arf()) {
                z = true;
            }
            this.gWH.K(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uS(int i) {
        if (this.gWI != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.ara().arr()) {
                z = true;
            }
            this.gWI.K(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gWT != null) {
            if (i == 12005) {
                this.gWT.auY();
            }
            this.gWT.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gWT.atZ().asC();
        this.gWT.auV();
        this.gWT.atZ().auj();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gWT.b(writeData);
                this.gWT.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k jL = this.gWT.atZ().jL(6);
                if (jL != null && jL.cFe != null) {
                    jL.cFe.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gWT.auR();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, long j) {
        if (this.fyU == null) {
            this.fyU = new com.baidu.tieba.frs.profession.permission.c(this.gWA.getPageContext());
            this.fyU.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jW(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void o(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jX(boolean z) {
                    if (z && m.this.gWT != null && m.this.gWU != null) {
                        if (!m.this.gWU.bFU() || m.this.gWU.getReplyer() == null) {
                            m.this.gWT.pQ(null);
                        } else {
                            m.this.gWT.pQ(m.this.gWU.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fyU.z(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gWT != null) {
            this.gWT.onDestory();
        }
        if (this.gWL != null) {
            this.gWL.onDestroy();
        }
        if (this.gWS != null) {
            this.gWS.a((ReplyMeModel.a) null);
            this.gWS.onDestroy();
        }
        if (this.gWL != null) {
            this.gWL.a((aj.a) null);
        }
    }

    public void e(s sVar) {
        if (this.gWG != null) {
            this.gWG.e(sVar);
        }
    }
}
