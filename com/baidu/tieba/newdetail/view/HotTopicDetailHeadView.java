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
    private int jQu;
    private TextView kfe;
    private TbImageView lqj;
    private View lqk;
    private View lql;
    private BarImageView lqm;
    private TextView lqn;
    private TextView lqo;
    private TextView lqp;
    private View lqq;
    private TBLottieAnimationView lqr;
    private TextView lqs;
    private a lqt;
    private ValueAnimator lqu;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.jQu = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQu = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQu = 3;
        initView();
    }

    private void initView() {
        e<?> J = i.J(getContext());
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.lqj = (TbImageView) findViewById(R.id.bgView);
        this.lqk = findViewById(R.id.bgDefaultView);
        this.lql = findViewById(R.id.header_round_corner_layout);
        this.lqm = (BarImageView) findViewById(R.id.iconView);
        this.eAz = (TextView) findViewById(R.id.titleView);
        this.lqn = (TextView) findViewById(R.id.titlePreView);
        this.lqo = (TextView) findViewById(R.id.titleNextView);
        this.akq = (TextView) findViewById(R.id.tagView);
        this.kfe = (TextView) findViewById(R.id.descView);
        this.lqp = (TextView) findViewById(R.id.descView1);
        this.lqq = findViewById(R.id.descLayout);
        this.lqr = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.lqs = (TextView) findViewById(R.id.blessView);
        this.lqs.setAlpha(0.66f);
        this.lqk.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
        this.lqm.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lqm.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.lqm.setPlaceHolder(1);
        this.akq.setAlpha(0.66f);
        this.lqq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).djW();
            }
        });
        this.lqr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.lqt != null) {
                    TiebaStatic.log(new ar("c13819").al("obj_type", HotTopicDetailHeadView.this.lqt.kdh));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.lqt);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.lqk.setVisibility(TextUtils.isEmpty(fVar.kdH) ? 0 : 8);
            this.lqm.startLoad(fVar.kdH, 10, false);
            this.lqj.startLoad(fVar.kdH, 39, false);
            this.eAz.setText(fVar.eIa);
            if (fVar.kdI > 0) {
                this.kfe.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.kdI));
                this.kfe.setVisibility(0);
            } else {
                this.kfe.setVisibility(8);
            }
            this.akq.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), au.dX(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.lqt = aVar;
        if (aVar == null) {
            this.lqr.setVisibility(8);
            this.lqs.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eAz.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.eAz.getContext(), R.dimen.tbds84);
            this.eAz.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lqo.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.lqo.setLayoutParams(layoutParams2);
            return;
        }
        this.lqs.setText(getContext().getResources().getString(Gz(aVar.kdh), au.dX(aVar.totalNum)));
        if (aVar.kde == 1) {
            this.lqr.setVisibility(8);
            this.lqs.setVisibility(0);
            this.lqs.setTranslationX(0.0f);
        } else {
            this.lqr.setVisibility(0);
            this.lqs.setVisibility(4);
            GA(aVar.kdh);
            this.lqr.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eAz.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.eAz.getContext(), R.dimen.tbds280);
        this.eAz.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.lqo.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.lqo.setLayoutParams(layoutParams4);
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
        if (this.lqr != null && this.lqr.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.lqr.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.lqr, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.lqr.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.lqr, R.raw.lottie_candle);
                } else {
                    this.lqr.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.lqr, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.lqr.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.lqr, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.lqr.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.lqr, R.raw.lottie_candle_1);
            } else {
                this.lqr.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.lqr, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jQu != i) {
            ap.setBackgroundResource(this.lql, R.drawable.bg_header_round_corner);
            this.lqk.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
            ap.setViewTextColor(this.eAz, R.color.CAM_X0101);
            ap.setViewTextColor(this.lqn, R.color.CAM_X0101);
            ap.setViewTextColor(this.lqo, R.color.CAM_X0101);
            ap.setViewTextColor(this.akq, R.color.CAM_X0101);
            ap.setViewTextColor(this.kfe, R.color.CAM_X0101);
            ap.setViewTextColor(this.lqp, R.color.CAM_X0101);
            ap.setViewTextColor(this.lqs, R.color.CAM_X0101);
            if (this.lqt != null) {
                GA(this.lqt.kdh);
            }
            this.jQu = i;
        }
    }

    public void E(long j, long j2) {
        if (this.lqt != null && this.lqt.kde != 1) {
            this.lqr.playAnimation();
            dkj();
            this.lqt.kde = 1;
            this.lqt.userPkId = j2;
        }
    }

    private void dkj() {
        if (this.lqu != null) {
            this.lqu.cancel();
        }
        final int width = this.lqs.getWidth();
        if (width > 0) {
            this.lqs.setTranslationX(width);
            this.lqs.setVisibility(0);
            this.lqu = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.lqu.setDuration(200L);
            this.lqu.setStartDelay(1000L);
            this.lqu.setInterpolator(new AccelerateDecelerateInterpolator());
            this.lqu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.lqs.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.lqu.start();
        }
    }
}
