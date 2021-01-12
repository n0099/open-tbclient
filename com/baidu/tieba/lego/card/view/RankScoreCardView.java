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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.RankScoreCard;
import com.baidu.tieba.tbadkCore.v;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class RankScoreCardView extends BaseCardView<RankScoreCard> {
    private TbImageView iNs;
    LinearLayout kSz;
    private TextView kWP;
    private final int kWR;
    private final int kWS;
    private RelativeLayout kWV;
    private TextView kWW;
    private RelativeLayout kWX;
    private TextView kWY;
    private TextView kWZ;
    private TextView kpP;
    private TextView title;

    public RankScoreCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kWR = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.kWS = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.kSz = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_score, (ViewGroup) null);
        this.kWV = (RelativeLayout) z(this.kSz, R.id.rl_content);
        this.title = (TextView) z(this.kSz, R.id.score_title);
        this.kpP = (TextView) z(this.kSz, R.id.desc);
        this.kWW = (TextView) z(this.kSz, R.id.desc2);
        this.kWX = (RelativeLayout) z(this.kSz, R.id.rl_pic);
        this.iNs = (TbImageView) z(this.kSz, R.id.pic);
        this.kWY = (TextView) z(this.kSz, R.id.leftTopText);
        this.kWZ = (TextView) z(this.kSz, R.id.right);
        this.kWP = (TextView) z(this.kSz, R.id.btn_post);
        return this.kSz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankScoreCard rankScoreCard, int i) {
        com.baidu.tbadk.r.a.a(this.eSJ, getRootView());
        ao.setBackgroundResource(this.kSz, R.drawable.addresslist_item_bg);
        ao.setViewTextColor(this.title, R.color.CAM_X0106);
        ao.setViewTextColor(this.kpP, R.color.CAM_X0106);
        ao.setViewTextColor(this.kWZ, R.color.CAM_X0308);
        setDesc2Color(rankScoreCard);
        setRightScoreColor(rankScoreCard);
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            a(this.kWW, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), R.color.CAM_X0106);
        }
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            a(this.kWZ, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), R.color.CAM_X0308);
        }
    }

    private void a(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iNs.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kWV.getLayoutParams();
            if (rankScoreCard.getRatio() > 0.0d) {
                layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
            } else {
                layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
            }
            this.iNs.setLayoutParams(layoutParams);
            layoutParams2.height = layoutParams.height;
            this.kWV.setLayoutParams(layoutParams2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void d(final RankScoreCard rankScoreCard) {
        int i = 0;
        if (!TextUtils.isEmpty(rankScoreCard.getCardTitle())) {
            this.title.setVisibility(0);
            this.title.setText(rankScoreCard.getCardTitle());
        } else {
            this.title.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc())) {
            this.kpP.setVisibility(0);
            this.kpP.setText(rankScoreCard.getDesc());
        } else {
            this.kpP.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            this.kWW.setText(rankScoreCard.getDesc2());
            setDesc2Color(rankScoreCard);
            if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                this.kWW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        v.h(RankScoreCardView.this.eSJ, rankScoreCard.getD2Scheme());
                    }
                });
            } else {
                this.kWW.setOnClickListener(null);
            }
        } else {
            this.kWW.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
            this.kWP.setVisibility(0);
            a(this.kWP, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
            this.kWP.setTag(rankScoreCard.getPostUrl());
            this.kWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bg.checkUpIsLogin(RankScoreCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.cZm().a(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
                    }
                }
            });
            this.kWZ.setVisibility(8);
        } else {
            this.kWP.setVisibility(8);
            this.kWZ.setVisibility(0);
            ao.setViewTextColor(this.kWZ, R.color.CAM_X0301);
            try {
                this.kWZ.setText(at.numberUniformFormat(Long.parseLong(rankScoreCard.getSubTitle())));
            } catch (Exception e) {
                this.kWZ.setText(rankScoreCard.getSubTitle());
                setRightScoreColor(rankScoreCard);
            }
            this.kWZ.setMaxWidth((this.kWR - this.kWS) / 2);
        }
        a(rankScoreCard);
        if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
            this.kWX.setVisibility(8);
        } else {
            this.kWX.setVisibility(0);
            this.iNs.setTag(rankScoreCard.getPicUrl());
            this.iNs.startLoad(rankScoreCard.getPicUrl(), 10, false);
            if (rankScoreCard.getRank() <= 0) {
                this.kWY.setVisibility(8);
            } else {
                this.kWY.setVisibility(0);
                int rank = rankScoreCard.getRank() - 1;
                if (rank >= 0) {
                    i = rank > 3 ? 3 : rank;
                }
                if (rankScoreCard.getRank() <= 3) {
                    ao.setViewTextColor(this.kWY, R.color.CAM_X0101);
                } else {
                    ao.setViewTextColor(this.kWY, R.color.CAM_X0111);
                }
                ao.setBackgroundColor(this.kWY, com.baidu.tieba.lego.a.kRp[i]);
                this.kWY.setText(rankScoreCard.getRank() + "");
            }
        }
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RankScoreCardView.this.c(rankScoreCard);
            }
        });
    }
}
