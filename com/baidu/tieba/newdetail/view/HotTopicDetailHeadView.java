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
/* loaded from: classes7.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView akb;
    private TextView eFr;
    private int jZf;
    private TextView knN;
    private TbImageView lqN;
    private View lqO;
    private View lqP;
    private BarImageView lqQ;
    private TextView lqR;
    private TextView lqS;
    private TextView lqT;
    private View lqU;
    private TBLottieAnimationView lqV;
    private TextView lqW;
    private a lqX;
    private ValueAnimator lqY;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.jZf = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZf = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZf = 3;
        initView();
    }

    private void initView() {
        f<?> K = j.K(getContext());
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.lqN = (TbImageView) findViewById(R.id.bgView);
        this.lqO = findViewById(R.id.bgDefaultView);
        this.lqP = findViewById(R.id.header_round_corner_layout);
        this.lqQ = (BarImageView) findViewById(R.id.iconView);
        this.eFr = (TextView) findViewById(R.id.titleView);
        this.lqR = (TextView) findViewById(R.id.titlePreView);
        this.lqS = (TextView) findViewById(R.id.titleNextView);
        this.akb = (TextView) findViewById(R.id.tagView);
        this.knN = (TextView) findViewById(R.id.descView);
        this.lqT = (TextView) findViewById(R.id.descView1);
        this.lqU = findViewById(R.id.descLayout);
        this.lqV = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.lqW = (TextView) findViewById(R.id.blessView);
        this.lqW.setAlpha(0.66f);
        this.lqO.setBackgroundColor(ao.getColor(R.color.CAM_X0302));
        this.lqQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lqQ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.lqQ.setPlaceHolder(1);
        this.akb.setAlpha(0.66f);
        this.lqU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).dfQ();
            }
        });
        this.lqV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.lqX != null) {
                    TiebaStatic.log(new aq("c13819").an("obj_type", HotTopicDetailHeadView.this.lqX.klQ));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.lqX);
                }
            }
        });
    }

    public void setTopicInfo(com.baidu.tieba.hottopic.data.f fVar) {
        if (fVar != null) {
            this.lqO.setVisibility(TextUtils.isEmpty(fVar.kmq) ? 0 : 8);
            this.lqQ.startLoad(fVar.kmq, 10, false);
            this.lqN.startLoad(fVar.kmq, 39, false);
            this.eFr.setText(fVar.eNh);
            if (fVar.kmr > 0) {
                this.knN.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.kmr));
                this.knN.setVisibility(0);
            } else {
                this.knN.setVisibility(8);
            }
            this.akb.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), at.dX(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.lqX = aVar;
        if (aVar == null) {
            this.lqV.setVisibility(8);
            this.lqW.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eFr.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.eFr.getContext(), R.dimen.tbds84);
            this.eFr.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lqS.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.lqS.setLayoutParams(layoutParams2);
            return;
        }
        this.lqW.setText(getContext().getResources().getString(EL(aVar.klQ), at.dX(aVar.totalNum)));
        if (aVar.klN == 1) {
            this.lqV.setVisibility(8);
            this.lqW.setVisibility(0);
            this.lqW.setTranslationX(0.0f);
        } else {
            this.lqV.setVisibility(0);
            this.lqW.setVisibility(4);
            EM(aVar.klQ);
            this.lqV.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eFr.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.eFr.getContext(), R.dimen.tbds280);
        this.eFr.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.lqS.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.lqS.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int EL(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void EM(int i) {
        if (this.lqV != null && this.lqV.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.lqV.setImageAssetsFolder("lottie_watch/");
                    ao.a(this.lqV, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.lqV.setImageAssetsFolder("lottie_candle/");
                    ao.a(this.lqV, R.raw.lottie_candle);
                } else {
                    this.lqV.setImageAssetsFolder("lottie_bless/");
                    ao.a(this.lqV, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.lqV.setImageAssetsFolder("lottie_watch_1/");
                ao.a(this.lqV, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.lqV.setImageAssetsFolder("lottie_candle_1/");
                ao.a(this.lqV, R.raw.lottie_candle_1);
            } else {
                this.lqV.setImageAssetsFolder("lottie_bless_1/");
                ao.a(this.lqV, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jZf != i) {
            ao.setBackgroundResource(this.lqP, R.drawable.bg_header_round_corner);
            this.lqO.setBackgroundColor(ao.getColor(R.color.CAM_X0302));
            ao.setViewTextColor(this.eFr, R.color.CAM_X0101);
            ao.setViewTextColor(this.lqR, R.color.CAM_X0101);
            ao.setViewTextColor(this.lqS, R.color.CAM_X0101);
            ao.setViewTextColor(this.akb, R.color.CAM_X0101);
            ao.setViewTextColor(this.knN, R.color.CAM_X0101);
            ao.setViewTextColor(this.lqT, R.color.CAM_X0101);
            ao.setViewTextColor(this.lqW, R.color.CAM_X0101);
            if (this.lqX != null) {
                EM(this.lqX.klQ);
            }
            this.jZf = i;
        }
    }

    public void H(long j, long j2) {
        if (this.lqX != null && this.lqX.klN != 1) {
            this.lqV.playAnimation();
            dgd();
            this.lqX.klN = 1;
            this.lqX.userPkId = j2;
        }
    }

    private void dgd() {
        if (this.lqY != null) {
            this.lqY.cancel();
        }
        final int width = this.lqW.getWidth();
        if (width > 0) {
            this.lqW.setTranslationX(width);
            this.lqW.setVisibility(0);
            this.lqY = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.lqY.setDuration(200L);
            this.lqY.setStartDelay(1000L);
            this.lqY.setInterpolator(new AccelerateDecelerateInterpolator());
            this.lqY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.lqW.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.lqY.start();
        }
    }
}
