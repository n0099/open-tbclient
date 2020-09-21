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
/* loaded from: classes20.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView aiT;
    private TextView dUN;
    private int iUD;
    private TextView jjv;
    private TbImageView kuL;
    private View kuM;
    private View kuN;
    private BarImageView kuO;
    private TextView kuP;
    private TextView kuQ;
    private TextView kuR;
    private View kuS;
    private TBLottieAnimationView kuT;
    private TextView kuU;
    private a kuV;
    private ValueAnimator kuW;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.iUD = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iUD = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUD = 3;
        initView();
    }

    private void initView() {
        e<?> I = i.I(getContext());
        if (I instanceof TbPageContext) {
            this.pageContext = (TbPageContext) I;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.kuL = (TbImageView) findViewById(R.id.bgView);
        this.kuM = findViewById(R.id.bgDefaultView);
        this.kuN = findViewById(R.id.header_round_corner_layout);
        this.kuO = (BarImageView) findViewById(R.id.iconView);
        this.dUN = (TextView) findViewById(R.id.titleView);
        this.kuP = (TextView) findViewById(R.id.titlePreView);
        this.kuQ = (TextView) findViewById(R.id.titleNextView);
        this.aiT = (TextView) findViewById(R.id.tagView);
        this.jjv = (TextView) findViewById(R.id.descView);
        this.kuR = (TextView) findViewById(R.id.descView1);
        this.kuS = findViewById(R.id.descLayout);
        this.kuT = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.kuU = (TextView) findViewById(R.id.blessView);
        this.kuU.setAlpha(0.66f);
        this.kuM.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
        this.kuO.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.kuO.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.kuO.setPlaceHolder(2);
        this.aiT.setAlpha(0.66f);
        this.kuS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).cVU();
            }
        });
        this.kuT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.kuV != null) {
                    TiebaStatic.log(new aq("c13819").ai("obj_type", HotTopicDetailHeadView.this.kuV.jhy));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.kuV);
                }
            }
        });
    }

    public void setTopicInfo(f fVar) {
        if (fVar != null) {
            this.kuM.setVisibility(TextUtils.isEmpty(fVar.jhY) ? 0 : 8);
            this.kuO.startLoad(fVar.jhY, 10, false);
            this.kuL.startLoad(fVar.jhY, 39, false);
            this.dUN.setText(fVar.ecp);
            if (fVar.jhZ > 0) {
                this.jjv.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.jhZ));
                this.jjv.setVisibility(0);
            } else {
                this.jjv.setVisibility(8);
            }
            this.aiT.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), at.cS(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.kuV = aVar;
        if (aVar == null) {
            this.kuT.setVisibility(8);
            this.kuU.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUN.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.dUN.getContext(), R.dimen.tbds84);
            this.dUN.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kuQ.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.kuQ.setLayoutParams(layoutParams2);
            return;
        }
        this.kuU.setText(getContext().getResources().getString(Ea(aVar.jhy), at.cS(aVar.totalNum)));
        if (aVar.jhv == 1) {
            this.kuT.setVisibility(8);
            this.kuU.setVisibility(0);
            this.kuU.setTranslationX(0.0f);
        } else {
            this.kuT.setVisibility(0);
            this.kuU.setVisibility(4);
            Eb(aVar.jhy);
            this.kuT.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dUN.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.dUN.getContext(), R.dimen.tbds280);
        this.dUN.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.kuQ.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.kuQ.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int Ea(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void Eb(int i) {
        if (this.kuT != null && this.kuT.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.kuT.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.kuT, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.kuT.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.kuT, R.raw.lottie_candle);
                } else {
                    this.kuT.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.kuT, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.kuT.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.kuT, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.kuT.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.kuT, R.raw.lottie_candle_1);
            } else {
                this.kuT.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.kuT, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.iUD != i) {
            ap.setBackgroundResource(this.kuN, R.drawable.bg_header_round_corner);
            this.kuM.setBackgroundColor(ap.getColor(R.color.cp_link_tip_a));
            ap.setViewTextColor(this.dUN, R.color.cp_cont_a);
            ap.setViewTextColor(this.kuP, R.color.cp_cont_a);
            ap.setViewTextColor(this.kuQ, R.color.cp_cont_a);
            ap.setViewTextColor(this.aiT, R.color.cp_cont_a);
            ap.setViewTextColor(this.jjv, R.color.cp_cont_a);
            ap.setViewTextColor(this.kuR, R.color.cp_cont_a);
            ap.setViewTextColor(this.kuU, R.color.cp_cont_a);
            if (this.kuV != null) {
                Eb(this.kuV.jhy);
            }
            this.iUD = i;
        }
    }

    public void D(long j, long j2) {
        if (this.kuV != null && this.kuV.jhv != 1) {
            this.kuT.playAnimation();
            cWh();
            this.kuV.jhv = 1;
            this.kuV.userPkId = j2;
        }
    }

    private void cWh() {
        if (this.kuW != null) {
            this.kuW.cancel();
        }
        final int width = this.kuU.getWidth();
        if (width > 0) {
            this.kuU.setTranslationX(width);
            this.kuU.setVisibility(0);
            this.kuW = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.kuW.setDuration(200L);
            this.kuW.setStartDelay(1000L);
            this.kuW.setInterpolator(new AccelerateDecelerateInterpolator());
            this.kuW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.kuU.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.kuW.start();
        }
    }
}
