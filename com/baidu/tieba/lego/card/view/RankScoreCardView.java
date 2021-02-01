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
/* loaded from: classes9.dex */
public class RankScoreCardView extends BaseCardView<RankScoreCard> {
    private TbImageView iSZ;
    private TextView kxW;
    LinearLayout laC;
    private TextView leT;
    private final int leV;
    private final int leW;
    private RelativeLayout leZ;
    private TextView lfa;
    private RelativeLayout lfb;
    private TextView lfc;
    private TextView lfd;
    private TextView title;

    public RankScoreCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.leV = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.leW = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.laC = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_score, (ViewGroup) null);
        this.leZ = (RelativeLayout) z(this.laC, R.id.rl_content);
        this.title = (TextView) z(this.laC, R.id.score_title);
        this.kxW = (TextView) z(this.laC, R.id.desc);
        this.lfa = (TextView) z(this.laC, R.id.desc2);
        this.lfb = (RelativeLayout) z(this.laC, R.id.rl_pic);
        this.iSZ = (TbImageView) z(this.laC, R.id.pic);
        this.lfc = (TextView) z(this.laC, R.id.leftTopText);
        this.lfd = (TextView) z(this.laC, R.id.right);
        this.leT = (TextView) z(this.laC, R.id.btn_post);
        return this.laC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankScoreCard rankScoreCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundResource(this.laC, R.drawable.addresslist_item_bg);
        ap.setViewTextColor(this.title, R.color.CAM_X0106);
        ap.setViewTextColor(this.kxW, R.color.CAM_X0106);
        ap.setViewTextColor(this.lfd, R.color.CAM_X0308);
        setDesc2Color(rankScoreCard);
        setRightScoreColor(rankScoreCard);
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            a(this.lfa, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), R.color.CAM_X0106);
        }
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            a(this.lfd, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), R.color.CAM_X0308);
        }
    }

    private void a(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iSZ.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.leZ.getLayoutParams();
            if (rankScoreCard.getRatio() > 0.0d) {
                layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
            } else {
                layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
            }
            this.iSZ.setLayoutParams(layoutParams);
            layoutParams2.height = layoutParams.height;
            this.leZ.setLayoutParams(layoutParams2);
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
            this.kxW.setVisibility(0);
            this.kxW.setText(rankScoreCard.getDesc());
        } else {
            this.kxW.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            this.lfa.setText(rankScoreCard.getDesc2());
            setDesc2Color(rankScoreCard);
            if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                this.lfa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        v.j(RankScoreCardView.this.eUY, rankScoreCard.getD2Scheme());
                    }
                });
            } else {
                this.lfa.setOnClickListener(null);
            }
        } else {
            this.lfa.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
            this.leT.setVisibility(0);
            a(this.leT, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
            this.leT.setTag(rankScoreCard.getPostUrl());
            this.leT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bh.checkUpIsLogin(RankScoreCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.dbk().a(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
                    }
                }
            });
            this.lfd.setVisibility(8);
        } else {
            this.leT.setVisibility(8);
            this.lfd.setVisibility(0);
            ap.setViewTextColor(this.lfd, R.color.CAM_X0301);
            try {
                this.lfd.setText(au.numberUniformFormat(Long.parseLong(rankScoreCard.getSubTitle())));
            } catch (Exception e) {
                this.lfd.setText(rankScoreCard.getSubTitle());
                setRightScoreColor(rankScoreCard);
            }
            this.lfd.setMaxWidth((this.leV - this.leW) / 2);
        }
        a(rankScoreCard);
        if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
            this.lfb.setVisibility(8);
        } else {
            this.lfb.setVisibility(0);
            this.iSZ.setTag(rankScoreCard.getPicUrl());
            this.iSZ.startLoad(rankScoreCard.getPicUrl(), 10, false);
            if (rankScoreCard.getRank() <= 0) {
                this.lfc.setVisibility(8);
            } else {
                this.lfc.setVisibility(0);
                int rank = rankScoreCard.getRank() - 1;
                if (rank >= 0) {
                    i = rank > 3 ? 3 : rank;
                }
                if (rankScoreCard.getRank() <= 3) {
                    ap.setViewTextColor(this.lfc, R.color.CAM_X0101);
                } else {
                    ap.setViewTextColor(this.lfc, R.color.CAM_X0111);
                }
                ap.setBackgroundColor(this.lfc, com.baidu.tieba.lego.a.kZr[i]);
                this.lfc.setText(rankScoreCard.getRank() + "");
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
