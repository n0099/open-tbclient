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
    private boolean aJU;
    private long dse;
    private Paint hLA;
    private Paint hLB;
    private Paint hLC;
    private float hLD;
    private float hLE;
    private LinkedList<Integer> hLF;
    private float hLG;
    private volatile State hLH;
    private float hLI;
    private float hLJ;
    private float hLK;
    private long hLL;
    private long hLM;
    private long hLN;
    private a hLx;
    private Paint hLy;
    private Paint hLz;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void wS(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hLF = new LinkedList<>();
        this.hLG = 0.0f;
        this.hLH = State.PAUSE;
        this.aJU = true;
        this.hLI = 0.0f;
        this.hLJ = 0.0f;
        this.hLK = 0.0f;
        this.hLL = 0L;
        this.lastStartTime = 0L;
        this.hLM = 0L;
        this.hLN = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLF = new LinkedList<>();
        this.hLG = 0.0f;
        this.hLH = State.PAUSE;
        this.aJU = true;
        this.hLI = 0.0f;
        this.hLJ = 0.0f;
        this.hLK = 0.0f;
        this.hLL = 0L;
        this.lastStartTime = 0L;
        this.hLM = 0L;
        this.hLN = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hLF = new LinkedList<>();
        this.hLG = 0.0f;
        this.hLH = State.PAUSE;
        this.aJU = true;
        this.hLI = 0.0f;
        this.hLJ = 0.0f;
        this.hLK = 0.0f;
        this.hLL = 0L;
        this.lastStartTime = 0L;
        this.hLM = 0L;
        this.hLN = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hLy = new Paint();
        this.hLz = new Paint();
        this.hLA = new Paint();
        this.hLC = new Paint();
        this.hLB = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hLy.setStyle(Paint.Style.FILL);
        this.hLy.setColor(Color.parseColor("#33aaff"));
        this.hLz.setStyle(Paint.Style.FILL);
        this.hLz.setColor(Color.rgb(51, 170, 255));
        this.hLA.setStyle(Paint.Style.FILL);
        this.hLA.setColor(Color.parseColor("#FFFFFF"));
        this.hLC.setStyle(Paint.Style.FILL);
        this.hLC.setColor(Color.parseColor("#e53917"));
        this.hLB.setStyle(Paint.Style.FILL);
        this.hLB.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hLG = displayMetrics.widthPixels / 15000.0f;
        this.hLK = this.hLG;
    }

    public void setListener(a aVar) {
        this.hLx = aVar;
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
        if (this.dse == 0) {
            this.dse = System.currentTimeMillis();
        }
        if (this.hLN == 0) {
            this.hLN = getHeight();
        }
        this.hLD = (float) this.hLN;
        this.hLE = (float) ((this.hLN * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hLI = 0.0f;
        if (!this.hLF.isEmpty()) {
            Iterator<Integer> it = this.hLF.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hLM = intValue;
                float f = this.hLI;
                this.hLI += ((float) (intValue - j)) * this.hLG;
                float f2 = this.hLI - this.hLE;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hLN - 1), this.hLy);
                canvas.drawRect(f2, 0.0f, this.hLI, (float) (this.hLN - 1), this.hLA);
                j = intValue;
            }
            if (this.hLF.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hLG, 0.0f, this.hLD + (this.hLG * 3000.0f), (float) (this.hLN - 1), this.hLz);
            }
        } else {
            canvas.drawRect(3000.0f * this.hLG, 0.0f, this.hLD + (this.hLG * 3000.0f), (float) (this.hLN - 1), this.hLz);
        }
        if (this.hLH == State.ROLLBACK) {
            canvas.drawRect(this.hLI - (((float) (this.hLM - this.lastStartTime)) * this.hLG), 0.0f, this.hLI, (float) this.hLN, this.hLC);
        }
        if (this.hLH == State.START) {
            this.hLJ += this.hLK * ((float) (currentTimeMillis - this.dse));
            float f3 = this.hLI + this.hLJ;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hLI, 0.0f, this.hLJ + this.hLI, (float) (this.hLN - 1), this.hLy);
            } else {
                canvas.drawRect(this.hLI, 0.0f, getMeasuredWidth(), (float) (this.hLN - 1), this.hLy);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hLN) + (f3 - 5.0f), (float) (this.hLN - 1), this.hLB);
            if (this.hLx != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hLx.wS(this.mProgress);
                }
            }
        } else {
            if (this.hLx != null) {
                int measuredWidth2 = (int) ((this.hLI / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hLx.wS(this.mProgress);
                }
            }
            if (this.hLL == 0 || currentTimeMillis - this.hLL >= 800) {
                this.aJU = !this.aJU;
                this.hLL = System.currentTimeMillis();
            }
            if (this.aJU) {
                canvas.drawRect(this.hLI - 5.0f, 0.0f, ((float) this.hLN) + (this.hLI - 5.0f), (float) (this.hLN - 1), this.hLB);
            }
        }
        this.dse = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hLH = state;
        if (state != State.START) {
            this.hLJ = this.hLK;
        }
        if (state == State.DELETE && this.hLF != null && !this.hLF.isEmpty()) {
            this.hLF.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hLH;
    }

    public void wR(int i) {
        this.hLF.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hLF == null || this.hLF.isEmpty()) {
            return 0;
        }
        return this.hLF.getLast().intValue();
    }

    public boolean bLO() {
        return this.hLF.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hLF;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hLF = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hLN = i;
    }

    public void reset() {
        this.hLF.clear();
        this.hLH = State.PAUSE;
        this.hLF.clear();
        this.hLI = 0.0f;
        this.dse = 0L;
        this.lastStartTime = 0L;
        this.hLM = 0L;
        this.mProgress = 0;
        this.hLL = 0L;
    }
}
