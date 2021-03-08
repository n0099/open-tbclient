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
    private d phR;
    private ImageView.ScaleType phS;

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
        if (this.phR == null || this.phR.elS() == null) {
            this.phR = new d(this);
        }
        if (this.phS != null) {
            setScaleType(this.phS);
            this.phS = null;
        }
    }

    public void setPhotoViewRotation(float f) {
        this.phR.setRotationTo(f);
    }

    public void setRotationTo(float f) {
        this.phR.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.phR.setRotationBy(f);
    }

    public RectF getDisplayRect() {
        return this.phR.getDisplayRect();
    }

    public Matrix getDisplayMatrix() {
        return this.phR.getDisplayMatrix();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.phR.getMinimumScale();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.phR.getMediumScale();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.phR.getMaximumScale();
    }

    public float getScale() {
        return this.phR.getScale();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.phR.getScaleType();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.phR.setAllowParentInterceptOnEdge(z);
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        this.phR.setMinimumScale(f);
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    public void setMediumScale(float f) {
        this.phR.setMediumScale(f);
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        this.phR.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.phR.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.phR != null) {
            this.phR.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.phR != null) {
            this.phR.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.phR != null) {
            this.phR.update();
        }
    }

    public void setOnMatrixChangeListener(d.c cVar) {
        this.phR.setOnMatrixChangeListener(cVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.phR.setOnLongClickListener(onLongClickListener);
    }

    public void setOnPhotoTapListener(d.InterfaceC0980d interfaceC0980d) {
        this.phR.setOnPhotoTapListener(interfaceC0980d);
    }

    public d.InterfaceC0980d getOnPhotoTapListener() {
        return this.phR.getOnPhotoTapListener();
    }

    public void setOnViewTapListener(d.f fVar) {
        this.phR.setOnViewTapListener(fVar);
    }

    public d.f getOnViewTapListener() {
        return this.phR.getOnViewTapListener();
    }

    public void setScale(float f) {
        this.phR.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.phR.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.phR.setScale(f, f2, f3, z);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.phR != null) {
            this.phR.setScaleType(scaleType);
        } else {
            this.phS = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.phR.setZoomable(z);
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.phR.getVisibleRectangleBitmap();
    }

    public void setZoomTransitionDuration(int i) {
        this.phR.setZoomTransitionDuration(i);
    }

    public c getIPhotoViewImplementation() {
        return this.phR;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.phR.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(d.e eVar) {
        this.phR.setOnScaleChangeListener(eVar);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.phR.cleanup();
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
        if (ThemeManager.emG() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawColor(2130706432);
        }
    }
}
