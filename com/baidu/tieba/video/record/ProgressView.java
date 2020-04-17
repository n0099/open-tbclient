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
/* loaded from: classes10.dex */
public class ProgressView extends View {
    private boolean dHQ;
    private long gAV;
    private long lastStartTime;
    private a lnZ;
    private Paint loa;
    private Paint lob;
    private Paint lod;
    private Paint loe;
    private Paint lof;
    private float loh;
    private float loi;
    private LinkedList<Integer> loj;
    private float lok;
    private volatile State lol;
    private float lom;
    private float loo;
    private float lop;
    private long loq;
    private long lor;
    private long los;
    private int mProgress;

    /* loaded from: classes10.dex */
    public interface a {
        void Et(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.loj = new LinkedList<>();
        this.lok = 0.0f;
        this.lol = State.PAUSE;
        this.dHQ = true;
        this.lom = 0.0f;
        this.loo = 0.0f;
        this.lop = 0.0f;
        this.loq = 0L;
        this.lastStartTime = 0L;
        this.lor = 0L;
        this.los = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loj = new LinkedList<>();
        this.lok = 0.0f;
        this.lol = State.PAUSE;
        this.dHQ = true;
        this.lom = 0.0f;
        this.loo = 0.0f;
        this.lop = 0.0f;
        this.loq = 0L;
        this.lastStartTime = 0L;
        this.lor = 0L;
        this.los = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loj = new LinkedList<>();
        this.lok = 0.0f;
        this.lol = State.PAUSE;
        this.dHQ = true;
        this.lom = 0.0f;
        this.loo = 0.0f;
        this.lop = 0.0f;
        this.loq = 0L;
        this.lastStartTime = 0L;
        this.lor = 0L;
        this.los = 0L;
        init(context);
    }

    private void init(Context context) {
        this.loa = new Paint();
        this.lob = new Paint();
        this.lod = new Paint();
        this.lof = new Paint();
        this.loe = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.loa.setStyle(Paint.Style.FILL);
        this.loa.setColor(Color.parseColor("#33aaff"));
        this.lob.setStyle(Paint.Style.FILL);
        this.lob.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.lod.setStyle(Paint.Style.FILL);
        this.lod.setColor(Color.parseColor("#FFFFFF"));
        this.lof.setStyle(Paint.Style.FILL);
        this.lof.setColor(Color.parseColor("#e53917"));
        this.loe.setStyle(Paint.Style.FILL);
        this.loe.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.lok = displayMetrics.widthPixels / 15000.0f;
        this.lop = this.lok;
    }

    public void setListener(a aVar) {
        this.lnZ = aVar;
    }

    /* loaded from: classes10.dex */
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
        if (this.gAV == 0) {
            this.gAV = System.currentTimeMillis();
        }
        if (this.los == 0) {
            this.los = getHeight();
        }
        this.loh = (float) this.los;
        this.loi = (float) ((this.los * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.lom = 0.0f;
        if (!this.loj.isEmpty()) {
            Iterator<Integer> it = this.loj.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.lor = intValue;
                float f = this.lom;
                this.lom += ((float) (intValue - j)) * this.lok;
                float f2 = this.lom - this.loi;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.los - 1), this.loa);
                canvas.drawRect(f2, 0.0f, this.lom, (float) (this.los - 1), this.lod);
                j = intValue;
            }
            if (this.loj.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.lok, 0.0f, this.loh + (this.lok * 3000.0f), (float) (this.los - 1), this.lob);
            }
        } else {
            canvas.drawRect(3000.0f * this.lok, 0.0f, this.loh + (this.lok * 3000.0f), (float) (this.los - 1), this.lob);
        }
        if (this.lol == State.ROLLBACK) {
            canvas.drawRect(this.lom - (((float) (this.lor - this.lastStartTime)) * this.lok), 0.0f, this.lom, (float) this.los, this.lof);
        }
        if (this.lol == State.START) {
            this.loo += this.lop * ((float) (currentTimeMillis - this.gAV));
            float f3 = this.lom + this.loo;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.lom, 0.0f, this.loo + this.lom, (float) (this.los - 1), this.loa);
            } else {
                canvas.drawRect(this.lom, 0.0f, getMeasuredWidth(), (float) (this.los - 1), this.loa);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.los) + (f3 - 5.0f), (float) (this.los - 1), this.loe);
            if (this.lnZ != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.lnZ.Et(this.mProgress);
                }
            }
        } else {
            if (this.lnZ != null) {
                int measuredWidth2 = (int) ((this.lom / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.lnZ.Et(this.mProgress);
                }
            }
            if (this.loq == 0 || currentTimeMillis - this.loq >= 800) {
                this.dHQ = !this.dHQ;
                this.loq = System.currentTimeMillis();
            }
            if (this.dHQ) {
                canvas.drawRect(this.lom - 5.0f, 0.0f, ((float) this.los) + (this.lom - 5.0f), (float) (this.los - 1), this.loe);
            }
        }
        this.gAV = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.lol = state;
        if (state != State.START) {
            this.loo = this.lop;
        }
        if (state == State.DELETE && this.loj != null && !this.loj.isEmpty()) {
            this.loj.removeLast();
        }
    }

    public State getCurrentState() {
        return this.lol;
    }

    public void Es(int i) {
        this.loj.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.loj == null || this.loj.isEmpty()) {
            return 0;
        }
        return this.loj.getLast().intValue();
    }

    public boolean dcT() {
        return this.loj.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.loj;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.loj = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.los = i;
    }

    public void reset() {
        this.loj.clear();
        this.lol = State.PAUSE;
        this.loj.clear();
        this.lom = 0.0f;
        this.gAV = 0L;
        this.lastStartTime = 0L;
        this.lor = 0L;
        this.mProgress = 0;
        this.loq = 0L;
    }
}
