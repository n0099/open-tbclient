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
/* loaded from: classes8.dex */
public class HotTopicDetailPkProcess extends View {
    private static int lvZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int lwa = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private ValueAnimator hzK;
    private int kdK;
    private int kgz;
    private int lwb;
    private int lwc;
    private float lwd;
    private int lwe;
    private Paint paint;
    private Path path;
    private RectF rectF;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.kdK = 3;
        this.lwd = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kdK = 3;
        this.lwd = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kdK = 3;
        this.lwd = 50.0f;
        this.rectF = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), lvZ);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kgz = i;
        this.lwe = ((int) ((((this.kgz - lvZ) - (lwa + lvZ)) * this.lwd) / 100.0f)) + (lvZ / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kgz > 0) {
            aj(canvas);
        }
    }

    private void aj(Canvas canvas) {
        ak(canvas);
        al(canvas);
        am(canvas);
    }

    private void ak(Canvas canvas) {
        this.paint.setColor(this.lwb);
        this.rectF.set(0.0f, 0.0f, lvZ, lvZ);
        canvas.drawArc(this.rectF, 90.0f, 180.0f, true, this.paint);
        this.rectF.set(lvZ / 2, 0.0f, this.lwe, lvZ);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void al(Canvas canvas) {
        this.paint.setColor(this.lwc);
        this.rectF.set(this.kgz - lvZ, 0.0f, this.kgz, lvZ);
        canvas.drawArc(this.rectF, -90.0f, 180.0f, true, this.paint);
        this.rectF.set(this.lwe + lvZ + lwa, 0.0f, this.kgz - (lvZ / 2), lvZ);
        canvas.drawRect(this.rectF, this.paint);
    }

    private void am(Canvas canvas) {
        this.paint.setColor(this.lwb);
        this.path.reset();
        this.path.moveTo(this.lwe, lvZ);
        this.path.lineTo(this.lwe + lvZ, 0.0f);
        this.path.lineTo(this.lwe, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.lwc);
        this.path.reset();
        this.path.moveTo(this.lwe + lwa, lvZ);
        this.path.lineTo(this.lwe + lwa + lvZ, lvZ);
        this.path.lineTo(this.lwe + lwa + lvZ, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.lwd = f3 * 100.0f;
            this.lwe = ((int) ((((this.kgz - lvZ) - (lwa + lvZ)) * this.lwd) / 100.0f)) + (lvZ / 2);
            invalidate();
            return;
        }
        aQ(f3);
    }

    private void aQ(float f) {
        if (this.hzK != null) {
            this.hzK.cancel();
        }
        this.hzK = ValueAnimator.ofFloat(this.lwd / 100.0f, f);
        this.hzK.setDuration(300L);
        this.hzK.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hzK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.hzK.start();
    }

    public void onChangeSkinType(int i) {
        if (this.kdK != i) {
            this.lwb = ao.getColor(R.color.CAM_X0308);
            this.lwc = ao.getColor(R.color.CAM_X0303);
            if (this.kdK != 3) {
                invalidate();
            }
            this.kdK = i;
        }
    }
}
