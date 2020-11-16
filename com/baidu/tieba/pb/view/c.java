package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c {
    private ImageView lRe;
    private boolean eUh = false;
    private Runnable lRf = new Runnable() { // from class: com.baidu.tieba.pb.view.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.eUh = true;
            int bwP = f.bwP();
            if (bwP > 0) {
                ViewGroup.LayoutParams layoutParams = c.this.lRe.getLayoutParams();
                int dimens = l.getDimens(c.this.lRe.getContext(), R.dimen.tbds62);
                layoutParams.height = dimens;
                layoutParams.width = dimens;
                c.this.lRe.setLayoutParams(layoutParams);
                SvgManager.bqB().a(c.this.lRe, bwP, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (c.this.fEb != null) {
                    c.this.fEb.start();
                }
            }
        }
    };
    private ValueAnimator fEb = new ValueAnimator();

    public c(ImageView imageView) {
        this.lRe = imageView;
        this.fEb.setDuration(4000L);
        this.fEb.setFloatValues(0.0f, 1.0f);
        this.fEb.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.c.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.fEb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.c.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (c.this.lRe != null) {
                    c.this.lRe.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    c.this.lRe.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void drX() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bug()) {
            e.mY().removeCallbacks(this.lRf);
            long buh = TbSingleton.getInstance().getSharePanelConfData().buh() * 1000;
            if (buh <= 0) {
                buh = IMConnection.RETRY_DELAY_TIMES;
            }
            e.mY().postDelayed(this.lRf, buh);
        }
    }

    public void setEnable(boolean z) {
        this.eUh = z;
    }

    public boolean isEnable() {
        return this.eUh;
    }

    public void onDestroy() {
        e.mY().removeCallbacks(this.lRf);
        if (this.fEb != null) {
            this.fEb.removeAllListeners();
            this.fEb.removeAllUpdateListeners();
            this.fEb.cancel();
        }
    }

    public void onChangeSkinType() {
        int bwP;
        if (this.eUh && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bug() && (bwP = f.bwP()) > 0) {
            ViewGroup.LayoutParams layoutParams = this.lRe.getLayoutParams();
            int dimens = l.getDimens(this.lRe.getContext(), R.dimen.tbds62);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            this.lRe.setLayoutParams(layoutParams);
            SvgManager.bqB().a(this.lRe, bwP, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
