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
    private boolean eWn;
    private Paint gOx;
    private long ijR;
    private long lastStartTime;
    private int mProgress;
    private a ntb;
    private Paint ntc;
    private Paint ntd;
    private Paint nte;
    private Paint ntf;
    private float ntg;
    private float nth;
    private LinkedList<Integer> nti;
    private float ntj;
    private volatile State ntk;
    private float ntl;
    private float ntm;
    private float ntn;
    private long nto;
    private long ntp;
    private long ntq;

    /* loaded from: classes23.dex */
    public interface a {
        void KQ(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.nti = new LinkedList<>();
        this.ntj = 0.0f;
        this.ntk = State.PAUSE;
        this.eWn = true;
        this.ntl = 0.0f;
        this.ntm = 0.0f;
        this.ntn = 0.0f;
        this.nto = 0L;
        this.lastStartTime = 0L;
        this.ntp = 0L;
        this.ntq = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nti = new LinkedList<>();
        this.ntj = 0.0f;
        this.ntk = State.PAUSE;
        this.eWn = true;
        this.ntl = 0.0f;
        this.ntm = 0.0f;
        this.ntn = 0.0f;
        this.nto = 0L;
        this.lastStartTime = 0L;
        this.ntp = 0L;
        this.ntq = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nti = new LinkedList<>();
        this.ntj = 0.0f;
        this.ntk = State.PAUSE;
        this.eWn = true;
        this.ntl = 0.0f;
        this.ntm = 0.0f;
        this.ntn = 0.0f;
        this.nto = 0L;
        this.lastStartTime = 0L;
        this.ntp = 0L;
        this.ntq = 0L;
        init(context);
    }

    private void init(Context context) {
        this.gOx = new Paint();
        this.ntc = new Paint();
        this.ntd = new Paint();
        this.ntf = new Paint();
        this.nte = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.gOx.setStyle(Paint.Style.FILL);
        this.gOx.setColor(Color.parseColor("#33aaff"));
        this.ntc.setStyle(Paint.Style.FILL);
        this.ntc.setColor(Color.rgb(51, (int) Constants.METHOD_IM_GET_USER_PROFILE_BY_BAIDU_UID, 255));
        this.ntd.setStyle(Paint.Style.FILL);
        this.ntd.setColor(Color.parseColor("#FFFFFF"));
        this.ntf.setStyle(Paint.Style.FILL);
        this.ntf.setColor(Color.parseColor("#e53917"));
        this.nte.setStyle(Paint.Style.FILL);
        this.nte.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.ntj = displayMetrics.widthPixels / 15000.0f;
        this.ntn = this.ntj;
    }

    public void setListener(a aVar) {
        this.ntb = aVar;
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
        if (this.ijR == 0) {
            this.ijR = System.currentTimeMillis();
        }
        if (this.ntq == 0) {
            this.ntq = getHeight();
        }
        this.ntg = (float) this.ntq;
        this.nth = (float) ((this.ntq * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.ntl = 0.0f;
        if (!this.nti.isEmpty()) {
            Iterator<Integer> it = this.nti.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.ntp = intValue;
                float f = this.ntl;
                this.ntl += ((float) (intValue - j)) * this.ntj;
                float f2 = this.ntl - this.nth;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.ntq - 1), this.gOx);
                canvas.drawRect(f2, 0.0f, this.ntl, (float) (this.ntq - 1), this.ntd);
                j = intValue;
            }
            if (this.nti.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.ntj, 0.0f, this.ntg + (this.ntj * 3000.0f), (float) (this.ntq - 1), this.ntc);
            }
        } else {
            canvas.drawRect(3000.0f * this.ntj, 0.0f, this.ntg + (this.ntj * 3000.0f), (float) (this.ntq - 1), this.ntc);
        }
        if (this.ntk == State.ROLLBACK) {
            canvas.drawRect(this.ntl - (((float) (this.ntp - this.lastStartTime)) * this.ntj), 0.0f, this.ntl, (float) this.ntq, this.ntf);
        }
        if (this.ntk == State.START) {
            this.ntm += this.ntn * ((float) (currentTimeMillis - this.ijR));
            float f3 = this.ntl + this.ntm;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.ntl, 0.0f, this.ntm + this.ntl, (float) (this.ntq - 1), this.gOx);
            } else {
                canvas.drawRect(this.ntl, 0.0f, getMeasuredWidth(), (float) (this.ntq - 1), this.gOx);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.ntq) + (f3 - 5.0f), (float) (this.ntq - 1), this.nte);
            if (this.ntb != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.ntb.KQ(this.mProgress);
                }
            }
        } else {
            if (this.ntb != null) {
                int measuredWidth2 = (int) ((this.ntl / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.ntb.KQ(this.mProgress);
                }
            }
            if (this.nto == 0 || currentTimeMillis - this.nto >= 800) {
                this.eWn = !this.eWn;
                this.nto = System.currentTimeMillis();
            }
            if (this.eWn) {
                canvas.drawRect(this.ntl - 5.0f, 0.0f, ((float) this.ntq) + (this.ntl - 5.0f), (float) (this.ntq - 1), this.nte);
            }
        }
        this.ijR = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.ntk = state;
        if (state != State.START) {
            this.ntm = this.ntn;
        }
        if (state == State.DELETE && this.nti != null && !this.nti.isEmpty()) {
            this.nti.removeLast();
        }
    }

    public State getCurrentState() {
        return this.ntk;
    }

    public void KP(int i) {
        this.nti.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.nti == null || this.nti.isEmpty()) {
            return 0;
        }
        return this.nti.getLast().intValue();
    }

    public boolean dQO() {
        return this.nti.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.nti;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.nti = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.ntq = i;
    }

    public void reset() {
        this.nti.clear();
        this.ntk = State.PAUSE;
        this.nti.clear();
        this.ntl = 0.0f;
        this.ijR = 0L;
        this.lastStartTime = 0L;
        this.ntp = 0L;
        this.mProgress = 0;
        this.nto = 0L;
    }
}
