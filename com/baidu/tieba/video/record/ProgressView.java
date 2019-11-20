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
/* loaded from: classes5.dex */
public class ProgressView extends View {
    private boolean cpQ;
    private long faW;
    private LinkedList<Integer> jDA;
    private float jDB;
    private volatile State jDC;
    private float jDD;
    private float jDE;
    private float jDF;
    private long jDG;
    private long jDH;
    private long jDI;
    private a jDs;
    private Paint jDt;
    private Paint jDu;
    private Paint jDv;
    private Paint jDw;
    private Paint jDx;
    private float jDy;
    private float jDz;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void Ba(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.jDA = new LinkedList<>();
        this.jDB = 0.0f;
        this.jDC = State.PAUSE;
        this.cpQ = true;
        this.jDD = 0.0f;
        this.jDE = 0.0f;
        this.jDF = 0.0f;
        this.jDG = 0L;
        this.lastStartTime = 0L;
        this.jDH = 0L;
        this.jDI = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jDA = new LinkedList<>();
        this.jDB = 0.0f;
        this.jDC = State.PAUSE;
        this.cpQ = true;
        this.jDD = 0.0f;
        this.jDE = 0.0f;
        this.jDF = 0.0f;
        this.jDG = 0L;
        this.lastStartTime = 0L;
        this.jDH = 0L;
        this.jDI = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jDA = new LinkedList<>();
        this.jDB = 0.0f;
        this.jDC = State.PAUSE;
        this.cpQ = true;
        this.jDD = 0.0f;
        this.jDE = 0.0f;
        this.jDF = 0.0f;
        this.jDG = 0L;
        this.lastStartTime = 0L;
        this.jDH = 0L;
        this.jDI = 0L;
        init(context);
    }

    private void init(Context context) {
        this.jDt = new Paint();
        this.jDu = new Paint();
        this.jDv = new Paint();
        this.jDx = new Paint();
        this.jDw = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.jDt.setStyle(Paint.Style.FILL);
        this.jDt.setColor(Color.parseColor("#33aaff"));
        this.jDu.setStyle(Paint.Style.FILL);
        this.jDu.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.jDv.setStyle(Paint.Style.FILL);
        this.jDv.setColor(Color.parseColor("#FFFFFF"));
        this.jDx.setStyle(Paint.Style.FILL);
        this.jDx.setColor(Color.parseColor("#e53917"));
        this.jDw.setStyle(Paint.Style.FILL);
        this.jDw.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.jDB = displayMetrics.widthPixels / 15000.0f;
        this.jDF = this.jDB;
    }

    public void setListener(a aVar) {
        this.jDs = aVar;
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
        if (this.faW == 0) {
            this.faW = System.currentTimeMillis();
        }
        if (this.jDI == 0) {
            this.jDI = getHeight();
        }
        this.jDy = (float) this.jDI;
        this.jDz = (float) ((this.jDI * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.jDD = 0.0f;
        if (!this.jDA.isEmpty()) {
            Iterator<Integer> it = this.jDA.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.jDH = intValue;
                float f = this.jDD;
                this.jDD += ((float) (intValue - j)) * this.jDB;
                float f2 = this.jDD - this.jDz;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.jDI - 1), this.jDt);
                canvas.drawRect(f2, 0.0f, this.jDD, (float) (this.jDI - 1), this.jDv);
                j = intValue;
            }
            if (this.jDA.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.jDB, 0.0f, this.jDy + (this.jDB * 3000.0f), (float) (this.jDI - 1), this.jDu);
            }
        } else {
            canvas.drawRect(3000.0f * this.jDB, 0.0f, this.jDy + (this.jDB * 3000.0f), (float) (this.jDI - 1), this.jDu);
        }
        if (this.jDC == State.ROLLBACK) {
            canvas.drawRect(this.jDD - (((float) (this.jDH - this.lastStartTime)) * this.jDB), 0.0f, this.jDD, (float) this.jDI, this.jDx);
        }
        if (this.jDC == State.START) {
            this.jDE += this.jDF * ((float) (currentTimeMillis - this.faW));
            float f3 = this.jDD + this.jDE;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.jDD, 0.0f, this.jDE + this.jDD, (float) (this.jDI - 1), this.jDt);
            } else {
                canvas.drawRect(this.jDD, 0.0f, getMeasuredWidth(), (float) (this.jDI - 1), this.jDt);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.jDI) + (f3 - 5.0f), (float) (this.jDI - 1), this.jDw);
            if (this.jDs != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.jDs.Ba(this.mProgress);
                }
            }
        } else {
            if (this.jDs != null) {
                int measuredWidth2 = (int) ((this.jDD / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.jDs.Ba(this.mProgress);
                }
            }
            if (this.jDG == 0 || currentTimeMillis - this.jDG >= 800) {
                this.cpQ = !this.cpQ;
                this.jDG = System.currentTimeMillis();
            }
            if (this.cpQ) {
                canvas.drawRect(this.jDD - 5.0f, 0.0f, ((float) this.jDI) + (this.jDD - 5.0f), (float) (this.jDI - 1), this.jDw);
            }
        }
        this.faW = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.jDC = state;
        if (state != State.START) {
            this.jDE = this.jDF;
        }
        if (state == State.DELETE && this.jDA != null && !this.jDA.isEmpty()) {
            this.jDA.removeLast();
        }
    }

    public State getCurrentState() {
        return this.jDC;
    }

    public void AZ(int i) {
        this.jDA.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.jDA == null || this.jDA.isEmpty()) {
            return 0;
        }
        return this.jDA.getLast().intValue();
    }

    public boolean cve() {
        return this.jDA.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.jDA;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.jDA = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.jDI = i;
    }

    public void reset() {
        this.jDA.clear();
        this.jDC = State.PAUSE;
        this.jDA.clear();
        this.jDD = 0.0f;
        this.faW = 0L;
        this.lastStartTime = 0L;
        this.jDH = 0L;
        this.mProgress = 0;
        this.jDG = 0L;
    }
}
