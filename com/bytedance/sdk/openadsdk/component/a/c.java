package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
/* loaded from: classes5.dex */
public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f28171a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f28172b;

    /* renamed from: c  reason: collision with root package name */
    public l f28173c;

    public c(@NonNull Context context) {
        super(context);
        this.f28172b = context;
        c();
    }

    private void c() {
        ImageView imageView = new ImageView(this.f28172b);
        this.f28171a = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f28171a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f28171a);
    }

    public l a() {
        return this.f28173c;
    }

    public void b() {
        this.f28171a.setImageBitmap(null);
        setOnClickListener(null);
        this.f28173c = null;
    }

    public void a(l lVar) {
        this.f28173c = lVar;
    }

    public void a(Bitmap bitmap) {
        this.f28171a.setImageBitmap(bitmap);
    }
}
