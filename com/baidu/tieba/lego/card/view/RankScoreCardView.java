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
/* loaded from: classes9.dex */
public class RankScoreCardView extends BaseCardView<RankScoreCard> {
    private TbImageView iRZ;
    LinearLayout kXe;
    private TextView kuu;
    private RelativeLayout lbB;
    private TextView lbC;
    private RelativeLayout lbD;
    private TextView lbE;
    private TextView lbF;
    private TextView lbv;
    private final int lbx;
    private final int lby;
    private TextView title;

    public RankScoreCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lbx = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.lby = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.kXe = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_score, (ViewGroup) null);
        this.lbB = (RelativeLayout) z(this.kXe, R.id.rl_content);
        this.title = (TextView) z(this.kXe, R.id.score_title);
        this.kuu = (TextView) z(this.kXe, R.id.desc);
        this.lbC = (TextView) z(this.kXe, R.id.desc2);
        this.lbD = (RelativeLayout) z(this.kXe, R.id.rl_pic);
        this.iRZ = (TbImageView) z(this.kXe, R.id.pic);
        this.lbE = (TextView) z(this.kXe, R.id.leftTopText);
        this.lbF = (TextView) z(this.kXe, R.id.right);
        this.lbv = (TextView) z(this.kXe, R.id.btn_post);
        return this.kXe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankScoreCard rankScoreCard, int i) {
        com.baidu.tbadk.r.a.a(this.eXu, getRootView());
        ao.setBackgroundResource(this.kXe, R.drawable.addresslist_item_bg);
        ao.setViewTextColor(this.title, R.color.CAM_X0106);
        ao.setViewTextColor(this.kuu, R.color.CAM_X0106);
        ao.setViewTextColor(this.lbF, R.color.CAM_X0308);
        setDesc2Color(rankScoreCard);
        setRightScoreColor(rankScoreCard);
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            a(this.lbC, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), R.color.CAM_X0106);
        }
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            a(this.lbF, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), R.color.CAM_X0308);
        }
    }

    private void a(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iRZ.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lbB.getLayoutParams();
            if (rankScoreCard.getRatio() > 0.0d) {
                layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
            } else {
                layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
            }
            this.iRZ.setLayoutParams(layoutParams);
            layoutParams2.height = layoutParams.height;
            this.lbB.setLayoutParams(layoutParams2);
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
            this.kuu.setVisibility(0);
            this.kuu.setText(rankScoreCard.getDesc());
        } else {
            this.kuu.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            this.lbC.setText(rankScoreCard.getDesc2());
            setDesc2Color(rankScoreCard);
            if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                this.lbC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        v.h(RankScoreCardView.this.eXu, rankScoreCard.getD2Scheme());
                    }
                });
            } else {
                this.lbC.setOnClickListener(null);
            }
        } else {
            this.lbC.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
            this.lbv.setVisibility(0);
            a(this.lbv, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
            this.lbv.setTag(rankScoreCard.getPostUrl());
            this.lbv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bg.checkUpIsLogin(RankScoreCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.dde().a(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
                    }
                }
            });
            this.lbF.setVisibility(8);
        } else {
            this.lbv.setVisibility(8);
            this.lbF.setVisibility(0);
            ao.setViewTextColor(this.lbF, R.color.CAM_X0301);
            try {
                this.lbF.setText(at.numberUniformFormat(Long.parseLong(rankScoreCard.getSubTitle())));
            } catch (Exception e) {
                this.lbF.setText(rankScoreCard.getSubTitle());
                setRightScoreColor(rankScoreCard);
            }
            this.lbF.setMaxWidth((this.lbx - this.lby) / 2);
        }
        a(rankScoreCard);
        if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
            this.lbD.setVisibility(8);
        } else {
            this.lbD.setVisibility(0);
            this.iRZ.setTag(rankScoreCard.getPicUrl());
            this.iRZ.startLoad(rankScoreCard.getPicUrl(), 10, false);
            if (rankScoreCard.getRank() <= 0) {
                this.lbE.setVisibility(8);
            } else {
                this.lbE.setVisibility(0);
                int rank = rankScoreCard.getRank() - 1;
                if (rank >= 0) {
                    i = rank > 3 ? 3 : rank;
                }
                if (rankScoreCard.getRank() <= 3) {
                    ao.setViewTextColor(this.lbE, R.color.CAM_X0101);
                } else {
                    ao.setViewTextColor(this.lbE, R.color.CAM_X0111);
                }
                ao.setBackgroundColor(this.lbE, com.baidu.tieba.lego.a.kVU[i]);
                this.lbE.setText(rankScoreCard.getRank() + "");
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
