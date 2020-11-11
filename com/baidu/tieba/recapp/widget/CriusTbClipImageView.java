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
    protected b mAS;
    private Path mAT;
    private RectF mAU;
    private float[] mAV;
    private int mAW;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAS = new b();
        this.mAT = new Path();
        this.mAW = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mAS = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.mAS.mAO = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.mAS.mAP = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.mAS.mAQ = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.mAS.mAR = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.mAS.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.mAS.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.mAS.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.mAS.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.mAS.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.mAS.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.mAS.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.mAS.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.mAS.mAO = l.dip2px(getContext(), 4.0f);
            this.mAS.mAP = l.dip2px(getContext(), 4.0f);
            this.mAS.mAQ = l.dip2px(getContext(), 4.0f);
            this.mAS.mAR = l.dip2px(getContext(), 4.0f);
            this.mAS.mRadius = l.dip2px(getContext(), 4.0f);
            this.mAS.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.mAS.mBorderColor = 201326592;
        }
        this.mAW = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.mAW != 1) {
            setLayerType(1, null);
        }
        if (!this.mAS.mIsRound) {
            this.mAS.mRadius = 0.0f;
        }
        this.Ry = this.mAS;
        setConrers(0);
        this.Rz = f.pd().aD(this.mDrawerType);
        this.Rz.a(this.mAS);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.mAS.mAO != i) {
            this.mAS.mAO = i;
            z = true;
        }
        if (this.mAS.mAP != i2) {
            this.mAS.mAP = i2;
            z = true;
        }
        if (this.mAS.mAQ != i3) {
            this.mAS.mAQ = i3;
            z = true;
        }
        if (this.mAS.mAR != i4) {
            this.mAS.mAR = i4;
            z = true;
        }
        if (z) {
            this.mAW = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.mAW != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.mAS.mRadius = i;
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
        if (!this.mAS.mIsRound) {
            setDrawerType(1);
            this.mAT.reset();
            this.mAU = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.mAV = new float[]{this.mAS.mAO, this.mAS.mAO, this.mAS.mAQ, this.mAS.mAQ, this.mAS.mAR, this.mAS.mAR, this.mAS.mAP, this.mAS.mAP};
            this.mAT.addRoundRect(this.mAU, this.mAV, Path.Direction.CW);
            try {
                canvas.clipPath(this.mAT);
            } catch (Error e) {
            }
        }
    }

    private void al(Canvas canvas) {
        if (!this.mAS.mIsRound && this.mAS.mHasBorder) {
            setDrawerType(1);
            this.mAT.reset();
            this.mAU = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.mAV = new float[]{this.mAS.mAO, this.mAS.mAO, this.mAS.mAQ, this.mAS.mAQ, this.mAS.mAR, this.mAS.mAR, this.mAS.mAP, this.mAS.mAP};
            this.mAT.addRoundRect(this.mAU, this.mAV, Path.Direction.CW);
            try {
                canvas.drawPath(this.mAT, this.Rz.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void b(Canvas canvas, Drawable drawable) {
        if (this.mAS.mIsRound) {
            super.b(canvas, drawable);
            return;
        }
        this.mAT.reset();
        this.mAU = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.mAV = new float[]{this.mAS.mAO, this.mAS.mAO, this.mAS.mAQ, this.mAS.mAQ, this.mAS.mAR, this.mAS.mAR, this.mAS.mAP, this.mAS.mAP};
        this.mAT.addRoundRect(this.mAU, this.mAV, Path.Direction.CW);
        try {
            canvas.clipPath(this.mAT);
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
    public void rX(int i) {
        bEy();
    }
}
