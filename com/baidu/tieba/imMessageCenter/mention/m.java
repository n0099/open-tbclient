package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.ac;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.imMessageCenter.mention.base.f;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView Wu;
    private BdSwipeRefreshLayout fGm;
    private final f.c fKP;
    private Runnable fjD;
    private com.baidu.tieba.frs.profession.permission.c hXq;
    private com.baidu.tieba.imMessageCenter.mention.base.f jEI;
    private boolean jEJ;
    private f.a jEK;
    private NavigationBarShadowView jEi;
    private PbListView jFA;
    private com.baidu.tieba.imMessageCenter.mention.base.e jFB;
    private boolean jFC;
    private am jFD;
    private AttentionHostData jFE;
    private int jFF;
    private View.OnClickListener jFG;
    private RecyclerView.OnScrollListener jFH;
    private ReplyMeModel jFI;
    private com.baidu.tbadk.editortools.pb.h jFJ;
    private com.baidu.tieba.imMessageCenter.mention.base.a jFK;
    private String jFL;
    private long jFM;
    private long jFN;
    private DataModel<MessageCenterActivity> jFO;
    private NewWriteModel.d jFP;
    private final ReplyMeModel.a jFQ;
    private final ReplyMessageFragment jFv;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jFF = R.color.cp_bg_line_c;
        this.jEJ = false;
        this.jFG = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.jFA != null && m.this.jFv != null) {
                    m.this.jFA.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jFA.setOnClickListener(null);
                    m.this.jFA.startLoadData();
                    m.this.jFv.cau();
                }
            }
        };
        this.fKP = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.jFv != null) {
                        m.this.jFv.cpb();
                    }
                } else if (m.this.fGm != null) {
                    m.this.fGm.setRefreshing(false);
                }
            }
        };
        this.jFH = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.jEi.show();
                            return;
                        } else {
                            m.this.jEi.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.jEi.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.jEK = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.jEI != null) {
                    m.this.Wu.removeHeaderView(m.this.jEI.getView());
                    m.this.jEJ = false;
                }
            }
        };
        this.jFI = null;
        this.fjD = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.jFJ != null && m.this.jFJ.bsD() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.jFJ.bsD().getInputView());
                }
            }
        };
        this.jFQ = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.jFL = str;
                m.this.jFM = j2;
                m.this.jFN = j3;
                m.this.H(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.jFJ != null) {
                    m.this.jFJ.bsz();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.jFv = replyMessageFragment;
        this.jFD = new am(replyMessageFragment.getPageContext());
        this.jFD.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z && m.this.jFJ != null) {
                    m.this.jFJ.bsv();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<q> arrayList) {
        if (this.Wu != null) {
            rj(false);
            if (z) {
                this.jFA.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jFA.endLoadData();
                this.jFA.setOnClickListener(this.jFG);
            } else {
                this.jFA.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jFA.endLoadData();
                this.jFA.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.jFA.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dE(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jFC) {
                    this.jFC = true;
                    this.Wu.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Wu.setNextPage(null);
                if (arrayList != null) {
                    this.jFB.setData(arrayList);
                }
                this.jFF = R.color.cp_bg_line_e;
            } else {
                this.Wu.removeHeaderView(this.mNoDataView);
                this.jFC = false;
                if (this.jFB != null) {
                    this.jFB.setData(arrayList);
                    this.jFB.notifyDataSetChanged();
                }
                this.Wu.setNextPage(this.jFA);
                this.jFF = R.color.cp_bg_line_c;
            }
            cJF();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.jFB != null) {
            this.jFB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bS(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.jEi = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jFv.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fKP);
        }
        this.mPullView.setTag(this.jFv.getUniqueId());
        if (this.jFA == null) {
            this.jFA = new PbListView(this.jFv.getContext());
            this.jFA.getView();
        }
        this.jFA.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.jFA.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jFv.getContext(), R.dimen.tbds182));
        this.jFA.setLineGone();
        this.jFA.setTextSize(R.dimen.tbfontsize33);
        this.jFA.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.jFA.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jFA.setOnClickListener(this.jFG);
        this.fGm = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.fGm.setProgressView(this.mPullView);
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.jFB = new com.baidu.tieba.imMessageCenter.mention.base.e(this.jFv.getPageContext(), this.Wu);
        this.jFB.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.rp(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.jFK = aVar;
                        if (aVar.cJZ()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cKa(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.jFE == null) {
                            m.this.jFE = new AttentionHostData();
                        }
                        if (m.this.jFK != null) {
                            m.this.jFE.parserWithMetaData(m.this.jFK.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.jFK != null) {
                            baijiahaoData = m.this.jFK.getBaijiahaoData();
                        }
                        m.this.jFI.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cKb() != null) {
                            aq ai = new aq(aVar.cKb()).ai("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jGr) {
                                ai.ai("obj_type", 1);
                            } else {
                                ai.ai("obj_type", 2);
                            }
                            TiebaStatic.log(ai);
                        }
                        aq aqVar = new aq("c13784");
                        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Wu.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Wu.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Wu.setFadingEdgeLength(0);
        this.Wu.setOverScrollMode(2);
        this.Wu.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Wu.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Wu.setNextPage(this.jFA);
        this.Wu.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.jFA != null) {
                    m.this.jFA.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jFA.setOnClickListener(null);
                    m.this.jFA.showLoading();
                    m.this.jFv.cau();
                }
            }
        });
        this.Wu.setOnScrollListener(this.mScrollListener);
        this.Wu.addOnScrollListener(this.jFH);
        cJW();
        this.jFI = new ReplyMeModel(this.jFv.getPageContext());
        this.jFI.a(this.jFQ);
        cJX();
        ro(false);
        return this.mRootView;
    }

    private void cJW() {
        cJF();
    }

    private void cJF() {
        if (this.Wu != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.jFv.getFragmentActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.ai("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.jEI != null) {
                    this.Wu.removeHeaderView(this.jEI.getView());
                    this.jEJ = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_im_open_notification_close_time", 0L);
            if (this.jEJ) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jEI == null) {
                    this.jEI = new com.baidu.tieba.imMessageCenter.mention.base.f(this.jFv.getPageContext());
                    this.jEI.a(this.jEK);
                }
                this.Wu.addHeaderView(this.jEI.getView(), 0);
                this.jEJ = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jFJ != null && this.jFJ.brw() != null) {
            this.jFJ.brw().onChangeSkinType(i);
        }
        if (this.jFA != null) {
            this.jFA.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.jFA.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.Wu, this.jFF);
        ap.setBackgroundColor(this.fGm, R.color.cp_bg_line_e);
        if (this.jEI != null) {
            this.jEI.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.jFJ == null || this.jFJ.brw() == null || this.jFJ.brw().getVisibility() != 0) {
            return false;
        }
        this.jFJ.bsz();
        return true;
    }

    public void rj(boolean z) {
        if (this.fGm != null) {
            if (z && this.Wu != null && this.Wu.getFirstVisiblePosition() != 0) {
                this.Wu.setSelection(0);
            }
            this.fGm.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cJX() {
        this.jFO = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.I(this.jFv.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean brS() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData BV(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.jFL);
                writeData.setThreadId(m.this.jFK.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.jFK.cJZ()) {
                    writeData.setFloor(m.this.jFM > 0 ? String.valueOf(m.this.jFM) : m.this.jFK.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.jFK.getPost_id());
                }
                if (m.this.jFN > 0) {
                    writeData.setRepostId(String.valueOf(m.this.jFN));
                }
                if (m.this.jFK != null) {
                    writeData.setBaijiahaoData(m.this.jFK.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String brT() {
                return null;
            }
        };
        this.jFP = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                if (m.this.jFv.getBaseFragmentActivity() != null) {
                    m.this.jFv.getBaseFragmentActivity().hideProgressBar();
                    m.this.jFJ.brw().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.jFD.a(m.this.jFE);
                        m.this.jFD.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && agVar == null && !AntiHelper.by(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.jFv.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ro(boolean z) {
        if (this.jFJ != null && this.jFJ.brw() != null && this.jFJ.brw().getParent() != null) {
            ((ViewGroup) this.jFJ.brw().getParent()).removeView(this.jFJ.brw());
        }
        this.jFJ = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).ec(this.jFv.getPageContext().getPageActivity());
        this.jFJ.a(this.jFv.getPageContext());
        this.jFJ.b(this.jFO);
        this.jFJ.j(this.jFv.getPageContext());
        this.jFJ.brw().jj(true);
        this.jFJ.brw().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jFJ.brw() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.jFJ.brw(), layoutParams);
            this.jFJ.brw().hide();
        }
        this.jFJ.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void brW() {
                if (m.this.jFv.getBaseFragmentActivity() != null) {
                    m.this.jFv.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.jFJ.b(this.jFP);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.jFJ != null) {
            if (i == 12005) {
                this.jFJ.bsC();
                com.baidu.adp.lib.f.e.mS().postDelayed(this.fjD, 300L);
            }
            this.jFJ.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.jFJ.brw().bpY();
        this.jFJ.bsz();
        this.jFJ.brw().brH();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jFJ.b(writeData);
                this.jFJ.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qe = this.jFJ.brw().qe(6);
                if (qe != null && qe.eKB != null) {
                    qe.eKB.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jFJ.bsv();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, long j) {
        if (this.jFK != null && this.jFK.getBaijiahaoData() != null && this.jFK.isBjh()) {
            if (this.jFJ == null || !this.jFJ.isBJH) {
                ro(true);
            }
            if (this.jFJ != null && this.jFK != null) {
                if (this.jFK.cJZ() && this.jFK.getReplyer() != null) {
                    this.jFJ.Cf(this.jFK.getReplyer().getName_show());
                    return;
                } else {
                    this.jFJ.Cf(null);
                    return;
                }
            }
            return;
        }
        if (this.hXq == null) {
            this.hXq = new com.baidu.tieba.frs.profession.permission.c(this.jFv.getPageContext());
            this.hXq.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ow(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void z(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ox(boolean z) {
                    if (z) {
                        if (m.this.jFJ == null || m.this.jFJ.isBJH) {
                            m.this.ro(false);
                        }
                        if (m.this.jFJ != null && m.this.jFK != null) {
                            if (!m.this.jFK.cJZ() || m.this.jFK.getReplyer() == null) {
                                m.this.jFJ.Cf(null);
                            } else {
                                m.this.jFJ.Cf(m.this.jFK.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.hXq.C(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fjD);
        if (this.jFJ != null) {
            this.jFJ.onDestory();
        }
        if (this.jFD != null) {
            this.jFD.onDestroy();
        }
        if (this.jFI != null) {
            this.jFI.a((ReplyMeModel.a) null);
            this.jFI.onDestroy();
        }
        if (this.jFD != null) {
            this.jFD.a((am.a) null);
        }
    }

    public void e(ab abVar) {
        if (this.jFB != null) {
            this.jFB.e(abVar);
        }
    }

    public void b(ac acVar) {
        if (this.jFB != null) {
            this.jFB.a(acVar);
        }
    }

    public void onPrimary() {
        cJF();
    }

    public void BY(int i) {
        if (this.jFB != null) {
            this.jFB.BY(i);
        }
    }
}
