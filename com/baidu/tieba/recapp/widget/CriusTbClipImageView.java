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
    protected b lmf;
    private Path lmg;
    private RectF lmh;
    private float[] lmi;
    private int lmj;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lmf = new b();
        this.lmg = new Path();
        this.lmj = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.lmf = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.lmf.lmb = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.lmf.lmc = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.lmf.lmd = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.lmf.lme = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.lmf.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.lmf.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.lmf.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.lmf.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.lmf.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.lmf.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.lmf.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.lmf.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.lmf.lmb = l.dip2px(getContext(), 4.0f);
            this.lmf.lmc = l.dip2px(getContext(), 4.0f);
            this.lmf.lmd = l.dip2px(getContext(), 4.0f);
            this.lmf.lme = l.dip2px(getContext(), 4.0f);
            this.lmf.mRadius = l.dip2px(getContext(), 4.0f);
            this.lmf.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.lmf.mBorderColor = 201326592;
        }
        this.lmj = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.lmj != 1) {
            setLayerType(1, null);
        }
        if (!this.lmf.mIsRound) {
            this.lmf.mRadius = 0.0f;
        }
        this.Ql = this.lmf;
        setConrers(0);
        this.Qm = f.nx().aw(this.mDrawerType);
        this.Qm.a(this.lmf);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.lmf.lmb != i) {
            this.lmf.lmb = i;
            z = true;
        }
        if (this.lmf.lmc != i2) {
            this.lmf.lmc = i2;
            z = true;
        }
        if (this.lmf.lmd != i3) {
            this.lmf.lmd = i3;
            z = true;
        }
        if (this.lmf.lme != i4) {
            this.lmf.lme = i4;
            z = true;
        }
        if (z) {
            this.lmj = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.lmj != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.lmf.mRadius = i;
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
        if (!this.lmf.mIsRound) {
            setDrawerType(1);
            this.lmg.reset();
            this.lmh = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.lmi = new float[]{this.lmf.lmb, this.lmf.lmb, this.lmf.lmd, this.lmf.lmd, this.lmf.lme, this.lmf.lme, this.lmf.lmc, this.lmf.lmc};
            this.lmg.addRoundRect(this.lmh, this.lmi, Path.Direction.CW);
            try {
                canvas.clipPath(this.lmg);
            } catch (Error e) {
            }
        }
    }

    private void ae(Canvas canvas) {
        if (!this.lmf.mIsRound && this.lmf.mHasBorder) {
            setDrawerType(1);
            this.lmg.reset();
            this.lmh = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.lmi = new float[]{this.lmf.lmb, this.lmf.lmb, this.lmf.lmd, this.lmf.lmd, this.lmf.lme, this.lmf.lme, this.lmf.lmc, this.lmf.lmc};
            this.lmg.addRoundRect(this.lmh, this.lmi, Path.Direction.CW);
            try {
                canvas.drawPath(this.lmg, this.Qm.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.lmf.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.lmg.reset();
        this.lmh = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.lmi = new float[]{this.lmf.lmb, this.lmf.lmb, this.lmf.lmd, this.lmf.lmd, this.lmf.lme, this.lmf.lme, this.lmf.lmc, this.lmf.lmc};
        this.lmg.addRoundRect(this.lmh, this.lmi, Path.Direction.CW);
        try {
            canvas.clipPath(this.lmg);
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
    public void oi(int i) {
        bjF();
    }
}
