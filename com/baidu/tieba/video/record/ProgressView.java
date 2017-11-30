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
    private boolean anA;
    private long ctl;
    private a gUL;
    private Paint gUM;
    private Paint gUN;
    private Paint gUO;
    private Paint gUP;
    private Paint gUQ;
    private float gUR;
    private float gUS;
    private LinkedList<Integer> gUT;
    private float gUU;
    private volatile State gUV;
    private float gUW;
    private float gUX;
    private float gUY;
    private long gUZ;
    private long gVa;
    private long gVb;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void vr(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gUT = new LinkedList<>();
        this.gUU = 0.0f;
        this.gUV = State.PAUSE;
        this.anA = true;
        this.gUW = 0.0f;
        this.gUX = 0.0f;
        this.gUY = 0.0f;
        this.gUZ = 0L;
        this.lastStartTime = 0L;
        this.gVa = 0L;
        this.gVb = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gUT = new LinkedList<>();
        this.gUU = 0.0f;
        this.gUV = State.PAUSE;
        this.anA = true;
        this.gUW = 0.0f;
        this.gUX = 0.0f;
        this.gUY = 0.0f;
        this.gUZ = 0L;
        this.lastStartTime = 0L;
        this.gVa = 0L;
        this.gVb = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gUT = new LinkedList<>();
        this.gUU = 0.0f;
        this.gUV = State.PAUSE;
        this.anA = true;
        this.gUW = 0.0f;
        this.gUX = 0.0f;
        this.gUY = 0.0f;
        this.gUZ = 0L;
        this.lastStartTime = 0L;
        this.gVa = 0L;
        this.gVb = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gUM = new Paint();
        this.gUN = new Paint();
        this.gUO = new Paint();
        this.gUQ = new Paint();
        this.gUP = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gUM.setStyle(Paint.Style.FILL);
        this.gUM.setColor(Color.parseColor("#33aaff"));
        this.gUN.setStyle(Paint.Style.FILL);
        this.gUN.setColor(Color.rgb(51, 170, (int) MotionEventCompat.ACTION_MASK));
        this.gUO.setStyle(Paint.Style.FILL);
        this.gUO.setColor(Color.parseColor("#FFFFFF"));
        this.gUQ.setStyle(Paint.Style.FILL);
        this.gUQ.setColor(Color.parseColor("#e53917"));
        this.gUP.setStyle(Paint.Style.FILL);
        this.gUP.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gUU = displayMetrics.widthPixels / 15000.0f;
        this.gUY = this.gUU;
    }

    public void setListener(a aVar) {
        this.gUL = aVar;
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
        if (this.ctl == 0) {
            this.ctl = System.currentTimeMillis();
        }
        if (this.gVb == 0) {
            this.gVb = getHeight();
        }
        this.gUR = (float) this.gVb;
        this.gUS = (float) ((this.gVb * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gUW = 0.0f;
        if (!this.gUT.isEmpty()) {
            Iterator<Integer> it = this.gUT.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gVa = intValue;
                float f = this.gUW;
                this.gUW += ((float) (intValue - j)) * this.gUU;
                float f2 = this.gUW - this.gUS;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gVb - 1), this.gUM);
                canvas.drawRect(f2, 0.0f, this.gUW, (float) (this.gVb - 1), this.gUO);
                j = intValue;
            }
            if (this.gUT.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gUU, 0.0f, this.gUR + (this.gUU * 3000.0f), (float) (this.gVb - 1), this.gUN);
            }
        } else {
            canvas.drawRect(3000.0f * this.gUU, 0.0f, this.gUR + (this.gUU * 3000.0f), (float) (this.gVb - 1), this.gUN);
        }
        if (this.gUV == State.ROLLBACK) {
            canvas.drawRect(this.gUW - (((float) (this.gVa - this.lastStartTime)) * this.gUU), 0.0f, this.gUW, (float) this.gVb, this.gUQ);
        }
        if (this.gUV == State.START) {
            this.gUX += this.gUY * ((float) (currentTimeMillis - this.ctl));
            float f3 = this.gUW + this.gUX;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gUW, 0.0f, this.gUX + this.gUW, (float) (this.gVb - 1), this.gUM);
            } else {
                canvas.drawRect(this.gUW, 0.0f, getMeasuredWidth(), (float) (this.gVb - 1), this.gUM);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gVb) + (f3 - 5.0f), (float) (this.gVb - 1), this.gUP);
            if (this.gUL != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gUL.vr(this.mProgress);
                }
            }
        } else {
            if (this.gUL != null) {
                int measuredWidth2 = (int) ((this.gUW / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gUL.vr(this.mProgress);
                }
            }
            if (this.gUZ == 0 || currentTimeMillis - this.gUZ >= 800) {
                this.anA = !this.anA;
                this.gUZ = System.currentTimeMillis();
            }
            if (this.anA) {
                canvas.drawRect(this.gUW - 5.0f, 0.0f, ((float) this.gVb) + (this.gUW - 5.0f), (float) (this.gVb - 1), this.gUP);
            }
        }
        this.ctl = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gUV = state;
        if (state != State.START) {
            this.gUX = this.gUY;
        }
        if (state == State.DELETE && this.gUT != null && !this.gUT.isEmpty()) {
            this.gUT.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gUV;
    }

    public void vq(int i) {
        this.gUT.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gUT == null || this.gUT.isEmpty()) {
            return 0;
        }
        return this.gUT.getLast().intValue();
    }

    public boolean bDk() {
        return this.gUT.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gUT;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gUT = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gVb = i;
    }

    public void reset() {
        this.gUT.clear();
        this.gUV = State.PAUSE;
        this.gUT.clear();
        this.gUW = 0.0f;
        this.ctl = 0L;
        this.lastStartTime = 0L;
        this.gVa = 0L;
        this.mProgress = 0;
        this.gUZ = 0L;
    }
}
