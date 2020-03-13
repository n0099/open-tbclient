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
/* loaded from: classes13.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b jOq;
    private Path jOr;
    private RectF jOs;
    private float[] jOt;
    private int jOu;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jOq = new b();
        this.jOr = new Path();
        this.jOu = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.jOq = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.jOq.jOm = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.jOq.jOn = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.jOq.jOo = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.jOq.jOp = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.jOq.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.jOq.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.jOq.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.jOq.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.jOq.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.jOq.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.jOq.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.jOq.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.jOq.jOm = l.dip2px(getContext(), 4.0f);
            this.jOq.jOn = l.dip2px(getContext(), 4.0f);
            this.jOq.jOo = l.dip2px(getContext(), 4.0f);
            this.jOq.jOp = l.dip2px(getContext(), 4.0f);
            this.jOq.mRadius = l.dip2px(getContext(), 4.0f);
            this.jOq.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.jOq.mBorderColor = 201326592;
        }
        this.jOu = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.jOu != 1) {
            setLayerType(1, null);
        }
        if (!this.jOq.mIsRound) {
            this.jOq.mRadius = 0.0f;
        }
        this.wx = this.jOq;
        setConrers(0);
        this.wy = e.iC().ad(this.mDrawerType);
        this.wy.a(this.jOq);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.jOq.jOm != i) {
            this.jOq.jOm = i;
            z = true;
        }
        if (this.jOq.jOn != i2) {
            this.jOq.jOn = i2;
            z = true;
        }
        if (this.jOq.jOo != i3) {
            this.jOq.jOo = i3;
            z = true;
        }
        if (this.jOq.jOp != i4) {
            this.jOq.jOp = i4;
            z = true;
        }
        if (z) {
            this.jOu = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.jOu != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.jOq.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        V(canvas);
        super.onDraw(canvas);
        W(canvas);
    }

    private void V(Canvas canvas) {
        if (!this.jOq.mIsRound) {
            setDrawerType(1);
            this.jOr.reset();
            this.jOs = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jOt = new float[]{this.jOq.jOm, this.jOq.jOm, this.jOq.jOo, this.jOq.jOo, this.jOq.jOp, this.jOq.jOp, this.jOq.jOn, this.jOq.jOn};
            this.jOr.addRoundRect(this.jOs, this.jOt, Path.Direction.CW);
            try {
                canvas.clipPath(this.jOr);
            } catch (Error e) {
            }
        }
    }

    private void W(Canvas canvas) {
        if (!this.jOq.mIsRound && this.jOq.mHasBorder) {
            setDrawerType(1);
            this.jOr.reset();
            this.jOs = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jOt = new float[]{this.jOq.jOm, this.jOq.jOm, this.jOq.jOo, this.jOq.jOo, this.jOq.jOp, this.jOq.jOp, this.jOq.jOn, this.jOq.jOn};
            this.jOr.addRoundRect(this.jOs, this.jOt, Path.Direction.CW);
            try {
                canvas.drawPath(this.jOr, this.wy.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.jOq.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.jOr.reset();
        this.jOs = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.jOt = new float[]{this.jOq.jOm, this.jOq.jOm, this.jOq.jOo, this.jOq.jOo, this.jOq.jOp, this.jOq.jOp, this.jOq.jOn, this.jOq.jOn};
        this.jOr.addRoundRect(this.jOs, this.jOt, Path.Direction.CW);
        try {
            canvas.clipPath(this.jOr);
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
    public void mU(int i) {
        aST();
    }
}
