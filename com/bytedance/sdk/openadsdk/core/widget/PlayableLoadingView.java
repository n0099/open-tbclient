package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.Locale;
/* loaded from: classes5.dex */
public class PlayableLoadingView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ProgressBar f28502a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28503b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28504c;

    public PlayableLoadingView(@NonNull Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setBackgroundColor(Color.parseColor("#0D1833"));
        setClickable(true);
        setVisibility(8);
        LayoutInflater.from(context).inflate(ad.f(context, "tt_playable_loading_layout"), (ViewGroup) this, true);
        this.f28502a = (ProgressBar) findViewById(ad.e(context, "tt_playable_pb_view"));
        this.f28503b = (TextView) findViewById(ad.e(context, "tt_playable_progress_tip"));
        this.f28504c = (TextView) findViewById(ad.e(context, "tt_playable_play"));
    }

    public void b() {
        setVisibility(0);
    }

    public TextView getPlayView() {
        return this.f28504c;
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        ProgressBar progressBar = this.f28502a;
        if (progressBar != null) {
            progressBar.setProgress(i);
        }
        TextView textView = this.f28503b;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i)));
        }
    }

    public PlayableLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayableLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public void a() {
        setVisibility(8);
    }
}
