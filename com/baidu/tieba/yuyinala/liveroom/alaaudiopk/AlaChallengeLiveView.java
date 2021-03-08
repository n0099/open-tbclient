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
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.CountDownTextView;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.LeftLadderTextView;
import com.baidu.tieba.yuyinala.liveroom.alaaudiopk.RightLadderTextView;
import com.kwad.sdk.collector.AppStatusRules;
/* loaded from: classes10.dex */
public class AlaChallengeLiveView extends RelativeLayout {
    private CountDownTimer gPV;
    private RelativeLayout hfF;
    private Context mContext;
    private ValueAnimator mValueAnimator;
    private CountDownTextView ouA;
    private TextView ouB;
    private TextView ouC;
    private LeftLadderTextView ouD;
    private RightLadderTextView ouE;
    private int ouF;
    private ImageView ouG;
    private ImageView ouH;
    private int ouI;
    private c ouJ;
    private View ouK;
    private ObjectAnimator ouL;
    private View ouM;
    private View ouN;
    private LinearLayout ouO;
    private LinearLayout ouP;
    private LottieAnimationView ouQ;
    private LottieAnimationView ouR;
    private FrameLayout ouS;
    private LottieAnimationView ouT;
    private int ouU;
    private int ouV;
    private boolean ouW;
    private long ouX;
    private ImageView ouY;
    private RelativeLayout ouZ;
    private boolean ova;
    private boolean ovb;
    private RelativeLayout rootView;

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.ouW = false;
        this.ouX = 0L;
        this.ova = false;
        this.ovb = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ouW = false;
        this.ouX = 0L;
        this.ova = false;
        this.ovb = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ouW = false;
        this.ouX = 0L;
        this.ova = false;
        this.ovb = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_audio_challenge_panel_optation_view, this);
        this.ouI = BdUtilHelper.getScreenSize((Activity) getContext()).widthPixels - BdUtilHelper.dip2px(getContext(), 54.0f);
        this.ouU = BdUtilHelper.dip2px(getContext(), 10.0f);
        this.ouV = BdUtilHelper.dip2px(getContext(), 22.0f);
        this.hfF = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.ouZ = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.ouA = (CountDownTextView) this.rootView.findViewById(a.f.pk_time_label);
        this.ouA.setData(new CountDownTextView.a(0, "00:00"));
        this.ouK = this.rootView.findViewById(a.f.view_shake);
        this.ouM = this.rootView.findViewById(a.f.view_left_shape);
        this.ouN = this.rootView.findViewById(a.f.view_right_shape);
        this.ouG = (ImageView) this.rootView.findViewById(a.f.left_state);
        this.ouH = (ImageView) this.rootView.findViewById(a.f.right_state);
        this.ouT = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_center);
        this.ouS = (FrameLayout) this.rootView.findViewById(a.f.ll_loading);
        this.ouO = (LinearLayout) this.rootView.findViewById(a.f.ll_left_loading);
        this.ouR = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_left);
        this.ouP = (LinearLayout) this.rootView.findViewById(a.f.ll_right_loading);
        this.ouQ = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_right);
        this.ouB = (TextView) this.rootView.findViewById(a.f.pk_left_progress);
        this.ouC = (TextView) this.rootView.findViewById(a.f.pk_right_progress);
        this.ouD = (LeftLadderTextView) this.rootView.findViewById(a.f.left_progress_bg);
        this.ouE = (RightLadderTextView) this.rootView.findViewById(a.f.right_progress_bg);
        this.ouY = (ImageView) this.rootView.findViewById(a.f.img_view_center);
        this.ouT.setImageAssetsFolder("lottie_team_fight_images/");
        this.ouT.setAnimation("anim_view_center.json");
        this.ouT.loop(true);
        ViewGroup.LayoutParams layoutParams = this.ouR.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.ouI;
        }
        this.ouR.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.ouQ.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = this.ouI;
        }
        this.ouQ.setLayoutParams(layoutParams2);
        this.ouS.setVisibility(4);
        if (this.ouR != null) {
            this.ouR.cancelAnimation();
        }
        if (this.ouQ != null) {
            this.ouQ.cancelAnimation();
        }
        this.ouT.setVisibility(4);
        if (this.ouT != null) {
            this.ouT.cancelAnimation();
        }
        eaK();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ouD.getLayoutParams();
        layoutParams3.width = (int) (this.ouI * 0.5f);
        this.ouD.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.ouE.getLayoutParams();
        layoutParams4.width = (int) (this.ouI * 0.5f);
        this.ouE.setLayoutParams(layoutParams4);
    }

    public void b(c cVar) {
        if (cVar != null) {
            if (this.ouJ != null) {
                this.ova = cVar.ovs != this.ouJ.ovs;
                this.ovb = cVar.activity_stage != this.ouJ.activity_stage;
            }
            this.ouJ = cVar;
            this.ouF = cVar.activity_stage;
            eaJ();
        }
    }

    private void eaJ() {
        switch (this.ouF) {
            case 0:
                eaO();
                return;
            case 1:
                eaN();
                return;
            case 2:
                eaM();
                return;
            case 3:
                eaL();
                return;
            default:
                return;
        }
    }

    public void eaK() {
        this.ouD.setBgColor(LeftLadderTextView.BgColor.RED);
        this.ouM.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape);
        this.ouE.setBgColor(RightLadderTextView.BgColor.BLUE);
        this.ouN.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape);
    }

    private void eaL() {
        this.ouY.setVisibility(8);
        this.ouW = false;
        this.ouX = 0L;
        if (this.ouJ != null) {
            VX(this.ouJ.ovu);
            this.ouB.setText(this.ouJ.ovv.f3603a);
            this.ouC.setText(this.ouJ.ovv.b);
        }
        this.ouZ.setBackgroundResource(a.e.yuyin_punish_icon);
        this.ouK.setVisibility(8);
        this.ouA.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        zR(false);
        if (this.ouL != null) {
            this.ouL.cancel();
        }
        this.ouS.setVisibility(4);
        if (this.ouR != null) {
            this.ouR.cancelAnimation();
        }
        if (this.ouQ != null) {
            this.ouQ.cancelAnimation();
        }
        this.ouT.setVisibility(4);
        if (this.ouT != null) {
            this.ouT.cancelAnimation();
        }
    }

    private void eaM() {
        cee();
        eaK();
        this.ouZ.setBackgroundResource(a.e.yuyin_statistics_icon);
        this.ouA.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.ouA.setData(new CountDownTextView.a(0, "00:00"));
        bTP();
        this.ouK.setVisibility(8);
        if (this.ouL != null) {
            this.ouL.cancel();
        }
        if (this.ouJ != null && this.ouJ.ovv != null) {
            eaP();
        }
    }

    private void bTP() {
        if (this.gPV != null) {
            this.gPV.cancel();
        }
    }

    private void eaN() {
        this.ouZ.setBackgroundResource(a.e.yuyin_pking_icon);
        cee();
        eaK();
        if (this.ouJ != null) {
            if (this.ouJ.ovv != null) {
                eaP();
            }
            zR(true);
        }
    }

    private void eaO() {
        cee();
        this.ouY.setVisibility(8);
        this.ouW = false;
        this.ouX = 0L;
        this.ouZ.setBackgroundResource(a.e.yuyin_prepare_icon);
        this.ouA.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.ouA.setData(new CountDownTextView.a(0, "00:00"));
        bTP();
        this.ouB.setText("0");
        this.ouC.setText("0");
        eaK();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ouD.getLayoutParams();
        layoutParams.width = (int) (this.ouI * 0.5f);
        this.ouD.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.ouE.getLayoutParams();
        layoutParams2.width = (int) (this.ouI * 0.5f);
        this.ouE.setLayoutParams(layoutParams2);
        this.ouK.setVisibility(4);
        if (this.ouL != null) {
            this.ouL.cancel();
        }
        this.ouS.setVisibility(4);
        if (this.ouR != null) {
            this.ouR.cancelAnimation();
        }
        if (this.ouQ != null) {
            this.ouQ.cancelAnimation();
        }
        this.ouT.setVisibility(4);
        if (this.ouT != null) {
            this.ouT.cancelAnimation();
        }
    }

    private void zR(boolean z) {
        boolean z2 = true;
        if (this.ouJ != null) {
            int i = this.ouJ.ovw;
            int i2 = i / 1000;
            boolean z3 = this.ouJ.ovx == 1;
            int i3 = this.ouJ.ovy;
            if (this.ouA.getData() == null || Math.abs(this.ouA.getData().ovg - i) <= i3) {
                z2 = false;
            }
            if (this.ouA.getData() == null || "00:00".equals(this.ouA.getData().ovh)) {
                bTP();
                n(i, i2, z);
            } else if (this.ovb || this.ova) {
                bTP();
                n(i, i2, z);
            } else if (z3 && z2) {
                bTP();
                n(i, i2, z);
            }
        }
    }

    private void n(int i, int i2, final boolean z) {
        this.ouA.setData(new CountDownTextView.a(i, b.LW(i2)));
        this.gPV = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (AlaChallengeLiveView.this.ouA != null) {
                    if (j > AppStatusRules.DEFAULT_GRANULARITY) {
                        AlaChallengeLiveView.this.ouA.setData(new CountDownTextView.a((int) j, b.LW((int) (j / 1000))));
                        AlaChallengeLiveView.this.ouA.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.ouK.setVisibility(8);
                        return;
                    }
                    if (j / 1000 == 0) {
                        AlaChallengeLiveView.this.ouA.setData(new CountDownTextView.a((int) j, "00:00"));
                    } else {
                        AlaChallengeLiveView.this.ouA.setData(new CountDownTextView.a((int) j, ((int) (j / 1000)) + ""));
                    }
                    if (j / 1000 <= 10) {
                        if (z) {
                            if (AlaChallengeLiveView.this.ouL == null || !AlaChallengeLiveView.this.ouL.isRunning()) {
                                AlaChallengeLiveView.this.ouK.setVisibility(0);
                                AlaChallengeLiveView.this.ouL = ObjectAnimator.ofFloat(AlaChallengeLiveView.this.ouK, "alpha", 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                                AlaChallengeLiveView.this.ouL.setRepeatMode(1);
                                AlaChallengeLiveView.this.ouL.setRepeatCount(-1);
                                AlaChallengeLiveView.this.ouL.setDuration(1000L);
                                AlaChallengeLiveView.this.ouL.start();
                            }
                            AlaChallengeLiveView.this.ouA.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_color_fa4242));
                            return;
                        }
                        AlaChallengeLiveView.this.ouA.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.ouK.setVisibility(8);
                        return;
                    }
                    AlaChallengeLiveView.this.ouA.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaChallengeLiveView.this.ouK.setVisibility(8);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        };
        this.gPV.start();
    }

    private void eaP() {
        if (this.ouJ != null) {
            if ("0".equals(this.ouJ.ovv.f3603a) && "0".equals(this.ouJ.ovv.b)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ouD.getLayoutParams();
                layoutParams.width = (int) (this.ouI * 0.5f);
                this.ouD.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.ouE.getLayoutParams();
                layoutParams2.width = (int) (this.ouI * 0.5f);
                this.ouE.setLayoutParams(layoutParams2);
                return;
            }
            int parseInt = Integer.parseInt(this.ouJ.ovv.f3603a);
            int parseInt2 = Integer.parseInt(this.ouJ.ovv.b);
            if (((parseInt > 0 && parseInt2 == 0) || (parseInt == 0 && parseInt2 > 0)) && !this.ouW) {
                this.ouW = true;
                this.ouX = System.currentTimeMillis();
                eaQ();
            } else if (Math.abs(System.currentTimeMillis() - this.ouX) >= 2000) {
                eaR();
            }
        }
    }

    private void eaQ() {
        this.ouS.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.ouO.getLayoutParams();
        layoutParams.width = (int) (this.ouI * 0.5f);
        this.ouO.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.ouP.getLayoutParams();
        layoutParams2.width = (int) (this.ouI * 0.5f);
        this.ouP.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ouQ.getLayoutParams();
        layoutParams3.leftMargin = -((int) (this.ouI * 0.5f));
        this.ouQ.setLayoutParams(layoutParams3);
        if (this.ouR != null) {
            this.ouR.playAnimation();
        }
        if (this.ouQ != null) {
            this.ouQ.playAnimation();
        }
        this.ouY.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ouY, "ScaleX", 1.0f, 6.0f, 1.0f);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ouY, "scaleY", 1.0f, 6.0f, 1.0f);
        ofFloat2.setDuration(500L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeLiveView.this.ouY.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) AlaChallengeLiveView.this.ouT.getLayoutParams();
                layoutParams4.setMargins(((int) (AlaChallengeLiveView.this.ouI * 0.5f)) - AlaChallengeLiveView.this.ouV, AlaChallengeLiveView.this.ouU, 0, 0);
                AlaChallengeLiveView.this.ouT.setLayoutParams(layoutParams4);
                AlaChallengeLiveView.this.ouT.setVisibility(0);
                AlaChallengeLiveView.this.ouT.playAnimation();
                AlaChallengeLiveView.this.eaS();
                AlaChallengeLiveView.this.eaT();
                AlaChallengeLiveView.this.ouY.setVisibility(8);
                float a2 = a.a(AlaChallengeLiveView.this.ouJ);
                float b = a.b(AlaChallengeLiveView.this.ouB, AlaChallengeLiveView.this.ouC);
                if (b != a2) {
                    if (AlaChallengeLiveView.this.mValueAnimator == null || !AlaChallengeLiveView.this.mValueAnimator.isRunning()) {
                        AlaChallengeLiveView.this.mValueAnimator = ValueAnimator.ofFloat(b, a2);
                        AlaChallengeLiveView.this.mValueAnimator.setDuration(400L);
                        AlaChallengeLiveView.this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AlaChallengeLiveView.this.bk(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                                AlaChallengeLiveView.this.ouW = true;
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

    private void eaR() {
        eaS();
        eaT();
        this.ouY.setVisibility(8);
        float a2 = a.a(this.ouJ);
        float b = a.b(this.ouB, this.ouC);
        if (b != a2) {
            if (this.mValueAnimator == null || !this.mValueAnimator.isRunning()) {
                this.mValueAnimator = ValueAnimator.ofFloat(b, a2);
                this.mValueAnimator.setDuration(400L);
                this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AlaChallengeLiveView.this.bk(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                    }
                });
                this.mValueAnimator.start();
            }
        } else if (this.ouT.getVisibility() != 0 || !this.ouT.isAnimating()) {
            bk(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ouD.getLayoutParams();
        layoutParams.width = (int) (this.ouI * f);
        this.ouD.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.ouE.getLayoutParams();
        layoutParams2.width = (int) (this.ouI * (1.0f - f));
        this.ouE.setLayoutParams(layoutParams2);
        this.ouS.setVisibility(0);
        ViewGroup.LayoutParams layoutParams3 = this.ouO.getLayoutParams();
        layoutParams3.width = (int) (this.ouI * f);
        this.ouO.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.ouP.getLayoutParams();
        layoutParams4.width = (int) (this.ouI * (1.0f - f));
        this.ouP.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.ouQ.getLayoutParams();
        layoutParams5.leftMargin = -((int) (this.ouI * f));
        this.ouQ.setLayoutParams(layoutParams5);
        if (this.ouR != null) {
            this.ouR.playAnimation();
        }
        if (this.ouQ != null) {
            this.ouQ.playAnimation();
        }
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.ouT.getLayoutParams();
        layoutParams6.setMargins(((int) (this.ouI * f)) - this.ouV, this.ouU, 0, 0);
        this.ouT.setLayoutParams(layoutParams6);
        this.ouT.setVisibility(0);
        this.ouT.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eaS() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.ouB.getText().toString());
            try {
                i2 = Integer.parseInt(this.ouJ.ovv.f3603a);
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
                    AlaChallengeLiveView.this.ouB.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.ouB.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.ouJ != null && this.ouJ.ovv != null) {
            this.ouB.setText(this.ouJ.ovv.f3603a);
        } else {
            this.ouB.setText("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eaT() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.ouC.getText().toString());
            try {
                i2 = Integer.parseInt(this.ouJ.ovv.b);
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
                    AlaChallengeLiveView.this.ouC.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.ouC.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.ouJ != null && this.ouJ.ovv != null) {
            this.ouC.setText(this.ouJ.ovv.b);
        } else {
            this.ouC.setText("0");
        }
    }

    public void cee() {
        this.ouG.setVisibility(4);
        this.ouH.setVisibility(4);
    }

    private void VX(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 97:
                if (str.equals("a")) {
                    c = 0;
                    break;
                }
                break;
            case 98:
                if (str.equals(com.baidu.pass.biometrics.face.liveness.d.b.f2804a)) {
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
                this.ouG.setVisibility(0);
                this.ouH.setVisibility(0);
                this.ouG.setImageResource(a.e.left_win_icon);
                this.ouH.setImageResource(a.e.right_fail_icon);
                this.ouE.setBgColor(RightLadderTextView.BgColor.GRAY);
                this.ouN.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape_gray);
                this.ouD.setBgColor(LeftLadderTextView.BgColor.RED);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ouD.getLayoutParams();
                layoutParams.width = (int) (this.ouI * a.a(this.ouJ));
                this.ouD.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.ouE.getLayoutParams();
                layoutParams2.width = (int) (this.ouI * (1.0f - a.a(this.ouJ)));
                this.ouE.setLayoutParams(layoutParams2);
                return;
            case 1:
                this.ouG.setVisibility(0);
                this.ouH.setVisibility(0);
                this.ouG.setImageResource(a.e.left_fail_icon);
                this.ouH.setImageResource(a.e.right_win_icon);
                this.ouD.setBgColor(LeftLadderTextView.BgColor.GRAY);
                this.ouM.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape_gray);
                this.ouE.setBgColor(RightLadderTextView.BgColor.BLUE);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.ouD.getLayoutParams();
                layoutParams3.width = (int) (this.ouI * a.a(this.ouJ));
                this.ouD.setLayoutParams(layoutParams3);
                ViewGroup.LayoutParams layoutParams4 = this.ouE.getLayoutParams();
                layoutParams4.width = (int) (this.ouI * (1.0f - a.a(this.ouJ)));
                this.ouE.setLayoutParams(layoutParams4);
                return;
            case 2:
                this.ouG.setVisibility(0);
                this.ouH.setVisibility(0);
                this.ouG.setImageResource(a.e.left_pingju_icon);
                this.ouH.setImageResource(a.e.right_pingju_icon);
                eaK();
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.ouD.getLayoutParams();
                layoutParams5.width = (int) (this.ouI * 0.5f);
                this.ouD.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.ouE.getLayoutParams();
                layoutParams6.width = (int) (this.ouI * 0.5f);
                this.ouE.setLayoutParams(layoutParams6);
                return;
            default:
                return;
        }
    }
}
