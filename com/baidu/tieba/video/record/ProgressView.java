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
    private Paint hkN;
    private long iKN;
    private boolean isVisible;
    private long lastStartTime;
    private int mProgress;
    private a nTk;
    private Paint nTl;
    private Paint nTm;
    private Paint nTn;
    private Paint nTo;
    private float nTp;
    private float nTq;
    private LinkedList<Integer> nTr;
    private float nTs;
    private volatile State nTt;
    private float nTu;
    private float nTv;
    private float nTw;
    private long nTx;
    private long nTy;
    private long nTz;

    /* loaded from: classes7.dex */
    public interface a {
        void KQ(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nTr = new LinkedList<>();
        this.nTs = 0.0f;
        this.nTt = State.PAUSE;
        this.isVisible = true;
        this.nTu = 0.0f;
        this.nTv = 0.0f;
        this.nTw = 0.0f;
        this.nTx = 0L;
        this.lastStartTime = 0L;
        this.nTy = 0L;
        this.nTz = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nTr = new LinkedList<>();
        this.nTs = 0.0f;
        this.nTt = State.PAUSE;
        this.isVisible = true;
        this.nTu = 0.0f;
        this.nTv = 0.0f;
        this.nTw = 0.0f;
        this.nTx = 0L;
        this.lastStartTime = 0L;
        this.nTy = 0L;
        this.nTz = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nTr = new LinkedList<>();
        this.nTs = 0.0f;
        this.nTt = State.PAUSE;
        this.isVisible = true;
        this.nTu = 0.0f;
        this.nTv = 0.0f;
        this.nTw = 0.0f;
        this.nTx = 0L;
        this.lastStartTime = 0L;
        this.nTy = 0L;
        this.nTz = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hkN = new Paint();
        this.nTl = new Paint();
        this.nTm = new Paint();
        this.nTo = new Paint();
        this.nTn = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hkN.setStyle(Paint.Style.FILL);
        this.hkN.setColor(Color.parseColor("#33aaff"));
        this.nTl.setStyle(Paint.Style.FILL);
        this.nTl.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nTm.setStyle(Paint.Style.FILL);
        this.nTm.setColor(Color.parseColor("#FFFFFF"));
        this.nTo.setStyle(Paint.Style.FILL);
        this.nTo.setColor(Color.parseColor("#e53917"));
        this.nTn.setStyle(Paint.Style.FILL);
        this.nTn.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nTs = displayMetrics.widthPixels / 15000.0f;
        this.nTw = this.nTs;
    }

    public void setListener(a aVar) {
        this.nTk = aVar;
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
        if (this.iKN == 0) {
            this.iKN = System.currentTimeMillis();
        }
        if (this.nTz == 0) {
            this.nTz = getHeight();
        }
        this.nTp = (float) this.nTz;
        this.nTq = (float) ((this.nTz * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nTu = 0.0f;
        if (!this.nTr.isEmpty()) {
            Iterator<Integer> it = this.nTr.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nTy = intValue;
                float f = this.nTu;
                this.nTu += ((float) (intValue - j)) * this.nTs;
                float f2 = this.nTu - this.nTq;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nTz - 1), this.hkN);
                canvas.drawRect(f2, 0.0f, this.nTu, (float) (this.nTz - 1), this.nTm);
                j = intValue;
            }
            if (this.nTr.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nTs, 0.0f, this.nTp + (this.nTs * 3000.0f), (float) (this.nTz - 1), this.nTl);
            }
        } else {
            canvas.drawRect(3000.0f * this.nTs, 0.0f, this.nTp + (this.nTs * 3000.0f), (float) (this.nTz - 1), this.nTl);
        }
        if (this.nTt == State.ROLLBACK) {
            canvas.drawRect(this.nTu - (((float) (this.nTy - this.lastStartTime)) * this.nTs), 0.0f, this.nTu, (float) this.nTz, this.nTo);
        }
        if (this.nTt == State.START) {
            this.nTv += this.nTw * ((float) (currentTimeMillis - this.iKN));
            float f3 = this.nTu + this.nTv;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nTu, 0.0f, this.nTv + this.nTu, (float) (this.nTz - 1), this.hkN);
            } else {
                canvas.drawRect(this.nTu, 0.0f, getMeasuredWidth(), (float) (this.nTz - 1), this.hkN);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nTz) + (f3 - 5.0f), (float) (this.nTz - 1), this.nTn);
            if (this.nTk != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nTk.KQ(this.mProgress);
                }
            }
        } else {
            if (this.nTk != null) {
                int measuredWidth2 = (int) ((this.nTu / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nTk.KQ(this.mProgress);
                }
            }
            if (this.nTx == 0 || currentTimeMillis - this.nTx >= 800) {
                this.isVisible = !this.isVisible;
                this.nTx = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.nTu - 5.0f, 0.0f, ((float) this.nTz) + (this.nTu - 5.0f), (float) (this.nTz - 1), this.nTn);
            }
        }
        this.iKN = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nTt = state;
        if (state != State.START) {
            this.nTv = this.nTw;
        }
        if (state == State.DELETE && this.nTr != null && !this.nTr.isEmpty()) {
            this.nTr.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nTt;
    }

    public void KP(int i) {
        this.nTr.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nTr == null || this.nTr.isEmpty()) {
            return 0;
        }
        return this.nTr.getLast().intValue();
    }

    public boolean dUu() {
        return this.nTr.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nTr;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nTr = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nTz = i;
    }

    public void reset() {
        this.nTr.clear();
        this.nTt = State.PAUSE;
        this.nTr.clear();
        this.nTu = 0.0f;
        this.iKN = 0L;
        this.lastStartTime = 0L;
        this.nTy = 0L;
        this.mProgress = 0;
        this.nTx = 0L;
    }
}
