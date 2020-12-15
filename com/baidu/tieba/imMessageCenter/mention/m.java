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
import com.baidu.tbadk.core.util.ar;
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
import com.baidu.tieba.card.data.BaseCardInfo;
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
    private BdTypeRecyclerView Yf;
    private Runnable fUi;
    private BdSwipeRefreshLayout gtA;
    private final f.c gye;
    private com.baidu.tieba.frs.profession.permission.c iXq;
    private com.baidu.tieba.imMessageCenter.mention.base.f kIJ;
    private boolean kIK;
    private f.a kIL;
    private NavigationBarShadowView kIj;
    private PbListView kJB;
    private com.baidu.tieba.imMessageCenter.mention.base.e kJC;
    private boolean kJD;
    private am kJE;
    private AttentionHostData kJF;
    private int kJG;
    private View.OnClickListener kJH;
    private RecyclerView.OnScrollListener kJI;
    private ReplyMeModel kJJ;
    private com.baidu.tbadk.editortools.pb.h kJK;
    private com.baidu.tieba.imMessageCenter.mention.base.a kJL;
    private String kJM;
    private long kJN;
    private long kJO;
    private DataModel<MessageCenterActivity> kJP;
    private NewWriteModel.d kJQ;
    private final ReplyMeModel.a kJR;
    private final ReplyMessageFragment kJw;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kJG = R.color.CAM_X0204;
        this.kIK = false;
        this.kJH = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kJB != null && m.this.kJw != null) {
                    m.this.kJB.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kJB.setOnClickListener(null);
                    m.this.kJB.startLoadData();
                    m.this.kJw.cqB();
                }
            }
        };
        this.gye = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kJw != null) {
                        m.this.kJw.cFn();
                    }
                } else if (m.this.gtA != null) {
                    m.this.gtA.setRefreshing(false);
                }
            }
        };
        this.kJI = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kIj.show();
                            return;
                        } else {
                            m.this.kIj.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kIj.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kIL = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.kIJ != null) {
                    m.this.Yf.removeHeaderView(m.this.kIJ.getView());
                    m.this.kIK = false;
                }
            }
        };
        this.kJJ = null;
        this.fUi = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kJK != null && m.this.kJK.bDz() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kJK.bDz().getInputView());
                }
            }
        };
        this.kJR = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kJM = str;
                m.this.kJN = j2;
                m.this.kJO = j3;
                m.this.L(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kJK != null) {
                    m.this.kJK.bDv();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kJw = replyMessageFragment;
        this.kJE = new am(replyMessageFragment.getPageContext());
        this.kJE.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z && m.this.kJK != null) {
                    m.this.kJK.bDr();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<q> arrayList) {
        if (this.Yf != null) {
            this.gtA.setVisibility(0);
            td(false);
            if (z) {
                this.kJB.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kJB.endLoadData();
                this.kJB.setOnClickListener(this.kJH);
            } else {
                this.kJB.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kJB.endLoadData();
                this.kJB.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kJB.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dZ(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kJD) {
                    this.kJD = true;
                    this.Yf.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Yf.setNextPage(null);
                if (arrayList != null) {
                    this.kJC.setData(arrayList);
                }
                this.kJG = R.color.CAM_X0205;
            } else {
                this.Yf.removeHeaderView(this.mNoDataView);
                this.kJD = false;
                if (this.kJC != null) {
                    this.kJC.setData(arrayList);
                    this.kJC.notifyDataSetChanged();
                }
                this.Yf.setNextPage(this.kJB);
                this.kJG = R.color.CAM_X0204;
            }
            dbu();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kJC != null) {
            this.kJC.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bX(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kIj = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kJw.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gye);
        }
        this.mPullView.setTag(this.kJw.getUniqueId());
        if (this.kJB == null) {
            this.kJB = new PbListView(this.kJw.getContext());
            this.kJB.getView();
        }
        this.kJB.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.kJB.bvh();
        this.kJB.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kJw.getContext(), R.dimen.tbds182));
        this.kJB.setLineGone();
        this.kJB.setTextSize(R.dimen.tbfontsize33);
        this.kJB.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.kJB.setNoMoreTextColorId(R.color.CAM_X0110);
        this.kJB.setOnClickListener(this.kJH);
        this.gtA = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.gtA.setProgressView(this.mPullView);
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kJC = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kJw.getPageContext(), this.Yf);
        this.kJC.setOnCardSubClickListener(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo) {
                long j;
                if (view != null && (baseCardInfo instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) baseCardInfo;
                    if (aVar.isNew() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                        aVar.tj(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.kJL = aVar;
                        if (aVar.dbP()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.dbQ(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kJF == null) {
                            m.this.kJF = new AttentionHostData();
                        }
                        if (m.this.kJL != null) {
                            m.this.kJF.parserWithMetaData(m.this.kJL.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kJL != null) {
                            baijiahaoData = m.this.kJL.getBaijiahaoData();
                        }
                        m.this.kJJ.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.dbR() != null) {
                            ar al = new ar(aVar.dbR()).al("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kKs) {
                                al.al("obj_type", 1);
                            } else {
                                al.al("obj_type", 2);
                            }
                            TiebaStatic.log(al);
                        }
                        ar arVar = new ar("c13784");
                        arVar.w("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Yf.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Yf.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Yf.setFadingEdgeLength(0);
        this.Yf.setOverScrollMode(2);
        this.Yf.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Yf.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Yf.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.kJB != null) {
                    m.this.kJB.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kJB.setOnClickListener(null);
                    m.this.kJB.showLoading();
                    m.this.kJw.cqB();
                }
            }
        });
        this.Yf.setOnScrollListener(this.mScrollListener);
        this.Yf.addOnScrollListener(this.kJI);
        dbL();
        this.kJJ = new ReplyMeModel(this.kJw.getPageContext());
        this.kJJ.a(this.kJR);
        dbM();
        ti(false);
        return this.mRootView;
    }

    private void dbL() {
        dbu();
    }

    private void dbu() {
        if (this.Yf != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kJw.getFragmentActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.al("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kIJ != null) {
                    this.Yf.removeHeaderView(this.kIJ.getView());
                    this.kIK = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_im_open_notification_close_time", 0L);
            if (this.kIK) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kIJ == null) {
                    this.kIJ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.kJw.getPageContext());
                    this.kIJ.a(this.kIL);
                }
                this.Yf.addHeaderView(this.kIJ.getView(), 0);
                this.kIK = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kJK != null && this.kJK.bCn() != null) {
            this.kJK.bCn().onChangeSkinType(i);
        }
        if (this.kJB != null) {
            this.kJB.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.kJB.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.Yf, this.kJG);
        ap.setBackgroundColor(this.gtA, R.color.CAM_X0205);
        if (this.kIJ != null) {
            this.kIJ.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kJK == null || this.kJK.bCn() == null || this.kJK.bCn().getVisibility() != 0) {
            return false;
        }
        this.kJK.bDv();
        return true;
    }

    public void td(boolean z) {
        if (this.gtA != null) {
            if (z && this.Yf != null && this.Yf.getFirstVisiblePosition() != 0) {
                this.Yf.setSelection(0);
            }
            this.gtA.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void dbM() {
        this.kJP = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.J(this.kJw.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bCO() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData DR(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kJM);
                writeData.setThreadId(m.this.kJL.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kJL.dbP()) {
                    writeData.setFloor(m.this.kJN > 0 ? String.valueOf(m.this.kJN) : m.this.kJL.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kJL.getPost_id());
                }
                if (m.this.kJO > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kJO));
                }
                if (m.this.kJL != null) {
                    writeData.setBaijiahaoData(m.this.kJL.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bCP() {
                return null;
            }
        };
        this.kJQ = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kJw.getBaseFragmentActivity() != null) {
                    m.this.kJw.getBaseFragmentActivity().hideProgressBar();
                    m.this.kJK.bCn().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kJE.a(m.this.kJF);
                        m.this.kJE.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kJw.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(boolean z) {
        if (this.kJK != null && this.kJK.bCn() != null && this.kJK.bCn().getParent() != null) {
            ((ViewGroup) this.kJK.bCn().getParent()).removeView(this.kJK.bCn());
        }
        this.kJK = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).eN(this.kJw.getPageContext().getPageActivity());
        this.kJK.a(this.kJw.getPageContext());
        this.kJK.b(this.kJP);
        this.kJK.setFrom(3);
        this.kJK.j(this.kJw.getPageContext());
        this.kJK.bCn().ks(true);
        this.kJK.bCn().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kJK.bCn() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kJK.bCn(), layoutParams);
            this.kJK.bCn().hide();
        }
        this.kJK.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bCS() {
                if (m.this.kJw.getBaseFragmentActivity() != null) {
                    m.this.kJw.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kJK.b(this.kJQ);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kJK != null) {
            if (i == 12005) {
                this.kJK.bDy();
                com.baidu.adp.lib.f.e.mY().postDelayed(this.fUi, 300L);
            }
            this.kJK.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kJK.bCn().bAK();
        this.kJK.bDv();
        this.kJK.bCn().bCA();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kJK.b(writeData);
                this.kJK.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m sj = this.kJK.bCn().sj(6);
                if (sj != null && sj.fub != null) {
                    sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kJK.bDr();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, long j) {
        if (this.kJL != null && this.kJL.getBaijiahaoData() != null && this.kJL.isBjh()) {
            if (this.kJK == null || !this.kJK.isBJH) {
                ti(true);
            }
            if (this.kJK != null && this.kJL != null) {
                if (this.kJL.dbP() && this.kJL.getReplyer() != null) {
                    this.kJK.Eb(this.kJL.getReplyer().getName_show());
                    return;
                } else {
                    this.kJK.Eb(null);
                    return;
                }
            }
            return;
        }
        if (this.iXq == null) {
            this.iXq = new com.baidu.tieba.frs.profession.permission.c(this.kJw.getPageContext());
            this.iXq.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qi(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void C(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qj(boolean z) {
                    if (z) {
                        if (m.this.kJK == null || m.this.kJK.isBJH) {
                            m.this.ti(false);
                        }
                        if (m.this.kJK != null && m.this.kJL != null) {
                            if (!m.this.kJL.dbP() || m.this.kJL.getReplyer() == null) {
                                m.this.kJK.Eb(null);
                            } else {
                                m.this.kJK.Eb(m.this.kJL.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.iXq.G(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fUi);
        if (this.kJK != null) {
            this.kJK.onDestory();
        }
        if (this.kJE != null) {
            this.kJE.onDestroy();
        }
        if (this.kJJ != null) {
            this.kJJ.a((ReplyMeModel.a) null);
            this.kJJ.onDestroy();
        }
        if (this.kJE != null) {
            this.kJE.a((am.a) null);
        }
    }

    public void e(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.kJC != null) {
            this.kJC.e(abVar);
        }
    }

    public void b(ac acVar) {
        if (this.kJC != null) {
            this.kJC.a(acVar);
        }
    }

    public void onPrimary() {
        dbu();
    }

    public void EY(int i) {
        if (this.kJC != null) {
            this.kJC.EY(i);
        }
    }

    public BdSwipeRefreshLayout dbN() {
        return this.gtA;
    }
}
