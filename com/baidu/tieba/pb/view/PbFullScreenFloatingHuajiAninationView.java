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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    private ImageView fJC;
    private ImageView fJD;
    private ImageView fJE;
    private ImageView fJF;
    private ImageView fJG;
    private ImageView fJH;
    private TextView fJI;
    private AnimatorSet fJJ;
    private AnimatorSet fJK;
    private AnimatorSet fJL;
    private AnimatorSet fJM;
    private AnimatorSet fJN;
    private AnimatorSet fJO;
    private AnimatorSet fJP;
    private boolean fJQ;
    private Runnable fJR;
    private Runnable fJS;
    private a fJf;
    private static final int fJB = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ah(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.fJQ = false;
        this.fJR = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bhC();
            }
        };
        this.fJS = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.fJQ = false;
        this.fJR = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bhC();
            }
        };
        this.fJS = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.fJQ = false;
        this.fJR = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bhC();
            }
        };
        this.fJS = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        LayoutInflater.from(getContext()).inflate(d.i.pb_full_screen_floating_huaji_view, this);
        this.fJC = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fJD = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fJE = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fJF = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fJG = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fJH = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fJI = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fJI.setX((SCREEN_WIDTH - fJB) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bhB();
    }

    private void bhB() {
        this.fJJ = new AnimatorSet();
        Drawable drawable = al.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fJC, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fJC, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fJJ.playTogether(ofFloat, ofFloat2);
        this.fJK = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fJD, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fJK.play(ofFloat3);
        this.fJL = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fJE, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fJL.play(ofFloat4);
        this.fJM = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fJF, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fJM.play(ofFloat5);
        this.fJN = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fJG, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fJN.play(ofFloat6);
        this.fJO = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fJH, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fJO.play(ofFloat7);
        this.fJP = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fJI, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fJI, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fJI, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fJP.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        al.j(this, d.C0141d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.BD()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        al.c(this.fJC, i3);
        al.c(this.fJD, i2);
        al.c(this.fJE, i2);
        al.c(this.fJF, i2);
        al.c(this.fJG, i2);
        al.c(this.fJH, i2);
        al.h(this.fJI, d.C0141d.cp_cont_i);
    }

    public void kU(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fJQ) {
            this.fJQ = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fJR, 2000L);
            this.fJJ.start();
            this.fJK.start();
            this.fJL.start();
            this.fJM.start();
            this.fJN.start();
            this.fJO.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhC() {
        this.fJQ = false;
        com.baidu.adp.lib.g.e.im().post(this.fJS);
        if (this.fJf != null) {
            this.fJf.onAnimationEnd();
        }
        removeCallbacks(this.fJR);
    }

    public void stopAnimation() {
        if (this.fJQ) {
            bhC();
            this.fJJ.cancel();
            this.fJK.cancel();
            this.fJL.cancel();
            this.fJM.cancel();
            this.fJN.cancel();
            this.fJO.cancel();
            this.fJP.cancel();
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
        this.fJf = aVar;
    }
}
