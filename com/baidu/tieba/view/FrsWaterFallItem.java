package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.data.bn;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FrsWaterFallItem extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextPaint f1794a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private Paint l;
    private int m;

    public FrsWaterFallItem(Context context) {
        super(context);
        this.f1794a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.m = 0;
        a();
    }

    public FrsWaterFallItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1794a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.m = 0;
        a();
    }

    public void a(int i, int i2, int i3) {
        this.g = i;
        this.h = i2;
        this.i = i3;
    }

    private void a() {
        this.f1794a = new TextPaint(1);
        this.l = new Paint();
        this.l.setAntiAlias(true);
        this.j = com.baidu.tieba.util.am.a(getContext(), 5.0f);
        this.k = com.baidu.tieba.util.am.a(getContext(), 2.0f);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap a2;
        Bitmap a3;
        super.onDraw(canvas);
        try {
            canvas.drawColor(16777215);
            bn bnVar = (bn) getTag();
            int height = ((getHeight() - getPaddingBottom()) - this.h) - this.j;
            int width = (getWidth() - getPaddingRight()) - this.j;
            this.f1794a.setTextSize(this.h);
            if (this.m == 1) {
                this.f1794a.setColor(-11446171);
            } else {
                this.f1794a.setColor(-5065030);
            }
            int ceil = (int) Math.ceil(this.f1794a.getFontMetrics().ascent);
            if (bnVar.e() > 0) {
                if (this.d == null) {
                    if (bnVar.e() > 999) {
                        this.d = "999+";
                    } else {
                        this.d = String.valueOf(bnVar.e());
                    }
                }
                if (this.e == -1) {
                    this.e = (width - ((int) Math.ceil(com.baidu.tieba.util.am.a((Paint) this.f1794a, this.d)))) - this.j;
                }
                canvas.drawText(this.d, this.e, height - ceil, this.f1794a);
                width = this.e;
            }
            if (this.e != -1) {
                if (this.m == 1) {
                    a3 = com.baidu.tieba.util.e.a((int) R.drawable.icon_little_comment_1);
                } else {
                    a3 = com.baidu.tieba.util.e.a((int) R.drawable.icon_little_comment);
                }
                this.f = this.e - a3.getWidth();
                width = this.f - this.i;
                canvas.drawBitmap(a3, width, ((this.h - a3.getHeight()) / 2) + height, this.l);
            }
            int i = width;
            if (this.m == 1) {
                a2 = com.baidu.tieba.util.e.a((int) R.drawable.icon_little_people_1);
            } else {
                a2 = com.baidu.tieba.util.e.a((int) R.drawable.icon_little_people);
            }
            this.c = com.baidu.tieba.util.am.a(this.f1794a, bnVar.a(), (i - a2.getWidth()) - (this.j * 2));
            int paddingLeft = getPaddingLeft() + this.j;
            canvas.drawBitmap(a2, paddingLeft, ((this.h - a2.getHeight()) / 2) + height, this.l);
            canvas.drawText(this.c, a2.getWidth() + paddingLeft + this.j, height - ceil, this.f1794a);
            this.f1794a.setTextSize(this.g);
            if (this.m == 1) {
                this.f1794a.setColor(-8682086);
            } else {
                this.f1794a.setColor(-14277082);
            }
            int ceil2 = (int) Math.ceil(this.f1794a.getFontMetrics().ascent);
            if (this.b == null) {
                this.b = com.baidu.tieba.util.am.a(this.f1794a, bnVar.c(), ((getWidth() - getPaddingLeft()) - getPaddingRight()) - this.j);
            }
            canvas.drawText(this.b, this.k + this.j, (height - ((this.i + this.g) + com.baidu.tieba.util.am.a(getContext(), 3.0f))) - ceil2, this.f1794a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i) {
        this.m = i;
        if (i == 1) {
            setBackgroundResource(R.drawable.bg_list_bottom_1);
        } else {
            setBackgroundResource(R.drawable.waterfall_bg);
        }
    }
}
