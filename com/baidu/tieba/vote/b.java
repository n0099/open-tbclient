package com.baidu.tieba.vote;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.av;
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
    private com.baidu.tbadk.widget.vote.b aKC;
    private PbActivity emy;
    private View fWU;
    private VotePhotoGroupView fWV;
    private VoteTextGroupView fWW;
    private VoteView fWX;
    private TextView fWY;
    private View fWZ;
    private View fXa;
    private VoteDataInfo fXb;
    private final List<f> fXc;
    private boolean fXd;
    private h fXe;
    private final com.baidu.adp.framework.listener.a fXf;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fWU != null) {
            this.fWU.setVisibility(i);
        }
    }

    public void bqu() {
        if (this.fWV != null) {
            this.fWV.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fXc = new ArrayList();
        this.fXd = false;
        this.maxWidth = 0;
        this.aKC = new c(this);
        this.fXf = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.emy = pbActivity;
        pbActivity.registerListener(this.fXf);
        this.maxWidth = k.K(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds120);
        this.fXe = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aLP() != null && hVar.aLQ() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(hVar.aLP().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(hVar.aLQ().getId(), 0L);
            if (hVar.aLQ().sm() && hVar.aLQ().rs() != null) {
                if (this.fWU == null) {
                    this.fWU = ((ViewStub) view.findViewById(t.g.vote_card_layout)).inflate();
                    this.fWY = (TextView) this.fWU.findViewById(t.g.btn_pb_vote);
                    this.fWZ = this.fWU.findViewById(t.g.vote_top_line);
                    this.fXa = this.fWU.findViewById(t.g.vote_middle_line);
                    this.fXb = hVar.aLO();
                    a(this.fXb, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    ti();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fWU.isShown()) {
                    this.fWU.setVisibility(0);
                }
            } else if (this.fWU != null && this.fWU.isShown()) {
                this.fWU.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fXb = voteDataInfo;
        if (this.fXb != null) {
            akM();
            if (this.fXb.getVoteType() == 1) {
                if (this.fXb.getStatus() == 2 || this.fXb.getIsPolled() == 1) {
                    lB(z);
                } else {
                    bqv();
                }
            } else if (this.fXb.getVoteType() == 2) {
                if (this.fXb.getStatus() == 2 || this.fXb.getIsPolled() == 1) {
                    U(2, z);
                } else {
                    U(this.fXb.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void U(int i, boolean z) {
        if (this.fWU != null && this.fXb != null) {
            this.fWV = (VotePhotoGroupView) this.fWU.findViewById(t.g.picvote_view);
            this.fWV.setOnVoteCheckedChangedListener(this.aKC);
            this.fWV.setVisibility(0);
            this.fWV.setMode(i);
            this.fWV.setData(this.fXb.getOptions(), z);
            if (this.fWZ != null) {
                this.fWZ.setVisibility(8);
            }
            if (this.fXa != null) {
                this.fXa.setVisibility(8);
            }
        }
    }

    private void akM() {
        if (this.fWU != null && this.fXb != null) {
            ((TextView) this.fWU.findViewById(t.g.tv_vote_endtime)).setText(this.fXb.getTips());
            ((TextView) this.fWU.findViewById(t.g.vote_num)).setText(getPageContext().getPageActivity().getString(t.j.pb_vote_num, new Object[]{Long.valueOf(this.fXb.getTotalNum())}));
            bqx();
        }
    }

    private void bqv() {
        if (this.fWU != null && this.fXb != null) {
            this.fWW = (VoteTextGroupView) this.fWU.findViewById(t.g.textvote_view);
            this.fWW.setOnVoteCheckedChangedListener(this.aKC);
            this.fWW.setVisibility(0);
            this.fWW.setMode(this.fXb.getIsMulti() == 1 ? 1 : 2);
            this.fWW.E(this.fXb.getOptions());
            this.fWW.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void lB(boolean z) {
        if (this.fWU != null && this.fXb != null) {
            this.fWV = (VotePhotoGroupView) this.fWU.findViewById(t.g.picvote_view);
            this.fWW = (VoteTextGroupView) this.fWU.findViewById(t.g.textvote_view);
            this.fWX = (VoteView) this.fWU.findViewById(t.g.result_vote_view);
            this.fWW.setVisibility(8);
            this.fWV.setVisibility(8);
            this.fWX.setVisibility(0);
            this.fWX.setWidth(this.maxWidth);
            this.fWX.a(this.fXb.getOptions(), z);
            this.fWX.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqw() {
        if (this.fXb != null) {
            if (this.fXe != null && this.emy != null) {
                this.fXe.c(this.emy.getActivity().getString(t.j.vote_succ));
            }
            this.fXb.setIsPolled(1);
            this.fXb.setTotalNum(this.fXb.getTotalNum() + 1);
            this.fXb.setTotalPoll(this.fXb.getTotalPoll() + this.fXc.size());
            for (f fVar : this.fXc) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fXb.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fXb.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.setPercent((int) ((fVar2.getNum() * 100) / this.fXb.getTotalPoll()));
                    }
                }
            }
            a(this.fXb, true);
            this.fXc.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void ti() {
        if (this.fWU != null) {
            com.baidu.tbadk.j.a.a(this.emy.getPageContext(), this.fWU);
        }
        bqx();
    }

    private void bqx() {
        if (this.fWY != null && this.fXb != null) {
            if (this.fXb.getStatus() == 2) {
                av.k(this.fWY, t.f.btn_pb_vote_d);
                this.fWY.setText(getPageContext().getString(t.j.pb_vote_over));
                av.c(this.fWY, t.d.cp_cont_d, 1);
                this.fWY.setEnabled(false);
            } else if (this.fXb.getIsPolled() == 1) {
                av.k(this.fWY, t.f.btn_pb_vote_d);
                this.fWY.setText(getPageContext().getString(t.j.pb_voted));
                av.c(this.fWY, t.d.cp_cont_d, 1);
                this.fWY.setEnabled(false);
            } else if (this.fXb.getIsPolled() == 0) {
                av.k(this.fWY, t.f.btn_pb_vote_selector);
                this.fWY.setText(getPageContext().getString(t.j.pb_vote_add));
                av.c(this.fWY, t.d.cp_cont_g, 1);
                this.fWY.setEnabled(true);
                this.fWY.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
