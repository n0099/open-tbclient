package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.a;
import com.baidu.tieba.hottopic.data.f;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes21.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView ajm;
    private TextView epn;
    private TextView jKS;
    private int jvY;
    private TextView kWA;
    private View kWB;
    private TBLottieAnimationView kWC;
    private TextView kWD;
    private a kWE;
    private ValueAnimator kWF;
    private TbImageView kWu;
    private View kWv;
    private View kWw;
    private BarImageView kWx;
    private TextView kWy;
    private TextView kWz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.jvY = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvY = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvY = 3;
        initView();
    }

    private void initView() {
        e<?> I = i.I(getContext());
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.kWu = (TbImageView) findViewById(R.id.bgView);
        this.kWv = findViewById(R.id.bgDefaultView);
        this.kWw = findViewById(R.id.header_round_corner_layout);
        this.kWx = (BarImageView) findViewById(R.id.iconView);
        this.epn = (TextView) findViewById(R.id.titleView);
        this.kWy = (TextView) findViewById(R.id.titlePreView);
        this.kWz = (TextView) findViewById(R.id.titleNextView);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.jKS = (TextView) findViewById(R.id.descView);
        this.kWA = (TextView) findViewById(R.id.descView1);
        this.kWB = findViewById(R.id.descLayout);
        this.kWC = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.kWD = (TextView) findViewById(R.id.blessView);
        this.kWD.setAlpha(0.66f);
        this.kWv.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.kWx.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kWx.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.kWx.setPlaceHolder(2);
        this.ajm.setAlpha(0.66f);
        this.kWB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).dcL();
            }
        });
        this.kWC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.kWE != null) {
                    TiebaStatic.log(new aq("c13819").aj("obj_type", HotTopicDetailHeadView.this.kWE.jIW));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.kWE);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.kWv.setVisibility(TextUtils.isEmpty(fVar.jJw) ? 0 : 8);
            this.kWx.startLoad(fVar.jJw, 10, false);
            this.kWu.startLoad(fVar.jJw, 39, false);
            this.epn.setText(fVar.ewR);
            if (fVar.jJx > 0) {
                this.jKS.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.jJx));
                this.jKS.setVisibility(0);
            } else {
                this.jKS.setVisibility(8);
            }
            this.ajm.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), at.dc(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.kWE = aVar;
        if (aVar == null) {
            this.kWC.setVisibility(8);
            this.kWD.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.epn.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.epn.getContext(), R.dimen.tbds84);
            this.epn.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kWz.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.kWz.setLayoutParams(layoutParams2);
            return;
        }
        this.kWD.setText(getContext().getResources().getString(EZ(aVar.jIW), at.dc(aVar.totalNum)));
        if (aVar.jIT == 1) {
            this.kWC.setVisibility(8);
            this.kWD.setVisibility(0);
            this.kWD.setTranslationX(0.0f);
        } else {
            this.kWC.setVisibility(0);
            this.kWD.setVisibility(4);
            Fa(aVar.jIW);
            this.kWC.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.epn.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.epn.getContext(), R.dimen.tbds280);
        this.epn.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kWz.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.kWz.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int EZ(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void Fa(int i) {
        if (this.kWC != null && this.kWC.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.kWC.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.kWC, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.kWC.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.kWC, R.raw.lottie_candle);
                } else {
                    this.kWC.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.kWC, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.kWC.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.kWC, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.kWC.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.kWC, R.raw.lottie_candle_1);
            } else {
                this.kWC.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.kWC, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jvY != i) {
            ap.setBackgroundResource(this.kWw, R.drawable.bg_header_round_corner);
            this.kWv.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
            ap.setViewTextColor(this.epn, R.color.cp_cont_a);
            ap.setViewTextColor(this.kWy, R.color.cp_cont_a);
            ap.setViewTextColor(this.kWz, R.color.cp_cont_a);
            ap.setViewTextColor(this.ajm, R.color.cp_cont_a);
            ap.setViewTextColor(this.jKS, R.color.cp_cont_a);
            ap.setViewTextColor(this.kWA, R.color.cp_cont_a);
            ap.setViewTextColor(this.kWD, R.color.cp_cont_a);
            if (this.kWE != null) {
                Fa(this.kWE.jIW);
            }
            this.jvY = i;
        }
    }

    public void E(long j, long j2) {
        if (this.kWE != null && this.kWE.jIT != 1) {
            this.kWC.playAnimation();
            dcY();
            this.kWE.jIT = 1;
            this.kWE.userPkId = j2;
        }
    }

    private void dcY() {
        if (this.kWF != null) {
            this.kWF.cancel();
        }
        final int width = this.kWD.getWidth();
        if (width > 0) {
            this.kWD.setTranslationX(width);
            this.kWD.setVisibility(0);
            this.kWF = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.kWF.setDuration(200L);
            this.kWF.setStartDelay(1000L);
            this.kWF.setInterpolator(new AccelerateDecelerateInterpolator());
            this.kWF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.kWD.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.kWF.start();
        }
    }
}
