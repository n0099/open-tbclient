package com.baidu.tieba.lego.card.view;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.RankDetailTrendCard;
import d.a.c.e.p.l;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class RankDetailTrendCardView extends BaseCardView<RankDetailTrendCard> {
    public final int A;
    public LinearLayout r;
    public TbImageView s;
    public TextView t;
    public TextView u;
    public TbImageView v;
    public TextView w;
    public TextView x;
    public HeadImageView y;
    public final int z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCard f18721e;

        public a(RankDetailTrendCard rankDetailTrendCard) {
            this.f18721e = rankDetailTrendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(RankDetailTrendCardView.this.getContext())) {
                d.a.j0.j1.m.b a2 = d.a.j0.j1.m.b.a();
                RankDetailTrendCard rankDetailTrendCard = this.f18721e;
                a2.e(rankDetailTrendCard, rankDetailTrendCard.getPostUrl(), null, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankDetailTrendCard f18723e;

        public b(RankDetailTrendCard rankDetailTrendCard) {
            this.f18723e = rankDetailTrendCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RankDetailTrendCardView.this.q(this.f18723e);
        }
    }

    public RankDetailTrendCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.z = l.k(tbPageContext.getPageActivity());
        this.A = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    private void setTrendTextColor(RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard == null || TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
            return;
        }
        F(this.w, rankDetailTrendCard.getTrendColor(), rankDetailTrendCard.getTrendColorNight(), R.color.CAM_X0308);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: J */
    public void x(RankDetailTrendCard rankDetailTrendCard, int i2) {
        d.a.i0.s0.a.a(this.m, getRootView());
        SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0108);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105);
        setTrendTextColor(rankDetailTrendCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: K */
    public void y(RankDetailTrendCard rankDetailTrendCard) {
        if (rankDetailTrendCard.getRank() == 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
            this.y.setLayoutParams(layoutParams);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.ds20);
            this.y.setLayoutParams(layoutParams2);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getIconUrl())) {
            this.s.setVisibility(0);
            this.s.setImageDrawable(null);
            this.s.V(rankDetailTrendCard.getIconUrl(), 10, false);
            this.t.setVisibility(8);
        } else if (rankDetailTrendCard.getRank() <= 0) {
            this.s.setVisibility(8);
            this.t.setVisibility(8);
        } else {
            if (rankDetailTrendCard.getRank() <= 3) {
                this.s.setVisibility(0);
                this.t.setVisibility(8);
                int rank = rankDetailTrendCard.getRank();
                if (rank == 1) {
                    SkinManager.setImageResource(this.s, R.drawable.icon_grade_shaitu1);
                } else if (rank == 2) {
                    SkinManager.setImageResource(this.s, R.drawable.icon_grade_shaitu2);
                } else if (rank != 3) {
                    this.s.setVisibility(8);
                    SkinManager.setImageResource(this.s, R.drawable.icon_grade_shaitu1);
                } else {
                    SkinManager.setImageResource(this.s, R.drawable.icon_grade_shaitu3);
                }
            } else {
                this.s.setVisibility(8);
                this.t.setVisibility(0);
            }
            if (rankDetailTrendCard.getRank() <= 9) {
                TextView textView = this.t;
                textView.setText("0" + rankDetailTrendCard.getRank() + "");
            } else {
                TextView textView2 = this.t;
                textView2.setText(rankDetailTrendCard.getRank() + "");
            }
            SkinManager.setViewTextColor(this.t, R.color.CAM_X0108);
        }
        if (!TextUtils.isEmpty(rankDetailTrendCard.getPostUrl()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnText()) && !TextUtils.isEmpty(rankDetailTrendCard.getBtnDone())) {
            this.x.setVisibility(0);
            H(this.x, rankDetailTrendCard.isDone(), rankDetailTrendCard.getBtnText(), rankDetailTrendCard.getBtnDone());
            this.x.setTag(rankDetailTrendCard.getPostUrl());
            this.x.setOnClickListener(new a(rankDetailTrendCard));
            this.v.setVisibility(8);
            this.w.setVisibility(8);
        } else {
            this.x.setVisibility(8);
            if (!TextUtils.isEmpty(rankDetailTrendCard.getPicTrendUrl())) {
                this.v.setVisibility(0);
                this.w.setVisibility(8);
                this.v.setImageDrawable(null);
                this.v.V(rankDetailTrendCard.getPicTrendUrl(), 10, false);
            } else if (!TextUtils.isEmpty(rankDetailTrendCard.getTrendText())) {
                this.w.setVisibility(0);
                this.v.setVisibility(8);
                this.w.setText(rankDetailTrendCard.getTrendText());
                setTrendTextColor(rankDetailTrendCard);
                this.w.setMaxWidth((this.z - this.A) / 2);
            } else {
                this.w.setVisibility(8);
                int picTrendType = rankDetailTrendCard.getPicTrendType();
                if (picTrendType == 1) {
                    this.v.setVisibility(0);
                    SkinManager.setImageResource(this.v, R.drawable.icon_arrow_ranking_up);
                } else if (picTrendType == 2) {
                    this.v.setVisibility(0);
                    SkinManager.setImageResource(this.v, R.drawable.icon_arrow_ranking_keep);
                } else if (picTrendType != 3) {
                    this.v.setVisibility(8);
                } else {
                    this.v.setVisibility(0);
                    SkinManager.setImageResource(this.v, R.drawable.icon_arrow_ranking_down);
                }
            }
        }
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0105);
        this.u.setText(rankDetailTrendCard.getCardTitle());
        if (TextUtils.isEmpty(rankDetailTrendCard.getPicUrl())) {
            this.y.setVisibility(8);
        } else {
            this.y.setVisibility(0);
            this.y.setTag(rankDetailTrendCard.getPicUrl());
            this.y.V(rankDetailTrendCard.getPicUrl(), 10, false);
        }
        setCardOnClickListener(new b(rankDetailTrendCard));
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View u() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_trend, (ViewGroup) null);
        this.r = linearLayout;
        this.s = (TbImageView) o(linearLayout, R.id.leftIcon);
        this.t = (TextView) o(this.r, R.id.item);
        this.u = (TextView) o(this.r, R.id.trend_title);
        this.v = (TbImageView) o(this.r, R.id.trend);
        this.w = (TextView) o(this.r, R.id.trend_text);
        this.x = (TextView) o(this.r, R.id.btn_post);
        HeadImageView headImageView = (HeadImageView) o(this.r, R.id.head);
        this.y = headImageView;
        headImageView.setIsRound(true);
        return this.r;
    }
}
