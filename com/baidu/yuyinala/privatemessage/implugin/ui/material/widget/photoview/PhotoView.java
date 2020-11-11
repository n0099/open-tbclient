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
    private d oCJ;
    private ImageView.ScaleType oCK;

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
        if (this.oCJ == null || this.oCJ.ehk() == null) {
            this.oCJ = new d(this);
        }
        if (this.oCK != null) {
            setScaleType(this.oCK);
            this.oCK = null;
        }
    }

    public void setPhotoViewRotation(float f) {
        this.oCJ.setRotationTo(f);
    }

    public void setRotationTo(float f) {
        this.oCJ.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.oCJ.setRotationBy(f);
    }

    public RectF getDisplayRect() {
        return this.oCJ.getDisplayRect();
    }

    public Matrix getDisplayMatrix() {
        return this.oCJ.getDisplayMatrix();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.oCJ.getMinimumScale();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.oCJ.getMediumScale();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.oCJ.getMaximumScale();
    }

    public float getScale() {
        return this.oCJ.getScale();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.oCJ.getScaleType();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.oCJ.setAllowParentInterceptOnEdge(z);
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        this.oCJ.setMinimumScale(f);
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    public void setMediumScale(float f) {
        this.oCJ.setMediumScale(f);
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        this.oCJ.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.oCJ.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.oCJ != null) {
            this.oCJ.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.oCJ != null) {
            this.oCJ.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.oCJ != null) {
            this.oCJ.update();
        }
    }

    public void setOnMatrixChangeListener(d.c cVar) {
        this.oCJ.setOnMatrixChangeListener(cVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.oCJ.setOnLongClickListener(onLongClickListener);
    }

    public void setOnPhotoTapListener(d.InterfaceC0951d interfaceC0951d) {
        this.oCJ.setOnPhotoTapListener(interfaceC0951d);
    }

    public d.InterfaceC0951d getOnPhotoTapListener() {
        return this.oCJ.getOnPhotoTapListener();
    }

    public void setOnViewTapListener(d.f fVar) {
        this.oCJ.setOnViewTapListener(fVar);
    }

    public d.f getOnViewTapListener() {
        return this.oCJ.getOnViewTapListener();
    }

    public void setScale(float f) {
        this.oCJ.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.oCJ.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.oCJ.setScale(f, f2, f3, z);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.oCJ != null) {
            this.oCJ.setScaleType(scaleType);
        } else {
            this.oCK = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.oCJ.setZoomable(z);
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.oCJ.getVisibleRectangleBitmap();
    }

    public void setZoomTransitionDuration(int i) {
        this.oCJ.setZoomTransitionDuration(i);
    }

    public c getIPhotoViewImplementation() {
        return this.oCJ;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.oCJ.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(d.e eVar) {
        this.oCJ.setOnScaleChangeListener(eVar);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.oCJ.cleanup();
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
        if (ThemeManager.eia() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawColor(2130706432);
        }
    }
}
