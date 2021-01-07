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
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.Locale;
/* loaded from: classes4.dex */
public class PlayableLoadingView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ProgressBar f7064a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f7065b;
    private TextView c;

    public PlayableLoadingView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public PlayableLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayableLoadingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setBackgroundColor(Color.parseColor("#0D1833"));
        setClickable(true);
        setVisibility(8);
        LayoutInflater.from(context).inflate(ac.f(context, "tt_playable_loading_layout"), (ViewGroup) this, true);
        this.f7064a = (ProgressBar) findViewById(ac.e(context, "tt_playable_pb_view"));
        this.f7065b = (TextView) findViewById(ac.e(context, "tt_playable_progress_tip"));
        this.c = (TextView) findViewById(ac.e(context, "tt_playable_play"));
    }

    public void setProgress(int i) {
        int i2 = i < 0 ? 0 : i;
        int i3 = i2 <= 100 ? i2 : 100;
        if (this.f7064a != null) {
            this.f7064a.setProgress(i3);
        }
        if (this.f7065b != null) {
            this.f7065b.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i3)));
        }
    }

    public void a() {
        setVisibility(8);
    }

    public void b() {
        setVisibility(0);
    }

    public TextView getPlayView() {
        return this.c;
    }
}
