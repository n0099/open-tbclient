package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class HotTopicDetailPkProcess extends View {
    private static int lzM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int lzN = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private ValueAnimator hzC;
    private int kgW;
    private int kkr;
    private int lzO;
    private int lzP;
    private float lzQ;
    private int lzR;
    private Paint paint;
    private Path path;
    private RectF rectF;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.kgW = 3;
        this.lzQ = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgW = 3;
        this.lzQ = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgW = 3;
        this.lzQ = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), lzM);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kkr = i;
        this.lzR = ((int) ((((this.kkr - lzM) - (lzN + lzM)) * this.lzQ) / 100.0f)) + (lzM / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kkr > 0) {
            aj(canvas);
        }
    }

    private void aj(Canvas canvas) {
        ak(canvas);
        al(canvas);
        am(canvas);
    }

    private void ak(Canvas canvas) {
        this.paint.setColor(this.lzO);
        this.rectF.set(0.0f, 0.0f, lzM, lzM);
        canvas.drawArc(this.rectF, 90.0f, 180.0f, true, this.paint);
        this.rectF.set(lzM / 2, 0.0f, this.lzR, lzM);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void al(Canvas canvas) {
        this.paint.setColor(this.lzP);
        this.rectF.set(this.kkr - lzM, 0.0f, this.kkr, lzM);
        canvas.drawArc(this.rectF, -90.0f, 180.0f, true, this.paint);
        this.rectF.set(this.lzR + lzM + lzN, 0.0f, this.kkr - (lzM / 2), lzM);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void am(Canvas canvas) {
        this.paint.setColor(this.lzO);
        this.path.reset();
        this.path.moveTo(this.lzR, lzM);
        this.path.lineTo(this.lzR + lzM, 0.0f);
        this.path.lineTo(this.lzR, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.lzP);
        this.path.reset();
        this.path.moveTo(this.lzR + lzN, lzM);
        this.path.lineTo(this.lzR + lzN + lzM, lzM);
        this.path.lineTo(this.lzR + lzN + lzM, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.lzQ = f3 * 100.0f;
            this.lzR = ((int) ((((this.kkr - lzM) - (lzN + lzM)) * this.lzQ) / 100.0f)) + (lzM / 2);
            invalidate();
            return;
        }
        aT(f3);
    }

    private void aT(float f) {
        if (this.hzC != null) {
            this.hzC.cancel();
        }
        this.hzC = ValueAnimator.ofFloat(this.lzQ / 100.0f, f);
        this.hzC.setDuration(300L);
        this.hzC.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hzC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.hzC.start();
    }

    public void onChangeSkinType(int i) {
        if (this.kgW != i) {
            this.lzO = ap.getColor(R.color.CAM_X0308);
            this.lzP = ap.getColor(R.color.CAM_X0303);
            if (this.kgW != 3) {
                invalidate();
            }
            this.kgW = i;
        }
    }
}
