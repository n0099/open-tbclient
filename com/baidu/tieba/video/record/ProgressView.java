package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ProgressView extends View {
    private boolean ank;
    private long cko;
    private a gJb;
    private Paint gJc;
    private Paint gJd;
    private Paint gJe;
    private Paint gJf;
    private Paint gJg;
    private float gJh;
    private float gJi;
    private LinkedList<Integer> gJj;
    private float gJk;
    private volatile State gJl;
    private float gJm;
    private float gJn;
    private float gJo;
    private long gJp;
    private long gJq;
    private long gJr;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uU(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gJj = new LinkedList<>();
        this.gJk = 0.0f;
        this.gJl = State.PAUSE;
        this.ank = true;
        this.gJm = 0.0f;
        this.gJn = 0.0f;
        this.gJo = 0.0f;
        this.gJp = 0L;
        this.lastStartTime = 0L;
        this.gJq = 0L;
        this.gJr = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJj = new LinkedList<>();
        this.gJk = 0.0f;
        this.gJl = State.PAUSE;
        this.ank = true;
        this.gJm = 0.0f;
        this.gJn = 0.0f;
        this.gJo = 0.0f;
        this.gJp = 0L;
        this.lastStartTime = 0L;
        this.gJq = 0L;
        this.gJr = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gJj = new LinkedList<>();
        this.gJk = 0.0f;
        this.gJl = State.PAUSE;
        this.ank = true;
        this.gJm = 0.0f;
        this.gJn = 0.0f;
        this.gJo = 0.0f;
        this.gJp = 0L;
        this.lastStartTime = 0L;
        this.gJq = 0L;
        this.gJr = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gJc = new Paint();
        this.gJd = new Paint();
        this.gJe = new Paint();
        this.gJg = new Paint();
        this.gJf = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gJc.setStyle(Paint.Style.FILL);
        this.gJc.setColor(Color.parseColor("#33aaff"));
        this.gJd.setStyle(Paint.Style.FILL);
        this.gJd.setColor(Color.rgb(51, 170, (int) MotionEventCompat.ACTION_MASK));
        this.gJe.setStyle(Paint.Style.FILL);
        this.gJe.setColor(Color.parseColor("#FFFFFF"));
        this.gJg.setStyle(Paint.Style.FILL);
        this.gJg.setColor(Color.parseColor("#e53917"));
        this.gJf.setStyle(Paint.Style.FILL);
        this.gJf.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gJk = displayMetrics.widthPixels / 15000.0f;
        this.gJo = this.gJk;
    }

    public void setListener(a aVar) {
        this.gJb = aVar;
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
        if (this.cko == 0) {
            this.cko = System.currentTimeMillis();
        }
        if (this.gJr == 0) {
            this.gJr = getHeight();
        }
        this.gJh = (float) this.gJr;
        this.gJi = (float) ((this.gJr * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gJm = 0.0f;
        if (!this.gJj.isEmpty()) {
            Iterator<Integer> it = this.gJj.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gJq = intValue;
                float f = this.gJm;
                this.gJm += ((float) (intValue - j)) * this.gJk;
                float f2 = this.gJm - this.gJi;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gJr - 1), this.gJc);
                canvas.drawRect(f2, 0.0f, this.gJm, (float) (this.gJr - 1), this.gJe);
                j = intValue;
            }
            if (this.gJj.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gJk, 0.0f, this.gJh + (this.gJk * 3000.0f), (float) (this.gJr - 1), this.gJd);
            }
        } else {
            canvas.drawRect(3000.0f * this.gJk, 0.0f, this.gJh + (this.gJk * 3000.0f), (float) (this.gJr - 1), this.gJd);
        }
        if (this.gJl == State.ROLLBACK) {
            canvas.drawRect(this.gJm - (((float) (this.gJq - this.lastStartTime)) * this.gJk), 0.0f, this.gJm, (float) this.gJr, this.gJg);
        }
        if (this.gJl == State.START) {
            this.gJn += this.gJo * ((float) (currentTimeMillis - this.cko));
            float f3 = this.gJm + this.gJn;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gJm, 0.0f, this.gJn + this.gJm, (float) (this.gJr - 1), this.gJc);
            } else {
                canvas.drawRect(this.gJm, 0.0f, getMeasuredWidth(), (float) (this.gJr - 1), this.gJc);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gJr) + (f3 - 5.0f), (float) (this.gJr - 1), this.gJf);
            if (this.gJb != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gJb.uU(this.mProgress);
                }
            }
        } else {
            if (this.gJb != null) {
                int measuredWidth2 = (int) ((this.gJm / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gJb.uU(this.mProgress);
                }
            }
            if (this.gJp == 0 || currentTimeMillis - this.gJp >= 800) {
                this.ank = !this.ank;
                this.gJp = System.currentTimeMillis();
            }
            if (this.ank) {
                canvas.drawRect(this.gJm - 5.0f, 0.0f, ((float) this.gJr) + (this.gJm - 5.0f), (float) (this.gJr - 1), this.gJf);
            }
        }
        this.cko = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gJl = state;
        if (state != State.START) {
            this.gJn = this.gJo;
        }
        if (state == State.DELETE && this.gJj != null && !this.gJj.isEmpty()) {
            this.gJj.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gJl;
    }

    public void uT(int i) {
        this.gJj.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gJj == null || this.gJj.isEmpty()) {
            return 0;
        }
        return this.gJj.getLast().intValue();
    }

    public boolean bAx() {
        return this.gJj.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gJj;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gJj = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gJr = i;
    }

    public void reset() {
        this.gJj.clear();
        this.gJl = State.PAUSE;
        this.gJj.clear();
        this.gJm = 0.0f;
        this.cko = 0L;
        this.lastStartTime = 0L;
        this.gJq = 0L;
        this.mProgress = 0;
        this.gJp = 0L;
    }
}
