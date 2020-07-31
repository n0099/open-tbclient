package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.f.e;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.f;
/* loaded from: classes16.dex */
public class c {
    private ImageView kKo;
    private boolean eiE = false;
    private Runnable kKp = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.eiE = true;
            int bgQ = f.bgQ();
            if (bgQ > 0) {
                SvgManager.baR().a(c.this.kKo, bgQ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.eQt != null) {
                    c.this.eQt.start();
                }
            }
        }
    };
    private ValueAnimator eQt = new ValueAnimator();

    public c(ImageView imageView) {
        this.kKo = imageView;
        this.eQt.setDuration(4000L);
        this.eQt.setFloatValues(0.0f, 1.0f);
        this.eQt.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.eQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.kKo != null) {
                    c.this.kKo.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.kKo.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void cUD() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bej()) {
            e.lt().removeCallbacks(this.kKp);
            long bek = TbSingleton.getInstance().getSharePanelConfData().bek() * 1000;
            if (bek <= 0) {
                bek = 3000;
            }
            e.lt().postDelayed(this.kKp, bek);
        }
    }

    public void setEnable(boolean z) {
        this.eiE = z;
    }

    public boolean isEnable() {
        return this.eiE;
    }

    public void onDestroy() {
        e.lt().removeCallbacks(this.kKp);
        if (this.eQt != null) {
            this.eQt.removeAllListeners();
            this.eQt.removeAllUpdateListeners();
            this.eQt.cancel();
        }
    }

    public void onChangeSkinType() {
        int bgQ;
        if (this.eiE && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bej() && (bgQ = f.bgQ()) > 0) {
            SvgManager.baR().a(this.kKo, bgQ, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
