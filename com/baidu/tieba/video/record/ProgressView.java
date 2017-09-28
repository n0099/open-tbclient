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
    private boolean anb;
    private long cde;
    private long gAa;
    private a gzK;
    private Paint gzL;
    private Paint gzM;
    private Paint gzN;
    private Paint gzO;
    private Paint gzP;
    private float gzQ;
    private float gzR;
    private LinkedList<Integer> gzS;
    private float gzT;
    private volatile State gzU;
    private float gzV;
    private float gzW;
    private float gzX;
    private long gzY;
    private long gzZ;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uE(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gzS = new LinkedList<>();
        this.gzT = 0.0f;
        this.gzU = State.PAUSE;
        this.anb = true;
        this.gzV = 0.0f;
        this.gzW = 0.0f;
        this.gzX = 0.0f;
        this.gzY = 0L;
        this.lastStartTime = 0L;
        this.gzZ = 0L;
        this.gAa = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzS = new LinkedList<>();
        this.gzT = 0.0f;
        this.gzU = State.PAUSE;
        this.anb = true;
        this.gzV = 0.0f;
        this.gzW = 0.0f;
        this.gzX = 0.0f;
        this.gzY = 0L;
        this.lastStartTime = 0L;
        this.gzZ = 0L;
        this.gAa = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzS = new LinkedList<>();
        this.gzT = 0.0f;
        this.gzU = State.PAUSE;
        this.anb = true;
        this.gzV = 0.0f;
        this.gzW = 0.0f;
        this.gzX = 0.0f;
        this.gzY = 0L;
        this.lastStartTime = 0L;
        this.gzZ = 0L;
        this.gAa = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gzL = new Paint();
        this.gzM = new Paint();
        this.gzN = new Paint();
        this.gzP = new Paint();
        this.gzO = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gzL.setStyle(Paint.Style.FILL);
        this.gzL.setColor(Color.parseColor("#33aaff"));
        this.gzM.setStyle(Paint.Style.FILL);
        this.gzM.setColor(Color.rgb(51, 170, (int) MotionEventCompat.ACTION_MASK));
        this.gzN.setStyle(Paint.Style.FILL);
        this.gzN.setColor(Color.parseColor("#FFFFFF"));
        this.gzP.setStyle(Paint.Style.FILL);
        this.gzP.setColor(Color.parseColor("#e53917"));
        this.gzO.setStyle(Paint.Style.FILL);
        this.gzO.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gzT = displayMetrics.widthPixels / 15000.0f;
        this.gzX = this.gzT;
    }

    public void setListener(a aVar) {
        this.gzK = aVar;
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
        if (this.cde == 0) {
            this.cde = System.currentTimeMillis();
        }
        if (this.gAa == 0) {
            this.gAa = getHeight();
        }
        this.gzQ = (float) this.gAa;
        this.gzR = (float) ((this.gAa * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gzV = 0.0f;
        if (!this.gzS.isEmpty()) {
            Iterator<Integer> it = this.gzS.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gzZ = intValue;
                float f = this.gzV;
                this.gzV += ((float) (intValue - j)) * this.gzT;
                float f2 = this.gzV - this.gzR;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gAa - 1), this.gzL);
                canvas.drawRect(f2, 0.0f, this.gzV, (float) (this.gAa - 1), this.gzN);
                j = intValue;
            }
            if (this.gzS.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gzT, 0.0f, this.gzQ + (this.gzT * 3000.0f), (float) (this.gAa - 1), this.gzM);
            }
        } else {
            canvas.drawRect(3000.0f * this.gzT, 0.0f, this.gzQ + (this.gzT * 3000.0f), (float) (this.gAa - 1), this.gzM);
        }
        if (this.gzU == State.ROLLBACK) {
            canvas.drawRect(this.gzV - (((float) (this.gzZ - this.lastStartTime)) * this.gzT), 0.0f, this.gzV, (float) this.gAa, this.gzP);
        }
        if (this.gzU == State.START) {
            this.gzW += this.gzX * ((float) (currentTimeMillis - this.cde));
            float f3 = this.gzV + this.gzW;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gzV, 0.0f, this.gzW + this.gzV, (float) (this.gAa - 1), this.gzL);
            } else {
                canvas.drawRect(this.gzV, 0.0f, getMeasuredWidth(), (float) (this.gAa - 1), this.gzL);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gAa) + (f3 - 5.0f), (float) (this.gAa - 1), this.gzO);
            if (this.gzK != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gzK.uE(this.mProgress);
                }
            }
        } else {
            if (this.gzK != null) {
                int measuredWidth2 = (int) ((this.gzV / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gzK.uE(this.mProgress);
                }
            }
            if (this.gzY == 0 || currentTimeMillis - this.gzY >= 800) {
                this.anb = !this.anb;
                this.gzY = System.currentTimeMillis();
            }
            if (this.anb) {
                canvas.drawRect(this.gzV - 5.0f, 0.0f, ((float) this.gAa) + (this.gzV - 5.0f), (float) (this.gAa - 1), this.gzO);
            }
        }
        this.cde = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gzU = state;
        if (state != State.START) {
            this.gzW = this.gzX;
        }
        if (state == State.DELETE && this.gzS != null && !this.gzS.isEmpty()) {
            this.gzS.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gzU;
    }

    public void uD(int i) {
        this.gzS.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gzS == null || this.gzS.isEmpty()) {
            return 0;
        }
        return this.gzS.getLast().intValue();
    }

    public boolean bxq() {
        return this.gzS.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gzS;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gzS = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gAa = i;
    }

    public void reset() {
        this.gzS.clear();
        this.gzU = State.PAUSE;
        this.gzS.clear();
        this.gzV = 0.0f;
        this.cde = 0L;
        this.lastStartTime = 0L;
        this.gzZ = 0L;
        this.mProgress = 0;
        this.gzY = 0L;
    }
}
