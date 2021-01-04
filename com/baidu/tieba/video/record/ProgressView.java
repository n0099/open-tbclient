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
    private a nLD;
    private Paint nLE;
    private Paint nLF;
    private Paint nLG;
    private Paint nLH;
    private float nLI;
    private float nLJ;
    private LinkedList<Integer> nLK;
    private float nLL;
    private volatile State nLM;
    private float nLN;
    private float nLO;
    private float nLP;
    private long nLQ;
    private long nLR;
    private long nLS;

    /* loaded from: classes8.dex */
    public interface a {
        void LY(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nLK = new LinkedList<>();
        this.nLL = 0.0f;
        this.nLM = State.PAUSE;
        this.isVisible = true;
        this.nLN = 0.0f;
        this.nLO = 0.0f;
        this.nLP = 0.0f;
        this.nLQ = 0L;
        this.lastStartTime = 0L;
        this.nLR = 0L;
        this.nLS = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nLK = new LinkedList<>();
        this.nLL = 0.0f;
        this.nLM = State.PAUSE;
        this.isVisible = true;
        this.nLN = 0.0f;
        this.nLO = 0.0f;
        this.nLP = 0.0f;
        this.nLQ = 0L;
        this.lastStartTime = 0L;
        this.nLR = 0L;
        this.nLS = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nLK = new LinkedList<>();
        this.nLL = 0.0f;
        this.nLM = State.PAUSE;
        this.isVisible = true;
        this.nLN = 0.0f;
        this.nLO = 0.0f;
        this.nLP = 0.0f;
        this.nLQ = 0L;
        this.lastStartTime = 0L;
        this.nLR = 0L;
        this.nLS = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hjh = new Paint();
        this.nLE = new Paint();
        this.nLF = new Paint();
        this.nLH = new Paint();
        this.nLG = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hjh.setStyle(Paint.Style.FILL);
        this.hjh.setColor(Color.parseColor("#33aaff"));
        this.nLE.setStyle(Paint.Style.FILL);
        this.nLE.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nLF.setStyle(Paint.Style.FILL);
        this.nLF.setColor(Color.parseColor("#FFFFFF"));
        this.nLH.setStyle(Paint.Style.FILL);
        this.nLH.setColor(Color.parseColor("#e53917"));
        this.nLG.setStyle(Paint.Style.FILL);
        this.nLG.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nLL = displayMetrics.widthPixels / 15000.0f;
        this.nLP = this.nLL;
    }

    public void setListener(a aVar) {
        this.nLD = aVar;
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
        if (this.nLS == 0) {
            this.nLS = getHeight();
        }
        this.nLI = (float) this.nLS;
        this.nLJ = (float) ((this.nLS * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nLN = 0.0f;
        if (!this.nLK.isEmpty()) {
            Iterator<Integer> it = this.nLK.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nLR = intValue;
                float f = this.nLN;
                this.nLN += ((float) (intValue - j)) * this.nLL;
                float f2 = this.nLN - this.nLJ;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nLS - 1), this.hjh);
                canvas.drawRect(f2, 0.0f, this.nLN, (float) (this.nLS - 1), this.nLF);
                j = intValue;
            }
            if (this.nLK.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nLL, 0.0f, this.nLI + (this.nLL * 3000.0f), (float) (this.nLS - 1), this.nLE);
            }
        } else {
            canvas.drawRect(3000.0f * this.nLL, 0.0f, this.nLI + (this.nLL * 3000.0f), (float) (this.nLS - 1), this.nLE);
        }
        if (this.nLM == State.ROLLBACK) {
            canvas.drawRect(this.nLN - (((float) (this.nLR - this.lastStartTime)) * this.nLL), 0.0f, this.nLN, (float) this.nLS, this.nLH);
        }
        if (this.nLM == State.START) {
            this.nLO += this.nLP * ((float) (currentTimeMillis - this.iHN));
            float f3 = this.nLN + this.nLO;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nLN, 0.0f, this.nLO + this.nLN, (float) (this.nLS - 1), this.hjh);
            } else {
                canvas.drawRect(this.nLN, 0.0f, getMeasuredWidth(), (float) (this.nLS - 1), this.hjh);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nLS) + (f3 - 5.0f), (float) (this.nLS - 1), this.nLG);
            if (this.nLD != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nLD.LY(this.mProgress);
                }
            }
        } else {
            if (this.nLD != null) {
                int measuredWidth2 = (int) ((this.nLN / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nLD.LY(this.mProgress);
                }
            }
            if (this.nLQ == 0 || currentTimeMillis - this.nLQ >= 800) {
                this.isVisible = !this.isVisible;
                this.nLQ = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.nLN - 5.0f, 0.0f, ((float) this.nLS) + (this.nLN - 5.0f), (float) (this.nLS - 1), this.nLG);
            }
        }
        this.iHN = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nLM = state;
        if (state != State.START) {
            this.nLO = this.nLP;
        }
        if (state == State.DELETE && this.nLK != null && !this.nLK.isEmpty()) {
            this.nLK.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nLM;
    }

    public void LX(int i) {
        this.nLK.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nLK == null || this.nLK.isEmpty()) {
            return 0;
        }
        return this.nLK.getLast().intValue();
    }

    public boolean dVK() {
        return this.nLK.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nLK;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nLK = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nLS = i;
    }

    public void reset() {
        this.nLK.clear();
        this.nLM = State.PAUSE;
        this.nLK.clear();
        this.nLN = 0.0f;
        this.iHN = 0L;
        this.lastStartTime = 0L;
        this.nLR = 0L;
        this.mProgress = 0;
        this.nLQ = 0L;
    }
}
