package com.baidu.tieba.vote;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
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
    private com.baidu.tbadk.widget.vote.b aGO;
    private PbActivity cNL;
    private View elO;
    private VotePhotoGroupView elP;
    private VoteTextGroupView elQ;
    private VoteView elR;
    private TextView elS;
    private View elT;
    private View elU;
    private VoteDataInfo elV;
    private final List<f> elW;
    private boolean elX;
    private h elY;
    private final com.baidu.adp.framework.listener.a elZ;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.elO != null) {
            this.elO.setVisibility(i);
        }
    }

    public void aSc() {
        if (this.elP != null) {
            this.elP.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.elW = new ArrayList();
        this.elX = false;
        this.maxWidth = 0;
        this.aGO = new c(this);
        this.elZ = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.cNL = pbActivity;
        pbActivity.registerListener(this.elZ);
        this.maxWidth = k.K(TbadkCoreApplication.m411getInst()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
        this.elY = new h(this.cNL.getPageContext());
    }

    public void a(View view, com.baidu.tieba.pb.a.c cVar) {
        if (cVar != null && cVar.aoE() != null && cVar.aoF() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(cVar.aoE().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(cVar.aoF().getId(), 0L);
            if (cVar.aoF().tI() && cVar.aoF().tk() != null) {
                if (this.elO == null) {
                    this.elO = ((ViewStub) view.findViewById(t.g.vote_card_layout)).inflate();
                    this.elS = (TextView) this.elO.findViewById(t.g.btn_pb_vote);
                    this.elT = this.elO.findViewById(t.g.vote_top_line);
                    this.elU = this.elO.findViewById(t.g.vote_middle_line);
                    this.elV = cVar.aoD();
                    a(this.elV, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m411getInst().getSkinType()) {
                    uv();
                }
                this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
                if (!this.elO.isShown()) {
                    this.elO.setVisibility(0);
                }
            } else if (this.elO != null && this.elO.isShown()) {
                this.elO.setVisibility(8);
            }
        }
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.elV = voteDataInfo;
        if (this.elV != null) {
            aSd();
            if (this.elV.getVoteType() == 1) {
                if (this.elV.getStatus() == 2 || this.elV.getIsPolled() == 1) {
                    iv(z);
                } else {
                    aSe();
                }
            } else if (this.elV.getVoteType() == 2) {
                if (this.elV.getStatus() == 2 || this.elV.getIsPolled() == 1) {
                    w(2, z);
                } else {
                    w(this.elV.getIsMulti() != 1 ? 3 : 1, z);
                }
            }
        }
    }

    private void w(int i, boolean z) {
        if (this.elO != null && this.elV != null) {
            this.elP = (VotePhotoGroupView) this.elO.findViewById(t.g.picvote_view);
            this.elP.setOnVoteCheckedChangedListener(this.aGO);
            this.elP.setVisibility(0);
            this.elP.setMode(i);
            this.elP.setData(this.elV.getOptions(), z);
            if (this.elT != null) {
                this.elT.setVisibility(8);
            }
            if (this.elU != null) {
                this.elU.setVisibility(8);
            }
        }
    }

    private void aSd() {
        if (this.elO != null && this.elV != null) {
            ((TextView) this.elO.findViewById(t.g.tv_vote_endtime)).setText(this.elV.getTips());
            ((TextView) this.elO.findViewById(t.g.vote_num)).setText(getPageContext().getPageActivity().getString(t.j.pb_vote_num, new Object[]{Long.valueOf(this.elV.getTotalNum())}));
            aSg();
        }
    }

    private void aSe() {
        if (this.elO != null && this.elV != null) {
            this.elQ = (VoteTextGroupView) this.elO.findViewById(t.g.textvote_view);
            this.elQ.setOnVoteCheckedChangedListener(this.aGO);
            this.elQ.setVisibility(0);
            this.elQ.setMode(this.elV.getIsMulti() == 1 ? 1 : 2);
            this.elQ.y(this.elV.getOptions());
            this.elQ.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    private void iv(boolean z) {
        if (this.elO != null && this.elV != null) {
            this.elP = (VotePhotoGroupView) this.elO.findViewById(t.g.picvote_view);
            this.elQ = (VoteTextGroupView) this.elO.findViewById(t.g.textvote_view);
            this.elR = (VoteView) this.elO.findViewById(t.g.result_vote_view);
            this.elQ.setVisibility(8);
            this.elP.setVisibility(8);
            this.elR.setVisibility(0);
            this.elR.setWidth(this.maxWidth);
            this.elR.a(this.elV.getOptions(), z);
            this.elR.onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSf() {
        if (this.elV != null) {
            if (this.elY != null && this.cNL != null) {
                this.elY.c(this.cNL.getActivity().getString(t.j.vote_succ));
            }
            this.elV.setIsPolled(1);
            this.elV.setTotalNum(this.elV.getTotalNum() + 1);
            this.elV.setTotalPoll(this.elV.getTotalPoll() + this.elW.size());
            for (f fVar : this.elW) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.elV.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.elV.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.cg((int) ((fVar2.getNum() * 100) / this.elV.getTotalPoll()));
                    }
                }
            }
            a(this.elV, true);
            this.elW.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void uv() {
        if (this.elO != null) {
            com.baidu.tbadk.i.a.a(this.cNL.getPageContext(), this.elO);
        }
        aSg();
    }

    private void aSg() {
        if (this.elS != null && this.elV != null) {
            if (this.elV.getStatus() == 2) {
                ar.k(this.elS, t.f.btn_pb_vote_d);
                this.elS.setText(getPageContext().getString(t.j.pb_vote_over));
                ar.b(this.elS, t.d.cp_cont_d, 1);
                this.elS.setEnabled(false);
            } else if (this.elV.getIsPolled() == 1) {
                ar.k(this.elS, t.f.btn_pb_vote_d);
                this.elS.setText(getPageContext().getString(t.j.pb_voted));
                ar.b(this.elS, t.d.cp_cont_d, 1);
                this.elS.setEnabled(false);
            } else if (this.elV.getIsPolled() == 0) {
                ar.k(this.elS, t.f.btn_pb_vote_selector);
                this.elS.setText(getPageContext().getString(t.j.pb_vote_add));
                ar.b(this.elS, t.d.cp_cont_g, 1);
                this.elS.setEnabled(true);
                this.elS.setOnClickListener(this.mOnClickListener);
            }
        }
    }
}
