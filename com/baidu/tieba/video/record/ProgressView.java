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
/* loaded from: classes10.dex */
public class ProgressView extends View {
    private long fVt;
    private boolean isVisible;
    private a kBV;
    private Paint kBW;
    private Paint kBX;
    private Paint kBY;
    private Paint kBZ;
    private Paint kCa;
    private float kCb;
    private float kCc;
    private LinkedList<Integer> kCd;
    private float kCe;
    private volatile State kCf;
    private float kCg;
    private float kCh;
    private float kCi;
    private long kCj;
    private long kCk;
    private long kCl;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes10.dex */
    public interface a {
        void DH(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.kCd = new LinkedList<>();
        this.kCe = 0.0f;
        this.kCf = State.PAUSE;
        this.isVisible = true;
        this.kCg = 0.0f;
        this.kCh = 0.0f;
        this.kCi = 0.0f;
        this.kCj = 0L;
        this.lastStartTime = 0L;
        this.kCk = 0L;
        this.kCl = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kCd = new LinkedList<>();
        this.kCe = 0.0f;
        this.kCf = State.PAUSE;
        this.isVisible = true;
        this.kCg = 0.0f;
        this.kCh = 0.0f;
        this.kCi = 0.0f;
        this.kCj = 0L;
        this.lastStartTime = 0L;
        this.kCk = 0L;
        this.kCl = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kCd = new LinkedList<>();
        this.kCe = 0.0f;
        this.kCf = State.PAUSE;
        this.isVisible = true;
        this.kCg = 0.0f;
        this.kCh = 0.0f;
        this.kCi = 0.0f;
        this.kCj = 0L;
        this.lastStartTime = 0L;
        this.kCk = 0L;
        this.kCl = 0L;
        init(context);
    }

    private void init(Context context) {
        this.kBW = new Paint();
        this.kBX = new Paint();
        this.kBY = new Paint();
        this.kCa = new Paint();
        this.kBZ = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.kBW.setStyle(Paint.Style.FILL);
        this.kBW.setColor(Color.parseColor("#33aaff"));
        this.kBX.setStyle(Paint.Style.FILL);
        this.kBX.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.kBY.setStyle(Paint.Style.FILL);
        this.kBY.setColor(Color.parseColor("#FFFFFF"));
        this.kCa.setStyle(Paint.Style.FILL);
        this.kCa.setColor(Color.parseColor("#e53917"));
        this.kBZ.setStyle(Paint.Style.FILL);
        this.kBZ.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.kCe = displayMetrics.widthPixels / 15000.0f;
        this.kCi = this.kCe;
    }

    public void setListener(a aVar) {
        this.kBV = aVar;
    }

    /* loaded from: classes10.dex */
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
        if (this.fVt == 0) {
            this.fVt = System.currentTimeMillis();
        }
        if (this.kCl == 0) {
            this.kCl = getHeight();
        }
        this.kCb = (float) this.kCl;
        this.kCc = (float) ((this.kCl * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.kCg = 0.0f;
        if (!this.kCd.isEmpty()) {
            Iterator<Integer> it = this.kCd.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.kCk = intValue;
                float f = this.kCg;
                this.kCg += ((float) (intValue - j)) * this.kCe;
                float f2 = this.kCg - this.kCc;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.kCl - 1), this.kBW);
                canvas.drawRect(f2, 0.0f, this.kCg, (float) (this.kCl - 1), this.kBY);
                j = intValue;
            }
            if (this.kCd.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.kCe, 0.0f, this.kCb + (this.kCe * 3000.0f), (float) (this.kCl - 1), this.kBX);
            }
        } else {
            canvas.drawRect(3000.0f * this.kCe, 0.0f, this.kCb + (this.kCe * 3000.0f), (float) (this.kCl - 1), this.kBX);
        }
        if (this.kCf == State.ROLLBACK) {
            canvas.drawRect(this.kCg - (((float) (this.kCk - this.lastStartTime)) * this.kCe), 0.0f, this.kCg, (float) this.kCl, this.kCa);
        }
        if (this.kCf == State.START) {
            this.kCh += this.kCi * ((float) (currentTimeMillis - this.fVt));
            float f3 = this.kCg + this.kCh;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.kCg, 0.0f, this.kCh + this.kCg, (float) (this.kCl - 1), this.kBW);
            } else {
                canvas.drawRect(this.kCg, 0.0f, getMeasuredWidth(), (float) (this.kCl - 1), this.kBW);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.kCl) + (f3 - 5.0f), (float) (this.kCl - 1), this.kBZ);
            if (this.kBV != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.kBV.DH(this.mProgress);
                }
            }
        } else {
            if (this.kBV != null) {
                int measuredWidth2 = (int) ((this.kCg / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.kBV.DH(this.mProgress);
                }
            }
            if (this.kCj == 0 || currentTimeMillis - this.kCj >= 800) {
                this.isVisible = !this.isVisible;
                this.kCj = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.kCg - 5.0f, 0.0f, ((float) this.kCl) + (this.kCg - 5.0f), (float) (this.kCl - 1), this.kBZ);
            }
        }
        this.fVt = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.kCf = state;
        if (state != State.START) {
            this.kCh = this.kCi;
        }
        if (state == State.DELETE && this.kCd != null && !this.kCd.isEmpty()) {
            this.kCd.removeLast();
        }
    }

    public State getCurrentState() {
        return this.kCf;
    }

    public void DG(int i) {
        this.kCd.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.kCd == null || this.kCd.isEmpty()) {
            return 0;
        }
        return this.kCd.getLast().intValue();
    }

    public boolean cRz() {
        return this.kCd.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.kCd;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.kCd = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.kCl = i;
    }

    public void reset() {
        this.kCd.clear();
        this.kCf = State.PAUSE;
        this.kCd.clear();
        this.kCg = 0.0f;
        this.fVt = 0L;
        this.lastStartTime = 0L;
        this.kCk = 0L;
        this.mProgress = 0;
        this.kCj = 0L;
    }
}
