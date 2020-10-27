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
import com.baidu.tieba.card.ab;
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
    private BdTypeRecyclerView Xe;
    private Runnable fHe;
    private BdSwipeRefreshLayout gfT;
    private final f.c gkz;
    private com.baidu.tieba.frs.profession.permission.c iFN;
    private com.baidu.tieba.imMessageCenter.mention.base.f koH;
    private boolean koI;
    private f.a koJ;
    private NavigationBarShadowView koh;
    private com.baidu.tieba.imMessageCenter.mention.base.e kpA;
    private boolean kpB;
    private am kpC;
    private AttentionHostData kpD;
    private int kpE;
    private View.OnClickListener kpF;
    private RecyclerView.OnScrollListener kpG;
    private ReplyMeModel kpH;
    private com.baidu.tbadk.editortools.pb.h kpI;
    private com.baidu.tieba.imMessageCenter.mention.base.a kpJ;
    private String kpK;
    private long kpL;
    private long kpM;
    private DataModel<MessageCenterActivity> kpN;
    private NewWriteModel.d kpO;
    private final ReplyMeModel.a kpP;
    private final ReplyMessageFragment kpu;
    private PbListView kpz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kpE = R.color.cp_bg_line_c;
        this.koI = false;
        this.kpF = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kpz != null && m.this.kpu != null) {
                    m.this.kpz.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kpz.setOnClickListener(null);
                    m.this.kpz.startLoadData();
                    m.this.kpu.ckj();
                }
            }
        };
        this.gkz = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kpu != null) {
                        m.this.kpu.cyS();
                    }
                } else if (m.this.gfT != null) {
                    m.this.gfT.setRefreshing(false);
                }
            }
        };
        this.kpG = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.koh.show();
                            return;
                        } else {
                            m.this.koh.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.koh.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.koJ = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.koH != null) {
                    m.this.Xe.removeHeaderView(m.this.koH.getView());
                    m.this.koI = false;
                }
            }
        };
        this.kpH = null;
        this.fHe = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kpI != null && m.this.kpI.byk() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kpI.byk().getInputView());
                }
            }
        };
        this.kpP = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kpK = str;
                m.this.kpL = j2;
                m.this.kpM = j3;
                m.this.L(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kpI != null) {
                    m.this.kpI.byg();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kpu = replyMessageFragment;
        this.kpC = new am(replyMessageFragment.getPageContext());
        this.kpC.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z && m.this.kpI != null) {
                    m.this.kpI.byc();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<q> arrayList) {
        if (this.Xe != null) {
            sp(false);
            if (z) {
                this.kpz.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kpz.endLoadData();
                this.kpz.setOnClickListener(this.kpF);
            } else {
                this.kpz.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kpz.endLoadData();
                this.kpz.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kpz.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dS(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.kpB) {
                    this.kpB = true;
                    this.Xe.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Xe.setNextPage(null);
                if (arrayList != null) {
                    this.kpA.setData(arrayList);
                }
                this.kpE = R.color.cp_bg_line_e;
            } else {
                this.Xe.removeHeaderView(this.mNoDataView);
                this.kpB = false;
                if (this.kpA != null) {
                    this.kpA.setData(arrayList);
                    this.kpA.notifyDataSetChanged();
                }
                this.Xe.setNextPage(this.kpz);
                this.kpE = R.color.cp_bg_line_c;
            }
            cUa();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kpA != null) {
            this.kpA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bW(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.koh = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kpu.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gkz);
        }
        this.mPullView.setTag(this.kpu.getUniqueId());
        if (this.kpz == null) {
            this.kpz = new PbListView(this.kpu.getContext());
            this.kpz.getView();
        }
        this.kpz.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.kpz.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kpu.getContext(), R.dimen.tbds182));
        this.kpz.setLineGone();
        this.kpz.setTextSize(R.dimen.tbfontsize33);
        this.kpz.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kpz.setNoMoreTextColorId(R.color.cp_cont_e);
        this.kpz.setOnClickListener(this.kpF);
        this.gfT = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.gfT.setProgressView(this.mPullView);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kpA = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kpu.getPageContext(), this.Xe);
        this.kpA.setOnCardSubClickListener(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                        aVar.sv(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.kpJ = aVar;
                        if (aVar.cUu()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cUv(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kpD == null) {
                            m.this.kpD = new AttentionHostData();
                        }
                        if (m.this.kpJ != null) {
                            m.this.kpD.parserWithMetaData(m.this.kpJ.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kpJ != null) {
                            baijiahaoData = m.this.kpJ.getBaijiahaoData();
                        }
                        m.this.kpH.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cUw() != null) {
                            aq aj = new aq(aVar.cUw()).aj("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kqq) {
                                aj.aj("obj_type", 1);
                            } else {
                                aj.aj("obj_type", 2);
                            }
                            TiebaStatic.log(aj);
                        }
                        aq aqVar = new aq("c13784");
                        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Xe.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Xe.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Xe.setFadingEdgeLength(0);
        this.Xe.setOverScrollMode(2);
        this.Xe.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Xe.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Xe.setNextPage(this.kpz);
        this.Xe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.kpz != null) {
                    m.this.kpz.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kpz.setOnClickListener(null);
                    m.this.kpz.showLoading();
                    m.this.kpu.ckj();
                }
            }
        });
        this.Xe.setOnScrollListener(this.mScrollListener);
        this.Xe.addOnScrollListener(this.kpG);
        cUr();
        this.kpH = new ReplyMeModel(this.kpu.getPageContext());
        this.kpH.a(this.kpP);
        cUs();
        su(false);
        return this.mRootView;
    }

    private void cUr() {
        cUa();
    }

    private void cUa() {
        if (this.Xe != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kpu.getFragmentActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.aj("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.koH != null) {
                    this.Xe.removeHeaderView(this.koH.getView());
                    this.koI = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bnH().getLong("key_im_open_notification_close_time", 0L);
            if (this.koI) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.koH == null) {
                    this.koH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.kpu.getPageContext());
                    this.koH.a(this.koJ);
                }
                this.Xe.addHeaderView(this.koH.getView(), 0);
                this.koI = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kpI != null && this.kpI.bwY() != null) {
            this.kpI.bwY().onChangeSkinType(i);
        }
        if (this.kpz != null) {
            this.kpz.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.kpz.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.Xe, this.kpE);
        ap.setBackgroundColor(this.gfT, R.color.cp_bg_line_e);
        if (this.koH != null) {
            this.koH.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kpI == null || this.kpI.bwY() == null || this.kpI.bwY().getVisibility() != 0) {
            return false;
        }
        this.kpI.byg();
        return true;
    }

    public void sp(boolean z) {
        if (this.gfT != null) {
            if (z && this.Xe != null && this.Xe.getFirstVisiblePosition() != 0) {
                this.Xe.setSelection(0);
            }
            this.gfT.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cUs() {
        this.kpN = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.I(this.kpu.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bxz() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData Dw(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kpK);
                writeData.setThreadId(m.this.kpJ.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kpJ.cUu()) {
                    writeData.setFloor(m.this.kpL > 0 ? String.valueOf(m.this.kpL) : m.this.kpJ.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kpJ.getPost_id());
                }
                if (m.this.kpM > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kpM));
                }
                if (m.this.kpJ != null) {
                    writeData.setBaijiahaoData(m.this.kpJ.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bxA() {
                return null;
            }
        };
        this.kpO = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kpu.getBaseFragmentActivity() != null) {
                    m.this.kpu.getBaseFragmentActivity().hideProgressBar();
                    m.this.kpI.bwY().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kpC.a(m.this.kpD);
                        m.this.kpC.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bN(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kpu.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void su(boolean z) {
        if (this.kpI != null && this.kpI.bwY() != null && this.kpI.bwY().getParent() != null) {
            ((ViewGroup) this.kpI.bwY().getParent()).removeView(this.kpI.bwY());
        }
        this.kpI = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).ei(this.kpu.getPageContext().getPageActivity());
        this.kpI.a(this.kpu.getPageContext());
        this.kpI.b(this.kpN);
        this.kpI.setFrom(3);
        this.kpI.j(this.kpu.getPageContext());
        this.kpI.bwY().jS(true);
        this.kpI.bwY().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kpI.bwY() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kpI.bwY(), layoutParams);
            this.kpI.bwY().hide();
        }
        this.kpI.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bxD() {
                if (m.this.kpu.getBaseFragmentActivity() != null) {
                    m.this.kpu.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kpI.b(this.kpO);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kpI != null) {
            if (i == 12005) {
                this.kpI.byj();
                com.baidu.adp.lib.f.e.mY().postDelayed(this.fHe, 300L);
            }
            this.kpI.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kpI.bwY().bvv();
        this.kpI.byg();
        this.kpI.bwY().bxl();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kpI.b(writeData);
                this.kpI.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m ra = this.kpI.bwY().ra(6);
                if (ra != null && ra.fhv != null) {
                    ra.fhv.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kpI.byc();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, long j) {
        if (this.kpJ != null && this.kpJ.getBaijiahaoData() != null && this.kpJ.isBjh()) {
            if (this.kpI == null || !this.kpI.isBJH) {
                su(true);
            }
            if (this.kpI != null && this.kpJ != null) {
                if (this.kpJ.cUu() && this.kpJ.getReplyer() != null) {
                    this.kpI.DG(this.kpJ.getReplyer().getName_show());
                    return;
                } else {
                    this.kpI.DG(null);
                    return;
                }
            }
            return;
        }
        if (this.iFN == null) {
            this.iFN = new com.baidu.tieba.frs.profession.permission.c(this.kpu.getPageContext());
            this.iFN.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pz(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void C(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pA(boolean z) {
                    if (z) {
                        if (m.this.kpI == null || m.this.kpI.isBJH) {
                            m.this.su(false);
                        }
                        if (m.this.kpI != null && m.this.kpJ != null) {
                            if (!m.this.kpJ.cUu() || m.this.kpJ.getReplyer() == null) {
                                m.this.kpI.DG(null);
                            } else {
                                m.this.kpI.DG(m.this.kpJ.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.iFN.G(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fHe);
        if (this.kpI != null) {
            this.kpI.onDestory();
        }
        if (this.kpC != null) {
            this.kpC.onDestroy();
        }
        if (this.kpH != null) {
            this.kpH.a((ReplyMeModel.a) null);
            this.kpH.onDestroy();
        }
        if (this.kpC != null) {
            this.kpC.a((am.a) null);
        }
    }

    public void e(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.kpA != null) {
            this.kpA.e(abVar);
        }
    }

    public void b(ac acVar) {
        if (this.kpA != null) {
            this.kpA.a(acVar);
        }
    }

    public void onPrimary() {
        cUa();
    }

    public void Dy(int i) {
        if (this.kpA != null) {
            this.kpA.Dy(i);
        }
    }
}
