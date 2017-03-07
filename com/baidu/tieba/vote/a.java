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
import com.baidu.tbadk.data.g;
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
    private com.baidu.tbadk.widget.vote.b aOp;
    private PbActivity eka;
    private View fIG;
    private VotePhotoGroupView fIH;
    private VoteTextGroupView fII;
    private VoteView fIJ;
    private LinearLayout fIK;
    private TextView fIL;
    private TextView fIM;
    private TextView fIN;
    private TextView fIO;
    private VoteDataInfo fIP;
    private final List<f> fIQ;
    private boolean fIR;
    private h fIS;
    private final com.baidu.adp.framework.listener.a fIT;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fIG != null) {
            this.fIG.setVisibility(i);
        }
    }

    public void blJ() {
        if (this.fIH != null) {
            this.fIH.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fIQ = new ArrayList();
        this.fIR = false;
        this.maxWidth = 0;
        this.aOp = new b(this);
        this.fIT = new c(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new d(this);
        this.eka = pbActivity;
        pbActivity.registerListener(this.fIT);
        this.maxWidth = k.ag(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds120);
        this.fIS = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aJp() != null && fVar.aJq() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aJp().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aJq().getId(), 0L);
            if (fVar.aJq().sC() && fVar.aJq().rF() != null) {
                if (this.fIG == null) {
                    this.fIG = ((ViewStub) view.findViewById(w.h.vote_card_layout)).inflate();
                    this.fIO = (TextView) this.fIG.findViewById(w.h.btn_pb_vote);
                    this.fIP = fVar.aJo();
                    b((PostData) x.c(fVar.aJs(), 0), this.fIG);
                    a(this.fIP, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    tD();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fIG.isShown()) {
                    this.fIG.setVisibility(0);
                }
            } else if (this.fIG != null && this.fIG.isShown()) {
                this.fIG.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.fIK = (LinearLayout) view.findViewById(w.h.pb_vote_location_container);
        this.fIL = (TextView) view.findViewById(w.h.pb_vote_first_floor_name);
        this.fIM = (TextView) view.findViewById(w.h.pb_item_vote_reply_time);
        this.fIN = (TextView) view.findViewById(w.h.pb_item_vote_location_address);
        g gVar = null;
        if (postData != null) {
            this.fIM.setText(postData.bhF());
            gVar = postData.bhG();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            String name = gVar.getName();
            String lat = gVar.getLat();
            String lng = gVar.getLng();
            this.fIN.setVisibility(0);
            this.fIN.setText(gVar.getName());
            this.fIN.setOnClickListener(new e(this, lat, lng, name));
            return;
        }
        this.fIN.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fIP = voteDataInfo;
        if (this.fIP != null) {
            if (this.fIP.getStatus() == 2 || this.fIP.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fIP.getOptions()) {
                    if (aVar != null && (aVar instanceof f)) {
                        ((f) aVar).setSelected(false);
                    }
                }
            }
            aRw();
            if (this.fIP.getVoteType() == 1) {
                if (this.fIP.getStatus() == 2 || this.fIP.getIsPolled() == 1) {
                    lB(z);
                } else {
                    blK();
                }
            } else if (this.fIP.getVoteType() == 2) {
                if (this.fIP.getStatus() == 2 || this.fIP.getIsPolled() == 1) {
                    I(2, z);
                } else {
                    I(this.fIP.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void I(int i, boolean z) {
        if (this.fIG != null && this.fIP != null) {
            this.fIH = (VotePhotoGroupView) this.fIG.findViewById(w.h.picvote_view);
            this.fIH.setOnVoteCheckedChangedListener(this.aOp);
            this.fIH.setVisibility(0);
            this.fIH.setMode(i);
            this.fIH.a(this.fIP.getOptions(), z, this.fIP.getIsPolled() == 1);
        }
    }

    private void aRw() {
        if (this.fIG != null && this.fIP != null) {
            ((TextView) this.fIG.findViewById(w.h.tv_vote_endtime)).setText(this.fIP.getTips());
            ((TextView) this.fIG.findViewById(w.h.vote_num)).setText(getPageContext().getPageActivity().getString(w.l.pb_vote_num, new Object[]{Long.valueOf(this.fIP.getTotalNum())}));
            blM();
        }
    }

    private void blK() {
        if (this.fIG != null && this.fIP != null) {
            this.fII = (VoteTextGroupView) this.fIG.findViewById(w.h.textvote_view);
            this.fII.setOnVoteCheckedChangedListener(this.aOp);
            this.fII.setVisibility(0);
            this.fII.setMode(this.fIP.getIsMulti() == 1 ? 1 : 2);
            this.fII.A(this.fIP.getOptions());
            this.fII.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void lB(boolean z) {
        if (this.fIG != null && this.fIP != null) {
            this.fIH = (VotePhotoGroupView) this.fIG.findViewById(w.h.picvote_view);
            this.fII = (VoteTextGroupView) this.fIG.findViewById(w.h.textvote_view);
            this.fIJ = (VoteView) this.fIG.findViewById(w.h.result_vote_view);
            this.fII.setVisibility(8);
            this.fIH.setVisibility(8);
            this.fIJ.setVisibility(0);
            this.fIJ.setWidth(this.maxWidth);
            this.fIJ.a(this.fIP.getOptions(), z);
            this.fIJ.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blL() {
        if (this.fIP != null) {
            if (this.fIS != null && this.eka != null) {
                this.fIS.c(this.eka.getActivity().getString(w.l.vote_succ));
            }
            this.fIP.setIsPolled(1);
            this.fIP.setTotalNum(this.fIP.getTotalNum() + 1);
            this.fIP.setTotalPoll(this.fIP.getTotalPoll() + this.fIQ.size());
            for (f fVar : this.fIQ) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fIP.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fIP.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.ce((int) ((fVar2.getNum() * 100) / this.fIP.getTotalPoll()));
                    }
                }
            }
            a(this.fIP, true);
            this.fIQ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void tD() {
        if (this.fIG != null) {
            com.baidu.tbadk.i.a.a(this.eka.getPageContext(), this.fIG);
        }
        blM();
    }

    private void blM() {
        if (this.fIO != null && this.fIP != null) {
            if (this.fIP.getStatus() == 2) {
                aq.j(this.fIO, w.g.bg_gray_circle);
                this.fIO.setText(getPageContext().getString(w.l.pb_vote_over));
                this.fIO.setEnabled(false);
            } else if (this.fIP.getIsPolled() == 1) {
                aq.j(this.fIO, w.g.bg_gray_circle);
                this.fIO.setText(getPageContext().getString(w.l.pb_voted));
                this.fIO.setEnabled(false);
            } else if (this.fIP.getIsPolled() == 0) {
                aq.j(this.fIO, w.g.btn_pb_vote_selector);
                this.fIO.setText(getPageContext().getString(w.l.vote));
                this.fIO.setEnabled(true);
                this.fIO.setOnClickListener(this.mOnClickListener);
            }
            aq.c(this.fIO, w.e.cp_cont_i, 1);
        }
    }
}
