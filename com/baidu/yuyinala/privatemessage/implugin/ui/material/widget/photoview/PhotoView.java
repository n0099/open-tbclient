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
    private d otq;
    private ImageView.ScaleType otr;

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
        if (this.otq == null || this.otq.edv() == null) {
            this.otq = new d(this);
        }
        if (this.otr != null) {
            setScaleType(this.otr);
            this.otr = null;
        }
    }

    public void setPhotoViewRotation(float f) {
        this.otq.setRotationTo(f);
    }

    public void setRotationTo(float f) {
        this.otq.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.otq.setRotationBy(f);
    }

    public RectF getDisplayRect() {
        return this.otq.getDisplayRect();
    }

    public Matrix getDisplayMatrix() {
        return this.otq.getDisplayMatrix();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.otq.getMinimumScale();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.otq.getMediumScale();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.otq.getMaximumScale();
    }

    public float getScale() {
        return this.otq.getScale();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.otq.getScaleType();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.otq.setAllowParentInterceptOnEdge(z);
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        this.otq.setMinimumScale(f);
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    public void setMediumScale(float f) {
        this.otq.setMediumScale(f);
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        this.otq.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.otq.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.otq != null) {
            this.otq.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.otq != null) {
            this.otq.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.otq != null) {
            this.otq.update();
        }
    }

    public void setOnMatrixChangeListener(d.c cVar) {
        this.otq.setOnMatrixChangeListener(cVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.otq.setOnLongClickListener(onLongClickListener);
    }

    public void setOnPhotoTapListener(d.InterfaceC0933d interfaceC0933d) {
        this.otq.setOnPhotoTapListener(interfaceC0933d);
    }

    public d.InterfaceC0933d getOnPhotoTapListener() {
        return this.otq.getOnPhotoTapListener();
    }

    public void setOnViewTapListener(d.f fVar) {
        this.otq.setOnViewTapListener(fVar);
    }

    public d.f getOnViewTapListener() {
        return this.otq.getOnViewTapListener();
    }

    public void setScale(float f) {
        this.otq.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.otq.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.otq.setScale(f, f2, f3, z);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.otq != null) {
            this.otq.setScaleType(scaleType);
        } else {
            this.otr = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.otq.setZoomable(z);
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.otq.getVisibleRectangleBitmap();
    }

    public void setZoomTransitionDuration(int i) {
        this.otq.setZoomTransitionDuration(i);
    }

    public c getIPhotoViewImplementation() {
        return this.otq;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.otq.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(d.e eVar) {
        this.otq.setOnScaleChangeListener(eVar);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.otq.cleanup();
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
        if (ThemeManager.eel() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawColor(2130706432);
        }
    }
}
