package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class FrsWaterFallItem extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextPaint f2518a;
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
        this.f2518a = null;
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
        this.f2518a = null;
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
        this.f2518a = new TextPaint(1);
        this.p = new Paint();
        this.p.setAntiAlias(true);
        this.j = UtilHelper.a(getContext(), 5.0f);
        this.k = UtilHelper.a(getContext(), 2.0f);
        this.m = getContext().getResources().getDimensionPixelSize(R.dimen.default_gap_14);
        this.n = getContext().getResources().getDimensionPixelSize(R.dimen.default_gap_10);
        this.o = getContext().getResources().getDimensionPixelSize(R.dimen.default_gap_8);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap a2;
        super.onDraw(canvas);
        try {
            com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) getTag();
            if (baVar != null) {
                int height = ((getHeight() - getPaddingBottom()) - this.l) + this.n;
                int width = (getWidth() - getPaddingRight()) - this.j;
                this.f2518a.setTextSize(this.h);
                if (this.q == 1) {
                    this.f2518a.setColor(getContext().getResources().getColor(R.color.listview_item_num_text_1));
                } else {
                    this.f2518a.setColor(getContext().getResources().getColor(R.color.listview_item_num_text));
                }
                int ceil = (int) Math.ceil(this.f2518a.getFontMetrics().ascent);
                int e = baVar.e();
                if (e > 0) {
                    if (this.d == null) {
                        if (e > 999) {
                            this.d = "999+";
                        } else {
                            this.d = String.valueOf(e);
                        }
                    }
                    if (this.e == -1) {
                        this.e = (width - ((int) Math.ceil(UtilHelper.a((Paint) this.f2518a, this.d)))) - this.j;
                    }
                    canvas.drawText(this.d, this.e, height - ceil, this.f2518a);
                    width = this.e;
                }
                if (this.e != -1) {
                    if (this.q == 1) {
                        a2 = com.baidu.tieba.util.m.a((int) R.drawable.icon_little_comment_s_1);
                    } else {
                        a2 = com.baidu.tieba.util.m.a((int) R.drawable.icon_little_comment_s);
                    }
                    this.f = this.e - a2.getWidth();
                    width = this.f - this.i;
                    canvas.drawBitmap(a2, width, ((this.h - a2.getHeight()) / 2) + height, this.p);
                }
                if (this.q == 1) {
                    this.f2518a.setColor(getContext().getResources().getColor(R.color.listview_item_author_time_text_1));
                } else {
                    this.f2518a.setColor(getContext().getResources().getColor(R.color.listview_item_author_time_text));
                }
                this.c = UtilHelper.a(this.f2518a, baVar.a(), width - (this.j * 2));
                canvas.drawText(this.c, this.k + this.j, height - ceil, this.f2518a);
                if (this.q == 1) {
                    this.f2518a.setColor(getContext().getResources().getColor(R.color.frs_header_divider_bg_1));
                } else {
                    this.f2518a.setColor(getContext().getResources().getColor(R.color.frs_header_divider_bg));
                }
                int height2 = (getHeight() - getPaddingBottom()) - this.l;
                canvas.drawRect(this.o, height2, getWidth() - this.o, height2 + 2, this.f2518a);
                this.f2518a.setTextSize(this.g);
                if (this.q == 1) {
                    this.f2518a.setColor(getContext().getResources().getColor(R.color.listview_item_title_text_1));
                } else {
                    this.f2518a.setColor(getContext().getResources().getColor(R.color.listview_item_title_text));
                }
                int ceil2 = (int) Math.ceil(this.f2518a.getFontMetrics().ascent);
                if (this.b == null) {
                    this.b = UtilHelper.a(this.f2518a, baVar.c(), ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.j * 2));
                }
                canvas.drawText(this.b, this.k + this.j, (((getHeight() - getPaddingBottom()) - (this.l * 2)) + this.m) - ceil2, this.f2518a);
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
