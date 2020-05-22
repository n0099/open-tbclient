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
/* loaded from: classes13.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b kRd;
    private Path kRe;
    private RectF kRf;
    private float[] kRg;
    private int kRh;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kRd = new b();
        this.kRe = new Path();
        this.kRh = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.kRd = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.kRd.kQZ = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.kRd.kRa = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.kRd.kRb = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.kRd.kRc = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.kRd.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.kRd.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.kRd.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.kRd.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.kRd.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.kRd.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.kRd.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.kRd.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.kRd.kQZ = l.dip2px(getContext(), 4.0f);
            this.kRd.kRa = l.dip2px(getContext(), 4.0f);
            this.kRd.kRb = l.dip2px(getContext(), 4.0f);
            this.kRd.kRc = l.dip2px(getContext(), 4.0f);
            this.kRd.mRadius = l.dip2px(getContext(), 4.0f);
            this.kRd.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.kRd.mBorderColor = 201326592;
        }
        this.kRh = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.kRh != 1) {
            setLayerType(1, null);
        }
        if (!this.kRd.mIsRound) {
            this.kRd.mRadius = 0.0f;
        }
        this.PF = this.kRd;
        setConrers(0);
        this.PG = f.nh().aq(this.mDrawerType);
        this.PG.a(this.kRd);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.kRd.kQZ != i) {
            this.kRd.kQZ = i;
            z = true;
        }
        if (this.kRd.kRa != i2) {
            this.kRd.kRa = i2;
            z = true;
        }
        if (this.kRd.kRb != i3) {
            this.kRd.kRb = i3;
            z = true;
        }
        if (this.kRd.kRc != i4) {
            this.kRd.kRc = i4;
            z = true;
        }
        if (z) {
            this.kRh = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.kRh != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.kRd.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Y(canvas);
        super.onDraw(canvas);
        Z(canvas);
    }

    private void Y(Canvas canvas) {
        if (!this.kRd.mIsRound) {
            setDrawerType(1);
            this.kRe.reset();
            this.kRf = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.kRg = new float[]{this.kRd.kQZ, this.kRd.kQZ, this.kRd.kRb, this.kRd.kRb, this.kRd.kRc, this.kRd.kRc, this.kRd.kRa, this.kRd.kRa};
            this.kRe.addRoundRect(this.kRf, this.kRg, Path.Direction.CW);
            try {
                canvas.clipPath(this.kRe);
            } catch (Error e) {
            }
        }
    }

    private void Z(Canvas canvas) {
        if (!this.kRd.mIsRound && this.kRd.mHasBorder) {
            setDrawerType(1);
            this.kRe.reset();
            this.kRf = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.kRg = new float[]{this.kRd.kQZ, this.kRd.kQZ, this.kRd.kRb, this.kRd.kRb, this.kRd.kRc, this.kRd.kRc, this.kRd.kRa, this.kRd.kRa};
            this.kRe.addRoundRect(this.kRf, this.kRg, Path.Direction.CW);
            try {
                canvas.drawPath(this.kRe, this.PG.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.kRd.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.kRe.reset();
        this.kRf = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.kRg = new float[]{this.kRd.kQZ, this.kRd.kQZ, this.kRd.kRb, this.kRd.kRb, this.kRd.kRc, this.kRd.kRc, this.kRd.kRa, this.kRd.kRa};
        this.kRe.addRoundRect(this.kRf, this.kRg, Path.Direction.CW);
        try {
            canvas.clipPath(this.kRe);
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
    public void nK(int i) {
        bhq();
    }
}
