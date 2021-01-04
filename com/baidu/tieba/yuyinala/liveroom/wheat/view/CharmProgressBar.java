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
    private static int oFn = 400;
    private static float oFo = 1.5f;
    private static float oFp = 0.06f;
    private Paint mPaint;
    private Path mPath;
    private long mStartTime;
    private float oFl;
    private SparseArray<Integer> oFm;

    public CharmProgressBar(Context context) {
        this(context, null);
    }

    public CharmProgressBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CharmProgressBar(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.oFl = 0.0f;
        this.oFm = new SparseArray<>();
        this.mStartTime = 0L;
        init();
        egs();
    }

    private void egs() {
        this.oFm.put(0, 30);
        this.oFm.put(5, 39);
        this.oFm.put(10, 51);
        this.oFm.put(15, 64);
        this.oFm.put(20, 72);
        this.oFm.put(25, 82);
        this.oFm.put(30, 87);
        this.oFm.put(35, 90);
        this.oFm.put(40, 95);
        this.oFm.put(45, 97);
        this.oFm.put(50, 100);
        this.oFm.put(55, 100);
        this.oFm.put(60, 100);
        this.oFm.put(65, 100);
        this.oFm.put(70, 98);
        this.oFm.put(75, 98);
        this.oFm.put(80, 95);
        this.oFm.put(85, 93);
        this.oFm.put(90, 80);
        this.oFm.put(95, 73);
        this.oFm.put(100, 70);
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
        return this.oFm.get(getProgress() - (getProgress() % 5)).intValue() / 100.0f;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getProgress() <= 96) {
            int height = getHeight();
            int i = (int) (height * oFp);
            int width = (int) (getWidth() * oFo);
            int startX = getStartX();
            int endX = getEndX();
            int progress = (height - ((getProgress() * height) / 100)) + i;
            this.mPath.reset();
            this.mPath.moveTo(startX, progress);
            int i2 = startX;
            while (i2 >= startX && i2 <= endX && i2 <= width) {
                this.mPath.lineTo(i2, progress - ((float) ((Math.sin(((i2 * 6.283185307179586d) / width) + this.oFl) * i) + i)));
                i2++;
            }
            this.mPath.lineTo(i2 - 1, progress);
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mPaint);
            this.mPath.reset();
            this.mPath.moveTo(startX, progress);
            int i3 = startX;
            while (i3 >= startX && i3 <= endX && i3 <= width) {
                this.mPath.lineTo(i3, progress - ((float) (i - (Math.sin(((i3 * 6.283185307179586d) / width) + this.oFl) * i))));
                i3++;
            }
            this.mPath.lineTo(i3 - 1, progress);
            this.mPath.close();
            canvas.drawPath(this.mPath, this.mPaint);
            this.oFl = (float) (getTheta() % 6.283185307179586d);
            postInvalidateDelayed(16L);
        }
    }

    private float getTheta() {
        if (this.mStartTime == 0) {
            this.mStartTime = System.currentTimeMillis();
            return 0.0f;
        }
        return (((float) (System.currentTimeMillis() - this.mStartTime)) * 1.0f) / oFn;
    }
}
