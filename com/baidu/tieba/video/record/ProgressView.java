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
/* loaded from: classes7.dex */
public class ProgressView extends View {
    private long fPB;
    private boolean isVisible;
    private a kxf;
    private Paint kxg;
    private Paint kxh;
    private Paint kxi;
    private Paint kxj;
    private Paint kxk;
    private float kxl;
    private float kxm;
    private LinkedList<Integer> kxn;
    private float kxo;
    private volatile State kxp;
    private float kxq;
    private float kxr;
    private float kxs;
    private long kxt;
    private long kxu;
    private long kxv;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes7.dex */
    public interface a {
        void Dv(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.kxn = new LinkedList<>();
        this.kxo = 0.0f;
        this.kxp = State.PAUSE;
        this.isVisible = true;
        this.kxq = 0.0f;
        this.kxr = 0.0f;
        this.kxs = 0.0f;
        this.kxt = 0L;
        this.lastStartTime = 0L;
        this.kxu = 0L;
        this.kxv = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kxn = new LinkedList<>();
        this.kxo = 0.0f;
        this.kxp = State.PAUSE;
        this.isVisible = true;
        this.kxq = 0.0f;
        this.kxr = 0.0f;
        this.kxs = 0.0f;
        this.kxt = 0L;
        this.lastStartTime = 0L;
        this.kxu = 0L;
        this.kxv = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kxn = new LinkedList<>();
        this.kxo = 0.0f;
        this.kxp = State.PAUSE;
        this.isVisible = true;
        this.kxq = 0.0f;
        this.kxr = 0.0f;
        this.kxs = 0.0f;
        this.kxt = 0L;
        this.lastStartTime = 0L;
        this.kxu = 0L;
        this.kxv = 0L;
        init(context);
    }

    private void init(Context context) {
        this.kxg = new Paint();
        this.kxh = new Paint();
        this.kxi = new Paint();
        this.kxk = new Paint();
        this.kxj = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.kxg.setStyle(Paint.Style.FILL);
        this.kxg.setColor(Color.parseColor("#33aaff"));
        this.kxh.setStyle(Paint.Style.FILL);
        this.kxh.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.kxi.setStyle(Paint.Style.FILL);
        this.kxi.setColor(Color.parseColor("#FFFFFF"));
        this.kxk.setStyle(Paint.Style.FILL);
        this.kxk.setColor(Color.parseColor("#e53917"));
        this.kxj.setStyle(Paint.Style.FILL);
        this.kxj.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.kxo = displayMetrics.widthPixels / 15000.0f;
        this.kxs = this.kxo;
    }

    public void setListener(a aVar) {
        this.kxf = aVar;
    }

    /* loaded from: classes7.dex */
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
        if (this.fPB == 0) {
            this.fPB = System.currentTimeMillis();
        }
        if (this.kxv == 0) {
            this.kxv = getHeight();
        }
        this.kxl = (float) this.kxv;
        this.kxm = (float) ((this.kxv * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.kxq = 0.0f;
        if (!this.kxn.isEmpty()) {
            Iterator<Integer> it = this.kxn.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.kxu = intValue;
                float f = this.kxq;
                this.kxq += ((float) (intValue - j)) * this.kxo;
                float f2 = this.kxq - this.kxm;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.kxv - 1), this.kxg);
                canvas.drawRect(f2, 0.0f, this.kxq, (float) (this.kxv - 1), this.kxi);
                j = intValue;
            }
            if (this.kxn.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.kxo, 0.0f, this.kxl + (this.kxo * 3000.0f), (float) (this.kxv - 1), this.kxh);
            }
        } else {
            canvas.drawRect(3000.0f * this.kxo, 0.0f, this.kxl + (this.kxo * 3000.0f), (float) (this.kxv - 1), this.kxh);
        }
        if (this.kxp == State.ROLLBACK) {
            canvas.drawRect(this.kxq - (((float) (this.kxu - this.lastStartTime)) * this.kxo), 0.0f, this.kxq, (float) this.kxv, this.kxk);
        }
        if (this.kxp == State.START) {
            this.kxr += this.kxs * ((float) (currentTimeMillis - this.fPB));
            float f3 = this.kxq + this.kxr;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.kxq, 0.0f, this.kxr + this.kxq, (float) (this.kxv - 1), this.kxg);
            } else {
                canvas.drawRect(this.kxq, 0.0f, getMeasuredWidth(), (float) (this.kxv - 1), this.kxg);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.kxv) + (f3 - 5.0f), (float) (this.kxv - 1), this.kxj);
            if (this.kxf != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.kxf.Dv(this.mProgress);
                }
            }
        } else {
            if (this.kxf != null) {
                int measuredWidth2 = (int) ((this.kxq / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.kxf.Dv(this.mProgress);
                }
            }
            if (this.kxt == 0 || currentTimeMillis - this.kxt >= 800) {
                this.isVisible = !this.isVisible;
                this.kxt = System.currentTimeMillis();
            }
            if (this.isVisible) {
                canvas.drawRect(this.kxq - 5.0f, 0.0f, ((float) this.kxv) + (this.kxq - 5.0f), (float) (this.kxv - 1), this.kxj);
            }
        }
        this.fPB = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.kxp = state;
        if (state != State.START) {
            this.kxr = this.kxs;
        }
        if (state == State.DELETE && this.kxn != null && !this.kxn.isEmpty()) {
            this.kxn.removeLast();
        }
    }

    public State getCurrentState() {
        return this.kxp;
    }

    public void Du(int i) {
        this.kxn.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.kxn == null || this.kxn.isEmpty()) {
            return 0;
        }
        return this.kxn.getLast().intValue();
    }

    public boolean cOY() {
        return this.kxn.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.kxn;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.kxn = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.kxv = i;
    }

    public void reset() {
        this.kxn.clear();
        this.kxp = State.PAUSE;
        this.kxn.clear();
        this.kxq = 0.0f;
        this.fPB = 0L;
        this.lastStartTime = 0L;
        this.kxu = 0L;
        this.mProgress = 0;
        this.kxt = 0L;
    }
}
