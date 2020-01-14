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
    protected b jNc;
    private Path jNd;
    private RectF jNe;
    private float[] jNf;
    private int jNg;

    public CriusTbClipImageView(Context context) {
        this(context, null, 0);
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jNc = new b();
        this.jNd = new Path();
        this.jNg = getLayerType();
    }

    public CriusTbClipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.jNc = new b();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BDImageView);
            this.jNc.jMY = obtainStyledAttributes.getDimensionPixelSize(1, l.dip2px(getContext(), 4.0f));
            this.jNc.jMZ = obtainStyledAttributes.getDimensionPixelSize(2, l.dip2px(getContext(), 4.0f));
            this.jNc.jNa = obtainStyledAttributes.getDimensionPixelSize(3, l.dip2px(getContext(), 4.0f));
            this.jNc.jNb = obtainStyledAttributes.getDimensionPixelSize(4, l.dip2px(getContext(), 4.0f));
            this.jNc.mRadius = obtainStyledAttributes.getDimensionPixelSize(0, l.dip2px(getContext(), 4.0f));
            this.jNc.mIsRound = obtainStyledAttributes.getBoolean(5, false);
            this.jNc.mHasBorder = obtainStyledAttributes.getBoolean(6, false);
            this.jNc.mBorderWidth = obtainStyledAttributes.getDimensionPixelSize(7, l.dip2px(getContext(), 1.0f));
            this.jNc.mBorderColor = obtainStyledAttributes.getColor(8, 201326592);
            this.jNc.mBorderSurroundContent = obtainStyledAttributes.getBoolean(9, false);
            this.jNc.mIsShowGifIcon = obtainStyledAttributes.getBoolean(10, true);
            this.jNc.mForegroundColor = obtainStyledAttributes.getColor(16, 0);
            this.mDrawerType = obtainStyledAttributes.getInt(12, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(13, Integer.MAX_VALUE);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(14, Integer.MAX_VALUE);
            this.mAdjustViewBounds = obtainStyledAttributes.getBoolean(15, false);
            obtainStyledAttributes.recycle();
        } else {
            this.jNc.jMY = l.dip2px(getContext(), 4.0f);
            this.jNc.jMZ = l.dip2px(getContext(), 4.0f);
            this.jNc.jNa = l.dip2px(getContext(), 4.0f);
            this.jNc.jNb = l.dip2px(getContext(), 4.0f);
            this.jNc.mRadius = l.dip2px(getContext(), 4.0f);
            this.jNc.mBorderWidth = l.dip2px(getContext(), 1.0f);
            this.jNc.mBorderColor = 201326592;
        }
        this.jNg = getLayerType();
        if (Build.VERSION.SDK_INT < 18 && this.jNg != 1) {
            setLayerType(1, null);
        }
        if (!this.jNc.mIsRound) {
            this.jNc.mRadius = 0.0f;
        }
        this.we = this.jNc;
        setConrers(0);
        this.wf = e.im().aa(this.mDrawerType);
        this.wf.a(this.jNc);
    }

    public void setRadius(int i, int i2, int i3, int i4) {
        boolean z = false;
        if (this.jNc.jMY != i) {
            this.jNc.jMY = i;
            z = true;
        }
        if (this.jNc.jMZ != i2) {
            this.jNc.jMZ = i2;
            z = true;
        }
        if (this.jNc.jNa != i3) {
            this.jNc.jNa = i3;
            z = true;
        }
        if (this.jNc.jNb != i4) {
            this.jNc.jNb = i4;
            z = true;
        }
        if (z) {
            this.jNg = getLayerType();
            if (Build.VERSION.SDK_INT < 18 && this.jNg != 1) {
                setLayerType(1, null);
            }
            invalidate();
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setRadius(int i) {
        this.jNc.mRadius = i;
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
        if (!this.jNc.mIsRound) {
            setDrawerType(1);
            this.jNd.reset();
            this.jNe = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jNf = new float[]{this.jNc.jMY, this.jNc.jMY, this.jNc.jNa, this.jNc.jNa, this.jNc.jNb, this.jNc.jNb, this.jNc.jMZ, this.jNc.jMZ};
            this.jNd.addRoundRect(this.jNe, this.jNf, Path.Direction.CW);
            try {
                canvas.clipPath(this.jNd);
            } catch (Error e) {
            }
        }
    }

    private void W(Canvas canvas) {
        if (!this.jNc.mIsRound && this.jNc.mHasBorder) {
            setDrawerType(1);
            this.jNd.reset();
            this.jNe = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            this.jNf = new float[]{this.jNc.jMY, this.jNc.jMY, this.jNc.jNa, this.jNc.jNa, this.jNc.jNb, this.jNc.jNb, this.jNc.jMZ, this.jNc.jMZ};
            this.jNd.addRoundRect(this.jNe, this.jNf, Path.Direction.CW);
            try {
                canvas.drawPath(this.jNd, this.wf.mBorderPaint);
            } catch (Error e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.widget.TbImageView
    public void c(Canvas canvas, Drawable drawable) {
        if (this.jNc.mIsRound) {
            super.c(canvas, drawable);
            return;
        }
        this.jNd.reset();
        this.jNe = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.jNf = new float[]{this.jNc.jMY, this.jNc.jMY, this.jNc.jNa, this.jNc.jNa, this.jNc.jNb, this.jNc.jNb, this.jNc.jMZ, this.jNc.jMZ};
        this.jNd.addRoundRect(this.jNe, this.jNf, Path.Direction.CW);
        try {
            canvas.clipPath(this.jNd);
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
