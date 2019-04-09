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
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.x;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView Qr;
    private BdSwipeRefreshLayout dcF;
    private final h.c dhu;
    private com.baidu.tieba.frs.profession.permission.c fci;
    private int gyA;
    private int gyB;
    private int gyC;
    private BdListView.b gyD;
    private View.OnClickListener gyE;
    private ReplyMeModel gyF;
    private com.baidu.tbadk.editortools.pb.g gyG;
    private com.baidu.tieba.imMessageCenter.mention.base.a gyH;
    private String gyI;
    private long gyJ;
    private long gyK;
    private DataModel<MessageCenterActivity> gyL;
    private final ReplyMeModel.a gyM;
    private final ReplyMessageFragment gyn;
    private PbListView gys;
    private com.baidu.tieba.imMessageCenter.mention.base.e gyt;
    private com.baidu.tieba.imMessageCenter.mention.base.f gyu;
    private com.baidu.tieba.imMessageCenter.mention.base.f gyv;
    private boolean gyw;
    private boolean gyx;
    private aj gyy;
    private AttentionHostData gyz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gyA = 0;
        this.gyB = 0;
        this.gyC = d.C0277d.cp_bg_line_e;
        this.gyD = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gyu.getView()) {
                    if (view == m.this.gyv.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahN();
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().iB(0);
                        m.this.gyB = 0;
                        m.this.ux(m.this.gyB);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahM();
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgAtme(0);
                m.this.gyA = 0;
                m.this.uw(m.this.gyA);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gyE = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gys != null && m.this.gyn != null) {
                    m.this.gys.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gys.setOnClickListener(null);
                    m.this.gys.aez();
                    m.this.gyn.bfb();
                }
            }
        };
        this.dhu = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    if (m.this.gyn != null) {
                        m.this.gyn.bfc();
                    }
                } else if (m.this.dcF != null) {
                    m.this.dcF.setRefreshing(false);
                }
            }
        };
        this.gyF = null;
        this.gyM = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gyI = str;
                m.this.gyJ = j2;
                m.this.gyK = j3;
                m.this.x(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gyG != null) {
                    m.this.gyG.amM();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gyn = replyMessageFragment;
        this.gyy = new aj(replyMessageFragment.getPageContext());
        this.gyy.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gyG != null) {
                    m.this.gyG.amI();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.T(this.Qr.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.m.h(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.lM(true);
                        m.this.gyn.bfc();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.any();
                this.mRefreshView.anz().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.pp(getPageContext().getResources().getString(d.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.pp(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.gyx) {
                this.Qr.addHeaderView(this.mRefreshView.anz(), 0);
            }
            this.gyx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Qr != null) {
            lM(false);
            if (z) {
                this.gys.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gys.aeA();
                this.gys.setOnClickListener(this.gyE);
            } else {
                this.gys.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gys.aeA();
                this.gys.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.gys.setOnClickListener(null);
            }
            if (v.T(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.hT(d.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gyw) {
                    this.gyw = true;
                    this.Qr.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Qr.setNextPage(null);
                this.gyC = d.C0277d.cp_bg_line_d;
            } else {
                this.Qr.removeHeaderView(this.mNoDataView);
                this.gyw = false;
                if (this.mRefreshView != null) {
                    this.Qr.removeHeaderView(this.mRefreshView.anz());
                    this.gyx = false;
                }
                if (this.gyt != null) {
                    this.gyt.setData(arrayList);
                    this.gyt.notifyDataSetChanged();
                }
                this.Qr.setNextPage(this.gys);
                this.gyC = d.C0277d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gyt != null) {
            this.gyt.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gyn.getPageContext());
            this.mPullView.setListPullRefreshListener(this.dhu);
        }
        this.mPullView.setTag(this.gyn.getUniqueId());
        if (this.gys == null) {
            this.gys = new PbListView(this.gyn.getContext());
            this.gys.getView();
        }
        this.gys.ia(d.C0277d.cp_bg_line_e);
        this.gys.setHeight(com.baidu.adp.lib.util.l.h(this.gyn.getContext(), d.e.tbds182));
        this.gys.aew();
        this.gys.setTextSize(d.e.tbfontsize33);
        this.gys.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.gys.hZ(d.C0277d.cp_cont_e);
        this.gys.setOnClickListener(this.gyE);
        this.dcF = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.dcF.setProgressView(this.mPullView);
        this.Qr = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.gyt = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gyn.getPageContext(), this.Qr);
        this.gyt.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long d;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.lN(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == d.g.message_bottom_reply_container) {
                        m.this.gyH = aVar;
                        if (aVar.bxP()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.bxQ(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gyz == null) {
                            m.this.gyz = new AttentionHostData();
                        }
                        if (m.this.gyH != null) {
                            m.this.gyz.parserWithMetaData(m.this.gyH.getThreadAuthor());
                        }
                        m.this.gyF.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bxR() != null) {
                            am T = new am(aVar.bxR()).T("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gzl) {
                                T.T("obj_type", 1);
                            } else {
                                T.T("obj_type", 2);
                            }
                            TiebaStatic.log(T);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.Qr.getItemAnimator()).setSupportsChangeAnimations(false);
        this.Qr.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.Qr.setFadingEdgeLength(0);
        this.Qr.setOverScrollMode(2);
        this.Qr.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.Qr.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.Qr.setNextPage(this.gys);
        this.Qr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gys != null) {
                    m.this.gys.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gys.setOnClickListener(null);
                    m.this.gys.showLoading();
                    m.this.gyn.bfb();
                }
            }
        });
        this.Qr.setOnScrollListener(this.mScrollListener);
        bxM();
        this.gyF = new ReplyMeModel(this.gyn.getPageContext());
        this.gyF.a(this.gyM);
        this.gyL = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.gyn.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean amk() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData oO(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.gyI);
                writeData.setThreadId(m.this.gyH.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gyH.bxP()) {
                    writeData.setFloor(m.this.gyJ > 0 ? String.valueOf(m.this.gyJ) : m.this.gyH.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gyH.getPost_id());
                }
                if (m.this.gyK > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gyK));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aml() {
                return null;
            }
        };
        this.gyG = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().dd(this.gyn.getPageContext().getContext());
        this.gyG.a(this.gyn.getPageContext());
        this.gyG.b(this.gyL);
        this.gyG.e(this.gyn.getPageContext());
        this.gyG.alP().eH(true);
        this.gyG.alP().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gyG.alP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gyG.alP(), layoutParams);
            this.gyG.alP().hide();
        }
        this.gyG.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void amo() {
                if (m.this.gyn.getBaseFragmentActivity() != null) {
                    m.this.gyn.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gyG.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.gyn.getBaseFragmentActivity() != null) {
                    m.this.gyn.getBaseFragmentActivity().hideProgressBar();
                    m.this.gyG.alP().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gyy.a(m.this.gyz);
                        m.this.gyy.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.aD(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gyn.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bxM() {
        this.gyu = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gyn.getPageContext());
        this.gyv = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gyn.getPageContext());
        this.gyu.aY(this.gyn.getString(d.j.at_me), d.f.icon_im_at);
        uw(this.gyA);
        this.gyv.aY(this.gyn.getString(d.j.agree_me), d.f.icon_im_laud);
        ux(this.gyB);
        this.gyv.uy(8);
        this.Qr.addHeaderView(this.gyu.getView());
        this.Qr.addHeaderView(this.gyv.getView());
        this.Qr.setOnHeaderClickListener(this.gyD);
    }

    public void onChangeSkinType(int i) {
        if (this.gyG != null && this.gyG.alP() != null) {
            this.gyG.alP().onChangeSkinType(i);
        }
        if (this.gys != null) {
            this.gys.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.gys.ib(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
        }
        if (this.gyu != null) {
            this.gyu.bxS();
        }
        if (this.gyv != null) {
            this.gyv.bxS();
        }
        notifyDataSetChanged();
        al.l(this.Qr, this.gyC);
        al.l(this.dcF, d.C0277d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gyG == null || this.gyG.alP() == null || this.gyG.alP().getVisibility() != 0) {
            return false;
        }
        this.gyG.amM();
        return true;
    }

    public void lM(boolean z) {
        if (this.dcF != null) {
            if (z && this.Qr != null && this.Qr.getFirstVisiblePosition() != 0) {
                this.Qr.setSelection(0);
            }
            this.dcF.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gyA = newsNotifyMessage.getMsgAtme();
            this.gyB = newsNotifyMessage.getMsgAgree();
            uw(this.gyA);
            ux(this.gyB);
        }
    }

    public void bxN() {
        uw(this.gyA);
        ux(this.gyB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(int i) {
        if (this.gyu != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aie().aij()) {
                z = true;
            }
            this.gyu.E(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(int i) {
        if (this.gyv != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiv()) {
                z = true;
            }
            this.gyv.E(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gyG != null) {
            if (i == 12005) {
                this.gyG.amP();
            }
            this.gyG.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gyG.alP().akm();
        this.gyG.amM();
        this.gyG.alP().ama();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gyG.b(writeData);
                this.gyG.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k jv = this.gyG.alP().jv(6);
                if (jv != null && jv.cix != null) {
                    jv.cix.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gyG.amI();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (this.fci == null) {
            this.fci = new com.baidu.tieba.frs.profession.permission.c(this.gyn.getPageContext());
            this.fci.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jl(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jm(boolean z) {
                    if (z && m.this.gyG != null && m.this.gyH != null) {
                        if (!m.this.gyH.bxP() || m.this.gyH.getReplyer() == null) {
                            m.this.gyG.oY(null);
                        } else {
                            m.this.gyG.oY(m.this.gyH.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fci.q(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gyG != null) {
            this.gyG.onDestory();
        }
        if (this.gyy != null) {
            this.gyy.onDestroy();
        }
        if (this.gyF != null) {
            this.gyF.a((ReplyMeModel.a) null);
            this.gyF.onDestroy();
        }
        if (this.gyy != null) {
            this.gyy.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gyt != null) {
            this.gyt.d(sVar);
        }
    }
}
