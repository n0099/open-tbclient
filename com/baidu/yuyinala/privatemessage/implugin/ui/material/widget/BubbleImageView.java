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
/* loaded from: classes11.dex */
public class BubbleImageView extends ImageView {
    private static final Bitmap.Config peM = Bitmap.Config.ARGB_8888;
    private Paint fBg;
    private int mAngle;
    private int mArrowHeight;
    private int mArrowWidth;
    private Bitmap mBitmap;
    private int mBitmapHeight;
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private Matrix mShaderMatrix;
    private int peN;
    private int peO;
    private int peP;
    private Rect peQ;

    public BubbleImageView(Context context) {
        super(context);
        this.mAngle = vy(10);
        this.peN = vy(40);
        this.mArrowWidth = vy(20);
        this.mArrowHeight = vy(20);
        this.peO = 0;
        this.peP = 0;
        l(null);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAngle = vy(10);
        this.peN = vy(40);
        this.mArrowWidth = vy(20);
        this.mArrowHeight = vy(20);
        this.peO = 0;
        this.peP = 0;
        l(attributeSet);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAngle = vy(10);
        this.peN = vy(40);
        this.mArrowWidth = vy(20);
        this.mArrowHeight = vy(20);
        this.peO = 0;
        this.peP = 0;
        l(attributeSet);
    }

    private void l(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.BubbleImageView);
            this.mAngle = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_angle, this.mAngle);
            this.mArrowHeight = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_arrowHeight, this.mArrowHeight);
            this.peO = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_arrowOffset, this.peO);
            this.peN = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_arrowTop, this.peN);
            this.mArrowWidth = (int) obtainStyledAttributes.getDimension(a.j.BubbleImageView_bubble_arrowWidth, this.mAngle);
            this.peP = obtainStyledAttributes.getInt(a.j.BubbleImageView_bubble_arrowLocation, this.peP);
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
            canvas.drawPath(path, this.fBg);
            try {
                if (ThemeManager.emw() == ThemeManager.ThemeMode.NIGHT) {
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
        this.mBitmap = o(drawable);
        setup();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        this.mBitmap = o(getDrawable());
        setup();
    }

    private Bitmap o(Drawable drawable) {
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
                createBitmap = Bitmap.createBitmap(1, 1, peM);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), peM);
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
            this.fBg = new Paint();
            this.fBg.setColor(getLineColor());
            this.fBg.setStrokeWidth(1.0f);
            this.fBg.setStyle(Paint.Style.STROKE);
            this.fBg.setAntiAlias(true);
            this.mBitmapHeight = this.mBitmap.getHeight();
            this.mBitmapWidth = this.mBitmap.getWidth();
            updateShaderMatrix();
            invalidate();
        }
    }

    private void updateShaderMatrix() {
        float width;
        float height;
        float f;
        this.mShaderMatrix = new Matrix();
        this.mShaderMatrix.set(null);
        this.peQ = new Rect(0, 0, getRight() - getLeft(), getBottom() - getTop());
        if (this.mBitmapWidth * this.peQ.height() > this.peQ.width() * this.mBitmapHeight) {
            width = this.peQ.height() / this.mBitmapHeight;
            f = (this.peQ.width() - (this.mBitmapWidth * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.peQ.width() / this.mBitmapWidth;
            height = (this.peQ.height() - (this.mBitmapHeight * width)) * 0.5f;
            f = 0.0f;
        }
        this.mShaderMatrix.setScale(width, width);
        this.mShaderMatrix.postTranslate((int) (f + 0.5f), (int) (height + 0.5f));
        this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
    }

    private int vy(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }
}
