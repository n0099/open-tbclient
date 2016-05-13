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
    private h eWA;
    private final com.baidu.adp.framework.listener.a eWB;
    private View eWq;
    private VotePhotoGroupView eWr;
    private VoteTextGroupView eWs;
    private VoteView eWt;
    private TextView eWu;
    private View eWv;
    private View eWw;
    private VoteDataInfo eWx;
    private final List<f> eWy;
    private boolean eWz;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.eWq != null) {
            this.eWq.setVisibility(i);
        }
    }

    public void bbb() {
        if (this.eWr != null) {
            this.eWr.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.eWy = new ArrayList();
        this.eWz = false;
        this.maxWidth = 0;
        this.aFT = new c(this);
        this.eWB = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.dhY = pbActivity;
        pbActivity.registerListener(this.eWB);
        this.maxWidth = k.B(TbadkCoreApplication.m11getInst()) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60);
        this.eWA = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.avD() != null && eVar.avE() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(eVar.avD().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(eVar.avE().getId(), 0L);
            if (eVar.avE().rm() && eVar.avE().qM() != null) {
                if (this.eWq == null) {
                    this.eWq = ((ViewStub) view.findViewById(t.g.vote_card_layout)).inflate();
                    this.eWu = (TextView) this.eWq.findViewById(t.g.btn_pb_vote);
                    this.eWv = this.eWq.findViewById(t.g.vote_top_line);
                    this.eWw = this.eWq.findViewById(t.g.vote_middle_line);
                    this.eWx = eVar.avC();
                    a(this.eWx, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m11getInst().getSkinType()) {
                    sg();
                }
                this.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
                if (!this.eWq.isShown()) {
                    this.eWq.setVisibility(0);
                }
            } else if (this.eWq != null && this.eWq.isShown()) {
                this.eWq.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.eWx = voteDataInfo;
        if (this.eWx != null) {
            Za();
            if (this.eWx.getVoteType() == 1) {
                if (this.eWx.getStatus() == 2 || this.eWx.getIsPolled() == 1) {
                    kq(z);
                } else {
                    bbc();
                }
            } else if (this.eWx.getVoteType() == 2) {
                if (this.eWx.getStatus() == 2 || this.eWx.getIsPolled() == 1) {
                    A(2, z);
                } else {
                    A(this.eWx.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void A(int i, boolean z) {
        if (this.eWq != null && this.eWx != null) {
            this.eWr = (VotePhotoGroupView) this.eWq.findViewById(t.g.picvote_view);
            this.eWr.setOnVoteCheckedChangedListener(this.aFT);
            this.eWr.setVisibility(0);
            this.eWr.setMode(i);
            this.eWr.setData(this.eWx.getOptions(), z);
            if (this.eWv != null) {
                this.eWv.setVisibility(8);
            }
            if (this.eWw != null) {
                this.eWw.setVisibility(8);
            }
        }
    }

    private void Za() {
        if (this.eWq != null && this.eWx != null) {
            ((TextView) this.eWq.findViewById(t.g.tv_vote_endtime)).setText(this.eWx.getTips());
            ((TextView) this.eWq.findViewById(t.g.vote_num)).setText(getPageContext().getPageActivity().getString(t.j.pb_vote_num, new Object[]{Long.valueOf(this.eWx.getTotalNum())}));
            bbe();
        }
    }

    private void bbc() {
        if (this.eWq != null && this.eWx != null) {
            this.eWs = (VoteTextGroupView) this.eWq.findViewById(t.g.textvote_view);
            this.eWs.setOnVoteCheckedChangedListener(this.aFT);
            this.eWs.setVisibility(0);
            this.eWs.setMode(this.eWx.getIsMulti() == 1 ? 1 : 2);
            this.eWs.D(this.eWx.getOptions());
            this.eWs.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    private void kq(boolean z) {
        if (this.eWq != null && this.eWx != null) {
            this.eWr = (VotePhotoGroupView) this.eWq.findViewById(t.g.picvote_view);
            this.eWs = (VoteTextGroupView) this.eWq.findViewById(t.g.textvote_view);
            this.eWt = (VoteView) this.eWq.findViewById(t.g.result_vote_view);
            this.eWs.setVisibility(8);
            this.eWr.setVisibility(8);
            this.eWt.setVisibility(0);
            this.eWt.setWidth(this.maxWidth);
            this.eWt.a(this.eWx.getOptions(), z);
            this.eWt.onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbd() {
        if (this.eWx != null) {
            if (this.eWA != null && this.dhY != null) {
                this.eWA.c(this.dhY.getActivity().getString(t.j.vote_succ));
            }
            this.eWx.setIsPolled(1);
            this.eWx.setTotalNum(this.eWx.getTotalNum() + 1);
            this.eWx.setTotalPoll(this.eWx.getTotalPoll() + this.eWy.size());
            for (f fVar : this.eWy) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.eWx.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.eWx.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.setPercent((int) ((fVar2.getNum() * 100) / this.eWx.getTotalPoll()));
                    }
                }
            }
            a(this.eWx, true);
            this.eWy.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void sg() {
        if (this.eWq != null) {
            com.baidu.tbadk.i.a.a(this.dhY.getPageContext(), this.eWq);
        }
        bbe();
    }

    private void bbe() {
        if (this.eWu != null && this.eWx != null) {
            if (this.eWx.getStatus() == 2) {
                at.k(this.eWu, t.f.btn_pb_vote_d);
                this.eWu.setText(getPageContext().getString(t.j.pb_vote_over));
                at.c(this.eWu, t.d.cp_cont_d, 1);
                this.eWu.setEnabled(false);
            } else if (this.eWx.getIsPolled() == 1) {
                at.k(this.eWu, t.f.btn_pb_vote_d);
                this.eWu.setText(getPageContext().getString(t.j.pb_voted));
                at.c(this.eWu, t.d.cp_cont_d, 1);
                this.eWu.setEnabled(false);
            } else if (this.eWx.getIsPolled() == 0) {
                at.k(this.eWu, t.f.btn_pb_vote_selector);
                this.eWu.setText(getPageContext().getString(t.j.pb_vote_add));
                at.c(this.eWu, t.d.cp_cont_g, 1);
                this.eWu.setEnabled(true);
                this.eWu.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
