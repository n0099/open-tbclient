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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class HotTopicDetailPkProcess extends View {
    private static int lrt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int lru = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private ValueAnimator hve;
    private int jZf;
    private int kbT;
    private int lrv;
    private int lrw;
    private float lrx;
    private int lry;
    private Paint paint;
    private Path path;
    private RectF rectF;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.jZf = 3;
        this.lrx = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZf = 3;
        this.lrx = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZf = 3;
        this.lrx = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), lrt);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kbT = i;
        this.lry = ((int) ((((this.kbT - lrt) - (lru + lrt)) * this.lrx) / 100.0f)) + (lrt / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kbT > 0) {
            aj(canvas);
        }
    }

    private void aj(Canvas canvas) {
        ak(canvas);
        al(canvas);
        am(canvas);
    }

    private void ak(Canvas canvas) {
        this.paint.setColor(this.lrv);
        this.rectF.set(0.0f, 0.0f, lrt, lrt);
        canvas.drawArc(this.rectF, 90.0f, 180.0f, true, this.paint);
        this.rectF.set(lrt / 2, 0.0f, this.lry, lrt);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void al(Canvas canvas) {
        this.paint.setColor(this.lrw);
        this.rectF.set(this.kbT - lrt, 0.0f, this.kbT, lrt);
        canvas.drawArc(this.rectF, -90.0f, 180.0f, true, this.paint);
        this.rectF.set(this.lry + lrt + lru, 0.0f, this.kbT - (lrt / 2), lrt);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void am(Canvas canvas) {
        this.paint.setColor(this.lrv);
        this.path.reset();
        this.path.moveTo(this.lry, lrt);
        this.path.lineTo(this.lry + lrt, 0.0f);
        this.path.lineTo(this.lry, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.lrw);
        this.path.reset();
        this.path.moveTo(this.lry + lru, lrt);
        this.path.lineTo(this.lry + lru + lrt, lrt);
        this.path.lineTo(this.lry + lru + lrt, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.lrx = f3 * 100.0f;
            this.lry = ((int) ((((this.kbT - lrt) - (lru + lrt)) * this.lrx) / 100.0f)) + (lrt / 2);
            invalidate();
            return;
        }
        aQ(f3);
    }

    private void aQ(float f) {
        if (this.hve != null) {
            this.hve.cancel();
        }
        this.hve = ValueAnimator.ofFloat(this.lrx / 100.0f, f);
        this.hve.setDuration(300L);
        this.hve.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hve.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.hve.start();
    }

    public void onChangeSkinType(int i) {
        if (this.jZf != i) {
            this.lrv = ao.getColor(R.color.CAM_X0308);
            this.lrw = ao.getColor(R.color.CAM_X0303);
            if (this.jZf != 3) {
                invalidate();
            }
            this.jZf = i;
        }
    }
}
