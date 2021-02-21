package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class CircleProgressView extends View {
    private Paint bhE;
    private int currentProgress;
    private Paint dWf;
    private int height;
    private RectF llX;
    private int llY;
    private int llZ;
    private Context mContext;
    private int maxWidth;
    private int paintWidth;
    private int width;

    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentProgress = 0;
        this.paintWidth = 0;
        this.width = 0;
        this.height = 0;
        this.maxWidth = 0;
        this.mContext = context;
        initView();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentProgress = 0;
        this.paintWidth = 0;
        this.width = 0;
        this.height = 0;
        this.maxWidth = 0;
        this.mContext = context;
        initView();
    }

    public CircleProgressView(Context context) {
        super(context);
        this.currentProgress = 0;
        this.paintWidth = 0;
        this.width = 0;
        this.height = 0;
        this.maxWidth = 0;
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.paintWidth = l.getDimens(this.mContext, R.dimen.ds4);
        this.llX = new RectF();
        this.dWf = new Paint();
        this.dWf.setAntiAlias(true);
        this.dWf.setStrokeWidth(this.paintWidth);
        this.dWf.setStyle(Paint.Style.STROKE);
        this.bhE = new Paint();
        this.bhE.setAntiAlias(true);
        this.bhE.setStrokeWidth(this.paintWidth);
        this.bhE.setStyle(Paint.Style.STROKE);
        this.llY = R.color.common_color_10184;
        this.llZ = R.color.common_color_10162;
        bzn();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.width = getWidth();
        this.height = getHeight();
        this.maxWidth = this.width > this.height ? this.width : this.height;
        this.llX.left = this.paintWidth / 2.0f;
        this.llX.top = this.paintWidth / 2.0f;
        this.llX.right = this.maxWidth - (this.paintWidth / 2);
        this.llX.bottom = this.maxWidth - (this.paintWidth / 2);
        canvas.drawArc(this.llX, 150.0f, 360.0f, false, this.bhE);
        canvas.drawArc(this.llX, 150.0f, this.currentProgress, false, this.dWf);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void bzn() {
        this.dWf.setColor(ap.getColor(this.llY));
        this.bhE.setColor(ap.getColor(this.llZ));
        invalidate();
    }
}
