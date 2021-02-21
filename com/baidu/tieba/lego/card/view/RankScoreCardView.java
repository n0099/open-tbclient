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
    private TbImageView iTn;
    private TextView kyk;
    LinearLayout laQ;
    private TextView lfh;
    private final int lfj;
    private final int lfk;
    private RelativeLayout lfn;
    private TextView lfo;
    private RelativeLayout lfp;
    private TextView lfq;
    private TextView lfr;
    private TextView title;

    public RankScoreCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lfj = com.baidu.adp.lib.util.l.getEquipmentWidth(tbPageContext.getPageActivity());
        this.lfk = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.laQ = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_score, (ViewGroup) null);
        this.lfn = (RelativeLayout) z(this.laQ, R.id.rl_content);
        this.title = (TextView) z(this.laQ, R.id.score_title);
        this.kyk = (TextView) z(this.laQ, R.id.desc);
        this.lfo = (TextView) z(this.laQ, R.id.desc2);
        this.lfp = (RelativeLayout) z(this.laQ, R.id.rl_pic);
        this.iTn = (TbImageView) z(this.laQ, R.id.pic);
        this.lfq = (TextView) z(this.laQ, R.id.leftTopText);
        this.lfr = (TextView) z(this.laQ, R.id.right);
        this.lfh = (TextView) z(this.laQ, R.id.btn_post);
        return this.laQ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(RankScoreCard rankScoreCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundResource(this.laQ, R.drawable.addresslist_item_bg);
        ap.setViewTextColor(this.title, R.color.CAM_X0106);
        ap.setViewTextColor(this.kyk, R.color.CAM_X0106);
        ap.setViewTextColor(this.lfr, R.color.CAM_X0308);
        setDesc2Color(rankScoreCard);
        setRightScoreColor(rankScoreCard);
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            a(this.lfo, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), R.color.CAM_X0106);
        }
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null && !TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            a(this.lfr, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), R.color.CAM_X0308);
        }
    }

    private void a(RankScoreCard rankScoreCard) {
        if (rankScoreCard != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iTn.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.lfn.getLayoutParams();
            if (rankScoreCard.getRatio() > 0.0d) {
                layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
            } else {
                layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
            }
            this.iTn.setLayoutParams(layoutParams);
            layoutParams2.height = layoutParams.height;
            this.lfn.setLayoutParams(layoutParams2);
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
            this.kyk.setVisibility(0);
            this.kyk.setText(rankScoreCard.getDesc());
        } else {
            this.kyk.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            this.lfo.setText(rankScoreCard.getDesc2());
            setDesc2Color(rankScoreCard);
            if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                this.lfo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        v.j(RankScoreCardView.this.eUY, rankScoreCard.getD2Scheme());
                    }
                });
            } else {
                this.lfo.setOnClickListener(null);
            }
        } else {
            this.lfo.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
            this.lfh.setVisibility(0);
            a(this.lfh, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
            this.lfh.setTag(rankScoreCard.getPostUrl());
            this.lfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.RankScoreCardView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bh.checkUpIsLogin(RankScoreCardView.this.getContext())) {
                        com.baidu.tieba.lego.a.b.dbr().a(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
                    }
                }
            });
            this.lfr.setVisibility(8);
        } else {
            this.lfh.setVisibility(8);
            this.lfr.setVisibility(0);
            ap.setViewTextColor(this.lfr, R.color.CAM_X0301);
            try {
                this.lfr.setText(au.numberUniformFormat(Long.parseLong(rankScoreCard.getSubTitle())));
            } catch (Exception e) {
                this.lfr.setText(rankScoreCard.getSubTitle());
                setRightScoreColor(rankScoreCard);
            }
            this.lfr.setMaxWidth((this.lfj - this.lfk) / 2);
        }
        a(rankScoreCard);
        if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
            this.lfp.setVisibility(8);
        } else {
            this.lfp.setVisibility(0);
            this.iTn.setTag(rankScoreCard.getPicUrl());
            this.iTn.startLoad(rankScoreCard.getPicUrl(), 10, false);
            if (rankScoreCard.getRank() <= 0) {
                this.lfq.setVisibility(8);
            } else {
                this.lfq.setVisibility(0);
                int rank = rankScoreCard.getRank() - 1;
                if (rank >= 0) {
                    i = rank > 3 ? 3 : rank;
                }
                if (rankScoreCard.getRank() <= 3) {
                    ap.setViewTextColor(this.lfq, R.color.CAM_X0101);
                } else {
                    ap.setViewTextColor(this.lfq, R.color.CAM_X0111);
                }
                ap.setBackgroundColor(this.lfq, com.baidu.tieba.lego.a.kZF[i]);
                this.lfq.setText(rankScoreCard.getRank() + "");
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
