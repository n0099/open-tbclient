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
    private static int jXp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int jXq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF FG;
    private ValueAnimator giC;
    private int iwV;
    private int jXr;
    private int jXs;
    private int jXt;
    private float jXu;
    private int jXv;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.iwV = 3;
        this.jXu = 50.0f;
        this.FG = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iwV = 3;
        this.jXu = 50.0f;
        this.FG = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iwV = 3;
        this.jXu = 50.0f;
        this.FG = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), jXp);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.jXr = i;
        this.jXv = ((int) ((((this.jXr - jXp) - (jXq + jXp)) * this.jXu) / 100.0f)) + (jXp / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.jXr > 0) {
            S(canvas);
        }
    }

    private void S(Canvas canvas) {
        T(canvas);
        U(canvas);
        V(canvas);
    }

    private void T(Canvas canvas) {
        this.paint.setColor(this.jXs);
        this.FG.set(0.0f, 0.0f, jXp, jXp);
        canvas.drawArc(this.FG, 90.0f, 180.0f, true, this.paint);
        this.FG.set(jXp / 2, 0.0f, this.jXv, jXp);
        canvas.drawRect(this.FG, this.paint);
    }

    private void U(Canvas canvas) {
        this.paint.setColor(this.jXt);
        this.FG.set(this.jXr - jXp, 0.0f, this.jXr, jXp);
        canvas.drawArc(this.FG, -90.0f, 180.0f, true, this.paint);
        this.FG.set(this.jXv + jXp + jXq, 0.0f, this.jXr - (jXp / 2), jXp);
        canvas.drawRect(this.FG, this.paint);
    }

    private void V(Canvas canvas) {
        this.paint.setColor(this.jXs);
        this.path.reset();
        this.path.moveTo(this.jXv, jXp);
        this.path.lineTo(this.jXv + jXp, 0.0f);
        this.path.lineTo(this.jXv, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.jXt);
        this.path.reset();
        this.path.moveTo(this.jXv + jXq, jXp);
        this.path.lineTo(this.jXv + jXq + jXp, jXp);
        this.path.lineTo(this.jXv + jXq + jXp, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.jXu = f3 * 100.0f;
            this.jXv = ((int) ((((this.jXr - jXp) - (jXq + jXp)) * this.jXu) / 100.0f)) + (jXp / 2);
            invalidate();
            return;
        }
        aq(f3);
    }

    private void aq(float f) {
        if (this.giC != null) {
            this.giC.cancel();
        }
        this.giC = ValueAnimator.ofFloat(this.jXu / 100.0f, f);
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
        if (this.iwV != i) {
            this.jXs = ao.getColor(R.color.cp_other_b);
            this.jXt = ao.getColor(R.color.cp_link_tip_b);
            if (this.iwV != 3) {
                invalidate();
            }
            this.iwV = i;
        }
    }
}
