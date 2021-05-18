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
    public Paint f19331e;

    /* renamed from: f  reason: collision with root package name */
    public Path f19332f;

    /* renamed from: g  reason: collision with root package name */
    public int f19333g;

    public TriangleShapeView(Context context) {
        super(context);
        this.f19333g = R.color.CAM_X0205;
    }

    public final void a() {
        if (this.f19331e == null) {
            this.f19331e = new Paint();
        }
        this.f19331e.setAntiAlias(true);
        this.f19331e.setStyle(Paint.Style.FILL);
        this.f19331e.setColor(SkinManager.getColor(this.f19333g));
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
        if (this.f19332f == null) {
            this.f19332f = new Path();
        }
        float f2 = height;
        this.f19332f.moveTo(0.0f, f2);
        float f3 = width;
        this.f19332f.lineTo(f3 / 2.0f, 0.0f);
        this.f19332f.lineTo(f3, f2);
        this.f19332f.close();
        canvas.drawPath(this.f19332f, this.f19331e);
    }

    public void setColorId(int i2) {
        this.f19333g = i2;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19333g = R.color.CAM_X0205;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19333g = R.color.CAM_X0205;
    }
}
