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
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class CriusTbClipImageView extends TbClipImageView {
    protected b jMX;
    private Path jMY;
    private RectF jMZ;
    private float[] jNa;
    private int jNb;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jMX = new b();
        this.jMY = new Path();
        this.jNb = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.jMX = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.jMX.jMT = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.jMX.jMU = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.jMX.jMV = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.jMX.jMW = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.jMX.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.jMX.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.jMX.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.jMX.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.jMX.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.jMX.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.jMX.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.jMX.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.jMX.jMT = l.dip2px(getContext(), 4.0f);
            this.jMX.jMU = l.dip2px(getContext(), 4.0f);
            this.jMX.jMV = l.dip2px(getContext(), 4.0f);
            this.jMX.jMW = l.dip2px(getContext(), 4.0f);
            this.jMX.mRadius = l.dip2px(getContext(), 4.0f);
            this.jMX.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.jMX.mBorderColor = 201326592;
        }
        this.jNb = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.jNb != 1) {
            setLayerType(1, null);
        }
        if (!this.jMX.mIsRound) {
            this.jMX.mRadius = 0.0f;
        }
        this.we = this.jMX;
        setConrers(0);
        this.wf = e.im().aa(this.mDrawerType);
        this.wf.a(this.jMX);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.jMX.jMT != i) {
            this.jMX.jMT = i;
            z = true;
        }
        if (this.jMX.jMU != i2) {
            this.jMX.jMU = i2;
            z = true;
        }
        if (this.jMX.jMV != i3) {
            this.jMX.jMV = i3;
            z = true;
        }
        if (this.jMX.jMW != i4) {
            this.jMX.jMW = i4;
            z = true;
        }
        if (z) {
            this.jNb = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.jNb != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.jMX.mRadius = i;
        setRadius(i, i, i, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView, com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        V(canvas);
        super.onDraw(canvas);
        W(canvas);
    }

    private void V(Canvas canvas) {
        if (!this.jMX.mIsRound) {
            setDrawerType(1);
            this.jMY.reset();
            this.jMZ = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jNa = new float[]{this.jMX.jMT, this.jMX.jMT, this.jMX.jMV, this.jMX.jMV, this.jMX.jMW, this.jMX.jMW, this.jMX.jMU, this.jMX.jMU};
            this.jMY.addRoundRect(this.jMZ, this.jNa, Path.Direction.CW);
            try {
                canvas.clipPath(this.jMY);
            } catch (Error e) {
            }
        }
    }

    private void W(Canvas canvas) {
        if (!this.jMX.mIsRound && this.jMX.mHasBorder) {
            setDrawerType(1);
            this.jMY.reset();
            this.jMZ = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jNa = new float[]{this.jMX.jMT, this.jMX.jMT, this.jMX.jMV, this.jMX.jMV, this.jMX.jMW, this.jMX.jMW, this.jMX.jMU, this.jMX.jMU};
            this.jMY.addRoundRect(this.jMZ, this.jNa, Path.Direction.CW);
            try {
                canvas.drawPath(this.jMY, this.wf.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.jMX.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.jMY.reset();
        this.jMZ = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.jNa = new float[]{this.jMX.jMT, this.jMX.jMT, this.jMX.jMV, this.jMX.jMV, this.jMX.jMW, this.jMX.jMW, this.jMX.jMU, this.jMX.jMU};
        this.jMY.addRoundRect(this.jMZ, this.jNa, Path.Direction.CW);
        try {
            canvas.clipPath(this.jMY);
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
    public void mD(int i) {
        aQz();
    }
}
