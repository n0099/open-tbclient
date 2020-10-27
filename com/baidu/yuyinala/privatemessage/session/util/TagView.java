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
    private Paint blN;
    private int mBgColor;
    private Context mContext;
    private int mTextColor;
    private Paint mTextPaint;
    private float mTextSize;
    private int oxH;
    private int oxI;
    private int oxJ;
    private int oxK;
    private int oxL;
    private float oxM;
    private float oxN;
    private float oxO;
    private float oxP;
    private float oxQ;
    private float oxR;
    private float oxS;
    private float oxT;
    private String oxU;
    private int oxV;
    private boolean oxW;
    private Paint oxX;
    private LinearGradient oxY;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oxH = -1;
        this.oxM = -1.0f;
        this.oxN = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.oxU = str;
        if (!TextUtils.isEmpty(this.oxU)) {
            this.oxV = this.oxU.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.oxU;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.oxI = -1;
        this.oxJ = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.oxI = i;
        this.oxJ = i2;
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
            if (this.oxH == 1) {
                size = (int) this.oxN;
            } else if (this.oxH == 2) {
                size = (int) ((this.oxT * 2.0f) + (this.oxO * 2.0f));
                if (!TextUtils.isEmpty(this.oxU)) {
                    if (this.oxV == 1) {
                        size = (int) this.oxM;
                    } else {
                        size = (int) (size + this.mTextPaint.measureText(this.oxU));
                    }
                }
            } else {
                size = (int) ((this.oxT * 2.0f) + (this.oxO * 2.0f));
                if (!TextUtils.isEmpty(this.oxU)) {
                    size = (int) (size + this.mTextPaint.measureText(this.oxU));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.oxM;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.oxN = i;
        this.oxM = i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        aq(canvas);
        ar(canvas);
        C(canvas);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, a.k.TagView);
        this.mBgColor = obtainStyledAttributes.getColor(a.k.TagView_bgColor, 0);
        this.oxI = obtainStyledAttributes.getColor(a.k.TagView_bgGradientStartColor, 0);
        this.oxJ = obtainStyledAttributes.getColor(a.k.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.k.TagView_textColor, 0);
        this.oxL = obtainStyledAttributes.getColor(a.k.TagView_bgTraceColor, 0);
        this.oxK = obtainStyledAttributes.getDimensionPixelSize(a.k.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.k.TagView_textSize, -1);
        this.oxW = obtainStyledAttributes.getBoolean(a.k.TagView_textIsBold, false);
        this.oxT = obtainStyledAttributes.getDimensionPixelSize(a.k.TagView_horizontalMargin, -1);
        this.oxO = obtainStyledAttributes.getDimensionPixelSize(a.k.TagView_traceWidth, 0);
        this.oxP = obtainStyledAttributes.getDimensionPixelSize(a.k.TagView_leftBottomConnerRadius, -1);
        this.oxQ = obtainStyledAttributes.getDimensionPixelSize(a.k.TagView_leftTopConnerRadius, -1);
        this.oxR = obtainStyledAttributes.getDimensionPixelSize(a.k.TagView_rightTopConnerRadius, -1);
        this.oxS = obtainStyledAttributes.getDimensionPixelSize(a.k.TagView_rightBottomConnerRadius, -1);
        this.oxH = obtainStyledAttributes.getInt(a.k.TagView_viewStyle, -1);
        this.oxU = obtainStyledAttributes.getString(a.k.TagView_text);
        obtainStyledAttributes.recycle();
        this.blN = new Paint(1);
        this.blN.setStyle(Paint.Style.FILL);
        this.blN.setDither(true);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        this.mTextPaint.setFakeBoldText(this.oxW);
        eeL();
        this.mTextPaint.setTextSize(this.mTextSize);
        if (this.oxO != 0.0f) {
            this.oxX = new Paint(1);
            this.oxX.setStyle(Paint.Style.FILL);
            this.oxX.setDither(true);
        }
    }

    private void eeL() {
        if (this.oxH != -1) {
            if (this.oxH == 0) {
                this.oxM = this.oxM != -1.0f ? this.oxM : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oxP = this.oxP != -1.0f ? this.oxP : f.dip2px(this.mContext, 2.0f);
                this.oxQ = this.oxQ != -1.0f ? this.oxQ : f.dip2px(this.mContext, 2.0f);
                this.oxS = this.oxS != -1.0f ? this.oxS : f.dip2px(this.mContext, 2.0f);
                this.oxR = this.oxR != -1.0f ? this.oxR : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oxT = f.dip2px(this.mContext, 4.0f);
            } else if (this.oxH == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oxM = f.dip2px(this.mContext, 8.0f);
                this.oxN = f.dip2px(this.mContext, 8.0f);
                this.oxP = f.dip2px(this.mContext, 4.0f);
                this.oxQ = this.oxP;
                this.oxS = this.oxP;
                this.oxR = this.oxP;
            } else if (this.oxH == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.oxM = this.oxM != -1.0f ? this.oxM : f.dip2px(this.mContext, 16.0f);
                this.oxP = f.dip2px(this.mContext, 8.0f);
                this.oxQ = this.oxP;
                this.oxS = this.oxP;
                this.oxR = this.oxP;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.oxT = this.oxT != -1.0f ? this.oxT : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void aq(Canvas canvas) {
        if (this.oxO != 0.0f) {
            this.oxX.setColor(this.oxL);
            if (this.oxH == 1) {
                canvas.drawCircle(this.oxN / 2.0f, this.oxM / 2.0f, this.oxM / 2.0f, this.oxX);
                return;
            }
            if (this.oxH == 2 && this.oxV == 1) {
                canvas.drawCircle(this.oxM / 2.0f, this.oxM / 2.0f, this.oxM / 2.0f, this.oxX);
            }
            Path path = new Path();
            if (this.oxQ != -1.0f) {
                path.moveTo(0.0f, this.oxQ + this.oxO);
                path.quadTo(0.0f, 0.0f, this.oxQ + this.oxO, 0.0f);
            }
            if (this.oxR != -1.0f) {
                path.lineTo(this.oxN - (this.oxR + this.oxO), 0.0f);
            } else {
                path.lineTo(this.oxN, 0.0f);
            }
            if (this.oxR != -1.0f) {
                path.quadTo(this.oxN, 0.0f, this.oxN, this.oxR + this.oxO);
            }
            if (this.oxS != -1.0f) {
                path.lineTo(this.oxN, this.oxM - (this.oxS + this.oxO));
            } else {
                path.lineTo(this.oxN, this.oxM);
            }
            if (this.oxS != -1.0f) {
                path.quadTo(this.oxN, this.oxM, this.oxN - (this.oxS + this.oxO), this.oxM);
            }
            if (this.oxP != -1.0f) {
                path.lineTo(this.oxP + this.oxO, this.oxM);
            } else {
                path.lineTo(0.0f, this.oxM);
            }
            if (this.oxP != -1.0f) {
                path.quadTo(0.0f, this.oxM, 0.0f, this.oxM - (this.oxP + this.oxO));
            }
            path.close();
            canvas.drawPath(path, this.oxX);
        }
    }

    private void ar(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.blN.setColor(this.mBgColor);
            this.blN.setShader(null);
        }
        if (this.oxI != 0 || this.oxJ != 0) {
            this.oxY = new LinearGradient(0.0f, 0.0f, this.oxN, this.oxM, this.oxI, this.oxJ, Shader.TileMode.CLAMP);
            this.blN.setShader(this.oxY);
        }
        if (this.oxH == 1) {
            canvas.drawCircle(this.oxN / 2.0f, this.oxM / 2.0f, this.oxP, this.blN);
        } else if (this.oxH == 2 && this.oxV == 1) {
            canvas.drawCircle(this.oxM / 2.0f, this.oxM / 2.0f, this.oxM / 2.0f, this.blN);
        } else {
            Path path = new Path();
            if (this.oxQ != -1.0f) {
                path.moveTo(this.oxO, this.oxO + this.oxQ);
                path.quadTo(this.oxO, this.oxO, this.oxO + this.oxQ, this.oxO);
            }
            if (this.oxR != -1.0f) {
                path.lineTo((this.oxN - this.oxO) - this.oxR, this.oxO);
            } else {
                path.lineTo(this.oxN - this.oxO, this.oxO);
            }
            if (this.oxR != -1.0f) {
                path.quadTo(this.oxN - this.oxO, this.oxO, this.oxN - this.oxO, this.oxR + this.oxO);
            }
            if (this.oxS != -1.0f) {
                path.lineTo(this.oxN - this.oxO, (this.oxM - this.oxO) - this.oxS);
            } else {
                path.lineTo(this.oxN - this.oxO, this.oxM - this.oxO);
            }
            if (this.oxS != -1.0f) {
                path.quadTo(this.oxN - this.oxO, this.oxM - this.oxO, (this.oxN - this.oxO) - this.oxS, this.oxM - this.oxO);
            }
            if (this.oxP != -1.0f) {
                path.lineTo(this.oxP + this.oxO, this.oxM - this.oxO);
            } else {
                path.lineTo(this.oxO, this.oxM - this.oxO);
            }
            if (this.oxP != -1.0f) {
                path.quadTo(this.oxO, this.oxM - this.oxO, this.oxO, (this.oxM - this.oxO) - this.oxP);
            }
            path.close();
            canvas.drawPath(path, this.blN);
        }
    }

    private void C(Canvas canvas) {
        if (!TextUtils.isEmpty(this.oxU)) {
            this.mTextPaint.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.mTextPaint.getFontMetricsInt();
            canvas.drawText(this.oxU, this.oxN / 2.0f, (((((int) this.oxM) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.mTextPaint);
        }
    }

    public void setStroke(int i) {
        this.oxL = i;
        invalidate();
    }

    public int getStyle() {
        return this.oxH;
    }
}
