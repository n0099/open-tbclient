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
/* loaded from: classes23.dex */
public class ProgressView extends View {
    private boolean fcU;
    private Paint gXr;
    private long ivy;
    private long lastStartTime;
    private int mProgress;
    private a nIk;
    private Paint nIl;
    private Paint nIm;
    private Paint nIn;
    private Paint nIo;
    private float nIp;
    private float nIq;
    private LinkedList<Integer> nIr;
    private float nIs;
    private volatile State nIt;
    private float nIu;
    private float nIv;
    private float nIw;
    private long nIx;
    private long nIy;
    private long nIz;

    /* loaded from: classes23.dex */
    public interface a {
        void Ml(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nIr = new LinkedList<>();
        this.nIs = 0.0f;
        this.nIt = State.PAUSE;
        this.fcU = true;
        this.nIu = 0.0f;
        this.nIv = 0.0f;
        this.nIw = 0.0f;
        this.nIx = 0L;
        this.lastStartTime = 0L;
        this.nIy = 0L;
        this.nIz = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIr = new LinkedList<>();
        this.nIs = 0.0f;
        this.nIt = State.PAUSE;
        this.fcU = true;
        this.nIu = 0.0f;
        this.nIv = 0.0f;
        this.nIw = 0.0f;
        this.nIx = 0L;
        this.lastStartTime = 0L;
        this.nIy = 0L;
        this.nIz = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIr = new LinkedList<>();
        this.nIs = 0.0f;
        this.nIt = State.PAUSE;
        this.fcU = true;
        this.nIu = 0.0f;
        this.nIv = 0.0f;
        this.nIw = 0.0f;
        this.nIx = 0L;
        this.lastStartTime = 0L;
        this.nIy = 0L;
        this.nIz = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gXr = new Paint();
        this.nIl = new Paint();
        this.nIm = new Paint();
        this.nIo = new Paint();
        this.nIn = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gXr.setStyle(Paint.Style.FILL);
        this.gXr.setColor(Color.parseColor("#33aaff"));
        this.nIl.setStyle(Paint.Style.FILL);
        this.nIl.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nIm.setStyle(Paint.Style.FILL);
        this.nIm.setColor(Color.parseColor("#FFFFFF"));
        this.nIo.setStyle(Paint.Style.FILL);
        this.nIo.setColor(Color.parseColor("#e53917"));
        this.nIn.setStyle(Paint.Style.FILL);
        this.nIn.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nIs = displayMetrics.widthPixels / 15000.0f;
        this.nIw = this.nIs;
    }

    public void setListener(a aVar) {
        this.nIk = aVar;
    }

    /* loaded from: classes23.dex */
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
        if (this.ivy == 0) {
            this.ivy = System.currentTimeMillis();
        }
        if (this.nIz == 0) {
            this.nIz = getHeight();
        }
        this.nIp = (float) this.nIz;
        this.nIq = (float) ((this.nIz * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nIu = 0.0f;
        if (!this.nIr.isEmpty()) {
            Iterator<Integer> it = this.nIr.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nIy = intValue;
                float f = this.nIu;
                this.nIu += ((float) (intValue - j)) * this.nIs;
                float f2 = this.nIu - this.nIq;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nIz - 1), this.gXr);
                canvas.drawRect(f2, 0.0f, this.nIu, (float) (this.nIz - 1), this.nIm);
                j = intValue;
            }
            if (this.nIr.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nIs, 0.0f, this.nIp + (this.nIs * 3000.0f), (float) (this.nIz - 1), this.nIl);
            }
        } else {
            canvas.drawRect(3000.0f * this.nIs, 0.0f, this.nIp + (this.nIs * 3000.0f), (float) (this.nIz - 1), this.nIl);
        }
        if (this.nIt == State.ROLLBACK) {
            canvas.drawRect(this.nIu - (((float) (this.nIy - this.lastStartTime)) * this.nIs), 0.0f, this.nIu, (float) this.nIz, this.nIo);
        }
        if (this.nIt == State.START) {
            this.nIv += this.nIw * ((float) (currentTimeMillis - this.ivy));
            float f3 = this.nIu + this.nIv;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nIu, 0.0f, this.nIv + this.nIu, (float) (this.nIz - 1), this.gXr);
            } else {
                canvas.drawRect(this.nIu, 0.0f, getMeasuredWidth(), (float) (this.nIz - 1), this.gXr);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nIz) + (f3 - 5.0f), (float) (this.nIz - 1), this.nIn);
            if (this.nIk != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nIk.Ml(this.mProgress);
                }
            }
        } else {
            if (this.nIk != null) {
                int measuredWidth2 = (int) ((this.nIu / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nIk.Ml(this.mProgress);
                }
            }
            if (this.nIx == 0 || currentTimeMillis - this.nIx >= 800) {
                this.fcU = !this.fcU;
                this.nIx = System.currentTimeMillis();
            }
            if (this.fcU) {
                canvas.drawRect(this.nIu - 5.0f, 0.0f, ((float) this.nIz) + (this.nIu - 5.0f), (float) (this.nIz - 1), this.nIn);
            }
        }
        this.ivy = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nIt = state;
        if (state != State.START) {
            this.nIv = this.nIw;
        }
        if (state == State.DELETE && this.nIr != null && !this.nIr.isEmpty()) {
            this.nIr.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nIt;
    }

    public void Mk(int i) {
        this.nIr.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nIr == null || this.nIr.isEmpty()) {
            return 0;
        }
        return this.nIr.getLast().intValue();
    }

    public boolean dWh() {
        return this.nIr.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nIr;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nIr = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nIz = i;
    }

    public void reset() {
        this.nIr.clear();
        this.nIt = State.PAUSE;
        this.nIr.clear();
        this.nIu = 0.0f;
        this.ivy = 0L;
        this.lastStartTime = 0L;
        this.nIy = 0L;
        this.mProgress = 0;
        this.nIx = 0L;
    }
}
