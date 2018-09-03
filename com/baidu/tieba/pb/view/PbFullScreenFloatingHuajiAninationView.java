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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    private boolean bza;
    private ImageView fNH;
    private ImageView fNI;
    private ImageView fNJ;
    private ImageView fNK;
    private ImageView fNL;
    private ImageView fNM;
    private TextView fNN;
    private AnimatorSet fNO;
    private AnimatorSet fNP;
    private AnimatorSet fNQ;
    private AnimatorSet fNR;
    private AnimatorSet fNS;
    private AnimatorSet fNT;
    private AnimatorSet fNU;
    private Runnable fNV;
    private Runnable fNW;
    private a fNp;
    private Runnable mRunnable;
    private static final int fNG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.ds48);
    private static final int SCREEN_WIDTH = l.ah(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.bza = false;
        this.fNV = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bgw();
            }
        };
        this.fNW = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.bza = false;
        this.fNV = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bgw();
            }
        };
        this.fNW = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.bza = false;
        this.fNV = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bgw();
            }
        };
        this.fNW = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        LayoutInflater.from(getContext()).inflate(f.h.pb_full_screen_floating_huaji_view, this);
        this.fNH = (ImageView) findViewById(f.g.pb_video_floating_big_huaji);
        this.fNI = (ImageView) findViewById(f.g.pb_video_floating_small_huaji1);
        this.fNJ = (ImageView) findViewById(f.g.pb_video_floating_small_huaji2);
        this.fNK = (ImageView) findViewById(f.g.pb_video_floating_small_huaji3);
        this.fNL = (ImageView) findViewById(f.g.pb_video_floating_small_huaji4);
        this.fNM = (ImageView) findViewById(f.g.pb_video_floating_small_huaji5);
        this.fNN = (TextView) findViewById(f.g.pb_video_floating_huaji_tip);
        this.fNN.setX((SCREEN_WIDTH - fNG) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bgv();
    }

    private void bgv() {
        this.fNO = new AnimatorSet();
        Drawable drawable = am.getDrawable(f.C0146f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fNH, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fNH, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fNO.playTogether(ofFloat, ofFloat2);
        this.fNP = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fNI, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fNP.play(ofFloat3);
        this.fNQ = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fNJ, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fNQ.play(ofFloat4);
        this.fNR = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fNK, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fNR.play(ofFloat5);
        this.fNS = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fNL, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fNS.play(ofFloat6);
        this.fNT = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fNM, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fNT.play(ofFloat7);
        this.fNU = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fNN, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fNN, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fNN, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fNU.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        am.j(this, f.d.black_alpha60);
        int i2 = f.C0146f.icon_floor_praised_floating;
        int i3 = f.C0146f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.BJ()) {
            i2 = f.C0146f.icon_floor_praised_floating_xmas;
            i3 = f.C0146f.icon_floor_bigpraised_floating_xmas;
        }
        am.c(this.fNH, i3);
        am.c(this.fNI, i2);
        am.c(this.fNJ, i2);
        am.c(this.fNK, i2);
        am.c(this.fNL, i2);
        am.c(this.fNM, i2);
        am.h(this.fNN, f.d.cp_cont_i);
    }

    public void kQ(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.bza) {
            this.bza = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fNV, 2000L);
            this.fNO.start();
            this.fNP.start();
            this.fNQ.start();
            this.fNR.start();
            this.fNS.start();
            this.fNT.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bgw() {
        this.bza = false;
        com.baidu.adp.lib.g.e.in().post(this.fNW);
        if (this.fNp != null) {
            this.fNp.onAnimationEnd();
        }
        removeCallbacks(this.fNV);
    }

    public void stopAnimation() {
        if (this.bza) {
            bgw();
            this.fNO.cancel();
            this.fNP.cancel();
            this.fNQ.cancel();
            this.fNR.cancel();
            this.fNS.cancel();
            this.fNT.cancel();
            this.fNU.cancel();
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
        this.fNp = aVar;
    }
}
