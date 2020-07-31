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
    private a mjf;
    private Paint mjg;
    private Paint mjh;
    private Paint mji;
    private Paint mjj;
    private Paint mjk;
    private float mjl;
    private float mjm;
    private LinkedList<Integer> mjn;
    private float mjo;
    private volatile State mjp;
    private float mjq;
    private float mjr;
    private float mjs;
    private long mjt;
    private long mju;
    private long mjv;

    /* loaded from: classes17.dex */
    public interface a {
        void GF(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.mjn = new LinkedList<>();
        this.mjo = 0.0f;
        this.mjp = State.PAUSE;
        this.ejP = true;
        this.mjq = 0.0f;
        this.mjr = 0.0f;
        this.mjs = 0.0f;
        this.mjt = 0L;
        this.lastStartTime = 0L;
        this.mju = 0L;
        this.mjv = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mjn = new LinkedList<>();
        this.mjo = 0.0f;
        this.mjp = State.PAUSE;
        this.ejP = true;
        this.mjq = 0.0f;
        this.mjr = 0.0f;
        this.mjs = 0.0f;
        this.mjt = 0L;
        this.lastStartTime = 0L;
        this.mju = 0L;
        this.mjv = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mjn = new LinkedList<>();
        this.mjo = 0.0f;
        this.mjp = State.PAUSE;
        this.ejP = true;
        this.mjq = 0.0f;
        this.mjr = 0.0f;
        this.mjs = 0.0f;
        this.mjt = 0L;
        this.lastStartTime = 0L;
        this.mju = 0L;
        this.mjv = 0L;
        init(context);
    }

    private void init(Context context) {
        this.mjg = new Paint();
        this.mjh = new Paint();
        this.mji = new Paint();
        this.mjk = new Paint();
        this.mjj = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.mjg.setStyle(Paint.Style.FILL);
        this.mjg.setColor(Color.parseColor("#33aaff"));
        this.mjh.setStyle(Paint.Style.FILL);
        this.mjh.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.mji.setStyle(Paint.Style.FILL);
        this.mji.setColor(Color.parseColor("#FFFFFF"));
        this.mjk.setStyle(Paint.Style.FILL);
        this.mjk.setColor(Color.parseColor("#e53917"));
        this.mjj.setStyle(Paint.Style.FILL);
        this.mjj.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mjo = displayMetrics.widthPixels / 15000.0f;
        this.mjs = this.mjo;
    }

    public void setListener(a aVar) {
        this.mjf = aVar;
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
        if (this.mjv == 0) {
            this.mjv = getHeight();
        }
        this.mjl = (float) this.mjv;
        this.mjm = (float) ((this.mjv * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.mjq = 0.0f;
        if (!this.mjn.isEmpty()) {
            Iterator<Integer> it = this.mjn.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.mju = intValue;
                float f = this.mjq;
                this.mjq += ((float) (intValue - j)) * this.mjo;
                float f2 = this.mjq - this.mjm;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.mjv - 1), this.mjg);
                canvas.drawRect(f2, 0.0f, this.mjq, (float) (this.mjv - 1), this.mji);
                j = intValue;
            }
            if (this.mjn.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.mjo, 0.0f, this.mjl + (this.mjo * 3000.0f), (float) (this.mjv - 1), this.mjh);
            }
        } else {
            canvas.drawRect(3000.0f * this.mjo, 0.0f, this.mjl + (this.mjo * 3000.0f), (float) (this.mjv - 1), this.mjh);
        }
        if (this.mjp == State.ROLLBACK) {
            canvas.drawRect(this.mjq - (((float) (this.mju - this.lastStartTime)) * this.mjo), 0.0f, this.mjq, (float) this.mjv, this.mjk);
        }
        if (this.mjp == State.START) {
            this.mjr += this.mjs * ((float) (currentTimeMillis - this.hio));
            float f3 = this.mjq + this.mjr;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.mjq, 0.0f, this.mjr + this.mjq, (float) (this.mjv - 1), this.mjg);
            } else {
                canvas.drawRect(this.mjq, 0.0f, getMeasuredWidth(), (float) (this.mjv - 1), this.mjg);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.mjv) + (f3 - 5.0f), (float) (this.mjv - 1), this.mjj);
            if (this.mjf != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.mjf.GF(this.mProgress);
                }
            }
        } else {
            if (this.mjf != null) {
                int measuredWidth2 = (int) ((this.mjq / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.mjf.GF(this.mProgress);
                }
            }
            if (this.mjt == 0 || currentTimeMillis - this.mjt >= 800) {
                this.ejP = !this.ejP;
                this.mjt = System.currentTimeMillis();
            }
            if (this.ejP) {
                canvas.drawRect(this.mjq - 5.0f, 0.0f, ((float) this.mjv) + (this.mjq - 5.0f), (float) (this.mjv - 1), this.mjj);
            }
        }
        this.hio = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.mjp = state;
        if (state != State.START) {
            this.mjr = this.mjs;
        }
        if (state == State.DELETE && this.mjn != null && !this.mjn.isEmpty()) {
            this.mjn.removeLast();
        }
    }

    public State getCurrentState() {
        return this.mjp;
    }

    public void GE(int i) {
        this.mjn.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.mjn == null || this.mjn.isEmpty()) {
            return 0;
        }
        return this.mjn.getLast().intValue();
    }

    public boolean drT() {
        return this.mjn.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.mjn;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.mjn = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.mjv = i;
    }

    public void reset() {
        this.mjn.clear();
        this.mjp = State.PAUSE;
        this.mjn.clear();
        this.mjq = 0.0f;
        this.hio = 0L;
        this.lastStartTime = 0L;
        this.mju = 0L;
        this.mProgress = 0;
        this.mjt = 0L;
    }
}
