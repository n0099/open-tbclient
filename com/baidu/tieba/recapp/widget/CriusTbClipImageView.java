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
    protected b lJX;
    private Path lJY;
    private RectF lJZ;
    private float[] lKa;
    private int lKb;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lJX = new b();
        this.lJY = new Path();
        this.lKb = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.lJX = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.lJX.lJT = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.lJX.lJU = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.lJX.lJV = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.lJX.lJW = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.lJX.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.lJX.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.lJX.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.lJX.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.lJX.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.lJX.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.lJX.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.lJX.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.lJX.lJT = l.dip2px(getContext(), 4.0f);
            this.lJX.lJU = l.dip2px(getContext(), 4.0f);
            this.lJX.lJV = l.dip2px(getContext(), 4.0f);
            this.lJX.lJW = l.dip2px(getContext(), 4.0f);
            this.lJX.mRadius = l.dip2px(getContext(), 4.0f);
            this.lJX.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.lJX.mBorderColor = 201326592;
        }
        this.lKb = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.lKb != 1) {
            setLayerType(1, null);
        }
        if (!this.lJX.mIsRound) {
            this.lJX.mRadius = 0.0f;
        }
        this.QO = this.lJX;
        setConrers(0);
        this.QP = f.oY().aA(this.mDrawerType);
        this.QP.a(this.lJX);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.lJX.lJT != i) {
            this.lJX.lJT = i;
            z = true;
        }
        if (this.lJX.lJU != i2) {
            this.lJX.lJU = i2;
            z = true;
        }
        if (this.lJX.lJV != i3) {
            this.lJX.lJV = i3;
            z = true;
        }
        if (this.lJX.lJW != i4) {
            this.lJX.lJW = i4;
            z = true;
        }
        if (z) {
            this.lKb = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.lKb != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.lJX.mRadius = i;
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
        if (!this.lJX.mIsRound) {
            setDrawerType(1);
            this.lJY.reset();
            this.lJZ = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.lKa = new float[]{this.lJX.lJT, this.lJX.lJT, this.lJX.lJV, this.lJX.lJV, this.lJX.lJW, this.lJX.lJW, this.lJX.lJU, this.lJX.lJU};
            this.lJY.addRoundRect(this.lJZ, this.lKa, Path.Direction.CW);
            try {
                canvas.clipPath(this.lJY);
            } catch (Error e) {
            }
        }
    }

    private void ak(Canvas canvas) {
        if (!this.lJX.mIsRound && this.lJX.mHasBorder) {
            setDrawerType(1);
            this.lJY.reset();
            this.lJZ = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.lKa = new float[]{this.lJX.lJT, this.lJX.lJT, this.lJX.lJV, this.lJX.lJV, this.lJX.lJW, this.lJX.lJW, this.lJX.lJU, this.lJX.lJU};
            this.lJY.addRoundRect(this.lJZ, this.lKa, Path.Direction.CW);
            try {
                canvas.drawPath(this.lJY, this.QP.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.lJX.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.lJY.reset();
        this.lJZ = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.lKa = new float[]{this.lJX.lJT, this.lJX.lJT, this.lJX.lJV, this.lJX.lJV, this.lJX.lJW, this.lJX.lJW, this.lJX.lJU, this.lJX.lJU};
        this.lJY.addRoundRect(this.lJZ, this.lKa, Path.Direction.CW);
        try {
            canvas.clipPath(this.lJY);
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
    public void qN(int i) {
        bwm();
    }
}
