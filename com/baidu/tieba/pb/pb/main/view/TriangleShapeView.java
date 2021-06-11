package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class TriangleShapeView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f19328e;

    /* renamed from: f  reason: collision with root package name */
    public Path f19329f;

    /* renamed from: g  reason: collision with root package name */
    public int f19330g;

    public TriangleShapeView(Context context) {
        super(context);
        this.f19330g = R.color.CAM_X0205;
    }

    public final void a() {
        if (this.f19328e == null) {
            this.f19328e = new Paint();
        }
        this.f19328e.setAntiAlias(true);
        this.f19328e.setStyle(Paint.Style.FILL);
        this.f19328e.setColor(SkinManager.getColor(this.f19330g));
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
        if (this.f19329f == null) {
            this.f19329f = new Path();
        }
        float f2 = height;
        this.f19329f.moveTo(0.0f, f2);
        float f3 = width;
        this.f19329f.lineTo(f3 / 2.0f, 0.0f);
        this.f19329f.lineTo(f3, f2);
        this.f19329f.close();
        canvas.drawPath(this.f19329f, this.f19328e);
    }

    public void setColorId(int i2) {
        this.f19330g = i2;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19330g = R.color.CAM_X0205;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19330g = R.color.CAM_X0205;
    }
}
