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
    protected b kSm;
    private Path kSn;
    private RectF kSo;
    private float[] kSp;
    private int kSq;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kSm = new b();
        this.kSn = new Path();
        this.kSq = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.kSm = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.kSm.kSi = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.kSm.kSj = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.kSm.kSk = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.kSm.kSl = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.kSm.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.kSm.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.kSm.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.kSm.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.kSm.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.kSm.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.kSm.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.kSm.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.kSm.kSi = l.dip2px(getContext(), 4.0f);
            this.kSm.kSj = l.dip2px(getContext(), 4.0f);
            this.kSm.kSk = l.dip2px(getContext(), 4.0f);
            this.kSm.kSl = l.dip2px(getContext(), 4.0f);
            this.kSm.mRadius = l.dip2px(getContext(), 4.0f);
            this.kSm.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.kSm.mBorderColor = 201326592;
        }
        this.kSq = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.kSq != 1) {
            setLayerType(1, null);
        }
        if (!this.kSm.mIsRound) {
            this.kSm.mRadius = 0.0f;
        }
        this.PF = this.kSm;
        setConrers(0);
        this.PG = f.nh().aq(this.mDrawerType);
        this.PG.a(this.kSm);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.kSm.kSi != i) {
            this.kSm.kSi = i;
            z = true;
        }
        if (this.kSm.kSj != i2) {
            this.kSm.kSj = i2;
            z = true;
        }
        if (this.kSm.kSk != i3) {
            this.kSm.kSk = i3;
            z = true;
        }
        if (this.kSm.kSl != i4) {
            this.kSm.kSl = i4;
            z = true;
        }
        if (z) {
            this.kSq = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.kSq != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.kSm.mRadius = i;
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
        if (!this.kSm.mIsRound) {
            setDrawerType(1);
            this.kSn.reset();
            this.kSo = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.kSp = new float[]{this.kSm.kSi, this.kSm.kSi, this.kSm.kSk, this.kSm.kSk, this.kSm.kSl, this.kSm.kSl, this.kSm.kSj, this.kSm.kSj};
            this.kSn.addRoundRect(this.kSo, this.kSp, Path.Direction.CW);
            try {
                canvas.clipPath(this.kSn);
            } catch (Error e) {
            }
        }
    }

    private void Z(Canvas canvas) {
        if (!this.kSm.mIsRound && this.kSm.mHasBorder) {
            setDrawerType(1);
            this.kSn.reset();
            this.kSo = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.kSp = new float[]{this.kSm.kSi, this.kSm.kSi, this.kSm.kSk, this.kSm.kSk, this.kSm.kSl, this.kSm.kSl, this.kSm.kSj, this.kSm.kSj};
            this.kSn.addRoundRect(this.kSo, this.kSp, Path.Direction.CW);
            try {
                canvas.drawPath(this.kSn, this.PG.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.kSm.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.kSn.reset();
        this.kSo = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.kSp = new float[]{this.kSm.kSi, this.kSm.kSi, this.kSm.kSk, this.kSm.kSk, this.kSm.kSl, this.kSm.kSl, this.kSm.kSj, this.kSm.kSj};
        this.kSn.addRoundRect(this.kSo, this.kSp, Path.Direction.CW);
        try {
            canvas.clipPath(this.kSn);
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
    public void nM(int i) {
        bhs();
    }
}
