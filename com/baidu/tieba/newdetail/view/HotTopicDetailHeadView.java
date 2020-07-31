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
    private TextView iLJ;
    private int iwT;
    private TextView ixg;
    private TbImageView jWH;
    private View jWI;
    private View jWJ;
    private BarImageView jWK;
    private TextView jWL;
    private TextView jWM;
    private TextView jWN;
    private View jWO;
    private TBLottieAnimationView jWP;
    private TextView jWQ;
    private a jWR;
    private ValueAnimator jWS;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.iwT = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwT = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwT = 3;
        initView();
    }

    private void initView() {
        e<?> G = i.G(getContext());
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.jWH = (TbImageView) findViewById(R.id.bgView);
        this.jWI = findViewById(R.id.bgDefaultView);
        this.jWJ = findViewById(R.id.header_round_corner_layout);
        this.jWK = (BarImageView) findViewById(R.id.iconView);
        this.dJr = (TextView) findViewById(R.id.titleView);
        this.jWL = (TextView) findViewById(R.id.titlePreView);
        this.jWM = (TextView) findViewById(R.id.titleNextView);
        this.ixg = (TextView) findViewById(R.id.tagView);
        this.iLJ = (TextView) findViewById(R.id.descView);
        this.jWN = (TextView) findViewById(R.id.descView1);
        this.jWO = findViewById(R.id.descLayout);
        this.jWP = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.jWQ = (TextView) findViewById(R.id.blessView);
        this.jWQ.setAlpha(0.66f);
        this.jWI.setBackgroundColor(ao.getColor(R.color.cp_link_tip_a));
        this.jWK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jWK.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jWK.setPlaceHolder(2);
        this.ixg.setAlpha(0.66f);
        this.jWO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).cHz();
            }
        });
        this.jWP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.jWR != null) {
                    TiebaStatic.log(new ap("c13819").ah("obj_type", HotTopicDetailHeadView.this.jWR.iJN));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.jWR);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.jWI.setVisibility(TextUtils.isEmpty(fVar.iKn) ? 0 : 8);
            this.jWK.startLoad(fVar.iKn, 10, false);
            this.jWH.startLoad(fVar.iKn, 39, false);
            this.dJr.setText(fVar.dQI);
            if (fVar.iKo > 0) {
                this.iLJ.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.iKo));
                this.iLJ.setVisibility(0);
            } else {
                this.iLJ.setVisibility(8);
            }
            this.ixg.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), as.cG(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.jWR = aVar;
        if (aVar == null) {
            this.jWP.setVisibility(8);
            this.jWQ.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJr.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.dJr.getContext(), R.dimen.tbds84);
            this.dJr.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jWM.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.jWM.setLayoutParams(layoutParams2);
            return;
        }
        this.jWQ.setText(getContext().getResources().getString(Bg(aVar.iJN), as.cG(aVar.totalNum)));
        if (aVar.iJK == 1) {
            this.jWP.setVisibility(8);
            this.jWQ.setVisibility(0);
            this.jWQ.setTranslationX(0.0f);
        } else {
            this.jWP.setVisibility(0);
            this.jWQ.setVisibility(4);
            Bh(aVar.iJN);
            this.jWP.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dJr.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.dJr.getContext(), R.dimen.tbds280);
        this.dJr.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jWM.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.jWM.setLayoutParams(layoutParams4);
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
        if (this.jWP != null && this.jWP.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.jWP.setImageAssetsFolder("lottie_watch/");
                    ao.a(this.jWP, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.jWP.setImageAssetsFolder("lottie_candle/");
                    ao.a(this.jWP, R.raw.lottie_candle);
                } else {
                    this.jWP.setImageAssetsFolder("lottie_bless/");
                    ao.a(this.jWP, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.jWP.setImageAssetsFolder("lottie_watch_1/");
                ao.a(this.jWP, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.jWP.setImageAssetsFolder("lottie_candle_1/");
                ao.a(this.jWP, R.raw.lottie_candle_1);
            } else {
                this.jWP.setImageAssetsFolder("lottie_bless_1/");
                ao.a(this.jWP, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iwT != i) {
            ao.setBackgroundResource(this.jWJ, R.drawable.bg_header_round_corner);
            this.jWI.setBackgroundColor(ao.getColor(R.color.cp_link_tip_a));
            ao.setViewTextColor(this.dJr, R.color.cp_cont_a);
            ao.setViewTextColor(this.jWL, R.color.cp_cont_a);
            ao.setViewTextColor(this.jWM, R.color.cp_cont_a);
            ao.setViewTextColor(this.ixg, R.color.cp_cont_a);
            ao.setViewTextColor(this.iLJ, R.color.cp_cont_a);
            ao.setViewTextColor(this.jWN, R.color.cp_cont_a);
            ao.setViewTextColor(this.jWQ, R.color.cp_cont_a);
            if (this.jWR != null) {
                Bh(this.jWR.iJN);
            }
            this.iwT = i;
        }
    }

    public void G(long j, long j2) {
        if (this.jWR != null && this.jWR.iJK != 1) {
            this.jWP.playAnimation();
            cHM();
            this.jWR.iJK = 1;
            this.jWR.userPkId = j2;
        }
    }

    private void cHM() {
        if (this.jWS != null) {
            this.jWS.cancel();
        }
        final int width = this.jWQ.getWidth();
        if (width > 0) {
            this.jWQ.setTranslationX(width);
            this.jWQ.setVisibility(0);
            this.jWS = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.jWS.setDuration(200L);
            this.jWS.setStartDelay(1000L);
            this.jWS.setInterpolator(new AccelerateDecelerateInterpolator());
            this.jWS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.jWQ.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.jWS.start();
        }
    }
}
