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
/* loaded from: classes8.dex */
public class HotTopicDetailHeadView extends RelativeLayout {
    private TextView ajQ;
    private TextView eHx;
    private int kgW;
    private TextView kwi;
    private TbImageView lzg;
    private View lzh;
    private View lzi;
    private BarImageView lzj;
    private TextView lzk;
    private TextView lzl;
    private TextView lzm;
    private View lzn;
    private TBLottieAnimationView lzo;
    private TextView lzp;
    private a lzq;
    private ValueAnimator lzr;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.kgW = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgW = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgW = 3;
        initView();
    }

    private void initView() {
        f<?> K = j.K(getContext());
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.lzg = (TbImageView) findViewById(R.id.bgView);
        this.lzh = findViewById(R.id.bgDefaultView);
        this.lzi = findViewById(R.id.header_round_corner_layout);
        this.lzj = (BarImageView) findViewById(R.id.iconView);
        this.eHx = (TextView) findViewById(R.id.titleView);
        this.lzk = (TextView) findViewById(R.id.titlePreView);
        this.lzl = (TextView) findViewById(R.id.titleNextView);
        this.ajQ = (TextView) findViewById(R.id.tagView);
        this.kwi = (TextView) findViewById(R.id.descView);
        this.lzm = (TextView) findViewById(R.id.descView1);
        this.lzn = findViewById(R.id.descLayout);
        this.lzo = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.lzp = (TextView) findViewById(R.id.blessView);
        this.lzp.setAlpha(0.66f);
        this.lzh.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
        this.lzj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lzj.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.lzj.setPlaceHolder(1);
        this.ajQ.setAlpha(0.66f);
        this.lzn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).dhY();
            }
        });
        this.lzo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.lzq != null) {
                    TiebaStatic.log(new ar("c13819").ap("obj_type", HotTopicDetailHeadView.this.lzq.kul));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.lzq);
                }
            }
        });
    }

    public void setTopicInfo(com.baidu.tieba.hottopic.data.f fVar) {
        if (fVar != null) {
            this.lzh.setVisibility(TextUtils.isEmpty(fVar.kuL) ? 0 : 8);
            this.lzj.startLoad(fVar.kuL, 10, false);
            this.lzg.startLoad(fVar.kuL, 39, false);
            this.eHx.setText(fVar.ePt);
            if (fVar.kuM > 0) {
                this.kwi.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.kuM));
                this.kwi.setVisibility(0);
            } else {
                this.kwi.setVisibility(8);
            }
            this.ajQ.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), au.ed(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.lzq = aVar;
        if (aVar == null) {
            this.lzo.setVisibility(8);
            this.lzp.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHx.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.eHx.getContext(), R.dimen.tbds84);
            this.eHx.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lzl.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.lzl.setLayoutParams(layoutParams2);
            return;
        }
        this.lzp.setText(getContext().getResources().getString(Fd(aVar.kul), au.ed(aVar.totalNum)));
        if (aVar.kui == 1) {
            this.lzo.setVisibility(8);
            this.lzp.setVisibility(0);
            this.lzp.setTranslationX(0.0f);
        } else {
            this.lzo.setVisibility(0);
            this.lzp.setVisibility(4);
            Fe(aVar.kul);
            this.lzo.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eHx.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.eHx.getContext(), R.dimen.tbds280);
        this.eHx.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.lzl.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.lzl.setLayoutParams(layoutParams4);
    }

    @StringRes
    private int Fd(int i) {
        if (i == 1) {
            return R.string.hot_topic_bless_tag_watch;
        }
        if (i == 2) {
            return R.string.hot_topic_bless_tag_candle;
        }
        return R.string.hot_topic_bless_tag_bless;
    }

    private void Fe(int i) {
        if (this.lzo != null && this.lzo.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.lzo.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.lzo, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.lzo.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.lzo, R.raw.lottie_candle);
                } else {
                    this.lzo.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.lzo, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.lzo.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.lzo, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.lzo.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.lzo, R.raw.lottie_candle_1);
            } else {
                this.lzo.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.lzo, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kgW != i) {
            ap.setBackgroundResource(this.lzi, R.drawable.bg_header_round_corner);
            this.lzh.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
            ap.setViewTextColor(this.eHx, R.color.CAM_X0101);
            ap.setViewTextColor(this.lzk, R.color.CAM_X0101);
            ap.setViewTextColor(this.lzl, R.color.CAM_X0101);
            ap.setViewTextColor(this.ajQ, R.color.CAM_X0101);
            ap.setViewTextColor(this.kwi, R.color.CAM_X0101);
            ap.setViewTextColor(this.lzm, R.color.CAM_X0101);
            ap.setViewTextColor(this.lzp, R.color.CAM_X0101);
            if (this.lzq != null) {
                Fe(this.lzq.kul);
            }
            this.kgW = i;
        }
    }

    public void L(long j, long j2) {
        if (this.lzq != null && this.lzq.kui != 1) {
            this.lzo.playAnimation();
            dil();
            this.lzq.kui = 1;
            this.lzq.userPkId = j2;
        }
    }

    private void dil() {
        if (this.lzr != null) {
            this.lzr.cancel();
        }
        final int width = this.lzp.getWidth();
        if (width > 0) {
            this.lzp.setTranslationX(width);
            this.lzp.setVisibility(0);
            this.lzr = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.lzr.setDuration(200L);
            this.lzr.setStartDelay(1000L);
            this.lzr.setInterpolator(new AccelerateDecelerateInterpolator());
            this.lzr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.lzp.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.lzr.start();
        }
    }
}
