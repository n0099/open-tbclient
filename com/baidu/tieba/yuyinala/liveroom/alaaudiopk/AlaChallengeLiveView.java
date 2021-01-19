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
    private RelativeLayout oiA;
    private boolean oiB;
    private boolean oiC;
    private CountDownTextView oib;
    private TextView oic;
    private TextView oid;
    private LeftLadderTextView oie;
    private RightLadderTextView oif;
    private int oig;
    private ImageView oih;
    private ImageView oii;
    private int oij;
    private d oik;
    private View oil;
    private ObjectAnimator oim;
    private View oin;
    private View oio;
    private LinearLayout oip;
    private LinearLayout oiq;
    private LottieAnimationView oir;
    private LottieAnimationView ois;
    private FrameLayout oit;
    private LottieAnimationView oiu;
    private int oiv;
    private int oiw;
    private boolean oix;
    private long oiy;
    private ImageView oiz;
    private RelativeLayout rootView;

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.oix = false;
        this.oiy = 0L;
        this.oiB = false;
        this.oiC = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oix = false;
        this.oiy = 0L;
        this.oiB = false;
        this.oiC = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oix = false;
        this.oiy = 0L;
        this.oiB = false;
        this.oiC = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_audio_challenge_panel_optation_view, this);
        this.oij = BdUtilHelper.getScreenSize((Activity) getContext()).widthPixels - BdUtilHelper.dip2px(getContext(), 54.0f);
        this.oiv = BdUtilHelper.dip2px(getContext(), 10.0f);
        this.oiw = BdUtilHelper.dip2px(getContext(), 20.0f);
        this.haY = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.oiA = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.oib = (CountDownTextView) this.rootView.findViewById(a.f.pk_time_label);
        this.oib.setData(new CountDownTextView.a(0, "00:00"));
        this.oil = this.rootView.findViewById(a.f.view_shake);
        this.oin = this.rootView.findViewById(a.f.view_left_shape);
        this.oio = this.rootView.findViewById(a.f.view_right_shape);
        this.oih = (ImageView) this.rootView.findViewById(a.f.left_state);
        this.oii = (ImageView) this.rootView.findViewById(a.f.right_state);
        this.oiu = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_center);
        this.oit = (FrameLayout) this.rootView.findViewById(a.f.ll_loading);
        this.oip = (LinearLayout) this.rootView.findViewById(a.f.ll_left_loading);
        this.ois = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_left);
        this.oiq = (LinearLayout) this.rootView.findViewById(a.f.ll_right_loading);
        this.oir = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_right);
        this.oic = (TextView) this.rootView.findViewById(a.f.pk_left_progress);
        this.oid = (TextView) this.rootView.findViewById(a.f.pk_right_progress);
        this.oie = (LeftLadderTextView) this.rootView.findViewById(a.f.left_progress_bg);
        this.oif = (RightLadderTextView) this.rootView.findViewById(a.f.right_progress_bg);
        this.oiz = (ImageView) this.rootView.findViewById(a.f.img_view_center);
        this.oiu.setImageAssetsFolder("lottie_team_fight_images/");
        this.oiu.setAnimation("anim_view_center.json");
        this.oiu.loop(true);
        ViewGroup.LayoutParams layoutParams = this.ois.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.oij;
        }
        this.ois.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oir.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = this.oij;
        }
        this.oir.setLayoutParams(layoutParams2);
        this.oit.setVisibility(4);
        if (this.ois != null) {
            this.ois.cancelAnimation();
        }
        if (this.oir != null) {
            this.oir.cancelAnimation();
        }
        this.oiu.setVisibility(4);
        if (this.oiu != null) {
            this.oiu.cancelAnimation();
        }
        dYh();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.oie.getLayoutParams();
        layoutParams3.width = (int) (this.oij * 0.5f);
        this.oie.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.oif.getLayoutParams();
        layoutParams4.width = (int) (this.oij * 0.5f);
        this.oif.setLayoutParams(layoutParams4);
    }

    public void Z(x xVar) {
        if (xVar != null && xVar.aGz != null) {
            this.oig = xVar.aGz.mStep;
            dYg();
        }
    }

    public void a(d dVar) {
        if (dVar != null) {
            if (this.oik != null) {
                this.oiB = dVar.oiT != this.oik.oiT;
                this.oiC = dVar.activity_stage != this.oik.activity_stage;
            }
            this.oik = dVar;
            this.oig = dVar.activity_stage;
            dYg();
        }
    }

    private void dYg() {
        switch (this.oig) {
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
        this.oie.setBgColor(LeftLadderTextView.BgColor.RED);
        this.oin.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape);
        this.oif.setBgColor(RightLadderTextView.BgColor.BLUE);
        this.oio.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape);
    }

    private void dYi() {
        this.oiz.setVisibility(8);
        this.oix = false;
        this.oiy = 0L;
        if (this.oik != null) {
            UG(this.oik.oiV);
            this.oic.setText(this.oik.oiW.f5349a);
            this.oid.setText(this.oik.oiW.f5350b);
        }
        this.oiA.setBackgroundResource(a.e.yuyin_punish_icon);
        this.oil.setVisibility(8);
        this.oib.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        zx(false);
        if (this.oim != null) {
            this.oim.cancel();
        }
        this.oit.setVisibility(4);
        if (this.ois != null) {
            this.ois.cancelAnimation();
        }
        if (this.oir != null) {
            this.oir.cancelAnimation();
        }
        this.oiu.setVisibility(4);
        if (this.oiu != null) {
            this.oiu.cancelAnimation();
        }
    }

    private void dYj() {
        ccW();
        dYh();
        this.oiA.setBackgroundResource(a.e.yuyin_statistics_icon);
        this.oib.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.oib.setData(new CountDownTextView.a(0, "00:00"));
        bSZ();
        this.oil.setVisibility(8);
        if (this.oim != null) {
            this.oim.cancel();
        }
        if (this.oik != null && this.oik.oiW != null) {
            dYm();
        }
    }

    private void bSZ() {
        if (this.gLs != null) {
            this.gLs.cancel();
        }
    }

    private void dYk() {
        this.oiA.setBackgroundResource(a.e.yuyin_pking_icon);
        ccW();
        dYh();
        if (this.oik != null) {
            if (this.oik.oiW != null) {
                dYm();
            }
            zx(true);
        }
    }

    private void dYl() {
        ccW();
        this.oiz.setVisibility(8);
        this.oix = false;
        this.oiy = 0L;
        this.oiA.setBackgroundResource(a.e.yuyin_prepare_icon);
        this.oib.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.oib.setData(new CountDownTextView.a(0, "00:00"));
        bSZ();
        this.oic.setText("0");
        this.oid.setText("0");
        dYh();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oie.getLayoutParams();
        layoutParams.width = (int) (this.oij * 0.5f);
        this.oie.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oif.getLayoutParams();
        layoutParams2.width = (int) (this.oij * 0.5f);
        this.oif.setLayoutParams(layoutParams2);
        this.oil.setVisibility(4);
        if (this.oim != null) {
            this.oim.cancel();
        }
        this.oit.setVisibility(4);
        if (this.ois != null) {
            this.ois.cancelAnimation();
        }
        if (this.oir != null) {
            this.oir.cancelAnimation();
        }
        this.oiu.setVisibility(4);
        if (this.oiu != null) {
            this.oiu.cancelAnimation();
        }
    }

    private void zx(boolean z) {
        boolean z2 = true;
        if (this.oik != null) {
            int i = this.oik.oiX;
            int i2 = i / 1000;
            boolean z3 = this.oik.oiY == 1;
            int i3 = this.oik.oiZ;
            if (this.oib.getData() == null || Math.abs(this.oib.getData().oiH - i) <= i3) {
                z2 = false;
            }
            if (this.oib.getData() == null || "00:00".equals(this.oib.getData().oiI)) {
                bSZ();
                m(i, i2, z);
            } else if (this.oiC || this.oiB) {
                bSZ();
                m(i, i2, z);
            } else if (z3 && z2) {
                bSZ();
                m(i, i2, z);
            }
        }
    }

    private void m(int i, int i2, final boolean z) {
        this.oib.setData(new CountDownTextView.a(i, c.Lw(i2)));
        this.gLs = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (AlaChallengeLiveView.this.oib != null) {
                    if (j > AppStatusRules.DEFAULT_GRANULARITY) {
                        AlaChallengeLiveView.this.oib.setData(new CountDownTextView.a((int) j, c.Lw((int) (j / 1000))));
                        AlaChallengeLiveView.this.oib.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.oil.setVisibility(8);
                        return;
                    }
                    if (j / 1000 == 0) {
                        AlaChallengeLiveView.this.oib.setData(new CountDownTextView.a((int) j, "00:00"));
                    } else {
                        AlaChallengeLiveView.this.oib.setData(new CountDownTextView.a((int) j, ((int) (j / 1000)) + ""));
                    }
                    if (j / 1000 <= 10) {
                        if (z) {
                            if (AlaChallengeLiveView.this.oim == null || !AlaChallengeLiveView.this.oim.isRunning()) {
                                AlaChallengeLiveView.this.oil.setVisibility(0);
                                AlaChallengeLiveView.this.oim = ObjectAnimator.ofFloat(AlaChallengeLiveView.this.oil, "alpha", 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                                AlaChallengeLiveView.this.oim.setRepeatMode(1);
                                AlaChallengeLiveView.this.oim.setRepeatCount(-1);
                                AlaChallengeLiveView.this.oim.setDuration(1000L);
                                AlaChallengeLiveView.this.oim.start();
                            }
                            AlaChallengeLiveView.this.oib.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_color_fa4242));
                            return;
                        }
                        AlaChallengeLiveView.this.oib.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.oil.setVisibility(8);
                        return;
                    }
                    AlaChallengeLiveView.this.oib.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaChallengeLiveView.this.oil.setVisibility(8);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        };
        this.gLs.start();
    }

    private void dYm() {
        if (this.oik != null) {
            if ("0".equals(this.oik.oiW.f5349a) && "0".equals(this.oik.oiW.f5350b)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oie.getLayoutParams();
                layoutParams.width = (int) (this.oij * 0.5f);
                this.oie.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.oif.getLayoutParams();
                layoutParams2.width = (int) (this.oij * 0.5f);
                this.oif.setLayoutParams(layoutParams2);
                return;
            }
            int parseInt = Integer.parseInt(this.oik.oiW.f5349a);
            int parseInt2 = Integer.parseInt(this.oik.oiW.f5350b);
            if (((parseInt > 0 && parseInt2 == 0) || (parseInt == 0 && parseInt2 > 0)) && !this.oix) {
                this.oix = true;
                this.oiy = System.currentTimeMillis();
                dYn();
            } else if (Math.abs(System.currentTimeMillis() - this.oiy) >= 2000) {
                dYo();
            }
        }
    }

    private void dYn() {
        this.oit.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.oip.getLayoutParams();
        layoutParams.width = (int) (this.oij * 0.5f);
        this.oip.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oiq.getLayoutParams();
        layoutParams2.width = (int) (this.oij * 0.5f);
        this.oiq.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.oir.getLayoutParams();
        layoutParams3.leftMargin = -((int) (this.oij * 0.5f));
        this.oir.setLayoutParams(layoutParams3);
        if (this.ois != null) {
            this.ois.playAnimation();
        }
        if (this.oir != null) {
            this.oir.playAnimation();
        }
        this.oiz.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.oiz, "ScaleX", 1.0f, 6.0f, 1.0f);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.oiz, "scaleY", 1.0f, 6.0f, 1.0f);
        ofFloat2.setDuration(500L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeLiveView.this.oiz.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) AlaChallengeLiveView.this.oiu.getLayoutParams();
                layoutParams4.setMargins(((int) (AlaChallengeLiveView.this.oij * 0.5f)) - AlaChallengeLiveView.this.oiw, AlaChallengeLiveView.this.oiv, 0, 0);
                AlaChallengeLiveView.this.oiu.setLayoutParams(layoutParams4);
                AlaChallengeLiveView.this.oiu.setVisibility(0);
                AlaChallengeLiveView.this.oiu.playAnimation();
                AlaChallengeLiveView.this.dYp();
                AlaChallengeLiveView.this.dYq();
                AlaChallengeLiveView.this.oiz.setVisibility(8);
                float b2 = b.b(AlaChallengeLiveView.this.oik);
                float b3 = b.b(AlaChallengeLiveView.this.oic, AlaChallengeLiveView.this.oid);
                if (b3 != b2) {
                    if (AlaChallengeLiveView.this.mValueAnimator == null || !AlaChallengeLiveView.this.mValueAnimator.isRunning()) {
                        AlaChallengeLiveView.this.mValueAnimator = ValueAnimator.ofFloat(b3, b2);
                        AlaChallengeLiveView.this.mValueAnimator.setDuration(400L);
                        AlaChallengeLiveView.this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AlaChallengeLiveView.this.bd(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                                AlaChallengeLiveView.this.oix = true;
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
        this.oiz.setVisibility(8);
        float b2 = b.b(this.oik);
        float b3 = b.b(this.oic, this.oid);
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
        } else if (this.oiu.getVisibility() != 0 || !this.oiu.isAnimating()) {
            bd(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oie.getLayoutParams();
        layoutParams.width = (int) (this.oij * f);
        this.oie.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.oif.getLayoutParams();
        layoutParams2.width = (int) (this.oij * (1.0f - f));
        this.oif.setLayoutParams(layoutParams2);
        this.oit.setVisibility(0);
        ViewGroup.LayoutParams layoutParams3 = this.oip.getLayoutParams();
        layoutParams3.width = (int) (this.oij * f);
        this.oip.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.oiq.getLayoutParams();
        layoutParams4.width = (int) (this.oij * (1.0f - f));
        this.oiq.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.oir.getLayoutParams();
        layoutParams5.leftMargin = -((int) (this.oij * f));
        this.oir.setLayoutParams(layoutParams5);
        if (this.ois != null) {
            this.ois.playAnimation();
        }
        if (this.oir != null) {
            this.oir.playAnimation();
        }
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.oiu.getLayoutParams();
        layoutParams6.setMargins(((int) (this.oij * f)) - this.oiw, this.oiv, 0, 0);
        this.oiu.setLayoutParams(layoutParams6);
        this.oiu.setVisibility(0);
        this.oiu.playAnimation();
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
            i = Integer.parseInt(this.oic.getText().toString());
            try {
                i2 = Integer.parseInt(this.oik.oiW.f5349a);
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
                    AlaChallengeLiveView.this.oic.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.oic.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.oik != null && this.oik.oiW != null) {
            this.oic.setText(this.oik.oiW.f5349a);
        } else {
            this.oic.setText("0");
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
            i = Integer.parseInt(this.oid.getText().toString());
            try {
                i2 = Integer.parseInt(this.oik.oiW.f5350b);
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
                    AlaChallengeLiveView.this.oid.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.oid.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.oik != null && this.oik.oiW != null) {
            this.oid.setText(this.oik.oiW.f5350b);
        } else {
            this.oid.setText("0");
        }
    }

    public void ccW() {
        this.oih.setVisibility(4);
        this.oii.setVisibility(4);
    }

    private void UG(String str) {
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
                this.oih.setVisibility(0);
                this.oii.setVisibility(0);
                this.oih.setImageResource(a.e.left_win_icon);
                this.oii.setImageResource(a.e.right_fail_icon);
                this.oif.setBgColor(RightLadderTextView.BgColor.GRAY);
                this.oio.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape_gray);
                this.oie.setBgColor(LeftLadderTextView.BgColor.RED);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.oie.getLayoutParams();
                layoutParams.width = (int) (this.oij * b.b(this.oik));
                this.oie.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.oif.getLayoutParams();
                layoutParams2.width = (int) (this.oij * (1.0f - b.b(this.oik)));
                this.oif.setLayoutParams(layoutParams2);
                return;
            case 1:
                this.oih.setVisibility(0);
                this.oii.setVisibility(0);
                this.oih.setImageResource(a.e.left_fail_icon);
                this.oii.setImageResource(a.e.right_win_icon);
                this.oie.setBgColor(LeftLadderTextView.BgColor.GRAY);
                this.oin.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape_gray);
                this.oif.setBgColor(RightLadderTextView.BgColor.BLUE);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.oie.getLayoutParams();
                layoutParams3.width = (int) (this.oij * b.b(this.oik));
                this.oie.setLayoutParams(layoutParams3);
                ViewGroup.LayoutParams layoutParams4 = this.oif.getLayoutParams();
                layoutParams4.width = (int) (this.oij * (1.0f - b.b(this.oik)));
                this.oif.setLayoutParams(layoutParams4);
                return;
            case 2:
                this.oih.setVisibility(0);
                this.oii.setVisibility(0);
                this.oih.setImageResource(a.e.left_pingju_icon);
                this.oii.setImageResource(a.e.right_pingju_icon);
                dYh();
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.oie.getLayoutParams();
                layoutParams5.width = (int) (this.oij * 0.5f);
                this.oie.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.oif.getLayoutParams();
                layoutParams6.width = (int) (this.oij * 0.5f);
                this.oif.setLayoutParams(layoutParams6);
                return;
            default:
                return;
        }
    }

    public void destory() {
        this.oix = false;
        this.oiy = 0L;
        this.oiB = false;
        this.oiC = false;
        bSZ();
    }
}
