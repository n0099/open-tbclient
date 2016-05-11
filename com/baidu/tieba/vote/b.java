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
    private com.baidu.tbadk.widget.vote.b aFT;
    private PbActivity dhY;
    private boolean eWA;
    private h eWB;
    private final com.baidu.adp.framework.listener.a eWC;
    private View eWr;
    private VotePhotoGroupView eWs;
    private VoteTextGroupView eWt;
    private VoteView eWu;
    private TextView eWv;
    private View eWw;
    private View eWx;
    private VoteDataInfo eWy;
    private final List<f> eWz;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.eWr != null) {
            this.eWr.setVisibility(i);
        }
    }

    public void baU() {
        if (this.eWs != null) {
            this.eWs.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.eWz = new ArrayList();
        this.eWA = false;
        this.maxWidth = 0;
        this.aFT = new c(this);
        this.eWC = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.dhY = pbActivity;
        pbActivity.registerListener(this.eWC);
        this.maxWidth = k.B(TbadkCoreApplication.m11getInst()) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60);
        this.eWB = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.avA() != null && eVar.avB() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(eVar.avA().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(eVar.avB().getId(), 0L);
            if (eVar.avB().rl() && eVar.avB().qL() != null) {
                if (this.eWr == null) {
                    this.eWr = ((ViewStub) view.findViewById(t.g.vote_card_layout)).inflate();
                    this.eWv = (TextView) this.eWr.findViewById(t.g.btn_pb_vote);
                    this.eWw = this.eWr.findViewById(t.g.vote_top_line);
                    this.eWx = this.eWr.findViewById(t.g.vote_middle_line);
                    this.eWy = eVar.avz();
                    a(this.eWy, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m11getInst().getSkinType()) {
                    sf();
                }
                this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
                if (!this.eWr.isShown()) {
                    this.eWr.setVisibility(0);
                }
            } else if (this.eWr != null && this.eWr.isShown()) {
                this.eWr.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.eWy = voteDataInfo;
        if (this.eWy != null) {
            YY();
            if (this.eWy.getVoteType() == 1) {
                if (this.eWy.getStatus() == 2 || this.eWy.getIsPolled() == 1) {
                    kq(z);
                } else {
                    baV();
                }
            } else if (this.eWy.getVoteType() == 2) {
                if (this.eWy.getStatus() == 2 || this.eWy.getIsPolled() == 1) {
                    A(2, z);
                } else {
                    A(this.eWy.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void A(int i, boolean z) {
        if (this.eWr != null && this.eWy != null) {
            this.eWs = (VotePhotoGroupView) this.eWr.findViewById(t.g.picvote_view);
            this.eWs.setOnVoteCheckedChangedListener(this.aFT);
            this.eWs.setVisibility(0);
            this.eWs.setMode(i);
            this.eWs.setData(this.eWy.getOptions(), z);
            if (this.eWw != null) {
                this.eWw.setVisibility(8);
            }
            if (this.eWx != null) {
                this.eWx.setVisibility(8);
            }
        }
    }

    private void YY() {
        if (this.eWr != null && this.eWy != null) {
            ((TextView) this.eWr.findViewById(t.g.tv_vote_endtime)).setText(this.eWy.getTips());
            ((TextView) this.eWr.findViewById(t.g.vote_num)).setText(getPageContext().getPageActivity().getString(t.j.pb_vote_num, new Object[]{Long.valueOf(this.eWy.getTotalNum())}));
            baX();
        }
    }

    private void baV() {
        if (this.eWr != null && this.eWy != null) {
            this.eWt = (VoteTextGroupView) this.eWr.findViewById(t.g.textvote_view);
            this.eWt.setOnVoteCheckedChangedListener(this.aFT);
            this.eWt.setVisibility(0);
            this.eWt.setMode(this.eWy.getIsMulti() == 1 ? 1 : 2);
            this.eWt.D(this.eWy.getOptions());
            this.eWt.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    private void kq(boolean z) {
        if (this.eWr != null && this.eWy != null) {
            this.eWs = (VotePhotoGroupView) this.eWr.findViewById(t.g.picvote_view);
            this.eWt = (VoteTextGroupView) this.eWr.findViewById(t.g.textvote_view);
            this.eWu = (VoteView) this.eWr.findViewById(t.g.result_vote_view);
            this.eWt.setVisibility(8);
            this.eWs.setVisibility(8);
            this.eWu.setVisibility(0);
            this.eWu.setWidth(this.maxWidth);
            this.eWu.a(this.eWy.getOptions(), z);
            this.eWu.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baW() {
        if (this.eWy != null) {
            if (this.eWB != null && this.dhY != null) {
                this.eWB.c(this.dhY.getActivity().getString(t.j.vote_succ));
            }
            this.eWy.setIsPolled(1);
            this.eWy.setTotalNum(this.eWy.getTotalNum() + 1);
            this.eWy.setTotalPoll(this.eWy.getTotalPoll() + this.eWz.size());
            for (f fVar : this.eWz) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.eWy.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.eWy.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.setPercent((int) ((fVar2.getNum() * 100) / this.eWy.getTotalPoll()));
                    }
                }
            }
            a(this.eWy, true);
            this.eWz.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void sf() {
        if (this.eWr != null) {
            com.baidu.tbadk.i.a.a(this.dhY.getPageContext(), this.eWr);
        }
        baX();
    }

    private void baX() {
        if (this.eWv != null && this.eWy != null) {
            if (this.eWy.getStatus() == 2) {
                at.k(this.eWv, t.f.btn_pb_vote_d);
                this.eWv.setText(getPageContext().getString(t.j.pb_vote_over));
                at.c(this.eWv, t.d.cp_cont_d, 1);
                this.eWv.setEnabled(false);
            } else if (this.eWy.getIsPolled() == 1) {
                at.k(this.eWv, t.f.btn_pb_vote_d);
                this.eWv.setText(getPageContext().getString(t.j.pb_voted));
                at.c(this.eWv, t.d.cp_cont_d, 1);
                this.eWv.setEnabled(false);
            } else if (this.eWy.getIsPolled() == 0) {
                at.k(this.eWv, t.f.btn_pb_vote_selector);
                this.eWv.setText(getPageContext().getString(t.j.pb_vote_add));
                at.c(this.eWv, t.d.cp_cont_g, 1);
                this.eWv.setEnabled(true);
                this.eWv.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
