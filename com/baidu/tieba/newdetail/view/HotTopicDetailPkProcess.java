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
    private static int lcX = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int lcY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF GD;
    private ValueAnimator hey;
    private int jBV;
    private int lcZ;
    private int lda;
    private int ldb;
    private float ldc;
    private int ldd;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.jBV = 3;
        this.ldc = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jBV = 3;
        this.ldc = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jBV = 3;
        this.ldc = 50.0f;
        this.GD = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), lcX);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.lcZ = i;
        this.ldd = ((int) ((((this.lcZ - lcX) - (lcY + lcX)) * this.ldc) / 100.0f)) + (lcX / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.lcZ > 0) {
            aa(canvas);
        }
    }

    private void aa(Canvas canvas) {
        ab(canvas);
        ac(canvas);
        ad(canvas);
    }

    private void ab(Canvas canvas) {
        this.paint.setColor(this.lda);
        this.GD.set(0.0f, 0.0f, lcX, lcX);
        canvas.drawArc(this.GD, 90.0f, 180.0f, true, this.paint);
        this.GD.set(lcX / 2, 0.0f, this.ldd, lcX);
        canvas.drawRect(this.GD, this.paint);
    }

    private void ac(Canvas canvas) {
        this.paint.setColor(this.ldb);
        this.GD.set(this.lcZ - lcX, 0.0f, this.lcZ, lcX);
        canvas.drawArc(this.GD, -90.0f, 180.0f, true, this.paint);
        this.GD.set(this.ldd + lcX + lcY, 0.0f, this.lcZ - (lcX / 2), lcX);
        canvas.drawRect(this.GD, this.paint);
    }

    private void ad(Canvas canvas) {
        this.paint.setColor(this.lda);
        this.path.reset();
        this.path.moveTo(this.ldd, lcX);
        this.path.lineTo(this.ldd + lcX, 0.0f);
        this.path.lineTo(this.ldd, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.ldb);
        this.path.reset();
        this.path.moveTo(this.ldd + lcY, lcX);
        this.path.lineTo(this.ldd + lcY + lcX, lcX);
        this.path.lineTo(this.ldd + lcY + lcX, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.ldc = f3 * 100.0f;
            this.ldd = ((int) ((((this.lcZ - lcX) - (lcY + lcX)) * this.ldc) / 100.0f)) + (lcX / 2);
            invalidate();
            return;
        }
        aG(f3);
    }

    private void aG(float f) {
        if (this.hey != null) {
            this.hey.cancel();
        }
        this.hey = ValueAnimator.ofFloat(this.ldc / 100.0f, f);
        this.hey.setDuration(300L);
        this.hey.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hey.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.hey.start();
    }

    public void onChangeSkinType(int i) {
        if (this.jBV != i) {
            this.lda = ap.getColor(R.color.cp_other_b);
            this.ldb = ap.getColor(R.color.cp_link_tip_b);
            if (this.jBV != 3) {
                invalidate();
            }
            this.jBV = i;
        }
    }
}
