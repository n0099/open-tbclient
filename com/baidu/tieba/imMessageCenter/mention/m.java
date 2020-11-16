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
/* loaded from: classes21.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView Xi;
    private Runnable fMx;
    private BdSwipeRefreshLayout glp;
    private final f.c gpT;
    private com.baidu.tieba.frs.profession.permission.c iMx;
    private NavigationBarShadowView kuN;
    private com.baidu.tieba.imMessageCenter.mention.base.f kvn;
    private boolean kvo;
    private f.a kvp;
    private final ReplyMessageFragment kwa;
    private PbListView kwf;
    private com.baidu.tieba.imMessageCenter.mention.base.e kwg;
    private boolean kwh;
    private am kwi;
    private AttentionHostData kwj;
    private int kwk;
    private View.OnClickListener kwl;
    private RecyclerView.OnScrollListener kwm;
    private ReplyMeModel kwn;
    private com.baidu.tbadk.editortools.pb.h kwo;
    private com.baidu.tieba.imMessageCenter.mention.base.a kwp;
    private String kwq;
    private long kwr;
    private long kws;
    private DataModel<MessageCenterActivity> kwt;
    private NewWriteModel.d kwu;
    private final ReplyMeModel.a kwv;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kwk = R.color.CAM_X0204;
        this.kvo = false;
        this.kwl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kwf != null && m.this.kwa != null) {
                    m.this.kwf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kwf.setOnClickListener(null);
                    m.this.kwf.startLoadData();
                    m.this.kwa.cmn();
                }
            }
        };
        this.gpT = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kwa != null) {
                        m.this.kwa.cAW();
                    }
                } else if (m.this.glp != null) {
                    m.this.glp.setRefreshing(false);
                }
            }
        };
        this.kwm = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kuN.show();
                            return;
                        } else {
                            m.this.kuN.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kuN.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kvp = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.kvn != null) {
                    m.this.Xi.removeHeaderView(m.this.kvn.getView());
                    m.this.kvo = false;
                }
            }
        };
        this.kwn = null;
        this.fMx = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kwo != null && m.this.kwo.bzZ() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kwo.bzZ().getInputView());
                }
            }
        };
        this.kwv = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kwq = str;
                m.this.kwr = j2;
                m.this.kws = j3;
                m.this.L(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kwo != null) {
                    m.this.kwo.bzV();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kwa = replyMessageFragment;
        this.kwi = new am(replyMessageFragment.getPageContext());
        this.kwi.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z && m.this.kwo != null) {
                    m.this.kwo.bzR();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<q> arrayList) {
        if (this.Xi != null) {
            this.glp.setVisibility(0);
            sB(false);
            if (z) {
                this.kwf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kwf.endLoadData();
                this.kwf.setOnClickListener(this.kwl);
            } else {
                this.kwf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kwf.endLoadData();
                this.kwf.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kwf.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dS(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kwh) {
                    this.kwh = true;
                    this.Xi.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Xi.setNextPage(null);
                if (arrayList != null) {
                    this.kwg.setData(arrayList);
                }
                this.kwk = R.color.CAM_X0205;
            } else {
                this.Xi.removeHeaderView(this.mNoDataView);
                this.kwh = false;
                if (this.kwg != null) {
                    this.kwg.setData(arrayList);
                    this.kwg.notifyDataSetChanged();
                }
                this.Xi.setNextPage(this.kwf);
                this.kwk = R.color.CAM_X0204;
            }
            cWh();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kwg != null) {
            this.kwg.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bU(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kuN = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kwa.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gpT);
        }
        this.mPullView.setTag(this.kwa.getUniqueId());
        if (this.kwf == null) {
            this.kwf = new PbListView(this.kwa.getContext());
            this.kwf.getView();
        }
        this.kwf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.kwf.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kwa.getContext(), R.dimen.tbds182));
        this.kwf.setLineGone();
        this.kwf.setTextSize(R.dimen.tbfontsize33);
        this.kwf.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.kwf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.kwf.setOnClickListener(this.kwl);
        this.glp = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.glp.setProgressView(this.mPullView);
        this.Xi = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kwg = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kwa.getPageContext(), this.Xi);
        this.kwg.setOnCardSubClickListener(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, BaseCardInfo baseCardInfo) {
                long j;
                if (view != null && (baseCardInfo instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) baseCardInfo;
                    if (aVar.isNew() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                        aVar.sH(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.kwp = aVar;
                        if (aVar.cWC()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cWD(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kwj == null) {
                            m.this.kwj = new AttentionHostData();
                        }
                        if (m.this.kwp != null) {
                            m.this.kwj.parserWithMetaData(m.this.kwp.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kwp != null) {
                            baijiahaoData = m.this.kwp.getBaijiahaoData();
                        }
                        m.this.kwn.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cWE() != null) {
                            ar ak = new ar(aVar.cWE()).ak("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kwW) {
                                ak.ak("obj_type", 1);
                            } else {
                                ak.ak("obj_type", 2);
                            }
                            TiebaStatic.log(ak);
                        }
                        ar arVar = new ar("c13784");
                        arVar.w("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Xi.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Xi.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Xi.setFadingEdgeLength(0);
        this.Xi.setOverScrollMode(2);
        this.Xi.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Xi.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Xi.setNextPage(this.kwf);
        this.Xi.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.kwf != null) {
                    m.this.kwf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kwf.setOnClickListener(null);
                    m.this.kwf.showLoading();
                    m.this.kwa.cmn();
                }
            }
        });
        this.Xi.setOnScrollListener(this.mScrollListener);
        this.Xi.addOnScrollListener(this.kwm);
        cWy();
        this.kwn = new ReplyMeModel(this.kwa.getPageContext());
        this.kwn.a(this.kwv);
        cWz();
        sG(false);
        return this.mRootView;
    }

    private void cWy() {
        cWh();
    }

    private void cWh() {
        if (this.Xi != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kwa.getFragmentActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.ak("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kvn != null) {
                    this.Xi.removeHeaderView(this.kvn.getView());
                    this.kvo = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bpu().getLong("key_im_open_notification_close_time", 0L);
            if (this.kvo) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kvn == null) {
                    this.kvn = new com.baidu.tieba.imMessageCenter.mention.base.f(this.kwa.getPageContext());
                    this.kvn.a(this.kvp);
                }
                this.Xi.addHeaderView(this.kvn.getView(), 0);
                this.kvo = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kwo != null && this.kwo.byN() != null) {
            this.kwo.byN().onChangeSkinType(i);
        }
        if (this.kwf != null) {
            this.kwf.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.kwf.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.Xi, this.kwk);
        ap.setBackgroundColor(this.glp, R.color.CAM_X0205);
        if (this.kvn != null) {
            this.kvn.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kwo == null || this.kwo.byN() == null || this.kwo.byN().getVisibility() != 0) {
            return false;
        }
        this.kwo.bzV();
        return true;
    }

    public void sB(boolean z) {
        if (this.glp != null) {
            if (z && this.Xi != null && this.Xi.getFirstVisiblePosition() != 0) {
                this.Xi.setSelection(0);
            }
            this.glp.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cWz() {
        this.kwt = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.I(this.kwa.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bzo() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData Dj(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kwq);
                writeData.setThreadId(m.this.kwp.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kwp.cWC()) {
                    writeData.setFloor(m.this.kwr > 0 ? String.valueOf(m.this.kwr) : m.this.kwp.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kwp.getPost_id());
                }
                if (m.this.kws > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kws));
                }
                if (m.this.kwp != null) {
                    writeData.setBaijiahaoData(m.this.kwp.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bzp() {
                return null;
            }
        };
        this.kwu = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kwa.getBaseFragmentActivity() != null) {
                    m.this.kwa.getBaseFragmentActivity().hideProgressBar();
                    m.this.kwo.byN().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kwi.a(m.this.kwj);
                        m.this.kwi.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kwa.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG(boolean z) {
        if (this.kwo != null && this.kwo.byN() != null && this.kwo.byN().getParent() != null) {
            ((ViewGroup) this.kwo.byN().getParent()).removeView(this.kwo.byN());
        }
        this.kwo = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).ei(this.kwa.getPageContext().getPageActivity());
        this.kwo.a(this.kwa.getPageContext());
        this.kwo.b(this.kwt);
        this.kwo.setFrom(3);
        this.kwo.j(this.kwa.getPageContext());
        this.kwo.byN().kc(true);
        this.kwo.byN().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kwo.byN() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kwo.byN(), layoutParams);
            this.kwo.byN().hide();
        }
        this.kwo.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bzs() {
                if (m.this.kwa.getBaseFragmentActivity() != null) {
                    m.this.kwa.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kwo.b(this.kwu);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kwo != null) {
            if (i == 12005) {
                this.kwo.bzY();
                com.baidu.adp.lib.f.e.mY().postDelayed(this.fMx, 300L);
            }
            this.kwo.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kwo.byN().bxk();
        this.kwo.bzV();
        this.kwo.byN().bza();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kwo.b(writeData);
                this.kwo.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m rI = this.kwo.byN().rI(6);
                if (rI != null && rI.fmx != null) {
                    rI.fmx.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kwo.bzR();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, long j) {
        if (this.kwp != null && this.kwp.getBaijiahaoData() != null && this.kwp.isBjh()) {
            if (this.kwo == null || !this.kwo.isBJH) {
                sG(true);
            }
            if (this.kwo != null && this.kwp != null) {
                if (this.kwp.cWC() && this.kwp.getReplyer() != null) {
                    this.kwo.Dt(this.kwp.getReplyer().getName_show());
                    return;
                } else {
                    this.kwo.Dt(null);
                    return;
                }
            }
            return;
        }
        if (this.iMx == null) {
            this.iMx = new com.baidu.tieba.frs.profession.permission.c(this.kwa.getPageContext());
            this.iMx.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pL(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void C(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pM(boolean z) {
                    if (z) {
                        if (m.this.kwo == null || m.this.kwo.isBJH) {
                            m.this.sG(false);
                        }
                        if (m.this.kwo != null && m.this.kwp != null) {
                            if (!m.this.kwp.cWC() || m.this.kwp.getReplyer() == null) {
                                m.this.kwo.Dt(null);
                            } else {
                                m.this.kwo.Dt(m.this.kwp.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.iMx.G(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMx);
        if (this.kwo != null) {
            this.kwo.onDestory();
        }
        if (this.kwi != null) {
            this.kwi.onDestroy();
        }
        if (this.kwn != null) {
            this.kwn.a((ReplyMeModel.a) null);
            this.kwn.onDestroy();
        }
        if (this.kwi != null) {
            this.kwi.a((am.a) null);
        }
    }

    public void e(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.kwg != null) {
            this.kwg.e(abVar);
        }
    }

    public void b(ac acVar) {
        if (this.kwg != null) {
            this.kwg.a(acVar);
        }
    }

    public void onPrimary() {
        cWh();
    }

    public void Ej(int i) {
        if (this.kwg != null) {
            this.kwg.Ej(i);
        }
    }

    public BdSwipeRefreshLayout cWA() {
        return this.glp;
    }
}
