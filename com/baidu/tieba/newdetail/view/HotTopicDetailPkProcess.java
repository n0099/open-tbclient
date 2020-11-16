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
/* loaded from: classes20.dex */
public class HotTopicDetailPkProcess extends View {
    private static int ldp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int ldq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF GD;
    private ValueAnimator hef;
    private int jCS;
    private int jFJ;
    private int ldr;
    private int lds;
    private float ldt;
    private int ldu;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.jCS = 3;
        this.ldt = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCS = 3;
        this.ldt = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCS = 3;
        this.ldt = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), ldp);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.jFJ = i;
        this.ldu = ((int) ((((this.jFJ - ldp) - (ldq + ldp)) * this.ldt) / 100.0f)) + (ldp / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.jFJ > 0) {
            ad(canvas);
        }
    }

    private void ad(Canvas canvas) {
        ae(canvas);
        af(canvas);
        ag(canvas);
    }

    private void ae(Canvas canvas) {
        this.paint.setColor(this.ldr);
        this.GD.set(0.0f, 0.0f, ldp, ldp);
        canvas.drawArc(this.GD, 90.0f, 180.0f, true, this.paint);
        this.GD.set(ldp / 2, 0.0f, this.ldu, ldp);
        canvas.drawRect(this.GD, this.paint);
    }

    private void af(Canvas canvas) {
        this.paint.setColor(this.lds);
        this.GD.set(this.jFJ - ldp, 0.0f, this.jFJ, ldp);
        canvas.drawArc(this.GD, -90.0f, 180.0f, true, this.paint);
        this.GD.set(this.ldu + ldp + ldq, 0.0f, this.jFJ - (ldp / 2), ldp);
        canvas.drawRect(this.GD, this.paint);
    }

    private void ag(Canvas canvas) {
        this.paint.setColor(this.ldr);
        this.path.reset();
        this.path.moveTo(this.ldu, ldp);
        this.path.lineTo(this.ldu + ldp, 0.0f);
        this.path.lineTo(this.ldu, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.lds);
        this.path.reset();
        this.path.moveTo(this.ldu + ldq, ldp);
        this.path.lineTo(this.ldu + ldq + ldp, ldp);
        this.path.lineTo(this.ldu + ldq + ldp, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.ldt = f3 * 100.0f;
            this.ldu = ((int) ((((this.jFJ - ldp) - (ldq + ldp)) * this.ldt) / 100.0f)) + (ldp / 2);
            invalidate();
            return;
        }
        aN(f3);
    }

    private void aN(float f) {
        if (this.hef != null) {
            this.hef.cancel();
        }
        this.hef = ValueAnimator.ofFloat(this.ldt / 100.0f, f);
        this.hef.setDuration(300L);
        this.hef.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hef.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.hef.start();
    }

    public void onChangeSkinType(int i) {
        if (this.jCS != i) {
            this.ldr = ap.getColor(R.color.CAM_X0308);
            this.lds = ap.getColor(R.color.CAM_X0303);
            if (this.jCS != 3) {
                invalidate();
            }
            this.jCS = i;
        }
    }
}
