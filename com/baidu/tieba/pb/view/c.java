package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.e;
/* loaded from: classes9.dex */
public class c {
    private ImageView khz;
    private boolean dVd = false;
    private Runnable khA = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.dVd = true;
            int bbh = e.bbh();
            if (bbh > 0) {
                SvgManager.aUW().a(c.this.khz, bbh, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.gYW != null) {
                    c.this.gYW.start();
                }
            }
        }
    };
    private ValueAnimator gYW = new ValueAnimator();

    public c(ImageView imageView) {
        this.khz = imageView;
        this.gYW.setDuration(4000L);
        this.gYW.setFloatValues(0.0f, 1.0f);
        this.gYW.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.gYW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.khz != null) {
                    c.this.khz.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.khz.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cMv() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aYh()) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(this.khA);
            long aYi = TbSingleton.getInstance().getSharePanelConfData().aYi() * 1000;
            if (aYi <= 0) {
                aYi = 3000;
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(this.khA, aYi);
        }
    }

    public void setEnable(boolean z) {
        this.dVd = z;
    }

    public boolean isEnable() {
        return this.dVd;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.khA);
        if (this.gYW != null) {
            this.gYW.removeAllListeners();
            this.gYW.removeAllUpdateListeners();
            this.gYW.cancel();
        }
    }

    public void onChangeSkinType() {
        int bbh;
        if (this.dVd && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().aYh() && (bbh = e.bbh()) > 0) {
            SvgManager.aUW().a(this.khz, bbh, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
