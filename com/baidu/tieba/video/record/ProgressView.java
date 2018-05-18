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
    private long cIX;
    private Paint cds;
    private a gSj;
    private Paint gSk;
    private Paint gSl;
    private Paint gSm;
    private Paint gSn;
    private float gSo;
    private float gSp;
    private LinkedList<Integer> gSq;
    private float gSr;
    private volatile State gSs;
    private float gSt;
    private float gSu;
    private float gSv;
    private long gSw;
    private long gSx;
    private long gSy;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uv(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gSq = new LinkedList<>();
        this.gSr = 0.0f;
        this.gSs = State.PAUSE;
        this.aoK = true;
        this.gSt = 0.0f;
        this.gSu = 0.0f;
        this.gSv = 0.0f;
        this.gSw = 0L;
        this.lastStartTime = 0L;
        this.gSx = 0L;
        this.gSy = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gSq = new LinkedList<>();
        this.gSr = 0.0f;
        this.gSs = State.PAUSE;
        this.aoK = true;
        this.gSt = 0.0f;
        this.gSu = 0.0f;
        this.gSv = 0.0f;
        this.gSw = 0L;
        this.lastStartTime = 0L;
        this.gSx = 0L;
        this.gSy = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gSq = new LinkedList<>();
        this.gSr = 0.0f;
        this.gSs = State.PAUSE;
        this.aoK = true;
        this.gSt = 0.0f;
        this.gSu = 0.0f;
        this.gSv = 0.0f;
        this.gSw = 0L;
        this.lastStartTime = 0L;
        this.gSx = 0L;
        this.gSy = 0L;
        init(context);
    }

    private void init(Context context) {
        this.cds = new Paint();
        this.gSk = new Paint();
        this.gSl = new Paint();
        this.gSn = new Paint();
        this.gSm = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.cds.setStyle(Paint.Style.FILL);
        this.cds.setColor(Color.parseColor("#33aaff"));
        this.gSk.setStyle(Paint.Style.FILL);
        this.gSk.setColor(Color.rgb(51, 170, 255));
        this.gSl.setStyle(Paint.Style.FILL);
        this.gSl.setColor(Color.parseColor("#FFFFFF"));
        this.gSn.setStyle(Paint.Style.FILL);
        this.gSn.setColor(Color.parseColor("#e53917"));
        this.gSm.setStyle(Paint.Style.FILL);
        this.gSm.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gSr = displayMetrics.widthPixels / 15000.0f;
        this.gSv = this.gSr;
    }

    public void setListener(a aVar) {
        this.gSj = aVar;
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
        if (this.cIX == 0) {
            this.cIX = System.currentTimeMillis();
        }
        if (this.gSy == 0) {
            this.gSy = getHeight();
        }
        this.gSo = (float) this.gSy;
        this.gSp = (float) ((this.gSy * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gSt = 0.0f;
        if (!this.gSq.isEmpty()) {
            Iterator<Integer> it = this.gSq.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gSx = intValue;
                float f = this.gSt;
                this.gSt += ((float) (intValue - j)) * this.gSr;
                float f2 = this.gSt - this.gSp;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gSy - 1), this.cds);
                canvas.drawRect(f2, 0.0f, this.gSt, (float) (this.gSy - 1), this.gSl);
                j = intValue;
            }
            if (this.gSq.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gSr, 0.0f, this.gSo + (this.gSr * 3000.0f), (float) (this.gSy - 1), this.gSk);
            }
        } else {
            canvas.drawRect(3000.0f * this.gSr, 0.0f, this.gSo + (this.gSr * 3000.0f), (float) (this.gSy - 1), this.gSk);
        }
        if (this.gSs == State.ROLLBACK) {
            canvas.drawRect(this.gSt - (((float) (this.gSx - this.lastStartTime)) * this.gSr), 0.0f, this.gSt, (float) this.gSy, this.gSn);
        }
        if (this.gSs == State.START) {
            this.gSu += this.gSv * ((float) (currentTimeMillis - this.cIX));
            float f3 = this.gSt + this.gSu;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gSt, 0.0f, this.gSu + this.gSt, (float) (this.gSy - 1), this.cds);
            } else {
                canvas.drawRect(this.gSt, 0.0f, getMeasuredWidth(), (float) (this.gSy - 1), this.cds);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gSy) + (f3 - 5.0f), (float) (this.gSy - 1), this.gSm);
            if (this.gSj != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gSj.uv(this.mProgress);
                }
            }
        } else {
            if (this.gSj != null) {
                int measuredWidth2 = (int) ((this.gSt / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gSj.uv(this.mProgress);
                }
            }
            if (this.gSw == 0 || currentTimeMillis - this.gSw >= 800) {
                this.aoK = !this.aoK;
                this.gSw = System.currentTimeMillis();
            }
            if (this.aoK) {
                canvas.drawRect(this.gSt - 5.0f, 0.0f, ((float) this.gSy) + (this.gSt - 5.0f), (float) (this.gSy - 1), this.gSm);
            }
        }
        this.cIX = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gSs = state;
        if (state != State.START) {
            this.gSu = this.gSv;
        }
        if (state == State.DELETE && this.gSq != null && !this.gSq.isEmpty()) {
            this.gSq.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gSs;
    }

    public void uu(int i) {
        this.gSq.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gSq == null || this.gSq.isEmpty()) {
            return 0;
        }
        return this.gSq.getLast().intValue();
    }

    public boolean bys() {
        return this.gSq.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gSq;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gSq = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gSy = i;
    }

    public void reset() {
        this.gSq.clear();
        this.gSs = State.PAUSE;
        this.gSq.clear();
        this.gSt = 0.0f;
        this.cIX = 0L;
        this.lastStartTime = 0L;
        this.gSx = 0L;
        this.mProgress = 0;
        this.gSw = 0L;
    }
}
