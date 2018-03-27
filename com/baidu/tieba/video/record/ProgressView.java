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
    private boolean bds;
    private Paint cMp;
    private long dpA;
    private a hvZ;
    private Paint hwa;
    private Paint hwb;
    private Paint hwc;
    private Paint hwd;
    private float hwe;
    private float hwf;
    private LinkedList<Integer> hwg;
    private float hwh;
    private volatile State hwi;
    private float hwj;
    private float hwk;
    private float hwl;
    private long hwm;
    private long hwn;
    private long hwo;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void wU(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hwg = new LinkedList<>();
        this.hwh = 0.0f;
        this.hwi = State.PAUSE;
        this.bds = true;
        this.hwj = 0.0f;
        this.hwk = 0.0f;
        this.hwl = 0.0f;
        this.hwm = 0L;
        this.lastStartTime = 0L;
        this.hwn = 0L;
        this.hwo = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hwg = new LinkedList<>();
        this.hwh = 0.0f;
        this.hwi = State.PAUSE;
        this.bds = true;
        this.hwj = 0.0f;
        this.hwk = 0.0f;
        this.hwl = 0.0f;
        this.hwm = 0L;
        this.lastStartTime = 0L;
        this.hwn = 0L;
        this.hwo = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hwg = new LinkedList<>();
        this.hwh = 0.0f;
        this.hwi = State.PAUSE;
        this.bds = true;
        this.hwj = 0.0f;
        this.hwk = 0.0f;
        this.hwl = 0.0f;
        this.hwm = 0L;
        this.lastStartTime = 0L;
        this.hwn = 0L;
        this.hwo = 0L;
        init(context);
    }

    private void init(Context context) {
        this.cMp = new Paint();
        this.hwa = new Paint();
        this.hwb = new Paint();
        this.hwd = new Paint();
        this.hwc = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.cMp.setStyle(Paint.Style.FILL);
        this.cMp.setColor(Color.parseColor("#33aaff"));
        this.hwa.setStyle(Paint.Style.FILL);
        this.hwa.setColor(Color.rgb(51, 170, 255));
        this.hwb.setStyle(Paint.Style.FILL);
        this.hwb.setColor(Color.parseColor("#FFFFFF"));
        this.hwd.setStyle(Paint.Style.FILL);
        this.hwd.setColor(Color.parseColor("#e53917"));
        this.hwc.setStyle(Paint.Style.FILL);
        this.hwc.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.hwh = displayMetrics.widthPixels / 15000.0f;
        this.hwl = this.hwh;
    }

    public void setListener(a aVar) {
        this.hvZ = aVar;
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
        if (this.dpA == 0) {
            this.dpA = System.currentTimeMillis();
        }
        if (this.hwo == 0) {
            this.hwo = getHeight();
        }
        this.hwe = (float) this.hwo;
        this.hwf = (float) ((this.hwo * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.hwj = 0.0f;
        if (!this.hwg.isEmpty()) {
            Iterator<Integer> it = this.hwg.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.hwn = intValue;
                float f = this.hwj;
                this.hwj += ((float) (intValue - j)) * this.hwh;
                float f2 = this.hwj - this.hwf;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.hwo - 1), this.cMp);
                canvas.drawRect(f2, 0.0f, this.hwj, (float) (this.hwo - 1), this.hwb);
                j = intValue;
            }
            if (this.hwg.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.hwh, 0.0f, this.hwe + (this.hwh * 3000.0f), (float) (this.hwo - 1), this.hwa);
            }
        } else {
            canvas.drawRect(3000.0f * this.hwh, 0.0f, this.hwe + (this.hwh * 3000.0f), (float) (this.hwo - 1), this.hwa);
        }
        if (this.hwi == State.ROLLBACK) {
            canvas.drawRect(this.hwj - (((float) (this.hwn - this.lastStartTime)) * this.hwh), 0.0f, this.hwj, (float) this.hwo, this.hwd);
        }
        if (this.hwi == State.START) {
            this.hwk += this.hwl * ((float) (currentTimeMillis - this.dpA));
            float f3 = this.hwj + this.hwk;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.hwj, 0.0f, this.hwk + this.hwj, (float) (this.hwo - 1), this.cMp);
            } else {
                canvas.drawRect(this.hwj, 0.0f, getMeasuredWidth(), (float) (this.hwo - 1), this.cMp);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.hwo) + (f3 - 5.0f), (float) (this.hwo - 1), this.hwc);
            if (this.hvZ != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hvZ.wU(this.mProgress);
                }
            }
        } else {
            if (this.hvZ != null) {
                int measuredWidth2 = (int) ((this.hwj / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hvZ.wU(this.mProgress);
                }
            }
            if (this.hwm == 0 || currentTimeMillis - this.hwm >= 800) {
                this.bds = !this.bds;
                this.hwm = System.currentTimeMillis();
            }
            if (this.bds) {
                canvas.drawRect(this.hwj - 5.0f, 0.0f, ((float) this.hwo) + (this.hwj - 5.0f), (float) (this.hwo - 1), this.hwc);
            }
        }
        this.dpA = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hwi = state;
        if (state != State.START) {
            this.hwk = this.hwl;
        }
        if (state == State.DELETE && this.hwg != null && !this.hwg.isEmpty()) {
            this.hwg.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hwi;
    }

    public void wT(int i) {
        this.hwg.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hwg == null || this.hwg.isEmpty()) {
            return 0;
        }
        return this.hwg.getLast().intValue();
    }

    public boolean bDB() {
        return this.hwg.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hwg;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hwg = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.hwo = i;
    }

    public void reset() {
        this.hwg.clear();
        this.hwi = State.PAUSE;
        this.hwg.clear();
        this.hwj = 0.0f;
        this.dpA = 0L;
        this.lastStartTime = 0L;
        this.hwn = 0L;
        this.mProgress = 0;
        this.hwm = 0L;
    }
}
