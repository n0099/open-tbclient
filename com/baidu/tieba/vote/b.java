package com.baidu.tieba.vote;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aCE;
    private PbActivity ciJ;
    private View diN;
    private VotePhotoGroupView diO;
    private VoteTextGroupView diP;
    private VoteView diQ;
    private TextView diR;
    private View diS;
    private View diT;
    private VoteDataInfo diU;
    private final List<f> diV;
    private boolean diW;
    private com.baidu.tbadk.core.view.f diX;
    private final com.baidu.adp.framework.listener.a diY;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.diN != null) {
            this.diN.setVisibility(i);
        }
    }

    public void aAA() {
        if (this.diO != null) {
            this.diO.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.diV = new ArrayList();
        this.diW = false;
        this.maxWidth = 0;
        this.aCE = new c(this);
        this.diY = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.ciJ = pbActivity;
        pbActivity.registerListener(this.diY);
        this.maxWidth = k.K(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
        this.diX = new com.baidu.tbadk.core.view.f(this.ciJ.getPageContext());
    }

    public void a(View view, com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null && bVar.aeN() != null && bVar.aeO() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(bVar.aeN().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(bVar.aeO().getId(), 0L);
            if (bVar.aeO().sB() && bVar.aeO().sg() != null) {
                if (this.diN == null) {
                    this.diN = ((ViewStub) view.findViewById(i.f.vote_card_layout)).inflate();
                    this.diR = (TextView) this.diN.findViewById(i.f.btn_pb_vote);
                    this.diS = this.diN.findViewById(i.f.vote_top_line);
                    this.diT = this.diN.findViewById(i.f.vote_middle_line);
                    tc();
                    this.diU = bVar.aeM();
                    a(this.diU, false);
                }
                if (!this.diN.isShown()) {
                    this.diN.setVisibility(0);
                }
            } else if (this.diN != null && this.diN.isShown()) {
                this.diN.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.diU = voteDataInfo;
        if (this.diU != null) {
            aAB();
            if (this.diU.getVoteType() == 1) {
                if (this.diU.getStatus() == 2 || this.diU.getIsPolled() == 1) {
                    gP(z);
                } else {
                    aAC();
                }
            } else if (this.diU.getVoteType() == 2) {
                if (this.diU.getStatus() == 2 || this.diU.getIsPolled() == 1) {
                    s(2, z);
                } else {
                    s(this.diU.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void s(int i, boolean z) {
        if (this.diN != null && this.diU != null) {
            this.diO = (VotePhotoGroupView) this.diN.findViewById(i.f.picvote_view);
            this.diO.setOnVoteCheckedChangedListener(this.aCE);
            this.diO.setVisibility(0);
            this.diO.setMode(i);
            this.diO.setData(this.diU.getOptions(), z);
            if (this.diS != null) {
                this.diS.setVisibility(8);
            }
            if (this.diT != null) {
                this.diT.setVisibility(8);
            }
        }
    }

    private void aAB() {
        if (this.diN != null && this.diU != null) {
            ((TextView) this.diN.findViewById(i.f.tv_vote_endtime)).setText(this.diU.getTips());
            ((TextView) this.diN.findViewById(i.f.vote_num)).setText(getPageContext().getPageActivity().getString(i.h.pb_vote_num, new Object[]{Long.valueOf(this.diU.getTotalNum())}));
            aAE();
        }
    }

    private void aAC() {
        if (this.diN != null && this.diU != null) {
            this.diP = (VoteTextGroupView) this.diN.findViewById(i.f.textvote_view);
            this.diP.setOnVoteCheckedChangedListener(this.aCE);
            this.diP.setVisibility(0);
            this.diP.setMode(this.diU.getIsMulti() == 1 ? 1 : 2);
            this.diP.t(this.diU.getOptions());
            this.diP.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void gP(boolean z) {
        if (this.diN != null && this.diU != null) {
            this.diO = (VotePhotoGroupView) this.diN.findViewById(i.f.picvote_view);
            this.diP = (VoteTextGroupView) this.diN.findViewById(i.f.textvote_view);
            this.diQ = (VoteView) this.diN.findViewById(i.f.result_vote_view);
            this.diP.setVisibility(8);
            this.diO.setVisibility(8);
            this.diQ.setVisibility(0);
            this.diQ.setWidth(this.maxWidth);
            this.diQ.b(this.diU.getOptions(), z);
            this.diQ.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAD() {
        if (this.diU != null) {
            if (this.diX != null && this.ciJ != null) {
                this.diX.dA(this.ciJ.getActivity().getString(i.h.vote_succ));
            }
            this.diU.setIsPolled(1);
            this.diU.setTotalNum(this.diU.getTotalNum() + 1);
            this.diU.setTotalPoll(this.diU.getTotalPoll() + this.diV.size());
            for (f fVar : this.diV) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.diU.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.diU.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.lD((int) ((fVar2.getNum() * 100) / this.diU.getTotalPoll()));
                    }
                }
            }
            a(this.diU, true);
            this.diV.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tc() {
        if (this.diN != null) {
            com.baidu.tbadk.h.a.a(this.ciJ.getPageContext(), this.diN);
        }
        aAE();
    }

    private void aAE() {
        if (this.diR != null && this.diU != null) {
            if (this.diU.getStatus() == 2) {
                am.i((View) this.diR, i.e.btn_pb_vote_d);
                this.diR.setText(getPageContext().getString(i.h.pb_vote_over));
                am.b(this.diR, i.c.cp_cont_d, 1);
                this.diR.setEnabled(false);
            } else if (this.diU.getIsPolled() == 1) {
                am.i((View) this.diR, i.e.btn_pb_vote_d);
                this.diR.setText(getPageContext().getString(i.h.pb_voted));
                am.b(this.diR, i.c.cp_cont_d, 1);
                this.diR.setEnabled(false);
            } else if (this.diU.getIsPolled() == 0) {
                am.i((View) this.diR, i.e.btn_pb_vote_selector);
                this.diR.setText(getPageContext().getString(i.h.pb_vote_add));
                am.b(this.diR, i.c.cp_cont_g, 1);
                this.diR.setEnabled(true);
                this.diR.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
