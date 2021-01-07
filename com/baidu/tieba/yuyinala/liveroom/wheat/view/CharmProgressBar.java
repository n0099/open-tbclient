package com.baidu.tieba.yuyinala.liveroom.wheat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class CharmProgressBar extends ProgressBar {
    private static int oFm = 400;
    private static float oFn = 1.5f;
    private static float oFo = 0.06f;
    private Paint mPaint;
    private Path mPath;
    private long mStartTime;
    private float oFk;
    private SparseArray<Integer> oFl;

    public CharmProgressBar(Context context) {
        this(context, null);
    }

    public CharmProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CharmProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.oFk = 0.0f;
        this.oFl = new SparseArray<>();
        this.mStartTime = 0L;
        init();
        egt();
    }

    private void egt() {
        this.oFl.put(0, 30);
        this.oFl.put(5, 39);
        this.oFl.put(10, 51);
        this.oFl.put(15, 64);
        this.oFl.put(20, 72);
        this.oFl.put(25, 82);
        this.oFl.put(30, 87);
        this.oFl.put(35, 90);
        this.oFl.put(40, 95);
        this.oFl.put(45, 97);
        this.oFl.put(50, 100);
        this.oFl.put(55, 100);
        this.oFl.put(60, 100);
        this.oFl.put(65, 100);
        this.oFl.put(70, 98);
        this.oFl.put(75, 98);
        this.oFl.put(80, 95);
        this.oFl.put(85, 93);
        this.oFl.put(90, 80);
        this.oFl.put(95, 73);
        this.oFl.put(100, 70);
    }

    protected void init() {
        this.mPaint = new Paint(1);
        this.mPaint.setColor(getResources().getColor(a.c.sdk_color_ff4780));
        this.mPath = new Path();
    }

    private int getStartX() {
        return (int) ((getWidth() * (1.0f - getWidthPercent())) / 2.0f);
    }

    private int getEndX() {
        return (int) (getWidth() - ((getWidth() * (1.0f - getWidthPercent())) / 2.0f));
    }

    private float getWidthPercent() {
        return this.oFl.get(getProgress() - (getProgress() % 5)).intValue() / 100.0f;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getProgress() <= 96) {
            int height = getHeight();
            int i = (int) (height * oFo);
            int width = (int) (getWidth() * oFn);
            int startX = getStartX();
            int endX = getEndX();
            int progress = (height - ((getProgress() * height) / 100)) + i;
            this.mPath.reset();
            this.mPath.moveTo(startX, progress);
            int i2 = startX;
            while (i2 >= startX && i2 <= endX && i2 <= width) {
                this.mPath.lineTo(i2, progress - ((float) ((Math.sin(((i2 * 6.283185307179586d) / width) + this.oFk) * i) + i)));
                i2++;
            }
            this.mPath.lineTo(i2 - 1, progress);
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mPaint);
            this.mPath.reset();
            this.mPath.moveTo(startX, progress);
            int i3 = startX;
            while (i3 >= startX && i3 <= endX && i3 <= width) {
                this.mPath.lineTo(i3, progress - ((float) (i - (Math.sin(((i3 * 6.283185307179586d) / width) + this.oFk) * i))));
                i3++;
            }
            this.mPath.lineTo(i3 - 1, progress);
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mPaint);
            this.oFk = (float) (getTheta() % 6.283185307179586d);
            postInvalidateDelayed(16L);
        }
    }

    private float getTheta() {
        if (this.mStartTime == 0) {
            this.mStartTime = System.currentTimeMillis();
            return 0.0f;
        }
        return (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / oFm;
    }
}
