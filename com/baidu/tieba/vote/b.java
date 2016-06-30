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
    private com.baidu.tbadk.widget.vote.b aGv;
    private PbActivity dOg;
    private View fBe;
    private VotePhotoGroupView fBf;
    private VoteTextGroupView fBg;
    private VoteView fBh;
    private TextView fBi;
    private View fBj;
    private View fBk;
    private VoteDataInfo fBl;
    private final List<f> fBm;
    private boolean fBn;
    private h fBo;
    private final com.baidu.adp.framework.listener.a fBp;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fBe != null) {
            this.fBe.setVisibility(i);
        }
    }

    public void bjp() {
        if (this.fBf != null) {
            this.fBf.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fBm = new ArrayList();
        this.fBn = false;
        this.maxWidth = 0;
        this.aGv = new c(this);
        this.fBp = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.dOg = pbActivity;
        pbActivity.registerListener(this.fBp);
        this.maxWidth = k.A(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds120);
        this.fBo = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.h hVar) {
        if (hVar != null && hVar.aDN() != null && hVar.aDO() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(hVar.aDN().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(hVar.aDO().getId(), 0L);
            if (hVar.aDO().ri() && hVar.aDO().qF() != null) {
                if (this.fBe == null) {
                    this.fBe = ((ViewStub) view.findViewById(u.g.vote_card_layout)).inflate();
                    this.fBi = (TextView) this.fBe.findViewById(u.g.btn_pb_vote);
                    this.fBj = this.fBe.findViewById(u.g.vote_top_line);
                    this.fBk = this.fBe.findViewById(u.g.vote_middle_line);
                    this.fBl = hVar.aDM();
                    a(this.fBl, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    se();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fBe.isShown()) {
                    this.fBe.setVisibility(0);
                }
            } else if (this.fBe != null && this.fBe.isShown()) {
                this.fBe.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fBl = voteDataInfo;
        if (this.fBl != null) {
            afy();
            if (this.fBl.getVoteType() == 1) {
                if (this.fBl.getStatus() == 2 || this.fBl.getIsPolled() == 1) {
                    la(z);
                } else {
                    bjq();
                }
            } else if (this.fBl.getVoteType() == 2) {
                if (this.fBl.getStatus() == 2 || this.fBl.getIsPolled() == 1) {
                    O(2, z);
                } else {
                    O(this.fBl.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void O(int i, boolean z) {
        if (this.fBe != null && this.fBl != null) {
            this.fBf = (VotePhotoGroupView) this.fBe.findViewById(u.g.picvote_view);
            this.fBf.setOnVoteCheckedChangedListener(this.aGv);
            this.fBf.setVisibility(0);
            this.fBf.setMode(i);
            this.fBf.setData(this.fBl.getOptions(), z);
            if (this.fBj != null) {
                this.fBj.setVisibility(8);
            }
            if (this.fBk != null) {
                this.fBk.setVisibility(8);
            }
        }
    }

    private void afy() {
        if (this.fBe != null && this.fBl != null) {
            ((TextView) this.fBe.findViewById(u.g.tv_vote_endtime)).setText(this.fBl.getTips());
            ((TextView) this.fBe.findViewById(u.g.vote_num)).setText(getPageContext().getPageActivity().getString(u.j.pb_vote_num, new Object[]{Long.valueOf(this.fBl.getTotalNum())}));
            bjs();
        }
    }

    private void bjq() {
        if (this.fBe != null && this.fBl != null) {
            this.fBg = (VoteTextGroupView) this.fBe.findViewById(u.g.textvote_view);
            this.fBg.setOnVoteCheckedChangedListener(this.aGv);
            this.fBg.setVisibility(0);
            this.fBg.setMode(this.fBl.getIsMulti() == 1 ? 1 : 2);
            this.fBg.E(this.fBl.getOptions());
            this.fBg.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void la(boolean z) {
        if (this.fBe != null && this.fBl != null) {
            this.fBf = (VotePhotoGroupView) this.fBe.findViewById(u.g.picvote_view);
            this.fBg = (VoteTextGroupView) this.fBe.findViewById(u.g.textvote_view);
            this.fBh = (VoteView) this.fBe.findViewById(u.g.result_vote_view);
            this.fBg.setVisibility(8);
            this.fBf.setVisibility(8);
            this.fBh.setVisibility(0);
            this.fBh.setWidth(this.maxWidth);
            this.fBh.a(this.fBl.getOptions(), z);
            this.fBh.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjr() {
        if (this.fBl != null) {
            if (this.fBo != null && this.dOg != null) {
                this.fBo.c(this.dOg.getActivity().getString(u.j.vote_succ));
            }
            this.fBl.setIsPolled(1);
            this.fBl.setTotalNum(this.fBl.getTotalNum() + 1);
            this.fBl.setTotalPoll(this.fBl.getTotalPoll() + this.fBm.size());
            for (f fVar : this.fBm) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fBl.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fBl.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.setPercent((int) ((fVar2.getNum() * 100) / this.fBl.getTotalPoll()));
                    }
                }
            }
            a(this.fBl, true);
            this.fBm.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void se() {
        if (this.fBe != null) {
            com.baidu.tbadk.j.a.a(this.dOg.getPageContext(), this.fBe);
        }
        bjs();
    }

    private void bjs() {
        if (this.fBi != null && this.fBl != null) {
            if (this.fBl.getStatus() == 2) {
                av.k(this.fBi, u.f.btn_pb_vote_d);
                this.fBi.setText(getPageContext().getString(u.j.pb_vote_over));
                av.c(this.fBi, u.d.cp_cont_d, 1);
                this.fBi.setEnabled(false);
            } else if (this.fBl.getIsPolled() == 1) {
                av.k(this.fBi, u.f.btn_pb_vote_d);
                this.fBi.setText(getPageContext().getString(u.j.pb_voted));
                av.c(this.fBi, u.d.cp_cont_d, 1);
                this.fBi.setEnabled(false);
            } else if (this.fBl.getIsPolled() == 0) {
                av.k(this.fBi, u.f.btn_pb_vote_selector);
                this.fBi.setText(getPageContext().getString(u.j.pb_vote_add));
                av.c(this.fBi, u.d.cp_cont_g, 1);
                this.fBi.setEnabled(true);
                this.fBi.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
