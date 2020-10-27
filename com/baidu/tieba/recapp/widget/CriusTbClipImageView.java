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
/* loaded from: classes26.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b muW;
    private Path muX;
    private RectF muY;
    private float[] muZ;
    private int mva;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.muW = new b();
        this.muX = new Path();
        this.mva = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.muW = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.muW.muS = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.muW.muT = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.muW.muU = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.muW.muV = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.muW.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.muW.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.muW.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.muW.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.muW.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.muW.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.muW.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.muW.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.muW.muS = l.dip2px(getContext(), 4.0f);
            this.muW.muT = l.dip2px(getContext(), 4.0f);
            this.muW.muU = l.dip2px(getContext(), 4.0f);
            this.muW.muV = l.dip2px(getContext(), 4.0f);
            this.muW.mRadius = l.dip2px(getContext(), 4.0f);
            this.muW.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.muW.mBorderColor = 201326592;
        }
        this.mva = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.mva != 1) {
            setLayerType(1, null);
        }
        if (!this.muW.mIsRound) {
            this.muW.mRadius = 0.0f;
        }
        this.Ry = this.muW;
        setConrers(0);
        this.Rz = f.pd().aD(this.mDrawerType);
        this.Rz.a(this.muW);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.muW.muS != i) {
            this.muW.muS = i;
            z = true;
        }
        if (this.muW.muT != i2) {
            this.muW.muT = i2;
            z = true;
        }
        if (this.muW.muU != i3) {
            this.muW.muU = i3;
            z = true;
        }
        if (this.muW.muV != i4) {
            this.muW.muV = i4;
            z = true;
        }
        if (z) {
            this.mva = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.mva != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.muW.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        ak(canvas);
        super.onDraw(canvas);
        al(canvas);
    }

    private void ak(Canvas canvas) {
        if (!this.muW.mIsRound) {
            setDrawerType(1);
            this.muX.reset();
            this.muY = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.muZ = new float[]{this.muW.muS, this.muW.muS, this.muW.muU, this.muW.muU, this.muW.muV, this.muW.muV, this.muW.muT, this.muW.muT};
            this.muX.addRoundRect(this.muY, this.muZ, Path.Direction.CW);
            try {
                canvas.clipPath(this.muX);
            } catch (Error e) {
            }
        }
    }

    private void al(Canvas canvas) {
        if (!this.muW.mIsRound && this.muW.mHasBorder) {
            setDrawerType(1);
            this.muX.reset();
            this.muY = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.muZ = new float[]{this.muW.muS, this.muW.muS, this.muW.muU, this.muW.muU, this.muW.muV, this.muW.muV, this.muW.muT, this.muW.muT};
            this.muX.addRoundRect(this.muY, this.muZ, Path.Direction.CW);
            try {
                canvas.drawPath(this.muX, this.Rz.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.muW.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.muX.reset();
        this.muY = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.muZ = new float[]{this.muW.muS, this.muW.muS, this.muW.muU, this.muW.muU, this.muW.muV, this.muW.muV, this.muW.muT, this.muW.muT};
        this.muX.addRoundRect(this.muY, this.muZ, Path.Direction.CW);
        try {
            canvas.clipPath(this.muX);
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
    public void rN(int i) {
        bBZ();
    }
}
