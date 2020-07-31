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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class HotTopicDetailPkProcess extends View {
    private static int jXn = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int jXo = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF FG;
    private ValueAnimator giC;
    private int iwT;
    private int jXp;
    private int jXq;
    private int jXr;
    private float jXs;
    private int jXt;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.iwT = 3;
        this.jXs = 50.0f;
        this.FG = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwT = 3;
        this.jXs = 50.0f;
        this.FG = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwT = 3;
        this.jXs = 50.0f;
        this.FG = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), jXn);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.jXp = i;
        this.jXt = ((int) ((((this.jXp - jXn) - (jXo + jXn)) * this.jXs) / 100.0f)) + (jXn / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.jXp > 0) {
            S(canvas);
        }
    }

    private void S(Canvas canvas) {
        T(canvas);
        U(canvas);
        V(canvas);
    }

    private void T(Canvas canvas) {
        this.paint.setColor(this.jXq);
        this.FG.set(0.0f, 0.0f, jXn, jXn);
        canvas.drawArc(this.FG, 90.0f, 180.0f, true, this.paint);
        this.FG.set(jXn / 2, 0.0f, this.jXt, jXn);
        canvas.drawRect(this.FG, this.paint);
    }

    private void U(Canvas canvas) {
        this.paint.setColor(this.jXr);
        this.FG.set(this.jXp - jXn, 0.0f, this.jXp, jXn);
        canvas.drawArc(this.FG, -90.0f, 180.0f, true, this.paint);
        this.FG.set(this.jXt + jXn + jXo, 0.0f, this.jXp - (jXn / 2), jXn);
        canvas.drawRect(this.FG, this.paint);
    }

    private void V(Canvas canvas) {
        this.paint.setColor(this.jXq);
        this.path.reset();
        this.path.moveTo(this.jXt, jXn);
        this.path.lineTo(this.jXt + jXn, 0.0f);
        this.path.lineTo(this.jXt, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.jXr);
        this.path.reset();
        this.path.moveTo(this.jXt + jXo, jXn);
        this.path.lineTo(this.jXt + jXo + jXn, jXn);
        this.path.lineTo(this.jXt + jXo + jXn, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.jXs = f3 * 100.0f;
            this.jXt = ((int) ((((this.jXp - jXn) - (jXo + jXn)) * this.jXs) / 100.0f)) + (jXn / 2);
            invalidate();
            return;
        }
        aq(f3);
    }

    private void aq(float f) {
        if (this.giC != null) {
            this.giC.cancel();
        }
        this.giC = ValueAnimator.ofFloat(this.jXs / 100.0f, f);
        this.giC.setDuration(300L);
        this.giC.setInterpolator(new AccelerateDecelerateInterpolator());
        this.giC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.giC.start();
    }

    public void onChangeSkinType(int i) {
        if (this.iwT != i) {
            this.jXq = ao.getColor(R.color.cp_other_b);
            this.jXr = ao.getColor(R.color.cp_link_tip_b);
            if (this.iwT != 3) {
                invalidate();
            }
            this.iwT = i;
        }
    }
}
