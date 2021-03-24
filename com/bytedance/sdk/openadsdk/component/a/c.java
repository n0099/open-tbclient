package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
/* loaded from: classes6.dex */
public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f27650a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f27651b;

    /* renamed from: c  reason: collision with root package name */
    public l f27652c;

    public c(@NonNull Context context) {
        super(context);
        this.f27651b = context;
        c();
    }

    private void c() {
        ImageView imageView = new ImageView(this.f27651b);
        this.f27650a = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f27650a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f27650a);
    }

    public l a() {
        return this.f27652c;
    }

    public void b() {
        this.f27650a.setImageBitmap(null);
        setOnClickListener(null);
        this.f27652c = null;
    }

    public void a(l lVar) {
        this.f27652c = lVar;
    }

    public void a(Bitmap bitmap) {
        this.f27650a.setImageBitmap(bitmap);
    }
}
