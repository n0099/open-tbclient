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
    private long fWb;
    private boolean isVisible;
    private a kDC;
    private Paint kDD;
    private Paint kDE;
    private Paint kDF;
    private Paint kDG;
    private Paint kDH;
    private float kDI;
    private float kDJ;
    private LinkedList<Integer> kDK;
    private float kDL;
    private volatile State kDM;
    private float kDN;
    private float kDO;
    private float kDP;
    private long kDQ;
    private long kDR;
    private long kDS;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes10.dex */
    public interface a {
        void DP(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.kDK = new LinkedList<>();
        this.kDL = 0.0f;
        this.kDM = State.PAUSE;
        this.isVisible = true;
        this.kDN = 0.0f;
        this.kDO = 0.0f;
        this.kDP = 0.0f;
        this.kDQ = 0L;
        this.lastStartTime = 0L;
        this.kDR = 0L;
        this.kDS = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kDK = new LinkedList<>();
        this.kDL = 0.0f;
        this.kDM = State.PAUSE;
        this.isVisible = true;
        this.kDN = 0.0f;
        this.kDO = 0.0f;
        this.kDP = 0.0f;
        this.kDQ = 0L;
        this.lastStartTime = 0L;
        this.kDR = 0L;
        this.kDS = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kDK = new LinkedList<>();
        this.kDL = 0.0f;
        this.kDM = State.PAUSE;
        this.isVisible = true;
        this.kDN = 0.0f;
        this.kDO = 0.0f;
        this.kDP = 0.0f;
        this.kDQ = 0L;
        this.lastStartTime = 0L;
        this.kDR = 0L;
        this.kDS = 0L;
        init(context);
    }

    private void init(Context context) {
        this.kDD = new Paint();
        this.kDE = new Paint();
        this.kDF = new Paint();
        this.kDH = new Paint();
        this.kDG = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.kDD.setStyle(Paint.Style.FILL);
        this.kDD.setColor(Color.parseColor("#33aaff"));
        this.kDE.setStyle(Paint.Style.FILL);
        this.kDE.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.kDF.setStyle(Paint.Style.FILL);
        this.kDF.setColor(Color.parseColor("#FFFFFF"));
        this.kDH.setStyle(Paint.Style.FILL);
        this.kDH.setColor(Color.parseColor("#e53917"));
        this.kDG.setStyle(Paint.Style.FILL);
        this.kDG.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.kDL = displayMetrics.widthPixels / 15000.0f;
        this.kDP = this.kDL;
    }

    public void setListener(a aVar) {
        this.kDC = aVar;
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
        if (this.fWb == 0) {
            this.fWb = System.currentTimeMillis();
        }
        if (this.kDS == 0) {
            this.kDS = getHeight();
        }
        this.kDI = (float) this.kDS;
        this.kDJ = (float) ((this.kDS * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.kDN = 0.0f;
        if (!this.kDK.isEmpty()) {
            Iterator<Integer> it = this.kDK.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.kDR = intValue;
                float f = this.kDN;
                this.kDN += ((float) (intValue - j)) * this.kDL;
                float f2 = this.kDN - this.kDJ;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.kDS - 1), this.kDD);
                canvas.drawRect(f2, 0.0f, this.kDN, (float) (this.kDS - 1), this.kDF);
                j = intValue;
            }
            if (this.kDK.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.kDL, 0.0f, this.kDI + (this.kDL * 3000.0f), (float) (this.kDS - 1), this.kDE);
            }
        } else {
            canvas.drawRect(3000.0f * this.kDL, 0.0f, this.kDI + (this.kDL * 3000.0f), (float) (this.kDS - 1), this.kDE);
        }
        if (this.kDM == State.ROLLBACK) {
            canvas.drawRect(this.kDN - (((float) (this.kDR - this.lastStartTime)) * this.kDL), 0.0f, this.kDN, (float) this.kDS, this.kDH);
        }
        if (this.kDM == State.START) {
            this.kDO += this.kDP * ((float) (currentTimeMillis - this.fWb));
            float f3 = this.kDN + this.kDO;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.kDN, 0.0f, this.kDO + this.kDN, (float) (this.kDS - 1), this.kDD);
            } else {
                canvas.drawRect(this.kDN, 0.0f, getMeasuredWidth(), (float) (this.kDS - 1), this.kDD);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.kDS) + (f3 - 5.0f), (float) (this.kDS - 1), this.kDG);
            if (this.kDC != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.kDC.DP(this.mProgress);
                }
            }
        } else {
            if (this.kDC != null) {
                int measuredWidth2 = (int) ((this.kDN / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.kDC.DP(this.mProgress);
                }
            }
            if (this.kDQ == 0 || currentTimeMillis - this.kDQ >= 800) {
                this.isVisible = !this.isVisible;
                this.kDQ = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.kDN - 5.0f, 0.0f, ((float) this.kDS) + (this.kDN - 5.0f), (float) (this.kDS - 1), this.kDG);
            }
        }
        this.fWb = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.kDM = state;
        if (state != State.START) {
            this.kDO = this.kDP;
        }
        if (state == State.DELETE && this.kDK != null && !this.kDK.isEmpty()) {
            this.kDK.removeLast();
        }
    }

    public State getCurrentState() {
        return this.kDM;
    }

    public void DO(int i) {
        this.kDK.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.kDK == null || this.kDK.isEmpty()) {
            return 0;
        }
        return this.kDK.getLast().intValue();
    }

    public boolean cRT() {
        return this.kDK.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.kDK;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.kDK = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.kDS = i;
    }

    public void reset() {
        this.kDK.clear();
        this.kDM = State.PAUSE;
        this.kDK.clear();
        this.kDN = 0.0f;
        this.fWb = 0L;
        this.lastStartTime = 0L;
        this.kDR = 0L;
        this.mProgress = 0;
        this.kDQ = 0L;
    }
}
