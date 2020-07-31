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
    private com.baidu.tieba.imMessageCenter.mention.base.f jpC;
    private boolean jpD;
    private f.a jpE;
    private NavigationBarShadowView jpc;
    private View.OnClickListener jqA;
    private RecyclerView.OnScrollListener jqB;
    private ReplyMeModel jqC;
    private com.baidu.tbadk.editortools.pb.h jqD;
    private com.baidu.tieba.imMessageCenter.mention.base.a jqE;
    private String jqF;
    private long jqG;
    private long jqH;
    private DataModel<MessageCenterActivity> jqI;
    private NewWriteModel.d jqJ;
    private final ReplyMeModel.a jqK;
    private final ReplyMessageFragment jqp;
    private PbListView jqu;
    private com.baidu.tieba.imMessageCenter.mention.base.e jqv;
    private boolean jqw;
    private al jqx;
    private AttentionHostData jqy;
    private int jqz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.jqz = R.color.cp_bg_line_c;
        this.jpD = false;
        this.jqA = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.jqu != null && m.this.jqp != null) {
                    m.this.jqu.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jqu.setOnClickListener(null);
                    m.this.jqu.startLoadData();
                    m.this.jqp.bQi();
                }
            }
        };
        this.fzt = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.jqp != null) {
                        m.this.jqp.cew();
                    }
                } else if (m.this.fuP != null) {
                    m.this.fuP.setRefreshing(false);
                }
            }
        };
        this.jqB = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.jpc.show();
                            return;
                        } else {
                            m.this.jpc.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.jpc.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.jpE = new f.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.tieba.imMessageCenter.mention.base.f.a
            public void onClose() {
                if (m.this.jpC != null) {
                    m.this.VT.removeHeaderView(m.this.jpC.getView());
                    m.this.jpD = false;
                }
            }
        };
        this.jqC = null;
        this.jqK = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.jqF = str;
                m.this.jqG = j2;
                m.this.jqH = j3;
                m.this.G(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.jqD != null) {
                    m.this.jqD.bjM();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.jqp = replyMessageFragment;
        this.jqx = new al(replyMessageFragment.getPageContext());
        this.jqx.a(new al.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z && m.this.jqD != null) {
                    m.this.jqD.bjI();
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
                this.jqu.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jqu.endLoadData();
                this.jqu.setOnClickListener(this.jqA);
            } else {
                this.jqu.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.jqu.endLoadData();
                this.jqu.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.jqu.setOnClickListener(null);
            }
            if (x.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.m31do(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.jqw) {
                    this.jqw = true;
                    this.VT.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.VT.setNextPage(null);
                if (arrayList != null) {
                    this.jqv.setData(arrayList);
                }
                this.jqz = R.color.cp_bg_line_e;
            } else {
                this.VT.removeHeaderView(this.mNoDataView);
                this.jqw = false;
                if (this.jqv != null) {
                    this.jqv.setData(arrayList);
                    this.jqv.notifyDataSetChanged();
                }
                this.VT.setNextPage(this.jqu);
                this.jqz = R.color.cp_bg_line_c;
            }
            cyN();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.jqv != null) {
            this.jqv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View bW(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.jpc = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.jqp.getPageContext());
            this.mPullView.setListPullRefreshListener(this.fzt);
        }
        this.mPullView.setTag(this.jqp.getUniqueId());
        if (this.jqu == null) {
            this.jqu = new PbListView(this.jqp.getContext());
            this.jqu.getView();
        }
        this.jqu.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.jqu.setHeight(com.baidu.adp.lib.util.l.getDimens(this.jqp.getContext(), R.dimen.tbds182));
        this.jqu.setLineGone();
        this.jqu.setTextSize(R.dimen.tbfontsize33);
        this.jqu.setTextColor(ao.getColor(R.color.cp_cont_d));
        this.jqu.setNoMoreTextColorId(R.color.cp_cont_e);
        this.jqu.setOnClickListener(this.jqA);
        this.fuP = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.fuP.setProgressView(this.mPullView);
        this.VT = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.jqv = new com.baidu.tieba.imMessageCenter.mention.base.e(this.jqp.getPageContext(), this.VT);
        this.jqv.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
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
                        m.this.jqE = aVar;
                        if (aVar.czh()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.czi(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.jqy == null) {
                            m.this.jqy = new AttentionHostData();
                        }
                        if (m.this.jqE != null) {
                            m.this.jqy.parserWithMetaData(m.this.jqE.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.jqE != null) {
                            baijiahaoData = m.this.jqE.getBaijiahaoData();
                        }
                        m.this.jqC.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.czj() != null) {
                            ap ah = new ap(aVar.czj()).ah("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jrl) {
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
        this.VT.setNextPage(this.jqu);
        this.VT.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.jqu != null) {
                    m.this.jqu.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.jqu.setOnClickListener(null);
                    m.this.jqu.showLoading();
                    m.this.jqp.bQi();
                }
            }
        });
        this.VT.setOnScrollListener(this.mScrollListener);
        this.VT.addOnScrollListener(this.jqB);
        cze();
        this.jqC = new ReplyMeModel(this.jqp.getPageContext());
        this.jqC.a(this.jqK);
        czf();
        qG(false);
        return this.mRootView;
    }

    private void cze() {
        cyN();
    }

    private void cyN() {
        if (this.VT != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.jqp.getFragmentActivity()).areNotificationsEnabled();
            ap apVar = new ap("c13616");
            apVar.ah("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(apVar);
            if (areNotificationsEnabled) {
                if (this.jpC != null) {
                    this.VT.removeHeaderView(this.jpC.getView());
                    this.jpD = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.aZP().getLong("key_im_open_notification_close_time", 0L);
            if (this.jpD) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.jpC == null) {
                    this.jpC = new com.baidu.tieba.imMessageCenter.mention.base.f(this.jqp.getPageContext());
                    this.jpC.a(this.jpE);
                }
                this.VT.addHeaderView(this.jpC.getView(), 0);
                this.jpD = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jqD != null && this.jqD.biJ() != null) {
            this.jqD.biJ().onChangeSkinType(i);
        }
        if (this.jqu != null) {
            this.jqu.setTextColor(ao.getColor(R.color.cp_cont_d));
            this.jqu.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        }
        notifyDataSetChanged();
        ao.setBackgroundColor(this.VT, this.jqz);
        ao.setBackgroundColor(this.fuP, R.color.cp_bg_line_e);
        if (this.jpC != null) {
            this.jpC.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.jqD == null || this.jqD.biJ() == null || this.jqD.biJ().getVisibility() != 0) {
            return false;
        }
        this.jqD.bjM();
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
        this.jqI = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.G(this.jqp.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
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
                writeData.setForumName(m.this.jqF);
                writeData.setThreadId(m.this.jqE.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.jqE.czh()) {
                    writeData.setFloor(m.this.jqG > 0 ? String.valueOf(m.this.jqG) : m.this.jqE.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.jqE.getPost_id());
                }
                if (m.this.jqH > 0) {
                    writeData.setRepostId(String.valueOf(m.this.jqH));
                }
                if (m.this.jqE != null) {
                    writeData.setBaijiahaoData(m.this.jqE.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bjg() {
                return null;
            }
        };
        this.jqJ = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
                if (m.this.jqp.getBaseFragmentActivity() != null) {
                    m.this.jqp.getBaseFragmentActivity().hideProgressBar();
                    m.this.jqD.biJ().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.jqx.a(m.this.jqy);
                        m.this.jqx.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && adVar == null && !AntiHelper.bB(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.jqp.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(boolean z) {
        if (this.jqD != null && this.jqD.biJ() != null && this.jqD.biJ().getParent() != null) {
            ((ViewGroup) this.jqD.biJ().getParent()).removeView(this.jqD.biJ());
        }
        this.jqD = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).dT(this.jqp.getPageContext().getPageActivity());
        this.jqD.a(this.jqp.getPageContext());
        this.jqD.b(this.jqI);
        this.jqD.j(this.jqp.getPageContext());
        this.jqD.biJ().iJ(true);
        this.jqD.biJ().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jqD.biJ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.jqD.biJ(), layoutParams);
            this.jqD.biJ().hide();
        }
        this.jqD.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bjj() {
                if (m.this.jqp.getBaseFragmentActivity() != null) {
                    m.this.jqp.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.jqD.b(this.jqJ);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.jqD != null) {
            if (i == 12005) {
                this.jqD.bjP();
            }
            this.jqD.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.jqD.biJ().bhl();
        this.jqD.bjM();
        this.jqD.biJ().biU();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.jqD.b(writeData);
                this.jqD.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.l nT = this.jqD.biJ().nT(6);
                if (nT != null && nT.ezZ != null) {
                    nT.ezZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.jqD.bjI();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, long j) {
        if (this.jqE != null && this.jqE.getBaijiahaoData() != null && this.jqE.isBjh()) {
            if (this.jqD == null || !this.jqD.isBJH) {
                qG(true);
            }
            if (this.jqD != null && this.jqE != null) {
                if (this.jqE.czh() && this.jqE.getReplyer() != null) {
                    this.jqD.zO(this.jqE.getReplyer().getName_show());
                    return;
                } else {
                    this.jqD.zO(null);
                    return;
                }
            }
            return;
        }
        if (this.hJL == null) {
            this.hJL = new com.baidu.tieba.frs.profession.permission.c(this.jqp.getPageContext());
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
                        if (m.this.jqD == null || m.this.jqD.isBJH) {
                            m.this.qG(false);
                        }
                        if (m.this.jqD != null && m.this.jqE != null) {
                            if (!m.this.jqE.czh() || m.this.jqE.getReplyer() == null) {
                                m.this.jqD.zO(null);
                            } else {
                                m.this.jqD.zO(m.this.jqE.getReplyer().getName_show());
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
        if (this.jqD != null) {
            this.jqD.onDestory();
        }
        if (this.jqx != null) {
            this.jqx.onDestroy();
        }
        if (this.jqC != null) {
            this.jqC.a((ReplyMeModel.a) null);
            this.jqC.onDestroy();
        }
        if (this.jqx != null) {
            this.jqx.a((al.a) null);
        }
    }

    public void e(z zVar) {
        if (this.jqv != null) {
            this.jqv.e(zVar);
        }
    }

    public void b(com.baidu.adp.widget.ListView.aa aaVar) {
        if (this.jqv != null) {
            this.jqv.a(aaVar);
        }
    }

    public void onPrimary() {
        cyN();
    }

    public void zF(int i) {
        if (this.jqv != null) {
            this.jqv.zF(i);
        }
    }
}
