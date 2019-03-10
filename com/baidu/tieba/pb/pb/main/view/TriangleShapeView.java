package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class TriangleShapeView extends View {
    private int hBs;
    private Paint mPaint;
    private Path mPath;

    public TriangleShapeView(Context context) {
        super(context);
        this.hBs = d.C0236d.cp_bg_line_e;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hBs = d.C0236d.cp_bg_line_e;
    }

    public TriangleShapeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hBs = d.C0236d.cp_bg_line_e;
    }

    public void setColorId(int i) {
        this.hBs = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (width != 0 && height != 0) {
            bOc();
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            this.mPath.moveTo(0.0f, height);
            this.mPath.lineTo(width / 2.0f, 0.0f);
            this.mPath.lineTo(width, height);
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    private void bOc() {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.hBs));
    }
}
