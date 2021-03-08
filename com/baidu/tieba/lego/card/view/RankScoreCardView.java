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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.RankScoreCard;
import com.baidu.tieba.tbadkCore.v;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class RankScoreCardView extends BaseCardView<RankScoreCard> {
    private TbImageView iUW;
    private TextView kAm;
    LinearLayout lcT;
    private TextView lhj;
    private final int lhl;
    private final int lhm;
    private RelativeLayout lhp;
    private TextView lhq;
    private RelativeLayout lhr;
    private TextView lhs;
    private TextView lht;
    private TextView title;

    public RankScoreCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lhl = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.lhm = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.lcT = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_score, (ViewGroup) null);
        this.lhp = (RelativeLayout) z(this.lcT, R.id.rl_content);
        this.title = (TextView) z(this.lcT, R.id.score_title);
        this.kAm = (TextView) z(this.lcT, R.id.desc);
        this.lhq = (TextView) z(this.lcT, R.id.desc2);
        this.lhr = (RelativeLayout) z(this.lcT, R.id.rl_pic);
        this.iUW = (TbImageView) z(this.lcT, R.id.pic);
        this.lhs = (TextView) z(this.lcT, R.id.leftTopText);
        this.lht = (TextView) z(this.lcT, R.id.right);
        this.lhj = (TextView) z(this.lcT, R.id.btn_post);
        return this.lcT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankScoreCard rankScoreCard, int i) {
        com.baidu.tbadk.r.a.a(this.eWx, getRootView());
        ap.setBackgroundResource(this.lcT, R.drawable.addresslist_item_bg);
        ap.setViewTextColor(this.title, R.color.CAM_X0106);
        ap.setViewTextColor(this.kAm, R.color.CAM_X0106);
        ap.setViewTextColor(this.lht, R.color.CAM_X0308);
        setDesc2Color(rankScoreCard);
        setRightScoreColor(rankScoreCard);
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            a(this.lhq, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), R.color.CAM_X0106);
        }
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            a(this.lht, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), R.color.CAM_X0308);
        }
    }

    private void a(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iUW.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lhp.getLayoutParams();
            if (rankScoreCard.getRatio() > 0.0d) {
                layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
            } else {
                layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
            }
            this.iUW.setLayoutParams(layoutParams);
            layoutParams2.height = layoutParams.height;
            this.lhp.setLayoutParams(layoutParams2);
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
            this.kAm.setVisibility(0);
            this.kAm.setText(rankScoreCard.getDesc());
        } else {
            this.kAm.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            this.lhq.setText(rankScoreCard.getDesc2());
            setDesc2Color(rankScoreCard);
            if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                this.lhq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        v.j(RankScoreCardView.this.eWx, rankScoreCard.getD2Scheme());
                    }
                });
            } else {
                this.lhq.setOnClickListener(null);
            }
        } else {
            this.lhq.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
            this.lhj.setVisibility(0);
            a(this.lhj, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
            this.lhj.setTag(rankScoreCard.getPostUrl());
            this.lhj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bh.checkUpIsLogin(RankScoreCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.dbA().a(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
                    }
                }
            });
            this.lht.setVisibility(8);
        } else {
            this.lhj.setVisibility(8);
            this.lht.setVisibility(0);
            ap.setViewTextColor(this.lht, R.color.CAM_X0301);
            try {
                this.lht.setText(au.numberUniformFormat(Long.parseLong(rankScoreCard.getSubTitle())));
            } catch (Exception e) {
                this.lht.setText(rankScoreCard.getSubTitle());
                setRightScoreColor(rankScoreCard);
            }
            this.lht.setMaxWidth((this.lhl - this.lhm) / 2);
        }
        a(rankScoreCard);
        if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
            this.lhr.setVisibility(8);
        } else {
            this.lhr.setVisibility(0);
            this.iUW.setTag(rankScoreCard.getPicUrl());
            this.iUW.startLoad(rankScoreCard.getPicUrl(), 10, false);
            if (rankScoreCard.getRank() <= 0) {
                this.lhs.setVisibility(8);
            } else {
                this.lhs.setVisibility(0);
                int rank = rankScoreCard.getRank() - 1;
                if (rank >= 0) {
                    i = rank > 3 ? 3 : rank;
                }
                if (rankScoreCard.getRank() <= 3) {
                    ap.setViewTextColor(this.lhs, R.color.CAM_X0101);
                } else {
                    ap.setViewTextColor(this.lhs, R.color.CAM_X0111);
                }
                ap.setBackgroundColor(this.lhs, com.baidu.tieba.lego.a.lbI[i]);
                this.lhs.setText(rankScoreCard.getRank() + "");
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
