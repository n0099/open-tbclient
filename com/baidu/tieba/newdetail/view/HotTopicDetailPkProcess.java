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
    private static int kXa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int kXb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF GD;
    private ValueAnimator gYu;
    private int jvY;
    private int kXc;
    private int kXd;
    private int kXe;
    private float kXf;
    private int kXg;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.jvY = 3;
        this.kXf = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jvY = 3;
        this.kXf = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jvY = 3;
        this.kXf = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), kXa);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kXc = i;
        this.kXg = ((int) ((((this.kXc - kXa) - (kXb + kXa)) * this.kXf) / 100.0f)) + (kXa / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kXc > 0) {
            aa(canvas);
        }
    }

    private void aa(Canvas canvas) {
        ab(canvas);
        ac(canvas);
        ad(canvas);
    }

    private void ab(Canvas canvas) {
        this.paint.setColor(this.kXd);
        this.GD.set(0.0f, 0.0f, kXa, kXa);
        canvas.drawArc(this.GD, 90.0f, 180.0f, true, this.paint);
        this.GD.set(kXa / 2, 0.0f, this.kXg, kXa);
        canvas.drawRect(this.GD, this.paint);
    }

    private void ac(Canvas canvas) {
        this.paint.setColor(this.kXe);
        this.GD.set(this.kXc - kXa, 0.0f, this.kXc, kXa);
        canvas.drawArc(this.GD, -90.0f, 180.0f, true, this.paint);
        this.GD.set(this.kXg + kXa + kXb, 0.0f, this.kXc - (kXa / 2), kXa);
        canvas.drawRect(this.GD, this.paint);
    }

    private void ad(Canvas canvas) {
        this.paint.setColor(this.kXd);
        this.path.reset();
        this.path.moveTo(this.kXg, kXa);
        this.path.lineTo(this.kXg + kXa, 0.0f);
        this.path.lineTo(this.kXg, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.kXe);
        this.path.reset();
        this.path.moveTo(this.kXg + kXb, kXa);
        this.path.lineTo(this.kXg + kXb + kXa, kXa);
        this.path.lineTo(this.kXg + kXb + kXa, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.kXf = f3 * 100.0f;
            this.kXg = ((int) ((((this.kXc - kXa) - (kXb + kXa)) * this.kXf) / 100.0f)) + (kXa / 2);
            invalidate();
            return;
        }
        aE(f3);
    }

    private void aE(float f) {
        if (this.gYu != null) {
            this.gYu.cancel();
        }
        this.gYu = ValueAnimator.ofFloat(this.kXf / 100.0f, f);
        this.gYu.setDuration(300L);
        this.gYu.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gYu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.gYu.start();
    }

    public void onChangeSkinType(int i) {
        if (this.jvY != i) {
            this.kXd = ap.getColor(R.color.cp_other_b);
            this.kXe = ap.getColor(R.color.cp_link_tip_b);
            if (this.jvY != 3) {
                invalidate();
            }
            this.jvY = i;
        }
    }
}
