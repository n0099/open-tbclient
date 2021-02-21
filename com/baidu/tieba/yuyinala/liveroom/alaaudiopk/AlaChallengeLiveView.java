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
/* loaded from: classes11.dex */
public class AlaChallengeLiveView extends RelativeLayout {
    private CountDownTimer gOm;
    private RelativeLayout hdW;
    private Context mContext;
    private ValueAnimator mValueAnimator;
    private ImageView osA;
    private ImageView osB;
    private int osC;
    private c osD;
    private View osE;
    private ObjectAnimator osF;
    private View osG;
    private View osH;
    private LinearLayout osI;
    private LinearLayout osJ;
    private LottieAnimationView osK;
    private LottieAnimationView osL;
    private FrameLayout osM;
    private LottieAnimationView osN;
    private int osO;
    private int osP;
    private boolean osQ;
    private long osR;
    private ImageView osS;
    private RelativeLayout osT;
    private boolean osU;
    private boolean osV;
    private CountDownTextView osu;
    private TextView osv;
    private TextView osw;
    private LeftLadderTextView osx;
    private RightLadderTextView osy;
    private int osz;
    private RelativeLayout rootView;

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.osQ = false;
        this.osR = 0L;
        this.osU = false;
        this.osV = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.osQ = false;
        this.osR = 0L;
        this.osU = false;
        this.osV = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osQ = false;
        this.osR = 0L;
        this.osU = false;
        this.osV = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_audio_challenge_panel_optation_view, this);
        this.osC = BdUtilHelper.getScreenSize((Activity) getContext()).widthPixels - BdUtilHelper.dip2px(getContext(), 54.0f);
        this.osO = BdUtilHelper.dip2px(getContext(), 10.0f);
        this.osP = BdUtilHelper.dip2px(getContext(), 22.0f);
        this.hdW = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.osT = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.osu = (CountDownTextView) this.rootView.findViewById(a.f.pk_time_label);
        this.osu.setData(new CountDownTextView.a(0, "00:00"));
        this.osE = this.rootView.findViewById(a.f.view_shake);
        this.osG = this.rootView.findViewById(a.f.view_left_shape);
        this.osH = this.rootView.findViewById(a.f.view_right_shape);
        this.osA = (ImageView) this.rootView.findViewById(a.f.left_state);
        this.osB = (ImageView) this.rootView.findViewById(a.f.right_state);
        this.osN = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_center);
        this.osM = (FrameLayout) this.rootView.findViewById(a.f.ll_loading);
        this.osI = (LinearLayout) this.rootView.findViewById(a.f.ll_left_loading);
        this.osL = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_left);
        this.osJ = (LinearLayout) this.rootView.findViewById(a.f.ll_right_loading);
        this.osK = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_right);
        this.osv = (TextView) this.rootView.findViewById(a.f.pk_left_progress);
        this.osw = (TextView) this.rootView.findViewById(a.f.pk_right_progress);
        this.osx = (LeftLadderTextView) this.rootView.findViewById(a.f.left_progress_bg);
        this.osy = (RightLadderTextView) this.rootView.findViewById(a.f.right_progress_bg);
        this.osS = (ImageView) this.rootView.findViewById(a.f.img_view_center);
        this.osN.setImageAssetsFolder("lottie_team_fight_images/");
        this.osN.setAnimation("anim_view_center.json");
        this.osN.loop(true);
        ViewGroup.LayoutParams layoutParams = this.osL.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.osC;
        }
        this.osL.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.osK.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = this.osC;
        }
        this.osK.setLayoutParams(layoutParams2);
        this.osM.setVisibility(4);
        if (this.osL != null) {
            this.osL.cancelAnimation();
        }
        if (this.osK != null) {
            this.osK.cancelAnimation();
        }
        this.osN.setVisibility(4);
        if (this.osN != null) {
            this.osN.cancelAnimation();
        }
        eaC();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.osx.getLayoutParams();
        layoutParams3.width = (int) (this.osC * 0.5f);
        this.osx.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.osy.getLayoutParams();
        layoutParams4.width = (int) (this.osC * 0.5f);
        this.osy.setLayoutParams(layoutParams4);
    }

    public void b(c cVar) {
        if (cVar != null) {
            if (this.osD != null) {
                this.osU = cVar.otm != this.osD.otm;
                this.osV = cVar.activity_stage != this.osD.activity_stage;
            }
            this.osD = cVar;
            this.osz = cVar.activity_stage;
            eaB();
        }
    }

    private void eaB() {
        switch (this.osz) {
            case 0:
                eaG();
                return;
            case 1:
                eaF();
                return;
            case 2:
                eaE();
                return;
            case 3:
                eaD();
                return;
            default:
                return;
        }
    }

    public void eaC() {
        this.osx.setBgColor(LeftLadderTextView.BgColor.RED);
        this.osG.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape);
        this.osy.setBgColor(RightLadderTextView.BgColor.BLUE);
        this.osH.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape);
    }

    private void eaD() {
        this.osS.setVisibility(8);
        this.osQ = false;
        this.osR = 0L;
        if (this.osD != null) {
            VQ(this.osD.oto);
            this.osv.setText(this.osD.otp.f5351a);
            this.osw.setText(this.osD.otp.f5352b);
        }
        this.osT.setBackgroundResource(a.e.yuyin_punish_icon);
        this.osE.setVisibility(8);
        this.osu.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        zS(false);
        if (this.osF != null) {
            this.osF.cancel();
        }
        this.osM.setVisibility(4);
        if (this.osL != null) {
            this.osL.cancelAnimation();
        }
        if (this.osK != null) {
            this.osK.cancelAnimation();
        }
        this.osN.setVisibility(4);
        if (this.osN != null) {
            this.osN.cancelAnimation();
        }
    }

    private void eaE() {
        cdY();
        eaC();
        this.osT.setBackgroundResource(a.e.yuyin_statistics_icon);
        this.osu.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.osu.setData(new CountDownTextView.a(0, "00:00"));
        bTJ();
        this.osE.setVisibility(8);
        if (this.osF != null) {
            this.osF.cancel();
        }
        if (this.osD != null && this.osD.otp != null) {
            eaH();
        }
    }

    private void bTJ() {
        if (this.gOm != null) {
            this.gOm.cancel();
        }
    }

    private void eaF() {
        this.osT.setBackgroundResource(a.e.yuyin_pking_icon);
        cdY();
        eaC();
        if (this.osD != null) {
            if (this.osD.otp != null) {
                eaH();
            }
            zS(true);
        }
    }

    private void eaG() {
        cdY();
        this.osS.setVisibility(8);
        this.osQ = false;
        this.osR = 0L;
        this.osT.setBackgroundResource(a.e.yuyin_prepare_icon);
        this.osu.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.osu.setData(new CountDownTextView.a(0, "00:00"));
        bTJ();
        this.osv.setText("0");
        this.osw.setText("0");
        eaC();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.osx.getLayoutParams();
        layoutParams.width = (int) (this.osC * 0.5f);
        this.osx.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.osy.getLayoutParams();
        layoutParams2.width = (int) (this.osC * 0.5f);
        this.osy.setLayoutParams(layoutParams2);
        this.osE.setVisibility(4);
        if (this.osF != null) {
            this.osF.cancel();
        }
        this.osM.setVisibility(4);
        if (this.osL != null) {
            this.osL.cancelAnimation();
        }
        if (this.osK != null) {
            this.osK.cancelAnimation();
        }
        this.osN.setVisibility(4);
        if (this.osN != null) {
            this.osN.cancelAnimation();
        }
    }

    private void zS(boolean z) {
        boolean z2 = true;
        if (this.osD != null) {
            int i = this.osD.otq;
            int i2 = i / 1000;
            boolean z3 = this.osD.otr == 1;
            int i3 = this.osD.ots;
            if (this.osu.getData() == null || Math.abs(this.osu.getData().ota - i) <= i3) {
                z2 = false;
            }
            if (this.osu.getData() == null || "00:00".equals(this.osu.getData().otb)) {
                bTJ();
                n(i, i2, z);
            } else if (this.osV || this.osU) {
                bTJ();
                n(i, i2, z);
            } else if (z3 && z2) {
                bTJ();
                n(i, i2, z);
            }
        }
    }

    private void n(int i, int i2, final boolean z) {
        this.osu.setData(new CountDownTextView.a(i, b.LS(i2)));
        this.gOm = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (AlaChallengeLiveView.this.osu != null) {
                    if (j > AppStatusRules.DEFAULT_GRANULARITY) {
                        AlaChallengeLiveView.this.osu.setData(new CountDownTextView.a((int) j, b.LS((int) (j / 1000))));
                        AlaChallengeLiveView.this.osu.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.osE.setVisibility(8);
                        return;
                    }
                    if (j / 1000 == 0) {
                        AlaChallengeLiveView.this.osu.setData(new CountDownTextView.a((int) j, "00:00"));
                    } else {
                        AlaChallengeLiveView.this.osu.setData(new CountDownTextView.a((int) j, ((int) (j / 1000)) + ""));
                    }
                    if (j / 1000 <= 10) {
                        if (z) {
                            if (AlaChallengeLiveView.this.osF == null || !AlaChallengeLiveView.this.osF.isRunning()) {
                                AlaChallengeLiveView.this.osE.setVisibility(0);
                                AlaChallengeLiveView.this.osF = ObjectAnimator.ofFloat(AlaChallengeLiveView.this.osE, "alpha", 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                                AlaChallengeLiveView.this.osF.setRepeatMode(1);
                                AlaChallengeLiveView.this.osF.setRepeatCount(-1);
                                AlaChallengeLiveView.this.osF.setDuration(1000L);
                                AlaChallengeLiveView.this.osF.start();
                            }
                            AlaChallengeLiveView.this.osu.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_color_fa4242));
                            return;
                        }
                        AlaChallengeLiveView.this.osu.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.osE.setVisibility(8);
                        return;
                    }
                    AlaChallengeLiveView.this.osu.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaChallengeLiveView.this.osE.setVisibility(8);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        };
        this.gOm.start();
    }

    private void eaH() {
        if (this.osD != null) {
            if ("0".equals(this.osD.otp.f5351a) && "0".equals(this.osD.otp.f5352b)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.osx.getLayoutParams();
                layoutParams.width = (int) (this.osC * 0.5f);
                this.osx.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.osy.getLayoutParams();
                layoutParams2.width = (int) (this.osC * 0.5f);
                this.osy.setLayoutParams(layoutParams2);
                return;
            }
            int parseInt = Integer.parseInt(this.osD.otp.f5351a);
            int parseInt2 = Integer.parseInt(this.osD.otp.f5352b);
            if (((parseInt > 0 && parseInt2 == 0) || (parseInt == 0 && parseInt2 > 0)) && !this.osQ) {
                this.osQ = true;
                this.osR = System.currentTimeMillis();
                eaI();
            } else if (Math.abs(System.currentTimeMillis() - this.osR) >= 2000) {
                eaJ();
            }
        }
    }

    private void eaI() {
        this.osM.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.osI.getLayoutParams();
        layoutParams.width = (int) (this.osC * 0.5f);
        this.osI.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.osJ.getLayoutParams();
        layoutParams2.width = (int) (this.osC * 0.5f);
        this.osJ.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.osK.getLayoutParams();
        layoutParams3.leftMargin = -((int) (this.osC * 0.5f));
        this.osK.setLayoutParams(layoutParams3);
        if (this.osL != null) {
            this.osL.playAnimation();
        }
        if (this.osK != null) {
            this.osK.playAnimation();
        }
        this.osS.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.osS, "ScaleX", 1.0f, 6.0f, 1.0f);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.osS, "scaleY", 1.0f, 6.0f, 1.0f);
        ofFloat2.setDuration(500L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeLiveView.this.osS.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) AlaChallengeLiveView.this.osN.getLayoutParams();
                layoutParams4.setMargins(((int) (AlaChallengeLiveView.this.osC * 0.5f)) - AlaChallengeLiveView.this.osP, AlaChallengeLiveView.this.osO, 0, 0);
                AlaChallengeLiveView.this.osN.setLayoutParams(layoutParams4);
                AlaChallengeLiveView.this.osN.setVisibility(0);
                AlaChallengeLiveView.this.osN.playAnimation();
                AlaChallengeLiveView.this.eaK();
                AlaChallengeLiveView.this.eaL();
                AlaChallengeLiveView.this.osS.setVisibility(8);
                float a2 = a.a(AlaChallengeLiveView.this.osD);
                float b2 = a.b(AlaChallengeLiveView.this.osv, AlaChallengeLiveView.this.osw);
                if (b2 != a2) {
                    if (AlaChallengeLiveView.this.mValueAnimator == null || !AlaChallengeLiveView.this.mValueAnimator.isRunning()) {
                        AlaChallengeLiveView.this.mValueAnimator = ValueAnimator.ofFloat(b2, a2);
                        AlaChallengeLiveView.this.mValueAnimator.setDuration(400L);
                        AlaChallengeLiveView.this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AlaChallengeLiveView.this.bg(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                                AlaChallengeLiveView.this.osQ = true;
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

    private void eaJ() {
        eaK();
        eaL();
        this.osS.setVisibility(8);
        float a2 = a.a(this.osD);
        float b2 = a.b(this.osv, this.osw);
        if (b2 != a2) {
            if (this.mValueAnimator == null || !this.mValueAnimator.isRunning()) {
                this.mValueAnimator = ValueAnimator.ofFloat(b2, a2);
                this.mValueAnimator.setDuration(400L);
                this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.3
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AlaChallengeLiveView.this.bg(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                    }
                });
                this.mValueAnimator.start();
            }
        } else if (this.osN.getVisibility() != 0 || !this.osN.isAnimating()) {
            bg(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.osx.getLayoutParams();
        layoutParams.width = (int) (this.osC * f);
        this.osx.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.osy.getLayoutParams();
        layoutParams2.width = (int) (this.osC * (1.0f - f));
        this.osy.setLayoutParams(layoutParams2);
        this.osM.setVisibility(0);
        ViewGroup.LayoutParams layoutParams3 = this.osI.getLayoutParams();
        layoutParams3.width = (int) (this.osC * f);
        this.osI.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.osJ.getLayoutParams();
        layoutParams4.width = (int) (this.osC * (1.0f - f));
        this.osJ.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.osK.getLayoutParams();
        layoutParams5.leftMargin = -((int) (this.osC * f));
        this.osK.setLayoutParams(layoutParams5);
        if (this.osL != null) {
            this.osL.playAnimation();
        }
        if (this.osK != null) {
            this.osK.playAnimation();
        }
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.osN.getLayoutParams();
        layoutParams6.setMargins(((int) (this.osC * f)) - this.osP, this.osO, 0, 0);
        this.osN.setLayoutParams(layoutParams6);
        this.osN.setVisibility(0);
        this.osN.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eaK() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.osv.getText().toString());
            try {
                i2 = Integer.parseInt(this.osD.otp.f5351a);
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
                    AlaChallengeLiveView.this.osv.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.osv.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.osD != null && this.osD.otp != null) {
            this.osv.setText(this.osD.otp.f5351a);
        } else {
            this.osv.setText("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eaL() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.osw.getText().toString());
            try {
                i2 = Integer.parseInt(this.osD.otp.f5352b);
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
                    AlaChallengeLiveView.this.osw.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.osw.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.osD != null && this.osD.otp != null) {
            this.osw.setText(this.osD.otp.f5352b);
        } else {
            this.osw.setText("0");
        }
    }

    public void cdY() {
        this.osA.setVisibility(4);
        this.osB.setVisibility(4);
    }

    private void VQ(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 97:
                if (str.equals("a")) {
                    c = 0;
                    break;
                }
                break;
            case 98:
                if (str.equals(com.baidu.pass.biometrics.face.liveness.d.b.f4046a)) {
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
                this.osA.setVisibility(0);
                this.osB.setVisibility(0);
                this.osA.setImageResource(a.e.left_win_icon);
                this.osB.setImageResource(a.e.right_fail_icon);
                this.osy.setBgColor(RightLadderTextView.BgColor.GRAY);
                this.osH.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape_gray);
                this.osx.setBgColor(LeftLadderTextView.BgColor.RED);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.osx.getLayoutParams();
                layoutParams.width = (int) (this.osC * a.a(this.osD));
                this.osx.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.osy.getLayoutParams();
                layoutParams2.width = (int) (this.osC * (1.0f - a.a(this.osD)));
                this.osy.setLayoutParams(layoutParams2);
                return;
            case 1:
                this.osA.setVisibility(0);
                this.osB.setVisibility(0);
                this.osA.setImageResource(a.e.left_fail_icon);
                this.osB.setImageResource(a.e.right_win_icon);
                this.osx.setBgColor(LeftLadderTextView.BgColor.GRAY);
                this.osG.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape_gray);
                this.osy.setBgColor(RightLadderTextView.BgColor.BLUE);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.osx.getLayoutParams();
                layoutParams3.width = (int) (this.osC * a.a(this.osD));
                this.osx.setLayoutParams(layoutParams3);
                ViewGroup.LayoutParams layoutParams4 = this.osy.getLayoutParams();
                layoutParams4.width = (int) (this.osC * (1.0f - a.a(this.osD)));
                this.osy.setLayoutParams(layoutParams4);
                return;
            case 2:
                this.osA.setVisibility(0);
                this.osB.setVisibility(0);
                this.osA.setImageResource(a.e.left_pingju_icon);
                this.osB.setImageResource(a.e.right_pingju_icon);
                eaC();
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.osx.getLayoutParams();
                layoutParams5.width = (int) (this.osC * 0.5f);
                this.osx.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.osy.getLayoutParams();
                layoutParams6.width = (int) (this.osC * 0.5f);
                this.osy.setLayoutParams(layoutParams6);
                return;
            default:
                return;
        }
    }
}
