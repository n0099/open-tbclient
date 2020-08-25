package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.f.e;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes16.dex */
public class c {
    private ImageView lae;
    private boolean esv = false;
    private Runnable laf = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.esv = true;
            int bpC = f.bpC();
            if (bpC > 0) {
                SvgManager.bjq().a(c.this.lae, bpC, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.faZ != null) {
                    c.this.faZ.start();
                }
            }
        }
    };
    private ValueAnimator faZ = new ValueAnimator();

    public c(ImageView imageView) {
        this.lae = imageView;
        this.faZ.setDuration(4000L);
        this.faZ.setFloatValues(0.0f, 1.0f);
        this.faZ.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.faZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.lae != null) {
                    c.this.lae.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.lae.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dfA() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bmT()) {
            e.mS().removeCallbacks(this.laf);
            long bmU = TbSingleton.getInstance().getSharePanelConfData().bmU() * 1000;
            if (bmU <= 0) {
                bmU = IMConnection.RETRY_DELAY_TIMES;
            }
            e.mS().postDelayed(this.laf, bmU);
        }
    }

    public void setEnable(boolean z) {
        this.esv = z;
    }

    public boolean isEnable() {
        return this.esv;
    }

    public void onDestroy() {
        e.mS().removeCallbacks(this.laf);
        if (this.faZ != null) {
            this.faZ.removeAllListeners();
            this.faZ.removeAllUpdateListeners();
            this.faZ.cancel();
        }
    }

    public void onChangeSkinType() {
        int bpC;
        if (this.esv && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bmT() && (bpC = f.bpC()) > 0) {
            SvgManager.bjq().a(this.lae, bpC, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
