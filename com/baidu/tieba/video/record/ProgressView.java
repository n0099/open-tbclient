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
    private boolean eIc;
    private Paint gwX;
    private long hRt;
    private long lastStartTime;
    private int mProgress;
    private a naE;
    private Paint naF;
    private Paint naG;
    private Paint naH;
    private Paint naI;
    private float naJ;
    private float naK;
    private LinkedList<Integer> naL;
    private float naM;
    private volatile State naN;
    private float naO;
    private float naP;
    private float naQ;
    private long naR;
    private long naS;
    private long naT;

    /* loaded from: classes23.dex */
    public interface a {
        void Kl(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.naL = new LinkedList<>();
        this.naM = 0.0f;
        this.naN = State.PAUSE;
        this.eIc = true;
        this.naO = 0.0f;
        this.naP = 0.0f;
        this.naQ = 0.0f;
        this.naR = 0L;
        this.lastStartTime = 0L;
        this.naS = 0L;
        this.naT = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.naL = new LinkedList<>();
        this.naM = 0.0f;
        this.naN = State.PAUSE;
        this.eIc = true;
        this.naO = 0.0f;
        this.naP = 0.0f;
        this.naQ = 0.0f;
        this.naR = 0L;
        this.lastStartTime = 0L;
        this.naS = 0L;
        this.naT = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.naL = new LinkedList<>();
        this.naM = 0.0f;
        this.naN = State.PAUSE;
        this.eIc = true;
        this.naO = 0.0f;
        this.naP = 0.0f;
        this.naQ = 0.0f;
        this.naR = 0L;
        this.lastStartTime = 0L;
        this.naS = 0L;
        this.naT = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gwX = new Paint();
        this.naF = new Paint();
        this.naG = new Paint();
        this.naI = new Paint();
        this.naH = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gwX.setStyle(Paint.Style.FILL);
        this.gwX.setColor(Color.parseColor("#33aaff"));
        this.naF.setStyle(Paint.Style.FILL);
        this.naF.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.naG.setStyle(Paint.Style.FILL);
        this.naG.setColor(Color.parseColor("#FFFFFF"));
        this.naI.setStyle(Paint.Style.FILL);
        this.naI.setColor(Color.parseColor("#e53917"));
        this.naH.setStyle(Paint.Style.FILL);
        this.naH.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.naM = displayMetrics.widthPixels / 15000.0f;
        this.naQ = this.naM;
    }

    public void setListener(a aVar) {
        this.naE = aVar;
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
        if (this.hRt == 0) {
            this.hRt = System.currentTimeMillis();
        }
        if (this.naT == 0) {
            this.naT = getHeight();
        }
        this.naJ = (float) this.naT;
        this.naK = (float) ((this.naT * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.naO = 0.0f;
        if (!this.naL.isEmpty()) {
            Iterator<Integer> it = this.naL.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.naS = intValue;
                float f = this.naO;
                this.naO += ((float) (intValue - j)) * this.naM;
                float f2 = this.naO - this.naK;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.naT - 1), this.gwX);
                canvas.drawRect(f2, 0.0f, this.naO, (float) (this.naT - 1), this.naG);
                j = intValue;
            }
            if (this.naL.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.naM, 0.0f, this.naJ + (this.naM * 3000.0f), (float) (this.naT - 1), this.naF);
            }
        } else {
            canvas.drawRect(3000.0f * this.naM, 0.0f, this.naJ + (this.naM * 3000.0f), (float) (this.naT - 1), this.naF);
        }
        if (this.naN == State.ROLLBACK) {
            canvas.drawRect(this.naO - (((float) (this.naS - this.lastStartTime)) * this.naM), 0.0f, this.naO, (float) this.naT, this.naI);
        }
        if (this.naN == State.START) {
            this.naP += this.naQ * ((float) (currentTimeMillis - this.hRt));
            float f3 = this.naO + this.naP;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.naO, 0.0f, this.naP + this.naO, (float) (this.naT - 1), this.gwX);
            } else {
                canvas.drawRect(this.naO, 0.0f, getMeasuredWidth(), (float) (this.naT - 1), this.gwX);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.naT) + (f3 - 5.0f), (float) (this.naT - 1), this.naH);
            if (this.naE != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.naE.Kl(this.mProgress);
                }
            }
        } else {
            if (this.naE != null) {
                int measuredWidth2 = (int) ((this.naO / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.naE.Kl(this.mProgress);
                }
            }
            if (this.naR == 0 || currentTimeMillis - this.naR >= 800) {
                this.eIc = !this.eIc;
                this.naR = System.currentTimeMillis();
            }
            if (this.eIc) {
                canvas.drawRect(this.naO - 5.0f, 0.0f, ((float) this.naT) + (this.naO - 5.0f), (float) (this.naT - 1), this.naH);
            }
        }
        this.hRt = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.naN = state;
        if (state != State.START) {
            this.naP = this.naQ;
        }
        if (state == State.DELETE && this.naL != null && !this.naL.isEmpty()) {
            this.naL.removeLast();
        }
    }

    public State getCurrentState() {
        return this.naN;
    }

    public void Kk(int i) {
        this.naL.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.naL == null || this.naL.isEmpty()) {
            return 0;
        }
        return this.naL.getLast().intValue();
    }

    public boolean dLe() {
        return this.naL.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.naL;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.naL = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.naT = i;
    }

    public void reset() {
        this.naL.clear();
        this.naN = State.PAUSE;
        this.naL.clear();
        this.naO = 0.0f;
        this.hRt = 0L;
        this.lastStartTime = 0L;
        this.naS = 0L;
        this.mProgress = 0;
        this.naR = 0L;
    }
}
