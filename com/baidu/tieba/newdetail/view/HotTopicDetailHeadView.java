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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.a;
import com.baidu.tieba.hottopic.data.f;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes21.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView akq;
    private TextView eAz;
    private int jQw;
    private TextView kfg;
    private TbImageView lql;
    private View lqm;
    private View lqn;
    private BarImageView lqo;
    private TextView lqp;
    private TextView lqq;
    private TextView lqr;
    private View lqs;
    private TBLottieAnimationView lqt;
    private TextView lqu;
    private a lqv;
    private ValueAnimator lqw;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.jQw = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQw = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQw = 3;
        initView();
    }

    private void initView() {
        e<?> J = i.J(getContext());
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.lql = (TbImageView) findViewById(R.id.bgView);
        this.lqm = findViewById(R.id.bgDefaultView);
        this.lqn = findViewById(R.id.header_round_corner_layout);
        this.lqo = (BarImageView) findViewById(R.id.iconView);
        this.eAz = (TextView) findViewById(R.id.titleView);
        this.lqp = (TextView) findViewById(R.id.titlePreView);
        this.lqq = (TextView) findViewById(R.id.titleNextView);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.kfg = (TextView) findViewById(R.id.descView);
        this.lqr = (TextView) findViewById(R.id.descView1);
        this.lqs = findViewById(R.id.descLayout);
        this.lqt = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.lqu = (TextView) findViewById(R.id.blessView);
        this.lqu.setAlpha(0.66f);
        this.lqm.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
        this.lqo.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lqo.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.lqo.setPlaceHolder(1);
        this.akq.setAlpha(0.66f);
        this.lqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).djX();
            }
        });
        this.lqt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.lqv != null) {
                    TiebaStatic.log(new ar("c13819").al("obj_type", HotTopicDetailHeadView.this.lqv.kdj));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.lqv);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.lqm.setVisibility(TextUtils.isEmpty(fVar.kdJ) ? 0 : 8);
            this.lqo.startLoad(fVar.kdJ, 10, false);
            this.lql.startLoad(fVar.kdJ, 39, false);
            this.eAz.setText(fVar.eIa);
            if (fVar.kdK > 0) {
                this.kfg.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.kdK));
                this.kfg.setVisibility(0);
            } else {
                this.kfg.setVisibility(8);
            }
            this.akq.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), au.dX(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.lqv = aVar;
        if (aVar == null) {
            this.lqt.setVisibility(8);
            this.lqu.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAz.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.eAz.getContext(), R.dimen.tbds84);
            this.eAz.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lqq.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.lqq.setLayoutParams(layoutParams2);
            return;
        }
        this.lqu.setText(getContext().getResources().getString(Gz(aVar.kdj), au.dX(aVar.totalNum)));
        if (aVar.kdg == 1) {
            this.lqt.setVisibility(8);
            this.lqu.setVisibility(0);
            this.lqu.setTranslationX(0.0f);
        } else {
            this.lqt.setVisibility(0);
            this.lqu.setVisibility(4);
            GA(aVar.kdj);
            this.lqt.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eAz.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.eAz.getContext(), R.dimen.tbds280);
        this.eAz.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.lqq.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.lqq.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int Gz(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void GA(int i) {
        if (this.lqt != null && this.lqt.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.lqt.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.lqt, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.lqt.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.lqt, R.raw.lottie_candle);
                } else {
                    this.lqt.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.lqt, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.lqt.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.lqt, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.lqt.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.lqt, R.raw.lottie_candle_1);
            } else {
                this.lqt.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.lqt, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQw != i) {
            ap.setBackgroundResource(this.lqn, R.drawable.bg_header_round_corner);
            this.lqm.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
            ap.setViewTextColor(this.eAz, R.color.CAM_X0101);
            ap.setViewTextColor(this.lqp, R.color.CAM_X0101);
            ap.setViewTextColor(this.lqq, R.color.CAM_X0101);
            ap.setViewTextColor(this.akq, R.color.CAM_X0101);
            ap.setViewTextColor(this.kfg, R.color.CAM_X0101);
            ap.setViewTextColor(this.lqr, R.color.CAM_X0101);
            ap.setViewTextColor(this.lqu, R.color.CAM_X0101);
            if (this.lqv != null) {
                GA(this.lqv.kdj);
            }
            this.jQw = i;
        }
    }

    public void E(long j, long j2) {
        if (this.lqv != null && this.lqv.kdg != 1) {
            this.lqt.playAnimation();
            dkk();
            this.lqv.kdg = 1;
            this.lqv.userPkId = j2;
        }
    }

    private void dkk() {
        if (this.lqw != null) {
            this.lqw.cancel();
        }
        final int width = this.lqu.getWidth();
        if (width > 0) {
            this.lqu.setTranslationX(width);
            this.lqu.setVisibility(0);
            this.lqw = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.lqw.setDuration(200L);
            this.lqw.setStartDelay(1000L);
            this.lqw.setInterpolator(new AccelerateDecelerateInterpolator());
            this.lqw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.lqu.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.lqw.start();
        }
    }
}
