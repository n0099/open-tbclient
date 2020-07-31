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
/* loaded from: classes20.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b ltB;
    private Path ltC;
    private RectF ltD;
    private float[] ltE;
    private int ltF;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ltB = new b();
        this.ltC = new Path();
        this.ltF = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.ltB = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.ltB.ltx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.ltB.lty = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.ltB.ltz = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.ltB.ltA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.ltB.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.ltB.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.ltB.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.ltB.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.ltB.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.ltB.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.ltB.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.ltB.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.ltB.ltx = l.dip2px(getContext(), 4.0f);
            this.ltB.lty = l.dip2px(getContext(), 4.0f);
            this.ltB.ltz = l.dip2px(getContext(), 4.0f);
            this.ltB.ltA = l.dip2px(getContext(), 4.0f);
            this.ltB.mRadius = l.dip2px(getContext(), 4.0f);
            this.ltB.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.ltB.mBorderColor = 201326592;
        }
        this.ltF = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.ltF != 1) {
            setLayerType(1, null);
        }
        if (!this.ltB.mIsRound) {
            this.ltB.mRadius = 0.0f;
        }
        this.Qk = this.ltB;
        setConrers(0);
        this.Ql = f.ny().ay(this.mDrawerType);
        this.Ql.a(this.ltB);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.ltB.ltx != i) {
            this.ltB.ltx = i;
            z = true;
        }
        if (this.ltB.lty != i2) {
            this.ltB.lty = i2;
            z = true;
        }
        if (this.ltB.ltz != i3) {
            this.ltB.ltz = i3;
            z = true;
        }
        if (this.ltB.ltA != i4) {
            this.ltB.ltA = i4;
            z = true;
        }
        if (z) {
            this.ltF = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.ltF != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.ltB.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        ad(canvas);
        super.onDraw(canvas);
        ae(canvas);
    }

    private void ad(Canvas canvas) {
        if (!this.ltB.mIsRound) {
            setDrawerType(1);
            this.ltC.reset();
            this.ltD = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ltE = new float[]{this.ltB.ltx, this.ltB.ltx, this.ltB.ltz, this.ltB.ltz, this.ltB.ltA, this.ltB.ltA, this.ltB.lty, this.ltB.lty};
            this.ltC.addRoundRect(this.ltD, this.ltE, Path.Direction.CW);
            try {
                canvas.clipPath(this.ltC);
            } catch (Error e) {
            }
        }
    }

    private void ae(Canvas canvas) {
        if (!this.ltB.mIsRound && this.ltB.mHasBorder) {
            setDrawerType(1);
            this.ltC.reset();
            this.ltD = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ltE = new float[]{this.ltB.ltx, this.ltB.ltx, this.ltB.ltz, this.ltB.ltz, this.ltB.ltA, this.ltB.ltA, this.ltB.lty, this.ltB.lty};
            this.ltC.addRoundRect(this.ltD, this.ltE, Path.Direction.CW);
            try {
                canvas.drawPath(this.ltC, this.Ql.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.ltB.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.ltC.reset();
        this.ltD = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.ltE = new float[]{this.ltB.ltx, this.ltB.ltx, this.ltB.ltz, this.ltB.ltz, this.ltB.ltA, this.ltB.ltA, this.ltB.lty, this.ltB.lty};
        this.ltC.addRoundRect(this.ltD, this.ltE, Path.Direction.CW);
        try {
            canvas.clipPath(this.ltC);
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
    public void oB(int i) {
        bny();
    }
}
