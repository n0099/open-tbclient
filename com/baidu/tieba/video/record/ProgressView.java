package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ProgressView extends View {
    private boolean anB;
    private long ctu;
    private float gXA;
    private float gXB;
    private LinkedList<Integer> gXC;
    private float gXD;
    private volatile State gXE;
    private float gXF;
    private float gXG;
    private float gXH;
    private long gXI;
    private long gXJ;
    private long gXK;
    private a gXu;
    private Paint gXv;
    private Paint gXw;
    private Paint gXx;
    private Paint gXy;
    private Paint gXz;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void vC(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gXC = new LinkedList<>();
        this.gXD = 0.0f;
        this.gXE = State.PAUSE;
        this.anB = true;
        this.gXF = 0.0f;
        this.gXG = 0.0f;
        this.gXH = 0.0f;
        this.gXI = 0L;
        this.lastStartTime = 0L;
        this.gXJ = 0L;
        this.gXK = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXC = new LinkedList<>();
        this.gXD = 0.0f;
        this.gXE = State.PAUSE;
        this.anB = true;
        this.gXF = 0.0f;
        this.gXG = 0.0f;
        this.gXH = 0.0f;
        this.gXI = 0L;
        this.lastStartTime = 0L;
        this.gXJ = 0L;
        this.gXK = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gXC = new LinkedList<>();
        this.gXD = 0.0f;
        this.gXE = State.PAUSE;
        this.anB = true;
        this.gXF = 0.0f;
        this.gXG = 0.0f;
        this.gXH = 0.0f;
        this.gXI = 0L;
        this.lastStartTime = 0L;
        this.gXJ = 0L;
        this.gXK = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gXv = new Paint();
        this.gXw = new Paint();
        this.gXx = new Paint();
        this.gXz = new Paint();
        this.gXy = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gXv.setStyle(Paint.Style.FILL);
        this.gXv.setColor(Color.parseColor("#33aaff"));
        this.gXw.setStyle(Paint.Style.FILL);
        this.gXw.setColor(Color.rgb(51, 170, (int) MotionEventCompat.ACTION_MASK));
        this.gXx.setStyle(Paint.Style.FILL);
        this.gXx.setColor(Color.parseColor("#FFFFFF"));
        this.gXz.setStyle(Paint.Style.FILL);
        this.gXz.setColor(Color.parseColor("#e53917"));
        this.gXy.setStyle(Paint.Style.FILL);
        this.gXy.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gXD = displayMetrics.widthPixels / 15000.0f;
        this.gXH = this.gXD;
    }

    public void setListener(a aVar) {
        this.gXu = aVar;
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
        if (this.ctu == 0) {
            this.ctu = System.currentTimeMillis();
        }
        if (this.gXK == 0) {
            this.gXK = getHeight();
        }
        this.gXA = (float) this.gXK;
        this.gXB = (float) ((this.gXK * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gXF = 0.0f;
        if (!this.gXC.isEmpty()) {
            Iterator<Integer> it = this.gXC.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gXJ = intValue;
                float f = this.gXF;
                this.gXF += ((float) (intValue - j)) * this.gXD;
                float f2 = this.gXF - this.gXB;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gXK - 1), this.gXv);
                canvas.drawRect(f2, 0.0f, this.gXF, (float) (this.gXK - 1), this.gXx);
                j = intValue;
            }
            if (this.gXC.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gXD, 0.0f, this.gXA + (this.gXD * 3000.0f), (float) (this.gXK - 1), this.gXw);
            }
        } else {
            canvas.drawRect(3000.0f * this.gXD, 0.0f, this.gXA + (this.gXD * 3000.0f), (float) (this.gXK - 1), this.gXw);
        }
        if (this.gXE == State.ROLLBACK) {
            canvas.drawRect(this.gXF - (((float) (this.gXJ - this.lastStartTime)) * this.gXD), 0.0f, this.gXF, (float) this.gXK, this.gXz);
        }
        if (this.gXE == State.START) {
            this.gXG += this.gXH * ((float) (currentTimeMillis - this.ctu));
            float f3 = this.gXF + this.gXG;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gXF, 0.0f, this.gXG + this.gXF, (float) (this.gXK - 1), this.gXv);
            } else {
                canvas.drawRect(this.gXF, 0.0f, getMeasuredWidth(), (float) (this.gXK - 1), this.gXv);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gXK) + (f3 - 5.0f), (float) (this.gXK - 1), this.gXy);
            if (this.gXu != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gXu.vC(this.mProgress);
                }
            }
        } else {
            if (this.gXu != null) {
                int measuredWidth2 = (int) ((this.gXF / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gXu.vC(this.mProgress);
                }
            }
            if (this.gXI == 0 || currentTimeMillis - this.gXI >= 800) {
                this.anB = !this.anB;
                this.gXI = System.currentTimeMillis();
            }
            if (this.anB) {
                canvas.drawRect(this.gXF - 5.0f, 0.0f, ((float) this.gXK) + (this.gXF - 5.0f), (float) (this.gXK - 1), this.gXy);
            }
        }
        this.ctu = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gXE = state;
        if (state != State.START) {
            this.gXG = this.gXH;
        }
        if (state == State.DELETE && this.gXC != null && !this.gXC.isEmpty()) {
            this.gXC.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gXE;
    }

    public void vB(int i) {
        this.gXC.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gXC == null || this.gXC.isEmpty()) {
            return 0;
        }
        return this.gXC.getLast().intValue();
    }

    public boolean bDR() {
        return this.gXC.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gXC;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gXC = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gXK = i;
    }

    public void reset() {
        this.gXC.clear();
        this.gXE = State.PAUSE;
        this.gXC.clear();
        this.gXF = 0.0f;
        this.ctu = 0L;
        this.lastStartTime = 0L;
        this.gXJ = 0L;
        this.mProgress = 0;
        this.gXI = 0L;
    }
}
