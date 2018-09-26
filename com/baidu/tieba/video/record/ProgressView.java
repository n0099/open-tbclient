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
    private boolean aAs;
    private long cYB;
    private a hqU;
    private Paint hqV;
    private Paint hqW;
    private Paint hqX;
    private Paint hqY;
    private Paint hqZ;
    private float hra;
    private float hrb;
    private LinkedList<Integer> hrc;
    private float hrd;
    private volatile State hre;
    private float hrf;
    private float hrg;
    private float hrh;
    private long hri;
    private long hrj;
    private long hrk;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void vp(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hrc = new LinkedList<>();
        this.hrd = 0.0f;
        this.hre = State.PAUSE;
        this.aAs = true;
        this.hrf = 0.0f;
        this.hrg = 0.0f;
        this.hrh = 0.0f;
        this.hri = 0L;
        this.lastStartTime = 0L;
        this.hrj = 0L;
        this.hrk = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hrc = new LinkedList<>();
        this.hrd = 0.0f;
        this.hre = State.PAUSE;
        this.aAs = true;
        this.hrf = 0.0f;
        this.hrg = 0.0f;
        this.hrh = 0.0f;
        this.hri = 0L;
        this.lastStartTime = 0L;
        this.hrj = 0L;
        this.hrk = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hrc = new LinkedList<>();
        this.hrd = 0.0f;
        this.hre = State.PAUSE;
        this.aAs = true;
        this.hrf = 0.0f;
        this.hrg = 0.0f;
        this.hrh = 0.0f;
        this.hri = 0L;
        this.lastStartTime = 0L;
        this.hrj = 0L;
        this.hrk = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hqV = new Paint();
        this.hqW = new Paint();
        this.hqX = new Paint();
        this.hqZ = new Paint();
        this.hqY = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hqV.setStyle(Paint.Style.FILL);
        this.hqV.setColor(Color.parseColor("#33aaff"));
        this.hqW.setStyle(Paint.Style.FILL);
        this.hqW.setColor(Color.rgb(51, 170, 255));
        this.hqX.setStyle(Paint.Style.FILL);
        this.hqX.setColor(Color.parseColor("#FFFFFF"));
        this.hqZ.setStyle(Paint.Style.FILL);
        this.hqZ.setColor(Color.parseColor("#e53917"));
        this.hqY.setStyle(Paint.Style.FILL);
        this.hqY.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hrd = displayMetrics.widthPixels / 15000.0f;
        this.hrh = this.hrd;
    }

    public void setListener(a aVar) {
        this.hqU = aVar;
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
        if (this.cYB == 0) {
            this.cYB = System.currentTimeMillis();
        }
        if (this.hrk == 0) {
            this.hrk = getHeight();
        }
        this.hra = (float) this.hrk;
        this.hrb = (float) ((this.hrk * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hrf = 0.0f;
        if (!this.hrc.isEmpty()) {
            Iterator<Integer> it = this.hrc.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hrj = intValue;
                float f = this.hrf;
                this.hrf += ((float) (intValue - j)) * this.hrd;
                float f2 = this.hrf - this.hrb;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hrk - 1), this.hqV);
                canvas.drawRect(f2, 0.0f, this.hrf, (float) (this.hrk - 1), this.hqX);
                j = intValue;
            }
            if (this.hrc.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hrd, 0.0f, this.hra + (this.hrd * 3000.0f), (float) (this.hrk - 1), this.hqW);
            }
        } else {
            canvas.drawRect(3000.0f * this.hrd, 0.0f, this.hra + (this.hrd * 3000.0f), (float) (this.hrk - 1), this.hqW);
        }
        if (this.hre == State.ROLLBACK) {
            canvas.drawRect(this.hrf - (((float) (this.hrj - this.lastStartTime)) * this.hrd), 0.0f, this.hrf, (float) this.hrk, this.hqZ);
        }
        if (this.hre == State.START) {
            this.hrg += this.hrh * ((float) (currentTimeMillis - this.cYB));
            float f3 = this.hrf + this.hrg;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hrf, 0.0f, this.hrg + this.hrf, (float) (this.hrk - 1), this.hqV);
            } else {
                canvas.drawRect(this.hrf, 0.0f, getMeasuredWidth(), (float) (this.hrk - 1), this.hqV);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hrk) + (f3 - 5.0f), (float) (this.hrk - 1), this.hqY);
            if (this.hqU != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hqU.vp(this.mProgress);
                }
            }
        } else {
            if (this.hqU != null) {
                int measuredWidth2 = (int) ((this.hrf / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hqU.vp(this.mProgress);
                }
            }
            if (this.hri == 0 || currentTimeMillis - this.hri >= 800) {
                this.aAs = !this.aAs;
                this.hri = System.currentTimeMillis();
            }
            if (this.aAs) {
                canvas.drawRect(this.hrf - 5.0f, 0.0f, ((float) this.hrk) + (this.hrf - 5.0f), (float) (this.hrk - 1), this.hqY);
            }
        }
        this.cYB = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hre = state;
        if (state != State.START) {
            this.hrg = this.hrh;
        }
        if (state == State.DELETE && this.hrc != null && !this.hrc.isEmpty()) {
            this.hrc.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hre;
    }

    public void vo(int i) {
        this.hrc.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hrc == null || this.hrc.isEmpty()) {
            return 0;
        }
        return this.hrc.getLast().intValue();
    }

    public boolean bFz() {
        return this.hrc.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hrc;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hrc = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hrk = i;
    }

    public void reset() {
        this.hrc.clear();
        this.hre = State.PAUSE;
        this.hrc.clear();
        this.hrf = 0.0f;
        this.cYB = 0L;
        this.lastStartTime = 0L;
        this.hrj = 0L;
        this.mProgress = 0;
        this.hri = 0L;
    }
}
