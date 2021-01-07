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
import com.baidu.adp.base.f;
import com.baidu.adp.base.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.a;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes8.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView akS;
    private TextView eKc;
    private int kdK;
    private TextView kss;
    private View lvA;
    private TBLottieAnimationView lvB;
    private TextView lvC;
    private a lvD;
    private ValueAnimator lvE;
    private TbImageView lvt;
    private View lvu;
    private View lvv;
    private BarImageView lvw;
    private TextView lvx;
    private TextView lvy;
    private TextView lvz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.kdK = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdK = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdK = 3;
        initView();
    }

    private void initView() {
        f<?> K = j.K(getContext());
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.lvt = (TbImageView) findViewById(R.id.bgView);
        this.lvu = findViewById(R.id.bgDefaultView);
        this.lvv = findViewById(R.id.header_round_corner_layout);
        this.lvw = (BarImageView) findViewById(R.id.iconView);
        this.eKc = (TextView) findViewById(R.id.titleView);
        this.lvx = (TextView) findViewById(R.id.titlePreView);
        this.lvy = (TextView) findViewById(R.id.titleNextView);
        this.akS = (TextView) findViewById(R.id.tagView);
        this.kss = (TextView) findViewById(R.id.descView);
        this.lvz = (TextView) findViewById(R.id.descView1);
        this.lvA = findViewById(R.id.descLayout);
        this.lvB = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.lvC = (TextView) findViewById(R.id.blessView);
        this.lvC.setAlpha(0.66f);
        this.lvu.setBackgroundColor(ao.getColor(R.color.CAM_X0302));
        this.lvw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lvw.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.lvw.setPlaceHolder(1);
        this.akS.setAlpha(0.66f);
        this.lvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).djI();
            }
        });
        this.lvB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.lvD != null) {
                    TiebaStatic.log(new aq("c13819").an("obj_type", HotTopicDetailHeadView.this.lvD.kqv));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.lvD);
                }
            }
        });
    }

    public void setTopicInfo(com.baidu.tieba.hottopic.data.f fVar) {
        if (fVar != null) {
            this.lvu.setVisibility(TextUtils.isEmpty(fVar.kqV) ? 0 : 8);
            this.lvw.startLoad(fVar.kqV, 10, false);
            this.lvt.startLoad(fVar.kqV, 39, false);
            this.eKc.setText(fVar.eRS);
            if (fVar.kqW > 0) {
                this.kss.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.kqW));
                this.kss.setVisibility(0);
            } else {
                this.kss.setVisibility(8);
            }
            this.akS.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), at.dX(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.lvD = aVar;
        if (aVar == null) {
            this.lvB.setVisibility(8);
            this.lvC.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKc.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.eKc.getContext(), R.dimen.tbds84);
            this.eKc.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lvy.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.lvy.setLayoutParams(layoutParams2);
            return;
        }
        this.lvC.setText(getContext().getResources().getString(Gr(aVar.kqv), at.dX(aVar.totalNum)));
        if (aVar.kqs == 1) {
            this.lvB.setVisibility(8);
            this.lvC.setVisibility(0);
            this.lvC.setTranslationX(0.0f);
        } else {
            this.lvB.setVisibility(0);
            this.lvC.setVisibility(4);
            Gs(aVar.kqv);
            this.lvB.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eKc.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.eKc.getContext(), R.dimen.tbds280);
        this.eKc.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.lvy.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.lvy.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int Gr(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void Gs(int i) {
        if (this.lvB != null && this.lvB.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.lvB.setImageAssetsFolder("lottie_watch/");
                    ao.a(this.lvB, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.lvB.setImageAssetsFolder("lottie_candle/");
                    ao.a(this.lvB, R.raw.lottie_candle);
                } else {
                    this.lvB.setImageAssetsFolder("lottie_bless/");
                    ao.a(this.lvB, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.lvB.setImageAssetsFolder("lottie_watch_1/");
                ao.a(this.lvB, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.lvB.setImageAssetsFolder("lottie_candle_1/");
                ao.a(this.lvB, R.raw.lottie_candle_1);
            } else {
                this.lvB.setImageAssetsFolder("lottie_bless_1/");
                ao.a(this.lvB, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kdK != i) {
            ao.setBackgroundResource(this.lvv, R.drawable.bg_header_round_corner);
            this.lvu.setBackgroundColor(ao.getColor(R.color.CAM_X0302));
            ao.setViewTextColor(this.eKc, R.color.CAM_X0101);
            ao.setViewTextColor(this.lvx, R.color.CAM_X0101);
            ao.setViewTextColor(this.lvy, R.color.CAM_X0101);
            ao.setViewTextColor(this.akS, R.color.CAM_X0101);
            ao.setViewTextColor(this.kss, R.color.CAM_X0101);
            ao.setViewTextColor(this.lvz, R.color.CAM_X0101);
            ao.setViewTextColor(this.lvC, R.color.CAM_X0101);
            if (this.lvD != null) {
                Gs(this.lvD.kqv);
            }
            this.kdK = i;
        }
    }

    public void H(long j, long j2) {
        if (this.lvD != null && this.lvD.kqs != 1) {
            this.lvB.playAnimation();
            djV();
            this.lvD.kqs = 1;
            this.lvD.userPkId = j2;
        }
    }

    private void djV() {
        if (this.lvE != null) {
            this.lvE.cancel();
        }
        final int width = this.lvC.getWidth();
        if (width > 0) {
            this.lvC.setTranslationX(width);
            this.lvC.setVisibility(0);
            this.lvE = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.lvE.setDuration(200L);
            this.lvE.setStartDelay(1000L);
            this.lvE.setInterpolator(new AccelerateDecelerateInterpolator());
            this.lvE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.lvC.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.lvE.start();
        }
    }
}
