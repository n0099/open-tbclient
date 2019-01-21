package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.card.ad;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView bRZ;
    private BdSwipeRefreshLayout bSa;
    private final j.b bSf;
    private final ReplyMessageFragment fiA;
    private PbListView fiF;
    private com.baidu.tieba.imMessageCenter.mention.base.e fiG;
    private com.baidu.tieba.imMessageCenter.mention.base.f fiH;
    private com.baidu.tieba.imMessageCenter.mention.base.f fiI;
    private boolean fiJ;
    private boolean fiK;
    private aj fiL;
    private AttentionHostData fiM;
    private int fiN;
    private int fiO;
    private int fiP;
    private BdListView.b fiQ;
    private View.OnClickListener fiR;
    private ReplyMeModel fiS;
    private com.baidu.tbadk.editortools.pb.g fiT;
    private com.baidu.tieba.imMessageCenter.mention.base.a fiU;
    private String fiV;
    private long fiW;
    private long fiX;
    private DataModel<MessageCenterActivity> fiY;
    private final ReplyMeModel.a fiZ;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.k.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.fiN = 0;
        this.fiO = 0;
        this.fiP = e.d.cp_bg_line_e;
        this.fiQ = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.fiH.getView()) {
                    if (view == m.this.fiI.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.If().Iv();
                        com.baidu.tbadk.coreExtra.messageCenter.a.If().eW(0);
                        m.this.fiO = 0;
                        m.this.qT(m.this.fiO);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.If().Iu();
                com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgAtme(0);
                m.this.fiN = 0;
                m.this.qS(m.this.fiN);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        };
        this.fiR = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.fiF != null && m.this.fiA != null) {
                    m.this.fiF.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.fiF.setOnClickListener(null);
                    m.this.fiF.Fp();
                    m.this.fiA.aEu();
                }
            }
        };
        this.bSf = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (m.this.fiA != null) {
                        m.this.fiA.aEv();
                    }
                } else if (m.this.bSa != null) {
                    m.this.bSa.setRefreshing(false);
                }
            }
        };
        this.fiS = null;
        this.fiZ = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.fiV = str;
                m.this.fiW = j2;
                m.this.fiX = j3;
                if (m.this.fiT != null && m.this.fiU != null) {
                    if (!m.this.fiU.aXq() || m.this.fiU.getReplyer() == null) {
                        m.this.fiT.ik(null);
                    } else {
                        m.this.fiT.ik(m.this.fiU.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.fiT != null) {
                    m.this.fiT.Nl();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.fiA = replyMessageFragment;
        this.fiL = new aj(replyMessageFragment.getPageContext());
        this.fiL.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z && m.this.fiT != null) {
                    m.this.fiT.Nh();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.I(this.bRZ.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.jm(true);
                        m.this.fiA.aEv();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.Od();
                this.mRefreshView.gd(getPageContext().getResources().getDimensionPixelSize(e.C0210e.ds_102));
                this.mRefreshView.Ob().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.iC(getPageContext().getResources().getString(e.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.iC(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.fiK) {
                this.bRZ.addHeaderView(this.mRefreshView.Ob(), 0);
            }
            this.fiK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.bRZ != null) {
            jm(false);
            if (z) {
                this.fiF.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fiF.Fq();
                this.fiF.setOnClickListener(this.fiR);
            } else {
                this.fiF.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fiF.Fq();
                this.fiF.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.fiF.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.fiJ) {
                    this.fiJ = true;
                    this.bRZ.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bRZ.setNextPage(null);
                this.fiP = e.d.cp_bg_line_d;
            } else {
                this.bRZ.removeHeaderView(this.mNoDataView);
                this.fiJ = false;
                if (this.mRefreshView != null) {
                    this.bRZ.removeHeaderView(this.mRefreshView.Ob());
                    this.fiK = false;
                }
                if (this.fiG != null) {
                    this.fiG.setData(arrayList);
                    this.fiG.notifyDataSetChanged();
                }
                this.bRZ.setNextPage(this.fiF);
                this.fiP = e.d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.fiG != null) {
            this.fiG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.fiA.getPageContext());
            this.mPullView.a(this.bSf);
        }
        this.mPullView.setTag(this.fiA.getUniqueId());
        if (this.fiF == null) {
            this.fiF = new PbListView(this.fiA.getContext());
            this.fiF.getView();
        }
        this.fiF.ex(e.d.cp_bg_line_e);
        this.fiF.setHeight(com.baidu.adp.lib.util.l.h(this.fiA.getContext(), e.C0210e.tbds182));
        this.fiF.Fm();
        this.fiF.setTextSize(e.C0210e.tbfontsize33);
        this.fiF.setTextColor(al.getColor(e.d.cp_cont_d));
        this.fiF.ew(e.d.cp_cont_e);
        this.fiF.setOnClickListener(this.fiR);
        this.bSa = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.reply_me_pull_refresh_layout);
        this.bSa.setProgressView(this.mPullView);
        this.bRZ = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.replyme_lv);
        this.fiG = new com.baidu.tieba.imMessageCenter.mention.base.e(this.fiA.getPageContext(), this.bRZ);
        this.fiG.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long d;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.jn(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == e.g.message_bottom_reply_container) {
                        m.this.fiU = aVar;
                        if (aVar.aXq()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.aXr(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.fiM == null) {
                            m.this.fiM = new AttentionHostData();
                        }
                        if (m.this.fiU != null) {
                            m.this.fiM.parserWithMetaData(m.this.fiU.getThreadAuthor());
                        }
                        m.this.fiS.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aXs() != null) {
                            am y = new am(aVar.aXs()).y("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.fjA) {
                                y.y("obj_type", 1);
                            } else {
                                y.y("obj_type", 2);
                            }
                            TiebaStatic.log(y);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.bRZ.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRZ.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bRZ.setFadingEdgeLength(0);
        this.bRZ.setOverScrollMode(2);
        this.bRZ.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bRZ.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bRZ.setNextPage(this.fiF);
        this.bRZ.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.fiF != null) {
                    m.this.fiF.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.fiF.setOnClickListener(null);
                    m.this.fiF.showLoading();
                    m.this.fiA.aEu();
                }
            }
        });
        this.bRZ.setOnScrollListener(this.mScrollListener);
        aXm();
        this.fiS = new ReplyMeModel(this.fiA.getPageContext());
        this.fiS.a(this.fiZ);
        this.fiY = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.fiA.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean MJ() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData hZ(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.fiV);
                writeData.setThreadId(m.this.fiU.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.fiU.aXq()) {
                    writeData.setFloor(m.this.fiW > 0 ? String.valueOf(m.this.fiW) : m.this.fiU.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.fiU.getPost_id());
                }
                if (m.this.fiX > 0) {
                    writeData.setRepostId(String.valueOf(m.this.fiX));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String MK() {
                return null;
            }
        };
        this.fiT = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.fiA.getPageContext().getContext());
        this.fiT.setContext(this.fiA.getPageContext());
        this.fiT.b(this.fiY);
        this.fiT.d(this.fiA.getPageContext());
        this.fiT.Mp().ct(true);
        this.fiT.Mp().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fiT.Mp() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.fiT.Mp(), layoutParams);
            this.fiT.Mp().hide();
        }
        this.fiT.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void MN() {
                if (m.this.fiA.getBaseFragmentActivity() != null) {
                    m.this.fiA.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.fiT.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.fiA.getBaseFragmentActivity() != null) {
                    m.this.fiA.getBaseFragmentActivity().hideProgressBar();
                    m.this.fiT.Mp().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.fiL.a(m.this.fiM);
                        m.this.fiL.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.fiA.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aXm() {
        this.fiH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.fiA.getPageContext());
        this.fiI = new com.baidu.tieba.imMessageCenter.mention.base.f(this.fiA.getPageContext());
        this.fiH.aD(this.fiA.getString(e.j.at_me), e.f.icon_im_at);
        qS(this.fiN);
        this.fiI.aD(this.fiA.getString(e.j.agree_me), e.f.icon_im_laud);
        qT(this.fiO);
        this.fiI.qU(8);
        this.bRZ.addHeaderView(this.fiH.getView());
        this.bRZ.addHeaderView(this.fiI.getView());
        this.bRZ.setOnHeaderClickListener(this.fiQ);
    }

    public void onChangeSkinType(int i) {
        if (this.fiT != null && this.fiT.Mp() != null) {
            this.fiT.Mp().onChangeSkinType(i);
        }
        if (this.fiF != null) {
            this.fiF.setTextColor(al.getColor(e.d.cp_cont_d));
            this.fiF.ey(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.fiH != null) {
            this.fiH.aXt();
        }
        if (this.fiI != null) {
            this.fiI.aXt();
        }
        notifyDataSetChanged();
        al.j(this.bRZ, this.fiP);
        al.j(this.bSa, e.d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.fiT == null || this.fiT.Mp() == null || this.fiT.Mp().getVisibility() != 0) {
            return false;
        }
        this.fiT.Nl();
        return true;
    }

    public void jm(boolean z) {
        if (this.bSa != null) {
            if (z && this.bRZ != null && this.bRZ.getFirstVisiblePosition() != 0) {
                this.bRZ.setSelection(0);
            }
            this.bSa.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.fiN = newsNotifyMessage.getMsgAtme();
            this.fiO = newsNotifyMessage.getMsgAgree();
            qS(this.fiN);
            qT(this.fiO);
        }
    }

    public void aXn() {
        qS(this.fiN);
        qT(this.fiO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qS(int i) {
        if (this.fiH != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.IM().IR()) {
                z = true;
            }
            this.fiH.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(int i) {
        if (this.fiI != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jd()) {
                z = true;
            }
            this.fiI.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.fiT != null) {
            if (i == 12005) {
                this.fiT.No();
            }
            this.fiT.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.fiT.Mp().KM();
        this.fiT.Nl();
        this.fiT.Mp().Mz();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.fiT.b(writeData);
                this.fiT.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k fL = this.fiT.Mp().fL(6);
                if (fL != null && fL.aYW != null) {
                    fL.aYW.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.fiT.Nh();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.fiT != null) {
            this.fiT.onDestory();
        }
        if (this.fiL != null) {
            this.fiL.onDestroy();
        }
        if (this.fiS != null) {
            this.fiS.a((ReplyMeModel.a) null);
            this.fiS.onDestroy();
        }
        if (this.fiL != null) {
            this.fiL.a((aj.a) null);
        }
    }

    public void d(n nVar) {
        if (this.fiG != null) {
            this.fiG.d(nVar);
        }
    }
}
