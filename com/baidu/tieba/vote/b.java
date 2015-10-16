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
    private com.baidu.tbadk.widget.vote.b aCP;
    private PbActivity ciU;
    private View djn;
    private VotePhotoGroupView djo;
    private VoteTextGroupView djp;
    private VoteView djq;
    private TextView djr;
    private View djs;
    private View djt;
    private VoteDataInfo dju;
    private final List<f> djv;
    private boolean djw;
    private com.baidu.tbadk.core.view.f djx;
    private final com.baidu.adp.framework.listener.a djy;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.djn != null) {
            this.djn.setVisibility(i);
        }
    }

    public void aAK() {
        if (this.djo != null) {
            this.djo.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.djv = new ArrayList();
        this.djw = false;
        this.maxWidth = 0;
        this.aCP = new c(this);
        this.djy = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.ciU = pbActivity;
        pbActivity.registerListener(this.djy);
        this.maxWidth = k.K(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(i.d.ds60);
        this.djx = new com.baidu.tbadk.core.view.f(this.ciU.getPageContext());
    }

    public void a(View view, com.baidu.tieba.pb.a.b bVar) {
        if (bVar != null && bVar.aeN() != null && bVar.aeO() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(bVar.aeN().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(bVar.aeO().getId(), 0L);
            if (bVar.aeO().sB() && bVar.aeO().sg() != null) {
                if (this.djn == null) {
                    this.djn = ((ViewStub) view.findViewById(i.f.vote_card_layout)).inflate();
                    this.djr = (TextView) this.djn.findViewById(i.f.btn_pb_vote);
                    this.djs = this.djn.findViewById(i.f.vote_top_line);
                    this.djt = this.djn.findViewById(i.f.vote_middle_line);
                    tc();
                    this.dju = bVar.aeM();
                    a(this.dju, false);
                }
                if (!this.djn.isShown()) {
                    this.djn.setVisibility(0);
                }
            } else if (this.djn != null && this.djn.isShown()) {
                this.djn.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.dju = voteDataInfo;
        if (this.dju != null) {
            aAL();
            if (this.dju.getVoteType() == 1) {
                if (this.dju.getStatus() == 2 || this.dju.getIsPolled() == 1) {
                    gP(z);
                } else {
                    aAM();
                }
            } else if (this.dju.getVoteType() == 2) {
                if (this.dju.getStatus() == 2 || this.dju.getIsPolled() == 1) {
                    s(2, z);
                } else {
                    s(this.dju.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void s(int i, boolean z) {
        if (this.djn != null && this.dju != null) {
            this.djo = (VotePhotoGroupView) this.djn.findViewById(i.f.picvote_view);
            this.djo.setOnVoteCheckedChangedListener(this.aCP);
            this.djo.setVisibility(0);
            this.djo.setMode(i);
            this.djo.setData(this.dju.getOptions(), z);
            if (this.djs != null) {
                this.djs.setVisibility(8);
            }
            if (this.djt != null) {
                this.djt.setVisibility(8);
            }
        }
    }

    private void aAL() {
        if (this.djn != null && this.dju != null) {
            ((TextView) this.djn.findViewById(i.f.tv_vote_endtime)).setText(this.dju.getTips());
            ((TextView) this.djn.findViewById(i.f.vote_num)).setText(getPageContext().getPageActivity().getString(i.h.pb_vote_num, new Object[]{Long.valueOf(this.dju.getTotalNum())}));
            aAO();
        }
    }

    private void aAM() {
        if (this.djn != null && this.dju != null) {
            this.djp = (VoteTextGroupView) this.djn.findViewById(i.f.textvote_view);
            this.djp.setOnVoteCheckedChangedListener(this.aCP);
            this.djp.setVisibility(0);
            this.djp.setMode(this.dju.getIsMulti() == 1 ? 1 : 2);
            this.djp.t(this.dju.getOptions());
            this.djp.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void gP(boolean z) {
        if (this.djn != null && this.dju != null) {
            this.djo = (VotePhotoGroupView) this.djn.findViewById(i.f.picvote_view);
            this.djp = (VoteTextGroupView) this.djn.findViewById(i.f.textvote_view);
            this.djq = (VoteView) this.djn.findViewById(i.f.result_vote_view);
            this.djp.setVisibility(8);
            this.djo.setVisibility(8);
            this.djq.setVisibility(0);
            this.djq.setWidth(this.maxWidth);
            this.djq.b(this.dju.getOptions(), z);
            this.djq.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAN() {
        if (this.dju != null) {
            if (this.djx != null && this.ciU != null) {
                this.djx.dA(this.ciU.getActivity().getString(i.h.vote_succ));
            }
            this.dju.setIsPolled(1);
            this.dju.setTotalNum(this.dju.getTotalNum() + 1);
            this.dju.setTotalPoll(this.dju.getTotalPoll() + this.djv.size());
            for (f fVar : this.djv) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.dju.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.dju.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.lF((int) ((fVar2.getNum() * 100) / this.dju.getTotalPoll()));
                    }
                }
            }
            a(this.dju, true);
            this.djv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tc() {
        if (this.djn != null) {
            com.baidu.tbadk.h.a.a(this.ciU.getPageContext(), this.djn);
        }
        aAO();
    }

    private void aAO() {
        if (this.djr != null && this.dju != null) {
            if (this.dju.getStatus() == 2) {
                an.i((View) this.djr, i.e.btn_pb_vote_d);
                this.djr.setText(getPageContext().getString(i.h.pb_vote_over));
                an.b(this.djr, i.c.cp_cont_d, 1);
                this.djr.setEnabled(false);
            } else if (this.dju.getIsPolled() == 1) {
                an.i((View) this.djr, i.e.btn_pb_vote_d);
                this.djr.setText(getPageContext().getString(i.h.pb_voted));
                an.b(this.djr, i.c.cp_cont_d, 1);
                this.djr.setEnabled(false);
            } else if (this.dju.getIsPolled() == 0) {
                an.i((View) this.djr, i.e.btn_pb_vote_selector);
                this.djr.setText(getPageContext().getString(i.h.pb_vote_add));
                an.b(this.djr, i.c.cp_cont_g, 1);
                this.djr.setEnabled(true);
                this.djr.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
