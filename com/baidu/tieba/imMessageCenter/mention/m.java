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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
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
    private BdTypeRecyclerView VT;
    private BdSwipeRefreshLayout fuP;
    private final f.c fzt;
    private com.baidu.tieba.frs.profession.permission.c hJL;
    private com.baidu.tieba.imMessageCenter.mention.base.f jpE;
    private boolean jpF;
    private f.a jpG;
    private NavigationBarShadowView jpe;
    private AttentionHostData jqA;
    private int jqB;
    private View.OnClickListener jqC;
    private RecyclerView.OnScrollListener jqD;
    private ReplyMeModel jqE;
    private com.baidu.tbadk.editortools.pb.h jqF;
    private com.baidu.tieba.imMessageCenter.mention.base.a jqG;
    private String jqH;
    private long jqI;
    private long jqJ;
    private DataModel<MessageCenterActivity> jqK;
    private NewWriteModel.d jqL;
    private final ReplyMeModel.a jqM;
    private final ReplyMessageFragment jqr;
    private PbListView jqw;
    private com.baidu.tieba.imMessageCenter.mention.base.e jqx;
    private boolean jqy;
    private al jqz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jqB = R.color.cp_bg_line_c;
        this.jpF = false;
        this.jqC = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.jqw != null && m.this.jqr != null) {
                    m.this.jqw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jqw.setOnClickListener(null);
                    m.this.jqw.startLoadData();
                    m.this.jqr.bQi();
                }
            }
        };
        this.fzt = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.jqr != null) {
                        m.this.jqr.cew();
                    }
                } else if (m.this.fuP != null) {
                    m.this.fuP.setRefreshing(false);
                }
            }
        };
        this.jqD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.jpe.show();
                            return;
                        } else {
                            m.this.jpe.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.jpe.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.jpG = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.jpE != null) {
                    m.this.VT.removeHeaderView(m.this.jpE.getView());
                    m.this.jpF = false;
                }
            }
        };
        this.jqE = null;
        this.jqM = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.jqH = str;
                m.this.jqI = j2;
                m.this.jqJ = j3;
                m.this.G(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.jqF != null) {
                    m.this.jqF.bjM();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.jqr = replyMessageFragment;
        this.jqz = new al(replyMessageFragment.getPageContext());
        this.jqz.a(new al.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z && m.this.jqF != null) {
                    m.this.jqF.bjI();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<q> arrayList) {
        if (this.VT != null) {
            qB(false);
            if (z) {
                this.jqw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jqw.endLoadData();
                this.jqw.setOnClickListener(this.jqC);
            } else {
                this.jqw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jqw.endLoadData();
                this.jqw.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.jqw.setOnClickListener(null);
            }
            if (x.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.m31do(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jqy) {
                    this.jqy = true;
                    this.VT.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.VT.setNextPage(null);
                if (arrayList != null) {
                    this.jqx.setData(arrayList);
                }
                this.jqB = R.color.cp_bg_line_e;
            } else {
                this.VT.removeHeaderView(this.mNoDataView);
                this.jqy = false;
                if (this.jqx != null) {
                    this.jqx.setData(arrayList);
                    this.jqx.notifyDataSetChanged();
                }
                this.VT.setNextPage(this.jqw);
                this.jqB = R.color.cp_bg_line_c;
            }
            cyN();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.jqx != null) {
            this.jqx.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bW(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.jpe = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jqr.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fzt);
        }
        this.mPullView.setTag(this.jqr.getUniqueId());
        if (this.jqw == null) {
            this.jqw = new PbListView(this.jqr.getContext());
            this.jqw.getView();
        }
        this.jqw.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.jqw.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jqr.getContext(), R.dimen.tbds182));
        this.jqw.setLineGone();
        this.jqw.setTextSize(R.dimen.tbfontsize33);
        this.jqw.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.jqw.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jqw.setOnClickListener(this.jqC);
        this.fuP = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.fuP.setProgressView(this.mPullView);
        this.VT = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.jqx = new com.baidu.tieba.imMessageCenter.mention.base.e(this.jqr.getPageContext(), this.VT);
        this.jqx.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long j;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.qH(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.jqG = aVar;
                        if (aVar.czh()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.czi(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.jqA == null) {
                            m.this.jqA = new AttentionHostData();
                        }
                        if (m.this.jqG != null) {
                            m.this.jqA.parserWithMetaData(m.this.jqG.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.jqG != null) {
                            baijiahaoData = m.this.jqG.getBaijiahaoData();
                        }
                        m.this.jqE.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.czj() != null) {
                            ap ah = new ap(aVar.czj()).ah("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jrn) {
                                ah.ah("obj_type", 1);
                            } else {
                                ah.ah("obj_type", 2);
                            }
                            TiebaStatic.log(ah);
                        }
                        ap apVar = new ap("c13784");
                        apVar.t("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(apVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.VT.getItemAnimator()).setSupportsChangeAnimations(false);
        this.VT.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.VT.setFadingEdgeLength(0);
        this.VT.setOverScrollMode(2);
        this.VT.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.VT.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.VT.setNextPage(this.jqw);
        this.VT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.jqw != null) {
                    m.this.jqw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jqw.setOnClickListener(null);
                    m.this.jqw.showLoading();
                    m.this.jqr.bQi();
                }
            }
        });
        this.VT.setOnScrollListener(this.mScrollListener);
        this.VT.addOnScrollListener(this.jqD);
        cze();
        this.jqE = new ReplyMeModel(this.jqr.getPageContext());
        this.jqE.a(this.jqM);
        czf();
        qG(false);
        return this.mRootView;
    }

    private void cze() {
        cyN();
    }

    private void cyN() {
        if (this.VT != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.jqr.getFragmentActivity()).areNotificationsEnabled();
            ap apVar = new ap("c13616");
            apVar.ah("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(apVar);
            if (areNotificationsEnabled) {
                if (this.jpE != null) {
                    this.VT.removeHeaderView(this.jpE.getView());
                    this.jpF = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_im_open_notification_close_time", 0L);
            if (this.jpF) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jpE == null) {
                    this.jpE = new com.baidu.tieba.imMessageCenter.mention.base.f(this.jqr.getPageContext());
                    this.jpE.a(this.jpG);
                }
                this.VT.addHeaderView(this.jpE.getView(), 0);
                this.jpF = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jqF != null && this.jqF.biJ() != null) {
            this.jqF.biJ().onChangeSkinType(i);
        }
        if (this.jqw != null) {
            this.jqw.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.jqw.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        notifyDataSetChanged();
        ao.setBackgroundColor(this.VT, this.jqB);
        ao.setBackgroundColor(this.fuP, R.color.cp_bg_line_e);
        if (this.jpE != null) {
            this.jpE.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.jqF == null || this.jqF.biJ() == null || this.jqF.biJ().getVisibility() != 0) {
            return false;
        }
        this.jqF.bjM();
        return true;
    }

    public void qB(boolean z) {
        if (this.fuP != null) {
            if (z && this.VT != null && this.VT.getFirstVisiblePosition() != 0) {
                this.VT.setSelection(0);
            }
            this.fuP.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void czf() {
        this.jqK = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.G(this.jqr.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bjf() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData zE(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.jqH);
                writeData.setThreadId(m.this.jqG.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.jqG.czh()) {
                    writeData.setFloor(m.this.jqI > 0 ? String.valueOf(m.this.jqI) : m.this.jqG.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.jqG.getPost_id());
                }
                if (m.this.jqJ > 0) {
                    writeData.setRepostId(String.valueOf(m.this.jqJ));
                }
                if (m.this.jqG != null) {
                    writeData.setBaijiahaoData(m.this.jqG.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bjg() {
                return null;
            }
        };
        this.jqL = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                if (m.this.jqr.getBaseFragmentActivity() != null) {
                    m.this.jqr.getBaseFragmentActivity().hideProgressBar();
                    m.this.jqF.biJ().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.jqz.a(m.this.jqA);
                        m.this.jqz.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && adVar == null && !AntiHelper.bB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.jqr.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(boolean z) {
        if (this.jqF != null && this.jqF.biJ() != null && this.jqF.biJ().getParent() != null) {
            ((ViewGroup) this.jqF.biJ().getParent()).removeView(this.jqF.biJ());
        }
        this.jqF = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dT(this.jqr.getPageContext().getPageActivity());
        this.jqF.a(this.jqr.getPageContext());
        this.jqF.b(this.jqK);
        this.jqF.j(this.jqr.getPageContext());
        this.jqF.biJ().iJ(true);
        this.jqF.biJ().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jqF.biJ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.jqF.biJ(), layoutParams);
            this.jqF.biJ().hide();
        }
        this.jqF.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bjj() {
                if (m.this.jqr.getBaseFragmentActivity() != null) {
                    m.this.jqr.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.jqF.b(this.jqL);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.jqF != null) {
            if (i == 12005) {
                this.jqF.bjP();
            }
            this.jqF.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.jqF.biJ().bhl();
        this.jqF.bjM();
        this.jqF.biJ().biU();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jqF.b(writeData);
                this.jqF.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l nT = this.jqF.biJ().nT(6);
                if (nT != null && nT.ezZ != null) {
                    nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jqF.bjI();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, long j) {
        if (this.jqG != null && this.jqG.getBaijiahaoData() != null && this.jqG.isBjh()) {
            if (this.jqF == null || !this.jqF.isBJH) {
                qG(true);
            }
            if (this.jqF != null && this.jqG != null) {
                if (this.jqG.czh() && this.jqG.getReplyer() != null) {
                    this.jqF.zO(this.jqG.getReplyer().getName_show());
                    return;
                } else {
                    this.jqF.zO(null);
                    return;
                }
            }
            return;
        }
        if (this.hJL == null) {
            this.hJL = new com.baidu.tieba.frs.profession.permission.c(this.jqr.getPageContext());
            this.hJL.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nQ(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void z(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void nR(boolean z) {
                    if (z) {
                        if (m.this.jqF == null || m.this.jqF.isBJH) {
                            m.this.qG(false);
                        }
                        if (m.this.jqF != null && m.this.jqG != null) {
                            if (!m.this.jqG.czh() || m.this.jqG.getReplyer() == null) {
                                m.this.jqF.zO(null);
                            } else {
                                m.this.jqF.zO(m.this.jqG.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.hJL.B(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.jqF != null) {
            this.jqF.onDestory();
        }
        if (this.jqz != null) {
            this.jqz.onDestroy();
        }
        if (this.jqE != null) {
            this.jqE.a((ReplyMeModel.a) null);
            this.jqE.onDestroy();
        }
        if (this.jqz != null) {
            this.jqz.a((al.a) null);
        }
    }

    public void e(z zVar) {
        if (this.jqx != null) {
            this.jqx.e(zVar);
        }
    }

    public void b(com.baidu.adp.widget.ListView.aa aaVar) {
        if (this.jqx != null) {
            this.jqx.a(aaVar);
        }
    }

    public void onPrimary() {
        cyN();
    }

    public void zF(int i) {
        if (this.jqx != null) {
            this.jqx.zF(i);
        }
    }
}
