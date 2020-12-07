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
    private static int lqP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int lqQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF Hx;
    private ValueAnimator hnN;
    private int jQu;
    private int jTm;
    private int lqR;
    private int lqS;
    private float lqT;
    private int lqU;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.jQu = 3;
        this.lqT = 50.0f;
        this.Hx = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jQu = 3;
        this.lqT = 50.0f;
        this.Hx = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jQu = 3;
        this.lqT = 50.0f;
        this.Hx = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), lqP);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.jTm = i;
        this.lqU = ((int) ((((this.jTm - lqP) - (lqQ + lqP)) * this.lqT) / 100.0f)) + (lqP / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.jTm > 0) {
            ad(canvas);
        }
    }

    private void ad(Canvas canvas) {
        ae(canvas);
        af(canvas);
        ag(canvas);
    }

    private void ae(Canvas canvas) {
        this.paint.setColor(this.lqR);
        this.Hx.set(0.0f, 0.0f, lqP, lqP);
        canvas.drawArc(this.Hx, 90.0f, 180.0f, true, this.paint);
        this.Hx.set(lqP / 2, 0.0f, this.lqU, lqP);
        canvas.drawRect(this.Hx, this.paint);
    }

    private void af(Canvas canvas) {
        this.paint.setColor(this.lqS);
        this.Hx.set(this.jTm - lqP, 0.0f, this.jTm, lqP);
        canvas.drawArc(this.Hx, -90.0f, 180.0f, true, this.paint);
        this.Hx.set(this.lqU + lqP + lqQ, 0.0f, this.jTm - (lqP / 2), lqP);
        canvas.drawRect(this.Hx, this.paint);
    }

    private void ag(Canvas canvas) {
        this.paint.setColor(this.lqR);
        this.path.reset();
        this.path.moveTo(this.lqU, lqP);
        this.path.lineTo(this.lqU + lqP, 0.0f);
        this.path.lineTo(this.lqU, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.lqS);
        this.path.reset();
        this.path.moveTo(this.lqU + lqQ, lqP);
        this.path.lineTo(this.lqU + lqQ + lqP, lqP);
        this.path.lineTo(this.lqU + lqQ + lqP, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.lqT = f3 * 100.0f;
            this.lqU = ((int) ((((this.jTm - lqP) - (lqQ + lqP)) * this.lqT) / 100.0f)) + (lqP / 2);
            invalidate();
            return;
        }
        aO(f3);
    }

    private void aO(float f) {
        if (this.hnN != null) {
            this.hnN.cancel();
        }
        this.hnN = ValueAnimator.ofFloat(this.lqT / 100.0f, f);
        this.hnN.setDuration(300L);
        this.hnN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hnN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.hnN.start();
    }

    public void onChangeSkinType(int i) {
        if (this.jQu != i) {
            this.lqR = ap.getColor(R.color.CAM_X0308);
            this.lqS = ap.getColor(R.color.CAM_X0303);
            if (this.jQu != 3) {
                invalidate();
            }
            this.jQu = i;
        }
    }
}
