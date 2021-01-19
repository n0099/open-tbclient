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
    private Paint bew;
    private Paint bex;
    private int mBgColor;
    private Context mContext;
    private int mTextColor;
    private float mTextSize;
    private float oZA;
    private float oZB;
    private float oZC;
    private float oZD;
    private String oZE;
    private int oZF;
    private boolean oZG;
    private Paint oZH;
    private LinearGradient oZI;
    private int oZr;
    private int oZs;
    private int oZt;
    private int oZu;
    private int oZv;
    private float oZw;
    private float oZx;
    private float oZy;
    private float oZz;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oZr = -1;
        this.oZw = -1.0f;
        this.oZx = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.oZE = str;
        if (!TextUtils.isEmpty(this.oZE)) {
            this.oZF = this.oZE.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.oZE;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.oZs = -1;
        this.oZt = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.oZs = i;
        this.oZt = i2;
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
            if (this.oZr == 1) {
                size = (int) this.oZx;
            } else if (this.oZr == 2) {
                size = (int) ((this.oZD * 2.0f) + (this.oZy * 2.0f));
                if (!TextUtils.isEmpty(this.oZE)) {
                    if (this.oZF == 1) {
                        size = (int) this.oZw;
                    } else {
                        size = (int) (size + this.bex.measureText(this.oZE));
                    }
                }
            } else {
                size = (int) ((this.oZD * 2.0f) + (this.oZy * 2.0f));
                if (!TextUtils.isEmpty(this.oZE)) {
                    size = (int) (size + this.bex.measureText(this.oZE));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.oZw;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.oZx = i;
        this.oZw = i2;
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
        this.oZs = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.oZt = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.oZv = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.oZu = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.oZG = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.oZD = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.oZy = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.oZz = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.oZA = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.oZB = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.oZC = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.oZr = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.oZE = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.bew = new Paint(1);
        this.bew.setStyle(Paint.Style.FILL);
        this.bew.setDither(true);
        this.bex = new Paint(1);
        this.bex.setTextAlign(Paint.Align.CENTER);
        this.bex.setFakeBoldText(this.oZG);
        ekC();
        this.bex.setTextSize(this.mTextSize);
        if (this.oZy != 0.0f) {
            this.oZH = new Paint(1);
            this.oZH.setStyle(Paint.Style.FILL);
            this.oZH.setDither(true);
        }
    }

    private void ekC() {
        if (this.oZr != -1) {
            if (this.oZr == 0) {
                this.oZw = this.oZw != -1.0f ? this.oZw : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oZz = this.oZz != -1.0f ? this.oZz : f.dip2px(this.mContext, 2.0f);
                this.oZA = this.oZA != -1.0f ? this.oZA : f.dip2px(this.mContext, 2.0f);
                this.oZC = this.oZC != -1.0f ? this.oZC : f.dip2px(this.mContext, 2.0f);
                this.oZB = this.oZB != -1.0f ? this.oZB : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oZD = f.dip2px(this.mContext, 4.0f);
            } else if (this.oZr == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oZw = f.dip2px(this.mContext, 8.0f);
                this.oZx = f.dip2px(this.mContext, 8.0f);
                this.oZz = f.dip2px(this.mContext, 4.0f);
                this.oZA = this.oZz;
                this.oZC = this.oZz;
                this.oZB = this.oZz;
            } else if (this.oZr == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oZw = this.oZw != -1.0f ? this.oZw : f.dip2px(this.mContext, 16.0f);
                this.oZz = f.dip2px(this.mContext, 8.0f);
                this.oZA = this.oZz;
                this.oZC = this.oZz;
                this.oZB = this.oZz;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oZD = this.oZD != -1.0f ? this.oZD : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void aB(Canvas canvas) {
        if (this.oZy != 0.0f) {
            this.oZH.setColor(this.oZv);
            if (this.oZr == 1) {
                canvas.drawCircle(this.oZx / 2.0f, this.oZw / 2.0f, this.oZw / 2.0f, this.oZH);
                return;
            }
            if (this.oZr == 2 && this.oZF == 1) {
                canvas.drawCircle(this.oZw / 2.0f, this.oZw / 2.0f, this.oZw / 2.0f, this.oZH);
            }
            Path path = new Path();
            if (this.oZA != -1.0f) {
                path.moveTo(0.0f, this.oZA + this.oZy);
                path.quadTo(0.0f, 0.0f, this.oZA + this.oZy, 0.0f);
            }
            if (this.oZB != -1.0f) {
                path.lineTo(this.oZx - (this.oZB + this.oZy), 0.0f);
            } else {
                path.lineTo(this.oZx, 0.0f);
            }
            if (this.oZB != -1.0f) {
                path.quadTo(this.oZx, 0.0f, this.oZx, this.oZB + this.oZy);
            }
            if (this.oZC != -1.0f) {
                path.lineTo(this.oZx, this.oZw - (this.oZC + this.oZy));
            } else {
                path.lineTo(this.oZx, this.oZw);
            }
            if (this.oZC != -1.0f) {
                path.quadTo(this.oZx, this.oZw, this.oZx - (this.oZC + this.oZy), this.oZw);
            }
            if (this.oZz != -1.0f) {
                path.lineTo(this.oZz + this.oZy, this.oZw);
            } else {
                path.lineTo(0.0f, this.oZw);
            }
            if (this.oZz != -1.0f) {
                path.quadTo(0.0f, this.oZw, 0.0f, this.oZw - (this.oZz + this.oZy));
            }
            path.close();
            canvas.drawPath(path, this.oZH);
        }
    }

    private void aC(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.bew.setColor(this.mBgColor);
            this.bew.setShader(null);
        }
        if (this.oZs != 0 || this.oZt != 0) {
            this.oZI = new LinearGradient(0.0f, 0.0f, this.oZx, this.oZw, this.oZs, this.oZt, Shader.TileMode.CLAMP);
            this.bew.setShader(this.oZI);
        }
        if (this.oZr == 1) {
            canvas.drawCircle(this.oZx / 2.0f, this.oZw / 2.0f, this.oZz, this.bew);
        } else if (this.oZr == 2 && this.oZF == 1) {
            canvas.drawCircle(this.oZw / 2.0f, this.oZw / 2.0f, this.oZw / 2.0f, this.bew);
        } else {
            Path path = new Path();
            if (this.oZA != -1.0f) {
                path.moveTo(this.oZy, this.oZy + this.oZA);
                path.quadTo(this.oZy, this.oZy, this.oZy + this.oZA, this.oZy);
            }
            if (this.oZB != -1.0f) {
                path.lineTo((this.oZx - this.oZy) - this.oZB, this.oZy);
            } else {
                path.lineTo(this.oZx - this.oZy, this.oZy);
            }
            if (this.oZB != -1.0f) {
                path.quadTo(this.oZx - this.oZy, this.oZy, this.oZx - this.oZy, this.oZB + this.oZy);
            }
            if (this.oZC != -1.0f) {
                path.lineTo(this.oZx - this.oZy, (this.oZw - this.oZy) - this.oZC);
            } else {
                path.lineTo(this.oZx - this.oZy, this.oZw - this.oZy);
            }
            if (this.oZC != -1.0f) {
                path.quadTo(this.oZx - this.oZy, this.oZw - this.oZy, (this.oZx - this.oZy) - this.oZC, this.oZw - this.oZy);
            }
            if (this.oZz != -1.0f) {
                path.lineTo(this.oZz + this.oZy, this.oZw - this.oZy);
            } else {
                path.lineTo(this.oZy, this.oZw - this.oZy);
            }
            if (this.oZz != -1.0f) {
                path.quadTo(this.oZy, this.oZw - this.oZy, this.oZy, (this.oZw - this.oZy) - this.oZz);
            }
            path.close();
            canvas.drawPath(path, this.bew);
        }
    }

    private void J(Canvas canvas) {
        if (!TextUtils.isEmpty(this.oZE)) {
            this.bex.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.bex.getFontMetricsInt();
            canvas.drawText(this.oZE, this.oZx / 2.0f, (((((int) this.oZw) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.bex);
        }
    }

    public void setStroke(int i) {
        this.oZv = i;
        invalidate();
    }

    public int getStyle() {
        return this.oZr;
    }
}
