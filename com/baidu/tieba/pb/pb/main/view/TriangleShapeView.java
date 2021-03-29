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
    public Paint f19870e;

    /* renamed from: f  reason: collision with root package name */
    public Path f19871f;

    /* renamed from: g  reason: collision with root package name */
    public int f19872g;

    public TriangleShapeView(Context context) {
        super(context);
        this.f19872g = R.color.CAM_X0205;
    }

    public final void a() {
        if (this.f19870e == null) {
            this.f19870e = new Paint();
        }
        this.f19870e.setAntiAlias(true);
        this.f19870e.setStyle(Paint.Style.FILL);
        this.f19870e.setColor(SkinManager.getColor(this.f19872g));
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
        if (this.f19871f == null) {
            this.f19871f = new Path();
        }
        float f2 = height;
        this.f19871f.moveTo(0.0f, f2);
        float f3 = width;
        this.f19871f.lineTo(f3 / 2.0f, 0.0f);
        this.f19871f.lineTo(f3, f2);
        this.f19871f.close();
        canvas.drawPath(this.f19871f, this.f19870e);
    }

    public void setColorId(int i) {
        this.f19872g = i;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19872g = R.color.CAM_X0205;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19872g = R.color.CAM_X0205;
    }
}
