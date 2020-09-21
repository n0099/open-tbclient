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
/* loaded from: classes20.dex */
public class HotTopicDetailPkProcess extends View {
    private static int kvr = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds22);
    private static int kvs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    private RectF Gl;
    private ValueAnimator gyn;
    private int iUD;
    private int kvt;
    private int kvu;
    private int kvv;
    private float kvw;
    private int kvx;
    private Paint paint;
    private Path path;

    public HotTopicDetailPkProcess(Context context) {
        super(context);
        this.iUD = 3;
        this.kvw = 50.0f;
        this.Gl = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iUD = 3;
        this.kvw = 50.0f;
        this.Gl = new RectF();
        this.path = new Path();
        init();
    }

    public HotTopicDetailPkProcess(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iUD = 3;
        this.kvw = 50.0f;
        this.Gl = new RectF();
        this.path = new Path();
        init();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), i), kvr);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.kvt = i;
        this.kvx = ((int) ((((this.kvt - kvr) - (kvs + kvr)) * this.kvw) / 100.0f)) + (kvr / 2);
    }

    private void init() {
        this.paint = new Paint(1);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.kvt > 0) {
            Z(canvas);
        }
    }

    private void Z(Canvas canvas) {
        aa(canvas);
        ab(canvas);
        ac(canvas);
    }

    private void aa(Canvas canvas) {
        this.paint.setColor(this.kvu);
        this.Gl.set(0.0f, 0.0f, kvr, kvr);
        canvas.drawArc(this.Gl, 90.0f, 180.0f, true, this.paint);
        this.Gl.set(kvr / 2, 0.0f, this.kvx, kvr);
        canvas.drawRect(this.Gl, this.paint);
    }

    private void ab(Canvas canvas) {
        this.paint.setColor(this.kvv);
        this.Gl.set(this.kvt - kvr, 0.0f, this.kvt, kvr);
        canvas.drawArc(this.Gl, -90.0f, 180.0f, true, this.paint);
        this.Gl.set(this.kvx + kvr + kvs, 0.0f, this.kvt - (kvr / 2), kvr);
        canvas.drawRect(this.Gl, this.paint);
    }

    private void ac(Canvas canvas) {
        this.paint.setColor(this.kvu);
        this.path.reset();
        this.path.moveTo(this.kvx, kvr);
        this.path.lineTo(this.kvx + kvr, 0.0f);
        this.path.lineTo(this.kvx, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
        this.paint.setColor(this.kvv);
        this.path.reset();
        this.path.moveTo(this.kvx + kvs, kvr);
        this.path.lineTo(this.kvx + kvs + kvr, kvr);
        this.path.lineTo(this.kvx + kvs + kvr, 0.0f);
        this.path.close();
        canvas.drawPath(this.path, this.paint);
    }

    public void setProcess(@FloatRange(from = 0.0d, to = 1.0d) float f, boolean z) {
        float f2 = f >= 0.0f ? f : 0.0f;
        float f3 = f2 <= 1.0f ? f2 : 1.0f;
        if (!z) {
            this.kvw = f3 * 100.0f;
            this.kvx = ((int) ((((this.kvt - kvr) - (kvs + kvr)) * this.kvw) / 100.0f)) + (kvr / 2);
            invalidate();
            return;
        }
        aw(f3);
    }

    private void aw(float f) {
        if (this.gyn != null) {
            this.gyn.cancel();
        }
        this.gyn = ValueAnimator.ofFloat(this.kvw / 100.0f, f);
        this.gyn.setDuration(300L);
        this.gyn.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gyn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.newdetail.view.HotTopicDetailPkProcess.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                HotTopicDetailPkProcess.this.setProcess(((Float) valueAnimator.getAnimatedValue()).floatValue(), false);
            }
        });
        this.gyn.start();
    }

    public void onChangeSkinType(int i) {
        if (this.iUD != i) {
            this.kvu = ap.getColor(R.color.cp_other_b);
            this.kvv = ap.getColor(R.color.cp_link_tip_b);
            if (this.iUD != 3) {
                invalidate();
            }
            this.iUD = i;
        }
    }
}
