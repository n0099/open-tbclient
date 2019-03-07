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
    private TextView fYJ;
    LinearLayout gFM;
    private TextView gKi;
    private final int gKk;
    private final int gKl;
    private RelativeLayout gKo;
    private TextView gKp;
    private RelativeLayout gKq;
    private TextView gKr;
    private TextView gKs;
    private TextView title;

    public RankScoreCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gKk = com.baidu.adp.lib.util.l.aO(tbPageContext.getPageActivity());
        this.gKl = tbPageContext.getResources().getDimensionPixelSize(d.e.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gFM = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.card_rank_score, (ViewGroup) null);
        this.gKo = (RelativeLayout) A(this.gFM, d.g.rl_content);
        this.title = (TextView) A(this.gFM, d.g.score_title);
        this.fYJ = (TextView) A(this.gFM, d.g.desc);
        this.gKp = (TextView) A(this.gFM, d.g.desc2);
        this.gKq = (RelativeLayout) A(this.gFM, d.g.rl_pic);
        this.eIr = (TbImageView) A(this.gFM, d.g.pic);
        this.gKr = (TextView) A(this.gFM, d.g.leftTopText);
        this.gKs = (TextView) A(this.gFM, d.g.right);
        this.gKi = (TextView) A(this.gFM, d.g.btn_post);
        return this.gFM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankScoreCard rankScoreCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.k(this.gFM, d.f.addresslist_item_bg);
        al.j(this.title, d.C0236d.cp_cont_f);
        al.j(this.fYJ, d.C0236d.cp_cont_f);
        al.j(this.gKs, d.C0236d.cp_other_b);
        setDesc2Color(rankScoreCard);
        setRightScoreColor(rankScoreCard);
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            a(this.gKp, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), d.C0236d.cp_cont_f);
        }
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            a(this.gKs, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), d.C0236d.cp_other_b);
        }
    }

    private void a(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eIr.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gKo.getLayoutParams();
            if (rankScoreCard.getRatio() > 0.0d) {
                layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
            } else {
                layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
            }
            this.eIr.setLayoutParams(layoutParams);
            layoutParams2.height = layoutParams.height;
            this.gKo.setLayoutParams(layoutParams2);
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
            this.fYJ.setVisibility(0);
            this.fYJ.setText(rankScoreCard.getDesc());
        } else {
            this.fYJ.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            this.gKp.setText(rankScoreCard.getDesc2());
            setDesc2Color(rankScoreCard);
            if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                this.gKp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        q.f(RankScoreCardView.this.mContext, rankScoreCard.getD2Scheme());
                    }
                });
            } else {
                this.gKp.setOnClickListener(null);
            }
        } else {
            this.gKp.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
            this.gKi.setVisibility(0);
            a(this.gKi, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
            this.gKi.setTag(rankScoreCard.getPostUrl());
            this.gKi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bc.cZ(RankScoreCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.bzz().a(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
                    }
                }
            });
            this.gKs.setVisibility(8);
        } else {
            this.gKi.setVisibility(8);
            this.gKs.setVisibility(0);
            al.j(this.gKs, d.C0236d.cp_cont_h);
            try {
                this.gKs.setText(ap.as(Long.parseLong(rankScoreCard.getSubTitle())));
            } catch (Exception e) {
                this.gKs.setText(rankScoreCard.getSubTitle());
                setRightScoreColor(rankScoreCard);
            }
            this.gKs.setMaxWidth((this.gKk - this.gKl) / 2);
        }
        a(rankScoreCard);
        if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
            this.gKq.setVisibility(8);
        } else {
            this.gKq.setVisibility(0);
            this.eIr.setTag(rankScoreCard.getPicUrl());
            this.eIr.startLoad(rankScoreCard.getPicUrl(), 10, false);
            if (rankScoreCard.getRank() <= 0) {
                this.gKr.setVisibility(8);
            } else {
                this.gKr.setVisibility(0);
                int rank = rankScoreCard.getRank() - 1;
                if (rank >= 0) {
                    i = rank > 3 ? 3 : rank;
                }
                if (rankScoreCard.getRank() <= 3) {
                    al.j(this.gKr, d.C0236d.cp_btn_a);
                } else {
                    al.j(this.gKr, d.C0236d.cp_cont_g);
                }
                al.l(this.gKr, com.baidu.tieba.lego.a.gEA[i]);
                this.gKr.setText(rankScoreCard.getRank() + "");
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
