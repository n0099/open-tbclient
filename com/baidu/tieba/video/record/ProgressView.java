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
    private boolean ccu;
    private long eZc;
    private LinkedList<Integer> jEA;
    private float jEB;
    private volatile State jEC;
    private float jED;
    private float jEE;
    private float jEF;
    private long jEG;
    private long jEH;
    private long jEI;
    private a jEs;
    private Paint jEt;
    private Paint jEu;
    private Paint jEv;
    private Paint jEw;
    private Paint jEx;
    private float jEy;
    private float jEz;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void Cv(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.jEA = new LinkedList<>();
        this.jEB = 0.0f;
        this.jEC = State.PAUSE;
        this.ccu = true;
        this.jED = 0.0f;
        this.jEE = 0.0f;
        this.jEF = 0.0f;
        this.jEG = 0L;
        this.lastStartTime = 0L;
        this.jEH = 0L;
        this.jEI = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jEA = new LinkedList<>();
        this.jEB = 0.0f;
        this.jEC = State.PAUSE;
        this.ccu = true;
        this.jED = 0.0f;
        this.jEE = 0.0f;
        this.jEF = 0.0f;
        this.jEG = 0L;
        this.lastStartTime = 0L;
        this.jEH = 0L;
        this.jEI = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEA = new LinkedList<>();
        this.jEB = 0.0f;
        this.jEC = State.PAUSE;
        this.ccu = true;
        this.jED = 0.0f;
        this.jEE = 0.0f;
        this.jEF = 0.0f;
        this.jEG = 0L;
        this.lastStartTime = 0L;
        this.jEH = 0L;
        this.jEI = 0L;
        init(context);
    }

    private void init(Context context) {
        this.jEt = new Paint();
        this.jEu = new Paint();
        this.jEv = new Paint();
        this.jEx = new Paint();
        this.jEw = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.jEt.setStyle(Paint.Style.FILL);
        this.jEt.setColor(Color.parseColor("#33aaff"));
        this.jEu.setStyle(Paint.Style.FILL);
        this.jEu.setColor(Color.rgb(51, 170, 255));
        this.jEv.setStyle(Paint.Style.FILL);
        this.jEv.setColor(Color.parseColor("#FFFFFF"));
        this.jEx.setStyle(Paint.Style.FILL);
        this.jEx.setColor(Color.parseColor("#e53917"));
        this.jEw.setStyle(Paint.Style.FILL);
        this.jEw.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.jEB = displayMetrics.widthPixels / 15000.0f;
        this.jEF = this.jEB;
    }

    public void setListener(a aVar) {
        this.jEs = aVar;
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
        if (this.eZc == 0) {
            this.eZc = System.currentTimeMillis();
        }
        if (this.jEI == 0) {
            this.jEI = getHeight();
        }
        this.jEy = (float) this.jEI;
        this.jEz = (float) ((this.jEI * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.jED = 0.0f;
        if (!this.jEA.isEmpty()) {
            Iterator<Integer> it = this.jEA.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.jEH = intValue;
                float f = this.jED;
                this.jED += ((float) (intValue - j)) * this.jEB;
                float f2 = this.jED - this.jEz;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.jEI - 1), this.jEt);
                canvas.drawRect(f2, 0.0f, this.jED, (float) (this.jEI - 1), this.jEv);
                j = intValue;
            }
            if (this.jEA.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.jEB, 0.0f, this.jEy + (this.jEB * 3000.0f), (float) (this.jEI - 1), this.jEu);
            }
        } else {
            canvas.drawRect(3000.0f * this.jEB, 0.0f, this.jEy + (this.jEB * 3000.0f), (float) (this.jEI - 1), this.jEu);
        }
        if (this.jEC == State.ROLLBACK) {
            canvas.drawRect(this.jED - (((float) (this.jEH - this.lastStartTime)) * this.jEB), 0.0f, this.jED, (float) this.jEI, this.jEx);
        }
        if (this.jEC == State.START) {
            this.jEE += this.jEF * ((float) (currentTimeMillis - this.eZc));
            float f3 = this.jED + this.jEE;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.jED, 0.0f, this.jEE + this.jED, (float) (this.jEI - 1), this.jEt);
            } else {
                canvas.drawRect(this.jED, 0.0f, getMeasuredWidth(), (float) (this.jEI - 1), this.jEt);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.jEI) + (f3 - 5.0f), (float) (this.jEI - 1), this.jEw);
            if (this.jEs != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.jEs.Cv(this.mProgress);
                }
            }
        } else {
            if (this.jEs != null) {
                int measuredWidth2 = (int) ((this.jED / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.jEs.Cv(this.mProgress);
                }
            }
            if (this.jEG == 0 || currentTimeMillis - this.jEG >= 800) {
                this.ccu = !this.ccu;
                this.jEG = System.currentTimeMillis();
            }
            if (this.ccu) {
                canvas.drawRect(this.jED - 5.0f, 0.0f, ((float) this.jEI) + (this.jED - 5.0f), (float) (this.jEI - 1), this.jEw);
            }
        }
        this.eZc = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.jEC = state;
        if (state != State.START) {
            this.jEE = this.jEF;
        }
        if (state == State.DELETE && this.jEA != null && !this.jEA.isEmpty()) {
            this.jEA.removeLast();
        }
    }

    public State getCurrentState() {
        return this.jEC;
    }

    public void Cu(int i) {
        this.jEA.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.jEA == null || this.jEA.isEmpty()) {
            return 0;
        }
        return this.jEA.getLast().intValue();
    }

    public boolean cxq() {
        return this.jEA.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.jEA;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.jEA = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.jEI = i;
    }

    public void reset() {
        this.jEA.clear();
        this.jEC = State.PAUSE;
        this.jEA.clear();
        this.jED = 0.0f;
        this.eZc = 0L;
        this.lastStartTime = 0L;
        this.jEH = 0L;
        this.mProgress = 0;
        this.jEG = 0L;
    }
}
