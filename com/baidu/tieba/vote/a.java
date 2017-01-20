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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.data.g;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.data.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aIS;
    private PbActivity ehi;
    private View fEf;
    private VotePhotoGroupView fEg;
    private VoteTextGroupView fEh;
    private VoteView fEi;
    private LinearLayout fEj;
    private TextView fEk;
    private TextView fEl;
    private TextView fEm;
    private TextView fEn;
    private VoteDataInfo fEo;
    private final List<f> fEp;
    private boolean fEq;
    private h fEr;
    private final com.baidu.adp.framework.listener.a fEs;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fEf != null) {
            this.fEf.setVisibility(i);
        }
    }

    public void blU() {
        if (this.fEg != null) {
            this.fEg.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fEp = new ArrayList();
        this.fEq = false;
        this.maxWidth = 0;
        this.aIS = new b(this);
        this.fEs = new c(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new d(this);
        this.ehi = pbActivity;
        pbActivity.registerListener(this.fEs);
        this.maxWidth = k.I(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds120);
        this.fEr = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aJY() != null && fVar.aJZ() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aJY().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aJZ().getId(), 0L);
            if (fVar.aJZ().sh() && fVar.aJZ().rm() != null) {
                if (this.fEf == null) {
                    this.fEf = ((ViewStub) view.findViewById(r.h.vote_card_layout)).inflate();
                    this.fEn = (TextView) this.fEf.findViewById(r.h.btn_pb_vote);
                    this.fEo = fVar.aJX();
                    b((p) w.c(fVar.aKb(), 0), this.fEf);
                    a(this.fEo, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    tg();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fEf.isShown()) {
                    this.fEf.setVisibility(0);
                }
            } else if (this.fEf != null && this.fEf.isShown()) {
                this.fEf.setVisibility(8);
            }
        }
    }

    private void b(p pVar, View view) {
        this.fEj = (LinearLayout) view.findViewById(r.h.pb_vote_location_container);
        this.fEk = (TextView) view.findViewById(r.h.pb_vote_first_floor_name);
        this.fEl = (TextView) view.findViewById(r.h.pb_item_vote_reply_time);
        this.fEm = (TextView) view.findViewById(r.h.pb_item_vote_location_address);
        g gVar = null;
        if (pVar != null) {
            this.fEl.setText(pVar.bhS());
            gVar = pVar.bhT();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            String name = gVar.getName();
            String lat = gVar.getLat();
            String lng = gVar.getLng();
            this.fEm.setVisibility(0);
            this.fEm.setText(gVar.getName());
            this.fEm.setOnClickListener(new e(this, lat, lng, name));
            return;
        }
        this.fEm.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fEo = voteDataInfo;
        if (this.fEo != null) {
            if (this.fEo.getStatus() == 2 || this.fEo.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fEo.getOptions()) {
                    if (aVar != null && (aVar instanceof f)) {
                        ((f) aVar).setSelected(false);
                    }
                }
            }
            aRT();
            if (this.fEo.getVoteType() == 1) {
                if (this.fEo.getStatus() == 2 || this.fEo.getIsPolled() == 1) {
                    lC(z);
                } else {
                    blV();
                }
            } else if (this.fEo.getVoteType() == 2) {
                if (this.fEo.getStatus() == 2 || this.fEo.getIsPolled() == 1) {
                    H(2, z);
                } else {
                    H(this.fEo.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void H(int i, boolean z) {
        if (this.fEf != null && this.fEo != null) {
            this.fEg = (VotePhotoGroupView) this.fEf.findViewById(r.h.picvote_view);
            this.fEg.setOnVoteCheckedChangedListener(this.aIS);
            this.fEg.setVisibility(0);
            this.fEg.setMode(i);
            this.fEg.a(this.fEo.getOptions(), z, this.fEo.getIsPolled() == 1);
        }
    }

    private void aRT() {
        if (this.fEf != null && this.fEo != null) {
            ((TextView) this.fEf.findViewById(r.h.tv_vote_endtime)).setText(this.fEo.getTips());
            ((TextView) this.fEf.findViewById(r.h.vote_num)).setText(getPageContext().getPageActivity().getString(r.l.pb_vote_num, new Object[]{Long.valueOf(this.fEo.getTotalNum())}));
            blX();
        }
    }

    private void blV() {
        if (this.fEf != null && this.fEo != null) {
            this.fEh = (VoteTextGroupView) this.fEf.findViewById(r.h.textvote_view);
            this.fEh.setOnVoteCheckedChangedListener(this.aIS);
            this.fEh.setVisibility(0);
            this.fEh.setMode(this.fEo.getIsMulti() == 1 ? 1 : 2);
            this.fEh.C(this.fEo.getOptions());
            this.fEh.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void lC(boolean z) {
        if (this.fEf != null && this.fEo != null) {
            this.fEg = (VotePhotoGroupView) this.fEf.findViewById(r.h.picvote_view);
            this.fEh = (VoteTextGroupView) this.fEf.findViewById(r.h.textvote_view);
            this.fEi = (VoteView) this.fEf.findViewById(r.h.result_vote_view);
            this.fEh.setVisibility(8);
            this.fEg.setVisibility(8);
            this.fEi.setVisibility(0);
            this.fEi.setWidth(this.maxWidth);
            this.fEi.a(this.fEo.getOptions(), z);
            this.fEi.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blW() {
        if (this.fEo != null) {
            if (this.fEr != null && this.ehi != null) {
                this.fEr.c(this.ehi.getActivity().getString(r.l.vote_succ));
            }
            this.fEo.setIsPolled(1);
            this.fEo.setTotalNum(this.fEo.getTotalNum() + 1);
            this.fEo.setTotalPoll(this.fEo.getTotalPoll() + this.fEp.size());
            for (f fVar : this.fEp) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fEo.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fEo.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.ci((int) ((fVar2.getNum() * 100) / this.fEo.getTotalPoll()));
                    }
                }
            }
            a(this.fEo, true);
            this.fEp.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tg() {
        if (this.fEf != null) {
            com.baidu.tbadk.i.a.a(this.ehi.getPageContext(), this.fEf);
        }
        blX();
    }

    private void blX() {
        if (this.fEn != null && this.fEo != null) {
            if (this.fEo.getStatus() == 2) {
                ap.j((View) this.fEn, r.g.bg_gray_circle);
                this.fEn.setText(getPageContext().getString(r.l.pb_vote_over));
                this.fEn.setEnabled(false);
            } else if (this.fEo.getIsPolled() == 1) {
                ap.j((View) this.fEn, r.g.bg_gray_circle);
                this.fEn.setText(getPageContext().getString(r.l.pb_voted));
                this.fEn.setEnabled(false);
            } else if (this.fEo.getIsPolled() == 0) {
                ap.j((View) this.fEn, r.g.btn_pb_vote_selector);
                this.fEn.setText(getPageContext().getString(r.l.vote));
                this.fEn.setEnabled(true);
                this.fEn.setOnClickListener(this.mOnClickListener);
            }
            ap.c(this.fEn, r.e.cp_cont_i, 1);
        }
    }
}
