package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.e;
/* loaded from: classes9.dex */
public class c {
    private ImageView jcF;
    private boolean jcH = false;
    private Runnable jcI = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.jcH = true;
            int aMw = e.aMw();
            if (aMw > 0) {
                SvgManager.aGC().a(c.this.jcF, aMw, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.jcG != null) {
                    c.this.jcG.start();
                }
            }
        }
    };
    private ValueAnimator jcG = new ValueAnimator();

    public c(ImageView imageView) {
        this.jcF = imageView;
        this.jcG.setDuration(4000L);
        this.jcG.setFloatValues(0.0f, 1.0f);
        this.jcG.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.jcG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jcF != null) {
                    c.this.jcF.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jcF.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cuj() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aJA()) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcI);
            long aJB = TbSingleton.getInstance().getSharePanelConfData().aJB() * 1000;
            if (aJB <= 0) {
                aJB = 3000;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.jcI, aJB);
        }
    }

    public void setEnable(boolean z) {
        this.jcH = z;
    }

    public boolean isEnable() {
        return this.jcH;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.jcI);
        if (this.jcG != null) {
            this.jcG.removeAllListeners();
            this.jcG.removeAllUpdateListeners();
            this.jcG.cancel();
        }
    }
}
