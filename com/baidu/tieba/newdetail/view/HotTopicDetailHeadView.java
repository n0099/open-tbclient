package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
import d.a.c.a.f;
import d.a.c.a.j;
import d.a.c.e.p.l;
/* loaded from: classes5.dex */
public class HotTopicDetailHeadView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f18641e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<HotTopicDetailActivity> f18642f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f18643g;

    /* renamed from: h  reason: collision with root package name */
    public View f18644h;

    /* renamed from: i  reason: collision with root package name */
    public View f18645i;
    public BarImageView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public View q;
    public TBLottieAnimationView r;
    public TextView s;
    public d.a.o0.d1.c.a t;
    public ValueAnimator u;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((HotTopicDetailActivity) HotTopicDetailHeadView.this.f18642f.getOrignalPage()).jumpToRankList();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HotTopicDetailHeadView.this.t == null) {
                return;
            }
            TiebaStatic.log(new StatisticItem("c13819").param("obj_type", HotTopicDetailHeadView.this.t.f56367i));
            ((HotTopicDetailActivity) HotTopicDetailHeadView.this.f18642f.getOrignalPage()).sendBlessData(HotTopicDetailHeadView.this.t);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f18648e;

        public c(int i2) {
            this.f18648e = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            HotTopicDetailHeadView.this.s.setTranslationX(this.f18648e * ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.f18641e = 3;
        g();
    }

    public void d(long j, long j2) {
        d.a.o0.d1.c.a aVar = this.t;
        if (aVar == null || aVar.f56364f == 1) {
            return;
        }
        this.r.playAnimation();
        i();
        d.a.o0.d1.c.a aVar2 = this.t;
        aVar2.f56364f = 1;
        aVar2.f56366h = j2;
    }

    @StringRes
    public final int e(int i2) {
        if (i2 == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i2 == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    public final void f(int i2) {
        TBLottieAnimationView tBLottieAnimationView = this.r;
        if (tBLottieAnimationView == null || tBLottieAnimationView.getVisibility() != 0) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType == 0 || skinType == 3) {
            if (i2 == 1) {
                this.r.setImageAssetsFolder("lottie_watch/");
                SkinManager.setLottieAnimation(this.r, R.raw.lottie_watch);
            } else if (i2 == 2) {
                this.r.setImageAssetsFolder("lottie_candle/");
                SkinManager.setLottieAnimation(this.r, R.raw.lottie_candle);
            } else {
                this.r.setImageAssetsFolder("lottie_bless/");
                SkinManager.setLottieAnimation(this.r, R.raw.lottie_bless);
            }
        } else if (i2 == 1) {
            this.r.setImageAssetsFolder("lottie_watch_1/");
            SkinManager.setLottieAnimation(this.r, R.raw.lottie_watch_1);
        } else if (i2 == 2) {
            this.r.setImageAssetsFolder("lottie_candle_1/");
            SkinManager.setLottieAnimation(this.r, R.raw.lottie_candle_1);
        } else {
            this.r.setImageAssetsFolder("lottie_bless_1/");
            SkinManager.setLottieAnimation(this.r, R.raw.lottie_bless_1);
        }
    }

    public final void g() {
        f<?> a2 = j.a(getContext());
        if (a2 instanceof TbPageContext) {
            this.f18642f = (TbPageContext) a2;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.f18643g = (TbImageView) findViewById(R.id.bgView);
        this.f18644h = findViewById(R.id.bgDefaultView);
        this.f18645i = findViewById(R.id.header_round_corner_layout);
        this.j = (BarImageView) findViewById(R.id.iconView);
        this.k = (TextView) findViewById(R.id.titleView);
        this.l = (TextView) findViewById(R.id.titlePreView);
        this.m = (TextView) findViewById(R.id.titleNextView);
        this.n = (TextView) findViewById(R.id.tagView);
        this.o = (TextView) findViewById(R.id.descView);
        this.p = (TextView) findViewById(R.id.descView1);
        this.q = findViewById(R.id.descLayout);
        this.r = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        TextView textView = (TextView) findViewById(R.id.blessView);
        this.s = textView;
        textView.setAlpha(0.66f);
        this.f18644h.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
        this.j.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.j.setStrokeWith(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.j.setPlaceHolder(1);
        this.n.setAlpha(0.66f);
        this.q.setOnClickListener(new a());
        this.r.setOnClickListener(new b());
    }

    public void h(int i2) {
        if (this.f18641e != i2) {
            SkinManager.setBackgroundResource(this.f18645i, R.drawable.bg_header_round_corner);
            this.f18644h.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
            d.a.o0.d1.c.a aVar = this.t;
            if (aVar != null) {
                f(aVar.f56367i);
            }
            this.f18641e = i2;
        }
    }

    public final void i() {
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        int width = this.s.getWidth();
        if (width > 0) {
            this.s.setTranslationX(width);
            this.s.setVisibility(0);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.u = ofFloat;
            ofFloat.setDuration(200L);
            this.u.setStartDelay(1000L);
            this.u.setInterpolator(new AccelerateDecelerateInterpolator());
            this.u.addUpdateListener(new c(width));
            this.u.start();
        }
    }

    public void setBlessInfo(d.a.o0.d1.c.a aVar) {
        this.t = aVar;
        if (aVar == null) {
            this.r.setVisibility(8);
            this.s.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.rightMargin = l.g(this.k.getContext(), R.dimen.tbds84);
            this.k.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.m.setLayoutParams(layoutParams2);
            return;
        }
        this.s.setText(getContext().getResources().getString(e(aVar.f56367i), StringHelper.numberUniformFormatExtraWithRoundInt(aVar.f56363e)));
        if (aVar.f56364f == 1) {
            this.r.setVisibility(8);
            this.s.setVisibility(0);
            this.s.setTranslationX(0.0f);
        } else {
            this.r.setVisibility(0);
            this.s.setVisibility(4);
            f(aVar.f56367i);
            this.r.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
        layoutParams3.rightMargin = l.g(this.k.getContext(), R.dimen.tbds280);
        this.k.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.m.setLayoutParams(layoutParams4);
    }

    public void setTopicInfo(d.a.o0.d1.c.f fVar) {
        if (fVar == null) {
            return;
        }
        this.f18644h.setVisibility(TextUtils.isEmpty(fVar.f56391i) ? 0 : 8);
        this.j.U(fVar.f56391i, 10, false);
        this.f18643g.U(fVar.f56391i, 39, false);
        this.k.setText(fVar.f56388f);
        if (fVar.l > 0) {
            TextView textView = this.o;
            String string = getContext().getString(R.string.hot_topic_rank_list_head_desc);
            textView.setText(String.format(string, "" + fVar.l));
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
        this.n.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), StringHelper.numberUniformFormatExtraWithRoundInt(fVar.f56390h)));
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18641e = 3;
        g();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18641e = 3;
        g();
    }
}
