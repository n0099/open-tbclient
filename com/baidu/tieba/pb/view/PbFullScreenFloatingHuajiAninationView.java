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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PbFullScreenFloatingHuajiAninationView extends RelativeLayout {
    private a kUX;
    private Runnable kZA;
    private ImageView kZl;
    private ImageView kZm;
    private ImageView kZn;
    private ImageView kZo;
    private ImageView kZp;
    private ImageView kZq;
    private TextView kZr;
    private AnimatorSet kZs;
    private AnimatorSet kZt;
    private AnimatorSet kZu;
    private AnimatorSet kZv;
    private AnimatorSet kZw;
    private AnimatorSet kZx;
    private AnimatorSet kZy;
    private Runnable kZz;
    private boolean mIsAnimating;
    private Runnable mRunnable;
    private static final int fCg = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds48);
    private static final int ahA = l.getEquipmentWidth(TbadkCoreApplication.getInst());

    /* loaded from: classes16.dex */
    public interface a {
        void onAnimationEnd();
    }

    public PbFullScreenFloatingHuajiAninationView(Context context) {
        super(context);
        this.mIsAnimating = false;
        this.kZz = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.dfz();
            }
        };
        this.kZA = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.mIsAnimating = false;
        this.kZz = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.dfz();
            }
        };
        this.kZA = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.mIsAnimating = false;
        this.kZz = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.1
            @Override // java.lang.Runnable
            public void run() {
                PbFullScreenFloatingHuajiAninationView.this.dfz();
            }
        };
        this.kZA = new Runnable() { // from class: com.baidu.tieba.pb.view.PbFullScreenFloatingHuajiAninationView.2
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
        this.kZl = (ImageView) findViewById(R.id.pb_video_floating_big_huaji);
        this.kZm = (ImageView) findViewById(R.id.pb_video_floating_small_huaji1);
        this.kZn = (ImageView) findViewById(R.id.pb_video_floating_small_huaji2);
        this.kZo = (ImageView) findViewById(R.id.pb_video_floating_small_huaji3);
        this.kZp = (ImageView) findViewById(R.id.pb_video_floating_small_huaji4);
        this.kZq = (ImageView) findViewById(R.id.pb_video_floating_small_huaji5);
        this.kZr = (TextView) findViewById(R.id.pb_video_floating_huaji_tip);
        this.kZr.setX((ahA - fCg) / 2);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        dfy();
    }

    private void dfy() {
        this.kZs = new AnimatorSet();
        Drawable drawable = ap.getDrawable(R.drawable.icon_floor_bigpraised_floating);
        int intrinsicWidth = (ahA - drawable.getIntrinsicWidth()) / 2;
        int intrinsicWidth2 = 0 - drawable.getIntrinsicWidth();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.kZl, "X", ahA, intrinsicWidth);
        ofFloat.setDuration(400L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.kZl, "X", intrinsicWidth, intrinsicWidth2);
        ofFloat2.setDuration(500L);
        ofFloat2.setStartDelay(1000L);
        this.kZs.playTogether(ofFloat, ofFloat2);
        this.kZt = new AnimatorSet();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.kZm, "X", ahA, intrinsicWidth2);
        ofFloat3.setDuration(600L);
        ofFloat3.setStartDelay(800L);
        this.kZt.play(ofFloat3);
        this.kZu = new AnimatorSet();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.kZn, "X", ahA, intrinsicWidth2);
        ofFloat4.setDuration(600L);
        ofFloat4.setStartDelay(800L);
        this.kZu.play(ofFloat4);
        this.kZv = new AnimatorSet();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.kZo, "X", ahA, intrinsicWidth2);
        ofFloat5.setDuration(300L);
        ofFloat5.setStartDelay(1100L);
        this.kZv.play(ofFloat5);
        this.kZw = new AnimatorSet();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.kZp, "X", ahA, intrinsicWidth2);
        ofFloat6.setDuration(200L);
        ofFloat6.setStartDelay(1200L);
        this.kZw.play(ofFloat6);
        this.kZx = new AnimatorSet();
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.kZq, "X", ahA, intrinsicWidth2);
        ofFloat7.setDuration(150L);
        ofFloat7.setStartDelay(1400L);
        this.kZx.play(ofFloat7);
        this.kZy = new AnimatorSet();
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.kZr, "scaleX", 0.0f, 2.0f, 1.0f);
        ofFloat8.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.kZr, "scaleY", 0.0f, 2.0f, 1.0f);
        ofFloat9.setDuration(500L);
        ofFloat8.setStartDelay(400L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.kZr, "X", ahA / 2, intrinsicWidth2);
        ofFloat10.setDuration(300L);
        ofFloat10.setStartDelay(700L);
        this.kZy.playTogether(ofFloat8, ofFloat9, ofFloat10);
    }

    public void onChangeSkinType(int i) {
        ap.setBackgroundColor(this, R.color.black_alpha60);
        int i2 = R.drawable.icon_floor_praised_floating;
        int i3 = R.drawable.icon_floor_bigpraised_floating;
        com.baidu.tbadk.coreExtra.data.c activitySwitch = TbadkCoreApplication.getInst().getActivitySwitch();
        if (activitySwitch != null && activitySwitch.bmp()) {
            i2 = R.drawable.icon_floor_praised_floating_xmas;
            i3 = R.drawable.icon_floor_bigpraised_floating_xmas;
        }
        ap.setImageResource(this.kZl, i3);
        ap.setImageResource(this.kZm, i2);
        ap.setImageResource(this.kZn, i2);
        ap.setImageResource(this.kZo, i2);
        ap.setImageResource(this.kZp, i2);
        ap.setImageResource(this.kZq, i2);
        ap.setViewTextColor(this.kZr, R.color.cp_cont_a);
    }

    public void uo(boolean z) {
        if (UtilHelper.getRealScreenOrientation(getContext()) != 2 && !this.mIsAnimating) {
            this.mIsAnimating = true;
            ((ViewGroup) ((Activity) getContext()).getWindow().getDecorView()).addView(this);
            postDelayed(this.kZz, 2000L);
            this.kZs.start();
            this.kZt.start();
            this.kZu.start();
            this.kZv.start();
            this.kZw.start();
            this.kZx.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dfz() {
        this.mIsAnimating = false;
        e.mS().post(this.kZA);
        if (this.kUX != null) {
            this.kUX.onAnimationEnd();
        }
        removeCallbacks(this.kZz);
    }

    public void stopAnimation() {
        if (this.mIsAnimating) {
            dfz();
            this.kZs.cancel();
            this.kZt.cancel();
            this.kZu.cancel();
            this.kZv.cancel();
            this.kZw.cancel();
            this.kZx.cancel();
            this.kZy.cancel();
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
        this.kUX = aVar;
    }
}
