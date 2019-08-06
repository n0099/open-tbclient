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
    private boolean cbA;
    private long eXw;
    private a jBW;
    private Paint jBX;
    private Paint jBY;
    private Paint jBZ;
    private Paint jCa;
    private Paint jCb;
    private float jCc;
    private float jCd;
    private LinkedList<Integer> jCe;
    private float jCf;
    private volatile State jCg;
    private float jCh;
    private float jCi;
    private float jCj;
    private long jCk;
    private long jCl;
    private long jCm;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void Cr(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.jCe = new LinkedList<>();
        this.jCf = 0.0f;
        this.jCg = State.PAUSE;
        this.cbA = true;
        this.jCh = 0.0f;
        this.jCi = 0.0f;
        this.jCj = 0.0f;
        this.jCk = 0L;
        this.lastStartTime = 0L;
        this.jCl = 0L;
        this.jCm = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jCe = new LinkedList<>();
        this.jCf = 0.0f;
        this.jCg = State.PAUSE;
        this.cbA = true;
        this.jCh = 0.0f;
        this.jCi = 0.0f;
        this.jCj = 0.0f;
        this.jCk = 0L;
        this.lastStartTime = 0L;
        this.jCl = 0L;
        this.jCm = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCe = new LinkedList<>();
        this.jCf = 0.0f;
        this.jCg = State.PAUSE;
        this.cbA = true;
        this.jCh = 0.0f;
        this.jCi = 0.0f;
        this.jCj = 0.0f;
        this.jCk = 0L;
        this.lastStartTime = 0L;
        this.jCl = 0L;
        this.jCm = 0L;
        init(context);
    }

    private void init(Context context) {
        this.jBX = new Paint();
        this.jBY = new Paint();
        this.jBZ = new Paint();
        this.jCb = new Paint();
        this.jCa = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.jBX.setStyle(Paint.Style.FILL);
        this.jBX.setColor(Color.parseColor("#33aaff"));
        this.jBY.setStyle(Paint.Style.FILL);
        this.jBY.setColor(Color.rgb(51, 170, 255));
        this.jBZ.setStyle(Paint.Style.FILL);
        this.jBZ.setColor(Color.parseColor("#FFFFFF"));
        this.jCb.setStyle(Paint.Style.FILL);
        this.jCb.setColor(Color.parseColor("#e53917"));
        this.jCa.setStyle(Paint.Style.FILL);
        this.jCa.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.jCf = displayMetrics.widthPixels / 15000.0f;
        this.jCj = this.jCf;
    }

    public void setListener(a aVar) {
        this.jBW = aVar;
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
        if (this.eXw == 0) {
            this.eXw = System.currentTimeMillis();
        }
        if (this.jCm == 0) {
            this.jCm = getHeight();
        }
        this.jCc = (float) this.jCm;
        this.jCd = (float) ((this.jCm * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.jCh = 0.0f;
        if (!this.jCe.isEmpty()) {
            Iterator<Integer> it = this.jCe.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.jCl = intValue;
                float f = this.jCh;
                this.jCh += ((float) (intValue - j)) * this.jCf;
                float f2 = this.jCh - this.jCd;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.jCm - 1), this.jBX);
                canvas.drawRect(f2, 0.0f, this.jCh, (float) (this.jCm - 1), this.jBZ);
                j = intValue;
            }
            if (this.jCe.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.jCf, 0.0f, this.jCc + (this.jCf * 3000.0f), (float) (this.jCm - 1), this.jBY);
            }
        } else {
            canvas.drawRect(3000.0f * this.jCf, 0.0f, this.jCc + (this.jCf * 3000.0f), (float) (this.jCm - 1), this.jBY);
        }
        if (this.jCg == State.ROLLBACK) {
            canvas.drawRect(this.jCh - (((float) (this.jCl - this.lastStartTime)) * this.jCf), 0.0f, this.jCh, (float) this.jCm, this.jCb);
        }
        if (this.jCg == State.START) {
            this.jCi += this.jCj * ((float) (currentTimeMillis - this.eXw));
            float f3 = this.jCh + this.jCi;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.jCh, 0.0f, this.jCi + this.jCh, (float) (this.jCm - 1), this.jBX);
            } else {
                canvas.drawRect(this.jCh, 0.0f, getMeasuredWidth(), (float) (this.jCm - 1), this.jBX);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.jCm) + (f3 - 5.0f), (float) (this.jCm - 1), this.jCa);
            if (this.jBW != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.jBW.Cr(this.mProgress);
                }
            }
        } else {
            if (this.jBW != null) {
                int measuredWidth2 = (int) ((this.jCh / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.jBW.Cr(this.mProgress);
                }
            }
            if (this.jCk == 0 || currentTimeMillis - this.jCk >= 800) {
                this.cbA = !this.cbA;
                this.jCk = System.currentTimeMillis();
            }
            if (this.cbA) {
                canvas.drawRect(this.jCh - 5.0f, 0.0f, ((float) this.jCm) + (this.jCh - 5.0f), (float) (this.jCm - 1), this.jCa);
            }
        }
        this.eXw = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.jCg = state;
        if (state != State.START) {
            this.jCi = this.jCj;
        }
        if (state == State.DELETE && this.jCe != null && !this.jCe.isEmpty()) {
            this.jCe.removeLast();
        }
    }

    public State getCurrentState() {
        return this.jCg;
    }

    public void Cq(int i) {
        this.jCe.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.jCe == null || this.jCe.isEmpty()) {
            return 0;
        }
        return this.jCe.getLast().intValue();
    }

    public boolean cwC() {
        return this.jCe.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.jCe;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.jCe = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.jCm = i;
    }

    public void reset() {
        this.jCe.clear();
        this.jCg = State.PAUSE;
        this.jCe.clear();
        this.jCh = 0.0f;
        this.eXw = 0L;
        this.lastStartTime = 0L;
        this.jCl = 0L;
        this.mProgress = 0;
        this.jCk = 0L;
    }
}
