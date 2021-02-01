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
/* loaded from: classes11.dex */
public class PhotoView extends ImageView implements c {
    private d pfm;
    private ImageView.ScaleType pfn;

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
        if (this.pfm == null || this.pfm.elA() == null) {
            this.pfm = new d(this);
        }
        if (this.pfn != null) {
            setScaleType(this.pfn);
            this.pfn = null;
        }
    }

    public void setPhotoViewRotation(float f) {
        this.pfm.setRotationTo(f);
    }

    public void setRotationTo(float f) {
        this.pfm.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.pfm.setRotationBy(f);
    }

    public RectF getDisplayRect() {
        return this.pfm.getDisplayRect();
    }

    public Matrix getDisplayMatrix() {
        return this.pfm.getDisplayMatrix();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.pfm.getMinimumScale();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.pfm.getMediumScale();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.pfm.getMaximumScale();
    }

    public float getScale() {
        return this.pfm.getScale();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.pfm.getScaleType();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.pfm.setAllowParentInterceptOnEdge(z);
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        this.pfm.setMinimumScale(f);
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    public void setMediumScale(float f) {
        this.pfm.setMediumScale(f);
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        this.pfm.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.pfm.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.pfm != null) {
            this.pfm.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.pfm != null) {
            this.pfm.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.pfm != null) {
            this.pfm.update();
        }
    }

    public void setOnMatrixChangeListener(d.c cVar) {
        this.pfm.setOnMatrixChangeListener(cVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.pfm.setOnLongClickListener(onLongClickListener);
    }

    public void setOnPhotoTapListener(d.InterfaceC0972d interfaceC0972d) {
        this.pfm.setOnPhotoTapListener(interfaceC0972d);
    }

    public d.InterfaceC0972d getOnPhotoTapListener() {
        return this.pfm.getOnPhotoTapListener();
    }

    public void setOnViewTapListener(d.f fVar) {
        this.pfm.setOnViewTapListener(fVar);
    }

    public d.f getOnViewTapListener() {
        return this.pfm.getOnViewTapListener();
    }

    public void setScale(float f) {
        this.pfm.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.pfm.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.pfm.setScale(f, f2, f3, z);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.pfm != null) {
            this.pfm.setScaleType(scaleType);
        } else {
            this.pfn = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.pfm.setZoomable(z);
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.pfm.getVisibleRectangleBitmap();
    }

    public void setZoomTransitionDuration(int i) {
        this.pfm.setZoomTransitionDuration(i);
    }

    public c getIPhotoViewImplementation() {
        return this.pfm;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.pfm.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(d.e eVar) {
        this.pfm.setOnScaleChangeListener(eVar);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.pfm.cleanup();
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
        if (ThemeManager.emo() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawColor(2130706432);
        }
    }
}
