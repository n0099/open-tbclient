package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
/* loaded from: classes6.dex */
class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f4247a;
    private final Context b;
    private l c;

    public c(@NonNull Context context) {
        super(context);
        this.b = context;
        c();
    }

    private void c() {
        this.f4247a = new ImageView(this.b);
        this.f4247a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4247a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f4247a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar) {
        this.c = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bitmap bitmap) {
        this.f4247a.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f4247a.setImageBitmap(null);
        setOnClickListener(null);
        this.c = null;
    }
}
