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
    private boolean awS;
    private long cSd;
    private Paint clv;
    private a hdK;
    private Paint hdL;
    private Paint hdM;
    private Paint hdN;
    private Paint hdO;
    private float hdP;
    private float hdQ;
    private LinkedList<Integer> hdR;
    private float hdS;
    private volatile State hdT;
    private float hdU;
    private float hdV;
    private float hdW;
    private long hdX;
    private long hdY;
    private long hdZ;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uI(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hdR = new LinkedList<>();
        this.hdS = 0.0f;
        this.hdT = State.PAUSE;
        this.awS = true;
        this.hdU = 0.0f;
        this.hdV = 0.0f;
        this.hdW = 0.0f;
        this.hdX = 0L;
        this.lastStartTime = 0L;
        this.hdY = 0L;
        this.hdZ = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hdR = new LinkedList<>();
        this.hdS = 0.0f;
        this.hdT = State.PAUSE;
        this.awS = true;
        this.hdU = 0.0f;
        this.hdV = 0.0f;
        this.hdW = 0.0f;
        this.hdX = 0L;
        this.lastStartTime = 0L;
        this.hdY = 0L;
        this.hdZ = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hdR = new LinkedList<>();
        this.hdS = 0.0f;
        this.hdT = State.PAUSE;
        this.awS = true;
        this.hdU = 0.0f;
        this.hdV = 0.0f;
        this.hdW = 0.0f;
        this.hdX = 0L;
        this.lastStartTime = 0L;
        this.hdY = 0L;
        this.hdZ = 0L;
        init(context);
    }

    private void init(Context context) {
        this.clv = new Paint();
        this.hdL = new Paint();
        this.hdM = new Paint();
        this.hdO = new Paint();
        this.hdN = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.clv.setStyle(Paint.Style.FILL);
        this.clv.setColor(Color.parseColor("#33aaff"));
        this.hdL.setStyle(Paint.Style.FILL);
        this.hdL.setColor(Color.rgb(51, 170, 255));
        this.hdM.setStyle(Paint.Style.FILL);
        this.hdM.setColor(Color.parseColor("#FFFFFF"));
        this.hdO.setStyle(Paint.Style.FILL);
        this.hdO.setColor(Color.parseColor("#e53917"));
        this.hdN.setStyle(Paint.Style.FILL);
        this.hdN.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hdS = displayMetrics.widthPixels / 15000.0f;
        this.hdW = this.hdS;
    }

    public void setListener(a aVar) {
        this.hdK = aVar;
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
        if (this.cSd == 0) {
            this.cSd = System.currentTimeMillis();
        }
        if (this.hdZ == 0) {
            this.hdZ = getHeight();
        }
        this.hdP = (float) this.hdZ;
        this.hdQ = (float) ((this.hdZ * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hdU = 0.0f;
        if (!this.hdR.isEmpty()) {
            Iterator<Integer> it = this.hdR.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hdY = intValue;
                float f = this.hdU;
                this.hdU += ((float) (intValue - j)) * this.hdS;
                float f2 = this.hdU - this.hdQ;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hdZ - 1), this.clv);
                canvas.drawRect(f2, 0.0f, this.hdU, (float) (this.hdZ - 1), this.hdM);
                j = intValue;
            }
            if (this.hdR.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hdS, 0.0f, this.hdP + (this.hdS * 3000.0f), (float) (this.hdZ - 1), this.hdL);
            }
        } else {
            canvas.drawRect(3000.0f * this.hdS, 0.0f, this.hdP + (this.hdS * 3000.0f), (float) (this.hdZ - 1), this.hdL);
        }
        if (this.hdT == State.ROLLBACK) {
            canvas.drawRect(this.hdU - (((float) (this.hdY - this.lastStartTime)) * this.hdS), 0.0f, this.hdU, (float) this.hdZ, this.hdO);
        }
        if (this.hdT == State.START) {
            this.hdV += this.hdW * ((float) (currentTimeMillis - this.cSd));
            float f3 = this.hdU + this.hdV;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hdU, 0.0f, this.hdV + this.hdU, (float) (this.hdZ - 1), this.clv);
            } else {
                canvas.drawRect(this.hdU, 0.0f, getMeasuredWidth(), (float) (this.hdZ - 1), this.clv);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hdZ) + (f3 - 5.0f), (float) (this.hdZ - 1), this.hdN);
            if (this.hdK != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hdK.uI(this.mProgress);
                }
            }
        } else {
            if (this.hdK != null) {
                int measuredWidth2 = (int) ((this.hdU / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hdK.uI(this.mProgress);
                }
            }
            if (this.hdX == 0 || currentTimeMillis - this.hdX >= 800) {
                this.awS = !this.awS;
                this.hdX = System.currentTimeMillis();
            }
            if (this.awS) {
                canvas.drawRect(this.hdU - 5.0f, 0.0f, ((float) this.hdZ) + (this.hdU - 5.0f), (float) (this.hdZ - 1), this.hdN);
            }
        }
        this.cSd = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hdT = state;
        if (state != State.START) {
            this.hdV = this.hdW;
        }
        if (state == State.DELETE && this.hdR != null && !this.hdR.isEmpty()) {
            this.hdR.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hdT;
    }

    public void uH(int i) {
        this.hdR.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hdR == null || this.hdR.isEmpty()) {
            return 0;
        }
        return this.hdR.getLast().intValue();
    }

    public boolean bDy() {
        return this.hdR.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hdR;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hdR = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hdZ = i;
    }

    public void reset() {
        this.hdR.clear();
        this.hdT = State.PAUSE;
        this.hdR.clear();
        this.hdU = 0.0f;
        this.cSd = 0L;
        this.lastStartTime = 0L;
        this.hdY = 0L;
        this.mProgress = 0;
        this.hdX = 0L;
    }
}
