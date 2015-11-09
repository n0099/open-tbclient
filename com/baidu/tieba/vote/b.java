package com.baidu.tieba.vote;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aBJ;
    private PbActivity cjZ;
    private View dkT;
    private VotePhotoGroupView dkU;
    private VoteTextGroupView dkV;
    private VoteView dkW;
    private TextView dkX;
    private View dkY;
    private View dkZ;
    private VoteDataInfo dla;
    private final List<f> dlb;
    private boolean dlc;
    private com.baidu.tbadk.core.view.f dld;
    private final com.baidu.adp.framework.listener.a dle;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.dkT != null) {
            this.dkT.setVisibility(i);
        }
    }

    public void aBw() {
        if (this.dkU != null) {
            this.dkU.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.dlb = new ArrayList();
        this.dlc = false;
        this.maxWidth = 0;
        this.aBJ = new c(this);
        this.dle = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.cjZ = pbActivity;
        pbActivity.registerListener(this.dle);
        this.maxWidth = k.K(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
        this.dld = new com.baidu.tbadk.core.view.f(this.cjZ.getPageContext());
    }

    public void a(View view, com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null && cVar.afg() != null && cVar.afh() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(cVar.afg().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(cVar.afh().getId(), 0L);
            if (cVar.afh().sB() && cVar.afh().sg() != null) {
                if (this.dkT == null) {
                    this.dkT = ((ViewStub) view.findViewById(i.f.vote_card_layout)).inflate();
                    this.dkX = (TextView) this.dkT.findViewById(i.f.btn_pb_vote);
                    this.dkY = this.dkT.findViewById(i.f.vote_top_line);
                    this.dkZ = this.dkT.findViewById(i.f.vote_middle_line);
                    tc();
                    this.dla = cVar.aff();
                    a(this.dla, false);
                }
                if (!this.dkT.isShown()) {
                    this.dkT.setVisibility(0);
                }
            } else if (this.dkT != null && this.dkT.isShown()) {
                this.dkT.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.dla = voteDataInfo;
        if (this.dla != null) {
            aBx();
            if (this.dla.getVoteType() == 1) {
                if (this.dla.getStatus() == 2 || this.dla.getIsPolled() == 1) {
                    gS(z);
                } else {
                    aBy();
                }
            } else if (this.dla.getVoteType() == 2) {
                if (this.dla.getStatus() == 2 || this.dla.getIsPolled() == 1) {
                    s(2, z);
                } else {
                    s(this.dla.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void s(int i, boolean z) {
        if (this.dkT != null && this.dla != null) {
            this.dkU = (VotePhotoGroupView) this.dkT.findViewById(i.f.picvote_view);
            this.dkU.setOnVoteCheckedChangedListener(this.aBJ);
            this.dkU.setVisibility(0);
            this.dkU.setMode(i);
            this.dkU.setData(this.dla.getOptions(), z);
            if (this.dkY != null) {
                this.dkY.setVisibility(8);
            }
            if (this.dkZ != null) {
                this.dkZ.setVisibility(8);
            }
        }
    }

    private void aBx() {
        if (this.dkT != null && this.dla != null) {
            ((TextView) this.dkT.findViewById(i.f.tv_vote_endtime)).setText(this.dla.getTips());
            ((TextView) this.dkT.findViewById(i.f.vote_num)).setText(getPageContext().getPageActivity().getString(i.h.pb_vote_num, new Object[]{Long.valueOf(this.dla.getTotalNum())}));
            aBA();
        }
    }

    private void aBy() {
        if (this.dkT != null && this.dla != null) {
            this.dkV = (VoteTextGroupView) this.dkT.findViewById(i.f.textvote_view);
            this.dkV.setOnVoteCheckedChangedListener(this.aBJ);
            this.dkV.setVisibility(0);
            this.dkV.setMode(this.dla.getIsMulti() == 1 ? 1 : 2);
            this.dkV.u(this.dla.getOptions());
            this.dkV.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void gS(boolean z) {
        if (this.dkT != null && this.dla != null) {
            this.dkU = (VotePhotoGroupView) this.dkT.findViewById(i.f.picvote_view);
            this.dkV = (VoteTextGroupView) this.dkT.findViewById(i.f.textvote_view);
            this.dkW = (VoteView) this.dkT.findViewById(i.f.result_vote_view);
            this.dkV.setVisibility(8);
            this.dkU.setVisibility(8);
            this.dkW.setVisibility(0);
            this.dkW.setWidth(this.maxWidth);
            this.dkW.b(this.dla.getOptions(), z);
            this.dkW.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBz() {
        if (this.dla != null) {
            if (this.dld != null && this.cjZ != null) {
                this.dld.dA(this.cjZ.getActivity().getString(i.h.vote_succ));
            }
            this.dla.setIsPolled(1);
            this.dla.setTotalNum(this.dla.getTotalNum() + 1);
            this.dla.setTotalPoll(this.dla.getTotalPoll() + this.dlb.size());
            for (f fVar : this.dlb) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.dla.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.dla.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.lT((int) ((fVar2.getNum() * 100) / this.dla.getTotalPoll()));
                    }
                }
            }
            a(this.dla, true);
            this.dlb.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tc() {
        if (this.dkT != null) {
            com.baidu.tbadk.h.a.a(this.cjZ.getPageContext(), this.dkT);
        }
        aBA();
    }

    private void aBA() {
        if (this.dkX != null && this.dla != null) {
            if (this.dla.getStatus() == 2) {
                an.i((View) this.dkX, i.e.btn_pb_vote_d);
                this.dkX.setText(getPageContext().getString(i.h.pb_vote_over));
                an.b(this.dkX, i.c.cp_cont_d, 1);
                this.dkX.setEnabled(false);
            } else if (this.dla.getIsPolled() == 1) {
                an.i((View) this.dkX, i.e.btn_pb_vote_d);
                this.dkX.setText(getPageContext().getString(i.h.pb_voted));
                an.b(this.dkX, i.c.cp_cont_d, 1);
                this.dkX.setEnabled(false);
            } else if (this.dla.getIsPolled() == 0) {
                an.i((View) this.dkX, i.e.btn_pb_vote_selector);
                this.dkX.setText(getPageContext().getString(i.h.pb_vote_add));
                an.b(this.dkX, i.c.cp_cont_g, 1);
                this.dkX.setEnabled(true);
                this.dkX.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
