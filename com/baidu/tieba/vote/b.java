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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aKb;
    private PbActivity eow;
    private View fYY;
    private VotePhotoGroupView fYZ;
    private VoteTextGroupView fZa;
    private VoteView fZb;
    private TextView fZc;
    private View fZd;
    private View fZe;
    private VoteDataInfo fZf;
    private final List<f> fZg;
    private boolean fZh;
    private h fZi;
    private final com.baidu.adp.framework.listener.a fZj;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fYY != null) {
            this.fYY.setVisibility(i);
        }
    }

    public void bqZ() {
        if (this.fYZ != null) {
            this.fYZ.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fZg = new ArrayList();
        this.fZh = false;
        this.maxWidth = 0;
        this.aKb = new c(this);
        this.fZj = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.eow = pbActivity;
        pbActivity.registerListener(this.fZj);
        this.maxWidth = k.K(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds120);
        this.fZi = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aMr() != null && hVar.aMs() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(hVar.aMr().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(hVar.aMs().getId(), 0L);
            if (hVar.aMs().sy() && hVar.aMs().rE() != null) {
                if (this.fYY == null) {
                    this.fYY = ((ViewStub) view.findViewById(r.g.vote_card_layout)).inflate();
                    this.fZc = (TextView) this.fYY.findViewById(r.g.btn_pb_vote);
                    this.fZd = this.fYY.findViewById(r.g.vote_top_line);
                    this.fZe = this.fYY.findViewById(r.g.vote_middle_line);
                    this.fZf = hVar.aMq();
                    a(this.fZf, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    tx();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fYY.isShown()) {
                    this.fYY.setVisibility(0);
                }
            } else if (this.fYY != null && this.fYY.isShown()) {
                this.fYY.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fZf = voteDataInfo;
        if (this.fZf != null) {
            if (this.fZf.getStatus() == 2 || this.fZf.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fZf.getOptions()) {
                    if (aVar != null && (aVar instanceof f)) {
                        ((f) aVar).setSelected(false);
                    }
                }
            }
            ala();
            if (this.fZf.getVoteType() == 1) {
                if (this.fZf.getStatus() == 2 || this.fZf.getIsPolled() == 1) {
                    lD(z);
                } else {
                    bra();
                }
            } else if (this.fZf.getVoteType() == 2) {
                if (this.fZf.getStatus() == 2 || this.fZf.getIsPolled() == 1) {
                    U(2, z);
                } else {
                    U(this.fZf.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void U(int i, boolean z) {
        if (this.fYY != null && this.fZf != null) {
            this.fYZ = (VotePhotoGroupView) this.fYY.findViewById(r.g.picvote_view);
            this.fYZ.setOnVoteCheckedChangedListener(this.aKb);
            this.fYZ.setVisibility(0);
            this.fYZ.setMode(i);
            this.fYZ.a(this.fZf.getOptions(), z, this.fZf.getIsPolled() == 1);
            if (this.fZd != null) {
                this.fZd.setVisibility(8);
            }
            if (this.fZe != null) {
                this.fZe.setVisibility(8);
            }
        }
    }

    private void ala() {
        if (this.fYY != null && this.fZf != null) {
            ((TextView) this.fYY.findViewById(r.g.tv_vote_endtime)).setText(this.fZf.getTips());
            ((TextView) this.fYY.findViewById(r.g.vote_num)).setText(getPageContext().getPageActivity().getString(r.j.pb_vote_num, new Object[]{Long.valueOf(this.fZf.getTotalNum())}));
            brc();
        }
    }

    private void bra() {
        if (this.fYY != null && this.fZf != null) {
            this.fZa = (VoteTextGroupView) this.fYY.findViewById(r.g.textvote_view);
            this.fZa.setOnVoteCheckedChangedListener(this.aKb);
            this.fZa.setVisibility(0);
            this.fZa.setMode(this.fZf.getIsMulti() == 1 ? 1 : 2);
            this.fZa.E(this.fZf.getOptions());
            this.fZa.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void lD(boolean z) {
        if (this.fYY != null && this.fZf != null) {
            this.fYZ = (VotePhotoGroupView) this.fYY.findViewById(r.g.picvote_view);
            this.fZa = (VoteTextGroupView) this.fYY.findViewById(r.g.textvote_view);
            this.fZb = (VoteView) this.fYY.findViewById(r.g.result_vote_view);
            this.fZa.setVisibility(8);
            this.fYZ.setVisibility(8);
            this.fZb.setVisibility(0);
            this.fZb.setWidth(this.maxWidth);
            this.fZb.a(this.fZf.getOptions(), z);
            this.fZb.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brb() {
        if (this.fZf != null) {
            if (this.fZi != null && this.eow != null) {
                this.fZi.c(this.eow.getActivity().getString(r.j.vote_succ));
            }
            this.fZf.setIsPolled(1);
            this.fZf.setTotalNum(this.fZf.getTotalNum() + 1);
            this.fZf.setTotalPoll(this.fZf.getTotalPoll() + this.fZg.size());
            for (f fVar : this.fZg) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fZf.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fZf.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.setPercent((int) ((fVar2.getNum() * 100) / this.fZf.getTotalPoll()));
                    }
                }
            }
            a(this.fZf, true);
            this.fZg.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tx() {
        if (this.fYY != null) {
            com.baidu.tbadk.i.a.a(this.eow.getPageContext(), this.fYY);
        }
        brc();
    }

    private void brc() {
        if (this.fZc != null && this.fZf != null) {
            if (this.fZf.getStatus() == 2) {
                av.k(this.fZc, r.f.btn_pb_vote_d);
                this.fZc.setText(getPageContext().getString(r.j.pb_vote_over));
                av.c(this.fZc, r.d.cp_cont_d, 1);
                this.fZc.setEnabled(false);
            } else if (this.fZf.getIsPolled() == 1) {
                av.k(this.fZc, r.f.btn_pb_vote_d);
                this.fZc.setText(getPageContext().getString(r.j.pb_voted));
                av.c(this.fZc, r.d.cp_cont_d, 1);
                this.fZc.setEnabled(false);
            } else if (this.fZf.getIsPolled() == 0) {
                av.k(this.fZc, r.f.btn_pb_vote_selector);
                this.fZc.setText(getPageContext().getString(r.j.pb_vote_add));
                av.c(this.fZc, r.d.cp_cont_g, 1);
                this.fZc.setEnabled(true);
                this.fZc.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
