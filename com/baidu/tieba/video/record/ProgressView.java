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
    private boolean axk;
    private long cSN;
    private a hje;
    private Paint hjf;
    private Paint hjg;
    private Paint hjh;
    private Paint hji;
    private Paint hjj;
    private float hjk;
    private float hjl;
    private LinkedList<Integer> hjm;
    private float hjn;
    private volatile State hjo;
    private float hjp;
    private float hjq;
    private float hjr;
    private long hjs;
    private long hjt;
    private long hju;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uP(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hjm = new LinkedList<>();
        this.hjn = 0.0f;
        this.hjo = State.PAUSE;
        this.axk = true;
        this.hjp = 0.0f;
        this.hjq = 0.0f;
        this.hjr = 0.0f;
        this.hjs = 0L;
        this.lastStartTime = 0L;
        this.hjt = 0L;
        this.hju = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hjm = new LinkedList<>();
        this.hjn = 0.0f;
        this.hjo = State.PAUSE;
        this.axk = true;
        this.hjp = 0.0f;
        this.hjq = 0.0f;
        this.hjr = 0.0f;
        this.hjs = 0L;
        this.lastStartTime = 0L;
        this.hjt = 0L;
        this.hju = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hjm = new LinkedList<>();
        this.hjn = 0.0f;
        this.hjo = State.PAUSE;
        this.axk = true;
        this.hjp = 0.0f;
        this.hjq = 0.0f;
        this.hjr = 0.0f;
        this.hjs = 0L;
        this.lastStartTime = 0L;
        this.hjt = 0L;
        this.hju = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hjf = new Paint();
        this.hjg = new Paint();
        this.hjh = new Paint();
        this.hjj = new Paint();
        this.hji = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hjf.setStyle(Paint.Style.FILL);
        this.hjf.setColor(Color.parseColor("#33aaff"));
        this.hjg.setStyle(Paint.Style.FILL);
        this.hjg.setColor(Color.rgb(51, 170, 255));
        this.hjh.setStyle(Paint.Style.FILL);
        this.hjh.setColor(Color.parseColor("#FFFFFF"));
        this.hjj.setStyle(Paint.Style.FILL);
        this.hjj.setColor(Color.parseColor("#e53917"));
        this.hji.setStyle(Paint.Style.FILL);
        this.hji.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hjn = displayMetrics.widthPixels / 15000.0f;
        this.hjr = this.hjn;
    }

    public void setListener(a aVar) {
        this.hje = aVar;
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
        if (this.cSN == 0) {
            this.cSN = System.currentTimeMillis();
        }
        if (this.hju == 0) {
            this.hju = getHeight();
        }
        this.hjk = (float) this.hju;
        this.hjl = (float) ((this.hju * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hjp = 0.0f;
        if (!this.hjm.isEmpty()) {
            Iterator<Integer> it = this.hjm.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hjt = intValue;
                float f = this.hjp;
                this.hjp += ((float) (intValue - j)) * this.hjn;
                float f2 = this.hjp - this.hjl;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hju - 1), this.hjf);
                canvas.drawRect(f2, 0.0f, this.hjp, (float) (this.hju - 1), this.hjh);
                j = intValue;
            }
            if (this.hjm.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hjn, 0.0f, this.hjk + (this.hjn * 3000.0f), (float) (this.hju - 1), this.hjg);
            }
        } else {
            canvas.drawRect(3000.0f * this.hjn, 0.0f, this.hjk + (this.hjn * 3000.0f), (float) (this.hju - 1), this.hjg);
        }
        if (this.hjo == State.ROLLBACK) {
            canvas.drawRect(this.hjp - (((float) (this.hjt - this.lastStartTime)) * this.hjn), 0.0f, this.hjp, (float) this.hju, this.hjj);
        }
        if (this.hjo == State.START) {
            this.hjq += this.hjr * ((float) (currentTimeMillis - this.cSN));
            float f3 = this.hjp + this.hjq;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hjp, 0.0f, this.hjq + this.hjp, (float) (this.hju - 1), this.hjf);
            } else {
                canvas.drawRect(this.hjp, 0.0f, getMeasuredWidth(), (float) (this.hju - 1), this.hjf);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hju) + (f3 - 5.0f), (float) (this.hju - 1), this.hji);
            if (this.hje != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hje.uP(this.mProgress);
                }
            }
        } else {
            if (this.hje != null) {
                int measuredWidth2 = (int) ((this.hjp / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hje.uP(this.mProgress);
                }
            }
            if (this.hjs == 0 || currentTimeMillis - this.hjs >= 800) {
                this.axk = !this.axk;
                this.hjs = System.currentTimeMillis();
            }
            if (this.axk) {
                canvas.drawRect(this.hjp - 5.0f, 0.0f, ((float) this.hju) + (this.hjp - 5.0f), (float) (this.hju - 1), this.hji);
            }
        }
        this.cSN = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hjo = state;
        if (state != State.START) {
            this.hjq = this.hjr;
        }
        if (state == State.DELETE && this.hjm != null && !this.hjm.isEmpty()) {
            this.hjm.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hjo;
    }

    public void uO(int i) {
        this.hjm.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hjm == null || this.hjm.isEmpty()) {
            return 0;
        }
        return this.hjm.getLast().intValue();
    }

    public boolean bCI() {
        return this.hjm.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hjm;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hjm = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hju = i;
    }

    public void reset() {
        this.hjm.clear();
        this.hjo = State.PAUSE;
        this.hjm.clear();
        this.hjp = 0.0f;
        this.cSN = 0L;
        this.lastStartTime = 0L;
        this.hjt = 0L;
        this.mProgress = 0;
        this.hjs = 0L;
    }
}
