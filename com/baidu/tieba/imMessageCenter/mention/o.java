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
    private final RecyclerView.OnScrollListener Sh;
    private BdTypeRecyclerView cea;
    private BdSwipeRefreshLayout ceb;
    private final j.b ceh;
    private DataModel<g> eTA;
    private final ReplyMeModel.a eTB;
    private final p eTe;
    private PbListView eTj;
    private com.baidu.tieba.imMessageCenter.mention.base.e eTk;
    private com.baidu.tieba.imMessageCenter.mention.base.f eTl;
    private com.baidu.tieba.imMessageCenter.mention.base.f eTm;
    private boolean eTn;
    private boolean eTo;
    private int eTp;
    private int eTq;
    private int eTr;
    private BdListView.b eTs;
    private View.OnClickListener eTt;
    private ReplyMeModel eTu;
    private com.baidu.tbadk.editortools.pb.h eTv;
    private com.baidu.tieba.imMessageCenter.mention.base.a eTw;
    private String eTx;
    private long eTy;
    private long eTz;
    private String mForumId;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.j.g mRefreshView;
    private ViewGroup mRootView;

    public o(p pVar) {
        super(pVar.getPageContext());
        this.eTp = 0;
        this.eTq = 0;
        this.eTr = d.C0140d.cp_bg_line_e;
        this.eTs = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.o.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != o.this.eTl.getView()) {
                    if (view == o.this.eTm.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(o.this.eTe.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().GZ();
                        com.baidu.tbadk.coreExtra.messageCenter.a.GJ().gU(0);
                        o.this.eTq = 0;
                        o.this.qN(o.this.eTq);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(o.this.eTe.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().GY();
                com.baidu.tbadk.coreExtra.messageCenter.a.GJ().setMsgAtme(0);
                o.this.eTp = 0;
                o.this.qM(o.this.eTp);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(o.this.eTe.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.eTt = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.eTj != null && o.this.eTe != null) {
                    o.this.eTj.gy(0);
                    o.this.eTj.setOnClickListener(null);
                    o.this.eTj.Eg();
                    o.this.eTe.aNL();
                }
            }
        };
        this.ceh = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.o.6
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    if (o.this.eTe != null) {
                        o.this.eTe.aNK();
                    }
                } else if (o.this.ceb != null) {
                    o.this.ceb.setRefreshing(false);
                }
            }
        };
        this.eTu = null;
        this.eTB = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.o.3
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                o.this.mForumId = String.valueOf(j);
                o.this.eTx = str;
                o.this.eTy = j2;
                o.this.eTz = j3;
                if (o.this.eTv != null && o.this.eTw != null) {
                    if (!o.this.eTw.aNO() || o.this.eTw.getReplyer() == null) {
                        o.this.eTv.gD(null);
                    } else {
                        o.this.eTv.gD(o.this.eTw.getReplyer().getName_show());
                    }
                }
            }
        };
        this.Sh = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && o.this.eTv != null) {
                    o.this.eTv.LX();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eTe = pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.E(this.cea.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        o.this.ik(true);
                        o.this.eTe.aNK();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.MR();
                this.mRefreshView.ia(this.eTe.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds_102));
                this.mRefreshView.MP().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.gW(getPageContext().getResources().getString(d.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.gW(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.eTo) {
                this.cea.addHeaderView(this.mRefreshView.MP(), 0);
            }
            this.eTo = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        ik(false);
        if (z) {
            this.eTj.gy(0);
            this.eTj.Eh();
            this.eTj.setOnClickListener(this.eTt);
        } else {
            this.eTj.gy(0);
            this.eTj.Eh();
            this.eTj.setText(this.mContext.getResources().getString(d.j.list_no_more));
            this.eTj.setOnClickListener(null);
        }
        if (v.E(arrayList)) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.mention_replyme_nodata), null);
                this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                aj.t(this.mNoDataView, d.C0140d.cp_bg_line_d);
            }
            if (this.mNoDataView.getParent() == null && !this.eTn && this.cea != null) {
                this.eTn = true;
                this.cea.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.cea.setNextPage(null);
            this.eTr = d.C0140d.cp_bg_line_d;
        } else {
            if (this.cea != null) {
                this.cea.removeHeaderView(this.mNoDataView);
                this.eTn = false;
                if (this.mRefreshView != null) {
                    this.cea.removeHeaderView(this.mRefreshView.MP());
                    this.eTo = false;
                }
            }
            if (this.eTk != null) {
                this.eTk.setData(arrayList);
                this.eTk.notifyDataSetChanged();
            }
            this.cea.setNextPage(this.eTj);
            this.eTr = d.C0140d.cp_bg_line_e;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eTk != null) {
            this.eTk.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.eTe.getPageContext());
            this.mPullView.a(this.ceh);
        }
        this.mPullView.setTag(this.eTe.getUniqueId());
        if (this.eTj == null) {
            this.eTj = new PbListView(this.eTe.getContext());
            this.eTj.getView();
        }
        this.eTj.gw(d.C0140d.cp_bg_line_e);
        this.eTj.setHeight(com.baidu.adp.lib.util.l.t(this.eTe.getContext(), d.e.tbds182));
        this.eTj.Ed();
        this.eTj.setTextSize(d.e.tbfontsize33);
        this.eTj.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
        this.eTj.gv(d.C0140d.cp_cont_e);
        this.eTj.setOnClickListener(this.eTt);
        this.ceb = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.ceb.setProgressView(this.mPullView);
        this.cea = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eTk = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eTe.getPageContext(), this.cea);
        this.eTk.c(new com.baidu.tieba.card.v() { // from class: com.baidu.tieba.imMessageCenter.mention.o.8
            @Override // com.baidu.tieba.card.v
            public void a(View view, com.baidu.tieba.card.data.b bVar) {
                long c;
                if (view != null && (bVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a)) {
                    com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) bVar;
                    if (aVar.isNew()) {
                        aVar.il(false);
                        o.this.notifyDataSetChanged();
                    }
                    if (view.getId() == d.g.message_bottom_reply_container) {
                        o.this.eTw = aVar;
                        if (aVar.aNO()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aNP(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        o.this.eTu.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aNQ() != null) {
                            ak s = new ak(aVar.aNQ()).s("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eUa) {
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
        ((DefaultItemAnimator) this.cea.getItemAnimator()).setSupportsChangeAnimations(false);
        this.cea.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.cea.setFadingEdgeLength(0);
        this.cea.setOverScrollMode(2);
        this.cea.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.cea.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.9
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.cea.setNextPage(this.eTj);
        this.cea.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.o.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (o.this.eTj != null) {
                    o.this.eTj.gy(0);
                    o.this.eTj.setOnClickListener(null);
                    o.this.eTj.showLoading();
                    o.this.eTe.aNL();
                }
            }
        });
        this.cea.setOnScrollListener(this.Sh);
        aNI();
        this.eTu = new ReplyMeModel(this.eTe.getPageContext());
        this.eTu.a(this.eTB);
        this.eTA = new DataModel<g>(com.baidu.adp.base.i.ak(this.eTe.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.o.11
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
                writeData.setForumName(o.this.eTx);
                writeData.setThreadId(o.this.eTw.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (o.this.eTw.aNO()) {
                    writeData.setFloor(o.this.eTy > 0 ? String.valueOf(o.this.eTy) : o.this.eTw.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(o.this.eTw.getPost_id());
                }
                if (o.this.eTz > 0) {
                    writeData.setRepostId(String.valueOf(o.this.eTz));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Lx() {
                return null;
            }
        };
        this.eTv = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bd(this.eTe.getPageContext().getContext());
        this.eTv.setContext(this.eTe.getPageContext());
        this.eTv.b(this.eTA);
        this.eTv.d(this.eTe.getPageContext());
        this.eTv.Lc().cf(true);
        this.eTv.Lc().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eTv.Lc() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eTv.Lc(), layoutParams);
            this.eTv.Lc().hide();
        }
        this.eTv.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.o.12
            @Override // com.baidu.tbadk.editortools.pb.c
            public void LA() {
                o.this.eTe.getBaseFragmentActivity().showProgressBar();
            }
        });
        this.eTv.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.o.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                o.this.eTe.getBaseFragmentActivity().hideProgressBar();
                o.this.eTv.Lc().hide();
                if (postWriteCallBackData != null && tVar == null && !AntiHelper.vQ(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    o.this.eTe.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    private void aNI() {
        this.eTl = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eTe.getPageContext());
        this.eTm = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eTe.getPageContext());
        this.eTl.as(this.eTe.getString(d.j.at_me), d.f.icon_im_at);
        qM(this.eTp);
        this.eTm.as(this.eTe.getString(d.j.agree_me), d.f.icon_im_laud);
        qN(this.eTq);
        this.eTm.qO(8);
        this.cea.addHeaderView(this.eTl.getView());
        this.cea.addHeaderView(this.eTm.getView());
        this.cea.setOnHeaderClickListener(this.eTs);
    }

    public void onChangeSkinType(int i) {
        if (this.eTv != null && this.eTv.Lc() != null) {
            this.eTv.Lc().onChangeSkinType(i);
        }
        if (this.eTj != null) {
            this.eTj.setTextColor(aj.getColor(d.C0140d.cp_cont_d));
            this.eTj.gx(i);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            aj.t(this.mNoDataView, d.C0140d.cp_bg_line_d);
        }
        if (this.eTl != null) {
            this.eTl.aNR();
        }
        if (this.eTm != null) {
            this.eTm.aNR();
        }
        notifyDataSetChanged();
        aj.t(this.cea, this.eTr);
        aj.t(this.ceb, d.C0140d.cp_bg_line_c);
    }

    public boolean onBackPressed() {
        if (this.eTv == null || this.eTv.Lc() == null || this.eTv.Lc().getVisibility() != 0) {
            return false;
        }
        this.eTv.LX();
        return true;
    }

    public void ik(boolean z) {
        if (this.ceb != null) {
            this.ceb.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.eTp = newsNotifyMessage.getMsgAtme();
            this.eTq = newsNotifyMessage.getMsgAgree();
            qM(this.eTp);
            qN(this.eTq);
        }
    }

    public void aNJ() {
        qM(this.eTp);
        qN(this.eTq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(int i) {
        if (this.eTl != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hq().Hv()) {
                z = true;
            }
            this.eTl.M(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qN(int i) {
        if (this.eTm != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hq().HG()) {
                z = true;
            }
            this.eTm.M(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eTv != null) {
            this.eTv.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eTv.Lc().Jm();
        this.eTv.LX();
        this.eTv.Lc().Lm();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eTv.b(writeData);
                this.eTv.setVoiceModel(pbEditorData.getVoiceModel());
                r hI = this.eTv.Lc().hI(6);
                if (hI != null && hI.bsw != null) {
                    hI.bsw.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eTv.LT();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eTv != null) {
            this.eTv.onDestory();
        }
    }

    public void d(com.baidu.adp.widget.ListView.o oVar) {
        if (this.eTk != null) {
            this.eTk.d(oVar);
        }
    }
}
