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
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aHm;
    private PbActivity eat;
    private View fOf;
    private VotePhotoGroupView fOg;
    private VoteTextGroupView fOh;
    private VoteView fOi;
    private TextView fOj;
    private View fOk;
    private View fOl;
    private VoteDataInfo fOm;
    private final List<f> fOn;
    private boolean fOo;
    private h fOp;
    private final com.baidu.adp.framework.listener.a fOq;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fOf != null) {
            this.fOf.setVisibility(i);
        }
    }

    public void bmE() {
        if (this.fOg != null) {
            this.fOg.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fOn = new ArrayList();
        this.fOo = false;
        this.maxWidth = 0;
        this.aHm = new c(this);
        this.fOq = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.eat = pbActivity;
        pbActivity.registerListener(this.fOq);
        this.maxWidth = k.A(TbadkCoreApplication.m10getInst()) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds120);
        this.fOp = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aGX() != null && hVar.aGY() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(hVar.aGX().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(hVar.aGY().getId(), 0L);
            if (hVar.aGY().rg() && hVar.aGY().qo() != null) {
                if (this.fOf == null) {
                    this.fOf = ((ViewStub) view.findViewById(u.g.vote_card_layout)).inflate();
                    this.fOj = (TextView) this.fOf.findViewById(u.g.btn_pb_vote);
                    this.fOk = this.fOf.findViewById(u.g.vote_top_line);
                    this.fOl = this.fOf.findViewById(u.g.vote_middle_line);
                    this.fOm = hVar.aGW();
                    a(this.fOm, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m10getInst().getSkinType()) {
                    sd();
                }
                this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
                if (!this.fOf.isShown()) {
                    this.fOf.setVisibility(0);
                }
            } else if (this.fOf != null && this.fOf.isShown()) {
                this.fOf.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fOm = voteDataInfo;
        if (this.fOm != null) {
            agb();
            if (this.fOm.getVoteType() == 1) {
                if (this.fOm.getStatus() == 2 || this.fOm.getIsPolled() == 1) {
                    lo(z);
                } else {
                    bmF();
                }
            } else if (this.fOm.getVoteType() == 2) {
                if (this.fOm.getStatus() == 2 || this.fOm.getIsPolled() == 1) {
                    S(2, z);
                } else {
                    S(this.fOm.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void S(int i, boolean z) {
        if (this.fOf != null && this.fOm != null) {
            this.fOg = (VotePhotoGroupView) this.fOf.findViewById(u.g.picvote_view);
            this.fOg.setOnVoteCheckedChangedListener(this.aHm);
            this.fOg.setVisibility(0);
            this.fOg.setMode(i);
            this.fOg.setData(this.fOm.getOptions(), z);
            if (this.fOk != null) {
                this.fOk.setVisibility(8);
            }
            if (this.fOl != null) {
                this.fOl.setVisibility(8);
            }
        }
    }

    private void agb() {
        if (this.fOf != null && this.fOm != null) {
            ((TextView) this.fOf.findViewById(u.g.tv_vote_endtime)).setText(this.fOm.getTips());
            ((TextView) this.fOf.findViewById(u.g.vote_num)).setText(getPageContext().getPageActivity().getString(u.j.pb_vote_num, new Object[]{Long.valueOf(this.fOm.getTotalNum())}));
            bmH();
        }
    }

    private void bmF() {
        if (this.fOf != null && this.fOm != null) {
            this.fOh = (VoteTextGroupView) this.fOf.findViewById(u.g.textvote_view);
            this.fOh.setOnVoteCheckedChangedListener(this.aHm);
            this.fOh.setVisibility(0);
            this.fOh.setMode(this.fOm.getIsMulti() == 1 ? 1 : 2);
            this.fOh.E(this.fOm.getOptions());
            this.fOh.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    private void lo(boolean z) {
        if (this.fOf != null && this.fOm != null) {
            this.fOg = (VotePhotoGroupView) this.fOf.findViewById(u.g.picvote_view);
            this.fOh = (VoteTextGroupView) this.fOf.findViewById(u.g.textvote_view);
            this.fOi = (VoteView) this.fOf.findViewById(u.g.result_vote_view);
            this.fOh.setVisibility(8);
            this.fOg.setVisibility(8);
            this.fOi.setVisibility(0);
            this.fOi.setWidth(this.maxWidth);
            this.fOi.a(this.fOm.getOptions(), z);
            this.fOi.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmG() {
        if (this.fOm != null) {
            if (this.fOp != null && this.eat != null) {
                this.fOp.c(this.eat.getActivity().getString(u.j.vote_succ));
            }
            this.fOm.setIsPolled(1);
            this.fOm.setTotalNum(this.fOm.getTotalNum() + 1);
            this.fOm.setTotalPoll(this.fOm.getTotalPoll() + this.fOn.size());
            for (f fVar : this.fOn) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fOm.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fOm.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.setPercent((int) ((fVar2.getNum() * 100) / this.fOm.getTotalPoll()));
                    }
                }
            }
            a(this.fOm, true);
            this.fOn.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void sd() {
        if (this.fOf != null) {
            com.baidu.tbadk.j.a.a(this.eat.getPageContext(), this.fOf);
        }
        bmH();
    }

    private void bmH() {
        if (this.fOj != null && this.fOm != null) {
            if (this.fOm.getStatus() == 2) {
                av.k(this.fOj, u.f.btn_pb_vote_d);
                this.fOj.setText(getPageContext().getString(u.j.pb_vote_over));
                av.c(this.fOj, u.d.cp_cont_d, 1);
                this.fOj.setEnabled(false);
            } else if (this.fOm.getIsPolled() == 1) {
                av.k(this.fOj, u.f.btn_pb_vote_d);
                this.fOj.setText(getPageContext().getString(u.j.pb_voted));
                av.c(this.fOj, u.d.cp_cont_d, 1);
                this.fOj.setEnabled(false);
            } else if (this.fOm.getIsPolled() == 0) {
                av.k(this.fOj, u.f.btn_pb_vote_selector);
                this.fOj.setText(getPageContext().getString(u.j.pb_vote_add));
                av.c(this.fOj, u.d.cp_cont_g, 1);
                this.fOj.setEnabled(true);
                this.fOj.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
