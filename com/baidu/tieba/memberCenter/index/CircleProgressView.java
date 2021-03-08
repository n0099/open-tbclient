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
/* loaded from: classes8.dex */
public class CircleProgressView extends View {
    private Paint bjg;
    private int currentProgress;
    private Paint dXG;
    private int height;
    private RectF loa;
    private int lob;
    private int lod;
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
        this.loa = new RectF();
        this.dXG = new Paint();
        this.dXG.setAntiAlias(true);
        this.dXG.setStrokeWidth(this.paintWidth);
        this.dXG.setStyle(Paint.Style.STROKE);
        this.bjg = new Paint();
        this.bjg.setAntiAlias(true);
        this.bjg.setStrokeWidth(this.paintWidth);
        this.bjg.setStyle(Paint.Style.STROKE);
        this.lob = R.color.common_color_10184;
        this.lod = R.color.common_color_10162;
        bzq();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.width = getWidth();
        this.height = getHeight();
        this.maxWidth = this.width > this.height ? this.width : this.height;
        this.loa.left = this.paintWidth / 2.0f;
        this.loa.top = this.paintWidth / 2.0f;
        this.loa.right = this.maxWidth - (this.paintWidth / 2);
        this.loa.bottom = this.maxWidth - (this.paintWidth / 2);
        canvas.drawArc(this.loa, 150.0f, 360.0f, false, this.bjg);
        canvas.drawArc(this.loa, 150.0f, this.currentProgress, false, this.dXG);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void bzq() {
        this.dXG.setColor(ap.getColor(this.lob));
        this.bjg.setColor(ap.getColor(this.lod));
        invalidate();
    }
}
