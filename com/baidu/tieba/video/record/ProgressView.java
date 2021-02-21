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
    private Paint hje;
    private long iJe;
    private boolean isVisible;
    private long lastStartTime;
    private int mProgress;
    private a nRf;
    private Paint nRg;
    private Paint nRh;
    private Paint nRi;
    private Paint nRj;
    private float nRk;
    private float nRl;
    private LinkedList<Integer> nRm;
    private float nRn;
    private volatile State nRo;
    private float nRp;
    private float nRq;
    private float nRr;
    private long nRs;
    private long nRt;
    private long nRu;

    /* loaded from: classes8.dex */
    public interface a {
        void KL(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nRm = new LinkedList<>();
        this.nRn = 0.0f;
        this.nRo = State.PAUSE;
        this.isVisible = true;
        this.nRp = 0.0f;
        this.nRq = 0.0f;
        this.nRr = 0.0f;
        this.nRs = 0L;
        this.lastStartTime = 0L;
        this.nRt = 0L;
        this.nRu = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nRm = new LinkedList<>();
        this.nRn = 0.0f;
        this.nRo = State.PAUSE;
        this.isVisible = true;
        this.nRp = 0.0f;
        this.nRq = 0.0f;
        this.nRr = 0.0f;
        this.nRs = 0L;
        this.lastStartTime = 0L;
        this.nRt = 0L;
        this.nRu = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRm = new LinkedList<>();
        this.nRn = 0.0f;
        this.nRo = State.PAUSE;
        this.isVisible = true;
        this.nRp = 0.0f;
        this.nRq = 0.0f;
        this.nRr = 0.0f;
        this.nRs = 0L;
        this.lastStartTime = 0L;
        this.nRt = 0L;
        this.nRu = 0L;
        init(context);
    }

    private void init(Context context) {
        this.hje = new Paint();
        this.nRg = new Paint();
        this.nRh = new Paint();
        this.nRj = new Paint();
        this.nRi = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.hje.setStyle(Paint.Style.FILL);
        this.hje.setColor(Color.parseColor("#33aaff"));
        this.nRg.setStyle(Paint.Style.FILL);
        this.nRg.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.nRh.setStyle(Paint.Style.FILL);
        this.nRh.setColor(Color.parseColor("#FFFFFF"));
        this.nRj.setStyle(Paint.Style.FILL);
        this.nRj.setColor(Color.parseColor("#e53917"));
        this.nRi.setStyle(Paint.Style.FILL);
        this.nRi.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.nRn = displayMetrics.widthPixels / 15000.0f;
        this.nRr = this.nRn;
    }

    public void setListener(a aVar) {
        this.nRf = aVar;
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
        if (this.iJe == 0) {
            this.iJe = System.currentTimeMillis();
        }
        if (this.nRu == 0) {
            this.nRu = getHeight();
        }
        this.nRk = (float) this.nRu;
        this.nRl = (float) ((this.nRu * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.nRp = 0.0f;
        if (!this.nRm.isEmpty()) {
            Iterator<Integer> it = this.nRm.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.nRt = intValue;
                float f = this.nRp;
                this.nRp += ((float) (intValue - j)) * this.nRn;
                float f2 = this.nRp - this.nRl;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.nRu - 1), this.hje);
                canvas.drawRect(f2, 0.0f, this.nRp, (float) (this.nRu - 1), this.nRh);
                j = intValue;
            }
            if (this.nRm.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.nRn, 0.0f, this.nRk + (this.nRn * 3000.0f), (float) (this.nRu - 1), this.nRg);
            }
        } else {
            canvas.drawRect(3000.0f * this.nRn, 0.0f, this.nRk + (this.nRn * 3000.0f), (float) (this.nRu - 1), this.nRg);
        }
        if (this.nRo == State.ROLLBACK) {
            canvas.drawRect(this.nRp - (((float) (this.nRt - this.lastStartTime)) * this.nRn), 0.0f, this.nRp, (float) this.nRu, this.nRj);
        }
        if (this.nRo == State.START) {
            this.nRq += this.nRr * ((float) (currentTimeMillis - this.iJe));
            float f3 = this.nRp + this.nRq;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.nRp, 0.0f, this.nRq + this.nRp, (float) (this.nRu - 1), this.hje);
            } else {
                canvas.drawRect(this.nRp, 0.0f, getMeasuredWidth(), (float) (this.nRu - 1), this.hje);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.nRu) + (f3 - 5.0f), (float) (this.nRu - 1), this.nRi);
            if (this.nRf != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.nRf.KL(this.mProgress);
                }
            }
        } else {
            if (this.nRf != null) {
                int measuredWidth2 = (int) ((this.nRp / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.nRf.KL(this.mProgress);
                }
            }
            if (this.nRs == 0 || currentTimeMillis - this.nRs >= 800) {
                this.isVisible = !this.isVisible;
                this.nRs = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.nRp - 5.0f, 0.0f, ((float) this.nRu) + (this.nRp - 5.0f), (float) (this.nRu - 1), this.nRi);
            }
        }
        this.iJe = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.nRo = state;
        if (state != State.START) {
            this.nRq = this.nRr;
        }
        if (state == State.DELETE && this.nRm != null && !this.nRm.isEmpty()) {
            this.nRm.removeLast();
        }
    }

    public State getCurrentState() {
        return this.nRo;
    }

    public void KK(int i) {
        this.nRm.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nRm == null || this.nRm.isEmpty()) {
            return 0;
        }
        return this.nRm.getLast().intValue();
    }

    public boolean dUm() {
        return this.nRm.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nRm;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nRm = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.nRu = i;
    }

    public void reset() {
        this.nRm.clear();
        this.nRo = State.PAUSE;
        this.nRm.clear();
        this.nRp = 0.0f;
        this.iJe = 0L;
        this.lastStartTime = 0L;
        this.nRt = 0L;
        this.mProgress = 0;
        this.nRs = 0L;
    }
}
