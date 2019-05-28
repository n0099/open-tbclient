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
    protected a iHf;
    private Path iHg;
    private RectF iHh;
    private float[] iHi;
    private int iHj;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iHf = new a();
        this.iHg = new Path();
        this.iHj = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.iHf = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.BDImageView);
            this.iHf.iHb = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.iHf.iHc = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.iHf.iHd = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.iHf.iHe = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.iHf.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.iHf.GK = obtainStyledAttributes.getBoolean(5, false);
            this.iHf.GL = obtainStyledAttributes.getBoolean(6, false);
            this.iHf.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.iHf.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.iHf.GM = obtainStyledAttributes.getBoolean(9, false);
            this.iHf.GO = obtainStyledAttributes.getBoolean(10, true);
            this.iHf.GQ = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.iHf.iHb = l.dip2px(getContext(), 4.0f);
            this.iHf.iHc = l.dip2px(getContext(), 4.0f);
            this.iHf.iHd = l.dip2px(getContext(), 4.0f);
            this.iHf.iHe = l.dip2px(getContext(), 4.0f);
            this.iHf.mRadius = l.dip2px(getContext(), 4.0f);
            this.iHf.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.iHf.mBorderColor = 201326592;
        }
        this.iHj = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.iHj != 1) {
            setLayerType(1, null);
        }
        if (!this.iHf.GK) {
            this.iHf.mRadius = 0.0f;
        }
        this.mArgs = this.iHf;
        setConrers(0);
        this.mDrawer = e.lj().aA(this.mDrawerType);
        this.mDrawer.a(this.iHf);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.iHf.iHb != i) {
            this.iHf.iHb = i;
            z = true;
        }
        if (this.iHf.iHc != i2) {
            this.iHf.iHc = i2;
            z = true;
        }
        if (this.iHf.iHd != i3) {
            this.iHf.iHd = i3;
            z = true;
        }
        if (this.iHf.iHe != i4) {
            this.iHf.iHe = i4;
            z = true;
        }
        if (z) {
            this.iHj = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.iHj != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.iHf.mRadius = i;
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
        if (!this.iHf.GK) {
            setDrawerType(1);
            this.iHg.reset();
            this.iHh = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iHi = new float[]{this.iHf.iHb, this.iHf.iHb, this.iHf.iHd, this.iHf.iHd, this.iHf.iHe, this.iHf.iHe, this.iHf.iHc, this.iHf.iHc};
            this.iHg.addRoundRect(this.iHh, this.iHi, Path.Direction.CW);
            try {
                canvas.clipPath(this.iHg);
            } catch (Error e) {
            }
        }
    }

    private void aa(Canvas canvas) {
        if (!this.iHf.GK && this.iHf.GL) {
            setDrawerType(1);
            this.iHg.reset();
            this.iHh = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iHi = new float[]{this.iHf.iHb, this.iHf.iHb, this.iHf.iHd, this.iHf.iHd, this.iHf.iHe, this.iHf.iHe, this.iHf.iHc, this.iHf.iHc};
            this.iHg.addRoundRect(this.iHh, this.iHi, Path.Direction.CW);
            try {
                canvas.drawPath(this.iHg, this.mDrawer.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void drawBackground(Canvas canvas, Drawable drawable) {
        if (this.iHf.GK) {
            super.drawBackground(canvas, drawable);
            return;
        }
        this.iHg.reset();
        this.iHh = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.iHi = new float[]{this.iHf.iHb, this.iHf.iHb, this.iHf.iHd, this.iHf.iHd, this.iHf.iHe, this.iHf.iHe, this.iHf.iHc, this.iHf.iHc};
        this.iHg.addRoundRect(this.iHh, this.iHi, Path.Direction.CW);
        try {
            canvas.clipPath(this.iHg);
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
