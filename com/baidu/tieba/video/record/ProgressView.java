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
    private boolean anj;
    private long ckH;
    private a gKj;
    private Paint gKk;
    private Paint gKl;
    private Paint gKm;
    private Paint gKn;
    private Paint gKo;
    private float gKp;
    private float gKq;
    private LinkedList<Integer> gKr;
    private float gKs;
    private volatile State gKt;
    private float gKu;
    private float gKv;
    private float gKw;
    private long gKx;
    private long gKy;
    private long gKz;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uY(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gKr = new LinkedList<>();
        this.gKs = 0.0f;
        this.gKt = State.PAUSE;
        this.anj = true;
        this.gKu = 0.0f;
        this.gKv = 0.0f;
        this.gKw = 0.0f;
        this.gKx = 0L;
        this.lastStartTime = 0L;
        this.gKy = 0L;
        this.gKz = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gKr = new LinkedList<>();
        this.gKs = 0.0f;
        this.gKt = State.PAUSE;
        this.anj = true;
        this.gKu = 0.0f;
        this.gKv = 0.0f;
        this.gKw = 0.0f;
        this.gKx = 0L;
        this.lastStartTime = 0L;
        this.gKy = 0L;
        this.gKz = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gKr = new LinkedList<>();
        this.gKs = 0.0f;
        this.gKt = State.PAUSE;
        this.anj = true;
        this.gKu = 0.0f;
        this.gKv = 0.0f;
        this.gKw = 0.0f;
        this.gKx = 0L;
        this.lastStartTime = 0L;
        this.gKy = 0L;
        this.gKz = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gKk = new Paint();
        this.gKl = new Paint();
        this.gKm = new Paint();
        this.gKo = new Paint();
        this.gKn = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gKk.setStyle(Paint.Style.FILL);
        this.gKk.setColor(Color.parseColor("#33aaff"));
        this.gKl.setStyle(Paint.Style.FILL);
        this.gKl.setColor(Color.rgb(51, 170, (int) MotionEventCompat.ACTION_MASK));
        this.gKm.setStyle(Paint.Style.FILL);
        this.gKm.setColor(Color.parseColor("#FFFFFF"));
        this.gKo.setStyle(Paint.Style.FILL);
        this.gKo.setColor(Color.parseColor("#e53917"));
        this.gKn.setStyle(Paint.Style.FILL);
        this.gKn.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gKs = displayMetrics.widthPixels / 15000.0f;
        this.gKw = this.gKs;
    }

    public void setListener(a aVar) {
        this.gKj = aVar;
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
        if (this.ckH == 0) {
            this.ckH = System.currentTimeMillis();
        }
        if (this.gKz == 0) {
            this.gKz = getHeight();
        }
        this.gKp = (float) this.gKz;
        this.gKq = (float) ((this.gKz * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gKu = 0.0f;
        if (!this.gKr.isEmpty()) {
            Iterator<Integer> it = this.gKr.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gKy = intValue;
                float f = this.gKu;
                this.gKu += ((float) (intValue - j)) * this.gKs;
                float f2 = this.gKu - this.gKq;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gKz - 1), this.gKk);
                canvas.drawRect(f2, 0.0f, this.gKu, (float) (this.gKz - 1), this.gKm);
                j = intValue;
            }
            if (this.gKr.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gKs, 0.0f, this.gKp + (this.gKs * 3000.0f), (float) (this.gKz - 1), this.gKl);
            }
        } else {
            canvas.drawRect(3000.0f * this.gKs, 0.0f, this.gKp + (this.gKs * 3000.0f), (float) (this.gKz - 1), this.gKl);
        }
        if (this.gKt == State.ROLLBACK) {
            canvas.drawRect(this.gKu - (((float) (this.gKy - this.lastStartTime)) * this.gKs), 0.0f, this.gKu, (float) this.gKz, this.gKo);
        }
        if (this.gKt == State.START) {
            this.gKv += this.gKw * ((float) (currentTimeMillis - this.ckH));
            float f3 = this.gKu + this.gKv;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gKu, 0.0f, this.gKv + this.gKu, (float) (this.gKz - 1), this.gKk);
            } else {
                canvas.drawRect(this.gKu, 0.0f, getMeasuredWidth(), (float) (this.gKz - 1), this.gKk);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gKz) + (f3 - 5.0f), (float) (this.gKz - 1), this.gKn);
            if (this.gKj != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gKj.uY(this.mProgress);
                }
            }
        } else {
            if (this.gKj != null) {
                int measuredWidth2 = (int) ((this.gKu / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gKj.uY(this.mProgress);
                }
            }
            if (this.gKx == 0 || currentTimeMillis - this.gKx >= 800) {
                this.anj = !this.anj;
                this.gKx = System.currentTimeMillis();
            }
            if (this.anj) {
                canvas.drawRect(this.gKu - 5.0f, 0.0f, ((float) this.gKz) + (this.gKu - 5.0f), (float) (this.gKz - 1), this.gKn);
            }
        }
        this.ckH = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gKt = state;
        if (state != State.START) {
            this.gKv = this.gKw;
        }
        if (state == State.DELETE && this.gKr != null && !this.gKr.isEmpty()) {
            this.gKr.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gKt;
    }

    public void uX(int i) {
        this.gKr.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gKr == null || this.gKr.isEmpty()) {
            return 0;
        }
        return this.gKr.getLast().intValue();
    }

    public boolean bAJ() {
        return this.gKr.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gKr;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gKr = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gKz = i;
    }

    public void reset() {
        this.gKr.clear();
        this.gKt = State.PAUSE;
        this.gKr.clear();
        this.gKu = 0.0f;
        this.ckH = 0L;
        this.lastStartTime = 0L;
        this.gKy = 0L;
        this.mProgress = 0;
        this.gKx = 0L;
    }
}
