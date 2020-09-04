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
/* loaded from: classes15.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView aiz;
    private TextView dSD;
    private int iLX;
    private TextView jaP;
    private TbImageView kmm;
    private View kmn;
    private View kmo;
    private BarImageView kmp;
    private TextView kmq;
    private TextView kmr;
    private TextView kms;
    private View kmt;
    private TBLottieAnimationView kmu;
    private TextView kmv;
    private a kmw;
    private ValueAnimator kmx;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.iLX = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLX = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLX = 3;
        initView();
    }

    private void initView() {
        e<?> I = i.I(getContext());
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.kmm = (TbImageView) findViewById(R.id.bgView);
        this.kmn = findViewById(R.id.bgDefaultView);
        this.kmo = findViewById(R.id.header_round_corner_layout);
        this.kmp = (BarImageView) findViewById(R.id.iconView);
        this.dSD = (TextView) findViewById(R.id.titleView);
        this.kmq = (TextView) findViewById(R.id.titlePreView);
        this.kmr = (TextView) findViewById(R.id.titleNextView);
        this.aiz = (TextView) findViewById(R.id.tagView);
        this.jaP = (TextView) findViewById(R.id.descView);
        this.kms = (TextView) findViewById(R.id.descView1);
        this.kmt = findViewById(R.id.descLayout);
        this.kmu = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.kmv = (TextView) findViewById(R.id.blessView);
        this.kmv.setAlpha(0.66f);
        this.kmn.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.kmp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kmp.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.kmp.setPlaceHolder(2);
        this.aiz.setAlpha(0.66f);
        this.kmt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).cSp();
            }
        });
        this.kmu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.kmw != null) {
                    TiebaStatic.log(new aq("c13819").ai("obj_type", HotTopicDetailHeadView.this.kmw.iYT));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.kmw);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.kmn.setVisibility(TextUtils.isEmpty(fVar.iZt) ? 0 : 8);
            this.kmp.startLoad(fVar.iZt, 10, false);
            this.kmm.startLoad(fVar.iZt, 39, false);
            this.dSD.setText(fVar.eaf);
            if (fVar.iZu > 0) {
                this.jaP.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.iZu));
                this.jaP.setVisibility(0);
            } else {
                this.jaP.setVisibility(8);
            }
            this.aiz.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), at.cR(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.kmw = aVar;
        if (aVar == null) {
            this.kmu.setVisibility(8);
            this.kmv.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSD.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.dSD.getContext(), R.dimen.tbds84);
            this.dSD.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kmr.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.kmr.setLayoutParams(layoutParams2);
            return;
        }
        this.kmv.setText(getContext().getResources().getString(Dz(aVar.iYT), at.cR(aVar.totalNum)));
        if (aVar.iYQ == 1) {
            this.kmu.setVisibility(8);
            this.kmv.setVisibility(0);
            this.kmv.setTranslationX(0.0f);
        } else {
            this.kmu.setVisibility(0);
            this.kmv.setVisibility(4);
            DA(aVar.iYT);
            this.kmu.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dSD.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.dSD.getContext(), R.dimen.tbds280);
        this.dSD.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kmr.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.kmr.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int Dz(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void DA(int i) {
        if (this.kmu != null && this.kmu.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.kmu.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.kmu, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.kmu.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.kmu, R.raw.lottie_candle);
                } else {
                    this.kmu.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.kmu, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.kmu.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.kmu, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.kmu.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.kmu, R.raw.lottie_candle_1);
            } else {
                this.kmu.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.kmu, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLX != i) {
            ap.setBackgroundResource(this.kmo, R.drawable.bg_header_round_corner);
            this.kmn.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
            ap.setViewTextColor(this.dSD, R.color.cp_cont_a);
            ap.setViewTextColor(this.kmq, R.color.cp_cont_a);
            ap.setViewTextColor(this.kmr, R.color.cp_cont_a);
            ap.setViewTextColor(this.aiz, R.color.cp_cont_a);
            ap.setViewTextColor(this.jaP, R.color.cp_cont_a);
            ap.setViewTextColor(this.kms, R.color.cp_cont_a);
            ap.setViewTextColor(this.kmv, R.color.cp_cont_a);
            if (this.kmw != null) {
                DA(this.kmw.iYT);
            }
            this.iLX = i;
        }
    }

    public void G(long j, long j2) {
        if (this.kmw != null && this.kmw.iYQ != 1) {
            this.kmu.playAnimation();
            cSC();
            this.kmw.iYQ = 1;
            this.kmw.userPkId = j2;
        }
    }

    private void cSC() {
        if (this.kmx != null) {
            this.kmx.cancel();
        }
        final int width = this.kmv.getWidth();
        if (width > 0) {
            this.kmv.setTranslationX(width);
            this.kmv.setVisibility(0);
            this.kmx = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.kmx.setDuration(200L);
            this.kmx.setStartDelay(1000L);
            this.kmx.setInterpolator(new AccelerateDecelerateInterpolator());
            this.kmx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.kmv.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.kmx.start();
        }
    }
}
