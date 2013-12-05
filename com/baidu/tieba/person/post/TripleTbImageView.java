package com.baidu.tieba.person.post;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
/* loaded from: classes.dex */
public class TripleTbImageView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f2368a = {0.5f, 0.33f, 0.25f};
    private static com.baidu.tieba.util.i g;
    private static int h;
    public TbImageView b;
    public TbImageView c;
    public TbImageView d;
    public Object[] e;
    public final int f;

    public TripleTbImageView(Context context) {
        this(context, null);
    }

    public TripleTbImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new TbImageView(context);
        this.c = new TbImageView(context);
        this.d = new TbImageView(context);
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.b);
        addView(this.c);
        addView(this.d);
        this.f = com.baidu.adp.lib.h.g.a(context, 6.0f);
        if (g == null) {
            g = new com.baidu.tieba.util.i(context);
        }
    }

    public void setTags(Object[] objArr) {
        this.e = objArr;
        if (objArr == null) {
            this.b.setTag(null);
            this.c.setTag(null);
            this.d.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        int length = objArr.length;
        if (length == 0) {
            this.b.setTag(null);
            this.c.setTag(null);
            this.d.setTag(null);
            requestLayout();
            invalidate();
            return;
        }
        switch (length) {
            case 1:
                g.a(480, 480);
                break;
            case 2:
                g.a(300, 300);
                break;
            case 3:
                g.a(200, 200);
                break;
        }
        if (length == 1) {
            String str = (String) objArr[0];
            this.b.setTag(str);
            com.baidu.adp.widget.ImageView.e a2 = g.a(str, new x(this, str));
            if (a2 != null) {
                this.b.setTag(str);
                a(this.b, a2);
            }
            this.c.setTag(null);
            this.d.setTag(null);
        } else if (length == 2) {
            String str2 = (String) objArr[0];
            this.b.setTag(str2);
            com.baidu.adp.widget.ImageView.e a3 = g.a(str2, new y(this, str2));
            if (a3 != null) {
                this.b.setTag(str2);
                a(this.b, a3);
            }
            String str3 = (String) objArr[1];
            com.baidu.adp.widget.ImageView.e a4 = g.a(str3, new z(this, str3));
            if (a4 != null) {
                this.c.setTag(str3);
                a(this.c, a4);
            }
            this.d.setTag(null);
        } else if (length == 3) {
            String str4 = (String) objArr[0];
            this.b.setTag(str4);
            com.baidu.adp.widget.ImageView.e a5 = g.a(str4, new aa(this, str4));
            if (a5 != null) {
                this.b.setTag(str4);
                a(this.b, a5);
            }
            String str5 = (String) objArr[1];
            com.baidu.adp.widget.ImageView.e a6 = g.a(str5, new ab(this, str5));
            if (a6 != null) {
                this.c.setTag(str5);
                a(this.c, a6);
            }
            String str6 = (String) objArr[2];
            com.baidu.adp.widget.ImageView.e a7 = g.a(str6, new ac(this, str6));
            if (a7 != null) {
                this.d.setTag(str6);
                a(this.d, a7);
            }
        }
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TbImageView tbImageView, com.baidu.adp.widget.ImageView.e eVar) {
        if (this.e != null) {
            int length = (int) (h / this.e.length);
            if (eVar.a() < length * 0.3f || eVar.b() < length * f2368a[this.e.length - 1] * 0.3f) {
                tbImageView.setScaleType(ImageView.ScaleType.FIT_START);
            } else {
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            tbImageView.invalidate();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 1073741823 & i;
        if (h == 0) {
            h = i3;
        }
        if (this.e == null || this.e.length == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        setMeasuredDimension(i3, (int) ((i3 * f2368a[this.e.length - 1]) + 0.5f));
        switch (this.e.length) {
            case 1:
                measureChild(this.b, i3 + 1073741824, ((int) ((i3 * f2368a[0]) + 0.5f)) + 1073741824);
                measureChild(this.c, 0, 0);
                measureChild(this.d, 0, 0);
                return;
            case 2:
                int i4 = ((i3 - (this.f * 3)) >> 1) + 1073741824;
                int i5 = ((int) ((i4 * f2368a[1]) + 0.5f)) + 1073741824;
                measureChild(this.b, i4, i5);
                measureChild(this.c, i4, i5);
                measureChild(this.d, 0, 0);
                break;
            case 3:
                break;
            default:
                return;
        }
        int i6 = ((i3 - (this.f * 4)) / 3) + 1073741824;
        int i7 = ((int) ((i6 * f2368a[2]) + 0.5f)) + 1073741824;
        measureChild(this.b, i6, i7);
        measureChild(this.c, i6, i7);
        measureChild(this.d, i6, i7);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.e != null && this.e.length != 0) {
            switch (this.e.length) {
                case 1:
                    this.b.layout(0, 0, i3, i4);
                    this.c.layout(0, 0, 0, 0);
                    this.d.layout(0, 0, 0, 0);
                    return;
                case 2:
                    int measuredWidth = (getMeasuredWidth() - (this.f * 3)) >> 1;
                    this.b.layout(this.f, 0, this.f + measuredWidth, i4);
                    this.c.layout((this.f * 2) + measuredWidth, 0, (measuredWidth * 2) + (this.f * 2), i4);
                    this.d.layout(0, 0, 0, 0);
                    return;
                case 3:
                    int measuredWidth2 = (getMeasuredWidth() - (this.f * 4)) / 3;
                    this.b.layout(this.f, 0, this.f + measuredWidth2, i4);
                    this.c.layout((this.f * 2) + measuredWidth2, 0, (measuredWidth2 * 2) + (this.f * 2), i4);
                    this.d.layout((measuredWidth2 * 2) + (this.f * 3), 0, (measuredWidth2 * 3) + (this.f * 3), i4);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.e != null && this.e.length != 0) {
            long drawingTime = getDrawingTime();
            switch (this.e.length) {
                case 1:
                    drawChild(canvas, this.b, drawingTime);
                    return;
                case 2:
                    drawChild(canvas, this.b, drawingTime);
                    drawChild(canvas, this.c, drawingTime);
                    return;
                case 3:
                    drawChild(canvas, this.b, drawingTime);
                    drawChild(canvas, this.c, drawingTime);
                    drawChild(canvas, this.d, drawingTime);
                    return;
                default:
                    return;
            }
        }
    }
}
