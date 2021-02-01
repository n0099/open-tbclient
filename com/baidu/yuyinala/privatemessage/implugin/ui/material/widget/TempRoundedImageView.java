package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes11.dex */
public class TempRoundedImageView extends ImageView {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final ImageView.ScaleType[] peB;
    private float borderWidth;
    private float cornerRadius;
    private Drawable mBackgroundDrawable;
    private float mDensity;
    private Drawable mDrawable;
    private int mHeight;
    private Paint mPaint;
    private ImageView.ScaleType mScaleType;
    private int mWidth;
    private ColorStateList peC;
    private boolean peD;
    private boolean peE;
    private int peF;
    private boolean peG;
    private boolean peH;

    static {
        $assertionsDisabled = !TempRoundedImageView.class.desiredAssertionStatus();
        peB = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public TempRoundedImageView(Context context) {
        super(context);
        this.cornerRadius = 90.0f;
        this.borderWidth = 0.0f;
        this.peC = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.peD = false;
        this.peG = false;
        this.peE = false;
        this.peH = false;
    }

    public TempRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TempRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cornerRadius = 90.0f;
        this.borderWidth = 0.0f;
        this.peC = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.peD = false;
        this.peG = false;
        this.peE = false;
        this.peH = false;
        this.mDensity = getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(a.j.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(peB[i2]);
        } else {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(a.j.RoundedImageView_corner_radius, -1);
        this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(a.j.RoundedImageView_border_width, -1);
        if (this.cornerRadius < 0.0f) {
            this.cornerRadius = 90.0f;
        }
        if (this.borderWidth < 0.0f) {
            this.borderWidth = 0.0f;
        }
        this.peC = obtainStyledAttributes.getColorStateList(a.j.RoundedImageView_border_color);
        if (this.peC == null) {
            this.peC = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.peE = obtainStyledAttributes.getBoolean(a.j.RoundedImageView_mutate_background, false);
        this.peD = obtainStyledAttributes.getBoolean(a.j.RoundedImageView_oval, false);
        this.peG = obtainStyledAttributes.getBoolean(a.j.RoundedImageView_support_night, false);
        updateDrawableAttrs();
        AT(true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.peH) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            canvas.drawColor(1056964607);
            canvas.drawRoundRect(new RectF(this.mWidth, this.mHeight, this.mWidth, this.mHeight), this.cornerRadius, this.cornerRadius, this.mPaint);
        }
        if (this.peG && ThemeManager.emo() == ThemeManager.ThemeMode.NIGHT) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            canvas.drawColor(-1240132331);
            canvas.drawRoundRect(new RectF(this.mWidth, this.mHeight, this.mWidth, this.mHeight), this.cornerRadius, this.cornerRadius, this.mPaint);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.mWidth = size;
        } else {
            this.mWidth = (int) (this.mDensity * 70.0f);
        }
        if (mode2 == 1073741824) {
            this.mHeight = size2;
        } else {
            this.mHeight = (int) (this.mDensity * 70.0f);
        }
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!$assertionsDisabled && scaleType == null) {
            throw new AssertionError();
        }
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            updateDrawableAttrs();
            AT(false);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.TempRoundedImageView$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        static {
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.peF = 0;
        this.mDrawable = com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a.fromDrawable(drawable);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.peF = 0;
        this.mDrawable = com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a.X(bitmap);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.peF != i) {
            this.peF = i;
            this.mDrawable = elt();
            updateDrawableAttrs();
            super.setImageDrawable(this.mDrawable);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable elt() {
        Drawable drawable = null;
        Resources resources = getResources();
        if (resources == null) {
            return null;
        }
        if (this.peF != 0) {
            try {
                drawable = resources.getDrawable(this.peF);
            } catch (Exception e) {
                Log.w("TempRoundedImageView", "Unable to find resource: " + this.peF, e);
                this.peF = 0;
            }
        }
        return com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a.fromDrawable(drawable);
    }

    private void updateDrawableAttrs() {
        p(this.mDrawable);
    }

    private void AT(boolean z) {
        if (this.peE) {
            if (z) {
                this.mBackgroundDrawable = com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a.fromDrawable(this.mBackgroundDrawable);
            }
            p(this.mBackgroundDrawable);
        }
    }

    private void p(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a) {
                ((com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a) drawable).b(this.mScaleType).bx(this.cornerRadius).by(this.borderWidth).b(this.peC).AR(this.peD);
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    p(layerDrawable.getDrawable(i));
                }
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackgroundDrawable = drawable;
        AT(true);
        super.setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void setCornerRadius(int i) {
        setCornerRadius(getResources().getDimension(i));
    }

    public void setCornerRadius(float f) {
        if (this.cornerRadius != f) {
            this.cornerRadius = f;
            updateDrawableAttrs();
            AT(false);
        }
    }

    public float getBorderWidth() {
        return this.borderWidth;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.borderWidth != f) {
            this.borderWidth = f;
            updateDrawableAttrs();
            AT(false);
            invalidate();
        }
    }

    public ColorStateList getBorderColors() {
        return this.peC;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (!this.peC.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
            }
            this.peC = colorStateList;
            updateDrawableAttrs();
            AT(false);
            if (this.borderWidth > 0.0f) {
                invalidate();
            }
        }
    }

    public void setOval(boolean z) {
        this.peD = z;
        updateDrawableAttrs();
        AT(false);
        invalidate();
    }

    public void setMutateBackground(boolean z) {
        if (this.peE != z) {
            this.peE = z;
            AT(true);
            invalidate();
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        super.setPressed(z);
        this.peH = z;
    }
}
