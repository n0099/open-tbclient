package com.baidu.yuyinala.privatemessage.session.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
/* loaded from: classes4.dex */
public class TagView extends View {
    private Paint bhF;
    private int mBgColor;
    private Context mContext;
    private int mTextColor;
    private Paint mTextPaint;
    private float mTextSize;
    private int oXK;
    private int oXL;
    private int oXM;
    private int oXN;
    private int oXO;
    private float oXP;
    private float oXQ;
    private float oXR;
    private float oXS;
    private float oXT;
    private float oXU;
    private float oXV;
    private float oXW;
    private String oXX;
    private int oXY;
    private boolean oXZ;
    private Paint oYa;
    private LinearGradient oYb;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oXK = -1;
        this.oXP = -1.0f;
        this.oXQ = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.oXX = str;
        if (!TextUtils.isEmpty(this.oXX)) {
            this.oXY = this.oXX.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.oXX;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.oXL = -1;
        this.oXM = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.oXL = i;
        this.oXM = i2;
        this.mBgColor = -1;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            if (this.oXK == 1) {
                size = (int) this.oXQ;
            } else if (this.oXK == 2) {
                size = (int) ((this.oXW * 2.0f) + (this.oXR * 2.0f));
                if (!TextUtils.isEmpty(this.oXX)) {
                    if (this.oXY == 1) {
                        size = (int) this.oXP;
                    } else {
                        size = (int) (size + this.mTextPaint.measureText(this.oXX));
                    }
                }
            } else {
                size = (int) ((this.oXW * 2.0f) + (this.oXR * 2.0f));
                if (!TextUtils.isEmpty(this.oXX)) {
                    size = (int) (size + this.mTextPaint.measureText(this.oXX));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.oXP;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.oXQ = i;
        this.oXP = i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ar(canvas);
        as(canvas);
        C(canvas);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, a.j.TagView);
        this.mBgColor = obtainStyledAttributes.getColor(a.j.TagView_bgColor, 0);
        this.oXL = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.oXM = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.oXO = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.oXN = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.oXZ = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.oXW = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.oXR = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.oXS = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.oXT = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.oXU = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.oXV = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.oXK = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.oXX = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.bhF = new Paint(1);
        this.bhF.setStyle(Paint.Style.FILL);
        this.bhF.setDither(true);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setFakeBoldText(this.oXZ);
        eoo();
        this.mTextPaint.setTextSize(this.mTextSize);
        if (this.oXR != 0.0f) {
            this.oYa = new Paint(1);
            this.oYa.setStyle(Paint.Style.FILL);
            this.oYa.setDither(true);
        }
    }

    private void eoo() {
        if (this.oXK != -1) {
            if (this.oXK == 0) {
                this.oXP = this.oXP != -1.0f ? this.oXP : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oXS = this.oXS != -1.0f ? this.oXS : f.dip2px(this.mContext, 2.0f);
                this.oXT = this.oXT != -1.0f ? this.oXT : f.dip2px(this.mContext, 2.0f);
                this.oXV = this.oXV != -1.0f ? this.oXV : f.dip2px(this.mContext, 2.0f);
                this.oXU = this.oXU != -1.0f ? this.oXU : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oXW = f.dip2px(this.mContext, 4.0f);
            } else if (this.oXK == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oXP = f.dip2px(this.mContext, 8.0f);
                this.oXQ = f.dip2px(this.mContext, 8.0f);
                this.oXS = f.dip2px(this.mContext, 4.0f);
                this.oXT = this.oXS;
                this.oXV = this.oXS;
                this.oXU = this.oXS;
            } else if (this.oXK == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oXP = this.oXP != -1.0f ? this.oXP : f.dip2px(this.mContext, 16.0f);
                this.oXS = f.dip2px(this.mContext, 8.0f);
                this.oXT = this.oXS;
                this.oXV = this.oXS;
                this.oXU = this.oXS;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oXW = this.oXW != -1.0f ? this.oXW : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void ar(Canvas canvas) {
        if (this.oXR != 0.0f) {
            this.oYa.setColor(this.oXO);
            if (this.oXK == 1) {
                canvas.drawCircle(this.oXQ / 2.0f, this.oXP / 2.0f, this.oXP / 2.0f, this.oYa);
                return;
            }
            if (this.oXK == 2 && this.oXY == 1) {
                canvas.drawCircle(this.oXP / 2.0f, this.oXP / 2.0f, this.oXP / 2.0f, this.oYa);
            }
            Path path = new Path();
            if (this.oXT != -1.0f) {
                path.moveTo(0.0f, this.oXT + this.oXR);
                path.quadTo(0.0f, 0.0f, this.oXT + this.oXR, 0.0f);
            }
            if (this.oXU != -1.0f) {
                path.lineTo(this.oXQ - (this.oXU + this.oXR), 0.0f);
            } else {
                path.lineTo(this.oXQ, 0.0f);
            }
            if (this.oXU != -1.0f) {
                path.quadTo(this.oXQ, 0.0f, this.oXQ, this.oXU + this.oXR);
            }
            if (this.oXV != -1.0f) {
                path.lineTo(this.oXQ, this.oXP - (this.oXV + this.oXR));
            } else {
                path.lineTo(this.oXQ, this.oXP);
            }
            if (this.oXV != -1.0f) {
                path.quadTo(this.oXQ, this.oXP, this.oXQ - (this.oXV + this.oXR), this.oXP);
            }
            if (this.oXS != -1.0f) {
                path.lineTo(this.oXS + this.oXR, this.oXP);
            } else {
                path.lineTo(0.0f, this.oXP);
            }
            if (this.oXS != -1.0f) {
                path.quadTo(0.0f, this.oXP, 0.0f, this.oXP - (this.oXS + this.oXR));
            }
            path.close();
            canvas.drawPath(path, this.oYa);
        }
    }

    private void as(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.bhF.setColor(this.mBgColor);
            this.bhF.setShader(null);
        }
        if (this.oXL != 0 || this.oXM != 0) {
            this.oYb = new LinearGradient(0.0f, 0.0f, this.oXQ, this.oXP, this.oXL, this.oXM, Shader.TileMode.CLAMP);
            this.bhF.setShader(this.oYb);
        }
        if (this.oXK == 1) {
            canvas.drawCircle(this.oXQ / 2.0f, this.oXP / 2.0f, this.oXS, this.bhF);
        } else if (this.oXK == 2 && this.oXY == 1) {
            canvas.drawCircle(this.oXP / 2.0f, this.oXP / 2.0f, this.oXP / 2.0f, this.bhF);
        } else {
            Path path = new Path();
            if (this.oXT != -1.0f) {
                path.moveTo(this.oXR, this.oXR + this.oXT);
                path.quadTo(this.oXR, this.oXR, this.oXR + this.oXT, this.oXR);
            }
            if (this.oXU != -1.0f) {
                path.lineTo((this.oXQ - this.oXR) - this.oXU, this.oXR);
            } else {
                path.lineTo(this.oXQ - this.oXR, this.oXR);
            }
            if (this.oXU != -1.0f) {
                path.quadTo(this.oXQ - this.oXR, this.oXR, this.oXQ - this.oXR, this.oXU + this.oXR);
            }
            if (this.oXV != -1.0f) {
                path.lineTo(this.oXQ - this.oXR, (this.oXP - this.oXR) - this.oXV);
            } else {
                path.lineTo(this.oXQ - this.oXR, this.oXP - this.oXR);
            }
            if (this.oXV != -1.0f) {
                path.quadTo(this.oXQ - this.oXR, this.oXP - this.oXR, (this.oXQ - this.oXR) - this.oXV, this.oXP - this.oXR);
            }
            if (this.oXS != -1.0f) {
                path.lineTo(this.oXS + this.oXR, this.oXP - this.oXR);
            } else {
                path.lineTo(this.oXR, this.oXP - this.oXR);
            }
            if (this.oXS != -1.0f) {
                path.quadTo(this.oXR, this.oXP - this.oXR, this.oXR, (this.oXP - this.oXR) - this.oXS);
            }
            path.close();
            canvas.drawPath(path, this.bhF);
        }
    }

    private void C(Canvas canvas) {
        if (!TextUtils.isEmpty(this.oXX)) {
            this.mTextPaint.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            canvas.drawText(this.oXX, this.oXQ / 2.0f, (((((int) this.oXP) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.mTextPaint);
        }
    }

    public void setStroke(int i) {
        this.oXO = i;
        invalidate();
    }

    public int getStyle() {
        return this.oXK;
    }
}
