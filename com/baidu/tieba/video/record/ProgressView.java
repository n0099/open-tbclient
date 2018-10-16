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
    private a hyh;
    private Paint hyi;
    private Paint hyj;
    private Paint hyk;
    private Paint hyl;
    private Paint hym;
    private float hyn;
    private float hyo;
    private LinkedList<Integer> hyp;
    private float hyq;
    private volatile State hyr;
    private float hys;
    private float hyt;
    private float hyu;
    private long hyv;
    private long hyw;
    private long hyx;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void vM(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hyp = new LinkedList<>();
        this.hyq = 0.0f;
        this.hyr = State.PAUSE;
        this.aFa = true;
        this.hys = 0.0f;
        this.hyt = 0.0f;
        this.hyu = 0.0f;
        this.hyv = 0L;
        this.lastStartTime = 0L;
        this.hyw = 0L;
        this.hyx = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hyp = new LinkedList<>();
        this.hyq = 0.0f;
        this.hyr = State.PAUSE;
        this.aFa = true;
        this.hys = 0.0f;
        this.hyt = 0.0f;
        this.hyu = 0.0f;
        this.hyv = 0L;
        this.lastStartTime = 0L;
        this.hyw = 0L;
        this.hyx = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hyp = new LinkedList<>();
        this.hyq = 0.0f;
        this.hyr = State.PAUSE;
        this.aFa = true;
        this.hys = 0.0f;
        this.hyt = 0.0f;
        this.hyu = 0.0f;
        this.hyv = 0L;
        this.lastStartTime = 0L;
        this.hyw = 0L;
        this.hyx = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hyi = new Paint();
        this.hyj = new Paint();
        this.hyk = new Paint();
        this.hym = new Paint();
        this.hyl = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hyi.setStyle(Paint.Style.FILL);
        this.hyi.setColor(Color.parseColor("#33aaff"));
        this.hyj.setStyle(Paint.Style.FILL);
        this.hyj.setColor(Color.rgb(51, 170, 255));
        this.hyk.setStyle(Paint.Style.FILL);
        this.hyk.setColor(Color.parseColor("#FFFFFF"));
        this.hym.setStyle(Paint.Style.FILL);
        this.hym.setColor(Color.parseColor("#e53917"));
        this.hyl.setStyle(Paint.Style.FILL);
        this.hyl.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hyq = displayMetrics.widthPixels / 15000.0f;
        this.hyu = this.hyq;
    }

    public void setListener(a aVar) {
        this.hyh = aVar;
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
        if (this.hyx == 0) {
            this.hyx = getHeight();
        }
        this.hyn = (float) this.hyx;
        this.hyo = (float) ((this.hyx * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hys = 0.0f;
        if (!this.hyp.isEmpty()) {
            Iterator<Integer> it = this.hyp.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hyw = intValue;
                float f = this.hys;
                this.hys += ((float) (intValue - j)) * this.hyq;
                float f2 = this.hys - this.hyo;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hyx - 1), this.hyi);
                canvas.drawRect(f2, 0.0f, this.hys, (float) (this.hyx - 1), this.hyk);
                j = intValue;
            }
            if (this.hyp.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hyq, 0.0f, this.hyn + (this.hyq * 3000.0f), (float) (this.hyx - 1), this.hyj);
            }
        } else {
            canvas.drawRect(3000.0f * this.hyq, 0.0f, this.hyn + (this.hyq * 3000.0f), (float) (this.hyx - 1), this.hyj);
        }
        if (this.hyr == State.ROLLBACK) {
            canvas.drawRect(this.hys - (((float) (this.hyw - this.lastStartTime)) * this.hyq), 0.0f, this.hys, (float) this.hyx, this.hym);
        }
        if (this.hyr == State.START) {
            this.hyt += this.hyu * ((float) (currentTimeMillis - this.dgR));
            float f3 = this.hys + this.hyt;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hys, 0.0f, this.hyt + this.hys, (float) (this.hyx - 1), this.hyi);
            } else {
                canvas.drawRect(this.hys, 0.0f, getMeasuredWidth(), (float) (this.hyx - 1), this.hyi);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hyx) + (f3 - 5.0f), (float) (this.hyx - 1), this.hyl);
            if (this.hyh != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hyh.vM(this.mProgress);
                }
            }
        } else {
            if (this.hyh != null) {
                int measuredWidth2 = (int) ((this.hys / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hyh.vM(this.mProgress);
                }
            }
            if (this.hyv == 0 || currentTimeMillis - this.hyv >= 800) {
                this.aFa = !this.aFa;
                this.hyv = System.currentTimeMillis();
            }
            if (this.aFa) {
                canvas.drawRect(this.hys - 5.0f, 0.0f, ((float) this.hyx) + (this.hys - 5.0f), (float) (this.hyx - 1), this.hyl);
            }
        }
        this.dgR = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hyr = state;
        if (state != State.START) {
            this.hyt = this.hyu;
        }
        if (state == State.DELETE && this.hyp != null && !this.hyp.isEmpty()) {
            this.hyp.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hyr;
    }

    public void vL(int i) {
        this.hyp.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hyp == null || this.hyp.isEmpty()) {
            return 0;
        }
        return this.hyp.getLast().intValue();
    }

    public boolean bIM() {
        return this.hyp.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hyp;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hyp = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hyx = i;
    }

    public void reset() {
        this.hyp.clear();
        this.hyr = State.PAUSE;
        this.hyp.clear();
        this.hys = 0.0f;
        this.dgR = 0L;
        this.lastStartTime = 0L;
        this.hyw = 0L;
        this.mProgress = 0;
        this.hyv = 0L;
    }
}
