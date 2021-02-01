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
    private CountDownTimer gNY;
    private RelativeLayout hdI;
    private Context mContext;
    private ValueAnimator mValueAnimator;
    private CountDownTextView orU;
    private TextView orV;
    private TextView orW;
    private LeftLadderTextView orX;
    private RightLadderTextView orY;
    private int orZ;
    private ImageView osa;
    private ImageView osb;
    private int osc;
    private c osd;
    private View ose;
    private ObjectAnimator osf;
    private View osg;
    private View osh;
    private LinearLayout osi;
    private LinearLayout osj;
    private LottieAnimationView osk;
    private LottieAnimationView osl;
    private FrameLayout osm;
    private LottieAnimationView osn;
    private int oso;
    private int osp;
    private boolean osq;
    private long osr;
    private ImageView oss;
    private RelativeLayout ost;
    private boolean osu;
    private boolean osv;
    private RelativeLayout rootView;

    public AlaChallengeLiveView(Context context) {
        super(context);
        this.osq = false;
        this.osr = 0L;
        this.osu = false;
        this.osv = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.osq = false;
        this.osr = 0L;
        this.osu = false;
        this.osv = false;
        init(context);
    }

    public AlaChallengeLiveView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.osq = false;
        this.osr = 0L;
        this.osu = false;
        this.osv = false;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        this.rootView = (RelativeLayout) View.inflate(context, a.g.ala_audio_challenge_panel_optation_view, this);
        this.osc = BdUtilHelper.getScreenSize((Activity) getContext()).widthPixels - BdUtilHelper.dip2px(getContext(), 54.0f);
        this.oso = BdUtilHelper.dip2px(getContext(), 10.0f);
        this.osp = BdUtilHelper.dip2px(getContext(), 22.0f);
        this.hdI = (RelativeLayout) this.rootView.findViewById(a.f.root_container);
        this.ost = (RelativeLayout) this.rootView.findViewById(a.f.pk_score_progress_layout);
        this.orU = (CountDownTextView) this.rootView.findViewById(a.f.pk_time_label);
        this.orU.setData(new CountDownTextView.a(0, "00:00"));
        this.ose = this.rootView.findViewById(a.f.view_shake);
        this.osg = this.rootView.findViewById(a.f.view_left_shape);
        this.osh = this.rootView.findViewById(a.f.view_right_shape);
        this.osa = (ImageView) this.rootView.findViewById(a.f.left_state);
        this.osb = (ImageView) this.rootView.findViewById(a.f.right_state);
        this.osn = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_center);
        this.osm = (FrameLayout) this.rootView.findViewById(a.f.ll_loading);
        this.osi = (LinearLayout) this.rootView.findViewById(a.f.ll_left_loading);
        this.osl = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_left);
        this.osj = (LinearLayout) this.rootView.findViewById(a.f.ll_right_loading);
        this.osk = (LottieAnimationView) this.rootView.findViewById(a.f.anim_view_right);
        this.orV = (TextView) this.rootView.findViewById(a.f.pk_left_progress);
        this.orW = (TextView) this.rootView.findViewById(a.f.pk_right_progress);
        this.orX = (LeftLadderTextView) this.rootView.findViewById(a.f.left_progress_bg);
        this.orY = (RightLadderTextView) this.rootView.findViewById(a.f.right_progress_bg);
        this.oss = (ImageView) this.rootView.findViewById(a.f.img_view_center);
        this.osn.setImageAssetsFolder("lottie_team_fight_images/");
        this.osn.setAnimation("anim_view_center.json");
        this.osn.loop(true);
        ViewGroup.LayoutParams layoutParams = this.osl.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = this.osc;
        }
        this.osl.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.osk.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = this.osc;
        }
        this.osk.setLayoutParams(layoutParams2);
        this.osm.setVisibility(4);
        if (this.osl != null) {
            this.osl.cancelAnimation();
        }
        if (this.osk != null) {
            this.osk.cancelAnimation();
        }
        this.osn.setVisibility(4);
        if (this.osn != null) {
            this.osn.cancelAnimation();
        }
        eau();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.orX.getLayoutParams();
        layoutParams3.width = (int) (this.osc * 0.5f);
        this.orX.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.orY.getLayoutParams();
        layoutParams4.width = (int) (this.osc * 0.5f);
        this.orY.setLayoutParams(layoutParams4);
    }

    public void b(c cVar) {
        if (cVar != null) {
            if (this.osd != null) {
                this.osu = cVar.osM != this.osd.osM;
                this.osv = cVar.activity_stage != this.osd.activity_stage;
            }
            this.osd = cVar;
            this.orZ = cVar.activity_stage;
            eat();
        }
    }

    private void eat() {
        switch (this.orZ) {
            case 0:
                eay();
                return;
            case 1:
                eax();
                return;
            case 2:
                eaw();
                return;
            case 3:
                eav();
                return;
            default:
                return;
        }
    }

    public void eau() {
        this.orX.setBgColor(LeftLadderTextView.BgColor.RED);
        this.osg.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape);
        this.orY.setBgColor(RightLadderTextView.BgColor.BLUE);
        this.osh.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape);
    }

    private void eav() {
        this.oss.setVisibility(8);
        this.osq = false;
        this.osr = 0L;
        if (this.osd != null) {
            VE(this.osd.osO);
            this.orV.setText(this.osd.osP.f5351a);
            this.orW.setText(this.osd.osP.f5352b);
        }
        this.ost.setBackgroundResource(a.e.yuyin_punish_icon);
        this.ose.setVisibility(8);
        this.orU.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        zS(false);
        if (this.osf != null) {
            this.osf.cancel();
        }
        this.osm.setVisibility(4);
        if (this.osl != null) {
            this.osl.cancelAnimation();
        }
        if (this.osk != null) {
            this.osk.cancelAnimation();
        }
        this.osn.setVisibility(4);
        if (this.osn != null) {
            this.osn.cancelAnimation();
        }
    }

    private void eaw() {
        cdR();
        eau();
        this.ost.setBackgroundResource(a.e.yuyin_statistics_icon);
        this.orU.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.orU.setData(new CountDownTextView.a(0, "00:00"));
        bTC();
        this.ose.setVisibility(8);
        if (this.osf != null) {
            this.osf.cancel();
        }
        if (this.osd != null && this.osd.osP != null) {
            eaz();
        }
    }

    private void bTC() {
        if (this.gNY != null) {
            this.gNY.cancel();
        }
    }

    private void eax() {
        this.ost.setBackgroundResource(a.e.yuyin_pking_icon);
        cdR();
        eau();
        if (this.osd != null) {
            if (this.osd.osP != null) {
                eaz();
            }
            zS(true);
        }
    }

    private void eay() {
        cdR();
        this.oss.setVisibility(8);
        this.osq = false;
        this.osr = 0L;
        this.ost.setBackgroundResource(a.e.yuyin_prepare_icon);
        this.orU.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.orU.setData(new CountDownTextView.a(0, "00:00"));
        bTC();
        this.orV.setText("0");
        this.orW.setText("0");
        eau();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.orX.getLayoutParams();
        layoutParams.width = (int) (this.osc * 0.5f);
        this.orX.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.orY.getLayoutParams();
        layoutParams2.width = (int) (this.osc * 0.5f);
        this.orY.setLayoutParams(layoutParams2);
        this.ose.setVisibility(4);
        if (this.osf != null) {
            this.osf.cancel();
        }
        this.osm.setVisibility(4);
        if (this.osl != null) {
            this.osl.cancelAnimation();
        }
        if (this.osk != null) {
            this.osk.cancelAnimation();
        }
        this.osn.setVisibility(4);
        if (this.osn != null) {
            this.osn.cancelAnimation();
        }
    }

    private void zS(boolean z) {
        boolean z2 = true;
        if (this.osd != null) {
            int i = this.osd.osQ;
            int i2 = i / 1000;
            boolean z3 = this.osd.osR == 1;
            int i3 = this.osd.osS;
            if (this.orU.getData() == null || Math.abs(this.orU.getData().osA - i) <= i3) {
                z2 = false;
            }
            if (this.orU.getData() == null || "00:00".equals(this.orU.getData().osB)) {
                bTC();
                n(i, i2, z);
            } else if (this.osv || this.osu) {
                bTC();
                n(i, i2, z);
            } else if (z3 && z2) {
                bTC();
                n(i, i2, z);
            }
        }
    }

    private void n(int i, int i2, final boolean z) {
        this.orU.setData(new CountDownTextView.a(i, b.LR(i2)));
        this.gNY = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.1
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (AlaChallengeLiveView.this.orU != null) {
                    if (j > AppStatusRules.DEFAULT_GRANULARITY) {
                        AlaChallengeLiveView.this.orU.setData(new CountDownTextView.a((int) j, b.LR((int) (j / 1000))));
                        AlaChallengeLiveView.this.orU.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.ose.setVisibility(8);
                        return;
                    }
                    if (j / 1000 == 0) {
                        AlaChallengeLiveView.this.orU.setData(new CountDownTextView.a((int) j, "00:00"));
                    } else {
                        AlaChallengeLiveView.this.orU.setData(new CountDownTextView.a((int) j, ((int) (j / 1000)) + ""));
                    }
                    if (j / 1000 <= 10) {
                        if (z) {
                            if (AlaChallengeLiveView.this.osf == null || !AlaChallengeLiveView.this.osf.isRunning()) {
                                AlaChallengeLiveView.this.ose.setVisibility(0);
                                AlaChallengeLiveView.this.osf = ObjectAnimator.ofFloat(AlaChallengeLiveView.this.ose, "alpha", 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                                AlaChallengeLiveView.this.osf.setRepeatMode(1);
                                AlaChallengeLiveView.this.osf.setRepeatCount(-1);
                                AlaChallengeLiveView.this.osf.setDuration(1000L);
                                AlaChallengeLiveView.this.osf.start();
                            }
                            AlaChallengeLiveView.this.orU.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_color_fa4242));
                            return;
                        }
                        AlaChallengeLiveView.this.orU.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                        AlaChallengeLiveView.this.ose.setVisibility(8);
                        return;
                    }
                    AlaChallengeLiveView.this.orU.setTextColor(AlaChallengeLiveView.this.getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaChallengeLiveView.this.ose.setVisibility(8);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        };
        this.gNY.start();
    }

    private void eaz() {
        if (this.osd != null) {
            if ("0".equals(this.osd.osP.f5351a) && "0".equals(this.osd.osP.f5352b)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.orX.getLayoutParams();
                layoutParams.width = (int) (this.osc * 0.5f);
                this.orX.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.orY.getLayoutParams();
                layoutParams2.width = (int) (this.osc * 0.5f);
                this.orY.setLayoutParams(layoutParams2);
                return;
            }
            int parseInt = Integer.parseInt(this.osd.osP.f5351a);
            int parseInt2 = Integer.parseInt(this.osd.osP.f5352b);
            if (((parseInt > 0 && parseInt2 == 0) || (parseInt == 0 && parseInt2 > 0)) && !this.osq) {
                this.osq = true;
                this.osr = System.currentTimeMillis();
                eaA();
            } else if (Math.abs(System.currentTimeMillis() - this.osr) >= 2000) {
                eaB();
            }
        }
    }

    private void eaA() {
        this.osm.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.osi.getLayoutParams();
        layoutParams.width = (int) (this.osc * 0.5f);
        this.osi.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.osj.getLayoutParams();
        layoutParams2.width = (int) (this.osc * 0.5f);
        this.osj.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.osk.getLayoutParams();
        layoutParams3.leftMargin = -((int) (this.osc * 0.5f));
        this.osk.setLayoutParams(layoutParams3);
        if (this.osl != null) {
            this.osl.playAnimation();
        }
        if (this.osk != null) {
            this.osk.playAnimation();
        }
        this.oss.setVisibility(0);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.oss, "ScaleX", 1.0f, 6.0f, 1.0f);
        ofFloat.setDuration(500L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.oss, "scaleY", 1.0f, 6.0f, 1.0f);
        ofFloat2.setDuration(500L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaChallengeLiveView.this.oss.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) AlaChallengeLiveView.this.osn.getLayoutParams();
                layoutParams4.setMargins(((int) (AlaChallengeLiveView.this.osc * 0.5f)) - AlaChallengeLiveView.this.osp, AlaChallengeLiveView.this.oso, 0, 0);
                AlaChallengeLiveView.this.osn.setLayoutParams(layoutParams4);
                AlaChallengeLiveView.this.osn.setVisibility(0);
                AlaChallengeLiveView.this.osn.playAnimation();
                AlaChallengeLiveView.this.eaC();
                AlaChallengeLiveView.this.eaD();
                AlaChallengeLiveView.this.oss.setVisibility(8);
                float a2 = a.a(AlaChallengeLiveView.this.osd);
                float b2 = a.b(AlaChallengeLiveView.this.orV, AlaChallengeLiveView.this.orW);
                if (b2 != a2) {
                    if (AlaChallengeLiveView.this.mValueAnimator == null || !AlaChallengeLiveView.this.mValueAnimator.isRunning()) {
                        AlaChallengeLiveView.this.mValueAnimator = ValueAnimator.ofFloat(b2, a2);
                        AlaChallengeLiveView.this.mValueAnimator.setDuration(400L);
                        AlaChallengeLiveView.this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.2.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                AlaChallengeLiveView.this.bg(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                                AlaChallengeLiveView.this.osq = true;
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

    private void eaB() {
        eaC();
        eaD();
        this.oss.setVisibility(8);
        float a2 = a.a(this.osd);
        float b2 = a.b(this.orV, this.orW);
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
        } else if (this.osn.getVisibility() != 0 || !this.osn.isAnimating()) {
            bg(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(float f) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.orX.getLayoutParams();
        layoutParams.width = (int) (this.osc * f);
        this.orX.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.orY.getLayoutParams();
        layoutParams2.width = (int) (this.osc * (1.0f - f));
        this.orY.setLayoutParams(layoutParams2);
        this.osm.setVisibility(0);
        ViewGroup.LayoutParams layoutParams3 = this.osi.getLayoutParams();
        layoutParams3.width = (int) (this.osc * f);
        this.osi.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.osj.getLayoutParams();
        layoutParams4.width = (int) (this.osc * (1.0f - f));
        this.osj.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.osk.getLayoutParams();
        layoutParams5.leftMargin = -((int) (this.osc * f));
        this.osk.setLayoutParams(layoutParams5);
        if (this.osl != null) {
            this.osl.playAnimation();
        }
        if (this.osk != null) {
            this.osk.playAnimation();
        }
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.osn.getLayoutParams();
        layoutParams6.setMargins(((int) (this.osc * f)) - this.osp, this.oso, 0, 0);
        this.osn.setLayoutParams(layoutParams6);
        this.osn.setVisibility(0);
        this.osn.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eaC() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.orV.getText().toString());
            try {
                i2 = Integer.parseInt(this.osd.osP.f5351a);
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
                    AlaChallengeLiveView.this.orV.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.5
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.orV.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.osd != null && this.osd.osP != null) {
            this.orV.setText(this.osd.osP.f5351a);
        } else {
            this.orV.setText("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eaD() {
        int i;
        int i2;
        try {
            i = Integer.parseInt(this.orW.getText().toString());
            try {
                i2 = Integer.parseInt(this.osd.osP.f5352b);
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
                    AlaChallengeLiveView.this.orW.setText(valueAnimator.getAnimatedValue().toString());
                }
            });
            ValueAnimator ofInt2 = ValueAnimator.ofInt(14, 24, 24, 14);
            ofInt2.setDuration(1000L);
            ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.liveroom.alaaudiopk.AlaChallengeLiveView.7
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AlaChallengeLiveView.this.orW.setTextSize(Float.parseFloat(valueAnimator.getAnimatedValue().toString()));
                }
            });
            animatorSet.playTogether(ofInt, ofInt2);
            animatorSet.start();
        } else if (this.osd != null && this.osd.osP != null) {
            this.orW.setText(this.osd.osP.f5352b);
        } else {
            this.orW.setText("0");
        }
    }

    public void cdR() {
        this.osa.setVisibility(4);
        this.osb.setVisibility(4);
    }

    private void VE(String str) {
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
                this.osa.setVisibility(0);
                this.osb.setVisibility(0);
                this.osa.setImageResource(a.e.left_win_icon);
                this.osb.setImageResource(a.e.right_fail_icon);
                this.orY.setBgColor(RightLadderTextView.BgColor.GRAY);
                this.osh.setBackgroundResource(a.e.ala_audio_challenge_score_right_bg_shape_gray);
                this.orX.setBgColor(LeftLadderTextView.BgColor.RED);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.orX.getLayoutParams();
                layoutParams.width = (int) (this.osc * a.a(this.osd));
                this.orX.setLayoutParams(layoutParams);
                ViewGroup.LayoutParams layoutParams2 = this.orY.getLayoutParams();
                layoutParams2.width = (int) (this.osc * (1.0f - a.a(this.osd)));
                this.orY.setLayoutParams(layoutParams2);
                return;
            case 1:
                this.osa.setVisibility(0);
                this.osb.setVisibility(0);
                this.osa.setImageResource(a.e.left_fail_icon);
                this.osb.setImageResource(a.e.right_win_icon);
                this.orX.setBgColor(LeftLadderTextView.BgColor.GRAY);
                this.osg.setBackgroundResource(a.e.ala_audio_challenge_score_left_bg_shape_gray);
                this.orY.setBgColor(RightLadderTextView.BgColor.BLUE);
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.orX.getLayoutParams();
                layoutParams3.width = (int) (this.osc * a.a(this.osd));
                this.orX.setLayoutParams(layoutParams3);
                ViewGroup.LayoutParams layoutParams4 = this.orY.getLayoutParams();
                layoutParams4.width = (int) (this.osc * (1.0f - a.a(this.osd)));
                this.orY.setLayoutParams(layoutParams4);
                return;
            case 2:
                this.osa.setVisibility(0);
                this.osb.setVisibility(0);
                this.osa.setImageResource(a.e.left_pingju_icon);
                this.osb.setImageResource(a.e.right_pingju_icon);
                eau();
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.orX.getLayoutParams();
                layoutParams5.width = (int) (this.osc * 0.5f);
                this.orX.setLayoutParams(layoutParams5);
                ViewGroup.LayoutParams layoutParams6 = this.orY.getLayoutParams();
                layoutParams6.width = (int) (this.osc * 0.5f);
                this.orY.setLayoutParams(layoutParams6);
                return;
            default:
                return;
        }
    }
}
