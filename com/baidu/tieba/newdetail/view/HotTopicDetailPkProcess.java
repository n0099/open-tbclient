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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class HotTopicDetailPkProcess extends View {
    private static int jOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int jOQ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF FG;
    private ValueAnimator gdt;
    private int iqP;
    private int jOR;
    private int jOS;
    private int jOT;
    private float jOU;
    private int jOV;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.iqP = 3;
        this.jOU = 50.0f;
        this.FG = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iqP = 3;
        this.jOU = 50.0f;
        this.FG = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iqP = 3;
        this.jOU = 50.0f;
        this.FG = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), jOP);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.jOR = i;
        this.jOV = ((int) ((((this.jOR - jOP) - (jOQ + jOP)) * this.jOU) / 100.0f)) + (jOP / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.jOR > 0) {
            S(canvas);
        }
    }

    private void S(Canvas canvas) {
        T(canvas);
        U(canvas);
        V(canvas);
    }

    private void T(Canvas canvas) {
        this.paint.setColor(this.jOS);
        this.FG.set(0.0f, 0.0f, jOP, jOP);
        canvas.drawArc(this.FG, 90.0f, 180.0f, true, this.paint);
        this.FG.set(jOP / 2, 0.0f, this.jOV, jOP);
        canvas.drawRect(this.FG, this.paint);
    }

    private void U(Canvas canvas) {
        this.paint.setColor(this.jOT);
        this.FG.set(this.jOR - jOP, 0.0f, this.jOR, jOP);
        canvas.drawArc(this.FG, -90.0f, 180.0f, true, this.paint);
        this.FG.set(this.jOV + jOP + jOQ, 0.0f, this.jOR - (jOP / 2), jOP);
        canvas.drawRect(this.FG, this.paint);
    }

    private void V(Canvas canvas) {
        this.paint.setColor(this.jOS);
        this.path.reset();
        this.path.moveTo(this.jOV, jOP);
        this.path.lineTo(this.jOV + jOP, 0.0f);
        this.path.lineTo(this.jOV, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.jOT);
        this.path.reset();
        this.path.moveTo(this.jOV + jOQ, jOP);
        this.path.lineTo(this.jOV + jOQ + jOP, jOP);
        this.path.lineTo(this.jOV + jOQ + jOP, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.jOU = f3 * 100.0f;
            this.jOV = ((int) ((((this.jOR - jOP) - (jOQ + jOP)) * this.jOU) / 100.0f)) + (jOP / 2);
            invalidate();
            return;
        }
        aq(f3);
    }

    private void aq(float f) {
        if (this.gdt != null) {
            this.gdt.cancel();
        }
        this.gdt = ValueAnimator.ofFloat(this.jOU / 100.0f, f);
        this.gdt.setDuration(300L);
        this.gdt.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gdt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.gdt.start();
    }

    public void onChangeSkinType(int i) {
        if (this.iqP != i) {
            this.jOS = an.getColor(R.color.cp_other_b);
            this.jOT = an.getColor(R.color.cp_link_tip_b);
            if (this.iqP != 3) {
                invalidate();
            }
            this.iqP = i;
        }
    }
}
