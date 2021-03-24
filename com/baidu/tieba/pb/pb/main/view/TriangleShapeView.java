package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class TriangleShapeView extends View {

    /* renamed from: e  reason: collision with root package name */
    public Paint f19869e;

    /* renamed from: f  reason: collision with root package name */
    public Path f19870f;

    /* renamed from: g  reason: collision with root package name */
    public int f19871g;

    public TriangleShapeView(Context context) {
        super(context);
        this.f19871g = R.color.CAM_X0205;
    }

    public final void a() {
        if (this.f19869e == null) {
            this.f19869e = new Paint();
        }
        this.f19869e.setAntiAlias(true);
        this.f19869e.setStyle(Paint.Style.FILL);
        this.f19869e.setColor(SkinManager.getColor(this.f19871g));
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
        if (this.f19870f == null) {
            this.f19870f = new Path();
        }
        float f2 = height;
        this.f19870f.moveTo(0.0f, f2);
        float f3 = width;
        this.f19870f.lineTo(f3 / 2.0f, 0.0f);
        this.f19870f.lineTo(f3, f2);
        this.f19870f.close();
        canvas.drawPath(this.f19870f, this.f19869e);
    }

    public void setColorId(int i) {
        this.f19871g = i;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19871g = R.color.CAM_X0205;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19871g = R.color.CAM_X0205;
    }
}
