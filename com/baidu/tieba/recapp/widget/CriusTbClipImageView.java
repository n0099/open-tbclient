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
    protected a ioL;
    private Path ioM;
    private RectF ioN;
    private float[] ioO;
    private int ioP;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ioL = new a();
        this.ioM = new Path();
        this.ioP = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.ioL = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.l.BDImageView);
            this.ioL.ioH = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusLeftTop, l.dip2px(getContext(), 4.0f));
            this.ioL.ioI = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusLeftBottom, l.dip2px(getContext(), 4.0f));
            this.ioL.ioJ = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusRightTop, l.dip2px(getContext(), 4.0f));
            this.ioL.ioK = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radiusRightBottom, l.dip2px(getContext(), 4.0f));
            this.ioL.mRadius = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_radius, l.dip2px(getContext(), 4.0f));
            this.ioL.Jc = obtainStyledAttributes.getBoolean(d.l.BDImageView_isRound, false);
            this.ioL.Jd = obtainStyledAttributes.getBoolean(d.l.BDImageView_hasBorder, false);
            this.ioL.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_borderWidth, l.dip2px(getContext(), 1.0f));
            this.ioL.mBorderColor = obtainStyledAttributes.getColor(d.l.BDImageView_borderColor, 201326592);
            this.ioL.Je = obtainStyledAttributes.getBoolean(d.l.BDImageView_borderSurroundContent, false);
            this.ioL.Jg = obtainStyledAttributes.getBoolean(d.l.BDImageView_showGifIcon, true);
            this.ioL.Ji = obtainStyledAttributes.getColor(d.l.BDImageView_foregroundColor, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(d.l.BDImageView_drawerType, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(d.l.BDImageView_maxHeight, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(d.l.BDImageView_adjustViewBounds, false);
            obtainStyledAttributes.recycle();
        } else {
            this.ioL.ioH = l.dip2px(getContext(), 4.0f);
            this.ioL.ioI = l.dip2px(getContext(), 4.0f);
            this.ioL.ioJ = l.dip2px(getContext(), 4.0f);
            this.ioL.ioK = l.dip2px(getContext(), 4.0f);
            this.ioL.mRadius = l.dip2px(getContext(), 4.0f);
            this.ioL.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.ioL.mBorderColor = 201326592;
        }
        this.ioP = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.ioP != 1) {
            setLayerType(1, null);
        }
        if (!this.ioL.Jc) {
            this.ioL.mRadius = 0.0f;
        }
        this.mArgs = this.ioL;
        setConrers(0);
        this.mDrawer = e.mp().aI(this.mDrawerType);
        this.mDrawer.a(this.ioL);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.ioL.ioH != i) {
            this.ioL.ioH = i;
            z = true;
        }
        if (this.ioL.ioI != i2) {
            this.ioL.ioI = i2;
            z = true;
        }
        if (this.ioL.ioJ != i3) {
            this.ioL.ioJ = i3;
            z = true;
        }
        if (this.ioL.ioK != i4) {
            this.ioL.ioK = i4;
            z = true;
        }
        if (z) {
            this.ioP = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.ioP != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.ioL.mRadius = i;
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
        if (!this.ioL.Jc) {
            setDrawerType(1);
            this.ioM.reset();
            this.ioN = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ioO = new float[]{this.ioL.ioH, this.ioL.ioH, this.ioL.ioJ, this.ioL.ioJ, this.ioL.ioK, this.ioL.ioK, this.ioL.ioI, this.ioL.ioI};
            this.ioM.addRoundRect(this.ioN, this.ioO, Path.Direction.CW);
            try {
                canvas.clipPath(this.ioM);
            } catch (Error e) {
            }
        }
    }

    private void Z(Canvas canvas) {
        if (!this.ioL.Jc && this.ioL.Jd) {
            setDrawerType(1);
            this.ioM.reset();
            this.ioN = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.ioO = new float[]{this.ioL.ioH, this.ioL.ioH, this.ioL.ioJ, this.ioL.ioJ, this.ioL.ioK, this.ioL.ioK, this.ioL.ioI, this.ioL.ioI};
            this.ioM.addRoundRect(this.ioN, this.ioO, Path.Direction.CW);
            try {
                canvas.drawPath(this.ioM, this.mDrawer.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void drawBackground(Canvas canvas, Drawable drawable) {
        if (this.ioL.Jc) {
            super.drawBackground(canvas, drawable);
            return;
        }
        this.ioM.reset();
        this.ioN = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.ioO = new float[]{this.ioL.ioH, this.ioL.ioH, this.ioL.ioJ, this.ioL.ioJ, this.ioL.ioK, this.ioL.ioK, this.ioL.ioI, this.ioL.ioI};
        this.ioM.addRoundRect(this.ioN, this.ioO, Path.Direction.CW);
        try {
            canvas.clipPath(this.ioM);
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
