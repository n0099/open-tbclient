package com.baidu.tieba.pb.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    private boolean dnL;
    private a hWR;
    private Runnable hXA;
    private ImageView hXl;
    private ImageView hXm;
    private ImageView hXn;
    private ImageView hXo;
    private ImageView hXp;
    private ImageView hXq;
    private TextView hXr;
    private AnimatorSet hXs;
    private AnimatorSet hXt;
    private AnimatorSet hXu;
    private AnimatorSet hXv;
    private AnimatorSet hXw;
    private AnimatorSet hXx;
    private AnimatorSet hXy;
    private Runnable hXz;
    private Runnable mRunnable;
    private static final int hXk = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private static final int SCREEN_WIDTH = l.af(TbadkCoreApplication.getInst());

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.dnL = false;
        this.hXz = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bXo();
            }
        };
        this.hXA = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.3
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        init();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dnL = false;
        this.hXz = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bXo();
            }
        };
        this.hXA = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.3
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        init();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dnL = false;
        this.hXz = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bXo();
            }
        };
        this.hXA = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.3
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ((Activity) PbFullScreenFloatingHuajiAninationView.this.getContext()).getWindow().getDecorView();
                if (PbFullScreenFloatingHuajiAninationView.this.getParent() != null && PbFullScreenFloatingHuajiAninationView.this.getParent() == viewGroup) {
                    viewGroup.removeView(PbFullScreenFloatingHuajiAninationView.this);
                }
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.pb_full_screen_floating_huaji_view, this);
        this.hXl = (ImageView) findViewById(R.id.pb_video_floating_big_huaji);
        this.hXm = (ImageView) findViewById(R.id.pb_video_floating_small_huaji1);
        this.hXn = (ImageView) findViewById(R.id.pb_video_floating_small_huaji2);
        this.hXo = (ImageView) findViewById(R.id.pb_video_floating_small_huaji3);
        this.hXp = (ImageView) findViewById(R.id.pb_video_floating_small_huaji4);
        this.hXq = (ImageView) findViewById(R.id.pb_video_floating_small_huaji5);
        this.hXr = (TextView) findViewById(R.id.pb_video_floating_huaji_tip);
        this.hXr.setX((SCREEN_WIDTH - hXk) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bXn();
    }

    private void bXn() {
        this.hXs = new AnimatorSet();
        Drawable drawable = al.getDrawable(R.drawable.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hXl, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hXl, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.hXs.playTogether(ofFloat, ofFloat2);
        this.hXt = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hXm, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.hXt.play(ofFloat3);
        this.hXu = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hXn, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.hXu.play(ofFloat4);
        this.hXv = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hXo, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.hXv.play(ofFloat5);
        this.hXw = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hXp, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.hXw.play(ofFloat6);
        this.hXx = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hXq, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.hXx.play(ofFloat7);
        this.hXy = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.hXr, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.hXr, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.hXr, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.hXy.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        al.l(this, R.color.black_alpha60);
        int i2 = R.drawable.icon_floor_praised_floating;
        int i3 = R.drawable.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.akT()) {
            i2 = R.drawable.icon_floor_praised_floating_xmas;
            i3 = R.drawable.icon_floor_bigpraised_floating_xmas;
        }
        al.c(this.hXl, i3);
        al.c(this.hXm, i2);
        al.c(this.hXn, i2);
        al.c(this.hXo, i2);
        al.c(this.hXp, i2);
        al.c(this.hXq, i2);
        al.j(this.hXr, R.color.cp_btn_a);
    }

    public void ph(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.dnL) {
            this.dnL = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.hXz, 2000L);
            this.hXs.start();
            this.hXt.start();
            this.hXu.start();
            this.hXv.start();
            this.hXw.start();
            this.hXx.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXo() {
        this.dnL = false;
        e.iB().post(this.hXA);
        if (this.hWR != null) {
            this.hWR.onAnimationEnd();
        }
        removeCallbacks(this.hXz);
    }

    public void stopAnimation() {
        if (this.dnL) {
            bXo();
            this.hXs.cancel();
            this.hXt.cancel();
            this.hXu.cancel();
            this.hXv.cancel();
            this.hXw.cancel();
            this.hXx.cancel();
            this.hXy.cancel();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            stopAnimation();
        }
    }

    public void setFloatingHuajiAninationListener(a aVar) {
        this.hWR = aVar;
    }
}
