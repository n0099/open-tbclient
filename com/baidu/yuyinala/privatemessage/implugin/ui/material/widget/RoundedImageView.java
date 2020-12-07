package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes4.dex */
public class RoundedImageView extends ImageView {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final ImageView.ScaleType[] oSI;
    private float cornerRadius;
    private float dfR;
    private Drawable mBackgroundDrawable;
    private Drawable mDrawable;
    private Paint mPaint;
    private ImageView.ScaleType mScaleType;
    private ColorStateList oSJ;
    private boolean oSK;
    private boolean oSL;
    private int oSM;

    static {
        $assertionsDisabled = !RoundedImageView.class.desiredAssertionStatus();
        oSI = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public RoundedImageView(Context context) {
        super(context);
        this.cornerRadius = 90.0f;
        this.dfR = 0.0f;
        this.oSJ = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.oSK = false;
        this.oSL = false;
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cornerRadius = 90.0f;
        this.dfR = 0.0f;
        this.oSJ = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        this.oSK = false;
        this.oSL = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(a.j.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(oSI[i2]);
        } else {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(1342177280);
        this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(a.j.RoundedImageView_corner_radius, -1);
        this.dfR = obtainStyledAttributes.getDimensionPixelSize(a.j.RoundedImageView_border_width, -1);
        if (this.cornerRadius < 0.0f) {
            this.cornerRadius = 90.0f;
        }
        if (this.dfR < 0.0f) {
            this.dfR = 0.0f;
        }
        this.oSJ = obtainStyledAttributes.getColorStateList(a.j.RoundedImageView_border_color);
        if (ThemeManager.enN() == ThemeManager.ThemeMode.NIGHT) {
            this.oSJ = ColorStateList.valueOf(8351342);
        } else if (this.oSJ == null) {
            this.oSJ = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
        }
        this.oSL = obtainStyledAttributes.getBoolean(a.j.RoundedImageView_mutate_background, false);
        this.oSK = obtainStyledAttributes.getBoolean(a.j.RoundedImageView_oval, false);
        updateDrawableAttrs();
        AE(true);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (ThemeManager.enN() == ThemeManager.ThemeMode.NIGHT) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.mPaint);
        }
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
            AE(false);
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.RoundedImageView$1  reason: invalid class name */
    /* loaded from: classes4.dex */
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
        this.oSM = 0;
        this.mDrawable = com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a.fromDrawable(drawable);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.oSM = 0;
        this.mDrawable = com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a.Z(bitmap);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.oSM != i) {
            this.oSM = i;
            this.mDrawable = emP();
            updateDrawableAttrs();
            super.setImageDrawable(this.mDrawable);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable emP() {
        Drawable drawable = null;
        Resources resources = getResources();
        if (resources == null) {
            return null;
        }
        if (this.oSM != 0) {
            try {
                drawable = resources.getDrawable(this.oSM);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.oSM, e);
                this.oSM = 0;
            }
        }
        return com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a.fromDrawable(drawable);
    }

    private void updateDrawableAttrs() {
        k(this.mDrawable);
    }

    private void AE(boolean z) {
        if (this.oSL) {
            if (z) {
                this.mBackgroundDrawable = com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a.fromDrawable(this.mBackgroundDrawable);
            }
            k(this.mBackgroundDrawable);
        }
    }

    private void k(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a) {
                ((com.baidu.yuyinala.privatemessage.implugin.ui.material.b.a) drawable).b(this.mScaleType).bj(this.cornerRadius).bk(this.dfR).b(this.oSJ).AC(this.oSK).AD(true);
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    k(layerDrawable.getDrawable(i));
                }
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackgroundDrawable = drawable;
        AE(true);
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
            AE(false);
        }
    }

    public float getBorderWidth() {
        return this.dfR;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.dfR != f) {
            this.dfR = f;
            updateDrawableAttrs();
            AE(false);
            invalidate();
        }
    }

    public ColorStateList getBorderColors() {
        return this.oSJ;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (!this.oSJ.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK);
            }
            this.oSJ = colorStateList;
            updateDrawableAttrs();
            AE(false);
            if (this.dfR > 0.0f) {
                invalidate();
            }
        }
    }

    public void setOval(boolean z) {
        this.oSK = z;
        updateDrawableAttrs();
        AE(false);
        invalidate();
    }

    public void setMutateBackground(boolean z) {
        if (this.oSL != z) {
            this.oSL = z;
            AE(true);
            invalidate();
        }
    }
}
