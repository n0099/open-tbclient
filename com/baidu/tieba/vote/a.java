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
    private com.baidu.tbadk.widget.vote.b aOZ;
    private PbActivity elf;
    private View fRe;
    private VotePhotoGroupView fRf;
    private VoteTextGroupView fRg;
    private VoteView fRh;
    private LinearLayout fRi;
    private TextView fRj;
    private TextView fRk;
    private TextView fRl;
    private TextView fRm;
    private VoteDataInfo fRn;
    private final List<f> fRo;
    private boolean fRp;
    private h fRq;
    private final com.baidu.adp.framework.listener.a fRr;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.fRe != null) {
            this.fRe.setVisibility(i);
        }
    }

    public void bmw() {
        if (this.fRf != null) {
            this.fRf.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.fRo = new ArrayList();
        this.fRp = false;
        this.maxWidth = 0;
        this.aOZ = new b(this);
        this.fRr = new c(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new d(this);
        this.elf = pbActivity;
        pbActivity.registerListener(this.fRr);
        this.maxWidth = k.af(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds120);
        this.fRq = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aIz() != null && fVar.aIB() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aIz().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aIB().getId(), 0L);
            if (fVar.aIB().sg() && fVar.aIB().rj() != null) {
                if (this.fRe == null) {
                    this.fRe = ((ViewStub) view.findViewById(w.h.vote_card_layout)).inflate();
                    this.fRm = (TextView) this.fRe.findViewById(w.h.btn_pb_vote);
                    this.fRn = fVar.aIy();
                    b((PostData) x.c(fVar.aID(), 0), this.fRe);
                    a(this.fRn, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.fRe.isShown()) {
                    this.fRe.setVisibility(0);
                }
            } else if (this.fRe != null && this.fRe.isShown()) {
                this.fRe.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.fRi = (LinearLayout) view.findViewById(w.h.pb_vote_location_container);
        this.fRj = (TextView) view.findViewById(w.h.pb_vote_first_floor_name);
        this.fRk = (TextView) view.findViewById(w.h.pb_item_vote_reply_time);
        this.fRl = (TextView) view.findViewById(w.h.pb_item_vote_location_address);
        g gVar = null;
        if (postData != null) {
            this.fRk.setText(postData.bii());
            gVar = postData.bij();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            String name = gVar.getName();
            String lat = gVar.getLat();
            String lng = gVar.getLng();
            this.fRl.setVisibility(0);
            this.fRl.setText(gVar.getName());
            this.fRl.setOnClickListener(new e(this, lat, lng, name));
            return;
        }
        this.fRl.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.fRn = voteDataInfo;
        if (this.fRn != null) {
            if (this.fRn.getStatus() == 2 || this.fRn.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fRn.getOptions()) {
                    if (aVar != null && (aVar instanceof f)) {
                        ((f) aVar).setSelected(false);
                    }
                }
            }
            aRv();
            if (this.fRn.getVoteType() == 1) {
                if (this.fRn.getStatus() == 2 || this.fRn.getIsPolled() == 1) {
                    lP(z);
                } else {
                    bmx();
                }
            } else if (this.fRn.getVoteType() == 2) {
                if (this.fRn.getStatus() == 2 || this.fRn.getIsPolled() == 1) {
                    F(2, z);
                } else {
                    F(this.fRn.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void F(int i, boolean z) {
        if (this.fRe != null && this.fRn != null) {
            this.fRf = (VotePhotoGroupView) this.fRe.findViewById(w.h.picvote_view);
            this.fRf.setOnVoteCheckedChangedListener(this.aOZ);
            this.fRf.setVisibility(0);
            this.fRf.setMode(i);
            this.fRf.a(this.fRn.getOptions(), z, this.fRn.getIsPolled() == 1);
        }
    }

    private void aRv() {
        if (this.fRe != null && this.fRn != null) {
            ((TextView) this.fRe.findViewById(w.h.tv_vote_endtime)).setText(this.fRn.getTips());
            ((TextView) this.fRe.findViewById(w.h.vote_num)).setText(getPageContext().getPageActivity().getString(w.l.pb_vote_num, new Object[]{Long.valueOf(this.fRn.getTotalNum())}));
            bmz();
        }
    }

    private void bmx() {
        if (this.fRe != null && this.fRn != null) {
            this.fRg = (VoteTextGroupView) this.fRe.findViewById(w.h.textvote_view);
            this.fRg.setOnVoteCheckedChangedListener(this.aOZ);
            this.fRg.setVisibility(0);
            this.fRg.setMode(this.fRn.getIsMulti() == 1 ? 1 : 2);
            this.fRg.C(this.fRn.getOptions());
            this.fRg.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void lP(boolean z) {
        if (this.fRe != null && this.fRn != null) {
            this.fRf = (VotePhotoGroupView) this.fRe.findViewById(w.h.picvote_view);
            this.fRg = (VoteTextGroupView) this.fRe.findViewById(w.h.textvote_view);
            this.fRh = (VoteView) this.fRe.findViewById(w.h.result_vote_view);
            this.fRg.setVisibility(8);
            this.fRf.setVisibility(8);
            this.fRh.setVisibility(0);
            this.fRh.setWidth(this.maxWidth);
            this.fRh.a(this.fRn.getOptions(), z);
            this.fRh.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmy() {
        if (this.fRn != null) {
            if (this.fRq != null && this.elf != null) {
                this.fRq.c(this.elf.getActivity().getString(w.l.vote_succ));
            }
            this.fRn.setIsPolled(1);
            this.fRn.setTotalNum(this.fRn.getTotalNum() + 1);
            this.fRn.setTotalPoll(this.fRn.getTotalPoll() + this.fRo.size());
            for (f fVar : this.fRo) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.fRn.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.fRn.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.cg((int) ((fVar2.getNum() * 100) / this.fRn.getTotalPoll()));
                    }
                }
            }
            a(this.fRn, true);
            this.fRo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.fRe != null) {
            com.baidu.tbadk.m.a.a(this.elf.getPageContext(), this.fRe);
        }
        bmz();
    }

    private void bmz() {
        if (this.fRm != null && this.fRn != null) {
            if (this.fRn.getStatus() == 2) {
                aq.j(this.fRm, w.g.bg_gray_circle);
                this.fRm.setText(getPageContext().getString(w.l.pb_vote_over));
                this.fRm.setEnabled(false);
            } else if (this.fRn.getIsPolled() == 1) {
                aq.j(this.fRm, w.g.bg_gray_circle);
                this.fRm.setText(getPageContext().getString(w.l.pb_voted));
                this.fRm.setEnabled(false);
            } else if (this.fRn.getIsPolled() == 0) {
                aq.j(this.fRm, w.g.btn_pb_vote_selector);
                this.fRm.setText(getPageContext().getString(w.l.vote));
                this.fRm.setEnabled(true);
                this.fRm.setOnClickListener(this.mOnClickListener);
            }
            aq.c(this.fRm, w.e.cp_cont_i, 1);
        }
    }
}
