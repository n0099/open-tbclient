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
    private boolean axh;
    private long cSK;
    private a hjf;
    private Paint hjg;
    private Paint hjh;
    private Paint hji;
    private Paint hjj;
    private Paint hjk;
    private float hjl;
    private float hjm;
    private LinkedList<Integer> hjn;
    private float hjo;
    private volatile State hjp;
    private float hjq;
    private float hjr;
    private float hjs;
    private long hjt;
    private long hju;
    private long hjv;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uP(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hjn = new LinkedList<>();
        this.hjo = 0.0f;
        this.hjp = State.PAUSE;
        this.axh = true;
        this.hjq = 0.0f;
        this.hjr = 0.0f;
        this.hjs = 0.0f;
        this.hjt = 0L;
        this.lastStartTime = 0L;
        this.hju = 0L;
        this.hjv = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hjn = new LinkedList<>();
        this.hjo = 0.0f;
        this.hjp = State.PAUSE;
        this.axh = true;
        this.hjq = 0.0f;
        this.hjr = 0.0f;
        this.hjs = 0.0f;
        this.hjt = 0L;
        this.lastStartTime = 0L;
        this.hju = 0L;
        this.hjv = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjn = new LinkedList<>();
        this.hjo = 0.0f;
        this.hjp = State.PAUSE;
        this.axh = true;
        this.hjq = 0.0f;
        this.hjr = 0.0f;
        this.hjs = 0.0f;
        this.hjt = 0L;
        this.lastStartTime = 0L;
        this.hju = 0L;
        this.hjv = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hjg = new Paint();
        this.hjh = new Paint();
        this.hji = new Paint();
        this.hjk = new Paint();
        this.hjj = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hjg.setStyle(Paint.Style.FILL);
        this.hjg.setColor(Color.parseColor("#33aaff"));
        this.hjh.setStyle(Paint.Style.FILL);
        this.hjh.setColor(Color.rgb(51, 170, 255));
        this.hji.setStyle(Paint.Style.FILL);
        this.hji.setColor(Color.parseColor("#FFFFFF"));
        this.hjk.setStyle(Paint.Style.FILL);
        this.hjk.setColor(Color.parseColor("#e53917"));
        this.hjj.setStyle(Paint.Style.FILL);
        this.hjj.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hjo = displayMetrics.widthPixels / 15000.0f;
        this.hjs = this.hjo;
    }

    public void setListener(a aVar) {
        this.hjf = aVar;
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
        if (this.cSK == 0) {
            this.cSK = System.currentTimeMillis();
        }
        if (this.hjv == 0) {
            this.hjv = getHeight();
        }
        this.hjl = (float) this.hjv;
        this.hjm = (float) ((this.hjv * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hjq = 0.0f;
        if (!this.hjn.isEmpty()) {
            Iterator<Integer> it = this.hjn.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hju = intValue;
                float f = this.hjq;
                this.hjq += ((float) (intValue - j)) * this.hjo;
                float f2 = this.hjq - this.hjm;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hjv - 1), this.hjg);
                canvas.drawRect(f2, 0.0f, this.hjq, (float) (this.hjv - 1), this.hji);
                j = intValue;
            }
            if (this.hjn.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hjo, 0.0f, this.hjl + (this.hjo * 3000.0f), (float) (this.hjv - 1), this.hjh);
            }
        } else {
            canvas.drawRect(3000.0f * this.hjo, 0.0f, this.hjl + (this.hjo * 3000.0f), (float) (this.hjv - 1), this.hjh);
        }
        if (this.hjp == State.ROLLBACK) {
            canvas.drawRect(this.hjq - (((float) (this.hju - this.lastStartTime)) * this.hjo), 0.0f, this.hjq, (float) this.hjv, this.hjk);
        }
        if (this.hjp == State.START) {
            this.hjr += this.hjs * ((float) (currentTimeMillis - this.cSK));
            float f3 = this.hjq + this.hjr;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hjq, 0.0f, this.hjr + this.hjq, (float) (this.hjv - 1), this.hjg);
            } else {
                canvas.drawRect(this.hjq, 0.0f, getMeasuredWidth(), (float) (this.hjv - 1), this.hjg);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hjv) + (f3 - 5.0f), (float) (this.hjv - 1), this.hjj);
            if (this.hjf != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hjf.uP(this.mProgress);
                }
            }
        } else {
            if (this.hjf != null) {
                int measuredWidth2 = (int) ((this.hjq / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hjf.uP(this.mProgress);
                }
            }
            if (this.hjt == 0 || currentTimeMillis - this.hjt >= 800) {
                this.axh = !this.axh;
                this.hjt = System.currentTimeMillis();
            }
            if (this.axh) {
                canvas.drawRect(this.hjq - 5.0f, 0.0f, ((float) this.hjv) + (this.hjq - 5.0f), (float) (this.hjv - 1), this.hjj);
            }
        }
        this.cSK = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hjp = state;
        if (state != State.START) {
            this.hjr = this.hjs;
        }
        if (state == State.DELETE && this.hjn != null && !this.hjn.isEmpty()) {
            this.hjn.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hjp;
    }

    public void uO(int i) {
        this.hjn.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hjn == null || this.hjn.isEmpty()) {
            return 0;
        }
        return this.hjn.getLast().intValue();
    }

    public boolean bCK() {
        return this.hjn.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hjn;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hjn = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hjv = i;
    }

    public void reset() {
        this.hjn.clear();
        this.hjp = State.PAUSE;
        this.hjn.clear();
        this.hjq = 0.0f;
        this.cSK = 0L;
        this.lastStartTime = 0L;
        this.hju = 0L;
        this.mProgress = 0;
        this.hjt = 0L;
    }
}
