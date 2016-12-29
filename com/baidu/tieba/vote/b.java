package com.baidu.tieba.vote;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.f<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aKl;
    private PbActivity dYB;
    private View fvl;
    private VotePhotoGroupView fvm;
    private VoteTextGroupView fvn;
    private VoteView fvo;
    private LinearLayout fvp;
    private TextView fvq;
    private TextView fvr;
    private TextView fvs;
    private TextView fvt;
    private VoteDataInfo fvu;
    private final List<g> fvv;
    private boolean fvw;
    private h fvx;
    private final com.baidu.adp.framework.listener.a fvy;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fvl != null) {
            this.fvl.setVisibility(i);
        }
    }

    public void bks() {
        if (this.fvm != null) {
            this.fvm.setPadding(0, 0, 0, 0);
        }
    }

    public b(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fvv = new ArrayList();
        this.fvw = false;
        this.maxWidth = 0;
        this.aKl = new c(this);
        this.fvy = new d(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new e(this);
        this.dYB = pbActivity;
        pbActivity.registerListener(this.fvy);
        this.maxWidth = k.I(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds120);
        this.fvx = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aIk() != null && fVar.aIl() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.h.b.c(fVar.aIk().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.h.b.c(fVar.aIl().getId(), 0L);
            if (fVar.aIl().sp() && fVar.aIl().ru() != null) {
                if (this.fvl == null) {
                    this.fvl = ((ViewStub) view.findViewById(r.g.vote_card_layout)).inflate();
                    this.fvt = (TextView) this.fvl.findViewById(r.g.btn_pb_vote);
                    this.fvu = fVar.aIj();
                    b((q) x.c(fVar.aIm(), 0), this.fvl);
                    a(this.fvu, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    tm();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fvl.isShown()) {
                    this.fvl.setVisibility(0);
                }
            } else if (this.fvl != null && this.fvl.isShown()) {
                this.fvl.setVisibility(8);
            }
        }
    }

    private void b(q qVar, View view) {
        this.fvp = (LinearLayout) view.findViewById(r.g.pb_vote_location_container);
        this.fvq = (TextView) view.findViewById(r.g.pb_vote_first_floor_name);
        this.fvr = (TextView) view.findViewById(r.g.pb_item_vote_reply_time);
        this.fvs = (TextView) view.findViewById(r.g.pb_item_vote_location_address);
        com.baidu.tbadk.data.g gVar = null;
        if (qVar != null) {
            this.fvr.setText(qVar.bgc());
            gVar = qVar.bgd();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            String name = gVar.getName();
            String lat = gVar.getLat();
            String lng = gVar.getLng();
            this.fvs.setVisibility(0);
            this.fvs.setText(gVar.getName());
            this.fvs.setOnClickListener(new f(this, lat, lng, name));
            return;
        }
        this.fvs.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fvu = voteDataInfo;
        if (this.fvu != null) {
            if (this.fvu.getStatus() == 2 || this.fvu.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fvu.getOptions()) {
                    if (aVar != null && (aVar instanceof g)) {
                        ((g) aVar).setSelected(false);
                    }
                }
            }
            ahv();
            if (this.fvu.getVoteType() == 1) {
                if (this.fvu.getStatus() == 2 || this.fvu.getIsPolled() == 1) {
                    lq(z);
                } else {
                    bkt();
                }
            } else if (this.fvu.getVoteType() == 2) {
                if (this.fvu.getStatus() == 2 || this.fvu.getIsPolled() == 1) {
                    H(2, z);
                } else {
                    H(this.fvu.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void H(int i, boolean z) {
        if (this.fvl != null && this.fvu != null) {
            this.fvm = (VotePhotoGroupView) this.fvl.findViewById(r.g.picvote_view);
            this.fvm.setOnVoteCheckedChangedListener(this.aKl);
            this.fvm.setVisibility(0);
            this.fvm.setMode(i);
            this.fvm.a(this.fvu.getOptions(), z, this.fvu.getIsPolled() == 1);
        }
    }

    private void ahv() {
        if (this.fvl != null && this.fvu != null) {
            ((TextView) this.fvl.findViewById(r.g.tv_vote_endtime)).setText(this.fvu.getTips());
            ((TextView) this.fvl.findViewById(r.g.vote_num)).setText(getPageContext().getPageActivity().getString(r.j.pb_vote_num, new Object[]{Long.valueOf(this.fvu.getTotalNum())}));
            bkv();
        }
    }

    private void bkt() {
        if (this.fvl != null && this.fvu != null) {
            this.fvn = (VoteTextGroupView) this.fvl.findViewById(r.g.textvote_view);
            this.fvn.setOnVoteCheckedChangedListener(this.aKl);
            this.fvn.setVisibility(0);
            this.fvn.setMode(this.fvu.getIsMulti() == 1 ? 1 : 2);
            this.fvn.E(this.fvu.getOptions());
            this.fvn.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void lq(boolean z) {
        if (this.fvl != null && this.fvu != null) {
            this.fvm = (VotePhotoGroupView) this.fvl.findViewById(r.g.picvote_view);
            this.fvn = (VoteTextGroupView) this.fvl.findViewById(r.g.textvote_view);
            this.fvo = (VoteView) this.fvl.findViewById(r.g.result_vote_view);
            this.fvn.setVisibility(8);
            this.fvm.setVisibility(8);
            this.fvo.setVisibility(0);
            this.fvo.setWidth(this.maxWidth);
            this.fvo.a(this.fvu.getOptions(), z);
            this.fvo.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bku() {
        if (this.fvu != null) {
            if (this.fvx != null && this.dYB != null) {
                this.fvx.c(this.dYB.getActivity().getString(r.j.vote_succ));
            }
            this.fvu.setIsPolled(1);
            this.fvu.setTotalNum(this.fvu.getTotalNum() + 1);
            this.fvu.setTotalPoll(this.fvu.getTotalPoll() + this.fvv.size());
            for (g gVar : this.fvv) {
                if (gVar != null) {
                    gVar.setNum(gVar.getNum() + 1);
                }
            }
            if (this.fvu.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fvu.getOptions()) {
                    if (aVar instanceof g) {
                        g gVar2 = (g) aVar;
                        gVar2.cj((int) ((gVar2.getNum() * 100) / this.fvu.getTotalPoll()));
                    }
                }
            }
            a(this.fvu, true);
            this.fvv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tm() {
        if (this.fvl != null) {
            com.baidu.tbadk.i.a.a(this.dYB.getPageContext(), this.fvl);
        }
        bkv();
    }

    private void bkv() {
        if (this.fvt != null && this.fvu != null) {
            if (this.fvu.getStatus() == 2) {
                ar.k(this.fvt, r.f.bg_gray_circle);
                this.fvt.setText(getPageContext().getString(r.j.pb_vote_over));
                this.fvt.setEnabled(false);
            } else if (this.fvu.getIsPolled() == 1) {
                ar.k(this.fvt, r.f.bg_gray_circle);
                this.fvt.setText(getPageContext().getString(r.j.pb_voted));
                this.fvt.setEnabled(false);
            } else if (this.fvu.getIsPolled() == 0) {
                ar.k(this.fvt, r.f.btn_pb_vote_selector);
                this.fvt.setText(getPageContext().getString(r.j.pb_vote_add));
                this.fvt.setEnabled(true);
                this.fvt.setOnClickListener(this.mOnClickListener);
            }
            ar.c(this.fvt, r.d.cp_cont_i, 1);
        }
    }
}
