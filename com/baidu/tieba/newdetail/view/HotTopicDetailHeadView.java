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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.a;
import com.baidu.tieba.hottopic.data.f;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes8.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView dDu;
    private TextView iFF;
    private int iqP;
    private TextView irc;
    private TbImageView jOj;
    private View jOk;
    private View jOl;
    private BarImageView jOm;
    private TextView jOn;
    private TextView jOo;
    private TextView jOp;
    private View jOq;
    private TBLottieAnimationView jOr;
    private TextView jOs;
    private a jOt;
    private ValueAnimator jOu;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.iqP = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqP = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqP = 3;
        initView();
    }

    private void initView() {
        e<?> G = i.G(getContext());
        if (G instanceof TbPageContext) {
            this.pageContext = (TbPageContext) G;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.jOj = (TbImageView) findViewById(R.id.bgView);
        this.jOk = findViewById(R.id.bgDefaultView);
        this.jOl = findViewById(R.id.header_round_corner_layout);
        this.jOm = (BarImageView) findViewById(R.id.iconView);
        this.dDu = (TextView) findViewById(R.id.titleView);
        this.jOn = (TextView) findViewById(R.id.titlePreView);
        this.jOo = (TextView) findViewById(R.id.titleNextView);
        this.irc = (TextView) findViewById(R.id.tagView);
        this.iFF = (TextView) findViewById(R.id.descView);
        this.jOp = (TextView) findViewById(R.id.descView1);
        this.jOq = findViewById(R.id.descLayout);
        this.jOr = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.jOs = (TextView) findViewById(R.id.blessView);
        this.jOs.setAlpha(0.66f);
        this.jOk.setBackgroundColor(an.getColor(R.color.cp_link_tip_a));
        this.jOm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.jOm.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.jOm.setPlaceHolder(2);
        this.irc.setAlpha(0.66f);
        this.jOq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).cDQ();
            }
        });
        this.jOr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.jOt != null) {
                    TiebaStatic.log(new ao("c13818").ag("obj_type", HotTopicDetailHeadView.this.jOt.iDJ));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.jOt);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.jOk.setVisibility(TextUtils.isEmpty(fVar.iEj) ? 0 : 8);
            this.jOm.startLoad(fVar.iEj, 10, false);
            this.jOj.startLoad(fVar.iEj, 39, false);
            this.dDu.setText(fVar.dKw);
            if (fVar.iEk > 0) {
                this.iFF.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.iEk));
                this.iFF.setVisibility(0);
            } else {
                this.iFF.setVisibility(8);
            }
            this.irc.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), ar.cn(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.jOt = aVar;
        if (aVar == null) {
            this.jOr.setVisibility(8);
            this.jOs.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dDu.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.dDu.getContext(), R.dimen.tbds84);
            this.dDu.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jOo.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.jOo.setLayoutParams(layoutParams2);
            return;
        }
        this.jOs.setText(getContext().getResources().getString(AH(aVar.iDJ), ar.cn(aVar.totalNum)));
        if (aVar.iDG == 1) {
            this.jOr.setVisibility(8);
            this.jOs.setVisibility(0);
            this.jOs.setTranslationX(0.0f);
        } else {
            this.jOr.setVisibility(0);
            this.jOs.setVisibility(4);
            AI(aVar.iDJ);
            this.jOr.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dDu.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.dDu.getContext(), R.dimen.tbds280);
        this.dDu.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.jOo.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.jOo.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int AH(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void AI(int i) {
        if (this.jOr != null && this.jOr.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.jOr.setImageAssetsFolder("lottie_watch/");
                    an.a(this.jOr, (int) R.raw.lottie_watch);
                } else if (i == 2) {
                    this.jOr.setImageAssetsFolder("lottie_candle/");
                    an.a(this.jOr, (int) R.raw.lottie_candle);
                } else {
                    this.jOr.setImageAssetsFolder("lottie_bless/");
                    an.a(this.jOr, (int) R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.jOr.setImageAssetsFolder("lottie_watch_1/");
                an.a(this.jOr, (int) R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.jOr.setImageAssetsFolder("lottie_candle_1/");
                an.a(this.jOr, (int) R.raw.lottie_candle_1);
            } else {
                this.jOr.setImageAssetsFolder("lottie_bless_1/");
                an.a(this.jOr, (int) R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iqP != i) {
            an.setBackgroundResource(this.jOl, R.drawable.bg_header_round_corner);
            this.jOk.setBackgroundColor(an.getColor(R.color.cp_link_tip_a));
            an.setViewTextColor(this.dDu, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.jOn, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.jOo, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.irc, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.iFF, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.jOp, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.jOs, (int) R.color.cp_cont_a);
            if (this.jOt != null) {
                AI(this.jOt.iDJ);
            }
            this.iqP = i;
        }
    }

    public void F(long j, long j2) {
        if (this.jOt != null && this.jOt.iDG != 1) {
            this.jOr.playAnimation();
            cEd();
            this.jOt.iDG = 1;
            this.jOt.userPkId = j2;
        }
    }

    private void cEd() {
        if (this.jOu != null) {
            this.jOu.cancel();
        }
        final int width = this.jOs.getWidth();
        if (width > 0) {
            this.jOs.setTranslationX(width);
            this.jOs.setVisibility(0);
            this.jOu = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.jOu.setDuration(200L);
            this.jOu.setStartDelay(1000L);
            this.jOu.setInterpolator(new AccelerateDecelerateInterpolator());
            this.jOu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.jOs.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.jOu.start();
        }
    }
}
