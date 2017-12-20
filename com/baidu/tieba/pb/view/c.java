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
/* loaded from: classes.dex */
public class c extends RelativeLayout {
    private ImageView fkK;
    private ImageView fkL;
    private ImageView fkM;
    private ImageView fkN;
    private ImageView fkO;
    private ImageView fkP;
    private TextView fkQ;
    private AnimatorSet fkR;
    private AnimatorSet fkS;
    private AnimatorSet fkT;
    private AnimatorSet fkU;
    private AnimatorSet fkV;
    private AnimatorSet fkW;
    private AnimatorSet fkX;
    private boolean fkY;
    private Runnable fkZ;
    private a fkq;
    private static final int fkJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.ac(TbadkCoreApplication.getInst());

    /* loaded from: classes.dex */
    public interface a {
        void onAnimationEnd();
    }

    public c(Context context) {
        super(context);
        this.fkY = false;
        this.fkZ = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.aYF();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.h.pb_full_screen_floating_huaji_view, this);
        this.fkK = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fkL = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fkM = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fkN = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fkO = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fkP = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fkQ = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fkQ.setX((SCREEN_WIDTH - fkJ) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        aYE();
    }

    private void aYE() {
        this.fkR = new AnimatorSet();
        Drawable drawable = aj.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fkK, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fkK, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fkR.playTogether(ofFloat, ofFloat2);
        this.fkS = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fkL, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fkS.play(ofFloat3);
        this.fkT = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fkM, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fkT.play(ofFloat4);
        this.fkU = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fkN, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fkU.play(ofFloat5);
        this.fkV = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fkO, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fkV.play(ofFloat6);
        this.fkW = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fkP, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fkW.play(ofFloat7);
        this.fkX = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fkQ, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fkQ, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fkQ, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fkX.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        aj.k(this, d.C0096d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.xE()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        aj.c(this.fkK, i3);
        aj.c(this.fkL, i2);
        aj.c(this.fkM, i2);
        aj.c(this.fkN, i2);
        aj.c(this.fkO, i2);
        aj.c(this.fkP, i2);
        aj.i(this.fkQ, d.C0096d.cp_cont_i);
    }

    public void kv(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fkY) {
            this.fkY = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fkZ, 2000L);
            this.fkR.start();
            this.fkS.start();
            this.fkT.start();
            this.fkU.start();
            this.fkV.start();
            this.fkW.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYF() {
        this.fkY = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fkq != null) {
            this.fkq.onAnimationEnd();
        }
        removeCallbacks(this.fkZ);
    }

    public void stopAnimation() {
        if (this.fkY) {
            aYF();
            this.fkR.cancel();
            this.fkS.cancel();
            this.fkT.cancel();
            this.fkU.cancel();
            this.fkV.cancel();
            this.fkW.cancel();
            this.fkX.cancel();
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
        this.fkq = aVar;
    }
}
