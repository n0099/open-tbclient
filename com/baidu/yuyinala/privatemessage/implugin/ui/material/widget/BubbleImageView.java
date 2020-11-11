package com.baidu.yuyinala.privatemessage.implugin.ui.material.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes4.dex */
public class BubbleImageView extends ImageView {
    private static final Bitmap.Config oBJ = Bitmap.Config.ARGB_8888;
    private Paint fnh;
    private int mAngle;
    private int mArrowHeight;
    private int mArrowWidth;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private Matrix mShaderMatrix;
    private int oBK;
    private int oBL;
    private int oBM;
    private Rect oBN;

    public BubbleImageView(Context context) {
        super(context);
        this.mAngle = vF(10);
        this.oBK = vF(40);
        this.mArrowWidth = vF(20);
        this.mArrowHeight = vF(20);
        this.oBL = 0;
        this.oBM = 0;
        i((AttributeSet) null);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAngle = vF(10);
        this.oBK = vF(40);
        this.mArrowWidth = vF(20);
        this.mArrowHeight = vF(20);
        this.oBL = 0;
        this.oBM = 0;
        i(attributeSet);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAngle = vF(10);
        this.oBK = vF(40);
        this.mArrowWidth = vF(20);
        this.mArrowHeight = vF(20);
        this.oBL = 0;
        this.oBM = 0;
        i(attributeSet);
    }

    private void i(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.BubbleImageView);
            this.mAngle = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_angle, this.mAngle);
            this.mArrowHeight = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_arrowHeight, this.mArrowHeight);
            this.oBL = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_arrowOffset, this.oBL);
            this.oBK = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_arrowTop, this.oBK);
            this.mArrowWidth = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_arrowWidth, this.mAngle);
            this.oBM = obtainStyledAttributes.getInt(a.j.BubbleImageView_bubble_arrowLocation, this.oBM);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), (getRight() - getLeft()) - getPaddingRight(), (getBottom() - getTop()) - getPaddingBottom());
            Path path = new Path();
            a(rectF, path);
            canvas.drawPath(path, this.mBitmapPaint);
            canvas.drawPath(path, this.fnh);
            try {
                if (ThemeManager.eia() == ThemeManager.ThemeMode.NIGHT) {
                    Paint paint = new Paint();
                    paint.setColor(1342177280);
                    canvas.drawPath(path, paint);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(RectF rectF, Path path) {
        path.moveTo(this.mAngle, rectF.top);
        path.lineTo(rectF.width() - this.mAngle, rectF.top);
        path.arcTo(new RectF(rectF.right - (this.mAngle * 2), rectF.top, rectF.right, (this.mAngle * 2) + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.height() - this.mAngle);
        path.arcTo(new RectF(rectF.right - (this.mAngle * 2), rectF.bottom - (this.mAngle * 2), rectF.right, rectF.bottom), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.mAngle, rectF.bottom);
        path.arcTo(new RectF(rectF.left, rectF.bottom - (this.mAngle * 2), (this.mAngle * 2) + rectF.left, rectF.bottom), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.mAngle);
        path.arcTo(new RectF(rectF.left, rectF.top, (this.mAngle * 2) + rectF.left, (this.mAngle * 2) + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        setup();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.mBitmap = bitmap;
        setup();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.mBitmap = i(drawable);
        setup();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.mBitmap = i(getDrawable());
        setup();
    }

    private Bitmap i(Drawable drawable) {
        Bitmap createBitmap;
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(1, 1, oBJ);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), oBJ);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            bitmap = createBitmap;
            return bitmap;
        } catch (OutOfMemoryError e) {
            return bitmap;
        }
    }

    private int getLineColor() {
        return 0;
    }

    private void setup() {
        if (this.mBitmap != null) {
            this.mBitmapShader = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.mBitmapPaint = new Paint();
            this.mBitmapPaint.setAntiAlias(true);
            this.mBitmapPaint.setShader(this.mBitmapShader);
            this.fnh = new Paint();
            this.fnh.setColor(getLineColor());
            this.fnh.setStrokeWidth(1.0f);
            this.fnh.setStyle(Paint.Style.STROKE);
            this.fnh.setAntiAlias(true);
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            updateShaderMatrix();
            invalidate();
        }
    }

    private void updateShaderMatrix() {
        float width;
        float f;
        float f2 = 0.0f;
        this.mShaderMatrix = new Matrix();
        this.mShaderMatrix.set(null);
        this.oBN = new Rect(0, 0, getRight() - getLeft(), getBottom() - getTop());
        if (this.mBitmapWidth * this.oBN.height() > this.oBN.width() * this.mBitmapHeight) {
            width = this.oBN.height() / this.mBitmapHeight;
            f = (this.oBN.width() - (this.mBitmapWidth * width)) * 0.5f;
        } else {
            width = this.oBN.width() / this.mBitmapWidth;
            f = 0.0f;
            f2 = (this.oBN.height() - (this.mBitmapHeight * width)) * 0.5f;
        }
        this.mShaderMatrix.setScale(width, width);
        this.mShaderMatrix.postTranslate((int) (f + 0.5f), (int) (f2 + 0.5f));
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }

    private int vF(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }
}
