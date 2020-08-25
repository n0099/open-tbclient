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
    private TextView aix;
    private TextView dSz;
    private int iLR;
    private TextView jaJ;
    private TbImageView kmf;
    private View kmg;
    private View kmh;
    private BarImageView kmi;
    private TextView kmj;
    private TextView kmk;
    private TextView kml;
    private View kmm;
    private TBLottieAnimationView kmn;
    private TextView kmo;
    private a kmp;
    private ValueAnimator kmq;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.iLR = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLR = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLR = 3;
        initView();
    }

    private void initView() {
        e<?> I = i.I(getContext());
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.kmf = (TbImageView) findViewById(R.id.bgView);
        this.kmg = findViewById(R.id.bgDefaultView);
        this.kmh = findViewById(R.id.header_round_corner_layout);
        this.kmi = (BarImageView) findViewById(R.id.iconView);
        this.dSz = (TextView) findViewById(R.id.titleView);
        this.kmj = (TextView) findViewById(R.id.titlePreView);
        this.kmk = (TextView) findViewById(R.id.titleNextView);
        this.aix = (TextView) findViewById(R.id.tagView);
        this.jaJ = (TextView) findViewById(R.id.descView);
        this.kml = (TextView) findViewById(R.id.descView1);
        this.kmm = findViewById(R.id.descLayout);
        this.kmn = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.kmo = (TextView) findViewById(R.id.blessView);
        this.kmo.setAlpha(0.66f);
        this.kmg.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.kmi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kmi.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.kmi.setPlaceHolder(2);
        this.aix.setAlpha(0.66f);
        this.kmm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).cSo();
            }
        });
        this.kmn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.kmp != null) {
                    TiebaStatic.log(new aq("c13819").ai("obj_type", HotTopicDetailHeadView.this.kmp.iYN));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.kmp);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.kmg.setVisibility(TextUtils.isEmpty(fVar.iZn) ? 0 : 8);
            this.kmi.startLoad(fVar.iZn, 10, false);
            this.kmf.startLoad(fVar.iZn, 39, false);
            this.dSz.setText(fVar.eab);
            if (fVar.iZo > 0) {
                this.jaJ.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.iZo));
                this.jaJ.setVisibility(0);
            } else {
                this.jaJ.setVisibility(8);
            }
            this.aix.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), at.cR(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.kmp = aVar;
        if (aVar == null) {
            this.kmn.setVisibility(8);
            this.kmo.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dSz.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.dSz.getContext(), R.dimen.tbds84);
            this.dSz.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kmk.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.kmk.setLayoutParams(layoutParams2);
            return;
        }
        this.kmo.setText(getContext().getResources().getString(Dz(aVar.iYN), at.cR(aVar.totalNum)));
        if (aVar.iYK == 1) {
            this.kmn.setVisibility(8);
            this.kmo.setVisibility(0);
            this.kmo.setTranslationX(0.0f);
        } else {
            this.kmn.setVisibility(0);
            this.kmo.setVisibility(4);
            DA(aVar.iYN);
            this.kmn.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dSz.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.dSz.getContext(), R.dimen.tbds280);
        this.dSz.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kmk.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.kmk.setLayoutParams(layoutParams4);
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
        if (this.kmn != null && this.kmn.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.kmn.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.kmn, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.kmn.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.kmn, R.raw.lottie_candle);
                } else {
                    this.kmn.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.kmn, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.kmn.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.kmn, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.kmn.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.kmn, R.raw.lottie_candle_1);
            } else {
                this.kmn.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.kmn, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iLR != i) {
            ap.setBackgroundResource(this.kmh, R.drawable.bg_header_round_corner);
            this.kmg.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
            ap.setViewTextColor(this.dSz, R.color.cp_cont_a);
            ap.setViewTextColor(this.kmj, R.color.cp_cont_a);
            ap.setViewTextColor(this.kmk, R.color.cp_cont_a);
            ap.setViewTextColor(this.aix, R.color.cp_cont_a);
            ap.setViewTextColor(this.jaJ, R.color.cp_cont_a);
            ap.setViewTextColor(this.kml, R.color.cp_cont_a);
            ap.setViewTextColor(this.kmo, R.color.cp_cont_a);
            if (this.kmp != null) {
                DA(this.kmp.iYN);
            }
            this.iLR = i;
        }
    }

    public void G(long j, long j2) {
        if (this.kmp != null && this.kmp.iYK != 1) {
            this.kmn.playAnimation();
            cSB();
            this.kmp.iYK = 1;
            this.kmp.userPkId = j2;
        }
    }

    private void cSB() {
        if (this.kmq != null) {
            this.kmq.cancel();
        }
        final int width = this.kmo.getWidth();
        if (width > 0) {
            this.kmo.setTranslationX(width);
            this.kmo.setVisibility(0);
            this.kmq = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.kmq.setDuration(200L);
            this.kmq.setStartDelay(1000L);
            this.kmq.setInterpolator(new AccelerateDecelerateInterpolator());
            this.kmq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.kmo.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.kmq.start();
        }
    }
}
