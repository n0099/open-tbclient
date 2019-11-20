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
    protected b iPh;
    private Path iPi;
    private RectF iPj;
    private float[] iPk;
    private int iPl;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iPh = new b();
        this.iPi = new Path();
        this.iPl = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.iPh = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.iPh.iPd = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.iPh.iPe = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.iPh.iPf = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.iPh.iPg = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.iPh.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.iPh.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.iPh.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.iPh.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.iPh.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.iPh.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.iPh.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.iPh.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.iPh.iPd = l.dip2px(getContext(), 4.0f);
            this.iPh.iPe = l.dip2px(getContext(), 4.0f);
            this.iPh.iPf = l.dip2px(getContext(), 4.0f);
            this.iPh.iPg = l.dip2px(getContext(), 4.0f);
            this.iPh.mRadius = l.dip2px(getContext(), 4.0f);
            this.iPh.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.iPh.mBorderColor = 201326592;
        }
        this.iPl = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.iPl != 1) {
            setLayerType(1, null);
        }
        if (!this.iPh.mIsRound) {
            this.iPh.mRadius = 0.0f;
        }
        this.tr = this.iPh;
        setConrers(0);
        this.ts = e.hT().X(this.mDrawerType);
        this.ts.a(this.iPh);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.iPh.iPd != i) {
            this.iPh.iPd = i;
            z = true;
        }
        if (this.iPh.iPe != i2) {
            this.iPh.iPe = i2;
            z = true;
        }
        if (this.iPh.iPf != i3) {
            this.iPh.iPf = i3;
            z = true;
        }
        if (this.iPh.iPg != i4) {
            this.iPh.iPg = i4;
            z = true;
        }
        if (z) {
            this.iPl = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.iPl != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.iPh.mRadius = i;
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
        if (!this.iPh.mIsRound) {
            setDrawerType(1);
            this.iPi.reset();
            this.iPj = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iPk = new float[]{this.iPh.iPd, this.iPh.iPd, this.iPh.iPf, this.iPh.iPf, this.iPh.iPg, this.iPh.iPg, this.iPh.iPe, this.iPh.iPe};
            this.iPi.addRoundRect(this.iPj, this.iPk, Path.Direction.CW);
            try {
                canvas.clipPath(this.iPi);
            } catch (Error e) {
            }
        }
    }

    private void Z(Canvas canvas) {
        if (!this.iPh.mIsRound && this.iPh.mHasBorder) {
            setDrawerType(1);
            this.iPi.reset();
            this.iPj = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iPk = new float[]{this.iPh.iPd, this.iPh.iPd, this.iPh.iPf, this.iPh.iPf, this.iPh.iPg, this.iPh.iPg, this.iPh.iPe, this.iPh.iPe};
            this.iPi.addRoundRect(this.iPj, this.iPk, Path.Direction.CW);
            try {
                canvas.drawPath(this.iPi, this.ts.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.iPh.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.iPi.reset();
        this.iPj = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.iPk = new float[]{this.iPh.iPd, this.iPh.iPd, this.iPh.iPf, this.iPh.iPf, this.iPh.iPg, this.iPh.iPg, this.iPh.iPe, this.iPh.iPe};
        this.iPi.addRoundRect(this.iPj, this.iPk, Path.Direction.CW);
        try {
            canvas.clipPath(this.iPi);
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
    public void ko(int i) {
        ayh();
    }
}
