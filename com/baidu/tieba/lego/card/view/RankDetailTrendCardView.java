package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.RankDetailTrendCard;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes9.dex */
public class RankDetailTrendCardView extends BaseCardView<RankDetailTrendCard> {
    LinearLayout laC;
    TbImageView leP;
    TextView leQ;
    TbImageView leR;
    TextView leS;
    TextView leT;
    HeadImageView leU;
    private final int leV;
    private final int leW;
    TextView title;

    public RankDetailTrendCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.leV = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.leW = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.laC = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_trend, (ViewGroup) null);
        this.leP = (TbImageView) z(this.laC, R.id.leftIcon);
        this.leQ = (TextView) z(this.laC, R.id.item);
        this.title = (TextView) z(this.laC, R.id.trend_title);
        this.leR = (TbImageView) z(this.laC, R.id.trend);
        this.leS = (TextView) z(this.laC, R.id.trend_text);
        this.leT = (TextView) z(this.laC, R.id.btn_post);
        this.leU = (HeadImageView) z(this.laC, R.id.head);
        this.leU.setIsRound(true);
        return this.laC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankDetailTrendCard rankDetailTrendCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundResource(this.laC, R.drawable.addresslist_item_bg);
        ap.setViewTextColor(this.leQ, R.color.CAM_X0108);
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        setTrendTextColor(rankDetailTrendCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard.getRank() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.leU.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
            this.leU.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.leU.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
            this.leU.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
            this.leP.setVisibility(0);
            this.leP.setImageDrawable(null);
            this.leP.startLoad(rankDetailTrendCard.getIconUrl(), 10, false);
            this.leQ.setVisibility(8);
        } else if (rankDetailTrendCard.getRank() <= 0) {
            this.leP.setVisibility(8);
            this.leQ.setVisibility(8);
        } else {
            if (rankDetailTrendCard.getRank() <= 3) {
                this.leP.setVisibility(0);
                this.leQ.setVisibility(8);
                switch (rankDetailTrendCard.getRank()) {
                    case 1:
                        ap.setImageResource(this.leP, R.drawable.icon_grade_shaitu1);
                        break;
                    case 2:
                        ap.setImageResource(this.leP, R.drawable.icon_grade_shaitu2);
                        break;
                    case 3:
                        ap.setImageResource(this.leP, R.drawable.icon_grade_shaitu3);
                        break;
                    default:
                        this.leP.setVisibility(8);
                        ap.setImageResource(this.leP, R.drawable.icon_grade_shaitu1);
                        break;
                }
            } else {
                this.leP.setVisibility(8);
                this.leQ.setVisibility(0);
            }
            if (rankDetailTrendCard.getRank() <= 9) {
                this.leQ.setText("0" + rankDetailTrendCard.getRank() + "");
            } else {
                this.leQ.setText(rankDetailTrendCard.getRank() + "");
            }
            ap.setViewTextColor(this.leQ, R.color.CAM_X0108);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
            this.leT.setVisibility(0);
            a(this.leT, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
            this.leT.setTag(rankDetailTrendCard.getPostUrl());
            this.leT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankDetailTrendCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bh.checkUpIsLogin(RankDetailTrendCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.dbk().a(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
                    }
                }
            });
            this.leR.setVisibility(8);
            this.leS.setVisibility(8);
        } else {
            this.leT.setVisibility(8);
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                this.leR.setVisibility(0);
                this.leS.setVisibility(8);
                this.leR.setImageDrawable(null);
                this.leR.startLoad(rankDetailTrendCard.getPicTrendUrl(), 10, false);
            } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                this.leS.setVisibility(0);
                this.leR.setVisibility(8);
                this.leS.setText(rankDetailTrendCard.getTrendText());
                setTrendTextColor(rankDetailTrendCard);
                this.leS.setMaxWidth((this.leV - this.leW) / 2);
            } else {
                this.leS.setVisibility(8);
                switch (rankDetailTrendCard.getPicTrendType()) {
                    case 1:
                        this.leR.setVisibility(0);
                        ap.setImageResource(this.leR, R.drawable.icon_arrow_ranking_up);
                        break;
                    case 2:
                        this.leR.setVisibility(0);
                        ap.setImageResource(this.leR, R.drawable.icon_arrow_ranking_keep);
                        break;
                    case 3:
                        this.leR.setVisibility(0);
                        ap.setImageResource(this.leR, R.drawable.icon_arrow_ranking_down);
                        break;
                    default:
                        this.leR.setVisibility(8);
                        break;
                }
            }
        }
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        this.title.setText(rankDetailTrendCard.getCardTitle());
        if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
            this.leU.setVisibility(8);
        } else {
            this.leU.setVisibility(0);
            this.leU.setTag(rankDetailTrendCard.getPicUrl());
            this.leU.startLoad(rankDetailTrendCard.getPicUrl(), 10, false);
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
            a(this.leS, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), R.color.CAM_X0308);
        }
    }
}
