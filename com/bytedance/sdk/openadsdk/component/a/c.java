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
    public ImageView f27345a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f27346b;

    /* renamed from: c  reason: collision with root package name */
    public l f27347c;

    public c(@NonNull Context context) {
        super(context);
        this.f27346b = context;
        c();
    }

    private void c() {
        ImageView imageView = new ImageView(this.f27346b);
        this.f27345a = imageView;
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f27345a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f27345a);
    }

    public l a() {
        return this.f27347c;
    }

    public void b() {
        this.f27345a.setImageBitmap(null);
        setOnClickListener(null);
        this.f27347c = null;
    }

    public void a(l lVar) {
        this.f27347c = lVar;
    }

    public void a(Bitmap bitmap) {
        this.f27345a.setImageBitmap(bitmap);
    }
}
