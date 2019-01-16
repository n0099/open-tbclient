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
    private BdTypeRecyclerView bRY;
    private BdSwipeRefreshLayout bRZ;
    private final j.b bSe;
    private PbListView fiE;
    private com.baidu.tieba.imMessageCenter.mention.base.e fiF;
    private com.baidu.tieba.imMessageCenter.mention.base.f fiG;
    private com.baidu.tieba.imMessageCenter.mention.base.f fiH;
    private boolean fiI;
    private boolean fiJ;
    private aj fiK;
    private AttentionHostData fiL;
    private int fiM;
    private int fiN;
    private int fiO;
    private BdListView.b fiP;
    private View.OnClickListener fiQ;
    private ReplyMeModel fiR;
    private com.baidu.tbadk.editortools.pb.g fiS;
    private com.baidu.tieba.imMessageCenter.mention.base.a fiT;
    private String fiU;
    private long fiV;
    private long fiW;
    private DataModel<MessageCenterActivity> fiX;
    private final ReplyMeModel.a fiY;
    private final ReplyMessageFragment fiz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.k.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.fiM = 0;
        this.fiN = 0;
        this.fiO = e.d.cp_bg_line_e;
        this.fiP = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.fiG.getView()) {
                    if (view == m.this.fiH.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.If().Iv();
                        com.baidu.tbadk.coreExtra.messageCenter.a.If().eW(0);
                        m.this.fiN = 0;
                        m.this.qT(m.this.fiN);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.If().Iu();
                com.baidu.tbadk.coreExtra.messageCenter.a.If().setMsgAtme(0);
                m.this.fiM = 0;
                m.this.qS(m.this.fiM);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
            }
        };
        this.fiQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.fiE != null && m.this.fiz != null) {
                    m.this.fiE.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.fiE.setOnClickListener(null);
                    m.this.fiE.Fp();
                    m.this.fiz.aEu();
                }
            }
        };
        this.bSe = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.j.b
            public void bI(boolean z) {
                if (com.baidu.adp.lib.util.j.kV()) {
                    if (m.this.fiz != null) {
                        m.this.fiz.aEv();
                    }
                } else if (m.this.bRZ != null) {
                    m.this.bRZ.setRefreshing(false);
                }
            }
        };
        this.fiR = null;
        this.fiY = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.fiU = str;
                m.this.fiV = j2;
                m.this.fiW = j3;
                if (m.this.fiS != null && m.this.fiT != null) {
                    if (!m.this.fiT.aXq() || m.this.fiT.getReplyer() == null) {
                        m.this.fiS.ik(null);
                    } else {
                        m.this.fiS.ik(m.this.fiT.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.fiS != null) {
                    m.this.fiS.Nl();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.fiz = replyMessageFragment;
        this.fiK = new aj(replyMessageFragment.getPageContext());
        this.fiK.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z && m.this.fiS != null) {
                    m.this.fiS.Nh();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.I(this.bRY.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.jm(true);
                        m.this.fiz.aEv();
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
            if (!this.fiJ) {
                this.bRY.addHeaderView(this.mRefreshView.Ob(), 0);
            }
            this.fiJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.bRY != null) {
            jm(false);
            if (z) {
                this.fiE.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fiE.Fq();
                this.fiE.setOnClickListener(this.fiQ);
            } else {
                this.fiE.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.fiE.Fq();
                this.fiE.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.fiE.setOnClickListener(null);
            }
            if (v.I(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0210e.ds80)), NoDataViewFactory.d.eq(e.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.fiI) {
                    this.fiI = true;
                    this.bRY.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bRY.setNextPage(null);
                this.fiO = e.d.cp_bg_line_d;
            } else {
                this.bRY.removeHeaderView(this.mNoDataView);
                this.fiI = false;
                if (this.mRefreshView != null) {
                    this.bRY.removeHeaderView(this.mRefreshView.Ob());
                    this.fiJ = false;
                }
                if (this.fiF != null) {
                    this.fiF.setData(arrayList);
                    this.fiF.notifyDataSetChanged();
                }
                this.bRY.setNextPage(this.fiE);
                this.fiO = e.d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.fiF != null) {
            this.fiF.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.fiz.getPageContext());
            this.mPullView.a(this.bSe);
        }
        this.mPullView.setTag(this.fiz.getUniqueId());
        if (this.fiE == null) {
            this.fiE = new PbListView(this.fiz.getContext());
            this.fiE.getView();
        }
        this.fiE.ex(e.d.cp_bg_line_e);
        this.fiE.setHeight(com.baidu.adp.lib.util.l.h(this.fiz.getContext(), e.C0210e.tbds182));
        this.fiE.Fm();
        this.fiE.setTextSize(e.C0210e.tbfontsize33);
        this.fiE.setTextColor(al.getColor(e.d.cp_cont_d));
        this.fiE.ew(e.d.cp_cont_e);
        this.fiE.setOnClickListener(this.fiQ);
        this.bRZ = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.reply_me_pull_refresh_layout);
        this.bRZ.setProgressView(this.mPullView);
        this.bRY = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.replyme_lv);
        this.fiF = new com.baidu.tieba.imMessageCenter.mention.base.e(this.fiz.getPageContext(), this.bRY);
        this.fiF.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
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
                        m.this.fiT = aVar;
                        if (aVar.aXq()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.aXr(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.fiL == null) {
                            m.this.fiL = new AttentionHostData();
                        }
                        if (m.this.fiT != null) {
                            m.this.fiL.parserWithMetaData(m.this.fiT.getThreadAuthor());
                        }
                        m.this.fiR.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aXs() != null) {
                            am y = new am(aVar.aXs()).y("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.fjz) {
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
        ((DefaultItemAnimator) this.bRY.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bRY.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bRY.setFadingEdgeLength(0);
        this.bRY.setOverScrollMode(2);
        this.bRY.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bRY.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bRY.setNextPage(this.fiE);
        this.bRY.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.fiE != null) {
                    m.this.fiE.ez(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.fiE.setOnClickListener(null);
                    m.this.fiE.showLoading();
                    m.this.fiz.aEu();
                }
            }
        });
        this.bRY.setOnScrollListener(this.mScrollListener);
        aXm();
        this.fiR = new ReplyMeModel(this.fiz.getPageContext());
        this.fiR.a(this.fiY);
        this.fiX = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.fiz.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
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
                writeData.setForumName(m.this.fiU);
                writeData.setThreadId(m.this.fiT.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.fiT.aXq()) {
                    writeData.setFloor(m.this.fiV > 0 ? String.valueOf(m.this.fiV) : m.this.fiT.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.fiT.getPost_id());
                }
                if (m.this.fiW > 0) {
                    writeData.setRepostId(String.valueOf(m.this.fiW));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String MK() {
                return null;
            }
        };
        this.fiS = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bM(this.fiz.getPageContext().getContext());
        this.fiS.setContext(this.fiz.getPageContext());
        this.fiS.b(this.fiX);
        this.fiS.d(this.fiz.getPageContext());
        this.fiS.Mp().ct(true);
        this.fiS.Mp().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.fiS.Mp() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.fiS.Mp(), layoutParams);
            this.fiS.Mp().hide();
        }
        this.fiS.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void MN() {
                if (m.this.fiz.getBaseFragmentActivity() != null) {
                    m.this.fiz.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.fiS.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.fiz.getBaseFragmentActivity() != null) {
                    m.this.fiz.getBaseFragmentActivity().hideProgressBar();
                    m.this.fiS.Mp().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.fiK.a(m.this.fiL);
                        m.this.fiK.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.al(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.fiz.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aXm() {
        this.fiG = new com.baidu.tieba.imMessageCenter.mention.base.f(this.fiz.getPageContext());
        this.fiH = new com.baidu.tieba.imMessageCenter.mention.base.f(this.fiz.getPageContext());
        this.fiG.aD(this.fiz.getString(e.j.at_me), e.f.icon_im_at);
        qS(this.fiM);
        this.fiH.aD(this.fiz.getString(e.j.agree_me), e.f.icon_im_laud);
        qT(this.fiN);
        this.fiH.qU(8);
        this.bRY.addHeaderView(this.fiG.getView());
        this.bRY.addHeaderView(this.fiH.getView());
        this.bRY.setOnHeaderClickListener(this.fiP);
    }

    public void onChangeSkinType(int i) {
        if (this.fiS != null && this.fiS.Mp() != null) {
            this.fiS.Mp().onChangeSkinType(i);
        }
        if (this.fiE != null) {
            this.fiE.setTextColor(al.getColor(e.d.cp_cont_d));
            this.fiE.ey(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ey(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.fiG != null) {
            this.fiG.aXt();
        }
        if (this.fiH != null) {
            this.fiH.aXt();
        }
        notifyDataSetChanged();
        al.j(this.bRY, this.fiO);
        al.j(this.bRZ, e.d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.fiS == null || this.fiS.Mp() == null || this.fiS.Mp().getVisibility() != 0) {
            return false;
        }
        this.fiS.Nl();
        return true;
    }

    public void jm(boolean z) {
        if (this.bRZ != null) {
            if (z && this.bRY != null && this.bRY.getFirstVisiblePosition() != 0) {
                this.bRY.setSelection(0);
            }
            this.bRZ.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.fiM = newsNotifyMessage.getMsgAtme();
            this.fiN = newsNotifyMessage.getMsgAgree();
            qS(this.fiM);
            qT(this.fiN);
        }
    }

    public void aXn() {
        qS(this.fiM);
        qT(this.fiN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qS(int i) {
        if (this.fiG != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.IM().IR()) {
                z = true;
            }
            this.fiG.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qT(int i) {
        if (this.fiH != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.IM().Jd()) {
                z = true;
            }
            this.fiH.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.fiS != null) {
            if (i == 12005) {
                this.fiS.No();
            }
            this.fiS.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.fiS.Mp().KM();
        this.fiS.Nl();
        this.fiS.Mp().Mz();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.fiS.b(writeData);
                this.fiS.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k fL = this.fiS.Mp().fL(6);
                if (fL != null && fL.aYV != null) {
                    fL.aYV.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.fiS.Nh();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.fiS != null) {
            this.fiS.onDestory();
        }
        if (this.fiK != null) {
            this.fiK.onDestroy();
        }
        if (this.fiR != null) {
            this.fiR.a((ReplyMeModel.a) null);
            this.fiR.onDestroy();
        }
        if (this.fiK != null) {
            this.fiK.a((aj.a) null);
        }
    }

    public void d(n nVar) {
        if (this.fiF != null) {
            this.fiF.d(nVar);
        }
    }
}
