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
/* loaded from: classes5.dex */
public class ProgressView extends View {
    private boolean cbt;
    private long eXm;
    private a jAP;
    private Paint jAQ;
    private Paint jAR;
    private Paint jAS;
    private Paint jAT;
    private Paint jAU;
    private float jAV;
    private float jAW;
    private LinkedList<Integer> jAX;
    private float jAY;
    private volatile State jAZ;
    private float jBa;
    private float jBb;
    private float jBc;
    private long jBd;
    private long jBe;
    private long jBf;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void Cp(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.jAX = new LinkedList<>();
        this.jAY = 0.0f;
        this.jAZ = State.PAUSE;
        this.cbt = true;
        this.jBa = 0.0f;
        this.jBb = 0.0f;
        this.jBc = 0.0f;
        this.jBd = 0L;
        this.lastStartTime = 0L;
        this.jBe = 0L;
        this.jBf = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jAX = new LinkedList<>();
        this.jAY = 0.0f;
        this.jAZ = State.PAUSE;
        this.cbt = true;
        this.jBa = 0.0f;
        this.jBb = 0.0f;
        this.jBc = 0.0f;
        this.jBd = 0L;
        this.lastStartTime = 0L;
        this.jBe = 0L;
        this.jBf = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jAX = new LinkedList<>();
        this.jAY = 0.0f;
        this.jAZ = State.PAUSE;
        this.cbt = true;
        this.jBa = 0.0f;
        this.jBb = 0.0f;
        this.jBc = 0.0f;
        this.jBd = 0L;
        this.lastStartTime = 0L;
        this.jBe = 0L;
        this.jBf = 0L;
        init(context);
    }

    private void init(Context context) {
        this.jAQ = new Paint();
        this.jAR = new Paint();
        this.jAS = new Paint();
        this.jAU = new Paint();
        this.jAT = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.jAQ.setStyle(Paint.Style.FILL);
        this.jAQ.setColor(Color.parseColor("#33aaff"));
        this.jAR.setStyle(Paint.Style.FILL);
        this.jAR.setColor(Color.rgb(51, 170, 255));
        this.jAS.setStyle(Paint.Style.FILL);
        this.jAS.setColor(Color.parseColor("#FFFFFF"));
        this.jAU.setStyle(Paint.Style.FILL);
        this.jAU.setColor(Color.parseColor("#e53917"));
        this.jAT.setStyle(Paint.Style.FILL);
        this.jAT.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.jAY = displayMetrics.widthPixels / 15000.0f;
        this.jBc = this.jAY;
    }

    public void setListener(a aVar) {
        this.jAP = aVar;
    }

    /* loaded from: classes5.dex */
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
        if (this.eXm == 0) {
            this.eXm = System.currentTimeMillis();
        }
        if (this.jBf == 0) {
            this.jBf = getHeight();
        }
        this.jAV = (float) this.jBf;
        this.jAW = (float) ((this.jBf * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.jBa = 0.0f;
        if (!this.jAX.isEmpty()) {
            Iterator<Integer> it = this.jAX.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.jBe = intValue;
                float f = this.jBa;
                this.jBa += ((float) (intValue - j)) * this.jAY;
                float f2 = this.jBa - this.jAW;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.jBf - 1), this.jAQ);
                canvas.drawRect(f2, 0.0f, this.jBa, (float) (this.jBf - 1), this.jAS);
                j = intValue;
            }
            if (this.jAX.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.jAY, 0.0f, this.jAV + (this.jAY * 3000.0f), (float) (this.jBf - 1), this.jAR);
            }
        } else {
            canvas.drawRect(3000.0f * this.jAY, 0.0f, this.jAV + (this.jAY * 3000.0f), (float) (this.jBf - 1), this.jAR);
        }
        if (this.jAZ == State.ROLLBACK) {
            canvas.drawRect(this.jBa - (((float) (this.jBe - this.lastStartTime)) * this.jAY), 0.0f, this.jBa, (float) this.jBf, this.jAU);
        }
        if (this.jAZ == State.START) {
            this.jBb += this.jBc * ((float) (currentTimeMillis - this.eXm));
            float f3 = this.jBa + this.jBb;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.jBa, 0.0f, this.jBb + this.jBa, (float) (this.jBf - 1), this.jAQ);
            } else {
                canvas.drawRect(this.jBa, 0.0f, getMeasuredWidth(), (float) (this.jBf - 1), this.jAQ);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.jBf) + (f3 - 5.0f), (float) (this.jBf - 1), this.jAT);
            if (this.jAP != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.jAP.Cp(this.mProgress);
                }
            }
        } else {
            if (this.jAP != null) {
                int measuredWidth2 = (int) ((this.jBa / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.jAP.Cp(this.mProgress);
                }
            }
            if (this.jBd == 0 || currentTimeMillis - this.jBd >= 800) {
                this.cbt = !this.cbt;
                this.jBd = System.currentTimeMillis();
            }
            if (this.cbt) {
                canvas.drawRect(this.jBa - 5.0f, 0.0f, ((float) this.jBf) + (this.jBa - 5.0f), (float) (this.jBf - 1), this.jAT);
            }
        }
        this.eXm = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.jAZ = state;
        if (state != State.START) {
            this.jBb = this.jBc;
        }
        if (state == State.DELETE && this.jAX != null && !this.jAX.isEmpty()) {
            this.jAX.removeLast();
        }
    }

    public State getCurrentState() {
        return this.jAZ;
    }

    public void Co(int i) {
        this.jAX.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.jAX == null || this.jAX.isEmpty()) {
            return 0;
        }
        return this.jAX.getLast().intValue();
    }

    public boolean cwg() {
        return this.jAX.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.jAX;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.jAX = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.jBf = i;
    }

    public void reset() {
        this.jAX.clear();
        this.jAZ = State.PAUSE;
        this.jAX.clear();
        this.jBa = 0.0f;
        this.eXm = 0L;
        this.lastStartTime = 0L;
        this.jBe = 0L;
        this.mProgress = 0;
        this.jBd = 0L;
    }
}
