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
    LinearLayout gFM;
    TbImageView gKe;
    TextView gKf;
    TbImageView gKg;
    TextView gKh;
    TextView gKi;
    HeadImageView gKj;
    private final int gKk;
    private final int gKl;
    TextView title;

    public RankDetailTrendCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gKk = com.baidu.adp.lib.util.l.aO(tbPageContext.getPageActivity());
        this.gKl = tbPageContext.getResources().getDimensionPixelSize(d.e.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gFM = (LinearLayout) LayoutInflater.from(getContext()).inflate(d.h.card_rank_trend, (ViewGroup) null);
        this.gKe = (TbImageView) A(this.gFM, d.g.leftIcon);
        this.gKf = (TextView) A(this.gFM, d.g.item);
        this.title = (TextView) A(this.gFM, d.g.trend_title);
        this.gKg = (TbImageView) A(this.gFM, d.g.trend);
        this.gKh = (TextView) A(this.gFM, d.g.trend_text);
        this.gKi = (TextView) A(this.gFM, d.g.btn_post);
        this.gKj = (HeadImageView) A(this.gFM, d.g.head);
        this.gKj.setIsRound(true);
        return this.gFM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankDetailTrendCard rankDetailTrendCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.k(this.gFM, d.f.addresslist_item_bg);
        al.j(this.gKf, d.C0236d.cp_cont_c);
        al.j(this.title, d.C0236d.cp_cont_b);
        setTrendTextColor(rankDetailTrendCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard.getRank() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gKj.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(d.e.ds24);
            this.gKj.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gKj.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(d.e.ds20);
            this.gKj.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
            this.gKe.setVisibility(0);
            this.gKe.setImageDrawable(null);
            this.gKe.startLoad(rankDetailTrendCard.getIconUrl(), 10, false);
            this.gKf.setVisibility(8);
        } else if (rankDetailTrendCard.getRank() <= 0) {
            this.gKe.setVisibility(8);
            this.gKf.setVisibility(8);
        } else {
            if (rankDetailTrendCard.getRank() <= 3) {
                this.gKe.setVisibility(0);
                this.gKf.setVisibility(8);
                switch (rankDetailTrendCard.getRank()) {
                    case 1:
                        al.c(this.gKe, d.f.icon_grade_shaitu1);
                        break;
                    case 2:
                        al.c(this.gKe, d.f.icon_grade_shaitu2);
                        break;
                    case 3:
                        al.c(this.gKe, d.f.icon_grade_shaitu3);
                        break;
                    default:
                        this.gKe.setVisibility(8);
                        al.c(this.gKe, d.f.icon_grade_shaitu1);
                        break;
                }
            } else {
                this.gKe.setVisibility(8);
                this.gKf.setVisibility(0);
            }
            if (rankDetailTrendCard.getRank() <= 9) {
                this.gKf.setText("0" + rankDetailTrendCard.getRank() + "");
            } else {
                this.gKf.setText(rankDetailTrendCard.getRank() + "");
            }
            al.j(this.gKf, d.C0236d.cp_cont_c);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
            this.gKi.setVisibility(0);
            a(this.gKi, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
            this.gKi.setTag(rankDetailTrendCard.getPostUrl());
            this.gKi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankDetailTrendCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bc.cZ(RankDetailTrendCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.bzz().a(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
                    }
                }
            });
            this.gKg.setVisibility(8);
            this.gKh.setVisibility(8);
        } else {
            this.gKi.setVisibility(8);
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                this.gKg.setVisibility(0);
                this.gKh.setVisibility(8);
                this.gKg.setImageDrawable(null);
                this.gKg.startLoad(rankDetailTrendCard.getPicTrendUrl(), 10, false);
            } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                this.gKh.setVisibility(0);
                this.gKg.setVisibility(8);
                this.gKh.setText(rankDetailTrendCard.getTrendText());
                setTrendTextColor(rankDetailTrendCard);
                this.gKh.setMaxWidth((this.gKk - this.gKl) / 2);
            } else {
                this.gKh.setVisibility(8);
                switch (rankDetailTrendCard.getPicTrendType()) {
                    case 1:
                        this.gKg.setVisibility(0);
                        al.c(this.gKg, d.f.icon_arrow_ranking_up);
                        break;
                    case 2:
                        this.gKg.setVisibility(0);
                        al.c(this.gKg, d.f.icon_arrow_ranking_keep);
                        break;
                    case 3:
                        this.gKg.setVisibility(0);
                        al.c(this.gKg, d.f.icon_arrow_ranking_down);
                        break;
                    default:
                        this.gKg.setVisibility(8);
                        break;
                }
            }
        }
        al.j(this.title, d.C0236d.cp_cont_b);
        this.title.setText(rankDetailTrendCard.getCardTitle());
        if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
            this.gKj.setVisibility(8);
        } else {
            this.gKj.setVisibility(0);
            this.gKj.setTag(rankDetailTrendCard.getPicUrl());
            this.gKj.startLoad(rankDetailTrendCard.getPicUrl(), 10, false);
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
            a(this.gKh, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), d.C0236d.cp_other_b);
        }
    }
}
