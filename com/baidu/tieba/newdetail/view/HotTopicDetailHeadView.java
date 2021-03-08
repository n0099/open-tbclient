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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.a;
import com.baidu.tieba.newdetail.HotTopicDetailActivity;
/* loaded from: classes7.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView ali;
    private TextView eIY;
    private int kiZ;
    private TextView kyk;
    private TbImageView lBi;
    private View lBj;
    private View lBk;
    private BarImageView lBl;
    private TextView lBm;
    private TextView lBn;
    private TextView lBo;
    private View lBp;
    private TBLottieAnimationView lBq;
    private TextView lBr;
    private a lBs;
    private ValueAnimator lBt;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.kiZ = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kiZ = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kiZ = 3;
        initView();
    }

    private void initView() {
        f<?> J = j.J(getContext());
        if (J instanceof TbPageContext) {
            this.pageContext = (TbPageContext) J;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.lBi = (TbImageView) findViewById(R.id.bgView);
        this.lBj = findViewById(R.id.bgDefaultView);
        this.lBk = findViewById(R.id.header_round_corner_layout);
        this.lBl = (BarImageView) findViewById(R.id.iconView);
        this.eIY = (TextView) findViewById(R.id.titleView);
        this.lBm = (TextView) findViewById(R.id.titlePreView);
        this.lBn = (TextView) findViewById(R.id.titleNextView);
        this.ali = (TextView) findViewById(R.id.tagView);
        this.kyk = (TextView) findViewById(R.id.descView);
        this.lBo = (TextView) findViewById(R.id.descView1);
        this.lBp = findViewById(R.id.descLayout);
        this.lBq = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.lBr = (TextView) findViewById(R.id.blessView);
        this.lBr.setAlpha(0.66f);
        this.lBj.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
        this.lBl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lBl.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.lBl.setPlaceHolder(1);
        this.ali.setAlpha(0.66f);
        this.lBp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).dih();
            }
        });
        this.lBq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.lBs != null) {
                    TiebaStatic.log(new ar("c13819").aq("obj_type", HotTopicDetailHeadView.this.lBs.kwn));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.lBs);
                }
            }
        });
    }

    public void setTopicInfo(com.baidu.tieba.hottopic.data.f fVar) {
        if (fVar != null) {
            this.lBj.setVisibility(TextUtils.isEmpty(fVar.kwN) ? 0 : 8);
            this.lBl.startLoad(fVar.kwN, 10, false);
            this.lBi.startLoad(fVar.kwN, 39, false);
            this.eIY.setText(fVar.eQU);
            if (fVar.kwO > 0) {
                this.kyk.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.kwO));
                this.kyk.setVisibility(0);
            } else {
                this.kyk.setVisibility(8);
            }
            this.ali.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), au.ed(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.lBs = aVar;
        if (aVar == null) {
            this.lBq.setVisibility(8);
            this.lBr.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eIY.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.eIY.getContext(), R.dimen.tbds84);
            this.eIY.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lBn.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.lBn.setLayoutParams(layoutParams2);
            return;
        }
        this.lBr.setText(getContext().getResources().getString(Fg(aVar.kwn), au.ed(aVar.totalNum)));
        if (aVar.kwk == 1) {
            this.lBq.setVisibility(8);
            this.lBr.setVisibility(0);
            this.lBr.setTranslationX(0.0f);
        } else {
            this.lBq.setVisibility(0);
            this.lBr.setVisibility(4);
            Fh(aVar.kwn);
            this.lBq.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eIY.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.eIY.getContext(), R.dimen.tbds280);
        this.eIY.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.lBn.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.lBn.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int Fg(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void Fh(int i) {
        if (this.lBq != null && this.lBq.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.lBq.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.lBq, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.lBq.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.lBq, R.raw.lottie_candle);
                } else {
                    this.lBq.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.lBq, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.lBq.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.lBq, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.lBq.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.lBq, R.raw.lottie_candle_1);
            } else {
                this.lBq.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.lBq, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kiZ != i) {
            ap.setBackgroundResource(this.lBk, R.drawable.bg_header_round_corner);
            this.lBj.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
            ap.setViewTextColor(this.eIY, R.color.CAM_X0101);
            ap.setViewTextColor(this.lBm, R.color.CAM_X0101);
            ap.setViewTextColor(this.lBn, R.color.CAM_X0101);
            ap.setViewTextColor(this.ali, R.color.CAM_X0101);
            ap.setViewTextColor(this.kyk, R.color.CAM_X0101);
            ap.setViewTextColor(this.lBo, R.color.CAM_X0101);
            ap.setViewTextColor(this.lBr, R.color.CAM_X0101);
            if (this.lBs != null) {
                Fh(this.lBs.kwn);
            }
            this.kiZ = i;
        }
    }

    public void L(long j, long j2) {
        if (this.lBs != null && this.lBs.kwk != 1) {
            this.lBq.playAnimation();
            diu();
            this.lBs.kwk = 1;
            this.lBs.userPkId = j2;
        }
    }

    private void diu() {
        if (this.lBt != null) {
            this.lBt.cancel();
        }
        final int width = this.lBr.getWidth();
        if (width > 0) {
            this.lBr.setTranslationX(width);
            this.lBr.setVisibility(0);
            this.lBt = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.lBt.setDuration(200L);
            this.lBt.setStartDelay(1000L);
            this.lBt.setInterpolator(new AccelerateDecelerateInterpolator());
            this.lBt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.lBr.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.lBt.start();
        }
    }
}
