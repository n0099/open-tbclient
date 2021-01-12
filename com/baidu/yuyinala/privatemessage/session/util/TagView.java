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
    private String oZD;
    private int oZE;
    private boolean oZF;
    private Paint oZG;
    private LinearGradient oZH;
    private int oZq;
    private int oZr;
    private int oZs;
    private int oZt;
    private int oZu;
    private float oZv;
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
        this.oZq = -1;
        this.oZv = -1.0f;
        this.oZw = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.oZD = str;
        if (!TextUtils.isEmpty(this.oZD)) {
            this.oZE = this.oZD.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.oZD;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.oZr = -1;
        this.oZs = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.oZr = i;
        this.oZs = i2;
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
            if (this.oZq == 1) {
                size = (int) this.oZw;
            } else if (this.oZq == 2) {
                size = (int) ((this.oZC * 2.0f) + (this.oZx * 2.0f));
                if (!TextUtils.isEmpty(this.oZD)) {
                    if (this.oZE == 1) {
                        size = (int) this.oZv;
                    } else {
                        size = (int) (size + this.bex.measureText(this.oZD));
                    }
                }
            } else {
                size = (int) ((this.oZC * 2.0f) + (this.oZx * 2.0f));
                if (!TextUtils.isEmpty(this.oZD)) {
                    size = (int) (size + this.bex.measureText(this.oZD));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.oZv;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.oZw = i;
        this.oZv = i2;
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
        this.oZr = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.oZs = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.oZu = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.oZt = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.oZF = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.oZC = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.oZx = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.oZy = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.oZz = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.oZA = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.oZB = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.oZq = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.oZD = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.bew = new Paint(1);
        this.bew.setStyle(Paint.Style.FILL);
        this.bew.setDither(true);
        this.bex = new Paint(1);
        this.bex.setTextAlign(Paint.Align.CENTER);
        this.bex.setFakeBoldText(this.oZF);
        ekC();
        this.bex.setTextSize(this.mTextSize);
        if (this.oZx != 0.0f) {
            this.oZG = new Paint(1);
            this.oZG.setStyle(Paint.Style.FILL);
            this.oZG.setDither(true);
        }
    }

    private void ekC() {
        if (this.oZq != -1) {
            if (this.oZq == 0) {
                this.oZv = this.oZv != -1.0f ? this.oZv : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oZy = this.oZy != -1.0f ? this.oZy : f.dip2px(this.mContext, 2.0f);
                this.oZz = this.oZz != -1.0f ? this.oZz : f.dip2px(this.mContext, 2.0f);
                this.oZB = this.oZB != -1.0f ? this.oZB : f.dip2px(this.mContext, 2.0f);
                this.oZA = this.oZA != -1.0f ? this.oZA : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oZC = f.dip2px(this.mContext, 4.0f);
            } else if (this.oZq == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oZv = f.dip2px(this.mContext, 8.0f);
                this.oZw = f.dip2px(this.mContext, 8.0f);
                this.oZy = f.dip2px(this.mContext, 4.0f);
                this.oZz = this.oZy;
                this.oZB = this.oZy;
                this.oZA = this.oZy;
            } else if (this.oZq == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oZv = this.oZv != -1.0f ? this.oZv : f.dip2px(this.mContext, 16.0f);
                this.oZy = f.dip2px(this.mContext, 8.0f);
                this.oZz = this.oZy;
                this.oZB = this.oZy;
                this.oZA = this.oZy;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oZC = this.oZC != -1.0f ? this.oZC : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void aB(Canvas canvas) {
        if (this.oZx != 0.0f) {
            this.oZG.setColor(this.oZu);
            if (this.oZq == 1) {
                canvas.drawCircle(this.oZw / 2.0f, this.oZv / 2.0f, this.oZv / 2.0f, this.oZG);
                return;
            }
            if (this.oZq == 2 && this.oZE == 1) {
                canvas.drawCircle(this.oZv / 2.0f, this.oZv / 2.0f, this.oZv / 2.0f, this.oZG);
            }
            Path path = new Path();
            if (this.oZz != -1.0f) {
                path.moveTo(0.0f, this.oZz + this.oZx);
                path.quadTo(0.0f, 0.0f, this.oZz + this.oZx, 0.0f);
            }
            if (this.oZA != -1.0f) {
                path.lineTo(this.oZw - (this.oZA + this.oZx), 0.0f);
            } else {
                path.lineTo(this.oZw, 0.0f);
            }
            if (this.oZA != -1.0f) {
                path.quadTo(this.oZw, 0.0f, this.oZw, this.oZA + this.oZx);
            }
            if (this.oZB != -1.0f) {
                path.lineTo(this.oZw, this.oZv - (this.oZB + this.oZx));
            } else {
                path.lineTo(this.oZw, this.oZv);
            }
            if (this.oZB != -1.0f) {
                path.quadTo(this.oZw, this.oZv, this.oZw - (this.oZB + this.oZx), this.oZv);
            }
            if (this.oZy != -1.0f) {
                path.lineTo(this.oZy + this.oZx, this.oZv);
            } else {
                path.lineTo(0.0f, this.oZv);
            }
            if (this.oZy != -1.0f) {
                path.quadTo(0.0f, this.oZv, 0.0f, this.oZv - (this.oZy + this.oZx));
            }
            path.close();
            canvas.drawPath(path, this.oZG);
        }
    }

    private void aC(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.bew.setColor(this.mBgColor);
            this.bew.setShader(null);
        }
        if (this.oZr != 0 || this.oZs != 0) {
            this.oZH = new LinearGradient(0.0f, 0.0f, this.oZw, this.oZv, this.oZr, this.oZs, Shader.TileMode.CLAMP);
            this.bew.setShader(this.oZH);
        }
        if (this.oZq == 1) {
            canvas.drawCircle(this.oZw / 2.0f, this.oZv / 2.0f, this.oZy, this.bew);
        } else if (this.oZq == 2 && this.oZE == 1) {
            canvas.drawCircle(this.oZv / 2.0f, this.oZv / 2.0f, this.oZv / 2.0f, this.bew);
        } else {
            Path path = new Path();
            if (this.oZz != -1.0f) {
                path.moveTo(this.oZx, this.oZx + this.oZz);
                path.quadTo(this.oZx, this.oZx, this.oZx + this.oZz, this.oZx);
            }
            if (this.oZA != -1.0f) {
                path.lineTo((this.oZw - this.oZx) - this.oZA, this.oZx);
            } else {
                path.lineTo(this.oZw - this.oZx, this.oZx);
            }
            if (this.oZA != -1.0f) {
                path.quadTo(this.oZw - this.oZx, this.oZx, this.oZw - this.oZx, this.oZA + this.oZx);
            }
            if (this.oZB != -1.0f) {
                path.lineTo(this.oZw - this.oZx, (this.oZv - this.oZx) - this.oZB);
            } else {
                path.lineTo(this.oZw - this.oZx, this.oZv - this.oZx);
            }
            if (this.oZB != -1.0f) {
                path.quadTo(this.oZw - this.oZx, this.oZv - this.oZx, (this.oZw - this.oZx) - this.oZB, this.oZv - this.oZx);
            }
            if (this.oZy != -1.0f) {
                path.lineTo(this.oZy + this.oZx, this.oZv - this.oZx);
            } else {
                path.lineTo(this.oZx, this.oZv - this.oZx);
            }
            if (this.oZy != -1.0f) {
                path.quadTo(this.oZx, this.oZv - this.oZx, this.oZx, (this.oZv - this.oZx) - this.oZy);
            }
            path.close();
            canvas.drawPath(path, this.bew);
        }
    }

    private void J(Canvas canvas) {
        if (!TextUtils.isEmpty(this.oZD)) {
            this.bex.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.bex.getFontMetricsInt();
            canvas.drawText(this.oZD, this.oZw / 2.0f, (((((int) this.oZv) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.bex);
        }
    }

    public void setStroke(int i) {
        this.oZu = i;
        invalidate();
    }

    public int getStyle() {
        return this.oZq;
    }
}
