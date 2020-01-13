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
    private long fSK;
    private boolean isVisible;
    private a kAH;
    private Paint kAI;
    private Paint kAJ;
    private Paint kAK;
    private Paint kAL;
    private Paint kAM;
    private float kAN;
    private float kAO;
    private LinkedList<Integer> kAP;
    private float kAQ;
    private volatile State kAR;
    private float kAS;
    private float kAT;
    private float kAU;
    private long kAV;
    private long kAW;
    private long kAX;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes8.dex */
    public interface a {
        void DB(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.kAP = new LinkedList<>();
        this.kAQ = 0.0f;
        this.kAR = State.PAUSE;
        this.isVisible = true;
        this.kAS = 0.0f;
        this.kAT = 0.0f;
        this.kAU = 0.0f;
        this.kAV = 0L;
        this.lastStartTime = 0L;
        this.kAW = 0L;
        this.kAX = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kAP = new LinkedList<>();
        this.kAQ = 0.0f;
        this.kAR = State.PAUSE;
        this.isVisible = true;
        this.kAS = 0.0f;
        this.kAT = 0.0f;
        this.kAU = 0.0f;
        this.kAV = 0L;
        this.lastStartTime = 0L;
        this.kAW = 0L;
        this.kAX = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kAP = new LinkedList<>();
        this.kAQ = 0.0f;
        this.kAR = State.PAUSE;
        this.isVisible = true;
        this.kAS = 0.0f;
        this.kAT = 0.0f;
        this.kAU = 0.0f;
        this.kAV = 0L;
        this.lastStartTime = 0L;
        this.kAW = 0L;
        this.kAX = 0L;
        init(context);
    }

    private void init(Context context) {
        this.kAI = new Paint();
        this.kAJ = new Paint();
        this.kAK = new Paint();
        this.kAM = new Paint();
        this.kAL = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.kAI.setStyle(Paint.Style.FILL);
        this.kAI.setColor(Color.parseColor("#33aaff"));
        this.kAJ.setStyle(Paint.Style.FILL);
        this.kAJ.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.kAK.setStyle(Paint.Style.FILL);
        this.kAK.setColor(Color.parseColor("#FFFFFF"));
        this.kAM.setStyle(Paint.Style.FILL);
        this.kAM.setColor(Color.parseColor("#e53917"));
        this.kAL.setStyle(Paint.Style.FILL);
        this.kAL.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.kAQ = displayMetrics.widthPixels / 15000.0f;
        this.kAU = this.kAQ;
    }

    public void setListener(a aVar) {
        this.kAH = aVar;
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
        if (this.fSK == 0) {
            this.fSK = System.currentTimeMillis();
        }
        if (this.kAX == 0) {
            this.kAX = getHeight();
        }
        this.kAN = (float) this.kAX;
        this.kAO = (float) ((this.kAX * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.kAS = 0.0f;
        if (!this.kAP.isEmpty()) {
            Iterator<Integer> it = this.kAP.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.kAW = intValue;
                float f = this.kAS;
                this.kAS += ((float) (intValue - j)) * this.kAQ;
                float f2 = this.kAS - this.kAO;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.kAX - 1), this.kAI);
                canvas.drawRect(f2, 0.0f, this.kAS, (float) (this.kAX - 1), this.kAK);
                j = intValue;
            }
            if (this.kAP.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.kAQ, 0.0f, this.kAN + (this.kAQ * 3000.0f), (float) (this.kAX - 1), this.kAJ);
            }
        } else {
            canvas.drawRect(3000.0f * this.kAQ, 0.0f, this.kAN + (this.kAQ * 3000.0f), (float) (this.kAX - 1), this.kAJ);
        }
        if (this.kAR == State.ROLLBACK) {
            canvas.drawRect(this.kAS - (((float) (this.kAW - this.lastStartTime)) * this.kAQ), 0.0f, this.kAS, (float) this.kAX, this.kAM);
        }
        if (this.kAR == State.START) {
            this.kAT += this.kAU * ((float) (currentTimeMillis - this.fSK));
            float f3 = this.kAS + this.kAT;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.kAS, 0.0f, this.kAT + this.kAS, (float) (this.kAX - 1), this.kAI);
            } else {
                canvas.drawRect(this.kAS, 0.0f, getMeasuredWidth(), (float) (this.kAX - 1), this.kAI);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.kAX) + (f3 - 5.0f), (float) (this.kAX - 1), this.kAL);
            if (this.kAH != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.kAH.DB(this.mProgress);
                }
            }
        } else {
            if (this.kAH != null) {
                int measuredWidth2 = (int) ((this.kAS / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.kAH.DB(this.mProgress);
                }
            }
            if (this.kAV == 0 || currentTimeMillis - this.kAV >= 800) {
                this.isVisible = !this.isVisible;
                this.kAV = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.kAS - 5.0f, 0.0f, ((float) this.kAX) + (this.kAS - 5.0f), (float) (this.kAX - 1), this.kAL);
            }
        }
        this.fSK = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.kAR = state;
        if (state != State.START) {
            this.kAT = this.kAU;
        }
        if (state == State.DELETE && this.kAP != null && !this.kAP.isEmpty()) {
            this.kAP.removeLast();
        }
    }

    public State getCurrentState() {
        return this.kAR;
    }

    public void DA(int i) {
        this.kAP.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.kAP == null || this.kAP.isEmpty()) {
            return 0;
        }
        return this.kAP.getLast().intValue();
    }

    public boolean cQb() {
        return this.kAP.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.kAP;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.kAP = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.kAX = i;
    }

    public void reset() {
        this.kAP.clear();
        this.kAR = State.PAUSE;
        this.kAP.clear();
        this.kAS = 0.0f;
        this.fSK = 0L;
        this.lastStartTime = 0L;
        this.kAW = 0L;
        this.mProgress = 0;
        this.kAV = 0L;
    }
}
