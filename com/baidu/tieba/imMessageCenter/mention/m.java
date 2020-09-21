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
/* loaded from: classes21.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView WM;
    private BdSwipeRefreshLayout fJy;
    private final f.c fOd;
    private Runnable fmw;
    private com.baidu.tieba.frs.profession.permission.c ieu;
    private NavigationBarShadowView jMK;
    private final ReplyMessageFragment jNX;
    private com.baidu.tieba.imMessageCenter.mention.base.f jNk;
    private boolean jNl;
    private f.a jNm;
    private PbListView jOc;
    private com.baidu.tieba.imMessageCenter.mention.base.e jOd;
    private boolean jOe;
    private am jOf;
    private AttentionHostData jOg;
    private int jOh;
    private View.OnClickListener jOi;
    private RecyclerView.OnScrollListener jOj;
    private ReplyMeModel jOk;
    private com.baidu.tbadk.editortools.pb.h jOl;
    private com.baidu.tieba.imMessageCenter.mention.base.a jOm;
    private String jOn;
    private long jOo;
    private long jOp;
    private DataModel<MessageCenterActivity> jOq;
    private NewWriteModel.d jOr;
    private final ReplyMeModel.a jOs;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jOh = R.color.cp_bg_line_c;
        this.jNl = false;
        this.jOi = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.jOc != null && m.this.jNX != null) {
                    m.this.jOc.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jOc.setOnClickListener(null);
                    m.this.jOc.startLoadData();
                    m.this.jNX.cdG();
                }
            }
        };
        this.fOd = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.jNX != null) {
                        m.this.jNX.cso();
                    }
                } else if (m.this.fJy != null) {
                    m.this.fJy.setRefreshing(false);
                }
            }
        };
        this.jOj = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.jMK.show();
                            return;
                        } else {
                            m.this.jMK.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.jMK.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.jNm = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.jNk != null) {
                    m.this.WM.removeHeaderView(m.this.jNk.getView());
                    m.this.jNl = false;
                }
            }
        };
        this.jOk = null;
        this.fmw = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.jOl != null && m.this.jOl.btH() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.jOl.btH().getInputView());
                }
            }
        };
        this.jOs = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.jOn = str;
                m.this.jOo = j2;
                m.this.jOp = j3;
                m.this.I(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.jOl != null) {
                    m.this.jOl.btD();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.jNX = replyMessageFragment;
        this.jOf = new am(replyMessageFragment.getPageContext());
        this.jOf.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z && m.this.jOl != null) {
                    m.this.jOl.btz();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<q> arrayList) {
        if (this.WM != null) {
            rr(false);
            if (z) {
                this.jOc.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jOc.endLoadData();
                this.jOc.setOnClickListener(this.jOi);
            } else {
                this.jOc.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jOc.endLoadData();
                this.jOc.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.jOc.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dG(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jOe) {
                    this.jOe = true;
                    this.WM.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.WM.setNextPage(null);
                if (arrayList != null) {
                    this.jOd.setData(arrayList);
                }
                this.jOh = R.color.cp_bg_line_e;
            } else {
                this.WM.removeHeaderView(this.mNoDataView);
                this.jOe = false;
                if (this.jOd != null) {
                    this.jOd.setData(arrayList);
                    this.jOd.notifyDataSetChanged();
                }
                this.WM.setNextPage(this.jOc);
                this.jOh = R.color.cp_bg_line_c;
            }
            cNl();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.jOd != null) {
            this.jOd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bT(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.jMK = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jNX.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fOd);
        }
        this.mPullView.setTag(this.jNX.getUniqueId());
        if (this.jOc == null) {
            this.jOc = new PbListView(this.jNX.getContext());
            this.jOc.getView();
        }
        this.jOc.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.jOc.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jNX.getContext(), R.dimen.tbds182));
        this.jOc.setLineGone();
        this.jOc.setTextSize(R.dimen.tbfontsize33);
        this.jOc.setTextColor(ap.getColor(R.color.cp_cont_d));
        this.jOc.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jOc.setOnClickListener(this.jOi);
        this.fJy = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.fJy.setProgressView(this.mPullView);
        this.WM = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.jOd = new com.baidu.tieba.imMessageCenter.mention.base.e(this.jNX.getPageContext(), this.WM);
        this.jOd.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.rx(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.jOm = aVar;
                        if (aVar.cNF()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cNG(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.jOg == null) {
                            m.this.jOg = new AttentionHostData();
                        }
                        if (m.this.jOm != null) {
                            m.this.jOg.parserWithMetaData(m.this.jOm.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.jOm != null) {
                            baijiahaoData = m.this.jOm.getBaijiahaoData();
                        }
                        m.this.jOk.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cNH() != null) {
                            aq ai = new aq(aVar.cNH()).ai("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jOT) {
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
        ((DefaultItemAnimator) this.WM.getItemAnimator()).setSupportsChangeAnimations(false);
        this.WM.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.WM.setFadingEdgeLength(0);
        this.WM.setOverScrollMode(2);
        this.WM.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.WM.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.WM.setNextPage(this.jOc);
        this.WM.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.jOc != null) {
                    m.this.jOc.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jOc.setOnClickListener(null);
                    m.this.jOc.showLoading();
                    m.this.jNX.cdG();
                }
            }
        });
        this.WM.setOnScrollListener(this.mScrollListener);
        this.WM.addOnScrollListener(this.jOj);
        cNC();
        this.jOk = new ReplyMeModel(this.jNX.getPageContext());
        this.jOk.a(this.jOs);
        cND();
        rw(false);
        return this.mRootView;
    }

    private void cNC() {
        cNl();
    }

    private void cNl() {
        if (this.WM != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.jNX.getFragmentActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.ai("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.jNk != null) {
                    this.WM.removeHeaderView(this.jNk.getView());
                    this.jNl = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bjf().getLong("key_im_open_notification_close_time", 0L);
            if (this.jNl) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jNk == null) {
                    this.jNk = new com.baidu.tieba.imMessageCenter.mention.base.f(this.jNX.getPageContext());
                    this.jNk.a(this.jNm);
                }
                this.WM.addHeaderView(this.jNk.getView(), 0);
                this.jNl = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jOl != null && this.jOl.bsv() != null) {
            this.jOl.bsv().onChangeSkinType(i);
        }
        if (this.jOc != null) {
            this.jOc.setTextColor(ap.getColor(R.color.cp_cont_d));
            this.jOc.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.WM, this.jOh);
        ap.setBackgroundColor(this.fJy, R.color.cp_bg_line_e);
        if (this.jNk != null) {
            this.jNk.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.jOl == null || this.jOl.bsv() == null || this.jOl.bsv().getVisibility() != 0) {
            return false;
        }
        this.jOl.btD();
        return true;
    }

    public void rr(boolean z) {
        if (this.fJy != null) {
            if (z && this.WM != null && this.WM.getFirstVisiblePosition() != 0) {
                this.WM.setSelection(0);
            }
            this.fJy.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cND() {
        this.jOq = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.I(this.jNX.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bsW() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData Cr(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.jOn);
                writeData.setThreadId(m.this.jOm.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.jOm.cNF()) {
                    writeData.setFloor(m.this.jOo > 0 ? String.valueOf(m.this.jOo) : m.this.jOm.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.jOm.getPost_id());
                }
                if (m.this.jOp > 0) {
                    writeData.setRepostId(String.valueOf(m.this.jOp));
                }
                if (m.this.jOm != null) {
                    writeData.setBaijiahaoData(m.this.jOm.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bsX() {
                return null;
            }
        };
        this.jOr = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.jNX.getBaseFragmentActivity() != null) {
                    m.this.jNX.getBaseFragmentActivity().hideProgressBar();
                    m.this.jOl.bsv().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.jOf.a(m.this.jOg);
                        m.this.jOf.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bC(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.jNX.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rw(boolean z) {
        if (this.jOl != null && this.jOl.bsv() != null && this.jOl.bsv().getParent() != null) {
            ((ViewGroup) this.jOl.bsv().getParent()).removeView(this.jOl.bsv());
        }
        this.jOl = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).eb(this.jNX.getPageContext().getPageActivity());
        this.jOl.a(this.jNX.getPageContext());
        this.jOl.b(this.jOq);
        this.jOl.setFrom(3);
        this.jOl.j(this.jNX.getPageContext());
        this.jOl.bsv().jh(true);
        this.jOl.bsv().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jOl.bsv() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.jOl.bsv(), layoutParams);
            this.jOl.bsv().hide();
        }
        this.jOl.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bta() {
                if (m.this.jNX.getBaseFragmentActivity() != null) {
                    m.this.jNX.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.jOl.b(this.jOr);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.jOl != null) {
            if (i == 12005) {
                this.jOl.btG();
                com.baidu.adp.lib.f.e.mX().postDelayed(this.fmw, 300L);
            }
            this.jOl.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.jOl.bsv().bqS();
        this.jOl.btD();
        this.jOl.bsv().bsI();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jOl.b(writeData);
                this.jOl.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qr = this.jOl.bsv().qr(6);
                if (qr != null && qr.eMS != null) {
                    qr.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jOl.btz();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, long j) {
        if (this.jOm != null && this.jOm.getBaijiahaoData() != null && this.jOm.isBjh()) {
            if (this.jOl == null || !this.jOl.isBJH) {
                rw(true);
            }
            if (this.jOl != null && this.jOm != null) {
                if (this.jOm.cNF() && this.jOm.getReplyer() != null) {
                    this.jOl.CB(this.jOm.getReplyer().getName_show());
                    return;
                } else {
                    this.jOl.CB(null);
                    return;
                }
            }
            return;
        }
        if (this.ieu == null) {
            this.ieu = new com.baidu.tieba.frs.profession.permission.c(this.jNX.getPageContext());
            this.ieu.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void oC(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void z(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void oD(boolean z) {
                    if (z) {
                        if (m.this.jOl == null || m.this.jOl.isBJH) {
                            m.this.rw(false);
                        }
                        if (m.this.jOl != null && m.this.jOm != null) {
                            if (!m.this.jOm.cNF() || m.this.jOm.getReplyer() == null) {
                                m.this.jOl.CB(null);
                            } else {
                                m.this.jOl.CB(m.this.jOm.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.ieu.D(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fmw);
        if (this.jOl != null) {
            this.jOl.onDestory();
        }
        if (this.jOf != null) {
            this.jOf.onDestroy();
        }
        if (this.jOk != null) {
            this.jOk.a((ReplyMeModel.a) null);
            this.jOk.onDestroy();
        }
        if (this.jOf != null) {
            this.jOf.a((am.a) null);
        }
    }

    public void e(ab abVar) {
        if (this.jOd != null) {
            this.jOd.e(abVar);
        }
    }

    public void b(ac acVar) {
        if (this.jOd != null) {
            this.jOd.a(acVar);
        }
    }

    public void onPrimary() {
        cNl();
    }

    public void Cz(int i) {
        if (this.jOd != null) {
            this.jOd.Cz(i);
        }
    }
}
