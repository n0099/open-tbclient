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
    protected b ltD;
    private Path ltE;
    private RectF ltF;
    private float[] ltG;
    private int ltH;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ltD = new b();
        this.ltE = new Path();
        this.ltH = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.ltD = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.ltD.ltz = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.ltD.ltA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.ltD.ltB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.ltD.ltC = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.ltD.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.ltD.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.ltD.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.ltD.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.ltD.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.ltD.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.ltD.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.ltD.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.ltD.ltz = l.dip2px(getContext(), 4.0f);
            this.ltD.ltA = l.dip2px(getContext(), 4.0f);
            this.ltD.ltB = l.dip2px(getContext(), 4.0f);
            this.ltD.ltC = l.dip2px(getContext(), 4.0f);
            this.ltD.mRadius = l.dip2px(getContext(), 4.0f);
            this.ltD.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.ltD.mBorderColor = 201326592;
        }
        this.ltH = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.ltH != 1) {
            setLayerType(1, null);
        }
        if (!this.ltD.mIsRound) {
            this.ltD.mRadius = 0.0f;
        }
        this.Qk = this.ltD;
        setConrers(0);
        this.Ql = f.ny().ay(this.mDrawerType);
        this.Ql.a(this.ltD);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.ltD.ltz != i) {
            this.ltD.ltz = i;
            z = true;
        }
        if (this.ltD.ltA != i2) {
            this.ltD.ltA = i2;
            z = true;
        }
        if (this.ltD.ltB != i3) {
            this.ltD.ltB = i3;
            z = true;
        }
        if (this.ltD.ltC != i4) {
            this.ltD.ltC = i4;
            z = true;
        }
        if (z) {
            this.ltH = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.ltH != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.ltD.mRadius = i;
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
        if (!this.ltD.mIsRound) {
            setDrawerType(1);
            this.ltE.reset();
            this.ltF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ltG = new float[]{this.ltD.ltz, this.ltD.ltz, this.ltD.ltB, this.ltD.ltB, this.ltD.ltC, this.ltD.ltC, this.ltD.ltA, this.ltD.ltA};
            this.ltE.addRoundRect(this.ltF, this.ltG, Path.Direction.CW);
            try {
                canvas.clipPath(this.ltE);
            } catch (Error e) {
            }
        }
    }

    private void ae(Canvas canvas) {
        if (!this.ltD.mIsRound && this.ltD.mHasBorder) {
            setDrawerType(1);
            this.ltE.reset();
            this.ltF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ltG = new float[]{this.ltD.ltz, this.ltD.ltz, this.ltD.ltB, this.ltD.ltB, this.ltD.ltC, this.ltD.ltC, this.ltD.ltA, this.ltD.ltA};
            this.ltE.addRoundRect(this.ltF, this.ltG, Path.Direction.CW);
            try {
                canvas.drawPath(this.ltE, this.Ql.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.ltD.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.ltE.reset();
        this.ltF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.ltG = new float[]{this.ltD.ltz, this.ltD.ltz, this.ltD.ltB, this.ltD.ltB, this.ltD.ltC, this.ltD.ltC, this.ltD.ltA, this.ltD.ltA};
        this.ltE.addRoundRect(this.ltF, this.ltG, Path.Direction.CW);
        try {
            canvas.clipPath(this.ltE);
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
