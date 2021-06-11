package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
@RequiresApi(api = 14)
@TargetApi(14)
/* loaded from: classes6.dex */
public class SSRenderTextureView extends TextureView implements TextureView.SurfaceTextureListener, b {

    /* renamed from: a  reason: collision with root package name */
    public a f28610a;

    /* renamed from: b  reason: collision with root package name */
    public b.a f28611b;

    public SSRenderTextureView(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(a aVar) {
        this.f28610a = aVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        a aVar = this.f28610a;
        if (aVar != null) {
            aVar.a(surfaceTexture, i2, i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        a aVar = this.f28610a;
        return aVar != null && aVar.a(surfaceTexture);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        a aVar = this.f28610a;
        if (aVar != null) {
            aVar.b(surfaceTexture, i2, i3);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        a aVar = this.f28610a;
        if (aVar != null) {
            aVar.b(surfaceTexture);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        b.a aVar = this.f28611b;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.f28611b = aVar;
    }

    public SSRenderTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i3;
        layoutParams.width = i2;
        setLayoutParams(layoutParams);
    }
}
