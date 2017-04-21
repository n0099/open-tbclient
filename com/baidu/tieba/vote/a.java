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
    private com.baidu.tbadk.widget.vote.b aOH;
    private PbActivity ekw;
    private View fML;
    private VotePhotoGroupView fMM;
    private VoteTextGroupView fMN;
    private VoteView fMO;
    private LinearLayout fMP;
    private TextView fMQ;
    private TextView fMR;
    private TextView fMS;
    private TextView fMT;
    private VoteDataInfo fMU;
    private final List<f> fMV;
    private boolean fMW;
    private h fMX;
    private final com.baidu.adp.framework.listener.a fMY;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fML != null) {
            this.fML.setVisibility(i);
        }
    }

    public void bnu() {
        if (this.fMM != null) {
            this.fMM.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fMV = new ArrayList();
        this.fMW = false;
        this.maxWidth = 0;
        this.aOH = new b(this);
        this.fMY = new c(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new d(this);
        this.ekw = pbActivity;
        pbActivity.registerListener(this.fMY);
        this.maxWidth = k.af(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds120);
        this.fMX = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aKx() != null && fVar.aKy() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aKx().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aKy().getId(), 0L);
            if (fVar.aKy().ta() && fVar.aKy().sd() != null) {
                if (this.fML == null) {
                    this.fML = ((ViewStub) view.findViewById(w.h.vote_card_layout)).inflate();
                    this.fMT = (TextView) this.fML.findViewById(w.h.btn_pb_vote);
                    this.fMU = fVar.aKw();
                    b((PostData) x.c(fVar.aKA(), 0), this.fML);
                    a(this.fMU, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fML.isShown()) {
                    this.fML.setVisibility(0);
                }
            } else if (this.fML != null && this.fML.isShown()) {
                this.fML.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.fMP = (LinearLayout) view.findViewById(w.h.pb_vote_location_container);
        this.fMQ = (TextView) view.findViewById(w.h.pb_vote_first_floor_name);
        this.fMR = (TextView) view.findViewById(w.h.pb_item_vote_reply_time);
        this.fMS = (TextView) view.findViewById(w.h.pb_item_vote_location_address);
        g gVar = null;
        if (postData != null) {
            this.fMR.setText(postData.bjr());
            gVar = postData.bjs();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            String name = gVar.getName();
            String lat = gVar.getLat();
            String lng = gVar.getLng();
            this.fMS.setVisibility(0);
            this.fMS.setText(gVar.getName());
            this.fMS.setOnClickListener(new e(this, lat, lng, name));
            return;
        }
        this.fMS.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fMU = voteDataInfo;
        if (this.fMU != null) {
            if (this.fMU.getStatus() == 2 || this.fMU.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fMU.getOptions()) {
                    if (aVar != null && (aVar instanceof f)) {
                        ((f) aVar).setSelected(false);
                    }
                }
            }
            aSG();
            if (this.fMU.getVoteType() == 1) {
                if (this.fMU.getStatus() == 2 || this.fMU.getIsPolled() == 1) {
                    lO(z);
                } else {
                    bnv();
                }
            } else if (this.fMU.getVoteType() == 2) {
                if (this.fMU.getStatus() == 2 || this.fMU.getIsPolled() == 1) {
                    I(2, z);
                } else {
                    I(this.fMU.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void I(int i, boolean z) {
        if (this.fML != null && this.fMU != null) {
            this.fMM = (VotePhotoGroupView) this.fML.findViewById(w.h.picvote_view);
            this.fMM.setOnVoteCheckedChangedListener(this.aOH);
            this.fMM.setVisibility(0);
            this.fMM.setMode(i);
            this.fMM.a(this.fMU.getOptions(), z, this.fMU.getIsPolled() == 1);
        }
    }

    private void aSG() {
        if (this.fML != null && this.fMU != null) {
            ((TextView) this.fML.findViewById(w.h.tv_vote_endtime)).setText(this.fMU.getTips());
            ((TextView) this.fML.findViewById(w.h.vote_num)).setText(getPageContext().getPageActivity().getString(w.l.pb_vote_num, new Object[]{Long.valueOf(this.fMU.getTotalNum())}));
            bnx();
        }
    }

    private void bnv() {
        if (this.fML != null && this.fMU != null) {
            this.fMN = (VoteTextGroupView) this.fML.findViewById(w.h.textvote_view);
            this.fMN.setOnVoteCheckedChangedListener(this.aOH);
            this.fMN.setVisibility(0);
            this.fMN.setMode(this.fMU.getIsMulti() == 1 ? 1 : 2);
            this.fMN.A(this.fMU.getOptions());
            this.fMN.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void lO(boolean z) {
        if (this.fML != null && this.fMU != null) {
            this.fMM = (VotePhotoGroupView) this.fML.findViewById(w.h.picvote_view);
            this.fMN = (VoteTextGroupView) this.fML.findViewById(w.h.textvote_view);
            this.fMO = (VoteView) this.fML.findViewById(w.h.result_vote_view);
            this.fMN.setVisibility(8);
            this.fMM.setVisibility(8);
            this.fMO.setVisibility(0);
            this.fMO.setWidth(this.maxWidth);
            this.fMO.a(this.fMU.getOptions(), z);
            this.fMO.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnw() {
        if (this.fMU != null) {
            if (this.fMX != null && this.ekw != null) {
                this.fMX.c(this.ekw.getActivity().getString(w.l.vote_succ));
            }
            this.fMU.setIsPolled(1);
            this.fMU.setTotalNum(this.fMU.getTotalNum() + 1);
            this.fMU.setTotalPoll(this.fMU.getTotalPoll() + this.fMV.size());
            for (f fVar : this.fMV) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fMU.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fMU.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.ch((int) ((fVar2.getNum() * 100) / this.fMU.getTotalPoll()));
                    }
                }
            }
            a(this.fMU, true);
            this.fMV.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.fML != null) {
            com.baidu.tbadk.m.a.a(this.ekw.getPageContext(), this.fML);
        }
        bnx();
    }

    private void bnx() {
        if (this.fMT != null && this.fMU != null) {
            if (this.fMU.getStatus() == 2) {
                aq.j(this.fMT, w.g.bg_gray_circle);
                this.fMT.setText(getPageContext().getString(w.l.pb_vote_over));
                this.fMT.setEnabled(false);
            } else if (this.fMU.getIsPolled() == 1) {
                aq.j(this.fMT, w.g.bg_gray_circle);
                this.fMT.setText(getPageContext().getString(w.l.pb_voted));
                this.fMT.setEnabled(false);
            } else if (this.fMU.getIsPolled() == 0) {
                aq.j(this.fMT, w.g.btn_pb_vote_selector);
                this.fMT.setText(getPageContext().getString(w.l.vote));
                this.fMT.setEnabled(true);
                this.fMT.setOnClickListener(this.mOnClickListener);
            }
            aq.c(this.fMT, w.e.cp_cont_i, 1);
        }
    }
}
