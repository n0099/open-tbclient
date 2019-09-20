package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.newwidget.ImageView.e;
import com.baidu.tbadk.widget.TbClipImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b iRa;
    private Path iRb;
    private RectF iRc;
    private float[] iRd;
    private int iRe;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iRa = new b();
        this.iRb = new Path();
        this.iRe = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.iRa = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.a.BDImageView);
            this.iRa.iQW = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.iRa.iQX = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.iRa.iQY = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.iRa.iQZ = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.iRa.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.iRa.GU = obtainStyledAttributes.getBoolean(5, false);
            this.iRa.GV = obtainStyledAttributes.getBoolean(6, false);
            this.iRa.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.iRa.GW = obtainStyledAttributes.getColor(8, 201326592);
            this.iRa.GX = obtainStyledAttributes.getBoolean(9, false);
            this.iRa.GZ = obtainStyledAttributes.getBoolean(10, true);
            this.iRa.Hc = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.iRa.iQW = l.dip2px(getContext(), 4.0f);
            this.iRa.iQX = l.dip2px(getContext(), 4.0f);
            this.iRa.iQY = l.dip2px(getContext(), 4.0f);
            this.iRa.iQZ = l.dip2px(getContext(), 4.0f);
            this.iRa.mRadius = l.dip2px(getContext(), 4.0f);
            this.iRa.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.iRa.GW = 201326592;
        }
        this.iRe = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.iRe != 1) {
            setLayerType(1, null);
        }
        if (!this.iRa.GU) {
            this.iRa.mRadius = 0.0f;
        }
        this.mArgs = this.iRa;
        setConrers(0);
        this.mDrawer = e.lz().aA(this.mDrawerType);
        this.mDrawer.a(this.iRa);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.iRa.iQW != i) {
            this.iRa.iQW = i;
            z = true;
        }
        if (this.iRa.iQX != i2) {
            this.iRa.iQX = i2;
            z = true;
        }
        if (this.iRa.iQY != i3) {
            this.iRa.iQY = i3;
            z = true;
        }
        if (this.iRa.iQZ != i4) {
            this.iRa.iQZ = i4;
            z = true;
        }
        if (z) {
            this.iRe = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.iRe != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.iRa.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        aa(canvas);
        super.onDraw(canvas);
        ab(canvas);
    }

    private void aa(Canvas canvas) {
        if (!this.iRa.GU) {
            setDrawerType(1);
            this.iRb.reset();
            this.iRc = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iRd = new float[]{this.iRa.iQW, this.iRa.iQW, this.iRa.iQY, this.iRa.iQY, this.iRa.iQZ, this.iRa.iQZ, this.iRa.iQX, this.iRa.iQX};
            this.iRb.addRoundRect(this.iRc, this.iRd, Path.Direction.CW);
            try {
                canvas.clipPath(this.iRb);
            } catch (Error e) {
            }
        }
    }

    private void ab(Canvas canvas) {
        if (!this.iRa.GU && this.iRa.GV) {
            setDrawerType(1);
            this.iRb.reset();
            this.iRc = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iRd = new float[]{this.iRa.iQW, this.iRa.iQW, this.iRa.iQY, this.iRa.iQY, this.iRa.iQZ, this.iRa.iQZ, this.iRa.iQX, this.iRa.iQX};
            this.iRb.addRoundRect(this.iRc, this.iRd, Path.Direction.CW);
            try {
                canvas.drawPath(this.iRb, this.mDrawer.GF);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void drawBackground(Canvas canvas, Drawable drawable) {
        if (this.iRa.GU) {
            super.drawBackground(canvas, drawable);
            return;
        }
        this.iRb.reset();
        this.iRc = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.iRd = new float[]{this.iRa.iQW, this.iRa.iQW, this.iRa.iQY, this.iRa.iQY, this.iRa.iQZ, this.iRa.iQZ, this.iRa.iQX, this.iRa.iQX};
        this.iRb.addRoundRect(this.iRc, this.iRd, Path.Direction.CW);
        try {
            canvas.clipPath(this.iRb);
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
