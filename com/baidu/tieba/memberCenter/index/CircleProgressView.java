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
/* loaded from: classes9.dex */
public class CircleProgressView extends View {
    private Paint bjn;
    private int currentProgress;
    private Paint dYL;
    private int height;
    private RectF lim;
    private int lin;
    private int lio;
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
        this.lim = new RectF();
        this.dYL = new Paint();
        this.dYL.setAntiAlias(true);
        this.dYL.setStrokeWidth(this.paintWidth);
        this.dYL.setStyle(Paint.Style.STROKE);
        this.bjn = new Paint();
        this.bjn.setAntiAlias(true);
        this.bjn.setStrokeWidth(this.paintWidth);
        this.bjn.setStyle(Paint.Style.STROKE);
        this.lin = R.color.common_color_10184;
        this.lio = R.color.common_color_10162;
        bCP();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.width = getWidth();
        this.height = getHeight();
        this.maxWidth = this.width > this.height ? this.width : this.height;
        this.lim.left = this.paintWidth / 2.0f;
        this.lim.top = this.paintWidth / 2.0f;
        this.lim.right = this.maxWidth - (this.paintWidth / 2);
        this.lim.bottom = this.maxWidth - (this.paintWidth / 2);
        canvas.drawArc(this.lim, 150.0f, 360.0f, false, this.bjn);
        canvas.drawArc(this.lim, 150.0f, this.currentProgress, false, this.dYL);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void bCP() {
        this.dYL.setColor(ao.getColor(this.lin));
        this.bjn.setColor(ao.getColor(this.lio));
        invalidate();
    }
}
