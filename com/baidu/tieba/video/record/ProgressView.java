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
    private boolean aJT;
    private long dsd;
    private Paint hLA;
    private Paint hLB;
    private float hLC;
    private float hLD;
    private LinkedList<Integer> hLE;
    private float hLF;
    private volatile State hLG;
    private float hLH;
    private float hLI;
    private float hLJ;
    private long hLK;
    private long hLL;
    private long hLM;
    private a hLw;
    private Paint hLx;
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
        this.hLE = new LinkedList<>();
        this.hLF = 0.0f;
        this.hLG = State.PAUSE;
        this.aJT = true;
        this.hLH = 0.0f;
        this.hLI = 0.0f;
        this.hLJ = 0.0f;
        this.hLK = 0L;
        this.lastStartTime = 0L;
        this.hLL = 0L;
        this.hLM = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hLE = new LinkedList<>();
        this.hLF = 0.0f;
        this.hLG = State.PAUSE;
        this.aJT = true;
        this.hLH = 0.0f;
        this.hLI = 0.0f;
        this.hLJ = 0.0f;
        this.hLK = 0L;
        this.lastStartTime = 0L;
        this.hLL = 0L;
        this.hLM = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hLE = new LinkedList<>();
        this.hLF = 0.0f;
        this.hLG = State.PAUSE;
        this.aJT = true;
        this.hLH = 0.0f;
        this.hLI = 0.0f;
        this.hLJ = 0.0f;
        this.hLK = 0L;
        this.lastStartTime = 0L;
        this.hLL = 0L;
        this.hLM = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hLx = new Paint();
        this.hLy = new Paint();
        this.hLz = new Paint();
        this.hLB = new Paint();
        this.hLA = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hLx.setStyle(Paint.Style.FILL);
        this.hLx.setColor(Color.parseColor("#33aaff"));
        this.hLy.setStyle(Paint.Style.FILL);
        this.hLy.setColor(Color.rgb(51, 170, 255));
        this.hLz.setStyle(Paint.Style.FILL);
        this.hLz.setColor(Color.parseColor("#FFFFFF"));
        this.hLB.setStyle(Paint.Style.FILL);
        this.hLB.setColor(Color.parseColor("#e53917"));
        this.hLA.setStyle(Paint.Style.FILL);
        this.hLA.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hLF = displayMetrics.widthPixels / 15000.0f;
        this.hLJ = this.hLF;
    }

    public void setListener(a aVar) {
        this.hLw = aVar;
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
        if (this.dsd == 0) {
            this.dsd = System.currentTimeMillis();
        }
        if (this.hLM == 0) {
            this.hLM = getHeight();
        }
        this.hLC = (float) this.hLM;
        this.hLD = (float) ((this.hLM * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hLH = 0.0f;
        if (!this.hLE.isEmpty()) {
            Iterator<Integer> it = this.hLE.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hLL = intValue;
                float f = this.hLH;
                this.hLH += ((float) (intValue - j)) * this.hLF;
                float f2 = this.hLH - this.hLD;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hLM - 1), this.hLx);
                canvas.drawRect(f2, 0.0f, this.hLH, (float) (this.hLM - 1), this.hLz);
                j = intValue;
            }
            if (this.hLE.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hLF, 0.0f, this.hLC + (this.hLF * 3000.0f), (float) (this.hLM - 1), this.hLy);
            }
        } else {
            canvas.drawRect(3000.0f * this.hLF, 0.0f, this.hLC + (this.hLF * 3000.0f), (float) (this.hLM - 1), this.hLy);
        }
        if (this.hLG == State.ROLLBACK) {
            canvas.drawRect(this.hLH - (((float) (this.hLL - this.lastStartTime)) * this.hLF), 0.0f, this.hLH, (float) this.hLM, this.hLB);
        }
        if (this.hLG == State.START) {
            this.hLI += this.hLJ * ((float) (currentTimeMillis - this.dsd));
            float f3 = this.hLH + this.hLI;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hLH, 0.0f, this.hLI + this.hLH, (float) (this.hLM - 1), this.hLx);
            } else {
                canvas.drawRect(this.hLH, 0.0f, getMeasuredWidth(), (float) (this.hLM - 1), this.hLx);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hLM) + (f3 - 5.0f), (float) (this.hLM - 1), this.hLA);
            if (this.hLw != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hLw.wS(this.mProgress);
                }
            }
        } else {
            if (this.hLw != null) {
                int measuredWidth2 = (int) ((this.hLH / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hLw.wS(this.mProgress);
                }
            }
            if (this.hLK == 0 || currentTimeMillis - this.hLK >= 800) {
                this.aJT = !this.aJT;
                this.hLK = System.currentTimeMillis();
            }
            if (this.aJT) {
                canvas.drawRect(this.hLH - 5.0f, 0.0f, ((float) this.hLM) + (this.hLH - 5.0f), (float) (this.hLM - 1), this.hLA);
            }
        }
        this.dsd = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hLG = state;
        if (state != State.START) {
            this.hLI = this.hLJ;
        }
        if (state == State.DELETE && this.hLE != null && !this.hLE.isEmpty()) {
            this.hLE.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hLG;
    }

    public void wR(int i) {
        this.hLE.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hLE == null || this.hLE.isEmpty()) {
            return 0;
        }
        return this.hLE.getLast().intValue();
    }

    public boolean bLO() {
        return this.hLE.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hLE;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hLE = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hLM = i;
    }

    public void reset() {
        this.hLE.clear();
        this.hLG = State.PAUSE;
        this.hLE.clear();
        this.hLH = 0.0f;
        this.dsd = 0L;
        this.lastStartTime = 0L;
        this.hLL = 0L;
        this.mProgress = 0;
        this.hLK = 0L;
    }
}
