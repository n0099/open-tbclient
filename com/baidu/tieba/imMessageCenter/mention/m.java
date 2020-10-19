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
import com.baidu.tbadk.coreExtra.data.ah;
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
/* loaded from: classes22.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView Xc;
    private BdSwipeRefreshLayout fVP;
    private Runnable fyJ;
    private final f.c gav;
    private com.baidu.tieba.frs.profession.permission.c itr;
    private NavigationBarShadowView kbI;
    private final ReplyMessageFragment kcV;
    private com.baidu.tieba.imMessageCenter.mention.base.f kci;
    private boolean kcj;
    private f.a kck;
    private PbListView kda;
    private com.baidu.tieba.imMessageCenter.mention.base.e kdb;
    private boolean kdc;
    private am kdd;
    private AttentionHostData kde;
    private int kdf;
    private View.OnClickListener kdg;
    private RecyclerView.OnScrollListener kdh;
    private ReplyMeModel kdi;
    private com.baidu.tbadk.editortools.pb.h kdj;
    private com.baidu.tieba.imMessageCenter.mention.base.a kdk;
    private String kdl;
    private long kdm;
    private long kdn;
    private DataModel<MessageCenterActivity> kdo;
    private NewWriteModel.d kdp;
    private final ReplyMeModel.a kdq;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kdf = R.color.cp_bg_line_c;
        this.kcj = false;
        this.kdg = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kda != null && m.this.kcV != null) {
                    m.this.kda.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kda.setOnClickListener(null);
                    m.this.kda.startLoadData();
                    m.this.kcV.chc();
                }
            }
        };
        this.gav = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kcV != null) {
                        m.this.kcV.cvL();
                    }
                } else if (m.this.fVP != null) {
                    m.this.fVP.setRefreshing(false);
                }
            }
        };
        this.kdh = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kbI.show();
                            return;
                        } else {
                            m.this.kbI.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kbI.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kck = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.kci != null) {
                    m.this.Xc.removeHeaderView(m.this.kci.getView());
                    m.this.kcj = false;
                }
            }
        };
        this.kdi = null;
        this.fyJ = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kdj != null && m.this.kdj.bwr() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kdj.bwr().getInputView());
                }
            }
        };
        this.kdq = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kdl = str;
                m.this.kdm = j2;
                m.this.kdn = j3;
                m.this.I(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kdj != null) {
                    m.this.kdj.bwn();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kcV = replyMessageFragment;
        this.kdd = new am(replyMessageFragment.getPageContext());
        this.kdd.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z && m.this.kdj != null) {
                    m.this.kdj.bwj();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<q> arrayList) {
        if (this.Xc != null) {
            rX(false);
            if (z) {
                this.kda.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kda.endLoadData();
                this.kda.setOnClickListener(this.kdg);
            } else {
                this.kda.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kda.endLoadData();
                this.kda.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kda.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dL(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.kdc) {
                    this.kdc = true;
                    this.Xc.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Xc.setNextPage(null);
                if (arrayList != null) {
                    this.kdb.setData(arrayList);
                }
                this.kdf = R.color.cp_bg_line_e;
            } else {
                this.Xc.removeHeaderView(this.mNoDataView);
                this.kdc = false;
                if (this.kdb != null) {
                    this.kdb.setData(arrayList);
                    this.kdb.notifyDataSetChanged();
                }
                this.Xc.setNextPage(this.kda);
                this.kdf = R.color.cp_bg_line_c;
            }
            cQT();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kdb != null) {
            this.kdb.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bV(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kbI = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kcV.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gav);
        }
        this.mPullView.setTag(this.kcV.getUniqueId());
        if (this.kda == null) {
            this.kda = new PbListView(this.kcV.getContext());
            this.kda.getView();
        }
        this.kda.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.kda.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kcV.getContext(), R.dimen.tbds182));
        this.kda.setLineGone();
        this.kda.setTextSize(R.dimen.tbfontsize33);
        this.kda.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kda.setNoMoreTextColorId(R.color.cp_cont_e);
        this.kda.setOnClickListener(this.kdg);
        this.fVP = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.fVP.setProgressView(this.mPullView);
        this.Xc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kdb = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kcV.getPageContext(), this.Xc);
        this.kdb.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                        aVar.sd(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.kdk = aVar;
                        if (aVar.cRn()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cRo(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kde == null) {
                            m.this.kde = new AttentionHostData();
                        }
                        if (m.this.kdk != null) {
                            m.this.kde.parserWithMetaData(m.this.kdk.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kdk != null) {
                            baijiahaoData = m.this.kdk.getBaijiahaoData();
                        }
                        m.this.kdi.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cRp() != null) {
                            aq aj = new aq(aVar.cRp()).aj("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kdR) {
                                aj.aj("obj_type", 1);
                            } else {
                                aj.aj("obj_type", 2);
                            }
                            TiebaStatic.log(aj);
                        }
                        aq aqVar = new aq("c13784");
                        aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Xc.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Xc.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Xc.setFadingEdgeLength(0);
        this.Xc.setOverScrollMode(2);
        this.Xc.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Xc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Xc.setNextPage(this.kda);
        this.Xc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.kda != null) {
                    m.this.kda.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kda.setOnClickListener(null);
                    m.this.kda.showLoading();
                    m.this.kcV.chc();
                }
            }
        });
        this.Xc.setOnScrollListener(this.mScrollListener);
        this.Xc.addOnScrollListener(this.kdh);
        cRk();
        this.kdi = new ReplyMeModel(this.kcV.getPageContext());
        this.kdi.a(this.kdq);
        cRl();
        sc(false);
        return this.mRootView;
    }

    private void cRk() {
        cQT();
    }

    private void cQT() {
        if (this.Xc != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kcV.getFragmentActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.aj("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.kci != null) {
                    this.Xc.removeHeaderView(this.kci.getView());
                    this.kcj = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.blO().getLong("key_im_open_notification_close_time", 0L);
            if (this.kcj) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kci == null) {
                    this.kci = new com.baidu.tieba.imMessageCenter.mention.base.f(this.kcV.getPageContext());
                    this.kci.a(this.kck);
                }
                this.Xc.addHeaderView(this.kci.getView(), 0);
                this.kcj = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kdj != null && this.kdj.bvf() != null) {
            this.kdj.bvf().onChangeSkinType(i);
        }
        if (this.kda != null) {
            this.kda.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.kda.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.Xc, this.kdf);
        ap.setBackgroundColor(this.fVP, R.color.cp_bg_line_e);
        if (this.kci != null) {
            this.kci.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kdj == null || this.kdj.bvf() == null || this.kdj.bvf().getVisibility() != 0) {
            return false;
        }
        this.kdj.bwn();
        return true;
    }

    public void rX(boolean z) {
        if (this.fVP != null) {
            if (z && this.Xc != null && this.Xc.getFirstVisiblePosition() != 0) {
                this.Xc.setSelection(0);
            }
            this.fVP.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cRl() {
        this.kdo = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.I(this.kcV.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bvG() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData Dd(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kdl);
                writeData.setThreadId(m.this.kdk.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kdk.cRn()) {
                    writeData.setFloor(m.this.kdm > 0 ? String.valueOf(m.this.kdm) : m.this.kdk.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kdk.getPost_id());
                }
                if (m.this.kdn > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kdn));
                }
                if (m.this.kdk != null) {
                    writeData.setBaijiahaoData(m.this.kdk.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bvH() {
                return null;
            }
        };
        this.kdp = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kcV.getBaseFragmentActivity() != null) {
                    m.this.kcV.getBaseFragmentActivity().hideProgressBar();
                    m.this.kdj.bvf().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kdd.a(m.this.kde);
                        m.this.kdd.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bM(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kcV.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(boolean z) {
        if (this.kdj != null && this.kdj.bvf() != null && this.kdj.bvf().getParent() != null) {
            ((ViewGroup) this.kdj.bvf().getParent()).removeView(this.kdj.bvf());
        }
        this.kdj = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).ei(this.kcV.getPageContext().getPageActivity());
        this.kdj.a(this.kcV.getPageContext());
        this.kdj.b(this.kdo);
        this.kdj.setFrom(3);
        this.kdj.j(this.kcV.getPageContext());
        this.kdj.bvf().jF(true);
        this.kdj.bvf().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kdj.bvf() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kdj.bvf(), layoutParams);
            this.kdj.bvf().hide();
        }
        this.kdj.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bvK() {
                if (m.this.kcV.getBaseFragmentActivity() != null) {
                    m.this.kcV.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kdj.b(this.kdp);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kdj != null) {
            if (i == 12005) {
                this.kdj.bwq();
                com.baidu.adp.lib.f.e.mY().postDelayed(this.fyJ, 300L);
            }
            this.kdj.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kdj.bvf().btC();
        this.kdj.bwn();
        this.kdj.bvf().bvs();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kdj.b(writeData);
                this.kdj.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qP = this.kdj.bvf().qP(6);
                if (qP != null && qP.eYZ != null) {
                    qP.eYZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kdj.bwj();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, long j) {
        if (this.kdk != null && this.kdk.getBaijiahaoData() != null && this.kdk.isBjh()) {
            if (this.kdj == null || !this.kdj.isBJH) {
                sc(true);
            }
            if (this.kdj != null && this.kdk != null) {
                if (this.kdk.cRn() && this.kdk.getReplyer() != null) {
                    this.kdj.Dn(this.kdk.getReplyer().getName_show());
                    return;
                } else {
                    this.kdj.Dn(null);
                    return;
                }
            }
            return;
        }
        if (this.itr == null) {
            this.itr = new com.baidu.tieba.frs.profession.permission.c(this.kcV.getPageContext());
            this.itr.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void ph(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void C(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pi(boolean z) {
                    if (z) {
                        if (m.this.kdj == null || m.this.kdj.isBJH) {
                            m.this.sc(false);
                        }
                        if (m.this.kdj != null && m.this.kdk != null) {
                            if (!m.this.kdk.cRn() || m.this.kdk.getReplyer() == null) {
                                m.this.kdj.Dn(null);
                            } else {
                                m.this.kdj.Dn(m.this.kdk.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.itr.D(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fyJ);
        if (this.kdj != null) {
            this.kdj.onDestory();
        }
        if (this.kdd != null) {
            this.kdd.onDestroy();
        }
        if (this.kdi != null) {
            this.kdi.a((ReplyMeModel.a) null);
            this.kdi.onDestroy();
        }
        if (this.kdd != null) {
            this.kdd.a((am.a) null);
        }
    }

    public void e(ab abVar) {
        if (this.kdb != null) {
            this.kdb.e(abVar);
        }
    }

    public void b(ac acVar) {
        if (this.kdb != null) {
            this.kdb.a(acVar);
        }
    }

    public void onPrimary() {
        cQT();
    }

    public void Df(int i) {
        if (this.kdb != null) {
            this.kdb.Df(i);
        }
    }
}
