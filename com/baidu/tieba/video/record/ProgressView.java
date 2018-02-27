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
/* loaded from: classes2.dex */
public class ProgressView extends View {
    private boolean bdq;
    private Paint cMm;
    private long dpx;
    private a hvB;
    private Paint hvC;
    private Paint hvD;
    private Paint hvE;
    private Paint hvF;
    private float hvG;
    private float hvH;
    private LinkedList<Integer> hvI;
    private float hvJ;
    private volatile State hvK;
    private float hvL;
    private float hvM;
    private float hvN;
    private long hvO;
    private long hvP;
    private long hvQ;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void wU(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hvI = new LinkedList<>();
        this.hvJ = 0.0f;
        this.hvK = State.PAUSE;
        this.bdq = true;
        this.hvL = 0.0f;
        this.hvM = 0.0f;
        this.hvN = 0.0f;
        this.hvO = 0L;
        this.lastStartTime = 0L;
        this.hvP = 0L;
        this.hvQ = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hvI = new LinkedList<>();
        this.hvJ = 0.0f;
        this.hvK = State.PAUSE;
        this.bdq = true;
        this.hvL = 0.0f;
        this.hvM = 0.0f;
        this.hvN = 0.0f;
        this.hvO = 0L;
        this.lastStartTime = 0L;
        this.hvP = 0L;
        this.hvQ = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvI = new LinkedList<>();
        this.hvJ = 0.0f;
        this.hvK = State.PAUSE;
        this.bdq = true;
        this.hvL = 0.0f;
        this.hvM = 0.0f;
        this.hvN = 0.0f;
        this.hvO = 0L;
        this.lastStartTime = 0L;
        this.hvP = 0L;
        this.hvQ = 0L;
        init(context);
    }

    private void init(Context context) {
        this.cMm = new Paint();
        this.hvC = new Paint();
        this.hvD = new Paint();
        this.hvF = new Paint();
        this.hvE = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.cMm.setStyle(Paint.Style.FILL);
        this.cMm.setColor(Color.parseColor("#33aaff"));
        this.hvC.setStyle(Paint.Style.FILL);
        this.hvC.setColor(Color.rgb(51, 170, 255));
        this.hvD.setStyle(Paint.Style.FILL);
        this.hvD.setColor(Color.parseColor("#FFFFFF"));
        this.hvF.setStyle(Paint.Style.FILL);
        this.hvF.setColor(Color.parseColor("#e53917"));
        this.hvE.setStyle(Paint.Style.FILL);
        this.hvE.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hvJ = displayMetrics.widthPixels / 15000.0f;
        this.hvN = this.hvJ;
    }

    public void setListener(a aVar) {
        this.hvB = aVar;
    }

    /* loaded from: classes2.dex */
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
        if (this.dpx == 0) {
            this.dpx = System.currentTimeMillis();
        }
        if (this.hvQ == 0) {
            this.hvQ = getHeight();
        }
        this.hvG = (float) this.hvQ;
        this.hvH = (float) ((this.hvQ * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hvL = 0.0f;
        if (!this.hvI.isEmpty()) {
            Iterator<Integer> it = this.hvI.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hvP = intValue;
                float f = this.hvL;
                this.hvL += ((float) (intValue - j)) * this.hvJ;
                float f2 = this.hvL - this.hvH;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hvQ - 1), this.cMm);
                canvas.drawRect(f2, 0.0f, this.hvL, (float) (this.hvQ - 1), this.hvD);
                j = intValue;
            }
            if (this.hvI.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hvJ, 0.0f, this.hvG + (this.hvJ * 3000.0f), (float) (this.hvQ - 1), this.hvC);
            }
        } else {
            canvas.drawRect(3000.0f * this.hvJ, 0.0f, this.hvG + (this.hvJ * 3000.0f), (float) (this.hvQ - 1), this.hvC);
        }
        if (this.hvK == State.ROLLBACK) {
            canvas.drawRect(this.hvL - (((float) (this.hvP - this.lastStartTime)) * this.hvJ), 0.0f, this.hvL, (float) this.hvQ, this.hvF);
        }
        if (this.hvK == State.START) {
            this.hvM += this.hvN * ((float) (currentTimeMillis - this.dpx));
            float f3 = this.hvL + this.hvM;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hvL, 0.0f, this.hvM + this.hvL, (float) (this.hvQ - 1), this.cMm);
            } else {
                canvas.drawRect(this.hvL, 0.0f, getMeasuredWidth(), (float) (this.hvQ - 1), this.cMm);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hvQ) + (f3 - 5.0f), (float) (this.hvQ - 1), this.hvE);
            if (this.hvB != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hvB.wU(this.mProgress);
                }
            }
        } else {
            if (this.hvB != null) {
                int measuredWidth2 = (int) ((this.hvL / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hvB.wU(this.mProgress);
                }
            }
            if (this.hvO == 0 || currentTimeMillis - this.hvO >= 800) {
                this.bdq = !this.bdq;
                this.hvO = System.currentTimeMillis();
            }
            if (this.bdq) {
                canvas.drawRect(this.hvL - 5.0f, 0.0f, ((float) this.hvQ) + (this.hvL - 5.0f), (float) (this.hvQ - 1), this.hvE);
            }
        }
        this.dpx = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hvK = state;
        if (state != State.START) {
            this.hvM = this.hvN;
        }
        if (state == State.DELETE && this.hvI != null && !this.hvI.isEmpty()) {
            this.hvI.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hvK;
    }

    public void wT(int i) {
        this.hvI.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hvI == null || this.hvI.isEmpty()) {
            return 0;
        }
        return this.hvI.getLast().intValue();
    }

    public boolean bDw() {
        return this.hvI.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hvI;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hvI = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hvQ = i;
    }

    public void reset() {
        this.hvI.clear();
        this.hvK = State.PAUSE;
        this.hvI.clear();
        this.hvL = 0.0f;
        this.dpx = 0L;
        this.lastStartTime = 0L;
        this.hvP = 0L;
        this.mProgress = 0;
        this.hvO = 0L;
    }
}
