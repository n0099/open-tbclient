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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.a;
import com.baidu.tieba.hottopic.data.f;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes15.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView dJr;
    private TextView iLL;
    private int iwV;
    private TextView ixi;
    private TbImageView jWJ;
    private View jWK;
    private View jWL;
    private BarImageView jWM;
    private TextView jWN;
    private TextView jWO;
    private TextView jWP;
    private View jWQ;
    private TBLottieAnimationView jWR;
    private TextView jWS;
    private a jWT;
    private ValueAnimator jWU;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.iwV = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwV = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwV = 3;
        initView();
    }

    private void initView() {
        e<?> G = i.G(getContext());
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.jWJ = (TbImageView) findViewById(R.id.bgView);
        this.jWK = findViewById(R.id.bgDefaultView);
        this.jWL = findViewById(R.id.header_round_corner_layout);
        this.jWM = (BarImageView) findViewById(R.id.iconView);
        this.dJr = (TextView) findViewById(R.id.titleView);
        this.jWN = (TextView) findViewById(R.id.titlePreView);
        this.jWO = (TextView) findViewById(R.id.titleNextView);
        this.ixi = (TextView) findViewById(R.id.tagView);
        this.iLL = (TextView) findViewById(R.id.descView);
        this.jWP = (TextView) findViewById(R.id.descView1);
        this.jWQ = findViewById(R.id.descLayout);
        this.jWR = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.jWS = (TextView) findViewById(R.id.blessView);
        this.jWS.setAlpha(0.66f);
        this.jWK.setBackgroundColor(ao.getColor(R.color.cp_link_tip_a));
        this.jWM.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jWM.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jWM.setPlaceHolder(2);
        this.ixi.setAlpha(0.66f);
        this.jWQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).cHz();
            }
        });
        this.jWR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.jWT != null) {
                    TiebaStatic.log(new ap("c13819").ah("obj_type", HotTopicDetailHeadView.this.jWT.iJP));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.jWT);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.jWK.setVisibility(TextUtils.isEmpty(fVar.iKp) ? 0 : 8);
            this.jWM.startLoad(fVar.iKp, 10, false);
            this.jWJ.startLoad(fVar.iKp, 39, false);
            this.dJr.setText(fVar.dQI);
            if (fVar.iKq > 0) {
                this.iLL.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.iKq));
                this.iLL.setVisibility(0);
            } else {
                this.iLL.setVisibility(8);
            }
            this.ixi.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), as.cG(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.jWT = aVar;
        if (aVar == null) {
            this.jWR.setVisibility(8);
            this.jWS.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJr.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.dJr.getContext(), R.dimen.tbds84);
            this.dJr.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jWO.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.jWO.setLayoutParams(layoutParams2);
            return;
        }
        this.jWS.setText(getContext().getResources().getString(Bg(aVar.iJP), as.cG(aVar.totalNum)));
        if (aVar.iJM == 1) {
            this.jWR.setVisibility(8);
            this.jWS.setVisibility(0);
            this.jWS.setTranslationX(0.0f);
        } else {
            this.jWR.setVisibility(0);
            this.jWS.setVisibility(4);
            Bh(aVar.iJP);
            this.jWR.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dJr.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.dJr.getContext(), R.dimen.tbds280);
        this.dJr.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jWO.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.jWO.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int Bg(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void Bh(int i) {
        if (this.jWR != null && this.jWR.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.jWR.setImageAssetsFolder("lottie_watch/");
                    ao.a(this.jWR, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.jWR.setImageAssetsFolder("lottie_candle/");
                    ao.a(this.jWR, R.raw.lottie_candle);
                } else {
                    this.jWR.setImageAssetsFolder("lottie_bless/");
                    ao.a(this.jWR, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.jWR.setImageAssetsFolder("lottie_watch_1/");
                ao.a(this.jWR, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.jWR.setImageAssetsFolder("lottie_candle_1/");
                ao.a(this.jWR, R.raw.lottie_candle_1);
            } else {
                this.jWR.setImageAssetsFolder("lottie_bless_1/");
                ao.a(this.jWR, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwV != i) {
            ao.setBackgroundResource(this.jWL, R.drawable.bg_header_round_corner);
            this.jWK.setBackgroundColor(ao.getColor(R.color.cp_link_tip_a));
            ao.setViewTextColor(this.dJr, R.color.cp_cont_a);
            ao.setViewTextColor(this.jWN, R.color.cp_cont_a);
            ao.setViewTextColor(this.jWO, R.color.cp_cont_a);
            ao.setViewTextColor(this.ixi, R.color.cp_cont_a);
            ao.setViewTextColor(this.iLL, R.color.cp_cont_a);
            ao.setViewTextColor(this.jWP, R.color.cp_cont_a);
            ao.setViewTextColor(this.jWS, R.color.cp_cont_a);
            if (this.jWT != null) {
                Bh(this.jWT.iJP);
            }
            this.iwV = i;
        }
    }

    public void G(long j, long j2) {
        if (this.jWT != null && this.jWT.iJM != 1) {
            this.jWR.playAnimation();
            cHM();
            this.jWT.iJM = 1;
            this.jWT.userPkId = j2;
        }
    }

    private void cHM() {
        if (this.jWU != null) {
            this.jWU.cancel();
        }
        final int width = this.jWS.getWidth();
        if (width > 0) {
            this.jWS.setTranslationX(width);
            this.jWS.setVisibility(0);
            this.jWU = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.jWU.setDuration(200L);
            this.jWU.setStartDelay(1000L);
            this.jWU.setInterpolator(new AccelerateDecelerateInterpolator());
            this.jWU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.jWS.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.jWU.start();
        }
    }
}
