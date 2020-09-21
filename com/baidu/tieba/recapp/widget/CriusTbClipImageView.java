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
import com.baidu.adp.newwidget.ImageView.f;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.R;
/* loaded from: classes25.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b lTe;
    private Path lTf;
    private RectF lTg;
    private float[] lTh;
    private int lTi;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lTe = new b();
        this.lTf = new Path();
        this.lTi = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.lTe = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.lTe.lTa = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.lTe.lTb = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.lTe.lTc = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.lTe.lTd = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.lTe.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.lTe.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.lTe.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.lTe.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.lTe.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.lTe.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.lTe.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.lTe.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.lTe.lTa = l.dip2px(getContext(), 4.0f);
            this.lTe.lTb = l.dip2px(getContext(), 4.0f);
            this.lTe.lTc = l.dip2px(getContext(), 4.0f);
            this.lTe.lTd = l.dip2px(getContext(), 4.0f);
            this.lTe.mRadius = l.dip2px(getContext(), 4.0f);
            this.lTe.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.lTe.mBorderColor = 201326592;
        }
        this.lTi = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.lTi != 1) {
            setLayerType(1, null);
        }
        if (!this.lTe.mIsRound) {
            this.lTe.mRadius = 0.0f;
        }
        this.Rh = this.lTe;
        setConrers(0);
        this.Ri = f.pd().aD(this.mDrawerType);
        this.Ri.a(this.lTe);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.lTe.lTa != i) {
            this.lTe.lTa = i;
            z = true;
        }
        if (this.lTe.lTb != i2) {
            this.lTe.lTb = i2;
            z = true;
        }
        if (this.lTe.lTc != i3) {
            this.lTe.lTc = i3;
            z = true;
        }
        if (this.lTe.lTd != i4) {
            this.lTe.lTd = i4;
            z = true;
        }
        if (z) {
            this.lTi = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.lTi != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.lTe.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        aj(canvas);
        super.onDraw(canvas);
        ak(canvas);
    }

    private void aj(Canvas canvas) {
        if (!this.lTe.mIsRound) {
            setDrawerType(1);
            this.lTf.reset();
            this.lTg = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.lTh = new float[]{this.lTe.lTa, this.lTe.lTa, this.lTe.lTc, this.lTe.lTc, this.lTe.lTd, this.lTe.lTd, this.lTe.lTb, this.lTe.lTb};
            this.lTf.addRoundRect(this.lTg, this.lTh, Path.Direction.CW);
            try {
                canvas.clipPath(this.lTf);
            } catch (Error e) {
            }
        }
    }

    private void ak(Canvas canvas) {
        if (!this.lTe.mIsRound && this.lTe.mHasBorder) {
            setDrawerType(1);
            this.lTf.reset();
            this.lTg = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.lTh = new float[]{this.lTe.lTa, this.lTe.lTa, this.lTe.lTc, this.lTe.lTc, this.lTe.lTd, this.lTe.lTd, this.lTe.lTb, this.lTe.lTb};
            this.lTf.addRoundRect(this.lTg, this.lTh, Path.Direction.CW);
            try {
                canvas.drawPath(this.lTf, this.Ri.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.lTe.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.lTf.reset();
        this.lTg = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.lTh = new float[]{this.lTe.lTa, this.lTe.lTa, this.lTe.lTc, this.lTe.lTc, this.lTe.lTd, this.lTe.lTd, this.lTe.lTb, this.lTe.lTb};
        this.lTf.addRoundRect(this.lTg, this.lTh, Path.Direction.CW);
        try {
            canvas.clipPath(this.lTf);
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
    public void re(int i) {
        bxw();
    }
}
