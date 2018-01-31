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
    private boolean bbK;
    private Paint cIA;
    private long dmS;
    private a huA;
    private Paint huB;
    private Paint huC;
    private Paint huD;
    private Paint huE;
    private float huF;
    private float huG;
    private LinkedList<Integer> huH;
    private float huI;
    private volatile State huJ;
    private float huK;
    private float huL;
    private float huM;
    private long huN;
    private long huO;
    private long huP;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void wU(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.huH = new LinkedList<>();
        this.huI = 0.0f;
        this.huJ = State.PAUSE;
        this.bbK = true;
        this.huK = 0.0f;
        this.huL = 0.0f;
        this.huM = 0.0f;
        this.huN = 0L;
        this.lastStartTime = 0L;
        this.huO = 0L;
        this.huP = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.huH = new LinkedList<>();
        this.huI = 0.0f;
        this.huJ = State.PAUSE;
        this.bbK = true;
        this.huK = 0.0f;
        this.huL = 0.0f;
        this.huM = 0.0f;
        this.huN = 0L;
        this.lastStartTime = 0L;
        this.huO = 0L;
        this.huP = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.huH = new LinkedList<>();
        this.huI = 0.0f;
        this.huJ = State.PAUSE;
        this.bbK = true;
        this.huK = 0.0f;
        this.huL = 0.0f;
        this.huM = 0.0f;
        this.huN = 0L;
        this.lastStartTime = 0L;
        this.huO = 0L;
        this.huP = 0L;
        init(context);
    }

    private void init(Context context) {
        this.cIA = new Paint();
        this.huB = new Paint();
        this.huC = new Paint();
        this.huE = new Paint();
        this.huD = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.cIA.setStyle(Paint.Style.FILL);
        this.cIA.setColor(Color.parseColor("#33aaff"));
        this.huB.setStyle(Paint.Style.FILL);
        this.huB.setColor(Color.rgb(51, 170, 255));
        this.huC.setStyle(Paint.Style.FILL);
        this.huC.setColor(Color.parseColor("#FFFFFF"));
        this.huE.setStyle(Paint.Style.FILL);
        this.huE.setColor(Color.parseColor("#e53917"));
        this.huD.setStyle(Paint.Style.FILL);
        this.huD.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.huI = displayMetrics.widthPixels / 15000.0f;
        this.huM = this.huI;
    }

    public void setListener(a aVar) {
        this.huA = aVar;
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
        if (this.dmS == 0) {
            this.dmS = System.currentTimeMillis();
        }
        if (this.huP == 0) {
            this.huP = getHeight();
        }
        this.huF = (float) this.huP;
        this.huG = (float) ((this.huP * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.huK = 0.0f;
        if (!this.huH.isEmpty()) {
            Iterator<Integer> it = this.huH.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.huO = intValue;
                float f = this.huK;
                this.huK += ((float) (intValue - j)) * this.huI;
                float f2 = this.huK - this.huG;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.huP - 1), this.cIA);
                canvas.drawRect(f2, 0.0f, this.huK, (float) (this.huP - 1), this.huC);
                j = intValue;
            }
            if (this.huH.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.huI, 0.0f, this.huF + (this.huI * 3000.0f), (float) (this.huP - 1), this.huB);
            }
        } else {
            canvas.drawRect(3000.0f * this.huI, 0.0f, this.huF + (this.huI * 3000.0f), (float) (this.huP - 1), this.huB);
        }
        if (this.huJ == State.ROLLBACK) {
            canvas.drawRect(this.huK - (((float) (this.huO - this.lastStartTime)) * this.huI), 0.0f, this.huK, (float) this.huP, this.huE);
        }
        if (this.huJ == State.START) {
            this.huL += this.huM * ((float) (currentTimeMillis - this.dmS));
            float f3 = this.huK + this.huL;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.huK, 0.0f, this.huL + this.huK, (float) (this.huP - 1), this.cIA);
            } else {
                canvas.drawRect(this.huK, 0.0f, getMeasuredWidth(), (float) (this.huP - 1), this.cIA);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.huP) + (f3 - 5.0f), (float) (this.huP - 1), this.huD);
            if (this.huA != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.huA.wU(this.mProgress);
                }
            }
        } else {
            if (this.huA != null) {
                int measuredWidth2 = (int) ((this.huK / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.huA.wU(this.mProgress);
                }
            }
            if (this.huN == 0 || currentTimeMillis - this.huN >= 800) {
                this.bbK = !this.bbK;
                this.huN = System.currentTimeMillis();
            }
            if (this.bbK) {
                canvas.drawRect(this.huK - 5.0f, 0.0f, ((float) this.huP) + (this.huK - 5.0f), (float) (this.huP - 1), this.huD);
            }
        }
        this.dmS = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.huJ = state;
        if (state != State.START) {
            this.huL = this.huM;
        }
        if (state == State.DELETE && this.huH != null && !this.huH.isEmpty()) {
            this.huH.removeLast();
        }
    }

    public State getCurrentState() {
        return this.huJ;
    }

    public void wT(int i) {
        this.huH.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.huH == null || this.huH.isEmpty()) {
            return 0;
        }
        return this.huH.getLast().intValue();
    }

    public boolean bCP() {
        return this.huH.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.huH;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.huH = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.huP = i;
    }

    public void reset() {
        this.huH.clear();
        this.huJ = State.PAUSE;
        this.huH.clear();
        this.huK = 0.0f;
        this.dmS = 0L;
        this.lastStartTime = 0L;
        this.huO = 0L;
        this.mProgress = 0;
        this.huN = 0L;
    }
}
