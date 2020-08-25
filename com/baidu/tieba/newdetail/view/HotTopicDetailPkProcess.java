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
    private static int kmL = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int kmM = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF Gl;
    private ValueAnimator guG;
    private int iLR;
    private int kmN;
    private int kmO;
    private int kmP;
    private float kmQ;
    private int kmR;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.iLR = 3;
        this.kmQ = 50.0f;
        this.Gl = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLR = 3;
        this.kmQ = 50.0f;
        this.Gl = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLR = 3;
        this.kmQ = 50.0f;
        this.Gl = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), kmL);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kmN = i;
        this.kmR = ((int) ((((this.kmN - kmL) - (kmM + kmL)) * this.kmQ) / 100.0f)) + (kmL / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kmN > 0) {
            Z(canvas);
        }
    }

    private void Z(Canvas canvas) {
        aa(canvas);
        ab(canvas);
        ac(canvas);
    }

    private void aa(Canvas canvas) {
        this.paint.setColor(this.kmO);
        this.Gl.set(0.0f, 0.0f, kmL, kmL);
        canvas.drawArc(this.Gl, 90.0f, 180.0f, true, this.paint);
        this.Gl.set(kmL / 2, 0.0f, this.kmR, kmL);
        canvas.drawRect(this.Gl, this.paint);
    }

    private void ab(Canvas canvas) {
        this.paint.setColor(this.kmP);
        this.Gl.set(this.kmN - kmL, 0.0f, this.kmN, kmL);
        canvas.drawArc(this.Gl, -90.0f, 180.0f, true, this.paint);
        this.Gl.set(this.kmR + kmL + kmM, 0.0f, this.kmN - (kmL / 2), kmL);
        canvas.drawRect(this.Gl, this.paint);
    }

    private void ac(Canvas canvas) {
        this.paint.setColor(this.kmO);
        this.path.reset();
        this.path.moveTo(this.kmR, kmL);
        this.path.lineTo(this.kmR + kmL, 0.0f);
        this.path.lineTo(this.kmR, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.kmP);
        this.path.reset();
        this.path.moveTo(this.kmR + kmM, kmL);
        this.path.lineTo(this.kmR + kmM + kmL, kmL);
        this.path.lineTo(this.kmR + kmM + kmL, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.kmQ = f3 * 100.0f;
            this.kmR = ((int) ((((this.kmN - kmL) - (kmM + kmL)) * this.kmQ) / 100.0f)) + (kmL / 2);
            invalidate();
            return;
        }
        aw(f3);
    }

    private void aw(float f) {
        if (this.guG != null) {
            this.guG.cancel();
        }
        this.guG = ValueAnimator.ofFloat(this.kmQ / 100.0f, f);
        this.guG.setDuration(300L);
        this.guG.setInterpolator(new AccelerateDecelerateInterpolator());
        this.guG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.guG.start();
    }

    public void onChangeSkinType(int i) {
        if (this.iLR != i) {
            this.kmO = ap.getColor(R.color.cp_other_b);
            this.kmP = ap.getColor(R.color.cp_link_tip_b);
            if (this.iLR != 3) {
                invalidate();
            }
            this.iLR = i;
        }
    }
}
