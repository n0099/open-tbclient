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
    private Paint blw;
    private int mBgColor;
    private Context mContext;
    private int mTextColor;
    private Paint mTextPaint;
    private float mTextSize;
    private int oIE;
    private int oIF;
    private int oIG;
    private int oIH;
    private int oII;
    private float oIJ;
    private float oIK;
    private float oIL;
    private float oIM;
    private float oIN;
    private float oIO;
    private float oIP;
    private float oIQ;
    private String oIR;
    private int oIS;
    private boolean oIT;
    private Paint oIU;
    private LinearGradient oIV;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oIE = -1;
        this.oIJ = -1.0f;
        this.oIK = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.oIR = str;
        if (!TextUtils.isEmpty(this.oIR)) {
            this.oIS = this.oIR.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.oIR;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.oIF = -1;
        this.oIG = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.oIF = i;
        this.oIG = i2;
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
            if (this.oIE == 1) {
                size = (int) this.oIK;
            } else if (this.oIE == 2) {
                size = (int) ((this.oIQ * 2.0f) + (this.oIL * 2.0f));
                if (!TextUtils.isEmpty(this.oIR)) {
                    if (this.oIS == 1) {
                        size = (int) this.oIJ;
                    } else {
                        size = (int) (size + this.mTextPaint.measureText(this.oIR));
                    }
                }
            } else {
                size = (int) ((this.oIQ * 2.0f) + (this.oIL * 2.0f));
                if (!TextUtils.isEmpty(this.oIR)) {
                    size = (int) (size + this.mTextPaint.measureText(this.oIR));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.oIJ;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.oIK = i;
        this.oIJ = i2;
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
        this.oIF = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.oIG = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.oII = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.oIH = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.oIT = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.oIQ = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.oIL = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.oIM = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.oIN = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.oIO = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.oIP = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.oIE = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.oIR = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.blw = new Paint(1);
        this.blw.setStyle(Paint.Style.FILL);
        this.blw.setDither(true);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setFakeBoldText(this.oIT);
        eiy();
        this.mTextPaint.setTextSize(this.mTextSize);
        if (this.oIL != 0.0f) {
            this.oIU = new Paint(1);
            this.oIU.setStyle(Paint.Style.FILL);
            this.oIU.setDither(true);
        }
    }

    private void eiy() {
        if (this.oIE != -1) {
            if (this.oIE == 0) {
                this.oIJ = this.oIJ != -1.0f ? this.oIJ : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oIM = this.oIM != -1.0f ? this.oIM : f.dip2px(this.mContext, 2.0f);
                this.oIN = this.oIN != -1.0f ? this.oIN : f.dip2px(this.mContext, 2.0f);
                this.oIP = this.oIP != -1.0f ? this.oIP : f.dip2px(this.mContext, 2.0f);
                this.oIO = this.oIO != -1.0f ? this.oIO : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oIQ = f.dip2px(this.mContext, 4.0f);
            } else if (this.oIE == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oIJ = f.dip2px(this.mContext, 8.0f);
                this.oIK = f.dip2px(this.mContext, 8.0f);
                this.oIM = f.dip2px(this.mContext, 4.0f);
                this.oIN = this.oIM;
                this.oIP = this.oIM;
                this.oIO = this.oIM;
            } else if (this.oIE == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oIJ = this.oIJ != -1.0f ? this.oIJ : f.dip2px(this.mContext, 16.0f);
                this.oIM = f.dip2px(this.mContext, 8.0f);
                this.oIN = this.oIM;
                this.oIP = this.oIM;
                this.oIO = this.oIM;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oIQ = this.oIQ != -1.0f ? this.oIQ : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void ar(Canvas canvas) {
        if (this.oIL != 0.0f) {
            this.oIU.setColor(this.oII);
            if (this.oIE == 1) {
                canvas.drawCircle(this.oIK / 2.0f, this.oIJ / 2.0f, this.oIJ / 2.0f, this.oIU);
                return;
            }
            if (this.oIE == 2 && this.oIS == 1) {
                canvas.drawCircle(this.oIJ / 2.0f, this.oIJ / 2.0f, this.oIJ / 2.0f, this.oIU);
            }
            Path path = new Path();
            if (this.oIN != -1.0f) {
                path.moveTo(0.0f, this.oIN + this.oIL);
                path.quadTo(0.0f, 0.0f, this.oIN + this.oIL, 0.0f);
            }
            if (this.oIO != -1.0f) {
                path.lineTo(this.oIK - (this.oIO + this.oIL), 0.0f);
            } else {
                path.lineTo(this.oIK, 0.0f);
            }
            if (this.oIO != -1.0f) {
                path.quadTo(this.oIK, 0.0f, this.oIK, this.oIO + this.oIL);
            }
            if (this.oIP != -1.0f) {
                path.lineTo(this.oIK, this.oIJ - (this.oIP + this.oIL));
            } else {
                path.lineTo(this.oIK, this.oIJ);
            }
            if (this.oIP != -1.0f) {
                path.quadTo(this.oIK, this.oIJ, this.oIK - (this.oIP + this.oIL), this.oIJ);
            }
            if (this.oIM != -1.0f) {
                path.lineTo(this.oIM + this.oIL, this.oIJ);
            } else {
                path.lineTo(0.0f, this.oIJ);
            }
            if (this.oIM != -1.0f) {
                path.quadTo(0.0f, this.oIJ, 0.0f, this.oIJ - (this.oIM + this.oIL));
            }
            path.close();
            canvas.drawPath(path, this.oIU);
        }
    }

    private void as(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.blw.setColor(this.mBgColor);
            this.blw.setShader(null);
        }
        if (this.oIF != 0 || this.oIG != 0) {
            this.oIV = new LinearGradient(0.0f, 0.0f, this.oIK, this.oIJ, this.oIF, this.oIG, Shader.TileMode.CLAMP);
            this.blw.setShader(this.oIV);
        }
        if (this.oIE == 1) {
            canvas.drawCircle(this.oIK / 2.0f, this.oIJ / 2.0f, this.oIM, this.blw);
        } else if (this.oIE == 2 && this.oIS == 1) {
            canvas.drawCircle(this.oIJ / 2.0f, this.oIJ / 2.0f, this.oIJ / 2.0f, this.blw);
        } else {
            Path path = new Path();
            if (this.oIN != -1.0f) {
                path.moveTo(this.oIL, this.oIL + this.oIN);
                path.quadTo(this.oIL, this.oIL, this.oIL + this.oIN, this.oIL);
            }
            if (this.oIO != -1.0f) {
                path.lineTo((this.oIK - this.oIL) - this.oIO, this.oIL);
            } else {
                path.lineTo(this.oIK - this.oIL, this.oIL);
            }
            if (this.oIO != -1.0f) {
                path.quadTo(this.oIK - this.oIL, this.oIL, this.oIK - this.oIL, this.oIO + this.oIL);
            }
            if (this.oIP != -1.0f) {
                path.lineTo(this.oIK - this.oIL, (this.oIJ - this.oIL) - this.oIP);
            } else {
                path.lineTo(this.oIK - this.oIL, this.oIJ - this.oIL);
            }
            if (this.oIP != -1.0f) {
                path.quadTo(this.oIK - this.oIL, this.oIJ - this.oIL, (this.oIK - this.oIL) - this.oIP, this.oIJ - this.oIL);
            }
            if (this.oIM != -1.0f) {
                path.lineTo(this.oIM + this.oIL, this.oIJ - this.oIL);
            } else {
                path.lineTo(this.oIL, this.oIJ - this.oIL);
            }
            if (this.oIM != -1.0f) {
                path.quadTo(this.oIL, this.oIJ - this.oIL, this.oIL, (this.oIJ - this.oIL) - this.oIM);
            }
            path.close();
            canvas.drawPath(path, this.blw);
        }
    }

    private void C(Canvas canvas) {
        if (!TextUtils.isEmpty(this.oIR)) {
            this.mTextPaint.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            canvas.drawText(this.oIR, this.oIK / 2.0f, (((((int) this.oIJ) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.mTextPaint);
        }
    }

    public void setStroke(int i) {
        this.oII = i;
        invalidate();
    }

    public int getStyle() {
        return this.oIE;
    }
}
