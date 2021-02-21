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
    private BdTypeRecyclerView XW;
    private BdSwipeRefreshLayout gCQ;
    private final f.c gHz;
    private Runnable gbv;
    private com.baidu.tieba.frs.profession.permission.c jkQ;
    private com.baidu.tieba.imMessageCenter.mention.base.e kRE;
    private boolean kRF;
    private e.a kRG;
    private NavigationBarShadowView kRe;
    private AttentionHostData kSA;
    private int kSB;
    private View.OnClickListener kSC;
    private RecyclerView.OnScrollListener kSD;
    private ReplyMeModel kSE;
    private com.baidu.tbadk.editortools.pb.h kSF;
    private com.baidu.tieba.imMessageCenter.mention.base.a kSG;
    private String kSH;
    private long kSI;
    private long kSJ;
    private DataModel<MessageCenterActivity> kSK;
    private NewWriteModel.d kSL;
    private final ReplyMeModel.a kSM;
    private final ReplyMessageFragment kSr;
    private PbListView kSw;
    private com.baidu.tieba.imMessageCenter.mention.base.d kSx;
    private boolean kSy;
    private am kSz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kSB = R.color.CAM_X0204;
        this.kRF = false;
        this.kSC = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kSw != null && m.this.kSr != null) {
                    m.this.kSw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kSw.setOnClickListener(null);
                    m.this.kSw.startLoadData();
                    m.this.kSr.cqU();
                }
            }
        };
        this.gHz = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kSr != null) {
                        m.this.kSr.cFL();
                    }
                } else if (m.this.gCQ != null) {
                    m.this.gCQ.setRefreshing(false);
                }
            }
        };
        this.kSD = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kRe.show();
                            return;
                        } else {
                            m.this.kRe.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kRe.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kRG = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (m.this.kRE != null) {
                    m.this.XW.removeHeaderView(m.this.kRE.getView());
                    m.this.kRF = false;
                }
            }
        };
        this.kSE = null;
        this.gbv = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kSF != null && m.this.kSF.bCu() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kSF.bCu().getInputView());
                }
            }
        };
        this.kSM = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kSH = str;
                m.this.kSI = j2;
                m.this.kSJ = j3;
                m.this.L(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kSF != null) {
                    m.this.kSF.bCq();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kSr = replyMessageFragment;
        this.kSz = new am(replyMessageFragment.getPageContext());
        this.kSz.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z && m.this.kSF != null) {
                    m.this.kSF.bCm();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<n> arrayList) {
        if (this.XW != null) {
            this.gCQ.setVisibility(0);
            tn(false);
            if (z) {
                this.kSw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kSw.endLoadData();
                this.kSw.setOnClickListener(this.kSC);
            } else {
                this.kSw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kSw.endLoadData();
                this.kSw.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kSw.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dS(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kSy) {
                    this.kSy = true;
                    this.XW.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.XW.setNextPage(null);
                if (arrayList != null) {
                    this.kSx.setData(arrayList);
                }
                this.kSB = R.color.CAM_X0205;
            } else {
                this.XW.removeHeaderView(this.mNoDataView);
                this.kSy = false;
                if (this.kSx != null) {
                    this.kSx.setData(arrayList);
                    this.kSx.notifyDataSetChanged();
                }
                this.XW.setNextPage(this.kSw);
                this.kSB = R.color.CAM_X0204;
            }
            cZl();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kSx != null) {
            this.kSx.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View cj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kRe = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kSr.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gHz);
        }
        this.mPullView.setTag(this.kSr.getUniqueId());
        if (this.kSw == null) {
            this.kSw = new PbListView(this.kSr.getContext());
            this.kSw.getView();
        }
        this.kSw.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.kSw.bud();
        this.kSw.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kSr.getContext(), R.dimen.tbds182));
        this.kSw.setLineGone();
        this.kSw.setTextSize(R.dimen.tbfontsize33);
        this.kSw.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.kSw.setNoMoreTextColorId(R.color.CAM_X0110);
        this.kSw.setOnClickListener(this.kSC);
        this.gCQ = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.gCQ.setProgressView(this.mPullView);
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kSx = new com.baidu.tieba.imMessageCenter.mention.base.d(this.kSr.getPageContext(), this.XW);
        this.kSx.setOnCardSubClickListener(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.kSG = aVar;
                        if (aVar.cZH()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cZI(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kSA == null) {
                            m.this.kSA = new AttentionHostData();
                        }
                        if (m.this.kSG != null) {
                            m.this.kSA.parserWithMetaData(m.this.kSG.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kSG != null) {
                            baijiahaoData = m.this.kSG.getBaijiahaoData();
                        }
                        m.this.kSE.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cZJ() != null) {
                            ar ap = new ar(aVar.cZJ()).ap("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kTn) {
                                ap.ap("obj_type", 1);
                            } else {
                                ap.ap("obj_type", 2);
                            }
                            TiebaStatic.log(ap);
                        }
                        ar arVar = new ar("c13784");
                        arVar.v("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(arVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.XW.getItemAnimator()).setSupportsChangeAnimations(false);
        this.XW.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.XW.setFadingEdgeLength(0);
        this.XW.setOverScrollMode(2);
        this.XW.addItemDecoration(new DeviderLineDecoration());
        this.XW.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.XW.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.kSw != null) {
                    m.this.kSw.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kSw.setOnClickListener(null);
                    m.this.kSw.showLoading();
                    m.this.kSr.cqU();
                }
            }
        });
        this.XW.setOnScrollListener(this.mScrollListener);
        this.XW.addOnScrollListener(this.kSD);
        cZD();
        this.kSE = new ReplyMeModel(this.kSr.getPageContext());
        this.kSE.a(this.kSM);
        cZE();
        ts(false);
        return this.mRootView;
    }

    private void cZD() {
        cZl();
    }

    private void cZl() {
        if (this.XW != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kSr.getFragmentActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.ap("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kRE != null) {
                    this.XW.removeHeaderView(this.kRE.getView());
                    this.kRF = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_im_open_notification_close_time", 0L);
            if (this.kRF) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kRE == null) {
                    this.kRE = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kSr.getPageContext());
                    this.kRE.a(this.kRG);
                }
                this.XW.addHeaderView(this.kRE.getView(), 0);
                this.kRF = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kSF != null && this.kSF.bBh() != null) {
            this.kSF.bBh().onChangeSkinType(i);
        }
        if (this.kSw != null) {
            this.kSw.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.kSw.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.XW, this.kSB);
        ap.setBackgroundColor(this.gCQ, R.color.CAM_X0205);
        if (this.kRE != null) {
            this.kRE.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kSF == null || this.kSF.bBh() == null || this.kSF.bBh().getVisibility() != 0) {
            return false;
        }
        this.kSF.bCq();
        return true;
    }

    public void tn(boolean z) {
        if (this.gCQ != null) {
            if (z && this.XW != null && this.XW.getFirstVisiblePosition() != 0) {
                this.XW.setSelection(0);
            }
            this.gCQ.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cZE() {
        this.kSK = new DataModel<MessageCenterActivity>(com.baidu.adp.base.j.K(this.kSr.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bBI() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData CR(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kSH);
                writeData.setThreadId(m.this.kSG.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kSG.cZH()) {
                    writeData.setFloor(m.this.kSI > 0 ? String.valueOf(m.this.kSI) : m.this.kSG.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kSG.getPost_id());
                }
                if (m.this.kSJ > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kSJ));
                }
                if (m.this.kSG != null) {
                    writeData.setBaijiahaoData(m.this.kSG.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bBJ() {
                return null;
            }
        };
        this.kSL = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kSr.getBaseFragmentActivity() != null) {
                    m.this.kSr.getBaseFragmentActivity().hideProgressBar();
                    m.this.kSF.bBh().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kSz.a(m.this.kSA);
                        m.this.kSz.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bX(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kSr.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(boolean z) {
        if (this.kSF != null && this.kSF.bBh() != null && this.kSF.bBh().getParent() != null) {
            ((ViewGroup) this.kSF.bBh().getParent()).removeView(this.kSF.bBh());
        }
        this.kSF = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).fg(this.kSr.getPageContext().getPageActivity());
        this.kSF.a(this.kSr.getPageContext());
        this.kSF.b(this.kSK);
        this.kSF.setFrom(3);
        this.kSF.j(this.kSr.getPageContext());
        this.kSF.bBh().kN(true);
        this.kSF.bBh().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kSF.bBh() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kSF.bBh(), layoutParams);
            this.kSF.bBh().hide();
        }
        this.kSF.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bBM() {
                if (m.this.kSr.getBaseFragmentActivity() != null) {
                    m.this.kSr.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kSF.b(this.kSL);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kSF != null) {
            if (i == 12005) {
                this.kSF.bCt();
                com.baidu.adp.lib.f.e.mA().postDelayed(this.gbv, 300L);
            }
            this.kSF.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kSF.bBh().bzD();
        this.kSF.bCq();
        this.kSF.bBh().bBu();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kSF.c(writeData);
                this.kSF.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qU = this.kSF.bBh().qU(6);
                if (qU != null && qU.fBo != null) {
                    qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kSF.bCm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, long j) {
        if (this.kSG != null && this.kSG.getBaijiahaoData() != null && this.kSG.isBjh()) {
            if (this.kSF == null || !this.kSF.isBJH) {
                ts(true);
            }
            if (this.kSF != null && this.kSG != null) {
                if (this.kSG.cZH() && this.kSG.getReplyer() != null) {
                    this.kSF.Db(this.kSG.getReplyer().getName_show());
                    return;
                } else {
                    this.kSF.Db(null);
                    return;
                }
            }
            return;
        }
        if (this.jkQ == null) {
            this.jkQ = new com.baidu.tieba.frs.profession.permission.c(this.kSr.getPageContext());
            this.jkQ.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qM(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void B(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qN(boolean z) {
                    if (z) {
                        if (m.this.kSF == null || m.this.kSF.isBJH) {
                            m.this.ts(false);
                        }
                        if (m.this.kSF != null && m.this.kSG != null) {
                            if (!m.this.kSG.cZH() || m.this.kSG.getReplyer() == null) {
                                m.this.kSF.Db(null);
                            } else {
                                m.this.kSF.Db(m.this.kSG.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.jkQ.G(str, j);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gbv);
        if (this.kSF != null) {
            this.kSF.onDestory();
        }
        if (this.kSz != null) {
            this.kSz.onDestroy();
        }
        if (this.kSE != null) {
            this.kSE.a((ReplyMeModel.a) null);
            this.kSE.onDestroy();
        }
        if (this.kSz != null) {
            this.kSz.a((am.a) null);
        }
    }

    public void e(w wVar) {
        if (this.kSx != null) {
            this.kSx.e(wVar);
        }
    }

    public void b(x xVar) {
        if (this.kSx != null) {
            this.kSx.a(xVar);
        }
    }

    public void onPrimary() {
        cZl();
    }

    public void DB(int i) {
        if (this.kSx != null) {
            this.kSx.DB(i);
        }
    }

    public BdSwipeRefreshLayout cZF() {
        return this.gCQ;
    }
}
