package com.baidu.tieba.vote;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aEv;
    private PbActivity cCy;
    private View dJG;
    private VotePhotoGroupView dJH;
    private VoteTextGroupView dJI;
    private VoteView dJJ;
    private TextView dJK;
    private View dJL;
    private View dJM;
    private VoteDataInfo dJN;
    private final List<f> dJO;
    private boolean dJP;
    private g dJQ;
    private final com.baidu.adp.framework.listener.a dJR;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.dJG != null) {
            this.dJG.setVisibility(i);
        }
    }

    public void aGS() {
        if (this.dJH != null) {
            this.dJH.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.dJO = new ArrayList();
        this.dJP = false;
        this.maxWidth = 0;
        this.aEv = new c(this);
        this.dJR = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.cCy = pbActivity;
        pbActivity.registerListener(this.dJR);
        this.maxWidth = k.K(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds60);
        this.dJQ = new g(this.cCy.getPageContext());
    }

    public void a(View view, com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null && cVar.ajy() != null && cVar.ajz() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(cVar.ajy().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(cVar.ajz().getId(), 0L);
            if (cVar.ajz().tc() && cVar.ajz().sH() != null) {
                if (this.dJG == null) {
                    this.dJG = ((ViewStub) view.findViewById(n.f.vote_card_layout)).inflate();
                    this.dJK = (TextView) this.dJG.findViewById(n.f.btn_pb_vote);
                    this.dJL = this.dJG.findViewById(n.f.vote_top_line);
                    this.dJM = this.dJG.findViewById(n.f.vote_middle_line);
                    tH();
                    this.dJN = cVar.ajx();
                    a(this.dJN, false);
                }
                if (!this.dJG.isShown()) {
                    this.dJG.setVisibility(0);
                }
            } else if (this.dJG != null && this.dJG.isShown()) {
                this.dJG.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.dJN = voteDataInfo;
        if (this.dJN != null) {
            aGT();
            if (this.dJN.getVoteType() == 1) {
                if (this.dJN.getStatus() == 2 || this.dJN.getIsPolled() == 1) {
                    hA(z);
                } else {
                    aGU();
                }
            } else if (this.dJN.getVoteType() == 2) {
                if (this.dJN.getStatus() == 2 || this.dJN.getIsPolled() == 1) {
                    t(2, z);
                } else {
                    t(this.dJN.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void t(int i, boolean z) {
        if (this.dJG != null && this.dJN != null) {
            this.dJH = (VotePhotoGroupView) this.dJG.findViewById(n.f.picvote_view);
            this.dJH.setOnVoteCheckedChangedListener(this.aEv);
            this.dJH.setVisibility(0);
            this.dJH.setMode(i);
            this.dJH.setData(this.dJN.getOptions(), z);
            if (this.dJL != null) {
                this.dJL.setVisibility(8);
            }
            if (this.dJM != null) {
                this.dJM.setVisibility(8);
            }
        }
    }

    private void aGT() {
        if (this.dJG != null && this.dJN != null) {
            ((TextView) this.dJG.findViewById(n.f.tv_vote_endtime)).setText(this.dJN.getTips());
            ((TextView) this.dJG.findViewById(n.f.vote_num)).setText(getPageContext().getPageActivity().getString(n.i.pb_vote_num, new Object[]{Long.valueOf(this.dJN.getTotalNum())}));
            aGW();
        }
    }

    private void aGU() {
        if (this.dJG != null && this.dJN != null) {
            this.dJI = (VoteTextGroupView) this.dJG.findViewById(n.f.textvote_view);
            this.dJI.setOnVoteCheckedChangedListener(this.aEv);
            this.dJI.setVisibility(0);
            this.dJI.setMode(this.dJN.getIsMulti() == 1 ? 1 : 2);
            this.dJI.t(this.dJN.getOptions());
            this.dJI.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void hA(boolean z) {
        if (this.dJG != null && this.dJN != null) {
            this.dJH = (VotePhotoGroupView) this.dJG.findViewById(n.f.picvote_view);
            this.dJI = (VoteTextGroupView) this.dJG.findViewById(n.f.textvote_view);
            this.dJJ = (VoteView) this.dJG.findViewById(n.f.result_vote_view);
            this.dJI.setVisibility(8);
            this.dJH.setVisibility(8);
            this.dJJ.setVisibility(0);
            this.dJJ.setWidth(this.maxWidth);
            this.dJJ.b(this.dJN.getOptions(), z);
            this.dJJ.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGV() {
        if (this.dJN != null) {
            if (this.dJQ != null && this.cCy != null) {
                this.dJQ.d(this.cCy.getActivity().getString(n.i.vote_succ));
            }
            this.dJN.setIsPolled(1);
            this.dJN.setTotalNum(this.dJN.getTotalNum() + 1);
            this.dJN.setTotalPoll(this.dJN.getTotalPoll() + this.dJO.size());
            for (f fVar : this.dJO) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.dJN.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.dJN.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.nf((int) ((fVar2.getNum() * 100) / this.dJN.getTotalPoll()));
                    }
                }
            }
            a(this.dJN, true);
            this.dJO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tH() {
        if (this.dJG != null) {
            com.baidu.tbadk.i.a.a(this.cCy.getPageContext(), this.dJG);
        }
        aGW();
    }

    private void aGW() {
        if (this.dJK != null && this.dJN != null) {
            if (this.dJN.getStatus() == 2) {
                as.i((View) this.dJK, n.e.btn_pb_vote_d);
                this.dJK.setText(getPageContext().getString(n.i.pb_vote_over));
                as.b(this.dJK, n.c.cp_cont_d, 1);
                this.dJK.setEnabled(false);
            } else if (this.dJN.getIsPolled() == 1) {
                as.i((View) this.dJK, n.e.btn_pb_vote_d);
                this.dJK.setText(getPageContext().getString(n.i.pb_voted));
                as.b(this.dJK, n.c.cp_cont_d, 1);
                this.dJK.setEnabled(false);
            } else if (this.dJN.getIsPolled() == 0) {
                as.i((View) this.dJK, n.e.btn_pb_vote_selector);
                this.dJK.setText(getPageContext().getString(n.i.pb_vote_add));
                as.b(this.dJK, n.c.cp_cont_g, 1);
                this.dJK.setEnabled(true);
                this.dJK.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
