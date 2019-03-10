package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.RankScoreCard;
import com.baidu.tieba.tbadkCore.q;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class RankScoreCardView extends BaseCardView<RankScoreCard> {
    private TbImageView eIr;
    private TextView fYK;
    LinearLayout gFN;
    private TextView gKj;
    private final int gKl;
    private final int gKm;
    private RelativeLayout gKp;
    private TextView gKq;
    private RelativeLayout gKr;
    private TextView gKs;
    private TextView gKt;
    private TextView title;

    public RankScoreCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gKl = com.baidu.adp.lib.util.l.aO(tbPageContext.getPageActivity());
        this.gKm = tbPageContext.getResources().getDimensionPixelSize(d.e.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAe() {
        this.gFN = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.card_rank_score, (ViewGroup) null);
        this.gKp = (RelativeLayout) A(this.gFN, d.g.rl_content);
        this.title = (TextView) A(this.gFN, d.g.score_title);
        this.fYK = (TextView) A(this.gFN, d.g.desc);
        this.gKq = (TextView) A(this.gFN, d.g.desc2);
        this.gKr = (RelativeLayout) A(this.gFN, d.g.rl_pic);
        this.eIr = (TbImageView) A(this.gFN, d.g.pic);
        this.gKs = (TextView) A(this.gFN, d.g.leftTopText);
        this.gKt = (TextView) A(this.gFN, d.g.right);
        this.gKj = (TextView) A(this.gFN, d.g.btn_post);
        return this.gFN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankScoreCard rankScoreCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.k(this.gFN, d.f.addresslist_item_bg);
        al.j(this.title, d.C0236d.cp_cont_f);
        al.j(this.fYK, d.C0236d.cp_cont_f);
        al.j(this.gKt, d.C0236d.cp_other_b);
        setDesc2Color(rankScoreCard);
        setRightScoreColor(rankScoreCard);
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            a(this.gKq, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), d.C0236d.cp_cont_f);
        }
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            a(this.gKt, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), d.C0236d.cp_other_b);
        }
    }

    private void a(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eIr.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gKp.getLayoutParams();
            if (rankScoreCard.getRatio() > 0.0d) {
                layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
            } else {
                layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
            }
            this.eIr.setLayoutParams(layoutParams);
            layoutParams2.height = layoutParams.height;
            this.gKp.setLayoutParams(layoutParams2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(final RankScoreCard rankScoreCard) {
        int i = 0;
        if (!TextUtils.isEmpty(rankScoreCard.getCardTitle())) {
            this.title.setVisibility(0);
            this.title.setText(rankScoreCard.getCardTitle());
        } else {
            this.title.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc())) {
            this.fYK.setVisibility(0);
            this.fYK.setText(rankScoreCard.getDesc());
        } else {
            this.fYK.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            this.gKq.setText(rankScoreCard.getDesc2());
            setDesc2Color(rankScoreCard);
            if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                this.gKq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        q.f(RankScoreCardView.this.mContext, rankScoreCard.getD2Scheme());
                    }
                });
            } else {
                this.gKq.setOnClickListener(null);
            }
        } else {
            this.gKq.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
            this.gKj.setVisibility(0);
            a(this.gKj, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
            this.gKj.setTag(rankScoreCard.getPostUrl());
            this.gKj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bc.cZ(RankScoreCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.bzA().a(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
                    }
                }
            });
            this.gKt.setVisibility(8);
        } else {
            this.gKj.setVisibility(8);
            this.gKt.setVisibility(0);
            al.j(this.gKt, d.C0236d.cp_cont_h);
            try {
                this.gKt.setText(ap.as(Long.parseLong(rankScoreCard.getSubTitle())));
            } catch (Exception e) {
                this.gKt.setText(rankScoreCard.getSubTitle());
                setRightScoreColor(rankScoreCard);
            }
            this.gKt.setMaxWidth((this.gKl - this.gKm) / 2);
        }
        a(rankScoreCard);
        if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
            this.gKr.setVisibility(8);
        } else {
            this.gKr.setVisibility(0);
            this.eIr.setTag(rankScoreCard.getPicUrl());
            this.eIr.startLoad(rankScoreCard.getPicUrl(), 10, false);
            if (rankScoreCard.getRank() <= 0) {
                this.gKs.setVisibility(8);
            } else {
                this.gKs.setVisibility(0);
                int rank = rankScoreCard.getRank() - 1;
                if (rank >= 0) {
                    i = rank > 3 ? 3 : rank;
                }
                if (rankScoreCard.getRank() <= 3) {
                    al.j(this.gKs, d.C0236d.cp_btn_a);
                } else {
                    al.j(this.gKs, d.C0236d.cp_cont_g);
                }
                al.l(this.gKs, com.baidu.tieba.lego.a.gEB[i]);
                this.gKs.setText(rankScoreCard.getRank() + "");
            }
        }
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RankScoreCardView.this.d(rankScoreCard);
            }
        });
    }
}
