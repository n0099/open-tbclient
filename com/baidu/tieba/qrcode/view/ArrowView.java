package com.baidu.tieba.qrcode.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class ArrowView extends View {
    private static int ixU = 20;
    private static int ixV = 13;
    private int height;
    private Path lS;
    private Paint paint;
    private int width;

    public ArrowView(Context context) {
        super(context);
        init(context);
    }

    public ArrowView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        ixU = l.g(context, R.dimen.tbds20);
        ixV = l.g(context, R.dimen.tbds13);
        this.paint = new Paint();
        this.paint.setColor(context.getResources().getColor(R.color.cp_bg_line_d));
        this.paint.setAntiAlias(true);
        this.lS = new Path();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(ixU, ixV);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(ixU, size2);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(size, ixV);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.lS.reset();
        this.lS.moveTo(this.width / 2, 0.0f);
        this.lS.lineTo(0.0f, this.height);
        this.lS.lineTo(this.width, this.height);
        this.lS.close();
        canvas.drawPath(this.lS, this.paint);
    }
}
