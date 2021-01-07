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
    private CountDownTextView omF;
    private TextView omG;
    private TextView omH;
    private LeftLadderTextView omI;
    private RightLadderTextView omJ;
    private int omK;
    private ImageView omL;
    private ImageView omM;
    private int omN;
    private d omO;
    private View omP;
    private ObjectAnimator omQ;
    private View omR;
    private View omS;
    private LinearLayout omT;
    private LinearLayout omU;
    private LottieAnimationView omV;
    private LottieAnimationView omW;
    private FrameLayout omX;
    private LottieAnimationView omY;
    private int omZ;
    private int ona;
    private boolean onb;
    private long onc;
    private ImageView ond;
    private RelativeLayout onf;
    private boolean ong;
    private boolean onh;
    private RelativeLayout rootView;

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.onb = false;
        this.onc = 0L;
        this.ong = false;
        this.onh = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onb = false;
        this.onc = 0L;
        this.ong = false;
        this.onh = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onb = false;
        this.onc = 0L;
        this.ong = false;
        this.onh = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        eO(context);
    }

    private void eO(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_audio_challenge_panel_optation_view, this);
        this.omN = BdUtilHelper.getScreenSize((Activity) getContext()).widthPixels - BdUtilHelper.dip2px(getContext(), 54.0f);
        this.omZ = BdUtilHelper.dip2px(getContext(), 10.0f);
        this.ona = BdUtilHelper.dip2px(getContext(), 20.0f);
        this.hfE = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.onf = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.omF = (CountDownTextView) this.rootView.findViewById(a.f.pk_time_label);
        this.omF.setData(new CountDownTextView.a(0, "00:00"));
        this.omP = this.rootView.findViewById(a.f.view_shake);
        this.omR = this.rootView.findViewById(a.f.view_left_shape);
        this.omS = this.rootView.findViewById(a.f.view_right_shape);
        this.omL = (ImageView) this.rootView.findViewById(a.f.left_state);
        this.omM = (ImageView) this.rootView.findViewById(a.f.right_state);
        this.omY = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_center);
        this.omX = (FrameLayout) this.rootView.findViewById(a.f.ll_loading);
        this.omT = (LinearLayout) this.rootView.findViewById(a.f.ll_left_loading);
        this.omW = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_left);
        this.omU = (LinearLayout) this.rootView.findViewById(a.f.ll_right_loading);
        this.omV = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_right);
        this.omG = (TextView) this.rootView.findViewById(a.f.pk_left_progress);
        this.omH = (TextView) this.rootView.findViewById(a.f.pk_right_progress);
        this.omI = (LeftLadderTextView) this.rootView.findViewById(a.f.left_progress_bg);
        this.omJ = (RightLadderTextView) this.rootView.findViewById(a.f.right_progress_bg);
        this.ond = (ImageView) this.rootView.findViewById(a.f.img_view_center);
        this.omY.setImageAssetsFolder("lottie_team_fight_images/");
        this.omY.setAnimation("anim_view_center.json");
        this.omY.loop(true);
        ViewGroup.LayoutParams layoutParams = this.omW.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.omN;
        }
        this.omW.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.omV.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = this.omN;
        }
        this.omV.setLayoutParams(layoutParams2);
        this.omX.setVisibility(4);
        if (this.omW != null) {
            this.omW.cancelAnimation();
        }
        if (this.omV != null) {
            this.omV.cancelAnimation();
        }
        this.omY.setVisibility(4);
        if (this.omY != null) {
            this.omY.cancelAnimation();
        }
        ebZ();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.omI.getLayoutParams();
        layoutParams3.width = (int) (this.omN * 0.5f);
        this.omI.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.omJ.getLayoutParams();
        layoutParams4.width = (int) (this.omN * 0.5f);
        this.omJ.setLayoutParams(layoutParams4);
    }

    public void Z(x xVar) {
        if (xVar != null && xVar.aLm != null) {
            this.omK = xVar.aLm.mStep;
            ebY();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            if (this.omO != null) {
                this.ong = dVar.ony != this.omO.ony;
                this.onh = dVar.activity_stage != this.omO.activity_stage;
            }
            this.omO = dVar;
            this.omK = dVar.activity_stage;
            ebY();
        }
    }

    private void ebY() {
        switch (this.omK) {
            case 0:
                ecd();
                return;
            case 1:
                ecc();
                return;
            case 2:
                ecb();
                return;
            case 3:
                eca();
                return;
            default:
                return;
        }
    }

    public void ebZ() {
        this.omI.setBgColor(LeftLadderTextView.BgColor.RED);
        this.omR.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape);
        this.omJ.setBgColor(RightLadderTextView.BgColor.BLUE);
        this.omS.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape);
    }

    private void eca() {
        this.ond.setVisibility(8);
        this.onb = false;
        this.onc = 0L;
        if (this.omO != null) {
            VN(this.omO.onA);
            this.omG.setText(this.omO.onB.f5632a);
            this.omH.setText(this.omO.onB.f5633b);
        }
        this.onf.setBackgroundResource(a.e.yuyin_punish_icon);
        this.omP.setVisibility(8);
        this.omF.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        zB(false);
        if (this.omQ != null) {
            this.omQ.cancel();
        }
        this.omX.setVisibility(4);
        if (this.omW != null) {
            this.omW.cancelAnimation();
        }
        if (this.omV != null) {
            this.omV.cancelAnimation();
        }
        this.omY.setVisibility(4);
        if (this.omY != null) {
            this.omY.cancelAnimation();
        }
    }

    private void ecb() {
        cgO();
        ebZ();
        this.onf.setBackgroundResource(a.e.yuyin_statistics_icon);
        this.omF.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.omF.setData(new CountDownTextView.a(0, "00:00"));
        bWR();
        this.omP.setVisibility(8);
        if (this.omQ != null) {
            this.omQ.cancel();
        }
        if (this.omO != null && this.omO.onB != null) {
            ece();
        }
    }

    private void bWR() {
        if (this.gPY != null) {
            this.gPY.cancel();
        }
    }

    private void ecc() {
        this.onf.setBackgroundResource(a.e.yuyin_pking_icon);
        cgO();
        ebZ();
        if (this.omO != null) {
            if (this.omO.onB != null) {
                ece();
            }
            zB(true);
        }
    }

    private void ecd() {
        cgO();
        this.ond.setVisibility(8);
        this.onb = false;
        this.onc = 0L;
        this.onf.setBackgroundResource(a.e.yuyin_prepare_icon);
        this.omF.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.omF.setData(new CountDownTextView.a(0, "00:00"));
        bWR();
        this.omG.setText("0");
        this.omH.setText("0");
        ebZ();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omI.getLayoutParams();
        layoutParams.width = (int) (this.omN * 0.5f);
        this.omI.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.omJ.getLayoutParams();
        layoutParams2.width = (int) (this.omN * 0.5f);
        this.omJ.setLayoutParams(layoutParams2);
        this.omP.setVisibility(4);
        if (this.omQ != null) {
            this.omQ.cancel();
        }
        this.omX.setVisibility(4);
        if (this.omW != null) {
            this.omW.cancelAnimation();
        }
        if (this.omV != null) {
            this.omV.cancelAnimation();
        }
        this.omY.setVisibility(4);
        if (this.omY != null) {
            this.omY.cancelAnimation();
        }
    }

    private void zB(boolean z) {
        boolean z2 = true;
        if (this.omO != null) {
            int i = this.omO.onC;
            int i2 = i / 1000;
            boolean z3 = this.omO.onD == 1;
            int i3 = this.omO.onE;
            if (this.omF.getData() == null || Math.abs(this.omF.getData().onm - i) <= i3) {
                z2 = false;
            }
            if (this.omF.getData() == null || "00:00".equals(this.omF.getData().onn)) {
                bWR();
                m(i, i2, z);
            } else if (this.onh || this.ong) {
                bWR();
                m(i, i2, z);
            } else if (z3 && z2) {
                bWR();
                m(i, i2, z);
            }
        }
    }

    private void m(int i, int i2, final boolean z) {
        this.omF.setData(new CountDownTextView.a(i, c.Nd(i2)));
        this.gPY = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (AlaChallengeLiveView.this.omF != null) {
                    if (j > AppStatusRules.DEFAULT_GRANULARITY) {
                        AlaChallengeLiveView.this.omF.setData(new CountDownTextView.a((int) j, c.Nd((int) (j / 1000))));
                        AlaChallengeLiveView.this.omF.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.omP.setVisibility(8);
                        return;
                    }
                    if (j / 1000 == 0) {
                        AlaChallengeLiveView.this.omF.setData(new CountDownTextView.a((int) j, "00:00"));
                    } else {
                        AlaChallengeLiveView.this.omF.setData(new CountDownTextView.a((int) j, ((int) (j / 1000)) + ""));
                    }
                    if (j / 1000 <= 10) {
                        if (z) {
                            if (AlaChallengeLiveView.this.omQ == null || !AlaChallengeLiveView.this.omQ.isRunning()) {
                                AlaChallengeLiveView.this.omP.setVisibility(0);
                                AlaChallengeLiveView.this.omQ = ObjectAnimator.ofFloat(AlaChallengeLiveView.this.omP, "alpha", 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                                AlaChallengeLiveView.this.omQ.setRepeatMode(1);
                                AlaChallengeLiveView.this.omQ.setRepeatCount(-1);
                                AlaChallengeLiveView.this.omQ.setDuration(1000L);
                                AlaChallengeLiveView.this.omQ.start();
                            }
                            AlaChallengeLiveView.this.omF.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_color_fa4242));
                            return;
                        }
                        AlaChallengeLiveView.this.omF.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.omP.setVisibility(8);
                        return;
                    }
                    AlaChallengeLiveView.this.omF.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaChallengeLiveView.this.omP.setVisibility(8);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        };
        this.gPY.start();
    }

    private void ece() {
        if (this.omO != null) {
            if ("0".equals(this.omO.onB.f5632a) && "0".equals(this.omO.onB.f5633b)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omI.getLayoutParams();
                layoutParams.width = (int) (this.omN * 0.5f);
                this.omI.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.omJ.getLayoutParams();
                layoutParams2.width = (int) (this.omN * 0.5f);
                this.omJ.setLayoutParams(layoutParams2);
                return;
            }
            int parseInt = Integer.parseInt(this.omO.onB.f5632a);
            int parseInt2 = Integer.parseInt(this.omO.onB.f5633b);
            if (((parseInt > 0 && parseInt2 == 0) || (parseInt == 0 && parseInt2 > 0)) && !this.onb) {
                this.onb = true;
                this.onc = System.currentTimeMillis();
                ecf();
            } else if (Math.abs(System.currentTimeMillis() - this.onc) >= 2000) {
                ecg();
            }
        }
    }

    private void ecf() {
        this.omX.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.omT.getLayoutParams();
        layoutParams.width = (int) (this.omN * 0.5f);
        this.omT.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.omU.getLayoutParams();
        layoutParams2.width = (int) (this.omN * 0.5f);
        this.omU.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.omV.getLayoutParams();
        layoutParams3.leftMargin = -((int) (this.omN * 0.5f));
        this.omV.setLayoutParams(layoutParams3);
        if (this.omW != null) {
            this.omW.playAnimation();
        }
        if (this.omV != null) {
            this.omV.playAnimation();
        }
        this.ond.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ond, "ScaleX", 1.0f, 6.0f, 1.0f);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ond, "scaleY", 1.0f, 6.0f, 1.0f);
        ofFloat2.setDuration(500L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeLiveView.this.ond.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) AlaChallengeLiveView.this.omY.getLayoutParams();
                layoutParams4.setMargins(((int) (AlaChallengeLiveView.this.omN * 0.5f)) - AlaChallengeLiveView.this.ona, AlaChallengeLiveView.this.omZ, 0, 0);
                AlaChallengeLiveView.this.omY.setLayoutParams(layoutParams4);
                AlaChallengeLiveView.this.omY.setVisibility(0);
                AlaChallengeLiveView.this.omY.playAnimation();
                AlaChallengeLiveView.this.ech();
                AlaChallengeLiveView.this.eci();
                AlaChallengeLiveView.this.ond.setVisibility(8);
                float b2 = b.b(AlaChallengeLiveView.this.omO);
                float b3 = b.b(AlaChallengeLiveView.this.omG, AlaChallengeLiveView.this.omH);
                if (b3 != b2) {
                    if (AlaChallengeLiveView.this.mValueAnimator == null || !AlaChallengeLiveView.this.mValueAnimator.isRunning()) {
                        AlaChallengeLiveView.this.mValueAnimator = ValueAnimator.ofFloat(b3, b2);
                        AlaChallengeLiveView.this.mValueAnimator.setDuration(400L);
                        AlaChallengeLiveView.this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AlaChallengeLiveView.this.bd(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                                AlaChallengeLiveView.this.onb = true;
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

    private void ecg() {
        ech();
        eci();
        this.ond.setVisibility(8);
        float b2 = b.b(this.omO);
        float b3 = b.b(this.omG, this.omH);
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
        } else if (this.omY.getVisibility() != 0 || !this.omY.isAnimating()) {
            bd(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omI.getLayoutParams();
        layoutParams.width = (int) (this.omN * f);
        this.omI.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.omJ.getLayoutParams();
        layoutParams2.width = (int) (this.omN * (1.0f - f));
        this.omJ.setLayoutParams(layoutParams2);
        this.omX.setVisibility(0);
        ViewGroup.LayoutParams layoutParams3 = this.omT.getLayoutParams();
        layoutParams3.width = (int) (this.omN * f);
        this.omT.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.omU.getLayoutParams();
        layoutParams4.width = (int) (this.omN * (1.0f - f));
        this.omU.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.omV.getLayoutParams();
        layoutParams5.leftMargin = -((int) (this.omN * f));
        this.omV.setLayoutParams(layoutParams5);
        if (this.omW != null) {
            this.omW.playAnimation();
        }
        if (this.omV != null) {
            this.omV.playAnimation();
        }
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.omY.getLayoutParams();
        layoutParams6.setMargins(((int) (this.omN * f)) - this.ona, this.omZ, 0, 0);
        this.omY.setLayoutParams(layoutParams6);
        this.omY.setVisibility(0);
        this.omY.playAnimation();
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
            i = Integer.parseInt(this.omG.getText().toString());
            try {
                i2 = Integer.parseInt(this.omO.onB.f5632a);
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
                    AlaChallengeLiveView.this.omG.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.omG.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.omO != null && this.omO.onB != null) {
            this.omG.setText(this.omO.onB.f5632a);
        } else {
            this.omG.setText("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eci() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.omH.getText().toString());
            try {
                i2 = Integer.parseInt(this.omO.onB.f5633b);
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
                    AlaChallengeLiveView.this.omH.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.omH.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.omO != null && this.omO.onB != null) {
            this.omH.setText(this.omO.onB.f5633b);
        } else {
            this.omH.setText("0");
        }
    }

    public void cgO() {
        this.omL.setVisibility(4);
        this.omM.setVisibility(4);
    }

    private void VN(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 97:
                if (str.equals("a")) {
                    c = 0;
                    break;
                }
                break;
            case 98:
                if (str.equals(com.baidu.pass.biometrics.face.liveness.d.b.f4081a)) {
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
                this.omL.setVisibility(0);
                this.omM.setVisibility(0);
                this.omL.setImageResource(a.e.left_win_icon);
                this.omM.setImageResource(a.e.right_fail_icon);
                this.omJ.setBgColor(RightLadderTextView.BgColor.GRAY);
                this.omS.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape_gray);
                this.omI.setBgColor(LeftLadderTextView.BgColor.RED);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.omI.getLayoutParams();
                layoutParams.width = (int) (this.omN * b.b(this.omO));
                this.omI.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.omJ.getLayoutParams();
                layoutParams2.width = (int) (this.omN * (1.0f - b.b(this.omO)));
                this.omJ.setLayoutParams(layoutParams2);
                return;
            case 1:
                this.omL.setVisibility(0);
                this.omM.setVisibility(0);
                this.omL.setImageResource(a.e.left_fail_icon);
                this.omM.setImageResource(a.e.right_win_icon);
                this.omI.setBgColor(LeftLadderTextView.BgColor.GRAY);
                this.omR.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape_gray);
                this.omJ.setBgColor(RightLadderTextView.BgColor.BLUE);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.omI.getLayoutParams();
                layoutParams3.width = (int) (this.omN * b.b(this.omO));
                this.omI.setLayoutParams(layoutParams3);
                ViewGroup.LayoutParams layoutParams4 = this.omJ.getLayoutParams();
                layoutParams4.width = (int) (this.omN * (1.0f - b.b(this.omO)));
                this.omJ.setLayoutParams(layoutParams4);
                return;
            case 2:
                this.omL.setVisibility(0);
                this.omM.setVisibility(0);
                this.omL.setImageResource(a.e.left_pingju_icon);
                this.omM.setImageResource(a.e.right_pingju_icon);
                ebZ();
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.omI.getLayoutParams();
                layoutParams5.width = (int) (this.omN * 0.5f);
                this.omI.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.omJ.getLayoutParams();
                layoutParams6.width = (int) (this.omN * 0.5f);
                this.omJ.setLayoutParams(layoutParams6);
                return;
            default:
                return;
        }
    }

    public void destory() {
        this.onb = false;
        this.onc = 0L;
        this.ong = false;
        this.onh = false;
        bWR();
    }
}
