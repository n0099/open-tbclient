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
    private boolean etO;
    private long hvt;
    private long lastStartTime;
    private a mBi;
    private Paint mBj;
    private Paint mBk;
    private Paint mBl;
    private Paint mBm;
    private Paint mBn;
    private float mBo;
    private float mBp;
    private LinkedList<Integer> mBq;
    private float mBr;
    private volatile State mBs;
    private float mBt;
    private float mBu;
    private float mBv;
    private long mBw;
    private long mBx;
    private long mBy;
    private int mProgress;

    /* loaded from: classes17.dex */
    public interface a {
        void Jb(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.mBq = new LinkedList<>();
        this.mBr = 0.0f;
        this.mBs = State.PAUSE;
        this.etO = true;
        this.mBt = 0.0f;
        this.mBu = 0.0f;
        this.mBv = 0.0f;
        this.mBw = 0L;
        this.lastStartTime = 0L;
        this.mBx = 0L;
        this.mBy = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBq = new LinkedList<>();
        this.mBr = 0.0f;
        this.mBs = State.PAUSE;
        this.etO = true;
        this.mBt = 0.0f;
        this.mBu = 0.0f;
        this.mBv = 0.0f;
        this.mBw = 0L;
        this.lastStartTime = 0L;
        this.mBx = 0L;
        this.mBy = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBq = new LinkedList<>();
        this.mBr = 0.0f;
        this.mBs = State.PAUSE;
        this.etO = true;
        this.mBt = 0.0f;
        this.mBu = 0.0f;
        this.mBv = 0.0f;
        this.mBw = 0L;
        this.lastStartTime = 0L;
        this.mBx = 0L;
        this.mBy = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mBj = new Paint();
        this.mBk = new Paint();
        this.mBl = new Paint();
        this.mBn = new Paint();
        this.mBm = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.mBj.setStyle(Paint.Style.FILL);
        this.mBj.setColor(Color.parseColor("#33aaff"));
        this.mBk.setStyle(Paint.Style.FILL);
        this.mBk.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.mBl.setStyle(Paint.Style.FILL);
        this.mBl.setColor(Color.parseColor("#FFFFFF"));
        this.mBn.setStyle(Paint.Style.FILL);
        this.mBn.setColor(Color.parseColor("#e53917"));
        this.mBm.setStyle(Paint.Style.FILL);
        this.mBm.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mBr = displayMetrics.widthPixels / 15000.0f;
        this.mBv = this.mBr;
    }

    public void setListener(a aVar) {
        this.mBi = aVar;
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
        if (this.hvt == 0) {
            this.hvt = System.currentTimeMillis();
        }
        if (this.mBy == 0) {
            this.mBy = getHeight();
        }
        this.mBo = (float) this.mBy;
        this.mBp = (float) ((this.mBy * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.mBt = 0.0f;
        if (!this.mBq.isEmpty()) {
            Iterator<Integer> it = this.mBq.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.mBx = intValue;
                float f = this.mBt;
                this.mBt += ((float) (intValue - j)) * this.mBr;
                float f2 = this.mBt - this.mBp;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.mBy - 1), this.mBj);
                canvas.drawRect(f2, 0.0f, this.mBt, (float) (this.mBy - 1), this.mBl);
                j = intValue;
            }
            if (this.mBq.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.mBr, 0.0f, this.mBo + (this.mBr * 3000.0f), (float) (this.mBy - 1), this.mBk);
            }
        } else {
            canvas.drawRect(3000.0f * this.mBr, 0.0f, this.mBo + (this.mBr * 3000.0f), (float) (this.mBy - 1), this.mBk);
        }
        if (this.mBs == State.ROLLBACK) {
            canvas.drawRect(this.mBt - (((float) (this.mBx - this.lastStartTime)) * this.mBr), 0.0f, this.mBt, (float) this.mBy, this.mBn);
        }
        if (this.mBs == State.START) {
            this.mBu += this.mBv * ((float) (currentTimeMillis - this.hvt));
            float f3 = this.mBt + this.mBu;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.mBt, 0.0f, this.mBu + this.mBt, (float) (this.mBy - 1), this.mBj);
            } else {
                canvas.drawRect(this.mBt, 0.0f, getMeasuredWidth(), (float) (this.mBy - 1), this.mBj);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.mBy) + (f3 - 5.0f), (float) (this.mBy - 1), this.mBm);
            if (this.mBi != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.mBi.Jb(this.mProgress);
                }
            }
        } else {
            if (this.mBi != null) {
                int measuredWidth2 = (int) ((this.mBt / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.mBi.Jb(this.mProgress);
                }
            }
            if (this.mBw == 0 || currentTimeMillis - this.mBw >= 800) {
                this.etO = !this.etO;
                this.mBw = System.currentTimeMillis();
            }
            if (this.etO) {
                canvas.drawRect(this.mBt - 5.0f, 0.0f, ((float) this.mBy) + (this.mBt - 5.0f), (float) (this.mBy - 1), this.mBm);
            }
        }
        this.hvt = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.mBs = state;
        if (state != State.START) {
            this.mBu = this.mBv;
        }
        if (state == State.DELETE && this.mBq != null && !this.mBq.isEmpty()) {
            this.mBq.removeLast();
        }
    }

    public State getCurrentState() {
        return this.mBs;
    }

    public void Ja(int i) {
        this.mBq.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.mBq == null || this.mBq.isEmpty()) {
            return 0;
        }
        return this.mBq.getLast().intValue();
    }

    public boolean dDy() {
        return this.mBq.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.mBq;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.mBq = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.mBy = i;
    }

    public void reset() {
        this.mBq.clear();
        this.mBs = State.PAUSE;
        this.mBq.clear();
        this.mBt = 0.0f;
        this.hvt = 0L;
        this.lastStartTime = 0L;
        this.mBx = 0L;
        this.mProgress = 0;
        this.mBw = 0L;
    }
}
