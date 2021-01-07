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
    private Paint hjh;
    private long iHN;
    private boolean isVisible;
    private long lastStartTime;
    private int mProgress;
    private a nLC;
    private Paint nLD;
    private Paint nLE;
    private Paint nLF;
    private Paint nLG;
    private float nLH;
    private float nLI;
    private LinkedList<Integer> nLJ;
    private float nLK;
    private volatile State nLL;
    private float nLM;
    private float nLN;
    private float nLO;
    private long nLP;
    private long nLQ;
    private long nLR;

    /* loaded from: classes8.dex */
    public interface a {
        void LY(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nLJ = new LinkedList<>();
        this.nLK = 0.0f;
        this.nLL = State.PAUSE;
        this.isVisible = true;
        this.nLM = 0.0f;
        this.nLN = 0.0f;
        this.nLO = 0.0f;
        this.nLP = 0L;
        this.lastStartTime = 0L;
        this.nLQ = 0L;
        this.nLR = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nLJ = new LinkedList<>();
        this.nLK = 0.0f;
        this.nLL = State.PAUSE;
        this.isVisible = true;
        this.nLM = 0.0f;
        this.nLN = 0.0f;
        this.nLO = 0.0f;
        this.nLP = 0L;
        this.lastStartTime = 0L;
        this.nLQ = 0L;
        this.nLR = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nLJ = new LinkedList<>();
        this.nLK = 0.0f;
        this.nLL = State.PAUSE;
        this.isVisible = true;
        this.nLM = 0.0f;
        this.nLN = 0.0f;
        this.nLO = 0.0f;
        this.nLP = 0L;
        this.lastStartTime = 0L;
        this.nLQ = 0L;
        this.nLR = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hjh = new Paint();
        this.nLD = new Paint();
        this.nLE = new Paint();
        this.nLG = new Paint();
        this.nLF = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hjh.setStyle(Paint.Style.FILL);
        this.hjh.setColor(Color.parseColor("#33aaff"));
        this.nLD.setStyle(Paint.Style.FILL);
        this.nLD.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nLE.setStyle(Paint.Style.FILL);
        this.nLE.setColor(Color.parseColor("#FFFFFF"));
        this.nLG.setStyle(Paint.Style.FILL);
        this.nLG.setColor(Color.parseColor("#e53917"));
        this.nLF.setStyle(Paint.Style.FILL);
        this.nLF.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nLK = displayMetrics.widthPixels / 15000.0f;
        this.nLO = this.nLK;
    }

    public void setListener(a aVar) {
        this.nLC = aVar;
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
        if (this.iHN == 0) {
            this.iHN = System.currentTimeMillis();
        }
        if (this.nLR == 0) {
            this.nLR = getHeight();
        }
        this.nLH = (float) this.nLR;
        this.nLI = (float) ((this.nLR * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nLM = 0.0f;
        if (!this.nLJ.isEmpty()) {
            Iterator<Integer> it = this.nLJ.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nLQ = intValue;
                float f = this.nLM;
                this.nLM += ((float) (intValue - j)) * this.nLK;
                float f2 = this.nLM - this.nLI;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nLR - 1), this.hjh);
                canvas.drawRect(f2, 0.0f, this.nLM, (float) (this.nLR - 1), this.nLE);
                j = intValue;
            }
            if (this.nLJ.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nLK, 0.0f, this.nLH + (this.nLK * 3000.0f), (float) (this.nLR - 1), this.nLD);
            }
        } else {
            canvas.drawRect(3000.0f * this.nLK, 0.0f, this.nLH + (this.nLK * 3000.0f), (float) (this.nLR - 1), this.nLD);
        }
        if (this.nLL == State.ROLLBACK) {
            canvas.drawRect(this.nLM - (((float) (this.nLQ - this.lastStartTime)) * this.nLK), 0.0f, this.nLM, (float) this.nLR, this.nLG);
        }
        if (this.nLL == State.START) {
            this.nLN += this.nLO * ((float) (currentTimeMillis - this.iHN));
            float f3 = this.nLM + this.nLN;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nLM, 0.0f, this.nLN + this.nLM, (float) (this.nLR - 1), this.hjh);
            } else {
                canvas.drawRect(this.nLM, 0.0f, getMeasuredWidth(), (float) (this.nLR - 1), this.hjh);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nLR) + (f3 - 5.0f), (float) (this.nLR - 1), this.nLF);
            if (this.nLC != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nLC.LY(this.mProgress);
                }
            }
        } else {
            if (this.nLC != null) {
                int measuredWidth2 = (int) ((this.nLM / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nLC.LY(this.mProgress);
                }
            }
            if (this.nLP == 0 || currentTimeMillis - this.nLP >= 800) {
                this.isVisible = !this.isVisible;
                this.nLP = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.nLM - 5.0f, 0.0f, ((float) this.nLR) + (this.nLM - 5.0f), (float) (this.nLR - 1), this.nLF);
            }
        }
        this.iHN = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nLL = state;
        if (state != State.START) {
            this.nLN = this.nLO;
        }
        if (state == State.DELETE && this.nLJ != null && !this.nLJ.isEmpty()) {
            this.nLJ.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nLL;
    }

    public void LX(int i) {
        this.nLJ.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nLJ == null || this.nLJ.isEmpty()) {
            return 0;
        }
        return this.nLJ.getLast().intValue();
    }

    public boolean dVL() {
        return this.nLJ.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nLJ;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nLJ = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nLR = i;
    }

    public void reset() {
        this.nLJ.clear();
        this.nLL = State.PAUSE;
        this.nLJ.clear();
        this.nLM = 0.0f;
        this.iHN = 0L;
        this.lastStartTime = 0L;
        this.nLQ = 0L;
        this.mProgress = 0;
        this.nLP = 0L;
    }
}
