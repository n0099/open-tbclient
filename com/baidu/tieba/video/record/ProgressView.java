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
    private boolean bbC;
    private Paint cIn;
    private long dmx;
    private a hug;
    private Paint huh;
    private Paint hui;
    private Paint huj;
    private Paint huk;
    private float hul;
    private float hum;
    private LinkedList<Integer> hun;
    private float huo;
    private volatile State hup;
    private float huq;
    private float hur;
    private float hus;
    private long hut;
    private long huu;
    private long huv;
    private long lastStartTime;
    private int mProgress;

    /* loaded from: classes2.dex */
    public interface a {
        void wU(int i);
    }

    public ProgressView(Context context) {
        super(context);
        this.hun = new LinkedList<>();
        this.huo = 0.0f;
        this.hup = State.PAUSE;
        this.bbC = true;
        this.huq = 0.0f;
        this.hur = 0.0f;
        this.hus = 0.0f;
        this.hut = 0L;
        this.lastStartTime = 0L;
        this.huu = 0L;
        this.huv = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hun = new LinkedList<>();
        this.huo = 0.0f;
        this.hup = State.PAUSE;
        this.bbC = true;
        this.huq = 0.0f;
        this.hur = 0.0f;
        this.hus = 0.0f;
        this.hut = 0L;
        this.lastStartTime = 0L;
        this.huu = 0L;
        this.huv = 0L;
        init(context);
    }

    public ProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hun = new LinkedList<>();
        this.huo = 0.0f;
        this.hup = State.PAUSE;
        this.bbC = true;
        this.huq = 0.0f;
        this.hur = 0.0f;
        this.hus = 0.0f;
        this.hut = 0L;
        this.lastStartTime = 0L;
        this.huu = 0L;
        this.huv = 0L;
        init(context);
    }

    private void init(Context context) {
        this.cIn = new Paint();
        this.huh = new Paint();
        this.hui = new Paint();
        this.huk = new Paint();
        this.huj = new Paint();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        this.cIn.setStyle(Paint.Style.FILL);
        this.cIn.setColor(Color.parseColor("#33aaff"));
        this.huh.setStyle(Paint.Style.FILL);
        this.huh.setColor(Color.rgb(51, 170, 255));
        this.hui.setStyle(Paint.Style.FILL);
        this.hui.setColor(Color.parseColor("#FFFFFF"));
        this.huk.setStyle(Paint.Style.FILL);
        this.huk.setColor(Color.parseColor("#e53917"));
        this.huj.setStyle(Paint.Style.FILL);
        this.huj.setColor(Color.parseColor("#33aaff"));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.huo = displayMetrics.widthPixels / 15000.0f;
        this.hus = this.huo;
    }

    public void setListener(a aVar) {
        this.hug = aVar;
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
        if (this.dmx == 0) {
            this.dmx = System.currentTimeMillis();
        }
        if (this.huv == 0) {
            this.huv = getHeight();
        }
        this.hul = (float) this.huv;
        this.hum = (float) ((this.huv * 1) / 3);
        long currentTimeMillis = System.currentTimeMillis();
        this.huq = 0.0f;
        if (!this.hun.isEmpty()) {
            Iterator<Integer> it = this.hun.iterator();
            long j = 0;
            while (it.hasNext()) {
                this.lastStartTime = j;
                long intValue = it.next().intValue();
                this.huu = intValue;
                float f = this.huq;
                this.huq += ((float) (intValue - j)) * this.huo;
                float f2 = this.huq - this.hum;
                if (f2 < 1.0f) {
                    f2 = 1.0f;
                }
                canvas.drawRect(f, 0.0f, f2, (float) (this.huv - 1), this.cIn);
                canvas.drawRect(f2, 0.0f, this.huq, (float) (this.huv - 1), this.hui);
                j = intValue;
            }
            if (this.hun.getLast().intValue() <= 3000.0f) {
                canvas.drawRect(3000.0f * this.huo, 0.0f, this.hul + (this.huo * 3000.0f), (float) (this.huv - 1), this.huh);
            }
        } else {
            canvas.drawRect(3000.0f * this.huo, 0.0f, this.hul + (this.huo * 3000.0f), (float) (this.huv - 1), this.huh);
        }
        if (this.hup == State.ROLLBACK) {
            canvas.drawRect(this.huq - (((float) (this.huu - this.lastStartTime)) * this.huo), 0.0f, this.huq, (float) this.huv, this.huk);
        }
        if (this.hup == State.START) {
            this.hur += this.hus * ((float) (currentTimeMillis - this.dmx));
            float f3 = this.huq + this.hur;
            if (f3 <= getMeasuredWidth()) {
                canvas.drawRect(this.huq, 0.0f, this.hur + this.huq, (float) (this.huv - 1), this.cIn);
            } else {
                canvas.drawRect(this.huq, 0.0f, getMeasuredWidth(), (float) (this.huv - 1), this.cIn);
            }
            canvas.drawRect(f3 - 5.0f, 0.0f, ((float) this.huv) + (f3 - 5.0f), (float) (this.huv - 1), this.huj);
            if (this.hug != null) {
                int measuredWidth = (int) ((f3 / getMeasuredWidth()) * 100.0f);
                if (measuredWidth > 100) {
                    measuredWidth = 100;
                }
                if (measuredWidth != this.mProgress) {
                    this.mProgress = measuredWidth;
                    this.hug.wU(this.mProgress);
                }
            }
        } else {
            if (this.hug != null) {
                int measuredWidth2 = (int) ((this.huq / getMeasuredWidth()) * 100.0f);
                if (measuredWidth2 > 100) {
                    measuredWidth2 = 100;
                }
                if (measuredWidth2 != this.mProgress) {
                    this.mProgress = measuredWidth2;
                    this.hug.wU(this.mProgress);
                }
            }
            if (this.hut == 0 || currentTimeMillis - this.hut >= 800) {
                this.bbC = !this.bbC;
                this.hut = System.currentTimeMillis();
            }
            if (this.bbC) {
                canvas.drawRect(this.huq - 5.0f, 0.0f, ((float) this.huv) + (this.huq - 5.0f), (float) (this.huv - 1), this.huj);
            }
        }
        this.dmx = System.currentTimeMillis();
        invalidate();
    }

    public void setCurrentState(State state) {
        this.hup = state;
        if (state != State.START) {
            this.hur = this.hus;
        }
        if (state == State.DELETE && this.hun != null && !this.hun.isEmpty()) {
            this.hun.removeLast();
        }
    }

    public State getCurrentState() {
        return this.hup;
    }

    public void wT(int i) {
        this.hun.add(Integer.valueOf(i));
    }

    public int getLastProgress() {
        if (this.hun == null || this.hun.isEmpty()) {
            return 0;
        }
        return this.hun.getLast().intValue();
    }

    public boolean bCN() {
        return this.hun.isEmpty();
    }

    public LinkedList<Integer> getTimeList() {
        return this.hun;
    }

    public void setTimeList(LinkedList<Integer> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            this.hun = linkedList;
        }
    }

    public void setPaintHeight(int i) {
        this.huv = i;
    }

    public void reset() {
        this.hun.clear();
        this.hup = State.PAUSE;
        this.hun.clear();
        this.huq = 0.0f;
        this.dmx = 0L;
        this.lastStartTime = 0L;
        this.huu = 0L;
        this.mProgress = 0;
        this.hut = 0L;
    }
}
