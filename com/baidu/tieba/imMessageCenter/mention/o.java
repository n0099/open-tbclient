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
    private BdTypeRecyclerView cdO;
    private BdSwipeRefreshLayout cdP;
    private final j.b cdV;
    private final p eSS;
    private PbListView eSX;
    private com.baidu.tieba.imMessageCenter.mention.base.e eSY;
    private com.baidu.tieba.imMessageCenter.mention.base.f eSZ;
    private com.baidu.tieba.imMessageCenter.mention.base.f eTa;
    private boolean eTb;
    private boolean eTc;
    private int eTd;
    private int eTe;
    private int eTf;
    private BdListView.b eTg;
    private View.OnClickListener eTh;
    private ReplyMeModel eTi;
    private com.baidu.tbadk.editortools.pb.h eTj;
    private com.baidu.tieba.imMessageCenter.mention.base.a eTk;
    private String eTl;
    private long eTm;
    private long eTn;
    private DataModel<g> eTo;
    private final ReplyMeModel.a eTp;
    private String mForumId;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private com.baidu.tbadk.core.view.k mPullView;
    private com.baidu.tbadk.j.g mRefreshView;
    private ViewGroup mRootView;

    public o(p pVar) {
        super(pVar.getPageContext());
        this.eTd = 0;
        this.eTe = 0;
        this.eTf = d.C0141d.cp_bg_line_e;
        this.eTg = new BdListView.b() { // from class: com.baidu.tieba.imMessageCenter.mention.o.1
            @Override // com.baidu.adp.widget.ListView.BdListView.b
            public void onClick(View view) {
                if (view != o.this.eSZ.getView()) {
                    if (view == o.this.eTa.getView()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AgreeMeActivityConfig(o.this.eSS.getPageContext().getPageActivity())));
                        com.baidu.tbadk.coreExtra.messageCenter.a.GI().GY();
                        com.baidu.tbadk.coreExtra.messageCenter.a.GI().gU(0);
                        o.this.eTe = 0;
                        o.this.qO(o.this.eTe);
                        TiebaStatic.log("c12926");
                        return;
                    }
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AtMessageActivityConfig(o.this.eSS.getPageContext().getPageActivity())));
                com.baidu.tbadk.coreExtra.messageCenter.a.GI().GX();
                com.baidu.tbadk.coreExtra.messageCenter.a.GI().setMsgAtme(0);
                o.this.eTd = 0;
                o.this.qN(o.this.eTd);
                TiebaStatic.log("c12925");
                TiebaStatic.eventStat(o.this.eSS.getPageContext().getPageActivity(), "msg_atme_tab_click", "click", 1, new Object[0]);
            }
        };
        this.eTh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (o.this.eSX != null && o.this.eSS != null) {
                    o.this.eSX.gy(0);
                    o.this.eSX.setOnClickListener(null);
                    o.this.eSX.Ef();
                    o.this.eSS.aNK();
                }
            }
        };
        this.cdV = new j.b() { // from class: com.baidu.tieba.imMessageCenter.mention.o.6
            @Override // com.baidu.tbadk.core.view.j.b
            public void bw(boolean z) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    if (o.this.eSS != null) {
                        o.this.eSS.aNJ();
                    }
                } else if (o.this.cdP != null) {
                    o.this.cdP.setRefreshing(false);
                }
            }
        };
        this.eTi = null;
        this.eTp = new ReplyMeModel.a() { // from class: com.baidu.tieba.imMessageCenter.mention.o.3
            @Override // com.baidu.tieba.imMessageCenter.mention.ReplyMeModel.a
            public void a(long j, long j2, long j3, String str) {
                o.this.mForumId = String.valueOf(j);
                o.this.eTl = str;
                o.this.eTm = j2;
                o.this.eTn = j3;
                if (o.this.eTj != null && o.this.eTk != null) {
                    if (!o.this.eTk.aNN() || o.this.eTk.getReplyer() == null) {
                        o.this.eTj.gD(null);
                    } else {
                        o.this.eTj.gD(o.this.eTk.getReplyer().getName_show());
                    }
                }
            }
        };
        this.Sb = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i != 0 && o.this.eTj != null) {
                    o.this.eTj.LW();
                }
                super.onScrollStateChanged(recyclerView, i);
            }
        };
        this.eSS = pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (v.E(this.cdO.getData())) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.7
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        o.this.ik(true);
                        o.this.eSS.aNJ();
                    }
                });
                this.mRefreshView.setTitle(null);
                this.mRefreshView.setButtonText(null);
                this.mRefreshView.MQ();
                this.mRefreshView.ia(this.eSS.getPageContext().getContext().getResources().getDimensionPixelSize(d.e.ds_102));
                this.mRefreshView.MO().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            }
            if (errorData != null) {
                this.mRefreshView.gW(getPageContext().getResources().getString(d.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code)));
            } else {
                this.mRefreshView.gW(null);
            }
            this.mRefreshView.onChangeSkinType();
            if (!this.eTc) {
                this.cdO.addHeaderView(this.mRefreshView.MO(), 0);
            }
            this.eTc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
        ik(false);
        if (z) {
            this.eSX.gy(0);
            this.eSX.Eg();
            this.eSX.setOnClickListener(this.eTh);
        } else {
            this.eSX.gy(0);
            this.eSX.Eg();
            this.eSX.setText(this.mContext.getResources().getString(d.j.list_no_more));
            this.eSX.setOnClickListener(null);
        }
        if (v.E(arrayList)) {
            if (this.mNoDataView == null) {
                this.mNoDataView = NoDataViewFactory.a(this.mContext.getContext(), null, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, (int) this.mContext.getResources().getDimension(d.e.ds80)), NoDataViewFactory.d.gp(d.j.mention_replyme_nodata), null);
                this.mNoDataView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
            }
            if (this.mNoDataView.getParent() == null && !this.eTb && this.cdO != null) {
                this.eTb = true;
                this.cdO.addHeaderView(this.mNoDataView);
                this.mNoDataView.setVisibility(0);
                this.mNoDataView.onChangeSkinType(this.mContext, TbadkCoreApplication.getInst().getSkinType());
            }
            this.cdO.setNextPage(null);
            this.eTf = d.C0141d.cp_bg_line_d;
        } else {
            if (this.cdO != null) {
                this.cdO.removeHeaderView(this.mNoDataView);
                this.eTb = false;
                if (this.mRefreshView != null) {
                    this.cdO.removeHeaderView(this.mRefreshView.MO());
                    this.eTc = false;
                }
            }
            if (this.eSY != null) {
                this.eSY.setData(arrayList);
                this.eSY.notifyDataSetChanged();
            }
            this.cdO.setNextPage(this.eSX);
            this.eTf = d.C0141d.cp_bg_line_e;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyDataSetChanged() {
        if (this.eSY != null) {
            this.eSY.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View onCreateView(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        this.mRootView = viewGroup;
        if (this.mPullView == null) {
            this.mPullView = new com.baidu.tbadk.core.view.k(this.eSS.getPageContext());
            this.mPullView.a(this.cdV);
        }
        this.mPullView.setTag(this.eSS.getUniqueId());
        if (this.eSX == null) {
            this.eSX = new PbListView(this.eSS.getContext());
            this.eSX.getView();
        }
        this.eSX.gw(d.C0141d.cp_bg_line_e);
        this.eSX.setHeight(com.baidu.adp.lib.util.l.t(this.eSS.getContext(), d.e.tbds182));
        this.eSX.Ec();
        this.eSX.setTextSize(d.e.tbfontsize33);
        this.eSX.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
        this.eSX.gv(d.C0141d.cp_cont_e);
        this.eSX.setOnClickListener(this.eTh);
        this.cdP = (BdSwipeRefreshLayout) this.mRootView.findViewById(d.g.reply_me_pull_refresh_layout);
        this.cdP.setProgressView(this.mPullView);
        this.cdO = (BdTypeRecyclerView) this.mRootView.findViewById(d.g.replyme_lv);
        this.eSY = new com.baidu.tieba.imMessageCenter.mention.base.e(this.eSS.getPageContext(), this.cdO);
        this.eSY.c(new com.baidu.tieba.card.v() { // from class: com.baidu.tieba.imMessageCenter.mention.o.8
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
                        o.this.eTk = aVar;
                        if (aVar.aNN()) {
                            c = com.baidu.adp.lib.g.b.c(aVar.aNO(), 0L);
                        } else {
                            c = com.baidu.adp.lib.g.b.c(aVar.getPost_id(), 0L);
                        }
                        o.this.eTi.a(c, 2, aVar.getFname(), aVar.getThread_id());
                        if (aVar.aNP() != null) {
                            ak s = new ak(aVar.aNP()).s("obj_locate", 3);
                            if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eTO) {
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
        ((DefaultItemAnimator) this.cdO.getItemAnimator()).setSupportsChangeAnimations(false);
        this.cdO.setLayoutManager(new LinearLayoutManager(this.mContext.getContext()));
        this.cdO.setFadingEdgeLength(0);
        this.cdO.setOverScrollMode(2);
        this.cdO.addItemDecoration(new com.baidu.tieba.imMessageCenter.mention.base.d());
        this.cdO.setRecyclerListener(new RecyclerView.RecyclerListener() { // from class: com.baidu.tieba.imMessageCenter.mention.o.9
            @Override // android.support.v7.widget.RecyclerView.RecyclerListener
            public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
                View view = viewHolder.itemView;
            }
        });
        this.cdO.setNextPage(this.eSX);
        this.cdO.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.imMessageCenter.mention.o.10
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (o.this.eSX != null) {
                    o.this.eSX.gy(0);
                    o.this.eSX.setOnClickListener(null);
                    o.this.eSX.showLoading();
                    o.this.eSS.aNK();
                }
            }
        });
        this.cdO.setOnScrollListener(this.Sb);
        aNH();
        this.eTi = new ReplyMeModel(this.eSS.getPageContext());
        this.eTi.a(this.eTp);
        this.eTo = new DataModel<g>(com.baidu.adp.base.i.ak(this.eSS.getPageContext().getContext())) { // from class: com.baidu.tieba.imMessageCenter.mention.o.11
            @Override // com.baidu.adp.base.BdBaseModel
            public boolean cancelLoadData() {
                return false;
            }

            @Override // com.baidu.adp.base.BdBaseModel
            protected boolean LoadData() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public boolean Lv() {
                return false;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public WriteData gr(String str) {
                WriteData writeData = new WriteData();
                writeData.setForumId(o.this.mForumId);
                writeData.setForumName(o.this.eTl);
                writeData.setThreadId(o.this.eTk.getThread_id());
                writeData.setIsAd(false);
                writeData.setFloorNum(0);
                if (o.this.eTk.aNN()) {
                    writeData.setFloor(o.this.eTm > 0 ? String.valueOf(o.this.eTm) : o.this.eTk.getOriginalThreadInfo().postId);
                } else {
                    writeData.setFloor(o.this.eTk.getPost_id());
                }
                if (o.this.eTn > 0) {
                    writeData.setRepostId(String.valueOf(o.this.eTn));
                }
                writeData.setType(2);
                return writeData;
            }

            @Override // com.baidu.tbadk.editortools.pb.DataModel
            public String Lw() {
                return null;
            }
        };
        this.eTj = (com.baidu.tbadk.editortools.pb.h) new com.baidu.tbadk.editortools.pb.i().bd(this.eSS.getPageContext().getContext());
        this.eTj.setContext(this.eSS.getPageContext());
        this.eTj.b(this.eTo);
        this.eTj.d(this.eSS.getPageContext());
        this.eTj.Lb().cf(true);
        this.eTj.Lb().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.eTj.Lb() != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.mRootView.addView(this.eTj.Lb(), layoutParams);
            this.eTj.Lb().hide();
        }
        this.eTj.a(new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.imMessageCenter.mention.o.12
            @Override // com.baidu.tbadk.editortools.pb.c
            public void Lz() {
                o.this.eSS.getBaseFragmentActivity().showProgressBar();
            }
        });
        this.eTj.b(new NewWriteModel.d() { // from class: com.baidu.tieba.imMessageCenter.mention.o.2
            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, t tVar, WriteData writeData, AntiData antiData) {
                o.this.eSS.getBaseFragmentActivity().hideProgressBar();
                o.this.eTj.Lb().hide();
                if (postWriteCallBackData != null && tVar == null && !AntiHelper.vR(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
                    o.this.eSS.showToast(postWriteCallBackData.getErrorString());
                }
            }
        });
        return this.mRootView;
    }

    private void aNH() {
        this.eSZ = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eSS.getPageContext());
        this.eTa = new com.baidu.tieba.imMessageCenter.mention.base.f(this.eSS.getPageContext());
        this.eSZ.as(this.eSS.getString(d.j.at_me), d.f.icon_im_at);
        qN(this.eTd);
        this.eTa.as(this.eSS.getString(d.j.agree_me), d.f.icon_im_laud);
        qO(this.eTe);
        this.eTa.qP(8);
        this.cdO.addHeaderView(this.eSZ.getView());
        this.cdO.addHeaderView(this.eTa.getView());
        this.cdO.setOnHeaderClickListener(this.eTg);
    }

    public void onChangeSkinType(int i) {
        if (this.eTj != null && this.eTj.Lb() != null) {
            this.eTj.Lb().onChangeSkinType(i);
        }
        if (this.eSX != null) {
            this.eSX.setTextColor(aj.getColor(d.C0141d.cp_cont_d));
            this.eSX.gx(i);
        }
        if (this.mPullView != null) {
            this.mPullView.gx(i);
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mContext, i);
            aj.t(this.mNoDataView, d.C0141d.cp_bg_line_d);
        }
        if (this.eSZ != null) {
            this.eSZ.aNQ();
        }
        if (this.eTa != null) {
            this.eTa.aNQ();
        }
        notifyDataSetChanged();
        aj.t(this.cdO, this.eTf);
        aj.t(this.cdP, d.C0141d.cp_bg_line_c);
    }

    public boolean onBackPressed() {
        if (this.eTj == null || this.eTj.Lb() == null || this.eTj.Lb().getVisibility() != 0) {
            return false;
        }
        this.eTj.LW();
        return true;
    }

    public void ik(boolean z) {
        if (this.cdP != null) {
            this.cdP.setRefreshing(z);
        }
    }

    public void b(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage != null) {
            this.eTd = newsNotifyMessage.getMsgAtme();
            this.eTe = newsNotifyMessage.getMsgAgree();
            qN(this.eTd);
            qO(this.eTe);
        }
    }

    public void aNI() {
        qN(this.eTd);
        qO(this.eTe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qN(int i) {
        if (this.eSZ != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hp().Hu()) {
                z = true;
            }
            this.eSZ.M(i, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qO(int i) {
        if (this.eTa != null) {
            boolean z = false;
            if (i > 0 && !com.baidu.tbadk.coreExtra.messageCenter.c.Hp().HF()) {
                z = true;
            }
            this.eTa.M(i, z);
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (this.eTj != null) {
            this.eTj.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
            return false;
        }
        return false;
    }

    private void d(int i, Intent intent) {
        this.eTj.Lb().Jl();
        this.eTj.LW();
        this.eTj.Lb().Ll();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                this.eTj.b(writeData);
                this.eTj.setVoiceModel(pbEditorData.getVoiceModel());
                r hI = this.eTj.Lb().hI(6);
                if (hI != null && hI.bsj != null) {
                    hI.bsj.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i == -1) {
                    this.eTj.LS();
                }
            }
        }
    }

    @Override // com.baidu.adp.base.c
    public void destroy() {
        if (this.eTj != null) {
            this.eTj.onDestory();
        }
    }

    public void d(com.baidu.adp.widget.ListView.o oVar) {
        if (this.eSY != null) {
            this.eSY.d(oVar);
        }
    }
}
