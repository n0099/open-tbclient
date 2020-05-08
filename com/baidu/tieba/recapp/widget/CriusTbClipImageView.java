package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.newwidget.ImageView.e;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b kzk;
    private Path kzl;
    private RectF kzm;
    private float[] kzn;
    private int kzo;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kzk = new b();
        this.kzl = new Path();
        this.kzo = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.kzk = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.kzk.kzg = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.kzk.kzh = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.kzk.kzi = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.kzk.kzj = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.kzk.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.kzk.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.kzk.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.kzk.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.kzk.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.kzk.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.kzk.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.kzk.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.kzk.kzg = l.dip2px(getContext(), 4.0f);
            this.kzk.kzh = l.dip2px(getContext(), 4.0f);
            this.kzk.kzi = l.dip2px(getContext(), 4.0f);
            this.kzk.kzj = l.dip2px(getContext(), 4.0f);
            this.kzk.mRadius = l.dip2px(getContext(), 4.0f);
            this.kzk.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.kzk.mBorderColor = 201326592;
        }
        this.kzo = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.kzo != 1) {
            setLayerType(1, null);
        }
        if (!this.kzk.mIsRound) {
            this.kzk.mRadius = 0.0f;
        }
        this.Pw = this.kzk;
        setConrers(0);
        this.Px = e.nf().ap(this.mDrawerType);
        this.Px.a(this.kzk);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.kzk.kzg != i) {
            this.kzk.kzg = i;
            z = true;
        }
        if (this.kzk.kzh != i2) {
            this.kzk.kzh = i2;
            z = true;
        }
        if (this.kzk.kzi != i3) {
            this.kzk.kzi = i3;
            z = true;
        }
        if (this.kzk.kzj != i4) {
            this.kzk.kzj = i4;
            z = true;
        }
        if (z) {
            this.kzo = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.kzo != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.kzk.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        X(canvas);
        super.onDraw(canvas);
        Y(canvas);
    }

    private void X(Canvas canvas) {
        if (!this.kzk.mIsRound) {
            setDrawerType(1);
            this.kzl.reset();
            this.kzm = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.kzn = new float[]{this.kzk.kzg, this.kzk.kzg, this.kzk.kzi, this.kzk.kzi, this.kzk.kzj, this.kzk.kzj, this.kzk.kzh, this.kzk.kzh};
            this.kzl.addRoundRect(this.kzm, this.kzn, Path.Direction.CW);
            try {
                canvas.clipPath(this.kzl);
            } catch (Error e) {
            }
        }
    }

    private void Y(Canvas canvas) {
        if (!this.kzk.mIsRound && this.kzk.mHasBorder) {
            setDrawerType(1);
            this.kzl.reset();
            this.kzm = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.kzn = new float[]{this.kzk.kzg, this.kzk.kzg, this.kzk.kzi, this.kzk.kzi, this.kzk.kzj, this.kzk.kzj, this.kzk.kzh, this.kzk.kzh};
            this.kzl.addRoundRect(this.kzm, this.kzn, Path.Direction.CW);
            try {
                canvas.drawPath(this.kzl, this.Px.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.kzk.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.kzl.reset();
        this.kzm = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.kzn = new float[]{this.kzk.kzg, this.kzk.kzg, this.kzk.kzi, this.kzk.kzi, this.kzk.kzj, this.kzk.kzj, this.kzk.kzh, this.kzk.kzh};
        this.kzl.addRoundRect(this.kzm, this.kzn, Path.Direction.CW);
        try {
            canvas.clipPath(this.kzl);
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
    public void ni(int i) {
        bbf();
    }
}
