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
/* loaded from: classes10.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b jJv;
    private Path jJw;
    private RectF jJx;
    private float[] jJy;
    private int jJz;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jJv = new b();
        this.jJw = new Path();
        this.jJz = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.jJv = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.jJv.jJr = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.jJv.jJs = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.jJv.jJt = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.jJv.jJu = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.jJv.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.jJv.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.jJv.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.jJv.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.jJv.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.jJv.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.jJv.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.jJv.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.jJv.jJr = l.dip2px(getContext(), 4.0f);
            this.jJv.jJs = l.dip2px(getContext(), 4.0f);
            this.jJv.jJt = l.dip2px(getContext(), 4.0f);
            this.jJv.jJu = l.dip2px(getContext(), 4.0f);
            this.jJv.mRadius = l.dip2px(getContext(), 4.0f);
            this.jJv.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.jJv.mBorderColor = 201326592;
        }
        this.jJz = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.jJz != 1) {
            setLayerType(1, null);
        }
        if (!this.jJv.mIsRound) {
            this.jJv.mRadius = 0.0f;
        }
        this.wa = this.jJv;
        setConrers(0);
        this.wb = e.in().aa(this.mDrawerType);
        this.wb.a(this.jJv);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.jJv.jJr != i) {
            this.jJv.jJr = i;
            z = true;
        }
        if (this.jJv.jJs != i2) {
            this.jJv.jJs = i2;
            z = true;
        }
        if (this.jJv.jJt != i3) {
            this.jJv.jJt = i3;
            z = true;
        }
        if (this.jJv.jJu != i4) {
            this.jJv.jJu = i4;
            z = true;
        }
        if (z) {
            this.jJz = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.jJz != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.jJv.mRadius = i;
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
        if (!this.jJv.mIsRound) {
            setDrawerType(1);
            this.jJw.reset();
            this.jJx = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jJy = new float[]{this.jJv.jJr, this.jJv.jJr, this.jJv.jJt, this.jJv.jJt, this.jJv.jJu, this.jJv.jJu, this.jJv.jJs, this.jJv.jJs};
            this.jJw.addRoundRect(this.jJx, this.jJy, Path.Direction.CW);
            try {
                canvas.clipPath(this.jJw);
            } catch (Error e) {
            }
        }
    }

    private void W(Canvas canvas) {
        if (!this.jJv.mIsRound && this.jJv.mHasBorder) {
            setDrawerType(1);
            this.jJw.reset();
            this.jJx = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jJy = new float[]{this.jJv.jJr, this.jJv.jJr, this.jJv.jJt, this.jJv.jJt, this.jJv.jJu, this.jJv.jJu, this.jJv.jJs, this.jJv.jJs};
            this.jJw.addRoundRect(this.jJx, this.jJy, Path.Direction.CW);
            try {
                canvas.drawPath(this.jJw, this.wb.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.jJv.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.jJw.reset();
        this.jJx = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.jJy = new float[]{this.jJv.jJr, this.jJv.jJr, this.jJv.jJt, this.jJv.jJt, this.jJv.jJu, this.jJv.jJu, this.jJv.jJs, this.jJv.jJs};
        this.jJw.addRoundRect(this.jJx, this.jJy, Path.Direction.CW);
        try {
            canvas.clipPath(this.jJw);
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
    public void mD(int i) {
        aQg();
    }
}
