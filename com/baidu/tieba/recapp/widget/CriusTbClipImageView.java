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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected a ioo;
    private Path iop;
    private RectF ioq;
    private float[] ior;
    private int ios;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ioo = new a();
        this.iop = new Path();
        this.ios = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.ioo = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.BDImageView);
            this.ioo.iok = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.ioo.iol = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.ioo.iom = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.ioo.ion = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.ioo.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.ioo.Jc = obtainStyledAttributes.getBoolean(d.l.BDImageView_isRound, false);
            this.ioo.Jd = obtainStyledAttributes.getBoolean(d.l.BDImageView_hasBorder, false);
            this.ioo.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.ioo.mBorderColor = obtainStyledAttributes.getColor(d.l.BDImageView_borderColor, 201326592);
            this.ioo.Je = obtainStyledAttributes.getBoolean(d.l.BDImageView_borderSurroundContent, false);
            this.ioo.Jg = obtainStyledAttributes.getBoolean(d.l.BDImageView_showGifIcon, true);
            this.ioo.Ji = obtainStyledAttributes.getColor(d.l.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(d.l.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(d.l.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.ioo.iok = l.dip2px(getContext(), 4.0f);
            this.ioo.iol = l.dip2px(getContext(), 4.0f);
            this.ioo.iom = l.dip2px(getContext(), 4.0f);
            this.ioo.ion = l.dip2px(getContext(), 4.0f);
            this.ioo.mRadius = l.dip2px(getContext(), 4.0f);
            this.ioo.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.ioo.mBorderColor = 201326592;
        }
        this.ios = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.ios != 1) {
            setLayerType(1, null);
        }
        if (!this.ioo.Jc) {
            this.ioo.mRadius = 0.0f;
        }
        this.mArgs = this.ioo;
        setConrers(0);
        this.mDrawer = e.mp().aH(this.mDrawerType);
        this.mDrawer.a(this.ioo);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.ioo.iok != i) {
            this.ioo.iok = i;
            z = true;
        }
        if (this.ioo.iol != i2) {
            this.ioo.iol = i2;
            z = true;
        }
        if (this.ioo.iom != i3) {
            this.ioo.iom = i3;
            z = true;
        }
        if (this.ioo.ion != i4) {
            this.ioo.ion = i4;
            z = true;
        }
        if (z) {
            this.ios = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.ios != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.ioo.mRadius = i;
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
        if (!this.ioo.Jc) {
            setDrawerType(1);
            this.iop.reset();
            this.ioq = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ior = new float[]{this.ioo.iok, this.ioo.iok, this.ioo.iom, this.ioo.iom, this.ioo.ion, this.ioo.ion, this.ioo.iol, this.ioo.iol};
            this.iop.addRoundRect(this.ioq, this.ior, Path.Direction.CW);
            try {
                canvas.clipPath(this.iop);
            } catch (Error e) {
            }
        }
    }

    private void Z(Canvas canvas) {
        if (!this.ioo.Jc && this.ioo.Jd) {
            setDrawerType(1);
            this.iop.reset();
            this.ioq = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ior = new float[]{this.ioo.iok, this.ioo.iok, this.ioo.iom, this.ioo.iom, this.ioo.ion, this.ioo.ion, this.ioo.iol, this.ioo.iol};
            this.iop.addRoundRect(this.ioq, this.ior, Path.Direction.CW);
            try {
                canvas.drawPath(this.iop, this.mDrawer.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void drawBackground(Canvas canvas, Drawable drawable) {
        if (this.ioo.Jc) {
            super.drawBackground(canvas, drawable);
            return;
        }
        this.iop.reset();
        this.ioq = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.ior = new float[]{this.ioo.iok, this.ioo.iok, this.ioo.iom, this.ioo.iom, this.ioo.ion, this.ioo.ion, this.ioo.iol, this.ioo.iol};
        this.iop.addRoundRect(this.ioq, this.ior, Path.Direction.CW);
        try {
            canvas.clipPath(this.iop);
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
