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
    private TextView evg;
    private int jBV;
    private TextView jQQ;
    private TextView lcA;
    private a lcB;
    private ValueAnimator lcC;
    private TbImageView lcr;
    private View lcs;
    private View lct;
    private BarImageView lcu;
    private TextView lcv;
    private TextView lcw;
    private TextView lcx;
    private View lcy;
    private TBLottieAnimationView lcz;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.jBV = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBV = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBV = 3;
        initView();
    }

    private void initView() {
        e<?> I = i.I(getContext());
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.lcr = (TbImageView) findViewById(R.id.bgView);
        this.lcs = findViewById(R.id.bgDefaultView);
        this.lct = findViewById(R.id.header_round_corner_layout);
        this.lcu = (BarImageView) findViewById(R.id.iconView);
        this.evg = (TextView) findViewById(R.id.titleView);
        this.lcv = (TextView) findViewById(R.id.titlePreView);
        this.lcw = (TextView) findViewById(R.id.titleNextView);
        this.ajm = (TextView) findViewById(R.id.tagView);
        this.jQQ = (TextView) findViewById(R.id.descView);
        this.lcx = (TextView) findViewById(R.id.descView1);
        this.lcy = findViewById(R.id.descLayout);
        this.lcz = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.lcA = (TextView) findViewById(R.id.blessView);
        this.lcA.setAlpha(0.66f);
        this.lcs.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.lcu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lcu.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.lcu.setPlaceHolder(2);
        this.ajm.setAlpha(0.66f);
        this.lcy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).dfn();
            }
        });
        this.lcz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.lcB != null) {
                    TiebaStatic.log(new aq("c13819").al("obj_type", HotTopicDetailHeadView.this.lcB.jOU));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.lcB);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.lcs.setVisibility(TextUtils.isEmpty(fVar.jPu) ? 0 : 8);
            this.lcu.startLoad(fVar.jPu, 10, false);
            this.lcr.startLoad(fVar.jPu, 39, false);
            this.evg.setText(fVar.eCJ);
            if (fVar.jPv > 0) {
                this.jQQ.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.jPv));
                this.jQQ.setVisibility(0);
            } else {
                this.jQQ.setVisibility(8);
            }
            this.ajm.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), at.dy(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.lcB = aVar;
        if (aVar == null) {
            this.lcz.setVisibility(8);
            this.lcA.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evg.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.evg.getContext(), R.dimen.tbds84);
            this.evg.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lcw.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.lcw.setLayoutParams(layoutParams2);
            return;
        }
        this.lcA.setText(getContext().getResources().getString(Fm(aVar.jOU), at.dy(aVar.totalNum)));
        if (aVar.jOR == 1) {
            this.lcz.setVisibility(8);
            this.lcA.setVisibility(0);
            this.lcA.setTranslationX(0.0f);
        } else {
            this.lcz.setVisibility(0);
            this.lcA.setVisibility(4);
            Fn(aVar.jOU);
            this.lcz.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.evg.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.evg.getContext(), R.dimen.tbds280);
        this.evg.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.lcw.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.lcw.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int Fm(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void Fn(int i) {
        if (this.lcz != null && this.lcz.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.lcz.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.lcz, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.lcz.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.lcz, R.raw.lottie_candle);
                } else {
                    this.lcz.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.lcz, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.lcz.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.lcz, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.lcz.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.lcz, R.raw.lottie_candle_1);
            } else {
                this.lcz.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.lcz, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jBV != i) {
            ap.setBackgroundResource(this.lct, R.drawable.bg_header_round_corner);
            this.lcs.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
            ap.setViewTextColor(this.evg, R.color.cp_cont_a);
            ap.setViewTextColor(this.lcv, R.color.cp_cont_a);
            ap.setViewTextColor(this.lcw, R.color.cp_cont_a);
            ap.setViewTextColor(this.ajm, R.color.cp_cont_a);
            ap.setViewTextColor(this.jQQ, R.color.cp_cont_a);
            ap.setViewTextColor(this.lcx, R.color.cp_cont_a);
            ap.setViewTextColor(this.lcA, R.color.cp_cont_a);
            if (this.lcB != null) {
                Fn(this.lcB.jOU);
            }
            this.jBV = i;
        }
    }

    public void F(long j, long j2) {
        if (this.lcB != null && this.lcB.jOR != 1) {
            this.lcz.playAnimation();
            dfA();
            this.lcB.jOR = 1;
            this.lcB.userPkId = j2;
        }
    }

    private void dfA() {
        if (this.lcC != null) {
            this.lcC.cancel();
        }
        final int width = this.lcA.getWidth();
        if (width > 0) {
            this.lcA.setTranslationX(width);
            this.lcA.setVisibility(0);
            this.lcC = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.lcC.setDuration(200L);
            this.lcC.setStartDelay(1000L);
            this.lcC.setInterpolator(new AccelerateDecelerateInterpolator());
            this.lcC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.lcA.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.lcC.start();
        }
    }
}
