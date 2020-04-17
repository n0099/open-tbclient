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
    protected b kzg;
    private Path kzh;
    private RectF kzi;
    private float[] kzj;
    private int kzk;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kzg = new b();
        this.kzh = new Path();
        this.kzk = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.kzg = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.kzg.kzc = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.kzg.kzd = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.kzg.kze = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.kzg.kzf = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.kzg.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.kzg.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.kzg.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.kzg.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.kzg.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.kzg.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.kzg.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.kzg.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.kzg.kzc = l.dip2px(getContext(), 4.0f);
            this.kzg.kzd = l.dip2px(getContext(), 4.0f);
            this.kzg.kze = l.dip2px(getContext(), 4.0f);
            this.kzg.kzf = l.dip2px(getContext(), 4.0f);
            this.kzg.mRadius = l.dip2px(getContext(), 4.0f);
            this.kzg.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.kzg.mBorderColor = 201326592;
        }
        this.kzk = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.kzk != 1) {
            setLayerType(1, null);
        }
        if (!this.kzg.mIsRound) {
            this.kzg.mRadius = 0.0f;
        }
        this.Ps = this.kzg;
        setConrers(0);
        this.Pt = e.nf().ap(this.mDrawerType);
        this.Pt.a(this.kzg);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.kzg.kzc != i) {
            this.kzg.kzc = i;
            z = true;
        }
        if (this.kzg.kzd != i2) {
            this.kzg.kzd = i2;
            z = true;
        }
        if (this.kzg.kze != i3) {
            this.kzg.kze = i3;
            z = true;
        }
        if (this.kzg.kzf != i4) {
            this.kzg.kzf = i4;
            z = true;
        }
        if (z) {
            this.kzk = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.kzk != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.kzg.mRadius = i;
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
        if (!this.kzg.mIsRound) {
            setDrawerType(1);
            this.kzh.reset();
            this.kzi = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.kzj = new float[]{this.kzg.kzc, this.kzg.kzc, this.kzg.kze, this.kzg.kze, this.kzg.kzf, this.kzg.kzf, this.kzg.kzd, this.kzg.kzd};
            this.kzh.addRoundRect(this.kzi, this.kzj, Path.Direction.CW);
            try {
                canvas.clipPath(this.kzh);
            } catch (Error e) {
            }
        }
    }

    private void Y(Canvas canvas) {
        if (!this.kzg.mIsRound && this.kzg.mHasBorder) {
            setDrawerType(1);
            this.kzh.reset();
            this.kzi = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.kzj = new float[]{this.kzg.kzc, this.kzg.kzc, this.kzg.kze, this.kzg.kze, this.kzg.kzf, this.kzg.kzf, this.kzg.kzd, this.kzg.kzd};
            this.kzh.addRoundRect(this.kzi, this.kzj, Path.Direction.CW);
            try {
                canvas.drawPath(this.kzh, this.Pt.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.kzg.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.kzh.reset();
        this.kzi = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.kzj = new float[]{this.kzg.kzc, this.kzg.kzc, this.kzg.kze, this.kzg.kze, this.kzg.kzf, this.kzg.kzf, this.kzg.kzd, this.kzg.kzd};
        this.kzh.addRoundRect(this.kzi, this.kzj, Path.Direction.CW);
        try {
            canvas.clipPath(this.kzh);
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
        bbh();
    }
}
