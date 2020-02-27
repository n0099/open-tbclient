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
    private long fVe;
    private boolean isVisible;
    private a kBH;
    private Paint kBI;
    private Paint kBJ;
    private Paint kBK;
    private Paint kBL;
    private Paint kBM;
    private float kBN;
    private float kBO;
    private LinkedList<Integer> kBP;
    private float kBQ;
    private volatile State kBR;
    private float kBS;
    private float kBT;
    private float kBU;
    private long kBV;
    private long kBW;
    private long kBX;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes10.dex */
    public interface a {
        void DH(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.kBP = new LinkedList<>();
        this.kBQ = 0.0f;
        this.kBR = State.PAUSE;
        this.isVisible = true;
        this.kBS = 0.0f;
        this.kBT = 0.0f;
        this.kBU = 0.0f;
        this.kBV = 0L;
        this.lastStartTime = 0L;
        this.kBW = 0L;
        this.kBX = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kBP = new LinkedList<>();
        this.kBQ = 0.0f;
        this.kBR = State.PAUSE;
        this.isVisible = true;
        this.kBS = 0.0f;
        this.kBT = 0.0f;
        this.kBU = 0.0f;
        this.kBV = 0L;
        this.lastStartTime = 0L;
        this.kBW = 0L;
        this.kBX = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kBP = new LinkedList<>();
        this.kBQ = 0.0f;
        this.kBR = State.PAUSE;
        this.isVisible = true;
        this.kBS = 0.0f;
        this.kBT = 0.0f;
        this.kBU = 0.0f;
        this.kBV = 0L;
        this.lastStartTime = 0L;
        this.kBW = 0L;
        this.kBX = 0L;
        init(context);
    }

    private void init(Context context) {
        this.kBI = new Paint();
        this.kBJ = new Paint();
        this.kBK = new Paint();
        this.kBM = new Paint();
        this.kBL = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.kBI.setStyle(Paint.Style.FILL);
        this.kBI.setColor(Color.parseColor("#33aaff"));
        this.kBJ.setStyle(Paint.Style.FILL);
        this.kBJ.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.kBK.setStyle(Paint.Style.FILL);
        this.kBK.setColor(Color.parseColor("#FFFFFF"));
        this.kBM.setStyle(Paint.Style.FILL);
        this.kBM.setColor(Color.parseColor("#e53917"));
        this.kBL.setStyle(Paint.Style.FILL);
        this.kBL.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.kBQ = displayMetrics.widthPixels / 15000.0f;
        this.kBU = this.kBQ;
    }

    public void setListener(a aVar) {
        this.kBH = aVar;
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
        if (this.fVe == 0) {
            this.fVe = System.currentTimeMillis();
        }
        if (this.kBX == 0) {
            this.kBX = getHeight();
        }
        this.kBN = (float) this.kBX;
        this.kBO = (float) ((this.kBX * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.kBS = 0.0f;
        if (!this.kBP.isEmpty()) {
            Iterator<Integer> it = this.kBP.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.kBW = intValue;
                float f = this.kBS;
                this.kBS += ((float) (intValue - j)) * this.kBQ;
                float f2 = this.kBS - this.kBO;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.kBX - 1), this.kBI);
                canvas.drawRect(f2, 0.0f, this.kBS, (float) (this.kBX - 1), this.kBK);
                j = intValue;
            }
            if (this.kBP.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.kBQ, 0.0f, this.kBN + (this.kBQ * 3000.0f), (float) (this.kBX - 1), this.kBJ);
            }
        } else {
            canvas.drawRect(3000.0f * this.kBQ, 0.0f, this.kBN + (this.kBQ * 3000.0f), (float) (this.kBX - 1), this.kBJ);
        }
        if (this.kBR == State.ROLLBACK) {
            canvas.drawRect(this.kBS - (((float) (this.kBW - this.lastStartTime)) * this.kBQ), 0.0f, this.kBS, (float) this.kBX, this.kBM);
        }
        if (this.kBR == State.START) {
            this.kBT += this.kBU * ((float) (currentTimeMillis - this.fVe));
            float f3 = this.kBS + this.kBT;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.kBS, 0.0f, this.kBT + this.kBS, (float) (this.kBX - 1), this.kBI);
            } else {
                canvas.drawRect(this.kBS, 0.0f, getMeasuredWidth(), (float) (this.kBX - 1), this.kBI);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.kBX) + (f3 - 5.0f), (float) (this.kBX - 1), this.kBL);
            if (this.kBH != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.kBH.DH(this.mProgress);
                }
            }
        } else {
            if (this.kBH != null) {
                int measuredWidth2 = (int) ((this.kBS / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.kBH.DH(this.mProgress);
                }
            }
            if (this.kBV == 0 || currentTimeMillis - this.kBV >= 800) {
                this.isVisible = !this.isVisible;
                this.kBV = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.kBS - 5.0f, 0.0f, ((float) this.kBX) + (this.kBS - 5.0f), (float) (this.kBX - 1), this.kBL);
            }
        }
        this.fVe = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.kBR = state;
        if (state != State.START) {
            this.kBT = this.kBU;
        }
        if (state == State.DELETE && this.kBP != null && !this.kBP.isEmpty()) {
            this.kBP.removeLast();
        }
    }

    public State getCurrentState() {
        return this.kBR;
    }

    public void DG(int i) {
        this.kBP.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.kBP == null || this.kBP.isEmpty()) {
            return 0;
        }
        return this.kBP.getLast().intValue();
    }

    public boolean cRw() {
        return this.kBP.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.kBP;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.kBP = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.kBX = i;
    }

    public void reset() {
        this.kBP.clear();
        this.kBR = State.PAUSE;
        this.kBP.clear();
        this.kBS = 0.0f;
        this.fVe = 0L;
        this.lastStartTime = 0L;
        this.kBW = 0L;
        this.mProgress = 0;
        this.kBV = 0L;
    }
}
