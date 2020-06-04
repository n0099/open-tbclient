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
    private boolean dWj;
    private long gPV;
    private a lHV;
    private Paint lHW;
    private Paint lHX;
    private Paint lHY;
    private Paint lHZ;
    private Paint lIa;
    private float lIb;
    private float lIc;
    private LinkedList<Integer> lId;
    private float lIe;
    private volatile State lIf;
    private float lIg;
    private float lIh;
    private float lIi;
    private long lIj;
    private long lIk;
    private long lIl;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes10.dex */
    public interface a {
        void Fg(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.lId = new LinkedList<>();
        this.lIe = 0.0f;
        this.lIf = State.PAUSE;
        this.dWj = true;
        this.lIg = 0.0f;
        this.lIh = 0.0f;
        this.lIi = 0.0f;
        this.lIj = 0L;
        this.lastStartTime = 0L;
        this.lIk = 0L;
        this.lIl = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lId = new LinkedList<>();
        this.lIe = 0.0f;
        this.lIf = State.PAUSE;
        this.dWj = true;
        this.lIg = 0.0f;
        this.lIh = 0.0f;
        this.lIi = 0.0f;
        this.lIj = 0L;
        this.lastStartTime = 0L;
        this.lIk = 0L;
        this.lIl = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lId = new LinkedList<>();
        this.lIe = 0.0f;
        this.lIf = State.PAUSE;
        this.dWj = true;
        this.lIg = 0.0f;
        this.lIh = 0.0f;
        this.lIi = 0.0f;
        this.lIj = 0L;
        this.lastStartTime = 0L;
        this.lIk = 0L;
        this.lIl = 0L;
        init(context);
    }

    private void init(Context context) {
        this.lHW = new Paint();
        this.lHX = new Paint();
        this.lHY = new Paint();
        this.lIa = new Paint();
        this.lHZ = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.lHW.setStyle(Paint.Style.FILL);
        this.lHW.setColor(Color.parseColor("#33aaff"));
        this.lHX.setStyle(Paint.Style.FILL);
        this.lHX.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.lHY.setStyle(Paint.Style.FILL);
        this.lHY.setColor(Color.parseColor("#FFFFFF"));
        this.lIa.setStyle(Paint.Style.FILL);
        this.lIa.setColor(Color.parseColor("#e53917"));
        this.lHZ.setStyle(Paint.Style.FILL);
        this.lHZ.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.lIe = displayMetrics.widthPixels / 15000.0f;
        this.lIi = this.lIe;
    }

    public void setListener(a aVar) {
        this.lHV = aVar;
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
        if (this.gPV == 0) {
            this.gPV = System.currentTimeMillis();
        }
        if (this.lIl == 0) {
            this.lIl = getHeight();
        }
        this.lIb = (float) this.lIl;
        this.lIc = (float) ((this.lIl * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.lIg = 0.0f;
        if (!this.lId.isEmpty()) {
            Iterator<Integer> it = this.lId.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.lIk = intValue;
                float f = this.lIg;
                this.lIg += ((float) (intValue - j)) * this.lIe;
                float f2 = this.lIg - this.lIc;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.lIl - 1), this.lHW);
                canvas.drawRect(f2, 0.0f, this.lIg, (float) (this.lIl - 1), this.lHY);
                j = intValue;
            }
            if (this.lId.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.lIe, 0.0f, this.lIb + (this.lIe * 3000.0f), (float) (this.lIl - 1), this.lHX);
            }
        } else {
            canvas.drawRect(3000.0f * this.lIe, 0.0f, this.lIb + (this.lIe * 3000.0f), (float) (this.lIl - 1), this.lHX);
        }
        if (this.lIf == State.ROLLBACK) {
            canvas.drawRect(this.lIg - (((float) (this.lIk - this.lastStartTime)) * this.lIe), 0.0f, this.lIg, (float) this.lIl, this.lIa);
        }
        if (this.lIf == State.START) {
            this.lIh += this.lIi * ((float) (currentTimeMillis - this.gPV));
            float f3 = this.lIg + this.lIh;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.lIg, 0.0f, this.lIh + this.lIg, (float) (this.lIl - 1), this.lHW);
            } else {
                canvas.drawRect(this.lIg, 0.0f, getMeasuredWidth(), (float) (this.lIl - 1), this.lHW);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.lIl) + (f3 - 5.0f), (float) (this.lIl - 1), this.lHZ);
            if (this.lHV != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.lHV.Fg(this.mProgress);
                }
            }
        } else {
            if (this.lHV != null) {
                int measuredWidth2 = (int) ((this.lIg / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.lHV.Fg(this.mProgress);
                }
            }
            if (this.lIj == 0 || currentTimeMillis - this.lIj >= 800) {
                this.dWj = !this.dWj;
                this.lIj = System.currentTimeMillis();
            }
            if (this.dWj) {
                canvas.drawRect(this.lIg - 5.0f, 0.0f, ((float) this.lIl) + (this.lIg - 5.0f), (float) (this.lIl - 1), this.lHZ);
            }
        }
        this.gPV = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.lIf = state;
        if (state != State.START) {
            this.lIh = this.lIi;
        }
        if (state == State.DELETE && this.lId != null && !this.lId.isEmpty()) {
            this.lId.removeLast();
        }
    }

    public State getCurrentState() {
        return this.lIf;
    }

    public void Ff(int i) {
        this.lId.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.lId == null || this.lId.isEmpty()) {
            return 0;
        }
        return this.lId.getLast().intValue();
    }

    public boolean dku() {
        return this.lId.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.lId;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.lId = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.lIl = i;
    }

    public void reset() {
        this.lId.clear();
        this.lIf = State.PAUSE;
        this.lId.clear();
        this.lIg = 0.0f;
        this.gPV = 0L;
        this.lastStartTime = 0L;
        this.lIk = 0L;
        this.mProgress = 0;
        this.lIj = 0L;
    }
}
