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
    private a kAM;
    private Paint kAN;
    private Paint kAO;
    private Paint kAP;
    private Paint kAQ;
    private Paint kAR;
    private float kAS;
    private float kAT;
    private LinkedList<Integer> kAU;
    private float kAV;
    private volatile State kAW;
    private float kAX;
    private float kAY;
    private float kAZ;
    private long kBa;
    private long kBb;
    private long kBc;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes8.dex */
    public interface a {
        void DB(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.kAU = new LinkedList<>();
        this.kAV = 0.0f;
        this.kAW = State.PAUSE;
        this.isVisible = true;
        this.kAX = 0.0f;
        this.kAY = 0.0f;
        this.kAZ = 0.0f;
        this.kBa = 0L;
        this.lastStartTime = 0L;
        this.kBb = 0L;
        this.kBc = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kAU = new LinkedList<>();
        this.kAV = 0.0f;
        this.kAW = State.PAUSE;
        this.isVisible = true;
        this.kAX = 0.0f;
        this.kAY = 0.0f;
        this.kAZ = 0.0f;
        this.kBa = 0L;
        this.lastStartTime = 0L;
        this.kBb = 0L;
        this.kBc = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kAU = new LinkedList<>();
        this.kAV = 0.0f;
        this.kAW = State.PAUSE;
        this.isVisible = true;
        this.kAX = 0.0f;
        this.kAY = 0.0f;
        this.kAZ = 0.0f;
        this.kBa = 0L;
        this.lastStartTime = 0L;
        this.kBb = 0L;
        this.kBc = 0L;
        init(context);
    }

    private void init(Context context) {
        this.kAN = new Paint();
        this.kAO = new Paint();
        this.kAP = new Paint();
        this.kAR = new Paint();
        this.kAQ = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.kAN.setStyle(Paint.Style.FILL);
        this.kAN.setColor(Color.parseColor("#33aaff"));
        this.kAO.setStyle(Paint.Style.FILL);
        this.kAO.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.kAP.setStyle(Paint.Style.FILL);
        this.kAP.setColor(Color.parseColor("#FFFFFF"));
        this.kAR.setStyle(Paint.Style.FILL);
        this.kAR.setColor(Color.parseColor("#e53917"));
        this.kAQ.setStyle(Paint.Style.FILL);
        this.kAQ.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.kAV = displayMetrics.widthPixels / 15000.0f;
        this.kAZ = this.kAV;
    }

    public void setListener(a aVar) {
        this.kAM = aVar;
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
        if (this.kBc == 0) {
            this.kBc = getHeight();
        }
        this.kAS = (float) this.kBc;
        this.kAT = (float) ((this.kBc * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.kAX = 0.0f;
        if (!this.kAU.isEmpty()) {
            Iterator<Integer> it = this.kAU.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.kBb = intValue;
                float f = this.kAX;
                this.kAX += ((float) (intValue - j)) * this.kAV;
                float f2 = this.kAX - this.kAT;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.kBc - 1), this.kAN);
                canvas.drawRect(f2, 0.0f, this.kAX, (float) (this.kBc - 1), this.kAP);
                j = intValue;
            }
            if (this.kAU.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.kAV, 0.0f, this.kAS + (this.kAV * 3000.0f), (float) (this.kBc - 1), this.kAO);
            }
        } else {
            canvas.drawRect(3000.0f * this.kAV, 0.0f, this.kAS + (this.kAV * 3000.0f), (float) (this.kBc - 1), this.kAO);
        }
        if (this.kAW == State.ROLLBACK) {
            canvas.drawRect(this.kAX - (((float) (this.kBb - this.lastStartTime)) * this.kAV), 0.0f, this.kAX, (float) this.kBc, this.kAR);
        }
        if (this.kAW == State.START) {
            this.kAY += this.kAZ * ((float) (currentTimeMillis - this.fSK));
            float f3 = this.kAX + this.kAY;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.kAX, 0.0f, this.kAY + this.kAX, (float) (this.kBc - 1), this.kAN);
            } else {
                canvas.drawRect(this.kAX, 0.0f, getMeasuredWidth(), (float) (this.kBc - 1), this.kAN);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.kBc) + (f3 - 5.0f), (float) (this.kBc - 1), this.kAQ);
            if (this.kAM != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.kAM.DB(this.mProgress);
                }
            }
        } else {
            if (this.kAM != null) {
                int measuredWidth2 = (int) ((this.kAX / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.kAM.DB(this.mProgress);
                }
            }
            if (this.kBa == 0 || currentTimeMillis - this.kBa >= 800) {
                this.isVisible = !this.isVisible;
                this.kBa = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.kAX - 5.0f, 0.0f, ((float) this.kBc) + (this.kAX - 5.0f), (float) (this.kBc - 1), this.kAQ);
            }
        }
        this.fSK = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.kAW = state;
        if (state != State.START) {
            this.kAY = this.kAZ;
        }
        if (state == State.DELETE && this.kAU != null && !this.kAU.isEmpty()) {
            this.kAU.removeLast();
        }
    }

    public State getCurrentState() {
        return this.kAW;
    }

    public void DA(int i) {
        this.kAU.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.kAU == null || this.kAU.isEmpty()) {
            return 0;
        }
        return this.kAU.getLast().intValue();
    }

    public boolean cQd() {
        return this.kAU.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.kAU;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.kAU = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.kBc = i;
    }

    public void reset() {
        this.kAU.clear();
        this.kAW = State.PAUSE;
        this.kAU.clear();
        this.kAX = 0.0f;
        this.fSK = 0L;
        this.lastStartTime = 0L;
        this.kBb = 0L;
        this.mProgress = 0;
        this.kBa = 0L;
    }
}
