package com.baidu.tieba.vote;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aJK;
    private PbActivity dfw;
    private View eFD;
    private VotePhotoGroupView eFE;
    private VoteTextGroupView eFF;
    private VoteView eFG;
    private TextView eFH;
    private View eFI;
    private View eFJ;
    private VoteDataInfo eFK;
    private final List<f> eFL;
    private boolean eFM;
    private h eFN;
    private final com.baidu.adp.framework.listener.a eFO;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.eFD != null) {
            this.eFD.setVisibility(i);
        }
    }

    public void aYE() {
        if (this.eFE != null) {
            this.eFE.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.eFL = new ArrayList();
        this.eFM = false;
        this.maxWidth = 0;
        this.aJK = new c(this);
        this.eFO = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.dfw = pbActivity;
        pbActivity.registerListener(this.eFO);
        this.maxWidth = k.B(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
        this.eFN = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.avu() != null && eVar.avv() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(eVar.avu().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(eVar.avv().getId(), 0L);
            if (eVar.avv().tN() && eVar.avv().tm() != null) {
                if (this.eFD == null) {
                    this.eFD = ((ViewStub) view.findViewById(t.g.vote_card_layout)).inflate();
                    this.eFH = (TextView) this.eFD.findViewById(t.g.btn_pb_vote);
                    this.eFI = this.eFD.findViewById(t.g.vote_top_line);
                    this.eFJ = this.eFD.findViewById(t.g.vote_middle_line);
                    this.eFK = eVar.avt();
                    a(this.eFK, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m411getInst().getSkinType()) {
                    uA();
                }
                this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
                if (!this.eFD.isShown()) {
                    this.eFD.setVisibility(0);
                }
            } else if (this.eFD != null && this.eFD.isShown()) {
                this.eFD.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.eFK = voteDataInfo;
        if (this.eFK != null) {
            Ze();
            if (this.eFK.getVoteType() == 1) {
                if (this.eFK.getStatus() == 2 || this.eFK.getIsPolled() == 1) {
                    jl(z);
                } else {
                    aYF();
                }
            } else if (this.eFK.getVoteType() == 2) {
                if (this.eFK.getStatus() == 2 || this.eFK.getIsPolled() == 1) {
                    w(2, z);
                } else {
                    w(this.eFK.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void w(int i, boolean z) {
        if (this.eFD != null && this.eFK != null) {
            this.eFE = (VotePhotoGroupView) this.eFD.findViewById(t.g.picvote_view);
            this.eFE.setOnVoteCheckedChangedListener(this.aJK);
            this.eFE.setVisibility(0);
            this.eFE.setMode(i);
            this.eFE.setData(this.eFK.getOptions(), z);
            if (this.eFI != null) {
                this.eFI.setVisibility(8);
            }
            if (this.eFJ != null) {
                this.eFJ.setVisibility(8);
            }
        }
    }

    private void Ze() {
        if (this.eFD != null && this.eFK != null) {
            ((TextView) this.eFD.findViewById(t.g.tv_vote_endtime)).setText(this.eFK.getTips());
            ((TextView) this.eFD.findViewById(t.g.vote_num)).setText(getPageContext().getPageActivity().getString(t.j.pb_vote_num, new Object[]{Long.valueOf(this.eFK.getTotalNum())}));
            aYH();
        }
    }

    private void aYF() {
        if (this.eFD != null && this.eFK != null) {
            this.eFF = (VoteTextGroupView) this.eFD.findViewById(t.g.textvote_view);
            this.eFF.setOnVoteCheckedChangedListener(this.aJK);
            this.eFF.setVisibility(0);
            this.eFF.setMode(this.eFK.getIsMulti() == 1 ? 1 : 2);
            this.eFF.B(this.eFK.getOptions());
            this.eFF.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void jl(boolean z) {
        if (this.eFD != null && this.eFK != null) {
            this.eFE = (VotePhotoGroupView) this.eFD.findViewById(t.g.picvote_view);
            this.eFF = (VoteTextGroupView) this.eFD.findViewById(t.g.textvote_view);
            this.eFG = (VoteView) this.eFD.findViewById(t.g.result_vote_view);
            this.eFF.setVisibility(8);
            this.eFE.setVisibility(8);
            this.eFG.setVisibility(0);
            this.eFG.setWidth(this.maxWidth);
            this.eFG.a(this.eFK.getOptions(), z);
            this.eFG.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYG() {
        if (this.eFK != null) {
            if (this.eFN != null && this.dfw != null) {
                this.eFN.c(this.dfw.getActivity().getString(t.j.vote_succ));
            }
            this.eFK.setIsPolled(1);
            this.eFK.setTotalNum(this.eFK.getTotalNum() + 1);
            this.eFK.setTotalPoll(this.eFK.getTotalPoll() + this.eFL.size());
            for (f fVar : this.eFL) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.eFK.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.eFK.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.ci((int) ((fVar2.getNum() * 100) / this.eFK.getTotalPoll()));
                    }
                }
            }
            a(this.eFK, true);
            this.eFL.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void uA() {
        if (this.eFD != null) {
            com.baidu.tbadk.i.a.a(this.dfw.getPageContext(), this.eFD);
        }
        aYH();
    }

    private void aYH() {
        if (this.eFH != null && this.eFK != null) {
            if (this.eFK.getStatus() == 2) {
                at.k(this.eFH, t.f.btn_pb_vote_d);
                this.eFH.setText(getPageContext().getString(t.j.pb_vote_over));
                at.b(this.eFH, t.d.cp_cont_d, 1);
                this.eFH.setEnabled(false);
            } else if (this.eFK.getIsPolled() == 1) {
                at.k(this.eFH, t.f.btn_pb_vote_d);
                this.eFH.setText(getPageContext().getString(t.j.pb_voted));
                at.b(this.eFH, t.d.cp_cont_d, 1);
                this.eFH.setEnabled(false);
            } else if (this.eFK.getIsPolled() == 0) {
                at.k(this.eFH, t.f.btn_pb_vote_selector);
                this.eFH.setText(getPageContext().getString(t.j.pb_vote_add));
                at.b(this.eFH, t.d.cp_cont_g, 1);
                this.eFH.setEnabled(true);
                this.eFH.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
