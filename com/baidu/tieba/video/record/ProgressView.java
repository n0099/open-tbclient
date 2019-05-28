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
    private boolean caq;
    private long eSm;
    private a juD;
    private Paint juE;
    private Paint juF;
    private Paint juG;
    private Paint juH;
    private Paint juI;
    private float juJ;
    private float juK;
    private LinkedList<Integer> juL;
    private float juM;
    private volatile State juN;
    private float juO;
    private float juP;
    private float juQ;
    private long juR;
    private long juS;
    private long juT;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void BI(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.juL = new LinkedList<>();
        this.juM = 0.0f;
        this.juN = State.PAUSE;
        this.caq = true;
        this.juO = 0.0f;
        this.juP = 0.0f;
        this.juQ = 0.0f;
        this.juR = 0L;
        this.lastStartTime = 0L;
        this.juS = 0L;
        this.juT = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.juL = new LinkedList<>();
        this.juM = 0.0f;
        this.juN = State.PAUSE;
        this.caq = true;
        this.juO = 0.0f;
        this.juP = 0.0f;
        this.juQ = 0.0f;
        this.juR = 0L;
        this.lastStartTime = 0L;
        this.juS = 0L;
        this.juT = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.juL = new LinkedList<>();
        this.juM = 0.0f;
        this.juN = State.PAUSE;
        this.caq = true;
        this.juO = 0.0f;
        this.juP = 0.0f;
        this.juQ = 0.0f;
        this.juR = 0L;
        this.lastStartTime = 0L;
        this.juS = 0L;
        this.juT = 0L;
        init(context);
    }

    private void init(Context context) {
        this.juE = new Paint();
        this.juF = new Paint();
        this.juG = new Paint();
        this.juI = new Paint();
        this.juH = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.juE.setStyle(Paint.Style.FILL);
        this.juE.setColor(Color.parseColor("#33aaff"));
        this.juF.setStyle(Paint.Style.FILL);
        this.juF.setColor(Color.rgb(51, 170, 255));
        this.juG.setStyle(Paint.Style.FILL);
        this.juG.setColor(Color.parseColor("#FFFFFF"));
        this.juI.setStyle(Paint.Style.FILL);
        this.juI.setColor(Color.parseColor("#e53917"));
        this.juH.setStyle(Paint.Style.FILL);
        this.juH.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.juM = displayMetrics.widthPixels / 15000.0f;
        this.juQ = this.juM;
    }

    public void setListener(a aVar) {
        this.juD = aVar;
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
        if (this.eSm == 0) {
            this.eSm = System.currentTimeMillis();
        }
        if (this.juT == 0) {
            this.juT = getHeight();
        }
        this.juJ = (float) this.juT;
        this.juK = (float) ((this.juT * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.juO = 0.0f;
        if (!this.juL.isEmpty()) {
            Iterator<Integer> it = this.juL.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.juS = intValue;
                float f = this.juO;
                this.juO += ((float) (intValue - j)) * this.juM;
                float f2 = this.juO - this.juK;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.juT - 1), this.juE);
                canvas.drawRect(f2, 0.0f, this.juO, (float) (this.juT - 1), this.juG);
                j = intValue;
            }
            if (this.juL.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.juM, 0.0f, this.juJ + (this.juM * 3000.0f), (float) (this.juT - 1), this.juF);
            }
        } else {
            canvas.drawRect(3000.0f * this.juM, 0.0f, this.juJ + (this.juM * 3000.0f), (float) (this.juT - 1), this.juF);
        }
        if (this.juN == State.ROLLBACK) {
            canvas.drawRect(this.juO - (((float) (this.juS - this.lastStartTime)) * this.juM), 0.0f, this.juO, (float) this.juT, this.juI);
        }
        if (this.juN == State.START) {
            this.juP += this.juQ * ((float) (currentTimeMillis - this.eSm));
            float f3 = this.juO + this.juP;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.juO, 0.0f, this.juP + this.juO, (float) (this.juT - 1), this.juE);
            } else {
                canvas.drawRect(this.juO, 0.0f, getMeasuredWidth(), (float) (this.juT - 1), this.juE);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.juT) + (f3 - 5.0f), (float) (this.juT - 1), this.juH);
            if (this.juD != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.juD.BI(this.mProgress);
                }
            }
        } else {
            if (this.juD != null) {
                int measuredWidth2 = (int) ((this.juO / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.juD.BI(this.mProgress);
                }
            }
            if (this.juR == 0 || currentTimeMillis - this.juR >= 800) {
                this.caq = !this.caq;
                this.juR = System.currentTimeMillis();
            }
            if (this.caq) {
                canvas.drawRect(this.juO - 5.0f, 0.0f, ((float) this.juT) + (this.juO - 5.0f), (float) (this.juT - 1), this.juH);
            }
        }
        this.eSm = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.juN = state;
        if (state != State.START) {
            this.juP = this.juQ;
        }
        if (state == State.DELETE && this.juL != null && !this.juL.isEmpty()) {
            this.juL.removeLast();
        }
    }

    public State getCurrentState() {
        return this.juN;
    }

    public void BH(int i) {
        this.juL.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.juL == null || this.juL.isEmpty()) {
            return 0;
        }
        return this.juL.getLast().intValue();
    }

    public boolean cts() {
        return this.juL.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.juL;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.juL = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.juT = i;
    }

    public void reset() {
        this.juL.clear();
        this.juN = State.PAUSE;
        this.juL.clear();
        this.juO = 0.0f;
        this.eSm = 0L;
        this.lastStartTime = 0L;
        this.juS = 0L;
        this.mProgress = 0;
        this.juR = 0L;
    }
}
