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
/* loaded from: classes6.dex */
public class PlayableLoadingView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ProgressBar f28743a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28744b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28745c;

    public PlayableLoadingView(@NonNull Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setBackgroundColor(Color.parseColor("#0D1833"));
        setClickable(true);
        setVisibility(8);
        LayoutInflater.from(context).inflate(ad.f(context, "tt_playable_loading_layout"), (ViewGroup) this, true);
        this.f28743a = (ProgressBar) findViewById(ad.e(context, "tt_playable_pb_view"));
        this.f28744b = (TextView) findViewById(ad.e(context, "tt_playable_progress_tip"));
        this.f28745c = (TextView) findViewById(ad.e(context, "tt_playable_play"));
    }

    public void b() {
        setVisibility(0);
    }

    public TextView getPlayView() {
        return this.f28745c;
    }

    public void setProgress(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 100) {
            i2 = 100;
        }
        ProgressBar progressBar = this.f28743a;
        if (progressBar != null) {
            progressBar.setProgress(i2);
        }
        TextView textView = this.f28744b;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i2)));
        }
    }

    public PlayableLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayableLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public void a() {
        setVisibility(8);
    }
}
