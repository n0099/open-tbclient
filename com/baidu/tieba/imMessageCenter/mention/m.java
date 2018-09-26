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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.data.WriteData;
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
/* loaded from: classes2.dex */
public class m extends com.baidu.adp.base.c {
    private BdTypeRecyclerView bEd;
    private BdSwipeRefreshLayout bEe;
    private final j.b bEk;
    private DataModel<MessageCenterActivity> ePA;
    private final ReplyMeModel.a ePB;
    private final ReplyMessageFragment ePc;
    private PbListView ePh;
    private com.baidu.tieba.imMessageCenter.mention.base.e ePi;
    private com.baidu.tieba.imMessageCenter.mention.base.f ePj;
    private com.baidu.tieba.imMessageCenter.mention.base.f ePk;
    private boolean ePl;
    private boolean ePm;
    private aj ePn;
    private AttentionHostData ePo;
    private int ePp;
    private int ePq;
    private int ePr;
    private BdListView.b ePs;
    private View.OnClickListener ePt;
    private ReplyMeModel ePu;
    private com.baidu.tbadk.editortools.pb.g ePv;
    private com.baidu.tieba.imMessageCenter.mention.base.a ePw;
    private String ePx;
    private long ePy;
    private long ePz;
    private String mForumId;
    private NoDataView mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.k.g mRefreshView;
    private ViewGroup mRootView;
    private final RecyclerView.OnScrollListener mScrollListener;

