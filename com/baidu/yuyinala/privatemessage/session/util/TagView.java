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
    private Paint bjn;
    private Paint bjo;
    private int mBgColor;
    private Context mContext;
    private int mTextColor;
    private float mTextSize;
    private int pdV;
    private int pdW;
    private int pdX;
    private int pdY;
    private int pdZ;
    private float pea;
    private float peb;
    private float pec;
    private float ped;
    private float pee;
    private float pef;
    private float peg;
    private float peh;
    private String pei;
    private int pej;
    private boolean pek;
    private Paint pel;
    private LinearGradient pem;

    public TagView(Context context) {
        this(context, null);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pdV = -1;
        this.pea = -1.0f;
        this.peb = -1.0f;
        this.mContext = context;
        init(attributeSet);
    }

    public void setText(String str) {
        this.pei = str;
        if (!TextUtils.isEmpty(this.pei)) {
            this.pej = this.pei.length();
        }
        requestLayout();
        invalidate();
    }

    public String getText() {
        return this.pei;
    }

    public void setBgColor(int i) {
        this.mBgColor = i;
        this.pdW = -1;
        this.pdX = -1;
        invalidate();
    }

    public void setGradientColor(int i, int i2) {
        this.pdW = i;
        this.pdX = i2;
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
            if (this.pdV == 1) {
                size = (int) this.peb;
            } else if (this.pdV == 2) {
                size = (int) ((this.peh * 2.0f) + (this.pec * 2.0f));
                if (!TextUtils.isEmpty(this.pei)) {
                    if (this.pej == 1) {
                        size = (int) this.pea;
                    } else {
                        size = (int) (size + this.bjo.measureText(this.pei));
                    }
                }
            } else {
                size = (int) ((this.peh * 2.0f) + (this.pec * 2.0f));
                if (!TextUtils.isEmpty(this.pei)) {
                    size = (int) (size + this.bjo.measureText(this.pei));
                }
            }
        }
        if (mode2 != 1073741824) {
            size2 = (int) this.pea;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.peb = i;
        this.pea = i2;
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
        this.pdW = obtainStyledAttributes.getColor(a.j.TagView_bgGradientStartColor, 0);
        this.pdX = obtainStyledAttributes.getColor(a.j.TagView_bgGradientEndColor, 0);
        this.mTextColor = obtainStyledAttributes.getColor(a.j.TagView_textColor, 0);
        this.pdZ = obtainStyledAttributes.getColor(a.j.TagView_bgTraceColor, 0);
        this.pdY = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_bgGradientAngle, -1);
        this.mTextSize = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_textSize, -1);
        this.pek = obtainStyledAttributes.getBoolean(a.j.TagView_textIsBold, false);
        this.peh = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_horizontalMargin, -1);
        this.pec = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_traceWidth, 0);
        this.ped = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftBottomConnerRadius, -1);
        this.pee = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_leftTopConnerRadius, -1);
        this.pef = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightTopConnerRadius, -1);
        this.peg = obtainStyledAttributes.getDimensionPixelSize(a.j.TagView_rightBottomConnerRadius, -1);
        this.pdV = obtainStyledAttributes.getInt(a.j.TagView_viewStyle, -1);
        this.pei = obtainStyledAttributes.getString(a.j.TagView_text);
        obtainStyledAttributes.recycle();
        this.bjn = new Paint(1);
        this.bjn.setStyle(Paint.Style.FILL);
        this.bjn.setDither(true);
        this.bjo = new Paint(1);
        this.bjo.setTextAlign(Paint.Align.CENTER);
        this.bjo.setFakeBoldText(this.pek);
        eoy();
        this.bjo.setTextSize(this.mTextSize);
        if (this.pec != 0.0f) {
            this.pel = new Paint(1);
            this.pel.setStyle(Paint.Style.FILL);
            this.pel.setDither(true);
        }
    }

    private void eoy() {
        if (this.pdV != -1) {
            if (this.pdV == 0) {
                this.pea = this.pea != -1.0f ? this.pea : f.dip2px(this.mContext, 15.0f);
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.ped = this.ped != -1.0f ? this.ped : f.dip2px(this.mContext, 2.0f);
                this.pee = this.pee != -1.0f ? this.pee : f.dip2px(this.mContext, 2.0f);
                this.peg = this.peg != -1.0f ? this.peg : f.dip2px(this.mContext, 2.0f);
                this.pef = this.pef != -1.0f ? this.pef : f.dip2px(this.mContext, 2.0f);
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 9.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.peh = f.dip2px(this.mContext, 4.0f);
            } else if (this.pdV == 1) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pea = f.dip2px(this.mContext, 8.0f);
                this.peb = f.dip2px(this.mContext, 8.0f);
                this.ped = f.dip2px(this.mContext, 4.0f);
                this.pee = this.ped;
                this.peg = this.ped;
                this.pef = this.ped;
            } else if (this.pdV == 2) {
                this.mBgColor = this.mBgColor != 0 ? this.mBgColor : -45690;
                this.pea = this.pea != -1.0f ? this.pea : f.dip2px(this.mContext, 16.0f);
                this.ped = f.dip2px(this.mContext, 8.0f);
                this.pee = this.ped;
                this.peg = this.ped;
                this.pef = this.ped;
                this.mTextSize = this.mTextSize != -1.0f ? this.mTextSize : f.dip2px(this.mContext, 12.0f);
                this.mTextColor = this.mTextColor != 0 ? this.mTextColor : -1;
                this.peh = this.peh != -1.0f ? this.peh : f.dip2px(this.mContext, 4.0f);
            }
        }
    }

    private void aB(Canvas canvas) {
        if (this.pec != 0.0f) {
            this.pel.setColor(this.pdZ);
            if (this.pdV == 1) {
                canvas.drawCircle(this.peb / 2.0f, this.pea / 2.0f, this.pea / 2.0f, this.pel);
                return;
            }
            if (this.pdV == 2 && this.pej == 1) {
                canvas.drawCircle(this.pea / 2.0f, this.pea / 2.0f, this.pea / 2.0f, this.pel);
            }
            Path path = new Path();
            if (this.pee != -1.0f) {
                path.moveTo(0.0f, this.pee + this.pec);
                path.quadTo(0.0f, 0.0f, this.pee + this.pec, 0.0f);
            }
            if (this.pef != -1.0f) {
                path.lineTo(this.peb - (this.pef + this.pec), 0.0f);
            } else {
                path.lineTo(this.peb, 0.0f);
            }
            if (this.pef != -1.0f) {
                path.quadTo(this.peb, 0.0f, this.peb, this.pef + this.pec);
            }
            if (this.peg != -1.0f) {
                path.lineTo(this.peb, this.pea - (this.peg + this.pec));
            } else {
                path.lineTo(this.peb, this.pea);
            }
            if (this.peg != -1.0f) {
                path.quadTo(this.peb, this.pea, this.peb - (this.peg + this.pec), this.pea);
            }
            if (this.ped != -1.0f) {
                path.lineTo(this.ped + this.pec, this.pea);
            } else {
                path.lineTo(0.0f, this.pea);
            }
            if (this.ped != -1.0f) {
                path.quadTo(0.0f, this.pea, 0.0f, this.pea - (this.ped + this.pec));
            }
            path.close();
            canvas.drawPath(path, this.pel);
        }
    }

    private void aC(Canvas canvas) {
        if (this.mBgColor != 0) {
            this.bjn.setColor(this.mBgColor);
            this.bjn.setShader(null);
        }
        if (this.pdW != 0 || this.pdX != 0) {
            this.pem = new LinearGradient(0.0f, 0.0f, this.peb, this.pea, this.pdW, this.pdX, Shader.TileMode.CLAMP);
            this.bjn.setShader(this.pem);
        }
        if (this.pdV == 1) {
            canvas.drawCircle(this.peb / 2.0f, this.pea / 2.0f, this.ped, this.bjn);
        } else if (this.pdV == 2 && this.pej == 1) {
            canvas.drawCircle(this.pea / 2.0f, this.pea / 2.0f, this.pea / 2.0f, this.bjn);
        } else {
            Path path = new Path();
            if (this.pee != -1.0f) {
                path.moveTo(this.pec, this.pec + this.pee);
                path.quadTo(this.pec, this.pec, this.pec + this.pee, this.pec);
            }
            if (this.pef != -1.0f) {
                path.lineTo((this.peb - this.pec) - this.pef, this.pec);
            } else {
                path.lineTo(this.peb - this.pec, this.pec);
            }
            if (this.pef != -1.0f) {
                path.quadTo(this.peb - this.pec, this.pec, this.peb - this.pec, this.pef + this.pec);
            }
            if (this.peg != -1.0f) {
                path.lineTo(this.peb - this.pec, (this.pea - this.pec) - this.peg);
            } else {
                path.lineTo(this.peb - this.pec, this.pea - this.pec);
            }
            if (this.peg != -1.0f) {
                path.quadTo(this.peb - this.pec, this.pea - this.pec, (this.peb - this.pec) - this.peg, this.pea - this.pec);
            }
            if (this.ped != -1.0f) {
                path.lineTo(this.ped + this.pec, this.pea - this.pec);
            } else {
                path.lineTo(this.pec, this.pea - this.pec);
            }
            if (this.ped != -1.0f) {
                path.quadTo(this.pec, this.pea - this.pec, this.pec, (this.pea - this.pec) - this.ped);
            }
            path.close();
            canvas.drawPath(path, this.bjn);
        }
    }

    private void J(Canvas canvas) {
        if (!TextUtils.isEmpty(this.pei)) {
            this.bjo.setColor(this.mTextColor);
            Paint.FontMetricsInt fontMetricsInt = this.bjo.getFontMetricsInt();
            canvas.drawText(this.pei, this.peb / 2.0f, (((((int) this.pea) + 0) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2, this.bjo);
        }
    }

    public void setStroke(int i) {
        this.pdZ = i;
        invalidate();
    }

    public int getStyle() {
        return this.pdV;
    }
}
