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
    private com.baidu.tbadk.widget.vote.b aOF;
    private PbActivity eig;
    private boolean fKA;
    private h fKB;
    private final com.baidu.adp.framework.listener.a fKC;
    private View fKp;
    private VotePhotoGroupView fKq;
    private VoteTextGroupView fKr;
    private VoteView fKs;
    private LinearLayout fKt;
    private TextView fKu;
    private TextView fKv;
    private TextView fKw;
    private TextView fKx;
    private VoteDataInfo fKy;
    private final List<f> fKz;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fKp != null) {
            this.fKp.setVisibility(i);
        }
    }

    public void bmt() {
        if (this.fKq != null) {
            this.fKq.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fKz = new ArrayList();
        this.fKA = false;
        this.maxWidth = 0;
        this.aOF = new b(this);
        this.fKC = new c(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new d(this);
        this.eig = pbActivity;
        pbActivity.registerListener(this.fKC);
        this.maxWidth = k.af(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds120);
        this.fKB = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aJw() != null && fVar.aJx() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aJw().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aJx().getId(), 0L);
            if (fVar.aJx().ta() && fVar.aJx().sd() != null) {
                if (this.fKp == null) {
                    this.fKp = ((ViewStub) view.findViewById(w.h.vote_card_layout)).inflate();
                    this.fKx = (TextView) this.fKp.findViewById(w.h.btn_pb_vote);
                    this.fKy = fVar.aJv();
                    b((PostData) x.c(fVar.aJz(), 0), this.fKp);
                    a(this.fKy, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fKp.isShown()) {
                    this.fKp.setVisibility(0);
                }
            } else if (this.fKp != null && this.fKp.isShown()) {
                this.fKp.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.fKt = (LinearLayout) view.findViewById(w.h.pb_vote_location_container);
        this.fKu = (TextView) view.findViewById(w.h.pb_vote_first_floor_name);
        this.fKv = (TextView) view.findViewById(w.h.pb_item_vote_reply_time);
        this.fKw = (TextView) view.findViewById(w.h.pb_item_vote_location_address);
        g gVar = null;
        if (postData != null) {
            this.fKv.setText(postData.biq());
            gVar = postData.bir();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            String name = gVar.getName();
            String lat = gVar.getLat();
            String lng = gVar.getLng();
            this.fKw.setVisibility(0);
            this.fKw.setText(gVar.getName());
            this.fKw.setOnClickListener(new e(this, lat, lng, name));
            return;
        }
        this.fKw.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fKy = voteDataInfo;
        if (this.fKy != null) {
            if (this.fKy.getStatus() == 2 || this.fKy.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fKy.getOptions()) {
                    if (aVar != null && (aVar instanceof f)) {
                        ((f) aVar).setSelected(false);
                    }
                }
            }
            aRF();
            if (this.fKy.getVoteType() == 1) {
                if (this.fKy.getStatus() == 2 || this.fKy.getIsPolled() == 1) {
                    lE(z);
                } else {
                    bmu();
                }
            } else if (this.fKy.getVoteType() == 2) {
                if (this.fKy.getStatus() == 2 || this.fKy.getIsPolled() == 1) {
                    I(2, z);
                } else {
                    I(this.fKy.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void I(int i, boolean z) {
        if (this.fKp != null && this.fKy != null) {
            this.fKq = (VotePhotoGroupView) this.fKp.findViewById(w.h.picvote_view);
            this.fKq.setOnVoteCheckedChangedListener(this.aOF);
            this.fKq.setVisibility(0);
            this.fKq.setMode(i);
            this.fKq.a(this.fKy.getOptions(), z, this.fKy.getIsPolled() == 1);
        }
    }

    private void aRF() {
        if (this.fKp != null && this.fKy != null) {
            ((TextView) this.fKp.findViewById(w.h.tv_vote_endtime)).setText(this.fKy.getTips());
            ((TextView) this.fKp.findViewById(w.h.vote_num)).setText(getPageContext().getPageActivity().getString(w.l.pb_vote_num, new Object[]{Long.valueOf(this.fKy.getTotalNum())}));
            bmw();
        }
    }

    private void bmu() {
        if (this.fKp != null && this.fKy != null) {
            this.fKr = (VoteTextGroupView) this.fKp.findViewById(w.h.textvote_view);
            this.fKr.setOnVoteCheckedChangedListener(this.aOF);
            this.fKr.setVisibility(0);
            this.fKr.setMode(this.fKy.getIsMulti() == 1 ? 1 : 2);
            this.fKr.A(this.fKy.getOptions());
            this.fKr.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void lE(boolean z) {
        if (this.fKp != null && this.fKy != null) {
            this.fKq = (VotePhotoGroupView) this.fKp.findViewById(w.h.picvote_view);
            this.fKr = (VoteTextGroupView) this.fKp.findViewById(w.h.textvote_view);
            this.fKs = (VoteView) this.fKp.findViewById(w.h.result_vote_view);
            this.fKr.setVisibility(8);
            this.fKq.setVisibility(8);
            this.fKs.setVisibility(0);
            this.fKs.setWidth(this.maxWidth);
            this.fKs.a(this.fKy.getOptions(), z);
            this.fKs.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmv() {
        if (this.fKy != null) {
            if (this.fKB != null && this.eig != null) {
                this.fKB.c(this.eig.getActivity().getString(w.l.vote_succ));
            }
            this.fKy.setIsPolled(1);
            this.fKy.setTotalNum(this.fKy.getTotalNum() + 1);
            this.fKy.setTotalPoll(this.fKy.getTotalPoll() + this.fKz.size());
            for (f fVar : this.fKz) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fKy.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fKy.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.ch((int) ((fVar2.getNum() * 100) / this.fKy.getTotalPoll()));
                    }
                }
            }
            a(this.fKy, true);
            this.fKz.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.fKp != null) {
            com.baidu.tbadk.m.a.a(this.eig.getPageContext(), this.fKp);
        }
        bmw();
    }

    private void bmw() {
        if (this.fKx != null && this.fKy != null) {
            if (this.fKy.getStatus() == 2) {
                aq.j(this.fKx, w.g.bg_gray_circle);
                this.fKx.setText(getPageContext().getString(w.l.pb_vote_over));
                this.fKx.setEnabled(false);
            } else if (this.fKy.getIsPolled() == 1) {
                aq.j(this.fKx, w.g.bg_gray_circle);
                this.fKx.setText(getPageContext().getString(w.l.pb_voted));
                this.fKx.setEnabled(false);
            } else if (this.fKy.getIsPolled() == 0) {
                aq.j(this.fKx, w.g.btn_pb_vote_selector);
                this.fKx.setText(getPageContext().getString(w.l.vote));
                this.fKx.setEnabled(true);
                this.fKx.setOnClickListener(this.mOnClickListener);
            }
            aq.c(this.fKx, w.e.cp_cont_i, 1);
        }
    }
}
