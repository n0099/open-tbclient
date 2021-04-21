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
    public ImageView f27344a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f27345b;

    /* renamed from: c  reason: collision with root package name */
    public l f27346c;

    public c(@NonNull Context context) {
        super(context);
        this.f27345b = context;
        c();
    }

    private void c() {
        ImageView imageView = new ImageView(this.f27345b);
        this.f27344a = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f27344a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f27344a);
    }

    public l a() {
        return this.f27346c;
    }

    public void b() {
        this.f27344a.setImageBitmap(null);
        setOnClickListener(null);
        this.f27346c = null;
    }

    public void a(l lVar) {
        this.f27346c = lVar;
    }

    public void a(Bitmap bitmap) {
        this.f27344a.setImageBitmap(bitmap);
    }
}
