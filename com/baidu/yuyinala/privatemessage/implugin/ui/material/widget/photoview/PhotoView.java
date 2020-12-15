package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.photoview.d;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes4.dex */
public class PhotoView extends ImageView implements c {
    private d oTv;
    private ImageView.ScaleType oTw;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        init();
    }

    protected void init() {
        if (this.oTv == null || this.oTv.emX() == null) {
            this.oTv = new d(this);
        }
        if (this.oTw != null) {
            setScaleType(this.oTw);
            this.oTw = null;
        }
    }

    public void setPhotoViewRotation(float f) {
        this.oTv.setRotationTo(f);
    }

    public void setRotationTo(float f) {
        this.oTv.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.oTv.setRotationBy(f);
    }

    public RectF getDisplayRect() {
        return this.oTv.getDisplayRect();
    }

    public Matrix getDisplayMatrix() {
        return this.oTv.getDisplayMatrix();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.oTv.getMinimumScale();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.oTv.getMediumScale();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.oTv.getMaximumScale();
    }

    public float getScale() {
        return this.oTv.getScale();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.oTv.getScaleType();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oTv.setAllowParentInterceptOnEdge(z);
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        this.oTv.setMinimumScale(f);
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    public void setMediumScale(float f) {
        this.oTv.setMediumScale(f);
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        this.oTv.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.oTv.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.oTv != null) {
            this.oTv.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.oTv != null) {
            this.oTv.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.oTv != null) {
            this.oTv.update();
        }
    }

    public void setOnMatrixChangeListener(d.c cVar) {
        this.oTv.setOnMatrixChangeListener(cVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.oTv.setOnLongClickListener(onLongClickListener);
    }

    public void setOnPhotoTapListener(d.InterfaceC0971d interfaceC0971d) {
        this.oTv.setOnPhotoTapListener(interfaceC0971d);
    }

    public d.InterfaceC0971d getOnPhotoTapListener() {
        return this.oTv.getOnPhotoTapListener();
    }

    public void setOnViewTapListener(d.f fVar) {
        this.oTv.setOnViewTapListener(fVar);
    }

    public d.f getOnViewTapListener() {
        return this.oTv.getOnViewTapListener();
    }

    public void setScale(float f) {
        this.oTv.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.oTv.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.oTv.setScale(f, f2, f3, z);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.oTv != null) {
            this.oTv.setScaleType(scaleType);
        } else {
            this.oTw = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.oTv.setZoomable(z);
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.oTv.getVisibleRectangleBitmap();
    }

    public void setZoomTransitionDuration(int i) {
        this.oTv.setZoomTransitionDuration(i);
    }

    public c getIPhotoViewImplementation() {
        return this.oTv;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.oTv.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(d.e eVar) {
        this.oTv.setOnScaleChangeListener(eVar);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.oTv.cleanup();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        init();
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (ThemeManager.enO() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawColor(2130706432);
        }
    }
}
