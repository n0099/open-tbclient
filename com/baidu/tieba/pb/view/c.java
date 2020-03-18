package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.e;
/* loaded from: classes9.dex */
public class c {
    private ImageView jeq;
    private boolean jes = false;
    private Runnable jet = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.jes = true;
            int aMB = e.aMB();
            if (aMB > 0) {
                SvgManager.aGG().a(c.this.jeq, aMB, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.jer != null) {
                    c.this.jer.start();
                }
            }
        }
    };
    private ValueAnimator jer = new ValueAnimator();

    public c(ImageView imageView) {
        this.jeq = imageView;
        this.jer.setDuration(4000L);
        this.jer.setFloatValues(0.0f, 1.0f);
        this.jer.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.jer.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jeq != null) {
                    c.this.jeq.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jeq.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cuD() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aJF()) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jet);
            long aJG = TbSingleton.getInstance().getSharePanelConfData().aJG() * 1000;
            if (aJG <= 0) {
                aJG = 3000;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jet, aJG);
        }
    }

    public void setEnable(boolean z) {
        this.jes = z;
    }

    public boolean isEnable() {
        return this.jes;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jet);
        if (this.jer != null) {
            this.jer.removeAllListeners();
            this.jer.removeAllUpdateListeners();
            this.jer.cancel();
        }
    }
}
