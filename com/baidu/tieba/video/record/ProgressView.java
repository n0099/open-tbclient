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
    private boolean aFQ;
    private long dhW;
    private LinkedList<Integer> hAa;
    private float hAb;
    private volatile State hAc;
    private float hAd;
    private float hAe;
    private float hAf;
    private long hAg;
    private long hAh;
    private long hAi;
    private a hzS;
    private Paint hzT;
    private Paint hzU;
    private Paint hzV;
    private Paint hzW;
    private Paint hzX;
    private float hzY;
    private float hzZ;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void wf(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hAa = new LinkedList<>();
        this.hAb = 0.0f;
        this.hAc = State.PAUSE;
        this.aFQ = true;
        this.hAd = 0.0f;
        this.hAe = 0.0f;
        this.hAf = 0.0f;
        this.hAg = 0L;
        this.lastStartTime = 0L;
        this.hAh = 0L;
        this.hAi = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hAa = new LinkedList<>();
        this.hAb = 0.0f;
        this.hAc = State.PAUSE;
        this.aFQ = true;
        this.hAd = 0.0f;
        this.hAe = 0.0f;
        this.hAf = 0.0f;
        this.hAg = 0L;
        this.lastStartTime = 0L;
        this.hAh = 0L;
        this.hAi = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hAa = new LinkedList<>();
        this.hAb = 0.0f;
        this.hAc = State.PAUSE;
        this.aFQ = true;
        this.hAd = 0.0f;
        this.hAe = 0.0f;
        this.hAf = 0.0f;
        this.hAg = 0L;
        this.lastStartTime = 0L;
        this.hAh = 0L;
        this.hAi = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hzT = new Paint();
        this.hzU = new Paint();
        this.hzV = new Paint();
        this.hzX = new Paint();
        this.hzW = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hzT.setStyle(Paint.Style.FILL);
        this.hzT.setColor(Color.parseColor("#33aaff"));
        this.hzU.setStyle(Paint.Style.FILL);
        this.hzU.setColor(Color.rgb(51, 170, 255));
        this.hzV.setStyle(Paint.Style.FILL);
        this.hzV.setColor(Color.parseColor("#FFFFFF"));
        this.hzX.setStyle(Paint.Style.FILL);
        this.hzX.setColor(Color.parseColor("#e53917"));
        this.hzW.setStyle(Paint.Style.FILL);
        this.hzW.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hAb = displayMetrics.widthPixels / 15000.0f;
        this.hAf = this.hAb;
    }

    public void setListener(a aVar) {
        this.hzS = aVar;
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
        if (this.dhW == 0) {
            this.dhW = System.currentTimeMillis();
        }
        if (this.hAi == 0) {
            this.hAi = getHeight();
        }
        this.hzY = (float) this.hAi;
        this.hzZ = (float) ((this.hAi * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hAd = 0.0f;
        if (!this.hAa.isEmpty()) {
            Iterator<Integer> it = this.hAa.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hAh = intValue;
                float f = this.hAd;
                this.hAd += ((float) (intValue - j)) * this.hAb;
                float f2 = this.hAd - this.hzZ;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hAi - 1), this.hzT);
                canvas.drawRect(f2, 0.0f, this.hAd, (float) (this.hAi - 1), this.hzV);
                j = intValue;
            }
            if (this.hAa.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hAb, 0.0f, this.hzY + (this.hAb * 3000.0f), (float) (this.hAi - 1), this.hzU);
            }
        } else {
            canvas.drawRect(3000.0f * this.hAb, 0.0f, this.hzY + (this.hAb * 3000.0f), (float) (this.hAi - 1), this.hzU);
        }
        if (this.hAc == State.ROLLBACK) {
            canvas.drawRect(this.hAd - (((float) (this.hAh - this.lastStartTime)) * this.hAb), 0.0f, this.hAd, (float) this.hAi, this.hzX);
        }
        if (this.hAc == State.START) {
            this.hAe += this.hAf * ((float) (currentTimeMillis - this.dhW));
            float f3 = this.hAd + this.hAe;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hAd, 0.0f, this.hAe + this.hAd, (float) (this.hAi - 1), this.hzT);
            } else {
                canvas.drawRect(this.hAd, 0.0f, getMeasuredWidth(), (float) (this.hAi - 1), this.hzT);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hAi) + (f3 - 5.0f), (float) (this.hAi - 1), this.hzW);
            if (this.hzS != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hzS.wf(this.mProgress);
                }
            }
        } else {
            if (this.hzS != null) {
                int measuredWidth2 = (int) ((this.hAd / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hzS.wf(this.mProgress);
                }
            }
            if (this.hAg == 0 || currentTimeMillis - this.hAg >= 800) {
                this.aFQ = !this.aFQ;
                this.hAg = System.currentTimeMillis();
            }
            if (this.aFQ) {
                canvas.drawRect(this.hAd - 5.0f, 0.0f, ((float) this.hAi) + (this.hAd - 5.0f), (float) (this.hAi - 1), this.hzW);
            }
        }
        this.dhW = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hAc = state;
        if (state != State.START) {
            this.hAe = this.hAf;
        }
        if (state == State.DELETE && this.hAa != null && !this.hAa.isEmpty()) {
            this.hAa.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hAc;
    }

    public void we(int i) {
        this.hAa.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hAa == null || this.hAa.isEmpty()) {
            return 0;
        }
        return this.hAa.getLast().intValue();
    }

    public boolean bIl() {
        return this.hAa.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hAa;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hAa = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hAi = i;
    }

    public void reset() {
        this.hAa.clear();
        this.hAc = State.PAUSE;
        this.hAa.clear();
        this.hAd = 0.0f;
        this.dhW = 0L;
        this.lastStartTime = 0L;
        this.hAh = 0L;
        this.mProgress = 0;
        this.hAg = 0L;
    }
}
