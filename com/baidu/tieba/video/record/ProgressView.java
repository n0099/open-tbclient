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
    private boolean bbC;
    private long dhW;
    private a hEC;
    private Paint hED;
    private Paint hEE;
    private Paint hEF;
    private Paint hEG;
    private Paint hEH;
    private float hEI;
    private float hEJ;
    private LinkedList<Integer> hEK;
    private float hEL;
    private volatile State hEM;
    private float hEN;
    private float hEO;
    private float hEP;
    private long hEQ;
    private long hER;
    private long hES;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void ys(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hEK = new LinkedList<>();
        this.hEL = 0.0f;
        this.hEM = State.PAUSE;
        this.bbC = true;
        this.hEN = 0.0f;
        this.hEO = 0.0f;
        this.hEP = 0.0f;
        this.hEQ = 0L;
        this.lastStartTime = 0L;
        this.hER = 0L;
        this.hES = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hEK = new LinkedList<>();
        this.hEL = 0.0f;
        this.hEM = State.PAUSE;
        this.bbC = true;
        this.hEN = 0.0f;
        this.hEO = 0.0f;
        this.hEP = 0.0f;
        this.hEQ = 0L;
        this.lastStartTime = 0L;
        this.hER = 0L;
        this.hES = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hEK = new LinkedList<>();
        this.hEL = 0.0f;
        this.hEM = State.PAUSE;
        this.bbC = true;
        this.hEN = 0.0f;
        this.hEO = 0.0f;
        this.hEP = 0.0f;
        this.hEQ = 0L;
        this.lastStartTime = 0L;
        this.hER = 0L;
        this.hES = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hED = new Paint();
        this.hEE = new Paint();
        this.hEF = new Paint();
        this.hEH = new Paint();
        this.hEG = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hED.setStyle(Paint.Style.FILL);
        this.hED.setColor(Color.parseColor("#33aaff"));
        this.hEE.setStyle(Paint.Style.FILL);
        this.hEE.setColor(Color.rgb(51, 170, 255));
        this.hEF.setStyle(Paint.Style.FILL);
        this.hEF.setColor(Color.parseColor("#FFFFFF"));
        this.hEH.setStyle(Paint.Style.FILL);
        this.hEH.setColor(Color.parseColor("#e53917"));
        this.hEG.setStyle(Paint.Style.FILL);
        this.hEG.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hEL = displayMetrics.widthPixels / 15000.0f;
        this.hEP = this.hEL;
    }

    public void setListener(a aVar) {
        this.hEC = aVar;
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
        if (this.dhW == 0) {
            this.dhW = System.currentTimeMillis();
        }
        if (this.hES == 0) {
            this.hES = getHeight();
        }
        this.hEI = (float) this.hES;
        this.hEJ = (float) ((this.hES * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hEN = 0.0f;
        if (!this.hEK.isEmpty()) {
            Iterator<Integer> it = this.hEK.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hER = intValue;
                float f = this.hEN;
                this.hEN += ((float) (intValue - j)) * this.hEL;
                float f2 = this.hEN - this.hEJ;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hES - 1), this.hED);
                canvas.drawRect(f2, 0.0f, this.hEN, (float) (this.hES - 1), this.hEF);
                j = intValue;
            }
            if (this.hEK.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hEL, 0.0f, this.hEI + (this.hEL * 3000.0f), (float) (this.hES - 1), this.hEE);
            }
        } else {
            canvas.drawRect(3000.0f * this.hEL, 0.0f, this.hEI + (this.hEL * 3000.0f), (float) (this.hES - 1), this.hEE);
        }
        if (this.hEM == State.ROLLBACK) {
            canvas.drawRect(this.hEN - (((float) (this.hER - this.lastStartTime)) * this.hEL), 0.0f, this.hEN, (float) this.hES, this.hEH);
        }
        if (this.hEM == State.START) {
            this.hEO += this.hEP * ((float) (currentTimeMillis - this.dhW));
            float f3 = this.hEN + this.hEO;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hEN, 0.0f, this.hEO + this.hEN, (float) (this.hES - 1), this.hED);
            } else {
                canvas.drawRect(this.hEN, 0.0f, getMeasuredWidth(), (float) (this.hES - 1), this.hED);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hES) + (f3 - 5.0f), (float) (this.hES - 1), this.hEG);
            if (this.hEC != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hEC.ys(this.mProgress);
                }
            }
        } else {
            if (this.hEC != null) {
                int measuredWidth2 = (int) ((this.hEN / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hEC.ys(this.mProgress);
                }
            }
            if (this.hEQ == 0 || currentTimeMillis - this.hEQ >= 800) {
                this.bbC = !this.bbC;
                this.hEQ = System.currentTimeMillis();
            }
            if (this.bbC) {
                canvas.drawRect(this.hEN - 5.0f, 0.0f, ((float) this.hES) + (this.hEN - 5.0f), (float) (this.hES - 1), this.hEG);
            }
        }
        this.dhW = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hEM = state;
        if (state != State.START) {
            this.hEO = this.hEP;
        }
        if (state == State.DELETE && this.hEK != null && !this.hEK.isEmpty()) {
            this.hEK.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hEM;
    }

    public void yr(int i) {
        this.hEK.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hEK == null || this.hEK.isEmpty()) {
            return 0;
        }
        return this.hEK.getLast().intValue();
    }

    public boolean bJq() {
        return this.hEK.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hEK;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hEK = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hES = i;
    }

    public void reset() {
        this.hEK.clear();
        this.hEM = State.PAUSE;
        this.hEK.clear();
        this.hEN = 0.0f;
        this.dhW = 0L;
        this.lastStartTime = 0L;
        this.hER = 0L;
        this.mProgress = 0;
        this.hEQ = 0L;
    }
}
