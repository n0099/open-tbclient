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
    private long fVg;
    private boolean isVisible;
    private a kBJ;
    private Paint kBK;
    private Paint kBL;
    private Paint kBM;
    private Paint kBN;
    private Paint kBO;
    private float kBP;
    private float kBQ;
    private LinkedList<Integer> kBR;
    private float kBS;
    private volatile State kBT;
    private float kBU;
    private float kBV;
    private float kBW;
    private long kBX;
    private long kBY;
    private long kBZ;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes10.dex */
    public interface a {
        void DH(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.kBR = new LinkedList<>();
        this.kBS = 0.0f;
        this.kBT = State.PAUSE;
        this.isVisible = true;
        this.kBU = 0.0f;
        this.kBV = 0.0f;
        this.kBW = 0.0f;
        this.kBX = 0L;
        this.lastStartTime = 0L;
        this.kBY = 0L;
        this.kBZ = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kBR = new LinkedList<>();
        this.kBS = 0.0f;
        this.kBT = State.PAUSE;
        this.isVisible = true;
        this.kBU = 0.0f;
        this.kBV = 0.0f;
        this.kBW = 0.0f;
        this.kBX = 0L;
        this.lastStartTime = 0L;
        this.kBY = 0L;
        this.kBZ = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kBR = new LinkedList<>();
        this.kBS = 0.0f;
        this.kBT = State.PAUSE;
        this.isVisible = true;
        this.kBU = 0.0f;
        this.kBV = 0.0f;
        this.kBW = 0.0f;
        this.kBX = 0L;
        this.lastStartTime = 0L;
        this.kBY = 0L;
        this.kBZ = 0L;
        init(context);
    }

    private void init(Context context) {
        this.kBK = new Paint();
        this.kBL = new Paint();
        this.kBM = new Paint();
        this.kBO = new Paint();
        this.kBN = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.kBK.setStyle(Paint.Style.FILL);
        this.kBK.setColor(Color.parseColor("#33aaff"));
        this.kBL.setStyle(Paint.Style.FILL);
        this.kBL.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.kBM.setStyle(Paint.Style.FILL);
        this.kBM.setColor(Color.parseColor("#FFFFFF"));
        this.kBO.setStyle(Paint.Style.FILL);
        this.kBO.setColor(Color.parseColor("#e53917"));
        this.kBN.setStyle(Paint.Style.FILL);
        this.kBN.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.kBS = displayMetrics.widthPixels / 15000.0f;
        this.kBW = this.kBS;
    }

    public void setListener(a aVar) {
        this.kBJ = aVar;
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
        if (this.fVg == 0) {
            this.fVg = System.currentTimeMillis();
        }
        if (this.kBZ == 0) {
            this.kBZ = getHeight();
        }
        this.kBP = (float) this.kBZ;
        this.kBQ = (float) ((this.kBZ * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.kBU = 0.0f;
        if (!this.kBR.isEmpty()) {
            Iterator<Integer> it = this.kBR.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.kBY = intValue;
                float f = this.kBU;
                this.kBU += ((float) (intValue - j)) * this.kBS;
                float f2 = this.kBU - this.kBQ;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.kBZ - 1), this.kBK);
                canvas.drawRect(f2, 0.0f, this.kBU, (float) (this.kBZ - 1), this.kBM);
                j = intValue;
            }
            if (this.kBR.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.kBS, 0.0f, this.kBP + (this.kBS * 3000.0f), (float) (this.kBZ - 1), this.kBL);
            }
        } else {
            canvas.drawRect(3000.0f * this.kBS, 0.0f, this.kBP + (this.kBS * 3000.0f), (float) (this.kBZ - 1), this.kBL);
        }
        if (this.kBT == State.ROLLBACK) {
            canvas.drawRect(this.kBU - (((float) (this.kBY - this.lastStartTime)) * this.kBS), 0.0f, this.kBU, (float) this.kBZ, this.kBO);
        }
        if (this.kBT == State.START) {
            this.kBV += this.kBW * ((float) (currentTimeMillis - this.fVg));
            float f3 = this.kBU + this.kBV;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.kBU, 0.0f, this.kBV + this.kBU, (float) (this.kBZ - 1), this.kBK);
            } else {
                canvas.drawRect(this.kBU, 0.0f, getMeasuredWidth(), (float) (this.kBZ - 1), this.kBK);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.kBZ) + (f3 - 5.0f), (float) (this.kBZ - 1), this.kBN);
            if (this.kBJ != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.kBJ.DH(this.mProgress);
                }
            }
        } else {
            if (this.kBJ != null) {
                int measuredWidth2 = (int) ((this.kBU / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.kBJ.DH(this.mProgress);
                }
            }
            if (this.kBX == 0 || currentTimeMillis - this.kBX >= 800) {
                this.isVisible = !this.isVisible;
                this.kBX = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.kBU - 5.0f, 0.0f, ((float) this.kBZ) + (this.kBU - 5.0f), (float) (this.kBZ - 1), this.kBN);
            }
        }
        this.fVg = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.kBT = state;
        if (state != State.START) {
            this.kBV = this.kBW;
        }
        if (state == State.DELETE && this.kBR != null && !this.kBR.isEmpty()) {
            this.kBR.removeLast();
        }
    }

    public State getCurrentState() {
        return this.kBT;
    }

    public void DG(int i) {
        this.kBR.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.kBR == null || this.kBR.isEmpty()) {
            return 0;
        }
        return this.kBR.getLast().intValue();
    }

    public boolean cRy() {
        return this.kBR.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.kBR;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.kBR = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.kBZ = i;
    }

    public void reset() {
        this.kBR.clear();
        this.kBT = State.PAUSE;
        this.kBR.clear();
        this.kBU = 0.0f;
        this.fVg = 0L;
        this.lastStartTime = 0L;
        this.kBY = 0L;
        this.mProgress = 0;
        this.kBX = 0L;
    }
}
