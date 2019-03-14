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
    protected a ioE;
    private Path ioF;
    private RectF ioG;
    private float[] ioH;
    private int ioI;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ioE = new a();
        this.ioF = new Path();
        this.ioI = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.ioE = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.BDImageView);
            this.ioE.ioA = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.ioE.ioB = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.ioE.ioC = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.ioE.ioD = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.ioE.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.ioE.Jc = obtainStyledAttributes.getBoolean(d.l.BDImageView_isRound, false);
            this.ioE.Jd = obtainStyledAttributes.getBoolean(d.l.BDImageView_hasBorder, false);
            this.ioE.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.ioE.mBorderColor = obtainStyledAttributes.getColor(d.l.BDImageView_borderColor, 201326592);
            this.ioE.Je = obtainStyledAttributes.getBoolean(d.l.BDImageView_borderSurroundContent, false);
            this.ioE.Jg = obtainStyledAttributes.getBoolean(d.l.BDImageView_showGifIcon, true);
            this.ioE.Ji = obtainStyledAttributes.getColor(d.l.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(d.l.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(d.l.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.ioE.ioA = l.dip2px(getContext(), 4.0f);
            this.ioE.ioB = l.dip2px(getContext(), 4.0f);
            this.ioE.ioC = l.dip2px(getContext(), 4.0f);
            this.ioE.ioD = l.dip2px(getContext(), 4.0f);
            this.ioE.mRadius = l.dip2px(getContext(), 4.0f);
            this.ioE.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.ioE.mBorderColor = 201326592;
        }
        this.ioI = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.ioI != 1) {
            setLayerType(1, null);
        }
        if (!this.ioE.Jc) {
            this.ioE.mRadius = 0.0f;
        }
        this.mArgs = this.ioE;
        setConrers(0);
        this.mDrawer = e.mp().aI(this.mDrawerType);
        this.mDrawer.a(this.ioE);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.ioE.ioA != i) {
            this.ioE.ioA = i;
            z = true;
        }
        if (this.ioE.ioB != i2) {
            this.ioE.ioB = i2;
            z = true;
        }
        if (this.ioE.ioC != i3) {
            this.ioE.ioC = i3;
            z = true;
        }
        if (this.ioE.ioD != i4) {
            this.ioE.ioD = i4;
            z = true;
        }
        if (z) {
            this.ioI = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.ioI != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.ioE.mRadius = i;
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
        if (!this.ioE.Jc) {
            setDrawerType(1);
            this.ioF.reset();
            this.ioG = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ioH = new float[]{this.ioE.ioA, this.ioE.ioA, this.ioE.ioC, this.ioE.ioC, this.ioE.ioD, this.ioE.ioD, this.ioE.ioB, this.ioE.ioB};
            this.ioF.addRoundRect(this.ioG, this.ioH, Path.Direction.CW);
            try {
                canvas.clipPath(this.ioF);
            } catch (Error e) {
            }
        }
    }

    private void Z(Canvas canvas) {
        if (!this.ioE.Jc && this.ioE.Jd) {
            setDrawerType(1);
            this.ioF.reset();
            this.ioG = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ioH = new float[]{this.ioE.ioA, this.ioE.ioA, this.ioE.ioC, this.ioE.ioC, this.ioE.ioD, this.ioE.ioD, this.ioE.ioB, this.ioE.ioB};
            this.ioF.addRoundRect(this.ioG, this.ioH, Path.Direction.CW);
            try {
                canvas.drawPath(this.ioF, this.mDrawer.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void drawBackground(Canvas canvas, Drawable drawable) {
        if (this.ioE.Jc) {
            super.drawBackground(canvas, drawable);
            return;
        }
        this.ioF.reset();
        this.ioG = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.ioH = new float[]{this.ioE.ioA, this.ioE.ioA, this.ioE.ioC, this.ioE.ioC, this.ioE.ioD, this.ioE.ioD, this.ioE.ioB, this.ioE.ioB};
        this.ioF.addRoundRect(this.ioG, this.ioH, Path.Direction.CW);
        try {
            canvas.clipPath(this.ioF);
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
