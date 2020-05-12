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
    private boolean dHU;
    private long gBb;
    private long lastStartTime;
    private a loe;
    private Paint lof;
    private Paint loh;
    private Paint loi;
    private Paint loj;
    private Paint lok;
    private float lol;
    private float lom;
    private LinkedList<Integer> loo;
    private float lop;
    private volatile State loq;
    private float lor;
    private float los;
    private float lot;
    private long lou;
    private long lov;
    private long lox;
    private int mProgress;

    /* loaded from: classes10.dex */
    public interface a {
        void Et(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.loo = new LinkedList<>();
        this.lop = 0.0f;
        this.loq = State.PAUSE;
        this.dHU = true;
        this.lor = 0.0f;
        this.los = 0.0f;
        this.lot = 0.0f;
        this.lou = 0L;
        this.lastStartTime = 0L;
        this.lov = 0L;
        this.lox = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loo = new LinkedList<>();
        this.lop = 0.0f;
        this.loq = State.PAUSE;
        this.dHU = true;
        this.lor = 0.0f;
        this.los = 0.0f;
        this.lot = 0.0f;
        this.lou = 0L;
        this.lastStartTime = 0L;
        this.lov = 0L;
        this.lox = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.loo = new LinkedList<>();
        this.lop = 0.0f;
        this.loq = State.PAUSE;
        this.dHU = true;
        this.lor = 0.0f;
        this.los = 0.0f;
        this.lot = 0.0f;
        this.lou = 0L;
        this.lastStartTime = 0L;
        this.lov = 0L;
        this.lox = 0L;
        init(context);
    }

    private void init(Context context) {
        this.lof = new Paint();
        this.loh = new Paint();
        this.loi = new Paint();
        this.lok = new Paint();
        this.loj = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.lof.setStyle(Paint.Style.FILL);
        this.lof.setColor(Color.parseColor("#33aaff"));
        this.loh.setStyle(Paint.Style.FILL);
        this.loh.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.loi.setStyle(Paint.Style.FILL);
        this.loi.setColor(Color.parseColor("#FFFFFF"));
        this.lok.setStyle(Paint.Style.FILL);
        this.lok.setColor(Color.parseColor("#e53917"));
        this.loj.setStyle(Paint.Style.FILL);
        this.loj.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.lop = displayMetrics.widthPixels / 15000.0f;
        this.lot = this.lop;
    }

    public void setListener(a aVar) {
        this.loe = aVar;
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
        if (this.gBb == 0) {
            this.gBb = System.currentTimeMillis();
        }
        if (this.lox == 0) {
            this.lox = getHeight();
        }
        this.lol = (float) this.lox;
        this.lom = (float) ((this.lox * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.lor = 0.0f;
        if (!this.loo.isEmpty()) {
            Iterator<Integer> it = this.loo.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.lov = intValue;
                float f = this.lor;
                this.lor += ((float) (intValue - j)) * this.lop;
                float f2 = this.lor - this.lom;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.lox - 1), this.lof);
                canvas.drawRect(f2, 0.0f, this.lor, (float) (this.lox - 1), this.loi);
                j = intValue;
            }
            if (this.loo.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.lop, 0.0f, this.lol + (this.lop * 3000.0f), (float) (this.lox - 1), this.loh);
            }
        } else {
            canvas.drawRect(3000.0f * this.lop, 0.0f, this.lol + (this.lop * 3000.0f), (float) (this.lox - 1), this.loh);
        }
        if (this.loq == State.ROLLBACK) {
            canvas.drawRect(this.lor - (((float) (this.lov - this.lastStartTime)) * this.lop), 0.0f, this.lor, (float) this.lox, this.lok);
        }
        if (this.loq == State.START) {
            this.los += this.lot * ((float) (currentTimeMillis - this.gBb));
            float f3 = this.lor + this.los;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.lor, 0.0f, this.los + this.lor, (float) (this.lox - 1), this.lof);
            } else {
                canvas.drawRect(this.lor, 0.0f, getMeasuredWidth(), (float) (this.lox - 1), this.lof);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.lox) + (f3 - 5.0f), (float) (this.lox - 1), this.loj);
            if (this.loe != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.loe.Et(this.mProgress);
                }
            }
        } else {
            if (this.loe != null) {
                int measuredWidth2 = (int) ((this.lor / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.loe.Et(this.mProgress);
                }
            }
            if (this.lou == 0 || currentTimeMillis - this.lou >= 800) {
                this.dHU = !this.dHU;
                this.lou = System.currentTimeMillis();
            }
            if (this.dHU) {
                canvas.drawRect(this.lor - 5.0f, 0.0f, ((float) this.lox) + (this.lor - 5.0f), (float) (this.lox - 1), this.loj);
            }
        }
        this.gBb = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.loq = state;
        if (state != State.START) {
            this.los = this.lot;
        }
        if (state == State.DELETE && this.loo != null && !this.loo.isEmpty()) {
            this.loo.removeLast();
        }
    }

    public State getCurrentState() {
        return this.loq;
    }

    public void Es(int i) {
        this.loo.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.loo == null || this.loo.isEmpty()) {
            return 0;
        }
        return this.loo.getLast().intValue();
    }

    public boolean dcR() {
        return this.loo.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.loo;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.loo = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.lox = i;
    }

    public void reset() {
        this.loo.clear();
        this.loq = State.PAUSE;
        this.loo.clear();
        this.lor = 0.0f;
        this.gBb = 0L;
        this.lastStartTime = 0L;
        this.lov = 0L;
        this.mProgress = 0;
        this.lou = 0L;
    }
}
