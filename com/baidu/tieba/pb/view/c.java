package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.f.e;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes21.dex */
public class c {
    private ImageView ljd;
    private boolean euE = false;
    private Runnable lje = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.euE = true;
            int bqx = f.bqx();
            if (bqx > 0) {
                SvgManager.bkl().a(c.this.ljd, bqx, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.fdW != null) {
                    c.this.fdW.start();
                }
            }
        }
    };
    private ValueAnimator fdW = new ValueAnimator();

    public c(ImageView imageView) {
        this.ljd = imageView;
        this.fdW.setDuration(4000L);
        this.fdW.setFloatValues(0.0f, 1.0f);
        this.fdW.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.fdW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.ljd != null) {
                    c.this.ljd.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.ljd.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dje() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bnN()) {
            e.mX().removeCallbacks(this.lje);
            long bnO = TbSingleton.getInstance().getSharePanelConfData().bnO() * 1000;
            if (bnO <= 0) {
                bnO = IMConnection.RETRY_DELAY_TIMES;
            }
            e.mX().postDelayed(this.lje, bnO);
        }
    }

    public void setEnable(boolean z) {
        this.euE = z;
    }

    public boolean isEnable() {
        return this.euE;
    }

    public void onDestroy() {
        e.mX().removeCallbacks(this.lje);
        if (this.fdW != null) {
            this.fdW.removeAllListeners();
            this.fdW.removeAllUpdateListeners();
            this.fdW.cancel();
        }
    }

    public void onChangeSkinType() {
        int bqx;
        if (this.euE && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bnN() && (bqx = f.bqx()) > 0) {
            SvgManager.bkl().a(this.ljd, bqx, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
