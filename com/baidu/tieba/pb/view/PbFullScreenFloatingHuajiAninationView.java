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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    private a fxL;
    private ImageView fyi;
    private ImageView fyj;
    private ImageView fyk;
    private ImageView fyl;
    private ImageView fym;
    private ImageView fyn;
    private TextView fyo;
    private AnimatorSet fyp;
    private AnimatorSet fyq;
    private AnimatorSet fyr;
    private AnimatorSet fys;
    private AnimatorSet fyt;
    private AnimatorSet fyu;
    private AnimatorSet fyv;
    private boolean fyw;
    private Runnable fyx;
    private static final int fyh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.af(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.fyw = false;
        this.fyx = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bcC();
            }
        };
        init();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fyw = false;
        this.fyx = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bcC();
            }
        };
        init();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fyw = false;
        this.fyx = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bcC();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.pb_full_screen_floating_huaji_view, this);
        this.fyi = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fyj = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fyk = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fyl = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fym = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fyn = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fyo = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fyo.setX((SCREEN_WIDTH - fyh) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bcB();
    }

    private void bcB() {
        this.fyp = new AnimatorSet();
        Drawable drawable = ak.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fyi, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fyi, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fyp.playTogether(ofFloat, ofFloat2);
        this.fyq = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fyj, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fyq.play(ofFloat3);
        this.fyr = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fyk, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fyr.play(ofFloat4);
        this.fys = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fyl, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fys.play(ofFloat5);
        this.fyt = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fym, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fyt.play(ofFloat6);
        this.fyu = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fyn, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fyu.play(ofFloat7);
        this.fyv = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fyo, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fyo, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fyo, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fyv.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        ak.j(this, d.C0126d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.yd()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        ak.c(this.fyi, i3);
        ak.c(this.fyj, i2);
        ak.c(this.fyk, i2);
        ak.c(this.fyl, i2);
        ak.c(this.fym, i2);
        ak.c(this.fyn, i2);
        ak.h(this.fyo, d.C0126d.cp_cont_i);
    }

    public void kO(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fyw) {
            this.fyw = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fyx, 2000L);
            this.fyp.start();
            this.fyq.start();
            this.fyr.start();
            this.fys.start();
            this.fyt.start();
            this.fyu.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcC() {
        this.fyw = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fxL != null) {
            this.fxL.onAnimationEnd();
        }
        removeCallbacks(this.fyx);
    }

    public void stopAnimation() {
        if (this.fyw) {
            bcC();
            this.fyp.cancel();
            this.fyq.cancel();
            this.fyr.cancel();
            this.fys.cancel();
            this.fyt.cancel();
            this.fyu.cancel();
            this.fyv.cancel();
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
        this.fxL = aVar;
    }
}
