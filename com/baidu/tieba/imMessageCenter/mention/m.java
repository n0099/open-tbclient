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
    private BdSwipeRefreshLayout fGi;
    private final f.c fKL;
    private Runnable fjz;
    private com.baidu.tieba.frs.profession.permission.c hXk;
    private com.baidu.tieba.imMessageCenter.mention.base.f jEC;
    private boolean jED;
    private f.a jEE;
    private NavigationBarShadowView jEc;
    private View.OnClickListener jFA;
    private RecyclerView.OnScrollListener jFB;
    private ReplyMeModel jFC;
    private com.baidu.tbadk.editortools.pb.h jFD;
    private com.baidu.tieba.imMessageCenter.mention.base.a jFE;
    private String jFF;
    private long jFG;
    private long jFH;
    private DataModel<MessageCenterActivity> jFI;
    private NewWriteModel.d jFJ;
    private final ReplyMeModel.a jFK;
    private final ReplyMessageFragment jFp;
    private PbListView jFu;
    private com.baidu.tieba.imMessageCenter.mention.base.e jFv;
    private boolean jFw;
    private am jFx;
    private AttentionHostData jFy;
    private int jFz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jFz = R.color.cp_bg_line_c;
        this.jED = false;
        this.jFA = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.jFu != null && m.this.jFp != null) {
                    m.this.jFu.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jFu.setOnClickListener(null);
                    m.this.jFu.startLoadData();
                    m.this.jFp.cat();
                }
            }
        };
        this.fKL = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.jFp != null) {
                        m.this.jFp.cpa();
                    }
                } else if (m.this.fGi != null) {
                    m.this.fGi.setRefreshing(false);
                }
            }
        };
        this.jFB = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.jEc.show();
                            return;
                        } else {
                            m.this.jEc.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.jEc.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.jEE = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.jEC != null) {
                    m.this.Wu.removeHeaderView(m.this.jEC.getView());
                    m.this.jED = false;
                }
            }
        };
        this.jFC = null;
        this.fjz = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.jFD != null && m.this.jFD.bsC() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.jFD.bsC().getInputView());
                }
            }
        };
        this.jFK = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.jFF = str;
                m.this.jFG = j2;
                m.this.jFH = j3;
                m.this.H(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.jFD != null) {
                    m.this.jFD.bsy();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.jFp = replyMessageFragment;
        this.jFx = new am(replyMessageFragment.getPageContext());
        this.jFx.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z && m.this.jFD != null) {
                    m.this.jFD.bsu();
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
            rh(false);
            if (z) {
                this.jFu.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jFu.endLoadData();
                this.jFu.setOnClickListener(this.jFA);
            } else {
                this.jFu.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jFu.endLoadData();
                this.jFu.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.jFu.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dE(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jFw) {
                    this.jFw = true;
                    this.Wu.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Wu.setNextPage(null);
                if (arrayList != null) {
                    this.jFv.setData(arrayList);
                }
                this.jFz = R.color.cp_bg_line_e;
            } else {
                this.Wu.removeHeaderView(this.mNoDataView);
                this.jFw = false;
                if (this.jFv != null) {
                    this.jFv.setData(arrayList);
                    this.jFv.notifyDataSetChanged();
                }
                this.Wu.setNextPage(this.jFu);
                this.jFz = R.color.cp_bg_line_c;
            }
            cJE();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.jFv != null) {
            this.jFv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bS(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.jEc = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jFp.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fKL);
        }
        this.mPullView.setTag(this.jFp.getUniqueId());
        if (this.jFu == null) {
            this.jFu = new PbListView(this.jFp.getContext());
            this.jFu.getView();
        }
        this.jFu.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.jFu.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jFp.getContext(), R.dimen.tbds182));
        this.jFu.setLineGone();
        this.jFu.setTextSize(R.dimen.tbfontsize33);
        this.jFu.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.jFu.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jFu.setOnClickListener(this.jFA);
        this.fGi = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.fGi.setProgressView(this.mPullView);
        this.Wu = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.jFv = new com.baidu.tieba.imMessageCenter.mention.base.e(this.jFp.getPageContext(), this.Wu);
        this.jFv.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.rn(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.jFE = aVar;
                        if (aVar.cJY()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cJZ(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.jFy == null) {
                            m.this.jFy = new AttentionHostData();
                        }
                        if (m.this.jFE != null) {
                            m.this.jFy.parserWithMetaData(m.this.jFE.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.jFE != null) {
                            baijiahaoData = m.this.jFE.getBaijiahaoData();
                        }
                        m.this.jFC.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cKa() != null) {
                            aq ai = new aq(aVar.cKa()).ai("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jGl) {
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
        this.Wu.setNextPage(this.jFu);
        this.Wu.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.jFu != null) {
                    m.this.jFu.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jFu.setOnClickListener(null);
                    m.this.jFu.showLoading();
                    m.this.jFp.cat();
                }
            }
        });
        this.Wu.setOnScrollListener(this.mScrollListener);
        this.Wu.addOnScrollListener(this.jFB);
        cJV();
        this.jFC = new ReplyMeModel(this.jFp.getPageContext());
        this.jFC.a(this.jFK);
        cJW();
        rm(false);
        return this.mRootView;
    }

    private void cJV() {
        cJE();
    }

    private void cJE() {
        if (this.Wu != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.jFp.getFragmentActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.ai("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.jEC != null) {
                    this.Wu.removeHeaderView(this.jEC.getView());
                    this.jED = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bik().getLong("key_im_open_notification_close_time", 0L);
            if (this.jED) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jEC == null) {
                    this.jEC = new com.baidu.tieba.imMessageCenter.mention.base.f(this.jFp.getPageContext());
                    this.jEC.a(this.jEE);
                }
                this.Wu.addHeaderView(this.jEC.getView(), 0);
                this.jED = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jFD != null && this.jFD.brv() != null) {
            this.jFD.brv().onChangeSkinType(i);
        }
        if (this.jFu != null) {
            this.jFu.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.jFu.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.Wu, this.jFz);
        ap.setBackgroundColor(this.fGi, R.color.cp_bg_line_e);
        if (this.jEC != null) {
            this.jEC.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.jFD == null || this.jFD.brv() == null || this.jFD.brv().getVisibility() != 0) {
            return false;
        }
        this.jFD.bsy();
        return true;
    }

    public void rh(boolean z) {
        if (this.fGi != null) {
            if (z && this.Wu != null && this.Wu.getFirstVisiblePosition() != 0) {
                this.Wu.setSelection(0);
            }
            this.fGi.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cJW() {
        this.jFI = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.I(this.jFp.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean brR() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData BU(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.jFF);
                writeData.setThreadId(m.this.jFE.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.jFE.cJY()) {
                    writeData.setFloor(m.this.jFG > 0 ? String.valueOf(m.this.jFG) : m.this.jFE.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.jFE.getPost_id());
                }
                if (m.this.jFH > 0) {
                    writeData.setRepostId(String.valueOf(m.this.jFH));
                }
                if (m.this.jFE != null) {
                    writeData.setBaijiahaoData(m.this.jFE.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String brS() {
                return null;
            }
        };
        this.jFJ = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
                if (m.this.jFp.getBaseFragmentActivity() != null) {
                    m.this.jFp.getBaseFragmentActivity().hideProgressBar();
                    m.this.jFD.brv().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.jFx.a(m.this.jFy);
                        m.this.jFx.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && agVar == null && !AntiHelper.bz(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.jFp.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rm(boolean z) {
        if (this.jFD != null && this.jFD.brv() != null && this.jFD.brv().getParent() != null) {
            ((ViewGroup) this.jFD.brv().getParent()).removeView(this.jFD.brv());
        }
        this.jFD = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).ec(this.jFp.getPageContext().getPageActivity());
        this.jFD.a(this.jFp.getPageContext());
        this.jFD.b(this.jFI);
        this.jFD.j(this.jFp.getPageContext());
        this.jFD.brv().jh(true);
        this.jFD.brv().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jFD.brv() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.jFD.brv(), layoutParams);
            this.jFD.brv().hide();
        }
        this.jFD.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void brV() {
                if (m.this.jFp.getBaseFragmentActivity() != null) {
                    m.this.jFp.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.jFD.b(this.jFJ);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.jFD != null) {
            if (i == 12005) {
                this.jFD.bsB();
                com.baidu.adp.lib.f.e.mS().postDelayed(this.fjz, 300L);
            }
            this.jFD.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.jFD.brv().bpX();
        this.jFD.bsy();
        this.jFD.brv().brG();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jFD.b(writeData);
                this.jFD.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qe = this.jFD.brv().qe(6);
                if (qe != null && qe.eKx != null) {
                    qe.eKx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jFD.bsu();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, long j) {
        if (this.jFE != null && this.jFE.getBaijiahaoData() != null && this.jFE.isBjh()) {
            if (this.jFD == null || !this.jFD.isBJH) {
                rm(true);
            }
            if (this.jFD != null && this.jFE != null) {
                if (this.jFE.cJY() && this.jFE.getReplyer() != null) {
                    this.jFD.Ce(this.jFE.getReplyer().getName_show());
                    return;
                } else {
                    this.jFD.Ce(null);
                    return;
                }
            }
            return;
        }
        if (this.hXk == null) {
            this.hXk = new com.baidu.tieba.frs.profession.permission.c(this.jFp.getPageContext());
            this.hXk.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ou(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void z(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ov(boolean z) {
                    if (z) {
                        if (m.this.jFD == null || m.this.jFD.isBJH) {
                            m.this.rm(false);
                        }
                        if (m.this.jFD != null && m.this.jFE != null) {
                            if (!m.this.jFE.cJY() || m.this.jFE.getReplyer() == null) {
                                m.this.jFD.Ce(null);
                            } else {
                                m.this.jFD.Ce(m.this.jFE.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.hXk.C(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fjz);
        if (this.jFD != null) {
            this.jFD.onDestory();
        }
        if (this.jFx != null) {
            this.jFx.onDestroy();
        }
        if (this.jFC != null) {
            this.jFC.a((ReplyMeModel.a) null);
            this.jFC.onDestroy();
        }
        if (this.jFx != null) {
            this.jFx.a((am.a) null);
        }
    }

    public void e(ab abVar) {
        if (this.jFv != null) {
            this.jFv.e(abVar);
        }
    }

    public void b(ac acVar) {
        if (this.jFv != null) {
            this.jFv.a(acVar);
        }
    }

    public void onPrimary() {
        cJE();
    }

    public void BY(int i) {
        if (this.jFv != null) {
            this.jFv.BY(i);
        }
    }
}
