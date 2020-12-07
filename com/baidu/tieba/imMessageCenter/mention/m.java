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
    private BdSwipeRefreshLayout gty;
    private final f.c gyc;
    private com.baidu.tieba.frs.profession.permission.c iXo;
    private com.baidu.tieba.imMessageCenter.mention.base.f kIH;
    private boolean kII;
    private f.a kIJ;
    private NavigationBarShadowView kIh;
    private com.baidu.tieba.imMessageCenter.mention.base.e kJA;
    private boolean kJB;
    private am kJC;
    private AttentionHostData kJD;
    private int kJE;
    private View.OnClickListener kJF;
    private RecyclerView.OnScrollListener kJG;
    private ReplyMeModel kJH;
    private com.baidu.tbadk.editortools.pb.h kJI;
    private com.baidu.tieba.imMessageCenter.mention.base.a kJJ;
    private String kJK;
    private long kJL;
    private long kJM;
    private DataModel<MessageCenterActivity> kJN;
    private NewWriteModel.d kJO;
    private final ReplyMeModel.a kJP;
    private final ReplyMessageFragment kJu;
    private PbListView kJz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kJE = R.color.CAM_X0204;
        this.kII = false;
        this.kJF = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kJz != null && m.this.kJu != null) {
                    m.this.kJz.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kJz.setOnClickListener(null);
                    m.this.kJz.startLoadData();
                    m.this.kJu.cqA();
                }
            }
        };
        this.gyc = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kJu != null) {
                        m.this.kJu.cFm();
                    }
                } else if (m.this.gty != null) {
                    m.this.gty.setRefreshing(false);
                }
            }
        };
        this.kJG = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kIh.show();
                            return;
                        } else {
                            m.this.kIh.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kIh.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kIJ = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.kIH != null) {
                    m.this.Yf.removeHeaderView(m.this.kIH.getView());
                    m.this.kII = false;
                }
            }
        };
        this.kJH = null;
        this.fUi = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kJI != null && m.this.kJI.bDz() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kJI.bDz().getInputView());
                }
            }
        };
        this.kJP = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kJK = str;
                m.this.kJL = j2;
                m.this.kJM = j3;
                m.this.L(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kJI != null) {
                    m.this.kJI.bDv();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kJu = replyMessageFragment;
        this.kJC = new am(replyMessageFragment.getPageContext());
        this.kJC.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z && m.this.kJI != null) {
                    m.this.kJI.bDr();
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
            this.gty.setVisibility(0);
            td(false);
            if (z) {
                this.kJz.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kJz.endLoadData();
                this.kJz.setOnClickListener(this.kJF);
            } else {
                this.kJz.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kJz.endLoadData();
                this.kJz.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kJz.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dZ(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kJB) {
                    this.kJB = true;
                    this.Yf.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Yf.setNextPage(null);
                if (arrayList != null) {
                    this.kJA.setData(arrayList);
                }
                this.kJE = R.color.CAM_X0205;
            } else {
                this.Yf.removeHeaderView(this.mNoDataView);
                this.kJB = false;
                if (this.kJA != null) {
                    this.kJA.setData(arrayList);
                    this.kJA.notifyDataSetChanged();
                }
                this.Yf.setNextPage(this.kJz);
                this.kJE = R.color.CAM_X0204;
            }
            dbt();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kJA != null) {
            this.kJA.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bX(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kIh = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kJu.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gyc);
        }
        this.mPullView.setTag(this.kJu.getUniqueId());
        if (this.kJz == null) {
            this.kJz = new PbListView(this.kJu.getContext());
            this.kJz.getView();
        }
        this.kJz.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.kJz.bvh();
        this.kJz.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kJu.getContext(), R.dimen.tbds182));
        this.kJz.setLineGone();
        this.kJz.setTextSize(R.dimen.tbfontsize33);
        this.kJz.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.kJz.setNoMoreTextColorId(R.color.CAM_X0110);
        this.kJz.setOnClickListener(this.kJF);
        this.gty = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.gty.setProgressView(this.mPullView);
        this.Yf = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kJA = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kJu.getPageContext(), this.Yf);
        this.kJA.setOnCardSubClickListener(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.kJJ = aVar;
                        if (aVar.dbO()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.dbP(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kJD == null) {
                            m.this.kJD = new AttentionHostData();
                        }
                        if (m.this.kJJ != null) {
                            m.this.kJD.parserWithMetaData(m.this.kJJ.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kJJ != null) {
                            baijiahaoData = m.this.kJJ.getBaijiahaoData();
                        }
                        m.this.kJH.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.dbQ() != null) {
                            ar al = new ar(aVar.dbQ()).al("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kKq) {
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
                if (m.this.kJz != null) {
                    m.this.kJz.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kJz.setOnClickListener(null);
                    m.this.kJz.showLoading();
                    m.this.kJu.cqA();
                }
            }
        });
        this.Yf.setOnScrollListener(this.mScrollListener);
        this.Yf.addOnScrollListener(this.kJG);
        dbK();
        this.kJH = new ReplyMeModel(this.kJu.getPageContext());
        this.kJH.a(this.kJP);
        dbL();
        ti(false);
        return this.mRootView;
    }

    private void dbK() {
        dbt();
    }

    private void dbt() {
        if (this.Yf != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kJu.getFragmentActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.al("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kIH != null) {
                    this.Yf.removeHeaderView(this.kIH.getView());
                    this.kII = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bsO().getLong("key_im_open_notification_close_time", 0L);
            if (this.kII) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kIH == null) {
                    this.kIH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.kJu.getPageContext());
                    this.kIH.a(this.kIJ);
                }
                this.Yf.addHeaderView(this.kIH.getView(), 0);
                this.kII = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kJI != null && this.kJI.bCn() != null) {
            this.kJI.bCn().onChangeSkinType(i);
        }
        if (this.kJz != null) {
            this.kJz.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.kJz.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.Yf, this.kJE);
        ap.setBackgroundColor(this.gty, R.color.CAM_X0205);
        if (this.kIH != null) {
            this.kIH.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kJI == null || this.kJI.bCn() == null || this.kJI.bCn().getVisibility() != 0) {
            return false;
        }
        this.kJI.bDv();
        return true;
    }

    public void td(boolean z) {
        if (this.gty != null) {
            if (z && this.Yf != null && this.Yf.getFirstVisiblePosition() != 0) {
                this.Yf.setSelection(0);
            }
            this.gty.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void dbL() {
        this.kJN = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.J(this.kJu.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
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
                writeData.setForumName(m.this.kJK);
                writeData.setThreadId(m.this.kJJ.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kJJ.dbO()) {
                    writeData.setFloor(m.this.kJL > 0 ? String.valueOf(m.this.kJL) : m.this.kJJ.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kJJ.getPost_id());
                }
                if (m.this.kJM > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kJM));
                }
                if (m.this.kJJ != null) {
                    writeData.setBaijiahaoData(m.this.kJJ.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bCP() {
                return null;
            }
        };
        this.kJO = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kJu.getBaseFragmentActivity() != null) {
                    m.this.kJu.getBaseFragmentActivity().hideProgressBar();
                    m.this.kJI.bCn().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kJC.a(m.this.kJD);
                        m.this.kJC.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kJu.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti(boolean z) {
        if (this.kJI != null && this.kJI.bCn() != null && this.kJI.bCn().getParent() != null) {
            ((ViewGroup) this.kJI.bCn().getParent()).removeView(this.kJI.bCn());
        }
        this.kJI = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).eN(this.kJu.getPageContext().getPageActivity());
        this.kJI.a(this.kJu.getPageContext());
        this.kJI.b(this.kJN);
        this.kJI.setFrom(3);
        this.kJI.j(this.kJu.getPageContext());
        this.kJI.bCn().ks(true);
        this.kJI.bCn().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kJI.bCn() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kJI.bCn(), layoutParams);
            this.kJI.bCn().hide();
        }
        this.kJI.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bCS() {
                if (m.this.kJu.getBaseFragmentActivity() != null) {
                    m.this.kJu.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kJI.b(this.kJO);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kJI != null) {
            if (i == 12005) {
                this.kJI.bDy();
                com.baidu.adp.lib.f.e.mY().postDelayed(this.fUi, 300L);
            }
            this.kJI.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kJI.bCn().bAK();
        this.kJI.bDv();
        this.kJI.bCn().bCA();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kJI.b(writeData);
                this.kJI.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m sj = this.kJI.bCn().sj(6);
                if (sj != null && sj.fub != null) {
                    sj.fub.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kJI.bDr();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, long j) {
        if (this.kJJ != null && this.kJJ.getBaijiahaoData() != null && this.kJJ.isBjh()) {
            if (this.kJI == null || !this.kJI.isBJH) {
                ti(true);
            }
            if (this.kJI != null && this.kJJ != null) {
                if (this.kJJ.dbO() && this.kJJ.getReplyer() != null) {
                    this.kJI.Eb(this.kJJ.getReplyer().getName_show());
                    return;
                } else {
                    this.kJI.Eb(null);
                    return;
                }
            }
            return;
        }
        if (this.iXo == null) {
            this.iXo = new com.baidu.tieba.frs.profession.permission.c(this.kJu.getPageContext());
            this.iXo.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qi(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void C(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qj(boolean z) {
                    if (z) {
                        if (m.this.kJI == null || m.this.kJI.isBJH) {
                            m.this.ti(false);
                        }
                        if (m.this.kJI != null && m.this.kJJ != null) {
                            if (!m.this.kJJ.dbO() || m.this.kJJ.getReplyer() == null) {
                                m.this.kJI.Eb(null);
                            } else {
                                m.this.kJI.Eb(m.this.kJJ.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.iXo.G(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fUi);
        if (this.kJI != null) {
            this.kJI.onDestory();
        }
        if (this.kJC != null) {
            this.kJC.onDestroy();
        }
        if (this.kJH != null) {
            this.kJH.a((ReplyMeModel.a) null);
            this.kJH.onDestroy();
        }
        if (this.kJC != null) {
            this.kJC.a((am.a) null);
        }
    }

    public void e(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.kJA != null) {
            this.kJA.e(abVar);
        }
    }

    public void b(ac acVar) {
        if (this.kJA != null) {
            this.kJA.a(acVar);
        }
    }

    public void onPrimary() {
        dbt();
    }

    public void EY(int i) {
        if (this.kJA != null) {
            this.kJA.EY(i);
        }
    }

    public BdSwipeRefreshLayout dbM() {
        return this.gty;
    }
}
