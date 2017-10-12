package com.baidu.tieba.video.record;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class ProgressView extends View {
    private boolean anb;
    private long cde;
    private a gzJ;
    private Paint gzK;
    private Paint gzL;
    private Paint gzM;
    private Paint gzN;
    private Paint gzO;
    private float gzP;
    private float gzQ;
    private LinkedList<Integer> gzR;
    private float gzS;
    private volatile State gzT;
    private float gzU;
    private float gzV;
    private float gzW;
    private long gzX;
    private long gzY;
    private long gzZ;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void uE(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.gzR = new LinkedList<>();
        this.gzS = 0.0f;
        this.gzT = State.PAUSE;
        this.anb = true;
        this.gzU = 0.0f;
        this.gzV = 0.0f;
        this.gzW = 0.0f;
        this.gzX = 0L;
        this.lastStartTime = 0L;
        this.gzY = 0L;
        this.gzZ = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gzR = new LinkedList<>();
        this.gzS = 0.0f;
        this.gzT = State.PAUSE;
        this.anb = true;
        this.gzU = 0.0f;
        this.gzV = 0.0f;
        this.gzW = 0.0f;
        this.gzX = 0L;
        this.lastStartTime = 0L;
        this.gzY = 0L;
        this.gzZ = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzR = new LinkedList<>();
        this.gzS = 0.0f;
        this.gzT = State.PAUSE;
        this.anb = true;
        this.gzU = 0.0f;
        this.gzV = 0.0f;
        this.gzW = 0.0f;
        this.gzX = 0L;
        this.lastStartTime = 0L;
        this.gzY = 0L;
        this.gzZ = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gzK = new Paint();
        this.gzL = new Paint();
        this.gzM = new Paint();
        this.gzO = new Paint();
        this.gzN = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gzK.setStyle(Paint.Style.FILL);
        this.gzK.setColor(Color.parseColor("#33aaff"));
        this.gzL.setStyle(Paint.Style.FILL);
        this.gzL.setColor(Color.rgb(51, 170, (int) MotionEventCompat.ACTION_MASK));
        this.gzM.setStyle(Paint.Style.FILL);
        this.gzM.setColor(Color.parseColor("#FFFFFF"));
        this.gzO.setStyle(Paint.Style.FILL);
        this.gzO.setColor(Color.parseColor("#e53917"));
        this.gzN.setStyle(Paint.Style.FILL);
        this.gzN.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.gzS = displayMetrics.widthPixels / 15000.0f;
        this.gzW = this.gzS;
    }

    public void setListener(a aVar) {
        this.gzJ = aVar;
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
        if (this.cde == 0) {
            this.cde = System.currentTimeMillis();
        }
        if (this.gzZ == 0) {
            this.gzZ = getHeight();
        }
        this.gzP = (float) this.gzZ;
        this.gzQ = (float) ((this.gzZ * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.gzU = 0.0f;
        if (!this.gzR.isEmpty()) {
            Iterator<Integer> it = this.gzR.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.gzY = intValue;
                float f = this.gzU;
                this.gzU += ((float) (intValue - j)) * this.gzS;
                float f2 = this.gzU - this.gzQ;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.gzZ - 1), this.gzK);
                canvas.drawRect(f2, 0.0f, this.gzU, (float) (this.gzZ - 1), this.gzM);
                j = intValue;
            }
            if (this.gzR.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.gzS, 0.0f, this.gzP + (this.gzS * 3000.0f), (float) (this.gzZ - 1), this.gzL);
            }
        } else {
            canvas.drawRect(3000.0f * this.gzS, 0.0f, this.gzP + (this.gzS * 3000.0f), (float) (this.gzZ - 1), this.gzL);
        }
        if (this.gzT == State.ROLLBACK) {
            canvas.drawRect(this.gzU - (((float) (this.gzY - this.lastStartTime)) * this.gzS), 0.0f, this.gzU, (float) this.gzZ, this.gzO);
        }
        if (this.gzT == State.START) {
            this.gzV += this.gzW * ((float) (currentTimeMillis - this.cde));
            float f3 = this.gzU + this.gzV;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.gzU, 0.0f, this.gzV + this.gzU, (float) (this.gzZ - 1), this.gzK);
            } else {
                canvas.drawRect(this.gzU, 0.0f, getMeasuredWidth(), (float) (this.gzZ - 1), this.gzK);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.gzZ) + (f3 - 5.0f), (float) (this.gzZ - 1), this.gzN);
            if (this.gzJ != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.gzJ.uE(this.mProgress);
                }
            }
        } else {
            if (this.gzJ != null) {
                int measuredWidth2 = (int) ((this.gzU / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.gzJ.uE(this.mProgress);
                }
            }
            if (this.gzX == 0 || currentTimeMillis - this.gzX >= 800) {
                this.anb = !this.anb;
                this.gzX = System.currentTimeMillis();
            }
            if (this.anb) {
                canvas.drawRect(this.gzU - 5.0f, 0.0f, ((float) this.gzZ) + (this.gzU - 5.0f), (float) (this.gzZ - 1), this.gzN);
            }
        }
        this.cde = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.gzT = state;
        if (state != State.START) {
            this.gzV = this.gzW;
        }
        if (state == State.DELETE && this.gzR != null && !this.gzR.isEmpty()) {
            this.gzR.removeLast();
        }
    }

    public State getCurrentState() {
        return this.gzT;
    }

    public void uD(int i) {
        this.gzR.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.gzR == null || this.gzR.isEmpty()) {
            return 0;
        }
        return this.gzR.getLast().intValue();
    }

    public boolean bxp() {
        return this.gzR.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.gzR;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.gzR = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.gzZ = i;
    }

    public void reset() {
        this.gzR.clear();
        this.gzT = State.PAUSE;
        this.gzR.clear();
        this.gzU = 0.0f;
        this.cde = 0L;
        this.lastStartTime = 0L;
        this.gzY = 0L;
        this.mProgress = 0;
        this.gzX = 0L;
    }
}
