package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class ProgressView extends View {
    private Paint heA;
    private long iDg;
    private boolean isVisible;
    private long lastStartTime;
    private int mProgress;
    private a nGX;
    private Paint nGY;
    private Paint nGZ;
    private Paint nHa;
    private Paint nHb;
    private float nHc;
    private float nHd;
    private LinkedList<Integer> nHe;
    private float nHf;
    private volatile State nHg;
    private float nHh;
    private float nHi;
    private float nHj;
    private long nHk;
    private long nHl;
    private long nHm;

    /* loaded from: classes7.dex */
    public interface a {
        void Kr(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nHe = new LinkedList<>();
        this.nHf = 0.0f;
        this.nHg = State.PAUSE;
        this.isVisible = true;
        this.nHh = 0.0f;
        this.nHi = 0.0f;
        this.nHj = 0.0f;
        this.nHk = 0L;
        this.lastStartTime = 0L;
        this.nHl = 0L;
        this.nHm = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nHe = new LinkedList<>();
        this.nHf = 0.0f;
        this.nHg = State.PAUSE;
        this.isVisible = true;
        this.nHh = 0.0f;
        this.nHi = 0.0f;
        this.nHj = 0.0f;
        this.nHk = 0L;
        this.lastStartTime = 0L;
        this.nHl = 0L;
        this.nHm = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nHe = new LinkedList<>();
        this.nHf = 0.0f;
        this.nHg = State.PAUSE;
        this.isVisible = true;
        this.nHh = 0.0f;
        this.nHi = 0.0f;
        this.nHj = 0.0f;
        this.nHk = 0L;
        this.lastStartTime = 0L;
        this.nHl = 0L;
        this.nHm = 0L;
        init(context);
    }

    private void init(Context context) {
        this.heA = new Paint();
        this.nGY = new Paint();
        this.nGZ = new Paint();
        this.nHb = new Paint();
        this.nHa = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.heA.setStyle(Paint.Style.FILL);
        this.heA.setColor(Color.parseColor("#33aaff"));
        this.nGY.setStyle(Paint.Style.FILL);
        this.nGY.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nGZ.setStyle(Paint.Style.FILL);
        this.nGZ.setColor(Color.parseColor("#FFFFFF"));
        this.nHb.setStyle(Paint.Style.FILL);
        this.nHb.setColor(Color.parseColor("#e53917"));
        this.nHa.setStyle(Paint.Style.FILL);
        this.nHa.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nHf = displayMetrics.widthPixels / 15000.0f;
        this.nHj = this.nHf;
    }

    public void setListener(a aVar) {
        this.nGX = aVar;
    }

    /* loaded from: classes7.dex */
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
        if (this.iDg == 0) {
            this.iDg = System.currentTimeMillis();
        }
        if (this.nHm == 0) {
            this.nHm = getHeight();
        }
        this.nHc = (float) this.nHm;
        this.nHd = (float) ((this.nHm * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nHh = 0.0f;
        if (!this.nHe.isEmpty()) {
            Iterator<Integer> it = this.nHe.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nHl = intValue;
                float f = this.nHh;
                this.nHh += ((float) (intValue - j)) * this.nHf;
                float f2 = this.nHh - this.nHd;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nHm - 1), this.heA);
                canvas.drawRect(f2, 0.0f, this.nHh, (float) (this.nHm - 1), this.nGZ);
                j = intValue;
            }
            if (this.nHe.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nHf, 0.0f, this.nHc + (this.nHf * 3000.0f), (float) (this.nHm - 1), this.nGY);
            }
        } else {
            canvas.drawRect(3000.0f * this.nHf, 0.0f, this.nHc + (this.nHf * 3000.0f), (float) (this.nHm - 1), this.nGY);
        }
        if (this.nHg == State.ROLLBACK) {
            canvas.drawRect(this.nHh - (((float) (this.nHl - this.lastStartTime)) * this.nHf), 0.0f, this.nHh, (float) this.nHm, this.nHb);
        }
        if (this.nHg == State.START) {
            this.nHi += this.nHj * ((float) (currentTimeMillis - this.iDg));
            float f3 = this.nHh + this.nHi;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nHh, 0.0f, this.nHi + this.nHh, (float) (this.nHm - 1), this.heA);
            } else {
                canvas.drawRect(this.nHh, 0.0f, getMeasuredWidth(), (float) (this.nHm - 1), this.heA);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nHm) + (f3 - 5.0f), (float) (this.nHm - 1), this.nHa);
            if (this.nGX != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nGX.Kr(this.mProgress);
                }
            }
        } else {
            if (this.nGX != null) {
                int measuredWidth2 = (int) ((this.nHh / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nGX.Kr(this.mProgress);
                }
            }
            if (this.nHk == 0 || currentTimeMillis - this.nHk >= 800) {
                this.isVisible = !this.isVisible;
                this.nHk = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.nHh - 5.0f, 0.0f, ((float) this.nHm) + (this.nHh - 5.0f), (float) (this.nHm - 1), this.nHa);
            }
        }
        this.iDg = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nHg = state;
        if (state != State.START) {
            this.nHi = this.nHj;
        }
        if (state == State.DELETE && this.nHe != null && !this.nHe.isEmpty()) {
            this.nHe.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nHg;
    }

    public void Kq(int i) {
        this.nHe.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nHe == null || this.nHe.isEmpty()) {
            return 0;
        }
        return this.nHe.getLast().intValue();
    }

    public boolean dRT() {
        return this.nHe.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nHe;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nHe = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nHm = i;
    }

    public void reset() {
        this.nHe.clear();
        this.nHg = State.PAUSE;
        this.nHe.clear();
        this.nHh = 0.0f;
        this.iDg = 0L;
        this.lastStartTime = 0L;
        this.nHl = 0L;
        this.mProgress = 0;
        this.nHk = 0L;
    }
}
