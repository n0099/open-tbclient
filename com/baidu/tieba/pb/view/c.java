package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.e;
/* loaded from: classes9.dex */
public class c {
    private ImageView kBm;
    private boolean ecu = false;
    private Runnable kBn = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.ecu = true;
            int bdj = e.bdj();
            if (bdj > 0) {
                SvgManager.aWQ().a(c.this.kBm, bdj, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.eJX != null) {
                    c.this.eJX.start();
                }
            }
        }
    };
    private ValueAnimator eJX = new ValueAnimator();

    public c(ImageView imageView) {
        this.kBm = imageView;
        this.eJX.setDuration(4000L);
        this.eJX.setFloatValues(0.0f, 1.0f);
        this.eJX.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.eJX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.kBm != null) {
                    c.this.kBm.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.kBm.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cQN() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bam()) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kBn);
            long ban = TbSingleton.getInstance().getSharePanelConfData().ban() * 1000;
            if (ban <= 0) {
                ban = 3000;
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(this.kBn, ban);
        }
    }

    public void setEnable(boolean z) {
        this.ecu = z;
    }

    public boolean isEnable() {
        return this.ecu;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.kBn);
        if (this.eJX != null) {
            this.eJX.removeAllListeners();
            this.eJX.removeAllUpdateListeners();
            this.eJX.cancel();
        }
    }

    public void onChangeSkinType() {
        int bdj;
        if (this.ecu && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bam() && (bdj = e.bdj()) > 0) {
            SvgManager.aWQ().a(this.kBm, bdj, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
