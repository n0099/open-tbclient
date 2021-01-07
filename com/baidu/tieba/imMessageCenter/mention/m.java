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
    private BdTypeRecyclerView Yc;
    private BdSwipeRefreshLayout gEz;
    private final f.c gJh;
    private Runnable gdM;
    private com.baidu.tieba.frs.profession.permission.c jjD;
    private com.baidu.tieba.imMessageCenter.mention.base.e kNS;
    private boolean kNT;
    private e.a kNU;
    private NavigationBarShadowView kNs;
    private final ReplyMessageFragment kOF;
    private PbListView kOK;
    private com.baidu.tieba.imMessageCenter.mention.base.d kOL;
    private boolean kOM;
    private al kON;
    private AttentionHostData kOO;
    private int kOP;
    private View.OnClickListener kOQ;
    private RecyclerView.OnScrollListener kOR;
    private ReplyMeModel kOS;
    private com.baidu.tbadk.editortools.pb.h kOT;
    private com.baidu.tieba.imMessageCenter.mention.base.a kOU;
    private String kOV;
    private long kOW;
    private long kOX;
    private DataModel<MessageCenterActivity> kOY;
    private NewWriteModel.d kOZ;
    private final ReplyMeModel.a kPa;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.kOP = R.color.CAM_X0204;
        this.kNT = false;
        this.kOQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.kOK != null && m.this.kOF != null) {
                    m.this.kOK.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kOK.setOnClickListener(null);
                    m.this.kOK.startLoadData();
                    m.this.kOF.ctv();
                }
            }
        };
        this.gJh = new f.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.f.c
            public void onListPullRefresh(boolean z) {
                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    if (m.this.kOF != null) {
                        m.this.kOF.cIj();
                    }
                } else if (m.this.gEz != null) {
                    m.this.gEz.setRefreshing(false);
                }
            }
        };
        this.kOR = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 0:
                        if (recyclerView.canScrollVertically(-1)) {
                            m.this.kNs.show();
                            return;
                        } else {
                            m.this.kNs.hide();
                            return;
                        }
                    case 1:
                    case 2:
                        m.this.kNs.show();
                        return;
                    default:
                        return;
                }
            }
        };
        this.kNU = new e.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.tieba.imMessageCenter.mention.base.e.a
            public void onClose() {
                if (m.this.kNS != null) {
                    m.this.Yc.removeHeaderView(m.this.kNS.getView());
                    m.this.kNT = false;
                }
            }
        };
        this.kOS = null;
        this.gdM = new Runnable() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // java.lang.Runnable
            public void run() {
                if (m.this.kOT != null && m.this.kOT.bFV() != null) {
                    com.baidu.adp.lib.util.l.showSoftKeyPad(m.this.getPageContext().getPageActivity(), m.this.kOT.bFV().getInputView());
                }
            }
        };
        this.kPa = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.kOV = str;
                m.this.kOW = j2;
                m.this.kOX = j3;
                m.this.M(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.kOT != null) {
                    m.this.kOT.bFR();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.kOF = replyMessageFragment;
        this.kON = new al(replyMessageFragment.getPageContext());
        this.kON.a(new al.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tbadk.core.util.al.a
            public void q(boolean z, int i) {
                if (z && m.this.kOT != null) {
                    m.this.kOT.bFN();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<n> arrayList) {
        if (this.Yc != null) {
            this.gEz.setVisibility(0);
            te(false);
            if (z) {
                this.kOK.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kOK.endLoadData();
                this.kOK.setOnClickListener(this.kOQ);
            } else {
                this.kOK.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.kOK.endLoadData();
                this.kOK.setText(this.mContext.getResources().getString(R.string.list_no_more));
                this.kOK.setOnClickListener(null);
            }
            if (x.isEmpty(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, (int) this.mContext.getResources().getDimension(R.dimen.ds80)), NoDataViewFactory.d.dY(null, this.mContext.getResources().getString(R.string.mention_replyme_nodata)), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
                }
                if (this.mNoDataView.getParent() == null && !this.kOM) {
                    this.kOM = true;
                    this.Yc.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Yc.setNextPage(null);
                if (arrayList != null) {
                    this.kOL.setData(arrayList);
                }
                this.kOP = R.color.CAM_X0205;
            } else {
                this.Yc.removeHeaderView(this.mNoDataView);
                this.kOM = false;
                if (this.kOL != null) {
                    this.kOL.setData(arrayList);
                    this.kOL.notifyDataSetChanged();
                }
                this.Yc.setNextPage(this.kOK);
                this.kOP = R.color.CAM_X0204;
            }
            daY();
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.kOL != null) {
            this.kOL.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View cj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        this.kNs = (NavigationBarShadowView) this.mRootView.findViewById(R.id.navi_shadow_view_reply_me);
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.kOF.getPageContext());
            this.mPullView.setListPullRefreshListener(this.gJh);
        }
        this.mPullView.setTag(this.kOF.getUniqueId());
        if (this.kOK == null) {
            this.kOK = new PbListView(this.kOF.getContext());
            this.kOK.getView();
        }
        this.kOK.setContainerBackgroundColorResId(R.color.CAM_X0205);
        this.kOK.bxD();
        this.kOK.setHeight(com.baidu.adp.lib.util.l.getDimens(this.kOF.getContext(), R.dimen.tbds182));
        this.kOK.setLineGone();
        this.kOK.setTextSize(R.dimen.tbfontsize33);
        this.kOK.setTextColor(ao.getColor(R.color.CAM_X0109));
        this.kOK.setNoMoreTextColorId(R.color.CAM_X0110);
        this.kOK.setOnClickListener(this.kOQ);
        this.gEz = (BdSwipeRefreshLayout) this.mRootView.findViewById(R.id.reply_me_pull_refresh_layout);
        this.gEz.setProgressView(this.mPullView);
        this.Yc = (BdTypeRecyclerView) this.mRootView.findViewById(R.id.replyme_lv);
        this.kOL = new com.baidu.tieba.imMessageCenter.mention.base.d(this.kOF.getPageContext(), this.Yc);
        this.kOL.setOnCardSubClickListener(new aa() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.aa
            public void a(View view, BaseCardInfo baseCardInfo) {
                long j;
                if (view != null && (baseCardInfo instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) baseCardInfo;
                    if (aVar.isNew() && view.getId() != R.id.photo && view.getId() != R.id.user_name) {
                        aVar.tk(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == R.id.message_bottom_reply_container) {
                        m.this.kOU = aVar;
                        if (aVar.dbu()) {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.dbv(), 0L);
                        } else {
                            j = com.baidu.adp.lib.f.b.toLong(aVar.getPost_id(), 0L);
                        }
                        if (m.this.kOO == null) {
                            m.this.kOO = new AttentionHostData();
                        }
                        if (m.this.kOU != null) {
                            m.this.kOO.parserWithMetaData(m.this.kOU.getThreadAuthor());
                        }
                        BaijiahaoData baijiahaoData = null;
                        if (m.this.kOU != null) {
                            baijiahaoData = m.this.kOU.getBaijiahaoData();
                        }
                        m.this.kOS.a(j, 2, aVar.getFname(), aVar.getThread_id(), baijiahaoData);
                        if (aVar.dbw() != null) {
                            aq an = new aq(aVar.dbw()).an("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kPB) {
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
        ((DefaultItemAnimator) this.Yc.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Yc.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Yc.setFadingEdgeLength(0);
        this.Yc.setOverScrollMode(2);
        this.Yc.addItemDecoration(new DeviderLineDecoration());
        this.Yc.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Yc.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.kOK != null) {
                    m.this.kOK.showEmptyView(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.kOK.setOnClickListener(null);
                    m.this.kOK.showLoading();
                    m.this.kOF.ctv();
                }
            }
        });
        this.Yc.setOnScrollListener(this.mScrollListener);
        this.Yc.addOnScrollListener(this.kOR);
        dbq();
        this.kOS = new ReplyMeModel(this.kOF.getPageContext());
        this.kOS.a(this.kPa);
        dbr();
        tj(false);
        return this.mRootView;
    }

    private void dbq() {
        daY();
    }

    private void daY() {
        if (this.Yc != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(this.kOF.getFragmentActivity()).areNotificationsEnabled();
            aq aqVar = new aq("c13616");
            aqVar.an("obj_type", areNotificationsEnabled ? 1 : 2);
            TiebaStatic.log(aqVar);
            if (areNotificationsEnabled) {
                if (this.kNS != null) {
                    this.Yc.removeHeaderView(this.kNS.getView());
                    this.kNT = false;
                    return;
                }
                return;
            }
            long j = com.baidu.tbadk.core.sharedPref.b.bvr().getLong("key_im_open_notification_close_time", 0L);
            if (this.kNT) {
                return;
            }
            if (j == 0 || System.currentTimeMillis() - j > 604800000) {
                if (this.kNS == null) {
                    this.kNS = new com.baidu.tieba.imMessageCenter.mention.base.e(this.kOF.getPageContext());
                    this.kNS.a(this.kNU);
                }
                this.Yc.addHeaderView(this.kNS.getView(), 0);
                this.kNT = true;
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kOT != null && this.kOT.bEJ() != null) {
            this.kOT.bEJ().onChangeSkinType(i);
        }
        if (this.kOK != null) {
            this.kOK.setTextColor(ao.getColor(R.color.CAM_X0109));
            this.kOK.changeSkin(i);
        }
        if (this.mPullView != null) {
            this.mPullView.changeSkin(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        }
        notifyDataSetChanged();
        ao.setBackgroundColor(this.Yc, this.kOP);
        ao.setBackgroundColor(this.gEz, R.color.CAM_X0205);
        if (this.kNS != null) {
            this.kNS.onChangeSkinType(i);
        }
    }

    public boolean onBackPressed() {
        if (this.kOT == null || this.kOT.bEJ() == null || this.kOT.bEJ().getVisibility() != 0) {
            return false;
        }
        this.kOT.bFR();
        return true;
    }

    public void te(boolean z) {
        if (this.gEz != null) {
            if (z && this.Yc != null && this.Yc.getFirstVisiblePosition() != 0) {
                this.Yc.setSelection(0);
            }
            this.gEz.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
        }
    }

    private void dbr() {
        this.kOY = new DataModel<MessageCenterActivity>(com.baidu.adp.base.j.K(this.kOF.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.15
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean bFk() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData DN(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.kOV);
                writeData.setThreadId(m.this.kOU.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.kOU.dbu()) {
                    writeData.setFloor(m.this.kOW > 0 ? String.valueOf(m.this.kOW) : m.this.kOU.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.kOU.getPost_id());
                }
                if (m.this.kOX > 0) {
                    writeData.setRepostId(String.valueOf(m.this.kOX));
                }
                if (m.this.kOU != null) {
                    writeData.setBaijiahaoData(m.this.kOU.getBaijiahaoData());
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String bFl() {
                return null;
            }
        };
        this.kOZ = new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
                if (m.this.kOF.getBaseFragmentActivity() != null) {
                    m.this.kOF.getBaseFragmentActivity().hideProgressBar();
                    m.this.kOT.bEJ().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.kON.a(m.this.kOO);
                        m.this.kON.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && ahVar == null && !AntiHelper.bP(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.kOF.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj(boolean z) {
        if (this.kOT != null && this.kOT.bEJ() != null && this.kOT.bEJ().getParent() != null) {
            ((ViewGroup) this.kOT.bEJ().getParent()).removeView(this.kOT.bEJ());
        }
        this.kOT = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i(z).fj(this.kOF.getPageContext().getPageActivity());
        this.kOT.a(this.kOF.getPageContext());
        this.kOT.b(this.kOY);
        this.kOT.setFrom(3);
        this.kOT.j(this.kOF.getPageContext());
        this.kOT.bEJ().kO(true);
        this.kOT.bEJ().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kOT.bEJ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.kOT.bEJ(), layoutParams);
            this.kOT.bEJ().hide();
        }
        this.kOT.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tbadk.editortools.pb.c
            public void bFo() {
                if (m.this.kOF.getBaseFragmentActivity() != null) {
                    m.this.kOF.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.kOT.b(this.kOZ);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.kOT != null) {
            if (i == 12005) {
                this.kOT.bFU();
                com.baidu.adp.lib.f.e.mB().postDelayed(this.gdM, 300L);
            }
            this.kOT.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.kOT.bEJ().bDf();
        this.kOT.bFR();
        this.kOT.bEJ().bEW();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.kOT.c(writeData);
                this.kOT.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.m sv = this.kOT.bEJ().sv(6);
                if (sv != null && sv.fDH != null) {
                    sv.fDH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.kOT.bFN();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, long j) {
        if (this.kOU != null && this.kOU.getBaijiahaoData() != null && this.kOU.isBjh()) {
            if (this.kOT == null || !this.kOT.isBJH) {
                tj(true);
            }
            if (this.kOT != null && this.kOU != null) {
                if (this.kOU.dbu() && this.kOU.getReplyer() != null) {
                    this.kOT.DX(this.kOU.getReplyer().getName_show());
                    return;
                } else {
                    this.kOT.DX(null);
                    return;
                }
            }
            return;
        }
        if (this.jjD == null) {
            this.jjD = new com.baidu.tieba.frs.profession.permission.c(this.kOF.getPageContext());
            this.jjD.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qG(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void B(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void qH(boolean z) {
                    if (z) {
                        if (m.this.kOT == null || m.this.kOT.isBJH) {
                            m.this.tj(false);
                        }
                        if (m.this.kOT != null && m.this.kOU != null) {
                            if (!m.this.kOU.dbu() || m.this.kOU.getReplyer() == null) {
                                m.this.kOT.DX(null);
                            } else {
                                m.this.kOT.DX(m.this.kOU.getReplyer().getName_show());
                            }
                        }
                    }
                }
            });
        }
        this.jjD.H(str, j);
    }

    @Override // com.baidu.adp.base.d
    public void destroy() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gdM);
        if (this.kOT != null) {
            this.kOT.onDestory();
        }
        if (this.kON != null) {
            this.kON.onDestroy();
        }
        if (this.kOS != null) {
            this.kOS.a((ReplyMeModel.a) null);
            this.kOS.onDestroy();
        }
        if (this.kON != null) {
            this.kON.a((al.a) null);
        }
    }

    public void e(w wVar) {
        if (this.kOL != null) {
            this.kOL.e(wVar);
        }
    }

    public void b(com.baidu.adp.widget.ListView.x xVar) {
        if (this.kOL != null) {
            this.kOL.a(xVar);
        }
    }

    public void onPrimary() {
        daY();
    }

    public void EQ(int i) {
        if (this.kOL != null) {
            this.kOL.EQ(i);
        }
    }

    public BdSwipeRefreshLayout dbs() {
        return this.gEz;
    }
}
