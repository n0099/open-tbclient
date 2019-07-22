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
    protected b iNA;
    private Path iNB;
    private RectF iNC;
    private float[] iND;
    private int iNE;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iNA = new b();
        this.iNB = new Path();
        this.iNE = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.iNA = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.BDImageView);
            this.iNA.iNw = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.iNA.iNx = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.iNA.iNy = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.iNA.iNz = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.iNA.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.iNA.GU = obtainStyledAttributes.getBoolean(5, false);
            this.iNA.GV = obtainStyledAttributes.getBoolean(6, false);
            this.iNA.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.iNA.GW = obtainStyledAttributes.getColor(8, 201326592);
            this.iNA.GX = obtainStyledAttributes.getBoolean(9, false);
            this.iNA.GZ = obtainStyledAttributes.getBoolean(10, true);
            this.iNA.Hc = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.iNA.iNw = l.dip2px(getContext(), 4.0f);
            this.iNA.iNx = l.dip2px(getContext(), 4.0f);
            this.iNA.iNy = l.dip2px(getContext(), 4.0f);
            this.iNA.iNz = l.dip2px(getContext(), 4.0f);
            this.iNA.mRadius = l.dip2px(getContext(), 4.0f);
            this.iNA.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.iNA.GW = 201326592;
        }
        this.iNE = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.iNE != 1) {
            setLayerType(1, null);
        }
        if (!this.iNA.GU) {
            this.iNA.mRadius = 0.0f;
        }
        this.mArgs = this.iNA;
        setConrers(0);
        this.mDrawer = e.lz().aA(this.mDrawerType);
        this.mDrawer.a(this.iNA);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.iNA.iNw != i) {
            this.iNA.iNw = i;
            z = true;
        }
        if (this.iNA.iNx != i2) {
            this.iNA.iNx = i2;
            z = true;
        }
        if (this.iNA.iNy != i3) {
            this.iNA.iNy = i3;
            z = true;
        }
        if (this.iNA.iNz != i4) {
            this.iNA.iNz = i4;
            z = true;
        }
        if (z) {
            this.iNE = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.iNE != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.iNA.mRadius = i;
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
        if (!this.iNA.GU) {
            setDrawerType(1);
            this.iNB.reset();
            this.iNC = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iND = new float[]{this.iNA.iNw, this.iNA.iNw, this.iNA.iNy, this.iNA.iNy, this.iNA.iNz, this.iNA.iNz, this.iNA.iNx, this.iNA.iNx};
            this.iNB.addRoundRect(this.iNC, this.iND, Path.Direction.CW);
            try {
                canvas.clipPath(this.iNB);
            } catch (Error e) {
            }
        }
    }

    private void aa(Canvas canvas) {
        if (!this.iNA.GU && this.iNA.GV) {
            setDrawerType(1);
            this.iNB.reset();
            this.iNC = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iND = new float[]{this.iNA.iNw, this.iNA.iNw, this.iNA.iNy, this.iNA.iNy, this.iNA.iNz, this.iNA.iNz, this.iNA.iNx, this.iNA.iNx};
            this.iNB.addRoundRect(this.iNC, this.iND, Path.Direction.CW);
            try {
                canvas.drawPath(this.iNB, this.mDrawer.GF);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void drawBackground(Canvas canvas, Drawable drawable) {
        if (this.iNA.GU) {
            super.drawBackground(canvas, drawable);
            return;
        }
        this.iNB.reset();
        this.iNC = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.iND = new float[]{this.iNA.iNw, this.iNA.iNw, this.iNA.iNy, this.iNA.iNy, this.iNA.iNz, this.iNA.iNz, this.iNA.iNx, this.iNA.iNx};
        this.iNB.addRoundRect(this.iNC, this.iND, Path.Direction.CW);
        try {
            canvas.clipPath(this.iNB);
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
