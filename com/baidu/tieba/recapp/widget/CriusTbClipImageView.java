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
    protected b lKk;
    private Path lKl;
    private RectF lKm;
    private float[] lKn;
    private int lKo;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lKk = new b();
        this.lKl = new Path();
        this.lKo = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.lKk = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.lKk.lKg = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.lKk.lKh = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.lKk.lKi = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.lKk.lKj = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.lKk.mRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.lKk.mIsRound = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_isRound, false);
            this.lKk.mHasBorder = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_hasBorder, false);
            this.lKk.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.lKk.mBorderColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_borderColor, 201326592);
            this.lKk.mBorderSurroundContent = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_borderSurroundContent, false);
            this.lKk.mIsShowGifIcon = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_showGifIcon, true);
            this.lKk.mForegroundColor = obtainStyledAttributes.getColor(R.styleable.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(R.styleable.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(R.styleable.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.lKk.lKg = l.dip2px(getContext(), 4.0f);
            this.lKk.lKh = l.dip2px(getContext(), 4.0f);
            this.lKk.lKi = l.dip2px(getContext(), 4.0f);
            this.lKk.lKj = l.dip2px(getContext(), 4.0f);
            this.lKk.mRadius = l.dip2px(getContext(), 4.0f);
            this.lKk.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.lKk.mBorderColor = 201326592;
        }
        this.lKo = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.lKo != 1) {
            setLayerType(1, null);
        }
        if (!this.lKk.mIsRound) {
            this.lKk.mRadius = 0.0f;
        }
        this.QO = this.lKk;
        setConrers(0);
        this.QP = f.oY().aA(this.mDrawerType);
        this.QP.a(this.lKk);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.lKk.lKg != i) {
            this.lKk.lKg = i;
            z = true;
        }
        if (this.lKk.lKh != i2) {
            this.lKk.lKh = i2;
            z = true;
        }
        if (this.lKk.lKi != i3) {
            this.lKk.lKi = i3;
            z = true;
        }
        if (this.lKk.lKj != i4) {
            this.lKk.lKj = i4;
            z = true;
        }
        if (z) {
            this.lKo = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.lKo != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.lKk.mRadius = i;
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
        if (!this.lKk.mIsRound) {
            setDrawerType(1);
            this.lKl.reset();
            this.lKm = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.lKn = new float[]{this.lKk.lKg, this.lKk.lKg, this.lKk.lKi, this.lKk.lKi, this.lKk.lKj, this.lKk.lKj, this.lKk.lKh, this.lKk.lKh};
            this.lKl.addRoundRect(this.lKm, this.lKn, Path.Direction.CW);
            try {
                canvas.clipPath(this.lKl);
            } catch (Error e) {
            }
        }
    }

    private void ak(Canvas canvas) {
        if (!this.lKk.mIsRound && this.lKk.mHasBorder) {
            setDrawerType(1);
            this.lKl.reset();
            this.lKm = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.lKn = new float[]{this.lKk.lKg, this.lKk.lKg, this.lKk.lKi, this.lKk.lKi, this.lKk.lKj, this.lKk.lKj, this.lKk.lKh, this.lKk.lKh};
            this.lKl.addRoundRect(this.lKm, this.lKn, Path.Direction.CW);
            try {
                canvas.drawPath(this.lKl, this.QP.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.lKk.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.lKl.reset();
        this.lKm = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.lKn = new float[]{this.lKk.lKg, this.lKk.lKg, this.lKk.lKi, this.lKk.lKi, this.lKk.lKj, this.lKk.lKj, this.lKk.lKh, this.lKk.lKh};
        this.lKl.addRoundRect(this.lKm, this.lKn, Path.Direction.CW);
        try {
            canvas.clipPath(this.lKl);
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
        bwn();
    }
}
