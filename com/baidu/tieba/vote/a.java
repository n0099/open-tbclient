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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.z;
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
    private com.baidu.tbadk.widget.vote.b aQr;
    private PbActivity euf;
    private View gbk;
    private VotePhotoGroupView gbl;
    private VoteTextGroupView gbm;
    private VoteView gbn;
    private LinearLayout gbo;
    private TextView gbp;
    private TextView gbq;
    private TextView gbr;
    private TextView gbs;
    private VoteDataInfo gbt;
    private final List<f> gbu;
    private boolean gbv;
    private h gbw;
    private final com.baidu.adp.framework.listener.a gbx;
    private long mForumId;
    private final View.OnClickListener mOnClickListener;
    private int mSkinType;
    private long mThreadId;
    private int maxWidth;

    public void setVisibility(int i) {
        if (this.gbk != null) {
            this.gbk.setVisibility(i);
        }
    }

    public void bqH() {
        if (this.gbl != null) {
            this.gbl.setPadding(0, 0, 0, 0);
        }
    }

    public a(PbActivity pbActivity) {
        super(pbActivity.getPageContext());
        this.mSkinType = 3;
        this.gbu = new ArrayList();
        this.gbv = false;
        this.maxWidth = 0;
        this.aQr = new b(this);
        this.gbx = new c(this, CmdConfigHttp.CMD_ADD_VOTE, 309006);
        this.mOnClickListener = new d(this);
        this.euf = pbActivity;
        pbActivity.registerListener(this.gbx);
        this.maxWidth = k.af(TbadkCoreApplication.m9getInst()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds120);
        this.gbw = new h();
    }

    public void a(View view, com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.aMt() != null && fVar.aMv() != null && view != null) {
            this.mForumId = com.baidu.adp.lib.g.b.c(fVar.aMt().getId(), 0L);
            this.mThreadId = com.baidu.adp.lib.g.b.c(fVar.aMv().getId(), 0L);
            if (fVar.aMv().sd() && fVar.aMv().rg() != null) {
                if (this.gbk == null) {
                    this.gbk = ((ViewStub) view.findViewById(w.h.vote_card_layout)).inflate();
                    this.gbs = (TextView) this.gbk.findViewById(w.h.btn_pb_vote);
                    this.gbt = fVar.aMs();
                    b((PostData) z.c(fVar.aMx(), 0), this.gbk);
                    a(this.gbt, false);
                }
                if (this.mSkinType != TbadkCoreApplication.m9getInst().getSkinType()) {
                    onChangeSkinType();
                }
                this.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
                if (!this.gbk.isShown()) {
                    this.gbk.setVisibility(0);
                }
            } else if (this.gbk != null && this.gbk.isShown()) {
                this.gbk.setVisibility(8);
            }
        }
    }

    private void b(PostData postData, View view) {
        this.gbo = (LinearLayout) view.findViewById(w.h.pb_vote_location_container);
        this.gbp = (TextView) view.findViewById(w.h.pb_vote_first_floor_name);
        this.gbq = (TextView) view.findViewById(w.h.pb_item_vote_reply_time);
        this.gbr = (TextView) view.findViewById(w.h.pb_item_vote_location_address);
        g gVar = null;
        if (postData != null) {
            this.gbq.setText(postData.bmw());
            gVar = postData.bmx();
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.getName()) && !TextUtils.isEmpty(gVar.getName().trim())) {
            String name = gVar.getName();
            String lat = gVar.getLat();
            String lng = gVar.getLng();
            this.gbr.setVisibility(0);
            this.gbr.setText(gVar.getName());
            this.gbr.setOnClickListener(new e(this, lat, lng, name));
            return;
        }
        this.gbr.setVisibility(8);
    }

    private void a(VoteDataInfo voteDataInfo, boolean z) {
        this.gbt = voteDataInfo;
        if (this.gbt != null) {
            if (this.gbt.getStatus() == 2 || this.gbt.getIsPolled() == 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gbt.getOptions()) {
                    if (aVar != null && (aVar instanceof f)) {
                        ((f) aVar).setSelected(false);
                    }
                }
            }
            aVD();
            if (this.gbt.getVoteType() == 1) {
                if (this.gbt.getStatus() == 2 || this.gbt.getIsPolled() == 1) {
                    mp(z);
                } else {
                    bqI();
                }
            } else if (this.gbt.getVoteType() == 2) {
                if (this.gbt.getStatus() == 2 || this.gbt.getIsPolled() == 1) {
                    F(2, z);
                } else {
                    F(this.gbt.getIsMulti() == 1 ? 1 : 3, z);
                }
            }
        }
    }

    private void F(int i, boolean z) {
        if (this.gbk != null && this.gbt != null) {
            this.gbl = (VotePhotoGroupView) this.gbk.findViewById(w.h.picvote_view);
            this.gbl.setOnVoteCheckedChangedListener(this.aQr);
            this.gbl.setVisibility(0);
            this.gbl.setMode(i);
            this.gbl.a(this.gbt.getOptions(), z, this.gbt.getIsPolled() == 1);
        }
    }

    private void aVD() {
        if (this.gbk != null && this.gbt != null) {
            ((TextView) this.gbk.findViewById(w.h.tv_vote_endtime)).setText(this.gbt.getTips());
            ((TextView) this.gbk.findViewById(w.h.vote_num)).setText(getPageContext().getPageActivity().getString(w.l.pb_vote_num, new Object[]{Long.valueOf(this.gbt.getTotalNum())}));
            bqK();
        }
    }

    private void bqI() {
        if (this.gbk != null && this.gbt != null) {
            this.gbm = (VoteTextGroupView) this.gbk.findViewById(w.h.textvote_view);
            this.gbm.setOnVoteCheckedChangedListener(this.aQr);
            this.gbm.setVisibility(0);
            this.gbm.setMode(this.gbt.getIsMulti() == 1 ? 1 : 2);
            this.gbm.E(this.gbt.getOptions());
            this.gbm.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    private void mp(boolean z) {
        if (this.gbk != null && this.gbt != null) {
            this.gbl = (VotePhotoGroupView) this.gbk.findViewById(w.h.picvote_view);
            this.gbm = (VoteTextGroupView) this.gbk.findViewById(w.h.textvote_view);
            this.gbn = (VoteView) this.gbk.findViewById(w.h.result_vote_view);
            this.gbm.setVisibility(8);
            this.gbl.setVisibility(8);
            this.gbn.setVisibility(0);
            this.gbn.setWidth(this.maxWidth);
            this.gbn.b(this.gbt.getOptions(), z);
            this.gbn.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqJ() {
        if (this.gbt != null) {
            if (this.gbw != null && this.euf != null) {
                this.gbw.c(this.euf.getActivity().getString(w.l.vote_succ));
            }
            this.gbt.setIsPolled(1);
            this.gbt.setTotalNum(this.gbt.getTotalNum() + 1);
            this.gbt.setTotalPoll(this.gbt.getTotalPoll() + this.gbu.size());
            for (f fVar : this.gbu) {
                if (fVar != null) {
                    fVar.setNum(fVar.getNum() + 1);
                }
            }
            if (this.gbt.getTotalPoll() > 0) {
                for (com.baidu.tbadk.widget.vote.a aVar : this.gbt.getOptions()) {
                    if (aVar instanceof f) {
                        f fVar2 = (f) aVar;
                        fVar2.cg((int) ((fVar2.getNum() * 100) / this.gbt.getTotalPoll()));
                    }
                }
            }
            a(this.gbt, true);
            this.gbu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkMessageIsBelongToCurPage(ResponsedMessage<?> responsedMessage) {
        return (responsedMessage == null || this.mContext == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != this.mContext.getUniqueId()) ? false : true;
    }

    public void onChangeSkinType() {
        if (this.gbk != null) {
            com.baidu.tbadk.m.a.a(this.euf.getPageContext(), this.gbk);
        }
        bqK();
    }

    private void bqK() {
        if (this.gbs != null && this.gbt != null) {
            if (this.gbt.getStatus() == 2) {
                as.j(this.gbs, w.g.bg_gray_circle);
                this.gbs.setText(getPageContext().getString(w.l.pb_vote_over));
                this.gbs.setEnabled(false);
            } else if (this.gbt.getIsPolled() == 1) {
                as.j(this.gbs, w.g.bg_gray_circle);
                this.gbs.setText(getPageContext().getString(w.l.pb_voted));
                this.gbs.setEnabled(false);
            } else if (this.gbt.getIsPolled() == 0) {
                as.j(this.gbs, w.g.btn_pb_vote_selector);
                this.gbs.setText(getPageContext().getString(w.l.vote));
                this.gbs.setEnabled(true);
                this.gbs.setOnClickListener(this.mOnClickListener);
            }
            as.c(this.gbs, w.e.cp_cont_i, 1);
        }
    }
}
