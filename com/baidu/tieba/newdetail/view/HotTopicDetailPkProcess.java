package com.baidu.tieba.newdetail.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class HotTopicDetailPkProcess extends View {
    private static int lqR = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int lqS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF Hx;
    private ValueAnimator hnP;
    private int jQw;
    private int jTo;
    private int lqT;
    private int lqU;
    private float lqV;
    private int lqW;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.jQw = 3;
        this.lqV = 50.0f;
        this.Hx = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQw = 3;
        this.lqV = 50.0f;
        this.Hx = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQw = 3;
        this.lqV = 50.0f;
        this.Hx = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), lqR);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.jTo = i;
        this.lqW = ((int) ((((this.jTo - lqR) - (lqS + lqR)) * this.lqV) / 100.0f)) + (lqR / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.jTo > 0) {
            ad(canvas);
        }
    }

    private void ad(Canvas canvas) {
        ae(canvas);
        af(canvas);
        ag(canvas);
    }

    private void ae(Canvas canvas) {
        this.paint.setColor(this.lqT);
        this.Hx.set(0.0f, 0.0f, lqR, lqR);
        canvas.drawArc(this.Hx, 90.0f, 180.0f, true, this.paint);
        this.Hx.set(lqR / 2, 0.0f, this.lqW, lqR);
        canvas.drawRect(this.Hx, this.paint);
    }

    private void af(Canvas canvas) {
        this.paint.setColor(this.lqU);
        this.Hx.set(this.jTo - lqR, 0.0f, this.jTo, lqR);
        canvas.drawArc(this.Hx, -90.0f, 180.0f, true, this.paint);
        this.Hx.set(this.lqW + lqR + lqS, 0.0f, this.jTo - (lqR / 2), lqR);
        canvas.drawRect(this.Hx, this.paint);
    }

    private void ag(Canvas canvas) {
        this.paint.setColor(this.lqT);
        this.path.reset();
        this.path.moveTo(this.lqW, lqR);
        this.path.lineTo(this.lqW + lqR, 0.0f);
        this.path.lineTo(this.lqW, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.lqU);
        this.path.reset();
        this.path.moveTo(this.lqW + lqS, lqR);
        this.path.lineTo(this.lqW + lqS + lqR, lqR);
        this.path.lineTo(this.lqW + lqS + lqR, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.lqV = f3 * 100.0f;
            this.lqW = ((int) ((((this.jTo - lqR) - (lqS + lqR)) * this.lqV) / 100.0f)) + (lqR / 2);
            invalidate();
            return;
        }
        aO(f3);
    }

    private void aO(float f) {
        if (this.hnP != null) {
            this.hnP.cancel();
        }
        this.hnP = ValueAnimator.ofFloat(this.lqV / 100.0f, f);
        this.hnP.setDuration(300L);
        this.hnP.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hnP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.hnP.start();
    }

    public void onChangeSkinType(int i) {
        if (this.jQw != i) {
            this.lqT = ap.getColor(R.color.CAM_X0308);
            this.lqU = ap.getColor(R.color.CAM_X0303);
            if (this.jQw != 3) {
                invalidate();
            }
            this.jQw = i;
        }
    }
}
