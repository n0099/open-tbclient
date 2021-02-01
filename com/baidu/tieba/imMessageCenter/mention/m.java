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
    private BdSwipeRefreshLayout gCC;
    private final f.c gHl;
    private Runnable gbv;
    private com.baidu.tieba.frs.profession.permission.c jkC;
    private NavigationBarShadowView kQQ;
    private com.baidu.tieba.imMessageCenter.mention.base.e kRq;
    private boolean kRr;
    private e.a kRs;
    private final ReplyMessageFragment kSd;
    private PbListView kSi;
    private com.baidu.tieba.imMessageCenter.mention.base.d kSj;
    private boolean kSk;
    private am kSl;
    private AttentionHostData kSm;
    private int kSn;
    private View.OnClickListener kSo;
    private RecyclerView.OnScrollListener kSp;
    private ReplyMeModel kSq;
    private com.baidu.tbadk.editortools.pb.h kSr;
    private com.baidu.tieba.imMessageCenter.mention.base.a kSs;
    private String kSt;
    private long kSu;
    private long kSv;
    private DataModel<MessageCenterActivity> kSw;
    private NewWriteModel.d kSx;
    private final ReplyMeModel.a kSy;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kSn = R.color.CAM_X0204;
        this.kRr = false;
        this.kSo = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kSi != null && m.this.kSd != null) {
                    m.this.kSi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kSi.setOnClickListener(null);
                    m.this.kSi.startLoadData();
                    m.this.kSd.cqN();
                }
            }
        };
        this.gHl = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kSd != null) {
                        m.this.kSd.cFE();
                    }
                } else if (m.this.gCC != null) {
                    m.this.gCC.setRefreshing(false);
                }
            }
        };
        this.kSp = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kQQ.show();
                            return;
                        } else {
                            m.this.kQQ.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kQQ.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kRs = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (m.this.kRq != null) {
                    m.this.XW.removeHeaderView(m.this.kRq.getView());
                    m.this.kRr = false;
                }
            }
        };
        this.kSq = null;
        this.gbv = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kSr != null && m.this.kSr.bCu() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kSr.bCu().getInputView());
                }
            }
        };
        this.kSy = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kSt = str;
                m.this.kSu = j2;
                m.this.kSv = j3;
                m.this.L(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kSr != null) {
                    m.this.kSr.bCq();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kSd = replyMessageFragment;
        this.kSl = new am(replyMessageFragment.getPageContext());
        this.kSl.a(new am.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z && m.this.kSr != null) {
                    m.this.kSr.bCm();
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
            this.gCC.setVisibility(0);
            tn(false);
            if (z) {
                this.kSi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kSi.endLoadData();
                this.kSi.setOnClickListener(this.kSo);
            } else {
                this.kSi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kSi.endLoadData();
                this.kSi.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kSi.setOnClickListener(null);
            }
            if (y.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dS(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kSk) {
                    this.kSk = true;
                    this.XW.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.XW.setNextPage(null);
                if (arrayList != null) {
                    this.kSj.setData(arrayList);
                }
                this.kSn = R.color.CAM_X0205;
            } else {
                this.XW.removeHeaderView(this.mNoDataView);
                this.kSk = false;
                if (this.kSj != null) {
                    this.kSj.setData(arrayList);
                    this.kSj.notifyDataSetChanged();
                }
                this.XW.setNextPage(this.kSi);
                this.kSn = R.color.CAM_X0204;
            }
            cZe();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kSj != null) {
            this.kSj.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View cj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kQQ = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kSd.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gHl);
        }
        this.mPullView.setTag(this.kSd.getUniqueId());
        if (this.kSi == null) {
            this.kSi = new PbListView(this.kSd.getContext());
            this.kSi.getView();
        }
        this.kSi.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.kSi.bud();
        this.kSi.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kSd.getContext(), R.dimen.tbds182));
        this.kSi.setLineGone();
        this.kSi.setTextSize(R.dimen.tbfontsize33);
        this.kSi.setTextColor(ap.getColor(R.color.CAM_X0109));
        this.kSi.setNoMoreTextColorId(R.color.CAM_X0110);
        this.kSi.setOnClickListener(this.kSo);
        this.gCC = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.gCC.setProgressView(this.mPullView);
        this.XW = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kSj = new com.baidu.tieba.imMessageCenter.mention.base.d(this.kSd.getPageContext(), this.XW);
        this.kSj.setOnCardSubClickListener(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.kSs = aVar;
                        if (aVar.cZA()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cZB(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kSm == null) {
                            m.this.kSm = new AttentionHostData();
                        }
                        if (m.this.kSs != null) {
                            m.this.kSm.parserWithMetaData(m.this.kSs.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kSs != null) {
                            baijiahaoData = m.this.kSs.getBaijiahaoData();
                        }
                        m.this.kSq.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cZC() != null) {
                            ar ap = new ar(aVar.cZC()).ap("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kSZ) {
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
                if (m.this.kSi != null) {
                    m.this.kSi.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kSi.setOnClickListener(null);
                    m.this.kSi.showLoading();
                    m.this.kSd.cqN();
                }
            }
        });
        this.XW.setOnScrollListener(this.mScrollListener);
        this.XW.addOnScrollListener(this.kSp);
        cZw();
        this.kSq = new ReplyMeModel(this.kSd.getPageContext());
        this.kSq.a(this.kSy);
        cZx();
        ts(false);
        return this.mRootView;
    }

    private void cZw() {
        cZe();
    }

    private void cZe() {
        if (this.XW != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kSd.getFragmentActivity()).areNotificationsEnabled();
            ar arVar = new ar("c13616");
            arVar.ap("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(arVar);
            if (areNotificationsEnabled) {
                if (this.kRq != null) {
                    this.XW.removeHeaderView(this.kRq.getView());
                    this.kRr = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brQ().getLong("key_im_open_notification_close_time", 0L);
            if (this.kRr) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kRq == null) {
                    this.kRq = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kSd.getPageContext());
                    this.kRq.a(this.kRs);
                }
                this.XW.addHeaderView(this.kRq.getView(), 0);
                this.kRr = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kSr != null && this.kSr.bBh() != null) {
            this.kSr.bBh().onChangeSkinType(i);
        }
        if (this.kSi != null) {
            this.kSi.setTextColor(ap.getColor(R.color.CAM_X0109));
            this.kSi.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ap.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        notifyDataSetChanged();
        ap.setBackgroundColor(this.XW, this.kSn);
        ap.setBackgroundColor(this.gCC, R.color.CAM_X0205);
        if (this.kRq != null) {
            this.kRq.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kSr == null || this.kSr.bBh() == null || this.kSr.bBh().getVisibility() != 0) {
            return false;
        }
        this.kSr.bCq();
        return true;
    }

    public void tn(boolean z) {
        if (this.gCC != null) {
            if (z && this.XW != null && this.XW.getFirstVisiblePosition() != 0) {
                this.XW.setSelection(0);
            }
            this.gCC.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cZx() {
        this.kSw = new DataModel<MessageCenterActivity>(com.baidu.adp.base.j.K(this.kSd.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
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
            public WriteData CT(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kSt);
                writeData.setThreadId(m.this.kSs.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kSs.cZA()) {
                    writeData.setFloor(m.this.kSu > 0 ? String.valueOf(m.this.kSu) : m.this.kSs.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kSs.getPost_id());
                }
                if (m.this.kSv > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kSv));
                }
                if (m.this.kSs != null) {
                    writeData.setBaijiahaoData(m.this.kSs.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bBJ() {
                return null;
            }
        };
        this.kSx = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kSd.getBaseFragmentActivity() != null) {
                    m.this.kSd.getBaseFragmentActivity().hideProgressBar();
                    m.this.kSr.bBh().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kSl.a(m.this.kSm);
                        m.this.kSl.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bX(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kSd.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(boolean z) {
        if (this.kSr != null && this.kSr.bBh() != null && this.kSr.bBh().getParent() != null) {
            ((ViewGroup) this.kSr.bBh().getParent()).removeView(this.kSr.bBh());
        }
        this.kSr = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).fg(this.kSd.getPageContext().getPageActivity());
        this.kSr.a(this.kSd.getPageContext());
        this.kSr.b(this.kSw);
        this.kSr.setFrom(3);
        this.kSr.j(this.kSd.getPageContext());
        this.kSr.bBh().kN(true);
        this.kSr.bBh().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kSr.bBh() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kSr.bBh(), layoutParams);
            this.kSr.bBh().hide();
        }
        this.kSr.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bBM() {
                if (m.this.kSd.getBaseFragmentActivity() != null) {
                    m.this.kSd.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kSr.b(this.kSx);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kSr != null) {
            if (i == 12005) {
                this.kSr.bCt();
                com.baidu.adp.lib.f.e.mA().postDelayed(this.gbv, 300L);
            }
            this.kSr.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kSr.bBh().bzD();
        this.kSr.bCq();
        this.kSr.bBh().bBu();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kSr.c(writeData);
                this.kSr.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qU = this.kSr.bBh().qU(6);
                if (qU != null && qU.fBo != null) {
                    qU.fBo.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kSr.bCm();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, long j) {
        if (this.kSs != null && this.kSs.getBaijiahaoData() != null && this.kSs.isBjh()) {
            if (this.kSr == null || !this.kSr.isBJH) {
                ts(true);
            }
            if (this.kSr != null && this.kSs != null) {
                if (this.kSs.cZA() && this.kSs.getReplyer() != null) {
                    this.kSr.Dd(this.kSs.getReplyer().getName_show());
                    return;
                } else {
                    this.kSr.Dd(null);
                    return;
                }
            }
            return;
        }
        if (this.jkC == null) {
            this.jkC = new com.baidu.tieba.frs.profession.permission.c(this.kSd.getPageContext());
            this.jkC.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qM(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void B(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qN(boolean z) {
                    if (z) {
                        if (m.this.kSr == null || m.this.kSr.isBJH) {
                            m.this.ts(false);
                        }
                        if (m.this.kSr != null && m.this.kSs != null) {
                            if (!m.this.kSs.cZA() || m.this.kSs.getReplyer() == null) {
                                m.this.kSr.Dd(null);
                            } else {
                                m.this.kSr.Dd(m.this.kSs.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.jkC.G(str, j);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gbv);
        if (this.kSr != null) {
            this.kSr.onDestory();
        }
        if (this.kSl != null) {
            this.kSl.onDestroy();
        }
        if (this.kSq != null) {
            this.kSq.a((ReplyMeModel.a) null);
            this.kSq.onDestroy();
        }
        if (this.kSl != null) {
            this.kSl.a((am.a) null);
        }
    }

    public void e(w wVar) {
        if (this.kSj != null) {
            this.kSj.e(wVar);
        }
    }

    public void b(x xVar) {
        if (this.kSj != null) {
            this.kSj.a(xVar);
        }
    }

    public void onPrimary() {
        cZe();
    }

    public void DB(int i) {
        if (this.kSj != null) {
            this.kSj.DB(i);
        }
    }

    public BdSwipeRefreshLayout cZy() {
        return this.gCC;
    }
}
