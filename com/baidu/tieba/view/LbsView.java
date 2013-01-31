package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class LbsView extends RelativeLayout {
    private float a;
    private float b;
    private Paint c;
    private TextPaint d;
    private Point e;
    private int f;
    private int g;
    private int h;
    private RectF i;
    private int j;
    private int k;
    private int l;
    private ArrayList m;
    private float n;
    private int o;
    private int p;
    private int q;

    public LbsView(Context context) {
        super(context);
        this.a = 0.6666667f;
        this.b = 0.6666667f;
        this.c = new Paint();
        this.d = new TextPaint();
        this.e = new Point(0, 0);
        this.f = 0;
        this.g = 1;
        this.h = 10;
        this.i = new RectF();
        this.j = 1;
        this.k = 8;
        this.l = 0;
        this.m = null;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = 446273945;
        a();
    }

    public LbsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.6666667f;
        this.b = 0.6666667f;
        this.c = new Paint();
        this.d = new TextPaint();
        this.e = new Point(0, 0);
        this.f = 0;
        this.g = 1;
        this.h = 10;
        this.i = new RectF();
        this.j = 1;
        this.k = 8;
        this.l = 0;
        this.m = null;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = 446273945;
        a();
    }

    public LbsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.6666667f;
        this.b = 0.6666667f;
        this.c = new Paint();
        this.d = new TextPaint();
        this.e = new Point(0, 0);
        this.f = 0;
        this.g = 1;
        this.h = 10;
        this.i = new RectF();
        this.j = 1;
        this.k = 8;
        this.l = 0;
        this.m = null;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = 446273945;
        a();
    }

    public void a() {
        setWillNotDraw(false);
        setDrawingCacheEnabled(false);
        this.j = com.baidu.tieba.c.ah.a(getContext(), 1.0f);
        this.k = com.baidu.tieba.c.ah.a(getContext(), 8.0f);
        this.h = com.baidu.tieba.c.ah.a(getContext(), 10.0f);
        this.l = com.baidu.tieba.c.ah.a(getContext(), 2.0f);
        this.m = new ArrayList(3);
        this.c.setAntiAlias(true);
        this.d.setAntiAlias(true);
        this.n = com.baidu.tieba.c.ah.c(getContext(), 10.0f);
        this.d.setTextSize(this.n);
        this.d.setColor(-5917250);
        this.d.setFakeBoldText(true);
    }

    public void a(int i) {
        if (i == 1) {
            this.d.setColor(-11842741);
            setBackgroundColor(com.baidu.tieba.c.ad.d(i));
            this.q = 436207616;
            this.p = 446405531;
        } else {
            this.d.setColor(-5917250);
            setBackgroundColor(getContext().getResources().getColor(R.color.backgroundcolor));
            this.q = 446273945;
            this.p = 1288490188;
        }
        invalidate();
    }

    public float getDistanceOffset() {
        return this.b;
    }

    public float getFontSize() {
        return this.n;
    }

    public void b() {
        this.m.clear();
        this.o = 0;
    }

    public void a(String str) {
        this.m.add(str);
    }

    public void setZoneNum(int i) {
        if (i > 0) {
            this.g = i;
            this.a /= i;
        }
    }

    public void setDisplayNum(int i) {
        if (i > this.o) {
            this.o = i;
            invalidate();
        }
    }

    public int getZoneNum() {
        return this.g;
    }

    public void b(int i) {
        int height;
        int height2 = getHeight() - i;
        if (height2 >= 0 && (height = getHeight() / this.g) != 0) {
            int i2 = height2 / height;
            if (height2 % height > (height >> 1)) {
                i2++;
            }
            setDisplayNum(i2);
        }
    }

    public int c(int i) {
        int size = this.m.size();
        if (i < 0 || i >= size) {
            return 0;
        }
        return ((int) com.baidu.tieba.c.ah.a((Paint) this.d, (String) this.m.get(i))) + this.l;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int i5 = i4 - i2;
            int i6 = (i3 - i) >> 1;
            int i7 = (int) (i5 * this.a);
            this.e.x = i6;
            if (i5 <= 0) {
                this.f = i6;
            } else {
                this.f = (((i6 * i6) / i7) + i7) >> 1;
            }
            this.e.y = (i5 + this.f) - i7;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        int size = this.m.size();
        for (int i = 0; i < this.g && i < size && i < this.o; i++) {
            a(canvas, i);
        }
        b(canvas);
    }

    private void a(Canvas canvas) {
        this.c.setColor(this.q);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.j);
        int i = this.h;
        while (true) {
            int i2 = i;
            if (i2 > getHeight()) {
                break;
            }
            canvas.drawLine(0.0f, i2, getWidth(), i2, this.c);
            i = this.h + i2;
        }
        int i3 = this.h;
        while (i3 <= getWidth()) {
            canvas.drawLine(i3, 0.0f, i3, getHeight(), this.c);
            i3 += this.h;
        }
    }

    private void a(Canvas canvas, int i) {
        this.c.setColor(this.p);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setStrokeWidth(this.k);
        int height = this.e.y - ((getHeight() * i) / this.g);
        this.i.left = this.e.x - this.f;
        this.i.right = this.e.x + this.f;
        this.i.top = height - this.f;
        this.i.bottom = height + this.f;
        canvas.drawArc(this.i, 180.0f, 180.0f, false, this.c);
    }

    private void b(Canvas canvas) {
        int height = getHeight() / this.g;
        int size = this.m.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.g && i2 < size && i2 < this.o) {
                canvas.drawText((String) this.m.get(i2), this.l, (int) (height * (((this.g - i2) - 1) + this.b)), this.d);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
