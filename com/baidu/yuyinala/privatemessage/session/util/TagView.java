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
    private int oXM;
    private int oXN;
    private int oXO;
    private int oXP;
    private int oXQ;
    private float oXR;
    private float oXS;
    private float oXT;
    private float oXU;
    private float oXV;
    private float oXW;
    private float oXX;
    private float oXY;
    private String oXZ;
    private int oYa;
    private boolean oYb;
    private Paint oYc;
    private LinearGradient oYd;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oXM = -1;
        this.oXR = -1.0f;
        this.oXS = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.oXZ = str;
        if (!TextUtils.isEmpty(this.oXZ)) {
            this.oYa = this.oXZ.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.oXZ;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.oXN = -1;
        this.oXO = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.oXN = i;
        this.oXO = i2;
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
            if (this.oXM == 1) {
                size = (int) this.oXS;
            } else if (this.oXM == 2) {
                size = (int) ((this.oXY * 2.0f) + (this.oXT * 2.0f));
                if (!TextUtils.isEmpty(this.oXZ)) {
                    if (this.oYa == 1) {
                        size = (int) this.oXR;
                    } else {
                        size = (int) (size + this.mTextPaint.measureText(this.oXZ));
                    }
                }
            } else {
                size = (int) ((this.oXY * 2.0f) + (this.oXT * 2.0f));
                if (!TextUtils.isEmpty(this.oXZ)) {
                    size = (int) (size + this.mTextPaint.measureText(this.oXZ));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.oXR;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.oXS = i;
        this.oXR = i2;
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
        this.oXN = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.oXO = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.oXQ = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.oXP = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.oYb = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.oXY = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.oXT = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.oXU = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.oXV = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.oXW = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.oXX = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.oXM = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.oXZ = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.bhF = new Paint(1);
        this.bhF.setStyle(Paint.Style.FILL);
        this.bhF.setDither(true);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setFakeBoldText(this.oYb);
        eop();
        this.mTextPaint.setTextSize(this.mTextSize);
        if (this.oXT != 0.0f) {
            this.oYc = new Paint(1);
            this.oYc.setStyle(Paint.Style.FILL);
            this.oYc.setDither(true);
        }
    }

    private void eop() {
        if (this.oXM != -1) {
            if (this.oXM == 0) {
                this.oXR = this.oXR != -1.0f ? this.oXR : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oXU = this.oXU != -1.0f ? this.oXU : f.dip2px(this.mContext, 2.0f);
                this.oXV = this.oXV != -1.0f ? this.oXV : f.dip2px(this.mContext, 2.0f);
                this.oXX = this.oXX != -1.0f ? this.oXX : f.dip2px(this.mContext, 2.0f);
                this.oXW = this.oXW != -1.0f ? this.oXW : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oXY = f.dip2px(this.mContext, 4.0f);
            } else if (this.oXM == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oXR = f.dip2px(this.mContext, 8.0f);
                this.oXS = f.dip2px(this.mContext, 8.0f);
                this.oXU = f.dip2px(this.mContext, 4.0f);
                this.oXV = this.oXU;
                this.oXX = this.oXU;
                this.oXW = this.oXU;
            } else if (this.oXM == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oXR = this.oXR != -1.0f ? this.oXR : f.dip2px(this.mContext, 16.0f);
                this.oXU = f.dip2px(this.mContext, 8.0f);
                this.oXV = this.oXU;
                this.oXX = this.oXU;
                this.oXW = this.oXU;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oXY = this.oXY != -1.0f ? this.oXY : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void ar(Canvas canvas) {
        if (this.oXT != 0.0f) {
            this.oYc.setColor(this.oXQ);
            if (this.oXM == 1) {
                canvas.drawCircle(this.oXS / 2.0f, this.oXR / 2.0f, this.oXR / 2.0f, this.oYc);
                return;
            }
            if (this.oXM == 2 && this.oYa == 1) {
                canvas.drawCircle(this.oXR / 2.0f, this.oXR / 2.0f, this.oXR / 2.0f, this.oYc);
            }
            Path path = new Path();
            if (this.oXV != -1.0f) {
                path.moveTo(0.0f, this.oXV + this.oXT);
                path.quadTo(0.0f, 0.0f, this.oXV + this.oXT, 0.0f);
            }
            if (this.oXW != -1.0f) {
                path.lineTo(this.oXS - (this.oXW + this.oXT), 0.0f);
            } else {
                path.lineTo(this.oXS, 0.0f);
            }
            if (this.oXW != -1.0f) {
                path.quadTo(this.oXS, 0.0f, this.oXS, this.oXW + this.oXT);
            }
            if (this.oXX != -1.0f) {
                path.lineTo(this.oXS, this.oXR - (this.oXX + this.oXT));
            } else {
                path.lineTo(this.oXS, this.oXR);
            }
            if (this.oXX != -1.0f) {
                path.quadTo(this.oXS, this.oXR, this.oXS - (this.oXX + this.oXT), this.oXR);
            }
            if (this.oXU != -1.0f) {
                path.lineTo(this.oXU + this.oXT, this.oXR);
            } else {
                path.lineTo(0.0f, this.oXR);
            }
            if (this.oXU != -1.0f) {
                path.quadTo(0.0f, this.oXR, 0.0f, this.oXR - (this.oXU + this.oXT));
            }
            path.close();
            canvas.drawPath(path, this.oYc);
        }
    }

    private void as(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.bhF.setColor(this.mBgColor);
            this.bhF.setShader(null);
        }
        if (this.oXN != 0 || this.oXO != 0) {
            this.oYd = new LinearGradient(0.0f, 0.0f, this.oXS, this.oXR, this.oXN, this.oXO, Shader.TileMode.CLAMP);
            this.bhF.setShader(this.oYd);
        }
        if (this.oXM == 1) {
            canvas.drawCircle(this.oXS / 2.0f, this.oXR / 2.0f, this.oXU, this.bhF);
        } else if (this.oXM == 2 && this.oYa == 1) {
            canvas.drawCircle(this.oXR / 2.0f, this.oXR / 2.0f, this.oXR / 2.0f, this.bhF);
        } else {
            Path path = new Path();
            if (this.oXV != -1.0f) {
                path.moveTo(this.oXT, this.oXT + this.oXV);
                path.quadTo(this.oXT, this.oXT, this.oXT + this.oXV, this.oXT);
            }
            if (this.oXW != -1.0f) {
                path.lineTo((this.oXS - this.oXT) - this.oXW, this.oXT);
            } else {
                path.lineTo(this.oXS - this.oXT, this.oXT);
            }
            if (this.oXW != -1.0f) {
                path.quadTo(this.oXS - this.oXT, this.oXT, this.oXS - this.oXT, this.oXW + this.oXT);
            }
            if (this.oXX != -1.0f) {
                path.lineTo(this.oXS - this.oXT, (this.oXR - this.oXT) - this.oXX);
            } else {
                path.lineTo(this.oXS - this.oXT, this.oXR - this.oXT);
            }
            if (this.oXX != -1.0f) {
                path.quadTo(this.oXS - this.oXT, this.oXR - this.oXT, (this.oXS - this.oXT) - this.oXX, this.oXR - this.oXT);
            }
            if (this.oXU != -1.0f) {
                path.lineTo(this.oXU + this.oXT, this.oXR - this.oXT);
            } else {
                path.lineTo(this.oXT, this.oXR - this.oXT);
            }
            if (this.oXU != -1.0f) {
                path.quadTo(this.oXT, this.oXR - this.oXT, this.oXT, (this.oXR - this.oXT) - this.oXU);
            }
            path.close();
            canvas.drawPath(path, this.bhF);
        }
    }

    private void C(Canvas canvas) {
        if (!TextUtils.isEmpty(this.oXZ)) {
            this.mTextPaint.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            canvas.drawText(this.oXZ, this.oXS / 2.0f, (((((int) this.oXR) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.mTextPaint);
        }
    }

    public void setStroke(int i) {
        this.oXQ = i;
        invalidate();
    }

    public int getStyle() {
        return this.oXM;
    }
}
