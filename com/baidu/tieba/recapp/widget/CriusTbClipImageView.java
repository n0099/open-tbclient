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
    protected b jPS;
    private Path jPT;
    private RectF jPU;
    private float[] jPV;
    private int jPW;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jPS = new b();
        this.jPT = new Path();
        this.jPW = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.jPS = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.jPS.jPO = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.jPS.jPP = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.jPS.jPQ = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.jPS.jPR = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.jPS.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.jPS.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.jPS.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.jPS.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.jPS.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.jPS.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.jPS.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.jPS.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.jPS.jPO = l.dip2px(getContext(), 4.0f);
            this.jPS.jPP = l.dip2px(getContext(), 4.0f);
            this.jPS.jPQ = l.dip2px(getContext(), 4.0f);
            this.jPS.jPR = l.dip2px(getContext(), 4.0f);
            this.jPS.mRadius = l.dip2px(getContext(), 4.0f);
            this.jPS.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.jPS.mBorderColor = 201326592;
        }
        this.jPW = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.jPW != 1) {
            setLayerType(1, null);
        }
        if (!this.jPS.mIsRound) {
            this.jPS.mRadius = 0.0f;
        }
        this.wx = this.jPS;
        setConrers(0);
        this.wy = e.iC().ad(this.mDrawerType);
        this.wy.a(this.jPS);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.jPS.jPO != i) {
            this.jPS.jPO = i;
            z = true;
        }
        if (this.jPS.jPP != i2) {
            this.jPS.jPP = i2;
            z = true;
        }
        if (this.jPS.jPQ != i3) {
            this.jPS.jPQ = i3;
            z = true;
        }
        if (this.jPS.jPR != i4) {
            this.jPS.jPR = i4;
            z = true;
        }
        if (z) {
            this.jPW = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.jPW != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.jPS.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        W(canvas);
        super.onDraw(canvas);
        X(canvas);
    }

    private void W(Canvas canvas) {
        if (!this.jPS.mIsRound) {
            setDrawerType(1);
            this.jPT.reset();
            this.jPU = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jPV = new float[]{this.jPS.jPO, this.jPS.jPO, this.jPS.jPQ, this.jPS.jPQ, this.jPS.jPR, this.jPS.jPR, this.jPS.jPP, this.jPS.jPP};
            this.jPT.addRoundRect(this.jPU, this.jPV, Path.Direction.CW);
            try {
                canvas.clipPath(this.jPT);
            } catch (Error e) {
            }
        }
    }

    private void X(Canvas canvas) {
        if (!this.jPS.mIsRound && this.jPS.mHasBorder) {
            setDrawerType(1);
            this.jPT.reset();
            this.jPU = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jPV = new float[]{this.jPS.jPO, this.jPS.jPO, this.jPS.jPQ, this.jPS.jPQ, this.jPS.jPR, this.jPS.jPR, this.jPS.jPP, this.jPS.jPP};
            this.jPT.addRoundRect(this.jPU, this.jPV, Path.Direction.CW);
            try {
                canvas.drawPath(this.jPT, this.wy.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.jPS.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.jPT.reset();
        this.jPU = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.jPV = new float[]{this.jPS.jPO, this.jPS.jPO, this.jPS.jPQ, this.jPS.jPQ, this.jPS.jPR, this.jPS.jPR, this.jPS.jPP, this.jPS.jPP};
        this.jPT.addRoundRect(this.jPU, this.jPV, Path.Direction.CW);
        try {
            canvas.clipPath(this.jPT);
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
    public void mW(int i) {
        aSX();
    }
}
