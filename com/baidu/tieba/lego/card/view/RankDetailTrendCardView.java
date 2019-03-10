package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.RankDetailTrendCard;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class RankDetailTrendCardView extends BaseCardView<RankDetailTrendCard> {
    LinearLayout gFN;
    TbImageView gKf;
    TextView gKg;
    TbImageView gKh;
    TextView gKi;
    TextView gKj;
    HeadImageView gKk;
    private final int gKl;
    private final int gKm;
    TextView title;

    public RankDetailTrendCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gKl = com.baidu.adp.lib.util.l.aO(tbPageContext.getPageActivity());
        this.gKm = tbPageContext.getResources().getDimensionPixelSize(d.e.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAe() {
        this.gFN = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.card_rank_trend, (ViewGroup) null);
        this.gKf = (TbImageView) A(this.gFN, d.g.leftIcon);
        this.gKg = (TextView) A(this.gFN, d.g.item);
        this.title = (TextView) A(this.gFN, d.g.trend_title);
        this.gKh = (TbImageView) A(this.gFN, d.g.trend);
        this.gKi = (TextView) A(this.gFN, d.g.trend_text);
        this.gKj = (TextView) A(this.gFN, d.g.btn_post);
        this.gKk = (HeadImageView) A(this.gFN, d.g.head);
        this.gKk.setIsRound(true);
        return this.gFN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankDetailTrendCard rankDetailTrendCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.k(this.gFN, d.f.addresslist_item_bg);
        al.j(this.gKg, d.C0236d.cp_cont_c);
        al.j(this.title, d.C0236d.cp_cont_b);
        setTrendTextColor(rankDetailTrendCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard.getRank() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gKk.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(d.e.ds24);
            this.gKk.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gKk.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(d.e.ds20);
            this.gKk.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
            this.gKf.setVisibility(0);
            this.gKf.setImageDrawable(null);
            this.gKf.startLoad(rankDetailTrendCard.getIconUrl(), 10, false);
            this.gKg.setVisibility(8);
        } else if (rankDetailTrendCard.getRank() <= 0) {
            this.gKf.setVisibility(8);
            this.gKg.setVisibility(8);
        } else {
            if (rankDetailTrendCard.getRank() <= 3) {
                this.gKf.setVisibility(0);
                this.gKg.setVisibility(8);
                switch (rankDetailTrendCard.getRank()) {
                    case 1:
                        al.c(this.gKf, d.f.icon_grade_shaitu1);
                        break;
                    case 2:
                        al.c(this.gKf, d.f.icon_grade_shaitu2);
                        break;
                    case 3:
                        al.c(this.gKf, d.f.icon_grade_shaitu3);
                        break;
                    default:
                        this.gKf.setVisibility(8);
                        al.c(this.gKf, d.f.icon_grade_shaitu1);
                        break;
                }
            } else {
                this.gKf.setVisibility(8);
                this.gKg.setVisibility(0);
            }
            if (rankDetailTrendCard.getRank() <= 9) {
                this.gKg.setText("0" + rankDetailTrendCard.getRank() + "");
            } else {
                this.gKg.setText(rankDetailTrendCard.getRank() + "");
            }
            al.j(this.gKg, d.C0236d.cp_cont_c);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
            this.gKj.setVisibility(0);
            a(this.gKj, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
            this.gKj.setTag(rankDetailTrendCard.getPostUrl());
            this.gKj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankDetailTrendCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bc.cZ(RankDetailTrendCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.bzA().a(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
                    }
                }
            });
            this.gKh.setVisibility(8);
            this.gKi.setVisibility(8);
        } else {
            this.gKj.setVisibility(8);
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                this.gKh.setVisibility(0);
                this.gKi.setVisibility(8);
                this.gKh.setImageDrawable(null);
                this.gKh.startLoad(rankDetailTrendCard.getPicTrendUrl(), 10, false);
            } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                this.gKi.setVisibility(0);
                this.gKh.setVisibility(8);
                this.gKi.setText(rankDetailTrendCard.getTrendText());
                setTrendTextColor(rankDetailTrendCard);
                this.gKi.setMaxWidth((this.gKl - this.gKm) / 2);
            } else {
                this.gKi.setVisibility(8);
                switch (rankDetailTrendCard.getPicTrendType()) {
                    case 1:
                        this.gKh.setVisibility(0);
                        al.c(this.gKh, d.f.icon_arrow_ranking_up);
                        break;
                    case 2:
                        this.gKh.setVisibility(0);
                        al.c(this.gKh, d.f.icon_arrow_ranking_keep);
                        break;
                    case 3:
                        this.gKh.setVisibility(0);
                        al.c(this.gKh, d.f.icon_arrow_ranking_down);
                        break;
                    default:
                        this.gKh.setVisibility(8);
                        break;
                }
            }
        }
        al.j(this.title, d.C0236d.cp_cont_b);
        this.title.setText(rankDetailTrendCard.getCardTitle());
        if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
            this.gKk.setVisibility(8);
        } else {
            this.gKk.setVisibility(0);
            this.gKk.setTag(rankDetailTrendCard.getPicUrl());
            this.gKk.startLoad(rankDetailTrendCard.getPicUrl(), 10, false);
        }
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankDetailTrendCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RankDetailTrendCardView.this.d(rankDetailTrendCard);
            }
        });
    }

    private void setTrendTextColor(RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard != null && !TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
            a(this.gKi, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), d.C0236d.cp_other_b);
        }
    }
}
