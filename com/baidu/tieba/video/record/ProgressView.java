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
    private long cHO;
    private Paint ccw;
    private a gRf;
    private Paint gRg;
    private Paint gRh;
    private Paint gRi;
    private Paint gRj;
    private float gRk;
    private float gRl;
    private LinkedList<Integer> gRm;
    private float gRn;
    private volatile State gRo;
    private float gRp;
    private float gRq;
    private float gRr;
    private long gRs;
    private long gRt;
    private long gRu;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uw(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gRm = new LinkedList<>();
        this.gRn = 0.0f;
        this.gRo = State.PAUSE;
        this.aoK = true;
        this.gRp = 0.0f;
        this.gRq = 0.0f;
        this.gRr = 0.0f;
        this.gRs = 0L;
        this.lastStartTime = 0L;
        this.gRt = 0L;
        this.gRu = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gRm = new LinkedList<>();
        this.gRn = 0.0f;
        this.gRo = State.PAUSE;
        this.aoK = true;
        this.gRp = 0.0f;
        this.gRq = 0.0f;
        this.gRr = 0.0f;
        this.gRs = 0L;
        this.lastStartTime = 0L;
        this.gRt = 0L;
        this.gRu = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gRm = new LinkedList<>();
        this.gRn = 0.0f;
        this.gRo = State.PAUSE;
        this.aoK = true;
        this.gRp = 0.0f;
        this.gRq = 0.0f;
        this.gRr = 0.0f;
        this.gRs = 0L;
        this.lastStartTime = 0L;
        this.gRt = 0L;
        this.gRu = 0L;
        init(context);
    }

    private void init(Context context) {
        this.ccw = new Paint();
        this.gRg = new Paint();
        this.gRh = new Paint();
        this.gRj = new Paint();
        this.gRi = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.ccw.setStyle(Paint.Style.FILL);
        this.ccw.setColor(Color.parseColor("#33aaff"));
        this.gRg.setStyle(Paint.Style.FILL);
        this.gRg.setColor(Color.rgb(51, 170, 255));
        this.gRh.setStyle(Paint.Style.FILL);
        this.gRh.setColor(Color.parseColor("#FFFFFF"));
        this.gRj.setStyle(Paint.Style.FILL);
        this.gRj.setColor(Color.parseColor("#e53917"));
        this.gRi.setStyle(Paint.Style.FILL);
        this.gRi.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gRn = displayMetrics.widthPixels / 15000.0f;
        this.gRr = this.gRn;
    }

    public void setListener(a aVar) {
        this.gRf = aVar;
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
        if (this.cHO == 0) {
            this.cHO = System.currentTimeMillis();
        }
        if (this.gRu == 0) {
            this.gRu = getHeight();
        }
        this.gRk = (float) this.gRu;
        this.gRl = (float) ((this.gRu * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gRp = 0.0f;
        if (!this.gRm.isEmpty()) {
            Iterator<Integer> it = this.gRm.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gRt = intValue;
                float f = this.gRp;
                this.gRp += ((float) (intValue - j)) * this.gRn;
                float f2 = this.gRp - this.gRl;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gRu - 1), this.ccw);
                canvas.drawRect(f2, 0.0f, this.gRp, (float) (this.gRu - 1), this.gRh);
                j = intValue;
            }
            if (this.gRm.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gRn, 0.0f, this.gRk + (this.gRn * 3000.0f), (float) (this.gRu - 1), this.gRg);
            }
        } else {
            canvas.drawRect(3000.0f * this.gRn, 0.0f, this.gRk + (this.gRn * 3000.0f), (float) (this.gRu - 1), this.gRg);
        }
        if (this.gRo == State.ROLLBACK) {
            canvas.drawRect(this.gRp - (((float) (this.gRt - this.lastStartTime)) * this.gRn), 0.0f, this.gRp, (float) this.gRu, this.gRj);
        }
        if (this.gRo == State.START) {
            this.gRq += this.gRr * ((float) (currentTimeMillis - this.cHO));
            float f3 = this.gRp + this.gRq;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gRp, 0.0f, this.gRq + this.gRp, (float) (this.gRu - 1), this.ccw);
            } else {
                canvas.drawRect(this.gRp, 0.0f, getMeasuredWidth(), (float) (this.gRu - 1), this.ccw);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gRu) + (f3 - 5.0f), (float) (this.gRu - 1), this.gRi);
            if (this.gRf != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gRf.uw(this.mProgress);
                }
            }
        } else {
            if (this.gRf != null) {
                int measuredWidth2 = (int) ((this.gRp / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gRf.uw(this.mProgress);
                }
            }
            if (this.gRs == 0 || currentTimeMillis - this.gRs >= 800) {
                this.aoK = !this.aoK;
                this.gRs = System.currentTimeMillis();
            }
            if (this.aoK) {
                canvas.drawRect(this.gRp - 5.0f, 0.0f, ((float) this.gRu) + (this.gRp - 5.0f), (float) (this.gRu - 1), this.gRi);
            }
        }
        this.cHO = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gRo = state;
        if (state != State.START) {
            this.gRq = this.gRr;
        }
        if (state == State.DELETE && this.gRm != null && !this.gRm.isEmpty()) {
            this.gRm.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gRo;
    }

    public void uv(int i) {
        this.gRm.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gRm == null || this.gRm.isEmpty()) {
            return 0;
        }
        return this.gRm.getLast().intValue();
    }

    public boolean byu() {
        return this.gRm.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gRm;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gRm = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gRu = i;
    }

    public void reset() {
        this.gRm.clear();
        this.gRo = State.PAUSE;
        this.gRm.clear();
        this.gRp = 0.0f;
        this.cHO = 0L;
        this.lastStartTime = 0L;
        this.gRt = 0L;
        this.mProgress = 0;
        this.gRs = 0L;
    }
}
