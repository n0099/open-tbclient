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
/* loaded from: classes2.dex */
public class ProgressView extends View {
    private boolean bdC;
    private Paint cMy;
    private long dpJ;
    private a hvO;
    private Paint hvP;
    private Paint hvQ;
    private Paint hvR;
    private Paint hvS;
    private float hvT;
    private float hvU;
    private LinkedList<Integer> hvV;
    private float hvW;
    private volatile State hvX;
    private float hvY;
    private float hvZ;
    private float hwa;
    private long hwb;
    private long hwc;
    private long hwd;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void wT(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hvV = new LinkedList<>();
        this.hvW = 0.0f;
        this.hvX = State.PAUSE;
        this.bdC = true;
        this.hvY = 0.0f;
        this.hvZ = 0.0f;
        this.hwa = 0.0f;
        this.hwb = 0L;
        this.lastStartTime = 0L;
        this.hwc = 0L;
        this.hwd = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hvV = new LinkedList<>();
        this.hvW = 0.0f;
        this.hvX = State.PAUSE;
        this.bdC = true;
        this.hvY = 0.0f;
        this.hvZ = 0.0f;
        this.hwa = 0.0f;
        this.hwb = 0L;
        this.lastStartTime = 0L;
        this.hwc = 0L;
        this.hwd = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hvV = new LinkedList<>();
        this.hvW = 0.0f;
        this.hvX = State.PAUSE;
        this.bdC = true;
        this.hvY = 0.0f;
        this.hvZ = 0.0f;
        this.hwa = 0.0f;
        this.hwb = 0L;
        this.lastStartTime = 0L;
        this.hwc = 0L;
        this.hwd = 0L;
        init(context);
    }

    private void init(Context context) {
        this.cMy = new Paint();
        this.hvP = new Paint();
        this.hvQ = new Paint();
        this.hvS = new Paint();
        this.hvR = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.cMy.setStyle(Paint.Style.FILL);
        this.cMy.setColor(Color.parseColor("#33aaff"));
        this.hvP.setStyle(Paint.Style.FILL);
        this.hvP.setColor(Color.rgb(51, 170, 255));
        this.hvQ.setStyle(Paint.Style.FILL);
        this.hvQ.setColor(Color.parseColor("#FFFFFF"));
        this.hvS.setStyle(Paint.Style.FILL);
        this.hvS.setColor(Color.parseColor("#e53917"));
        this.hvR.setStyle(Paint.Style.FILL);
        this.hvR.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hvW = displayMetrics.widthPixels / 15000.0f;
        this.hwa = this.hvW;
    }

    public void setListener(a aVar) {
        this.hvO = aVar;
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
        if (this.dpJ == 0) {
            this.dpJ = System.currentTimeMillis();
        }
        if (this.hwd == 0) {
            this.hwd = getHeight();
        }
        this.hvT = (float) this.hwd;
        this.hvU = (float) ((this.hwd * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hvY = 0.0f;
        if (!this.hvV.isEmpty()) {
            Iterator<Integer> it = this.hvV.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hwc = intValue;
                float f = this.hvY;
                this.hvY += ((float) (intValue - j)) * this.hvW;
                float f2 = this.hvY - this.hvU;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hwd - 1), this.cMy);
                canvas.drawRect(f2, 0.0f, this.hvY, (float) (this.hwd - 1), this.hvQ);
                j = intValue;
            }
            if (this.hvV.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hvW, 0.0f, this.hvT + (this.hvW * 3000.0f), (float) (this.hwd - 1), this.hvP);
            }
        } else {
            canvas.drawRect(3000.0f * this.hvW, 0.0f, this.hvT + (this.hvW * 3000.0f), (float) (this.hwd - 1), this.hvP);
        }
        if (this.hvX == State.ROLLBACK) {
            canvas.drawRect(this.hvY - (((float) (this.hwc - this.lastStartTime)) * this.hvW), 0.0f, this.hvY, (float) this.hwd, this.hvS);
        }
        if (this.hvX == State.START) {
            this.hvZ += this.hwa * ((float) (currentTimeMillis - this.dpJ));
            float f3 = this.hvY + this.hvZ;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hvY, 0.0f, this.hvZ + this.hvY, (float) (this.hwd - 1), this.cMy);
            } else {
                canvas.drawRect(this.hvY, 0.0f, getMeasuredWidth(), (float) (this.hwd - 1), this.cMy);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hwd) + (f3 - 5.0f), (float) (this.hwd - 1), this.hvR);
            if (this.hvO != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hvO.wT(this.mProgress);
                }
            }
        } else {
            if (this.hvO != null) {
                int measuredWidth2 = (int) ((this.hvY / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hvO.wT(this.mProgress);
                }
            }
            if (this.hwb == 0 || currentTimeMillis - this.hwb >= 800) {
                this.bdC = !this.bdC;
                this.hwb = System.currentTimeMillis();
            }
            if (this.bdC) {
                canvas.drawRect(this.hvY - 5.0f, 0.0f, ((float) this.hwd) + (this.hvY - 5.0f), (float) (this.hwd - 1), this.hvR);
            }
        }
        this.dpJ = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hvX = state;
        if (state != State.START) {
            this.hvZ = this.hwa;
        }
        if (state == State.DELETE && this.hvV != null && !this.hvV.isEmpty()) {
            this.hvV.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hvX;
    }

    public void wS(int i) {
        this.hvV.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hvV == null || this.hvV.isEmpty()) {
            return 0;
        }
        return this.hvV.getLast().intValue();
    }

    public boolean bDx() {
        return this.hvV.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hvV;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hvV = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hwd = i;
    }

    public void reset() {
        this.hvV.clear();
        this.hvX = State.PAUSE;
        this.hvV.clear();
        this.hvY = 0.0f;
        this.dpJ = 0L;
        this.lastStartTime = 0L;
        this.hwc = 0L;
        this.mProgress = 0;
        this.hwb = 0L;
    }
}
