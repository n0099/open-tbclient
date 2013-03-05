package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.au;
/* loaded from: classes.dex */
public class FrsWaterFallItem extends LinearLayout {
    private TextPaint a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    public FrsWaterFallItem(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        a();
    }

    public FrsWaterFallItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = -1;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        a();
    }

    public void a(int i, int i2, int i3) {
        this.g = i;
        this.h = i2;
        this.i = i3;
    }

    private void a() {
        this.a = new TextPaint(1);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            if (this.j == 1) {
                canvas.drawColor(TiebaApplication.b().getResources().getColor(R.color.skin_1_second_common_bg));
            } else {
                canvas.drawColor(TiebaApplication.b().getResources().getColor(R.color.white));
            }
            au auVar = (au) getTag();
            int height = (getHeight() - getPaddingBottom()) - this.h;
            int width = getWidth() - getPaddingRight();
            this.a.setTextSize(this.h);
            this.a.setColor(-6908266);
            int ceil = (int) Math.ceil(this.a.getFontMetrics().ascent);
            if (auVar.e() > 0) {
                if (this.d == null) {
                    if (auVar.e() > 999) {
                        this.d = "999+";
                    } else {
                        this.d = String.valueOf(auVar.e());
                    }
                }
                if (this.e == -1) {
                    this.e = width - ((int) Math.ceil(com.baidu.tieba.c.ai.a((Paint) this.a, this.d)));
                }
                canvas.drawText(this.d, this.e, height - ceil, this.a);
                width = this.e - com.baidu.tieba.c.ai.a(getContext(), 2.0f);
            }
            if (this.e != -1) {
                Bitmap a = com.baidu.tieba.c.e.a((int) R.drawable.icon_reply);
                this.f = this.e - a.getWidth();
                width = this.f - this.i;
                canvas.drawBitmap(a, this.f, ((this.h - a.getHeight()) / 2) + height, (Paint) null);
            }
            if (this.c == null) {
                this.c = com.baidu.tieba.c.ai.a(this.a, auVar.a(), width - getPaddingLeft());
            }
            canvas.drawText(auVar.a(), getPaddingLeft(), height - ceil, this.a);
            this.a.setTextSize(this.g);
            if (this.j == 1) {
                this.a.setColor(TiebaApplication.b().getResources().getColor(R.color.skin_1_common_color));
            } else {
                this.a.setColor(-13421773);
            }
            int ceil2 = (int) Math.ceil(this.a.getFontMetrics().ascent);
            if (this.b == null) {
                this.b = com.baidu.tieba.c.ai.a(this.a, auVar.c(), (getWidth() - getPaddingLeft()) - getPaddingRight());
            }
            canvas.drawText(this.b, getPaddingLeft(), (height - (this.i + this.g)) - ceil2, this.a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(int i) {
        this.j = i;
    }
}
