package com.baidu.tieba.kn.pk.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;
/* loaded from: classes.dex */
public class i extends View {

    /* renamed from: a  reason: collision with root package name */
    private Point f1801a;
    private Point b;
    private Point c;
    private Point d;
    private Paint e;
    private Path f;
    private LinearGradient g;
    private LinearGradient h;

    public i(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.FILL);
        this.e.setColor(Color.parseColor("#88000000"));
        this.f = new Path();
    }

    public void a(Point point, Point point2, Point point3, Point point4) {
        this.f1801a = point;
        this.c = point3;
        this.d = point4;
        this.b = point2;
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1801a != null && this.c != null && this.b != null && this.d != null) {
            this.g = new LinearGradient(this.f1801a.x / 2.0f, 0.0f, this.c.x / 2.0f, this.c.y, Color.parseColor("#9a000000"), Color.parseColor("#00000000"), Shader.TileMode.MIRROR);
            this.h = new LinearGradient((this.b.x + getWidth()) / 2.0f, 0.0f, (this.d.x + getWidth()) / 2.0f, this.d.y, Color.parseColor("#9a000000"), Color.parseColor("#00000000"), Shader.TileMode.MIRROR);
            this.f.reset();
            this.f.moveTo(0.0f, 0.0f);
            this.f.lineTo(this.f1801a.x, this.f1801a.y);
            this.f.lineTo(this.c.x, this.c.y);
            this.f.lineTo(0.0f, this.c.y);
            this.e.setShader(this.g);
            canvas.drawPath(this.f, this.e);
            this.f.reset();
            this.f.moveTo(this.b.x, this.b.y);
            this.f.lineTo(getWidth(), 0.0f);
            this.f.lineTo(getWidth(), this.d.y);
            this.f.lineTo(this.d.x, this.d.y);
            this.e.setShader(this.h);
            canvas.drawPath(this.f, this.e);
        }
    }
}
