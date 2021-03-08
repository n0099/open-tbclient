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
/* loaded from: classes8.dex */
public class RankDetailTrendCardView extends BaseCardView<RankDetailTrendCard> {
    LinearLayout lcT;
    TbImageView lhf;
    TextView lhg;
    TbImageView lhh;
    TextView lhi;
    TextView lhj;
    HeadImageView lhk;
    private final int lhl;
    private final int lhm;
    TextView title;

    public RankDetailTrendCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lhl = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.lhm = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.lcT = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_trend, (ViewGroup) null);
        this.lhf = (TbImageView) z(this.lcT, R.id.leftIcon);
        this.lhg = (TextView) z(this.lcT, R.id.item);
        this.title = (TextView) z(this.lcT, R.id.trend_title);
        this.lhh = (TbImageView) z(this.lcT, R.id.trend);
        this.lhi = (TextView) z(this.lcT, R.id.trend_text);
        this.lhj = (TextView) z(this.lcT, R.id.btn_post);
        this.lhk = (HeadImageView) z(this.lcT, R.id.head);
        this.lhk.setIsRound(true);
        return this.lcT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankDetailTrendCard rankDetailTrendCard, int i) {
        com.baidu.tbadk.r.a.a(this.eWx, getRootView());
        ap.setBackgroundResource(this.lcT, R.drawable.addresslist_item_bg);
        ap.setViewTextColor(this.lhg, R.color.CAM_X0108);
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        setTrendTextColor(rankDetailTrendCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard.getRank() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lhk.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
            this.lhk.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lhk.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
            this.lhk.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
            this.lhf.setVisibility(0);
            this.lhf.setImageDrawable(null);
            this.lhf.startLoad(rankDetailTrendCard.getIconUrl(), 10, false);
            this.lhg.setVisibility(8);
        } else if (rankDetailTrendCard.getRank() <= 0) {
            this.lhf.setVisibility(8);
            this.lhg.setVisibility(8);
        } else {
            if (rankDetailTrendCard.getRank() <= 3) {
                this.lhf.setVisibility(0);
                this.lhg.setVisibility(8);
                switch (rankDetailTrendCard.getRank()) {
                    case 1:
                        ap.setImageResource(this.lhf, R.drawable.icon_grade_shaitu1);
                        break;
                    case 2:
                        ap.setImageResource(this.lhf, R.drawable.icon_grade_shaitu2);
                        break;
                    case 3:
                        ap.setImageResource(this.lhf, R.drawable.icon_grade_shaitu3);
                        break;
                    default:
                        this.lhf.setVisibility(8);
                        ap.setImageResource(this.lhf, R.drawable.icon_grade_shaitu1);
                        break;
                }
            } else {
                this.lhf.setVisibility(8);
                this.lhg.setVisibility(0);
            }
            if (rankDetailTrendCard.getRank() <= 9) {
                this.lhg.setText("0" + rankDetailTrendCard.getRank() + "");
            } else {
                this.lhg.setText(rankDetailTrendCard.getRank() + "");
            }
            ap.setViewTextColor(this.lhg, R.color.CAM_X0108);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
            this.lhj.setVisibility(0);
            a(this.lhj, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
            this.lhj.setTag(rankDetailTrendCard.getPostUrl());
            this.lhj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankDetailTrendCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bh.checkUpIsLogin(RankDetailTrendCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.dbA().a(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
                    }
                }
            });
            this.lhh.setVisibility(8);
            this.lhi.setVisibility(8);
        } else {
            this.lhj.setVisibility(8);
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                this.lhh.setVisibility(0);
                this.lhi.setVisibility(8);
                this.lhh.setImageDrawable(null);
                this.lhh.startLoad(rankDetailTrendCard.getPicTrendUrl(), 10, false);
            } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                this.lhi.setVisibility(0);
                this.lhh.setVisibility(8);
                this.lhi.setText(rankDetailTrendCard.getTrendText());
                setTrendTextColor(rankDetailTrendCard);
                this.lhi.setMaxWidth((this.lhl - this.lhm) / 2);
            } else {
                this.lhi.setVisibility(8);
                switch (rankDetailTrendCard.getPicTrendType()) {
                    case 1:
                        this.lhh.setVisibility(0);
                        ap.setImageResource(this.lhh, R.drawable.icon_arrow_ranking_up);
                        break;
                    case 2:
                        this.lhh.setVisibility(0);
                        ap.setImageResource(this.lhh, R.drawable.icon_arrow_ranking_keep);
                        break;
                    case 3:
                        this.lhh.setVisibility(0);
                        ap.setImageResource(this.lhh, R.drawable.icon_arrow_ranking_down);
                        break;
                    default:
                        this.lhh.setVisibility(8);
                        break;
                }
            }
        }
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        this.title.setText(rankDetailTrendCard.getCardTitle());
        if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
            this.lhk.setVisibility(8);
        } else {
            this.lhk.setVisibility(0);
            this.lhk.setTag(rankDetailTrendCard.getPicUrl());
            this.lhk.startLoad(rankDetailTrendCard.getPicUrl(), 10, false);
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
            a(this.lhi, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), R.color.CAM_X0308);
        }
    }
}
