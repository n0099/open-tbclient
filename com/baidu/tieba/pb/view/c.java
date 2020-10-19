package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.f.e;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes22.dex */
public class c {
    private ImageView lyv;
    private boolean eGO = false;
    private Runnable lyw = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.eGO = true;
            int bth = f.bth();
            if (bth > 0) {
                SvgManager.bmU().a(c.this.lyv, bth, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.fqj != null) {
                    c.this.fqj.start();
                }
            }
        }
    };
    private ValueAnimator fqj = new ValueAnimator();

    public c(ImageView imageView) {
        this.lyv = imageView;
        this.fqj.setDuration(4000L);
        this.fqj.setFloatValues(0.0f, 1.0f);
        this.fqj.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.fqj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.lyv != null) {
                    c.this.lyv.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.lyv.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dmN() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bqx()) {
            e.mY().removeCallbacks(this.lyw);
            long bqy = TbSingleton.getInstance().getSharePanelConfData().bqy() * 1000;
            if (bqy <= 0) {
                bqy = IMConnection.RETRY_DELAY_TIMES;
            }
            e.mY().postDelayed(this.lyw, bqy);
        }
    }

    public void setEnable(boolean z) {
        this.eGO = z;
    }

    public boolean isEnable() {
        return this.eGO;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.lyw);
        if (this.fqj != null) {
            this.fqj.removeAllListeners();
            this.fqj.removeAllUpdateListeners();
            this.fqj.cancel();
        }
    }

    public void onChangeSkinType() {
        int bth;
        if (this.eGO && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bqx() && (bth = f.bth()) > 0) {
            SvgManager.bmU().a(this.lyv, bth, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
