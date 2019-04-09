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
    private boolean bSy;
    private long eCx;
    private a jbI;
    private Paint jbJ;
    private Paint jbK;
    private Paint jbL;
    private Paint jbM;
    private Paint jbN;
    private float jbO;
    private float jbP;
    private LinkedList<Integer> jbQ;
    private float jbR;
    private volatile State jbS;
    private float jbT;
    private float jbU;
    private float jbV;
    private long jbW;
    private long jbX;
    private long jbY;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void AA(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.jbQ = new LinkedList<>();
        this.jbR = 0.0f;
        this.jbS = State.PAUSE;
        this.bSy = true;
        this.jbT = 0.0f;
        this.jbU = 0.0f;
        this.jbV = 0.0f;
        this.jbW = 0L;
        this.lastStartTime = 0L;
        this.jbX = 0L;
        this.jbY = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jbQ = new LinkedList<>();
        this.jbR = 0.0f;
        this.jbS = State.PAUSE;
        this.bSy = true;
        this.jbT = 0.0f;
        this.jbU = 0.0f;
        this.jbV = 0.0f;
        this.jbW = 0L;
        this.lastStartTime = 0L;
        this.jbX = 0L;
        this.jbY = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jbQ = new LinkedList<>();
        this.jbR = 0.0f;
        this.jbS = State.PAUSE;
        this.bSy = true;
        this.jbT = 0.0f;
        this.jbU = 0.0f;
        this.jbV = 0.0f;
        this.jbW = 0L;
        this.lastStartTime = 0L;
        this.jbX = 0L;
        this.jbY = 0L;
        init(context);
    }

    private void init(Context context) {
        this.jbJ = new Paint();
        this.jbK = new Paint();
        this.jbL = new Paint();
        this.jbN = new Paint();
        this.jbM = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.jbJ.setStyle(Paint.Style.FILL);
        this.jbJ.setColor(Color.parseColor("#33aaff"));
        this.jbK.setStyle(Paint.Style.FILL);
        this.jbK.setColor(Color.rgb(51, 170, 255));
        this.jbL.setStyle(Paint.Style.FILL);
        this.jbL.setColor(Color.parseColor("#FFFFFF"));
        this.jbN.setStyle(Paint.Style.FILL);
        this.jbN.setColor(Color.parseColor("#e53917"));
        this.jbM.setStyle(Paint.Style.FILL);
        this.jbM.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.jbR = displayMetrics.widthPixels / 15000.0f;
        this.jbV = this.jbR;
    }

    public void setListener(a aVar) {
        this.jbI = aVar;
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
        if (this.eCx == 0) {
            this.eCx = System.currentTimeMillis();
        }
        if (this.jbY == 0) {
            this.jbY = getHeight();
        }
        this.jbO = (float) this.jbY;
        this.jbP = (float) ((this.jbY * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.jbT = 0.0f;
        if (!this.jbQ.isEmpty()) {
            Iterator<Integer> it = this.jbQ.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.jbX = intValue;
                float f = this.jbT;
                this.jbT += ((float) (intValue - j)) * this.jbR;
                float f2 = this.jbT - this.jbP;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.jbY - 1), this.jbJ);
                canvas.drawRect(f2, 0.0f, this.jbT, (float) (this.jbY - 1), this.jbL);
                j = intValue;
            }
            if (this.jbQ.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.jbR, 0.0f, this.jbO + (this.jbR * 3000.0f), (float) (this.jbY - 1), this.jbK);
            }
        } else {
            canvas.drawRect(3000.0f * this.jbR, 0.0f, this.jbO + (this.jbR * 3000.0f), (float) (this.jbY - 1), this.jbK);
        }
        if (this.jbS == State.ROLLBACK) {
            canvas.drawRect(this.jbT - (((float) (this.jbX - this.lastStartTime)) * this.jbR), 0.0f, this.jbT, (float) this.jbY, this.jbN);
        }
        if (this.jbS == State.START) {
            this.jbU += this.jbV * ((float) (currentTimeMillis - this.eCx));
            float f3 = this.jbT + this.jbU;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.jbT, 0.0f, this.jbU + this.jbT, (float) (this.jbY - 1), this.jbJ);
            } else {
                canvas.drawRect(this.jbT, 0.0f, getMeasuredWidth(), (float) (this.jbY - 1), this.jbJ);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.jbY) + (f3 - 5.0f), (float) (this.jbY - 1), this.jbM);
            if (this.jbI != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.jbI.AA(this.mProgress);
                }
            }
        } else {
            if (this.jbI != null) {
                int measuredWidth2 = (int) ((this.jbT / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.jbI.AA(this.mProgress);
                }
            }
            if (this.jbW == 0 || currentTimeMillis - this.jbW >= 800) {
                this.bSy = !this.bSy;
                this.jbW = System.currentTimeMillis();
            }
            if (this.bSy) {
                canvas.drawRect(this.jbT - 5.0f, 0.0f, ((float) this.jbY) + (this.jbT - 5.0f), (float) (this.jbY - 1), this.jbM);
            }
        }
        this.eCx = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.jbS = state;
        if (state != State.START) {
            this.jbU = this.jbV;
        }
        if (state == State.DELETE && this.jbQ != null && !this.jbQ.isEmpty()) {
            this.jbQ.removeLast();
        }
    }

    public State getCurrentState() {
        return this.jbS;
    }

    public void Az(int i) {
        this.jbQ.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.jbQ == null || this.jbQ.isEmpty()) {
            return 0;
        }
        return this.jbQ.getLast().intValue();
    }

    public boolean cln() {
        return this.jbQ.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.jbQ;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.jbQ = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.jbY = i;
    }

    public void reset() {
        this.jbQ.clear();
        this.jbS = State.PAUSE;
        this.jbQ.clear();
        this.jbT = 0.0f;
        this.eCx = 0L;
        this.lastStartTime = 0L;
        this.jbX = 0L;
        this.mProgress = 0;
        this.jbW = 0L;
    }
}
