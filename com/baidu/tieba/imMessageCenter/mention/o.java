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
import com.baidu.adp.widget.refresh.BdSwipeRefreshLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AgreeMeActivityConfig;
import com.baidu.tbadk.core.atomData.AtMessageActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.r;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.ReplyMeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class o extends com.baidu.adp.base.c {
    private final RecyclerView.OnScrollListener Sb;
    private BdTypeRecyclerView cdR;
    private BdSwipeRefreshLayout cdS;
    private final j.b cdY;
    private String eTA;
    private long eTB;
    private long eTC;
    private DataModel<g> eTD;
    private final ReplyMeModel.a eTE;
    private final p eTh;
    private PbListView eTm;
    private com.baidu.tieba.imMessageCenter.mention.base.e eTn;
    private com.baidu.tieba.imMessageCenter.mention.base.f eTo;
    private com.baidu.tieba.imMessageCenter.mention.base.f eTp;
    private boolean eTq;
    private boolean eTr;
    private int eTs;
    private int eTt;
    private int eTu;
    private BdListView.b eTv;
    private View.OnClickListener eTw;
    private ReplyMeModel eTx;
    private com.baidu.tbadk.editortools.pb.h eTy;
    private com.baidu.tieba.imMessageCenter.mention.base.a eTz;
    private String mForumId;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.j.g mRefreshView;
    private ViewGroup mRootView;

    public o(p pVar) {
        super(pVar.getPageContext());
        this.eTs = 0;
        this.eTt = 0;
        this.eTu = d.C0141d.cp_bg_line_e;
        this.eTv = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.o.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != o.this.eTo.getView()) {
                    if (view == o.this.eTp.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(o.this.eTh.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().GZ();
                        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().gU(0);
                        o.this.eTt = 0;
                        o.this.qO(o.this.eTt);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(o.this.eTh.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().GY();
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgAtme(0);
                o.this.eTs = 0;
                o.this.qN(o.this.eTs);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(o.this.eTh.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.eTw = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.eTm != null && o.this.eTh != null) {
                    o.this.eTm.gy(0);
                    o.this.eTm.setOnClickListener(null);
                    o.this.eTm.Eg();
                    o.this.eTh.aNL();
                }
            }
        };
        this.cdY = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.o.6
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    if (o.this.eTh != null) {
                        o.this.eTh.aNK();
                    }
                } else if (o.this.cdS != null) {
                    o.this.cdS.setRefreshing(false);
                }
            }
        };
        this.eTx = null;
        this.eTE = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.o.3
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                o.this.mForumId = String.valueOf(j);
                o.this.eTA = str;
                o.this.eTB = j2;
                o.this.eTC = j3;
                if (o.this.eTy != null && o.this.eTz != null) {
                    if (!o.this.eTz.aNO() || o.this.eTz.getReplyer() == null) {
                        o.this.eTy.gD(null);
                    } else {
                        o.this.eTy.gD(o.this.eTz.getReplyer().getName_show());
                    }
                }
            }
        };
        this.Sb = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && o.this.eTy != null) {
                    o.this.eTy.LX();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eTh = pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.E(this.cdR.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        o.this.ip(true);
                        o.this.eTh.aNK();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.MR();
                this.mRefreshView.ia(this.eTh.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds_102));
                this.mRefreshView.MP().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.gW(getPageContext().getResources().getString(d.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.gW(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.eTr) {
                this.cdR.addHeaderView(this.mRefreshView.MP(), 0);
            }
            this.eTr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        ip(false);
        if (z) {
            this.eTm.gy(0);
            this.eTm.Eh();
            this.eTm.setOnClickListener(this.eTw);
        } else {
            this.eTm.gy(0);
            this.eTm.Eh();
            this.eTm.setText(this.mContext.getResources().getString(d.j.list_no_more));
            this.eTm.setOnClickListener(null);
        }
        if (v.E(arrayList)) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.mention_replyme_nodata), null);
                this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
            }
            if (this.mNoDataView.getParent() == null && !this.eTq && this.cdR != null) {
                this.eTq = true;
                this.cdR.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.cdR.setNextPage(null);
            this.eTu = d.C0141d.cp_bg_line_d;
        } else {
            if (this.cdR != null) {
                this.cdR.removeHeaderView(this.mNoDataView);
                this.eTq = false;
                if (this.mRefreshView != null) {
                    this.cdR.removeHeaderView(this.mRefreshView.MP());
                    this.eTr = false;
                }
            }
            if (this.eTn != null) {
                this.eTn.setData(arrayList);
                this.eTn.notifyDataSetChanged();
            }
            this.cdR.setNextPage(this.eTm);
            this.eTu = d.C0141d.cp_bg_line_e;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eTn != null) {
            this.eTn.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.eTh.getPageContext());
            this.mPullView.a(this.cdY);
        }
        this.mPullView.setTag(this.eTh.getUniqueId());
        if (this.eTm == null) {
            this.eTm = new PbListView(this.eTh.getContext());
            this.eTm.getView();
        }
        this.eTm.gw(d.C0141d.cp_bg_line_e);
        this.eTm.setHeight(com.baidu.adp.lib.util.l.t(this.eTh.getContext(), d.e.tbds182));
        this.eTm.Ed();
        this.eTm.setTextSize(d.e.tbfontsize33);
        this.eTm.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
        this.eTm.gv(d.C0141d.cp_cont_e);
        this.eTm.setOnClickListener(this.eTw);
        this.cdS = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.cdS.setProgressView(this.mPullView);
        this.cdR = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eTn = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eTh.getPageContext(), this.cdR);
        this.eTn.c(new com.baidu.tieba.card.v() { // from class: com.baidu.tieba.imMessageCenter.mention.o.8
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.iq(false);
                        o.this.notifyDataSetChanged();
                    }
                    if (view.getId() == d.g.message_bottom_reply_container) {
                        o.this.eTz = aVar;
                        if (aVar.aNO()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aNP(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        o.this.eTx.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aNQ() != null) {
                            ak s = new ak(aVar.aNQ()).s("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eUd) {
                                s.s("obj_type", 1);
                            } else {
                                s.s("obj_type", 2);
                            }
                            TiebaStatic.log(s);
                        }
                    }
                }
            }
        });
        ((DefaultItemAnimator) this.cdR.getItemAnimator()).setSupportsChangeAnimations(false);
        this.cdR.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.cdR.setFadingEdgeLength(0);
        this.cdR.setOverScrollMode(2);
        this.cdR.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.cdR.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.9
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.cdR.setNextPage(this.eTm);
        this.cdR.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.o.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (o.this.eTm != null) {
                    o.this.eTm.gy(0);
                    o.this.eTm.setOnClickListener(null);
                    o.this.eTm.showLoading();
                    o.this.eTh.aNL();
                }
            }
        });
        this.cdR.setOnScrollListener(this.Sb);
        aNI();
        this.eTx = new ReplyMeModel(this.eTh.getPageContext());
        this.eTx.a(this.eTE);
        this.eTD = new DataModel<g>(com.baidu.adp.base.i.ak(this.eTh.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.o.11
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Lw() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData gr(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(o.this.mForumId);
                writeData.setForumName(o.this.eTA);
                writeData.setThreadId(o.this.eTz.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (o.this.eTz.aNO()) {
                    writeData.setFloor(o.this.eTB > 0 ? String.valueOf(o.this.eTB) : o.this.eTz.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(o.this.eTz.getPost_id());
                }
                if (o.this.eTC > 0) {
                    writeData.setRepostId(String.valueOf(o.this.eTC));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Lx() {
                return null;
            }
        };
        this.eTy = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bd(this.eTh.getPageContext().getContext());
        this.eTy.setContext(this.eTh.getPageContext());
        this.eTy.b(this.eTD);
        this.eTy.d(this.eTh.getPageContext());
        this.eTy.Lc().cf(true);
        this.eTy.Lc().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eTy.Lc() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eTy.Lc(), layoutParams);
            this.eTy.Lc().hide();
        }
        this.eTy.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.o.12
            @Override // com.baidu.tbadk.editortools.pb.c
            public void LA() {
                o.this.eTh.getBaseFragmentActivity().showProgressBar();
            }
        });
        this.eTy.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.o.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                o.this.eTh.getBaseFragmentActivity().hideProgressBar();
                o.this.eTy.Lc().hide();
                if (postWriteCallBackData != null && tVar == null && !AntiHelper.vR(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    o.this.eTh.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    private void aNI() {
        this.eTo = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eTh.getPageContext());
        this.eTp = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eTh.getPageContext());
        this.eTo.as(this.eTh.getString(d.j.at_me), d.f.icon_im_at);
        qN(this.eTs);
        this.eTp.as(this.eTh.getString(d.j.agree_me), d.f.icon_im_laud);
        qO(this.eTt);
        this.eTp.qP(8);
        this.cdR.addHeaderView(this.eTo.getView());
        this.cdR.addHeaderView(this.eTp.getView());
        this.cdR.setOnHeaderClickListener(this.eTv);
    }

    public void onChangeSkinType(int i) {
        if (this.eTy != null && this.eTy.Lc() != null) {
            this.eTy.Lc().onChangeSkinType(i);
        }
        if (this.eTm != null) {
            this.eTm.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.eTm.gx(i);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
        }
        if (this.eTo != null) {
            this.eTo.aNR();
        }
        if (this.eTp != null) {
            this.eTp.aNR();
        }
        notifyDataSetChanged();
        aj.t(this.cdR, this.eTu);
        aj.t(this.cdS, d.C0141d.cp_bg_line_c);
    }

    public boolean onBackPressed() {
        if (this.eTy == null || this.eTy.Lc() == null || this.eTy.Lc().getVisibility() != 0) {
            return false;
        }
        this.eTy.LX();
        return true;
    }

    public void ip(boolean z) {
        if (this.cdS != null) {
            this.cdS.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.eTs = newsNotifyMessage.getMsgAtme();
            this.eTt = newsNotifyMessage.getMsgAgree();
            qN(this.eTs);
            qO(this.eTt);
        }
    }

    public void aNJ() {
        qN(this.eTs);
        qO(this.eTt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qN(int i) {
        if (this.eTo != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hv()) {
                z = true;
            }
            this.eTo.M(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qO(int i) {
        if (this.eTp != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HG()) {
                z = true;
            }
            this.eTp.M(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eTy != null) {
            this.eTy.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eTy.Lc().Jm();
        this.eTy.LX();
        this.eTy.Lc().Lm();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eTy.b(writeData);
                this.eTy.setVoiceModel(pbEditorData.getVoiceModel());
                r hI = this.eTy.Lc().hI(6);
                if (hI != null && hI.bsm != null) {
                    hI.bsm.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eTy.LT();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eTy != null) {
            this.eTy.onDestory();
        }
    }

    public void d(com.baidu.adp.widget.ListView.o oVar) {
        if (this.eTn != null) {
            this.eTn.d(oVar);
        }
    }
}
