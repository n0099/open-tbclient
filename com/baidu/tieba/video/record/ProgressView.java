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
    private boolean cqH;
    private long fbN;
    private a jEj;
    private Paint jEk;
    private Paint jEl;
    private Paint jEm;
    private Paint jEn;
    private Paint jEo;
    private float jEp;
    private float jEq;
    private LinkedList<Integer> jEr;
    private float jEs;
    private volatile State jEt;
    private float jEu;
    private float jEv;
    private float jEw;
    private long jEx;
    private long jEy;
    private long jEz;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes5.dex */
    public interface a {
        void Bb(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.jEr = new LinkedList<>();
        this.jEs = 0.0f;
        this.jEt = State.PAUSE;
        this.cqH = true;
        this.jEu = 0.0f;
        this.jEv = 0.0f;
        this.jEw = 0.0f;
        this.jEx = 0L;
        this.lastStartTime = 0L;
        this.jEy = 0L;
        this.jEz = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jEr = new LinkedList<>();
        this.jEs = 0.0f;
        this.jEt = State.PAUSE;
        this.cqH = true;
        this.jEu = 0.0f;
        this.jEv = 0.0f;
        this.jEw = 0.0f;
        this.jEx = 0L;
        this.lastStartTime = 0L;
        this.jEy = 0L;
        this.jEz = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jEr = new LinkedList<>();
        this.jEs = 0.0f;
        this.jEt = State.PAUSE;
        this.cqH = true;
        this.jEu = 0.0f;
        this.jEv = 0.0f;
        this.jEw = 0.0f;
        this.jEx = 0L;
        this.lastStartTime = 0L;
        this.jEy = 0L;
        this.jEz = 0L;
        init(context);
    }

    private void init(Context context) {
        this.jEk = new Paint();
        this.jEl = new Paint();
        this.jEm = new Paint();
        this.jEo = new Paint();
        this.jEn = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.jEk.setStyle(Paint.Style.FILL);
        this.jEk.setColor(Color.parseColor("#33aaff"));
        this.jEl.setStyle(Paint.Style.FILL);
        this.jEl.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.jEm.setStyle(Paint.Style.FILL);
        this.jEm.setColor(Color.parseColor("#FFFFFF"));
        this.jEo.setStyle(Paint.Style.FILL);
        this.jEo.setColor(Color.parseColor("#e53917"));
        this.jEn.setStyle(Paint.Style.FILL);
        this.jEn.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.jEs = displayMetrics.widthPixels / 15000.0f;
        this.jEw = this.jEs;
    }

    public void setListener(a aVar) {
        this.jEj = aVar;
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
        if (this.fbN == 0) {
            this.fbN = System.currentTimeMillis();
        }
        if (this.jEz == 0) {
            this.jEz = getHeight();
        }
        this.jEp = (float) this.jEz;
        this.jEq = (float) ((this.jEz * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.jEu = 0.0f;
        if (!this.jEr.isEmpty()) {
            Iterator<Integer> it = this.jEr.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.jEy = intValue;
                float f = this.jEu;
                this.jEu += ((float) (intValue - j)) * this.jEs;
                float f2 = this.jEu - this.jEq;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.jEz - 1), this.jEk);
                canvas.drawRect(f2, 0.0f, this.jEu, (float) (this.jEz - 1), this.jEm);
                j = intValue;
            }
            if (this.jEr.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.jEs, 0.0f, this.jEp + (this.jEs * 3000.0f), (float) (this.jEz - 1), this.jEl);
            }
        } else {
            canvas.drawRect(3000.0f * this.jEs, 0.0f, this.jEp + (this.jEs * 3000.0f), (float) (this.jEz - 1), this.jEl);
        }
        if (this.jEt == State.ROLLBACK) {
            canvas.drawRect(this.jEu - (((float) (this.jEy - this.lastStartTime)) * this.jEs), 0.0f, this.jEu, (float) this.jEz, this.jEo);
        }
        if (this.jEt == State.START) {
            this.jEv += this.jEw * ((float) (currentTimeMillis - this.fbN));
            float f3 = this.jEu + this.jEv;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.jEu, 0.0f, this.jEv + this.jEu, (float) (this.jEz - 1), this.jEk);
            } else {
                canvas.drawRect(this.jEu, 0.0f, getMeasuredWidth(), (float) (this.jEz - 1), this.jEk);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.jEz) + (f3 - 5.0f), (float) (this.jEz - 1), this.jEn);
            if (this.jEj != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.jEj.Bb(this.mProgress);
                }
            }
        } else {
            if (this.jEj != null) {
                int measuredWidth2 = (int) ((this.jEu / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.jEj.Bb(this.mProgress);
                }
            }
            if (this.jEx == 0 || currentTimeMillis - this.jEx >= 800) {
                this.cqH = !this.cqH;
                this.jEx = System.currentTimeMillis();
            }
            if (this.cqH) {
                canvas.drawRect(this.jEu - 5.0f, 0.0f, ((float) this.jEz) + (this.jEu - 5.0f), (float) (this.jEz - 1), this.jEn);
            }
        }
        this.fbN = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.jEt = state;
        if (state != State.START) {
            this.jEv = this.jEw;
        }
        if (state == State.DELETE && this.jEr != null && !this.jEr.isEmpty()) {
            this.jEr.removeLast();
        }
    }

    public State getCurrentState() {
        return this.jEt;
    }

    public void Ba(int i) {
        this.jEr.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.jEr == null || this.jEr.isEmpty()) {
            return 0;
        }
        return this.jEr.getLast().intValue();
    }

    public boolean cvg() {
        return this.jEr.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.jEr;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.jEr = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.jEz = i;
    }

    public void reset() {
        this.jEr.clear();
        this.jEt = State.PAUSE;
        this.jEr.clear();
        this.jEu = 0.0f;
        this.fbN = 0L;
        this.lastStartTime = 0L;
        this.jEy = 0L;
        this.mProgress = 0;
        this.jEx = 0L;
    }
}
