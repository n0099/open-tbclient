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
    private Path miA;
    private RectF miB;
    private float[] miC;
    private int miD;
    protected b miz;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.miz = new b();
        this.miA = new Path();
        this.miD = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.miz = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.miz.miv = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.miz.miw = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.miz.mix = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.miz.miy = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.miz.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.miz.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.miz.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.miz.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.miz.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.miz.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.miz.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.miz.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.miz.miv = l.dip2px(getContext(), 4.0f);
            this.miz.miw = l.dip2px(getContext(), 4.0f);
            this.miz.mix = l.dip2px(getContext(), 4.0f);
            this.miz.miy = l.dip2px(getContext(), 4.0f);
            this.miz.mRadius = l.dip2px(getContext(), 4.0f);
            this.miz.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.miz.mBorderColor = 201326592;
        }
        this.miD = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.miD != 1) {
            setLayerType(1, null);
        }
        if (!this.miz.mIsRound) {
            this.miz.mRadius = 0.0f;
        }
        this.Rx = this.miz;
        setConrers(0);
        this.Ry = f.pd().aD(this.mDrawerType);
        this.Ry.a(this.miz);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.miz.miv != i) {
            this.miz.miv = i;
            z = true;
        }
        if (this.miz.miw != i2) {
            this.miz.miw = i2;
            z = true;
        }
        if (this.miz.mix != i3) {
            this.miz.mix = i3;
            z = true;
        }
        if (this.miz.miy != i4) {
            this.miz.miy = i4;
            z = true;
        }
        if (z) {
            this.miD = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.miD != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.miz.mRadius = i;
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
        if (!this.miz.mIsRound) {
            setDrawerType(1);
            this.miA.reset();
            this.miB = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.miC = new float[]{this.miz.miv, this.miz.miv, this.miz.mix, this.miz.mix, this.miz.miy, this.miz.miy, this.miz.miw, this.miz.miw};
            this.miA.addRoundRect(this.miB, this.miC, Path.Direction.CW);
            try {
                canvas.clipPath(this.miA);
            } catch (Error e) {
            }
        }
    }

    private void al(Canvas canvas) {
        if (!this.miz.mIsRound && this.miz.mHasBorder) {
            setDrawerType(1);
            this.miA.reset();
            this.miB = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.miC = new float[]{this.miz.miv, this.miz.miv, this.miz.mix, this.miz.mix, this.miz.miy, this.miz.miy, this.miz.miw, this.miz.miw};
            this.miA.addRoundRect(this.miB, this.miC, Path.Direction.CW);
            try {
                canvas.drawPath(this.miA, this.Ry.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.miz.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.miA.reset();
        this.miB = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.miC = new float[]{this.miz.miv, this.miz.miv, this.miz.mix, this.miz.mix, this.miz.miy, this.miz.miy, this.miz.miw, this.miz.miw};
        this.miA.addRoundRect(this.miB, this.miC, Path.Direction.CW);
        try {
            canvas.clipPath(this.miA);
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
    public void rC(int i) {
        bAg();
    }
}
