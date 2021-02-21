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
    private d pfM;
    private ImageView.ScaleType pfN;

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
        if (this.pfM == null || this.pfM.elI() == null) {
            this.pfM = new d(this);
        }
        if (this.pfN != null) {
            setScaleType(this.pfN);
            this.pfN = null;
        }
    }

    public void setPhotoViewRotation(float f) {
        this.pfM.setRotationTo(f);
    }

    public void setRotationTo(float f) {
        this.pfM.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.pfM.setRotationBy(f);
    }

    public RectF getDisplayRect() {
        return this.pfM.getDisplayRect();
    }

    public Matrix getDisplayMatrix() {
        return this.pfM.getDisplayMatrix();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.pfM.getMinimumScale();
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    public float getMediumScale() {
        return this.pfM.getMediumScale();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.pfM.getMaximumScale();
    }

    public float getScale() {
        return this.pfM.getScale();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.pfM.getScaleType();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.pfM.setAllowParentInterceptOnEdge(z);
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        this.pfM.setMinimumScale(f);
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    public void setMediumScale(float f) {
        this.pfM.setMediumScale(f);
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        this.pfM.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.pfM.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.pfM != null) {
            this.pfM.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.pfM != null) {
            this.pfM.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.pfM != null) {
            this.pfM.update();
        }
    }

    public void setOnMatrixChangeListener(d.c cVar) {
        this.pfM.setOnMatrixChangeListener(cVar);
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.pfM.setOnLongClickListener(onLongClickListener);
    }

    public void setOnPhotoTapListener(d.InterfaceC0974d interfaceC0974d) {
        this.pfM.setOnPhotoTapListener(interfaceC0974d);
    }

    public d.InterfaceC0974d getOnPhotoTapListener() {
        return this.pfM.getOnPhotoTapListener();
    }

    public void setOnViewTapListener(d.f fVar) {
        this.pfM.setOnViewTapListener(fVar);
    }

    public d.f getOnViewTapListener() {
        return this.pfM.getOnViewTapListener();
    }

    public void setScale(float f) {
        this.pfM.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.pfM.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.pfM.setScale(f, f2, f3, z);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.pfM != null) {
            this.pfM.setScaleType(scaleType);
        } else {
            this.pfN = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.pfM.setZoomable(z);
    }

    public Bitmap getVisibleRectangleBitmap() {
        return this.pfM.getVisibleRectangleBitmap();
    }

    public void setZoomTransitionDuration(int i) {
        this.pfM.setZoomTransitionDuration(i);
    }

    public c getIPhotoViewImplementation() {
        return this.pfM;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.pfM.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(d.e eVar) {
        this.pfM.setOnScaleChangeListener(eVar);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.pfM.cleanup();
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
        if (ThemeManager.emw() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawColor(2130706432);
        }
    }
}
