package com.baidu.tieba.pb.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class c extends RelativeLayout {
    private ImageView gcD;
    private ImageView gcE;
    private ImageView gcF;
    private ImageView gcG;
    private ImageView gcH;
    private ImageView gcI;
    private TextView gcJ;
    private AnimatorSet gcK;
    private AnimatorSet gcL;
    private AnimatorSet gcM;
    private AnimatorSet gcN;
    private AnimatorSet gcO;
    private AnimatorSet gcP;
    private AnimatorSet gcQ;
    private boolean gcR;
    private Runnable gcS;
    private a gcj;
    private static final int gcC = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ao(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.gcR = false;
        this.gcS = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.bhB();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.gcD = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.gcE = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.gcF = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.gcG = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.gcH = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.gcI = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.gcJ = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.gcJ.setX((SCREEN_WIDTH - gcC) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bhA();
    }

    private void bhA() {
        this.gcK = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gcD, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gcD, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.gcK.playTogether(ofFloat, ofFloat2);
        this.gcL = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gcE, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.gcL.play(ofFloat3);
        this.gcM = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.gcF, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.gcM.play(ofFloat4);
        this.gcN = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.gcG, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.gcN.play(ofFloat5);
        this.gcO = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.gcH, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.gcO.play(ofFloat6);
        this.gcP = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.gcI, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.gcP.play(ofFloat7);
        this.gcQ = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.gcJ, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.gcJ, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.gcJ, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.gcQ.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.t(this, d.C0141d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.Fq()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        aj.c(this.gcD, i3);
        aj.c(this.gcE, i2);
        aj.c(this.gcF, i2);
        aj.c(this.gcG, i2);
        aj.c(this.gcH, i2);
        aj.c(this.gcI, i2);
        aj.r(this.gcJ, d.C0141d.cp_cont_i);
    }

    public void ll(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.gcR) {
            this.gcR = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.gcS, 2000L);
            this.gcK.start();
            this.gcL.start();
            this.gcM.start();
            this.gcN.start();
            this.gcO.start();
            this.gcP.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhB() {
        this.gcR = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.gcj != null) {
            this.gcj.onAnimationEnd();
        }
        removeCallbacks(this.gcS);
    }

    public void stopAnimation() {
        if (this.gcR) {
            bhB();
            this.gcK.cancel();
            this.gcL.cancel();
            this.gcM.cancel();
            this.gcN.cancel();
            this.gcO.cancel();
            this.gcP.cancel();
            this.gcQ.cancel();
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
        this.gcj = aVar;
    }
}
