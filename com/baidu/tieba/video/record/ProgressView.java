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
    private boolean aJq;
    private long doE;
    private a hHe;
    private Paint hHf;
    private Paint hHg;
    private Paint hHh;
    private Paint hHi;
    private Paint hHj;
    private float hHk;
    private float hHl;
    private LinkedList<Integer> hHm;
    private float hHn;
    private volatile State hHo;
    private float hHp;
    private float hHq;
    private float hHr;
    private long hHs;
    private long hHt;
    private long hHu;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void wC(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hHm = new LinkedList<>();
        this.hHn = 0.0f;
        this.hHo = State.PAUSE;
        this.aJq = true;
        this.hHp = 0.0f;
        this.hHq = 0.0f;
        this.hHr = 0.0f;
        this.hHs = 0L;
        this.lastStartTime = 0L;
        this.hHt = 0L;
        this.hHu = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hHm = new LinkedList<>();
        this.hHn = 0.0f;
        this.hHo = State.PAUSE;
        this.aJq = true;
        this.hHp = 0.0f;
        this.hHq = 0.0f;
        this.hHr = 0.0f;
        this.hHs = 0L;
        this.lastStartTime = 0L;
        this.hHt = 0L;
        this.hHu = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hHm = new LinkedList<>();
        this.hHn = 0.0f;
        this.hHo = State.PAUSE;
        this.aJq = true;
        this.hHp = 0.0f;
        this.hHq = 0.0f;
        this.hHr = 0.0f;
        this.hHs = 0L;
        this.lastStartTime = 0L;
        this.hHt = 0L;
        this.hHu = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hHf = new Paint();
        this.hHg = new Paint();
        this.hHh = new Paint();
        this.hHj = new Paint();
        this.hHi = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hHf.setStyle(Paint.Style.FILL);
        this.hHf.setColor(Color.parseColor("#33aaff"));
        this.hHg.setStyle(Paint.Style.FILL);
        this.hHg.setColor(Color.rgb(51, 170, 255));
        this.hHh.setStyle(Paint.Style.FILL);
        this.hHh.setColor(Color.parseColor("#FFFFFF"));
        this.hHj.setStyle(Paint.Style.FILL);
        this.hHj.setColor(Color.parseColor("#e53917"));
        this.hHi.setStyle(Paint.Style.FILL);
        this.hHi.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hHn = displayMetrics.widthPixels / 15000.0f;
        this.hHr = this.hHn;
    }

    public void setListener(a aVar) {
        this.hHe = aVar;
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
        if (this.doE == 0) {
            this.doE = System.currentTimeMillis();
        }
        if (this.hHu == 0) {
            this.hHu = getHeight();
        }
        this.hHk = (float) this.hHu;
        this.hHl = (float) ((this.hHu * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hHp = 0.0f;
        if (!this.hHm.isEmpty()) {
            Iterator<Integer> it = this.hHm.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hHt = intValue;
                float f = this.hHp;
                this.hHp += ((float) (intValue - j)) * this.hHn;
                float f2 = this.hHp - this.hHl;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hHu - 1), this.hHf);
                canvas.drawRect(f2, 0.0f, this.hHp, (float) (this.hHu - 1), this.hHh);
                j = intValue;
            }
            if (this.hHm.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hHn, 0.0f, this.hHk + (this.hHn * 3000.0f), (float) (this.hHu - 1), this.hHg);
            }
        } else {
            canvas.drawRect(3000.0f * this.hHn, 0.0f, this.hHk + (this.hHn * 3000.0f), (float) (this.hHu - 1), this.hHg);
        }
        if (this.hHo == State.ROLLBACK) {
            canvas.drawRect(this.hHp - (((float) (this.hHt - this.lastStartTime)) * this.hHn), 0.0f, this.hHp, (float) this.hHu, this.hHj);
        }
        if (this.hHo == State.START) {
            this.hHq += this.hHr * ((float) (currentTimeMillis - this.doE));
            float f3 = this.hHp + this.hHq;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hHp, 0.0f, this.hHq + this.hHp, (float) (this.hHu - 1), this.hHf);
            } else {
                canvas.drawRect(this.hHp, 0.0f, getMeasuredWidth(), (float) (this.hHu - 1), this.hHf);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hHu) + (f3 - 5.0f), (float) (this.hHu - 1), this.hHi);
            if (this.hHe != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hHe.wC(this.mProgress);
                }
            }
        } else {
            if (this.hHe != null) {
                int measuredWidth2 = (int) ((this.hHp / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hHe.wC(this.mProgress);
                }
            }
            if (this.hHs == 0 || currentTimeMillis - this.hHs >= 800) {
                this.aJq = !this.aJq;
                this.hHs = System.currentTimeMillis();
            }
            if (this.aJq) {
                canvas.drawRect(this.hHp - 5.0f, 0.0f, ((float) this.hHu) + (this.hHp - 5.0f), (float) (this.hHu - 1), this.hHi);
            }
        }
        this.doE = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hHo = state;
        if (state != State.START) {
            this.hHq = this.hHr;
        }
        if (state == State.DELETE && this.hHm != null && !this.hHm.isEmpty()) {
            this.hHm.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hHo;
    }

    public void wB(int i) {
        this.hHm.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hHm == null || this.hHm.isEmpty()) {
            return 0;
        }
        return this.hHm.getLast().intValue();
    }

    public boolean bKp() {
        return this.hHm.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hHm;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hHm = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hHu = i;
    }

    public void reset() {
        this.hHm.clear();
        this.hHo = State.PAUSE;
        this.hHm.clear();
        this.hHp = 0.0f;
        this.doE = 0L;
        this.lastStartTime = 0L;
        this.hHt = 0L;
        this.mProgress = 0;
        this.hHs = 0L;
    }
}
