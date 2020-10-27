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
/* loaded from: classes23.dex */
public class ProgressView extends View {
    private boolean eQy;
    private Paint gIL;
    private long idU;
    private long lastStartTime;
    private int mProgress;
    private a nne;
    private Paint nnf;
    private Paint nng;
    private Paint nnh;
    private Paint nni;
    private float nnj;
    private float nnk;
    private LinkedList<Integer> nnl;
    private float nnm;
    private volatile State nnn;
    private float nno;
    private float nnp;
    private float nnq;
    private long nnr;
    private long nns;
    private long nnt;

    /* loaded from: classes23.dex */
    public interface a {
        void KD(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nnl = new LinkedList<>();
        this.nnm = 0.0f;
        this.nnn = State.PAUSE;
        this.eQy = true;
        this.nno = 0.0f;
        this.nnp = 0.0f;
        this.nnq = 0.0f;
        this.nnr = 0L;
        this.lastStartTime = 0L;
        this.nns = 0L;
        this.nnt = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nnl = new LinkedList<>();
        this.nnm = 0.0f;
        this.nnn = State.PAUSE;
        this.eQy = true;
        this.nno = 0.0f;
        this.nnp = 0.0f;
        this.nnq = 0.0f;
        this.nnr = 0L;
        this.lastStartTime = 0L;
        this.nns = 0L;
        this.nnt = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nnl = new LinkedList<>();
        this.nnm = 0.0f;
        this.nnn = State.PAUSE;
        this.eQy = true;
        this.nno = 0.0f;
        this.nnp = 0.0f;
        this.nnq = 0.0f;
        this.nnr = 0L;
        this.lastStartTime = 0L;
        this.nns = 0L;
        this.nnt = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gIL = new Paint();
        this.nnf = new Paint();
        this.nng = new Paint();
        this.nni = new Paint();
        this.nnh = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gIL.setStyle(Paint.Style.FILL);
        this.gIL.setColor(Color.parseColor("#33aaff"));
        this.nnf.setStyle(Paint.Style.FILL);
        this.nnf.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nng.setStyle(Paint.Style.FILL);
        this.nng.setColor(Color.parseColor("#FFFFFF"));
        this.nni.setStyle(Paint.Style.FILL);
        this.nni.setColor(Color.parseColor("#e53917"));
        this.nnh.setStyle(Paint.Style.FILL);
        this.nnh.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nnm = displayMetrics.widthPixels / 15000.0f;
        this.nnq = this.nnm;
    }

    public void setListener(a aVar) {
        this.nne = aVar;
    }

    /* loaded from: classes23.dex */
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
        if (this.idU == 0) {
            this.idU = System.currentTimeMillis();
        }
        if (this.nnt == 0) {
            this.nnt = getHeight();
        }
        this.nnj = (float) this.nnt;
        this.nnk = (float) ((this.nnt * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nno = 0.0f;
        if (!this.nnl.isEmpty()) {
            Iterator<Integer> it = this.nnl.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nns = intValue;
                float f = this.nno;
                this.nno += ((float) (intValue - j)) * this.nnm;
                float f2 = this.nno - this.nnk;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nnt - 1), this.gIL);
                canvas.drawRect(f2, 0.0f, this.nno, (float) (this.nnt - 1), this.nng);
                j = intValue;
            }
            if (this.nnl.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nnm, 0.0f, this.nnj + (this.nnm * 3000.0f), (float) (this.nnt - 1), this.nnf);
            }
        } else {
            canvas.drawRect(3000.0f * this.nnm, 0.0f, this.nnj + (this.nnm * 3000.0f), (float) (this.nnt - 1), this.nnf);
        }
        if (this.nnn == State.ROLLBACK) {
            canvas.drawRect(this.nno - (((float) (this.nns - this.lastStartTime)) * this.nnm), 0.0f, this.nno, (float) this.nnt, this.nni);
        }
        if (this.nnn == State.START) {
            this.nnp += this.nnq * ((float) (currentTimeMillis - this.idU));
            float f3 = this.nno + this.nnp;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nno, 0.0f, this.nnp + this.nno, (float) (this.nnt - 1), this.gIL);
            } else {
                canvas.drawRect(this.nno, 0.0f, getMeasuredWidth(), (float) (this.nnt - 1), this.gIL);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nnt) + (f3 - 5.0f), (float) (this.nnt - 1), this.nnh);
            if (this.nne != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nne.KD(this.mProgress);
                }
            }
        } else {
            if (this.nne != null) {
                int measuredWidth2 = (int) ((this.nno / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nne.KD(this.mProgress);
                }
            }
            if (this.nnr == 0 || currentTimeMillis - this.nnr >= 800) {
                this.eQy = !this.eQy;
                this.nnr = System.currentTimeMillis();
            }
            if (this.eQy) {
                canvas.drawRect(this.nno - 5.0f, 0.0f, ((float) this.nnt) + (this.nno - 5.0f), (float) (this.nnt - 1), this.nnh);
            }
        }
        this.idU = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nnn = state;
        if (state != State.START) {
            this.nnp = this.nnq;
        }
        if (state == State.DELETE && this.nnl != null && !this.nnl.isEmpty()) {
            this.nnl.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nnn;
    }

    public void KC(int i) {
        this.nnl.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nnl == null || this.nnl.isEmpty()) {
            return 0;
        }
        return this.nnl.getLast().intValue();
    }

    public boolean dOm() {
        return this.nnl.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nnl;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nnl = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nnt = i;
    }

    public void reset() {
        this.nnl.clear();
        this.nnn = State.PAUSE;
        this.nnl.clear();
        this.nno = 0.0f;
        this.idU = 0L;
        this.lastStartTime = 0L;
        this.nns = 0L;
        this.mProgress = 0;
        this.nnr = 0L;
    }
}
