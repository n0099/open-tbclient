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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView bwl;
    private BdSwipeRefreshLayout bwm;
    private final f.b bws;
    private com.baidu.tbadk.editortools.pb.g eAA;
    private com.baidu.tieba.imMessageCenter.mention.base.a eAB;
    private String eAC;
    private long eAD;
    private long eAE;
    private DataModel<MessageCenterActivity> eAF;
    private final ReplyMeModel.a eAG;
    private final ReplyMessageFragment eAh;
    private PbListView eAm;
    private com.baidu.tieba.imMessageCenter.mention.base.e eAn;
    private com.baidu.tieba.imMessageCenter.mention.base.f eAo;
    private com.baidu.tieba.imMessageCenter.mention.base.f eAp;
    private boolean eAq;
    private boolean eAr;
    private aj eAs;
    private AttentionHostData eAt;
    private int eAu;
    private int eAv;
    private int eAw;
    private BdListView.b eAx;
    private View.OnClickListener eAy;
    private ReplyMeModel eAz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.g mPullView;
    private com.baidu.tbadk.j.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.eAu = 0;
        this.eAv = 0;
        this.eAw = d.C0141d.cp_bg_line_e;
        this.eAx = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.eAo.getView()) {
                    if (view == m.this.eAp.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dn();
                        com.baidu.tbadk.coreExtra.messageCenter.a.CX().dV(0);
                        m.this.eAv = 0;
                        m.this.ou(m.this.eAv);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.CX().Dm();
                com.baidu.tbadk.coreExtra.messageCenter.a.CX().setMsgAtme(0);
                m.this.eAu = 0;
                m.this.ot(m.this.eAu);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.eAy = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eAm != null && m.this.eAh != null) {
                    m.this.eAm.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eAm.setOnClickListener(null);
                    m.this.eAm.Ar();
                    m.this.eAh.aNH();
                }
            }
        };
        this.bws = new f.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.f.b
            public void aS(boolean z) {
                if (com.baidu.adp.lib.util.j.jD()) {
                    if (m.this.eAh != null) {
                        m.this.eAh.aNG();
                    }
                } else if (m.this.bwm != null) {
                    m.this.bwm.setRefreshing(false);
                }
            }
        };
        this.eAz = null;
        this.eAG = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.eAC = str;
                m.this.eAD = j2;
                m.this.eAE = j3;
                if (m.this.eAA != null && m.this.eAB != null) {
                    if (!m.this.eAB.aNK() || m.this.eAB.getReplyer() == null) {
                        m.this.eAA.gS(null);
                    } else {
                        m.this.eAA.gS(m.this.eAB.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.eAA != null) {
                    m.this.eAA.Ic();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eAh = replyMessageFragment;
        this.eAs = new aj(replyMessageFragment.getPageContext());
        this.eAs.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z && m.this.eAA != null) {
                    m.this.eAA.HY();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (w.z(this.bwl.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.hU(true);
                        m.this.eAh.aNG();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.IX();
                this.mRefreshView.fe(getPageContext().getResources().getDimensionPixelSize(d.e.ds_102));
                this.mRefreshView.IV().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.setSubText(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.eAr) {
                this.bwl.addHeaderView(this.mRefreshView.IV(), 0);
            }
            this.eAr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        hU(false);
        if (z) {
            this.eAm.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.eAm.As();
            this.eAm.setOnClickListener(this.eAy);
        } else {
            this.eAm.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.eAm.As();
            this.eAm.setText(this.mContext.getResources().getString(d.k.list_no_more));
            this.eAm.setOnClickListener(null);
        }
        if (w.z(arrayList)) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.dr(d.k.mention_replyme_nodata), null);
                this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                al.j(this.mNoDataView, d.C0141d.cp_bg_line_d);
            }
            if (this.mNoDataView.getParent() == null && !this.eAq && this.bwl != null) {
                this.eAq = true;
                this.bwl.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.bwl.setNextPage(null);
            this.eAw = d.C0141d.cp_bg_line_d;
        } else {
            if (this.bwl != null) {
                this.bwl.removeHeaderView(this.mNoDataView);
                this.eAq = false;
                if (this.mRefreshView != null) {
                    this.bwl.removeHeaderView(this.mRefreshView.IV());
                    this.eAr = false;
                }
            }
            if (this.eAn != null) {
                this.eAn.setData(arrayList);
                this.eAn.notifyDataSetChanged();
            }
            this.bwl.setNextPage(this.eAm);
            this.eAw = d.C0141d.cp_bg_line_e;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eAn != null) {
            this.eAn.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.g(this.eAh.getPageContext());
            this.mPullView.a(this.bws);
        }
        this.mPullView.setTag(this.eAh.getUniqueId());
        if (this.eAm == null) {
            this.eAm = new PbListView(this.eAh.getContext());
            this.eAm.getView();
        }
        this.eAm.dx(d.C0141d.cp_bg_line_e);
        this.eAm.setHeight(com.baidu.adp.lib.util.l.e(this.eAh.getContext(), d.e.tbds182));
        this.eAm.Ao();
        this.eAm.setTextSize(d.e.tbfontsize33);
        this.eAm.setTextColor(al.getColor(d.C0141d.cp_cont_d));
        this.eAm.dw(d.C0141d.cp_cont_e);
        this.eAm.setOnClickListener(this.eAy);
        this.bwm = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.bwm.setProgressView(this.mPullView);
        this.bwl = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eAn = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eAh.getPageContext(), this.bwl);
        this.eAn.e(new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.hV(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == d.g.message_bottom_reply_container) {
                        m.this.eAB = aVar;
                        if (aVar.aNK()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aNL(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        if (m.this.eAt == null) {
                            m.this.eAt = new AttentionHostData();
                        }
                        if (m.this.eAB != null) {
                            m.this.eAt.parserWithMetaData(m.this.eAB.getThreadAuthor());
                        }
                        m.this.eAz.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aNM() != null) {
                            am r = new am(aVar.aNM()).r("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eBg) {
                                r.r("obj_type", 1);
                            } else {
                                r.r("obj_type", 2);
                            }
                            TiebaStatic.log(r);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.bwl.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bwl.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bwl.setFadingEdgeLength(0);
        this.bwl.setOverScrollMode(2);
        this.bwl.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bwl.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bwl.setNextPage(this.eAm);
        this.bwl.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.eAm != null) {
                    m.this.eAm.dz(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.eAm.setOnClickListener(null);
                    m.this.eAm.showLoading();
                    m.this.eAh.aNH();
                }
            }
        });
        this.bwl.setOnScrollListener(this.mScrollListener);
        aNE();
        this.eAz = new ReplyMeModel(this.eAh.getPageContext());
        this.eAz.a(this.eAG);
        this.eAF = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.ad(this.eAh.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean HA() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData gH(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.eAC);
                writeData.setThreadId(m.this.eAB.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.eAB.aNK()) {
                    writeData.setFloor(m.this.eAD > 0 ? String.valueOf(m.this.eAD) : m.this.eAB.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.eAB.getPost_id());
                }
                if (m.this.eAE > 0) {
                    writeData.setRepostId(String.valueOf(m.this.eAE));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String HB() {
                return null;
            }
        };
        this.eAA = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().aY(this.eAh.getPageContext().getContext());
        this.eAA.setContext(this.eAh.getPageContext());
        this.eAA.b(this.eAF);
        this.eAA.d(this.eAh.getPageContext());
        this.eAA.Hg().bB(true);
        this.eAA.Hg().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eAA.Hg() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eAA.Hg(), layoutParams);
            this.eAA.Hg().hide();
        }
        this.eAA.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void HE() {
                if (m.this.eAh.getBaseFragmentActivity() != null) {
                    m.this.eAh.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.eAA.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                if (m.this.eAh.getBaseFragmentActivity() != null) {
                    m.this.eAh.getBaseFragmentActivity().hideProgressBar();
                    m.this.eAA.Hg().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.eAs.a(m.this.eAt);
                        m.this.eAs.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && tVar == null && !AntiHelper.tE(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.eAh.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aNE() {
        this.eAo = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eAh.getPageContext());
        this.eAp = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eAh.getPageContext());
        this.eAo.ax(this.eAh.getString(d.k.at_me), d.f.icon_im_at);
        ot(this.eAu);
        this.eAp.ax(this.eAh.getString(d.k.agree_me), d.f.icon_im_laud);
        ou(this.eAv);
        this.eAp.ov(8);
        this.bwl.addHeaderView(this.eAo.getView());
        this.bwl.addHeaderView(this.eAp.getView());
        this.bwl.setOnHeaderClickListener(this.eAx);
    }

    public void onChangeSkinType(int i) {
        if (this.eAA != null && this.eAA.Hg() != null) {
            this.eAA.Hg().onChangeSkinType(i);
        }
        if (this.eAm != null) {
            this.eAm.setTextColor(al.getColor(d.C0141d.cp_cont_d));
            this.eAm.dy(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dy(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, d.C0141d.cp_bg_line_d);
        }
        if (this.eAo != null) {
            this.eAo.aNN();
        }
        if (this.eAp != null) {
            this.eAp.aNN();
        }
        notifyDataSetChanged();
        al.j(this.bwl, this.eAw);
        al.j(this.bwm, d.C0141d.cp_bg_line_c);
    }

    public boolean onBackPressed() {
        if (this.eAA == null || this.eAA.Hg() == null || this.eAA.Hg().getVisibility() != 0) {
            return false;
        }
        this.eAA.Ic();
        return true;
    }

    public void hU(boolean z) {
        if (this.bwm != null) {
            if (z && this.bwl != null && this.bwl.getFirstVisiblePosition() != 0) {
                this.bwl.setSelection(0);
            }
            this.bwm.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.eAu = newsNotifyMessage.getMsgAtme();
            this.eAv = newsNotifyMessage.getMsgAgree();
            ot(this.eAu);
            ou(this.eAv);
        }
    }

    public void aNF() {
        ot(this.eAu);
        ou(this.eAv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(int i) {
        if (this.eAo != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.DE().DJ()) {
                z = true;
            }
            this.eAo.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ou(int i) {
        if (this.eAp != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.DE().DU()) {
                z = true;
            }
            this.eAp.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eAA != null) {
            if (i == 12005) {
                this.eAA.If();
            }
            this.eAA.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eAA.Hg().FB();
        this.eAA.Ic();
        this.eAA.Hg().Hq();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eAA.b(writeData);
                this.eAA.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eM = this.eAA.Hg().eM(6);
                if (eM != null && eM.aLj != null) {
                    eM.aLj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eAA.HY();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eAA != null) {
            this.eAA.onDestory();
        }
        if (this.eAs != null) {
            this.eAs.onDestroy();
        }
        if (this.eAz != null) {
            this.eAz.a((ReplyMeModel.a) null);
            this.eAz.onDestroy();
        }
        if (this.eAs != null) {
            this.eAs.a((aj.a) null);
        }
    }

    public void d(n nVar) {
        if (this.eAn != null) {
            this.eAn.d(nVar);
        }
    }
}
