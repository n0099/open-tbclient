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
    private TextView ajl;
    private TextView egP;
    private int jjB;
    private TextView jyt;
    private TbImageView kJX;
    private View kJY;
    private View kJZ;
    private BarImageView kKa;
    private TextView kKb;
    private TextView kKc;
    private TextView kKd;
    private View kKe;
    private TBLottieAnimationView kKf;
    private TextView kKg;
    private a kKh;
    private ValueAnimator kKi;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.jjB = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjB = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjB = 3;
        initView();
    }

    private void initView() {
        e<?> I = i.I(getContext());
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.kJX = (TbImageView) findViewById(R.id.bgView);
        this.kJY = findViewById(R.id.bgDefaultView);
        this.kJZ = findViewById(R.id.header_round_corner_layout);
        this.kKa = (BarImageView) findViewById(R.id.iconView);
        this.egP = (TextView) findViewById(R.id.titleView);
        this.kKb = (TextView) findViewById(R.id.titlePreView);
        this.kKc = (TextView) findViewById(R.id.titleNextView);
        this.ajl = (TextView) findViewById(R.id.tagView);
        this.jyt = (TextView) findViewById(R.id.descView);
        this.kKd = (TextView) findViewById(R.id.descView1);
        this.kKe = findViewById(R.id.descLayout);
        this.kKf = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.kKg = (TextView) findViewById(R.id.blessView);
        this.kKg.setAlpha(0.66f);
        this.kJY.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.kKa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kKa.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.kKa.setPlaceHolder(2);
        this.ajl.setAlpha(0.66f);
        this.kKe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).cZD();
            }
        });
        this.kKf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.kKh != null) {
                    TiebaStatic.log(new aq("c13819").aj("obj_type", HotTopicDetailHeadView.this.kKh.jwx));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.kKh);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.kJY.setVisibility(TextUtils.isEmpty(fVar.jwX) ? 0 : 8);
            this.kKa.startLoad(fVar.jwX, 10, false);
            this.kJX.startLoad(fVar.jwX, 39, false);
            this.egP.setText(fVar.eou);
            if (fVar.jwY > 0) {
                this.jyt.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.jwY));
                this.jyt.setVisibility(0);
            } else {
                this.jyt.setVisibility(8);
            }
            this.ajl.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), at.da(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.kKh = aVar;
        if (aVar == null) {
            this.kKf.setVisibility(8);
            this.kKg.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.egP.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.egP.getContext(), R.dimen.tbds84);
            this.egP.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kKc.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.kKc.setLayoutParams(layoutParams2);
            return;
        }
        this.kKg.setText(getContext().getResources().getString(EG(aVar.jwx), at.da(aVar.totalNum)));
        if (aVar.jwu == 1) {
            this.kKf.setVisibility(8);
            this.kKg.setVisibility(0);
            this.kKg.setTranslationX(0.0f);
        } else {
            this.kKf.setVisibility(0);
            this.kKg.setVisibility(4);
            EH(aVar.jwx);
            this.kKf.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.egP.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.egP.getContext(), R.dimen.tbds280);
        this.egP.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kKc.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.kKc.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int EG(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void EH(int i) {
        if (this.kKf != null && this.kKf.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.kKf.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.kKf, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.kKf.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.kKf, R.raw.lottie_candle);
                } else {
                    this.kKf.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.kKf, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.kKf.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.kKf, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.kKf.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.kKf, R.raw.lottie_candle_1);
            } else {
                this.kKf.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.kKf, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != i) {
            ap.setBackgroundResource(this.kJZ, R.drawable.bg_header_round_corner);
            this.kJY.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
            ap.setViewTextColor(this.egP, R.color.cp_cont_a);
            ap.setViewTextColor(this.kKb, R.color.cp_cont_a);
            ap.setViewTextColor(this.kKc, R.color.cp_cont_a);
            ap.setViewTextColor(this.ajl, R.color.cp_cont_a);
            ap.setViewTextColor(this.jyt, R.color.cp_cont_a);
            ap.setViewTextColor(this.kKd, R.color.cp_cont_a);
            ap.setViewTextColor(this.kKg, R.color.cp_cont_a);
            if (this.kKh != null) {
                EH(this.kKh.jwx);
            }
            this.jjB = i;
        }
    }

    public void D(long j, long j2) {
        if (this.kKh != null && this.kKh.jwu != 1) {
            this.kKf.playAnimation();
            cZQ();
            this.kKh.jwu = 1;
            this.kKh.userPkId = j2;
        }
    }

    private void cZQ() {
        if (this.kKi != null) {
            this.kKi.cancel();
        }
        final int width = this.kKg.getWidth();
        if (width > 0) {
            this.kKg.setTranslationX(width);
            this.kKg.setVisibility(0);
            this.kKi = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.kKi.setDuration(200L);
            this.kKi.setStartDelay(1000L);
            this.kKi.setInterpolator(new AccelerateDecelerateInterpolator());
            this.kKi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.kKg.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.kKi.start();
        }
    }
}
