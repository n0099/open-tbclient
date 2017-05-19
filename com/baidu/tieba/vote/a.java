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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.vote.VotePhotoGroupView;
import com.baidu.tbadk.widget.vote.VoteTextGroupView;
import com.baidu.tbadk.widget.vote.VoteView;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e<PbActivity> {
    private com.baidu.tbadk.widget.vote.b aPa;
    private PbActivity efF;
    private VoteView fJA;
    private LinearLayout fJB;
    private TextView fJC;
    private TextView fJD;
    private TextView fJE;
    private TextView fJF;
    private VoteDataInfo fJG;
    private final List<f> fJH;
    private boolean fJI;
    private h fJJ;
    private final com.baidu.adp.framework.listener.a fJK;
    private View fJx;
    private VotePhotoGroupView fJy;
    private VoteTextGroupView fJz;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fJx != null) {
            this.fJx.setVisibility(i);
        }
    }

    public void bkZ() {
        if (this.fJy != null) {
            this.fJy.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fJH = new ArrayList();
        this.fJI = false;
        this.maxWidth = 0;
        this.aPa = new b(this);
        this.fJK = new c(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new d(this);
        this.efF = pbActivity;
        pbActivity.registerListener(this.fJK);
        this.maxWidth = k.af(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds120);
        this.fJJ = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aHE() != null && fVar.aHG() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aHE().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aHG().getId(), 0L);
            if (fVar.aHG().sk() && fVar.aHG().rn() != null) {
                if (this.fJx == null) {
                    this.fJx = ((ViewStub) view.findViewById(w.h.vote_card_layout)).inflate();
                    this.fJF = (TextView) this.fJx.findViewById(w.h.btn_pb_vote);
                    this.fJG = fVar.aHD();
                    b((PostData) x.c(fVar.aHI(), 0), this.fJx);
                    a(this.fJG, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fJx.isShown()) {
                    this.fJx.setVisibility(0);
                }
            } else if (this.fJx != null && this.fJx.isShown()) {
                this.fJx.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.fJB = (LinearLayout) view.findViewById(w.h.pb_vote_location_container);
        this.fJC = (TextView) view.findViewById(w.h.pb_vote_first_floor_name);
        this.fJD = (TextView) view.findViewById(w.h.pb_item_vote_reply_time);
        this.fJE = (TextView) view.findViewById(w.h.pb_item_vote_location_address);
        com.baidu.tbadk.data.f fVar = null;
        if (postData != null) {
            this.fJD.setText(postData.bgO());
            fVar = postData.bgP();
        }
        if (fVar != null && !TextUtils.isEmpty(fVar.getName()) && !TextUtils.isEmpty(fVar.getName().trim())) {
            String name = fVar.getName();
            String lat = fVar.getLat();
            String lng = fVar.getLng();
            this.fJE.setVisibility(0);
            this.fJE.setText(fVar.getName());
            this.fJE.setOnClickListener(new e(this, lat, lng, name));
            return;
        }
        this.fJE.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fJG = voteDataInfo;
        if (this.fJG != null) {
            if (this.fJG.getStatus() == 2 || this.fJG.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fJG.getOptions()) {
                    if (aVar != null && (aVar instanceof f)) {
                        ((f) aVar).setSelected(false);
                    }
                }
            }
            aQa();
            if (this.fJG.getVoteType() == 1) {
                if (this.fJG.getStatus() == 2 || this.fJG.getIsPolled() == 1) {
                    lw(z);
                } else {
                    bla();
                }
            } else if (this.fJG.getVoteType() == 2) {
                if (this.fJG.getStatus() == 2 || this.fJG.getIsPolled() == 1) {
                    H(2, z);
                } else {
                    H(this.fJG.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void H(int i, boolean z) {
        if (this.fJx != null && this.fJG != null) {
            this.fJy = (VotePhotoGroupView) this.fJx.findViewById(w.h.picvote_view);
            this.fJy.setOnVoteCheckedChangedListener(this.aPa);
            this.fJy.setVisibility(0);
            this.fJy.setMode(i);
            this.fJy.a(this.fJG.getOptions(), z, this.fJG.getIsPolled() == 1);
        }
    }

    private void aQa() {
        if (this.fJx != null && this.fJG != null) {
            ((TextView) this.fJx.findViewById(w.h.tv_vote_endtime)).setText(this.fJG.getTips());
            ((TextView) this.fJx.findViewById(w.h.vote_num)).setText(getPageContext().getPageActivity().getString(w.l.pb_vote_num, new Object[]{Long.valueOf(this.fJG.getTotalNum())}));
            blc();
        }
    }

    private void bla() {
        if (this.fJx != null && this.fJG != null) {
            this.fJz = (VoteTextGroupView) this.fJx.findViewById(w.h.textvote_view);
            this.fJz.setOnVoteCheckedChangedListener(this.aPa);
            this.fJz.setVisibility(0);
            this.fJz.setMode(this.fJG.getIsMulti() == 1 ? 1 : 2);
            this.fJz.C(this.fJG.getOptions());
            this.fJz.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void lw(boolean z) {
        if (this.fJx != null && this.fJG != null) {
            this.fJy = (VotePhotoGroupView) this.fJx.findViewById(w.h.picvote_view);
            this.fJz = (VoteTextGroupView) this.fJx.findViewById(w.h.textvote_view);
            this.fJA = (VoteView) this.fJx.findViewById(w.h.result_vote_view);
            this.fJz.setVisibility(8);
            this.fJy.setVisibility(8);
            this.fJA.setVisibility(0);
            this.fJA.setWidth(this.maxWidth);
            this.fJA.a(this.fJG.getOptions(), z);
            this.fJA.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blb() {
        if (this.fJG != null) {
            if (this.fJJ != null && this.efF != null) {
                this.fJJ.c(this.efF.getActivity().getString(w.l.vote_succ));
            }
            this.fJG.setIsPolled(1);
            this.fJG.setTotalNum(this.fJG.getTotalNum() + 1);
            this.fJG.setTotalPoll(this.fJG.getTotalPoll() + this.fJH.size());
            for (f fVar : this.fJH) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fJG.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fJG.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.cf((int) ((fVar2.getNum() * 100) / this.fJG.getTotalPoll()));
                    }
                }
            }
            a(this.fJG, true);
            this.fJH.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.fJx != null) {
            com.baidu.tbadk.m.a.a(this.efF.getPageContext(), this.fJx);
        }
        blc();
    }

    private void blc() {
        if (this.fJF != null && this.fJG != null) {
            if (this.fJG.getStatus() == 2) {
                aq.j(this.fJF, w.g.bg_gray_circle);
                this.fJF.setText(getPageContext().getString(w.l.pb_vote_over));
                this.fJF.setEnabled(false);
            } else if (this.fJG.getIsPolled() == 1) {
                aq.j(this.fJF, w.g.bg_gray_circle);
                this.fJF.setText(getPageContext().getString(w.l.pb_voted));
                this.fJF.setEnabled(false);
            } else if (this.fJG.getIsPolled() == 0) {
                aq.j(this.fJF, w.g.btn_pb_vote_selector);
                this.fJF.setText(getPageContext().getString(w.l.vote));
                this.fJF.setEnabled(true);
                this.fJF.setOnClickListener(this.mOnClickListener);
            }
            aq.c(this.fJF, w.e.cp_cont_i, 1);
        }
    }
}
