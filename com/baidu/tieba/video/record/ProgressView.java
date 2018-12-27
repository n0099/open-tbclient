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
    private boolean aJr;
    private long dru;
    private float hKA;
    private float hKB;
    private float hKC;
    private long hKD;
    private long hKE;
    private long hKF;
    private a hKp;
    private Paint hKq;
    private Paint hKr;
    private Paint hKs;
    private Paint hKt;
    private Paint hKu;
    private float hKv;
    private float hKw;
    private LinkedList<Integer> hKx;
    private float hKy;
    private volatile State hKz;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void wP(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hKx = new LinkedList<>();
        this.hKy = 0.0f;
        this.hKz = State.PAUSE;
        this.aJr = true;
        this.hKA = 0.0f;
        this.hKB = 0.0f;
        this.hKC = 0.0f;
        this.hKD = 0L;
        this.lastStartTime = 0L;
        this.hKE = 0L;
        this.hKF = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hKx = new LinkedList<>();
        this.hKy = 0.0f;
        this.hKz = State.PAUSE;
        this.aJr = true;
        this.hKA = 0.0f;
        this.hKB = 0.0f;
        this.hKC = 0.0f;
        this.hKD = 0L;
        this.lastStartTime = 0L;
        this.hKE = 0L;
        this.hKF = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hKx = new LinkedList<>();
        this.hKy = 0.0f;
        this.hKz = State.PAUSE;
        this.aJr = true;
        this.hKA = 0.0f;
        this.hKB = 0.0f;
        this.hKC = 0.0f;
        this.hKD = 0L;
        this.lastStartTime = 0L;
        this.hKE = 0L;
        this.hKF = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hKq = new Paint();
        this.hKr = new Paint();
        this.hKs = new Paint();
        this.hKu = new Paint();
        this.hKt = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hKq.setStyle(Paint.Style.FILL);
        this.hKq.setColor(Color.parseColor("#33aaff"));
        this.hKr.setStyle(Paint.Style.FILL);
        this.hKr.setColor(Color.rgb(51, 170, 255));
        this.hKs.setStyle(Paint.Style.FILL);
        this.hKs.setColor(Color.parseColor("#FFFFFF"));
        this.hKu.setStyle(Paint.Style.FILL);
        this.hKu.setColor(Color.parseColor("#e53917"));
        this.hKt.setStyle(Paint.Style.FILL);
        this.hKt.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hKy = displayMetrics.widthPixels / 15000.0f;
        this.hKC = this.hKy;
    }

    public void setListener(a aVar) {
        this.hKp = aVar;
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
        if (this.dru == 0) {
            this.dru = System.currentTimeMillis();
        }
        if (this.hKF == 0) {
            this.hKF = getHeight();
        }
        this.hKv = (float) this.hKF;
        this.hKw = (float) ((this.hKF * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hKA = 0.0f;
        if (!this.hKx.isEmpty()) {
            Iterator<Integer> it = this.hKx.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hKE = intValue;
                float f = this.hKA;
                this.hKA += ((float) (intValue - j)) * this.hKy;
                float f2 = this.hKA - this.hKw;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hKF - 1), this.hKq);
                canvas.drawRect(f2, 0.0f, this.hKA, (float) (this.hKF - 1), this.hKs);
                j = intValue;
            }
            if (this.hKx.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hKy, 0.0f, this.hKv + (this.hKy * 3000.0f), (float) (this.hKF - 1), this.hKr);
            }
        } else {
            canvas.drawRect(3000.0f * this.hKy, 0.0f, this.hKv + (this.hKy * 3000.0f), (float) (this.hKF - 1), this.hKr);
        }
        if (this.hKz == State.ROLLBACK) {
            canvas.drawRect(this.hKA - (((float) (this.hKE - this.lastStartTime)) * this.hKy), 0.0f, this.hKA, (float) this.hKF, this.hKu);
        }
        if (this.hKz == State.START) {
            this.hKB += this.hKC * ((float) (currentTimeMillis - this.dru));
            float f3 = this.hKA + this.hKB;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hKA, 0.0f, this.hKB + this.hKA, (float) (this.hKF - 1), this.hKq);
            } else {
                canvas.drawRect(this.hKA, 0.0f, getMeasuredWidth(), (float) (this.hKF - 1), this.hKq);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hKF) + (f3 - 5.0f), (float) (this.hKF - 1), this.hKt);
            if (this.hKp != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hKp.wP(this.mProgress);
                }
            }
        } else {
            if (this.hKp != null) {
                int measuredWidth2 = (int) ((this.hKA / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hKp.wP(this.mProgress);
                }
            }
            if (this.hKD == 0 || currentTimeMillis - this.hKD >= 800) {
                this.aJr = !this.aJr;
                this.hKD = System.currentTimeMillis();
            }
            if (this.aJr) {
                canvas.drawRect(this.hKA - 5.0f, 0.0f, ((float) this.hKF) + (this.hKA - 5.0f), (float) (this.hKF - 1), this.hKt);
            }
        }
        this.dru = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hKz = state;
        if (state != State.START) {
            this.hKB = this.hKC;
        }
        if (state == State.DELETE && this.hKx != null && !this.hKx.isEmpty()) {
            this.hKx.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hKz;
    }

    public void wO(int i) {
        this.hKx.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hKx == null || this.hKx.isEmpty()) {
            return 0;
        }
        return this.hKx.getLast().intValue();
    }

    public boolean bLf() {
        return this.hKx.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hKx;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hKx = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hKF = i;
    }

    public void reset() {
        this.hKx.clear();
        this.hKz = State.PAUSE;
        this.hKx.clear();
        this.hKA = 0.0f;
        this.dru = 0L;
        this.lastStartTime = 0L;
        this.hKE = 0L;
        this.mProgress = 0;
        this.hKD = 0L;
    }
}
