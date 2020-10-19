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
    private static int kKD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int kKE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF GD;
    private ValueAnimator gMG;
    private int jjB;
    private int kKF;
    private int kKG;
    private int kKH;
    private float kKI;
    private int kKJ;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.jjB = 3;
        this.kKI = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jjB = 3;
        this.kKI = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jjB = 3;
        this.kKI = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), kKD);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kKF = i;
        this.kKJ = ((int) ((((this.kKF - kKD) - (kKE + kKD)) * this.kKI) / 100.0f)) + (kKD / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kKF > 0) {
            aa(canvas);
        }
    }

    private void aa(Canvas canvas) {
        ab(canvas);
        ac(canvas);
        ad(canvas);
    }

    private void ab(Canvas canvas) {
        this.paint.setColor(this.kKG);
        this.GD.set(0.0f, 0.0f, kKD, kKD);
        canvas.drawArc(this.GD, 90.0f, 180.0f, true, this.paint);
        this.GD.set(kKD / 2, 0.0f, this.kKJ, kKD);
        canvas.drawRect(this.GD, this.paint);
    }

    private void ac(Canvas canvas) {
        this.paint.setColor(this.kKH);
        this.GD.set(this.kKF - kKD, 0.0f, this.kKF, kKD);
        canvas.drawArc(this.GD, -90.0f, 180.0f, true, this.paint);
        this.GD.set(this.kKJ + kKD + kKE, 0.0f, this.kKF - (kKD / 2), kKD);
        canvas.drawRect(this.GD, this.paint);
    }

    private void ad(Canvas canvas) {
        this.paint.setColor(this.kKG);
        this.path.reset();
        this.path.moveTo(this.kKJ, kKD);
        this.path.lineTo(this.kKJ + kKD, 0.0f);
        this.path.lineTo(this.kKJ, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.kKH);
        this.path.reset();
        this.path.moveTo(this.kKJ + kKE, kKD);
        this.path.lineTo(this.kKJ + kKE + kKD, kKD);
        this.path.lineTo(this.kKJ + kKE + kKD, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.kKI = f3 * 100.0f;
            this.kKJ = ((int) ((((this.kKF - kKD) - (kKE + kKD)) * this.kKI) / 100.0f)) + (kKD / 2);
            invalidate();
            return;
        }
        aC(f3);
    }

    private void aC(float f) {
        if (this.gMG != null) {
            this.gMG.cancel();
        }
        this.gMG = ValueAnimator.ofFloat(this.kKI / 100.0f, f);
        this.gMG.setDuration(300L);
        this.gMG.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gMG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.gMG.start();
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != i) {
            this.kKG = ap.getColor(R.color.cp_other_b);
            this.kKH = ap.getColor(R.color.cp_link_tip_b);
            if (this.jjB != 3) {
                invalidate();
            }
            this.jjB = i;
        }
    }
}
