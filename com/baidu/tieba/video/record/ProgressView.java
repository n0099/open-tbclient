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
    private boolean edF;
    private long hcE;
    private long lastStartTime;
    private int mProgress;
    private a mbM;
    private Paint mbN;
    private Paint mbO;
    private Paint mbP;
    private Paint mbQ;
    private Paint mbR;
    private float mbS;
    private float mbT;
    private LinkedList<Integer> mbU;
    private float mbV;
    private volatile State mbW;
    private float mbX;
    private float mbY;
    private float mbZ;
    private long mca;
    private long mcb;
    private long mcc;

    /* loaded from: classes10.dex */
    public interface a {
        void Gj(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.mbU = new LinkedList<>();
        this.mbV = 0.0f;
        this.mbW = State.PAUSE;
        this.edF = true;
        this.mbX = 0.0f;
        this.mbY = 0.0f;
        this.mbZ = 0.0f;
        this.mca = 0L;
        this.lastStartTime = 0L;
        this.mcb = 0L;
        this.mcc = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mbU = new LinkedList<>();
        this.mbV = 0.0f;
        this.mbW = State.PAUSE;
        this.edF = true;
        this.mbX = 0.0f;
        this.mbY = 0.0f;
        this.mbZ = 0.0f;
        this.mca = 0L;
        this.lastStartTime = 0L;
        this.mcb = 0L;
        this.mcc = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mbU = new LinkedList<>();
        this.mbV = 0.0f;
        this.mbW = State.PAUSE;
        this.edF = true;
        this.mbX = 0.0f;
        this.mbY = 0.0f;
        this.mbZ = 0.0f;
        this.mca = 0L;
        this.lastStartTime = 0L;
        this.mcb = 0L;
        this.mcc = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mbN = new Paint();
        this.mbO = new Paint();
        this.mbP = new Paint();
        this.mbR = new Paint();
        this.mbQ = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.mbN.setStyle(Paint.Style.FILL);
        this.mbN.setColor(Color.parseColor("#33aaff"));
        this.mbO.setStyle(Paint.Style.FILL);
        this.mbO.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.mbP.setStyle(Paint.Style.FILL);
        this.mbP.setColor(Color.parseColor("#FFFFFF"));
        this.mbR.setStyle(Paint.Style.FILL);
        this.mbR.setColor(Color.parseColor("#e53917"));
        this.mbQ.setStyle(Paint.Style.FILL);
        this.mbQ.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mbV = displayMetrics.widthPixels / 15000.0f;
        this.mbZ = this.mbV;
    }

    public void setListener(a aVar) {
        this.mbM = aVar;
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
        if (this.hcE == 0) {
            this.hcE = System.currentTimeMillis();
        }
        if (this.mcc == 0) {
            this.mcc = getHeight();
        }
        this.mbS = (float) this.mcc;
        this.mbT = (float) ((this.mcc * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.mbX = 0.0f;
        if (!this.mbU.isEmpty()) {
            Iterator<Integer> it = this.mbU.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.mcb = intValue;
                float f = this.mbX;
                this.mbX += ((float) (intValue - j)) * this.mbV;
                float f2 = this.mbX - this.mbT;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.mcc - 1), this.mbN);
                canvas.drawRect(f2, 0.0f, this.mbX, (float) (this.mcc - 1), this.mbP);
                j = intValue;
            }
            if (this.mbU.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.mbV, 0.0f, this.mbS + (this.mbV * 3000.0f), (float) (this.mcc - 1), this.mbO);
            }
        } else {
            canvas.drawRect(3000.0f * this.mbV, 0.0f, this.mbS + (this.mbV * 3000.0f), (float) (this.mcc - 1), this.mbO);
        }
        if (this.mbW == State.ROLLBACK) {
            canvas.drawRect(this.mbX - (((float) (this.mcb - this.lastStartTime)) * this.mbV), 0.0f, this.mbX, (float) this.mcc, this.mbR);
        }
        if (this.mbW == State.START) {
            this.mbY += this.mbZ * ((float) (currentTimeMillis - this.hcE));
            float f3 = this.mbX + this.mbY;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.mbX, 0.0f, this.mbY + this.mbX, (float) (this.mcc - 1), this.mbN);
            } else {
                canvas.drawRect(this.mbX, 0.0f, getMeasuredWidth(), (float) (this.mcc - 1), this.mbN);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.mcc) + (f3 - 5.0f), (float) (this.mcc - 1), this.mbQ);
            if (this.mbM != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.mbM.Gj(this.mProgress);
                }
            }
        } else {
            if (this.mbM != null) {
                int measuredWidth2 = (int) ((this.mbX / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.mbM.Gj(this.mProgress);
                }
            }
            if (this.mca == 0 || currentTimeMillis - this.mca >= 800) {
                this.edF = !this.edF;
                this.mca = System.currentTimeMillis();
            }
            if (this.edF) {
                canvas.drawRect(this.mbX - 5.0f, 0.0f, ((float) this.mcc) + (this.mbX - 5.0f), (float) (this.mcc - 1), this.mbQ);
            }
        }
        this.hcE = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.mbW = state;
        if (state != State.START) {
            this.mbY = this.mbZ;
        }
        if (state == State.DELETE && this.mbU != null && !this.mbU.isEmpty()) {
            this.mbU.removeLast();
        }
    }

    public State getCurrentState() {
        return this.mbW;
    }

    public void Gi(int i) {
        this.mbU.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.mbU == null || this.mbU.isEmpty()) {
            return 0;
        }
        return this.mbU.getLast().intValue();
    }

    public boolean doG() {
        return this.mbU.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.mbU;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.mbU = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.mcc = i;
    }

    public void reset() {
        this.mbU.clear();
        this.mbW = State.PAUSE;
        this.mbU.clear();
        this.mbX = 0.0f;
        this.hcE = 0L;
        this.lastStartTime = 0L;
        this.mcb = 0L;
        this.mProgress = 0;
        this.mca = 0L;
    }
}
