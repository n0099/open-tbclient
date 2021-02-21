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
    private int pki;
    private int pkj;
    private int pkk;
    private int pkl;
    private int pkm;
    private float pkn;
    private float pko;
    private float pkp;
    private float pkq;
    private float pkr;
    private float pks;
    private float pkt;
    private float pku;
    private String pkv;
    private int pkw;
    private boolean pkx;
    private Paint pky;
    private LinearGradient pkz;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pki = -1;
        this.pkn = -1.0f;
        this.pko = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.pkv = str;
        if (!TextUtils.isEmpty(this.pkv)) {
            this.pkw = this.pkv.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.pkv;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.pkj = -1;
        this.pkk = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.pkj = i;
        this.pkk = i2;
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
            if (this.pki == 1) {
                size = (int) this.pko;
            } else if (this.pki == 2) {
                size = (int) ((this.pku * 2.0f) + (this.pkp * 2.0f));
                if (!TextUtils.isEmpty(this.pkv)) {
                    if (this.pkw == 1) {
                        size = (int) this.pkn;
                    } else {
                        size = (int) (size + this.bhF.measureText(this.pkv));
                    }
                }
            } else {
                size = (int) ((this.pku * 2.0f) + (this.pkp * 2.0f));
                if (!TextUtils.isEmpty(this.pkv)) {
                    size = (int) (size + this.bhF.measureText(this.pkv));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.pkn;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pko = i;
        this.pkn = i2;
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
        this.pkj = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.pkk = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.pkm = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.pkl = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.pkx = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.pku = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.pkp = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.pkq = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.pkr = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.pks = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.pkt = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.pki = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.pkv = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.bhE = new Paint(1);
        this.bhE.setStyle(Paint.Style.FILL);
        this.bhE.setDither(true);
        this.bhF = new Paint(1);
        this.bhF.setTextAlign(Paint.Align.CENTER);
        this.bhF.setFakeBoldText(this.pkx);
        enc();
        this.bhF.setTextSize(this.mTextSize);
        if (this.pkp != 0.0f) {
            this.pky = new Paint(1);
            this.pky.setStyle(Paint.Style.FILL);
            this.pky.setDither(true);
        }
    }

    private void enc() {
        if (this.pki != -1) {
            if (this.pki == 0) {
                this.pkn = this.pkn != -1.0f ? this.pkn : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pkq = this.pkq != -1.0f ? this.pkq : f.dip2px(this.mContext, 2.0f);
                this.pkr = this.pkr != -1.0f ? this.pkr : f.dip2px(this.mContext, 2.0f);
                this.pkt = this.pkt != -1.0f ? this.pkt : f.dip2px(this.mContext, 2.0f);
                this.pks = this.pks != -1.0f ? this.pks : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.pku = f.dip2px(this.mContext, 4.0f);
            } else if (this.pki == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pkn = f.dip2px(this.mContext, 8.0f);
                this.pko = f.dip2px(this.mContext, 8.0f);
                this.pkq = f.dip2px(this.mContext, 4.0f);
                this.pkr = this.pkq;
                this.pkt = this.pkq;
                this.pks = this.pkq;
            } else if (this.pki == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pkn = this.pkn != -1.0f ? this.pkn : f.dip2px(this.mContext, 16.0f);
                this.pkq = f.dip2px(this.mContext, 8.0f);
                this.pkr = this.pkq;
                this.pkt = this.pkq;
                this.pks = this.pkq;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.pku = this.pku != -1.0f ? this.pku : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void aB(Canvas canvas) {
        if (this.pkp != 0.0f) {
            this.pky.setColor(this.pkm);
            if (this.pki == 1) {
                canvas.drawCircle(this.pko / 2.0f, this.pkn / 2.0f, this.pkn / 2.0f, this.pky);
                return;
            }
            if (this.pki == 2 && this.pkw == 1) {
                canvas.drawCircle(this.pkn / 2.0f, this.pkn / 2.0f, this.pkn / 2.0f, this.pky);
            }
            Path path = new Path();
            if (this.pkr != -1.0f) {
                path.moveTo(0.0f, this.pkr + this.pkp);
                path.quadTo(0.0f, 0.0f, this.pkr + this.pkp, 0.0f);
            }
            if (this.pks != -1.0f) {
                path.lineTo(this.pko - (this.pks + this.pkp), 0.0f);
            } else {
                path.lineTo(this.pko, 0.0f);
            }
            if (this.pks != -1.0f) {
                path.quadTo(this.pko, 0.0f, this.pko, this.pks + this.pkp);
            }
            if (this.pkt != -1.0f) {
                path.lineTo(this.pko, this.pkn - (this.pkt + this.pkp));
            } else {
                path.lineTo(this.pko, this.pkn);
            }
            if (this.pkt != -1.0f) {
                path.quadTo(this.pko, this.pkn, this.pko - (this.pkt + this.pkp), this.pkn);
            }
            if (this.pkq != -1.0f) {
                path.lineTo(this.pkq + this.pkp, this.pkn);
            } else {
                path.lineTo(0.0f, this.pkn);
            }
            if (this.pkq != -1.0f) {
                path.quadTo(0.0f, this.pkn, 0.0f, this.pkn - (this.pkq + this.pkp));
            }
            path.close();
            canvas.drawPath(path, this.pky);
        }
    }

    private void aC(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.bhE.setColor(this.mBgColor);
            this.bhE.setShader(null);
        }
        if (this.pkj != 0 || this.pkk != 0) {
            this.pkz = new LinearGradient(0.0f, 0.0f, this.pko, this.pkn, this.pkj, this.pkk, Shader.TileMode.CLAMP);
            this.bhE.setShader(this.pkz);
        }
        if (this.pki == 1) {
            canvas.drawCircle(this.pko / 2.0f, this.pkn / 2.0f, this.pkq, this.bhE);
        } else if (this.pki == 2 && this.pkw == 1) {
            canvas.drawCircle(this.pkn / 2.0f, this.pkn / 2.0f, this.pkn / 2.0f, this.bhE);
        } else {
            Path path = new Path();
            if (this.pkr != -1.0f) {
                path.moveTo(this.pkp, this.pkp + this.pkr);
                path.quadTo(this.pkp, this.pkp, this.pkp + this.pkr, this.pkp);
            }
            if (this.pks != -1.0f) {
                path.lineTo((this.pko - this.pkp) - this.pks, this.pkp);
            } else {
                path.lineTo(this.pko - this.pkp, this.pkp);
            }
            if (this.pks != -1.0f) {
                path.quadTo(this.pko - this.pkp, this.pkp, this.pko - this.pkp, this.pks + this.pkp);
            }
            if (this.pkt != -1.0f) {
                path.lineTo(this.pko - this.pkp, (this.pkn - this.pkp) - this.pkt);
            } else {
                path.lineTo(this.pko - this.pkp, this.pkn - this.pkp);
            }
            if (this.pkt != -1.0f) {
                path.quadTo(this.pko - this.pkp, this.pkn - this.pkp, (this.pko - this.pkp) - this.pkt, this.pkn - this.pkp);
            }
            if (this.pkq != -1.0f) {
                path.lineTo(this.pkq + this.pkp, this.pkn - this.pkp);
            } else {
                path.lineTo(this.pkp, this.pkn - this.pkp);
            }
            if (this.pkq != -1.0f) {
                path.quadTo(this.pkp, this.pkn - this.pkp, this.pkp, (this.pkn - this.pkp) - this.pkq);
            }
            path.close();
            canvas.drawPath(path, this.bhE);
        }
    }

    private void J(Canvas canvas) {
        if (!TextUtils.isEmpty(this.pkv)) {
            this.bhF.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.bhF.getFontMetricsInt();
            canvas.drawText(this.pkv, this.pko / 2.0f, (((((int) this.pkn) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.bhF);
        }
    }

    public void setStroke(int i) {
        this.pkm = i;
        invalidate();
    }

    public int getStyle() {
        return this.pki;
    }
}
