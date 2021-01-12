package com.bytedance.sdk.openadsdk.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.l;
/* loaded from: classes4.dex */
class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f6270a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6271b;
    private l c;

    public c(@NonNull Context context) {
        super(context);
        this.f6271b = context;
        c();
    }

    private void c() {
        this.f6270a = new ImageView(this.f6271b);
        this.f6270a.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f6270a.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f6270a);
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
        this.f6270a.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f6270a.setImageBitmap(null);
        setOnClickListener(null);
        this.c = null;
    }
}
