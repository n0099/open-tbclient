package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.x;
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.CountDownTextView;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.LeftLadderTextView;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.RightLadderTextView;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes11.dex */
public class AlaChallengeLiveView extends RelativeLayout {
    private CountDownTimer gPY;
    private RelativeLayout hfE;
    private Context mContext;
    private ValueAnimator mValueAnimator;
    private CountDownTextView omG;
    private TextView omH;
    private TextView omI;
    private LeftLadderTextView omJ;
    private RightLadderTextView omK;
    private int omL;
    private ImageView omM;
    private ImageView omN;
    private int omO;
    private d omP;
    private View omQ;
    private ObjectAnimator omR;
    private View omS;
    private View omT;
    private LinearLayout omU;
    private LinearLayout omV;
    private LottieAnimationView omW;
    private LottieAnimationView omX;
    private FrameLayout omY;
    private LottieAnimationView omZ;
    private int ona;
    private int onb;
    private boolean onc;
    private long ond;
    private ImageView onf;
    private RelativeLayout ong;
    private boolean onh;
    private boolean oni;
    private RelativeLayout rootView;

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.onc = false;
        this.ond = 0L;
        this.onh = false;
        this.oni = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onc = false;
        this.ond = 0L;
        this.onh = false;
        this.oni = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onc = false;
        this.ond = 0L;
        this.onh = false;
        this.oni = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        eO(context);
    }

    private void eO(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_audio_challenge_panel_optation_view, this);
        this.omO = BdUtilHelper.getScreenSize((Activity) getContext()).widthPixels - BdUtilHelper.dip2px(getContext(), 54.0f);
        this.ona = BdUtilHelper.dip2px(getContext(), 10.0f);
        this.onb = BdUtilHelper.dip2px(getContext(), 20.0f);
        this.hfE = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.ong = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.omG = (CountDownTextView) this.rootView.findViewById(a.f.pk_time_label);
        this.omG.setData(new CountDownTextView.a(0, "00:00"));
        this.omQ = this.rootView.findViewById(a.f.view_shake);
        this.omS = this.rootView.findViewById(a.f.view_left_shape);
        this.omT = this.rootView.findViewById(a.f.view_right_shape);
        this.omM = (ImageView) this.rootView.findViewById(a.f.left_state);
        this.omN = (ImageView) this.rootView.findViewById(a.f.right_state);
        this.omZ = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_center);
        this.omY = (FrameLayout) this.rootView.findViewById(a.f.ll_loading);
        this.omU = (LinearLayout) this.rootView.findViewById(a.f.ll_left_loading);
        this.omX = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_left);
        this.omV = (LinearLayout) this.rootView.findViewById(a.f.ll_right_loading);
        this.omW = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_right);
        this.omH = (TextView) this.rootView.findViewById(a.f.pk_left_progress);
        this.omI = (TextView) this.rootView.findViewById(a.f.pk_right_progress);
        this.omJ = (LeftLadderTextView) this.rootView.findViewById(a.f.left_progress_bg);
        this.omK = (RightLadderTextView) this.rootView.findViewById(a.f.right_progress_bg);
        this.onf = (ImageView) this.rootView.findViewById(a.f.img_view_center);
        this.omZ.setImageAssetsFolder("lottie_team_fight_images/");
        this.omZ.setAnimation("anim_view_center.json");
        this.omZ.loop(true);
        ViewGroup.LayoutParams layoutParams = this.omX.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.omO;
        }
        this.omX.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.omW.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = this.omO;
        }
        this.omW.setLayoutParams(layoutParams2);
        this.omY.setVisibility(4);
        if (this.omX != null) {
            this.omX.cancelAnimation();
        }
        if (this.omW != null) {
            this.omW.cancelAnimation();
        }
        this.omZ.setVisibility(4);
        if (this.omZ != null) {
            this.omZ.cancelAnimation();
        }
        ebY();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.omJ.getLayoutParams();
        layoutParams3.width = (int) (this.omO * 0.5f);
        this.omJ.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.omK.getLayoutParams();
        layoutParams4.width = (int) (this.omO * 0.5f);
        this.omK.setLayoutParams(layoutParams4);
    }

    public void Z(x xVar) {
        if (xVar != null && xVar.aLm != null) {
            this.omL = xVar.aLm.mStep;
            ebX();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            if (this.omP != null) {
                this.onh = dVar.onz != this.omP.onz;
                this.oni = dVar.activity_stage != this.omP.activity_stage;
            }
            this.omP = dVar;
            this.omL = dVar.activity_stage;
            ebX();
        }
    }

    private void ebX() {
        switch (this.omL) {
            case 0:
                ecc();
                return;
            case 1:
                ecb();
                return;
            case 2:
                eca();
                return;
            case 3:
                ebZ();
                return;
            default:
                return;
        }
    }

    public void ebY() {
        this.omJ.setBgColor(LeftLadderTextView.BgColor.RED);
        this.omS.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape);
        this.omK.setBgColor(RightLadderTextView.BgColor.BLUE);
        this.omT.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape);
    }

    private void ebZ() {
        this.onf.setVisibility(8);
        this.onc = false;
        this.ond = 0L;
        if (this.omP != null) {
            VO(this.omP.onB);
            this.omH.setText(this.omP.onC.f5631a);
            this.omI.setText(this.omP.onC.f5632b);
        }
        this.ong.setBackgroundResource(a.e.yuyin_punish_icon);
        this.omQ.setVisibility(8);
        this.omG.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        zB(false);
        if (this.omR != null) {
            this.omR.cancel();
        }
        this.omY.setVisibility(4);
        if (this.omX != null) {
            this.omX.cancelAnimation();
        }
        if (this.omW != null) {
            this.omW.cancelAnimation();
        }
        this.omZ.setVisibility(4);
        if (this.omZ != null) {
            this.omZ.cancelAnimation();
        }
    }

    private void eca() {
        cgN();
        ebY();
        this.ong.setBackgroundResource(a.e.yuyin_statistics_icon);
        this.omG.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.omG.setData(new CountDownTextView.a(0, "00:00"));
        bWQ();
        this.omQ.setVisibility(8);
        if (this.omR != null) {
            this.omR.cancel();
        }
        if (this.omP != null && this.omP.onC != null) {
            ecd();
        }
    }

    private void bWQ() {
        if (this.gPY != null) {
            this.gPY.cancel();
        }
    }

    private void ecb() {
        this.ong.setBackgroundResource(a.e.yuyin_pking_icon);
        cgN();
        ebY();
        if (this.omP != null) {
            if (this.omP.onC != null) {
                ecd();
            }
            zB(true);
        }
    }

    private void ecc() {
        cgN();
        this.onf.setVisibility(8);
        this.onc = false;
        this.ond = 0L;
        this.ong.setBackgroundResource(a.e.yuyin_prepare_icon);
        this.omG.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.omG.setData(new CountDownTextView.a(0, "00:00"));
        bWQ();
        this.omH.setText("0");
        this.omI.setText("0");
        ebY();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omJ.getLayoutParams();
        layoutParams.width = (int) (this.omO * 0.5f);
        this.omJ.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.omK.getLayoutParams();
        layoutParams2.width = (int) (this.omO * 0.5f);
        this.omK.setLayoutParams(layoutParams2);
        this.omQ.setVisibility(4);
        if (this.omR != null) {
            this.omR.cancel();
        }
        this.omY.setVisibility(4);
        if (this.omX != null) {
            this.omX.cancelAnimation();
        }
        if (this.omW != null) {
            this.omW.cancelAnimation();
        }
        this.omZ.setVisibility(4);
        if (this.omZ != null) {
            this.omZ.cancelAnimation();
        }
    }

    private void zB(boolean z) {
        boolean z2 = true;
        if (this.omP != null) {
            int i = this.omP.onD;
            int i2 = i / 1000;
            boolean z3 = this.omP.onE == 1;
            int i3 = this.omP.onF;
            if (this.omG.getData() == null || Math.abs(this.omG.getData().onn - i) <= i3) {
                z2 = false;
            }
            if (this.omG.getData() == null || "00:00".equals(this.omG.getData().ono)) {
                bWQ();
                m(i, i2, z);
            } else if (this.oni || this.onh) {
                bWQ();
                m(i, i2, z);
            } else if (z3 && z2) {
                bWQ();
                m(i, i2, z);
            }
        }
    }

    private void m(int i, int i2, final boolean z) {
        this.omG.setData(new CountDownTextView.a(i, c.Nd(i2)));
        this.gPY = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (AlaChallengeLiveView.this.omG != null) {
                    if (j > AppStatusRules.DEFAULT_GRANULARITY) {
                        AlaChallengeLiveView.this.omG.setData(new CountDownTextView.a((int) j, c.Nd((int) (j / 1000))));
                        AlaChallengeLiveView.this.omG.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.omQ.setVisibility(8);
                        return;
                    }
                    if (j / 1000 == 0) {
                        AlaChallengeLiveView.this.omG.setData(new CountDownTextView.a((int) j, "00:00"));
                    } else {
                        AlaChallengeLiveView.this.omG.setData(new CountDownTextView.a((int) j, ((int) (j / 1000)) + ""));
                    }
                    if (j / 1000 <= 10) {
                        if (z) {
                            if (AlaChallengeLiveView.this.omR == null || !AlaChallengeLiveView.this.omR.isRunning()) {
                                AlaChallengeLiveView.this.omQ.setVisibility(0);
                                AlaChallengeLiveView.this.omR = ObjectAnimator.ofFloat(AlaChallengeLiveView.this.omQ, "alpha", 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                                AlaChallengeLiveView.this.omR.setRepeatMode(1);
                                AlaChallengeLiveView.this.omR.setRepeatCount(-1);
                                AlaChallengeLiveView.this.omR.setDuration(1000L);
                                AlaChallengeLiveView.this.omR.start();
                            }
                            AlaChallengeLiveView.this.omG.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_color_fa4242));
                            return;
                        }
                        AlaChallengeLiveView.this.omG.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.omQ.setVisibility(8);
                        return;
                    }
                    AlaChallengeLiveView.this.omG.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaChallengeLiveView.this.omQ.setVisibility(8);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        };
        this.gPY.start();
    }

    private void ecd() {
        if (this.omP != null) {
            if ("0".equals(this.omP.onC.f5631a) && "0".equals(this.omP.onC.f5632b)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omJ.getLayoutParams();
                layoutParams.width = (int) (this.omO * 0.5f);
                this.omJ.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.omK.getLayoutParams();
                layoutParams2.width = (int) (this.omO * 0.5f);
                this.omK.setLayoutParams(layoutParams2);
                return;
            }
            int parseInt = Integer.parseInt(this.omP.onC.f5631a);
            int parseInt2 = Integer.parseInt(this.omP.onC.f5632b);
            if (((parseInt > 0 && parseInt2 == 0) || (parseInt == 0 && parseInt2 > 0)) && !this.onc) {
                this.onc = true;
                this.ond = System.currentTimeMillis();
                ece();
            } else if (Math.abs(System.currentTimeMillis() - this.ond) >= 2000) {
                ecf();
            }
        }
    }

    private void ece() {
        this.omY.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.omU.getLayoutParams();
        layoutParams.width = (int) (this.omO * 0.5f);
        this.omU.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.omV.getLayoutParams();
        layoutParams2.width = (int) (this.omO * 0.5f);
        this.omV.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.omW.getLayoutParams();
        layoutParams3.leftMargin = -((int) (this.omO * 0.5f));
        this.omW.setLayoutParams(layoutParams3);
        if (this.omX != null) {
            this.omX.playAnimation();
        }
        if (this.omW != null) {
            this.omW.playAnimation();
        }
        this.onf.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.onf, "ScaleX", 1.0f, 6.0f, 1.0f);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.onf, "scaleY", 1.0f, 6.0f, 1.0f);
        ofFloat2.setDuration(500L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeLiveView.this.onf.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) AlaChallengeLiveView.this.omZ.getLayoutParams();
                layoutParams4.setMargins(((int) (AlaChallengeLiveView.this.omO * 0.5f)) - AlaChallengeLiveView.this.onb, AlaChallengeLiveView.this.ona, 0, 0);
                AlaChallengeLiveView.this.omZ.setLayoutParams(layoutParams4);
                AlaChallengeLiveView.this.omZ.setVisibility(0);
                AlaChallengeLiveView.this.omZ.playAnimation();
                AlaChallengeLiveView.this.ecg();
                AlaChallengeLiveView.this.ech();
                AlaChallengeLiveView.this.onf.setVisibility(8);
                float b2 = b.b(AlaChallengeLiveView.this.omP);
                float b3 = b.b(AlaChallengeLiveView.this.omH, AlaChallengeLiveView.this.omI);
                if (b3 != b2) {
                    if (AlaChallengeLiveView.this.mValueAnimator == null || !AlaChallengeLiveView.this.mValueAnimator.isRunning()) {
                        AlaChallengeLiveView.this.mValueAnimator = ValueAnimator.ofFloat(b3, b2);
                        AlaChallengeLiveView.this.mValueAnimator.setDuration(400L);
                        AlaChallengeLiveView.this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AlaChallengeLiveView.this.bd(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                                AlaChallengeLiveView.this.onc = true;
                            }
                        });
                        AlaChallengeLiveView.this.mValueAnimator.start();
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void ecf() {
        ecg();
        ech();
        this.onf.setVisibility(8);
        float b2 = b.b(this.omP);
        float b3 = b.b(this.omH, this.omI);
        if (b3 != b2) {
            if (this.mValueAnimator == null || !this.mValueAnimator.isRunning()) {
                this.mValueAnimator = ValueAnimator.ofFloat(b3, b2);
                this.mValueAnimator.setDuration(400L);
                this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AlaChallengeLiveView.this.bd(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                    }
                });
                this.mValueAnimator.start();
            }
        } else if (this.omZ.getVisibility() != 0 || !this.omZ.isAnimating()) {
            bd(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omJ.getLayoutParams();
        layoutParams.width = (int) (this.omO * f);
        this.omJ.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.omK.getLayoutParams();
        layoutParams2.width = (int) (this.omO * (1.0f - f));
        this.omK.setLayoutParams(layoutParams2);
        this.omY.setVisibility(0);
        ViewGroup.LayoutParams layoutParams3 = this.omU.getLayoutParams();
        layoutParams3.width = (int) (this.omO * f);
        this.omU.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.omV.getLayoutParams();
        layoutParams4.width = (int) (this.omO * (1.0f - f));
        this.omV.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.omW.getLayoutParams();
        layoutParams5.leftMargin = -((int) (this.omO * f));
        this.omW.setLayoutParams(layoutParams5);
        if (this.omX != null) {
            this.omX.playAnimation();
        }
        if (this.omW != null) {
            this.omW.playAnimation();
        }
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.omZ.getLayoutParams();
        layoutParams6.setMargins(((int) (this.omO * f)) - this.onb, this.ona, 0, 0);
        this.omZ.setLayoutParams(layoutParams6);
        this.omZ.setVisibility(0);
        this.omZ.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ecg() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.omH.getText().toString());
            try {
                i2 = Integer.parseInt(this.omP.onC.f5631a);
            } catch (Exception e) {
                i2 = 0;
                if (i2 <= i) {
                }
            }
        } catch (Exception e2) {
            i = 0;
        }
        if (i2 <= i) {
            AnimatorSet animatorSet = new AnimatorSet();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.setDuration(760L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.omH.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.omH.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.omP != null && this.omP.onC != null) {
            this.omH.setText(this.omP.onC.f5631a);
        } else {
            this.omH.setText("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ech() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.omI.getText().toString());
            try {
                i2 = Integer.parseInt(this.omP.onC.f5632b);
            } catch (Exception e) {
                i2 = 0;
                if (i2 <= i) {
                }
            }
        } catch (Exception e2) {
            i = 0;
        }
        if (i2 <= i) {
            AnimatorSet animatorSet = new AnimatorSet();
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.setDuration(760L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.6
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.omI.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.omI.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.omP != null && this.omP.onC != null) {
            this.omI.setText(this.omP.onC.f5632b);
        } else {
            this.omI.setText("0");
        }
    }

    public void cgN() {
        this.omM.setVisibility(4);
        this.omN.setVisibility(4);
    }

    private void VO(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 97:
                if (str.equals("a")) {
                    c = 0;
                    break;
                }
                break;
            case 98:
                if (str.equals(com.baidu.pass.biometrics.face.liveness.d.b.f4080a)) {
                    c = 1;
                    break;
                }
                break;
            case 96673:
                if (str.equals("all")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.omM.setVisibility(0);
                this.omN.setVisibility(0);
                this.omM.setImageResource(a.e.left_win_icon);
                this.omN.setImageResource(a.e.right_fail_icon);
                this.omK.setBgColor(RightLadderTextView.BgColor.GRAY);
                this.omT.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape_gray);
                this.omJ.setBgColor(LeftLadderTextView.BgColor.RED);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omJ.getLayoutParams();
                layoutParams.width = (int) (this.omO * b.b(this.omP));
                this.omJ.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.omK.getLayoutParams();
                layoutParams2.width = (int) (this.omO * (1.0f - b.b(this.omP)));
                this.omK.setLayoutParams(layoutParams2);
                return;
            case 1:
                this.omM.setVisibility(0);
                this.omN.setVisibility(0);
                this.omM.setImageResource(a.e.left_fail_icon);
                this.omN.setImageResource(a.e.right_win_icon);
                this.omJ.setBgColor(LeftLadderTextView.BgColor.GRAY);
                this.omS.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape_gray);
                this.omK.setBgColor(RightLadderTextView.BgColor.BLUE);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.omJ.getLayoutParams();
                layoutParams3.width = (int) (this.omO * b.b(this.omP));
                this.omJ.setLayoutParams(layoutParams3);
                ViewGroup.LayoutParams layoutParams4 = this.omK.getLayoutParams();
                layoutParams4.width = (int) (this.omO * (1.0f - b.b(this.omP)));
                this.omK.setLayoutParams(layoutParams4);
                return;
            case 2:
                this.omM.setVisibility(0);
                this.omN.setVisibility(0);
                this.omM.setImageResource(a.e.left_pingju_icon);
                this.omN.setImageResource(a.e.right_pingju_icon);
                ebY();
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.omJ.getLayoutParams();
                layoutParams5.width = (int) (this.omO * 0.5f);
                this.omJ.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.omK.getLayoutParams();
                layoutParams6.width = (int) (this.omO * 0.5f);
                this.omK.setLayoutParams(layoutParams6);
                return;
            default:
                return;
        }
    }

    public void destory() {
        this.onc = false;
        this.ond = 0L;
        this.onh = false;
        this.oni = false;
        bWQ();
    }
}
