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
    private boolean ejP;
    private long hio;
    private long lastStartTime;
    private int mProgress;
    private a mjh;
    private Paint mji;
    private Paint mjj;
    private Paint mjk;
    private Paint mjl;
    private Paint mjm;
    private float mjn;
    private float mjo;
    private LinkedList<Integer> mjp;
    private float mjq;
    private volatile State mjr;
    private float mjs;
    private float mjt;
    private float mju;
    private long mjv;
    private long mjw;
    private long mjx;

    /* loaded from: classes17.dex */
    public interface a {
        void GF(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.mjp = new LinkedList<>();
        this.mjq = 0.0f;
        this.mjr = State.PAUSE;
        this.ejP = true;
        this.mjs = 0.0f;
        this.mjt = 0.0f;
        this.mju = 0.0f;
        this.mjv = 0L;
        this.lastStartTime = 0L;
        this.mjw = 0L;
        this.mjx = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mjp = new LinkedList<>();
        this.mjq = 0.0f;
        this.mjr = State.PAUSE;
        this.ejP = true;
        this.mjs = 0.0f;
        this.mjt = 0.0f;
        this.mju = 0.0f;
        this.mjv = 0L;
        this.lastStartTime = 0L;
        this.mjw = 0L;
        this.mjx = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjp = new LinkedList<>();
        this.mjq = 0.0f;
        this.mjr = State.PAUSE;
        this.ejP = true;
        this.mjs = 0.0f;
        this.mjt = 0.0f;
        this.mju = 0.0f;
        this.mjv = 0L;
        this.lastStartTime = 0L;
        this.mjw = 0L;
        this.mjx = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mji = new Paint();
        this.mjj = new Paint();
        this.mjk = new Paint();
        this.mjm = new Paint();
        this.mjl = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.mji.setStyle(Paint.Style.FILL);
        this.mji.setColor(Color.parseColor("#33aaff"));
        this.mjj.setStyle(Paint.Style.FILL);
        this.mjj.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.mjk.setStyle(Paint.Style.FILL);
        this.mjk.setColor(Color.parseColor("#FFFFFF"));
        this.mjm.setStyle(Paint.Style.FILL);
        this.mjm.setColor(Color.parseColor("#e53917"));
        this.mjl.setStyle(Paint.Style.FILL);
        this.mjl.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mjq = displayMetrics.widthPixels / 15000.0f;
        this.mju = this.mjq;
    }

    public void setListener(a aVar) {
        this.mjh = aVar;
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
        if (this.hio == 0) {
            this.hio = System.currentTimeMillis();
        }
        if (this.mjx == 0) {
            this.mjx = getHeight();
        }
        this.mjn = (float) this.mjx;
        this.mjo = (float) ((this.mjx * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.mjs = 0.0f;
        if (!this.mjp.isEmpty()) {
            Iterator<Integer> it = this.mjp.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.mjw = intValue;
                float f = this.mjs;
                this.mjs += ((float) (intValue - j)) * this.mjq;
                float f2 = this.mjs - this.mjo;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.mjx - 1), this.mji);
                canvas.drawRect(f2, 0.0f, this.mjs, (float) (this.mjx - 1), this.mjk);
                j = intValue;
            }
            if (this.mjp.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.mjq, 0.0f, this.mjn + (this.mjq * 3000.0f), (float) (this.mjx - 1), this.mjj);
            }
        } else {
            canvas.drawRect(3000.0f * this.mjq, 0.0f, this.mjn + (this.mjq * 3000.0f), (float) (this.mjx - 1), this.mjj);
        }
        if (this.mjr == State.ROLLBACK) {
            canvas.drawRect(this.mjs - (((float) (this.mjw - this.lastStartTime)) * this.mjq), 0.0f, this.mjs, (float) this.mjx, this.mjm);
        }
        if (this.mjr == State.START) {
            this.mjt += this.mju * ((float) (currentTimeMillis - this.hio));
            float f3 = this.mjs + this.mjt;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.mjs, 0.0f, this.mjt + this.mjs, (float) (this.mjx - 1), this.mji);
            } else {
                canvas.drawRect(this.mjs, 0.0f, getMeasuredWidth(), (float) (this.mjx - 1), this.mji);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.mjx) + (f3 - 5.0f), (float) (this.mjx - 1), this.mjl);
            if (this.mjh != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.mjh.GF(this.mProgress);
                }
            }
        } else {
            if (this.mjh != null) {
                int measuredWidth2 = (int) ((this.mjs / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.mjh.GF(this.mProgress);
                }
            }
            if (this.mjv == 0 || currentTimeMillis - this.mjv >= 800) {
                this.ejP = !this.ejP;
                this.mjv = System.currentTimeMillis();
            }
            if (this.ejP) {
                canvas.drawRect(this.mjs - 5.0f, 0.0f, ((float) this.mjx) + (this.mjs - 5.0f), (float) (this.mjx - 1), this.mjl);
            }
        }
        this.hio = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.mjr = state;
        if (state != State.START) {
            this.mjt = this.mju;
        }
        if (state == State.DELETE && this.mjp != null && !this.mjp.isEmpty()) {
            this.mjp.removeLast();
        }
    }

    public State getCurrentState() {
        return this.mjr;
    }

    public void GE(int i) {
        this.mjp.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.mjp == null || this.mjp.isEmpty()) {
            return 0;
        }
        return this.mjp.getLast().intValue();
    }

    public boolean drU() {
        return this.mjp.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.mjp;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.mjp = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.mjx = i;
    }

    public void reset() {
        this.mjp.clear();
        this.mjr = State.PAUSE;
        this.mjp.clear();
        this.mjs = 0.0f;
        this.hio = 0L;
        this.lastStartTime = 0L;
        this.mjw = 0L;
        this.mProgress = 0;
        this.mjv = 0L;
    }
}
