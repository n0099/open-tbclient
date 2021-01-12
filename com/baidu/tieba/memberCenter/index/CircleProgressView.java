package com.baidu.tieba.memberCenter.index;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class CircleProgressView extends View {
    private Paint bew;
    private int currentProgress;
    private Paint dTZ;
    private int height;
    private RectF ldG;
    private int ldH;
    private int ldI;
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
        this.ldG = new RectF();
        this.dTZ = new Paint();
        this.dTZ.setAntiAlias(true);
        this.dTZ.setStrokeWidth(this.paintWidth);
        this.dTZ.setStyle(Paint.Style.STROKE);
        this.bew = new Paint();
        this.bew.setAntiAlias(true);
        this.bew.setStrokeWidth(this.paintWidth);
        this.bew.setStyle(Paint.Style.STROKE);
        this.ldH = R.color.common_color_10184;
        this.ldI = R.color.common_color_10162;
        byV();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.width = getWidth();
        this.height = getHeight();
        this.maxWidth = this.width > this.height ? this.width : this.height;
        this.ldG.left = this.paintWidth / 2.0f;
        this.ldG.top = this.paintWidth / 2.0f;
        this.ldG.right = this.maxWidth - (this.paintWidth / 2);
        this.ldG.bottom = this.maxWidth - (this.paintWidth / 2);
        canvas.drawArc(this.ldG, 150.0f, 360.0f, false, this.bew);
        canvas.drawArc(this.ldG, 150.0f, this.currentProgress, false, this.dTZ);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void byV() {
        this.dTZ.setColor(ao.getColor(this.ldH));
        this.bew.setColor(ao.getColor(this.ldI));
        invalidate();
    }
}
