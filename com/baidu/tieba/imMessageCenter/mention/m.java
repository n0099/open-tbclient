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
    private Runnable fMU;
    private BdSwipeRefreshLayout glI;
    private final f.c gqm;
    private com.baidu.tieba.frs.profession.permission.c iLK;
    private com.baidu.tieba.imMessageCenter.mention.base.f kuD;
    private boolean kuE;
    private f.a kuF;
    private NavigationBarShadowView kud;
    private int kvA;
    private View.OnClickListener kvB;
    private RecyclerView.OnScrollListener kvC;
    private ReplyMeModel kvD;
    private com.baidu.tbadk.editortools.pb.h kvE;
    private com.baidu.tieba.imMessageCenter.mention.base.a kvF;
    private String kvG;
    private long kvH;
    private long kvI;
    private DataModel<MessageCenterActivity> kvJ;
    private NewWriteModel.d kvK;
    private final ReplyMeModel.a kvL;
    private final ReplyMessageFragment kvq;
    private PbListView kvv;
    private com.baidu.tieba.imMessageCenter.mention.base.e kvw;
    private boolean kvx;
    private am kvy;
    private AttentionHostData kvz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kvA = R.color.cp_bg_line_c;
        this.kuE = false;
        this.kvB = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kvv != null && m.this.kvq != null) {
                    m.this.kvv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kvv.setOnClickListener(null);
                    m.this.kvv.startLoadData();
                    m.this.kvq.cmL();
                }
            }
        };
        this.gqm = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kvq != null) {
                        m.this.kvq.cBt();
                    }
                } else if (m.this.glI != null) {
                    m.this.glI.setRefreshing(false);
                }
            }
        };
        this.kvC = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kud.show();
                            return;
                        } else {
                            m.this.kud.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kud.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kuF = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.kuD != null) {
                    m.this.Xe.removeHeaderView(m.this.kuD.getView());
                    m.this.kuE = false;
                }
            }
        };
        this.kvD = null;
        this.fMU = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kvE != null && m.this.kvE.bAJ() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kvE.bAJ().getInputView());
                }
            }
        };
        this.kvL = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kvG = str;
                m.this.kvH = j2;
                m.this.kvI = j3;
                m.this.L(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kvE != null) {
                    m.this.kvE.bAF();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kvq = replyMessageFragment;
        this.kvy = new am(replyMessageFragment.getPageContext());
        this.kvy.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void r(boolean z, int i) {
                if (z && m.this.kvE != null) {
                    m.this.kvE.bAB();
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
            sy(false);
            if (z) {
                this.kvv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kvv.endLoadData();
                this.kvv.setOnClickListener(this.kvB);
            } else {
                this.kvv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kvv.endLoadData();
                this.kvv.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kvv.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dS(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.kvx) {
                    this.kvx = true;
                    this.Xe.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Xe.setNextPage(null);
                if (arrayList != null) {
                    this.kvw.setData(arrayList);
                }
                this.kvA = R.color.cp_bg_line_e;
            } else {
                this.Xe.removeHeaderView(this.mNoDataView);
                this.kvx = false;
                if (this.kvw != null) {
                    this.kvw.setData(arrayList);
                    this.kvw.notifyDataSetChanged();
                }
                this.Xe.setNextPage(this.kvv);
                this.kvA = R.color.cp_bg_line_c;
            }
            cWB();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kvw != null) {
            this.kvw.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bY(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kud = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kvq.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gqm);
        }
        this.mPullView.setTag(this.kvq.getUniqueId());
        if (this.kvv == null) {
            this.kvv = new PbListView(this.kvq.getContext());
            this.kvv.getView();
        }
        this.kvv.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.kvv.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kvq.getContext(), R.dimen.tbds182));
        this.kvv.setLineGone();
        this.kvv.setTextSize(R.dimen.tbfontsize33);
        this.kvv.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.kvv.setNoMoreTextColorId(R.color.cp_cont_e);
        this.kvv.setOnClickListener(this.kvB);
        this.glI = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.glI.setProgressView(this.mPullView);
        this.Xe = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kvw = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kvq.getPageContext(), this.Xe);
        this.kvw.setOnCardSubClickListener(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                        aVar.sE(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.kvF = aVar;
                        if (aVar.cWV()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cWW(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kvz == null) {
                            m.this.kvz = new AttentionHostData();
                        }
                        if (m.this.kvF != null) {
                            m.this.kvz.parserWithMetaData(m.this.kvF.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kvF != null) {
                            baijiahaoData = m.this.kvF.getBaijiahaoData();
                        }
                        m.this.kvD.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cWX() != null) {
                            aq al = new aq(aVar.cWX()).al("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kwm) {
                                al.al("obj_type", 1);
                            } else {
                                al.al("obj_type", 2);
                            }
                            TiebaStatic.log(al);
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
        this.Xe.setNextPage(this.kvv);
        this.Xe.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.kvv != null) {
                    m.this.kvv.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kvv.setOnClickListener(null);
                    m.this.kvv.showLoading();
                    m.this.kvq.cmL();
                }
            }
        });
        this.Xe.setOnScrollListener(this.mScrollListener);
        this.Xe.addOnScrollListener(this.kvC);
        cWS();
        this.kvD = new ReplyMeModel(this.kvq.getPageContext());
        this.kvD.a(this.kvL);
        cWT();
        sD(false);
        return this.mRootView;
    }

    private void cWS() {
        cWB();
    }

    private void cWB() {
        if (this.Xe != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kvq.getFragmentActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.al("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.kuD != null) {
                    this.Xe.removeHeaderView(this.kuD.getView());
                    this.kuE = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bqh().getLong("key_im_open_notification_close_time", 0L);
            if (this.kuE) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kuD == null) {
                    this.kuD = new com.baidu.tieba.imMessageCenter.mention.base.f(this.kvq.getPageContext());
                    this.kuD.a(this.kuF);
                }
                this.Xe.addHeaderView(this.kuD.getView(), 0);
                this.kuE = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kvE != null && this.kvE.bzx() != null) {
            this.kvE.bzx().onChangeSkinType(i);
        }
        if (this.kvv != null) {
            this.kvv.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.kvv.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.Xe, this.kvA);
        ap.setBackgroundColor(this.glI, R.color.cp_bg_line_e);
        if (this.kuD != null) {
            this.kuD.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kvE == null || this.kvE.bzx() == null || this.kvE.bzx().getVisibility() != 0) {
            return false;
        }
        this.kvE.bAF();
        return true;
    }

    public void sy(boolean z) {
        if (this.glI != null) {
            if (z && this.Xe != null && this.Xe.getFirstVisiblePosition() != 0) {
                this.Xe.setSelection(0);
            }
            this.glI.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cWT() {
        this.kvJ = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.I(this.kvq.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bzY() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData DK(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kvG);
                writeData.setThreadId(m.this.kvF.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kvF.cWV()) {
                    writeData.setFloor(m.this.kvH > 0 ? String.valueOf(m.this.kvH) : m.this.kvF.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kvF.getPost_id());
                }
                if (m.this.kvI > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kvI));
                }
                if (m.this.kvF != null) {
                    writeData.setBaijiahaoData(m.this.kvF.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bzZ() {
                return null;
            }
        };
        this.kvK = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kvq.getBaseFragmentActivity() != null) {
                    m.this.kvq.getBaseFragmentActivity().hideProgressBar();
                    m.this.kvE.bzx().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kvy.a(m.this.kvz);
                        m.this.kvy.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bR(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kvq.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sD(boolean z) {
        if (this.kvE != null && this.kvE.bzx() != null && this.kvE.bzx().getParent() != null) {
            ((ViewGroup) this.kvE.bzx().getParent()).removeView(this.kvE.bzx());
        }
        this.kvE = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).ei(this.kvq.getPageContext().getPageActivity());
        this.kvE.a(this.kvq.getPageContext());
        this.kvE.b(this.kvJ);
        this.kvE.setFrom(3);
        this.kvE.j(this.kvq.getPageContext());
        this.kvE.bzx().kb(true);
        this.kvE.bzx().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kvE.bzx() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kvE.bzx(), layoutParams);
            this.kvE.bzx().hide();
        }
        this.kvE.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bAc() {
                if (m.this.kvq.getBaseFragmentActivity() != null) {
                    m.this.kvq.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kvE.b(this.kvK);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kvE != null) {
            if (i == 12005) {
                this.kvE.bAI();
                com.baidu.adp.lib.f.e.mY().postDelayed(this.fMU, 300L);
            }
            this.kvE.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kvE.bzx().bxU();
        this.kvE.bAF();
        this.kvE.bzx().bzK();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kvE.b(writeData);
                this.kvE.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m rk = this.kvE.bzx().rk(6);
                if (rk != null && rk.fnp != null) {
                    rk.fnp.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kvE.bAB();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, long j) {
        if (this.kvF != null && this.kvF.getBaijiahaoData() != null && this.kvF.isBjh()) {
            if (this.kvE == null || !this.kvE.isBJH) {
                sD(true);
            }
            if (this.kvE != null && this.kvF != null) {
                if (this.kvF.cWV() && this.kvF.getReplyer() != null) {
                    this.kvE.DU(this.kvF.getReplyer().getName_show());
                    return;
                } else {
                    this.kvE.DU(null);
                    return;
                }
            }
            return;
        }
        if (this.iLK == null) {
            this.iLK = new com.baidu.tieba.frs.profession.permission.c(this.kvq.getPageContext());
            this.iLK.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pI(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void C(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void pJ(boolean z) {
                    if (z) {
                        if (m.this.kvE == null || m.this.kvE.isBJH) {
                            m.this.sD(false);
                        }
                        if (m.this.kvE != null && m.this.kvF != null) {
                            if (!m.this.kvF.cWV() || m.this.kvF.getReplyer() == null) {
                                m.this.kvE.DU(null);
                            } else {
                                m.this.kvE.DU(m.this.kvF.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.iLK.G(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fMU);
        if (this.kvE != null) {
            this.kvE.onDestory();
        }
        if (this.kvy != null) {
            this.kvy.onDestroy();
        }
        if (this.kvD != null) {
            this.kvD.a((ReplyMeModel.a) null);
            this.kvD.onDestroy();
        }
        if (this.kvy != null) {
            this.kvy.a((am.a) null);
        }
    }

    public void e(com.baidu.adp.widget.ListView.ab abVar) {
        if (this.kvw != null) {
            this.kvw.e(abVar);
        }
    }

    public void b(ac acVar) {
        if (this.kvw != null) {
            this.kvw.a(acVar);
        }
    }

    public void onPrimary() {
        cWB();
    }

    public void DL(int i) {
        if (this.kvw != null) {
            this.kvw.DL(i);
        }
    }
}
