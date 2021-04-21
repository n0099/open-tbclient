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
    public Paint f19563e;

    /* renamed from: f  reason: collision with root package name */
    public Path f19564f;

    /* renamed from: g  reason: collision with root package name */
    public int f19565g;

    public TriangleShapeView(Context context) {
        super(context);
        this.f19565g = R.color.CAM_X0205;
    }

    public final void a() {
        if (this.f19563e == null) {
            this.f19563e = new Paint();
        }
        this.f19563e.setAntiAlias(true);
        this.f19563e.setStyle(Paint.Style.FILL);
        this.f19563e.setColor(SkinManager.getColor(this.f19565g));
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
        if (this.f19564f == null) {
            this.f19564f = new Path();
        }
        float f2 = height;
        this.f19564f.moveTo(0.0f, f2);
        float f3 = width;
        this.f19564f.lineTo(f3 / 2.0f, 0.0f);
        this.f19564f.lineTo(f3, f2);
        this.f19564f.close();
        canvas.drawPath(this.f19564f, this.f19563e);
    }

    public void setColorId(int i) {
        this.f19565g = i;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19565g = R.color.CAM_X0205;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19565g = R.color.CAM_X0205;
    }
}
