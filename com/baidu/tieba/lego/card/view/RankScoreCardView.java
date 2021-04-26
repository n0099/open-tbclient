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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.RankScoreCard;
import d.a.c.e.p.l;
import d.a.j0.d3.v;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes4.dex */
public class RankScoreCardView extends BaseCardView<RankScoreCard> {
    public TextView A;
    public final int B;
    public final int C;
    public LinearLayout r;
    public RelativeLayout s;
    public TextView t;
    public TextView u;
    public TextView v;
    public RelativeLayout w;
    public TbImageView x;
    public TextView y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankScoreCard f18725e;

        public a(RankScoreCard rankScoreCard) {
            this.f18725e = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.c(RankScoreCardView.this.m, this.f18725e.getD2Scheme());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankScoreCard f18727e;

        public b(RankScoreCard rankScoreCard) {
            this.f18727e = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(RankScoreCardView.this.getContext())) {
                d.a.j0.j1.m.b a2 = d.a.j0.j1.m.b.a();
                RankScoreCard rankScoreCard = this.f18727e;
                a2.e(rankScoreCard, rankScoreCard.getPostUrl(), null, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RankScoreCard f18729e;

        public c(RankScoreCard rankScoreCard) {
            this.f18729e = rankScoreCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RankScoreCardView.this.q(this.f18729e);
        }
    }

    public RankScoreCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.B = l.k(tbPageContext.getPageActivity());
        this.C = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
    }

    private void setDesc2Color(RankScoreCard rankScoreCard) {
        if (rankScoreCard == null || TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            return;
        }
        F(this.v, rankScoreCard.getD2Color(), rankScoreCard.getD2ColorN(), R.color.CAM_X0106);
    }

    private void setRightScoreColor(RankScoreCard rankScoreCard) {
        if (rankScoreCard == null || TextUtils.isEmpty(rankScoreCard.getSubTitle())) {
            return;
        }
        F(this.z, rankScoreCard.getScoreColor(), rankScoreCard.getScoreColorNight(), R.color.CAM_X0308);
    }

    public final void J(RankScoreCard rankScoreCard) {
        if (rankScoreCard == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.s.getLayoutParams();
        if (rankScoreCard.getRatio() > 0.0d) {
            layoutParams.height = (int) ((layoutParams.width * rankScoreCard.getRatio()) + 0.5d);
        } else {
            layoutParams.height = (int) ((layoutParams.width * 1.35f) + 0.5f);
        }
        this.x.setLayoutParams(layoutParams);
        layoutParams2.height = layoutParams.height;
        this.s.setLayoutParams(layoutParams2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: K */
    public void x(RankScoreCard rankScoreCard, int i2) {
        d.a.i0.s0.a.a(this.m, getRootView());
        SkinManager.setBackgroundResource(this.r, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.t, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.u, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.z, R.color.CAM_X0308);
        setDesc2Color(rankScoreCard);
        setRightScoreColor(rankScoreCard);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void y(RankScoreCard rankScoreCard) {
        if (!TextUtils.isEmpty(rankScoreCard.getCardTitle())) {
            this.t.setVisibility(0);
            this.t.setText(rankScoreCard.getCardTitle());
        } else {
            this.t.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc())) {
            this.u.setVisibility(0);
            this.u.setText(rankScoreCard.getDesc());
        } else {
            this.u.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getDesc2())) {
            this.v.setText(rankScoreCard.getDesc2());
            setDesc2Color(rankScoreCard);
            if (!TextUtils.isEmpty(rankScoreCard.getD2Scheme())) {
                this.v.setOnClickListener(new a(rankScoreCard));
            } else {
                this.v.setOnClickListener(null);
            }
        } else {
            this.v.setVisibility(4);
        }
        if (!TextUtils.isEmpty(rankScoreCard.getPostUrl()) && !TextUtils.isEmpty(rankScoreCard.getBtnText()) && !TextUtils.isEmpty(rankScoreCard.getBtnDone())) {
            this.A.setVisibility(0);
            H(this.A, rankScoreCard.isDone(), rankScoreCard.getBtnText(), rankScoreCard.getBtnDone());
            this.A.setTag(rankScoreCard.getPostUrl());
            this.A.setOnClickListener(new b(rankScoreCard));
            this.z.setVisibility(8);
        } else {
            this.A.setVisibility(8);
            this.z.setVisibility(0);
            SkinManager.setViewTextColor(this.z, R.color.CAM_X0301);
            try {
                this.z.setText(StringHelper.numberUniformFormat(Long.parseLong(rankScoreCard.getSubTitle())));
            } catch (Exception unused) {
                this.z.setText(rankScoreCard.getSubTitle());
                setRightScoreColor(rankScoreCard);
            }
            this.z.setMaxWidth((this.B - this.C) / 2);
        }
        J(rankScoreCard);
        if (TextUtils.isEmpty(rankScoreCard.getPicUrl())) {
            this.w.setVisibility(8);
        } else {
            this.w.setVisibility(0);
            this.x.setTag(rankScoreCard.getPicUrl());
            this.x.V(rankScoreCard.getPicUrl(), 10, false);
            if (rankScoreCard.getRank() <= 0) {
                this.y.setVisibility(8);
            } else {
                this.y.setVisibility(0);
                int rank = rankScoreCard.getRank() - 1;
                int i2 = rank >= 0 ? rank > 3 ? 3 : rank : 0;
                if (rankScoreCard.getRank() <= 3) {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0101);
                } else {
                    SkinManager.setViewTextColor(this.y, R.color.CAM_X0111);
                }
                SkinManager.setBackgroundColor(this.y, d.a.j0.j1.a.f55701a[i2]);
                this.y.setText(rankScoreCard.getRank() + "");
            }
        }
        setCardOnClickListener(new c(rankScoreCard));
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View u() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_rank_score, (ViewGroup) null);
        this.r = linearLayout;
        this.s = (RelativeLayout) o(linearLayout, R.id.rl_content);
        this.t = (TextView) o(this.r, R.id.score_title);
        this.u = (TextView) o(this.r, R.id.desc);
        this.v = (TextView) o(this.r, R.id.desc2);
        this.w = (RelativeLayout) o(this.r, R.id.rl_pic);
        this.x = (TbImageView) o(this.r, R.id.pic);
        this.y = (TextView) o(this.r, R.id.leftTopText);
        this.z = (TextView) o(this.r, R.id.right);
        this.A = (TextView) o(this.r, R.id.btn_post);
        return this.r;
    }
}
