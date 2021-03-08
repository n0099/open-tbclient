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
/* loaded from: classes7.dex */
public class HotTopicDetailPkProcess extends View {
    private static int lBO = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int lBP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private ValueAnimator hBl;
    private int kiZ;
    private int kmt;
    private int lBQ;
    private int lBR;
    private float lBS;
    private int lBT;
    private Paint paint;
    private Path path;
    private RectF rectF;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.kiZ = 3;
        this.lBS = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kiZ = 3;
        this.lBS = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kiZ = 3;
        this.lBS = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), lBO);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kmt = i;
        this.lBT = ((int) ((((this.kmt - lBO) - (lBP + lBO)) * this.lBS) / 100.0f)) + (lBO / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kmt > 0) {
            aj(canvas);
        }
    }

    private void aj(Canvas canvas) {
        ak(canvas);
        al(canvas);
        am(canvas);
    }

    private void ak(Canvas canvas) {
        this.paint.setColor(this.lBQ);
        this.rectF.set(0.0f, 0.0f, lBO, lBO);
        canvas.drawArc(this.rectF, 90.0f, 180.0f, true, this.paint);
        this.rectF.set(lBO / 2, 0.0f, this.lBT, lBO);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void al(Canvas canvas) {
        this.paint.setColor(this.lBR);
        this.rectF.set(this.kmt - lBO, 0.0f, this.kmt, lBO);
        canvas.drawArc(this.rectF, -90.0f, 180.0f, true, this.paint);
        this.rectF.set(this.lBT + lBO + lBP, 0.0f, this.kmt - (lBO / 2), lBO);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void am(Canvas canvas) {
        this.paint.setColor(this.lBQ);
        this.path.reset();
        this.path.moveTo(this.lBT, lBO);
        this.path.lineTo(this.lBT + lBO, 0.0f);
        this.path.lineTo(this.lBT, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.lBR);
        this.path.reset();
        this.path.moveTo(this.lBT + lBP, lBO);
        this.path.lineTo(this.lBT + lBP + lBO, lBO);
        this.path.lineTo(this.lBT + lBP + lBO, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.lBS = f3 * 100.0f;
            this.lBT = ((int) ((((this.kmt - lBO) - (lBP + lBO)) * this.lBS) / 100.0f)) + (lBO / 2);
            invalidate();
            return;
        }
        aX(f3);
    }

    private void aX(float f) {
        if (this.hBl != null) {
            this.hBl.cancel();
        }
        this.hBl = ValueAnimator.ofFloat(this.lBS / 100.0f, f);
        this.hBl.setDuration(300L);
        this.hBl.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hBl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.hBl.start();
    }

    public void onChangeSkinType(int i) {
        if (this.kiZ != i) {
            this.lBQ = ap.getColor(R.color.CAM_X0308);
            this.lBR = ap.getColor(R.color.CAM_X0303);
            if (this.kiZ != 3) {
                invalidate();
            }
            this.kiZ = i;
        }
    }
}
