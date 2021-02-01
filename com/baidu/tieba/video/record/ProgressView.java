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
/* loaded from: classes8.dex */
public class ProgressView extends View {
    private Paint hiQ;
    private long iIQ;
    private boolean isVisible;
    private long lastStartTime;
    private int mProgress;
    private a nQF;
    private Paint nQG;
    private Paint nQH;
    private Paint nQI;
    private Paint nQJ;
    private float nQK;
    private float nQL;
    private LinkedList<Integer> nQM;
    private float nQN;
    private volatile State nQO;
    private float nQP;
    private float nQQ;
    private float nQR;
    private long nQS;
    private long nQT;
    private long nQU;

    /* loaded from: classes8.dex */
    public interface a {
        void KL(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nQM = new LinkedList<>();
        this.nQN = 0.0f;
        this.nQO = State.PAUSE;
        this.isVisible = true;
        this.nQP = 0.0f;
        this.nQQ = 0.0f;
        this.nQR = 0.0f;
        this.nQS = 0L;
        this.lastStartTime = 0L;
        this.nQT = 0L;
        this.nQU = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nQM = new LinkedList<>();
        this.nQN = 0.0f;
        this.nQO = State.PAUSE;
        this.isVisible = true;
        this.nQP = 0.0f;
        this.nQQ = 0.0f;
        this.nQR = 0.0f;
        this.nQS = 0L;
        this.lastStartTime = 0L;
        this.nQT = 0L;
        this.nQU = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQM = new LinkedList<>();
        this.nQN = 0.0f;
        this.nQO = State.PAUSE;
        this.isVisible = true;
        this.nQP = 0.0f;
        this.nQQ = 0.0f;
        this.nQR = 0.0f;
        this.nQS = 0L;
        this.lastStartTime = 0L;
        this.nQT = 0L;
        this.nQU = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hiQ = new Paint();
        this.nQG = new Paint();
        this.nQH = new Paint();
        this.nQJ = new Paint();
        this.nQI = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hiQ.setStyle(Paint.Style.FILL);
        this.hiQ.setColor(Color.parseColor("#33aaff"));
        this.nQG.setStyle(Paint.Style.FILL);
        this.nQG.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nQH.setStyle(Paint.Style.FILL);
        this.nQH.setColor(Color.parseColor("#FFFFFF"));
        this.nQJ.setStyle(Paint.Style.FILL);
        this.nQJ.setColor(Color.parseColor("#e53917"));
        this.nQI.setStyle(Paint.Style.FILL);
        this.nQI.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nQN = displayMetrics.widthPixels / 15000.0f;
        this.nQR = this.nQN;
    }

    public void setListener(a aVar) {
        this.nQF = aVar;
    }

    /* loaded from: classes8.dex */
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
        if (this.iIQ == 0) {
            this.iIQ = System.currentTimeMillis();
        }
        if (this.nQU == 0) {
            this.nQU = getHeight();
        }
        this.nQK = (float) this.nQU;
        this.nQL = (float) ((this.nQU * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nQP = 0.0f;
        if (!this.nQM.isEmpty()) {
            Iterator<Integer> it = this.nQM.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nQT = intValue;
                float f = this.nQP;
                this.nQP += ((float) (intValue - j)) * this.nQN;
                float f2 = this.nQP - this.nQL;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nQU - 1), this.hiQ);
                canvas.drawRect(f2, 0.0f, this.nQP, (float) (this.nQU - 1), this.nQH);
                j = intValue;
            }
            if (this.nQM.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nQN, 0.0f, this.nQK + (this.nQN * 3000.0f), (float) (this.nQU - 1), this.nQG);
            }
        } else {
            canvas.drawRect(3000.0f * this.nQN, 0.0f, this.nQK + (this.nQN * 3000.0f), (float) (this.nQU - 1), this.nQG);
        }
        if (this.nQO == State.ROLLBACK) {
            canvas.drawRect(this.nQP - (((float) (this.nQT - this.lastStartTime)) * this.nQN), 0.0f, this.nQP, (float) this.nQU, this.nQJ);
        }
        if (this.nQO == State.START) {
            this.nQQ += this.nQR * ((float) (currentTimeMillis - this.iIQ));
            float f3 = this.nQP + this.nQQ;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nQP, 0.0f, this.nQQ + this.nQP, (float) (this.nQU - 1), this.hiQ);
            } else {
                canvas.drawRect(this.nQP, 0.0f, getMeasuredWidth(), (float) (this.nQU - 1), this.hiQ);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nQU) + (f3 - 5.0f), (float) (this.nQU - 1), this.nQI);
            if (this.nQF != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nQF.KL(this.mProgress);
                }
            }
        } else {
            if (this.nQF != null) {
                int measuredWidth2 = (int) ((this.nQP / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nQF.KL(this.mProgress);
                }
            }
            if (this.nQS == 0 || currentTimeMillis - this.nQS >= 800) {
                this.isVisible = !this.isVisible;
                this.nQS = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.nQP - 5.0f, 0.0f, ((float) this.nQU) + (this.nQP - 5.0f), (float) (this.nQU - 1), this.nQI);
            }
        }
        this.iIQ = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nQO = state;
        if (state != State.START) {
            this.nQQ = this.nQR;
        }
        if (state == State.DELETE && this.nQM != null && !this.nQM.isEmpty()) {
            this.nQM.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nQO;
    }

    public void KK(int i) {
        this.nQM.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nQM == null || this.nQM.isEmpty()) {
            return 0;
        }
        return this.nQM.getLast().intValue();
    }

    public boolean dUe() {
        return this.nQM.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nQM;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nQM = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nQU = i;
    }

    public void reset() {
        this.nQM.clear();
        this.nQO = State.PAUSE;
        this.nQM.clear();
        this.nQP = 0.0f;
        this.iIQ = 0L;
        this.lastStartTime = 0L;
        this.nQT = 0L;
        this.mProgress = 0;
        this.nQS = 0L;
    }
}
