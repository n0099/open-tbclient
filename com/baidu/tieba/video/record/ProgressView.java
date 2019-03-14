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
    private boolean bSv;
    private long eCL;
    private a jbT;
    private Paint jbU;
    private Paint jbV;
    private Paint jbW;
    private Paint jbX;
    private Paint jbY;
    private float jbZ;
    private float jca;
    private LinkedList<Integer> jcb;
    private float jcc;
    private volatile State jcd;
    private float jce;
    private float jcf;
    private float jcg;
    private long jch;
    private long jci;
    private long jcj;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void AE(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.jcb = new LinkedList<>();
        this.jcc = 0.0f;
        this.jcd = State.PAUSE;
        this.bSv = true;
        this.jce = 0.0f;
        this.jcf = 0.0f;
        this.jcg = 0.0f;
        this.jch = 0L;
        this.lastStartTime = 0L;
        this.jci = 0L;
        this.jcj = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jcb = new LinkedList<>();
        this.jcc = 0.0f;
        this.jcd = State.PAUSE;
        this.bSv = true;
        this.jce = 0.0f;
        this.jcf = 0.0f;
        this.jcg = 0.0f;
        this.jch = 0L;
        this.lastStartTime = 0L;
        this.jci = 0L;
        this.jcj = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jcb = new LinkedList<>();
        this.jcc = 0.0f;
        this.jcd = State.PAUSE;
        this.bSv = true;
        this.jce = 0.0f;
        this.jcf = 0.0f;
        this.jcg = 0.0f;
        this.jch = 0L;
        this.lastStartTime = 0L;
        this.jci = 0L;
        this.jcj = 0L;
        init(context);
    }

    private void init(Context context) {
        this.jbU = new Paint();
        this.jbV = new Paint();
        this.jbW = new Paint();
        this.jbY = new Paint();
        this.jbX = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.jbU.setStyle(Paint.Style.FILL);
        this.jbU.setColor(Color.parseColor("#33aaff"));
        this.jbV.setStyle(Paint.Style.FILL);
        this.jbV.setColor(Color.rgb(51, 170, 255));
        this.jbW.setStyle(Paint.Style.FILL);
        this.jbW.setColor(Color.parseColor("#FFFFFF"));
        this.jbY.setStyle(Paint.Style.FILL);
        this.jbY.setColor(Color.parseColor("#e53917"));
        this.jbX.setStyle(Paint.Style.FILL);
        this.jbX.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.jcc = displayMetrics.widthPixels / 15000.0f;
        this.jcg = this.jcc;
    }

    public void setListener(a aVar) {
        this.jbT = aVar;
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
        if (this.eCL == 0) {
            this.eCL = System.currentTimeMillis();
        }
        if (this.jcj == 0) {
            this.jcj = getHeight();
        }
        this.jbZ = (float) this.jcj;
        this.jca = (float) ((this.jcj * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.jce = 0.0f;
        if (!this.jcb.isEmpty()) {
            Iterator<Integer> it = this.jcb.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.jci = intValue;
                float f = this.jce;
                this.jce += ((float) (intValue - j)) * this.jcc;
                float f2 = this.jce - this.jca;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.jcj - 1), this.jbU);
                canvas.drawRect(f2, 0.0f, this.jce, (float) (this.jcj - 1), this.jbW);
                j = intValue;
            }
            if (this.jcb.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.jcc, 0.0f, this.jbZ + (this.jcc * 3000.0f), (float) (this.jcj - 1), this.jbV);
            }
        } else {
            canvas.drawRect(3000.0f * this.jcc, 0.0f, this.jbZ + (this.jcc * 3000.0f), (float) (this.jcj - 1), this.jbV);
        }
        if (this.jcd == State.ROLLBACK) {
            canvas.drawRect(this.jce - (((float) (this.jci - this.lastStartTime)) * this.jcc), 0.0f, this.jce, (float) this.jcj, this.jbY);
        }
        if (this.jcd == State.START) {
            this.jcf += this.jcg * ((float) (currentTimeMillis - this.eCL));
            float f3 = this.jce + this.jcf;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.jce, 0.0f, this.jcf + this.jce, (float) (this.jcj - 1), this.jbU);
            } else {
                canvas.drawRect(this.jce, 0.0f, getMeasuredWidth(), (float) (this.jcj - 1), this.jbU);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.jcj) + (f3 - 5.0f), (float) (this.jcj - 1), this.jbX);
            if (this.jbT != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.jbT.AE(this.mProgress);
                }
            }
        } else {
            if (this.jbT != null) {
                int measuredWidth2 = (int) ((this.jce / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.jbT.AE(this.mProgress);
                }
            }
            if (this.jch == 0 || currentTimeMillis - this.jch >= 800) {
                this.bSv = !this.bSv;
                this.jch = System.currentTimeMillis();
            }
            if (this.bSv) {
                canvas.drawRect(this.jce - 5.0f, 0.0f, ((float) this.jcj) + (this.jce - 5.0f), (float) (this.jcj - 1), this.jbX);
            }
        }
        this.eCL = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.jcd = state;
        if (state != State.START) {
            this.jcf = this.jcg;
        }
        if (state == State.DELETE && this.jcb != null && !this.jcb.isEmpty()) {
            this.jcb.removeLast();
        }
    }

    public State getCurrentState() {
        return this.jcd;
    }

    public void AD(int i) {
        this.jcb.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.jcb == null || this.jcb.isEmpty()) {
            return 0;
        }
        return this.jcb.getLast().intValue();
    }

    public boolean clp() {
        return this.jcb.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.jcb;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.jcb = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.jcj = i;
    }

    public void reset() {
        this.jcb.clear();
        this.jcd = State.PAUSE;
        this.jcb.clear();
        this.jce = 0.0f;
        this.eCL = 0L;
        this.lastStartTime = 0L;
        this.jci = 0L;
        this.mProgress = 0;
        this.jch = 0L;
    }
}
