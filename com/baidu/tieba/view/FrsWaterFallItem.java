package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.slidingmenu.lib.R;
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
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private Paint p;
    private int q;

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
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = null;
        this.q = 0;
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
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = null;
        this.q = 0;
        a();
    }

    public void a(int i, int i2, int i3, int i4) {
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.l = i4;
    }

    private void a() {
        this.a = new TextPaint(1);
        this.p = new Paint();
        this.p.setAntiAlias(true);
        this.j = com.baidu.adp.lib.h.g.a(getContext(), 5.0f);
        this.k = com.baidu.adp.lib.h.g.a(getContext(), 2.0f);
        this.m = getContext().getResources().getDimensionPixelSize(R.dimen.default_gap_14);
        this.n = getContext().getResources().getDimensionPixelSize(R.dimen.default_gap_10);
        this.o = getContext().getResources().getDimensionPixelSize(R.dimen.default_gap_8);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap a;
        super.onDraw(canvas);
        try {
            com.baidu.tieba.data.bc bcVar = (com.baidu.tieba.data.bc) getTag();
            if (bcVar != null) {
                int height = ((getHeight() - getPaddingBottom()) - this.l) + this.n;
                int width = (getWidth() - getPaddingRight()) - this.j;
                this.a.setTextSize(this.h);
                if (this.q == 1) {
                    this.a.setColor(getContext().getResources().getColor(R.color.listview_item_num_text_1));
                } else {
                    this.a.setColor(getContext().getResources().getColor(R.color.listview_item_num_text));
                }
                int ceil = (int) Math.ceil(this.a.getFontMetrics().ascent);
                int e = bcVar.e();
                if (e > 0) {
                    if (this.d == null) {
                        if (e > 999) {
                            this.d = "999+";
                        } else {
                            this.d = String.valueOf(e);
                        }
                    }
                    if (this.e == -1) {
                        this.e = (width - ((int) Math.ceil(com.baidu.adp.lib.h.g.a((Paint) this.a, this.d)))) - this.j;
                    }
                    canvas.drawText(this.d, this.e, height - ceil, this.a);
                    width = this.e;
                }
                if (this.e != -1) {
                    if (this.q == 1) {
                        a = com.baidu.tieba.util.m.a((int) R.drawable.icon_little_comment_s_1);
                    } else {
                        a = com.baidu.tieba.util.m.a((int) R.drawable.icon_little_comment_s);
                    }
                    this.f = this.e - a.getWidth();
                    width = this.f - this.i;
                    canvas.drawBitmap(a, width, ((this.h - a.getHeight()) / 2) + height, this.p);
                }
                if (this.q == 1) {
                    this.a.setColor(getContext().getResources().getColor(R.color.listview_item_author_time_text_1));
                } else {
                    this.a.setColor(getContext().getResources().getColor(R.color.listview_item_author_time_text));
                }
                this.c = com.baidu.adp.lib.h.g.a(this.a, bcVar.a(), width - (this.j * 2));
                canvas.drawText(this.c, this.k + this.j, height - ceil, this.a);
                if (this.q == 1) {
                    this.a.setColor(getContext().getResources().getColor(R.color.frs_header_divider_bg_1));
                } else {
                    this.a.setColor(getContext().getResources().getColor(R.color.frs_header_divider_bg));
                }
                int height2 = (getHeight() - getPaddingBottom()) - this.l;
                canvas.drawRect(this.o, height2, getWidth() - this.o, height2 + 2, this.a);
                this.a.setTextSize(this.g);
                if (this.q == 1) {
                    this.a.setColor(getContext().getResources().getColor(R.color.listview_item_title_text_1));
                } else {
                    this.a.setColor(getContext().getResources().getColor(R.color.listview_item_title_text));
                }
                int ceil2 = (int) Math.ceil(this.a.getFontMetrics().ascent);
                if (this.b == null) {
                    this.b = com.baidu.adp.lib.h.g.a(this.a, bcVar.c(), ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.j * 2));
                }
                canvas.drawText(this.b, this.k + this.j, (((getHeight() - getPaddingBottom()) - (this.l * 2)) + this.m) - ceil2, this.a);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(int i) {
        this.q = i;
        if (i == 1) {
            setBackgroundResource(R.drawable.bg_frs_image_item_1);
        } else {
            setBackgroundResource(R.drawable.bg_frs_image_item);
        }
    }
}
