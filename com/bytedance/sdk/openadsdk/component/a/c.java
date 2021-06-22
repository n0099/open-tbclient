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
    public ImageView f27530a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f27531b;

    /* renamed from: c  reason: collision with root package name */
    public l f27532c;

    public c(@NonNull Context context) {
        super(context);
        this.f27531b = context;
        c();
    }

    private void c() {
        ImageView imageView = new ImageView(this.f27531b);
        this.f27530a = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f27530a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f27530a);
    }

    public l a() {
        return this.f27532c;
    }

    public void b() {
        this.f27530a.setImageBitmap(null);
        setOnClickListener(null);
        this.f27532c = null;
    }

    public void a(l lVar) {
        this.f27532c = lVar;
    }

    public void a(Bitmap bitmap) {
        this.f27530a.setImageBitmap(bitmap);
    }
}
