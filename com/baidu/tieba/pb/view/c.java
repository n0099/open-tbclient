package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.e;
/* loaded from: classes9.dex */
public class c {
    private ImageView jcD;
    private boolean jcF = false;
    private Runnable jcG = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.jcF = true;
            int aMu = e.aMu();
            if (aMu > 0) {
                SvgManager.aGA().a(c.this.jcD, aMu, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.jcE != null) {
                    c.this.jcE.start();
                }
            }
        }
    };
    private ValueAnimator jcE = new ValueAnimator();

    public c(ImageView imageView) {
        this.jcD = imageView;
        this.jcE.setDuration(4000L);
        this.jcE.setFloatValues(0.0f, 1.0f);
        this.jcE.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.jcE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jcD != null) {
                    c.this.jcD.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jcD.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cuh() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aJy()) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcG);
            long aJz = TbSingleton.getInstance().getSharePanelConfData().aJz() * 1000;
            if (aJz <= 0) {
                aJz = 3000;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jcG, aJz);
        }
    }

    public void setEnable(boolean z) {
        this.jcF = z;
    }

    public boolean isEnable() {
        return this.jcF;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcG);
        if (this.jcE != null) {
            this.jcE.removeAllListeners();
            this.jcE.removeAllUpdateListeners();
            this.jcE.cancel();
        }
    }
}
