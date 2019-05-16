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
    protected a iHd;
    private Path iHe;
    private RectF iHf;
    private float[] iHg;
    private int iHh;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iHd = new a();
        this.iHe = new Path();
        this.iHh = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.iHd = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.BDImageView);
            this.iHd.iGZ = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.iHd.iHa = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.iHd.iHb = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.iHd.iHc = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.iHd.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.iHd.GK = obtainStyledAttributes.getBoolean(5, false);
            this.iHd.GL = obtainStyledAttributes.getBoolean(6, false);
            this.iHd.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.iHd.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.iHd.GM = obtainStyledAttributes.getBoolean(9, false);
            this.iHd.GO = obtainStyledAttributes.getBoolean(10, true);
            this.iHd.GQ = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.iHd.iGZ = l.dip2px(getContext(), 4.0f);
            this.iHd.iHa = l.dip2px(getContext(), 4.0f);
            this.iHd.iHb = l.dip2px(getContext(), 4.0f);
            this.iHd.iHc = l.dip2px(getContext(), 4.0f);
            this.iHd.mRadius = l.dip2px(getContext(), 4.0f);
            this.iHd.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.iHd.mBorderColor = 201326592;
        }
        this.iHh = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.iHh != 1) {
            setLayerType(1, null);
        }
        if (!this.iHd.GK) {
            this.iHd.mRadius = 0.0f;
        }
        this.mArgs = this.iHd;
        setConrers(0);
        this.mDrawer = e.lj().aA(this.mDrawerType);
        this.mDrawer.a(this.iHd);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.iHd.iGZ != i) {
            this.iHd.iGZ = i;
            z = true;
        }
        if (this.iHd.iHa != i2) {
            this.iHd.iHa = i2;
            z = true;
        }
        if (this.iHd.iHb != i3) {
            this.iHd.iHb = i3;
            z = true;
        }
        if (this.iHd.iHc != i4) {
            this.iHd.iHc = i4;
            z = true;
        }
        if (z) {
            this.iHh = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.iHh != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.iHd.mRadius = i;
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
        if (!this.iHd.GK) {
            setDrawerType(1);
            this.iHe.reset();
            this.iHf = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iHg = new float[]{this.iHd.iGZ, this.iHd.iGZ, this.iHd.iHb, this.iHd.iHb, this.iHd.iHc, this.iHd.iHc, this.iHd.iHa, this.iHd.iHa};
            this.iHe.addRoundRect(this.iHf, this.iHg, Path.Direction.CW);
            try {
                canvas.clipPath(this.iHe);
            } catch (Error e) {
            }
        }
    }

    private void aa(Canvas canvas) {
        if (!this.iHd.GK && this.iHd.GL) {
            setDrawerType(1);
            this.iHe.reset();
            this.iHf = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iHg = new float[]{this.iHd.iGZ, this.iHd.iGZ, this.iHd.iHb, this.iHd.iHb, this.iHd.iHc, this.iHd.iHc, this.iHd.iHa, this.iHd.iHa};
            this.iHe.addRoundRect(this.iHf, this.iHg, Path.Direction.CW);
            try {
                canvas.drawPath(this.iHe, this.mDrawer.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void drawBackground(Canvas canvas, Drawable drawable) {
        if (this.iHd.GK) {
            super.drawBackground(canvas, drawable);
            return;
        }
        this.iHe.reset();
        this.iHf = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.iHg = new float[]{this.iHd.iGZ, this.iHd.iGZ, this.iHd.iHb, this.iHd.iHb, this.iHd.iHc, this.iHd.iHc, this.iHd.iHa, this.iHd.iHa};
        this.iHe.addRoundRect(this.iHf, this.iHg, Path.Direction.CW);
        try {
            canvas.clipPath(this.iHe);
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
