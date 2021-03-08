package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.adp.widget.ListView.x;
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
import com.baidu.tieba.imMessageCenter.mention.base.DeviderLineDecoration;
import com.baidu.tieba.imMessageCenter.mention.base.e;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.base.d {
    private BdTypeRecyclerView Zq;
    private BdSwipeRefreshLayout gEz;
    private final f.c gJi;
    private Runnable gcW;
    private com.baidu.tieba.frs.profession.permission.c jmA;
    private com.baidu.tieba.imMessageCenter.mention.base.e kTG;
    private boolean kTH;
    private e.a kTI;
    private NavigationBarShadowView kTg;
    private boolean kUA;
    private am kUB;
    private AttentionHostData kUC;
    private int kUD;
    private View.OnClickListener kUE;
    private RecyclerView.OnScrollListener kUF;
    private ReplyMeModel kUG;
    private com.baidu.tbadk.editortools.pb.h kUH;
    private com.baidu.tieba.imMessageCenter.mention.base.a kUI;
    private String kUJ;
    private long kUK;
    private long kUL;
    private DataModel<MessageCenterActivity> kUM;
    private NewWriteModel.d kUN;
    private final ReplyMeModel.a kUO;
    private final ReplyMessageFragment kUt;
    private PbListView kUy;
    private com.baidu.tieba.imMessageCenter.mention.base.d kUz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kUD = R.color.CAM_X0204;
        this.kTH = false;
        this.kUE = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kUy != null && m.this.kUt != null) {
                    m.this.kUy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kUy.setOnClickListener(null);
                    m.this.kUy.startLoadData();
                    m.this.kUt.cra();
                }
            }
        };
        this.gJi = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kUt != null) {
                        m.this.kUt.cFR();
                    }
                } else if (m.this.gEz != null) {
                    m.this.gEz.setRefreshing(false);
                }
            }
        };
        this.kUF = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kTg.show();
                            return;
                        } else {
                            m.this.kTg.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kTg.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kTI = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (m.this.kTG != null) {
                    m.this.Zq.removeHeaderView(m.this.kTG.getView());
                    m.this.kTH = false;
                }
            }
        };
        this.kUG = null;
        this.gcW = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kUH != null && m.this.kUH.bCx() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kUH.bCx().getInputView());
                }
            }
        };
        this.kUO = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kUJ = str;
                m.this.kUK = j2;
                m.this.kUL = j3;
                m.this.L(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kUH != null) {
                    m.this.kUH.bCt();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kUt = replyMessageFragment;
        this.kUB = new am(replyMessageFragment.getPageContext());
        this.kUB.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z && m.this.kUH != null) {
                    m.this.kUH.bCp();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<n> arrayList) {
        if (this.Zq != null) {
            this.gEz.setVisibility(0);
            tn(false);
            if (z) {
                this.kUy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kUy.endLoadData();
                this.kUy.setOnClickListener(this.kUE);
            } else {
                this.kUy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kUy.endLoadData();
                this.kUy.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kUy.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dS(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kUA) {
                    this.kUA = true;
                    this.Zq.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Zq.setNextPage(null);
                if (arrayList != null) {
                    this.kUz.setData(arrayList);
                }
                this.kUD = R.color.CAM_X0205;
            } else {
                this.Zq.removeHeaderView(this.mNoDataView);
                this.kUA = false;
                if (this.kUz != null) {
                    this.kUz.setData(arrayList);
                    this.kUz.notifyDataSetChanged();
                }
                this.Zq.setNextPage(this.kUy);
                this.kUD = R.color.CAM_X0204;
            }
            cZs();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kUz != null) {
            this.kUz.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View ci(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kTg = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kUt.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gJi);
        }
        this.mPullView.setTag(this.kUt.getUniqueId());
        if (this.kUy == null) {
            this.kUy = new PbListView(this.kUt.getContext());
            this.kUy.getView();
        }
        this.kUy.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.kUy.bug();
        this.kUy.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kUt.getContext(), R.dimen.tbds182));
        this.kUy.setLineGone();
        this.kUy.setTextSize(R.dimen.tbfontsize33);
        this.kUy.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.kUy.setNoMoreTextColorId(R.color.CAM_X0110);
        this.kUy.setOnClickListener(this.kUE);
        this.gEz = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.gEz.setProgressView(this.mPullView);
        this.Zq = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kUz = new com.baidu.tieba.imMessageCenter.mention.base.d(this.kUt.getPageContext(), this.Zq);
        this.kUz.setOnCardSubClickListener(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo) {
                long j;
                if (view != null && (baseCardInfo instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) baseCardInfo;
                    if (aVar.isNew() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                        aVar.tt(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.kUI = aVar;
                        if (aVar.cZO()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cZP(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kUC == null) {
                            m.this.kUC = new AttentionHostData();
                        }
                        if (m.this.kUI != null) {
                            m.this.kUC.parserWithMetaData(m.this.kUI.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kUI != null) {
                            baijiahaoData = m.this.kUI.getBaijiahaoData();
                        }
                        m.this.kUG.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cZQ() != null) {
                            ar aq = new ar(aVar.cZQ()).aq("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kVp) {
                                aq.aq("obj_type", 1);
                            } else {
                                aq.aq("obj_type", 2);
                            }
                            TiebaStatic.log(aq);
                        }
                        ar arVar = new ar("c13784");
                        arVar.v("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Zq.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Zq.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Zq.setFadingEdgeLength(0);
        this.Zq.setOverScrollMode(2);
        this.Zq.addItemDecoration(new DeviderLineDecoration());
        this.Zq.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Zq.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.kUy != null) {
                    m.this.kUy.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kUy.setOnClickListener(null);
                    m.this.kUy.showLoading();
                    m.this.kUt.cra();
                }
            }
        });
        this.Zq.setOnScrollListener(this.mScrollListener);
        this.Zq.addOnScrollListener(this.kUF);
        cZK();
        this.kUG = new ReplyMeModel(this.kUt.getPageContext());
        this.kUG.a(this.kUO);
        cZL();
        ts(false);
        return this.mRootView;
    }

    private void cZK() {
        cZs();
    }

    private void cZs() {
        if (this.Zq != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kUt.getFragmentActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.aq("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kTG != null) {
                    this.Zq.removeHeaderView(this.kTG.getView());
                    this.kTH = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brR().getLong("key_im_open_notification_close_time", 0L);
            if (this.kTH) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kTG == null) {
                    this.kTG = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kUt.getPageContext());
                    this.kTG.a(this.kTI);
                }
                this.Zq.addHeaderView(this.kTG.getView(), 0);
                this.kTH = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kUH != null && this.kUH.bBk() != null) {
            this.kUH.bBk().onChangeSkinType(i);
        }
        if (this.kUy != null) {
            this.kUy.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.kUy.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.Zq, this.kUD);
        ap.setBackgroundColor(this.gEz, R.color.CAM_X0205);
        if (this.kTG != null) {
            this.kTG.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kUH == null || this.kUH.bBk() == null || this.kUH.bBk().getVisibility() != 0) {
            return false;
        }
        this.kUH.bCt();
        return true;
    }

    public void tn(boolean z) {
        if (this.gEz != null) {
            if (z && this.Zq != null && this.Zq.getFirstVisiblePosition() != 0) {
                this.Zq.setSelection(0);
            }
            this.gEz.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cZL() {
        this.kUM = new DataModel<MessageCenterActivity>(com.baidu.adp.base.j.J(this.kUt.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bBL() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData CY(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kUJ);
                writeData.setThreadId(m.this.kUI.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kUI.cZO()) {
                    writeData.setFloor(m.this.kUK > 0 ? String.valueOf(m.this.kUK) : m.this.kUI.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kUI.getPost_id());
                }
                if (m.this.kUL > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kUL));
                }
                if (m.this.kUI != null) {
                    writeData.setBaijiahaoData(m.this.kUI.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bBM() {
                return null;
            }
        };
        this.kUN = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kUt.getBaseFragmentActivity() != null) {
                    m.this.kUt.getBaseFragmentActivity().hideProgressBar();
                    m.this.kUH.bBk().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kUB.a(m.this.kUC);
                        m.this.kUB.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bX(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kUt.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(boolean z) {
        if (this.kUH != null && this.kUH.bBk() != null && this.kUH.bBk().getParent() != null) {
            ((ViewGroup) this.kUH.bBk().getParent()).removeView(this.kUH.bBk());
        }
        this.kUH = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).ff(this.kUt.getPageContext().getPageActivity());
        this.kUH.a(this.kUt.getPageContext());
        this.kUH.b(this.kUM);
        this.kUH.setFrom(3);
        this.kUH.j(this.kUt.getPageContext());
        this.kUH.bBk().kN(true);
        this.kUH.bBk().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kUH.bBk() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kUH.bBk(), layoutParams);
            this.kUH.bBk().hide();
        }
        this.kUH.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bBP() {
                if (m.this.kUt.getBaseFragmentActivity() != null) {
                    m.this.kUt.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kUH.b(this.kUN);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kUH != null) {
            if (i == 12005) {
                this.kUH.bCw();
                com.baidu.adp.lib.f.e.mA().postDelayed(this.gcW, 300L);
            }
            this.kUH.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kUH.bBk().bzG();
        this.kUH.bCt();
        this.kUH.bBk().bBx();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kUH.c(writeData);
                this.kUH.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qV = this.kUH.bBk().qV(6);
                if (qV != null && qV.fCN != null) {
                    qV.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kUH.bCp();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, long j) {
        if (this.kUI != null && this.kUI.getBaijiahaoData() != null && this.kUI.isBjh()) {
            if (this.kUH == null || !this.kUH.isBJH) {
                ts(true);
            }
            if (this.kUH != null && this.kUI != null) {
                if (this.kUI.cZO() && this.kUI.getReplyer() != null) {
                    this.kUH.Di(this.kUI.getReplyer().getName_show());
                    return;
                } else {
                    this.kUH.Di(null);
                    return;
                }
            }
            return;
        }
        if (this.jmA == null) {
            this.jmA = new com.baidu.tieba.frs.profession.permission.c(this.kUt.getPageContext());
            this.jmA.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qM(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void B(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qN(boolean z) {
                    if (z) {
                        if (m.this.kUH == null || m.this.kUH.isBJH) {
                            m.this.ts(false);
                        }
                        if (m.this.kUH != null && m.this.kUI != null) {
                            if (!m.this.kUI.cZO() || m.this.kUI.getReplyer() == null) {
                                m.this.kUH.Di(null);
                            } else {
                                m.this.kUH.Di(m.this.kUI.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.jmA.G(str, j);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gcW);
        if (this.kUH != null) {
            this.kUH.onDestory();
        }
        if (this.kUB != null) {
            this.kUB.onDestroy();
        }
        if (this.kUG != null) {
            this.kUG.a((ReplyMeModel.a) null);
            this.kUG.onDestroy();
        }
        if (this.kUB != null) {
            this.kUB.a((am.a) null);
        }
    }

    public void e(w wVar) {
        if (this.kUz != null) {
            this.kUz.e(wVar);
        }
    }

    public void b(x xVar) {
        if (this.kUz != null) {
            this.kUz.a(xVar);
        }
    }

    public void onPrimary() {
        cZs();
    }

    public void DE(int i) {
        if (this.kUz != null) {
            this.kUz.DE(i);
        }
    }

    public BdSwipeRefreshLayout cZM() {
        return this.gEz;
    }
}
