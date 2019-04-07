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
    private BdSwipeRefreshLayout dcE;
    private final h.c dht;
    private com.baidu.tieba.frs.profession.permission.c fci;
    private int gyA;
    private int gyB;
    private BdListView.b gyC;
    private View.OnClickListener gyD;
    private ReplyMeModel gyE;
    private com.baidu.tbadk.editortools.pb.g gyF;
    private com.baidu.tieba.imMessageCenter.mention.base.a gyG;
    private String gyH;
    private long gyI;
    private long gyJ;
    private DataModel<MessageCenterActivity> gyK;
    private final ReplyMeModel.a gyL;
    private final ReplyMessageFragment gym;
    private PbListView gyr;
    private com.baidu.tieba.imMessageCenter.mention.base.e gys;
    private com.baidu.tieba.imMessageCenter.mention.base.f gyt;
    private com.baidu.tieba.imMessageCenter.mention.base.f gyu;
    private boolean gyv;
    private boolean gyw;
    private aj gyx;
    private AttentionHostData gyy;
    private int gyz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.i mPullView;
    private com.baidu.tbadk.m.h mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.gyz = 0;
        this.gyA = 0;
        this.gyB = d.C0277d.cp_bg_line_e;
        this.gyC = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.gyt.getView()) {
                    if (view == m.this.gyu.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahN();
                        com.baidu.tbadk.coreExtra.messageCenter.b.ahx().iB(0);
                        m.this.gyA = 0;
                        m.this.ux(m.this.gyA);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().ahM();
                com.baidu.tbadk.coreExtra.messageCenter.b.ahx().setMsgAtme(0);
                m.this.gyz = 0;
                m.this.uw(m.this.gyz);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.gyD = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gyr != null && m.this.gym != null) {
                    m.this.gyr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gyr.setOnClickListener(null);
                    m.this.gyr.aez();
                    m.this.gym.bfb();
                }
            }
        };
        this.dht = new h.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.view.h.c
            public void dR(boolean z) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    if (m.this.gym != null) {
                        m.this.gym.bfc();
                    }
                } else if (m.this.dcE != null) {
                    m.this.dcE.setRefreshing(false);
                }
            }
        };
        this.gyE = null;
        this.gyL = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str, long j4) {
                m.this.mForumId = String.valueOf(j);
                m.this.gyH = str;
                m.this.gyI = j2;
                m.this.gyJ = j3;
                m.this.x(m.this.mForumId, j4);
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.gyF != null) {
                    m.this.gyF.amM();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.gym = replyMessageFragment;
        this.gyx = new aj(replyMessageFragment.getPageContext());
        this.gyx.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
            @Override // com.baidu.tbadk.core.util.aj.a
            public void e(boolean z, int i) {
                if (z && m.this.gyF != null) {
                    m.this.gyF.amI();
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
                        m.this.gym.bfc();
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
            if (!this.gyw) {
                this.Qr.addHeaderView(this.mRefreshView.anz(), 0);
            }
            this.gyw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (this.Qr != null) {
            lM(false);
            if (z) {
                this.gyr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gyr.aeA();
                this.gyr.setOnClickListener(this.gyD);
            } else {
                this.gyr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.gyr.aeA();
                this.gyr.setText(this.mContext.getResources().getString(d.j.list_no_more));
                this.gyr.setOnClickListener(null);
            }
            if (v.T(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.hT(d.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.gyv) {
                    this.gyv = true;
                    this.Qr.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.Qr.setNextPage(null);
                this.gyB = d.C0277d.cp_bg_line_d;
            } else {
                this.Qr.removeHeaderView(this.mNoDataView);
                this.gyv = false;
                if (this.mRefreshView != null) {
                    this.Qr.removeHeaderView(this.mRefreshView.anz());
                    this.gyw = false;
                }
                if (this.gys != null) {
                    this.gys.setData(arrayList);
                    this.gys.notifyDataSetChanged();
                }
                this.Qr.setNextPage(this.gyr);
                this.gyB = d.C0277d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.gys != null) {
            this.gys.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.i(this.gym.getPageContext());
            this.mPullView.setListPullRefreshListener(this.dht);
        }
        this.mPullView.setTag(this.gym.getUniqueId());
        if (this.gyr == null) {
            this.gyr = new PbListView(this.gym.getContext());
            this.gyr.getView();
        }
        this.gyr.ia(d.C0277d.cp_bg_line_e);
        this.gyr.setHeight(com.baidu.adp.lib.util.l.h(this.gym.getContext(), d.e.tbds182));
        this.gyr.aew();
        this.gyr.setTextSize(d.e.tbfontsize33);
        this.gyr.setTextColor(al.getColor(d.C0277d.cp_cont_d));
        this.gyr.hZ(d.C0277d.cp_cont_e);
        this.gyr.setOnClickListener(this.gyD);
        this.dcE = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.dcE.setProgressView(this.mPullView);
        this.Qr = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.gys = new com.baidu.tieba.imMessageCenter.mention.base.e(this.gym.getPageContext(), this.Qr);
        this.gys.b(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
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
                        m.this.gyG = aVar;
                        if (aVar.bxP()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.bxQ(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.gyy == null) {
                            m.this.gyy = new AttentionHostData();
                        }
                        if (m.this.gyG != null) {
                            m.this.gyy.parserWithMetaData(m.this.gyG.getThreadAuthor());
                        }
                        m.this.gyE.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.bxR() != null) {
                            am T = new am(aVar.bxR()).T("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gzk) {
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
        this.Qr.setNextPage(this.gyr);
        this.Qr.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.gyr != null) {
                    m.this.gyr.ic(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.gyr.setOnClickListener(null);
                    m.this.gyr.showLoading();
                    m.this.gym.bfb();
                }
            }
        });
        this.Qr.setOnScrollListener(this.mScrollListener);
        bxM();
        this.gyE = new ReplyMeModel(this.gym.getPageContext());
        this.gyE.a(this.gyL);
        this.gyK = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.gym.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.14
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
                writeData.setForumName(m.this.gyH);
                writeData.setThreadId(m.this.gyG.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.gyG.bxP()) {
                    writeData.setFloor(m.this.gyI > 0 ? String.valueOf(m.this.gyI) : m.this.gyG.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.gyG.getPost_id());
                }
                if (m.this.gyJ > 0) {
                    writeData.setRepostId(String.valueOf(m.this.gyJ));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String aml() {
                return null;
            }
        };
        this.gyF = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().dd(this.gym.getPageContext().getContext());
        this.gyF.a(this.gym.getPageContext());
        this.gyF.b(this.gyK);
        this.gyF.e(this.gym.getPageContext());
        this.gyF.alP().eH(true);
        this.gyF.alP().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.gyF.alP() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.gyF.alP(), layoutParams);
            this.gyF.alP().hide();
        }
        this.gyF.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void amo() {
                if (m.this.gym.getBaseFragmentActivity() != null) {
                    m.this.gym.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.gyF.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, x xVar, WriteData writeData, AntiData antiData) {
                if (m.this.gym.getBaseFragmentActivity() != null) {
                    m.this.gym.getBaseFragmentActivity().hideProgressBar();
                    m.this.gyF.alP().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.gyx.a(m.this.gyy);
                        m.this.gyx.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && xVar == null && !AntiHelper.aD(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.gym.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void bxM() {
        this.gyt = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gym.getPageContext());
        this.gyu = new com.baidu.tieba.imMessageCenter.mention.base.f(this.gym.getPageContext());
        this.gyt.aY(this.gym.getString(d.j.at_me), d.f.icon_im_at);
        uw(this.gyz);
        this.gyu.aY(this.gym.getString(d.j.agree_me), d.f.icon_im_laud);
        ux(this.gyA);
        this.gyu.uy(8);
        this.Qr.addHeaderView(this.gyt.getView());
        this.Qr.addHeaderView(this.gyu.getView());
        this.Qr.setOnHeaderClickListener(this.gyC);
    }

    public void onChangeSkinType(int i) {
        if (this.gyF != null && this.gyF.alP() != null) {
            this.gyF.alP().onChangeSkinType(i);
        }
        if (this.gyr != null) {
            this.gyr.setTextColor(al.getColor(d.C0277d.cp_cont_d));
            this.gyr.ib(i);
        }
        if (this.mPullView != null) {
            this.mPullView.ib(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.l(this.mNoDataView, d.C0277d.cp_bg_line_d);
        }
        if (this.gyt != null) {
            this.gyt.bxS();
        }
        if (this.gyu != null) {
            this.gyu.bxS();
        }
        notifyDataSetChanged();
        al.l(this.Qr, this.gyB);
        al.l(this.dcE, d.C0277d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.gyF == null || this.gyF.alP() == null || this.gyF.alP().getVisibility() != 0) {
            return false;
        }
        this.gyF.amM();
        return true;
    }

    public void lM(boolean z) {
        if (this.dcE != null) {
            if (z && this.Qr != null && this.Qr.getFirstVisiblePosition() != 0) {
                this.Qr.setSelection(0);
            }
            this.dcE.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.gyz = newsNotifyMessage.getMsgAtme();
            this.gyA = newsNotifyMessage.getMsgAgree();
            uw(this.gyz);
            ux(this.gyA);
        }
    }

    public void bxN() {
        uw(this.gyz);
        ux(this.gyA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(int i) {
        if (this.gyt != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aie().aij()) {
                z = true;
            }
            this.gyt.E(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(int i) {
        if (this.gyu != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.d.aie().aiv()) {
                z = true;
            }
            this.gyu.E(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.gyF != null) {
            if (i == 12005) {
                this.gyF.amP();
            }
            this.gyF.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.gyF.alP().akm();
        this.gyF.amM();
        this.gyF.alP().ama();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.gyF.b(writeData);
                this.gyF.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k jv = this.gyF.alP().jv(6);
                if (jv != null && jv.ciw != null) {
                    jv.ciw.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.gyF.amI();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, long j) {
        if (this.fci == null) {
            this.fci = new com.baidu.tieba.frs.profession.permission.c(this.gym.getPageContext());
            this.fci.a(new c.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jl(boolean z) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void n(boolean z, int i) {
                }

                @Override // com.baidu.tieba.frs.profession.permission.c.a
                public void jm(boolean z) {
                    if (z && m.this.gyF != null && m.this.gyG != null) {
                        if (!m.this.gyG.bxP() || m.this.gyG.getReplyer() == null) {
                            m.this.gyF.oY(null);
                        } else {
                            m.this.gyF.oY(m.this.gyG.getReplyer().getName_show());
                        }
                    }
                }
            });
        }
        this.fci.q(str, j);
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.gyF != null) {
            this.gyF.onDestory();
        }
        if (this.gyx != null) {
            this.gyx.onDestroy();
        }
        if (this.gyE != null) {
            this.gyE.a((ReplyMeModel.a) null);
            this.gyE.onDestroy();
        }
        if (this.gyx != null) {
            this.gyx.a((aj.a) null);
        }
    }

    public void d(s sVar) {
        if (this.gys != null) {
            this.gys.d(sVar);
        }
    }
}
