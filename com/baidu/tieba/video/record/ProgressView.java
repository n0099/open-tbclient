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
    private boolean car;
    private long eSm;
    private a juG;
    private Paint juH;
    private Paint juI;
    private Paint juJ;
    private Paint juK;
    private Paint juL;
    private float juM;
    private float juN;
    private LinkedList<Integer> juO;
    private float juP;
    private volatile State juQ;
    private float juR;
    private float juS;
    private float juT;
    private long juU;
    private long juV;
    private long juW;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void BI(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.juO = new LinkedList<>();
        this.juP = 0.0f;
        this.juQ = State.PAUSE;
        this.car = true;
        this.juR = 0.0f;
        this.juS = 0.0f;
        this.juT = 0.0f;
        this.juU = 0L;
        this.lastStartTime = 0L;
        this.juV = 0L;
        this.juW = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.juO = new LinkedList<>();
        this.juP = 0.0f;
        this.juQ = State.PAUSE;
        this.car = true;
        this.juR = 0.0f;
        this.juS = 0.0f;
        this.juT = 0.0f;
        this.juU = 0L;
        this.lastStartTime = 0L;
        this.juV = 0L;
        this.juW = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.juO = new LinkedList<>();
        this.juP = 0.0f;
        this.juQ = State.PAUSE;
        this.car = true;
        this.juR = 0.0f;
        this.juS = 0.0f;
        this.juT = 0.0f;
        this.juU = 0L;
        this.lastStartTime = 0L;
        this.juV = 0L;
        this.juW = 0L;
        init(context);
    }

    private void init(Context context) {
        this.juH = new Paint();
        this.juI = new Paint();
        this.juJ = new Paint();
        this.juL = new Paint();
        this.juK = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.juH.setStyle(Paint.Style.FILL);
        this.juH.setColor(Color.parseColor("#33aaff"));
        this.juI.setStyle(Paint.Style.FILL);
        this.juI.setColor(Color.rgb(51, 170, 255));
        this.juJ.setStyle(Paint.Style.FILL);
        this.juJ.setColor(Color.parseColor("#FFFFFF"));
        this.juL.setStyle(Paint.Style.FILL);
        this.juL.setColor(Color.parseColor("#e53917"));
        this.juK.setStyle(Paint.Style.FILL);
        this.juK.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.juP = displayMetrics.widthPixels / 15000.0f;
        this.juT = this.juP;
    }

    public void setListener(a aVar) {
        this.juG = aVar;
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
        if (this.juW == 0) {
            this.juW = getHeight();
        }
        this.juM = (float) this.juW;
        this.juN = (float) ((this.juW * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.juR = 0.0f;
        if (!this.juO.isEmpty()) {
            Iterator<Integer> it = this.juO.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.juV = intValue;
                float f = this.juR;
                this.juR += ((float) (intValue - j)) * this.juP;
                float f2 = this.juR - this.juN;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.juW - 1), this.juH);
                canvas.drawRect(f2, 0.0f, this.juR, (float) (this.juW - 1), this.juJ);
                j = intValue;
            }
            if (this.juO.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.juP, 0.0f, this.juM + (this.juP * 3000.0f), (float) (this.juW - 1), this.juI);
            }
        } else {
            canvas.drawRect(3000.0f * this.juP, 0.0f, this.juM + (this.juP * 3000.0f), (float) (this.juW - 1), this.juI);
        }
        if (this.juQ == State.ROLLBACK) {
            canvas.drawRect(this.juR - (((float) (this.juV - this.lastStartTime)) * this.juP), 0.0f, this.juR, (float) this.juW, this.juL);
        }
        if (this.juQ == State.START) {
            this.juS += this.juT * ((float) (currentTimeMillis - this.eSm));
            float f3 = this.juR + this.juS;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.juR, 0.0f, this.juS + this.juR, (float) (this.juW - 1), this.juH);
            } else {
                canvas.drawRect(this.juR, 0.0f, getMeasuredWidth(), (float) (this.juW - 1), this.juH);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.juW) + (f3 - 5.0f), (float) (this.juW - 1), this.juK);
            if (this.juG != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.juG.BI(this.mProgress);
                }
            }
        } else {
            if (this.juG != null) {
                int measuredWidth2 = (int) ((this.juR / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.juG.BI(this.mProgress);
                }
            }
            if (this.juU == 0 || currentTimeMillis - this.juU >= 800) {
                this.car = !this.car;
                this.juU = System.currentTimeMillis();
            }
            if (this.car) {
                canvas.drawRect(this.juR - 5.0f, 0.0f, ((float) this.juW) + (this.juR - 5.0f), (float) (this.juW - 1), this.juK);
            }
        }
        this.eSm = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.juQ = state;
        if (state != State.START) {
            this.juS = this.juT;
        }
        if (state == State.DELETE && this.juO != null && !this.juO.isEmpty()) {
            this.juO.removeLast();
        }
    }

    public State getCurrentState() {
        return this.juQ;
    }

    public void BH(int i) {
        this.juO.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.juO == null || this.juO.isEmpty()) {
            return 0;
        }
        return this.juO.getLast().intValue();
    }

    public boolean ctr() {
        return this.juO.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.juO;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.juO = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.juW = i;
    }

    public void reset() {
        this.juO.clear();
        this.juQ = State.PAUSE;
        this.juO.clear();
        this.juR = 0.0f;
        this.eSm = 0L;
        this.lastStartTime = 0L;
        this.juV = 0L;
        this.mProgress = 0;
        this.juU = 0L;
    }
}
