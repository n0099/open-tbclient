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
    public Paint f19555e;

    /* renamed from: f  reason: collision with root package name */
    public Path f19556f;

    /* renamed from: g  reason: collision with root package name */
    public int f19557g;

    public TriangleShapeView(Context context) {
        super(context);
        this.f19557g = R.color.CAM_X0205;
    }

    public final void a() {
        if (this.f19555e == null) {
            this.f19555e = new Paint();
        }
        this.f19555e.setAntiAlias(true);
        this.f19555e.setStyle(Paint.Style.FILL);
        this.f19555e.setColor(SkinManager.getColor(this.f19557g));
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
        if (this.f19556f == null) {
            this.f19556f = new Path();
        }
        float f2 = height;
        this.f19556f.moveTo(0.0f, f2);
        float f3 = width;
        this.f19556f.lineTo(f3 / 2.0f, 0.0f);
        this.f19556f.lineTo(f3, f2);
        this.f19556f.close();
        canvas.drawPath(this.f19556f, this.f19555e);
    }

    public void setColorId(int i) {
        this.f19557g = i;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19557g = R.color.CAM_X0205;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19557g = R.color.CAM_X0205;
    }
}
