package com.baidu.tieba.pb.view;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.coreExtra.share.f;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class d {
    private ImageView mpj;
    private boolean fiV = false;
    private Runnable mpk = new Runnable() { // from class: com.baidu.tieba.pb.view.d.1
        @Override // java.lang.Runnable
        public void run() {
            d.this.fiV = true;
            int bzi = f.bzi();
            if (bzi > 0) {
                ViewGroup.LayoutParams layoutParams = d.this.mpj.getLayoutParams();
                int dimens = l.getDimens(d.this.mpj.getContext(), R.dimen.tbds62);
                layoutParams.height = dimens;
                layoutParams.width = dimens;
                d.this.mpj.setLayoutParams(layoutParams);
                SvgManager.bsR().a(d.this.mpj, bzi, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                if (d.this.valueAnimator != null) {
                    d.this.valueAnimator.start();
                }
            }
        }
    };
    private ValueAnimator valueAnimator = new ValueAnimator();

    public d(ImageView imageView) {
        this.mpj = imageView;
        this.valueAnimator.setDuration(4000L);
        this.valueAnimator.setFloatValues(0.0f, 1.0f);
        this.valueAnimator.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.pb.view.d.2
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                return (float) (1.075d + (0.075d * Math.sin((18.84955592153876d * f) - 1.5707963267948966d)));
            }
        });
        this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.view.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (d.this.mpj != null) {
                    d.this.mpj.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.mpj.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
    }

    public void dvE() {
        if (TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bwz()) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mpk);
            long bwA = TbSingleton.getInstance().getSharePanelConfData().bwA() * 1000;
            if (bwA <= 0) {
                bwA = IMConnection.RETRY_DELAY_TIMES;
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(this.mpk, bwA);
        }
    }

    public void setEnable(boolean z) {
        this.fiV = z;
    }

    public boolean isEnable() {
        return this.fiV;
    }

    public void onDestroy() {
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.mpk);
        if (this.valueAnimator != null) {
            this.valueAnimator.removeAllListeners();
            this.valueAnimator.removeAllUpdateListeners();
            this.valueAnimator.cancel();
        }
    }

    public void onChangeSkinType() {
        int bzi;
        if (this.fiV && TbSingleton.getInstance().getSharePanelConfData() != null && TbSingleton.getInstance().getSharePanelConfData().bwz() && (bzi = f.bzi()) > 0) {
            ViewGroup.LayoutParams layoutParams = this.mpj.getLayoutParams();
            int dimens = l.getDimens(this.mpj.getContext(), R.dimen.tbds62);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            this.mpj.setLayoutParams(layoutParams);
            SvgManager.bsR().a(this.mpj, bzi, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }
}
