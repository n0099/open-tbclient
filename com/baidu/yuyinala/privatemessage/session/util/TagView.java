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
/* loaded from: classes11.dex */
public class TagView extends View {
    private Paint bhE;
    private Paint bhF;
    private int mBgColor;
    private Context mContext;
    private int mTextColor;
    private float mTextSize;
    private int pjH;
    private int pjI;
    private int pjJ;
    private int pjK;
    private int pjL;
    private float pjM;
    private float pjN;
    private float pjO;
    private float pjP;
    private float pjQ;
    private float pjR;
    private float pjS;
    private float pjT;
    private String pjU;
    private int pjV;
    private boolean pjW;
    private Paint pjX;
    private LinearGradient pjY;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pjH = -1;
        this.pjM = -1.0f;
        this.pjN = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.pjU = str;
        if (!TextUtils.isEmpty(this.pjU)) {
            this.pjV = this.pjU.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.pjU;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.pjI = -1;
        this.pjJ = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.pjI = i;
        this.pjJ = i2;
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
            if (this.pjH == 1) {
                size = (int) this.pjN;
            } else if (this.pjH == 2) {
                size = (int) ((this.pjT * 2.0f) + (this.pjO * 2.0f));
                if (!TextUtils.isEmpty(this.pjU)) {
                    if (this.pjV == 1) {
                        size = (int) this.pjM;
                    } else {
                        size = (int) (size + this.bhF.measureText(this.pjU));
                    }
                }
            } else {
                size = (int) ((this.pjT * 2.0f) + (this.pjO * 2.0f));
                if (!TextUtils.isEmpty(this.pjU)) {
                    size = (int) (size + this.bhF.measureText(this.pjU));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.pjM;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pjN = i;
        this.pjM = i2;
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
        this.pjI = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.pjJ = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.pjL = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.pjK = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.pjW = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.pjT = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.pjO = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.pjP = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.pjQ = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.pjR = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.pjS = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.pjH = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.pjU = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.bhE = new Paint(1);
        this.bhE.setStyle(Paint.Style.FILL);
        this.bhE.setDither(true);
        this.bhF = new Paint(1);
        this.bhF.setTextAlign(Paint.Align.CENTER);
        this.bhF.setFakeBoldText(this.pjW);
        emU();
        this.bhF.setTextSize(this.mTextSize);
        if (this.pjO != 0.0f) {
            this.pjX = new Paint(1);
            this.pjX.setStyle(Paint.Style.FILL);
            this.pjX.setDither(true);
        }
    }

    private void emU() {
        if (this.pjH != -1) {
            if (this.pjH == 0) {
                this.pjM = this.pjM != -1.0f ? this.pjM : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pjP = this.pjP != -1.0f ? this.pjP : f.dip2px(this.mContext, 2.0f);
                this.pjQ = this.pjQ != -1.0f ? this.pjQ : f.dip2px(this.mContext, 2.0f);
                this.pjS = this.pjS != -1.0f ? this.pjS : f.dip2px(this.mContext, 2.0f);
                this.pjR = this.pjR != -1.0f ? this.pjR : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.pjT = f.dip2px(this.mContext, 4.0f);
            } else if (this.pjH == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pjM = f.dip2px(this.mContext, 8.0f);
                this.pjN = f.dip2px(this.mContext, 8.0f);
                this.pjP = f.dip2px(this.mContext, 4.0f);
                this.pjQ = this.pjP;
                this.pjS = this.pjP;
                this.pjR = this.pjP;
            } else if (this.pjH == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pjM = this.pjM != -1.0f ? this.pjM : f.dip2px(this.mContext, 16.0f);
                this.pjP = f.dip2px(this.mContext, 8.0f);
                this.pjQ = this.pjP;
                this.pjS = this.pjP;
                this.pjR = this.pjP;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.pjT = this.pjT != -1.0f ? this.pjT : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void aB(Canvas canvas) {
        if (this.pjO != 0.0f) {
            this.pjX.setColor(this.pjL);
            if (this.pjH == 1) {
                canvas.drawCircle(this.pjN / 2.0f, this.pjM / 2.0f, this.pjM / 2.0f, this.pjX);
                return;
            }
            if (this.pjH == 2 && this.pjV == 1) {
                canvas.drawCircle(this.pjM / 2.0f, this.pjM / 2.0f, this.pjM / 2.0f, this.pjX);
            }
            Path path = new Path();
            if (this.pjQ != -1.0f) {
                path.moveTo(0.0f, this.pjQ + this.pjO);
                path.quadTo(0.0f, 0.0f, this.pjQ + this.pjO, 0.0f);
            }
            if (this.pjR != -1.0f) {
                path.lineTo(this.pjN - (this.pjR + this.pjO), 0.0f);
            } else {
                path.lineTo(this.pjN, 0.0f);
            }
            if (this.pjR != -1.0f) {
                path.quadTo(this.pjN, 0.0f, this.pjN, this.pjR + this.pjO);
            }
            if (this.pjS != -1.0f) {
                path.lineTo(this.pjN, this.pjM - (this.pjS + this.pjO));
            } else {
                path.lineTo(this.pjN, this.pjM);
            }
            if (this.pjS != -1.0f) {
                path.quadTo(this.pjN, this.pjM, this.pjN - (this.pjS + this.pjO), this.pjM);
            }
            if (this.pjP != -1.0f) {
                path.lineTo(this.pjP + this.pjO, this.pjM);
            } else {
                path.lineTo(0.0f, this.pjM);
            }
            if (this.pjP != -1.0f) {
                path.quadTo(0.0f, this.pjM, 0.0f, this.pjM - (this.pjP + this.pjO));
            }
            path.close();
            canvas.drawPath(path, this.pjX);
        }
    }

    private void aC(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.bhE.setColor(this.mBgColor);
            this.bhE.setShader(null);
        }
        if (this.pjI != 0 || this.pjJ != 0) {
            this.pjY = new LinearGradient(0.0f, 0.0f, this.pjN, this.pjM, this.pjI, this.pjJ, Shader.TileMode.CLAMP);
            this.bhE.setShader(this.pjY);
        }
        if (this.pjH == 1) {
            canvas.drawCircle(this.pjN / 2.0f, this.pjM / 2.0f, this.pjP, this.bhE);
        } else if (this.pjH == 2 && this.pjV == 1) {
            canvas.drawCircle(this.pjM / 2.0f, this.pjM / 2.0f, this.pjM / 2.0f, this.bhE);
        } else {
            Path path = new Path();
            if (this.pjQ != -1.0f) {
                path.moveTo(this.pjO, this.pjO + this.pjQ);
                path.quadTo(this.pjO, this.pjO, this.pjO + this.pjQ, this.pjO);
            }
            if (this.pjR != -1.0f) {
                path.lineTo((this.pjN - this.pjO) - this.pjR, this.pjO);
            } else {
                path.lineTo(this.pjN - this.pjO, this.pjO);
            }
            if (this.pjR != -1.0f) {
                path.quadTo(this.pjN - this.pjO, this.pjO, this.pjN - this.pjO, this.pjR + this.pjO);
            }
            if (this.pjS != -1.0f) {
                path.lineTo(this.pjN - this.pjO, (this.pjM - this.pjO) - this.pjS);
            } else {
                path.lineTo(this.pjN - this.pjO, this.pjM - this.pjO);
            }
            if (this.pjS != -1.0f) {
                path.quadTo(this.pjN - this.pjO, this.pjM - this.pjO, (this.pjN - this.pjO) - this.pjS, this.pjM - this.pjO);
            }
            if (this.pjP != -1.0f) {
                path.lineTo(this.pjP + this.pjO, this.pjM - this.pjO);
            } else {
                path.lineTo(this.pjO, this.pjM - this.pjO);
            }
            if (this.pjP != -1.0f) {
                path.quadTo(this.pjO, this.pjM - this.pjO, this.pjO, (this.pjM - this.pjO) - this.pjP);
            }
            path.close();
            canvas.drawPath(path, this.bhE);
        }
    }

    private void J(Canvas canvas) {
        if (!TextUtils.isEmpty(this.pjU)) {
            this.bhF.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.bhF.getFontMetricsInt();
            canvas.drawText(this.pjU, this.pjN / 2.0f, (((((int) this.pjM) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.bhF);
        }
    }

    public void setStroke(int i) {
        this.pjL = i;
        invalidate();
    }

    public int getStyle() {
        return this.pjH;
    }
}
