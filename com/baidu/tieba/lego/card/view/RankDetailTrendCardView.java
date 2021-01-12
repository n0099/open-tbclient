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
/* loaded from: classes8.dex */
public class RankDetailTrendCardView extends BaseCardView<RankDetailTrendCard> {
    LinearLayout kSz;
    TbImageView kWL;
    TextView kWM;
    TbImageView kWN;
    TextView kWO;
    TextView kWP;
    HeadImageView kWQ;
    private final int kWR;
    private final int kWS;
    TextView title;

    public RankDetailTrendCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kWR = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.kWS = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.kSz = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_trend, (ViewGroup) null);
        this.kWL = (TbImageView) z(this.kSz, R.id.leftIcon);
        this.kWM = (TextView) z(this.kSz, R.id.item);
        this.title = (TextView) z(this.kSz, R.id.trend_title);
        this.kWN = (TbImageView) z(this.kSz, R.id.trend);
        this.kWO = (TextView) z(this.kSz, R.id.trend_text);
        this.kWP = (TextView) z(this.kSz, R.id.btn_post);
        this.kWQ = (HeadImageView) z(this.kSz, R.id.head);
        this.kWQ.setIsRound(true);
        return this.kSz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankDetailTrendCard rankDetailTrendCard, int i) {
        com.baidu.tbadk.r.a.a(this.eSJ, getRootView());
        ao.setBackgroundResource(this.kSz, R.drawable.addresslist_item_bg);
        ao.setViewTextColor(this.kWM, R.color.CAM_X0108);
        ao.setViewTextColor(this.title, R.color.CAM_X0105);
        setTrendTextColor(rankDetailTrendCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard.getRank() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kWQ.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
            this.kWQ.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kWQ.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
            this.kWQ.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
            this.kWL.setVisibility(0);
            this.kWL.setImageDrawable(null);
            this.kWL.startLoad(rankDetailTrendCard.getIconUrl(), 10, false);
            this.kWM.setVisibility(8);
        } else if (rankDetailTrendCard.getRank() <= 0) {
            this.kWL.setVisibility(8);
            this.kWM.setVisibility(8);
        } else {
            if (rankDetailTrendCard.getRank() <= 3) {
                this.kWL.setVisibility(0);
                this.kWM.setVisibility(8);
                switch (rankDetailTrendCard.getRank()) {
                    case 1:
                        ao.setImageResource(this.kWL, R.drawable.icon_grade_shaitu1);
                        break;
                    case 2:
                        ao.setImageResource(this.kWL, R.drawable.icon_grade_shaitu2);
                        break;
                    case 3:
                        ao.setImageResource(this.kWL, R.drawable.icon_grade_shaitu3);
                        break;
                    default:
                        this.kWL.setVisibility(8);
                        ao.setImageResource(this.kWL, R.drawable.icon_grade_shaitu1);
                        break;
                }
            } else {
                this.kWL.setVisibility(8);
                this.kWM.setVisibility(0);
            }
            if (rankDetailTrendCard.getRank() <= 9) {
                this.kWM.setText("0" + rankDetailTrendCard.getRank() + "");
            } else {
                this.kWM.setText(rankDetailTrendCard.getRank() + "");
            }
            ao.setViewTextColor(this.kWM, R.color.CAM_X0108);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
            this.kWP.setVisibility(0);
            a(this.kWP, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
            this.kWP.setTag(rankDetailTrendCard.getPostUrl());
            this.kWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankDetailTrendCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bg.checkUpIsLogin(RankDetailTrendCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.cZm().a(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
                    }
                }
            });
            this.kWN.setVisibility(8);
            this.kWO.setVisibility(8);
        } else {
            this.kWP.setVisibility(8);
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                this.kWN.setVisibility(0);
                this.kWO.setVisibility(8);
                this.kWN.setImageDrawable(null);
                this.kWN.startLoad(rankDetailTrendCard.getPicTrendUrl(), 10, false);
            } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                this.kWO.setVisibility(0);
                this.kWN.setVisibility(8);
                this.kWO.setText(rankDetailTrendCard.getTrendText());
                setTrendTextColor(rankDetailTrendCard);
                this.kWO.setMaxWidth((this.kWR - this.kWS) / 2);
            } else {
                this.kWO.setVisibility(8);
                switch (rankDetailTrendCard.getPicTrendType()) {
                    case 1:
                        this.kWN.setVisibility(0);
                        ao.setImageResource(this.kWN, R.drawable.icon_arrow_ranking_up);
                        break;
                    case 2:
                        this.kWN.setVisibility(0);
                        ao.setImageResource(this.kWN, R.drawable.icon_arrow_ranking_keep);
                        break;
                    case 3:
                        this.kWN.setVisibility(0);
                        ao.setImageResource(this.kWN, R.drawable.icon_arrow_ranking_down);
                        break;
                    default:
                        this.kWN.setVisibility(8);
                        break;
                }
            }
        }
        ao.setViewTextColor(this.title, R.color.CAM_X0105);
        this.title.setText(rankDetailTrendCard.getCardTitle());
        if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
            this.kWQ.setVisibility(8);
        } else {
            this.kWQ.setVisibility(0);
            this.kWQ.setTag(rankDetailTrendCard.getPicUrl());
            this.kWQ.startLoad(rankDetailTrendCard.getPicUrl(), 10, false);
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
            a(this.kWO, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), R.color.CAM_X0308);
        }
    }
}
