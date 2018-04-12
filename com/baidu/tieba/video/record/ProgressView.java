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
    private boolean aoK;
    private long cHR;
    private Paint ccz;
    private a gRi;
    private Paint gRj;
    private Paint gRk;
    private Paint gRl;
    private Paint gRm;
    private float gRn;
    private float gRo;
    private LinkedList<Integer> gRp;
    private float gRq;
    private volatile State gRr;
    private float gRs;
    private float gRt;
    private float gRu;
    private long gRv;
    private long gRw;
    private long gRx;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void ux(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gRp = new LinkedList<>();
        this.gRq = 0.0f;
        this.gRr = State.PAUSE;
        this.aoK = true;
        this.gRs = 0.0f;
        this.gRt = 0.0f;
        this.gRu = 0.0f;
        this.gRv = 0L;
        this.lastStartTime = 0L;
        this.gRw = 0L;
        this.gRx = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gRp = new LinkedList<>();
        this.gRq = 0.0f;
        this.gRr = State.PAUSE;
        this.aoK = true;
        this.gRs = 0.0f;
        this.gRt = 0.0f;
        this.gRu = 0.0f;
        this.gRv = 0L;
        this.lastStartTime = 0L;
        this.gRw = 0L;
        this.gRx = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gRp = new LinkedList<>();
        this.gRq = 0.0f;
        this.gRr = State.PAUSE;
        this.aoK = true;
        this.gRs = 0.0f;
        this.gRt = 0.0f;
        this.gRu = 0.0f;
        this.gRv = 0L;
        this.lastStartTime = 0L;
        this.gRw = 0L;
        this.gRx = 0L;
        init(context);
    }

    private void init(Context context) {
        this.ccz = new Paint();
        this.gRj = new Paint();
        this.gRk = new Paint();
        this.gRm = new Paint();
        this.gRl = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.ccz.setStyle(Paint.Style.FILL);
        this.ccz.setColor(Color.parseColor("#33aaff"));
        this.gRj.setStyle(Paint.Style.FILL);
        this.gRj.setColor(Color.rgb(51, 170, 255));
        this.gRk.setStyle(Paint.Style.FILL);
        this.gRk.setColor(Color.parseColor("#FFFFFF"));
        this.gRm.setStyle(Paint.Style.FILL);
        this.gRm.setColor(Color.parseColor("#e53917"));
        this.gRl.setStyle(Paint.Style.FILL);
        this.gRl.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gRq = displayMetrics.widthPixels / 15000.0f;
        this.gRu = this.gRq;
    }

    public void setListener(a aVar) {
        this.gRi = aVar;
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
        if (this.cHR == 0) {
            this.cHR = System.currentTimeMillis();
        }
        if (this.gRx == 0) {
            this.gRx = getHeight();
        }
        this.gRn = (float) this.gRx;
        this.gRo = (float) ((this.gRx * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gRs = 0.0f;
        if (!this.gRp.isEmpty()) {
            Iterator<Integer> it = this.gRp.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gRw = intValue;
                float f = this.gRs;
                this.gRs += ((float) (intValue - j)) * this.gRq;
                float f2 = this.gRs - this.gRo;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gRx - 1), this.ccz);
                canvas.drawRect(f2, 0.0f, this.gRs, (float) (this.gRx - 1), this.gRk);
                j = intValue;
            }
            if (this.gRp.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gRq, 0.0f, this.gRn + (this.gRq * 3000.0f), (float) (this.gRx - 1), this.gRj);
            }
        } else {
            canvas.drawRect(3000.0f * this.gRq, 0.0f, this.gRn + (this.gRq * 3000.0f), (float) (this.gRx - 1), this.gRj);
        }
        if (this.gRr == State.ROLLBACK) {
            canvas.drawRect(this.gRs - (((float) (this.gRw - this.lastStartTime)) * this.gRq), 0.0f, this.gRs, (float) this.gRx, this.gRm);
        }
        if (this.gRr == State.START) {
            this.gRt += this.gRu * ((float) (currentTimeMillis - this.cHR));
            float f3 = this.gRs + this.gRt;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gRs, 0.0f, this.gRt + this.gRs, (float) (this.gRx - 1), this.ccz);
            } else {
                canvas.drawRect(this.gRs, 0.0f, getMeasuredWidth(), (float) (this.gRx - 1), this.ccz);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gRx) + (f3 - 5.0f), (float) (this.gRx - 1), this.gRl);
            if (this.gRi != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gRi.ux(this.mProgress);
                }
            }
        } else {
            if (this.gRi != null) {
                int measuredWidth2 = (int) ((this.gRs / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gRi.ux(this.mProgress);
                }
            }
            if (this.gRv == 0 || currentTimeMillis - this.gRv >= 800) {
                this.aoK = !this.aoK;
                this.gRv = System.currentTimeMillis();
            }
            if (this.aoK) {
                canvas.drawRect(this.gRs - 5.0f, 0.0f, ((float) this.gRx) + (this.gRs - 5.0f), (float) (this.gRx - 1), this.gRl);
            }
        }
        this.cHR = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gRr = state;
        if (state != State.START) {
            this.gRt = this.gRu;
        }
        if (state == State.DELETE && this.gRp != null && !this.gRp.isEmpty()) {
            this.gRp.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gRr;
    }

    public void uw(int i) {
        this.gRp.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gRp == null || this.gRp.isEmpty()) {
            return 0;
        }
        return this.gRp.getLast().intValue();
    }

    public boolean byu() {
        return this.gRp.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gRp;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gRp = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gRx = i;
    }

    public void reset() {
        this.gRp.clear();
        this.gRr = State.PAUSE;
        this.gRp.clear();
        this.gRs = 0.0f;
        this.cHR = 0L;
        this.lastStartTime = 0L;
        this.gRw = 0L;
        this.mProgress = 0;
        this.gRv = 0L;
    }
}
