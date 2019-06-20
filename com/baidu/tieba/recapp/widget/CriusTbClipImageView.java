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
import com.baidu.adp.newwidget.ImageView.e;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.c;
/* loaded from: classes3.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b iHi;
    private Path iHj;
    private RectF iHk;
    private float[] iHl;
    private int iHm;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iHi = new b();
        this.iHj = new Path();
        this.iHm = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.iHi = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.BDImageView);
            this.iHi.iHe = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.iHi.iHf = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.iHi.iHg = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.iHi.iHh = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.iHi.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.iHi.GJ = obtainStyledAttributes.getBoolean(5, false);
            this.iHi.GK = obtainStyledAttributes.getBoolean(6, false);
            this.iHi.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.iHi.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.iHi.GL = obtainStyledAttributes.getBoolean(9, false);
            this.iHi.GN = obtainStyledAttributes.getBoolean(10, true);
            this.iHi.GP = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.iHi.iHe = l.dip2px(getContext(), 4.0f);
            this.iHi.iHf = l.dip2px(getContext(), 4.0f);
            this.iHi.iHg = l.dip2px(getContext(), 4.0f);
            this.iHi.iHh = l.dip2px(getContext(), 4.0f);
            this.iHi.mRadius = l.dip2px(getContext(), 4.0f);
            this.iHi.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.iHi.mBorderColor = 201326592;
        }
        this.iHm = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.iHm != 1) {
            setLayerType(1, null);
        }
        if (!this.iHi.GJ) {
            this.iHi.mRadius = 0.0f;
        }
        this.mArgs = this.iHi;
        setConrers(0);
        this.mDrawer = e.lj().aA(this.mDrawerType);
        this.mDrawer.a(this.iHi);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.iHi.iHe != i) {
            this.iHi.iHe = i;
            z = true;
        }
        if (this.iHi.iHf != i2) {
            this.iHi.iHf = i2;
            z = true;
        }
        if (this.iHi.iHg != i3) {
            this.iHi.iHg = i3;
            z = true;
        }
        if (this.iHi.iHh != i4) {
            this.iHi.iHh = i4;
            z = true;
        }
        if (z) {
            this.iHm = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.iHm != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.iHi.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Z(canvas);
        super.onDraw(canvas);
        aa(canvas);
    }

    private void Z(Canvas canvas) {
        if (!this.iHi.GJ) {
            setDrawerType(1);
            this.iHj.reset();
            this.iHk = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iHl = new float[]{this.iHi.iHe, this.iHi.iHe, this.iHi.iHg, this.iHi.iHg, this.iHi.iHh, this.iHi.iHh, this.iHi.iHf, this.iHi.iHf};
            this.iHj.addRoundRect(this.iHk, this.iHl, Path.Direction.CW);
            try {
                canvas.clipPath(this.iHj);
            } catch (Error e) {
            }
        }
    }

    private void aa(Canvas canvas) {
        if (!this.iHi.GJ && this.iHi.GK) {
            setDrawerType(1);
            this.iHj.reset();
            this.iHk = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iHl = new float[]{this.iHi.iHe, this.iHi.iHe, this.iHi.iHg, this.iHi.iHg, this.iHi.iHh, this.iHi.iHh, this.iHi.iHf, this.iHi.iHf};
            this.iHj.addRoundRect(this.iHk, this.iHl, Path.Direction.CW);
            try {
                canvas.drawPath(this.iHj, this.mDrawer.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void drawBackground(Canvas canvas, Drawable drawable) {
        if (this.iHi.GJ) {
            super.drawBackground(canvas, drawable);
            return;
        }
        this.iHj.reset();
        this.iHk = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.iHl = new float[]{this.iHi.iHe, this.iHi.iHe, this.iHi.iHg, this.iHi.iHg, this.iHi.iHh, this.iHi.iHh, this.iHi.iHf, this.iHi.iHf};
        this.iHj.addRoundRect(this.iHk, this.iHl, Path.Direction.CW);
        try {
            canvas.clipPath(this.iHj);
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
    public void addCornerFlags(int i) {
        clearCornerFlag();
    }
}
