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
    private boolean anE;
    private long ctz;
    private Paint gXA;
    private Paint gXB;
    private Paint gXC;
    private Paint gXD;
    private Paint gXE;
    private float gXF;
    private float gXG;
    private LinkedList<Integer> gXH;
    private float gXI;
    private volatile State gXJ;
    private float gXK;
    private float gXL;
    private float gXM;
    private long gXN;
    private long gXO;
    private long gXP;
    private a gXz;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void vC(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gXH = new LinkedList<>();
        this.gXI = 0.0f;
        this.gXJ = State.PAUSE;
        this.anE = true;
        this.gXK = 0.0f;
        this.gXL = 0.0f;
        this.gXM = 0.0f;
        this.gXN = 0L;
        this.lastStartTime = 0L;
        this.gXO = 0L;
        this.gXP = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gXH = new LinkedList<>();
        this.gXI = 0.0f;
        this.gXJ = State.PAUSE;
        this.anE = true;
        this.gXK = 0.0f;
        this.gXL = 0.0f;
        this.gXM = 0.0f;
        this.gXN = 0L;
        this.lastStartTime = 0L;
        this.gXO = 0L;
        this.gXP = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gXH = new LinkedList<>();
        this.gXI = 0.0f;
        this.gXJ = State.PAUSE;
        this.anE = true;
        this.gXK = 0.0f;
        this.gXL = 0.0f;
        this.gXM = 0.0f;
        this.gXN = 0L;
        this.lastStartTime = 0L;
        this.gXO = 0L;
        this.gXP = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gXA = new Paint();
        this.gXB = new Paint();
        this.gXC = new Paint();
        this.gXE = new Paint();
        this.gXD = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gXA.setStyle(Paint.Style.FILL);
        this.gXA.setColor(Color.parseColor("#33aaff"));
        this.gXB.setStyle(Paint.Style.FILL);
        this.gXB.setColor(Color.rgb(51, 170, (int) MotionEventCompat.ACTION_MASK));
        this.gXC.setStyle(Paint.Style.FILL);
        this.gXC.setColor(Color.parseColor("#FFFFFF"));
        this.gXE.setStyle(Paint.Style.FILL);
        this.gXE.setColor(Color.parseColor("#e53917"));
        this.gXD.setStyle(Paint.Style.FILL);
        this.gXD.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gXI = displayMetrics.widthPixels / 15000.0f;
        this.gXM = this.gXI;
    }

    public void setListener(a aVar) {
        this.gXz = aVar;
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
        if (this.ctz == 0) {
            this.ctz = System.currentTimeMillis();
        }
        if (this.gXP == 0) {
            this.gXP = getHeight();
        }
        this.gXF = (float) this.gXP;
        this.gXG = (float) ((this.gXP * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gXK = 0.0f;
        if (!this.gXH.isEmpty()) {
            Iterator<Integer> it = this.gXH.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gXO = intValue;
                float f = this.gXK;
                this.gXK += ((float) (intValue - j)) * this.gXI;
                float f2 = this.gXK - this.gXG;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gXP - 1), this.gXA);
                canvas.drawRect(f2, 0.0f, this.gXK, (float) (this.gXP - 1), this.gXC);
                j = intValue;
            }
            if (this.gXH.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gXI, 0.0f, this.gXF + (this.gXI * 3000.0f), (float) (this.gXP - 1), this.gXB);
            }
        } else {
            canvas.drawRect(3000.0f * this.gXI, 0.0f, this.gXF + (this.gXI * 3000.0f), (float) (this.gXP - 1), this.gXB);
        }
        if (this.gXJ == State.ROLLBACK) {
            canvas.drawRect(this.gXK - (((float) (this.gXO - this.lastStartTime)) * this.gXI), 0.0f, this.gXK, (float) this.gXP, this.gXE);
        }
        if (this.gXJ == State.START) {
            this.gXL += this.gXM * ((float) (currentTimeMillis - this.ctz));
            float f3 = this.gXK + this.gXL;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gXK, 0.0f, this.gXL + this.gXK, (float) (this.gXP - 1), this.gXA);
            } else {
                canvas.drawRect(this.gXK, 0.0f, getMeasuredWidth(), (float) (this.gXP - 1), this.gXA);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gXP) + (f3 - 5.0f), (float) (this.gXP - 1), this.gXD);
            if (this.gXz != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gXz.vC(this.mProgress);
                }
            }
        } else {
            if (this.gXz != null) {
                int measuredWidth2 = (int) ((this.gXK / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gXz.vC(this.mProgress);
                }
            }
            if (this.gXN == 0 || currentTimeMillis - this.gXN >= 800) {
                this.anE = !this.anE;
                this.gXN = System.currentTimeMillis();
            }
            if (this.anE) {
                canvas.drawRect(this.gXK - 5.0f, 0.0f, ((float) this.gXP) + (this.gXK - 5.0f), (float) (this.gXP - 1), this.gXD);
            }
        }
        this.ctz = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gXJ = state;
        if (state != State.START) {
            this.gXL = this.gXM;
        }
        if (state == State.DELETE && this.gXH != null && !this.gXH.isEmpty()) {
            this.gXH.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gXJ;
    }

    public void vB(int i) {
        this.gXH.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gXH == null || this.gXH.isEmpty()) {
            return 0;
        }
        return this.gXH.getLast().intValue();
    }

    public boolean bDR() {
        return this.gXH.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gXH;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gXH = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gXP = i;
    }

    public void reset() {
        this.gXH.clear();
        this.gXJ = State.PAUSE;
        this.gXH.clear();
        this.gXK = 0.0f;
        this.ctz = 0L;
        this.lastStartTime = 0L;
        this.gXO = 0L;
        this.mProgress = 0;
        this.gXN = 0L;
    }
}
