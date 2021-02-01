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
    private int kgI;
    private TextView kvU;
    private TbImageView lyS;
    private View lyT;
    private View lyU;
    private BarImageView lyV;
    private TextView lyW;
    private TextView lyX;
    private TextView lyY;
    private View lyZ;
    private TBLottieAnimationView lza;
    private TextView lzb;
    private a lzc;
    private ValueAnimator lzd;
    private TbPageContext<HotTopicDetailActivity> pageContext;

    public HotTopicDetailHeadView(Context context) {
        super(context);
        this.kgI = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgI = 3;
        initView();
    }

    public HotTopicDetailHeadView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgI = 3;
        initView();
    }

    private void initView() {
        f<?> K = j.K(getContext());
        if (K instanceof TbPageContext) {
            this.pageContext = (TbPageContext) K;
        }
        LayoutInflater.from(getContext()).inflate(R.layout.hot_topic_detail_head_item, (ViewGroup) this, true);
        this.lyS = (TbImageView) findViewById(R.id.bgView);
        this.lyT = findViewById(R.id.bgDefaultView);
        this.lyU = findViewById(R.id.header_round_corner_layout);
        this.lyV = (BarImageView) findViewById(R.id.iconView);
        this.eHx = (TextView) findViewById(R.id.titleView);
        this.lyW = (TextView) findViewById(R.id.titlePreView);
        this.lyX = (TextView) findViewById(R.id.titleNextView);
        this.ajQ = (TextView) findViewById(R.id.tagView);
        this.kvU = (TextView) findViewById(R.id.descView);
        this.lyY = (TextView) findViewById(R.id.descView1);
        this.lyZ = findViewById(R.id.descLayout);
        this.lza = (TBLottieAnimationView) findViewById(R.id.blessLayout);
        this.lzb = (TextView) findViewById(R.id.blessView);
        this.lzb.setAlpha(0.66f);
        this.lyT.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
        this.lyV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.lyV.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.lyV.setPlaceHolder(1);
        this.ajQ.setAlpha(0.66f);
        this.lyZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).dhR();
            }
        });
        this.lza.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotTopicDetailHeadView.this.lzc != null) {
                    TiebaStatic.log(new ar("c13819").ap("obj_type", HotTopicDetailHeadView.this.lzc.ktX));
                    ((HotTopicDetailActivity) HotTopicDetailHeadView.this.pageContext.getOrignalPage()).a(HotTopicDetailHeadView.this.lzc);
                }
            }
        });
    }

    public void setTopicInfo(com.baidu.tieba.hottopic.data.f fVar) {
        if (fVar != null) {
            this.lyT.setVisibility(TextUtils.isEmpty(fVar.kux) ? 0 : 8);
            this.lyV.startLoad(fVar.kux, 10, false);
            this.lyS.startLoad(fVar.kux, 39, false);
            this.eHx.setText(fVar.ePt);
            if (fVar.kuy > 0) {
                this.kvU.setText(String.format(getContext().getString(R.string.hot_topic_rank_list_head_desc), "" + fVar.kuy));
                this.kvU.setVisibility(0);
            } else {
                this.kvU.setVisibility(8);
            }
            this.ajQ.setText(String.format(getContext().getString(R.string.hot_topic_rank_item_tag), au.ed(fVar.postNum)));
        }
    }

    public void setBlessInfo(a aVar) {
        this.lzc = aVar;
        if (aVar == null) {
            this.lza.setVisibility(8);
            this.lzb.setVisibility(4);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eHx.getLayoutParams();
            layoutParams.rightMargin = l.getDimens(this.eHx.getContext(), R.dimen.tbds84);
            this.eHx.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lyX.getLayoutParams();
            layoutParams2.leftMargin = -layoutParams.rightMargin;
            this.lyX.setLayoutParams(layoutParams2);
            return;
        }
        this.lzb.setText(getContext().getResources().getString(Fd(aVar.ktX), au.ed(aVar.totalNum)));
        if (aVar.ktU == 1) {
            this.lza.setVisibility(8);
            this.lzb.setVisibility(0);
            this.lzb.setTranslationX(0.0f);
        } else {
            this.lza.setVisibility(0);
            this.lzb.setVisibility(4);
            Fe(aVar.ktX);
            this.lza.cancelAnimation();
        }
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eHx.getLayoutParams();
        layoutParams3.rightMargin = l.getDimens(this.eHx.getContext(), R.dimen.tbds280);
        this.eHx.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.lyX.getLayoutParams();
        layoutParams4.leftMargin = -layoutParams3.rightMargin;
        this.lyX.setLayoutParams(layoutParams4);
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
        if (this.lza != null && this.lza.getVisibility() == 0) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 0 || skinType == 3) {
                if (i == 1) {
                    this.lza.setImageAssetsFolder("lottie_watch/");
                    ap.a(this.lza, R.raw.lottie_watch);
                } else if (i == 2) {
                    this.lza.setImageAssetsFolder("lottie_candle/");
                    ap.a(this.lza, R.raw.lottie_candle);
                } else {
                    this.lza.setImageAssetsFolder("lottie_bless/");
                    ap.a(this.lza, R.raw.lottie_bless);
                }
            } else if (i == 1) {
                this.lza.setImageAssetsFolder("lottie_watch_1/");
                ap.a(this.lza, R.raw.lottie_watch_1);
            } else if (i == 2) {
                this.lza.setImageAssetsFolder("lottie_candle_1/");
                ap.a(this.lza, R.raw.lottie_candle_1);
            } else {
                this.lza.setImageAssetsFolder("lottie_bless_1/");
                ap.a(this.lza, R.raw.lottie_bless_1);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.kgI != i) {
            ap.setBackgroundResource(this.lyU, R.drawable.bg_header_round_corner);
            this.lyT.setBackgroundColor(ap.getColor(R.color.CAM_X0302));
            ap.setViewTextColor(this.eHx, R.color.CAM_X0101);
            ap.setViewTextColor(this.lyW, R.color.CAM_X0101);
            ap.setViewTextColor(this.lyX, R.color.CAM_X0101);
            ap.setViewTextColor(this.ajQ, R.color.CAM_X0101);
            ap.setViewTextColor(this.kvU, R.color.CAM_X0101);
            ap.setViewTextColor(this.lyY, R.color.CAM_X0101);
            ap.setViewTextColor(this.lzb, R.color.CAM_X0101);
            if (this.lzc != null) {
                Fe(this.lzc.ktX);
            }
            this.kgI = i;
        }
    }

    public void L(long j, long j2) {
        if (this.lzc != null && this.lzc.ktU != 1) {
            this.lza.playAnimation();
            die();
            this.lzc.ktU = 1;
            this.lzc.userPkId = j2;
        }
    }

    private void die() {
        if (this.lzd != null) {
            this.lzd.cancel();
        }
        final int width = this.lzb.getWidth();
        if (width > 0) {
            this.lzb.setTranslationX(width);
            this.lzb.setVisibility(0);
            this.lzd = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.lzd.setDuration(200L);
            this.lzd.setStartDelay(1000L);
            this.lzd.setInterpolator(new AccelerateDecelerateInterpolator());
            this.lzd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailHeadView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    HotTopicDetailHeadView.this.lzb.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue() * width);
                }
            });
            this.lzd.start();
        }
    }
}
