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
/* loaded from: classes10.dex */
public class AlaChallengeLiveView extends RelativeLayout {
    private CountDownTimer gLs;
    private RelativeLayout haY;
    private Context mContext;
    private ValueAnimator mValueAnimator;
    private boolean oiA;
    private boolean oiB;
    private CountDownTextView oia;
    private TextView oib;
    private TextView oic;
    private LeftLadderTextView oid;
    private RightLadderTextView oie;
    private int oif;
    private ImageView oig;
    private ImageView oih;
    private int oii;
    private d oij;
    private View oik;
    private ObjectAnimator oil;
    private View oim;
    private View oin;
    private LinearLayout oio;
    private LinearLayout oip;
    private LottieAnimationView oiq;
    private LottieAnimationView oir;
    private FrameLayout ois;
    private LottieAnimationView oit;
    private int oiu;
    private int oiv;
    private boolean oiw;
    private long oix;
    private ImageView oiy;
    private RelativeLayout oiz;
    private RelativeLayout rootView;

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.oiw = false;
        this.oix = 0L;
        this.oiA = false;
        this.oiB = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oiw = false;
        this.oix = 0L;
        this.oiA = false;
        this.oiB = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oiw = false;
        this.oix = 0L;
        this.oiA = false;
        this.oiB = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_audio_challenge_panel_optation_view, this);
        this.oii = BdUtilHelper.getScreenSize((Activity) getContext()).widthPixels - BdUtilHelper.dip2px(getContext(), 54.0f);
        this.oiu = BdUtilHelper.dip2px(getContext(), 10.0f);
        this.oiv = BdUtilHelper.dip2px(getContext(), 20.0f);
        this.haY = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.oiz = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.oia = (CountDownTextView) this.rootView.findViewById(a.f.pk_time_label);
        this.oia.setData(new CountDownTextView.a(0, "00:00"));
        this.oik = this.rootView.findViewById(a.f.view_shake);
        this.oim = this.rootView.findViewById(a.f.view_left_shape);
        this.oin = this.rootView.findViewById(a.f.view_right_shape);
        this.oig = (ImageView) this.rootView.findViewById(a.f.left_state);
        this.oih = (ImageView) this.rootView.findViewById(a.f.right_state);
        this.oit = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_center);
        this.ois = (FrameLayout) this.rootView.findViewById(a.f.ll_loading);
        this.oio = (LinearLayout) this.rootView.findViewById(a.f.ll_left_loading);
        this.oir = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_left);
        this.oip = (LinearLayout) this.rootView.findViewById(a.f.ll_right_loading);
        this.oiq = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_right);
        this.oib = (TextView) this.rootView.findViewById(a.f.pk_left_progress);
        this.oic = (TextView) this.rootView.findViewById(a.f.pk_right_progress);
        this.oid = (LeftLadderTextView) this.rootView.findViewById(a.f.left_progress_bg);
        this.oie = (RightLadderTextView) this.rootView.findViewById(a.f.right_progress_bg);
        this.oiy = (ImageView) this.rootView.findViewById(a.f.img_view_center);
        this.oit.setImageAssetsFolder("lottie_team_fight_images/");
        this.oit.setAnimation("anim_view_center.json");
        this.oit.loop(true);
        ViewGroup.LayoutParams layoutParams = this.oir.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.oii;
        }
        this.oir.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oiq.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = this.oii;
        }
        this.oiq.setLayoutParams(layoutParams2);
        this.ois.setVisibility(4);
        if (this.oir != null) {
            this.oir.cancelAnimation();
        }
        if (this.oiq != null) {
            this.oiq.cancelAnimation();
        }
        this.oit.setVisibility(4);
        if (this.oit != null) {
            this.oit.cancelAnimation();
        }
        dYh();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.oid.getLayoutParams();
        layoutParams3.width = (int) (this.oii * 0.5f);
        this.oid.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.oie.getLayoutParams();
        layoutParams4.width = (int) (this.oii * 0.5f);
        this.oie.setLayoutParams(layoutParams4);
    }

    public void Z(x xVar) {
        if (xVar != null && xVar.aGz != null) {
            this.oif = xVar.aGz.mStep;
            dYg();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            if (this.oij != null) {
                this.oiA = dVar.oiS != this.oij.oiS;
                this.oiB = dVar.activity_stage != this.oij.activity_stage;
            }
            this.oij = dVar;
            this.oif = dVar.activity_stage;
            dYg();
        }
    }

    private void dYg() {
        switch (this.oif) {
            case 0:
                dYl();
                return;
            case 1:
                dYk();
                return;
            case 2:
                dYj();
                return;
            case 3:
                dYi();
                return;
            default:
                return;
        }
    }

    public void dYh() {
        this.oid.setBgColor(LeftLadderTextView.BgColor.RED);
        this.oim.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape);
        this.oie.setBgColor(RightLadderTextView.BgColor.BLUE);
        this.oin.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape);
    }

    private void dYi() {
        this.oiy.setVisibility(8);
        this.oiw = false;
        this.oix = 0L;
        if (this.oij != null) {
            UF(this.oij.oiU);
            this.oib.setText(this.oij.oiV.f5349a);
            this.oic.setText(this.oij.oiV.f5350b);
        }
        this.oiz.setBackgroundResource(a.e.yuyin_punish_icon);
        this.oik.setVisibility(8);
        this.oia.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        zx(false);
        if (this.oil != null) {
            this.oil.cancel();
        }
        this.ois.setVisibility(4);
        if (this.oir != null) {
            this.oir.cancelAnimation();
        }
        if (this.oiq != null) {
            this.oiq.cancelAnimation();
        }
        this.oit.setVisibility(4);
        if (this.oit != null) {
            this.oit.cancelAnimation();
        }
    }

    private void dYj() {
        ccW();
        dYh();
        this.oiz.setBackgroundResource(a.e.yuyin_statistics_icon);
        this.oia.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.oia.setData(new CountDownTextView.a(0, "00:00"));
        bSZ();
        this.oik.setVisibility(8);
        if (this.oil != null) {
            this.oil.cancel();
        }
        if (this.oij != null && this.oij.oiV != null) {
            dYm();
        }
    }

    private void bSZ() {
        if (this.gLs != null) {
            this.gLs.cancel();
        }
    }

    private void dYk() {
        this.oiz.setBackgroundResource(a.e.yuyin_pking_icon);
        ccW();
        dYh();
        if (this.oij != null) {
            if (this.oij.oiV != null) {
                dYm();
            }
            zx(true);
        }
    }

    private void dYl() {
        ccW();
        this.oiy.setVisibility(8);
        this.oiw = false;
        this.oix = 0L;
        this.oiz.setBackgroundResource(a.e.yuyin_prepare_icon);
        this.oia.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.oia.setData(new CountDownTextView.a(0, "00:00"));
        bSZ();
        this.oib.setText("0");
        this.oic.setText("0");
        dYh();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oid.getLayoutParams();
        layoutParams.width = (int) (this.oii * 0.5f);
        this.oid.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oie.getLayoutParams();
        layoutParams2.width = (int) (this.oii * 0.5f);
        this.oie.setLayoutParams(layoutParams2);
        this.oik.setVisibility(4);
        if (this.oil != null) {
            this.oil.cancel();
        }
        this.ois.setVisibility(4);
        if (this.oir != null) {
            this.oir.cancelAnimation();
        }
        if (this.oiq != null) {
            this.oiq.cancelAnimation();
        }
        this.oit.setVisibility(4);
        if (this.oit != null) {
            this.oit.cancelAnimation();
        }
    }

    private void zx(boolean z) {
        boolean z2 = true;
        if (this.oij != null) {
            int i = this.oij.oiW;
            int i2 = i / 1000;
            boolean z3 = this.oij.oiX == 1;
            int i3 = this.oij.oiY;
            if (this.oia.getData() == null || Math.abs(this.oia.getData().oiG - i) <= i3) {
                z2 = false;
            }
            if (this.oia.getData() == null || "00:00".equals(this.oia.getData().oiH)) {
                bSZ();
                m(i, i2, z);
            } else if (this.oiB || this.oiA) {
                bSZ();
                m(i, i2, z);
            } else if (z3 && z2) {
                bSZ();
                m(i, i2, z);
            }
        }
    }

    private void m(int i, int i2, final boolean z) {
        this.oia.setData(new CountDownTextView.a(i, c.Lw(i2)));
        this.gLs = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (AlaChallengeLiveView.this.oia != null) {
                    if (j > AppStatusRules.DEFAULT_GRANULARITY) {
                        AlaChallengeLiveView.this.oia.setData(new CountDownTextView.a((int) j, c.Lw((int) (j / 1000))));
                        AlaChallengeLiveView.this.oia.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.oik.setVisibility(8);
                        return;
                    }
                    if (j / 1000 == 0) {
                        AlaChallengeLiveView.this.oia.setData(new CountDownTextView.a((int) j, "00:00"));
                    } else {
                        AlaChallengeLiveView.this.oia.setData(new CountDownTextView.a((int) j, ((int) (j / 1000)) + ""));
                    }
                    if (j / 1000 <= 10) {
                        if (z) {
                            if (AlaChallengeLiveView.this.oil == null || !AlaChallengeLiveView.this.oil.isRunning()) {
                                AlaChallengeLiveView.this.oik.setVisibility(0);
                                AlaChallengeLiveView.this.oil = ObjectAnimator.ofFloat(AlaChallengeLiveView.this.oik, "alpha", 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                                AlaChallengeLiveView.this.oil.setRepeatMode(1);
                                AlaChallengeLiveView.this.oil.setRepeatCount(-1);
                                AlaChallengeLiveView.this.oil.setDuration(1000L);
                                AlaChallengeLiveView.this.oil.start();
                            }
                            AlaChallengeLiveView.this.oia.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_color_fa4242));
                            return;
                        }
                        AlaChallengeLiveView.this.oia.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.oik.setVisibility(8);
                        return;
                    }
                    AlaChallengeLiveView.this.oia.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaChallengeLiveView.this.oik.setVisibility(8);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        };
        this.gLs.start();
    }

    private void dYm() {
        if (this.oij != null) {
            if ("0".equals(this.oij.oiV.f5349a) && "0".equals(this.oij.oiV.f5350b)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oid.getLayoutParams();
                layoutParams.width = (int) (this.oii * 0.5f);
                this.oid.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.oie.getLayoutParams();
                layoutParams2.width = (int) (this.oii * 0.5f);
                this.oie.setLayoutParams(layoutParams2);
                return;
            }
            int parseInt = Integer.parseInt(this.oij.oiV.f5349a);
            int parseInt2 = Integer.parseInt(this.oij.oiV.f5350b);
            if (((parseInt > 0 && parseInt2 == 0) || (parseInt == 0 && parseInt2 > 0)) && !this.oiw) {
                this.oiw = true;
                this.oix = System.currentTimeMillis();
                dYn();
            } else if (Math.abs(System.currentTimeMillis() - this.oix) >= 2000) {
                dYo();
            }
        }
    }

    private void dYn() {
        this.ois.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.oio.getLayoutParams();
        layoutParams.width = (int) (this.oii * 0.5f);
        this.oio.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oip.getLayoutParams();
        layoutParams2.width = (int) (this.oii * 0.5f);
        this.oip.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.oiq.getLayoutParams();
        layoutParams3.leftMargin = -((int) (this.oii * 0.5f));
        this.oiq.setLayoutParams(layoutParams3);
        if (this.oir != null) {
            this.oir.playAnimation();
        }
        if (this.oiq != null) {
            this.oiq.playAnimation();
        }
        this.oiy.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.oiy, "ScaleX", 1.0f, 6.0f, 1.0f);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.oiy, "scaleY", 1.0f, 6.0f, 1.0f);
        ofFloat2.setDuration(500L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeLiveView.this.oiy.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) AlaChallengeLiveView.this.oit.getLayoutParams();
                layoutParams4.setMargins(((int) (AlaChallengeLiveView.this.oii * 0.5f)) - AlaChallengeLiveView.this.oiv, AlaChallengeLiveView.this.oiu, 0, 0);
                AlaChallengeLiveView.this.oit.setLayoutParams(layoutParams4);
                AlaChallengeLiveView.this.oit.setVisibility(0);
                AlaChallengeLiveView.this.oit.playAnimation();
                AlaChallengeLiveView.this.dYp();
                AlaChallengeLiveView.this.dYq();
                AlaChallengeLiveView.this.oiy.setVisibility(8);
                float b2 = b.b(AlaChallengeLiveView.this.oij);
                float b3 = b.b(AlaChallengeLiveView.this.oib, AlaChallengeLiveView.this.oic);
                if (b3 != b2) {
                    if (AlaChallengeLiveView.this.mValueAnimator == null || !AlaChallengeLiveView.this.mValueAnimator.isRunning()) {
                        AlaChallengeLiveView.this.mValueAnimator = ValueAnimator.ofFloat(b3, b2);
                        AlaChallengeLiveView.this.mValueAnimator.setDuration(400L);
                        AlaChallengeLiveView.this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AlaChallengeLiveView.this.bd(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                                AlaChallengeLiveView.this.oiw = true;
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

    private void dYo() {
        dYp();
        dYq();
        this.oiy.setVisibility(8);
        float b2 = b.b(this.oij);
        float b3 = b.b(this.oib, this.oic);
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
        } else if (this.oit.getVisibility() != 0 || !this.oit.isAnimating()) {
            bd(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oid.getLayoutParams();
        layoutParams.width = (int) (this.oii * f);
        this.oid.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oie.getLayoutParams();
        layoutParams2.width = (int) (this.oii * (1.0f - f));
        this.oie.setLayoutParams(layoutParams2);
        this.ois.setVisibility(0);
        ViewGroup.LayoutParams layoutParams3 = this.oio.getLayoutParams();
        layoutParams3.width = (int) (this.oii * f);
        this.oio.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.oip.getLayoutParams();
        layoutParams4.width = (int) (this.oii * (1.0f - f));
        this.oip.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.oiq.getLayoutParams();
        layoutParams5.leftMargin = -((int) (this.oii * f));
        this.oiq.setLayoutParams(layoutParams5);
        if (this.oir != null) {
            this.oir.playAnimation();
        }
        if (this.oiq != null) {
            this.oiq.playAnimation();
        }
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.oit.getLayoutParams();
        layoutParams6.setMargins(((int) (this.oii * f)) - this.oiv, this.oiu, 0, 0);
        this.oit.setLayoutParams(layoutParams6);
        this.oit.setVisibility(0);
        this.oit.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dYp() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.oib.getText().toString());
            try {
                i2 = Integer.parseInt(this.oij.oiV.f5349a);
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
                    AlaChallengeLiveView.this.oib.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.oib.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.oij != null && this.oij.oiV != null) {
            this.oib.setText(this.oij.oiV.f5349a);
        } else {
            this.oib.setText("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void dYq() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.oic.getText().toString());
            try {
                i2 = Integer.parseInt(this.oij.oiV.f5350b);
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
                    AlaChallengeLiveView.this.oic.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.oic.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.oij != null && this.oij.oiV != null) {
            this.oic.setText(this.oij.oiV.f5350b);
        } else {
            this.oic.setText("0");
        }
    }

    public void ccW() {
        this.oig.setVisibility(4);
        this.oih.setVisibility(4);
    }

    private void UF(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case 97:
                if (str.equals("a")) {
                    c = 0;
                    break;
                }
                break;
            case 98:
                if (str.equals(com.baidu.pass.biometrics.face.liveness.d.b.f4043a)) {
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
                this.oig.setVisibility(0);
                this.oih.setVisibility(0);
                this.oig.setImageResource(a.e.left_win_icon);
                this.oih.setImageResource(a.e.right_fail_icon);
                this.oie.setBgColor(RightLadderTextView.BgColor.GRAY);
                this.oin.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape_gray);
                this.oid.setBgColor(LeftLadderTextView.BgColor.RED);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oid.getLayoutParams();
                layoutParams.width = (int) (this.oii * b.b(this.oij));
                this.oid.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.oie.getLayoutParams();
                layoutParams2.width = (int) (this.oii * (1.0f - b.b(this.oij)));
                this.oie.setLayoutParams(layoutParams2);
                return;
            case 1:
                this.oig.setVisibility(0);
                this.oih.setVisibility(0);
                this.oig.setImageResource(a.e.left_fail_icon);
                this.oih.setImageResource(a.e.right_win_icon);
                this.oid.setBgColor(LeftLadderTextView.BgColor.GRAY);
                this.oim.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape_gray);
                this.oie.setBgColor(RightLadderTextView.BgColor.BLUE);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.oid.getLayoutParams();
                layoutParams3.width = (int) (this.oii * b.b(this.oij));
                this.oid.setLayoutParams(layoutParams3);
                ViewGroup.LayoutParams layoutParams4 = this.oie.getLayoutParams();
                layoutParams4.width = (int) (this.oii * (1.0f - b.b(this.oij)));
                this.oie.setLayoutParams(layoutParams4);
                return;
            case 2:
                this.oig.setVisibility(0);
                this.oih.setVisibility(0);
                this.oig.setImageResource(a.e.left_pingju_icon);
                this.oih.setImageResource(a.e.right_pingju_icon);
                dYh();
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.oid.getLayoutParams();
                layoutParams5.width = (int) (this.oii * 0.5f);
                this.oid.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.oie.getLayoutParams();
                layoutParams6.width = (int) (this.oii * 0.5f);
                this.oie.setLayoutParams(layoutParams6);
                return;
            default:
                return;
        }
    }

    public void destory() {
        this.oiw = false;
        this.oix = 0L;
        this.oiA = false;
        this.oiB = false;
        bSZ();
    }
}
