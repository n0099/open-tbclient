package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.RankDetailTrendCard;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes9.dex */
public class RankDetailTrendCardView extends BaseCardView<RankDetailTrendCard> {
    LinearLayout kXe;
    TbImageView lbr;
    TextView lbs;
    TbImageView lbt;
    TextView lbu;
    TextView lbv;
    HeadImageView lbw;
    private final int lbx;
    private final int lby;
    TextView title;

    public RankDetailTrendCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lbx = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.lby = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.kXe = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_trend, (ViewGroup) null);
        this.lbr = (TbImageView) z(this.kXe, R.id.leftIcon);
        this.lbs = (TextView) z(this.kXe, R.id.item);
        this.title = (TextView) z(this.kXe, R.id.trend_title);
        this.lbt = (TbImageView) z(this.kXe, R.id.trend);
        this.lbu = (TextView) z(this.kXe, R.id.trend_text);
        this.lbv = (TextView) z(this.kXe, R.id.btn_post);
        this.lbw = (HeadImageView) z(this.kXe, R.id.head);
        this.lbw.setIsRound(true);
        return this.kXe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankDetailTrendCard rankDetailTrendCard, int i) {
        com.baidu.tbadk.r.a.a(this.eXu, getRootView());
        ao.setBackgroundResource(this.kXe, R.drawable.addresslist_item_bg);
        ao.setViewTextColor(this.lbs, R.color.CAM_X0108);
        ao.setViewTextColor(this.title, R.color.CAM_X0105);
        setTrendTextColor(rankDetailTrendCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard.getRank() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lbw.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
            this.lbw.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lbw.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
            this.lbw.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
            this.lbr.setVisibility(0);
            this.lbr.setImageDrawable(null);
            this.lbr.startLoad(rankDetailTrendCard.getIconUrl(), 10, false);
            this.lbs.setVisibility(8);
        } else if (rankDetailTrendCard.getRank() <= 0) {
            this.lbr.setVisibility(8);
            this.lbs.setVisibility(8);
        } else {
            if (rankDetailTrendCard.getRank() <= 3) {
                this.lbr.setVisibility(0);
                this.lbs.setVisibility(8);
                switch (rankDetailTrendCard.getRank()) {
                    case 1:
                        ao.setImageResource(this.lbr, R.drawable.icon_grade_shaitu1);
                        break;
                    case 2:
                        ao.setImageResource(this.lbr, R.drawable.icon_grade_shaitu2);
                        break;
                    case 3:
                        ao.setImageResource(this.lbr, R.drawable.icon_grade_shaitu3);
                        break;
                    default:
                        this.lbr.setVisibility(8);
                        ao.setImageResource(this.lbr, R.drawable.icon_grade_shaitu1);
                        break;
                }
            } else {
                this.lbr.setVisibility(8);
                this.lbs.setVisibility(0);
            }
            if (rankDetailTrendCard.getRank() <= 9) {
                this.lbs.setText("0" + rankDetailTrendCard.getRank() + "");
            } else {
                this.lbs.setText(rankDetailTrendCard.getRank() + "");
            }
            ao.setViewTextColor(this.lbs, R.color.CAM_X0108);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
            this.lbv.setVisibility(0);
            a(this.lbv, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
            this.lbv.setTag(rankDetailTrendCard.getPostUrl());
            this.lbv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankDetailTrendCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bg.checkUpIsLogin(RankDetailTrendCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.dde().a(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
                    }
                }
            });
            this.lbt.setVisibility(8);
            this.lbu.setVisibility(8);
        } else {
            this.lbv.setVisibility(8);
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                this.lbt.setVisibility(0);
                this.lbu.setVisibility(8);
                this.lbt.setImageDrawable(null);
                this.lbt.startLoad(rankDetailTrendCard.getPicTrendUrl(), 10, false);
            } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                this.lbu.setVisibility(0);
                this.lbt.setVisibility(8);
                this.lbu.setText(rankDetailTrendCard.getTrendText());
                setTrendTextColor(rankDetailTrendCard);
                this.lbu.setMaxWidth((this.lbx - this.lby) / 2);
            } else {
                this.lbu.setVisibility(8);
                switch (rankDetailTrendCard.getPicTrendType()) {
                    case 1:
                        this.lbt.setVisibility(0);
                        ao.setImageResource(this.lbt, R.drawable.icon_arrow_ranking_up);
                        break;
                    case 2:
                        this.lbt.setVisibility(0);
                        ao.setImageResource(this.lbt, R.drawable.icon_arrow_ranking_keep);
                        break;
                    case 3:
                        this.lbt.setVisibility(0);
                        ao.setImageResource(this.lbt, R.drawable.icon_arrow_ranking_down);
                        break;
                    default:
                        this.lbt.setVisibility(8);
                        break;
                }
            }
        }
        ao.setViewTextColor(this.title, R.color.CAM_X0105);
        this.title.setText(rankDetailTrendCard.getCardTitle());
        if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
            this.lbw.setVisibility(8);
        } else {
            this.lbw.setVisibility(0);
            this.lbw.setTag(rankDetailTrendCard.getPicUrl());
            this.lbw.startLoad(rankDetailTrendCard.getPicUrl(), 10, false);
        }
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankDetailTrendCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RankDetailTrendCardView.this.c(rankDetailTrendCard);
            }
        });
    }

    private void setTrendTextColor(RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard != null && !TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
            a(this.lbu, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), R.color.CAM_X0308);
        }
    }
}
