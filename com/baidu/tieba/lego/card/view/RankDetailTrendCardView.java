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
    LinearLayout laQ;
    TbImageView lfd;
    TextView lfe;
    TbImageView lff;
    TextView lfg;
    TextView lfh;
    HeadImageView lfi;
    private final int lfj;
    private final int lfk;
    TextView title;

    public RankDetailTrendCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lfj = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.lfk = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.laQ = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_trend, (ViewGroup) null);
        this.lfd = (TbImageView) z(this.laQ, R.id.leftIcon);
        this.lfe = (TextView) z(this.laQ, R.id.item);
        this.title = (TextView) z(this.laQ, R.id.trend_title);
        this.lff = (TbImageView) z(this.laQ, R.id.trend);
        this.lfg = (TextView) z(this.laQ, R.id.trend_text);
        this.lfh = (TextView) z(this.laQ, R.id.btn_post);
        this.lfi = (HeadImageView) z(this.laQ, R.id.head);
        this.lfi.setIsRound(true);
        return this.laQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankDetailTrendCard rankDetailTrendCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundResource(this.laQ, R.drawable.addresslist_item_bg);
        ap.setViewTextColor(this.lfe, R.color.CAM_X0108);
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        setTrendTextColor(rankDetailTrendCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard.getRank() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lfi.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
            this.lfi.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lfi.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
            this.lfi.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
            this.lfd.setVisibility(0);
            this.lfd.setImageDrawable(null);
            this.lfd.startLoad(rankDetailTrendCard.getIconUrl(), 10, false);
            this.lfe.setVisibility(8);
        } else if (rankDetailTrendCard.getRank() <= 0) {
            this.lfd.setVisibility(8);
            this.lfe.setVisibility(8);
        } else {
            if (rankDetailTrendCard.getRank() <= 3) {
                this.lfd.setVisibility(0);
                this.lfe.setVisibility(8);
                switch (rankDetailTrendCard.getRank()) {
                    case 1:
                        ap.setImageResource(this.lfd, R.drawable.icon_grade_shaitu1);
                        break;
                    case 2:
                        ap.setImageResource(this.lfd, R.drawable.icon_grade_shaitu2);
                        break;
                    case 3:
                        ap.setImageResource(this.lfd, R.drawable.icon_grade_shaitu3);
                        break;
                    default:
                        this.lfd.setVisibility(8);
                        ap.setImageResource(this.lfd, R.drawable.icon_grade_shaitu1);
                        break;
                }
            } else {
                this.lfd.setVisibility(8);
                this.lfe.setVisibility(0);
            }
            if (rankDetailTrendCard.getRank() <= 9) {
                this.lfe.setText("0" + rankDetailTrendCard.getRank() + "");
            } else {
                this.lfe.setText(rankDetailTrendCard.getRank() + "");
            }
            ap.setViewTextColor(this.lfe, R.color.CAM_X0108);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
            this.lfh.setVisibility(0);
            a(this.lfh, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
            this.lfh.setTag(rankDetailTrendCard.getPostUrl());
            this.lfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankDetailTrendCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bh.checkUpIsLogin(RankDetailTrendCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.dbr().a(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
                    }
                }
            });
            this.lff.setVisibility(8);
            this.lfg.setVisibility(8);
        } else {
            this.lfh.setVisibility(8);
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                this.lff.setVisibility(0);
                this.lfg.setVisibility(8);
                this.lff.setImageDrawable(null);
                this.lff.startLoad(rankDetailTrendCard.getPicTrendUrl(), 10, false);
            } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                this.lfg.setVisibility(0);
                this.lff.setVisibility(8);
                this.lfg.setText(rankDetailTrendCard.getTrendText());
                setTrendTextColor(rankDetailTrendCard);
                this.lfg.setMaxWidth((this.lfj - this.lfk) / 2);
            } else {
                this.lfg.setVisibility(8);
                switch (rankDetailTrendCard.getPicTrendType()) {
                    case 1:
                        this.lff.setVisibility(0);
                        ap.setImageResource(this.lff, R.drawable.icon_arrow_ranking_up);
                        break;
                    case 2:
                        this.lff.setVisibility(0);
                        ap.setImageResource(this.lff, R.drawable.icon_arrow_ranking_keep);
                        break;
                    case 3:
                        this.lff.setVisibility(0);
                        ap.setImageResource(this.lff, R.drawable.icon_arrow_ranking_down);
                        break;
                    default:
                        this.lff.setVisibility(8);
                        break;
                }
            }
        }
        ap.setViewTextColor(this.title, R.color.CAM_X0105);
        this.title.setText(rankDetailTrendCard.getCardTitle());
        if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
            this.lfi.setVisibility(8);
        } else {
            this.lfi.setVisibility(0);
            this.lfi.setTag(rankDetailTrendCard.getPicUrl());
            this.lfi.startLoad(rankDetailTrendCard.getPicUrl(), 10, false);
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
            a(this.lfg, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), R.color.CAM_X0308);
        }
    }
}
