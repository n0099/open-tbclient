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
/* loaded from: classes17.dex */
public class ProgressView extends View {
    private boolean etK;
    private long hvn;
    private long lastStartTime;
    private a mAP;
    private Paint mAQ;
    private Paint mAR;
    private Paint mAS;
    private Paint mAT;
    private Paint mAU;
    private float mAV;
    private float mAW;
    private LinkedList<Integer> mAX;
    private float mAY;
    private volatile State mAZ;
    private float mBa;
    private float mBb;
    private float mBc;
    private long mBd;
    private long mBe;
    private long mBf;
    private int mProgress;

    /* loaded from: classes17.dex */
    public interface a {
        void Jb(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.mAX = new LinkedList<>();
        this.mAY = 0.0f;
        this.mAZ = State.PAUSE;
        this.etK = true;
        this.mBa = 0.0f;
        this.mBb = 0.0f;
        this.mBc = 0.0f;
        this.mBd = 0L;
        this.lastStartTime = 0L;
        this.mBe = 0L;
        this.mBf = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAX = new LinkedList<>();
        this.mAY = 0.0f;
        this.mAZ = State.PAUSE;
        this.etK = true;
        this.mBa = 0.0f;
        this.mBb = 0.0f;
        this.mBc = 0.0f;
        this.mBd = 0L;
        this.lastStartTime = 0L;
        this.mBe = 0L;
        this.mBf = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mAX = new LinkedList<>();
        this.mAY = 0.0f;
        this.mAZ = State.PAUSE;
        this.etK = true;
        this.mBa = 0.0f;
        this.mBb = 0.0f;
        this.mBc = 0.0f;
        this.mBd = 0L;
        this.lastStartTime = 0L;
        this.mBe = 0L;
        this.mBf = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mAQ = new Paint();
        this.mAR = new Paint();
        this.mAS = new Paint();
        this.mAU = new Paint();
        this.mAT = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.mAQ.setStyle(Paint.Style.FILL);
        this.mAQ.setColor(Color.parseColor("#33aaff"));
        this.mAR.setStyle(Paint.Style.FILL);
        this.mAR.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.mAS.setStyle(Paint.Style.FILL);
        this.mAS.setColor(Color.parseColor("#FFFFFF"));
        this.mAU.setStyle(Paint.Style.FILL);
        this.mAU.setColor(Color.parseColor("#e53917"));
        this.mAT.setStyle(Paint.Style.FILL);
        this.mAT.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mAY = displayMetrics.widthPixels / 15000.0f;
        this.mBc = this.mAY;
    }

    public void setListener(a aVar) {
        this.mAP = aVar;
    }

    /* loaded from: classes17.dex */
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
        if (this.hvn == 0) {
            this.hvn = System.currentTimeMillis();
        }
        if (this.mBf == 0) {
            this.mBf = getHeight();
        }
        this.mAV = (float) this.mBf;
        this.mAW = (float) ((this.mBf * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.mBa = 0.0f;
        if (!this.mAX.isEmpty()) {
            Iterator<Integer> it = this.mAX.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.mBe = intValue;
                float f = this.mBa;
                this.mBa += ((float) (intValue - j)) * this.mAY;
                float f2 = this.mBa - this.mAW;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.mBf - 1), this.mAQ);
                canvas.drawRect(f2, 0.0f, this.mBa, (float) (this.mBf - 1), this.mAS);
                j = intValue;
            }
            if (this.mAX.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.mAY, 0.0f, this.mAV + (this.mAY * 3000.0f), (float) (this.mBf - 1), this.mAR);
            }
        } else {
            canvas.drawRect(3000.0f * this.mAY, 0.0f, this.mAV + (this.mAY * 3000.0f), (float) (this.mBf - 1), this.mAR);
        }
        if (this.mAZ == State.ROLLBACK) {
            canvas.drawRect(this.mBa - (((float) (this.mBe - this.lastStartTime)) * this.mAY), 0.0f, this.mBa, (float) this.mBf, this.mAU);
        }
        if (this.mAZ == State.START) {
            this.mBb += this.mBc * ((float) (currentTimeMillis - this.hvn));
            float f3 = this.mBa + this.mBb;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.mBa, 0.0f, this.mBb + this.mBa, (float) (this.mBf - 1), this.mAQ);
            } else {
                canvas.drawRect(this.mBa, 0.0f, getMeasuredWidth(), (float) (this.mBf - 1), this.mAQ);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.mBf) + (f3 - 5.0f), (float) (this.mBf - 1), this.mAT);
            if (this.mAP != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.mAP.Jb(this.mProgress);
                }
            }
        } else {
            if (this.mAP != null) {
                int measuredWidth2 = (int) ((this.mBa / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.mAP.Jb(this.mProgress);
                }
            }
            if (this.mBd == 0 || currentTimeMillis - this.mBd >= 800) {
                this.etK = !this.etK;
                this.mBd = System.currentTimeMillis();
            }
            if (this.etK) {
                canvas.drawRect(this.mBa - 5.0f, 0.0f, ((float) this.mBf) + (this.mBa - 5.0f), (float) (this.mBf - 1), this.mAT);
            }
        }
        this.hvn = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.mAZ = state;
        if (state != State.START) {
            this.mBb = this.mBc;
        }
        if (state == State.DELETE && this.mAX != null && !this.mAX.isEmpty()) {
            this.mAX.removeLast();
        }
    }

    public State getCurrentState() {
        return this.mAZ;
    }

    public void Ja(int i) {
        this.mAX.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.mAX == null || this.mAX.isEmpty()) {
            return 0;
        }
        return this.mAX.getLast().intValue();
    }

    public boolean dDp() {
        return this.mAX.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.mAX;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.mAX = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.mBf = i;
    }

    public void reset() {
        this.mAX.clear();
        this.mAZ = State.PAUSE;
        this.mAX.clear();
        this.mBa = 0.0f;
        this.hvn = 0L;
        this.lastStartTime = 0L;
        this.mBe = 0L;
        this.mProgress = 0;
        this.mBd = 0L;
    }
}
