package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class ProgressView extends View {
    private boolean aFa;
    private long dgR;
    private a hyi;
    private Paint hyj;
    private Paint hyk;
    private Paint hyl;
    private Paint hym;
    private Paint hyn;
    private float hyo;
    private float hyp;
    private LinkedList<Integer> hyq;
    private float hyr;
    private volatile State hys;
    private float hyt;
    private float hyu;
    private float hyv;
    private long hyw;
    private long hyx;
    private long hyy;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void vM(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hyq = new LinkedList<>();
        this.hyr = 0.0f;
        this.hys = State.PAUSE;
        this.aFa = true;
        this.hyt = 0.0f;
        this.hyu = 0.0f;
        this.hyv = 0.0f;
        this.hyw = 0L;
        this.lastStartTime = 0L;
        this.hyx = 0L;
        this.hyy = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hyq = new LinkedList<>();
        this.hyr = 0.0f;
        this.hys = State.PAUSE;
        this.aFa = true;
        this.hyt = 0.0f;
        this.hyu = 0.0f;
        this.hyv = 0.0f;
        this.hyw = 0L;
        this.lastStartTime = 0L;
        this.hyx = 0L;
        this.hyy = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hyq = new LinkedList<>();
        this.hyr = 0.0f;
        this.hys = State.PAUSE;
        this.aFa = true;
        this.hyt = 0.0f;
        this.hyu = 0.0f;
        this.hyv = 0.0f;
        this.hyw = 0L;
        this.lastStartTime = 0L;
        this.hyx = 0L;
        this.hyy = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hyj = new Paint();
        this.hyk = new Paint();
        this.hyl = new Paint();
        this.hyn = new Paint();
        this.hym = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hyj.setStyle(Paint.Style.FILL);
        this.hyj.setColor(Color.parseColor("#33aaff"));
        this.hyk.setStyle(Paint.Style.FILL);
        this.hyk.setColor(Color.rgb(51, 170, 255));
        this.hyl.setStyle(Paint.Style.FILL);
        this.hyl.setColor(Color.parseColor("#FFFFFF"));
        this.hyn.setStyle(Paint.Style.FILL);
        this.hyn.setColor(Color.parseColor("#e53917"));
        this.hym.setStyle(Paint.Style.FILL);
        this.hym.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hyr = displayMetrics.widthPixels / 15000.0f;
        this.hyv = this.hyr;
    }

    public void setListener(a aVar) {
        this.hyi = aVar;
    }

    /* loaded from: classes5.dex */
    public enum State {
        START(1),
        PAUSE(2),
        ROLLBACK(3),
        DELETE(4);
        
        private int mIntValue;

        static State mapIntToValue(int i) {
            State[] values;
            for (State state : values()) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return PAUSE;
        }

        State(int i) {
            this.mIntValue = i;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dgR == 0) {
            this.dgR = System.currentTimeMillis();
        }
        if (this.hyy == 0) {
            this.hyy = getHeight();
        }
        this.hyo = (float) this.hyy;
        this.hyp = (float) ((this.hyy * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hyt = 0.0f;
        if (!this.hyq.isEmpty()) {
            Iterator<Integer> it = this.hyq.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hyx = intValue;
                float f = this.hyt;
                this.hyt += ((float) (intValue - j)) * this.hyr;
                float f2 = this.hyt - this.hyp;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hyy - 1), this.hyj);
                canvas.drawRect(f2, 0.0f, this.hyt, (float) (this.hyy - 1), this.hyl);
                j = intValue;
            }
            if (this.hyq.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hyr, 0.0f, this.hyo + (this.hyr * 3000.0f), (float) (this.hyy - 1), this.hyk);
            }
        } else {
            canvas.drawRect(3000.0f * this.hyr, 0.0f, this.hyo + (this.hyr * 3000.0f), (float) (this.hyy - 1), this.hyk);
        }
        if (this.hys == State.ROLLBACK) {
            canvas.drawRect(this.hyt - (((float) (this.hyx - this.lastStartTime)) * this.hyr), 0.0f, this.hyt, (float) this.hyy, this.hyn);
        }
        if (this.hys == State.START) {
            this.hyu += this.hyv * ((float) (currentTimeMillis - this.dgR));
            float f3 = this.hyt + this.hyu;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hyt, 0.0f, this.hyu + this.hyt, (float) (this.hyy - 1), this.hyj);
            } else {
                canvas.drawRect(this.hyt, 0.0f, getMeasuredWidth(), (float) (this.hyy - 1), this.hyj);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hyy) + (f3 - 5.0f), (float) (this.hyy - 1), this.hym);
            if (this.hyi != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hyi.vM(this.mProgress);
                }
            }
        } else {
            if (this.hyi != null) {
                int measuredWidth2 = (int) ((this.hyt / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hyi.vM(this.mProgress);
                }
            }
            if (this.hyw == 0 || currentTimeMillis - this.hyw >= 800) {
                this.aFa = !this.aFa;
                this.hyw = System.currentTimeMillis();
            }
            if (this.aFa) {
                canvas.drawRect(this.hyt - 5.0f, 0.0f, ((float) this.hyy) + (this.hyt - 5.0f), (float) (this.hyy - 1), this.hym);
            }
        }
        this.dgR = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hys = state;
        if (state != State.START) {
            this.hyu = this.hyv;
        }
        if (state == State.DELETE && this.hyq != null && !this.hyq.isEmpty()) {
            this.hyq.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hys;
    }

    public void vL(int i) {
        this.hyq.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hyq == null || this.hyq.isEmpty()) {
            return 0;
        }
        return this.hyq.getLast().intValue();
    }

    public boolean bIM() {
        return this.hyq.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hyq;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hyq = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hyy = i;
    }

    public void reset() {
        this.hyq.clear();
        this.hys = State.PAUSE;
        this.hyq.clear();
        this.hyt = 0.0f;
        this.dgR = 0L;
        this.lastStartTime = 0L;
        this.hyx = 0L;
        this.mProgress = 0;
        this.hyw = 0L;
    }
}
