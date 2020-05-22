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
    private boolean dWj;
    private long gPK;
    private a lGM;
    private Paint lGN;
    private Paint lGO;
    private Paint lGP;
    private Paint lGQ;
    private Paint lGR;
    private float lGS;
    private float lGT;
    private LinkedList<Integer> lGU;
    private float lGV;
    private volatile State lGW;
    private float lGX;
    private float lGY;
    private float lGZ;
    private long lHa;
    private long lHb;
    private long lHc;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes10.dex */
    public interface a {
        void Fe(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.lGU = new LinkedList<>();
        this.lGV = 0.0f;
        this.lGW = State.PAUSE;
        this.dWj = true;
        this.lGX = 0.0f;
        this.lGY = 0.0f;
        this.lGZ = 0.0f;
        this.lHa = 0L;
        this.lastStartTime = 0L;
        this.lHb = 0L;
        this.lHc = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lGU = new LinkedList<>();
        this.lGV = 0.0f;
        this.lGW = State.PAUSE;
        this.dWj = true;
        this.lGX = 0.0f;
        this.lGY = 0.0f;
        this.lGZ = 0.0f;
        this.lHa = 0L;
        this.lastStartTime = 0L;
        this.lHb = 0L;
        this.lHc = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lGU = new LinkedList<>();
        this.lGV = 0.0f;
        this.lGW = State.PAUSE;
        this.dWj = true;
        this.lGX = 0.0f;
        this.lGY = 0.0f;
        this.lGZ = 0.0f;
        this.lHa = 0L;
        this.lastStartTime = 0L;
        this.lHb = 0L;
        this.lHc = 0L;
        init(context);
    }

    private void init(Context context) {
        this.lGN = new Paint();
        this.lGO = new Paint();
        this.lGP = new Paint();
        this.lGR = new Paint();
        this.lGQ = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.lGN.setStyle(Paint.Style.FILL);
        this.lGN.setColor(Color.parseColor("#33aaff"));
        this.lGO.setStyle(Paint.Style.FILL);
        this.lGO.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.lGP.setStyle(Paint.Style.FILL);
        this.lGP.setColor(Color.parseColor("#FFFFFF"));
        this.lGR.setStyle(Paint.Style.FILL);
        this.lGR.setColor(Color.parseColor("#e53917"));
        this.lGQ.setStyle(Paint.Style.FILL);
        this.lGQ.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.lGV = displayMetrics.widthPixels / 15000.0f;
        this.lGZ = this.lGV;
    }

    public void setListener(a aVar) {
        this.lGM = aVar;
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
        if (this.gPK == 0) {
            this.gPK = System.currentTimeMillis();
        }
        if (this.lHc == 0) {
            this.lHc = getHeight();
        }
        this.lGS = (float) this.lHc;
        this.lGT = (float) ((this.lHc * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.lGX = 0.0f;
        if (!this.lGU.isEmpty()) {
            Iterator<Integer> it = this.lGU.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.lHb = intValue;
                float f = this.lGX;
                this.lGX += ((float) (intValue - j)) * this.lGV;
                float f2 = this.lGX - this.lGT;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.lHc - 1), this.lGN);
                canvas.drawRect(f2, 0.0f, this.lGX, (float) (this.lHc - 1), this.lGP);
                j = intValue;
            }
            if (this.lGU.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.lGV, 0.0f, this.lGS + (this.lGV * 3000.0f), (float) (this.lHc - 1), this.lGO);
            }
        } else {
            canvas.drawRect(3000.0f * this.lGV, 0.0f, this.lGS + (this.lGV * 3000.0f), (float) (this.lHc - 1), this.lGO);
        }
        if (this.lGW == State.ROLLBACK) {
            canvas.drawRect(this.lGX - (((float) (this.lHb - this.lastStartTime)) * this.lGV), 0.0f, this.lGX, (float) this.lHc, this.lGR);
        }
        if (this.lGW == State.START) {
            this.lGY += this.lGZ * ((float) (currentTimeMillis - this.gPK));
            float f3 = this.lGX + this.lGY;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.lGX, 0.0f, this.lGY + this.lGX, (float) (this.lHc - 1), this.lGN);
            } else {
                canvas.drawRect(this.lGX, 0.0f, getMeasuredWidth(), (float) (this.lHc - 1), this.lGN);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.lHc) + (f3 - 5.0f), (float) (this.lHc - 1), this.lGQ);
            if (this.lGM != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.lGM.Fe(this.mProgress);
                }
            }
        } else {
            if (this.lGM != null) {
                int measuredWidth2 = (int) ((this.lGX / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.lGM.Fe(this.mProgress);
                }
            }
            if (this.lHa == 0 || currentTimeMillis - this.lHa >= 800) {
                this.dWj = !this.dWj;
                this.lHa = System.currentTimeMillis();
            }
            if (this.dWj) {
                canvas.drawRect(this.lGX - 5.0f, 0.0f, ((float) this.lHc) + (this.lGX - 5.0f), (float) (this.lHc - 1), this.lGQ);
            }
        }
        this.gPK = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.lGW = state;
        if (state != State.START) {
            this.lGY = this.lGZ;
        }
        if (state == State.DELETE && this.lGU != null && !this.lGU.isEmpty()) {
            this.lGU.removeLast();
        }
    }

    public State getCurrentState() {
        return this.lGW;
    }

    public void Fd(int i) {
        this.lGU.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.lGU == null || this.lGU.isEmpty()) {
            return 0;
        }
        return this.lGU.getLast().intValue();
    }

    public boolean dkf() {
        return this.lGU.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.lGU;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.lGU = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.lHc = i;
    }

    public void reset() {
        this.lGU.clear();
        this.lGW = State.PAUSE;
        this.lGU.clear();
        this.lGX = 0.0f;
        this.gPK = 0L;
        this.lastStartTime = 0L;
        this.lHb = 0L;
        this.mProgress = 0;
        this.lHa = 0L;
    }
}
