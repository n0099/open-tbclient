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
    protected b iOE;
    private Path iOF;
    private RectF iOG;
    private float[] iOH;
    private int iOI;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iOE = new b();
        this.iOF = new Path();
        this.iOI = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.iOE = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.a.BDImageView);
            this.iOE.iOA = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.iOE.iOB = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.iOE.iOC = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.iOE.iOD = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.iOE.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.iOE.GU = obtainStyledAttributes.getBoolean(5, false);
            this.iOE.GV = obtainStyledAttributes.getBoolean(6, false);
            this.iOE.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.iOE.GW = obtainStyledAttributes.getColor(8, 201326592);
            this.iOE.GX = obtainStyledAttributes.getBoolean(9, false);
            this.iOE.GZ = obtainStyledAttributes.getBoolean(10, true);
            this.iOE.Hc = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.iOE.iOA = l.dip2px(getContext(), 4.0f);
            this.iOE.iOB = l.dip2px(getContext(), 4.0f);
            this.iOE.iOC = l.dip2px(getContext(), 4.0f);
            this.iOE.iOD = l.dip2px(getContext(), 4.0f);
            this.iOE.mRadius = l.dip2px(getContext(), 4.0f);
            this.iOE.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.iOE.GW = 201326592;
        }
        this.iOI = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.iOI != 1) {
            setLayerType(1, null);
        }
        if (!this.iOE.GU) {
            this.iOE.mRadius = 0.0f;
        }
        this.mArgs = this.iOE;
        setConrers(0);
        this.mDrawer = e.lz().aA(this.mDrawerType);
        this.mDrawer.a(this.iOE);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.iOE.iOA != i) {
            this.iOE.iOA = i;
            z = true;
        }
        if (this.iOE.iOB != i2) {
            this.iOE.iOB = i2;
            z = true;
        }
        if (this.iOE.iOC != i3) {
            this.iOE.iOC = i3;
            z = true;
        }
        if (this.iOE.iOD != i4) {
            this.iOE.iOD = i4;
            z = true;
        }
        if (z) {
            this.iOI = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.iOI != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.iOE.mRadius = i;
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
        if (!this.iOE.GU) {
            setDrawerType(1);
            this.iOF.reset();
            this.iOG = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iOH = new float[]{this.iOE.iOA, this.iOE.iOA, this.iOE.iOC, this.iOE.iOC, this.iOE.iOD, this.iOE.iOD, this.iOE.iOB, this.iOE.iOB};
            this.iOF.addRoundRect(this.iOG, this.iOH, Path.Direction.CW);
            try {
                canvas.clipPath(this.iOF);
            } catch (Error e) {
            }
        }
    }

    private void aa(Canvas canvas) {
        if (!this.iOE.GU && this.iOE.GV) {
            setDrawerType(1);
            this.iOF.reset();
            this.iOG = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.iOH = new float[]{this.iOE.iOA, this.iOE.iOA, this.iOE.iOC, this.iOE.iOC, this.iOE.iOD, this.iOE.iOD, this.iOE.iOB, this.iOE.iOB};
            this.iOF.addRoundRect(this.iOG, this.iOH, Path.Direction.CW);
            try {
                canvas.drawPath(this.iOF, this.mDrawer.GF);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void drawBackground(Canvas canvas, Drawable drawable) {
        if (this.iOE.GU) {
            super.drawBackground(canvas, drawable);
            return;
        }
        this.iOF.reset();
        this.iOG = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.iOH = new float[]{this.iOE.iOA, this.iOE.iOA, this.iOE.iOC, this.iOE.iOC, this.iOE.iOD, this.iOE.iOD, this.iOE.iOB, this.iOE.iOB};
        this.iOF.addRoundRect(this.iOG, this.iOH, Path.Direction.CW);
        try {
            canvas.clipPath(this.iOF);
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
