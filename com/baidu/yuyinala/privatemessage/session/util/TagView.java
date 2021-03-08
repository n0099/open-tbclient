package com.baidu.yuyinala.privatemessage.session.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
/* loaded from: classes10.dex */
public class TagView extends View {
    private Paint bjg;
    private Paint bjh;
    private int mBgColor;
    private Context mContext;
    private int mTextColor;
    private float mTextSize;
    private String pmA;
    private int pmB;
    private boolean pmC;
    private Paint pmD;
    private LinearGradient pmE;
    private int pmn;
    private int pmo;
    private int pmp;
    private int pmq;
    private int pmr;
    private float pms;
    private float pmt;
    private float pmu;
    private float pmv;
    private float pmw;
    private float pmx;
    private float pmy;
    private float pmz;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pmn = -1;
        this.pms = -1.0f;
        this.pmt = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.pmA = str;
        if (!TextUtils.isEmpty(this.pmA)) {
            this.pmB = this.pmA.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.pmA;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.pmo = -1;
        this.pmp = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.pmo = i;
        this.pmp = i2;
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
            if (this.pmn == 1) {
                size = (int) this.pmt;
            } else if (this.pmn == 2) {
                size = (int) ((this.pmz * 2.0f) + (this.pmu * 2.0f));
                if (!TextUtils.isEmpty(this.pmA)) {
                    if (this.pmB == 1) {
                        size = (int) this.pms;
                    } else {
                        size = (int) (size + this.bjh.measureText(this.pmA));
                    }
                }
            } else {
                size = (int) ((this.pmz * 2.0f) + (this.pmu * 2.0f));
                if (!TextUtils.isEmpty(this.pmA)) {
                    size = (int) (size + this.bjh.measureText(this.pmA));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.pms;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pmt = i;
        this.pms = i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aB(canvas);
        aC(canvas);
        J(canvas);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, a.j.TagView);
        this.mBgColor = obtainStyledAttributes.getColor(a.j.TagView_bgColor, 0);
        this.pmo = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.pmp = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.pmr = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.pmq = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.pmC = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.pmz = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.pmu = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.pmv = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.pmw = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.pmx = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.pmy = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.pmn = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.pmA = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.bjg = new Paint(1);
        this.bjg.setStyle(Paint.Style.FILL);
        this.bjg.setDither(true);
        this.bjh = new Paint(1);
        this.bjh.setTextAlign(Paint.Align.CENTER);
        this.bjh.setFakeBoldText(this.pmC);
        enn();
        this.bjh.setTextSize(this.mTextSize);
        if (this.pmu != 0.0f) {
            this.pmD = new Paint(1);
            this.pmD.setStyle(Paint.Style.FILL);
            this.pmD.setDither(true);
        }
    }

    private void enn() {
        if (this.pmn != -1) {
            if (this.pmn == 0) {
                this.pms = this.pms != -1.0f ? this.pms : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pmv = this.pmv != -1.0f ? this.pmv : f.dip2px(this.mContext, 2.0f);
                this.pmw = this.pmw != -1.0f ? this.pmw : f.dip2px(this.mContext, 2.0f);
                this.pmy = this.pmy != -1.0f ? this.pmy : f.dip2px(this.mContext, 2.0f);
                this.pmx = this.pmx != -1.0f ? this.pmx : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.pmz = f.dip2px(this.mContext, 4.0f);
            } else if (this.pmn == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pms = f.dip2px(this.mContext, 8.0f);
                this.pmt = f.dip2px(this.mContext, 8.0f);
                this.pmv = f.dip2px(this.mContext, 4.0f);
                this.pmw = this.pmv;
                this.pmy = this.pmv;
                this.pmx = this.pmv;
            } else if (this.pmn == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pms = this.pms != -1.0f ? this.pms : f.dip2px(this.mContext, 16.0f);
                this.pmv = f.dip2px(this.mContext, 8.0f);
                this.pmw = this.pmv;
                this.pmy = this.pmv;
                this.pmx = this.pmv;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.pmz = this.pmz != -1.0f ? this.pmz : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void aB(Canvas canvas) {
        if (this.pmu != 0.0f) {
            this.pmD.setColor(this.pmr);
            if (this.pmn == 1) {
                canvas.drawCircle(this.pmt / 2.0f, this.pms / 2.0f, this.pms / 2.0f, this.pmD);
                return;
            }
            if (this.pmn == 2 && this.pmB == 1) {
                canvas.drawCircle(this.pms / 2.0f, this.pms / 2.0f, this.pms / 2.0f, this.pmD);
            }
            Path path = new Path();
            if (this.pmw != -1.0f) {
                path.moveTo(0.0f, this.pmw + this.pmu);
                path.quadTo(0.0f, 0.0f, this.pmw + this.pmu, 0.0f);
            }
            if (this.pmx != -1.0f) {
                path.lineTo(this.pmt - (this.pmx + this.pmu), 0.0f);
            } else {
                path.lineTo(this.pmt, 0.0f);
            }
            if (this.pmx != -1.0f) {
                path.quadTo(this.pmt, 0.0f, this.pmt, this.pmx + this.pmu);
            }
            if (this.pmy != -1.0f) {
                path.lineTo(this.pmt, this.pms - (this.pmy + this.pmu));
            } else {
                path.lineTo(this.pmt, this.pms);
            }
            if (this.pmy != -1.0f) {
                path.quadTo(this.pmt, this.pms, this.pmt - (this.pmy + this.pmu), this.pms);
            }
            if (this.pmv != -1.0f) {
                path.lineTo(this.pmv + this.pmu, this.pms);
            } else {
                path.lineTo(0.0f, this.pms);
            }
            if (this.pmv != -1.0f) {
                path.quadTo(0.0f, this.pms, 0.0f, this.pms - (this.pmv + this.pmu));
            }
            path.close();
            canvas.drawPath(path, this.pmD);
        }
    }

    private void aC(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.bjg.setColor(this.mBgColor);
            this.bjg.setShader(null);
        }
        if (this.pmo != 0 || this.pmp != 0) {
            this.pmE = new LinearGradient(0.0f, 0.0f, this.pmt, this.pms, this.pmo, this.pmp, Shader.TileMode.CLAMP);
            this.bjg.setShader(this.pmE);
        }
        if (this.pmn == 1) {
            canvas.drawCircle(this.pmt / 2.0f, this.pms / 2.0f, this.pmv, this.bjg);
        } else if (this.pmn == 2 && this.pmB == 1) {
            canvas.drawCircle(this.pms / 2.0f, this.pms / 2.0f, this.pms / 2.0f, this.bjg);
        } else {
            Path path = new Path();
            if (this.pmw != -1.0f) {
                path.moveTo(this.pmu, this.pmu + this.pmw);
                path.quadTo(this.pmu, this.pmu, this.pmu + this.pmw, this.pmu);
            }
            if (this.pmx != -1.0f) {
                path.lineTo((this.pmt - this.pmu) - this.pmx, this.pmu);
            } else {
                path.lineTo(this.pmt - this.pmu, this.pmu);
            }
            if (this.pmx != -1.0f) {
                path.quadTo(this.pmt - this.pmu, this.pmu, this.pmt - this.pmu, this.pmx + this.pmu);
            }
            if (this.pmy != -1.0f) {
                path.lineTo(this.pmt - this.pmu, (this.pms - this.pmu) - this.pmy);
            } else {
                path.lineTo(this.pmt - this.pmu, this.pms - this.pmu);
            }
            if (this.pmy != -1.0f) {
                path.quadTo(this.pmt - this.pmu, this.pms - this.pmu, (this.pmt - this.pmu) - this.pmy, this.pms - this.pmu);
            }
            if (this.pmv != -1.0f) {
                path.lineTo(this.pmv + this.pmu, this.pms - this.pmu);
            } else {
                path.lineTo(this.pmu, this.pms - this.pmu);
            }
            if (this.pmv != -1.0f) {
                path.quadTo(this.pmu, this.pms - this.pmu, this.pmu, (this.pms - this.pmu) - this.pmv);
            }
            path.close();
            canvas.drawPath(path, this.bjg);
        }
    }

    private void J(Canvas canvas) {
        if (!TextUtils.isEmpty(this.pmA)) {
            this.bjh.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.bjh.getFontMetricsInt();
            canvas.drawText(this.pmA, this.pmt / 2.0f, (((((int) this.pms) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.bjh);
        }
    }

    public void setStroke(int i) {
        this.pmr = i;
        invalidate();
    }

    public int getStyle() {
        return this.pmn;
    }
}
