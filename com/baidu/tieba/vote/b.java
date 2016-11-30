package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aKU;
    private PbActivity eug;
    private TextView ggA;
    private TextView ggB;
    private VoteDataInfo ggC;
    private final List<g> ggD;
    private boolean ggE;
    private h ggF;
    private final com.baidu.adp.framework.listener.a ggG;
    private View ggt;
    private VotePhotoGroupView ggu;
    private VoteTextGroupView ggv;
    private VoteView ggw;
    private LinearLayout ggx;
    private TextView ggy;
    private TextView ggz;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.ggt != null) {
            this.ggt.setVisibility(i);
        }
    }

    public void bts() {
        if (this.ggu != null) {
            this.ggu.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.ggD = new ArrayList();
        this.ggE = false;
        this.maxWidth = 0;
        this.aKU = new c(this);
        this.ggG = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.eug = pbActivity;
        pbActivity.registerListener(this.ggG);
        this.maxWidth = k.K(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds120);
        this.ggF = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aOk() != null && hVar.aOl() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(hVar.aOk().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(hVar.aOl().getId(), 0L);
            if (hVar.aOl().sA() && hVar.aOl().rG() != null) {
                if (this.ggt == null) {
                    this.ggt = ((ViewStub) view.findViewById(r.g.vote_card_layout)).inflate();
                    this.ggB = (TextView) this.ggt.findViewById(r.g.btn_pb_vote);
                    this.ggC = hVar.aOj();
                    b((q) x.c(hVar.aOm(), 0), this.ggt);
                    a(this.ggC, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    tB();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.ggt.isShown()) {
                    this.ggt.setVisibility(0);
                }
            } else if (this.ggt != null && this.ggt.isShown()) {
                this.ggt.setVisibility(8);
            }
        }
    }

    private void b(q qVar, View view) {
        this.ggx = (LinearLayout) view.findViewById(r.g.pb_vote_location_container);
        this.ggy = (TextView) view.findViewById(r.g.pb_vote_first_floor_name);
        this.ggz = (TextView) view.findViewById(r.g.pb_item_vote_reply_time);
        this.ggA = (TextView) view.findViewById(r.g.pb_item_vote_location_address);
        com.baidu.tbadk.data.g gVar = null;
        if (qVar != null) {
            this.ggz.setText(qVar.bmn());
            gVar = qVar.bmo();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            String name = gVar.getName();
            String lat = gVar.getLat();
            String lng = gVar.getLng();
            this.ggA.setVisibility(0);
            this.ggA.setText(gVar.getName());
            this.ggA.setOnClickListener(new f(this, lat, lng, name));
            return;
        }
        this.ggA.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.ggC = voteDataInfo;
        if (this.ggC != null) {
            if (this.ggC.getStatus() == 2 || this.ggC.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.ggC.getOptions()) {
                    if (aVar != null && (aVar instanceof g)) {
                        ((g) aVar).setSelected(false);
                    }
                }
            }
            amV();
            if (this.ggC.getVoteType() == 1) {
                if (this.ggC.getStatus() == 2 || this.ggC.getIsPolled() == 1) {
                    mc(z);
                } else {
                    btt();
                }
            } else if (this.ggC.getVoteType() == 2) {
                if (this.ggC.getStatus() == 2 || this.ggC.getIsPolled() == 1) {
                    X(2, z);
                } else {
                    X(this.ggC.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void X(int i, boolean z) {
        if (this.ggt != null && this.ggC != null) {
            this.ggu = (VotePhotoGroupView) this.ggt.findViewById(r.g.picvote_view);
            this.ggu.setOnVoteCheckedChangedListener(this.aKU);
            this.ggu.setVisibility(0);
            this.ggu.setMode(i);
            this.ggu.a(this.ggC.getOptions(), z, this.ggC.getIsPolled() == 1);
        }
    }

    private void amV() {
        if (this.ggt != null && this.ggC != null) {
            ((TextView) this.ggt.findViewById(r.g.tv_vote_endtime)).setText(this.ggC.getTips());
            ((TextView) this.ggt.findViewById(r.g.vote_num)).setText(getPageContext().getPageActivity().getString(r.j.pb_vote_num, new Object[]{Long.valueOf(this.ggC.getTotalNum())}));
            btv();
        }
    }

    private void btt() {
        if (this.ggt != null && this.ggC != null) {
            this.ggv = (VoteTextGroupView) this.ggt.findViewById(r.g.textvote_view);
            this.ggv.setOnVoteCheckedChangedListener(this.aKU);
            this.ggv.setVisibility(0);
            this.ggv.setMode(this.ggC.getIsMulti() == 1 ? 1 : 2);
            this.ggv.E(this.ggC.getOptions());
            this.ggv.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void mc(boolean z) {
        if (this.ggt != null && this.ggC != null) {
            this.ggu = (VotePhotoGroupView) this.ggt.findViewById(r.g.picvote_view);
            this.ggv = (VoteTextGroupView) this.ggt.findViewById(r.g.textvote_view);
            this.ggw = (VoteView) this.ggt.findViewById(r.g.result_vote_view);
            this.ggv.setVisibility(8);
            this.ggu.setVisibility(8);
            this.ggw.setVisibility(0);
            this.ggw.setWidth(this.maxWidth);
            this.ggw.a(this.ggC.getOptions(), z);
            this.ggw.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btu() {
        if (this.ggC != null) {
            if (this.ggF != null && this.eug != null) {
                this.ggF.c(this.eug.getActivity().getString(r.j.vote_succ));
            }
            this.ggC.setIsPolled(1);
            this.ggC.setTotalNum(this.ggC.getTotalNum() + 1);
            this.ggC.setTotalPoll(this.ggC.getTotalPoll() + this.ggD.size());
            for (g gVar : this.ggD) {
                if (gVar != null) {
                    gVar.setNum(gVar.getNum() + 1);
                }
            }
            if (this.ggC.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.ggC.getOptions()) {
                    if (aVar instanceof g) {
                        g gVar2 = (g) aVar;
                        gVar2.setPercent((int) ((gVar2.getNum() * 100) / this.ggC.getTotalPoll()));
                    }
                }
            }
            a(this.ggC, true);
            this.ggD.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tB() {
        if (this.ggt != null) {
            com.baidu.tbadk.i.a.a(this.eug.getPageContext(), this.ggt);
        }
        btv();
    }

    private void btv() {
        if (this.ggB != null && this.ggC != null) {
            if (this.ggC.getStatus() == 2) {
                at.k(this.ggB, r.f.bg_gray_circle);
                this.ggB.setText(getPageContext().getString(r.j.pb_vote_over));
                this.ggB.setEnabled(false);
            } else if (this.ggC.getIsPolled() == 1) {
                at.k(this.ggB, r.f.bg_gray_circle);
                this.ggB.setText(getPageContext().getString(r.j.pb_voted));
                this.ggB.setEnabled(false);
            } else if (this.ggC.getIsPolled() == 0) {
                at.k(this.ggB, r.f.btn_pb_vote_selector);
                this.ggB.setText(getPageContext().getString(r.j.pb_vote_add));
                this.ggB.setEnabled(true);
                this.ggB.setOnClickListener(this.mOnClickListener);
            }
            at.c(this.ggB, r.d.cp_cont_i, 1);
        }
    }
}
