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
/* loaded from: classes8.dex */
public class HotTopicDetailPkProcess extends View {
    private static int lzy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int lzz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private ValueAnimator hzo;
    private int kgI;
    private int kkd;
    private int lzA;
    private int lzB;
    private float lzC;
    private int lzD;
    private Paint paint;
    private Path path;
    private RectF rectF;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.kgI = 3;
        this.lzC = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kgI = 3;
        this.lzC = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kgI = 3;
        this.lzC = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), lzy);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kkd = i;
        this.lzD = ((int) ((((this.kkd - lzy) - (lzz + lzy)) * this.lzC) / 100.0f)) + (lzy / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kkd > 0) {
            aj(canvas);
        }
    }

    private void aj(Canvas canvas) {
        ak(canvas);
        al(canvas);
        am(canvas);
    }

    private void ak(Canvas canvas) {
        this.paint.setColor(this.lzA);
        this.rectF.set(0.0f, 0.0f, lzy, lzy);
        canvas.drawArc(this.rectF, 90.0f, 180.0f, true, this.paint);
        this.rectF.set(lzy / 2, 0.0f, this.lzD, lzy);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void al(Canvas canvas) {
        this.paint.setColor(this.lzB);
        this.rectF.set(this.kkd - lzy, 0.0f, this.kkd, lzy);
        canvas.drawArc(this.rectF, -90.0f, 180.0f, true, this.paint);
        this.rectF.set(this.lzD + lzy + lzz, 0.0f, this.kkd - (lzy / 2), lzy);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void am(Canvas canvas) {
        this.paint.setColor(this.lzA);
        this.path.reset();
        this.path.moveTo(this.lzD, lzy);
        this.path.lineTo(this.lzD + lzy, 0.0f);
        this.path.lineTo(this.lzD, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.lzB);
        this.path.reset();
        this.path.moveTo(this.lzD + lzz, lzy);
        this.path.lineTo(this.lzD + lzz + lzy, lzy);
        this.path.lineTo(this.lzD + lzz + lzy, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.lzC = f3 * 100.0f;
            this.lzD = ((int) ((((this.kkd - lzy) - (lzz + lzy)) * this.lzC) / 100.0f)) + (lzy / 2);
            invalidate();
            return;
        }
        aT(f3);
    }

    private void aT(float f) {
        if (this.hzo != null) {
            this.hzo.cancel();
        }
        this.hzo = ValueAnimator.ofFloat(this.lzC / 100.0f, f);
        this.hzo.setDuration(300L);
        this.hzo.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hzo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.hzo.start();
    }

    public void onChangeSkinType(int i) {
        if (this.kgI != i) {
            this.lzA = ap.getColor(R.color.CAM_X0308);
            this.lzB = ap.getColor(R.color.CAM_X0303);
            if (this.kgI != 3) {
                invalidate();
            }
            this.kgI = i;
        }
    }
}
