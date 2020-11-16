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
    private d oEn;
    private ImageView.ScaleType oEo;

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
        if (this.oEn == null || this.oEn.ehi() == null) {
            this.oEn = new d(this);
        }
        if (this.oEo != null) {
            setScaleType(this.oEo);
            this.oEo = null;
        }
    }

    public void setPhotoViewRotation(float f) {
        this.oEn.setRotationTo(f);
    }

    public void setRotationTo(float f) {
        this.oEn.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.oEn.setRotationBy(f);
    }

    public RectF getDisplayRect() {
        return this.oEn.getDisplayRect();
    }

    public Matrix getDisplayMatrix() {
        return this.oEn.getDisplayMatrix();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.oEn.getMinimumScale();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.oEn.getMediumScale();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.oEn.getMaximumScale();
    }

    public float getScale() {
        return this.oEn.getScale();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.oEn.getScaleType();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oEn.setAllowParentInterceptOnEdge(z);
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        this.oEn.setMinimumScale(f);
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    public void setMediumScale(float f) {
        this.oEn.setMediumScale(f);
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        this.oEn.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.oEn.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.oEn != null) {
            this.oEn.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.oEn != null) {
            this.oEn.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.oEn != null) {
            this.oEn.update();
        }
    }

    public void setOnMatrixChangeListener(d.c cVar) {
        this.oEn.setOnMatrixChangeListener(cVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.oEn.setOnLongClickListener(onLongClickListener);
    }

    public void setOnPhotoTapListener(d.InterfaceC0954d interfaceC0954d) {
        this.oEn.setOnPhotoTapListener(interfaceC0954d);
    }

    public d.InterfaceC0954d getOnPhotoTapListener() {
        return this.oEn.getOnPhotoTapListener();
    }

    public void setOnViewTapListener(d.f fVar) {
        this.oEn.setOnViewTapListener(fVar);
    }

    public d.f getOnViewTapListener() {
        return this.oEn.getOnViewTapListener();
    }

    public void setScale(float f) {
        this.oEn.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.oEn.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.oEn.setScale(f, f2, f3, z);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.oEn != null) {
            this.oEn.setScaleType(scaleType);
        } else {
            this.oEo = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.oEn.setZoomable(z);
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.oEn.getVisibleRectangleBitmap();
    }

    public void setZoomTransitionDuration(int i) {
        this.oEn.setZoomTransitionDuration(i);
    }

    public c getIPhotoViewImplementation() {
        return this.oEn;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.oEn.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(d.e eVar) {
        this.oEn.setOnScaleChangeListener(eVar);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.oEn.cleanup();
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
        if (ThemeManager.ehY() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawColor(2130706432);
        }
    }
}
