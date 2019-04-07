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
    private boolean bSx;
    private long eCw;
    private a jbH;
    private Paint jbI;
    private Paint jbJ;
    private Paint jbK;
    private Paint jbL;
    private Paint jbM;
    private float jbN;
    private float jbO;
    private LinkedList<Integer> jbP;
    private float jbQ;
    private volatile State jbR;
    private float jbS;
    private float jbT;
    private float jbU;
    private long jbV;
    private long jbW;
    private long jbX;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void AA(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.jbP = new LinkedList<>();
        this.jbQ = 0.0f;
        this.jbR = State.PAUSE;
        this.bSx = true;
        this.jbS = 0.0f;
        this.jbT = 0.0f;
        this.jbU = 0.0f;
        this.jbV = 0L;
        this.lastStartTime = 0L;
        this.jbW = 0L;
        this.jbX = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jbP = new LinkedList<>();
        this.jbQ = 0.0f;
        this.jbR = State.PAUSE;
        this.bSx = true;
        this.jbS = 0.0f;
        this.jbT = 0.0f;
        this.jbU = 0.0f;
        this.jbV = 0L;
        this.lastStartTime = 0L;
        this.jbW = 0L;
        this.jbX = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jbP = new LinkedList<>();
        this.jbQ = 0.0f;
        this.jbR = State.PAUSE;
        this.bSx = true;
        this.jbS = 0.0f;
        this.jbT = 0.0f;
        this.jbU = 0.0f;
        this.jbV = 0L;
        this.lastStartTime = 0L;
        this.jbW = 0L;
        this.jbX = 0L;
        init(context);
    }

    private void init(Context context) {
        this.jbI = new Paint();
        this.jbJ = new Paint();
        this.jbK = new Paint();
        this.jbM = new Paint();
        this.jbL = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.jbI.setStyle(Paint.Style.FILL);
        this.jbI.setColor(Color.parseColor("#33aaff"));
        this.jbJ.setStyle(Paint.Style.FILL);
        this.jbJ.setColor(Color.rgb(51, 170, 255));
        this.jbK.setStyle(Paint.Style.FILL);
        this.jbK.setColor(Color.parseColor("#FFFFFF"));
        this.jbM.setStyle(Paint.Style.FILL);
        this.jbM.setColor(Color.parseColor("#e53917"));
        this.jbL.setStyle(Paint.Style.FILL);
        this.jbL.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.jbQ = displayMetrics.widthPixels / 15000.0f;
        this.jbU = this.jbQ;
    }

    public void setListener(a aVar) {
        this.jbH = aVar;
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
        if (this.eCw == 0) {
            this.eCw = System.currentTimeMillis();
        }
        if (this.jbX == 0) {
            this.jbX = getHeight();
        }
        this.jbN = (float) this.jbX;
        this.jbO = (float) ((this.jbX * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.jbS = 0.0f;
        if (!this.jbP.isEmpty()) {
            Iterator<Integer> it = this.jbP.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.jbW = intValue;
                float f = this.jbS;
                this.jbS += ((float) (intValue - j)) * this.jbQ;
                float f2 = this.jbS - this.jbO;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.jbX - 1), this.jbI);
                canvas.drawRect(f2, 0.0f, this.jbS, (float) (this.jbX - 1), this.jbK);
                j = intValue;
            }
            if (this.jbP.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.jbQ, 0.0f, this.jbN + (this.jbQ * 3000.0f), (float) (this.jbX - 1), this.jbJ);
            }
        } else {
            canvas.drawRect(3000.0f * this.jbQ, 0.0f, this.jbN + (this.jbQ * 3000.0f), (float) (this.jbX - 1), this.jbJ);
        }
        if (this.jbR == State.ROLLBACK) {
            canvas.drawRect(this.jbS - (((float) (this.jbW - this.lastStartTime)) * this.jbQ), 0.0f, this.jbS, (float) this.jbX, this.jbM);
        }
        if (this.jbR == State.START) {
            this.jbT += this.jbU * ((float) (currentTimeMillis - this.eCw));
            float f3 = this.jbS + this.jbT;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.jbS, 0.0f, this.jbT + this.jbS, (float) (this.jbX - 1), this.jbI);
            } else {
                canvas.drawRect(this.jbS, 0.0f, getMeasuredWidth(), (float) (this.jbX - 1), this.jbI);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.jbX) + (f3 - 5.0f), (float) (this.jbX - 1), this.jbL);
            if (this.jbH != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.jbH.AA(this.mProgress);
                }
            }
        } else {
            if (this.jbH != null) {
                int measuredWidth2 = (int) ((this.jbS / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.jbH.AA(this.mProgress);
                }
            }
            if (this.jbV == 0 || currentTimeMillis - this.jbV >= 800) {
                this.bSx = !this.bSx;
                this.jbV = System.currentTimeMillis();
            }
            if (this.bSx) {
                canvas.drawRect(this.jbS - 5.0f, 0.0f, ((float) this.jbX) + (this.jbS - 5.0f), (float) (this.jbX - 1), this.jbL);
            }
        }
        this.eCw = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.jbR = state;
        if (state != State.START) {
            this.jbT = this.jbU;
        }
        if (state == State.DELETE && this.jbP != null && !this.jbP.isEmpty()) {
            this.jbP.removeLast();
        }
    }

    public State getCurrentState() {
        return this.jbR;
    }

    public void Az(int i) {
        this.jbP.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.jbP == null || this.jbP.isEmpty()) {
            return 0;
        }
        return this.jbP.getLast().intValue();
    }

    public boolean cln() {
        return this.jbP.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.jbP;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.jbP = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.jbX = i;
    }

    public void reset() {
        this.jbP.clear();
        this.jbR = State.PAUSE;
        this.jbP.clear();
        this.jbS = 0.0f;
        this.eCw = 0L;
        this.lastStartTime = 0L;
        this.jbW = 0L;
        this.mProgress = 0;
        this.jbV = 0L;
    }
}
