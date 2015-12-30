package com.baidu.tieba.vote;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aFV;
    private PbActivity cGj;
    private View dRf;
    private VotePhotoGroupView dRg;
    private VoteTextGroupView dRh;
    private VoteView dRi;
    private TextView dRj;
    private View dRk;
    private View dRl;
    private VoteDataInfo dRm;
    private final List<f> dRn;
    private boolean dRo;
    private h dRp;
    private final com.baidu.adp.framework.listener.a dRq;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.dRf != null) {
            this.dRf.setVisibility(i);
        }
    }

    public void aJm() {
        if (this.dRg != null) {
            this.dRg.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.dRn = new ArrayList();
        this.dRo = false;
        this.maxWidth = 0;
        this.aFV = new c(this);
        this.dRq = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.cGj = pbActivity;
        pbActivity.registerListener(this.dRq);
        this.maxWidth = k.K(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds60);
        this.dRp = new h(this.cGj.getPageContext());
    }

    public void a(View view, com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null && cVar.akG() != null && cVar.akH() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(cVar.akG().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(cVar.akH().getId(), 0L);
            if (cVar.akH().sM() && cVar.akH().sr() != null) {
                if (this.dRf == null) {
                    this.dRf = ((ViewStub) view.findViewById(n.g.vote_card_layout)).inflate();
                    this.dRj = (TextView) this.dRf.findViewById(n.g.btn_pb_vote);
                    this.dRk = this.dRf.findViewById(n.g.vote_top_line);
                    this.dRl = this.dRf.findViewById(n.g.vote_middle_line);
                    this.dRm = cVar.akF();
                    a(this.dRm, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m411getInst().getSkinType()) {
                    tr();
                }
                this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
                if (!this.dRf.isShown()) {
                    this.dRf.setVisibility(0);
                }
            } else if (this.dRf != null && this.dRf.isShown()) {
                this.dRf.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.dRm = voteDataInfo;
        if (this.dRm != null) {
            aJn();
            if (this.dRm.getVoteType() == 1) {
                if (this.dRm.getStatus() == 2 || this.dRm.getIsPolled() == 1) {
                    hJ(z);
                } else {
                    aJo();
                }
            } else if (this.dRm.getVoteType() == 2) {
                if (this.dRm.getStatus() == 2 || this.dRm.getIsPolled() == 1) {
                    u(2, z);
                } else {
                    u(this.dRm.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void u(int i, boolean z) {
        if (this.dRf != null && this.dRm != null) {
            this.dRg = (VotePhotoGroupView) this.dRf.findViewById(n.g.picvote_view);
            this.dRg.setOnVoteCheckedChangedListener(this.aFV);
            this.dRg.setVisibility(0);
            this.dRg.setMode(i);
            this.dRg.setData(this.dRm.getOptions(), z);
            if (this.dRk != null) {
                this.dRk.setVisibility(8);
            }
            if (this.dRl != null) {
                this.dRl.setVisibility(8);
            }
        }
    }

    private void aJn() {
        if (this.dRf != null && this.dRm != null) {
            ((TextView) this.dRf.findViewById(n.g.tv_vote_endtime)).setText(this.dRm.getTips());
            ((TextView) this.dRf.findViewById(n.g.vote_num)).setText(getPageContext().getPageActivity().getString(n.j.pb_vote_num, new Object[]{Long.valueOf(this.dRm.getTotalNum())}));
            aJq();
        }
    }

    private void aJo() {
        if (this.dRf != null && this.dRm != null) {
            this.dRh = (VoteTextGroupView) this.dRf.findViewById(n.g.textvote_view);
            this.dRh.setOnVoteCheckedChangedListener(this.aFV);
            this.dRh.setVisibility(0);
            this.dRh.setMode(this.dRm.getIsMulti() == 1 ? 1 : 2);
            this.dRh.u(this.dRm.getOptions());
            this.dRh.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void hJ(boolean z) {
        if (this.dRf != null && this.dRm != null) {
            this.dRg = (VotePhotoGroupView) this.dRf.findViewById(n.g.picvote_view);
            this.dRh = (VoteTextGroupView) this.dRf.findViewById(n.g.textvote_view);
            this.dRi = (VoteView) this.dRf.findViewById(n.g.result_vote_view);
            this.dRh.setVisibility(8);
            this.dRg.setVisibility(8);
            this.dRi.setVisibility(0);
            this.dRi.setWidth(this.maxWidth);
            this.dRi.b(this.dRm.getOptions(), z);
            this.dRi.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJp() {
        if (this.dRm != null) {
            if (this.dRp != null && this.cGj != null) {
                this.dRp.c(this.cGj.getActivity().getString(n.j.vote_succ));
            }
            this.dRm.setIsPolled(1);
            this.dRm.setTotalNum(this.dRm.getTotalNum() + 1);
            this.dRm.setTotalPoll(this.dRm.getTotalPoll() + this.dRn.size());
            for (f fVar : this.dRn) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.dRm.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.dRm.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.nX((int) ((fVar2.getNum() * 100) / this.dRm.getTotalPoll()));
                    }
                }
            }
            a(this.dRm, true);
            this.dRn.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tr() {
        if (this.dRf != null) {
            com.baidu.tbadk.i.a.a(this.cGj.getPageContext(), this.dRf);
        }
        aJq();
    }

    private void aJq() {
        if (this.dRj != null && this.dRm != null) {
            if (this.dRm.getStatus() == 2) {
                as.i((View) this.dRj, n.f.btn_pb_vote_d);
                this.dRj.setText(getPageContext().getString(n.j.pb_vote_over));
                as.b(this.dRj, n.d.cp_cont_d, 1);
                this.dRj.setEnabled(false);
            } else if (this.dRm.getIsPolled() == 1) {
                as.i((View) this.dRj, n.f.btn_pb_vote_d);
                this.dRj.setText(getPageContext().getString(n.j.pb_voted));
                as.b(this.dRj, n.d.cp_cont_d, 1);
                this.dRj.setEnabled(false);
            } else if (this.dRm.getIsPolled() == 0) {
                as.i((View) this.dRj, n.f.btn_pb_vote_selector);
                this.dRj.setText(getPageContext().getString(n.j.pb_vote_add));
                as.b(this.dRj, n.d.cp_cont_g, 1);
                this.dRj.setEnabled(true);
                this.dRj.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
