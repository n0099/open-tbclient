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
    private long eSl;
    private a juC;
    private Paint juD;
    private Paint juE;
    private Paint juF;
    private Paint juG;
    private Paint juH;
    private float juI;
    private float juJ;
    private LinkedList<Integer> juK;
    private float juL;
    private volatile State juM;
    private float juN;
    private float juO;
    private float juP;
    private long juQ;
    private long juR;
    private long juS;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void BI(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.juK = new LinkedList<>();
        this.juL = 0.0f;
        this.juM = State.PAUSE;
        this.caq = true;
        this.juN = 0.0f;
        this.juO = 0.0f;
        this.juP = 0.0f;
        this.juQ = 0L;
        this.lastStartTime = 0L;
        this.juR = 0L;
        this.juS = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.juK = new LinkedList<>();
        this.juL = 0.0f;
        this.juM = State.PAUSE;
        this.caq = true;
        this.juN = 0.0f;
        this.juO = 0.0f;
        this.juP = 0.0f;
        this.juQ = 0L;
        this.lastStartTime = 0L;
        this.juR = 0L;
        this.juS = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.juK = new LinkedList<>();
        this.juL = 0.0f;
        this.juM = State.PAUSE;
        this.caq = true;
        this.juN = 0.0f;
        this.juO = 0.0f;
        this.juP = 0.0f;
        this.juQ = 0L;
        this.lastStartTime = 0L;
        this.juR = 0L;
        this.juS = 0L;
        init(context);
    }

    private void init(Context context) {
        this.juD = new Paint();
        this.juE = new Paint();
        this.juF = new Paint();
        this.juH = new Paint();
        this.juG = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.juD.setStyle(Paint.Style.FILL);
        this.juD.setColor(Color.parseColor("#33aaff"));
        this.juE.setStyle(Paint.Style.FILL);
        this.juE.setColor(Color.rgb(51, 170, 255));
        this.juF.setStyle(Paint.Style.FILL);
        this.juF.setColor(Color.parseColor("#FFFFFF"));
        this.juH.setStyle(Paint.Style.FILL);
        this.juH.setColor(Color.parseColor("#e53917"));
        this.juG.setStyle(Paint.Style.FILL);
        this.juG.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.juL = displayMetrics.widthPixels / 15000.0f;
        this.juP = this.juL;
    }

    public void setListener(a aVar) {
        this.juC = aVar;
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
        if (this.eSl == 0) {
            this.eSl = System.currentTimeMillis();
        }
        if (this.juS == 0) {
            this.juS = getHeight();
        }
        this.juI = (float) this.juS;
        this.juJ = (float) ((this.juS * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.juN = 0.0f;
        if (!this.juK.isEmpty()) {
            Iterator<Integer> it = this.juK.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.juR = intValue;
                float f = this.juN;
                this.juN += ((float) (intValue - j)) * this.juL;
                float f2 = this.juN - this.juJ;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.juS - 1), this.juD);
                canvas.drawRect(f2, 0.0f, this.juN, (float) (this.juS - 1), this.juF);
                j = intValue;
            }
            if (this.juK.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.juL, 0.0f, this.juI + (this.juL * 3000.0f), (float) (this.juS - 1), this.juE);
            }
        } else {
            canvas.drawRect(3000.0f * this.juL, 0.0f, this.juI + (this.juL * 3000.0f), (float) (this.juS - 1), this.juE);
        }
        if (this.juM == State.ROLLBACK) {
            canvas.drawRect(this.juN - (((float) (this.juR - this.lastStartTime)) * this.juL), 0.0f, this.juN, (float) this.juS, this.juH);
        }
        if (this.juM == State.START) {
            this.juO += this.juP * ((float) (currentTimeMillis - this.eSl));
            float f3 = this.juN + this.juO;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.juN, 0.0f, this.juO + this.juN, (float) (this.juS - 1), this.juD);
            } else {
                canvas.drawRect(this.juN, 0.0f, getMeasuredWidth(), (float) (this.juS - 1), this.juD);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.juS) + (f3 - 5.0f), (float) (this.juS - 1), this.juG);
            if (this.juC != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.juC.BI(this.mProgress);
                }
            }
        } else {
            if (this.juC != null) {
                int measuredWidth2 = (int) ((this.juN / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.juC.BI(this.mProgress);
                }
            }
            if (this.juQ == 0 || currentTimeMillis - this.juQ >= 800) {
                this.caq = !this.caq;
                this.juQ = System.currentTimeMillis();
            }
            if (this.caq) {
                canvas.drawRect(this.juN - 5.0f, 0.0f, ((float) this.juS) + (this.juN - 5.0f), (float) (this.juS - 1), this.juG);
            }
        }
        this.eSl = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.juM = state;
        if (state != State.START) {
            this.juO = this.juP;
        }
        if (state == State.DELETE && this.juK != null && !this.juK.isEmpty()) {
            this.juK.removeLast();
        }
    }

    public State getCurrentState() {
        return this.juM;
    }

    public void BH(int i) {
        this.juK.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.juK == null || this.juK.isEmpty()) {
            return 0;
        }
        return this.juK.getLast().intValue();
    }

    public boolean ctq() {
        return this.juK.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.juK;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.juK = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.juS = i;
    }

    public void reset() {
        this.juK.clear();
        this.juM = State.PAUSE;
        this.juK.clear();
        this.juN = 0.0f;
        this.eSl = 0L;
        this.lastStartTime = 0L;
        this.juR = 0L;
        this.mProgress = 0;
        this.juQ = 0L;
    }
}
