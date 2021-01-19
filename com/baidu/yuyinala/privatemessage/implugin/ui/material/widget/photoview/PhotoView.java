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
/* loaded from: classes10.dex */
public class PhotoView extends ImageView implements c {
    private d oUZ;
    private ImageView.ScaleType oVa;

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
        if (this.oUZ == null || this.oUZ.ejg() == null) {
            this.oUZ = new d(this);
        }
        if (this.oVa != null) {
            setScaleType(this.oVa);
            this.oVa = null;
        }
    }

    public void setPhotoViewRotation(float f) {
        this.oUZ.setRotationTo(f);
    }

    public void setRotationTo(float f) {
        this.oUZ.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.oUZ.setRotationBy(f);
    }

    public RectF getDisplayRect() {
        return this.oUZ.getDisplayRect();
    }

    public Matrix getDisplayMatrix() {
        return this.oUZ.getDisplayMatrix();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.oUZ.getMinimumScale();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.oUZ.getMediumScale();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.oUZ.getMaximumScale();
    }

    public float getScale() {
        return this.oUZ.getScale();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.oUZ.getScaleType();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oUZ.setAllowParentInterceptOnEdge(z);
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        this.oUZ.setMinimumScale(f);
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    public void setMediumScale(float f) {
        this.oUZ.setMediumScale(f);
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        this.oUZ.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.oUZ.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.oUZ != null) {
            this.oUZ.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.oUZ != null) {
            this.oUZ.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.oUZ != null) {
            this.oUZ.update();
        }
    }

    public void setOnMatrixChangeListener(d.c cVar) {
        this.oUZ.setOnMatrixChangeListener(cVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.oUZ.setOnLongClickListener(onLongClickListener);
    }

    public void setOnPhotoTapListener(d.InterfaceC0968d interfaceC0968d) {
        this.oUZ.setOnPhotoTapListener(interfaceC0968d);
    }

    public d.InterfaceC0968d getOnPhotoTapListener() {
        return this.oUZ.getOnPhotoTapListener();
    }

    public void setOnViewTapListener(d.f fVar) {
        this.oUZ.setOnViewTapListener(fVar);
    }

    public d.f getOnViewTapListener() {
        return this.oUZ.getOnViewTapListener();
    }

    public void setScale(float f) {
        this.oUZ.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.oUZ.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.oUZ.setScale(f, f2, f3, z);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.oUZ != null) {
            this.oUZ.setScaleType(scaleType);
        } else {
            this.oVa = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.oUZ.setZoomable(z);
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.oUZ.getVisibleRectangleBitmap();
    }

    public void setZoomTransitionDuration(int i) {
        this.oUZ.setZoomTransitionDuration(i);
    }

    public c getIPhotoViewImplementation() {
        return this.oUZ;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.oUZ.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(d.e eVar) {
        this.oUZ.setOnScaleChangeListener(eVar);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.oUZ.cleanup();
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
        if (ThemeManager.ejW() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawColor(2130706432);
        }
    }
}