    public m(ReplyMessageFragment replyMessageFragment) {
        super(replyMessageFragment.getPageContext());
        this.ePp = 0;
        this.ePq = 0;
        this.ePr = e.d.cp_bg_line_e;
        this.ePs = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != m.this.ePj.getView()) {
                    if (view == m.this.ePk.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(m.this.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EO();
                        com.baidu.tbadk.coreExtra.messageCenter.a.Ey().ek(0);
                        m.this.ePq = 0;
                        m.this.pu(m.this.ePq);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(m.this.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().EN();
                com.baidu.tbadk.coreExtra.messageCenter.a.Ey().setMsgAtme(0);
                m.this.ePp = 0;
                m.this.pt(m.this.ePp);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(m.this.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.ePt = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.ePh != null && m.this.ePc != null) {
                    m.this.ePh.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.ePh.setOnClickListener(null);
                    m.this.ePh.BI();
                    m.this.ePc.ayH();
                }
            }
        };
        this.bEk = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.m.7
            @Override // com.baidu.tbadk.core.view.j.b
            public void bf(boolean z) {
                if (com.baidu.adp.lib.util.j.kK()) {
                    if (m.this.ePc != null) {
                        m.this.ePc.ayI();
                    }
                } else if (m.this.bEe != null) {
                    m.this.bEe.setRefreshing(false);
                }
            }
        };
        this.ePu = null;
        this.ePB = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.4
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                m.this.mForumId = String.valueOf(j);
                m.this.ePx = str;
                m.this.ePy = j2;
                m.this.ePz = j3;
                if (m.this.ePv != null && m.this.ePw != null) {
                    if (!m.this.ePw.aRA() || m.this.ePw.getReplyer() == null) {
                        m.this.ePv.ho(null);
                    } else {
                        m.this.ePv.ho(m.this.ePw.getReplyer().getName_show());
                    }
                }
            }
        };
        this.mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.5
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && m.this.ePv != null) {
                    m.this.ePv.JF();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.ePc = replyMessageFragment;
        this.ePn = new aj(replyMessageFragment.getPageContext());
        this.ePn.a(new aj.a() { // from class: com.baidu.tieba.imMessageCenter.mention.m.8
            @Override // com.baidu.tbadk.core.util.aj.a
            public void c(boolean z, int i) {
                if (z && m.this.ePv != null) {
                    m.this.ePv.JB();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.z(this.bEd.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        m.this.iF(true);
                        m.this.ePc.ayI();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.KA();
                this.mRefreshView.fr(getPageContext().getResources().getDimensionPixelSize(e.C0141e.ds_102));
                this.mRefreshView.Ky().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.hG(getPageContext().getResources().getString(e.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.hG(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.ePm) {
                this.bEd.addHeaderView(this.mRefreshView.Ky(), 0);
            }
            this.ePm = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
        if (this.bEd != null) {
            iF(false);
            if (z) {
                this.ePh.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.ePh.BJ();
                this.ePh.setOnClickListener(this.ePt);
            } else {
                this.ePh.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                this.ePh.BJ();
                this.ePh.setText(this.mContext.getResources().getString(e.j.list_no_more));
                this.ePh.setOnClickListener(null);
            }
            if (v.z(arrayList)) {
                if (this.mNoDataView == null) {
                    this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(e.C0141e.ds80)), NoDataViewFactory.d.dE(e.j.mention_replyme_nodata), null);
                    this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    al.j(this.mNoDataView, e.d.cp_bg_line_d);
                }
                if (this.mNoDataView.getParent() == null && !this.ePl) {
                    this.ePl = true;
                    this.bEd.addHeaderView(this.mNoDataView);
                    this.mNoDataView.setVisibility(0);
                    this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
                }
                this.bEd.setNextPage(null);
                this.ePr = e.d.cp_bg_line_d;
            } else {
                this.bEd.removeHeaderView(this.mNoDataView);
                this.ePl = false;
                if (this.mRefreshView != null) {
                    this.bEd.removeHeaderView(this.mRefreshView.Ky());
                    this.ePm = false;
                }
                if (this.ePi != null) {
                    this.ePi.setData(arrayList);
                    this.ePi.notifyDataSetChanged();
                }
                this.bEd.setNextPage(this.ePh);
                this.ePr = e.d.cp_bg_line_e;
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.ePi != null) {
            this.ePi.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.ePc.getPageContext());
            this.mPullView.a(this.bEk);
        }
        this.mPullView.setTag(this.ePc.getUniqueId());
        if (this.ePh == null) {
            this.ePh = new PbListView(this.ePc.getContext());
            this.ePh.getView();
        }
        this.ePh.dL(e.d.cp_bg_line_e);
        this.ePh.setHeight(com.baidu.adp.lib.util.l.h(this.ePc.getContext(), e.C0141e.tbds182));
        this.ePh.BF();
        this.ePh.setTextSize(e.C0141e.tbfontsize33);
        this.ePh.setTextColor(al.getColor(e.d.cp_cont_d));
        this.ePh.dK(e.d.cp_cont_e);
        this.ePh.setOnClickListener(this.ePt);
        this.bEe = (BdSwipeRefreshLayout) this.mRootView.findViewById(e.g.reply_me_pull_refresh_layout);
        this.bEe.setProgressView(this.mPullView);
        this.bEd = (BdTypeRecyclerView) this.mRootView.findViewById(e.g.replyme_lv);
        this.ePi = new com.baidu.tieba.imMessageCenter.mention.base.e(this.ePc.getPageContext(), this.bEd);
        this.ePi.e(new ad() { // from class: com.baidu.tieba.imMessageCenter.mention.m.10
            @Override // com.baidu.tieba.card.ad
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long d;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.iG(false);
                        m.this.notifyDataSetChanged();
                    }
                    if (view.getId() == e.g.message_bottom_reply_container) {
                        m.this.ePw = aVar;
                        if (aVar.aRA()) {
                            d = com.baidu.adp.lib.g.b.d(aVar.aRB(), 0L);
                        } else {
                            d = com.baidu.adp.lib.g.b.d(aVar.getPost_id(), 0L);
                        }
                        if (m.this.ePo == null) {
                            m.this.ePo = new AttentionHostData();
                        }
                        if (m.this.ePw != null) {
                            m.this.ePo.parserWithMetaData(m.this.ePw.getThreadAuthor());
                        }
                        m.this.ePu.a(d, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aRC() != null) {
                            am w = new am(aVar.aRC()).w("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eQb) {
                                w.w("obj_type", 1);
                            } else {
                                w.w("obj_type", 2);
                            }
                            TiebaStatic.log(w);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.bEd.getItemAnimator()).setSupportsChangeAnimations(false);
        this.bEd.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.bEd.setFadingEdgeLength(0);
        this.bEd.setOverScrollMode(2);
        this.bEd.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.bEd.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.m.11
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.bEd.setNextPage(this.ePh);
        this.bEd.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.m.12
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (m.this.ePh != null) {
                    m.this.ePh.dN(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
                    m.this.ePh.setOnClickListener(null);
                    m.this.ePh.showLoading();
                    m.this.ePc.ayH();
                }
            }
        });
        this.bEd.setOnScrollListener(this.mScrollListener);
        aRw();
        this.ePu = new ReplyMeModel(this.ePc.getPageContext());
        this.ePu.a(this.ePB);
        this.ePA = new DataModel<MessageCenterActivity>(com.baidu.adp.base.i.aK(this.ePc.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.m.13
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Jd() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData hd(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(m.this.mForumId);
                writeData.setForumName(m.this.ePx);
                writeData.setThreadId(m.this.ePw.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (m.this.ePw.aRA()) {
                    writeData.setFloor(m.this.ePy > 0 ? String.valueOf(m.this.ePy) : m.this.ePw.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(m.this.ePw.getPost_id());
                }
                if (m.this.ePz > 0) {
                    writeData.setRepostId(String.valueOf(m.this.ePz));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Je() {
                return null;
            }
        };
        this.ePv = (com.baidu.tbadk.editortools.pb.g) new com.baidu.tbadk.editortools.pb.h().bE(this.ePc.getPageContext().getContext());
        this.ePv.setContext(this.ePc.getPageContext());
        this.ePv.b(this.ePA);
        this.ePv.d(this.ePc.getPageContext());
        this.ePv.IJ().bP(true);
        this.ePv.IJ().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.ePv.IJ() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.ePv.IJ(), layoutParams);
            this.ePv.IJ().hide();
        }
        this.ePv.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.m.2
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Jh() {
                if (m.this.ePc.getBaseFragmentActivity() != null) {
                    m.this.ePc.getBaseFragmentActivity().showProgressBar();
                }
            }
        });
        this.ePv.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.m.3
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.v vVar, WriteData writeData, AntiData antiData) {
                if (m.this.ePc.getBaseFragmentActivity() != null) {
                    m.this.ePc.getBaseFragmentActivity().hideProgressBar();
                    m.this.ePv.IJ().hide();
                    if (!z && postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010) {
                        m.this.ePn.a(m.this.ePo);
                        m.this.ePn.a(postWriteCallBackData.getReplyPrivacyTip());
                    } else if (postWriteCallBackData != null && vVar == null && !AntiHelper.am(postWriteCallBackData.getErrorCode(), postWriteCallBackData.getErrorString()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                        m.this.ePc.showToast(postWriteCallBackData.getErrorString());
                    }
                }
            }
        });
        return this.mRootView;
    }

    private void aRw() {
        this.ePj = new com.baidu.tieba.imMessageCenter.mention.base.f(this.ePc.getPageContext());
        this.ePk = new com.baidu.tieba.imMessageCenter.mention.base.f(this.ePc.getPageContext());
        this.ePj.ax(this.ePc.getString(e.j.at_me), e.f.icon_im_at);
        pt(this.ePp);
        this.ePk.ax(this.ePc.getString(e.j.agree_me), e.f.icon_im_laud);
        pu(this.ePq);
        this.ePk.pv(8);
        this.bEd.addHeaderView(this.ePj.getView());
        this.bEd.addHeaderView(this.ePk.getView());
        this.bEd.setOnHeaderClickListener(this.ePs);
    }

    public void onChangeSkinType(int i) {
        if (this.ePv != null && this.ePv.IJ() != null) {
            this.ePv.IJ().onChangeSkinType(i);
        }
        if (this.ePh != null) {
            this.ePh.setTextColor(al.getColor(e.d.cp_cont_d));
            this.ePh.dM(i);
        }
        if (this.mPullView != null) {
            this.mPullView.dM(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            al.j(this.mNoDataView, e.d.cp_bg_line_d);
        }
        if (this.ePj != null) {
            this.ePj.aRD();
        }
        if (this.ePk != null) {
            this.ePk.aRD();
        }
        notifyDataSetChanged();
        al.j(this.bEd, this.ePr);
        al.j(this.bEe, e.d.cp_bg_line_e);
    }

    public boolean onBackPressed() {
        if (this.ePv == null || this.ePv.IJ() == null || this.ePv.IJ().getVisibility() != 0) {
            return false;
        }
        this.ePv.JF();
        return true;
    }

    public void iF(boolean z) {
        if (this.bEe != null) {
            if (z && this.bEd != null && this.bEd.getFirstVisiblePosition() != 0) {
                this.bEd.setSelection(0);
            }
            this.bEe.setRefreshing(z);
        }
    }

    public void a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.ePp = newsNotifyMessage.getMsgAtme();
            this.ePq = newsNotifyMessage.getMsgAgree();
            pt(this.ePp);
            pu(this.ePq);
        }
    }

    public void aRx() {
        pt(this.ePp);
        pu(this.ePq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(int i) {
        if (this.ePj != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fk()) {
                z = true;
            }
            this.ePj.y(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pu(int i) {
        if (this.ePk != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Ff().Fw()) {
                z = true;
            }
            this.ePk.y(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.ePv != null) {
            if (i == 12005) {
                this.ePv.JI();
            }
            this.ePv.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.ePv.IJ().Hf();
        this.ePv.JF();
        this.ePv.IJ().IT();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.ePv.b(writeData);
                this.ePv.setVoiceModel(pbEditorData.getVoiceModel());
                com.baidu.tbadk.editortools.k eZ = this.ePv.IJ().eZ(6);
                if (eZ != null && eZ.aPu != null) {
                    eZ.aPu.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.ePv.JB();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.ePv != null) {
            this.ePv.onDestory();
        }
        if (this.ePn != null) {
            this.ePn.onDestroy();
        }
        if (this.ePu != null) {
            this.ePu.a((ReplyMeModel.a) null);
            this.ePu.onDestroy();
        }
        if (this.ePn != null) {
            this.ePn.a((aj.a) null);
        }
    }

    public void d(n nVar) {
        if (this.ePi != null) {
            this.ePi.d(nVar);
        }
    }
}
