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
/* loaded from: classes5.dex */
public class ScanLoadingView extends LinearLayout {
    private TBLottieAnimationView iEs;

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
        this.iEs = (TBLottieAnimationView) findViewById(R.id.loading_anim);
        this.iEs.y(true);
        this.iEs.setFrame(0);
        am.a(this.iEs, (int) R.raw.scan_refresh);
        am.f((TextView) findViewById(R.id.loading_text), R.color.cp_cont_c, 1);
        setVisibility(8);
    }

    public void showLoading() {
        setVisibility(0);
        if (this.iEs != null) {
            if (this.iEs.isAnimating()) {
                this.iEs.cancelAnimation();
            }
            this.iEs.br();
        }
    }

    public void bqO() {
        if (this.iEs != null) {
            this.iEs.cancelAnimation();
        }
        setVisibility(8);
    }
}
