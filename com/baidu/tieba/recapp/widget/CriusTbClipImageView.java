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
    protected b jOc;
    private Path jOd;
    private RectF jOe;
    private float[] jOf;
    private int jOg;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jOc = new b();
        this.jOd = new Path();
        this.jOg = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.jOc = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.jOc.jNY = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.jOc.jNZ = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.jOc.jOa = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.jOc.jOb = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.jOc.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.jOc.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.jOc.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.jOc.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.jOc.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.jOc.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.jOc.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.jOc.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.jOc.jNY = l.dip2px(getContext(), 4.0f);
            this.jOc.jNZ = l.dip2px(getContext(), 4.0f);
            this.jOc.jOa = l.dip2px(getContext(), 4.0f);
            this.jOc.jOb = l.dip2px(getContext(), 4.0f);
            this.jOc.mRadius = l.dip2px(getContext(), 4.0f);
            this.jOc.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.jOc.mBorderColor = 201326592;
        }
        this.jOg = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.jOg != 1) {
            setLayerType(1, null);
        }
        if (!this.jOc.mIsRound) {
            this.jOc.mRadius = 0.0f;
        }
        this.wx = this.jOc;
        setConrers(0);
        this.wy = e.iC().ad(this.mDrawerType);
        this.wy.a(this.jOc);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.jOc.jNY != i) {
            this.jOc.jNY = i;
            z = true;
        }
        if (this.jOc.jNZ != i2) {
            this.jOc.jNZ = i2;
            z = true;
        }
        if (this.jOc.jOa != i3) {
            this.jOc.jOa = i3;
            z = true;
        }
        if (this.jOc.jOb != i4) {
            this.jOc.jOb = i4;
            z = true;
        }
        if (z) {
            this.jOg = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.jOg != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.jOc.mRadius = i;
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
        if (!this.jOc.mIsRound) {
            setDrawerType(1);
            this.jOd.reset();
            this.jOe = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jOf = new float[]{this.jOc.jNY, this.jOc.jNY, this.jOc.jOa, this.jOc.jOa, this.jOc.jOb, this.jOc.jOb, this.jOc.jNZ, this.jOc.jNZ};
            this.jOd.addRoundRect(this.jOe, this.jOf, Path.Direction.CW);
            try {
                canvas.clipPath(this.jOd);
            } catch (Error e) {
            }
        }
    }

    private void W(Canvas canvas) {
        if (!this.jOc.mIsRound && this.jOc.mHasBorder) {
            setDrawerType(1);
            this.jOd.reset();
            this.jOe = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jOf = new float[]{this.jOc.jNY, this.jOc.jNY, this.jOc.jOa, this.jOc.jOa, this.jOc.jOb, this.jOc.jOb, this.jOc.jNZ, this.jOc.jNZ};
            this.jOd.addRoundRect(this.jOe, this.jOf, Path.Direction.CW);
            try {
                canvas.drawPath(this.jOd, this.wy.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.jOc.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.jOd.reset();
        this.jOe = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.jOf = new float[]{this.jOc.jNY, this.jOc.jNY, this.jOc.jOa, this.jOc.jOa, this.jOc.jOb, this.jOc.jOb, this.jOc.jNZ, this.jOc.jNZ};
        this.jOd.addRoundRect(this.jOe, this.jOf, Path.Direction.CW);
        try {
            canvas.clipPath(this.jOd);
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
        aSQ();
    }
}
