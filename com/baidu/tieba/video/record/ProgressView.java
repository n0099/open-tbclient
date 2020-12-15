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
    private Paint gXt;
    private long ivA;
    private long lastStartTime;
    private int mProgress;
    private long nIA;
    private long nIB;
    private a nIm;
    private Paint nIn;
    private Paint nIo;
    private Paint nIp;
    private Paint nIq;
    private float nIr;
    private float nIs;
    private LinkedList<Integer> nIt;
    private float nIu;
    private volatile State nIv;
    private float nIw;
    private float nIx;
    private float nIy;
    private long nIz;

    /* loaded from: classes23.dex */
    public interface a {
        void Ml(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nIt = new LinkedList<>();
        this.nIu = 0.0f;
        this.nIv = State.PAUSE;
        this.fcU = true;
        this.nIw = 0.0f;
        this.nIx = 0.0f;
        this.nIy = 0.0f;
        this.nIz = 0L;
        this.lastStartTime = 0L;
        this.nIA = 0L;
        this.nIB = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nIt = new LinkedList<>();
        this.nIu = 0.0f;
        this.nIv = State.PAUSE;
        this.fcU = true;
        this.nIw = 0.0f;
        this.nIx = 0.0f;
        this.nIy = 0.0f;
        this.nIz = 0L;
        this.lastStartTime = 0L;
        this.nIA = 0L;
        this.nIB = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIt = new LinkedList<>();
        this.nIu = 0.0f;
        this.nIv = State.PAUSE;
        this.fcU = true;
        this.nIw = 0.0f;
        this.nIx = 0.0f;
        this.nIy = 0.0f;
        this.nIz = 0L;
        this.lastStartTime = 0L;
        this.nIA = 0L;
        this.nIB = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gXt = new Paint();
        this.nIn = new Paint();
        this.nIo = new Paint();
        this.nIq = new Paint();
        this.nIp = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gXt.setStyle(Paint.Style.FILL);
        this.gXt.setColor(Color.parseColor("#33aaff"));
        this.nIn.setStyle(Paint.Style.FILL);
        this.nIn.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nIo.setStyle(Paint.Style.FILL);
        this.nIo.setColor(Color.parseColor("#FFFFFF"));
        this.nIq.setStyle(Paint.Style.FILL);
        this.nIq.setColor(Color.parseColor("#e53917"));
        this.nIp.setStyle(Paint.Style.FILL);
        this.nIp.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nIu = displayMetrics.widthPixels / 15000.0f;
        this.nIy = this.nIu;
    }

    public void setListener(a aVar) {
        this.nIm = aVar;
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
        if (this.ivA == 0) {
            this.ivA = System.currentTimeMillis();
        }
        if (this.nIB == 0) {
            this.nIB = getHeight();
        }
        this.nIr = (float) this.nIB;
        this.nIs = (float) ((this.nIB * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nIw = 0.0f;
        if (!this.nIt.isEmpty()) {
            Iterator<Integer> it = this.nIt.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nIA = intValue;
                float f = this.nIw;
                this.nIw += ((float) (intValue - j)) * this.nIu;
                float f2 = this.nIw - this.nIs;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nIB - 1), this.gXt);
                canvas.drawRect(f2, 0.0f, this.nIw, (float) (this.nIB - 1), this.nIo);
                j = intValue;
            }
            if (this.nIt.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nIu, 0.0f, this.nIr + (this.nIu * 3000.0f), (float) (this.nIB - 1), this.nIn);
            }
        } else {
            canvas.drawRect(3000.0f * this.nIu, 0.0f, this.nIr + (this.nIu * 3000.0f), (float) (this.nIB - 1), this.nIn);
        }
        if (this.nIv == State.ROLLBACK) {
            canvas.drawRect(this.nIw - (((float) (this.nIA - this.lastStartTime)) * this.nIu), 0.0f, this.nIw, (float) this.nIB, this.nIq);
        }
        if (this.nIv == State.START) {
            this.nIx += this.nIy * ((float) (currentTimeMillis - this.ivA));
            float f3 = this.nIw + this.nIx;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nIw, 0.0f, this.nIx + this.nIw, (float) (this.nIB - 1), this.gXt);
            } else {
                canvas.drawRect(this.nIw, 0.0f, getMeasuredWidth(), (float) (this.nIB - 1), this.gXt);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nIB) + (f3 - 5.0f), (float) (this.nIB - 1), this.nIp);
            if (this.nIm != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nIm.Ml(this.mProgress);
                }
            }
        } else {
            if (this.nIm != null) {
                int measuredWidth2 = (int) ((this.nIw / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nIm.Ml(this.mProgress);
                }
            }
            if (this.nIz == 0 || currentTimeMillis - this.nIz >= 800) {
                this.fcU = !this.fcU;
                this.nIz = System.currentTimeMillis();
            }
            if (this.fcU) {
                canvas.drawRect(this.nIw - 5.0f, 0.0f, ((float) this.nIB) + (this.nIw - 5.0f), (float) (this.nIB - 1), this.nIp);
            }
        }
        this.ivA = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nIv = state;
        if (state != State.START) {
            this.nIx = this.nIy;
        }
        if (state == State.DELETE && this.nIt != null && !this.nIt.isEmpty()) {
            this.nIt.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nIv;
    }

    public void Mk(int i) {
        this.nIt.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nIt == null || this.nIt.isEmpty()) {
            return 0;
        }
        return this.nIt.getLast().intValue();
    }

    public boolean dWi() {
        return this.nIt.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nIt;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nIt = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nIB = i;
    }

    public void reset() {
        this.nIt.clear();
        this.nIv = State.PAUSE;
        this.nIt.clear();
        this.nIw = 0.0f;
        this.ivA = 0L;
        this.lastStartTime = 0L;
        this.nIA = 0L;
        this.mProgress = 0;
        this.nIz = 0L;
    }
}
