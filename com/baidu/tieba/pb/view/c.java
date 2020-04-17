package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.e;
/* loaded from: classes9.dex */
public class c {
    private ImageView jOx;
    private boolean dGN = false;
    private Runnable jOy = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.dGN = true;
            int aUY = e.aUY();
            if (aUY > 0) {
                SvgManager.aOU().a(c.this.jOx, aUY, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.gJT != null) {
                    c.this.gJT.start();
                }
            }
        }
    };
    private ValueAnimator gJT = new ValueAnimator();

    public c(ImageView imageView) {
        this.jOx = imageView;
        this.gJT.setDuration(4000L);
        this.gJT.setFloatValues(0.0f, 1.0f);
        this.gJT.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.gJT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.jOx != null) {
                    c.this.jOx.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.jOx.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cFj() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aSc()) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jOy);
            long aSd = TbSingleton.getInstance().getSharePanelConfData().aSd() * 1000;
            if (aSd <= 0) {
                aSd = 3000;
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(this.jOy, aSd);
        }
    }

    public void setEnable(boolean z) {
        this.dGN = z;
    }

    public boolean isEnable() {
        return this.dGN;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.jOy);
        if (this.gJT != null) {
            this.gJT.removeAllListeners();
            this.gJT.removeAllUpdateListeners();
            this.gJT.cancel();
        }
    }
}
