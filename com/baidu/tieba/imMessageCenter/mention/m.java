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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
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
    private BdTypeRecyclerView Ya;
    private Runnable fZd;
    private final f.c gEB;
    private BdSwipeRefreshLayout gzS;
    private com.baidu.tieba.frs.profession.permission.c jeV;
    private NavigationBarShadowView kIN;
    private com.baidu.tieba.imMessageCenter.mention.base.e kJn;
    private boolean kJo;
    private e.a kJp;
    private final ReplyMessageFragment kKa;
    private PbListView kKf;
    private com.baidu.tieba.imMessageCenter.mention.base.d kKg;
    private boolean kKh;
    private al kKi;
    private AttentionHostData kKj;
    private int kKk;
    private View.OnClickListener kKl;
    private RecyclerView.OnScrollListener kKm;
    private ReplyMeModel kKn;
    private com.baidu.tbadk.editortools.pb.h kKo;
    private com.baidu.tieba.imMessageCenter.mention.base.a kKp;
    private String kKq;
    private long kKr;
    private long kKs;
    private DataModel<MessageCenterActivity> kKt;
    private NewWriteModel.d kKu;
    private final ReplyMeModel.a kKv;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kKk = R.color.CAM_X0204;
        this.kJo = false;
        this.kKl = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kKf != null && m.this.kKa != null) {
                    m.this.kKf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kKf.setOnClickListener(null);
                    m.this.kKf.startLoadData();
                    m.this.kKa.cpD();
                }
            }
        };
        this.gEB = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kKa != null) {
                        m.this.kKa.cEr();
                    }
                } else if (m.this.gzS != null) {
                    m.this.gzS.setRefreshing(false);
                }
            }
        };
        this.kKm = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kIN.show();
                            return;
                        } else {
                            m.this.kIN.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kIN.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kJp = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (m.this.kJn != null) {
                    m.this.Ya.removeHeaderView(m.this.kJn.getView());
                    m.this.kJo = false;
                }
            }
        };
        this.kKn = null;
        this.fZd = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kKo != null && m.this.kKo.bCc() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kKo.bCc().getInputView());
                }
            }
        };
        this.kKv = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kKq = str;
                m.this.kKr = j2;
                m.this.kKs = j3;
                m.this.M(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kKo != null) {
                    m.this.kKo.bBY();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kKa = replyMessageFragment;
        this.kKi = new al(replyMessageFragment.getPageContext());
        this.kKi.a(new al.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z && m.this.kKo != null) {
                    m.this.kKo.bBU();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<n> arrayList) {
        if (this.Ya != null) {
            this.gzS.setVisibility(0);
            ta(false);
            if (z) {
                this.kKf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kKf.endLoadData();
                this.kKf.setOnClickListener(this.kKl);
            } else {
                this.kKf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kKf.endLoadData();
                this.kKf.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kKf.setOnClickListener(null);
            }
            if (x.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dX(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kKh) {
                    this.kKh = true;
                    this.Ya.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Ya.setNextPage(null);
                if (arrayList != null) {
                    this.kKg.setData(arrayList);
                }
                this.kKk = R.color.CAM_X0205;
            } else {
                this.Ya.removeHeaderView(this.mNoDataView);
                this.kKh = false;
                if (this.kKg != null) {
                    this.kKg.setData(arrayList);
                    this.kKg.notifyDataSetChanged();
                }
                this.Ya.setNextPage(this.kKf);
                this.kKk = R.color.CAM_X0204;
            }
            cXg();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kKg != null) {
            this.kKg.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View cj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kIN = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kKa.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gEB);
        }
        this.mPullView.setTag(this.kKa.getUniqueId());
        if (this.kKf == null) {
            this.kKf = new PbListView(this.kKa.getContext());
            this.kKf.getView();
        }
        this.kKf.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.kKf.btJ();
        this.kKf.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kKa.getContext(), R.dimen.tbds182));
        this.kKf.setLineGone();
        this.kKf.setTextSize(R.dimen.tbfontsize33);
        this.kKf.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.kKf.setNoMoreTextColorId(R.color.CAM_X0110);
        this.kKf.setOnClickListener(this.kKl);
        this.gzS = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.gzS.setProgressView(this.mPullView);
        this.Ya = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kKg = new com.baidu.tieba.imMessageCenter.mention.base.d(this.kKa.getPageContext(), this.Ya);
        this.kKg.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.aa
            public void a(View view, BaseCardInfo baseCardInfo) {
                long j;
                if (view != null && (baseCardInfo instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) baseCardInfo;
                    if (aVar.isNew() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                        aVar.tg(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.kKp = aVar;
                        if (aVar.cXC()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.cXD(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kKj == null) {
                            m.this.kKj = new AttentionHostData();
                        }
                        if (m.this.kKp != null) {
                            m.this.kKj.parserWithMetaData(m.this.kKp.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kKp != null) {
                            baijiahaoData = m.this.kKp.getBaijiahaoData();
                        }
                        m.this.kKn.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.cXE() != null) {
                            aq an = new aq(aVar.cXE()).an("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kKW) {
                                an.an("obj_type", 1);
                            } else {
                                an.an("obj_type", 2);
                            }
                            TiebaStatic.log(an);
                        }
                        aq aqVar = new aq("c13784");
                        aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                        TiebaStatic.log(aqVar);
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Ya.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Ya.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Ya.setFadingEdgeLength(0);
        this.Ya.setOverScrollMode(2);
        this.Ya.addItemDecoration(new DeviderLineDecoration());
        this.Ya.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Ya.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.kKf != null) {
                    m.this.kKf.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kKf.setOnClickListener(null);
                    m.this.kKf.showLoading();
                    m.this.kKa.cpD();
                }
            }
        });
        this.Ya.setOnScrollListener(this.mScrollListener);
        this.Ya.addOnScrollListener(this.kKm);
        cXy();
        this.kKn = new ReplyMeModel(this.kKa.getPageContext());
        this.kKn.a(this.kKv);
        cXz();
        tf(false);
        return this.mRootView;
    }

    private void cXy() {
        cXg();
    }

    private void cXg() {
        if (this.Ya != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kKa.getFragmentActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.an("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.kJn != null) {
                    this.Ya.removeHeaderView(this.kJn.getView());
                    this.kJo = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.brx().getLong("key_im_open_notification_close_time", 0L);
            if (this.kJo) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kJn == null) {
                    this.kJn = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kKa.getPageContext());
                    this.kJn.a(this.kJp);
                }
                this.Ya.addHeaderView(this.kJn.getView(), 0);
                this.kJo = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kKo != null && this.kKo.bAP() != null) {
            this.kKo.bAP().onChangeSkinType(i);
        }
        if (this.kKf != null) {
            this.kKf.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.kKf.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        notifyDataSetChanged();
        ao.setBackgroundColor(this.Ya, this.kKk);
        ao.setBackgroundColor(this.gzS, R.color.CAM_X0205);
        if (this.kJn != null) {
            this.kJn.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kKo == null || this.kKo.bAP() == null || this.kKo.bAP().getVisibility() != 0) {
            return false;
        }
        this.kKo.bBY();
        return true;
    }

    public void ta(boolean z) {
        if (this.gzS != null) {
            if (z && this.Ya != null && this.Ya.getFirstVisiblePosition() != 0) {
                this.Ya.setSelection(0);
            }
            this.gzS.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void cXz() {
        this.kKt = new DataModel<MessageCenterActivity>(com.baidu.adp.base.j.K(this.kKa.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bBq() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData CC(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kKq);
                writeData.setThreadId(m.this.kKp.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kKp.cXC()) {
                    writeData.setFloor(m.this.kKr > 0 ? String.valueOf(m.this.kKr) : m.this.kKp.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kKp.getPost_id());
                }
                if (m.this.kKs > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kKs));
                }
                if (m.this.kKp != null) {
                    writeData.setBaijiahaoData(m.this.kKp.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bBr() {
                return null;
            }
        };
        this.kKu = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kKa.getBaseFragmentActivity() != null) {
                    m.this.kKa.getBaseFragmentActivity().hideProgressBar();
                    m.this.kKo.bAP().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kKi.a(m.this.kKj);
                        m.this.kKi.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bQ(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kKa.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf(boolean z) {
        if (this.kKo != null && this.kKo.bAP() != null && this.kKo.bAP().getParent() != null) {
            ((ViewGroup) this.kKo.bAP().getParent()).removeView(this.kKo.bAP());
        }
        this.kKo = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).fh(this.kKa.getPageContext().getPageActivity());
        this.kKo.a(this.kKa.getPageContext());
        this.kKo.b(this.kKt);
        this.kKo.setFrom(3);
        this.kKo.j(this.kKa.getPageContext());
        this.kKo.bAP().kK(true);
        this.kKo.bAP().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kKo.bAP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kKo.bAP(), layoutParams);
            this.kKo.bAP().hide();
        }
        this.kKo.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bBu() {
                if (m.this.kKa.getBaseFragmentActivity() != null) {
                    m.this.kKa.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kKo.b(this.kKu);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kKo != null) {
            if (i == 12005) {
                this.kKo.bCb();
                com.baidu.adp.lib.f.e.mB().postDelayed(this.fZd, 300L);
            }
            this.kKo.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kKo.bAP().bzl();
        this.kKo.bBY();
        this.kKo.bAP().bBc();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kKo.c(writeData);
                this.kKo.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m qP = this.kKo.bAP().qP(6);
                if (qP != null && qP.fyZ != null) {
                    qP.fyZ.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kKo.bBU();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, long j) {
        if (this.kKp != null && this.kKp.getBaijiahaoData() != null && this.kKp.isBjh()) {
            if (this.kKo == null || !this.kKo.isBJH) {
                tf(true);
            }
            if (this.kKo != null && this.kKp != null) {
                if (this.kKp.cXC() && this.kKp.getReplyer() != null) {
                    this.kKo.CM(this.kKp.getReplyer().getName_show());
                    return;
                } else {
                    this.kKo.CM(null);
                    return;
                }
            }
            return;
        }
        if (this.jeV == null) {
            this.jeV = new com.baidu.tieba.frs.profession.permission.c(this.kKa.getPageContext());
            this.jeV.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qC(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void B(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qD(boolean z) {
                    if (z) {
                        if (m.this.kKo == null || m.this.kKo.isBJH) {
                            m.this.tf(false);
                        }
                        if (m.this.kKo != null && m.this.kKp != null) {
                            if (!m.this.kKp.cXC() || m.this.kKp.getReplyer() == null) {
                                m.this.kKo.CM(null);
                            } else {
                                m.this.kKo.CM(m.this.kKp.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.jeV.H(str, j);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.fZd);
        if (this.kKo != null) {
            this.kKo.onDestory();
        }
        if (this.kKi != null) {
            this.kKi.onDestroy();
        }
        if (this.kKn != null) {
            this.kKn.a((ReplyMeModel.a) null);
            this.kKn.onDestroy();
        }
        if (this.kKi != null) {
            this.kKi.a((al.a) null);
        }
    }

    public void e(w wVar) {
        if (this.kKg != null) {
            this.kKg.e(wVar);
        }
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        if (this.kKg != null) {
            this.kKg.a(xVar);
        }
    }

    public void onPrimary() {
        cXg();
    }

    public void Dk(int i) {
        if (this.kKg != null) {
            this.kKg.Dk(i);
        }
    }

    public BdSwipeRefreshLayout cXA() {
        return this.gzS;
    }
}
