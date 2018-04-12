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
    private a fwI;
    private ImageView fxf;
    private ImageView fxg;
    private ImageView fxh;
    private ImageView fxi;
    private ImageView fxj;
    private ImageView fxk;
    private TextView fxl;
    private AnimatorSet fxm;
    private AnimatorSet fxn;
    private AnimatorSet fxo;
    private AnimatorSet fxp;
    private AnimatorSet fxq;
    private AnimatorSet fxr;
    private AnimatorSet fxs;
    private boolean fxt;
    private Runnable fxu;
    private static final int fxe = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds48);
    private static final int SCREEN_WIDTH = l.af(TbadkCoreApplication.getInst());

    /* loaded from: classes2.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.fxt = false;
        this.fxu = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bcC();
            }
        };
        init();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fxt = false;
        this.fxu = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bcC();
            }
        };
        init();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fxt = false;
        this.fxu = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.bcC();
            }
        };
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(d.i.pb_full_screen_floating_huaji_view, this);
        this.fxf = (ImageView) findViewById(d.g.pb_video_floating_big_huaji);
        this.fxg = (ImageView) findViewById(d.g.pb_video_floating_small_huaji1);
        this.fxh = (ImageView) findViewById(d.g.pb_video_floating_small_huaji2);
        this.fxi = (ImageView) findViewById(d.g.pb_video_floating_small_huaji3);
        this.fxj = (ImageView) findViewById(d.g.pb_video_floating_small_huaji4);
        this.fxk = (ImageView) findViewById(d.g.pb_video_floating_small_huaji5);
        this.fxl = (TextView) findViewById(d.g.pb_video_floating_huaji_tip);
        this.fxl.setX((SCREEN_WIDTH - fxe) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        bcB();
    }

    private void bcB() {
        this.fxm = new AnimatorSet();
        Drawable drawable = ak.getDrawable(d.f.icon_floor_bigpraised_floating);
        int intrinsicWidth = (SCREEN_WIDTH - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.fxf, "X", SCREEN_WIDTH, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.fxf, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.fxm.playTogether(ofFloat, ofFloat2);
        this.fxn = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.fxg, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.fxn.play(ofFloat3);
        this.fxo = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.fxh, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.fxo.play(ofFloat4);
        this.fxp = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.fxi, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.fxp.play(ofFloat5);
        this.fxq = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.fxj, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.fxq.play(ofFloat6);
        this.fxr = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.fxk, "X", SCREEN_WIDTH, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.fxr.play(ofFloat7);
        this.fxs = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.fxl, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.fxl, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.fxl, "X", SCREEN_WIDTH / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.fxs.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        ak.j(this, d.C0126d.black_alpha60);
        int i2 = d.f.icon_floor_praised_floating;
        int i3 = d.f.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.b activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.ye()) {
            i2 = d.f.icon_floor_praised_floating_xmas;
            i3 = d.f.icon_floor_bigpraised_floating_xmas;
        }
        ak.c(this.fxf, i3);
        ak.c(this.fxg, i2);
        ak.c(this.fxh, i2);
        ak.c(this.fxi, i2);
        ak.c(this.fxj, i2);
        ak.c(this.fxk, i2);
        ak.h(this.fxl, d.C0126d.cp_cont_i);
    }

    public void kN(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.fxt) {
            this.fxt = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.fxu, 2000L);
            this.fxm.start();
            this.fxn.start();
            this.fxo.start();
            this.fxp.start();
            this.fxq.start();
            this.fxr.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcC() {
        this.fxt = false;
        ViewGroup viewGroup = (ViewGroup) ((Activity) getContext()).getWindow().getDecorView();
        if (getParent() != null && getParent() == viewGroup) {
            viewGroup.removeView(this);
        }
        if (this.fwI != null) {
            this.fwI.onAnimationEnd();
        }
        removeCallbacks(this.fxu);
    }

    public void stopAnimation() {
        if (this.fxt) {
            bcC();
            this.fxm.cancel();
            this.fxn.cancel();
            this.fxo.cancel();
            this.fxp.cancel();
            this.fxq.cancel();
            this.fxr.cancel();
            this.fxs.cancel();
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
        this.fwI = aVar;
    }
}
