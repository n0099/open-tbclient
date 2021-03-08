package com.baidu.tieba.qrcode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class ScanLoadingView extends LinearLayout {
    private TBLottieAnimationView mMa;

    public ScanLoadingView(Context context) {
        this(context, null);
    }

    public ScanLoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanLoadingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_scan_loading, (ViewGroup) this, true);
        this.mMa = (TBLottieAnimationView) findViewById(R.id.loading_anim);
        this.mMa.loop(true);
        this.mMa.setFrame(0);
        ap.a(this.mMa, R.raw.scan_refresh);
        ap.setViewTextColor((TextView) findViewById(R.id.loading_text), R.color.CAM_X0108, 1);
        setVisibility(8);
    }

    public void showLoading() {
        setVisibility(0);
        if (this.mMa != null) {
            if (this.mMa.isAnimating()) {
                this.mMa.cancelAnimation();
            }
            this.mMa.playAnimation();
        }
    }

    public void hideLoading() {
        if (this.mMa != null) {
            this.mMa.cancelAnimation();
        }
        setVisibility(8);
    }
}
