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
/* loaded from: classes20.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView ajr;
    private TextView etx;
    private int jCS;
    private TextView jRA;
    private TbImageView lcJ;
    private View lcK;
    private View lcL;
    private BarImageView lcM;
    private TextView lcN;
    private TextView lcO;
    private TextView lcP;
    private View lcQ;
    private TBLottieAnimationView lcR;
    private TextView lcS;
    private a lcT;
    private ValueAnimator lcU;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.jCS = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = 3;
        initView();
    }

    private void initView() {
        e<?> I = i.I(getContext());
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.lcJ = (TbImageView) findViewById(R.id.bgView);
        this.lcK = findViewById(R.id.bgDefaultView);
        this.lcL = findViewById(R.id.header_round_corner_layout);
        this.lcM = (BarImageView) findViewById(R.id.iconView);
        this.etx = (TextView) findViewById(R.id.titleView);
        this.lcN = (TextView) findViewById(R.id.titlePreView);
        this.lcO = (TextView) findViewById(R.id.titleNextView);
        this.ajr = (TextView) findViewById(R.id.tagView);
        this.jRA = (TextView) findViewById(R.id.descView);
        this.lcP = (TextView) findViewById(R.id.descView1);
        this.lcQ = findViewById(R.id.descLayout);
        this.lcR = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.lcS = (TextView) findViewById(R.id.blessView);
        this.lcS.setAlpha(0.66f);
        this.lcK.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
        this.lcM.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lcM.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.lcM.setPlaceHolder(1);
        this.ajr.setAlpha(0.66f);
        this.lcQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).deK();
            }
        });
        this.lcR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.lcT != null) {
                    TiebaStatic.log(new ar("c13819").ak("obj_type", HotTopicDetailHeadView.this.lcT.jPE));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.lcT);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.lcK.setVisibility(TextUtils.isEmpty(fVar.jQe) ? 0 : 8);
            this.lcM.startLoad(fVar.jQe, 10, false);
            this.lcJ.startLoad(fVar.jQe, 39, false);
            this.etx.setText(fVar.eBa);
            if (fVar.jQf > 0) {
                this.jRA.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.jQf));
                this.jRA.setVisibility(0);
            } else {
                this.jRA.setVisibility(8);
            }
            this.ajr.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), au.dy(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.lcT = aVar;
        if (aVar == null) {
            this.lcR.setVisibility(8);
            this.lcS.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.etx.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.etx.getContext(), R.dimen.tbds84);
            this.etx.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lcO.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.lcO.setLayoutParams(layoutParams2);
            return;
        }
        this.lcS.setText(getContext().getResources().getString(FK(aVar.jPE), au.dy(aVar.totalNum)));
        if (aVar.jPB == 1) {
            this.lcR.setVisibility(8);
            this.lcS.setVisibility(0);
            this.lcS.setTranslationX(0.0f);
        } else {
            this.lcR.setVisibility(0);
            this.lcS.setVisibility(4);
            FL(aVar.jPE);
            this.lcR.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.etx.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.etx.getContext(), R.dimen.tbds280);
        this.etx.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.lcO.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.lcO.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int FK(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void FL(int i) {
        if (this.lcR != null && this.lcR.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.lcR.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.lcR, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.lcR.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.lcR, R.raw.lottie_candle);
                } else {
                    this.lcR.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.lcR, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.lcR.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.lcR, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.lcR.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.lcR, R.raw.lottie_candle_1);
            } else {
                this.lcR.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.lcR, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.jCS != i) {
            ap.setBackgroundResource(this.lcL, R.drawable.bg_header_round_corner);
            this.lcK.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
            ap.setViewTextColor(this.etx, R.color.CAM_X0101);
            ap.setViewTextColor(this.lcN, R.color.CAM_X0101);
            ap.setViewTextColor(this.lcO, R.color.CAM_X0101);
            ap.setViewTextColor(this.ajr, R.color.CAM_X0101);
            ap.setViewTextColor(this.jRA, R.color.CAM_X0101);
            ap.setViewTextColor(this.lcP, R.color.CAM_X0101);
            ap.setViewTextColor(this.lcS, R.color.CAM_X0101);
            if (this.lcT != null) {
                FL(this.lcT.jPE);
            }
            this.jCS = i;
        }
    }

    public void F(long j, long j2) {
        if (this.lcT != null && this.lcT.jPB != 1) {
            this.lcR.playAnimation();
            deX();
            this.lcT.jPB = 1;
            this.lcT.userPkId = j2;
        }
    }

    private void deX() {
        if (this.lcU != null) {
            this.lcU.cancel();
        }
        final int width = this.lcS.getWidth();
        if (width > 0) {
            this.lcS.setTranslationX(width);
            this.lcS.setVisibility(0);
            this.lcU = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.lcU.setDuration(200L);
            this.lcU.setStartDelay(1000L);
            this.lcU.setInterpolator(new AccelerateDecelerateInterpolator());
            this.lcU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.lcS.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.lcU.start();
        }
    }
}
