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
/* loaded from: classes15.dex */
public class HotTopicDetailPkProcess extends View {
    private static int kmS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int kmT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF Gl;
    private ValueAnimator guK;
    private int iLX;
    private int kmU;
    private int kmV;
    private int kmW;
    private float kmX;
    private int kmY;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.iLX = 3;
        this.kmX = 50.0f;
        this.Gl = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLX = 3;
        this.kmX = 50.0f;
        this.Gl = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLX = 3;
        this.kmX = 50.0f;
        this.Gl = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), kmS);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kmU = i;
        this.kmY = ((int) ((((this.kmU - kmS) - (kmT + kmS)) * this.kmX) / 100.0f)) + (kmS / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kmU > 0) {
            Z(canvas);
        }
    }

    private void Z(Canvas canvas) {
        aa(canvas);
        ab(canvas);
        ac(canvas);
    }

    private void aa(Canvas canvas) {
        this.paint.setColor(this.kmV);
        this.Gl.set(0.0f, 0.0f, kmS, kmS);
        canvas.drawArc(this.Gl, 90.0f, 180.0f, true, this.paint);
        this.Gl.set(kmS / 2, 0.0f, this.kmY, kmS);
        canvas.drawRect(this.Gl, this.paint);
    }

    private void ab(Canvas canvas) {
        this.paint.setColor(this.kmW);
        this.Gl.set(this.kmU - kmS, 0.0f, this.kmU, kmS);
        canvas.drawArc(this.Gl, -90.0f, 180.0f, true, this.paint);
        this.Gl.set(this.kmY + kmS + kmT, 0.0f, this.kmU - (kmS / 2), kmS);
        canvas.drawRect(this.Gl, this.paint);
    }

    private void ac(Canvas canvas) {
        this.paint.setColor(this.kmV);
        this.path.reset();
        this.path.moveTo(this.kmY, kmS);
        this.path.lineTo(this.kmY + kmS, 0.0f);
        this.path.lineTo(this.kmY, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.kmW);
        this.path.reset();
        this.path.moveTo(this.kmY + kmT, kmS);
        this.path.lineTo(this.kmY + kmT + kmS, kmS);
        this.path.lineTo(this.kmY + kmT + kmS, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.kmX = f3 * 100.0f;
            this.kmY = ((int) ((((this.kmU - kmS) - (kmT + kmS)) * this.kmX) / 100.0f)) + (kmS / 2);
            invalidate();
            return;
        }
        aw(f3);
    }

    private void aw(float f) {
        if (this.guK != null) {
            this.guK.cancel();
        }
        this.guK = ValueAnimator.ofFloat(this.kmX / 100.0f, f);
        this.guK.setDuration(300L);
        this.guK.setInterpolator(new AccelerateDecelerateInterpolator());
        this.guK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.guK.start();
    }

    public void onChangeSkinType(int i) {
        if (this.iLX != i) {
            this.kmV = ap.getColor(R.color.cp_other_b);
            this.kmW = ap.getColor(R.color.cp_link_tip_b);
            if (this.iLX != 3) {
                invalidate();
            }
            this.iLX = i;
        }
    }
}
