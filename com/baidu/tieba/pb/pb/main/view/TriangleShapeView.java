package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class TriangleShapeView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f20043e;

    /* renamed from: f  reason: collision with root package name */
    public Path f20044f;

    /* renamed from: g  reason: collision with root package name */
    public int f20045g;

    public TriangleShapeView(Context context) {
        super(context);
        this.f20045g = R.color.CAM_X0205;
    }

    public final void a() {
        if (this.f20043e == null) {
            this.f20043e = new Paint();
        }
        this.f20043e.setAntiAlias(true);
        this.f20043e.setStyle(Paint.Style.FILL);
        this.f20043e.setColor(SkinManager.getColor(this.f20045g));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        a();
        if (this.f20044f == null) {
            this.f20044f = new Path();
        }
        float f2 = height;
        this.f20044f.moveTo(0.0f, f2);
        float f3 = width;
        this.f20044f.lineTo(f3 / 2.0f, 0.0f);
        this.f20044f.lineTo(f3, f2);
        this.f20044f.close();
        canvas.drawPath(this.f20044f, this.f20043e);
    }

    public void setColorId(int i2) {
        this.f20045g = i2;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20045g = R.color.CAM_X0205;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20045g = R.color.CAM_X0205;
    }
}
