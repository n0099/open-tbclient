package com.baidu.tieba.qrcode.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class ScanLoadingView extends LinearLayout {
    private TBLottieAnimationView jwV;

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
        this.jwV = (TBLottieAnimationView) findViewById(R.id.loading_anim);
        this.jwV.loop(true);
        this.jwV.setFrame(0);
        am.a(this.jwV, R.raw.scan_refresh);
        am.setViewTextColor((TextView) findViewById(R.id.loading_text), R.color.cp_cont_c, 1);
        setVisibility(8);
    }

    public void showLoading() {
        setVisibility(0);
        if (this.jwV != null) {
            if (this.jwV.isAnimating()) {
                this.jwV.cancelAnimation();
            }
            this.jwV.playAnimation();
        }
    }

    public void hideLoading() {
        if (this.jwV != null) {
            this.jwV.cancelAnimation();
        }
        setVisibility(8);
    }
}
