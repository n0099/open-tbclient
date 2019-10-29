package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.newwidget.ImageView.e;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b iPY;
    private Path iPZ;
    private RectF iQa;
    private float[] iQb;
    private int iQc;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iPY = new b();
        this.iPZ = new Path();
        this.iQc = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.iPY = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.iPY.iPU = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.iPY.iPV = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.iPY.iPW = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.iPY.iPX = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.iPY.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.iPY.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.iPY.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.iPY.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.iPY.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.iPY.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.iPY.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.iPY.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.iPY.iPU = l.dip2px(getContext(), 4.0f);
            this.iPY.iPV = l.dip2px(getContext(), 4.0f);
            this.iPY.iPW = l.dip2px(getContext(), 4.0f);
            this.iPY.iPX = l.dip2px(getContext(), 4.0f);
            this.iPY.mRadius = l.dip2px(getContext(), 4.0f);
            this.iPY.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.iPY.mBorderColor = 201326592;
        }
        this.iQc = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.iQc != 1) {
            setLayerType(1, null);
        }
        if (!this.iPY.mIsRound) {
            this.iPY.mRadius = 0.0f;
        }
        this.tT = this.iPY;
        setConrers(0);
        this.tU = e.hT().X(this.mDrawerType);
        this.tU.a(this.iPY);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.iPY.iPU != i) {
            this.iPY.iPU = i;
            z = true;
        }
        if (this.iPY.iPV != i2) {
            this.iPY.iPV = i2;
            z = true;
        }
        if (this.iPY.iPW != i3) {
            this.iPY.iPW = i3;
            z = true;
        }
        if (this.iPY.iPX != i4) {
            this.iPY.iPX = i4;
            z = true;
        }
        if (z) {
            this.iQc = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.iQc != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.iPY.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Y(canvas);
        super.onDraw(canvas);
        Z(canvas);
    }

    private void Y(Canvas canvas) {
        if (!this.iPY.mIsRound) {
            setDrawerType(1);
            this.iPZ.reset();
            this.iQa = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iQb = new float[]{this.iPY.iPU, this.iPY.iPU, this.iPY.iPW, this.iPY.iPW, this.iPY.iPX, this.iPY.iPX, this.iPY.iPV, this.iPY.iPV};
            this.iPZ.addRoundRect(this.iQa, this.iQb, Path.Direction.CW);
            try {
                canvas.clipPath(this.iPZ);
            } catch (Error e) {
            }
        }
    }

    private void Z(Canvas canvas) {
        if (!this.iPY.mIsRound && this.iPY.mHasBorder) {
            setDrawerType(1);
            this.iPZ.reset();
            this.iQa = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iQb = new float[]{this.iPY.iPU, this.iPY.iPU, this.iPY.iPW, this.iPY.iPW, this.iPY.iPX, this.iPY.iPX, this.iPY.iPV, this.iPY.iPV};
            this.iPZ.addRoundRect(this.iQa, this.iQb, Path.Direction.CW);
            try {
                canvas.drawPath(this.iPZ, this.tU.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.iPY.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.iPZ.reset();
        this.iQa = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.iQb = new float[]{this.iPY.iPU, this.iPY.iPU, this.iPY.iPW, this.iPY.iPW, this.iPY.iPX, this.iPY.iPX, this.iPY.iPV, this.iPY.iPV};
        this.iPZ.addRoundRect(this.iQa, this.iQb, Path.Direction.CW);
        try {
            canvas.clipPath(this.iPZ);
        } catch (Error e) {
        }
        drawable.draw(canvas);
        canvas.save();
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void setConrers(int i) {
        super.setConrers(0);
    }

    @Override // com.baidu.tbadk.widget.TbImageView
    public void kp(int i) {
        ayj();
    }
}
