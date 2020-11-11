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
    private Paint bnh;
    private int mBgColor;
    private Context mContext;
    private int mTextColor;
    private Paint mTextPaint;
    private float mTextSize;
    private int oHa;
    private int oHb;
    private int oHc;
    private int oHd;
    private int oHe;
    private float oHf;
    private float oHg;
    private float oHh;
    private float oHi;
    private float oHj;
    private float oHk;
    private float oHl;
    private float oHm;
    private String oHn;
    private int oHo;
    private boolean oHp;
    private Paint oHq;
    private LinearGradient oHr;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oHa = -1;
        this.oHf = -1.0f;
        this.oHg = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.oHn = str;
        if (!TextUtils.isEmpty(this.oHn)) {
            this.oHo = this.oHn.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.oHn;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.oHb = -1;
        this.oHc = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.oHb = i;
        this.oHc = i2;
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
            if (this.oHa == 1) {
                size = (int) this.oHg;
            } else if (this.oHa == 2) {
                size = (int) ((this.oHm * 2.0f) + (this.oHh * 2.0f));
                if (!TextUtils.isEmpty(this.oHn)) {
                    if (this.oHo == 1) {
                        size = (int) this.oHf;
                    } else {
                        size = (int) (size + this.mTextPaint.measureText(this.oHn));
                    }
                }
            } else {
                size = (int) ((this.oHm * 2.0f) + (this.oHh * 2.0f));
                if (!TextUtils.isEmpty(this.oHn)) {
                    size = (int) (size + this.mTextPaint.measureText(this.oHn));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.oHf;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.oHg = i;
        this.oHf = i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aq(canvas);
        ar(canvas);
        C(canvas);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, a.j.TagView);
        this.mBgColor = obtainStyledAttributes.getColor(a.j.TagView_bgColor, 0);
        this.oHb = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.oHc = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.oHe = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.oHd = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.oHp = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.oHm = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.oHh = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.oHi = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.oHj = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.oHk = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.oHl = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.oHa = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.oHn = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.bnh = new Paint(1);
        this.bnh.setStyle(Paint.Style.FILL);
        this.bnh.setDither(true);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setFakeBoldText(this.oHp);
        eiA();
        this.mTextPaint.setTextSize(this.mTextSize);
        if (this.oHh != 0.0f) {
            this.oHq = new Paint(1);
            this.oHq.setStyle(Paint.Style.FILL);
            this.oHq.setDither(true);
        }
    }

    private void eiA() {
        if (this.oHa != -1) {
            if (this.oHa == 0) {
                this.oHf = this.oHf != -1.0f ? this.oHf : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oHi = this.oHi != -1.0f ? this.oHi : f.dip2px(this.mContext, 2.0f);
                this.oHj = this.oHj != -1.0f ? this.oHj : f.dip2px(this.mContext, 2.0f);
                this.oHl = this.oHl != -1.0f ? this.oHl : f.dip2px(this.mContext, 2.0f);
                this.oHk = this.oHk != -1.0f ? this.oHk : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oHm = f.dip2px(this.mContext, 4.0f);
            } else if (this.oHa == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oHf = f.dip2px(this.mContext, 8.0f);
                this.oHg = f.dip2px(this.mContext, 8.0f);
                this.oHi = f.dip2px(this.mContext, 4.0f);
                this.oHj = this.oHi;
                this.oHl = this.oHi;
                this.oHk = this.oHi;
            } else if (this.oHa == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oHf = this.oHf != -1.0f ? this.oHf : f.dip2px(this.mContext, 16.0f);
                this.oHi = f.dip2px(this.mContext, 8.0f);
                this.oHj = this.oHi;
                this.oHl = this.oHi;
                this.oHk = this.oHi;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oHm = this.oHm != -1.0f ? this.oHm : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void aq(Canvas canvas) {
        if (this.oHh != 0.0f) {
            this.oHq.setColor(this.oHe);
            if (this.oHa == 1) {
                canvas.drawCircle(this.oHg / 2.0f, this.oHf / 2.0f, this.oHf / 2.0f, this.oHq);
                return;
            }
            if (this.oHa == 2 && this.oHo == 1) {
                canvas.drawCircle(this.oHf / 2.0f, this.oHf / 2.0f, this.oHf / 2.0f, this.oHq);
            }
            Path path = new Path();
            if (this.oHj != -1.0f) {
                path.moveTo(0.0f, this.oHj + this.oHh);
                path.quadTo(0.0f, 0.0f, this.oHj + this.oHh, 0.0f);
            }
            if (this.oHk != -1.0f) {
                path.lineTo(this.oHg - (this.oHk + this.oHh), 0.0f);
            } else {
                path.lineTo(this.oHg, 0.0f);
            }
            if (this.oHk != -1.0f) {
                path.quadTo(this.oHg, 0.0f, this.oHg, this.oHk + this.oHh);
            }
            if (this.oHl != -1.0f) {
                path.lineTo(this.oHg, this.oHf - (this.oHl + this.oHh));
            } else {
                path.lineTo(this.oHg, this.oHf);
            }
            if (this.oHl != -1.0f) {
                path.quadTo(this.oHg, this.oHf, this.oHg - (this.oHl + this.oHh), this.oHf);
            }
            if (this.oHi != -1.0f) {
                path.lineTo(this.oHi + this.oHh, this.oHf);
            } else {
                path.lineTo(0.0f, this.oHf);
            }
            if (this.oHi != -1.0f) {
                path.quadTo(0.0f, this.oHf, 0.0f, this.oHf - (this.oHi + this.oHh));
            }
            path.close();
            canvas.drawPath(path, this.oHq);
        }
    }

    private void ar(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.bnh.setColor(this.mBgColor);
            this.bnh.setShader(null);
        }
        if (this.oHb != 0 || this.oHc != 0) {
            this.oHr = new LinearGradient(0.0f, 0.0f, this.oHg, this.oHf, this.oHb, this.oHc, Shader.TileMode.CLAMP);
            this.bnh.setShader(this.oHr);
        }
        if (this.oHa == 1) {
            canvas.drawCircle(this.oHg / 2.0f, this.oHf / 2.0f, this.oHi, this.bnh);
        } else if (this.oHa == 2 && this.oHo == 1) {
            canvas.drawCircle(this.oHf / 2.0f, this.oHf / 2.0f, this.oHf / 2.0f, this.bnh);
        } else {
            Path path = new Path();
            if (this.oHj != -1.0f) {
                path.moveTo(this.oHh, this.oHh + this.oHj);
                path.quadTo(this.oHh, this.oHh, this.oHh + this.oHj, this.oHh);
            }
            if (this.oHk != -1.0f) {
                path.lineTo((this.oHg - this.oHh) - this.oHk, this.oHh);
            } else {
                path.lineTo(this.oHg - this.oHh, this.oHh);
            }
            if (this.oHk != -1.0f) {
                path.quadTo(this.oHg - this.oHh, this.oHh, this.oHg - this.oHh, this.oHk + this.oHh);
            }
            if (this.oHl != -1.0f) {
                path.lineTo(this.oHg - this.oHh, (this.oHf - this.oHh) - this.oHl);
            } else {
                path.lineTo(this.oHg - this.oHh, this.oHf - this.oHh);
            }
            if (this.oHl != -1.0f) {
                path.quadTo(this.oHg - this.oHh, this.oHf - this.oHh, (this.oHg - this.oHh) - this.oHl, this.oHf - this.oHh);
            }
            if (this.oHi != -1.0f) {
                path.lineTo(this.oHi + this.oHh, this.oHf - this.oHh);
            } else {
                path.lineTo(this.oHh, this.oHf - this.oHh);
            }
            if (this.oHi != -1.0f) {
                path.quadTo(this.oHh, this.oHf - this.oHh, this.oHh, (this.oHf - this.oHh) - this.oHi);
            }
            path.close();
            canvas.drawPath(path, this.bnh);
        }
    }

    private void C(Canvas canvas) {
        if (!TextUtils.isEmpty(this.oHn)) {
            this.mTextPaint.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            canvas.drawText(this.oHn, this.oHg / 2.0f, (((((int) this.oHf) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.mTextPaint);
        }
    }

    public void setStroke(int i) {
        this.oHe = i;
        invalidate();
    }

    public int getStyle() {
        return this.oHa;
    }
}
