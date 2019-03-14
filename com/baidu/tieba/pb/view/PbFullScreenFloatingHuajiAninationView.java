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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    private boolean ddd;
    private TextView hFA;
    private AnimatorSet hFB;
    private AnimatorSet hFC;
    private AnimatorSet hFD;
    private AnimatorSet hFE;
    private AnimatorSet hFF;
    private AnimatorSet hFG;
    private AnimatorSet hFH;
    private Runnable hFI;
    private Runnable hFJ;
    private a hFa;
    private ImageView hFu;
    private ImageView hFv;
    private ImageView hFw;
    private ImageView hFx;
    private ImageView hFy;
    private ImageView hFz;
    private Runnable mRunnable;
    private static final int hFt = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.aO(TbadkCoreApplication.getInst());

    /* loaded from: classes4.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.ddd = false;
        this.hFI = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bPu();
            }
        };
        this.hFJ = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.ddd = false;
        this.hFI = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bPu();
            }
        };
        this.hFJ = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.ddd = false;
        this.hFI = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bPu();
            }
        };
        this.hFJ = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.hFu = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.hFv = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.hFw = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.hFx = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.hFy = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.hFz = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.hFA = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.hFA.setX((SCREEN_WIDTH - hFt) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bPt();
    }

    private void bPt() {
        this.hFB = new AnimatorSet();
        Drawable drawable = al.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hFu, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hFu, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.hFB.playTogether(ofFloat, ofFloat2);
        this.hFC = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hFv, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.hFC.play(ofFloat3);
        this.hFD = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hFw, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.hFD.play(ofFloat4);
        this.hFE = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hFx, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.hFE.play(ofFloat5);
        this.hFF = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hFy, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.hFF.play(ofFloat6);
        this.hFG = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hFz, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.hFG.play(ofFloat7);
        this.hFH = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.hFA, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.hFA, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.hFA, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.hFH.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        al.l(this, d.C0277d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.afX()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        al.c(this.hFu, i3);
        al.c(this.hFv, i2);
        al.c(this.hFw, i2);
        al.c(this.hFx, i2);
        al.c(this.hFy, i2);
        al.c(this.hFz, i2);
        al.j(this.hFA, d.C0277d.cp_btn_a);
    }

    public void or(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.ddd) {
            this.ddd = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.hFI, 2000L);
            this.hFB.start();
            this.hFC.start();
            this.hFD.start();
            this.hFE.start();
            this.hFF.start();
            this.hFG.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPu() {
        this.ddd = false;
        e.jH().post(this.hFJ);
        if (this.hFa != null) {
            this.hFa.onAnimationEnd();
        }
        removeCallbacks(this.hFI);
    }

    public void stopAnimation() {
        if (this.ddd) {
            bPu();
            this.hFB.cancel();
            this.hFC.cancel();
            this.hFD.cancel();
            this.hFE.cancel();
            this.hFF.cancel();
            this.hFG.cancel();
            this.hFH.cancel();
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
        this.hFa = aVar;
    }
}
